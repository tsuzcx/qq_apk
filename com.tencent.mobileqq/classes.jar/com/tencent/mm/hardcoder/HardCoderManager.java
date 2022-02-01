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
  private static Bundle jdField_a_of_type_AndroidOsBundle;
  private static HardCoderManager jdField_a_of_type_ComTencentMmHardcoderHardCoderManager;
  private static final String jdField_a_of_type_JavaLangString;
  private static Random jdField_a_of_type_JavaUtilRandom = new Random();
  public static final boolean a;
  private static Bundle jdField_b_of_type_AndroidOsBundle;
  private int jdField_a_of_type_Int = 0;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = MobileQQ.getContext().getSharedPreferences("sp_hardcoder", 4);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HashMap<Integer, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ConcurrentHashMap<Integer, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean = false;
  
  static
  {
    boolean bool;
    if ((QLog.isColorLevel()) && (new File("/sdcard/debug_hc").exists())) {
      bool = true;
    } else {
      bool = false;
    }
    jdField_a_of_type_Boolean = bool;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppSetting.g());
    localStringBuilder.append("key_crash_cnt");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    jdField_a_of_type_AndroidOsBundle = new Bundle(8);
    jdField_b_of_type_AndroidOsBundle = new Bundle(2);
  }
  
  public static HardCoderManager a()
  {
    if (jdField_a_of_type_ComTencentMmHardcoderHardCoderManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMmHardcoderHardCoderManager == null)
        {
          jdField_a_of_type_ComTencentMmHardcoderHardCoderManager = new HardCoderManager();
          if (MobileQQ.sProcessId == 1) {
            new HardCoderManager.1().start();
          } else {
            jdField_a_of_type_ComTencentMmHardcoderHardCoderManager.d();
          }
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMmHardcoderHardCoderManager;
  }
  
  private void d()
  {
    if ((jdField_a_of_type_Boolean) && (new File("/sdcard/disable_hc").exists()))
    {
      QLog.d("HardCoder.QQManager", 1, "disable by file cfg");
      this.jdField_a_of_type_Int = 2;
      return;
    }
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_cfg_flag", 0);
    if (i == 2)
    {
      QLog.d("HardCoder.QQManager", 1, "disable by server cfg");
      this.jdField_a_of_type_Int = 3;
      return;
    }
    Object localObject = Build.MANUFACTURER;
    if ((localObject != null) && (((String)localObject).toUpperCase().contains("VIVO")))
    {
      QLog.d("HardCoder.QQManager", 1, "disable vivo");
      this.jdField_a_of_type_Int = 3;
      return;
    }
    if (MobileQQ.sProcessId == 1)
    {
      int j = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(jdField_a_of_type_JavaLangString, 0);
      if (j > 2)
      {
        this.jdField_a_of_type_Int = 9;
      }
      else
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(jdField_a_of_type_JavaLangString, j + 1).commit();
        this.jdField_a_of_type_Int = HCPerfManager.a().a();
        if ((this.jdField_a_of_type_Int == 10) && (i == 1) && (Math.random() < 0.5D))
        {
          this.jdField_a_of_type_Int = 8;
          HCPerfManager.a().a();
        }
      }
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putInt("key_state", this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int == 10)
      {
        ((SharedPreferences.Editor)localObject).putInt(jdField_a_of_type_JavaLangString, j + 1);
        ThreadManager.getSubThreadHandler().postDelayed(new HardCoderManager.2(this), 10000L);
      }
      else
      {
        ((SharedPreferences.Editor)localObject).putInt(jdField_a_of_type_JavaLangString, j);
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
    else
    {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_state", 1);
      if (this.jdField_a_of_type_Int == 10) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hc init ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.d("HardCoder.QQManager", 1, ((StringBuilder)localObject).toString());
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramInt7, paramString, true);
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong, int paramInt7, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int != 10) {
      return 0;
    }
    if (MobileQQ.sProcessId == 1) {
      return HCPerfManager.a().a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramLong, paramInt7, paramString);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(0);
    HCPerfManager.PerformanceTask localPerformanceTask = (HCPerfManager.PerformanceTask)HCPerfManager.a.obtain(HCPerfManager.PerformanceTask.class);
    localPerformanceTask.jdField_a_of_type_Int = paramInt1;
    localPerformanceTask.c = paramInt2;
    localPerformanceTask.d = paramInt3;
    localPerformanceTask.e = paramInt4;
    localPerformanceTask.b = paramInt5;
    localPerformanceTask.f = paramInt6;
    localPerformanceTask.jdField_a_of_type_Long = paramLong;
    localPerformanceTask.jdField_a_of_type_JavaLangString = paramString;
    localMessage.obj = localPerformanceTask;
    localMessage.sendToTarget();
    if (paramBoolean)
    {
      paramInt1 = jdField_a_of_type_JavaUtilRandom.nextInt();
      localMessage.arg1 = paramInt1;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(0));
    }
    else
    {
      localMessage.arg1 = 0;
    }
    return localMessage.arg1;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Int == 10)
    {
      this.jdField_a_of_type_Int = 1;
      QLog.d("HardCoder.QQManager", 1, "onDisconnect");
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_state", this.jdField_a_of_type_Int).commit();
      HCPerfManager.a().a();
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      return;
    }
    if (MobileQQ.sProcessId == 1)
    {
      HCPerfManager.a().a(paramInt);
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
      {
        localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        localMessage.arg1 = ((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt))).intValue();
        localMessage.sendToTarget();
        return;
      }
      if (paramBoolean)
      {
        localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        localMessage.arg1 = paramInt;
        localMessage.sendToTarget();
      }
    }
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    return (i == 10) || (i == 8);
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("crash count = ");
    localStringBuilder.append(this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(jdField_a_of_type_JavaLangString, 0));
    QLog.d("HardCoder.QQManager", 1, localStringBuilder.toString());
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(jdField_a_of_type_JavaLangString, 0).commit();
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int != 1)
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
              this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_cfg_flag", Integer.valueOf((String)localObject).intValue()).commit();
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
    if (this.jdField_a_of_type_Int == 4)
    {
      long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_last_down_time", 0L);
      if ((Math.abs(System.currentTimeMillis() - l) > 86400000L) && (NetworkUtil.isWifiConnected(MobileQQ.getContext())))
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_last_down_time", System.currentTimeMillis()).apply();
        ThreadManager.executeOnNetWorkThread(new HardCoderManager.3(this));
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      Object localObject = (HCPerfManager.PerformanceTask)paramMessage.obj;
      jdField_a_of_type_AndroidOsBundle.putInt("key_delay", ((HCPerfManager.PerformanceTask)localObject).jdField_a_of_type_Int);
      jdField_a_of_type_AndroidOsBundle.putInt("key_cpu", ((HCPerfManager.PerformanceTask)localObject).c);
      jdField_a_of_type_AndroidOsBundle.putInt("key_io", ((HCPerfManager.PerformanceTask)localObject).d);
      jdField_a_of_type_AndroidOsBundle.putInt("key_bind", ((HCPerfManager.PerformanceTask)localObject).e);
      jdField_a_of_type_AndroidOsBundle.putInt("key_timeout", ((HCPerfManager.PerformanceTask)localObject).b);
      jdField_a_of_type_AndroidOsBundle.putInt("key_scene", ((HCPerfManager.PerformanceTask)localObject).f);
      jdField_a_of_type_AndroidOsBundle.putLong("key_action", ((HCPerfManager.PerformanceTask)localObject).jdField_a_of_type_Long);
      jdField_a_of_type_AndroidOsBundle.putString("key_tag", ((HCPerfManager.PerformanceTask)localObject).jdField_a_of_type_JavaLangString);
      localObject = QIPCClientHelper.getInstance().getClient().callServer("HardCoderModule", "start", jdField_a_of_type_AndroidOsBundle);
      if ((paramMessage.arg1 != 0) && (localObject != null) && (((EIPCResult)localObject).code != 0)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramMessage.arg1), Integer.valueOf(((EIPCResult)localObject).code));
      }
    }
    else if (paramMessage.what == 1)
    {
      jdField_b_of_type_AndroidOsBundle.putInt("key_code", paramMessage.arg1);
      QIPCClientHelper.getInstance().getClient().callServer("HardCoderModule", "stop", jdField_b_of_type_AndroidOsBundle);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderManager
 * JD-Core Version:    0.7.0.1
 */