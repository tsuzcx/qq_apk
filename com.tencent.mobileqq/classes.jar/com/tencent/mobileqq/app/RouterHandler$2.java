package com.tencent.mobileqq.app;

import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgCSBody;
import com.tencent.litetransfersdk.ProtocolHelper;
import java.util.List;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MsgHeader;

class RouterHandler$2
  implements Runnable
{
  RouterHandler$2(RouterHandler paramRouterHandler, SubMsgType0x7.MsgBody.MsgHeader paramMsgHeader, List paramList, boolean paramBoolean) {}
  
  public void run()
  {
    MsgCSBody localMsgCSBody = this.this$0.k.MsgCSBodyFromFTNNotify(0, this.a, this.b, this.c);
    this.this$0.j.OnPbMsgReceive(localMsgCSBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.RouterHandler.2
 * JD-Core Version:    0.7.0.1
 */