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
        this.a.n(1);
        this.a.a.sendEmptyMessageDelayed(10, 3000L);
        return;
      }
      paramHashMap = this.a;
      paramHashMap.Y = true;
      paramHashMap.aC();
      if ((PublicAccountChatPie.a(this.a) != null) && (PublicAccountChatPie.a(this.a).isShowing())) {
        PublicAccountChatPie.a(this.a).dismiss();
      }
      this.a.aD();
      return;
    }
    this.a.n(2);
    this.a.a.sendEmptyMessageDelayed(10, 3000L);
  }
  
  protected void g(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if (paramBoolean)
    {
      if (paramHashMap == null) {
        return;
      }
      PublicAccountChatPie localPublicAccountChatPie = this.a;
      localPublicAccountChatPie.ab = true;
      localPublicAccountChatPie.aa = ((Boolean)paramHashMap.get("result")).booleanValue();
      this.a.aC();
      this.a.aD();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.58
 * JD-Core Version:    0.7.0.1
 */