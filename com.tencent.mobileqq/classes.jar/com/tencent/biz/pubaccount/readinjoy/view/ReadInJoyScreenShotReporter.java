package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyScreenShotReporter
{
  private static ReadInJoyScreenShotReporter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter;
  private ScreenshotContentObserver jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver;
  private Integer jdField_a_of_type_JavaLangInteger;
  private Integer b;
  
  public static ReadInJoyScreenShotReporter a(Activity paramActivity)
  {
    int i;
    int j;
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter == null)
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter = new ReadInJoyScreenShotReporter();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
    }
    try
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = new ScreenshotContentObserver(paramActivity, i, j);
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver.a(new ReadInJoyScreenShotReporter.1());
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter;
    }
    catch (SecurityException paramActivity)
    {
      for (;;)
      {
        QLog.e("ReadInJoyScreenShotReporter", 1, "SecurityException error = " + paramActivity.toString());
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = null;
      }
    }
  }
  
  public void a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter != null)
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter.jdField_a_of_type_JavaLangInteger = null;
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter.b = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter != null)
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter.jdField_a_of_type_JavaLangInteger = new Integer(paramInt2);
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter.b = new Integer(paramInt1);
    }
  }
  
  public void b()
  {
    if ((jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter != null) && (jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver != null))
    {
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver.a();
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter.jdField_a_of_type_ComTencentBizPubaccountUtilScreenshotContentObserver = null;
    }
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyScreenShotReporter = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyScreenShotReporter
 * JD-Core Version:    0.7.0.1
 */