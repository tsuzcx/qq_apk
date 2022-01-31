import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.troop.data.TroopMessageManager.1;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class azqz
  extends akon
{
  public static long b;
  public int a;
  public long a;
  private HashMap<String, HashSet<String>> a;
  public boolean a;
  public int b;
  public int c;
  
  public azqz(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade)
  {
    super(paramQQAppInterface, paramQQMessageFacade);
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public int a(int paramInt, ConversationInfo paramConversationInfo)
  {
    if (akpc.a(paramConversationInfo) > 0)
    {
      HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      if (paramInt == 2)
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramConversationInfo.uin, paramConversationInfo.type)) && (this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a().b(paramConversationInfo.uin, paramConversationInfo.type)) && (!localHotChatManager.b(paramConversationInfo.uin))) {
          return akpc.a(paramConversationInfo);
        }
        return 0;
      }
    }
    return super.a(paramInt, paramConversationInfo);
  }
  
  public MessageForGrayTips a(QQAppInterface paramQQAppInterface, String paramString, TroopTipsEntity paramTroopTipsEntity)
  {
    int n = 0;
    if ((paramString == null) || (paramTroopTipsEntity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "addTroopTipsMessage parm null");
      }
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "addTroopTipsMessage troopTipsEntity.optShowLatest:" + paramTroopTipsEntity.optShowLatest);
    }
    int j;
    int k;
    label150:
    int m;
    if (((paramQQAppInterface.a().a() == 1) && (paramString.equals(paramQQAppInterface.a().a()))) || (paramTroopTipsEntity.need2InsertIntoMsgListRightNow()))
    {
      paramString = paramQQAppInterface.a(1).b(paramString, 1);
      if (paramString == null)
      {
        j = 0;
        i = n;
        if (paramTroopTipsEntity.repeatInterval > 0)
        {
          i = n;
          if (j > 0)
          {
            if (paramTroopTipsEntity.repeatInterval >= paramString.size()) {
              break label299;
            }
            k = paramTroopTipsEntity.repeatInterval;
            m = 0;
            label153:
            i = n;
            if (m < k)
            {
              MessageRecord localMessageRecord = (MessageRecord)paramString.get(j - k + m);
              if ((localMessageRecord.msgtype != 2024) || (!String.valueOf(paramTroopTipsEntity.serviceType).equals(localMessageRecord.getExtInfoFromExtStr("gray_tips_serviceType")))) {
                break label310;
              }
              if (!QLog.isColorLevel()) {
                break label355;
              }
              QLog.i("Q.msg.BaseMessageManager", 2, String.format("processTroopTipsEntity discard seq:%s interval:%d", new Object[] { Long.valueOf(paramTroopTipsEntity.msgSeq), Integer.valueOf(paramTroopTipsEntity.repeatInterval) }));
            }
          }
        }
      }
    }
    label299:
    label310:
    label355:
    for (int i = 1;; i = 1)
    {
      paramTroopTipsEntity.read = true;
      paramQQAppInterface = (bamj)paramQQAppInterface.getManager(81);
      if ((paramQQAppInterface != null) && (i == 0))
      {
        return paramQQAppInterface.b(paramTroopTipsEntity);
        j = paramString.size();
        break;
        k = paramString.size();
        break label150;
        m += 1;
        break label153;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager", 2, "saveTroopTips");
        }
        paramString = (bamj)paramQQAppInterface.getManager(81);
        if (paramString != null) {
          paramString.a(paramQQAppInterface, paramTroopTipsEntity);
        }
      }
      return null;
    }
  }
  
  protected String a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString1)) {}
    for (paramString2 = ajyc.a(2131715656); paramString2 == null; paramString2 = bbcl.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1)) {
      return paramString1;
    }
    return paramString2;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ArrayList<TroopNotificationCache> paramArrayList, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "addTroopNotificationMessage");
    }
    paramString1 = paramQQAppInterface.a(1).e(String.valueOf(paramString2), 1);
    if ((paramString1 != null) && (!paramString1.isEmpty()) && (paramInt1 == 23))
    {
      paramString1 = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        TroopNotificationCache localTroopNotificationCache = (TroopNotificationCache)localIterator.next();
        localTroopNotificationCache.read = true;
        localTroopNotificationCache.currentUin = paramQQAppInterface.getCurrentAccountUin();
        paramString1.a(localTroopNotificationCache);
      }
      paramString1.a();
    }
    balq.a(paramQQAppInterface, paramString2, paramArrayList, paramInt2, paramInt3, paramString3);
  }
  
  public void a(MessageRecord paramMessageRecord, aukn paramaukn, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, akol paramakol)
  {
    if (paramMessageRecord == null) {
      return;
    }
    Map localMap1 = paramakol.jdField_a_of_type_JavaUtilMap;
    Map localMap2 = paramakol.b;
    Map localMap3 = paramakol.c;
    Object localObject2 = paramakol.jdField_a_of_type_Askq;
    Object localObject1 = paramakol.jdField_a_of_type_Aktg;
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = awzw.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    String str1 = paramMessageRecord.frienduin;
    String str2 = paramMessageRecord.senderuin;
    int j = paramMessageRecord.istroop;
    long l1 = paramMessageRecord.time;
    RecentUser localRecentUser = ((aktg)localObject1).a(str1, paramMessageRecord.istroop);
    if (localObject2 != null)
    {
      localObject1 = ((askq)localObject2).a(str1);
      if (localObject1 != null) {
        if (((azmj)localObject1).b() != paramMessageRecord.shmsgseq) {
          localObject1 = null;
        }
      }
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(str1);
      if (j == 1)
      {
        if ((localRecentUser.msgType == 24) || (localObject1 == null) || (((azmj)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, str1) != 24)) {
          break label1047;
        }
        if ((i != 1) && (i != 4)) {
          break label990;
        }
        axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atsign_norm", 0, 0, localRecentUser.uin, "", "", "");
        label246:
        if ((!paramMessageRecord.isSend()) && (localObject1 != null) && (((azmj)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, str1) == 17) && (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(str1)) && (MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord))) {
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C8D", "0X8005C8D", 0, 0, "", "", "", "");
        }
        if (MessageForQQWalletMsg.isCommandRedPacketMsg(paramMessageRecord))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "group command red packet, UI_BUSY");
          }
          mqq.app.MainService.sPwdPacketTime = System.currentTimeMillis();
          bbaz.a(true);
        }
        if (paramMessageRecord.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          akny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin, j, paramMessageRecord);
        }
      }
      int k;
      if ((localObject1 != null) && (((azmj)localObject1).a()))
      {
        k = ((azmj)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, str1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageManager.troop.special_msg.special_attention", 2, "addMessageRecord, bizType" + k + "|ru.msgType:" + localRecentUser.msgType);
        }
        if (azmj.a(k, localRecentUser.msgType))
        {
          localRecentUser.msgType = k;
          localRecentUser.msg = azmj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1, (azmj)localObject1, localRecentUser.msg, paramMessageRecord, true);
          if (!asfb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1))
          {
            localRecentUser.uin = str1;
            if ((j == 1000) || (j == 1020) || (j == 1004)) {
              localRecentUser.troopUin = str2;
            }
            localRecentUser.setType(j);
            if (l1 > localRecentUser.lastmsgtime) {
              localRecentUser.lastmsgtime = l1;
            }
            localMap1.put(akpy.a(str1, j), localRecentUser);
          }
          if ((j == 1) || (j == 3000))
          {
            if (k != 8) {
              break label1583;
            }
            localObject2 = "";
            if (i != 2) {
              break label1569;
            }
            localObject2 = "msg_assist";
            label651:
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", (String)localObject2, 0, 0, str1, "", "", "");
          }
        }
        label685:
        if ((j == 1) && ((k == 24) || (k == 22)) && (!mye.a(paramMessageRecord)) && (bamn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "atMeOrReplyMe")))
        {
          localObject2 = paramMessageRecord.frienduin;
          String str3 = paramMessageRecord.senderuin;
          long l2 = paramMessageRecord.time;
          long l3 = paramMessageRecord.msgseq;
          ThreadManager.getSubThreadHandler().post(new TroopMessageManager.1(this, (String)localObject2, str3, k, l2, l3));
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager", 2, "markAtOrReplyMeMsgInTroop|" + l3);
          }
        }
      }
      if (localMap1.containsKey(akpy.a(localRecentUser.uin, localRecentUser.getType()))) {}
      for (localObject2 = (RecentUser)localMap1.get(akpy.a(localRecentUser.uin, localRecentUser.getType()));; localObject2 = localRecentUser)
      {
        if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60)).b(str1)) {
          if ((!localMap3.containsKey(akpy.a(str1, j))) || (((MessageRecord)localMap3.get(akpy.a(str1, j))).time <= paramMessageRecord.time)) {
            localMap3.put(akpy.a(str1, j), paramMessageRecord);
          }
        }
        for (;;)
        {
          super.a(paramMessageRecord, paramaukn, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramakol);
          paramaukn = ayfw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramaukn.a(paramMessageRecord);
          paramaukn.a();
          return;
          if (!paramMessageRecord.isread) {
            break label2242;
          }
          ((askq)localObject2).b(str1);
          localObject1 = null;
          break;
          label990:
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localRecentUser.uin) != 2) {
            break label246;
          }
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atsign_grphelper", 0, 0, localRecentUser.uin, "", "", "");
          break label246;
          label1047:
          boolean bool;
          if ((localRecentUser.msgType != 17) && (localRecentUser.msgType != 22) && (localRecentUser.msgType != 24) && (localObject1 != null) && (((azmj)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, str1) == 17))
          {
            bool = paramMessageRecord instanceof MessageForQQWalletMsg;
            if ((i == 3) || (i == 4))
            {
              if (bool)
              {
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_hongbaoSign_allscreen", 0, 0, localRecentUser.uin, "", "", "");
                break label246;
              }
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_allscreen", 0, 0, localRecentUser.uin, "", "", "");
              break label246;
            }
            if (i == 2)
            {
              if (bool)
              {
                axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_hongbaoSign_grphelper", 0, 0, localRecentUser.uin, "", "", "");
                break label246;
              }
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_grphelper", 0, 0, localRecentUser.uin, "", "", "");
              break label246;
            }
            if (i != 1) {
              break label246;
            }
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_sfsign_norm", 0, 0, localRecentUser.uin, "", "", "");
            break label246;
          }
          if ((localRecentUser.msgType == 17) || (localRecentUser.msgType == 22) || (localRecentUser.msgType == 24) || (localRecentUser.msgType == 13) || (localObject1 == null) || (((azmj)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, str1) != 13)) {
            break label246;
          }
          if ((i == 3) || (i == 4)) {
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_allscreen", 0, 0, localRecentUser.uin, "", "", "");
          }
          for (;;)
          {
            if (!QLog.isColorLevel()) {
              break label1567;
            }
            QLog.d("Q.msg.BaseMessageManager.troop.special_msg", 2, "addMessageRecord");
            break;
            if (i == 2) {
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_grphelper", 0, 0, localRecentUser.uin, "", "", "");
            } else if (i == 1) {
              axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Appear_atall_norm", 0, 0, localRecentUser.uin, "", "", "");
            }
          }
          label1567:
          break label246;
          label1569:
          if (i != 1) {
            break label651;
          }
          localObject2 = "msg_public";
          break label651;
          label1583:
          if (k != 22) {
            break label685;
          }
          if (j == 3000) {}
          for (localObject2 = "Grp_Dis_replyMsg";; localObject2 = "Grp_replyMsg")
          {
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", (String)localObject2, "", "Msglist", "Appear_replySign", 0, 0, localRecentUser.troopUin, "" + i, "", "");
            if ((i != 3) && (i != 4)) {
              break label1718;
            }
            axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", (String)localObject2, "", "Msglist", "Appear_replySign_allscreen", 0, 0, localRecentUser.troopUin, "", "", "");
            break;
          }
          label1718:
          if (i != 2) {
            break label685;
          }
          axqw.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", (String)localObject2, "", "Msglist", "Appear_replySign_grphelper", 0, 0, localRecentUser.troopUin, "", "", "");
          break label685;
          if ((!akpy.g(paramMessageRecord.msgtype)) && (!akpy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord)))
          {
            if ((j == 1) && (i != 1) && (i != 4))
            {
              if (localObject1 == null) {}
              for (i = 0;; i = ((azmj)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, str1))
              {
                if ((i == 17) || (i == 24) || (i == 16) || (i == 13) || (i == 5) || (i == 27) || (i == 18) || (i == 22) || (i == 14) || (i == 4) || (i == 10) || (i == 11))
                {
                  ((RecentUser)localObject2).uin = str1;
                  if ((j == 1000) || (j == 1020) || (j == 1004)) {
                    ((RecentUser)localObject2).troopUin = str2;
                  }
                  ((RecentUser)localObject2).setType(j);
                  if (l1 > ((RecentUser)localObject2).lastmsgtime) {
                    ((RecentUser)localObject2).lastmsgtime = l1;
                  }
                  localMap1.put(akpy.a(str1, j), localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageManager.troop.special_msg", 2, "addMessageRecord, MsgBizType:" + i + "uin:" + ((RecentUser)localObject2).uin);
                  }
                }
                if ((!asfb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str1)) || ((localMap2.containsKey(akpy.a(str1, j))) && (((MessageRecord)localMap2.get(akpy.a(str1, j))).time > paramMessageRecord.time))) {
                  break;
                }
                localMap2.put(akpy.a(str1, j), paramMessageRecord);
                break;
              }
            }
            if ((paramMessageRecord.isLongMsg()) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord)))
            {
              if (QLog.isColorLevel()) {
                QLog.i("Q.msg.BaseMessageManager", 2, "addMessageRecord, long msg uncompleted");
              }
            }
            else
            {
              ((RecentUser)localObject2).uin = str1;
              ((RecentUser)localObject2).setType(j);
              bool = true;
              if ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
                bool = ((MessageForUniteGrayTip)paramMessageRecord).tipParam.d;
              }
              if ((l1 > ((RecentUser)localObject2).lastmsgtime) && (bool)) {
                ((RecentUser)localObject2).lastmsgtime = l1;
              }
              localMap1.put(akpy.a(str1, j), localObject2);
            }
          }
        }
      }
      label2242:
      continue;
      localObject1 = null;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    super.a(paramString, paramInt);
    ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    RecentUser localRecentUser = localProxyManager.a().a(paramString, paramInt);
    c(paramString, paramInt, 9223372036854775807L);
    if ((localRecentUser.shouldShowInRecentList()) || (localRecentUser.msgType == 11))
    {
      localRecentUser.cleanMsgAndMsgData(localRecentUser.msgType);
      localProxyManager.a().a(localRecentUser);
    }
    if (paramInt == 1)
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString);
      if ((paramInt != 1) && (paramInt != 4))
      {
        ahnn.a().a(localRecentUser.uin + "-" + localRecentUser.getType());
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(localRecentUser);
      }
    }
  }
  
  protected void a(String paramString, int paramInt, long paramLong)
  {
    super.a(paramString, paramInt, paramLong);
    c(paramString, paramInt, paramLong);
  }
  
  public void a(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    super.a(paramString, paramInt, paramLong, paramBoolean);
    bamq localbamq = (bamq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
    if (localbamq != null) {
      localbamq.a(paramString);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramString1);
    if ((paramInt == 1) && (i != 1) && (i != 4))
    {
      if (i == 2) {
        paramString2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      try
      {
        asfb.a().a(paramString1, paramLong, paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        paramString2.a();
        this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.a(null);
        return;
      }
      finally
      {
        paramString2.a();
      }
    }
    super.a(paramString1, paramInt, paramString2, paramString3, paramLong);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramString, paramInt, paramBoolean1, paramBoolean2);
    bamq localbamq = (bamq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
    if (localbamq != null) {
      localbamq.a(paramString);
    }
  }
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    super.a(paramString, paramInt1, paramBoolean1, paramBoolean2, paramInt2);
    bamq localbamq = (bamq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
    if (localbamq != null) {
      localbamq.a(paramString);
    }
  }
  
  /* Error */
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 90	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9: lload_2
    //   10: invokevirtual 475	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   13: ldc_w 343
    //   16: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: lload 4
    //   21: invokevirtual 475	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   24: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore 6
    //   29: aload_0
    //   30: getfield 27	azqz:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   33: aload_1
    //   34: invokevirtual 625	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   37: ifeq +23 -> 60
    //   40: aload_0
    //   41: getfield 27	azqz:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   44: aload_1
    //   45: invokevirtual 626	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   48: checkcast 628	java/util/HashSet
    //   51: aload 6
    //   53: invokevirtual 631	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   56: pop
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: new 628	java/util/HashSet
    //   63: dup
    //   64: invokespecial 632	java/util/HashSet:<init>	()V
    //   67: astore 7
    //   69: aload 7
    //   71: aload 6
    //   73: invokevirtual 631	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   76: pop
    //   77: aload_0
    //   78: getfield 27	azqz:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   81: aload_1
    //   82: aload 7
    //   84: invokevirtual 633	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   87: pop
    //   88: goto -31 -> 57
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	azqz
    //   0	96	1	paramString	String
    //   0	96	2	paramLong1	long
    //   0	96	4	paramLong2	long
    //   27	45	6	str	String
    //   67	16	7	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   2	57	91	finally
    //   60	88	91	finally
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade.b.containsKey(akpy.a(paramString, paramInt));
  }
  
  protected String b(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString1)) {}
    for (paramString2 = ajyc.a(2131715657); paramString2 == null; paramString2 = bbcl.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString2, paramString1)) {
      return paramString1;
    }
    return paramString2;
  }
  
  public void b(String paramString, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) > 0) {
      c(paramString, paramInt, paramLong);
    }
    super.b(paramString, paramInt, paramLong);
  }
  
  public void b(String paramString, long paramLong1, long paramLong2)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        HashSet localHashSet = (HashSet)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        localHashSet.remove(paramLong1 + "" + paramLong2);
        if (localHashSet.isEmpty())
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
          setChanged();
          notifyObservers();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg", 2, "并发拉取完成，troopUin:" + paramString);
          }
        }
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	azqz:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 625	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: istore_2
    //   11: iload_2
    //   12: ifeq +9 -> 21
    //   15: iconst_0
    //   16: istore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: iconst_1
    //   22: istore_2
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	azqz
    //   0	31	1	paramString	String
    //   10	13	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	26	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azqz
 * JD-Core Version:    0.7.0.1
 */