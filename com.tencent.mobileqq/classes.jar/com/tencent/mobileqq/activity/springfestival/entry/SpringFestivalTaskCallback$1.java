package com.tencent.mobileqq.activity.springfestival.entry;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.portal.ConversationHongBaoV2;
import com.tencent.qphone.base.util.QLog;

class SpringFestivalTaskCallback$1
  implements Handler.Callback
{
  SpringFestivalTaskCallback$1(SpringFestivalTaskCallback paramSpringFestivalTaskCallback) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage ,msg.what =  ");
      localStringBuilder.append(paramMessage.what);
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, localStringBuilder.toString());
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "handleMessage ,MSG_HIDE_NORMAL_BREATH_LIGHT");
      }
      SpringFestivalTaskCallback.a(this.a).a.a();
      SpringFestivalTaskCallback.a(this.a, false);
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "handleMessage MSG_GRAB_FAKE_EVENT 11");
    }
    SpringFestivalTaskCallback.a(this.a).a.a(false, HardCodeUtil.a(2131708339), null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback.1
 * JD-Core Version:    0.7.0.1
 */