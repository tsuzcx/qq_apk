package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MarketFace;

public class MarketFaceElemDecoder
  extends SimplePBElemDecoder
{
  public int a()
  {
    return super.a() + 5;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    new MessagePBElemDecoder().a(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo, paramBoolean2);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return paramElem.market_face.has();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.MarketFaceElemDecoder
 * JD-Core Version:    0.7.0.1
 */