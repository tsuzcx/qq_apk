package com.tencent.biz.pubaccount.readinjoy.engine;

import aaod;
import ajsf;
import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import otp;

public class WeishiManager$1
  implements Runnable
{
  public WeishiManager$1(otp paramotp, Activity paramActivity) {}
  
  public void run()
  {
    if (otp.a(this.this$0) == null) {}
    do
    {
      return;
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = ajsf.aP;
      localSessionInfo.jdField_a_of_type_Int = 1008;
      aaod.a(otp.a(this.this$0), localSessionInfo);
      otp.a(this.this$0).a().c(ajsf.aP, 1008);
    } while (!(this.a instanceof ReadInJoyChannelActivity));
    ((ReadInJoyChannelActivity)this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.1
 * JD-Core Version:    0.7.0.1
 */