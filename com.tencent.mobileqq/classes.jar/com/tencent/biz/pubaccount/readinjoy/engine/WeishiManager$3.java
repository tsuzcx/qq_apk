package com.tencent.biz.pubaccount.readinjoy.engine;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import bace;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import oie;
import sai;
import sam;

public class WeishiManager$3
  implements Runnable
{
  public WeishiManager$3(oie paramoie, String paramString1, long paramLong, QQMessageFacade paramQQMessageFacade, String paramString2, Map paramMap) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a((MessageRecord)localObject, oie.a(this.this$0).c());
    }
    sam.jdField_a_of_type_JavaLangString = this.b;
    sai.a("WSAioLog", "saveLastFeedInfo feedId:" + this.b + ", title:" + this.jdField_a_of_type_JavaLangString);
    try
    {
      long l = Long.parseLong(oie.a(this.this$0).getCurrentAccountUin());
      localObject = PreferenceManager.getDefaultPreference(oie.a(this.this$0).getApplication(), l).edit();
      ((SharedPreferences.Editor)localObject).putString("key_weishi_newest_feed_id", this.b).apply();
      ((SharedPreferences.Editor)localObject).putString("key_weishi_newest_feed_desc", this.jdField_a_of_type_JavaLangString).apply();
      ((SharedPreferences.Editor)localObject).putLong("key_weishi_newest_feed_time", this.jdField_a_of_type_Long).apply();
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(1)))
      {
        if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1)) != null)
        {
          bace.a((byte[])this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1)), this.this$0.b(), false);
          Log.i("weishi-report", "save map passback length:" + ((byte[])this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1))).length);
          Log.d("weishi-report", "save map passback:" + sam.a((byte[])this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1))));
        }
      }
      else
      {
        Log.i("weishi-report", "save map passback error, no key 1!");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("WeishiManager", 2, localException.getMessage(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.3
 * JD-Core Version:    0.7.0.1
 */