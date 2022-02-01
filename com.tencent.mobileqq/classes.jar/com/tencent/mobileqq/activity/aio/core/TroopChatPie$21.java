package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousStatusListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import mqq.os.MqqHandler;

class TroopChatPie$21
  implements AnonymousChatHelper.AnonymousStatusListener
{
  TroopChatPie$21(TroopChatPie paramTroopChatPie) {}
  
  public void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equals(this.a.ah.b))) {
      this.a.m.post(new TroopChatPie.21.1(this, paramString2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.21
 * JD-Core Version:    0.7.0.1
 */