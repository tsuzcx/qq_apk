package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ShakeWindow;

public class ShakeWindowElemDecoder
  extends SimplePBElemDecoder
{
  private void a(List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramList = (im_msg_body.Elem)((Iterator)localObject).next();
      if (paramList.shake_window.has()) {
        break label44;
      }
    }
    paramList = null;
    label44:
    if (paramList == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      paramStringBuilder.append("elemType:ShakeWindow;\n");
    }
    paramList = (im_msg_body.ShakeWindow)paramList.shake_window.get();
    localObject = (MessageForShakeWindow)MessageRecordFactory.a(-2020);
    ((MessageForShakeWindow)localObject).msgtype = -2020;
    ((MessageForShakeWindow)localObject).msg = "[Shake Window]";
    ShakeWindowMsg localShakeWindowMsg = new ShakeWindowMsg();
    localShakeWindowMsg.mType = paramList.uint32_type.get();
    localShakeWindowMsg.mReserve = paramList.uint32_reserve.get();
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    localShakeWindowMsg.onlineFlag = i;
    localShakeWindowMsg.shake = true;
    ((MessageForShakeWindow)localObject).msgData = localShakeWindowMsg.getBytes();
    if (((MessageForShakeWindow)localObject).msgData == null)
    {
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("c2cMsgContent.data:null;\n");
      }
    }
    else {
      paramList1.add(localObject);
    }
  }
  
  public int a()
  {
    return 1000;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    a(paramList, paramList1, paramStringBuilder, paramBoolean1);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.shake_window.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.ShakeWindowElemDecoder
 * JD-Core Version:    0.7.0.1
 */