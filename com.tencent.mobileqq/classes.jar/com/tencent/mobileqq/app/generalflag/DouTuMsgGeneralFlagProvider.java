package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.doutu.DoutuMsgUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class DouTuMsgGeneralFlagProvider
  implements IGeneralFlagProvider
{
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    if (DoutuMsgUtil.a(paramMessageRecord))
    {
      paramResvAttr.uint32_doutu_msg_type.set(1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElemFromMsg [doutu] set uint32_doutu_msg_type ");
      }
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    return new boolean[] { paramBoolean1, a(paramMessageRecord, paramBoolean2, paramResvAttr) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.DouTuMsgGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */