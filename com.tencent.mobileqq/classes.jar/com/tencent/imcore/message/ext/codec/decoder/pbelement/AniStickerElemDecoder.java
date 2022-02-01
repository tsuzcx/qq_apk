package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class AniStickerElemDecoder
  extends SimplePBElemDecoder
{
  public int a()
  {
    return super.a() + 5;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    paramMsg = paramList.iterator();
    while (paramMsg.hasNext())
    {
      paramList = (im_msg_body.Elem)paramMsg.next();
      if (a(paramList)) {
        break label39;
      }
    }
    paramList = null;
    label39:
    if ((paramList != null) && (paramList.common_elem.bytes_pb_elem.has()))
    {
      if (paramList1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MessageForAniSticker", 2, "[decodePBMsgElem] msgRecords null");
        }
        paramList1 = new ArrayList();
      }
      else
      {
        paramList1.clear();
      }
      paramMsg = new MessageForAniSticker();
      paramMsg.deserializeMsgBody(paramList.common_elem.bytes_pb_elem.get().toByteArray());
      paramMsg.msgtype = -8018;
      paramMsg.msg = paramMsg.text;
      paramMsg.mIsParsed = true;
      paramMsg.msgData = paramMsg.serializeMsgData();
      paramList1.add(paramMsg);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MessageForAniSticker", 2, "[decodePBMsgElem] matchElem null or Bytes isEmpty");
    }
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (37 == paramElem.common_elem.uint32_service_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.AniStickerElemDecoder
 * JD-Core Version:    0.7.0.1
 */