package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class BubbleMsgGeneralFlagProvider
  implements IGeneralFlagProvider
{
  private boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, boolean paramBoolean, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (paramPbSendMsgReq != null)
    {
      int i = paramPbSendMsgReq.toByteArray().length;
      paramQQAppInterface = (ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
      int j = paramQQAppInterface.d();
      int k = paramQQAppInterface.b();
      boolean bool2 = false;
      boolean bool1;
      if (k > 0)
      {
        paramQQAppInterface = localBubbleManager.a(k, false);
        if (paramQQAppInterface != null)
        {
          bool1 = bool2;
          if (paramQQAppInterface != null)
          {
            bool1 = bool2;
            if (paramQQAppInterface.a != null)
            {
              bool1 = bool2;
              if (paramQQAppInterface.a.size() <= 0) {}
            }
          }
        }
        else
        {
          bool1 = true;
        }
      }
      else
      {
        bool1 = false;
      }
      if (QLog.isColorLevel())
      {
        paramQQAppInterface = new StringBuilder();
        paramQQAppInterface.append("bubbleId->");
        paramQQAppInterface.append(k);
        paramQQAppInterface.append(" needSend->");
        paramQQAppInterface.append(bool1);
        QLog.d("Q.msg.MessageHandlerUtils", 2, paramQQAppInterface.toString());
      }
      paramBoolean = a(paramMessageRecord, paramPbSendMsgReq, paramBoolean, paramGeneralFlags, i, 7, j, bool1);
      if (paramMessageRecord.vipSubBubbleId != 0)
      {
        if (QLog.isColorLevel())
        {
          paramQQAppInterface = new StringBuilder();
          paramQQAppInterface.append("getGeneralFlagElemFromMsg, sub bubbleid: ");
          paramQQAppInterface.append(paramMessageRecord.vipSubBubbleId);
          QLog.i("Q.msg.MessageHandlerUtils", 2, paramQQAppInterface.toString());
        }
        paramGeneralFlags.uint32_bubble_sub_id.set(paramMessageRecord.vipSubBubbleId);
        return true;
      }
      return paramBoolean;
    }
    return paramBoolean;
  }
  
  private boolean a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, boolean paramBoolean1, im_msg_body.GeneralFlags paramGeneralFlags, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    boolean bool = paramBoolean1;
    if (paramBoolean2) {
      if (paramInt3 > 0)
      {
        bool = paramBoolean1;
        if (paramInt1 + paramInt2 < paramInt3)
        {
          bool = paramBoolean1;
          if (paramInt3 <= 0) {}
        }
      }
      else
      {
        bool = paramBoolean1;
        if (paramMessageRecord.vipBubbleDiyTextId > 0)
        {
          bool = paramBoolean1;
          if (paramPbSendMsgReq.msg_body.has())
          {
            bool = paramBoolean1;
            if (((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.has())
            {
              paramPbSendMsgReq = (im_msg_body.RichText)((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.get();
              bool = paramBoolean1;
              if (paramPbSendMsgReq.elems != null)
              {
                bool = paramBoolean1;
                if (paramPbSendMsgReq.elems.has())
                {
                  paramBoolean1 = true;
                  paramGeneralFlags.uint32_bubble_diy_text_id.set(paramMessageRecord.vipBubbleDiyTextId);
                  bool = paramBoolean1;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("Q.msg.MessageHandlerUtils", 2, "add BubbleDiyTextId!");
                    bool = paramBoolean1;
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool;
  }
  
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    return new boolean[] { a((QQAppInterface)paramAppInterface, paramMessageRecord, paramPbSendMsgReq, paramBoolean1, paramGeneralFlags), paramBoolean2 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.BubbleMsgGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */