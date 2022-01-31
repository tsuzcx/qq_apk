package com.tencent.biz.pubaccount.readinjoy.engine;

import aael;
import ajed;
import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import oie;

public class WeishiManager$1
  implements Runnable
{
  public WeishiManager$1(oie paramoie, Activity paramActivity) {}
  
  public void run()
  {
    if (oie.a(this.this$0) == null) {}
    do
    {
      return;
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = ajed.aO;
      localSessionInfo.jdField_a_of_type_Int = 1008;
      aael.a(oie.a(this.this$0), localSessionInfo);
      oie.a(this.this$0).a().c(ajed.aO, 1008);
    } while (!(this.a instanceof ReadInJoyChannelActivity));
    ((ReadInJoyChannelActivity)this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.1
 * JD-Core Version:    0.7.0.1
 */