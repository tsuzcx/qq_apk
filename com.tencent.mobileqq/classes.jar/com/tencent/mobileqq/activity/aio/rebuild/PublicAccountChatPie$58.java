package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Dialog;
import android.os.Handler;
import com.tencent.qidian.controller.QidianBusinessObserver;
import java.util.HashMap;

class PublicAccountChatPie$58
  extends QidianBusinessObserver
{
  PublicAccountChatPie$58(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  protected void f(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((paramBoolean) && (paramHashMap != null))
    {
      if (((Integer)paramHashMap.get("result")).intValue() == 0)
      {
        this.a.u(1);
        this.a.ce.sendEmptyMessageDelayed(10, 3000L);
        return;
      }
      paramHashMap = this.a;
      paramHashMap.cC = true;
      paramHashMap.bS();
      if ((PublicAccountChatPie.H(this.a) != null) && (PublicAccountChatPie.H(this.a).isShowing())) {
        PublicAccountChatPie.H(this.a).dismiss();
      }
      this.a.bT();
      return;
    }
    this.a.u(2);
    this.a.ce.sendEmptyMessageDelayed(10, 3000L);
  }
  
  protected void g(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramBoolean)
    {
      if (paramHashMap == null) {
        return;
      }
      PublicAccountChatPie localPublicAccountChatPie = this.a;
      localPublicAccountChatPie.cF = true;
      localPublicAccountChatPie.cE = ((Boolean)paramHashMap.get("result")).booleanValue();
      this.a.bS();
      this.a.bT();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.58
 * JD-Core Version:    0.7.0.1
 */