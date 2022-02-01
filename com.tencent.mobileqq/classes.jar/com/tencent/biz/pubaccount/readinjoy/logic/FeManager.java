package com.tencent.biz.pubaccount.readinjoy.logic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class FeManager
{
  public static FeManager a;
  private long jdField_a_of_type_Long = 0L;
  GFeReporter jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicGFeReporter = new GFeReporter();
  PFeReporter jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicPFeReporter = new PFeReporter();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean;
  
  private FeManager()
  {
    if (a(BaseApplicationImpl.getApplication().getRuntime()))
    {
      this.jdField_a_of_type_Boolean = true;
      a(BaseApplicationImpl.getApplication().getRuntime(), false);
    }
  }
  
  public static FeManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicFeManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicFeManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicFeManager = new FeManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicFeManager;
    }
    finally {}
  }
  
  private void a(long paramLong)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ReadInJoyHelper.a((AppRuntime)localObject, true, true);
    } while (localObject == null);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putLong("readinjoy_ex_last_update_time", paramLong);
    ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
  }
  
  public static void a(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    paramAppRuntime = ReadInJoyHelper.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return;
    }
    paramAppRuntime = paramAppRuntime.edit();
    paramAppRuntime.putBoolean("simple_force_report_once", paramBoolean);
    ReadInJoyHelper.a(paramAppRuntime, true);
  }
  
  public static boolean a(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = ReadInJoyHelper.a(paramAppRuntime, true, true);
    if (paramAppRuntime == null) {
      return false;
    }
    return paramAppRuntime.getBoolean("simple_force_report_once", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.FeManager
 * JD-Core Version:    0.7.0.1
 */