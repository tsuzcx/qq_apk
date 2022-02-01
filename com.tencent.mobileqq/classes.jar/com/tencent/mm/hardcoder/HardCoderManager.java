package com.tencent.mm.hardcoder;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class HardCoderManager
  implements Handler.Callback
{
  private static final int FLAG_AB_TEST = 1;
  private static final int FLAG_DISABLE = 2;
  private static final int FLAG_ENABLE = 0;
  private static final String KEY_CFG_FLAG = "key_cfg_flag";
  private static final String KEY_CRASH_COUNT;
  private static final String KEY_LAST_DOWNLOAD_TIME = "key_last_down_time";
  private static final String KEY_STATE = "key_state";
  private static final int MAX_CRASH_COUNT = 2;
  private static final long MIN_DOWNLOAD_INTERVAL = 86400000L;
  private static final int MSG_START = 0;
  private static final int MSG_STOP = 1;
  private static final String SO_URL_FOR_32 = "https://qd.myapp.com/myapp/qqteam/qq_tools/libhc4.jpg";
  private static final String SO_URL_FOR_64 = "https://down.qq.com/qqAVCodecLib/qqHardCoderLib/testVersion/20200624/libhc4.jpg";
  private static final String SP_HC = "sp_hardcoder";
  static final int STATE_B_TEST = 8;
  static final int STATE_CRASH_PROTECT = 9;
  static final int STATE_DOWNLOAD_FAIL = 5;
  static final int STATE_DOWNLOAD_SUC = 6;
  static final int STATE_EXCEPTION = 7;
  static final int STATE_FILE_CFG_DISABLE = 2;
  static final int STATE_NO_SO = 4;
  static final int STATE_OK = 10;
  static final int STATE_SVC_CFG_DISABLE = 3;
  static final int STATE_UNINIT = 0;
  static final int STATE_UNSUPRT = 1;
  private static final String TAG = "HardCoder.QQManager";
  public static final boolean sDebug;
  private static HardCoderManager sInstance;
  private static Random sRand = new Random();
  private static Bundle sStartBundle;
  private static Bundle sStopBundle;
  private ConcurrentHashMap<Integer, Integer> codeMap = new ConcurrentHashMap();
  private boolean hasRunningBg = false;
  private Handler mHandler;
  private SharedPreferences mPref = MobileQQ.getContext().getSharedPreferences("sp_hardcoder", 4);
  private HashMap<Integer, Boolean> sceneFlagMap = new HashMap();
  private int state = 0;
  
  static
  {
    boolean bool;
    if ((QLog.isColorLevel()) && (new File("/sdcard/debug_hc").exists())) {
      bool = true;
    } else {
      bool = false;
    }
    sDebug = bool;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppSetting.i());
    localStringBuilder.append("key_crash_cnt");
    KEY_CRASH_COUNT = localStringBuilder.toString();
    sStartBundle = new Bundle(8);
    sStopBundle = new Bundle(2);
  }
  
  public static HardCoderManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null)
        {
          sInstance = new HardCoderManager();
          if (MobileQQ.sProcessId == 1) {
            new HardCoderManager.1().start();
          } else {
            sInstance.init();
          }
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  static String getSoUrl()
  {
    return "https://qd.myapp.com/myapp/qqteam/qq_tools/libhc4.jpg";
  }
  
  private void init()
  {
    if ((sDebug) && (new File("/sdcard/disable_hc").exists()))
    {
      QLog.d("HardCoder.QQManager", 1, "disable by file cfg");
      this.state = 2;
      return;
    }
    int i = this.mPref.getInt("key_cfg_flag", 0);
    if (i == 2)
    {
      QLog.d("HardCoder.QQManager", 1, "disable by server cfg");
      this.state = 3;
      return;
    }
    Object localObject = Build.MANUFACTURER;
    if ((localObject != null) && (((String)localObject).toUpperCase().contains("VIVO")))
    {
      QLog.d("HardCoder.QQManager", 1, "disable vivo");
      this.state = 3;
      return;
    }
    if (MobileQQ.sProcessId == 1)
    {
      int j = this.mPref.getInt(KEY_CRASH_COUNT, 0);
      if (j > 2)
      {
        this.state = 9;
      }
      else
      {
        this.mPref.edit().putInt(KEY_CRASH_COUNT, j + 1).commit();
        this.state = HCPerfManager.getInstance().init();
        if ((this.state == 10) && (i == 1) && (Math.random() < 0.5D))
        {
          this.state = 8;
          HCPerfManager.getInstance().uninit();
        }
      }
      localObject = this.mPref.edit();
      ((SharedPreferences.Editor)localObject).putInt("key_state", this.state);
      if (this.state == 10)
      {
        ((SharedPreferences.Editor)localObject).putInt(KEY_CRASH_COUNT, j + 1);
        ThreadManager.getSubThreadHandler().postDelayed(new HardCoderManager.2(this), 10000L);
      }
      else
      {
        ((SharedPreferences.Editor)localObject).putInt(KEY_CRASH_COUNT, j);
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
    else
    {
      this.state = this.mPref.getInt("key_state", 1);
      if (this.state == 10) {
        this.mHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hc init ");
    ((StringBuilder)localObject).append(this.state);
    QLog.d("HardCoder.QQManager", 1, ((StringBuilder)localObject).toString());
  }
  
  public void clearCrashRecord()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("crash count = ");
    localStringBuilder.append(this.mPref.getInt(KEY_CRASH_COUNT, 0));
    QLog.d("HardCoder.QQManager", 1, localStringBuilder.toString());
    this.mPref.edit().putInt(KEY_CRASH_COUNT, 0).commit();
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      Object localObject = (HCPerfManager.PerformanceTask)paramMessage.obj;
      sStartBundle.putInt("key_delay", ((HCPerfManager.PerformanceTask)localObject).delay);
      sStartBundle.putInt("key_cpu", ((HCPerfManager.PerformanceTask)localObject).cpuLevel);
      sStartBundle.putInt("key_io", ((HCPerfManager.PerformanceTask)localObject).ioLevel);
      sStartBundle.putInt("key_bind", ((HCPerfManager.PerformanceTask)localObject).bindTid);
      sStartBundle.putInt("key_timeout", ((HCPerfManager.PerformanceTask)localObject).timeout);
      sStartBundle.putInt("key_scene", ((HCPerfManager.PerformanceTask)localObject).scene);
      sStartBundle.putLong("key_action", ((HCPerfManager.PerformanceTask)localObject).action);
      sStartBundle.putString("key_tag", ((HCPerfManager.PerformanceTask)localObject).tag);
      localObject = QIPCClientHelper.getInstance().getClient().callServer("HardCoderModule", "start", sStartBundle);
      if ((paramMessage.arg1 != 0) && (localObject != null) && (((EIPCResult)localObject).code != 0)) {
        this.codeMap.put(Integer.valueOf(paramMessage.arg1), Integer.valueOf(((EIPCResult)localObject).code));
      }
    }
    else if (paramMessage.what == 1)
    {
      sStopBundle.putInt("key_code", paramMessage.arg1);
      QIPCClientHelper.getInstance().getClient().callServer("HardCoderModule", "stop", sStopBundle);
    }
    return false;
  }
  
  public boolean isEnable()
  {
    return this.state == 10;
  }
  
  public boolean isSceneEnable(int paramInt)
  {
    if (!this.sceneFlagMap.containsKey(Integer.valueOf(paramInt))) {
      this.sceneFlagMap.put(Integer.valueOf(paramInt), Boolean.valueOf(this.mPref.getBoolean(String.valueOf(paramInt), true)));
    }
    return ((Boolean)this.sceneFlagMap.get(Integer.valueOf(paramInt))).booleanValue();
  }
  
  public boolean isSupported()
  {
    int i = this.state;
    return (i == 10) || (i == 8);
  }
  
  public void onRunningBackground()
  {
    if (this.hasRunningBg) {
      return;
    }
    this.hasRunningBg = true;
    if (this.state != 1)
    {
      Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.batteryCfg.name());
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("#");
        if (localObject.length >= 4)
        {
          localObject = localObject[3];
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("hcConfig = ");
          localStringBuilder1.append((String)localObject);
          QLog.d("HardCoder.QQManager", 1, localStringBuilder1.toString());
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = localObject.split("\\|")[0];
            try
            {
              this.mPref.edit().putInt("key_cfg_flag", Integer.valueOf((String)localObject).intValue()).commit();
            }
            catch (Exception localException)
            {
              QLog.e("HardCoder.QQManager", 1, "", localException);
            }
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("svc flag = ");
            localStringBuilder2.append((String)localObject);
            QLog.d("HardCoder.QQManager", 1, localStringBuilder2.toString());
          }
        }
      }
    }
    if (this.state == 4)
    {
      long l = this.mPref.getLong("key_last_down_time", 0L);
      if ((Math.abs(System.currentTimeMillis() - l) > 86400000L) && (NetworkUtil.isWifiConnected(MobileQQ.getContext())))
      {
        this.mPref.edit().putLong("key_last_down_time", System.currentTimeMillis()).apply();
        ThreadManager.executeOnNetWorkThread(new HardCoderManager.3(this));
      }
    }
  }
  
  void onSocketDisconnect()
  {
    if (this.state == 10)
    {
      this.state = 1;
      QLog.d("HardCoder.QQManager", 1, "onDisconnect");
      this.mPref.edit().putInt("key_state", this.state).commit();
      HCPerfManager.getInstance().uninit();
    }
  }
  
  public void setSceneEnable(int paramInt, boolean paramBoolean)
  {
    this.sceneFlagMap.put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
    this.mPref.edit().putBoolean(String.valueOf(paramInt), paramBoolean).commit();
  }
  
  public int start(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    return start(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramInt7, paramString, true);
  }
  
  public int start(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString, boolean paramBoolean)
  {
    if (this.state != 10) {
      return 0;
    }
    if (MobileQQ.sProcessId == 1) {
      return HCPerfManager.getInstance().start(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramInt7, paramString);
    }
    Message localMessage = this.mHandler.obtainMessage(0);
    HCPerfManager.PerformanceTask localPerformanceTask = (HCPerfManager.PerformanceTask)HCPerfManager.sStartTaskPool.obtain(HCPerfManager.PerformanceTask.class);
    localPerformanceTask.delay = paramInt1;
    localPerformanceTask.cpuLevel = paramInt2;
    localPerformanceTask.ioLevel = paramInt3;
    localPerformanceTask.bindTid = paramInt4;
    localPerformanceTask.timeout = paramInt5;
    localPerformanceTask.scene = paramInt6;
    localPerformanceTask.action = paramLong;
    localPerformanceTask.tag = paramString;
    localMessage.obj = localPerformanceTask;
    localMessage.sendToTarget();
    if (paramBoolean)
    {
      paramInt1 = sRand.nextInt();
      localMessage.arg1 = paramInt1;
      this.codeMap.put(Integer.valueOf(paramInt1), Integer.valueOf(0));
    }
    else
    {
      localMessage.arg1 = 0;
    }
    return localMessage.arg1;
  }
  
  public void stop(int paramInt)
  {
    stop(paramInt, false);
  }
  
  public void stop(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      return;
    }
    if (MobileQQ.sProcessId == 1)
    {
      HCPerfManager.getInstance().stop(paramInt);
      return;
    }
    if (this.mHandler != null)
    {
      Message localMessage;
      if (this.codeMap.containsKey(Integer.valueOf(paramInt)))
      {
        localMessage = this.mHandler.obtainMessage(1);
        localMessage.arg1 = ((Integer)this.codeMap.remove(Integer.valueOf(paramInt))).intValue();
        localMessage.sendToTarget();
        return;
      }
      if (paramBoolean)
      {
        localMessage = this.mHandler.obtainMessage(1);
        localMessage.arg1 = paramInt;
        localMessage.sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderManager
 * JD-Core Version:    0.7.0.1
 */