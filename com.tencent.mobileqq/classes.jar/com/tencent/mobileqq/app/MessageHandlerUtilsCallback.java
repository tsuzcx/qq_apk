package com.tencent.mobileqq.app;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade.HongbaoParams;
import com.tencent.mobileqq.bubble.BubbleConfig;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.message.TinyMsgCodec;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_svc.MultiMsgAssist;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.babyq.babyq_cookie.BabyQCookie;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;

public class MessageHandlerUtilsCallback
  implements MessageHandlerUtils.Callback
{
  public long a(long paramLong, msg_comm.UinPairMsg paramUinPairMsg, AppInterface paramAppInterface)
  {
    return TinyMsgCodec.a(paramLong, paramUinPairMsg, paramAppInterface);
  }
  
  public String a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    String str = paramAppInterface.getCurrentAccountUin();
    if ((str != null) && (str.equals(paramString1))) {
      return HardCodeUtil.a(2131706657);
    }
    paramString2 = ContactUtils.a((QQAppInterface)paramAppInterface, paramString1, paramString2, 1, 0);
    if (paramString2 == paramString1)
    {
      paramAppInterface = ((FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1);
      if (paramAppInterface != null) {
        return ContactUtils.a(paramAppInterface);
      }
    }
    return paramString2;
  }
  
  public void a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    int i = paramPbSendMsgReq.toByteArray().length;
    Object localObject = (ISVIPHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
    int j = ((ISVIPHandler)localObject).d();
    paramAppInterface = (BubbleManager)paramAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    int k = ((ISVIPHandler)localObject).b();
    boolean bool2 = false;
    boolean bool1;
    if (k > 0)
    {
      paramAppInterface = paramAppInterface.a(k, false);
      if (paramAppInterface != null)
      {
        bool1 = bool2;
        if (paramAppInterface != null)
        {
          bool1 = bool2;
          if (paramAppInterface.a != null)
          {
            bool1 = bool2;
            if (paramAppInterface.a.size() <= 0) {}
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
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("bubbleId->");
      paramAppInterface.append(k);
      paramAppInterface.append(" needSend->");
      paramAppInterface.append(bool1);
      QLog.d("Q.msg.MessageHandlerUtils", 2, paramAppInterface.toString());
    }
    if ((paramPbSendMsgReq.msg_body.has()) && (((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.has()))
    {
      paramAppInterface = (im_msg_body.RichText)((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.get();
      if ((paramAppInterface.elems != null) && (paramAppInterface.elems.has()))
      {
        paramPbSendMsgReq = new im_msg_body.GeneralFlags();
        new generalflags.ResvAttr();
        bool1 = MessageHandlerUtils.a(paramMessageRecord, i, 7, j, bool1, false, paramPbSendMsgReq);
        if (paramMessageRecord.vipSubBubbleId != 0)
        {
          paramPbSendMsgReq.uint32_bubble_sub_id.set(paramMessageRecord.vipSubBubbleId);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getPbSendReqFromBlessMsg, sub bubbleid: ");
            ((StringBuilder)localObject).append(paramMessageRecord.vipSubBubbleId);
            QLog.i("Q.msg.MessageHandlerUtils", 2, ((StringBuilder)localObject).toString());
          }
          bool1 = true;
        }
        if (bool1)
        {
          paramMessageRecord = new im_msg_body.Elem();
          paramMessageRecord.general_flags.set(paramPbSendMsgReq);
          paramAppInterface.elems.get().add(paramMessageRecord);
        }
      }
    }
  }
  
  public void a(Object paramObject, msg_svc.MultiMsgAssist paramMultiMsgAssist)
  {
    if ((paramObject != null) && ((paramObject instanceof ChatActivityFacade.HongbaoParams)))
    {
      paramObject = (ChatActivityFacade.HongbaoParams)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, String.format("getPbSendReqFromBlessMsg, hongbao param, temp_id: %d, video_len: %d, redbag_id: %s, redbag_amount: %d, has_readbag: %d, has_video: %d", new Object[] { Long.valueOf(paramObject.jdField_a_of_type_Long), Long.valueOf(paramObject.jdField_b_of_type_Long), paramObject.jdField_a_of_type_ArrayOfByte, Long.valueOf(paramObject.c), Integer.valueOf(paramObject.jdField_a_of_type_Int), Integer.valueOf(paramObject.jdField_b_of_type_Int) }));
      }
      paramMultiMsgAssist.uint64_temp_id.set(paramObject.jdField_a_of_type_Long);
      paramMultiMsgAssist.uint64_vedio_len.set(paramObject.jdField_b_of_type_Long);
      paramMultiMsgAssist.uint32_has_readbag.set(paramObject.jdField_a_of_type_Int);
      if (paramObject.jdField_a_of_type_Int == 1)
      {
        if (paramObject.jdField_a_of_type_ArrayOfByte != null) {
          paramMultiMsgAssist.bytes_redbag_id.set(ByteStringMicro.copyFrom(paramObject.jdField_a_of_type_ArrayOfByte));
        }
        paramMultiMsgAssist.uint64_redbag_amount.set(paramObject.c);
      }
      paramMultiMsgAssist.uint32_has_vedio.set(paramObject.jdField_b_of_type_Int);
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord instanceof MessageForFoldMsg;
  }
  
  public boolean a(MessageRecord paramMessageRecord, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    try
    {
      if ("babyq_set_avator".equals(paramMessageRecord.msg))
      {
        paramMessageRecord = new babyq_cookie.BabyQCookie();
        paramMessageRecord.uint32_type.set(201);
        paramGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramMessageRecord.toByteArray()));
      }
      else if ("babyq_add_friend".equals(paramMessageRecord.msg))
      {
        paramMessageRecord = new babyq_cookie.BabyQCookie();
        paramMessageRecord.uint32_type.set(202);
        paramGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramMessageRecord.toByteArray()));
      }
      else if ("babyq_add_troop".equals(paramMessageRecord.msg))
      {
        paramMessageRecord = new babyq_cookie.BabyQCookie();
        paramMessageRecord.uint32_type.set(203);
        paramGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramMessageRecord.toByteArray()));
      }
      else if ("babyq_game_strategy".equals(paramMessageRecord.msg))
      {
        paramMessageRecord = new babyq_cookie.BabyQCookie();
        paramMessageRecord.uint32_type.set(204);
        paramMessageRecord.uint32_user_click.set(1);
        paramGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramMessageRecord.toByteArray()));
      }
      else if ("babyq_game_gift".equals(paramMessageRecord.msg))
      {
        paramMessageRecord = new babyq_cookie.BabyQCookie();
        paramMessageRecord.uint32_type.set(205);
        paramMessageRecord.uint32_user_click.set(1);
        paramGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramMessageRecord.toByteArray()));
      }
      else if ("babyq_game_tribe".equals(paramMessageRecord.msg))
      {
        paramMessageRecord = new babyq_cookie.BabyQCookie();
        paramMessageRecord.uint32_type.set(206);
        paramMessageRecord.uint32_user_click.set(1);
        paramGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramMessageRecord.toByteArray()));
      }
      else if ("baqyq_mayknow_people".equals(paramMessageRecord.msg))
      {
        paramMessageRecord = new babyq_cookie.BabyQCookie();
        paramMessageRecord.uint32_type.set(207);
        paramMessageRecord.uint32_user_click.set(1);
        paramGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(paramMessageRecord.toByteArray()));
      }
      else
      {
        byte[] arrayOfByte = Utils.a(paramMessageRecord.msg);
        if (arrayOfByte != null) {
          paramGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
        }
        if (QLog.isColorLevel())
        {
          paramGeneralFlags = new StringBuilder();
          paramGeneralFlags.append("getGeneralFlagElem, guideMsgCookie: ");
          paramGeneralFlags.append(paramMessageRecord.msg);
          paramGeneralFlags.append(" ,bytes:");
          paramGeneralFlags.append(Arrays.toString(arrayOfByte));
          QLog.d("Q.msg.MessageHandlerUtils", 2, paramGeneralFlags.toString());
        }
      }
      return false;
    }
    catch (Exception paramMessageRecord)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "set guideMsgCookie error!", paramMessageRecord);
      }
    }
    return true;
  }
  
  public Object[] a(MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt)
  {
    int i;
    if (paramMessageRecord.msgtype == -1000)
    {
      paramMessageRecord = (MessageForText)paramMessageRecord;
      paramRichText = MessageProtoCodec.a(paramMessageRecord);
      i = paramMessageRecord.msgVia;
    }
    else if (paramMessageRecord.msgtype == -2022)
    {
      paramRichText = MessageProtoCodec.a((MessageForShortVideo)paramMessageRecord);
      i = paramInt;
    }
    else
    {
      i = paramInt;
      if (paramMessageRecord.msgtype == -2000)
      {
        paramRichText = MessageProtoCodec.a((MessageForPic)paramMessageRecord);
        i = paramInt;
      }
    }
    return new Object[] { paramRichText, Integer.valueOf(i) };
  }
  
  public boolean b(MessageRecord paramMessageRecord)
  {
    AppInterface localAppInterface = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool3 = localAppInterface instanceof QQAppInterface;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (paramMessageRecord.extraflag != 32768)
      {
        bool1 = bool2;
        if (!((QQAppInterface)localAppInterface).getMsgCache().b(paramMessageRecord)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageHandlerUtilsCallback
 * JD-Core Version:    0.7.0.1
 */