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
  private static Random jdField_a_of_type_JavaUtilRandom;
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
    if ((QLog.isColorLevel()) && (new File("/sdcard/debug_hc").exists())) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_a_of_type_JavaLangString = AppSetting.g() + "key_crash_cnt";
      jdField_a_of_type_AndroidOsBundle = new Bundle(8);
      jdField_b_of_type_AndroidOsBundle = new Bundle(2);
      jdField_a_of_type_JavaUtilRandom = new Random();
      return;
    }
  }
  
  /* Error */
  public static HardCoderManager a()
  {
    // Byte code:
    //   0: getstatic 113	com/tencent/mm/hardcoder/HardCoderManager:jdField_a_of_type_ComTencentMmHardcoderHardCoderManager	Lcom/tencent/mm/hardcoder/HardCoderManager;
    //   3: ifnonnull +42 -> 45
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 113	com/tencent/mm/hardcoder/HardCoderManager:jdField_a_of_type_ComTencentMmHardcoderHardCoderManager	Lcom/tencent/mm/hardcoder/HardCoderManager;
    //   12: ifnonnull +30 -> 42
    //   15: new 2	com/tencent/mm/hardcoder/HardCoderManager
    //   18: dup
    //   19: invokespecial 114	com/tencent/mm/hardcoder/HardCoderManager:<init>	()V
    //   22: putstatic 113	com/tencent/mm/hardcoder/HardCoderManager:jdField_a_of_type_ComTencentMmHardcoderHardCoderManager	Lcom/tencent/mm/hardcoder/HardCoderManager;
    //   25: getstatic 117	mqq/app/MobileQQ:sProcessId	I
    //   28: iconst_1
    //   29: if_icmpne +20 -> 49
    //   32: new 119	com/tencent/mm/hardcoder/HardCoderManager$1
    //   35: dup
    //   36: invokespecial 120	com/tencent/mm/hardcoder/HardCoderManager$1:<init>	()V
    //   39: invokevirtual 123	com/tencent/mm/hardcoder/HardCoderManager$1:start	()V
    //   42: ldc 2
    //   44: monitorexit
    //   45: getstatic 113	com/tencent/mm/hardcoder/HardCoderManager:jdField_a_of_type_ComTencentMmHardcoderHardCoderManager	Lcom/tencent/mm/hardcoder/HardCoderManager;
    //   48: areturn
    //   49: getstatic 113	com/tencent/mm/hardcoder/HardCoderManager:jdField_a_of_type_ComTencentMmHardcoderHardCoderManager	Lcom/tencent/mm/hardcoder/HardCoderManager;
    //   52: invokespecial 126	com/tencent/mm/hardcoder/HardCoderManager:d	()V
    //   55: goto -13 -> 42
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   58	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	42	58	finally
    //   42	45	58	finally
    //   49	55	58	finally
    //   59	62	58	finally
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
    int j;
    if (MobileQQ.sProcessId == 1)
    {
      j = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(jdField_a_of_type_JavaLangString, 0);
      if (j > 2)
      {
        this.jdField_a_of_type_Int = 9;
        localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putInt("key_state", this.jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Int != 10) {
          break label307;
        }
        ((SharedPreferences.Editor)localObject).putInt(jdField_a_of_type_JavaLangString, j + 1);
        ThreadManager.getSubThreadHandler().postDelayed(new HardCoderManager.2(this), 10000L);
        label196:
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    for (;;)
    {
      QLog.d("HardCoder.QQManager", 1, "hc init " + this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(jdField_a_of_type_JavaLangString, j + 1).commit();
      this.jdField_a_of_type_Int = HCPerfManager.a().a();
      if ((this.jdField_a_of_type_Int != 10) || (i != 1) || (Math.random() >= 0.5D)) {
        break;
      }
      this.jdField_a_of_type_Int = 8;
      HCPerfManager.a().a();
      break;
      label307:
      ((SharedPreferences.Editor)localObject).putInt(jdField_a_of_type_JavaLangString, j);
      break label196;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_state", 1);
      if (this.jdField_a_of_type_Int == 10) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      }
    }
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
    for (;;)
    {
      return localMessage.arg1;
      localMessage.arg1 = 0;
    }
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
    if (paramInt == 0) {}
    do
    {
      do
      {
        return;
        if (MobileQQ.sProcessId == 1)
        {
          HCPerfManager.a().a(paramInt);
          return;
        }
      } while (this.jdField_a_of_type_AndroidOsHandler == null);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt)))
      {
        localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
        localMessage.arg1 = ((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt))).intValue();
        localMessage.sendToTarget();
        return;
      }
    } while (!paramBoolean);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_Int == 8);
  }
  
  public void b()
  {
    QLog.d("HardCoder.QQManager", 1, "crash count = " + this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(jdField_a_of_type_JavaLangString, 0));
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(jdField_a_of_type_JavaLangString, 0).commit();
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (;;)
    {
      return;
      this.jdField_b_of_type_Boolean = true;
      Object localObject;
      if (this.jdField_a_of_type_Int != 1)
      {
        localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.batteryCfg.name());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("#");
          if (localObject.length >= 4)
          {
            localObject = localObject[3];
            QLog.d("HardCoder.QQManager", 1, "hcConfig = " + (String)localObject);
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              localObject = localObject.split("\\|")[0];
            }
          }
        }
      }
      try
      {
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_cfg_flag", Integer.valueOf((String)localObject).intValue()).commit();
        QLog.d("HardCoder.QQManager", 1, "svc flag = " + (String)localObject);
        if (this.jdField_a_of_type_Int != 4) {
          continue;
        }
        long l = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_last_down_time", 0L);
        if ((Math.abs(System.currentTimeMillis() - l) <= 86400000L) || (!NetworkUtil.h(MobileQQ.getContext()))) {
          continue;
        }
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_last_down_time", System.currentTimeMillis()).apply();
        ThreadManager.executeOnNetWorkThread(new HardCoderManager.3(this));
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("HardCoder.QQManager", 1, "", localException);
        }
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
    for (;;)
    {
      return false;
      if (paramMessage.what == 1)
      {
        jdField_b_of_type_AndroidOsBundle.putInt("key_code", paramMessage.arg1);
        QIPCClientHelper.getInstance().getClient().callServer("HardCoderModule", "stop", jdField_b_of_type_AndroidOsBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.hardcoder.HardCoderManager
 * JD-Core Version:    0.7.0.1
 */