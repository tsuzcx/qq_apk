package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype31;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class ShareLocationElemDecoder
  extends SimplePBElemDecoder
{
  public static void a(QQAppInterface paramQQAppInterface, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean, MessageInfo paramMessageInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("elems = [");
      localStringBuilder.append(paramList);
      localStringBuilder.append("], msgRecords = [");
      localStringBuilder.append(paramList1);
      localStringBuilder.append("], logBuilder = [");
      localStringBuilder.append(paramStringBuilder);
      localStringBuilder.append("], msg = [");
      localStringBuilder.append(paramMsg);
      localStringBuilder.append("]");
      QLog.d("ShareLocationElemDecoder", 2, new Object[] { "decodePBMsgElems_LbsShareMsg: invoked. ", localStringBuilder.toString() });
    }
    if ((paramList != null) && (paramList.size() != 0))
    {
      if (paramBoolean)
      {
        if (paramQQAppInterface.getLongAccountUin() == paramMsg.msg_head.to_uin.get())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(paramMsg.msg_head.from_uin.get());
          paramQQAppInterface.append("");
          paramQQAppInterface = paramQQAppInterface.toString();
        }
        else
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append(paramMsg.msg_head.to_uin.get());
          paramQQAppInterface.append("");
          paramQQAppInterface = paramQQAppInterface.toString();
        }
      }
      else if (paramMessageInfo != null)
      {
        paramQQAppInterface = paramMessageInfo.a;
      }
      else
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(paramMsg.msg_head.to_uin.get());
        paramQQAppInterface.append("");
        paramQQAppInterface = paramQQAppInterface.toString();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramMsg = (im_msg_body.Elem)paramList.next();
        if ((paramMsg.common_elem.has()) && (paramMsg.common_elem.uint32_service_type.get() == 31) && (paramMsg.common_elem.bytes_pb_elem.has())) {
          try
          {
            new hummer_commelem.MsgElemInfo_servtype31().mergeFrom(paramMsg.common_elem.bytes_pb_elem.get().toByteArray());
          }
          catch (InvalidProtocolBufferMicroException paramMsg)
          {
            QLog.e("ShareLocationElemDecoder", 1, "decodePBMsgElems_LbsShareMsg: failed. ", paramMsg);
          }
        }
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:LbsShareMsg;\n");
      }
      paramList = (MessageForLocationShare)MessageRecordFactory.a(-2076);
      paramList.msgtype = -2076;
      paramList.msg = BaseApplication.getContext().getString(2131916759);
      paramList.isSharingLocation = true;
      paramList.frienduin = paramQQAppInterface;
      paramList.parse();
      paramList1.add(paramList);
      if (QLog.isColorLevel())
      {
        paramStringBuilder.append("LbsShareMsg.msg: ");
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append(paramList.toString());
        paramQQAppInterface.append("\n");
        paramStringBuilder.append(paramQQAppInterface.toString());
        paramStringBuilder.append("\n");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ShareLocationElemDecoder", 2, "decodePBMsgElems_LbsShareMsg msg decode failed");
    }
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramList, paramList1, paramStringBuilder, paramMsg, paramBoolean2, paramMessageInfo);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (31 == paramElem.common_elem.uint32_service_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.ShareLocationElemDecoder
 * JD-Core Version:    0.7.0.1
 */