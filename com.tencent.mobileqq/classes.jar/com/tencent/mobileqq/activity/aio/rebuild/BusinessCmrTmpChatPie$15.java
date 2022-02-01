package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.BmqqAccountType;

class BusinessCmrTmpChatPie$15
  extends CardObserver
{
  BusinessCmrTmpChatPie$15(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  protected void onGetAccountType(boolean paramBoolean, BmqqAccountType paramBmqqAccountType)
  {
    super.onGetAccountType(paramBoolean, paramBmqqAccountType);
    BusinessCmrTmpChatPie.a(this.a);
    this.a.bC();
    if ((this.a.W != null) && (this.a.bR.m(this.a.ah.b)) && (!BusinessCmrTmpChatPie.b(this.a)))
    {
      BusinessCmrTmpChatPie.a(this.a, true);
      BaseChatPie localBaseChatPie = this.a.f.getChatFragment().c;
      this.a.W.a(this.a.d, this.a.ah, localBaseChatPie);
      this.a.W.a(localBaseChatPie);
    }
    if ((paramBmqqAccountType != null) && (paramBmqqAccountType.getUin() != null) && (this.a.ah != null) && (this.a.ah.b != null) && (paramBmqqAccountType.getUin().equals(this.a.ah.b)) && (paramBmqqAccountType.getAccountType() == 6)) {
      BusinessCmrTmpChatPie.c(this.a);
    }
    if ((this.a.ah != null) && (this.a.ah.a == 1024) && ((TextUtils.isEmpty(this.a.ah.e)) || (this.a.ah.e.equals(this.a.ah.b))))
    {
      this.a.ah.e = CrmUtils.e(this.a.d, this.a.ah.b);
      this.a.C.setText(this.a.ah.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.15
 * JD-Core Version:    0.7.0.1
 */