package com.tencent.mobileqq.activity.aio.item;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
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
    AIOUtils.q = true;
    if (!this.a.c()) {
      if (SystemClock.uptimeMillis() - ShakeItemBuilder.a(this.a) < 3000L)
      {
        QLog.d("Q.msg.shakemsg", 2, "shake return cause:too much click in a very short time!");
      }
      else
      {
        MessageForShakeWindow localMessageForShakeWindow = (MessageForShakeWindow)AIOUtils.a(paramView);
        if ((!(this.a.e instanceof ChatActivity)) && (!(this.a.e instanceof SplashActivity)))
        {
          this.a.d.vibratorAndAudioForShake(localMessageForShakeWindow.frienduin, false);
        }
        else
        {
          BaseActivity localBaseActivity = (BaseActivity)this.a.e;
          ShakeItemBuilder.a(this.a, SystemClock.uptimeMillis());
          localBaseActivity.getChatFragment().k().az();
          this.a.d.vibratorAndAudioForShake(localMessageForShakeWindow.frienduin, false);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShakeItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */