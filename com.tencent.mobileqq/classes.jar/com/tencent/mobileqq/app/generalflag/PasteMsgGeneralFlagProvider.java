package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class PasteMsgGeneralFlagProvider
  implements IGeneralFlagProvider
{
  private int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private void a(generalflags.ResvAttr paramResvAttr, String paramString, int paramInt)
  {
    int i = 1;
    if ((paramInt & 0x1) != 1) {
      i = 0;
    }
    if (i != 0)
    {
      paramResvAttr.uint32_msg_info_flag.set(paramInt);
      if (QLog.isColorLevel())
      {
        paramResvAttr = new StringBuilder();
        paramResvAttr.append("getGeneralFlagElemFromMsg: invoked.  containPasteExtra: ");
        paramResvAttr.append(paramString);
        QLog.i("Q.msg.MessageHandlerUtils", 2, paramResvAttr.toString());
      }
    }
  }
  
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    paramAppInterface = paramMessageRecord.getExtInfoFromExtStr("key_message_extra_info_flag");
    a(paramResvAttr, paramAppInterface, a(paramAppInterface));
    return new boolean[] { paramBoolean1, paramBoolean2 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.PasteMsgGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */