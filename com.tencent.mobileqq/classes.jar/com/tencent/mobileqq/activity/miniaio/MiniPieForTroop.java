package com.tencent.mobileqq.activity.miniaio;

import android.content.Context;
import android.os.Bundle;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class MiniPieForTroop
  extends MiniPie
{
  public MiniPieForTroop(Context paramContext, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramSessionInfo, paramQQAppInterface);
  }
  
  protected void A()
  {
    this.a = "MiniPieForTroop";
  }
  
  public boolean a()
  {
    super.a();
    long l = this.d.getConversationFacade().e(this.c.b, this.c.a);
    this.c.b().putLong("key_troop_last_read_seq", l);
    return true;
  }
  
  protected boolean c()
  {
    return true;
  }
  
  protected void i()
  {
    this.T = true;
    super.i();
  }
  
  protected void w()
  {
    super.w();
  }
  
  protected void x()
  {
    super.x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniPieForTroop
 * JD-Core Version:    0.7.0.1
 */