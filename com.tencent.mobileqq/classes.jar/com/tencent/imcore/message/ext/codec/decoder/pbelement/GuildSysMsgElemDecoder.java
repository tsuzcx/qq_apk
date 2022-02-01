package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.group_pro_proto.msgpush.servtype.EventBody;
import tencent.im.group_pro_proto.msgpush.servtype.UpdateMsg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class GuildSysMsgElemDecoder
  extends SimplePBElemDecoder
{
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if (paramDecodeProtoPkgContext.p != 10014) {
      return false;
    }
    paramMsg = null;
    paramStringBuilder = paramList.iterator();
    do
    {
      paramList = paramMsg;
      if (!paramStringBuilder.hasNext()) {
        break;
      }
      paramList = (im_msg_body.Elem)paramStringBuilder.next();
    } while (!paramList.common_elem.has());
    paramList = (im_msg_body.CommonElem)paramList.common_elem.get();
    if (paramList == null) {
      return false;
    }
    if (500 != paramList.uint32_service_type.get()) {
      return false;
    }
    paramMsg = new servtype.EventBody();
    try
    {
      paramMsg.mergeFrom(paramList.bytes_pb_elem.get().toByteArray());
      if (paramMsg.msg_update_msg.has())
      {
        paramList = (servtype.UpdateMsg)paramMsg.msg_update_msg.get();
        if (paramList.uint64_msg_seq.has())
        {
          paramMsg = new MessageRecord();
          paramMsg.msgtype = -2006;
          paramMsg.saveExtInfoToExtStr("GUILD_MSG_UPDATE_MSG_SEQ", String.valueOf(paramList.uint64_msg_seq.get()));
          paramList1.add(paramMsg);
          return true;
        }
      }
      return false;
    }
    catch (InvalidProtocolBufferMicroException paramList) {}
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (((im_msg_body.CommonElem)paramElem.common_elem.get()).uint32_service_type.get() == 500);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.GuildSysMsgElemDecoder
 * JD-Core Version:    0.7.0.1
 */