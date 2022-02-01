package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.guild.message.api.IGuildAioMsgFilterApi.MsgSeqItem;

class GuildOneClickJumpMsgFilter$1
  implements Runnable
{
  GuildOneClickJumpMsgFilter$1(GuildOneClickJumpMsgFilter paramGuildOneClickJumpMsgFilter, IGuildAioMsgFilterApi.MsgSeqItem paramMsgSeqItem1, IGuildAioMsgFilterApi.MsgSeqItem paramMsgSeqItem2, boolean paramBoolean, AIOContext paramAIOContext) {}
  
  public void run()
  {
    if (this.a != null)
    {
      if (this.b == null) {
        return;
      }
      if (this.c != this.d.e().b().e()) {
        this.d.e().b().a(this.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.GuildOneClickJumpMsgFilter.1
 * JD-Core Version:    0.7.0.1
 */