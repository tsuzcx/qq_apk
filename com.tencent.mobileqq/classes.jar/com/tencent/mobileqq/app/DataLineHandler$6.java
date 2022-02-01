package com.tencent.mobileqq.app;

import com.dataline.compatible.DatalineDownloadRespInfo;
import com.dataline.compatible.IDatalineFileReqCallback;
import com.tencent.litetransfersdk.LiteTransferWrapper;
import com.tencent.litetransfersdk.MsgSCBody;
import com.tencent.litetransfersdk.ProtocolHelper;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.cs.cmd0x346.cmd0x346.RspBody;

class DataLineHandler$6
  implements Runnable
{
  DataLineHandler$6(DataLineHandler paramDataLineHandler, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt) {}
  
  public void run()
  {
    MsgSCBody localMsgSCBody = new MsgSCBody();
    Object localObject2 = new cmd0x346.RspBody();
    localMsgSCBody.uMsgType = 838;
    if ((this.a == null) || (this.b == null)) {
      localMsgSCBody.bTimeOut = true;
    }
    FromServiceMsg localFromServiceMsg = this.b;
    if (localFromServiceMsg != null)
    {
      byte[] arrayOfByte = null;
      if (localFromServiceMsg.getWupBuffer() != null)
      {
        int i = this.b.getWupBuffer().length - 4;
        if (i >= 0)
        {
          arrayOfByte = new byte[i];
          PkgTools.copyData(arrayOfByte, 0, this.b.getWupBuffer(), 4, i);
        }
      }
      else if (arrayOfByte != null)
      {
        try
        {
          ((cmd0x346.RspBody)localObject2).mergeFrom(arrayOfByte);
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
    this.this$0.g.FillMsgSCBody(localMsgSCBody, (cmd0x346.RspBody)localObject2, this.c);
    Object localObject1 = this.a;
    if (localObject1 == null)
    {
      this.this$0.d.OnPbMsgReply(0, localMsgSCBody);
      return;
    }
    localObject1 = (IDatalineFileReqCallback)((ToServiceMsg)localObject1).getAttribute("callback");
    if (localObject1 != null)
    {
      localObject2 = new DatalineDownloadRespInfo();
      ((DatalineDownloadRespInfo)localObject2).a(localMsgSCBody);
      ((IDatalineFileReqCallback)localObject1).a((DatalineDownloadRespInfo)localObject2);
      return;
    }
    localObject1 = (Long)this.a.getAttribute("cookie");
    this.this$0.d.OnPbMsgReply(((Long)localObject1).intValue(), localMsgSCBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.6
 * JD-Core Version:    0.7.0.1
 */