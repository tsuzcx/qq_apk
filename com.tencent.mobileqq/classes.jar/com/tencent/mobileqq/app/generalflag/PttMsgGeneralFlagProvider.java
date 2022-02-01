package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.utils.IMessageForPttUtilsApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class PttMsgGeneralFlagProvider
  implements IGeneralFlagProvider
{
  private void a(MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr)
  {
    if ((paramMessageRecord instanceof MessageForPtt))
    {
      paramMessageRecord = (MessageForPtt)paramMessageRecord;
      if (paramMessageRecord.waveformArray != null) {
        paramResvAttr.bytes_pb_ptt_waveform.set(ByteStringMicro.copyFrom(((IMessageForPttUtilsApi)QRoute.api(IMessageForPttUtilsApi.class)).changeWaveformToPb(paramMessageRecord.waveformArray)));
      }
    }
  }
  
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    a(paramMessageRecord, paramResvAttr);
    return new boolean[] { paramBoolean1, paramBoolean2 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.PttMsgGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */