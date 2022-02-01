package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype11;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class DoodleElemDecoder
  extends SimplePBElemDecoder
{
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramMsg = (im_msg_body.Elem)paramList.next();
      if (paramMsg.common_elem.has())
      {
        paramList = (im_msg_body.CommonElem)paramMsg.common_elem.get();
        break label55;
      }
    }
    paramList = null;
    label55:
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("decodePBMsgElems_ScribbleMsg;\n");
    }
    paramStringBuilder = new hummer_commelem.MsgElemInfo_servtype11();
    try
    {
      paramStringBuilder.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
      paramList = (MessageForScribble)MessageRecordFactory.a(-7001);
      paramList.msgtype = -7001;
      if (paramStringBuilder.bytes_Doodle_md5.has()) {
        paramList.combineFileMd5 = new String(paramStringBuilder.bytes_Doodle_md5.get().toByteArray());
      }
      if (paramStringBuilder.bytes_Doodle_url.has()) {
        paramList.combineFileUrl = new String(paramStringBuilder.bytes_Doodle_url.get().toByteArray());
      }
      if (paramStringBuilder.uint32_doodleData_offset.has()) {
        paramList.offSet = paramStringBuilder.uint32_doodleData_offset.get();
      }
      if (paramStringBuilder.uint32_doodle_gif_id.has()) {
        paramList.gifId = paramStringBuilder.uint32_doodle_gif_id.get();
      }
      if (QLog.isColorLevel())
      {
        paramStringBuilder = new StringBuilder();
        paramStringBuilder.append(" decodePBMsgElems_ScribbleMsg ");
        paramStringBuilder.append(paramList.combineFileMd5);
        paramStringBuilder.append(" ");
        paramStringBuilder.append(paramList.combineFileUrl);
        QLog.i("DoodleElemDecoderscribble msg", 1, paramStringBuilder.toString());
      }
      paramList.prewrite();
      paramList1.add(paramList);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramList)
    {
      QLog.e("DoodleElemDecoderscribble msg", 1, paramList, new Object[0]);
    }
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    a(paramList, paramList1, paramStringBuilder, paramMsg);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (11 == paramElem.common_elem.uint32_service_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.DoodleElemDecoder
 * JD-Core Version:    0.7.0.1
 */