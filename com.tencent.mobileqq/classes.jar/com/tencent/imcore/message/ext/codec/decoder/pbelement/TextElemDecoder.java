package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder;
import com.tencent.mobileqq.service.message.TempSessionInfo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.OnlineImage;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.Text;

public class TextElemDecoder
  extends SimplePBElemDecoder
{
  public static Boolean b(im_msg_body.Elem paramElem)
  {
    boolean bool2 = paramElem.text.has();
    boolean bool1 = true;
    if ((!bool2) && (!paramElem.face.has()) && (!paramElem.small_emoji.has()) && (!paramElem.online_image.has()) && (!paramElem.bankcode_ctrl_info.has()))
    {
      if (paramElem.common_elem.has())
      {
        if (33 != paramElem.common_elem.uint32_service_type.get()) {
          bool1 = false;
        }
        return Boolean.valueOf(bool1);
      }
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public int a()
  {
    return -1;
  }
  
  public boolean a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    new MessagePBElemDecoder().h(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
    return true;
  }
  
  public boolean a(im_msg_body.Elem paramElem)
  {
    return b(paramElem).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.pbelement.TextElemDecoder
 * JD-Core Version:    0.7.0.1
 */