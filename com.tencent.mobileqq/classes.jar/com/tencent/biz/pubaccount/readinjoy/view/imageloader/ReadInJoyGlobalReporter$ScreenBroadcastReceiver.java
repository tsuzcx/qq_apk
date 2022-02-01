package com.tencent.biz.pubaccount.readinjoy.view.imageloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyGlobalReporter$ScreenBroadcastReceiver
  extends BroadcastReceiver
{
  private String jdField_a_of_type_JavaLangString = null;
  
  private ReadInJoyGlobalReporter$ScreenBroadcastReceiver(ReadInJoyGlobalReporter paramReadInJoyGlobalReporter) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getAction();
    if ("android.intent.action.SCREEN_ON".equals(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_ON appstatus=" + ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter));
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!"android.intent.action.SCREEN_OFF".equals(this.jdField_a_of_type_JavaLangString)) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_SCREEN_OFF appstatus = " + ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter));
            }
          } while (ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter) != 2);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter.a();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter.f();
          return;
        } while (!"android.intent.action.USER_PRESENT".equals(this.jdField_a_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyGlobalReporter", 2, "ScreenBroadcastReceiver ACTION_USER_PRESENT app status=" + ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter));
        }
      } while ((ReadInJoyGlobalReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter) != 2) || (!(BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)));
      paramContext = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    } while (paramContext == null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewImageloaderReadInJoyGlobalReporter.a(paramContext, NetConnInfoCenter.getServerTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.imageloader.ReadInJoyGlobalReporter.ScreenBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */