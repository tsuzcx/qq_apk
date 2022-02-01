package com.tencent.mobileqq.activity.aio.core.msglist;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;

public class MsgList
{
  private final ListUI a;
  private final BaseMsgLoader b;
  private final Scroller c;
  private final UnreadTask d;
  private final MsgListRefresher e;
  private final MsgListRegister f;
  
  MsgList(@NonNull AIOContext paramAIOContext, @NonNull ListUI paramListUI, @NonNull Scroller paramScroller, @NonNull BaseMsgLoader paramBaseMsgLoader, @NonNull UnreadTask paramUnreadTask, @NonNull MsgListRefresher paramMsgListRefresher)
  {
    this.a = paramListUI;
    this.c = paramScroller;
    this.b = paramBaseMsgLoader;
    this.d = paramUnreadTask;
    this.e = paramMsgListRefresher;
    this.f = new MsgListRegister(paramAIOContext);
    paramMsgListRefresher.a(paramListUI);
  }
  
  public MsgListRegister a()
  {
    return this.f;
  }
  
  public ListUI b()
  {
    return this.a;
  }
  
  public BaseMsgLoader c()
  {
    if (!this.b.a()) {
      this.b.a(this.f.a());
    }
    return this.b;
  }
  
  public Scroller d()
  {
    return this.c;
  }
  
  public UnreadTask e()
  {
    return this.d;
  }
  
  public MsgListRefresher f()
  {
    return this.e;
  }
  
  public void g()
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.MsgList
 * JD-Core Version:    0.7.0.1
 */