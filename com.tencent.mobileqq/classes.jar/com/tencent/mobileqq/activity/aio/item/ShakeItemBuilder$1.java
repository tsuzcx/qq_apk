package com.tencent.mobileqq.activity.aio.item;

import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShakeItemBuilder$1
  implements View.OnClickListener
{
  ShakeItemBuilder$1(ShakeItemBuilder paramShakeItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "shake msg onClick() is called");
    }
    AIOUtils.o = true;
    if (this.a.a()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (SystemClock.uptimeMillis() - ShakeItemBuilder.a(this.a) < 3000L)
      {
        QLog.d("Q.msg.shakemsg", 2, "shake return cause:too much click in a very short time!");
      }
      else
      {
        MessageForShakeWindow localMessageForShakeWindow = (MessageForShakeWindow)AIOUtils.a(paramView);
        if (((this.a.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) || ((this.a.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)))
        {
          FragmentActivity localFragmentActivity = (FragmentActivity)this.a.jdField_a_of_type_AndroidContentContext;
          ShakeItemBuilder.a(this.a, SystemClock.uptimeMillis());
          localFragmentActivity.getChatFragment().a().aq();
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.vibratorAndAudioForShake(localMessageForShakeWindow.frienduin, false);
        }
        else
        {
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.vibratorAndAudioForShake(localMessageForShakeWindow.frienduin, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShakeItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */