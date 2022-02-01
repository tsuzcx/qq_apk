package com.tencent.biz.pubaccount.util;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

class ShareStructLongMessageManager$1
  implements UpCallBack
{
  ShareStructLongMessageManager$1(ShareStructLongMessageManager paramShareStructLongMessageManager, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, MessageObserver paramMessageObserver, boolean paramBoolean) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    try
    {
      Object localObject1;
      if (paramSendResult.jdField_a_of_type_Int == 0)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof MessageForStructing))
        {
          localObject1 = (MessageForStructing)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
          Object localObject2 = ((MessageForStructing)localObject1).richText;
          Object localObject3;
          Object localObject4;
          if (localObject2 == null)
          {
            localObject2 = MessageProtoCodec.a((MessageForStructing)localObject1);
            if (localObject2 != null)
            {
              localObject3 = ((im_msg_body.RichText)localObject2).elems.get();
              if (QLog.isColorLevel())
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("current uid is");
                ((StringBuilder)localObject4).append(paramSendResult.c);
                QLog.d("ShareStructLongMessageManager", 2, ((StringBuilder)localObject4).toString());
              }
              localObject3 = ((List)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                localObject4 = (im_msg_body.Elem)((Iterator)localObject3).next();
                if (((im_msg_body.Elem)localObject4).rich_msg.has())
                {
                  ((im_msg_body.Elem)localObject4).rich_msg.bytes_msg_resid.set(ByteStringMicro.copyFrom(paramSendResult.c.getBytes()));
                  ((im_msg_body.Elem)localObject4).rich_msg.bytes_template_1.set(ByteStringMicro.EMPTY);
                }
                else if ((((im_msg_body.Elem)localObject4).text.has()) && (((im_msg_body.Elem)localObject4).text.str.has()))
                {
                  String str = ((im_msg_body.Elem)localObject4).text.str.get().toStringUtf8();
                  if (str.length() > 500)
                  {
                    str = str.substring(0, 500);
                    ((im_msg_body.Elem)localObject4).text.str.set(ByteStringMicro.copyFromUtf8(str));
                  }
                }
              }
              ((MessageForStructing)localObject1).richText = ((im_msg_body.RichText)localObject2);
            }
          }
          else
          {
            localObject2 = ((MessageForStructing)localObject1).richText.elems.get();
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("current uid is");
              ((StringBuilder)localObject3).append(paramSendResult.c);
              QLog.d("ShareStructLongMessageManager", 2, ((StringBuilder)localObject3).toString());
            }
            if ((localObject2 != null) && (ShareStructLongMessageManager.b(((MessageForStructing)localObject1).structingMsg)))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject3 = (im_msg_body.Elem)((Iterator)localObject2).next();
                if (((im_msg_body.Elem)localObject3).rich_msg.has())
                {
                  ((im_msg_body.Elem)localObject3).rich_msg.bytes_msg_resid.set(ByteStringMicro.copyFrom(paramSendResult.c.getBytes()));
                  ((im_msg_body.Elem)localObject3).rich_msg.bytes_template_1.set(ByteStringMicro.EMPTY);
                  ((im_msg_body.Elem)localObject3).rich_msg.uint32_service_id.set(((MessageForStructing)localObject1).structingMsg.mMsgServiceID);
                }
                else if ((((im_msg_body.Elem)localObject3).text.has()) && (((im_msg_body.Elem)localObject3).text.str.has()))
                {
                  localObject4 = ((im_msg_body.Elem)localObject3).text.str.get().toStringUtf8();
                  if (((String)localObject4).length() > 500)
                  {
                    localObject4 = ((String)localObject4).substring(0, 500);
                    ((im_msg_body.Elem)localObject3).text.str.set(ByteStringMicro.copyFromUtf8((String)localObject4));
                  }
                }
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver, this.jdField_a_of_type_Boolean);
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("upload  msg pack failed, result.errStr=");
          ((StringBuilder)localObject1).append(paramSendResult.b);
          ((StringBuilder)localObject1).append(",result.errStr=");
          ((StringBuilder)localObject1).append(paramSendResult.jdField_a_of_type_JavaLangString);
          QLog.d("ShareStructLongMessageManager", 2, ((StringBuilder)localObject1).toString());
        }
        this.jdField_a_of_type_ComTencentBizPubaccountUtilShareStructLongMessageManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        return;
      }
    }
    catch (Exception paramSendResult)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShareStructLongMessageManager", 2, "upload  msg pack failed, catch exception", paramSendResult);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountUtilShareStructLongMessageManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ShareStructLongMessageManager.1
 * JD-Core Version:    0.7.0.1
 */