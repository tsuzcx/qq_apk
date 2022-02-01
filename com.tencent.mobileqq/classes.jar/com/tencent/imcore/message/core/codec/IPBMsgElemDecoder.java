package com.tencent.imcore.message.core.codec;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.Elem;

public abstract interface IPBMsgElemDecoder
{
  public abstract int a();
  
  public abstract void a(List<IPBMsgElemDecoder> paramList);
  
  public abstract boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext);
  
  public abstract boolean a(im_msg_body.Elem paramElem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.imcore.message.core.codec.IPBMsgElemDecoder
 * JD-Core Version:    0.7.0.1
 */