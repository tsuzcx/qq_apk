import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import PushNotifyPack.DisMsgReadedNotify;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.DiscMessageProcessor.1;
import com.tencent.mobileqq.app.message.DiscMessageProcessor.2;
import com.tencent.mobileqq.app.message.DiscMessageProcessor.3;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.DiscussInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGetDiscussMsgResp;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import org.jetbrains.annotations.NotNull;
import tencent.im.apollo_game_status.STCMGameMessage;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.conf.sysmsg_0x20c_0x20.Convert2Group;
import tencent.im.conf.sysmsg_0x20c_0x20.MemberNumRemind;
import tencent.im.conf.sysmsg_0x20c_0x20.SysMsgBody;
import tencent.im.conf.sysmsg_0x20c_0x20.UploadFileRemind;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef;
import tencent.im.oidb.cmd0x858.oidb_0x858.GoldMsgTipsElem;
import tencent.im.oidb.cmd0x858.oidb_0x858.MessageRecallReminder;
import tencent.im.oidb.cmd0x858.oidb_0x858.MessageRecallReminder.MessageMeta;
import tencent.im.oidb.cmd0x858.oidb_0x858.NotifyMsgBody;
import tencent.im.oidb.cmd0x858.oidb_0x858.NotifyObjmsgUpdate;
import tencent.im.oidb.cmd0x858.oidb_0x858.RedGrayTipsInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;

