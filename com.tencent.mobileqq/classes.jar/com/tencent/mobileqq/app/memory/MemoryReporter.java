package com.tencent.mobileqq.app.memory;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.cache.ClearMemoryConfig;
import com.tencent.common.cache.ClearMemoryConfig.MemoryLevelInfo;
import com.tencent.common.cache.MemoryClearManagerNew;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MemoryConfigs;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.InitMagnifierSDK;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import mqq.app.Foreground;

public class MemoryReporter
  implements Handler.Callback
{
  private static MemoryReporter jdField_a_of_type_ComTencentMobileqqAppMemoryMemoryReporter;
  public static ArrayList a;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Vector jdField_a_of_type_JavaUtilVector;
  public boolean a;
  private long b = System.currentTimeMillis();
  private long c;
  private long d;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private MemoryReporter()
  {
    float f1 = MemoryConfigs.a().b;
    float f2 = MemoryConfigs.a().c;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("memory_reporter", 0);
    if (localSharedPreferences.contains("sp_key_last_shot_time")) {
      localSharedPreferences.edit().clear().commit();
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(a(), 0);
    this.d = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("sp_key_last_shot_time", 0L);
    if (Math.abs(System.currentTimeMillis() - this.d) >= 86400000L)
    {
      if (this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_need_report", false)) {
        d();
      }
      if (f1 >= Math.random())
      {
        QLog.setUIN_REPORTLOG_LEVEL(2);
        this.jdField_a_of_type_Boolean = true;
        this.d = System.currentTimeMillis();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("sp_key_last_shot_time", this.d).putBoolean("key_need_report", true).commit();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
      this.jdField_a_of_type_JavaUtilVector = new Vector();
      a(MemoryClearManagerNew.a());
      return;
      QLog.setUIN_REPORTLOG_LEVEL(2);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public static MemoryReporter a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppMemoryMemoryReporter == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppMemoryMemoryReporter == null) {
        jdField_a_of_type_ComTencentMobileqqAppMemoryMemoryReporter = new MemoryReporter();
      }
      return jdField_a_of_type_ComTencentMobileqqAppMemoryMemoryReporter;
    }
    finally {}
  }
  
  private String a()
  {
    return "memory_reporter_" + BaseApplicationImpl.sProcessId;
  }
  
  private void a(int paramInt, ClearMemoryConfig.MemoryLevelInfo paramMemoryLevelInfo)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      if (localIterator.hasNext()) {
        ((MemoryReporter.IMemoryListener)localIterator.next()).a(paramInt, paramMemoryLevelInfo);
      }
    }
  }
  
  private void a(long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
      if (localIterator.hasNext()) {
        ((MemoryReporter.IMemoryListener)localIterator.next()).a(paramLong);
      }
    }
  }
  
  private void c()
  {
    long l = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    if (l > (100 - MemoryConfigs.a().jdField_a_of_type_Int) * Runtime.getRuntime().maxMemory() / 100L)
    {
      a(l);
      if (this.jdField_a_of_type_Boolean)
      {
        InitMagnifierSDK.a(this.jdField_a_of_type_AndroidOsHandler, l);
        if ((this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_need_report", false)) && (l > this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_use_heap", 0L)) && (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) > 120000L))
        {
          localObject = UnifiedMonitor.a();
          if (localObject == null) {
            break label251;
          }
        }
      }
    }
    label251:
    for (Object localObject = (String)((HashMap)localObject).get("act");; localObject = null)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_use_heap", l).putString("key_act_name", (String)localObject).putBoolean("key_clear_flag", MemoryConfigs.a().jdField_a_of_type_ComTencentCommonCacheClearMemoryConfig.jdField_a_of_type_Boolean).commit();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Boolean) && (System.currentTimeMillis() - this.c > 86400000L))
      {
        e();
        if (QLog.isColorLevel()) {
          QLog.d("MemoryReporter", 2, "login over 24 hours, report again");
        }
      }
      if ((this.jdField_a_of_type_Boolean) && (System.currentTimeMillis() - this.d > 86400000L)) {
        d();
      }
      return;
    }
  }
  
  private void d()
  {
    if (("0".equals("355371")) || (!this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_need_report", false))) {
      return;
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    String str = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_act_name", "");
    boolean bool = this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("key_clear_flag", false);
    long l3 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_use_heap", -1L);
    long l2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_threshold", -1L);
    long l1 = l2;
    if (l2 == -1L)
    {
      l1 = DeviceInfoUtil.e();
      localEditor.putLong("key_threshold", l1);
    }
    l2 = this.d;
    long l4 = this.d;
    long l5 = Runtime.getRuntime().maxMemory();
    int i;
    if (l3 != -1L)
    {
      i = 1;
      if (!bool) {
        break label235;
      }
    }
    label235:
    for (int j = 1;; j = 0)
    {
      InitMagnifierSDK.a(l2, l4 + 86400000L, str, l3, l5, l1, -1L, i, j);
      localEditor.remove("key_use_heap").remove("key_act_name").remove("key_clear_flag").remove("key_need_report").commit();
      return;
      i = 0;
      break;
    }
  }
  
  private void e()
  {
    StringBuffer localStringBuffer = new StringBuffer(512);
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject == null) {
      return;
    }
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      FriendsManager localFriendsManager = (FriendsManager)((QQAppInterface)localObject).getManager(50);
      int i;
      if (localFriendsManager != null)
      {
        i = localFriendsManager.a();
        localStringBuffer.append("fc=");
        localStringBuffer.append(i);
        localStringBuffer.append("&");
      }
      localObject = (DiscussionManager)((QQAppInterface)localObject).getManager(52);
      if (localObject != null)
      {
        i = ((DiscussionManager)localObject).a().size();
        localStringBuffer.append("dc=");
        localStringBuffer.append(i);
        localStringBuffer.append("&");
        i = ((DiscussionManager)localObject).b();
        localStringBuffer.append("dmc=");
        localStringBuffer.append(i);
        localStringBuffer.append("&");
      }
    }
    InitMagnifierSDK.a(this.jdField_a_of_type_AndroidOsHandler, -1L, -1L, "-1", localStringBuffer.toString());
    this.c = System.currentTimeMillis();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      e();
    }
    b();
  }
  
  public void a(MemoryReporter.IMemoryListener paramIMemoryListener)
  {
    synchronized (this.jdField_a_of_type_JavaUtilVector)
    {
      this.jdField_a_of_type_JavaUtilVector.add(paramIMemoryListener);
      return;
    }
  }
  
  public boolean a(long paramLong1, long paramLong2, ClearMemoryConfig paramClearMemoryConfig, int paramInt)
  {
    ClearMemoryConfig.MemoryLevelInfo localMemoryLevelInfo = paramClearMemoryConfig.a(paramInt);
    if ((localMemoryLevelInfo != null) && (paramLong1 >= localMemoryLevelInfo.jdField_a_of_type_Int * paramLong2 / 100L))
    {
      paramClearMemoryConfig.jdField_a_of_type_Int = localMemoryLevelInfo.b;
      a(paramInt, localMemoryLevelInfo);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (MemoryConfigs.a().jdField_a_of_type_ComTencentCommonCacheClearMemoryConfig.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (Foreground.sCountResume > 0) {}
    for (boolean bool = true;; bool = false) {
      switch (paramMessage.what)
      {
      default: 
        return true;
      }
    }
    c();
    MemoryClearManagerNew.a().a(bool);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    paramMessage = this.jdField_a_of_type_AndroidOsHandler;
    if (bool) {}
    for (long l1 = 5000L;; l1 = 30000L)
    {
      paramMessage.sendEmptyMessageDelayed(1, l1);
      break;
    }
    l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().maxMemory();
    paramMessage = MemoryConfigs.a().jdField_a_of_type_ComTencentCommonCacheClearMemoryConfig;
    MemoryClearManagerNew.a().c();
    int i;
    if (a(l1, l2, paramMessage, 1)) {
      i = paramMessage.jdField_a_of_type_Int * 1000;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      int j = i;
      if (!bool)
      {
        j = i;
        if (i >= 30000) {
          j = i * 2;
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2, j);
      break;
      if (a(l1, l2, paramMessage, 2)) {
        i = paramMessage.jdField_a_of_type_Int * 1000;
      } else if (a(l1, l2, paramMessage, 3)) {
        i = paramMessage.jdField_a_of_type_Int * 1000;
      } else {
        i = 30000;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.memory.MemoryReporter
 * JD-Core Version:    0.7.0.1
 */