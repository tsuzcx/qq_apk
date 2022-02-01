package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Dialog;
import android.os.Handler;
import com.tencent.qidian.controller.QidianBusinessObserver;
import java.util.HashMap;

class PublicAccountChatPie$58
  extends QidianBusinessObserver
{
  PublicAccountChatPie$58(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void f(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null))
    {
      this.a.x(2);
      this.a.a.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    if (((Integer)paramHashMap.get("result")).intValue() == 0)
    {
      this.a.x(1);
      this.a.a.sendEmptyMessageDelayed(10, 3000L);
      return;
    }
    this.a.ai = true;
    this.a.bw();
    if ((PublicAccountChatPie.a(this.a) != null) && (PublicAccountChatPie.a(this.a).isShowing())) {
      PublicAccountChatPie.a(this.a).dismiss();
    }
    this.a.bx();
  }
  
  public void g(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    if ((!paramBoolean) || (paramHashMap == null)) {
      return;
    }
    this.a.al = true;
    this.a.ak = ((Boolean)paramHashMap.get("result")).booleanValue();
    this.a.bw();
    this.a.bx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.58
 * JD-Core Version:    0.7.0.1
 */