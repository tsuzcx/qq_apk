package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class WeishiManager$3
  implements Runnable
{
  WeishiManager$3(WeishiManager paramWeishiManager, String paramString1, long paramLong, QQMessageFacade paramQQMessageFacade, String paramString2, String paramString3, Map paramMap) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a((MessageRecord)localObject, WeishiManager.a(this.this$0).getCurrentUin());
    }
    WeishiUtils.jdField_a_of_type_JavaLangString = this.b;
    WSLog.a("WSAioLog", "saveLastFeedInfo feedId:" + this.b + ", title:" + this.jdField_a_of_type_JavaLangString);
    try
    {
      long l = Long.parseLong(WeishiManager.a(this.this$0).getCurrentAccountUin());
      localObject = PreferenceManager.getDefaultPreference(WeishiManager.a(this.this$0).getApplication(), l).edit();
      ((SharedPreferences.Editor)localObject).putString("key_weishi_newest_feed_id", this.b);
      ((SharedPreferences.Editor)localObject).putString("key_weishi_newest_feed_desc", this.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putLong("key_weishi_newest_feed_time", this.jdField_a_of_type_Long);
      ((SharedPreferences.Editor)localObject).putString("key_weishi_newest_feed_from", this.c);
      ((SharedPreferences.Editor)localObject).apply();
      if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1)) == null)
      {
        WSLog.a("weishi-report", "save map passback error, no key 1!");
        FileUtils.e(this.this$0.b());
        return;
      }
      boolean bool = FileUtils.a((byte[])this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1)), this.this$0.b(), false);
      WSLog.e("weishi-report", "save map saveSuccess : " + bool + ", passback : " + WeishiUtils.a((byte[])this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1))));
      return;
    }
    catch (Exception localException)
    {
      QLog.d("WeishiManager", 2, localException.getMessage(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.3
 * JD-Core Version:    0.7.0.1
 */