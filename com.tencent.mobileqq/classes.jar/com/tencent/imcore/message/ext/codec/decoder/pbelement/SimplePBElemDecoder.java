package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.imcore.message.core.codec.IPBMsgElemDecoder;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.Elem;

public class SimplePBElemDecoder
  implements IPBMsgElemDecoder
{
  public int a()
  {
    return 0;
  }
  
  public void a(List<IPBMsgElemDecoder> paramList) {}
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    return false;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.SimplePBElemDecoder
 * JD-Core Version:    0.7.0.1
 */