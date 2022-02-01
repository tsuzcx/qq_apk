package com.tencent.biz.pubaccount.readinjoy.engine;

import admh;
import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import pws;

public class WeishiManager$1
  implements Runnable
{
  public WeishiManager$1(pws parampws, Activity paramActivity) {}
  
  public void run()
  {
    if (pws.a(this.this$0) == null) {}
    do
    {
      return;
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.curFriendUin = AppConstants.WEISHI_UIN;
      localSessionInfo.curType = 1008;
      admh.a(pws.a(this.this$0), localSessionInfo);
      pws.a(this.this$0).getMessageFacade().setReaded(AppConstants.WEISHI_UIN, 1008);
    } while (!(this.a instanceof ReadInJoyChannelActivity));
    ((ReadInJoyChannelActivity)this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.WeishiManager.1
 * JD-Core Version:    0.7.0.1
 */