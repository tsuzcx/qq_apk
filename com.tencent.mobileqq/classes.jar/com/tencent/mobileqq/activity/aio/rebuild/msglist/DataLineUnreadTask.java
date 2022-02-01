package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.UnreadTask;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class DataLineUnreadTask
  extends UnreadTask
{
  public DataLineUnreadTask(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void c()
  {
    super.c();
    ((DataLineHandler)this.a.a().getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).q();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.DataLineUnreadTask
 * JD-Core Version:    0.7.0.1
 */