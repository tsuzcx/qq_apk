package com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry;

import ahfz;
import ahgm;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpacketConfBean.TimeInfo;
import com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.config.SpringFestivalRedpakcetPreviewConfBean.BreathLight;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class SpringHbEntryManager$17
  implements Runnable
{
  public SpringHbEntryManager$17(ahfz paramahfz, SpringFestivalRedpakcetPreviewConfBean.BreathLight paramBreathLight) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences;
    boolean bool;
    if (ahfz.a(this.this$0) != null)
    {
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("spring_entry_sp", 4);
      bool = localSharedPreferences.getBoolean(ahfz.a(this.this$0, this.a.breathTimeInfo.beginTime, this.a.breathTimeInfo.endTime, ahfz.a(this.this$0).getCurrentAccountUin()), false);
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringEntryManager", 2, "checkBreathLight ... hasABreathLightShow: " + bool);
      }
      if (bool) {}
    }
    try
    {
      ahfz.a(this.this$0).a(true, this.a);
      bool = localSharedPreferences.getBoolean("first_enter_time_flag_" + ahfz.a(this.this$0, this.a.breathTimeInfo.beginTime, this.a.breathTimeInfo.endTime, ahfz.a(this.this$0).c()), true);
      if (QLog.isColorLevel()) {
        QLog.i("springHb_SpringEntryManager", 2, "is first show : " + bool);
      }
      if (bool)
      {
        localSharedPreferences.edit().putLong("first_enter_time_" + ahfz.a(this.this$0, this.a.breathTimeInfo.beginTime, this.a.breathTimeInfo.endTime, ahfz.a(this.this$0).c()), this.this$0.b()).apply();
        localSharedPreferences.edit().putBoolean("first_enter_time_flag_" + ahfz.a(this.this$0, this.a.breathTimeInfo.beginTime, this.a.breathTimeInfo.endTime, ahfz.a(this.this$0).c()), false).apply();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("springHb_SpringEntryManager", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.springfestival.entry.SpringHbEntryManager.17
 * JD-Core Version:    0.7.0.1
 */