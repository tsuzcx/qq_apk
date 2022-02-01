package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class GoldMsgElemDecoder
  extends SimplePBElemDecoder
{
  public int a()
  {
    return -1000;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return (paramElem.common_elem.has()) && (18 == paramElem.common_elem.uint32_service_type.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.GoldMsgElemDecoder
 * JD-Core Version:    0.7.0.1
 */