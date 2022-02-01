package com.tencent.mobileqq.activity.home;

import android.app.Dialog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;

class Conversation$ShowRealNameDialog
{
  private final String b;
  private final String c;
  private final String d;
  
  public Conversation$ShowRealNameDialog(Conversation paramConversation, String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }
  
  public void a()
  {
    Conversation.ShowRealNameDialog.1 local1 = new Conversation.ShowRealNameDialog.1(this);
    Conversation localConversation = this.a;
    localConversation.z = DialogUtil.a(localConversation.P(), 230, this.b, this.c, HardCodeUtil.a(2131900757), HardCodeUtil.a(2131900761), local1, local1);
    this.a.z.setCancelable(false);
    this.a.z.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.ShowRealNameDialog
 * JD-Core Version:    0.7.0.1
 */