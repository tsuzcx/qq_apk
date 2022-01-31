package com.tencent.biz.pubaccount.readinjoy.logic;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class FeManager
{
  GFeReporter jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicGFeReporter = new GFeReporter();
  PFeReporter jdField_a_of_type_ComTencentBizPubaccountReadinjoyLogicPFeReporter = new PFeReporter();
  private final String jdField_a_of_type_JavaLangString = "readinjoy_ex_last_update_time";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.logic.FeManager
 * JD-Core Version:    0.7.0.1
 */