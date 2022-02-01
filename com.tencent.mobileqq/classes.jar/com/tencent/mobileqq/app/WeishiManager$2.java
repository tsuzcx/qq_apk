package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class WeishiManager$2
  implements Runnable
{
  WeishiManager$2(WeishiManager paramWeishiManager, String paramString1, long paramLong, QQMessageFacade paramQQMessageFacade, String paramString2, String paramString3, Map paramMap) {}
  
  public void run()
  {
    Object localObject = this.this$0.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a((MessageRecord)localObject, WeishiManager.a(this.this$0).getCurrentUin());
    }
    ((IWSManager)QRoute.api(IWSManager.class)).setWeishiLastFeedId(this.b);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveLastFeedInfo feedId:");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(", title:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.i("WSAioLog", 2, ((StringBuilder)localObject).toString());
    try
    {
      long l = Long.parseLong(WeishiManager.a(this.this$0).getCurrentAccountUin());
      localObject = PreferenceManager.getDefaultPreference(WeishiManager.a(this.this$0).getApplication(), l).edit();
      ((SharedPreferences.Editor)localObject).putString("key_weishi_newest_feed_id", this.b);
      ((SharedPreferences.Editor)localObject).putString("key_weishi_newest_feed_desc", this.jdField_a_of_type_JavaLangString);
      ((SharedPreferences.Editor)localObject).putLong("key_weishi_newest_feed_time", this.jdField_a_of_type_Long);
      ((SharedPreferences.Editor)localObject).putString("key_weishi_newest_feed_from", this.c);
      ((SharedPreferences.Editor)localObject).apply();
      localObject = this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1));
      if (localObject == null)
      {
        QLog.i("weishi-report", 2, "save map passback error, no key 1!");
        FileUtils.deleteFile(this.this$0.b());
        return;
      }
      boolean bool = FileUtils.writeFile((byte[])this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(1)), this.this$0.b(), false);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("save map saveSuccess : ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("weishi-report", 2, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.d("WeishiManager", 2, localException.getMessage(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.WeishiManager.2
 * JD-Core Version:    0.7.0.1
 */