package com.tencent.biz.pubaccount.readinjoy.engine;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;

class WeishiManager$1
  implements Runnable
{
  WeishiManager$1(WeishiManager paramWeishiManager, Activity paramActivity) {}
  
  public void run()
  {
    if (WeishiManager.a(this.this$0) == null) {}
    do
    {
      return;
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = AppConstants.WEISHI_UIN;
      localSessionInfo.jdField_a_of_type_Int = 1008;
      ChatActivityFacade.a(WeishiManager.a(this.this$0), localSessionInfo);
      WeishiManager.a(this.this$0).getMessageFacade().c(AppConstants.WEISHI_UIN, 1008);
    } while (!(this.a instanceof ReadInJoyChannelActivity));
    ((ReadInJoyChannelActivity)this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.1
 * JD-Core Version:    0.7.0.1
 */