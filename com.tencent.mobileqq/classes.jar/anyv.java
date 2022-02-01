import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForWantGiftMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgcomm.msg_comm.UinPairMsg;
import msf.msgsvc.msg_ctrl.MsgCtrl;
import msf.msgsvc.msg_svc.C2C;
import msf.msgsvc.msg_svc.MultiMsgAssist;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import org.json.JSONObject;
import tencent.im.babyq.babyq_cookie.BabyQCookie;
import tencent.im.cs.ptt_waveform.ptt_waveform.PttWaveform;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype13;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.BlessingMessage;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NearByMessageType;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.oidb.oidb_0xdea.PassThrough;
import tencent.im.qzone.album.UploadParam;

public class anyv
{
  private static ArrayList<Integer> a = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(24), Integer.valueOf(14), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(23), Integer.valueOf(25), Integer.valueOf(26), Integer.valueOf(8), Integer.valueOf(16), Integer.valueOf(17), Integer.valueOf(18), Integer.valueOf(15), Integer.valueOf(19), Integer.valueOf(20), Integer.valueOf(22), Integer.valueOf(28), Integer.valueOf(27), Integer.valueOf(29), Integer.valueOf(31), Integer.valueOf(30), Integer.valueOf(32), Integer.valueOf(33), Integer.valueOf(34) }));
  
  private static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramQQAppInterface.getLongAccountUin();
    if (paramLong1 == l) {
      return paramLong2;
    }
    if (paramLong2 == l) {
      return paramLong1;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.msg.MessageHandlerUtils", 2, "<---decodeC2CMessagePackage: neither fromUin nor toUin is selfUin.use peerUin instead.");
    }
    return paramLong3;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, msg_comm.UinPairMsg paramUinPairMsg)
  {
    return aveb.a(a(paramQQAppInterface, paramLong1, paramLong2, paramLong3), paramUinPairMsg, paramQQAppInterface);
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 4) {
      return 0L;
    }
    return ((paramArrayOfByte[0] & 0xFF) << 24) + ((paramArrayOfByte[1] & 0xFF) << 16) + ((paramArrayOfByte[2] & 0xFF) << 8) + (paramArrayOfByte[3] & 0xFF);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    if ((str != null) && (str.equals(paramString1))) {
      return anvx.a(2131706095);
    }
    paramString2 = ContactUtils.getDisplayName(paramQQAppInterface, paramString1, paramString2, 1, 0);
    if (paramString2 == paramString1)
    {
      paramQQAppInterface = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1);
      if (paramQQAppInterface != null) {
        return ContactUtils.getFriendName(paramQQAppInterface);
      }
    }
    return paramString2;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    Object localObject2 = new anyw(paramQQAppInterface, paramMessageRecord, null, 0).a();
    Object localObject1 = ((anyw)localObject2).a();
    int i = ((anyw)localObject2).a();
    if (localObject1 == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgVia", 2, "send message, entrance: " + i);
    }
    a(paramMessageRecord, (im_msg_body.RichText)localObject1);
    b(paramQQAppInterface, paramMessageRecord, (im_msg_body.RichText)localObject1);
    localObject2 = arxx.a(paramMessageRecord);
    if (localObject2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.nearby_bank", 2, "clearingElem has carry, elem:" + ((im_msg_body.Elem)localObject2).near_by_msg.uint32_type.get());
      }
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
    }
    a(paramQQAppInterface, paramMessageRecord, (im_msg_body.RichText)localObject1);
    a(paramQQAppInterface, paramMessageRecord, (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    localObject1 = bcrx.a(paramQQAppInterface, paramMessageRecord, (im_msg_body.RichText)localObject1, i);
    b(paramMessageRecord, (msg_svc.PbSendMsgReq)localObject1);
    localObject2 = a(paramQQAppInterface, paramMessageRecord, (msg_svc.PbSendMsgReq)localObject1);
    if ((localObject2 != null) && (localObject1 != null))
    {
      im_msg_body.RichText localRichText = (im_msg_body.RichText)((im_msg_body.MsgBody)((msg_svc.PbSendMsgReq)localObject1).msg_body.get()).rich_text.get();
      im_msg_body.Elem localElem = new im_msg_body.Elem();
      localElem.general_flags.set((MessageMicro)localObject2);
      localRichText.elems.get().add(localElem);
    }
    a(paramMessageRecord, (msg_svc.PbSendMsgReq)localObject1);
    a(paramMessageRecord, (msg_svc.PbSendMsgReq)localObject1, paramQQAppInterface);
    return localObject1;
  }
  
  public static msg_svc.PbSendMsgReq a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, ArrayList<String> paramArrayList, adml paramadml)
  {
    boolean bool4 = true;
    Object localObject1;
    int i;
    boolean bool1;
    label69:
    boolean bool2;
    label85:
    boolean bool3;
    if (paramMessageRecord.msgtype == -1000)
    {
      localObject1 = bcrx.a((MessageForText)paramMessageRecord);
      i = ((MessageForText)paramMessageRecord).msgVia;
      if ((localObject1 != null) && (((im_msg_body.RichText)localObject1).elems != null) && (paramArrayList != null) && (paramArrayList.size() != 0)) {
        break label266;
      }
      if (QLog.isColorLevel())
      {
        if (localObject1 != null) {
          break label242;
        }
        bool1 = true;
        if ((localObject1 == null) || (((im_msg_body.RichText)localObject1).elems != null)) {
          break label248;
        }
        bool2 = true;
        if (paramArrayList != null) {
          break label254;
        }
        bool3 = true;
        label92:
        if ((paramArrayList == null) || (paramArrayList.size() != 0)) {
          break label260;
        }
      }
    }
    for (;;)
    {
      QLog.d("Q.msg.MessageHandlerUtils", 2, String.format("getPbSendReqFromBlessMsg, error: %s, %s, %s, %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4) }));
      paramArrayList = null;
      return paramArrayList;
      if (paramMessageRecord.msgtype == -2022)
      {
        localObject1 = bcrx.a((MessageForShortVideo)paramMessageRecord);
        i = 0;
        break;
      }
      if (paramMessageRecord.msgtype == -2000)
      {
        localObject1 = bcrx.a((MessageForPic)paramMessageRecord);
        i = 0;
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "getPbSendReqFromBlessMsg, error msgtype, " + paramMessageRecord.msgtype);
      }
      return null;
      label242:
      bool1 = false;
      break label69;
      label248:
      bool2 = false;
      break label85;
      label254:
      bool3 = false;
      break label92;
      label260:
      bool4 = false;
    }
    label266:
    Object localObject2 = new im_msg_body.Elem();
    im_msg_body.BlessingMessage localBlessingMessage = new im_msg_body.BlessingMessage();
    localBlessingMessage.uint32_msg_type.set(1);
    if (paramMessageRecord.needUpdateMsgTag) {
      localBlessingMessage.uint32_ex_flag.set(1);
    }
    for (;;)
    {
      ((im_msg_body.Elem)localObject2).bless_msg.set(localBlessingMessage);
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
      localObject2 = new im_msg_body.MsgBody();
      ((im_msg_body.MsgBody)localObject2).rich_text.set((MessageMicro)localObject1);
      localObject1 = new msg_svc.MultiMsgAssist();
      ((msg_svc.MultiMsgAssist)localObject1).msg_use.set(1);
      a(paramArrayList, (msg_svc.MultiMsgAssist)localObject1);
      a(paramadml, (msg_svc.MultiMsgAssist)localObject1);
      int j = bcsc.a(paramMessageRecord.msgUid);
      int k = (short)(int)paramMessageRecord.msgseq;
      paramArrayList = paramQQAppInterface.getMsgCache().a();
      paramadml = new msg_svc.PbSendMsgReq();
      paramadml.msg_body.set((MessageMicro)localObject2);
      paramadml.msg_seq.set(k & 0xFFFF);
      paramadml.msg_rand.set(j);
      paramadml.msg_via.set(i);
      paramadml.multi_msg_assist.set((MessageMicro)localObject1);
      if (paramArrayList != null) {
        paramadml.sync_cookie.set(ByteStringMicro.copyFrom(paramArrayList));
      }
      paramArrayList = paramadml;
      if (paramadml == null) {
        break;
      }
      a(paramQQAppInterface, paramMessageRecord, paramadml);
      return paramadml;
      localBlessingMessage.uint32_ex_flag.set(0);
    }
  }
  
  private static im_msg_body.GeneralFlags a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    im_msg_body.GeneralFlags localGeneralFlags = new im_msg_body.GeneralFlags();
    generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
    boolean bool2 = a(false, localResvAttr, paramMessageRecord.getExtInfoFromExtStr(bcrn.jdField_c_of_type_JavaLangString));
    if (paramMessageRecord.msgtype == -1052)
    {
      if (paramMessageRecord.msg != null)
      {
        paramQQAppInterface = localGeneralFlags;
        if (a(paramMessageRecord, localGeneralFlags)) {
          paramQQAppInterface = null;
        }
        return paramQQAppInterface;
      }
      return null;
    }
    boolean bool1 = a(paramQQAppInterface, paramMessageRecord, paramPbSendMsgReq, false, localGeneralFlags);
    boolean bool3;
    Object localObject;
    label167:
    boolean bool4;
    int i;
    if (((paramMessageRecord instanceof MessageForFoldMsg)) && (akqe.a(paramQQAppInterface)))
    {
      bool3 = akqe.b(paramQQAppInterface);
      localObject = (akqe)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
      MessageForFoldMsg localMessageForFoldMsg = (MessageForFoldMsg)paramMessageRecord;
      if ((localMessageForFoldMsg.redBagId != null) && (akqe.b(paramQQAppInterface))) {
        if ((bool3) && (!((akqe)localObject).e))
        {
          bool1 = true;
          a(localGeneralFlags, localResvAttr, bool3, localMessageForFoldMsg, bool1);
          bool1 = true;
          bool2 = true;
          bool3 = bool1;
          bool4 = bool2;
          if (QLog.isColorLevel())
          {
            long l = localMessageForFoldMsg.mPasswdRedBagSender;
            if (!localMessageForFoldMsg.foldFlagTemp) {
              break label550;
            }
            i = 1;
            label198:
            QLog.d("msgFold", 2, String.format("Send, pack foldMsg, senderUin: %d, foldFlag: %s, redBagId: %s", new Object[] { Long.valueOf(l), Integer.valueOf(i), localMessageForFoldMsg.redBagId }));
            QLog.d("msgFold", 2, String.format("Send, send foldMsg, frienduin: %s, msguid: %s, shmsgseq: %s content: %s", new Object[] { localMessageForFoldMsg.frienduin, Long.valueOf(localMessageForFoldMsg.msgUid), Long.valueOf(localMessageForFoldMsg.shmsgseq), localMessageForFoldMsg.getLogColorContent() }));
            bool4 = bool2;
            bool3 = bool1;
          }
        }
      }
    }
    for (;;)
    {
      bool2 = f(paramMessageRecord, bool3, localResvAttr);
      bool1 = a(paramMessageRecord, bool4, localGeneralFlags);
      localObject = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramQQAppInterface.getCurrentUin());
      if (localObject != null)
      {
        localGeneralFlags.uint64_pendant_id.set(((ExtensionInfo)localObject).pendantId);
        bool1 = true;
        localResvAttr.uint32_mobile_custom_font.set(gb.a((ExtensionInfo)localObject));
        a(localResvAttr, (ExtensionInfo)localObject, paramMessageRecord.getExtInfoFromExtStr("vip_sub_font_id"));
        bool2 = true;
        a(localResvAttr, (ExtensionInfo)localObject);
      }
      for (;;)
      {
        for (;;)
        {
          bool2 = c(paramMessageRecord, bool2, localResvAttr);
          localObject = paramMessageRecord.getExtInfoFromExtStr("robot_news_class_id");
          try
          {
            localResvAttr.uint32_bot_message_class_id.set(Integer.parseInt((String)localObject));
            label430:
            localObject = paramMessageRecord.getExtInfoFromExtStr("key_message_extra_info_flag");
            a(localResvAttr, (String)localObject, a((String)localObject));
            bool2 = e(paramMessageRecord, a(paramQQAppInterface, paramMessageRecord, a(paramMessageRecord, b(paramMessageRecord, a(paramQQAppInterface, paramMessageRecord, paramPbSendMsgReq, bool2, localResvAttr), localResvAttr), localResvAttr), localResvAttr), localResvAttr);
            a(paramMessageRecord, localResvAttr);
            c(paramMessageRecord, localResvAttr);
            b(paramMessageRecord, localResvAttr);
            if (d(paramMessageRecord, bool2, localResvAttr))
            {
              bool1 = true;
              localGeneralFlags.bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
            }
            if (bool1) {}
            for (;;)
            {
              return localGeneralFlags;
              bool1 = false;
              break;
              label550:
              i = 0;
              break label198;
              localGeneralFlags = null;
            }
          }
          catch (Exception localException)
          {
            break label430;
          }
        }
      }
      bool3 = bool1;
      bool1 = bool2;
      bool2 = bool3;
      break label167;
      bool3 = bool2;
      bool4 = bool1;
    }
  }
  
  private static void a(adml paramadml, msg_svc.MultiMsgAssist paramMultiMsgAssist)
  {
    if (paramadml != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, String.format("getPbSendReqFromBlessMsg, hongbao param, temp_id: %d, video_len: %d, redbag_id: %s, redbag_amount: %d, has_readbag: %d, has_video: %d", new Object[] { Long.valueOf(paramadml.jdField_a_of_type_Long), Long.valueOf(paramadml.jdField_b_of_type_Long), paramadml.jdField_a_of_type_ArrayOfByte, Long.valueOf(paramadml.c), Integer.valueOf(paramadml.jdField_a_of_type_Int), Integer.valueOf(paramadml.jdField_b_of_type_Int) }));
      }
      paramMultiMsgAssist.uint64_temp_id.set(paramadml.jdField_a_of_type_Long);
      paramMultiMsgAssist.uint64_vedio_len.set(paramadml.jdField_b_of_type_Long);
      paramMultiMsgAssist.uint32_has_readbag.set(paramadml.jdField_a_of_type_Int);
      if (paramadml.jdField_a_of_type_Int == 1)
      {
        if (paramadml.jdField_a_of_type_ArrayOfByte != null) {
          paramMultiMsgAssist.bytes_redbag_id.set(ByteStringMicro.copyFrom(paramadml.jdField_a_of_type_ArrayOfByte));
        }
        paramMultiMsgAssist.uint64_redbag_amount.set(paramadml.c);
      }
      paramMultiMsgAssist.uint32_has_vedio.set(paramadml.jdField_b_of_type_Int);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, anvk paramanvk, im_msg_body.PubGroup paramPubGroup)
  {
    for (;;)
    {
      try
      {
        String str = (String)axqc.a(paramQQAppInterface.getCurrentAccountUin(), "self_nick", String.valueOf(""));
        int j = ((Integer)axqc.a(paramQQAppInterface.getCurrentAccountUin(), "self_gender", Integer.valueOf(-1))).intValue();
        int i = ((Integer)axqc.a(paramQQAppInterface.getCurrentAccountUin(), "self_age", Integer.valueOf(-1))).intValue();
        if ((i < 0) || (j < 0))
        {
          Friends localFriends = paramanvk.e(paramQQAppInterface.getCurrentAccountUin());
          if (localFriends != null)
          {
            i = localFriends.age;
            if (localFriends.gender == 2)
            {
              j = 1;
              paramQQAppInterface = localFriends.name;
              if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
                paramPubGroup.bytes_nickname.set(ByteStringMicro.copyFrom(paramQQAppInterface.getBytes()));
              }
              paramPubGroup.uint32_age.set(i);
              paramPubGroup.uint32_gender.set(j);
              return;
            }
            if (localFriends.gender == 1)
            {
              j = 0;
              continue;
            }
          }
          else
          {
            paramQQAppInterface = paramanvk.b(paramQQAppInterface.getCurrentAccountUin());
            if (paramQQAppInterface != null)
            {
              i = paramQQAppInterface.age;
              j = paramQQAppInterface.shGender;
              paramQQAppInterface = paramQQAppInterface.strNick;
              continue;
            }
            j = 2;
            paramQQAppInterface = str;
            i = 0;
            continue;
          }
        }
        else
        {
          j -= 1;
          paramQQAppInterface = str;
          continue;
        }
        j = 2;
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, anvk paramanvk)
  {
    if (paramanvk.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "get kpl global flag");
      }
      paramMessageRecord.saveExtInfoToExtStr("msg_ext_key", "Y");
      paramanvk = paramMessageRecord.frienduin;
      int i = paramMessageRecord.istroop;
      long l = paramMessageRecord.uniseq;
      paramQQAppInterface.getMessageFacade().updateMsgFieldByUniseq(paramanvk, i, l, "extStr", paramMessageRecord.extStr);
      paramQQAppInterface.getMessageFacade().updateMsgFieldByUniseq(paramanvk, i, l, "extLong", Integer.valueOf(paramMessageRecord.extLong));
    }
  }
  
  protected static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    boolean bool2 = true;
    int i = paramPbSendMsgReq.toByteArray().length;
    Object localObject = (aocy)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
    int j = ((aocy)localObject).d();
    paramQQAppInterface = (BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    int k = ((aocy)localObject).b();
    boolean bool1;
    if (k > 0)
    {
      paramQQAppInterface = paramQQAppInterface.a(k, false);
      if ((paramQQAppInterface == null) || ((paramQQAppInterface != null) && (paramQQAppInterface.a != null) && (paramQQAppInterface.a.size() > 0))) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "bubbleId->" + k + " needSend->" + bool1);
      }
      if ((paramPbSendMsgReq.msg_body.has()) && (((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.has()))
      {
        paramQQAppInterface = (im_msg_body.RichText)((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.get();
        if ((paramQQAppInterface.elems != null) && (paramQQAppInterface.elems.has()))
        {
          paramPbSendMsgReq = new im_msg_body.GeneralFlags();
          localObject = new generalflags.ResvAttr();
          bool1 = a(paramMessageRecord, i, 7, j, bool1, false, paramPbSendMsgReq);
          if (paramMessageRecord.vipSubBubbleId != 0)
          {
            paramPbSendMsgReq.uint32_bubble_sub_id.set(paramMessageRecord.vipSubBubbleId);
            if (QLog.isColorLevel()) {
              QLog.i("Q.msg.MessageHandlerUtils", 2, "getPbSendReqFromBlessMsg, sub bubbleid: " + paramMessageRecord.vipSubBubbleId);
            }
            bool1 = true;
          }
          if (!g(paramMessageRecord, false, (generalflags.ResvAttr)localObject)) {
            break label356;
          }
          paramPbSendMsgReq.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((generalflags.ResvAttr)localObject).toByteArray()));
          bool1 = bool2;
        }
      }
      label356:
      for (;;)
      {
        if (bool1)
        {
          paramMessageRecord = new im_msg_body.Elem();
          paramMessageRecord.general_flags.set(paramPbSendMsgReq);
          paramQQAppInterface.elems.get().add(paramMessageRecord);
        }
        return;
        bool1 = false;
        break;
      }
      bool1 = false;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    paramQQAppInterface = (aozr)paramQQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a()) && (paramQQAppInterface.a() == 1L) && ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000)))
    {
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null)
      {
        int i = paramQQAppInterface.systemHeadID;
        int j = paramQQAppInterface.bHeadType;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandlerUtils", 4, new Object[] { Integer.valueOf(2), " QQ 18 aniversary activity send system head id = " + i + ", head flag = " + j });
        }
        paramQQAppInterface = new im_msg_body.Elem();
        paramMessageRecord = new im_msg_body.CommonElem();
        paramMessageRecord.uint32_service_type.set(13);
        hummer_commelem.MsgElemInfo_servtype13 localMsgElemInfo_servtype13 = new hummer_commelem.MsgElemInfo_servtype13();
        localMsgElemInfo_servtype13.uint32_sys_head_id.set(i);
        localMsgElemInfo_servtype13.uint32_head_flag.set(j);
        paramMessageRecord.bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype13.toByteArray()));
        paramQQAppInterface.common_elem.set(paramMessageRecord);
        paramRichText.elems.add(paramQQAppInterface);
      }
    }
  }
  
  private static void a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      if ((paramMessageRecord.msgCtrl != null) && (paramPbSendMsgReq != null))
      {
        paramPbSendMsgReq.msg_ctrl.set(paramMessageRecord.msgCtrl);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.MessageHandlerUtils", 2, "set msg_crl for MessageForPic");
        }
      }
    }
  }
  
  private static void a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator = paramQQAppInterface.getMessageFacade().getRegistry().c().iterator();
    while (localIterator.hasNext()) {
      ((acol)localIterator.next()).a(paramMessageRecord, paramPbSendMsgReq, paramQQAppInterface);
    }
  }
  
  private static void a(MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      paramResvAttr = paramResvAttr.uint32_aio_sync_to_story_flag;
      if (!paramMessageRecord.sync2Story) {
        break label61;
      }
    }
    label61:
    for (int i = 1;; i = 0)
    {
      paramResvAttr.set(i);
      QLog.d("Q.msg.MessageHandlerUtils", 1, "EditAioSyncToStoryPart pic sync to story is " + paramMessageRecord.sync2Story);
      return;
    }
  }
  
  private static void a(MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    if (paramMessageRecord.msgtype == -1000)
    {
      Object localObject = (MessageForText)paramMessageRecord;
      if (((MessageForText)localObject).mPasswdRedBagFlag != 0)
      {
        paramMessageRecord = new im_msg_body.ExtraInfo();
        paramMessageRecord.uint64_uin.set(((MessageForText)localObject).mPasswdRedBagSender);
        paramMessageRecord.uint32_msg_state_flag.set(((MessageForText)localObject).mPasswdRedBagFlag);
        localObject = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject).extra_info.set(paramMessageRecord);
        paramRichText.elems.add((MessageMicro)localObject);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(paramString1, 2, "<" + paramString2 + paramLong);
      paramString3 = paramLong + "|" + paramString3 + "|" + paramString4;
      if (paramString2 != null) {
        QLog.d(paramString1, 2, paramString2 + paramString3);
      }
    }
  }
  
  private static void a(ArrayList<String> paramArrayList, msg_svc.MultiMsgAssist paramMultiMsgAssist)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      msg_svc.RoutingHead localRoutingHead = new msg_svc.RoutingHead();
      msg_svc.C2C localC2C = new msg_svc.C2C();
      localC2C.to_uin.set(Long.valueOf(str).longValue());
      localRoutingHead.c2c.set(localC2C);
      paramMultiMsgAssist.repeated_routing.add(localRoutingHead);
    }
  }
  
  public static void a(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 1)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
      if (bcsc.a(localMessageRecord)) {
        if (((i <= 0) || (((MessageRecord)paramList.get(i - 1)).shmsgseq != localMessageRecord.shmsgseq)) && ((i >= paramList.size() - 1) || (((MessageRecord)paramList.get(i + 1)).shmsgseq != localMessageRecord.shmsgseq))) {
          break label141;
        }
      }
      label141:
      for (int j = 1;; j = 0)
      {
        if (j != 0) {
          localArrayList.add(localMessageRecord);
        }
        i += 1;
        break;
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  private static void a(generalflags.ResvAttr paramResvAttr, ExtensionInfo paramExtensionInfo)
  {
    if (paramExtensionInfo.pendantDiyId > 0) {
      paramResvAttr.uint32_pendant_diy_id.set(paramExtensionInfo.pendantDiyId);
    }
    if (paramExtensionInfo.faceId > 0) {
      paramResvAttr.uint32_face_id.set(paramExtensionInfo.faceId);
    }
    if (paramExtensionInfo.fontEffect > 0) {
      paramResvAttr.uint32_req_font_effect_id.set(paramExtensionInfo.fontEffect);
    }
  }
  
  private static void a(generalflags.ResvAttr paramResvAttr, ExtensionInfo paramExtensionInfo, String paramString)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramString)) {
      i = Integer.parseInt(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElemFromMsg: fontId=" + paramExtensionInfo.uVipFont + " subFontId=" + i);
    }
    paramResvAttr.uint64_subfont_id.set(i);
    if ((paramExtensionInfo.diyFontTimestampMap != null) && (paramExtensionInfo.diyFontTimestampMap.get(Integer.valueOf((int)paramExtensionInfo.uVipFont)) != null)) {
      paramResvAttr.uint32_diy_font_timestamp.set(((Integer)paramExtensionInfo.diyFontTimestampMap.get(Integer.valueOf((int)paramExtensionInfo.uVipFont))).intValue());
    }
  }
  
  private static void a(generalflags.ResvAttr paramResvAttr, String paramString, int paramInt)
  {
    int i = 1;
    if ((paramInt & 0x1) == 1) {}
    for (;;)
    {
      if (i != 0)
      {
        paramResvAttr.uint32_msg_info_flag.set(paramInt);
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElemFromMsg: invoked.  containPasteExtra: " + paramString);
        }
      }
      return;
      i = 0;
    }
  }
  
  private static void a(im_msg_body.GeneralFlags paramGeneralFlags, generalflags.ResvAttr paramResvAttr, boolean paramBoolean1, MessageForFoldMsg paramMessageForFoldMsg, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      paramGeneralFlags.uint64_uin.set(paramMessageForFoldMsg.mPasswdRedBagSender);
    }
    PBUInt32Field localPBUInt32Field = paramGeneralFlags.uint32_prp_fold;
    if (paramMessageForFoldMsg.foldFlagTemp) {}
    for (int i = 1;; i = 0)
    {
      localPBUInt32Field.set(i);
      if ((!TextUtils.isEmpty(paramMessageForFoldMsg.redBagId)) && (!paramBoolean2)) {
        paramGeneralFlags.bytes_rp_id.set(ByteStringMicro.copyFromUtf8(paramMessageForFoldMsg.redBagId));
      }
      if ((!TextUtils.isEmpty(paramMessageForFoldMsg.redBagIndex)) && (paramBoolean1))
      {
        paramGeneralFlags.bytes_rp_index.set(ByteStringMicro.copyFromUtf8(paramMessageForFoldMsg.redBagIndex));
        paramResvAttr.redbag_msg_sender_uin.set(paramMessageForFoldMsg.mPasswdRedBagSender);
      }
      return;
    }
  }
  
  public static boolean a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (acos)paramQQAppInterface.getMessageFacade().getRegistry().a().a(Integer.valueOf(paramInt));
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a())) {
      return true;
    }
    return a.contains(Integer.valueOf(paramInt));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().getMsgList(paramString1, paramInt);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("------->msgFilter :msgIsTroop:").append(paramInt).append(",peerUin:").append(paramString1).append(",list size:");
      if (paramQQAppInterface != null) {
        break label164;
      }
    }
    label164:
    for (paramInt = 0;; paramInt = paramQQAppInterface.size())
    {
      QLog.d("Q.msg.MessageHandlerUtils", 2, paramInt);
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0)) {
        break;
      }
      paramQQAppInterface = paramQQAppInterface.iterator();
      do
      {
        if (!paramQQAppInterface.hasNext()) {
          break;
        }
        paramString1 = (MessageRecord)paramQQAppInterface.next();
      } while ((Math.abs(paramString1.time - paramLong1) >= 30L) || (paramString1.shmsgseq != paramLong2) || (!paramString1.senderuin.equals(paramString2)));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "------->msgFilter-duplicated msg.");
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandlerUtils", 2, "---------------msgFilter message [before filter] is null !");
      }
      return true;
    }
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("---------------msgFilter istroop: ").append(paramMessageRecord.istroop).append(" shmsgseq: ").append(paramMessageRecord.shmsgseq).append(" friendUin: ").append(paramMessageRecord.frienduin).append(" senderUin: ").append(paramMessageRecord.senderuin).append(" msgType: ").append(paramMessageRecord.msgtype).append(" time:").append(paramMessageRecord.time).append(" msgContent: ").append(paramMessageRecord.getLogColorContent());
    }
    for (;;)
    {
      paramQQAppInterface = paramQQAppInterface.getMessageFacade().getMsgList(paramMessageRecord.frienduin, paramMessageRecord.istroop);
      int j;
      int i;
      if (paramQQAppInterface == null)
      {
        j = 0;
        if (j <= 15) {
          break label275;
        }
        i = j - 15;
      }
      for (;;)
      {
        if (i >= j) {
          break label287;
        }
        MessageRecord localMessageRecord = (MessageRecord)paramQQAppInterface.get(i);
        if ((localMessageRecord != null) && (localMessageRecord.msgtype == paramMessageRecord.msgtype) && (bhbx.a(localMessageRecord.msg, paramMessageRecord.msg)))
        {
          if ((QLog.isColorLevel()) && (localStringBuilder != null))
          {
            localStringBuilder.append(" filterType: other");
            QLog.w("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
          }
          MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - l);
          return true;
          j = paramQQAppInterface.size();
          break;
          label275:
          i = 0;
          continue;
        }
        i += 1;
      }
      label287:
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
      }
      MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - l);
      return false;
      localStringBuilder = null;
    }
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    if (((bgls)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(paramMessageRecord))
    {
      paramResvAttr.uint32_robot_msg_flag.set(1, true);
      if ((paramMessageRecord instanceof MessageForPtt))
      {
        paramQQAppInterface = (MessageForPtt)paramMessageRecord;
        new im_msg_body.Elem();
        new im_msg_body.Text();
        if ((paramQQAppInterface.atInfoList != null) && (!paramQQAppInterface.atInfoList.isEmpty()))
        {
          paramMessageRecord = (im_msg_body.RichText)((im_msg_body.MsgBody)paramPbSendMsgReq.msg_body.get()).rich_text.get();
          bcrx.a(paramMessageRecord, paramQQAppInterface.mInputContent, paramQQAppInterface.atInfoList);
          if (paramMessageRecord.elems.has())
          {
            paramQQAppInterface = paramMessageRecord.elems.get().iterator();
            while (paramQQAppInterface.hasNext())
            {
              paramMessageRecord = (im_msg_body.Elem)paramQQAppInterface.next();
              if (paramMessageRecord.text.has())
              {
                paramMessageRecord = (im_msg_body.Text)paramMessageRecord.text.get();
                if (paramMessageRecord.str.has()) {
                  paramMessageRecord.str.set(ByteStringMicro.copyFromUtf8(""));
                }
              }
            }
          }
        }
      }
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, boolean paramBoolean, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    boolean bool = paramBoolean;
    int i;
    int j;
    int k;
    if (paramPbSendMsgReq != null)
    {
      i = paramPbSendMsgReq.toByteArray().length;
      paramQQAppInterface = (aocy)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
      j = paramQQAppInterface.d();
      k = paramQQAppInterface.b();
      if (k <= 0) {
        break label218;
      }
      paramQQAppInterface = localBubbleManager.a(k, false);
      if ((paramQQAppInterface == null) || ((paramQQAppInterface != null) && (paramQQAppInterface.a != null) && (paramQQAppInterface.a.size() > 0))) {
        bool = true;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "bubbleId->" + k + " needSend->" + bool);
      }
      bool = a(paramMessageRecord, paramPbSendMsgReq, paramBoolean, paramGeneralFlags, i, 7, j, bool);
      if (paramMessageRecord.vipSubBubbleId != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElemFromMsg, sub bubbleid: " + paramMessageRecord.vipSubBubbleId);
        }
        paramGeneralFlags.uint32_bubble_sub_id.set(paramMessageRecord.vipSubBubbleId);
        return true;
        bool = false;
      }
      else
      {
        return bool;
        label218:
        bool = false;
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if ((paramMessageRecord == null) || ((paramMessageRecord.msg == null) && (paramMessageRecord.msgData == null))) {
      if (QLog.isColorLevel()) {
        QLog.w("Q.msg.MessageHandlerUtils", 2, "---------------msgFilter message [before filter] is null !");
      }
    }
    long l;
    StringBuilder localStringBuilder;
    do
    {
      return true;
      l = System.currentTimeMillis();
      localStringBuilder = null;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder(256);
        localStringBuilder.append("---------------msgFilter istroop: ").append(paramMessageRecord.istroop).append(" uid: ").append(paramMessageRecord.msgUid).append(" shmsgseq: ").append(paramMessageRecord.shmsgseq).append(" friendUin: ").append(paramMessageRecord.frienduin).append(" senderUin: ").append(paramMessageRecord.senderuin).append(" msgType: ").append(paramMessageRecord.msgtype).append(" time:").append(paramMessageRecord.time).append(" msgContent: ").append(paramMessageRecord.getLogColorContent()).append(" isNormalMsg: ").append(paramBoolean);
      }
    } while (a(paramQQAppInterface, paramMessageRecord, paramBoolean, l, localStringBuilder));
    if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
      QLog.d("Q.msg.MessageHandlerUtils", 2, localStringBuilder.toString());
    }
    MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - l);
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, long paramLong, StringBuilder paramStringBuilder)
  {
    List localList = paramQQAppInterface.getMessageFacade().getMsgList(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    if ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 1026) || (paramMessageRecord.istroop == 3000))
    {
      if (!b(paramQQAppInterface, paramMessageRecord, paramBoolean, paramLong, paramStringBuilder, localList)) {}
    }
    else {
      do
      {
        return true;
        if (!acnh.d(paramMessageRecord.istroop)) {
          break;
        }
      } while (a(paramQQAppInterface, paramMessageRecord, paramBoolean, paramLong, paramStringBuilder, localList));
    }
    do
    {
      do
      {
        return false;
        if (paramMessageRecord.istroop != 7220) {
          break;
        }
      } while (!b(paramMessageRecord, paramLong, paramStringBuilder, localList));
      return true;
    } while (!a(paramMessageRecord, paramLong, paramStringBuilder, localList));
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, long paramLong, StringBuilder paramStringBuilder, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (acnh.a((MessageRecord)paramList.next(), paramMessageRecord, paramBoolean))
        {
          if ((QLog.isColorLevel()) && (paramStringBuilder != null))
          {
            paramStringBuilder.append(" filterType: " + paramMessageRecord.istroop);
            QLog.w("Q.msg.MessageHandlerUtils", 2, paramStringBuilder.toString());
          }
          MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - paramLong);
          return true;
        }
      }
    }
    return paramQQAppInterface.getMsgCache().f(paramMessageRecord);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    boolean bool = paramBoolean;
    if ((paramMessageRecord instanceof ChatMessage))
    {
      bool = paramBoolean;
      if (TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("msg_ext_key"))) {}
    }
    try
    {
      String str = KplRoleInfo.getGameNickByUin(paramQQAppInterface, paramMessageRecord.selfuin);
      paramQQAppInterface = KplRoleInfo.getGameNickByUin(paramQQAppInterface, paramMessageRecord.frienduin);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(paramMessageRecord.selfuin, str);
      localJSONObject.put(paramMessageRecord.frienduin, paramQQAppInterface);
      paramQQAppInterface = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("KplMessage", 2, "general kpl flag=" + paramQQAppInterface);
      }
      paramQQAppInterface = paramQQAppInterface.getBytes("utf-8");
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("KplMessage", 2, "some error at MessageHandlerUtils::getGeneralFlagElemFromMsg()");
        }
        paramQQAppInterface.printStackTrace();
        paramQQAppInterface = null;
      }
    }
    bool = paramBoolean;
    if (paramQQAppInterface != null)
    {
      bool = true;
      paramResvAttr.bytes_kpl_info.set(ByteStringMicro.copyFrom(paramQQAppInterface));
    }
    return bool;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    AppInterface localAppInterface = bofz.a();
    if ((localAppInterface instanceof QQAppInterface)) {
      return (paramMessageRecord.extraflag != 32768) && (!((QQAppInterface)localAppInterface).getMsgCache().b(paramMessageRecord));
    }
    return false;
  }
  
  private static boolean a(MessageRecord paramMessageRecord, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    boolean bool = paramBoolean2;
    if (paramBoolean1) {
      if (paramInt3 > 0)
      {
        bool = paramBoolean2;
        if (paramInt1 + paramInt2 < paramInt3)
        {
          bool = paramBoolean2;
          if (paramInt3 <= 0) {}
        }
      }
      else
      {
        bool = paramBoolean2;
        if (paramMessageRecord.vipBubbleDiyTextId > 0)
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
    return bool;
  }
  
  private static boolean a(MessageRecord paramMessageRecord, long paramLong, StringBuilder paramStringBuilder, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord.time == paramMessageRecord.time) && (localMessageRecord.msg.equals(paramMessageRecord.msg)))
        {
          if ((QLog.isColorLevel()) && (paramStringBuilder != null))
          {
            paramStringBuilder.append(" filterType: other");
            QLog.w("Q.msg.MessageHandlerUtils", 2, paramStringBuilder.toString());
          }
          MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - paramLong);
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq, boolean paramBoolean1, im_msg_body.GeneralFlags paramGeneralFlags, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
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
  
  private static boolean a(MessageRecord paramMessageRecord, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    boolean bool = true;
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
    }
    catch (Exception paramMessageRecord)
    {
      if (!QLog.isColorLevel()) {
        return bool;
      }
    }
    QLog.d("Q.msg.MessageHandlerUtils", 2, "set guideMsgCookie error!", paramMessageRecord);
    return true;
    if ("babyq_add_troop".equals(paramMessageRecord.msg))
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
      byte[] arrayOfByte = bhbx.a(paramMessageRecord.msg);
      if (arrayOfByte != null) {
        paramGeneralFlags.babyq_guide_msg_cookie.set(ByteStringMicro.copyFrom(arrayOfByte));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElem, guideMsgCookie: " + paramMessageRecord.msg + " ,bytes:" + Arrays.toString(arrayOfByte));
      }
    }
    bool = false;
    return bool;
  }
  
  private static boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    boolean bool = paramBoolean;
    if ((paramMessageRecord instanceof MessageForPic))
    {
      bool = paramBoolean;
      if (aioi.b((MessageForPic)paramMessageRecord))
      {
        paramBoolean = true;
        paramResvAttr.uint32_custom_featureid.set(33025);
        bool = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElemFromMsg [zhitu] set uint32_custom_featureid ");
          bool = paramBoolean;
        }
      }
    }
    return bool;
  }
  
  private static boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    boolean bool = true;
    if ((paramMessageRecord instanceof MessageForLongTextMsg))
    {
      paramMessageRecord = (MessageForLongTextMsg)paramMessageRecord;
      bool = paramBoolean;
      if (paramMessageRecord.structingMsg != null)
      {
        paramGeneralFlags.long_text_flag.set(1);
        paramGeneralFlags.long_text_resid.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.structingMsg.mResid));
        bool = true;
      }
      return bool;
    }
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = (MessageForArkApp)paramMessageRecord;
      if (TextUtils.isEmpty(paramMessageRecord.resIDForLongMsg)) {
        break label150;
      }
      paramGeneralFlags.long_text_flag.set(1);
      paramGeneralFlags.long_text_resid.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.resIDForLongMsg));
      paramBoolean = bool;
    }
    label150:
    for (;;)
    {
      return paramBoolean;
      bool = paramBoolean;
      if (!(paramMessageRecord instanceof MessageForArkBabyqReply)) {
        break;
      }
      paramMessageRecord = (MessageForArkBabyqReply)paramMessageRecord;
      bool = paramBoolean;
      if (TextUtils.isEmpty(paramMessageRecord.resIDForLongMsg)) {
        break;
      }
      paramGeneralFlags.long_text_flag.set(1);
      paramGeneralFlags.long_text_resid.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.resIDForLongMsg));
      return true;
    }
  }
  
  public static boolean a(ArrayList<MessageRecord> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)paramArrayList.next();
    } while ((localMessageRecord.isSend()) || (localMessageRecord.isread));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean a(boolean paramBoolean, generalflags.ResvAttr paramResvAttr, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramBoolean = true;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      paramResvAttr.uint32_holiday_flag.set(i);
      return paramBoolean;
    }
    catch (Exception paramResvAttr)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElem, holiday_activie_flag.error: " + paramString);
      }
    }
    return false;
  }
  
  public static String[] a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return null;
    }
    String[] arrayOfString = new String[7];
    long l1 = paramToServiceMsg.extraData.getLong("startTime", 0L);
    long l6 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atAppSite", 0L);
    long l5 = paramFromServiceMsg.extraData.getLong("timestamp_app2msf_atMsfSite", 0L);
    long l8 = paramFromServiceMsg.extraData.getLong("timestamp_msf2net_atMsfSite", 0L);
    long l3 = paramFromServiceMsg.extraData.getLong("timestamp_net2msf_atMsfSite", 0L);
    long l4 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atMsfSite", 0L);
    long l2 = paramFromServiceMsg.extraData.getLong("timestamp_msf2app_atAppSite", 0L);
    long l7 = System.currentTimeMillis();
    arrayOfString[1] = String.valueOf(l7 - l1);
    arrayOfString[2] = String.valueOf(l3 - l8);
    arrayOfString[3] = String.valueOf(l8 - l1);
    arrayOfString[4] = String.valueOf(l7 - l3);
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("handler");
    if (l6 != 0L)
    {
      paramToServiceMsg.append("|").append(String.valueOf(l6 - l1)).append("|app");
      l1 = l6;
    }
    for (;;)
    {
      if (l5 != 0L)
      {
        paramToServiceMsg.append("|").append(String.valueOf(l5 - l1)).append("|msf");
        l1 = l5;
      }
      for (;;)
      {
        if (l8 != 0L) {
          paramToServiceMsg.append("|").append(String.valueOf(l8 - l1)).append("|net");
        }
        arrayOfString[5] = paramToServiceMsg.toString();
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("net");
        if (l4 != 0L) {
          paramToServiceMsg.append("|").append(String.valueOf(l4 - l3)).append("|msf");
        }
        for (l1 = l4;; l1 = l3)
        {
          if (l2 != 0L)
          {
            paramToServiceMsg.append("|").append(String.valueOf(l2 - l1)).append("|app");
            l1 = l2;
          }
          for (;;)
          {
            paramToServiceMsg.append("|").append(String.valueOf(l7 - l1)).append("|handler");
            arrayOfString[6] = paramToServiceMsg.toString();
            paramToServiceMsg = new StringBuilder();
            paramToServiceMsg.append("{");
            paramToServiceMsg.append("total:").append(arrayOfString[1]).append(",");
            paramToServiceMsg.append("net:").append(arrayOfString[2]).append(",");
            paramToServiceMsg.append("send:").append(arrayOfString[3]).append(",");
            paramToServiceMsg.append("recv:").append(arrayOfString[4]).append(",");
            paramToServiceMsg.append("sendDetail:").append(arrayOfString[5]).append(",");
            paramToServiceMsg.append("recvDetail:").append(arrayOfString[6]);
            paramToServiceMsg.append("}");
            arrayOfString[0] = paramToServiceMsg.toString();
            return arrayOfString;
          }
        }
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    if (nty.a(paramMessageRecord)) {
      c(paramMessageRecord, paramRichText);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            TroopManager localTroopManager;
            do
            {
              return;
              if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 1026)) {
                break;
              }
              localObject1 = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
              localObject2 = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
              b(paramMessageRecord, paramRichText);
              localObject2 = ((HotChatManager)localObject2).a(paramMessageRecord.frienduin);
              localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            } while ((localObject2 == null) && (!localTroopManager.f(paramMessageRecord.frienduin)));
            Object localObject2 = new im_msg_body.PubGroup();
            a(paramQQAppInterface, (anvk)localObject1, (im_msg_body.PubGroup)localObject2);
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).pub_group.set((MessageMicro)localObject2);
            paramRichText.elems.add((MessageMicro)localObject1);
            c(paramQQAppInterface, paramMessageRecord, paramRichText);
            return;
            if ((paramMessageRecord.istroop != 1033) && (paramMessageRecord.istroop != 1034)) {
              break;
            }
            paramQQAppInterface = new im_msg_body.Elem();
            aqvh.a(paramQQAppInterface, paramMessageRecord);
            paramRichText.elems.add(paramQQAppInterface);
          } while (!QLog.isColorLevel());
          QLog.i("Q.confess", 2, "bindConfessInfoElem");
          return;
          if (TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_frd_chat_confess_info"))) {
            break;
          }
          paramQQAppInterface = aqvh.a(paramMessageRecord);
          if (paramQQAppInterface != null) {
            paramRichText.elems.add(paramQQAppInterface);
          }
        } while (!QLog.isColorLevel());
        QLog.i("Q.confess", 2, "bindC2CFirstMsgConfessInfoElem elem:" + paramQQAppInterface);
        return;
      } while (paramMessageRecord.istroop != 10007);
      Object localObject1 = new im_msg_body.Elem();
      aveb.a((im_msg_body.Elem)localObject1, paramMessageRecord, paramQQAppInterface);
      paramRichText.elems.add((MessageMicro)localObject1);
    } while (!QLog.isColorLevel());
    QLog.i("Q.confess", 2, "bindTinyInfoElem");
  }
  
  private static void b(MessageRecord paramMessageRecord, msg_svc.PbSendMsgReq paramPbSendMsgReq)
  {
    if ((paramPbSendMsgReq != null) && ((paramMessageRecord instanceof MessageForStructing)))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if ((paramMessageRecord.structingMsg != null) && (uwe.a(paramMessageRecord.structingMsg)))
      {
        paramMessageRecord = new msg_ctrl.MsgCtrl();
        paramMessageRecord.msg_flag.set(4);
        paramPbSendMsgReq.msg_ctrl.set(paramMessageRecord);
      }
    }
  }
  
  private static void b(MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr)
  {
    if ((paramMessageRecord instanceof MessageForPtt))
    {
      paramMessageRecord = (MessageForPtt)paramMessageRecord;
      if (paramMessageRecord.waveformArray != null) {
        paramResvAttr.bytes_pb_ptt_waveform.set(ByteStringMicro.copyFrom(bhfx.a(paramMessageRecord.waveformArray).toByteArray()));
      }
    }
  }
  
  private static void b(MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    if (!TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("ext_key_group_chat_confess_info")))
    {
      paramMessageRecord = aqvh.b(paramMessageRecord);
      if (paramMessageRecord != null) {
        paramRichText.elems.add(paramMessageRecord);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.confess", 2, "bindGroupFirstMsgConfessInfoElem elem:" + paramMessageRecord);
      }
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean, long paramLong, StringBuilder paramStringBuilder, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (acnh.a((MessageRecord)paramList.next(), paramMessageRecord, false, paramBoolean))
        {
          if ((QLog.isColorLevel()) && (paramStringBuilder != null))
          {
            paramStringBuilder.append(" filterType: troop msg isNormalMsg=" + paramBoolean);
            QLog.w("Q.msg.MessageHandlerUtils", 2, paramStringBuilder.toString());
          }
          MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - paramLong);
          return true;
        }
      }
    }
    return paramQQAppInterface.getMsgCache().f(paramMessageRecord);
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    boolean bool = true;
    if ((paramMessageRecord.istroop != 1) && (paramMessageRecord.istroop != 3000)) {
      bool = a(paramMessageRecord);
    }
    while ((a(paramMessageRecord)) && (paramMessageRecord.extraflag == 0)) {
      return bool;
    }
    return false;
  }
  
  private static boolean b(MessageRecord paramMessageRecord, long paramLong, StringBuilder paramStringBuilder, List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (acnh.a((MessageRecord)paramList.next(), paramMessageRecord, true))
        {
          if ((QLog.isColorLevel()) && (paramStringBuilder != null))
          {
            paramStringBuilder.append(" filterType: other");
            QLog.w("Q.msg.MessageHandlerUtils", 2, paramStringBuilder.toString());
          }
          MsgAutoMonitorUtil.getInstance().addMsgFilterTime(System.currentTimeMillis() - paramLong);
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean b(MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    if (asaa.a(paramMessageRecord))
    {
      paramResvAttr.uint32_doutu_msg_type.set(1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElemFromMsg [doutu] set uint32_doutu_msg_type ");
      }
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public static boolean b(ArrayList<MessageRecord> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!paramArrayList.hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)paramArrayList.next();
    } while ((localMessageRecord.msgtype == -2006) && ((localMessageRecord instanceof MessageForFoldMsg)));
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    paramQQAppInterface = HotChatManager.a(paramQQAppInterface, paramMessageRecord);
    if (paramQQAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.hotchat", 2, "carry authElem:" + paramQQAppInterface.near_by_msg.uint32_identify_type.get());
      }
      if (paramMessageRecord.msgtype == -2011)
      {
        paramMessageRecord = paramRichText.elems.get();
        paramMessageRecord.add(0, paramQQAppInterface);
        paramRichText.elems.set(paramMessageRecord);
      }
    }
    else
    {
      return;
    }
    paramRichText.elems.add(paramQQAppInterface);
  }
  
  private static void c(MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr)
  {
    if (((paramMessageRecord instanceof MessageForPic)) && (paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_is_sync_qzone").equals("1"))) {
      paramResvAttr.uint32_upload_image_to_qzone_flag.set(1);
    }
    try
    {
      UploadParam localUploadParam = new UploadParam();
      localUploadParam.bytes_qzone_albumid.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_album_id")));
      localUploadParam.uint64_batchid.set(Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_batch_id")).longValue());
      localUploadParam.uint32_full_image.set(Integer.valueOf(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_is_raw")).intValue());
      localUploadParam.uint64_image_number.set(Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_batch_count")).longValue());
      localUploadParam.uint64_image_number_index.set(Long.valueOf(paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_photo_index")).longValue());
      paramResvAttr.bytes_upload_image_to_qzone_param.set(ByteStringMicro.copyFrom(localUploadParam.toByteArray()));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, "general syncQzoneAlbum : albumid = " + paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_album_id") + ", batchid = " + paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_batch_id") + ", isRaw = " + paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_is_raw") + ", imgCount = " + paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_batch_count") + ", imgIndex = " + paramMessageRecord.getExtInfoFromExtStr("msg_extra_key_qzone_photo_index"));
      }
      return;
    }
    catch (Exception paramMessageRecord) {}
  }
  
  private static void c(MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText)
  {
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    im_msg_body.AnonymousGroupMsg localAnonymousGroupMsg = new im_msg_body.AnonymousGroupMsg();
    ntz localntz = nty.a(paramMessageRecord);
    localAnonymousGroupMsg.uint32_flags.set(localntz.jdField_a_of_type_Int);
    if (!TextUtils.isEmpty(localntz.jdField_a_of_type_JavaLangString)) {
      localAnonymousGroupMsg.str_anon_id.set(ByteStringMicro.copyFrom(localntz.jdField_a_of_type_JavaLangString.getBytes()));
    }
    if (!TextUtils.isEmpty(localntz.jdField_b_of_type_JavaLangString)) {
      localAnonymousGroupMsg.str_anon_nick.set(ByteStringMicro.copyFrom(localntz.jdField_b_of_type_JavaLangString.getBytes()));
    }
    localAnonymousGroupMsg.uint32_head_portrait.set(localntz.jdField_b_of_type_Int);
    localAnonymousGroupMsg.uint32_expire_time.set(localntz.jdField_c_of_type_Int);
    if (!TextUtils.isEmpty(localntz.jdField_c_of_type_JavaLangString)) {
      localAnonymousGroupMsg.str_rank_color.set(ByteStringMicro.copyFrom(localntz.jdField_c_of_type_JavaLangString.getBytes()));
    }
    localAnonymousGroupMsg.uint32_bubble_id.set((int)paramMessageRecord.vipBubbleID);
    localElem.anon_group_msg.set(localAnonymousGroupMsg);
    paramRichText.elems.add(localElem);
  }
  
  private static boolean c(MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    if ((paramMessageRecord instanceof MessageForWantGiftMsg))
    {
      paramResvAttr.want_gift_sender_uin.set(((MessageForWantGiftMsg)paramMessageRecord).wantGiftSenderUin);
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private static boolean d(MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    if ((paramMessageRecord instanceof MessageForReplyText))
    {
      paramMessageRecord = (MessageForReplyText)paramMessageRecord;
      if (paramMessageRecord.isBarrageMsg)
      {
        paramResvAttr.uint32_comment_flag.set(1);
        paramResvAttr.uint64_comment_location.set(paramMessageRecord.barrageTimeLocation);
        oidb_0xdea.PassThrough localPassThrough = new oidb_0xdea.PassThrough();
        localPassThrough.entrance.set(paramMessageRecord.barrageSourceMsgType);
        localPassThrough.uint32_client_type.set(1);
        paramResvAttr.bytes_pass_through.set(ByteStringMicro.copyFrom(localPassThrough.toByteArray()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandlerUtils", 2, new Object[] { "send replay msg, isBarrageMsg: ", Boolean.valueOf(paramMessageRecord.isBarrageMsg), " timeLocation:", Long.valueOf(paramMessageRecord.barrageTimeLocation), " type:", Integer.valueOf(paramMessageRecord.barrageSourceMsgType) });
      }
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  private static boolean e(MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    boolean bool = paramBoolean;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
      if (paramMessageRecord.redBagType == LocalMediaInfo.REDBAG_TYPE_GET)
      {
        paramResvAttr.uint32_red_envelope_type.set(paramMessageRecord.redBagType);
        paramResvAttr.bytes_shortVideoId.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.shortVideoId));
        QLog.d("Q.msg.MessageHandlerUtils", 1, "VideoRedbag, generalflag take redbag flag");
        paramBoolean = true;
      }
      paramResvAttr = paramResvAttr.uint32_aio_sync_to_story_flag;
      if (!paramMessageRecord.syncToStory) {
        break label115;
      }
    }
    label115:
    for (int i = 1;; i = 0)
    {
      paramResvAttr.set(i);
      QLog.d("Q.msg.MessageHandlerUtils", 1, "EditAioSyncToStoryPart Video sync to story is " + paramMessageRecord.syncToStory);
      bool = paramBoolean;
      return bool;
    }
  }
  
  private static boolean f(MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    boolean bool = paramBoolean;
    EmojiStickerManager.StickerInfo localStickerInfo;
    if (paramMessageRecord.msgtype == -2058)
    {
      localStickerInfo = EmojiStickerManager.a(paramMessageRecord);
      bool = paramBoolean;
      if (localStickerInfo != null)
      {
        paramBoolean = true;
        paramResvAttr.float_sticker_x.set(localStickerInfo.x);
        paramResvAttr.float_sticker_y.set(localStickerInfo.y);
        paramResvAttr.float_sticker_width.set(localStickerInfo.width);
        paramResvAttr.float_sticker_height.set(localStickerInfo.height);
        paramResvAttr.uint32_sticker_rotate.set(localStickerInfo.rotate);
        if (paramMessageRecord.istroop != 0) {
          break label179;
        }
        paramResvAttr.uint64_sticker_host_msgseq.set((short)(int)localStickerInfo.hostMsgSeq & 0xFFFF);
      }
    }
    for (;;)
    {
      paramResvAttr.uint64_sticker_host_msguid.set(localStickerInfo.hostMsgUid);
      paramResvAttr.uint64_sticker_host_time.set(localStickerInfo.hostMsgTime);
      bool = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.msg.MessageHandlerUtils", 2, "set generalFlag for sticker info: " + localStickerInfo.toString());
        bool = paramBoolean;
      }
      return bool;
      label179:
      paramResvAttr.uint64_sticker_host_msgseq.set(localStickerInfo.hostMsgSeq);
    }
  }
  
  private static boolean g(MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    boolean bool = paramBoolean;
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      paramMessageRecord = (MessageForShortVideo)paramMessageRecord;
      bool = paramBoolean;
      if (paramMessageRecord.redBagType == LocalMediaInfo.REDBAG_TYPE_GET)
      {
        paramResvAttr.uint32_red_envelope_type.set(paramMessageRecord.redBagType);
        paramResvAttr.bytes_shortVideoId.set(ByteStringMicro.copyFromUtf8(paramMessageRecord.shortVideoId));
        QLog.d("Q.msg.MessageHandlerUtils", 1, "VideoRedbag, generalflag take redbag flag in bless");
        bool = true;
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyv
 * JD-Core Version:    0.7.0.1
 */