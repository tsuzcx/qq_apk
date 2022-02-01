package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype35;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class WriteTogetherElemDecoder
  extends SimplePBElemDecoder
{
  private MessageForWriteTogether a(im_msg_body.Elem paramElem, MessageRecord paramMessageRecord)
  {
    MessageForWriteTogether localMessageForWriteTogether = new MessageForWriteTogether();
    MessageRecord.copyMessageRecordBaseField(localMessageForWriteTogether, paramMessageRecord);
    if (paramElem.common_elem.bytes_pb_elem.has())
    {
      hummer_commelem.MsgElemInfo_servtype35 localMsgElemInfo_servtype35 = new hummer_commelem.MsgElemInfo_servtype35();
      try
      {
        localMsgElemInfo_servtype35.mergeFrom(paramElem.common_elem.bytes_pb_elem.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException paramElem)
      {
        paramElem.printStackTrace();
      }
      localMsgElemInfo_servtype35.bytes_global_padid.has();
      paramElem = localMsgElemInfo_servtype35.bytes_token.get().toStringUtf8();
      String str = localMsgElemInfo_servtype35.bytes_global_padid.get().toStringUtf8();
      int i = localMsgElemInfo_servtype35.uint32_get_rev.get();
      int j = localMsgElemInfo_servtype35.uint32_his_edit_uin_num.get();
      boolean bool2 = false;
      boolean bool1;
      if ((paramMessageRecord instanceof MessageForLongTextMsg))
      {
        paramMessageRecord = (MessageForLongTextMsg)paramMessageRecord;
        paramMessageRecord.parse();
        bool1 = bool2;
        if (paramMessageRecord.sb != null)
        {
          bool1 = bool2;
          if (paramMessageRecord.sb.length() >= 6000) {
            bool1 = true;
          }
        }
      }
      else
      {
        if ((paramMessageRecord instanceof MessageForText))
        {
          paramMessageRecord = (MessageForText)paramMessageRecord;
          paramMessageRecord.parse();
          if ((paramMessageRecord.sb != null) && (paramMessageRecord.sb.length() >= 6000))
          {
            bool1 = true;
            break label219;
          }
        }
        bool1 = false;
      }
      label219:
      a(localMessageForWriteTogether, paramElem, str, i, bool1, j);
    }
    return localMessageForWriteTogether;
  }
  
  private void a(MessageForWriteTogether paramMessageForWriteTogether, String paramString1, String paramString2, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    paramMessageForWriteTogether.token = paramString1;
    paramMessageForWriteTogether.padId = paramString2;
    paramMessageForWriteTogether.baseRev = paramInt1;
    paramMessageForWriteTogether.isLongMsg = paramBoolean;
    paramMessageForWriteTogether.partCnt = paramInt2;
    paramMessageForWriteTogether.msgtype = -7014;
    paramMessageForWriteTogether.saveExtInfoToExtStr("write_together_token", paramString1);
    paramMessageForWriteTogether.saveExtInfoToExtStr("write_together_pad_id", paramString2);
    paramMessageForWriteTogether.saveExtInfoToExtStr("write_together_base_rev", String.valueOf(paramInt1));
    paramMessageForWriteTogether.saveExtInfoToExtStr("write_together_part_cnt", String.valueOf(paramInt2));
    paramMessageForWriteTogether.saveExtInfoToExtStr("write_together_long_msg", String.valueOf(paramBoolean));
  }
  
  private boolean a(im_msg_body.Elem paramElem, List<MessageRecord> paramList)
  {
    if ((paramElem != null) && (paramList != null) && (paramList.size() != 0))
    {
      if ((QLog.isColorLevel()) && (paramList.size() != 1))
      {
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[decodeWriteTogetherMsg] ");
          localStringBuilder.append(localMessageRecord.toString());
          QLog.d("WriteTogetherElemDecode", 1, localStringBuilder.toString());
        }
      }
      paramList.set(0, a(paramElem, (MessageRecord)paramList.get(0)));
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[decodeWriteTogetherMsg] elem: ");
    ((StringBuilder)localObject).append(paramElem);
    ((StringBuilder)localObject).append(", message: ");
    ((StringBuilder)localObject).append(paramList);
    QLog.e("WriteTogetherElemDecode", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  public int a()
  {
    return -1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    if (paramList1 == null) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramMsg = (im_msg_body.Elem)paramList.next();
      if ((a(paramMsg)) && (a(paramMsg, paramList1))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (35 == paramElem.common_elem.uint32_service_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.WriteTogetherElemDecoder
 * JD-Core Version:    0.7.0.1
 */