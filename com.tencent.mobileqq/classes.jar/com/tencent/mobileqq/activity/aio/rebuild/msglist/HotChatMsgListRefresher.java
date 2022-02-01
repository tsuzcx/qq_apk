package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatContext;

public class HotChatMsgListRefresher
  extends MsgListRefresher
{
  public HotChatMsgListRefresher(@NonNull AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void a()
  {
    super.a();
    if (((HotChatContext)this.a).d() == 2) {
      this.a.a().a().a(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.HotChatMsgListRefresher
 * JD-Core Version:    0.7.0.1
 */