public class aonw
  extends acmh
{
  Handler a;
  public final ConcurrentHashMap<String, ArrayList<Pair<String, String>>> a;
  
  public aonw(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    Object localObject1 = paramMsgInfo.vMsg;
    long l1 = paramMsgInfo.lFromUin;
    long l2 = PkgTools.getLongData((byte[])localObject1, 0);
    byte b = localObject1[4];
    ArrayList localArrayList = new ArrayList();
    antl localantl1 = (antl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    Object localObject2 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject3 = (antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg cOpType: " + b + ", dwConfUin=" + l2);
    }
    switch (b)
    {
    case 4: 
    case 5: 
    case 8: 
    case 12: 
    case 13: 
    case 14: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 23: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 33: 
    default: 
    case 1: 
    case 11: 
    case 2: 
      do
      {
        do
        {
          return null;
        } while (!a(paramMsgInfo, (byte[])localObject1, 5, l2, localantl1, (anvk)localObject2, (antp)localObject3));
        return null;
      } while (!a(paramMsgInfo, paramLong, (byte[])localObject1, l1, 5, b, l2, localArrayList, localantl1, (antp)localObject3));
      return null;
    case 3: 
      a(paramMsgInfo, paramLong, (byte[])localObject1, 5, b, l2, localArrayList, localantl1);
      return null;
    case 6: 
      a(paramMsgInfo, paramLong, (byte[])localObject1, 5, b, l2, localantl1, (antp)localObject3);
      return null;
    case 9: 
      a(paramMsgInfo, paramLong, (byte[])localObject1, l1, 5, l2);
      return null;
    case 22: 
      a(paramMsgInfo, paramLong, (byte[])localObject1, l1, 5, b, l2, localArrayList, localantl1);
      return null;
    case 24: 
      return a((byte[])localObject1, l1, 5);
    case 25: 
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject1, 5, null, true);
      return null;
    case 15: 
      a((byte[])localObject1, 5);
      return null;
    case 10: 
      a(paramMsgInfo, paramLong, (byte[])localObject1, l1, 5, l2, localArrayList);
      return null;
    case 7: 
      long l3 = PkgTools.getLongData((byte[])localObject1, 5);
      long l4 = PkgTools.getLongData((byte[])localObject1, 9);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + l2 + " memberUin: " + l3);
      }
      localObject2 = String.valueOf(l3);
      if (a(l3, l2, paramMsgInfo.shMsgSeq)) {
        return null;
      }
      if (((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        return null;
      }
      localObject3 = a(l2, (String)localObject2, a(paramMsgInfo));
      int i = PkgTools.getShortData((byte[])localObject1, 13);
      HashSet localHashSet = new HashSet();
      a((byte[])localObject1, 15, localArrayList, i, localHashSet);
      localObject1 = a(l2, localHashSet, new StringBuffer(), "");
      antl localantl2 = (antl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
      localantl2.a(l2, (String)localObject2, localArrayList, 10005);
      a(paramMsgInfo, paramLong, l1, l2, localantl1, l4, (String)localObject3, localHashSet, (String)localObject1, localantl2);
      return null;
    case 32: 
      a((byte[])localObject1, 5, l2, (antp)localObject3);
      return null;
    case 34: 
      if (QLog.isColorLevel()) {
        QLog.d("GameParty", 2, "recv 0x20c_0x22 online push");
      }
      c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject1, 5, null, true);
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameManager", 2, "recv 0x20c_0x23 online push.[Discussion]");
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject1, 5, null, true);
    return null;
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    paramMsgInfo = a(paramMsgInfo, paramSvcReqPushMsg.lUin);
    if ((paramMsgInfo != null) && (!anyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgInfo, true))) {
      return paramMsgInfo;
    }
    return null;
  }
  
  @NotNull
  private MessageRecord a(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    int i = paramArrayOfByte.length - paramInt;
    Object localObject = new byte[i];
    PkgTools.getBytesData(paramArrayOfByte, paramInt, (byte[])localObject, i);
    oidb_0x858.NotifyMsgBody localNotifyMsgBody = new oidb_0x858.NotifyMsgBody();
    paramArrayOfByte = (MessageForQQWalletTips)bcsa.a(-2029);
    try
    {
      localNotifyMsgBody.mergeFrom((byte[])localObject);
      localObject = (oidb_0x858.RedGrayTipsInfo)localNotifyMsgBody.opt_msg_redtips.get();
      paramArrayOfByte.senderUin = (((oidb_0x858.RedGrayTipsInfo)localObject).uint64_sender_uin.get() + "");
      paramArrayOfByte.reciverUin = (((oidb_0x858.RedGrayTipsInfo)localObject).uint64_receiver_uin.get() + "");
      paramArrayOfByte.senderContent = ((oidb_0x858.RedGrayTipsInfo)localObject).bytes_sender_rich_content.get().toStringUtf8();
      paramArrayOfByte.reciverContent = ((oidb_0x858.RedGrayTipsInfo)localObject).bytes_receiver_rich_content.get().toStringUtf8();
      paramArrayOfByte.authKey = ((oidb_0x858.RedGrayTipsInfo)localObject).bytes_authkey.get().toStringUtf8();
      paramArrayOfByte.idiomSeq = ((oidb_0x858.RedGrayTipsInfo)localObject).uint32_idiom_seq.get();
      paramArrayOfByte.idiom = ((oidb_0x858.RedGrayTipsInfo)localObject).bytes_idiom.get().toStringUtf8();
      paramArrayOfByte.msgType = ((oidb_0x858.RedGrayTipsInfo)localObject).sint32_msgtype.get();
      paramArrayOfByte.richContent = ((oidb_0x858.RedGrayTipsInfo)localObject).bytes_broadcast_rich_content.get().toStringUtf8();
      paramArrayOfByte.lastPinyin = ((oidb_0x858.RedGrayTipsInfo)localObject).bytes_idiom_alpha.get().toStringUtf8();
      paramArrayOfByte.bytes_jumpurl = ((oidb_0x858.RedGrayTipsInfo)localObject).bytes_jumpurl.get().toStringUtf8();
      paramArrayOfByte.subChannel = ((oidb_0x858.RedGrayTipsInfo)localObject).uint32_subchannel.get();
      paramArrayOfByte.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramLong + "", "", "[QQWallet Tips]", bcrg.a(), -2029, 3000, bcrg.a());
      paramArrayOfByte.isread = true;
      paramArrayOfByte.getBytes();
      paramArrayOfByte.onReceiveGrapTips();
      return paramArrayOfByte;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramArrayOfByte;
  }
  
  private String a(long paramLong1, String paramString1, byte paramByte, long paramLong2, long paramLong3, String paramString2, StringBuffer paramStringBuffer, String paramString3)
  {
    if (paramByte == 22)
    {
      if (paramLong2 == 0L) {
        paramString3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691764);
      }
      do
      {
        return paramString3;
        if (paramLong2 == 1L) {
          return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691765);
        }
      } while (paramLong2 != 2L);
      return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692123, new Object[] { paramStringBuffer.toString() });
    }
    int i;
    if (paramLong3 == paramLong1)
    {
      i = 1;
      if (i == 0) {
        break label172;
      }
      if (!QLog.isColorLevel()) {
        break label293;
      }
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691745);
    }
    for (;;)
    {
      return paramString1 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691757, new Object[] { paramStringBuffer.toString() });
      i = 0;
      break;
      label172:
      paramString3 = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "showWelcomeTips server invitorName empty cOpType:" + paramByte);
        }
        paramString3 = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, String.valueOf(paramLong3));
      }
      if (ContactUtils.isDiscussionMeeting(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) {
        paramString3 = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, String.valueOf(paramLong3));
      }
      paramString1 = paramString3 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691744);
      continue;
      label293:
      paramString1 = "";
    }
  }
  
  private String a(long paramLong, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 2 server memberName empty");
      }
      str = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong), paramString1);
    }
    return str;
  }
  
  private String a(long paramLong, HashSet<String> paramHashSet, StringBuffer paramStringBuffer, String paramString)
  {
    if (paramHashSet.size() > 0)
    {
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext())
      {
        String str = (String)paramHashSet.next();
        paramStringBuffer.append(ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong), str)).append("、");
      }
    }
    if (paramStringBuffer.length() > 0) {
      paramString = paramStringBuffer.deleteCharAt(paramStringBuffer.toString().length() - 1).toString();
    }
    return paramString;
  }
  
  private String a(MsgInfo paramMsgInfo)
  {
    String str2 = "";
    String str1 = str2;
    if (paramMsgInfo.vNickName != null)
    {
      str1 = str2;
      if (paramMsgInfo.vNickName.size() > 0) {
        str1 = (String)paramMsgInfo.vNickName.get(0);
      }
    }
    return str1;
  }
  
  private void a(byte paramByte, long paramLong1, long paramLong2)
  {
    if (paramLong2 != Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue()) {}
    MqqHandler localMqqHandler;
    do
    {
      do
      {
        return;
      } while (paramByte != 2);
      localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(AVNotifyCenter.class);
    } while (localMqqHandler == null);
    Message localMessage = localMqqHandler.obtainMessage(10003);
    localMessage.obj = Long.valueOf(paramLong1);
    localMqqHandler.sendMessage(localMessage);
  }
  
  private void a(long paramLong1, long paramLong2, ArrayList<DiscussionMemberInfo> paramArrayList)
  {
    if (paramArrayList.size() > 0) {
      ((antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).b(paramArrayList);
    }
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB saveDiscussionMemberInfoList. disUin:" + paramLong1 + ", cost=" + (l - paramLong2));
    }
  }
  
  private void a(long paramLong1, long paramLong2, ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2)
  {
    if (paramArrayList2 != null) {
      a(paramArrayList2, paramArrayList1, true);
    }
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB msgListFilter. disUin:" + paramLong1 + ", cost=" + (l - paramLong2));
    }
  }
  
  private void a(long paramLong, antp paramantp, sysmsg_0x20c_0x20.SysMsgBody paramSysMsgBody, int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (!paramSysMsgBody.msg_convert_to_group.has());
            Object localObject = (sysmsg_0x20c_0x20.Convert2Group)paramSysMsgBody.msg_convert_to_group.get();
            paramSysMsgBody = String.valueOf(((sysmsg_0x20c_0x20.Convert2Group)localObject).u64_operator.get());
            String str = String.valueOf(((sysmsg_0x20c_0x20.Convert2Group)localObject).u64_group_code.get());
            localObject = String.valueOf(((sysmsg_0x20c_0x20.Convert2Group)localObject).u64_discuss_code.get());
            if (paramantp.jdField_a_of_type_JavaUtilMap != null)
            {
              paramantp.jdField_a_of_type_JavaUtilMap.put(localObject, new String[] { str, paramSysMsgBody });
              paramantp.jdField_a_of_type_JavaUtilSet.add(str);
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=2): Discussion %s is converted to group %s by user %s.", new Object[] { localObject, str, paramSysMsgBody }));
            }
            ((antl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(String.valueOf(paramLong));
            if ((BaseActivity.sTopActivity instanceof SplashActivity)) {}
            ((anrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).notifyUI(41, true, new Object[] { Integer.valueOf(2131695875), localObject, str, Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(paramSysMsgBody)) });
            return;
          } while (!paramSysMsgBody.msg_mem_num_remind.has());
          paramantp = (sysmsg_0x20c_0x20.MemberNumRemind)paramSysMsgBody.msg_mem_num_remind.get();
          paramInt = paramantp.u32_mem_num.get();
          paramLong = paramantp.u64_discuss_code.get();
        } while (!QLog.isColorLevel());
        QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=3): Discussion %d remains %d members.", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
        return;
      } while (!paramSysMsgBody.msg_upload_file_remind.has());
      paramLong = ((sysmsg_0x20c_0x20.UploadFileRemind)paramSysMsgBody.msg_upload_file_remind.get()).u64_discuss_code.get();
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.DiscMsgPc", 2, String.format("0x20(cmd=4): Discussion %d gets a file uploaded.", new Object[] { Long.valueOf(paramLong) }));
  }
  
  private void a(long paramLong, msg_comm.Msg paramMsg)
  {
    if (paramMsg.content_head.has())
    {
      paramMsg = (msg_comm.ContentHead)paramMsg.content_head.get();
      int i = paramMsg.div_seq.get();
      int j = paramMsg.pkg_index.get();
      int k = paramMsg.pkg_num.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB ContentHead. disUin:" + paramLong + ", divSeq:" + i + ",pkgIndex:" + j + ",pkgNum:" + k);
      }
    }
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, antl paramantl1, long paramLong4, String paramString1, HashSet<String> paramHashSet, String paramString2, antl paramantl2)
  {
    paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691760, new Object[] { paramString2 });
    if (paramHashSet.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      if ((int)paramLong4 < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc", 2, "0x7: kicked from the disc because of converting to a group，dwCmdTime=" + paramLong4);
        }
        return;
      }
      paramantl2.a(String.valueOf(paramLong3));
      a(paramMsgInfo, paramLong1, paramLong2, paramLong2, anvx.a(2131702813));
      return;
    }
    paramString1 = paramString1 + anvx.a(2131702812) + paramString2;
    paramantl2.a(String.valueOf(paramLong3), paramHashSet);
    paramantl1.a(paramLong3);
    a(paramMsgInfo, paramLong1, paramLong2, paramLong2, paramString1);
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    MessageRecord localMessageRecord = bcsa.a(-1004);
    localMessageRecord.init(paramLong1, paramLong2, paramLong2, paramString, paramMsgInfo.uRealMsgTime, -1004, 3000, paramMsgInfo.uMsgTime);
    localMessageRecord.isread = true;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + paramLong2 + " msgType: " + -1004 + " friendType: " + 3000 + " shMsgSeq: " + paramMsgInfo.shMsgSeq + " msgContent: " + bhbx.a(paramString));
    }
    if (!anyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(localMessageRecord, String.valueOf(paramLong1));
    }
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, int paramInt, byte paramByte, long paramLong2, antl paramantl, antp paramantp)
  {
    long l1 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    long l2 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    int i = PkgTools.getShortData(paramArrayOfByte, paramInt);
    Object localObject = new byte[i];
    PkgTools.getBytesData(paramArrayOfByte, paramInt + 2, (byte[])localObject, i);
    String str = new String((byte[])localObject);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:" + paramByte + "dwCmdUin =" + l1 + " dwCmdTime=" + l2 + " strName=" + str);
    }
    if (l1 == paramLong1)
    {
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691727, new Object[] { str });
      paramantl.a(String.valueOf(paramLong2), str);
      a(paramMsgInfo, paramLong1, paramLong2, l1, paramArrayOfByte);
      return;
    }
    localObject = "";
    paramArrayOfByte = paramantp.a(String.valueOf(paramLong2));
    if ((paramArrayOfByte != null) && (paramArrayOfByte.isDiscussHrMeeting())) {
      paramArrayOfByte = bhgf.a(paramantp, paramArrayOfByte.uin, String.valueOf(l1));
    }
    for (;;)
    {
      paramantp = paramArrayOfByte;
      if (TextUtils.isEmpty(paramArrayOfByte))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 6 server opeaterName empty");
        }
        paramantp = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong2), String.valueOf(l1));
      }
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691728, new Object[] { paramantp, str });
      break;
      paramArrayOfByte = (byte[])localObject;
      if (paramMsgInfo.vNickName != null)
      {
        paramArrayOfByte = (byte[])localObject;
        if (paramMsgInfo.vNickName.size() > 0) {
          paramArrayOfByte = (String)paramMsgInfo.vNickName.get(0);
        }
      }
    }
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, int paramInt, byte paramByte, long paramLong2, List<String> paramList, antl paramantl)
  {
    ArrayList localArrayList1 = paramMsgInfo.getVNickName();
    long l1 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 8;
    int j = PkgTools.getShortData(paramArrayOfByte, paramInt);
    ArrayList localArrayList2 = new ArrayList();
    int i = paramInt + 2;
    for (paramInt = 1; paramInt < j + 1; paramInt = (short)(paramInt + 1))
    {
      String str = (String)localArrayList1.get(paramInt);
      long l2 = PkgTools.getLongData(paramArrayOfByte, i);
      i += 4;
      paramList.add(String.valueOf(l2));
      localArrayList2.add(new Pair(String.valueOf(l2), str));
    }
    paramArrayOfByte = new anto();
    paramArrayOfByte.jdField_b_of_type_Int = localArrayList1.size();
    paramArrayOfByte.jdField_a_of_type_JavaLangString = String.valueOf(paramLong2);
    paramantl.a(paramArrayOfByte);
    paramantl.a(paramLong2, String.valueOf(l1), paramList, 10004);
    paramArrayOfByte = new Pair(Long.valueOf(l1), localArrayList1.get(0));
    paramantl = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    if ((RecentUser)paramantl.findRecentUser(Long.toString(paramLong2), 3000) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg ru alreadyintab");
      }
      if (ContactUtils.isDiscussionMeeting(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong2)))
      {
        a(paramArrayOfByte, paramMsgInfo, localArrayList2, paramLong1, String.valueOf(paramLong2), paramByte, false);
        return;
      }
      b(paramArrayOfByte, paramMsgInfo, localArrayList2, paramLong1, String.valueOf(paramLong2), paramByte, false);
      return;
    }
    paramList = (RecentUser)paramantl.findRecentUserByUin(Long.toString(paramLong2), 3000);
    alik.a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade());
    paramList.uin = Long.toString(paramLong2);
    paramList.lastmsgtime = paramMsgInfo.uRealMsgTime;
    paramList.setType(3000);
    paramantl.saveRecentUser(paramList);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg ru.lastmsgtime " + paramMsgInfo.uRealMsgTime);
    }
    paramantl = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (SelectMemberActivity.sNeedBlockDiscussSelfInviteMsg)
    {
      SelectMemberActivity.sNeedBlockDiscussSelfInviteMsg = false;
      b(paramArrayOfByte, paramMsgInfo, localArrayList2, paramLong1, String.valueOf(paramLong2), paramByte, true);
      return;
    }
    if (TextUtils.equals(paramantl, String.valueOf(l1)))
    {
      a(localArrayList1, paramList.uin, paramantl, paramantl);
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Multi_call", "Show_discuss_tips", 0, 0, "", "", "", "");
      return;
    }
    b(paramArrayOfByte, paramMsgInfo, localArrayList2, paramLong1, String.valueOf(paramLong2), paramByte, true);
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, byte paramByte, long paramLong3, long paramLong4, List<String> paramList, antl paramantl, boolean paramBoolean, long paramLong5, long paramLong6, Pair<Long, String> paramPair)
  {
    int j = PkgTools.getShortData(paramArrayOfByte, paramInt);
    String str1 = "";
    Object localObject = str1;
    if (paramBoolean)
    {
      localObject = str1;
      if (paramMsgInfo.vNickName != null)
      {
        localObject = str1;
        if (paramMsgInfo.vNickName.size() >= 2) {
          localObject = (String)paramMsgInfo.vNickName.get(1);
        }
      }
    }
    Pair localPair = new Pair(Long.valueOf(paramLong6), localObject);
    localObject = new anto();
    ((anto)localObject).jdField_b_of_type_Int = j;
    ((anto)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramLong4);
    paramantl.a((anto)localObject);
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      int k = i + 1;
      i = paramInt + 2;
      paramInt = 0;
      while (paramInt < j)
      {
        String str2 = String.valueOf(PkgTools.getLongData(paramArrayOfByte, i));
        str1 = "";
        localObject = str1;
        if (paramMsgInfo.vNickName != null)
        {
          localObject = str1;
          if (paramMsgInfo.vNickName.size() >= j + k) {
            localObject = (String)paramMsgInfo.vNickName.get(paramInt + k);
          }
        }
        localArrayList.add(new Pair(str2, localObject));
        paramList.add(str2);
        i += 4;
        paramInt += 1;
      }
    }
    paramInt = 0;
    if (paramLong5 == 0L) {
      paramInt = 10007;
    }
    for (;;)
    {
      paramantl.a(paramLong4, String.valueOf(paramLong3), paramList, paramInt);
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DiscMessageProcessor.1(this, paramLong3, paramLong1, paramPair, paramMsgInfo, paramLong4, paramLong2, paramByte, paramLong5, localPair, localArrayList), 2000L);
      return;
      if (paramLong5 == 1L) {
        paramInt = 10006;
      } else if (paramLong5 == 2L) {
        paramInt = 10008;
      }
    }
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, byte paramByte, long paramLong3, List<String> paramList, antl paramantl)
  {
    boolean bool = false;
    long l1 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    long l2 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    long l3 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    if (l3 != 0L) {
      bool = true;
    }
    String str = "";
    Object localObject = str;
    if (paramMsgInfo.vNickName != null)
    {
      localObject = str;
      if (paramMsgInfo.vNickName.size() >= 1) {
        localObject = (String)paramMsgInfo.vNickName.get(0);
      }
    }
    localObject = new Pair(Long.valueOf(l1), localObject);
    switch ((int)l2)
    {
    }
    for (;;)
    {
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
      if ((RecentUser)paramArrayOfByte.findRecentUser(Long.toString(paramLong3), 3000) == null) {
        break;
      }
      return;
      a(paramMsgInfo, paramLong1, paramArrayOfByte, paramLong2, paramInt + 4 + 4, paramByte, l1, paramLong3, paramList, paramantl, bool, l2, l3, (Pair)localObject);
    }
    paramList = (RecentUser)paramArrayOfByte.findRecentUserByUin(Long.toString(paramLong3), 3000);
    paramList.uin = Long.toString(paramLong3);
    paramList.lastmsgtime = paramMsgInfo.uRealMsgTime;
    paramList.setType(3000);
    paramArrayOfByte.saveRecentUser(paramList);
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, long paramLong3)
  {
    if (PkgTools.getShortData(paramArrayOfByte, paramInt) != 0)
    {
      paramInt += 2;
      int j = PkgTools.getShortData(paramArrayOfByte, paramInt);
      ArrayList localArrayList = new ArrayList();
      paramInt += 2;
      int i = 0;
      Object localObject2;
      while (i < j)
      {
        long l = PkgTools.getLongData(paramArrayOfByte, paramInt);
        localObject2 = "";
        localObject1 = localObject2;
        if (paramMsgInfo.vNickName != null)
        {
          localObject1 = localObject2;
          if (paramMsgInfo.vNickName.size() >= j) {
            localObject1 = (String)paramMsgInfo.vNickName.get(i);
          }
        }
        localArrayList.add(new Pair(Long.valueOf(l), localObject1));
        paramInt += 4;
        i += 1;
      }
      i = PkgTools.getShortData(paramArrayOfByte, paramInt);
      Object localObject1 = new byte[i];
      PkgTools.getBytesData(paramArrayOfByte, paramInt + 2, (byte[])localObject1, i);
      paramArrayOfByte = new String((byte[])localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:9 +uinList.size()=" + localArrayList.size());
      }
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Pair)((Iterator)localObject1).next();
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:9 +遍历uin uin=" + ((Pair)localObject2).first);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "cOptye:9 +sTips=" + paramArrayOfByte + "+lUin=" + paramLong1);
      }
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DiscMessageProcessor.2(this, localArrayList, paramLong1, paramLong3, paramArrayOfByte, paramMsgInfo, paramLong2), 2000L);
    }
  }
  
  private void a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, long paramLong3, List<String> paramList)
  {
    long l1 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    long l2 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    int i = paramInt + 4;
    paramInt = PkgTools.getUnsignedByte(paramArrayOfByte[i]);
    i += 1;
    PkgTools.getUTFString(paramArrayOfByte, i, paramInt);
    paramInt = i + paramInt;
    int j = PkgTools.getShortData(paramArrayOfByte, paramInt);
    i = paramInt + 2;
    HashSet localHashSet = new HashSet();
    paramInt = 0;
    while (paramInt < j)
    {
      long l3 = PkgTools.getLongData(paramArrayOfByte, i);
      i += 4;
      localHashSet.add(String.valueOf(l3));
      paramList.add(String.valueOf(l3));
      paramInt += 1;
    }
    String str;
    if (localHashSet.size() > 0)
    {
      paramArrayOfByte = (antl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
      str = String.valueOf(paramLong3);
      if (!localHashSet.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
        break label274;
      }
      if ((int)l2 >= 0) {
        break label248;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "0x7: kicked from the disc because of converting to a group，dwCmdTime=" + l2);
      }
    }
    for (;;)
    {
      paramArrayOfByte.a(paramLong3, String.valueOf(l1), paramList, 10005);
      return;
      label248:
      paramArrayOfByte.a(str);
      a(paramMsgInfo, paramLong1, paramLong2, paramLong2, anvx.a(2131702814));
    }
    label274:
    paramArrayOfByte.a(str, localHashSet);
    if (Long.getLong(str) != null) {}
    for (paramLong1 = Long.getLong(str).longValue();; paramLong1 = 0L)
    {
      paramArrayOfByte.a(paramLong1);
      break;
    }
  }
  
  private void a(Pair<Long, String> paramPair1, MsgInfo paramMsgInfo, long paramLong1, long paramLong2, long paramLong3, byte paramByte, long paramLong4, Pair<Long, String> paramPair2)
  {
    long l1 = ((Long)paramPair1.first).longValue();
    long l2 = ((Long)paramPair2.first).longValue();
    paramPair1 = (String)paramPair1.second;
    if (TextUtils.isEmpty(paramPair1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 0xb server showName empty");
      }
      paramPair1 = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong2), String.valueOf(l1));
    }
    for (;;)
    {
      String str = (String)paramPair2.second;
      paramPair2 = str;
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 0xb server shareName empty");
        }
        paramPair2 = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong2), String.valueOf(l2));
      }
      if (ContactUtils.isDiscussionMeeting(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong2))) {
        paramPair1 = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong2), String.valueOf(l1));
      }
      if (paramLong4 == 0L) {
        paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691761, new Object[] { paramPair1 });
      }
      for (;;)
      {
        a(paramMsgInfo, paramLong1, paramLong2, paramLong3, paramPair1);
        return;
        if (paramLong4 == 1L) {
          paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691762, new Object[] { paramPair1, paramPair2 });
        } else if (paramLong4 == 2L) {
          paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131692122, new Object[] { paramPair1 });
        } else {
          paramPair1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691757, new Object[] { paramPair1 });
        }
      }
    }
  }
  
  private void a(Pair<Long, String> paramPair, MsgInfo paramMsgInfo, ArrayList<Pair<String, String>> paramArrayList, long paramLong1, String paramString, byte paramByte, long paramLong2, boolean paramBoolean)
  {
    long l = ((Long)paramPair.first).longValue();
    String str = (String)paramPair.second;
    int m = paramArrayList.size();
    StringBuffer localStringBuffer;
    int j;
    label55:
    Object localObject;
    int k;
    if (m > 50)
    {
      i = 50;
      localStringBuffer = new StringBuffer(i * 10);
      j = 0;
      if (j >= i) {
        break label271;
      }
      paramPair = (Pair)paramArrayList.get(j);
      localObject = (String)paramPair.first;
      if (Long.valueOf((String)localObject).longValue() != paramLong1) {
        break label161;
      }
      k = 1;
      label98:
      if (k == 0) {
        break label167;
      }
      paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691766);
      a(paramByte, Long.valueOf(paramString).longValue(), paramLong1);
      label133:
      if (j != 0) {
        break label242;
      }
      localStringBuffer.append(paramPair);
    }
    for (;;)
    {
      j += 1;
      break label55;
      i = m;
      break;
      label161:
      k = 0;
      break label98;
      label167:
      paramPair = (String)paramPair.second;
      if ((!TextUtils.isEmpty(paramPair)) && (!ContactUtils.isDiscussionMeeting(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString))) {
        break label133;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "showWelcomeTips server name empty cOpType:" + paramByte);
      }
      paramPair = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, (String)localObject);
      break label133;
      label242:
      localStringBuffer.append("、" + paramPair);
    }
    label271:
    if (m > 50)
    {
      localStringBuffer.append(" 等");
      localStringBuffer.append(m - 1);
      localStringBuffer.append("人");
    }
    if (paramBoolean) {}
    for (int i = -5001;; i = -1004)
    {
      paramArrayList = new ArrayList();
      localObject = bcsa.a(i);
      paramPair = "";
      if (paramByte == 11) {
        paramPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691764);
      }
      paramPair = a(paramLong1, paramString, paramByte, paramLong2, l, str, localStringBuffer, paramPair);
      ((MessageRecord)localObject).init(paramLong1, paramMsgInfo.lFromUin, paramMsgInfo.lFromUin, paramPair, paramMsgInfo.uRealMsgTime, i, 3000, paramMsgInfo.uMsgTime);
      ((MessageRecord)localObject).isread = true;
      if ((localObject instanceof MessageForNewGrayTips)) {
        ((MessageForNewGrayTips)localObject).updateMsgData();
      }
      if (!anyv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, false)) {
        paramArrayList.add(localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "----------handleC2COnlinePushMsgResp after analysis(showWelcomeTips) friendUin: " + ((MessageRecord)localObject).frienduin + " msgType: " + i + " friendType: " + 3000 + " shMsgSeq: " + paramMsgInfo.shMsgSeq + " msgContent: " + ((MessageRecord)localObject).getLogColorContent());
      }
      if (paramArrayList.size() > 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(paramArrayList, String.valueOf(paramLong1));
      }
      return;
    }
  }
  
  private void a(Pair<Long, String> paramPair, MsgInfo paramMsgInfo, ArrayList<Pair<String, String>> paramArrayList, long paramLong, String paramString, byte paramByte, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new DiscMessageProcessor.3(this, paramPair, paramMsgInfo, paramArrayList, paramLong, paramString, paramByte, paramBoolean), 2000L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i = paramArrayOfByte.length - paramInt;
    paramMessageRecord = new byte[i];
    PkgTools.getBytesData(paramArrayOfByte, paramInt, paramMessageRecord, i);
    paramArrayOfByte = new oidb_0x858.NotifyMsgBody();
    try
    {
      paramArrayOfByte.mergeFrom(paramMessageRecord);
      paramInt = paramArrayOfByte.opt_enum_type.get();
      l1 = paramArrayOfByte.opt_uint64_conf_uin.get();
      if ((paramInt != 7) || (!paramArrayOfByte.opt_msg_recall_reminder.has())) {
        return;
      }
      localObject1 = (oidb_0x858.MessageRecallReminder)paramArrayOfByte.opt_msg_recall_reminder.get();
      l2 = ((oidb_0x858.MessageRecallReminder)localObject1).uint64_uin.get();
      l3 = ((oidb_0x858.MessageRecallReminder)localObject1).uint64_admin_uin.get();
      paramArrayOfByte = new HashMap();
      try
      {
        paramMessageRecord = new msgrevoke_userdef.MsgInfoUserDef();
        paramMessageRecord.mergeFrom(((oidb_0x858.MessageRecallReminder)localObject1).bytes_userdef.get().toByteArray());
        paramInt = paramMessageRecord.uint32_long_message_flag.get();
        if (paramInt != 1) {
          break label216;
        }
        paramMessageRecord = ((ArrayList)paramMessageRecord.long_msg_info.get()).iterator();
        while (paramMessageRecord.hasNext())
        {
          localObject2 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)paramMessageRecord.next();
          paramArrayOfByte.put(Integer.valueOf(((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject2).uint32_msg_seq.get()), localObject2);
        }
        QLog.d("revokeMsg", 2, "recv 0x20c_0x19 msg, parse msgInfoUserDef error");
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      long l1;
      Object localObject1;
      long l2;
      long l3;
      Object localObject2;
      label216:
      paramQQAppInterface.printStackTrace();
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("Q.msg.DiscMsgPc", 2, "parse0x20c_subType0x19 Exception " + paramQQAppInterface.getStackTrace());
      return;
      paramQQAppInterface.getMessageFacade().handleRevokedNotifyAndNotify(paramMessageRecord, false);
    }
    paramMessageRecord = new ArrayList();
    localObject1 = ((ArrayList)((oidb_0x858.MessageRecallReminder)localObject1).uint32_recalled_msg_list.get()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (oidb_0x858.MessageRecallReminder.MessageMeta)((Iterator)localObject1).next();
      localObject2 = new RevokeMsgInfo();
      ((RevokeMsgInfo)localObject2).jdField_b_of_type_JavaLangString = String.valueOf(l2);
      ((RevokeMsgInfo)localObject2).jdField_c_of_type_JavaLangString = String.valueOf(l3);
      ((RevokeMsgInfo)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l1);
      ((RevokeMsgInfo)localObject2).jdField_a_of_type_Int = 3000;
      ((RevokeMsgInfo)localObject2).jdField_a_of_type_Long = ((oidb_0x858.MessageRecallReminder.MessageMeta)localObject3).uint32_seq.get();
      ((RevokeMsgInfo)localObject2).jdField_c_of_type_Long = ((oidb_0x858.MessageRecallReminder.MessageMeta)localObject3).uint32_time.get();
      ((RevokeMsgInfo)localObject2).f = ((oidb_0x858.MessageRecallReminder.MessageMeta)localObject3).uint32_is_anony_msg.get();
      if (paramInt == 1)
      {
        localObject3 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)paramArrayOfByte.get(Integer.valueOf(((oidb_0x858.MessageRecallReminder.MessageMeta)localObject3).uint32_seq.get()));
        ((RevokeMsgInfo)localObject2).jdField_b_of_type_Int = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_id.get();
        ((RevokeMsgInfo)localObject2).jdField_c_of_type_Int = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_num.get();
        ((RevokeMsgInfo)localObject2).d = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_index.get();
      }
      paramMessageRecord.add(localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("revokeMsg", 2, "recv 0x20c_0x19 msg," + ((RevokeMsgInfo)localObject2).toString());
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList<msg_comm.Msg> paramArrayList, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp)
  {
    ArrayList localArrayList = new ArrayList();
    String str = String.valueOf(paramToServiceMsg.extraData.getLong("lDisUin", paramPbGetDiscussMsgResp.discuss_uin.get()));
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().h(str);
    StringBuilder localStringBuilder = new StringBuilder();
    if (QLog.isColorLevel())
    {
      localStringBuilder.append("<<---initGetPullDiscussionMsg discussUin: ").append(str).append(" res.cReplyCode: ").append(paramPbGetDiscussMsgResp.result.get()).append(" lastSeq: ").append(l);
      QLog.d("Q.msg.DiscMsgPc_At_Me_DISC", 2, localStringBuilder.toString());
    }
    if (paramArrayList != null) {
      a(paramArrayList, localArrayList);
    }
    if ((paramPbGetDiscussMsgResp.result.get() == 104) && (localArrayList.size() == 0))
    {
      l = paramToServiceMsg.extraData.getLong("lEndSeq", paramPbGetDiscussMsgResp.return_end_seq.get());
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "initGetPullDiscussionMsg reply 104 !! disUin=" + str + ", reqEndSeq=" + l);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(str, l);
    }
    for (int i = 1;; i = 0)
    {
      if (localArrayList.size() > 0)
      {
        b(localArrayList);
        Collections.sort(localArrayList, this.jdField_a_of_type_JavaUtilComparator);
        paramToServiceMsg = new ArrayList();
        a(localArrayList, str, localStringBuilder, paramToServiceMsg);
        int k = localArrayList.size();
        int j = 0;
        while (j < k)
        {
          paramArrayList = (MessageRecord)localArrayList.get(j);
          if ((paramArrayList instanceof MessageForMarketFace)) {
            awyq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMarketFace)paramArrayList);
          }
          j += 1;
        }
        l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().h(str);
        if (paramToServiceMsg.size() > 0) {
          a(paramToServiceMsg, str, false, 0, l);
        }
      }
      for (;;)
      {
        if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(str) == 1))
        {
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(str);
          if (paramToServiceMsg != null)
          {
            l = ((Long)paramToServiceMsg[0]).longValue();
            ((acmd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getBaseMessageManager(3000)).b(str, 3000, l);
          }
        }
        return;
        i = 1;
        continue;
        i = 1;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList<msg_comm.Msg> paramArrayList, msg_svc.PbGetDiscussMsgResp paramPbGetDiscussMsgResp, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList2 = new ArrayList();
    bffl localbffl = new bffl();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---refreshDiscussionHead_PB: size:" + paramArrayList.size());
      }
      a(paramArrayList, paramString, localArrayList1, localHashSet, localArrayList2, localbffl);
    }
    if (localArrayList2.size() > 0) {
      ((antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).b(localArrayList2);
    }
    a(localArrayList1);
    Collections.sort(localArrayList1, this.jdField_a_of_type_JavaUtilComparator);
    paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
    paramArrayList = paramPbGetDiscussMsgResp.discuss_uin.toString();
    ((awzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(paramArrayList + "&" + 3000, localbffl);
    paramArrayList = new ArrayList();
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.putLong("beginSeq", paramPbGetDiscussMsgResp.return_begin_seq.get());
      paramToServiceMsg.putLong("endSeq", paramPbGetDiscussMsgResp.return_end_seq.get());
      paramToServiceMsg.putBoolean("success", true);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().handleRefreshMessagelistHeadResult(String.valueOf(paramPbGetDiscussMsgResp.discuss_uin.get()), 3000, localArrayList1, paramArrayList, paramToServiceMsg);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
    ((bhou)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(localArrayList1);
  }
  
  private void a(StringBuilder paramStringBuilder, ArrayList<Pair<Long, String>> paramArrayList, long paramLong)
  {
    int i = 0;
    if (i < paramArrayList.size())
    {
      String str2 = (String)((Pair)paramArrayList.get(i)).second;
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 9 server showName empty");
        }
        str1 = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong), String.valueOf(paramArrayList.get(i)));
      }
      if (i == 0) {
        paramStringBuilder.append(str1);
      }
      for (;;)
      {
        i += 1;
        break;
        paramStringBuilder.append("、" + str1);
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList)
  {
    antl localantl = (antl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
        localMessageRecord.issend = 2;
      }
      localMessageRecord.isread = true;
      try
      {
        localantl.a(Long.parseLong(localMessageRecord.frienduin), Long.parseLong(localMessageRecord.senderuin));
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.DiscMsgPc", 2, "processRefreshHead exception when checkAndGetDiscussionMemberExist " + localMessageRecord.frienduin + ":" + localMessageRecord.senderuin);
      }
    }
  }
  
  private void a(ArrayList<String> paramArrayList, String paramString1, String paramString2, String paramString3)
  {
    MessageRecord localMessageRecord = bcsa.a(-1016);
    long l = bcrg.a();
    if ((paramArrayList != null) && (paramArrayList.size() > 1))
    {
      int k = paramArrayList.size();
      if (k > 50) {}
      StringBuilder localStringBuilder;
      for (int i = 50;; i = k)
      {
        localStringBuilder = new StringBuilder(i * 10);
        int j = 1;
        while (j < i)
        {
          localStringBuilder.append((String)paramArrayList.get(j));
          if (j != i - 1) {
            localStringBuilder.append("、");
          }
          j += 1;
        }
      }
      if (k > 50)
      {
        localStringBuilder.append(" 等");
        localStringBuilder.append(k - 1);
        localStringBuilder.append("人");
      }
      paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131691273, new Object[] { localStringBuilder });
      localMessageRecord.init(paramString2, paramString1, paramString3, paramArrayList + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694170), l, -1016, 3000, l);
      localMessageRecord.extStr = paramArrayList;
      localMessageRecord.isread = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(localMessageRecord, localMessageRecord.selfuin);
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList1, String paramString, StringBuilder paramStringBuilder, ArrayList<MessageRecord> paramArrayList2)
  {
    int i = paramArrayList1.size() - 1;
    if (i >= 0)
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList1.get(i);
      if (QLog.isColorLevel())
      {
        paramStringBuilder.setLength(0);
        paramStringBuilder.append("----------initGetPullDiscussionMsg update send message  mr.senderuin: ").append(localMessageRecord.senderuin).append(" mr.msgtype: ").append(localMessageRecord.msgtype).append(" mr.frienduin: ").append(localMessageRecord.frienduin).append(" mr.shmsgseq: ").append(localMessageRecord.shmsgseq).append(" mr.time:").append(localMessageRecord.time).append(" mr.msg: ").append(localMessageRecord.getLogColorContent());
        QLog.d("Q.msg.DiscMsgPc", 2, paramStringBuilder.toString());
      }
      if (a(paramString, localMessageRecord)) {}
      for (;;)
      {
        i -= 1;
        break;
        paramArrayList2.add(0, localMessageRecord);
      }
    }
  }
  
  private void a(ArrayList<msg_comm.Msg> paramArrayList, String paramString, ArrayList<MessageRecord> paramArrayList1, HashSet<String> paramHashSet, ArrayList<DiscussionMemberInfo> paramArrayList2, bffl parambffl)
  {
    Iterator localIterator = paramArrayList.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        msg_comm.Msg localMsg = (msg_comm.Msg)localIterator.next();
        paramArrayList = (msg_comm.MsgHead)localMsg.msg_head.get();
        if (!paramArrayList.discuss_info.has())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc", 2, "<---refreshDiscussionHead_PB: no discussInfo.");
          }
        }
        else
        {
          Object localObject = (msg_comm.DiscussInfo)paramArrayList.discuss_info.get();
          long l1 = paramArrayList.from_uin.get();
          long l2 = paramArrayList.to_uin.get();
          long l3 = paramArrayList.msg_seq.get();
          int i = paramArrayList.msg_time.get();
          long l4 = paramArrayList.msg_uid.get();
          int j = paramArrayList.user_active.get();
          int k = paramArrayList.from_instid.get();
          long l5 = ((msg_comm.DiscussInfo)localObject).discuss_uin.get();
          int m = ((msg_comm.DiscussInfo)localObject).discuss_type.get();
          long l6 = ((msg_comm.DiscussInfo)localObject).discuss_info_seq.get();
          ArrayList localArrayList = null;
          paramArrayList = localArrayList;
          if (((msg_comm.DiscussInfo)localObject).discuss_remark.has())
          {
            paramArrayList = localArrayList;
            if (((msg_comm.DiscussInfo)localObject).discuss_remark.get() != null) {
              paramArrayList = ((msg_comm.DiscussInfo)localObject).discuss_remark.get().toByteArray();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc", 2, "<---refreshDiscussionHead_PB : fromUin:" + l1 + ",toUin:" + l2 + ",msgTime:" + i + ",msgSeq:" + l3 + ",msgUid:" + l4 + ",userActive:" + j + ",fromInstid:" + k + ",disUin:" + l5 + ",disType:" + m + ",disSeq:" + l6 + ",remarkSender:" + Arrays.toString(paramArrayList) + ",hasAppShare:" + localMsg.appshare_info.has() + ",hasMsgBody:" + localMsg.msg_body.has());
          }
          localArrayList = new ArrayList();
          localObject = new ArrayList();
          bcsd localbcsd = new bcsd();
          localbcsd.jdField_e_of_type_Long = l5;
          localbcsd.jdField_e_of_type_Int = 3000;
          localbcsd.f = m;
          if (localMsg.content_head.has())
          {
            msg_comm.ContentHead localContentHead = (msg_comm.ContentHead)localMsg.content_head.get();
            i = localContentHead.div_seq.get();
            j = localContentHead.pkg_index.get();
            k = localContentHead.pkg_num.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.DiscMsgPc", 2, "<---refreshDiscussionHead_PB ContentHead: divSeq:" + i + ",pkgIndex:" + j + ",pkgNum:" + k);
            }
          }
          try
          {
            a(localMsg, (ArrayList)localObject, localbcsd, true, parambffl);
            if (((ArrayList)localObject).size() > 0) {
              a((List)localObject, localArrayList, true);
            }
            if ((localArrayList != null) && (localArrayList.size() >= 1))
            {
              anyv.a(localArrayList);
              paramArrayList1.addAll(localArrayList);
              anyv.a("Q.msg.DiscMsgPc", paramString, l3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), String.valueOf(l5));
              a(paramHashSet, paramArrayList2, l1, l5, paramArrayList);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.w("Q.msg.DiscMsgPc", 2, "decodeSinglePbMsg_GroupDis error,", localException);
              }
            }
          }
        }
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, String paramString, boolean paramBoolean, int paramInt, long paramLong)
  {
    Object localObject1 = paramArrayList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (((MessageRecord)localObject2).shmsgseq > paramLong) {
        paramLong = ((MessageRecord)localObject2).shmsgseq;
      }
    }
    localObject1 = (acmd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getBaseMessageManager(3000);
    if (!((acmd)localObject1).a(paramString, 3000, paramArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(paramString);
      long l = ((Long)localObject2[0]).longValue();
      int i = paramArrayList.size();
      paramInt = 0;
      while (paramInt < i)
      {
        if ((((MessageRecord)paramArrayList.get(paramInt)).senderuin != null) && (((MessageRecord)paramArrayList.get(paramInt)).senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
        {
          ((MessageRecord)paramArrayList.get(paramInt)).isread = true;
          ((MessageRecord)paramArrayList.get(paramInt)).issend = 2;
        }
        if (((Long)localObject2[0]).longValue() >= ((MessageRecord)paramArrayList.get(paramInt)).shmsgseq) {
          ((MessageRecord)paramArrayList.get(paramInt)).isread = true;
        }
        paramInt += 1;
      }
      boolean bool = anyv.a(paramArrayList);
      paramInt = acnh.a(paramArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop))
      {
        paramBoolean = true;
        ((QQMessageFacade)localObject2).addMessage(paramArrayList, str, paramBoolean, false);
        ((acmd)localObject1).b(paramString, 3000, l);
        ((acmd)localObject1).a(paramString, paramArrayList);
        paramBoolean = bool;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().h(paramString, paramLong);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramBoolean)) && (!acnh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 3000))) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a("initGetPullDiscussionMsg", true, paramInt, paramBoolean, false);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramArrayList);
        ((bhou)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(paramArrayList);
        return;
        paramBoolean = false;
        break;
      }
    }
  }
  
  private void a(ArrayList<msg_comm.Msg> paramArrayList, ArrayList<MessageRecord> paramArrayList1)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "discussionMsgRecordHandle_PB msgs is null or size <= 0");
      }
      return;
    }
    long l1 = 0L;
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList1 = new ArrayList();
    new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    msg_comm.Msg localMsg;
    bffl localbffl;
    Object localObject;
    long l4;
    long l2;
    long l3;
    int i;
    long l5;
    int j;
    int k;
    int m;
    long l6;
    if (localIterator.hasNext())
    {
      localMsg = (msg_comm.Msg)localIterator.next();
      localbffl = new bffl();
      paramArrayList = (msg_comm.MsgHead)localMsg.msg_head.get();
      if ((!paramArrayList.discuss_info.has()) && (QLog.isColorLevel())) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      localObject = (msg_comm.DiscussInfo)paramArrayList.discuss_info.get();
      l4 = paramArrayList.from_uin.get();
      l2 = paramArrayList.to_uin.get();
      l3 = paramArrayList.msg_seq.get();
      i = paramArrayList.msg_time.get();
      l5 = paramArrayList.msg_uid.get();
      j = paramArrayList.user_active.get();
      k = paramArrayList.from_instid.get();
      l1 = ((msg_comm.DiscussInfo)localObject).discuss_uin.get();
      m = ((msg_comm.DiscussInfo)localObject).discuss_type.get();
      l6 = ((msg_comm.DiscussInfo)localObject).discuss_info_seq.get();
      if ((!((msg_comm.DiscussInfo)localObject).discuss_remark.has()) || (((msg_comm.DiscussInfo)localObject).discuss_remark.get() == null)) {
        break label681;
      }
    }
    label675:
    label678:
    label681:
    for (paramArrayList = ((msg_comm.DiscussInfo)localObject).discuss_remark.get().toByteArray();; paramArrayList = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB : fromUin:" + l4 + ",toUin:" + l2 + ",msgTime:" + i + ",msgSeq:" + l3 + ",msgUid:" + l5 + ",userActive:" + j + ",fromInstid:" + k + ",disUin:" + l1 + ",disType:" + m + ",disSeq:" + l6 + ",remarkSender:" + Arrays.toString(paramArrayList) + ",hasAppShare:" + localMsg.appshare_info.has() + ",hasMsgBody:" + localMsg.msg_body.has());
      }
      localObject = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      bcsd localbcsd = new bcsd();
      localbcsd.jdField_e_of_type_Long = l1;
      localbcsd.jdField_e_of_type_Int = 3000;
      localbcsd.f = m;
      a(l1, localMsg);
      l2 = System.currentTimeMillis();
      for (;;)
      {
        try
        {
          a(localMsg, localArrayList2, localbcsd, true, localbffl);
          if (!QLog.isColorLevel()) {
            break label678;
          }
          l3 = System.currentTimeMillis();
          QLog.d("Q.msg.DiscMsgPc", 2, "<---discussionMsgRecordHandle_PB decodeSinglePbMsg_Group. isUin:" + l1 + ", cost=" + (l3 - l2));
          l2 = l3;
          a(l1, l2, (ArrayList)localObject, localArrayList2);
          if (localObject == null) {
            break label675;
          }
          if (((ArrayList)localObject).size() >= 1) {}
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("Q.msg.DiscMsgPc", 2, "decodeSinglePbMsg_GroupDis error,", localException);
          continue;
          anyv.a((List)localObject);
          paramArrayList1.addAll((Collection)localObject);
          a(localHashSet, localArrayList1, l4, l1, paramArrayList);
        }
        break;
        a(l1, System.currentTimeMillis(), localArrayList1);
        return;
        break;
      }
    }
  }
  
  private void a(HashSet<String> paramHashSet, ArrayList<DiscussionMemberInfo> paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      String str2 = String.valueOf(paramLong1);
      String str1 = HexUtil.bytes2HexStr(paramArrayOfByte) + ":" + str2;
      if (!paramHashSet.contains(str1))
      {
        paramArrayOfByte = ((antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(paramArrayOfByte, String.valueOf(paramLong2), str2, false);
        if (paramArrayOfByte != null)
        {
          paramArrayList.add(paramArrayOfByte);
          paramHashSet.add(str1);
        }
      }
    }
  }
  
  private void a(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---DiscussionMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:").append(paramList1.size()).append(" outListSize:").append(paramList2.size());
      QLog.d("Q.msg.DiscMsgPc", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg, boolean paramBoolean)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!((msg_comm.MsgHead)localObject1).discuss_info.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      return;
    }
    Object localObject3 = (msg_comm.DiscussInfo)((msg_comm.MsgHead)localObject1).discuss_info.get();
    long l1 = ((msg_comm.MsgHead)localObject1).from_uin.get();
    long l2 = ((msg_comm.MsgHead)localObject1).to_uin.get();
    long l3 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
    int m = ((msg_comm.MsgHead)localObject1).msg_time.get();
    long l4 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
    int n = ((msg_comm.MsgHead)localObject1).user_active.get();
    int i1 = ((msg_comm.MsgHead)localObject1).from_instid.get();
    long l5 = ((msg_comm.DiscussInfo)localObject3).discuss_uin.get();
    int i2 = ((msg_comm.DiscussInfo)localObject3).discuss_type.get();
    long l6 = ((msg_comm.DiscussInfo)localObject3).discuss_info_seq.get();
    label173:
    long l7;
    Object localObject2;
    int k;
    int j;
    int i;
    if (paramFromServiceMsg.getUin() == null)
    {
      localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      l7 = ((Long)localObject1).longValue();
      localObject2 = null;
      localObject1 = localObject2;
      if (((msg_comm.DiscussInfo)localObject3).discuss_remark.has())
      {
        localObject1 = localObject2;
        if (((msg_comm.DiscussInfo)localObject3).discuss_remark.get() != null) {
          localObject1 = ((msg_comm.DiscussInfo)localObject3).discuss_remark.get().toByteArray();
        }
      }
      if (!paramMsg.content_head.has()) {
        break label793;
      }
      localObject2 = (msg_comm.ContentHead)paramMsg.content_head.get();
      k = ((msg_comm.ContentHead)localObject2).div_seq.get();
      j = ((msg_comm.ContentHead)localObject2).pkg_index.get();
      i = ((msg_comm.ContentHead)localObject2).pkg_num.get();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.userActiveStatus = n;
      int i3 = paramFromServiceMsg.getRequestSsoSeq();
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.a())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(l7, paramPbPushMsg.svrip.get(), i3);
        return;
        localObject1 = Long.valueOf(paramFromServiceMsg.getUin());
        break label173;
      }
      if (a(paramMsg, paramFromServiceMsg, paramPbPushMsg, l5, l7, i3)) {
        break;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder("<---handleMsgPush_PB_Dis ");
        paramFromServiceMsg.append(" fromUin:").append(l1).append(" toUin").append(l2).append(" msgTime:").append(m).append(" msgSeq:").append(l3).append(" msgUid:").append(l4).append(" userActive:").append(n).append(" fromInstid:").append(i1).append(" disUin:").append(l5).append(" disType:").append(i2).append(" disSeq:").append(l6).append(" remarkSender:").append(HexUtil.bytes2HexStr((byte[])localObject1)).append(" divSeq:").append(k).append(" pkgIndex:").append(j).append(" pkgNum:").append(i).append(" hasShare:").append(paramMsg.appshare_info.has());
        QLog.d("Q.msg.DiscMsgPc", 2, paramFromServiceMsg.toString());
      }
      ((antl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).a(l5, l1);
      ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(l1);
      paramFromServiceMsg = (antp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      localObject2 = new bcsd();
      ((bcsd)localObject2).jdField_e_of_type_Long = l5;
      ((bcsd)localObject2).jdField_e_of_type_Int = 3000;
      ((bcsd)localObject2).f = i2;
      paramMsg = a(paramMsg, (bcsd)localObject2);
      localObject3 = new HashSet();
      ArrayList localArrayList = new ArrayList();
      localObject2 = new ArrayList();
      a((byte[])localObject1, paramFromServiceMsg, paramMsg, (HashSet)localObject3, localArrayList, (ArrayList)localObject2);
      if (localArrayList.size() > 0) {
        paramFromServiceMsg.b(localArrayList);
      }
      paramFromServiceMsg = new ArrayList();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0)) {
        paramFromServiceMsg.addAll((Collection)localObject2);
      }
      b(l5, l7, (ArrayList)localObject2, paramFromServiceMsg);
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(l7, paramPbPushMsg.svrip.get(), i3);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramFromServiceMsg);
      ((bhou)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(paramMsg);
      return;
      label793:
      i = 0;
      j = 0;
      k = 0;
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    PkgTools.getLongData(paramArrayOfByte, paramInt);
    paramInt += 4;
    paramInt = paramArrayOfByte[paramInt];
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt, long paramLong, antp paramantp)
  {
    int i = (int)PkgTools.getLongData(paramArrayOfByte, paramInt);
    byte[] arrayOfByte = new byte[i];
    PkgTools.getBytesData(paramArrayOfByte, paramInt + 4, arrayOfByte, i);
    paramArrayOfByte = new sysmsg_0x20c_0x20.SysMsgBody();
    try
    {
      paramArrayOfByte.mergeFrom(arrayOfByte);
      if (paramArrayOfByte.u32_cmd.has()) {
        a(paramLong, paramantp, paramArrayOfByte, paramArrayOfByte.u32_cmd.get());
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.msg.DiscMsgPc", 2, "0x20: Parsing data failed!");
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt1, List<String> paramList, int paramInt2, HashSet<String> paramHashSet)
  {
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      long l = PkgTools.getLongData(paramArrayOfByte, i);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg MSG_DISCUSSION_TYPE_KICKOUT_MEMBER uin=" + l);
      }
      i += 4;
      paramHashSet.add(String.valueOf(l));
      paramList.add(String.valueOf(l));
      paramInt1 += 1;
    }
  }
  
  private void a(byte[] paramArrayOfByte, antp paramantp, HashSet<String> paramHashSet, ArrayList<DiscussionMemberInfo> paramArrayList, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      String str2 = paramMessageRecord.senderuin;
      String str1 = HexUtil.bytes2HexStr(paramArrayOfByte) + ":" + str2;
      if (!paramHashSet.contains(str1))
      {
        paramArrayOfByte = paramantp.a(paramArrayOfByte, paramMessageRecord.frienduin, str2, false);
        if (paramArrayOfByte != null)
        {
          paramArrayList.add(paramArrayOfByte);
          paramHashSet.add(str1);
        }
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, antp paramantp, List<MessageRecord> paramList, HashSet<String> paramHashSet, ArrayList<DiscussionMemberInfo> paramArrayList, ArrayList<MessageRecord> paramArrayList1)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      anyv.a(paramList);
      int j = paramList.size();
      int i = 0;
      if (i < j)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc", 2, "----------handleMsgPush_PB_Dis after analysis  mr.senderuin: " + localMessageRecord.senderuin + " mr.msgtype: " + localMessageRecord.msgtype + " mr.frienduin: " + localMessageRecord.frienduin + " mr.shmsgseq: " + localMessageRecord.shmsgseq + " mr.time:" + localMessageRecord.time + " mr.msg: " + localMessageRecord.getLogColorContent());
        }
        if (a(localMessageRecord)) {}
        for (;;)
        {
          i += 1;
          break;
          if ((localMessageRecord instanceof MessageForMarketFace)) {
            awyq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMarketFace)localMessageRecord);
          }
          paramArrayList1.add(localMessageRecord);
          a(paramArrayOfByte, paramantp, paramHashSet, paramArrayList, i, localMessageRecord);
        }
      }
    }
  }
  
  /* Error */
  private boolean a(long paramLong1, long paramLong2, short paramShort)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 83	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   9: lload_1
    //   10: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13: ldc_w 1634
    //   16: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: lload_3
    //   20: invokevirtual 98	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   23: ldc_w 1634
    //   26: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload 5
    //   31: invokevirtual 93	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore 7
    //   39: aload_0
    //   40: getfield 43	aonw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   43: invokevirtual 1106	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lbcrg;
    //   46: invokevirtual 1636	bcrg:a	()Ljava/util/ArrayList;
    //   49: aload 7
    //   51: invokevirtual 1637	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   54: ifeq +45 -> 99
    //   57: invokestatic 79	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   60: ifeq +31 -> 91
    //   63: ldc_w 504
    //   66: iconst_2
    //   67: new 83	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 1639
    //   77: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload 7
    //   82: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 1641	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: iconst_1
    //   92: istore 6
    //   94: aload_0
    //   95: monitorexit
    //   96: iload 6
    //   98: ireturn
    //   99: aload_0
    //   100: getfield 43	aonw:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   103: invokevirtual 1106	com/tencent/mobileqq/app/QQAppInterface:getMsgCache	()Lbcrg;
    //   106: aload 7
    //   108: invokevirtual 1642	bcrg:a	(Ljava/lang/String;)V
    //   111: iconst_0
    //   112: istore 6
    //   114: goto -20 -> 94
    //   117: astore 7
    //   119: aload_0
    //   120: monitorexit
    //   121: aload 7
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	aonw
    //   0	124	1	paramLong1	long
    //   0	124	3	paramLong2	long
    //   0	124	5	paramShort	short
    //   92	21	6	bool	boolean
    //   37	70	7	str	String
    //   117	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	91	117	finally
    //   99	111	117	finally
  }
  
  private boolean a(MsgInfo paramMsgInfo, long paramLong1, byte[] paramArrayOfByte, long paramLong2, int paramInt, byte paramByte, long paramLong3, List<String> paramList, antl paramantl, antp paramantp)
  {
    long l = PkgTools.getLongData(paramArrayOfByte, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + paramLong3 + " memberUin: " + l);
    }
    String str = String.valueOf(l);
    if (a(l, paramLong3, paramMsgInfo.shMsgSeq)) {
      return true;
    }
    paramArrayOfByte = a(paramMsgInfo);
    if ((TextUtils.isEmpty(paramArrayOfByte)) || (ContactUtils.isDiscussionMeeting(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "coptype 2 server memberName empty");
      }
      paramArrayOfByte = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong3), str);
    }
    paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691763, new Object[] { paramArrayOfByte });
    paramList.add(str);
    paramantl.a(paramLong3, str, paramList, 10009);
    if (str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      paramantp.a(String.valueOf(paramLong3), String.valueOf(l));
      a(paramByte, paramLong3, l);
      paramantl.a(String.valueOf(paramLong3));
      return true;
    }
    paramantl.a(paramLong3);
    paramantp.a(String.valueOf(paramLong3), String.valueOf(l));
    a(paramMsgInfo, paramLong1, paramLong2, paramLong2, paramArrayOfByte);
    return false;
  }
  
  private boolean a(MsgInfo paramMsgInfo, byte[] paramArrayOfByte, int paramInt, long paramLong, antl paramantl, anvk paramanvk, antp paramantp)
  {
    long l1 = PkgTools.getLongData(paramArrayOfByte, paramInt);
    long l2 = PkgTools.getLongData(paramArrayOfByte, paramInt + 4);
    new StringBuilder().append(String.valueOf(paramLong)).append("_").append(String.valueOf(l1)).toString();
    a(paramMsgInfo);
    if ((paramMsgInfo.vNickName != null) && (paramMsgInfo.vNickName.size() > 1)) {
      paramArrayOfByte = (String)paramMsgInfo.vNickName.get(1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg discussionUin: " + paramLong + " memberUin: " + l2);
    }
    if (a(l2, paramLong, paramMsgInfo.shMsgSeq))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg memberChangeMsgFilter return");
      }
      return true;
    }
    paramantl.a(paramLong);
    paramInt = paramantp.a(paramLong + "");
    if (!paramantp.a(String.valueOf(paramLong), String.valueOf(l2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionUpdateMsg add discussion " + paramLong + " member number by 1 " + l2 + " num: " + paramInt);
      }
      paramMsgInfo = new DiscussionMemberInfo();
      paramMsgInfo.discussionUin = String.valueOf(paramLong);
      paramMsgInfo.memberUin = String.valueOf(l2);
      paramMsgInfo.flag = 0;
      paramArrayOfByte = paramanvk.e(String.valueOf(l2));
      if ((paramArrayOfByte != null) && (paramArrayOfByte.name != null)) {
        paramMsgInfo.memberName = paramArrayOfByte.name;
      }
      paramantp.a(paramMsgInfo);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "handleDiscussionMemchangeMsg setDiscussionMemberNum memnum" + paramInt);
      }
    }
    return false;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getSendingTroopMsgItem(paramMessageRecord.frienduin, 3000, paramMessageRecord);
      if (localMessageRecord != null)
      {
        if (((paramMessageRecord instanceof MessageForText)) && ((localMessageRecord instanceof MessageForText)) && (paramMessageRecord.getRepeatCount() > 0))
        {
          localMessageRecord.setRepeatCount(paramMessageRecord.getRepeatCount());
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc", 2, "<---handleMsgPush_PB_Dis ===> update findMr.repeatCount=" + localMessageRecord.getRepeatCount());
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramMessageRecord.frienduin, 3000, localMessageRecord.uniseq, paramMessageRecord.shmsgseq, paramMessageRecord.time);
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramMessageRecord, localMessageRecord);
        TianShuManager.getInstance().cacheTraceInfo(localMessageRecord.getExtInfoFromExtStr("report_key_bytes_oac_msg_extend"));
        a(localMessageRecord);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().h(paramMessageRecord.frienduin, paramMessageRecord.shmsgseq);
        agfe.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord.uniseq);
        return true;
      }
      paramMessageRecord.isread = true;
      paramMessageRecord.issend = 2;
      this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setReadFrom(paramMessageRecord.frienduin, 3000, paramMessageRecord.shmsgseq);
    }
    return false;
  }
  
  private boolean a(String paramString, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getSendingTroopMsgItem(paramMessageRecord.frienduin, 3000, paramMessageRecord);
      if (localMessageRecord != null)
      {
        if (((paramMessageRecord instanceof MessageForText)) && ((localMessageRecord instanceof MessageForText)) && (paramMessageRecord.getRepeatCount() > 0))
        {
          localMessageRecord.setRepeatCount(paramMessageRecord.getRepeatCount());
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.DiscMsgPc", 2, "<---initGetPullDiscussionMsg_PB ===> update findMr.repeatCount=" + paramMessageRecord.getRepeatCount());
          }
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().d()) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(paramMessageRecord.frienduin, 3000, localMessageRecord.uniseq, paramMessageRecord.shmsgseq, paramMessageRecord.time);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().h(paramString, paramMessageRecord.shmsgseq);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg, long paramLong1, long paramLong2, int paramInt)
  {
    if (!MessageHandler.b)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(String.valueOf(paramLong1)) != 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().d(String.valueOf(paramLong1), new Object[] { paramMsg, paramFromServiceMsg, paramPbPushMsg });
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.DiscMsgPc", 2, "handleMsgPush_PB_Dis unfinished discussionUin=" + paramLong1);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramLong2, paramPbPushMsg.svrip.get(), paramInt);
        return true;
      }
    }
    else if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.d())
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().d(String.valueOf(paramLong1), new Object[] { paramMsg, paramFromServiceMsg, paramPbPushMsg });
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.b(paramLong2, paramPbPushMsg.svrip.get(), paramInt);
      return true;
    }
    return false;
  }
  
  private void b(long paramLong1, long paramLong2, ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2)
  {
    int i;
    if (paramArrayList2.size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramArrayList1);
      boolean bool2 = anyv.a(paramArrayList2);
      i = acnh.a(paramArrayList2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramArrayList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop))
      {
        bool1 = true;
        paramArrayList1.addMessage(paramArrayList2, String.valueOf(paramLong2), bool1);
        paramArrayList1 = new HashMap();
        paramArrayList2 = paramArrayList2.iterator();
      }
      label94:
      Object localObject;
      for (;;)
      {
        if (!paramArrayList2.hasNext()) {
          break label269;
        }
        localObject = (MessageRecord)paramArrayList2.next();
        if (((MessageRecord)localObject).istroop == 3000)
        {
          if (paramArrayList1.containsKey(((MessageRecord)localObject).frienduin))
          {
            String str = ((MessageRecord)localObject).frienduin;
            if (((MessageRecord)localObject).shmsgseq > ((Long)paramArrayList1.get(((MessageRecord)localObject).frienduin)).longValue()) {}
            for (paramLong2 = ((MessageRecord)localObject).shmsgseq;; paramLong2 = ((Long)paramArrayList1.get(((MessageRecord)localObject).frienduin)).longValue())
            {
              paramArrayList1.put(str, Long.valueOf(paramLong2));
              break label94;
              bool1 = false;
              break;
            }
          }
          paramArrayList1.put(((MessageRecord)localObject).frienduin, Long.valueOf(Math.max(((MessageRecord)localObject).shmsgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().h(((MessageRecord)localObject).frienduin))));
        }
      }
      label269:
      paramArrayList2 = paramArrayList1.keySet().iterator();
      while (paramArrayList2.hasNext())
      {
        localObject = (String)paramArrayList2.next();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().h((String)localObject, ((Long)paramArrayList1.get(localObject)).longValue());
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2)) || (acnh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(paramLong1), 3000))) {
        break label381;
      }
    }
    label381:
    for (boolean bool1 = true;; bool1 = false)
    {
      a("handleMsgPush_PB_Dis", true, i, bool1, false);
      return;
    }
  }
  
  private void b(Pair<Long, String> paramPair, MsgInfo paramMsgInfo, ArrayList<Pair<String, String>> paramArrayList, long paramLong, String paramString, byte paramByte, boolean paramBoolean)
  {
    a(paramPair, paramMsgInfo, paramArrayList, paramLong, paramString, paramByte, 0L, paramBoolean);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i = paramArrayOfByte.length - paramInt;
    paramMessageRecord = new byte[i];
    PkgTools.getBytesData(paramArrayOfByte, paramInt, paramMessageRecord, i);
    paramArrayOfByte = new oidb_0x858.NotifyMsgBody();
    try
    {
      paramArrayOfByte.mergeFrom(paramMessageRecord);
      paramInt = paramArrayOfByte.opt_enum_type.get();
      long l = paramArrayOfByte.opt_uint64_conf_uin.get();
      if (paramInt == 11)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloGameManager", 2, "apollo game status push, [Discussion].");
        }
        if (!paramArrayOfByte.opt_stcm_game_state.has()) {
          return;
        }
        paramArrayOfByte = (apollo_game_status.STCMGameMessage)paramArrayOfByte.opt_stcm_game_state.get();
        if (paramQQAppInterface == null) {
          return;
        }
        ((amma)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a(0, 3000, Long.toString(l), paramArrayOfByte);
        return;
      }
      if (paramInt == 12)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPushManager", 2, "recv action push message, [Discussion].");
        }
        if (!paramArrayOfByte.apllo_msg_push.has()) {
          return;
        }
        paramArrayOfByte = (apollo_push_msgInfo.STPushMsgElem)paramArrayOfByte.apllo_msg_push.get();
        if (paramQQAppInterface == null) {
          return;
        }
        ((amnd)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_PUSH_MANAGER)).a(3000, paramArrayOfByte);
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      QLog.e("Q.msg.DiscMsgPc", 1, "parse0x20c_subType0x23 Exception " + paramQQAppInterface.getStackTrace());
      return;
    }
    if (paramInt == 13)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc", 2, "goldmsg push, [Discussion].");
      }
      if (paramArrayOfByte.opt_msg_goldtips.has())
      {
        paramQQAppInterface = (oidb_0x858.GoldMsgTipsElem)paramArrayOfByte.opt_msg_goldtips.get();
        if ((paramQQAppInterface.type.has()) && (paramQQAppInterface.type.get() == 3)) {
          akwm.a(3000, null, (oidb_0x858.GoldMsgTipsElem)paramArrayOfByte.opt_msg_goldtips.get());
        }
      }
    }
  }
  
  private void b(ArrayList<MessageRecord> paramArrayList)
  {
    antl localantl = (antl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
      {
        localMessageRecord.isread = true;
        localMessageRecord.issend = 2;
      }
      try
      {
        localantl.a(Long.parseLong(localMessageRecord.frienduin), Long.parseLong(localMessageRecord.senderuin));
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.DiscMsgPc", 2, "processOffline exception when checkAndGetDiscussionMemberExist " + localMessageRecord.frienduin + ":" + localMessageRecord.senderuin);
      }
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    int i = paramArrayOfByte.length - paramInt;
    paramMessageRecord = new byte[i];
    PkgTools.getBytesData(paramArrayOfByte, paramInt, paramMessageRecord, i);
    paramArrayOfByte = new oidb_0x858.NotifyMsgBody();
    try
    {
      paramArrayOfByte.mergeFrom(paramMessageRecord);
      paramInt = paramArrayOfByte.opt_enum_type.get();
      paramArrayOfByte.opt_uint64_conf_uin.get();
      if ((paramInt == 9) && (paramArrayOfByte.opt_msg_obj_update.has()))
      {
        paramMessageRecord = (oidb_0x858.NotifyObjmsgUpdate)paramArrayOfByte.opt_msg_obj_update.get();
        if (paramMessageRecord.bytes_ext_msg.has())
        {
          paramArrayOfByte = new SubMsgType0xaa.MsgBody();
          try
          {
            paramArrayOfByte.mergeFrom(paramMessageRecord.bytes_ext_msg.get().toByteArray());
            ((avhf)paramQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(paramArrayOfByte, false);
            return;
          }
          catch (Exception paramMessageRecord)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GameParty", 2, "recv 0x858_notifyobjmsgupdate, prase msgBody error");
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg.DiscMsgPc", 2, "parse0x20c_subType0x22 Exception " + paramQQAppInterface.getStackTrace());
      }
    }
  }
  
  public acnr a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return null;
      if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null)) {
        return new acnr(a(paramMsgInfo, paramSvcReqPushMsg), false);
      }
      a(getClass().getName(), paramInt);
    }
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, bcsd parambcsd)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    bffl localbffl = new bffl();
    try
    {
      a(paramMsg, localArrayList1, parambcsd, true, localbffl);
      long l = paramMsg.msg_head.discuss_info.discuss_uin.get();
      ((awzf)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(String.valueOf(l) + "&" + 3000, localbffl);
      a(localArrayList1, localArrayList2, true);
      return localArrayList2;
    }
    catch (Exception paramMsg)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.DiscMsgPc", 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    ArrayList localArrayList;
    switch (paramInt)
    {
    default: 
      return;
    case 1001: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2], ((Boolean)paramVarArgs[3]).booleanValue());
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 3))
      {
        localArrayList = new ArrayList();
        a((ArrayList)paramVarArgs[1], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetDiscussMsgResp)paramVarArgs[2]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      localArrayList = new ArrayList();
      a((ArrayList)paramVarArgs[1], localArrayList);
      a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetDiscussMsgResp)paramVarArgs[2], (String)paramVarArgs[3]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(DisMsgReadedNotify paramDisMsgReadedNotify)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.DiscMsgPc", 2, "DisMsgReadedNotify lDisUin is " + paramDisMsgReadedNotify.lDisUin + ", lMemberSeq  is " + paramDisMsgReadedNotify.lMemberSeq);
    }
    String str = String.valueOf(paramDisMsgReadedNotify.lDisUin);
    Object[] arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(str);
    if ((arrayOfObject != null) && (arrayOfObject.length >= 2))
    {
      long l = ((Long)arrayOfObject[0]).longValue();
      ((Long)arrayOfObject[1]).longValue();
      if (l < paramDisMsgReadedNotify.lMemberSeq) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(str, new Object[] { Long.valueOf(paramDisMsgReadedNotify.lMemberSeq), Long.valueOf(paramDisMsgReadedNotify.lDisMsgSeq) });
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().setReadFrom(str, 3000, paramDisMsgReadedNotify.lMemberSeq);
    if (paramDisMsgReadedNotify.lMemberSeq >= 0L) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().msgNotifyManager.a(str, 3000);
    }
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    super.a(paramString, paramInt, paramLong);
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    msg_svc.PbDiscussReadedReportReq localPbDiscussReadedReportReq = new msg_svc.PbDiscussReadedReportReq();
    localPbDiscussReadedReportReq.conf_uin.set(Long.valueOf(paramString).longValue());
    localPbDiscussReadedReportReq.last_read_seq.set(paramLong);
    localPbMsgReadedReportReq.dis_read_report.add(localPbDiscussReadedReportReq);
    a(localPbMsgReadedReportReq);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aonw
 * JD-Core Version:    0.7.0.1
 */