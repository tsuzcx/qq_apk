package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.res.Resources;
import com.tencent.biz.pubaccount.api.IPublicAccountManager.refuseAcceptDone;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.qphone.base.util.BaseApplication;

class PublicAccountChatPie$23
  implements IPublicAccountManager.refuseAcceptDone
{
  PublicAccountChatPie$23(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a(boolean paramBoolean)
  {
    PublicAccountChatPie localPublicAccountChatPie = this.a;
    localPublicAccountChatPie.cE = false;
    localPublicAccountChatPie.bR();
    this.a.bz();
    AddMessageHelper.a(this.a.d, this.a.ah.b, this.a.d.getApp().getResources().getString(2131896266), this.a.ah.a, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.23
 * JD-Core Version:    0.7.0.1
 */