package com.tencent.mobileqq.activity.aio.core.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;

public class MsgListBuilder
{
  private final AIOContext a;
  private ListUI b;
  private Scroller c;
  private BaseMsgLoader d;
  private UnreadTask e;
  private MsgListRefresher f;
  
  public MsgListBuilder(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
  }
  
  public MsgList a()
  {
    if (this.d == null) {
      this.d = new BaseMsgLoader();
    }
    if (this.f == null) {
      this.f = new MsgListRefresher(this.a);
    }
    return new MsgList(this.a, this.b, this.c, this.d, this.e, this.f);
  }
  
  public MsgListBuilder a(UnreadTask paramUnreadTask)
  {
    this.e = paramUnreadTask;
    return this;
  }
  
  public MsgListBuilder a(BaseMsgLoader paramBaseMsgLoader)
  {
    this.d = paramBaseMsgLoader;
    return this;
  }
  
  public MsgListBuilder a(MsgListRefresher paramMsgListRefresher)
  {
    this.f = paramMsgListRefresher;
    return this;
  }
  
  public MsgListBuilder a(ListUI paramListUI)
  {
    this.b = paramListUI;
    return this;
  }
  
  public MsgListBuilder a(Scroller paramScroller)
  {
    this.c = paramScroller;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder
 * JD-Core Version:    0.7.0.1
 */