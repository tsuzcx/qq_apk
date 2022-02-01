package com.tencent.mobileqq.app.pbsendhandler;

import android.text.TextUtils;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.message.TinyMsgCodec;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichText;

public class AnonymousMsgPbSendReqHandler
  implements IPbSendReqHandler
{
  private void a(QQAppInterface paramQQAppInterface, FriendsManager paramFriendsManager, im_msg_body.PubGroup paramPubGroup)
  {
    for (;;)
    {
      String str;
      try
      {
        str = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramQQAppInterface.getCurrentAccountUin(), "self_nick", "");
        i = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramQQAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
        int j = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(paramQQAppInterface.getCurrentAccountUin(), "self_age", Integer.valueOf(-1))).intValue();
        if (j >= 0) {
          if (i >= 0) {
            break label248;
          }
        }
        Friends localFriends = paramFriendsManager.m(paramQQAppInterface.getCurrentAccountUin());
        j = 0;
        i = 0;
        if (localFriends != null)
        {
          j = localFriends.age;
          if (localFriends.gender == 2) {
            i = 1;
          } else {
            if (localFriends.gender != 1) {
              break label260;
            }
          }
          paramQQAppInterface = localFriends.name;
        }
        else
        {
          paramQQAppInterface = paramFriendsManager.f(paramQQAppInterface.getCurrentAccountUin());
          if (paramQQAppInterface == null) {
            break label266;
          }
          j = paramQQAppInterface.age;
          i = paramQQAppInterface.shGender;
          paramQQAppInterface = paramQQAppInterface.strNick;
        }
        if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
          paramPubGroup.bytes_nickname.set(ByteStringMicro.copyFrom(paramQQAppInterface.getBytes()));
        }
        paramPubGroup.uint32_age.set(j);
        paramPubGroup.uint32_gender.set(i);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      label248:
      i -= 1;
      paramQQAppInterface = str;
      continue;
      label260:
      int i = 2;
      continue;
      label266:
      i = 2;
      paramQQAppInterface = str;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    if (AnonymousChatHelper.c(paramMessageRecord))
    {
      a(paramMessageRecord, paramRichText);
      return;
    }
    Object localObject1;
    if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 1026))
    {
      if ((paramMessageRecord.istroop != 1033) && (paramMessageRecord.istroop != 1034))
      {
        if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_frd_chat_confess_info")))
        {
          paramQQAppInterface = ConfessMsgUtil.a(paramMessageRecord);
          if (paramQQAppInterface != null) {
            paramRichText.elems.add(paramQQAppInterface);
          }
          if (QLog.isColorLevel())
          {
            paramMessageRecord = new StringBuilder();
            paramMessageRecord.append("bindC2CFirstMsgConfessInfoElem elem:");
            paramMessageRecord.append(paramQQAppInterface);
            QLog.i("Q.confess", 2, paramMessageRecord.toString());
          }
        }
        else if (paramMessageRecord.istroop == 10007)
        {
          localObject1 = new im_msg_body.Elem();
          TinyMsgCodec.a((im_msg_body.Elem)localObject1, paramMessageRecord, paramQQAppInterface);
          paramRichText.elems.add((MessageMicro)localObject1);
          if (QLog.isColorLevel()) {
            QLog.i("Q.confess", 2, "bindTinyInfoElem");
          }
        }
      }
      else
      {
        paramQQAppInterface = new im_msg_body.Elem();
        ConfessMsgUtil.a(paramQQAppInterface, paramMessageRecord);
        paramRichText.elems.add(paramQQAppInterface);
        if (QLog.isColorLevel()) {
          QLog.i("Q.confess", 2, "bindConfessInfoElem");
        }
      }
    }
    else
    {
      localObject1 = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject2 = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      b(paramMessageRecord, paramRichText);
      localObject2 = ((HotChatManager)localObject2).c(paramMessageRecord.frienduin);
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((localObject2 != null) || (localTroopManager.s(paramMessageRecord.frienduin)))
      {
        localObject2 = new im_msg_body.PubGroup();
        a(paramQQAppInterface, (FriendsManager)localObject1, (im_msg_body.PubGroup)localObject2);
        localObject1 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject1).pub_group.set((MessageMicro)localObject2);
        paramRichText.elems.add((MessageMicro)localObject1);
        b(paramQQAppInterface, paramMessageRecord, paramRichText);
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    im_msg_body.AnonymousGroupMsg localAnonymousGroupMsg = new im_msg_body.AnonymousGroupMsg();
    AnonymousChatHelper.AnonymousExtInfo localAnonymousExtInfo = AnonymousChatHelper.g(paramMessageRecord);
    localAnonymousGroupMsg.uint32_flags.set(localAnonymousExtInfo.a);
    if (!TextUtils.isEmpty(localAnonymousExtInfo.b)) {
      localAnonymousGroupMsg.str_anon_id.set(ByteStringMicro.copyFrom(localAnonymousExtInfo.b.getBytes()));
    }
    if (!TextUtils.isEmpty(localAnonymousExtInfo.c)) {
      localAnonymousGroupMsg.str_anon_nick.set(ByteStringMicro.copyFrom(localAnonymousExtInfo.c.getBytes()));
    }
    localAnonymousGroupMsg.uint32_head_portrait.set(localAnonymousExtInfo.d);
    localAnonymousGroupMsg.uint32_expire_time.set(localAnonymousExtInfo.e);
    if (!TextUtils.isEmpty(localAnonymousExtInfo.f)) {
      localAnonymousGroupMsg.str_rank_color.set(ByteStringMicro.copyFrom(localAnonymousExtInfo.f.getBytes()));
    }
    localAnonymousGroupMsg.uint32_bubble_id.set((int)paramMessageRecord.vipBubbleID);
    localElem.anon_group_msg.set(localAnonymousGroupMsg);
    paramRichText.elems.add(localElem);
  }
  
  private void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    paramQQAppInterface = HotChatManager.a(paramQQAppInterface, paramMessageRecord);
    if (paramQQAppInterface != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("carry authElem:");
        localStringBuilder.append(paramQQAppInterface.near_by_msg.uint32_identify_type.get());
        QLog.d("Q.hotchat", 2, localStringBuilder.toString());
      }
      if (paramMessageRecord.msgtype == -2011)
      {
        paramMessageRecord = paramRichText.elems.get();
        paramMessageRecord.add(0, paramQQAppInterface);
        paramRichText.elems.set(paramMessageRecord);
        return;
      }
      paramRichText.elems.add(paramQQAppInterface);
    }
  }
  
  private void b(MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_group_chat_confess_info")))
    {
      paramMessageRecord = ConfessMsgUtil.e(paramMessageRecord);
      if (paramMessageRecord != null) {
        paramRichText.elems.add(paramMessageRecord);
      }
      if (QLog.isColorLevel())
      {
        paramRichText = new StringBuilder();
        paramRichText.append("bindGroupFirstMsgConfessInfoElem elem:");
        paramRichText.append(paramMessageRecord);
        QLog.i("Q.confess", 2, paramRichText.toString());
      }
    }
  }
  
  public msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    a((QQAppInterface)paramAppInterface, paramMessageRecord, paramRichText);
    return paramPbSendMsgReq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.pbsendhandler.AnonymousMsgPbSendReqHandler
 * JD-Core Version:    0.7.0.1
 */