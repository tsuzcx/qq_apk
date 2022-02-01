package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.imcore.message.ConfessRefresher;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.app.QQAppInterface;

public class ConfessListUI
  extends ListUI
{
  public ConfessListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void c()
  {
    super.c();
    if (this.h.w > 0) {
      this.h.y = new ConfessRefresher(this.b.a().getMessageFacade().r());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ConfessListUI
 * JD-Core Version:    0.7.0.1
 */