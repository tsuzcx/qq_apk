package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.rebuild.AppletsContext;

public class AppletsMsgListRefresher
  extends MsgListRefresher
{
  public AppletsMsgListRefresher(@NonNull AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void e()
  {
    super.e();
    if (this.a.e().b().w() < 1)
    {
      ((AppletsContext)this.a).Q();
      return;
    }
    ((AppletsContext)this.a).P();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.AppletsMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */