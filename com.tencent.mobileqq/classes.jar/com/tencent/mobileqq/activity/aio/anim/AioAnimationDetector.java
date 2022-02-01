package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsPlayer;
import com.tencent.mobileqq.activity.aio.anim.businesseggs.DragonKingEggsPlayer;
import com.tencent.mobileqq.activity.aio.anim.businesseggs.LevelEggsPlayer;
import com.tencent.mobileqq.activity.aio.anim.egg.EggKeyword;
import com.tencent.mobileqq.activity.aio.anim.egg.IEggBizPlayer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class AioAnimationDetector
{
  private static volatile AioAnimationDetector jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector;
  public volatile long a;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private List<IEggBizPlayer> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, CopyOnWriteArraySet<Long>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  public volatile boolean a;
  private long jdField_b_of_type_Long = -1L;
  private boolean jdField_b_of_type_Boolean = false;
  
  private AioAnimationDetector()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Boolean = false;
    b();
  }
  
  public static AioAnimationDetector a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector == null) {
          jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector = new AioAnimationDetector();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationDetector;
  }
  
  private void a(long paramLong, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage.time > paramLong) && (!paramChatMessage.isSend())) {
      paramChatMessage.mNewAnimFlag = true;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, AioAnimationRule paramAioAnimationRule)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (EggsUtil.a(paramAioAnimationRule)) {
        AIOUtils.a(paramQQAppInterface, true);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, AioAnimationRule paramAioAnimationRule, boolean paramBoolean, ChatMessage paramChatMessage)
  {
    CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramAioAnimationRule.jdField_b_of_type_Int));
    if (localCopyOnWriteArraySet == null) {
      return;
    }
    if (localCopyOnWriteArraySet.contains(Long.valueOf(paramChatMessage.shmsgseq)))
    {
      if (paramBoolean) {
        EggsUtil.a(paramQQAppInterface, "0X800B071", paramChatMessage.frienduin, paramAioAnimationRule);
      }
      localCopyOnWriteArraySet.remove(Long.valueOf(paramChatMessage.shmsgseq));
    }
    if (ListUtils.a(localCopyOnWriteArraySet)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramAioAnimationRule.jdField_b_of_type_Int));
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt)
  {
    if (paramInt == 0)
    {
      paramChatMessage = "0X8004A27";
    }
    else
    {
      if (paramInt == 1)
      {
        if (paramChatMessage.istroop == 1)
        {
          paramChatMessage = "0X8004A28";
          break label48;
        }
        if (paramChatMessage.istroop == 3000)
        {
          paramChatMessage = "0X8004A29";
          break label48;
        }
      }
      paramChatMessage = "";
    }
    label48:
    if (!TextUtils.isEmpty(paramChatMessage)) {
      VipUtils.a(paramQQAppInterface, "Vip_StructuredEgg", paramChatMessage, paramChatMessage, 0, 0, new String[0]);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt1, int paramInt2, AioAnimationRule paramAioAnimationRule)
  {
    if (paramInt1 == 0)
    {
      paramInt1 = 0;
    }
    else
    {
      if (paramInt1 == 1)
      {
        if (paramChatMessage.istroop == 1)
        {
          paramInt1 = 1;
          break label44;
        }
        if (paramChatMessage.istroop == 3000)
        {
          paramInt1 = 2;
          break label44;
        }
      }
      paramInt1 = -1;
    }
    label44:
    if (paramInt2 == 2)
    {
      if (!paramChatMessage.isSendFromLocal())
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_rec", 0, 0, String.valueOf(paramInt1), String.valueOf(paramAioAnimationRule.jdField_b_of_type_Int), "", "");
        return;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_launch", 0, 0, String.valueOf(paramInt1), String.valueOf(paramAioAnimationRule.jdField_b_of_type_Int), "", "");
      return;
    }
    if (paramInt2 == 3)
    {
      if (!paramChatMessage.isSendFromLocal())
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_rec", 0, 0, String.valueOf(paramInt1), String.valueOf(paramAioAnimationRule.jdField_b_of_type_Int), "", "");
        return;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_launch", 0, 0, String.valueOf(paramInt1), String.valueOf(paramAioAnimationRule.jdField_b_of_type_Int), "", "");
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, AioAnimationRule paramAioAnimationRule)
  {
    if (a(paramQQAppInterface, paramChatMessage, 2, paramAIOAnimationConatiner, paramInt, paramAioAnimationRule)) {
      return;
    }
    if (paramAioAnimationRule.jdField_a_of_type_Boolean)
    {
      int j = paramAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.size();
      int i = 0;
      while (i < j)
      {
        localObject = (AioAnimationRule.JumpImage)paramAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.get(i);
        localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
        int k = i * 800;
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.11(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, k, paramAioAnimationRule, paramChatMessage), paramInt + k);
        i += 1;
      }
    }
    Object localObject = (AioAnimationRule.JumpImage)paramAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.get(0);
    localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.12(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, paramAioAnimationRule, paramChatMessage), paramInt);
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, AioAnimationRule paramAioAnimationRule)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detect combo =======> isLastStackMessageFromOthers ? ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append("  lastStackMessageSeq=");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      localStringBuilder.append("thisMessageSeq=");
      localStringBuilder.append(paramChatMessage.shmsgseq);
      QLog.d("AioAnimationDetector", 2, localStringBuilder.toString());
    }
    if ((paramChatMessage.isSendFromLocal()) && (this.jdField_b_of_type_Boolean) && (paramChatMessage.shmsgseq == this.jdField_b_of_type_Long + 1L)) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Eggs_stack_new", 0, 0, String.valueOf(0), String.valueOf(paramAioAnimationRule.jdField_b_of_type_Int), "", "");
    }
    this.jdField_b_of_type_Boolean = (paramChatMessage.isSendFromLocal() ^ true);
    this.jdField_b_of_type_Long = paramChatMessage.shmsgseq;
  }
  
  private void a(QQAppInterface paramQQAppInterface, @NonNull ArrayList<AioAnimationRule> paramArrayList, ChatMessage paramChatMessage)
  {
    if (!paramChatMessage.isSend()) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      AioAnimationRule localAioAnimationRule = (AioAnimationRule)paramArrayList.next();
      EggsUtil.a(paramQQAppInterface, "0X800B070", paramChatMessage.frienduin, localAioAnimationRule);
    }
  }
  
  private void a(ChatMessage paramChatMessage, AioAnimationRule paramAioAnimationRule)
  {
    try
    {
      CopyOnWriteArraySet localCopyOnWriteArraySet2 = (CopyOnWriteArraySet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramAioAnimationRule.jdField_b_of_type_Int));
      CopyOnWriteArraySet localCopyOnWriteArraySet1 = localCopyOnWriteArraySet2;
      if (localCopyOnWriteArraySet2 == null)
      {
        localCopyOnWriteArraySet1 = new CopyOnWriteArraySet();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramAioAnimationRule.jdField_b_of_type_Int), localCopyOnWriteArraySet1);
      }
      localCopyOnWriteArraySet1.add(Long.valueOf(paramChatMessage.shmsgseq));
      return;
    }
    finally {}
  }
  
  private void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo)
  {
    b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IEggBizPlayer)localIterator.next()).a(paramChatMessage, paramQQAppInterface, paramBaseSessionInfo);
    }
  }
  
  private void a(List<ChatMessage> paramList)
  {
    b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((IEggBizPlayer)localIterator.next()).a(paramList);
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt1, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt2, AioAnimationRule paramAioAnimationRule)
  {
    b();
    int i = paramAioAnimationRule.jdField_a_of_type_Int;
    if (i != -1)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localIEggBizPlayer = (IEggBizPlayer)localIterator.next();
        if (localIEggBizPlayer.a() == i) {
          break label68;
        }
      }
      IEggBizPlayer localIEggBizPlayer = null;
      label68:
      if ((localIEggBizPlayer != null) && ((localIEggBizPlayer.b() & paramInt1) != 0))
      {
        localIEggBizPlayer.a(paramQQAppInterface, this.jdField_a_of_type_AndroidOsHandler, paramChatMessage, paramAIOAnimationConatiner, paramInt2, paramAioAnimationRule);
        QLog.d("AioAnimationDetector", 1, new Object[] { "[onGroupAnimationTriggered] play dispatch to ", Integer.valueOf(localIEggBizPlayer.a()), ", id: ", Integer.valueOf(paramAioAnimationRule.jdField_b_of_type_Int), ", session: ", Integer.valueOf(paramInt1) });
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(new DragonKingEggsPlayer());
      this.jdField_a_of_type_JavaUtilList.add(new BusinessEggsPlayer());
      this.jdField_a_of_type_JavaUtilList.add(new LevelEggsPlayer());
    }
  }
  
  private void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, AioAnimationRule paramAioAnimationRule)
  {
    int j = paramAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (AioAnimationRule.JumpImage)paramAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.get(i);
      localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
      int k = i * 800;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.13(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, k, paramAioAnimationRule, paramChatMessage), paramInt + k);
      i += 1;
    }
  }
  
  private void c()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null)
    {
      localList.clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
  }
  
  private void c(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, AioAnimationRule paramAioAnimationRule)
  {
    Object localObject = (AioAnimationRule.JumpImage)paramAioAnimationRule.jdField_b_of_type_JavaUtilArrayList.get(0);
    localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.14(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, paramAioAnimationRule, paramChatMessage), paramInt);
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IEggBizPlayer)((Iterator)localObject).next()).a();
      }
    }
  }
  
  public String a(AbsShareMsg paramAbsShareMsg)
  {
    if ((paramAbsShareMsg != null) && (paramAbsShareMsg.getItemCount() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramAbsShareMsg = paramAbsShareMsg.iterator();
      while (paramAbsShareMsg.hasNext())
      {
        Object localObject = (AbsStructMsgElement)paramAbsShareMsg.next();
        if ((localObject instanceof AbsStructMsgItem))
        {
          localObject = ((AbsStructMsgItem)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
            String str = localAbsStructMsgElement.jdField_a_of_type_JavaLangString;
            if ("title".equals(str)) {
              localStringBuilder.append(((StructMsgItemTitle)localAbsStructMsgElement).b());
            } else if ("summary".equals(str)) {
              localStringBuilder.append(((StructMsgItemSummary)localAbsStructMsgElement).b());
            }
          }
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public ArrayList<AioAnimationRule> a(ChatMessage paramChatMessage)
  {
    Iterator localIterator = null;
    Object localObject = null;
    AioAnimationRule localAioAnimationRule = null;
    if (paramChatMessage != null)
    {
      if (!a(paramChatMessage)) {
        return null;
      }
      localObject = AioAnimationConfigHelper.a().a();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "match : rules == null, just return;");
        }
        return null;
      }
      paramChatMessage.parse();
      long l1 = System.currentTimeMillis();
      String str;
      if (b(paramChatMessage)) {
        str = a((AbsShareMsg)((MessageForStructing)paramChatMessage).structingMsg);
      } else {
        str = paramChatMessage.msg;
      }
      paramChatMessage = localIterator;
      if (!TextUtils.isEmpty(str))
      {
        localIterator = ((ArrayList)localObject).iterator();
        localObject = localAioAnimationRule;
        label378:
        label383:
        for (;;)
        {
          paramChatMessage = (ChatMessage)localObject;
          if (!localIterator.hasNext()) {
            break;
          }
          localAioAnimationRule = (AioAnimationRule)localIterator.next();
          if (localAioAnimationRule.jdField_a_of_type_JavaUtilArrayList != null)
          {
            int i = 0;
            for (;;)
            {
              if (i >= localAioAnimationRule.jdField_a_of_type_JavaUtilArrayList.size()) {
                break label383;
              }
              if (((EggKeyword)localAioAnimationRule.jdField_a_of_type_JavaUtilArrayList.get(i)).a(str))
              {
                if (localAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData != null)
                {
                  l2 = System.currentTimeMillis() / 1000L;
                  if ((localAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.jdField_a_of_type_Int == 1) && ((localAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.jdField_b_of_type_Int > l2) || (localAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.c < l2)))
                  {
                    if (!QLog.isColorLevel()) {
                      break label378;
                    }
                    QLog.d("AioAnimationDetector", 2, "JD red pack,But not in date.");
                    break label378;
                  }
                }
                paramChatMessage = (ChatMessage)localObject;
                if (localObject == null) {
                  paramChatMessage = new ArrayList();
                }
                localAioAnimationRule = new AioAnimationRule(localAioAnimationRule);
                localAioAnimationRule.c = i;
                paramChatMessage.add(localAioAnimationRule);
                localObject = paramChatMessage;
                if (!QLog.isColorLevel()) {
                  break;
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("matched ===> rule: id=");
                ((StringBuilder)localObject).append(localAioAnimationRule.jdField_b_of_type_Int);
                ((StringBuilder)localObject).append(", index = ");
                ((StringBuilder)localObject).append(localAioAnimationRule.c);
                QLog.d("AioAnimationDetector", 2, ((StringBuilder)localObject).toString());
                localObject = paramChatMessage;
                break;
              }
              i += 1;
            }
          }
        }
      }
      long l2 = System.currentTimeMillis();
      localObject = paramChatMessage;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("match duration: ");
        ((StringBuilder)localObject).append(l2 - l1);
        ((StringBuilder)localObject).append(" ms");
        QLog.d("AioAnimationDetector", 2, ((StringBuilder)localObject).toString());
        localObject = paramChatMessage;
      }
    }
    return localObject;
  }
  
  public void a()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    c();
    d();
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, MessageRecord paramMessageRecord, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    Object localObject1 = this;
    if (paramBaseSessionInfo.jdField_a_of_type_Int != 1033)
    {
      if (paramBaseSessionInfo.jdField_a_of_type_Int == 1034) {
        return;
      }
      if ((paramMessageRecord instanceof MessageForArkFlashChat)) {
        return;
      }
      if (((AioAnimationDetector)localObject1).jdField_a_of_type_Boolean) {
        return;
      }
      long l1 = ((AioAnimationDetector)localObject1).jdField_a_of_type_Long;
      localObject1 = "AioAnimationDetector";
      if (l1 == -1L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "handleNewMsg, lastMsgIdOrTime == -1, just return");
        }
        return;
      }
      if (paramBaseSessionInfo.jdField_a_of_type_Int == 1008) {
        return;
      }
      if (UinTypeUtil.a(paramBaseSessionInfo.jdField_a_of_type_Int) == 1032) {
        return;
      }
      int k = paramBaseSessionInfo.jdField_a_of_type_Int;
      int j = 0;
      int i = 0;
      if ((k != 1) && (paramBaseSessionInfo.jdField_a_of_type_Int != 3000))
      {
        if (UinTypeUtil.b(paramBaseSessionInfo.jdField_a_of_type_Int)) {
          i = 1;
        }
        k = 0;
        j = i;
        i = k;
      }
      else
      {
        i = 1;
      }
      if ((i == 0) && (j == 0)) {
        return;
      }
      if ((paramBaseSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((paramBaseSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((j != 0) && (UinTypeUtil.b(paramMessageRecord.istroop)))))
      {
        List localList = paramQQAppInterface.getMessageFacade().a(paramBaseSessionInfo.jdField_a_of_type_JavaLangString, paramBaseSessionInfo.jdField_a_of_type_Int, true);
        Object localObject2 = a();
        l1 = ((AioAnimationDetector)localObject2).jdField_a_of_type_Long;
        j = localList.size() - 1;
        paramMessageRecord = (MessageRecord)localObject1;
        localObject1 = localObject2;
        for (;;)
        {
          Object localObject3 = this;
          if (j < 0) {
            break;
          }
          ChatMessage localChatMessage = (ChatMessage)localList.get(j);
          if (i != 0)
          {
            if (localChatMessage.shmsgseq <= l1) {
              return;
            }
            if (!localChatMessage.isAioAnimChecked)
            {
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("handle troop&discussion new message ===> (");
                ((StringBuilder)localObject2).append(localChatMessage.shmsgseq);
                ((StringBuilder)localObject2).append(")");
                QLog.d(paramMessageRecord, 2, ((StringBuilder)localObject2).toString());
              }
              ((AioAnimationDetector)localObject3).a(l1, localChatMessage);
              ((AioAnimationDetector)localObject3).a(localChatMessage, paramQQAppInterface, paramBaseSessionInfo);
              localObject2 = ((AioAnimationDetector)localObject1).a(localChatMessage);
              if (localObject2 != null) {
                ((AioAnimationDetector)localObject1).a(paramQQAppInterface, (ArrayList)localObject2, true, localChatMessage, true, paramAIOAnimationConatiner, 0, true);
              }
              ((AioAnimationDetector)localObject1).jdField_a_of_type_Long = localChatMessage.shmsgseq;
            }
          }
          else
          {
            MessageRecord localMessageRecord = paramMessageRecord;
            long l2 = l1;
            localObject2 = localObject1;
            if (localChatMessage.time <= l2) {
              return;
            }
            if (!localChatMessage.isAioAnimChecked)
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("handle c2c new message ===> (");
                localStringBuilder.append(localChatMessage.time);
                localStringBuilder.append(")");
                QLog.d(localMessageRecord, 2, localStringBuilder.toString());
              }
              ((AioAnimationDetector)localObject3).a(l2, localChatMessage);
              ((AioAnimationDetector)localObject3).a(localChatMessage, paramQQAppInterface, paramBaseSessionInfo);
              localObject3 = ((AioAnimationDetector)localObject2).a(localChatMessage);
              if (localObject3 != null) {
                ((AioAnimationDetector)localObject2).a(paramQQAppInterface, (ArrayList)localObject3, false, localChatMessage, true, paramAIOAnimationConatiner, 0, true);
              }
              ((AioAnimationDetector)localObject2).jdField_a_of_type_Long = localChatMessage.time;
            }
          }
          j -= 1;
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    if ((paramQQAppInterface != null) && (paramSessionInfo != null))
    {
      if (paramAIOAnimationConatiner == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleUnreadMsgList, hasUnRead=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
        QLog.d("AioAnimationDetector", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = paramQQAppInterface.getMessageFacade().a(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, -1L, true);
      a((List)localObject1);
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      if (paramSessionInfo.jdField_a_of_type_Int == 1008) {
        return;
      }
      if ((paramSessionInfo.jdField_a_of_type_Int != 1) && (paramSessionInfo.jdField_a_of_type_Int != 3000))
      {
        if (UinTypeUtil.b(paramSessionInfo.jdField_a_of_type_Int)) {
          i = 1;
        } else {
          i = 0;
        }
        k = 0;
        j = i;
        i = k;
      }
      else
      {
        j = 0;
        i = 1;
      }
      if ((i == 0) && (j == 0)) {
        return;
      }
      long l = this.jdField_a_of_type_Long;
      int j = ((List)localObject1).size();
      int n = 0;
      int m = 0;
      int k = i;
      int i = n;
      while (m < j)
      {
        paramSessionInfo = (ChatMessage)((List)localObject1).get(m);
        Object localObject2;
        if (k != 0)
        {
          if ((paramSessionInfo.shmsgseq >= l) && (!paramSessionInfo.isAioAnimChecked))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleUnreadMsgList, troop&discussion message ===> (");
              ((StringBuilder)localObject2).append(paramSessionInfo.shmsgseq);
              ((StringBuilder)localObject2).append(")");
              QLog.d("AioAnimationDetector", 2, ((StringBuilder)localObject2).toString());
            }
            boolean bool;
            if (m == j - 1) {
              bool = true;
            } else {
              bool = false;
            }
            localObject2 = a(paramSessionInfo);
            this.jdField_a_of_type_Long = paramSessionInfo.shmsgseq;
            if (localObject2 != null)
            {
              a(paramQQAppInterface, (ArrayList)localObject2, true, paramSessionInfo, bool, paramAIOAnimationConatiner, i * 800, false);
              i += 1;
            }
            else
            {
              break label512;
            }
          }
        }
        else
        {
          n = i;
          i = n;
          if (paramSessionInfo.time >= l)
          {
            i = n;
            if (!paramSessionInfo.isAioAnimChecked)
            {
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("handleUnreadMsgList, c2c message ===> (");
                ((StringBuilder)localObject2).append(paramSessionInfo.time);
                ((StringBuilder)localObject2).append(")");
                QLog.d("AioAnimationDetector", 2, ((StringBuilder)localObject2).toString());
              }
              localObject2 = a(paramSessionInfo);
              this.jdField_a_of_type_Long = paramSessionInfo.time;
              i = n;
              if (localObject2 != null)
              {
                a(paramQQAppInterface, (ArrayList)localObject2, false, paramSessionInfo, false, paramAIOAnimationConatiner, n * 800, false);
                i = n + 1;
              }
            }
          }
        }
        label512:
        m += 1;
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, AIOAnimationConatiner paramAIOAnimationConatiner, Drawable paramDrawable, int paramInt, AioAnimationRule paramAioAnimationRule, ChatMessage paramChatMessage)
  {
    int i;
    if (paramAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData == null) {
      i = -1;
    } else {
      i = paramAioAnimationRule.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.jdField_a_of_type_Int;
    }
    boolean bool = paramAIOAnimationConatiner.a(2, 300, new Object[] { paramDrawable, Integer.valueOf(paramInt), Integer.valueOf(i), paramAioAnimationRule, paramChatMessage });
    a(paramQQAppInterface, paramAioAnimationRule);
    a(paramQQAppInterface, paramAioAnimationRule, bool, paramChatMessage);
  }
  
  public void a(QQAppInterface paramQQAppInterface, AIOAnimationConatiner paramAIOAnimationConatiner, Drawable paramDrawable, AioAnimationRule paramAioAnimationRule, ChatMessage paramChatMessage)
  {
    a(paramQQAppInterface, paramAioAnimationRule, paramAIOAnimationConatiner.b(8, 300, new Object[] { paramDrawable, paramAioAnimationRule, paramChatMessage }), paramChatMessage);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ArrayList<AioAnimationRule> paramArrayList, boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, boolean paramBoolean3)
  {
    Object localObject6 = this;
    Object localObject5 = paramQQAppInterface;
    Object localObject4 = paramChatMessage;
    Object localObject7 = paramAIOAnimationConatiner;
    if ((localObject5 != null) && (localObject4 != null) && (localObject7 != null) && (paramArrayList != null) && (paramArrayList.size() != 0) && (((AioAnimationDetector)localObject6).a((ChatMessage)localObject4)))
    {
      paramBoolean3 = ((ChatMessage)localObject4).isAioAnimChecked;
      Object localObject1 = "AioAnimationDetector";
      if (paramBoolean3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "detect : message is checked, just return;");
        }
        return;
      }
      ((ChatMessage)localObject4).isAioAnimChecked = true;
      Object localObject3 = (EcShopAssistantManager)((QQAppInterface)localObject5).getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      Iterator localIterator = paramArrayList.iterator();
      label1805:
      for (;;)
      {
        paramBoolean3 = paramBoolean1;
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = (AioAnimationRule)localIterator.next();
        ((AioAnimationDetector)localObject6).a((ChatMessage)localObject4, (AioAnimationRule)localObject2);
        int j = paramChatMessage.getRepeatCount();
        int i = ((AioAnimationRule)localObject2).d;
        int n = ((AioAnimationRule)localObject2).e;
        if (QLog.isColorLevel())
        {
          localObject8 = new StringBuilder();
          ((StringBuilder)localObject8).append("detect : troopOrDiscussion=");
          ((StringBuilder)localObject8).append(paramBoolean3);
          ((StringBuilder)localObject8).append(" matched (");
          ((StringBuilder)localObject8).append(((ChatMessage)localObject4).uniseq);
          ((StringBuilder)localObject8).append("), rule: id=");
          ((StringBuilder)localObject8).append(((AioAnimationRule)localObject2).jdField_b_of_type_Int);
          ((StringBuilder)localObject8).append(",M=");
          ((StringBuilder)localObject8).append(j);
          ((StringBuilder)localObject8).append(",X=");
          ((StringBuilder)localObject8).append(i);
          ((StringBuilder)localObject8).append(",Y=");
          ((StringBuilder)localObject8).append(n);
          ((StringBuilder)localObject8).append(",crazyMode=");
          ((StringBuilder)localObject8).append(((AioAnimationRule)localObject2).jdField_a_of_type_Boolean);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject8).toString());
        }
        if (!paramBoolean3) {
          if ((i == 0) && (n == 0))
          {
            if (QLog.isColorLevel())
            {
              localObject8 = new StringBuilder();
              ((StringBuilder)localObject8).append("detect c2c =======>  egg_jumper animation, crazyModeEnable=");
              ((StringBuilder)localObject8).append(((AioAnimationRule)localObject2).jdField_a_of_type_Boolean);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject8).toString());
            }
            a(paramQQAppInterface, paramChatMessage, 0, 3, (AioAnimationRule)localObject2);
            if ((localObject4 instanceof MessageForStructing)) {
              ((AioAnimationDetector)localObject6).a((QQAppInterface)localObject5, (ChatMessage)localObject4, 0);
            }
            if (a(paramQQAppInterface, paramChatMessage, 1, paramAIOAnimationConatiner, paramInt, (AioAnimationRule)localObject2)) {
              return;
            }
            localObject8 = localObject2;
            if (((AioAnimationRule)localObject8).jdField_a_of_type_Boolean)
            {
              b(paramQQAppInterface, paramChatMessage, paramAIOAnimationConatiner, paramInt, (AioAnimationRule)localObject8);
              break label587;
            }
            c(paramQQAppInterface, paramChatMessage, paramAIOAnimationConatiner, paramInt, (AioAnimationRule)localObject8);
            break label587;
          }
        }
        label587:
        do
        {
          break;
          localObject8 = localObject3;
          if ((i == 0) && (n == 0))
          {
            if (QLog.isColorLevel())
            {
              localObject8 = new StringBuilder();
              ((StringBuilder)localObject8).append("detect =======>  egg_jumper animation ,crazyModeEnable=");
              ((StringBuilder)localObject8).append(((AioAnimationRule)localObject2).jdField_a_of_type_Boolean);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject8).toString());
            }
            a(paramQQAppInterface, paramChatMessage, 1, 3, (AioAnimationRule)localObject2);
            if ((localObject4 instanceof MessageForStructing)) {
              ((AioAnimationDetector)localObject6).a((QQAppInterface)localObject5, (ChatMessage)localObject4, 1);
            }
            a(paramQQAppInterface, paramChatMessage, paramAIOAnimationConatiner, paramInt, (AioAnimationRule)localObject2);
            break label1692;
          }
          if (i >= n) {
            break label1692;
          }
        } while (j < i);
        i = 1000;
        int k;
        int m;
        if (j == n)
        {
          if (QLog.isColorLevel())
          {
            localObject8 = new StringBuilder();
            ((StringBuilder)localObject8).append("detect (M == Y) =======>  egg_combo animation, checkCombo= ");
            ((StringBuilder)localObject8).append(paramBoolean2);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject8).toString());
          }
          if (paramBoolean2)
          {
            a(paramQQAppInterface, paramChatMessage, 1, 2, (AioAnimationRule)localObject2);
            ((AioAnimationDetector)localObject6).a((QQAppInterface)localObject5, (ChatMessage)localObject4, (AioAnimationRule)localObject2);
            ((AioAnimationDetector)localObject6).jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.2((AioAnimationDetector)localObject6, (AIOAnimationConatiner)localObject7, j, (ChatMessage)localObject4), paramInt + 0);
          }
          if (QLog.isColorLevel())
          {
            localObject7 = new StringBuilder();
            ((StringBuilder)localObject7).append("detect (M == Y) =======>  egg_jumper animation ,Y=");
            ((StringBuilder)localObject7).append(n);
            ((StringBuilder)localObject7).append(",crazyModeEnable=");
            ((StringBuilder)localObject7).append(((AioAnimationRule)localObject2).jdField_a_of_type_Boolean);
            QLog.d((String)localObject1, 2, ((StringBuilder)localObject7).toString());
          }
          localObject7 = localObject2;
          a(paramQQAppInterface, paramChatMessage, 1, 3, (AioAnimationRule)localObject2);
          i = 0;
          localObject2 = localObject7;
          while (i < n)
          {
            if (paramBoolean2) {
              j = 1000;
            } else {
              j = 0;
            }
            if (((AioAnimationRule)localObject2).jdField_a_of_type_Boolean)
            {
              k = ((AioAnimationRule)localObject2).jdField_b_of_type_JavaUtilArrayList.size();
              m = 0;
              while (m < k)
              {
                localObject7 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject2).jdField_b_of_type_JavaUtilArrayList.get(m);
                localObject7 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject7);
                int i1 = (m + i) * 800;
                ((AioAnimationDetector)localObject6).jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.3(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject7, i1, (AioAnimationRule)localObject2, paramChatMessage), paramInt + j + i1);
                m += 1;
              }
            }
            else
            {
              localObject7 = localObject2;
              localObject8 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject7).jdField_b_of_type_JavaUtilArrayList.get(0);
              localObject8 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject8);
              k = i * 800;
              ((AioAnimationDetector)localObject6).jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.4(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject8, k, (AioAnimationRule)localObject7, paramChatMessage), paramInt + j + k);
            }
            i += 1;
            localObject6 = this;
          }
          localObject7 = localObject2;
          localObject6 = this;
          localObject8 = paramAIOAnimationConatiner;
          localObject9 = localObject1;
          localObject1 = localObject5;
          localObject2 = localObject4;
          localObject4 = localObject8;
          localObject5 = localObject9;
        }
        else
        {
          localObject7 = localObject2;
          if (j > n)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("detect (M > Y) =======>  egg_combo animation, checkCombo= ");
              ((StringBuilder)localObject2).append(paramBoolean2);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
            }
            localObject6 = localObject1;
            if (paramBoolean2)
            {
              a(paramQQAppInterface, paramChatMessage, 1, 2, (AioAnimationRule)localObject7);
              localObject1 = this;
              ((AioAnimationDetector)localObject1).a((QQAppInterface)localObject5, (ChatMessage)localObject4, (AioAnimationRule)localObject7);
              ((AioAnimationDetector)localObject1).jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.5((AioAnimationDetector)localObject1, paramAIOAnimationConatiner, j, (ChatMessage)localObject4), paramInt + 0);
            }
            localObject8 = this;
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("detect (M > Y) =======>  egg_jumper animation ,Y=");
              ((StringBuilder)localObject1).append(n);
              ((StringBuilder)localObject1).append(",crazyModeEnable=");
              ((StringBuilder)localObject1).append(((AioAnimationRule)localObject7).jdField_a_of_type_Boolean);
              QLog.d((String)localObject6, 2, ((StringBuilder)localObject1).toString());
            }
            k = 0;
            a(paramQQAppInterface, paramChatMessage, 1, 3, (AioAnimationRule)localObject7);
            if (!paramBoolean2) {
              i = 0;
            }
            if (((AioAnimationRule)localObject7).jdField_a_of_type_Boolean)
            {
              j = ((AioAnimationRule)localObject7).jdField_b_of_type_JavaUtilArrayList.size();
              while (k < j)
              {
                localObject1 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject7).jdField_b_of_type_JavaUtilArrayList.get(k);
                localObject1 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject1);
                if (((AioAnimationRule)localObject7).jdField_a_of_type_Int == 8)
                {
                  ((AioAnimationDetector)localObject8).jdField_a_of_type_AndroidOsHandler.post(new AioAnimationDetector.6(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject1, (AioAnimationRule)localObject7, paramChatMessage));
                }
                else
                {
                  m = k * 800;
                  ((AioAnimationDetector)localObject8).jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.7(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject1, m, (AioAnimationRule)localObject7, paramChatMessage), paramInt + i + m);
                }
                k += 1;
              }
            }
            localObject1 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject7).jdField_b_of_type_JavaUtilArrayList.get(0);
            localObject1 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject1);
            if (((AioAnimationRule)localObject7).jdField_a_of_type_Int == 8) {
              ((AioAnimationDetector)localObject8).jdField_a_of_type_AndroidOsHandler.post(new AioAnimationDetector.8(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject1, (AioAnimationRule)localObject7, paramChatMessage));
            } else {
              ((AioAnimationDetector)localObject8).jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.9(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject1, (AioAnimationRule)localObject7, paramChatMessage), paramInt + i);
            }
            localObject1 = paramQQAppInterface;
            localObject2 = paramChatMessage;
            localObject4 = paramAIOAnimationConatiner;
            localObject5 = localObject6;
            localObject6 = localObject8;
          }
          else
          {
            localObject2 = this;
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("detect (X <= M < Y) ======>  egg_combo animation, checkCombo= ");
              ((StringBuilder)localObject4).append(paramBoolean2);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject4).toString());
            }
            if (!paramBoolean2)
            {
              localObject5 = paramQQAppInterface;
              localObject4 = paramChatMessage;
              localObject7 = paramAIOAnimationConatiner;
              localObject3 = localObject8;
              localObject6 = localObject2;
              break label1805;
            }
            a(paramQQAppInterface, paramChatMessage, 1, 2, (AioAnimationRule)localObject7);
            localObject9 = paramQQAppInterface;
            localObject8 = paramChatMessage;
            ((AioAnimationDetector)localObject2).a((QQAppInterface)localObject9, (ChatMessage)localObject8, (AioAnimationRule)localObject7);
            localObject5 = ((AioAnimationDetector)localObject2).jdField_a_of_type_AndroidOsHandler;
            localObject4 = paramAIOAnimationConatiner;
            ((Handler)localObject5).postDelayed(new AioAnimationDetector.10((AioAnimationDetector)localObject2, (AIOAnimationConatiner)localObject4, j, (ChatMessage)localObject8), paramInt + 0);
            localObject5 = localObject1;
            localObject6 = localObject2;
            break label1728;
            label1692:
            localObject8 = localObject5;
            localObject9 = localObject4;
            localObject4 = localObject7;
            localObject7 = localObject2;
            localObject5 = localObject1;
            localObject2 = localObject9;
            localObject1 = localObject8;
          }
        }
        Object localObject8 = localObject2;
        Object localObject9 = localObject1;
        label1728:
        if (((AioAnimationRule)localObject7).jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData != null) {
          if (((AioAnimationRule)localObject7).jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.jdField_a_of_type_Int == 1)
          {
            localObject1 = localObject3;
            if (localObject1 != null)
            {
              ((EcShopAssistantManager)localObject1).jdField_b_of_type_Int = ((AioAnimationRule)localObject7).jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.d;
              ((EcShopAssistantManager)localObject1).c = ((AioAnimationRule)localObject7).jdField_a_of_type_ComTencentMobileqqActivityAioAnimAioAnimationRule$BussinessData.e;
            }
          }
          else {}
        }
        localObject1 = localObject5;
        localObject7 = localObject4;
        localObject4 = localObject8;
        localObject5 = localObject9;
      }
      ((AioAnimationDetector)localObject6).a((QQAppInterface)localObject5, paramArrayList, (ChatMessage)localObject4);
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt1, Drawable paramDrawable, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = i * 800;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new AioAnimationDetector.1(this, paramAIOAnimationConatiner, paramDrawable, j), j + paramInt1);
      i += 1;
    }
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    boolean bool = paramChatMessage instanceof MessageForText;
    if ((!bool) && (!(paramChatMessage instanceof MessageForLongMsg)) && (!(paramChatMessage instanceof MessageForStructing)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "checkMsgType : not MessageForText and MessageForLongMsg and MessageFlashChat, return false;");
      }
      return false;
    }
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "checkMsgType : messageForText");
      }
    }
    else if ((paramChatMessage instanceof MessageForLongMsg))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationDetector", 2, "checkMsgType : MessageForLongMsg");
      }
    }
    else if (((paramChatMessage instanceof MessageForStructing)) && (QLog.isColorLevel())) {
      QLog.d("AioAnimationDetector", 2, "checkMsgType : MessageForStructing");
    }
    return true;
  }
  
  public boolean b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
      if (paramChatMessage == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "msg type is MessageForStructing, strctMsg is null");
        }
      }
      else {
        return paramChatMessage instanceof AbsShareMsg;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector
 * JD-Core Version:    0.7.0.1
 */