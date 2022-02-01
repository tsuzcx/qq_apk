package com.tencent.biz.pubaccount.readinjoy.engine;

import aean;
import android.app.Activity;
import antf;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import pgj;

public class WeishiManager$1
  implements Runnable
{
  public WeishiManager$1(pgj parampgj, Activity paramActivity) {}
  
  public void run()
  {
    if (pgj.a(this.this$0) == null) {}
    do
    {
      return;
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = antf.aP;
      localSessionInfo.jdField_a_of_type_Int = 1008;
      aean.a(pgj.a(this.this$0), localSessionInfo);
      pgj.a(this.this$0).a().c(antf.aP, 1008);
    } while (!(this.a instanceof ReadInJoyChannelActivity));
    ((ReadInJoyChannelActivity)this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.1
 * JD-Core Version:    0.7.0.1
 */