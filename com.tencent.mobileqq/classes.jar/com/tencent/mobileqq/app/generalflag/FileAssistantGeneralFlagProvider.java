package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class FileAssistantGeneralFlagProvider
  implements IGeneralFlagProvider
{
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    if (QFileAssistantUtils.a(paramMessageRecord.frienduin))
    {
      int i = QFileAssistantUtils.c();
      paramResvAttr.uint32_device_type.set(i);
      QFileAssistantUtils.a(paramMessageRecord, i);
      return true;
    }
    return paramBoolean;
  }
  
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    return new boolean[] { paramBoolean1, a(paramMessageRecord, paramBoolean2, paramResvAttr) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.FileAssistantGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */