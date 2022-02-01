package com.tencent.biz.pubaccount.readinjoy.engine;

import adrm;
import android.app.Activity;
import anhk;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import pnp;

public class WeishiManager$1
  implements Runnable
{
  public WeishiManager$1(pnp parampnp, Activity paramActivity) {}
  
  public void run()
  {
    if (pnp.a(this.this$0) == null) {}
    do
    {
      return;
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_JavaLangString = anhk.aP;
      localSessionInfo.jdField_a_of_type_Int = 1008;
      adrm.a(pnp.a(this.this$0), localSessionInfo);
      pnp.a(this.this$0).a().c(anhk.aP, 1008);
    } while (!(this.a instanceof ReadInJoyChannelActivity));
    ((ReadInJoyChannelActivity)this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.1
 * JD-Core Version:    0.7.0.1
 */