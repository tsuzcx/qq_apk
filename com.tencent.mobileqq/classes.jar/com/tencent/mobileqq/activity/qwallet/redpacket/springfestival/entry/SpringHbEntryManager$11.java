package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry;

import ahfz;
import ahgm;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean.PreviewInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class SpringHbEntryManager$11
  implements Runnable
{
  public SpringHbEntryManager$11(ahfz paramahfz, long paramLong, SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void run()
  {
    SpringFestivalRedpakcetPreviewConfBean.PreviewInfo localPreviewInfo;
    if (ahfz.a(this.this$0) != null)
    {
      localPreviewInfo = this.this$0.a(this.jdField_a_of_type_Long);
      if (localPreviewInfo == null) {}
    }
    try
    {
      ahfz.a(this.this$0).a(localPreviewInfo.resourceUrl, localPreviewInfo.actionUrl);
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_JavaLangString + "_" + ahfz.a(this.this$0).getCurrentAccountUin() + "_" + "spring_active_dialog_show", true).apply();
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_JavaLangString + "_" + ahfz.a(this.this$0).getCurrentAccountUin() + "_" + "spring_active_dialog_show", false).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.11
 * JD-Core Version:    0.7.0.1
 */