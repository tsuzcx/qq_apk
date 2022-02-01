package com.tencent.imcore.message;

import com.tencent.imcore.message.messageprocessor.LastC2CBubbleID;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.QMessageProtoCodec;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SecretFileMsg;

public class DecodeC2CMsgPkgBubbleID
{
  public static int a(msg_comm.Msg paramMsg)
  {
    paramMsg = QMessageProtoCodec.a(paramMsg);
    if ((paramMsg != null) && (paramMsg.uint32_bubble_diy_text_id.has()))
    {
      int i = paramMsg.uint32_bubble_diy_text_id.get();
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder();
        paramMsg.append("decodeC2CMsgPkg_BubbleDiyTextID->");
        paramMsg.append(i);
        QLog.d("DecodeC2CMsgPkgBubbleID", 2, paramMsg.toString());
      }
      return i;
    }
    return 0;
  }
  
  public static long a(BaseMessageHandler paramBaseMessageHandler, msg_comm.Msg paramMsg, String paramString1, String paramString2)
  {
    if (paramMsg.msg_body.has())
    {
      if (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) {
        return 0L;
      }
      paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      long l1 = -1L;
      if (paramMsg.hasNext())
      {
        Object localObject = (im_msg_body.Elem)paramMsg.next();
        if ((((im_msg_body.Elem)localObject).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.has())) {}
        for (int i = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.get();; i = ((im_msg_body.ElemFlags2)((im_msg_body.SecretFileMsg)localObject).elem_flags2.get()).uint32_color_text_id.get())
        {
          l1 = i & 0xFFFFFFFF;
          break;
          if (!((im_msg_body.Elem)localObject).secret_file.has()) {
            break;
          }
          localObject = ((im_msg_body.Elem)localObject).secret_file;
          if ((!((im_msg_body.SecretFileMsg)localObject).elem_flags2.has()) || (!((im_msg_body.SecretFileMsg)localObject).elem_flags2.uint32_color_text_id.has())) {
            break;
          }
        }
      }
      long l2;
      if (l1 == 4294967295L) {
        l2 = LastC2CBubbleID.a(paramBaseMessageHandler.a(), paramString1, paramString2);
      } else {
        l2 = -1L;
      }
      if (l1 != 4294967295L) {
        l2 = l1;
      }
      l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      return l1;
    }
    return 0L;
  }
  
  public static int b(msg_comm.Msg paramMsg)
  {
    paramMsg = QMessageProtoCodec.a(paramMsg);
    if ((paramMsg != null) && (paramMsg.uint32_bubble_sub_id.has()))
    {
      int i = paramMsg.uint32_bubble_sub_id.get();
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder();
        paramMsg.append("decodeC2CMsgPkg_SubBubbleID->");
        paramMsg.append(i);
        QLog.d("DecodeC2CMsgPkgBubbleID", 2, paramMsg.toString());
      }
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.DecodeC2CMsgPkgBubbleID
 * JD-Core Version:    0.7.0.1
 */