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
  private static volatile AioAnimationDetector c;
  public volatile long a = -1L;
  public volatile boolean b = false;
  private boolean d = false;
  private long e = -1L;
  private ConcurrentHashMap<Integer, CopyOnWriteArraySet<Long>> f = new ConcurrentHashMap();
  private AtomicBoolean g = new AtomicBoolean(false);
  private final Handler h = new Handler(Looper.getMainLooper());
  private List<IEggBizPlayer> i;
  
  private AioAnimationDetector()
  {
    c();
  }
  
  public static AioAnimationDetector a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new AioAnimationDetector();
        }
      }
      finally {}
    }
    return c;
  }
  
  private void a(long paramLong, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage.time > paramLong) && (!paramChatMessage.isSend())) {
      paramChatMessage.mNewAnimFlag = true;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, AioAnimationRule paramAioAnimationRule)
  {
    if (!this.g.get())
    {
      if (EggsUtil.a(paramAioAnimationRule)) {
        AIOUtils.a(paramQQAppInterface, true);
      }
      this.g.set(true);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, AioAnimationRule paramAioAnimationRule, boolean paramBoolean, ChatMessage paramChatMessage)
  {
    CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.f.get(Integer.valueOf(paramAioAnimationRule.b));
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
      this.f.remove(Integer.valueOf(paramAioAnimationRule.b));
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
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_rec", 0, 0, String.valueOf(paramInt1), String.valueOf(paramAioAnimationRule.b), "", "");
        return;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_stack_launch", 0, 0, String.valueOf(paramInt1), String.valueOf(paramAioAnimationRule.b), "", "");
      return;
    }
    if (paramInt2 == 3)
    {
      if (!paramChatMessage.isSendFromLocal())
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_rec", 0, 0, String.valueOf(paramInt1), String.valueOf(paramAioAnimationRule.b), "", "");
        return;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Egg_jump_launch", 0, 0, String.valueOf(paramInt1), String.valueOf(paramAioAnimationRule.b), "", "");
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, AioAnimationRule paramAioAnimationRule)
  {
    int k = paramAioAnimationRule.j.size();
    int j = 0;
    while (j < k)
    {
      Object localObject = (AioAnimationRule.JumpImage)paramAioAnimationRule.j.get(j);
      localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
      int m = j * 800;
      this.h.postDelayed(new AioAnimationDetector.13(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, m, paramAioAnimationRule, paramChatMessage), paramInt + m);
      j += 1;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt1, AioAnimationRule paramAioAnimationRule, boolean paramBoolean, ArrayList<AioAnimationRule> paramArrayList, int paramInt2)
  {
    if (a(paramQQAppInterface, paramChatMessage, 2, paramAIOAnimationConatiner, paramInt1, paramAioAnimationRule, paramBoolean, paramArrayList, paramInt2)) {
      return;
    }
    if (paramAioAnimationRule.i)
    {
      int j = paramAioAnimationRule.j.size();
      paramInt2 = 0;
      while (paramInt2 < j)
      {
        paramArrayList = (AioAnimationRule.JumpImage)paramAioAnimationRule.j.get(paramInt2);
        paramArrayList = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), paramArrayList);
        int k = paramInt2 * 800;
        this.h.postDelayed(new AioAnimationDetector.11(this, paramQQAppInterface, paramAIOAnimationConatiner, paramArrayList, k, paramAioAnimationRule, paramChatMessage), paramInt1 + k);
        paramInt2 += 1;
      }
    }
    paramArrayList = (AioAnimationRule.JumpImage)paramAioAnimationRule.j.get(0);
    paramArrayList = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), paramArrayList);
    this.h.postDelayed(new AioAnimationDetector.12(this, paramQQAppInterface, paramAIOAnimationConatiner, paramArrayList, paramAioAnimationRule, paramChatMessage), paramInt1);
  }
  
  private void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, AioAnimationRule paramAioAnimationRule)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detect combo =======> isLastStackMessageFromOthers ? ");
      localStringBuilder.append(this.d);
      localStringBuilder.append("  lastStackMessageSeq=");
      localStringBuilder.append(this.e);
      localStringBuilder.append("thisMessageSeq=");
      localStringBuilder.append(paramChatMessage.shmsgseq);
      QLog.d("AioAnimationDetector", 2, localStringBuilder.toString());
    }
    if ((paramChatMessage.isSendFromLocal()) && (this.d) && (paramChatMessage.shmsgseq == this.e + 1L)) {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Supr-Eggs", "Eggs_stack_new", 0, 0, String.valueOf(0), String.valueOf(paramAioAnimationRule.b), "", "");
    }
    this.d = (paramChatMessage.isSendFromLocal() ^ true);
    this.e = paramChatMessage.shmsgseq;
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
      CopyOnWriteArraySet localCopyOnWriteArraySet2 = (CopyOnWriteArraySet)this.f.get(Integer.valueOf(paramAioAnimationRule.b));
      CopyOnWriteArraySet localCopyOnWriteArraySet1 = localCopyOnWriteArraySet2;
      if (localCopyOnWriteArraySet2 == null)
      {
        localCopyOnWriteArraySet1 = new CopyOnWriteArraySet();
        this.f.put(Integer.valueOf(paramAioAnimationRule.b), localCopyOnWriteArraySet1);
      }
      localCopyOnWriteArraySet1.add(Long.valueOf(paramChatMessage.shmsgseq));
      return;
    }
    finally {}
  }
  
  private void a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo)
  {
    c();
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((IEggBizPlayer)localIterator.next()).a(paramChatMessage, paramQQAppInterface, paramBaseSessionInfo);
    }
  }
  
  private void a(List<ChatMessage> paramList)
  {
    c();
    Iterator localIterator = this.i.iterator();
    while (localIterator.hasNext()) {
      ((IEggBizPlayer)localIterator.next()).a(paramList);
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, int paramInt1, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt2, AioAnimationRule paramAioAnimationRule, boolean paramBoolean, ArrayList<AioAnimationRule> paramArrayList, int paramInt3)
  {
    c();
    int j = paramAioAnimationRule.a;
    if (j != -1)
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        localIEggBizPlayer = (IEggBizPlayer)localIterator.next();
        if (localIEggBizPlayer.a() == j) {
          break label68;
        }
      }
      IEggBizPlayer localIEggBizPlayer = null;
      label68:
      if ((localIEggBizPlayer != null) && ((localIEggBizPlayer.b() & paramInt1) != 0))
      {
        localIEggBizPlayer.a(paramQQAppInterface, this.h, paramChatMessage, paramAIOAnimationConatiner, paramInt2, paramAioAnimationRule, paramBoolean, paramArrayList, paramInt3);
        QLog.d("AioAnimationDetector", 1, new Object[] { "[onGroupAnimationTriggered] play dispatch to ", Integer.valueOf(localIEggBizPlayer.a()), ", id: ", Integer.valueOf(paramAioAnimationRule.b), ", session: ", Integer.valueOf(paramInt1) });
        return true;
      }
    }
    return false;
  }
  
  private void b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt, AioAnimationRule paramAioAnimationRule)
  {
    Object localObject = (AioAnimationRule.JumpImage)paramAioAnimationRule.j.get(0);
    localObject = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject);
    this.h.postDelayed(new AioAnimationDetector.14(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject, paramAioAnimationRule, paramChatMessage), paramInt);
  }
  
  private void c()
  {
    if (this.i == null)
    {
      this.i = new ArrayList();
      this.i.add(new DragonKingEggsPlayer());
      this.i.add(new BusinessEggsPlayer());
      this.i.add(new LevelEggsPlayer());
    }
  }
  
  private void d()
  {
    List localList = this.i;
    if (localList != null)
    {
      localList.clear();
      this.i = null;
    }
  }
  
  private void e()
  {
    Object localObject = this.i;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((IEggBizPlayer)((Iterator)localObject).next()).c();
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
          localObject = ((AbsStructMsgItem)localObject).ax.iterator();
          while (((Iterator)localObject).hasNext())
          {
            AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject).next();
            String str = localAbsStructMsgElement.b;
            if ("title".equals(str)) {
              localStringBuilder.append(((StructMsgItemTitle)localAbsStructMsgElement).e());
            } else if ("summary".equals(str)) {
              localStringBuilder.append(((StructMsgItemSummary)localAbsStructMsgElement).e());
            }
          }
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseSessionInfo paramBaseSessionInfo, MessageRecord paramMessageRecord, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    Object localObject1 = this;
    if (paramBaseSessionInfo.a != 1033)
    {
      if (paramBaseSessionInfo.a == 1034) {
        return;
      }
      if ((paramMessageRecord instanceof MessageForArkFlashChat)) {
        return;
      }
      if (((AioAnimationDetector)localObject1).b) {
        return;
      }
      long l1 = ((AioAnimationDetector)localObject1).a;
      localObject1 = "AioAnimationDetector";
      if (l1 == -1L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "handleNewMsg, lastMsgIdOrTime == -1, just return");
        }
        return;
      }
      if (paramBaseSessionInfo.a == 1008) {
        return;
      }
      if (UinTypeUtil.e(paramBaseSessionInfo.a) == 1032) {
        return;
      }
      int m = paramBaseSessionInfo.a;
      int k = 0;
      int j = 0;
      if ((m != 1) && (paramBaseSessionInfo.a != 3000))
      {
        if (UinTypeUtil.b(paramBaseSessionInfo.a)) {
          j = 1;
        }
        m = 0;
        k = j;
        j = m;
      }
      else
      {
        j = 1;
      }
      if ((j == 0) && (k == 0)) {
        return;
      }
      if ((paramBaseSessionInfo.b.equals(paramMessageRecord.frienduin)) && ((paramBaseSessionInfo.a == paramMessageRecord.istroop) || ((k != 0) && (UinTypeUtil.b(paramMessageRecord.istroop)))))
      {
        List localList = paramQQAppInterface.getMessageFacade().b(paramBaseSessionInfo.b, paramBaseSessionInfo.a, true);
        Object localObject2 = a();
        l1 = ((AioAnimationDetector)localObject2).a;
        k = localList.size() - 1;
        paramMessageRecord = (MessageRecord)localObject1;
        localObject1 = localObject2;
        for (;;)
        {
          Object localObject3 = this;
          if (k < 0) {
            break;
          }
          ChatMessage localChatMessage = (ChatMessage)localList.get(k);
          if (j != 0)
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
              localObject2 = ((AioAnimationDetector)localObject1).c(localChatMessage);
              if (localObject2 != null) {
                ((AioAnimationDetector)localObject1).a(paramQQAppInterface, (ArrayList)localObject2, true, localChatMessage, true, paramAIOAnimationConatiner, 0, true);
              }
              ((AioAnimationDetector)localObject1).a = localChatMessage.shmsgseq;
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
              localObject3 = ((AioAnimationDetector)localObject2).c(localChatMessage);
              if (localObject3 != null) {
                ((AioAnimationDetector)localObject2).a(paramQQAppInterface, (ArrayList)localObject3, false, localChatMessage, true, paramAIOAnimationConatiner, 0, true);
              }
              ((AioAnimationDetector)localObject2).a = localChatMessage.time;
            }
          }
          k -= 1;
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
        ((StringBuilder)localObject1).append(this.b);
        QLog.d("AioAnimationDetector", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = paramQQAppInterface.getMessageFacade().c(paramSessionInfo.b, paramSessionInfo.a, -1L, true);
      a((List)localObject1);
      if (!this.b) {
        return;
      }
      if (paramSessionInfo.a == 1008) {
        return;
      }
      if ((paramSessionInfo.a != 1) && (paramSessionInfo.a != 3000))
      {
        if (UinTypeUtil.b(paramSessionInfo.a)) {
          j = 1;
        } else {
          j = 0;
        }
        m = 0;
        k = j;
        j = m;
      }
      else
      {
        k = 0;
        j = 1;
      }
      if ((j == 0) && (k == 0)) {
        return;
      }
      long l = this.a;
      int k = ((List)localObject1).size();
      int i1 = 0;
      int n = 0;
      int m = j;
      int j = i1;
      while (n < k)
      {
        paramSessionInfo = (ChatMessage)((List)localObject1).get(n);
        Object localObject2;
        if (m != 0)
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
            if (n == k - 1) {
              bool = true;
            } else {
              bool = false;
            }
            localObject2 = c(paramSessionInfo);
            this.a = paramSessionInfo.shmsgseq;
            if (localObject2 != null)
            {
              a(paramQQAppInterface, (ArrayList)localObject2, true, paramSessionInfo, bool, paramAIOAnimationConatiner, j * 800, false);
              j += 1;
            }
            else
            {
              break label512;
            }
          }
        }
        else
        {
          i1 = j;
          j = i1;
          if (paramSessionInfo.time >= l)
          {
            j = i1;
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
              localObject2 = c(paramSessionInfo);
              this.a = paramSessionInfo.time;
              j = i1;
              if (localObject2 != null)
              {
                a(paramQQAppInterface, (ArrayList)localObject2, false, paramSessionInfo, false, paramAIOAnimationConatiner, i1 * 800, false);
                j = i1 + 1;
              }
            }
          }
        }
        label512:
        n += 1;
      }
      this.b = false;
    }
  }
  
  void a(QQAppInterface paramQQAppInterface, AIOAnimationConatiner paramAIOAnimationConatiner, Drawable paramDrawable, int paramInt, AioAnimationRule paramAioAnimationRule, ChatMessage paramChatMessage)
  {
    int j;
    if (paramAioAnimationRule.k == null) {
      j = -1;
    } else {
      j = paramAioAnimationRule.k.a;
    }
    boolean bool = paramAIOAnimationConatiner.a(2, 300, new Object[] { paramDrawable, Integer.valueOf(paramInt), Integer.valueOf(j), paramAioAnimationRule, paramChatMessage });
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
    if ((localObject5 != null) && (localObject4 != null) && (paramAIOAnimationConatiner != null) && (paramArrayList != null) && (paramArrayList.size() != 0))
    {
      if (!((AioAnimationDetector)localObject6).a((ChatMessage)localObject4)) {
        return;
      }
      boolean bool = ((ChatMessage)localObject4).isAioAnimChecked;
      Object localObject1 = "AioAnimationDetector";
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AioAnimationDetector", 2, "detect : message is checked, just return;");
        }
        return;
      }
      ((ChatMessage)localObject4).isAioAnimChecked = true;
      Object localObject2 = (EcShopAssistantManager)((QQAppInterface)localObject5).getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
      int k = 0;
      Object localObject3;
      for (;;)
      {
        bool = paramBoolean1;
        localObject3 = paramArrayList;
        if (k >= paramArrayList.size()) {
          break;
        }
        Object localObject7 = (AioAnimationRule)((ArrayList)localObject3).get(k);
        ((AioAnimationDetector)localObject6).a((ChatMessage)localObject4, (AioAnimationRule)localObject7);
        int j = paramChatMessage.getRepeatCount();
        int m = ((AioAnimationRule)localObject7).g;
        int i2 = ((AioAnimationRule)localObject7).h;
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("detect : troopOrDiscussion=");
          ((StringBuilder)localObject3).append(bool);
          ((StringBuilder)localObject3).append(" matched (");
          ((StringBuilder)localObject3).append(((ChatMessage)localObject4).uniseq);
          ((StringBuilder)localObject3).append("), rule: id=");
          ((StringBuilder)localObject3).append(((AioAnimationRule)localObject7).b);
          ((StringBuilder)localObject3).append(",M=");
          ((StringBuilder)localObject3).append(j);
          ((StringBuilder)localObject3).append(",X=");
          ((StringBuilder)localObject3).append(m);
          ((StringBuilder)localObject3).append(",Y=");
          ((StringBuilder)localObject3).append(i2);
          ((StringBuilder)localObject3).append(",crazyMode=");
          ((StringBuilder)localObject3).append(((AioAnimationRule)localObject7).i);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
        }
        if (!bool) {
          if ((m == 0) && (i2 == 0))
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("detect c2c =======>  egg_jumper animation, crazyModeEnable=");
              ((StringBuilder)localObject3).append(((AioAnimationRule)localObject7).i);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
            }
            a(paramQQAppInterface, paramChatMessage, 0, 3, (AioAnimationRule)localObject7);
            if ((localObject4 instanceof MessageForStructing)) {
              ((AioAnimationDetector)localObject6).a((QQAppInterface)localObject5, (ChatMessage)localObject4, 0);
            }
            localObject3 = localObject7;
            if (a(paramQQAppInterface, paramChatMessage, 1, paramAIOAnimationConatiner, paramInt, (AioAnimationRule)localObject7, paramBoolean3, paramArrayList, k)) {
              return;
            }
            if (((AioAnimationRule)localObject3).i) {
              a(paramQQAppInterface, paramChatMessage, paramAIOAnimationConatiner, paramInt, (AioAnimationRule)localObject3);
            } else {
              b(paramQQAppInterface, paramChatMessage, paramAIOAnimationConatiner, paramInt, (AioAnimationRule)localObject3);
            }
            localObject3 = localObject1;
            localObject1 = localObject5;
            localObject5 = localObject3;
            localObject3 = localObject6;
            break label1703;
          }
        }
        do
        {
          localObject9 = localObject5;
          localObject7 = localObject4;
          localObject8 = localObject1;
          break label1852;
          localObject9 = localObject7;
          if ((m == 0) && (i2 == 0))
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("detect =======>  egg_jumper animation ,crazyModeEnable=");
              ((StringBuilder)localObject3).append(((AioAnimationRule)localObject9).i);
              QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
            }
            a(paramQQAppInterface, paramChatMessage, 1, 3, (AioAnimationRule)localObject9);
            if ((localObject4 instanceof MessageForStructing)) {
              ((AioAnimationDetector)localObject6).a((QQAppInterface)localObject5, (ChatMessage)localObject4, 1);
            }
            a(paramQQAppInterface, paramChatMessage, paramAIOAnimationConatiner, paramInt, (AioAnimationRule)localObject9, paramBoolean3, paramArrayList, k);
            localObject8 = localObject1;
            break;
          }
          localObject3 = localObject1;
          localObject8 = localObject3;
          if (m >= i2) {
            break;
          }
        } while (j < m);
        int n;
        int i1;
        if (j == i2)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("detect (M == Y) =======>  egg_combo animation, checkCombo= ");
            ((StringBuilder)localObject1).append(paramBoolean2);
            QLog.d((String)localObject3, 2, ((StringBuilder)localObject1).toString());
          }
          if (paramBoolean2)
          {
            a(paramQQAppInterface, paramChatMessage, 1, 2, (AioAnimationRule)localObject9);
            ((AioAnimationDetector)localObject6).a((QQAppInterface)localObject5, (ChatMessage)localObject4, (AioAnimationRule)localObject9);
            ((AioAnimationDetector)localObject6).h.postDelayed(new AioAnimationDetector.2((AioAnimationDetector)localObject6, paramAIOAnimationConatiner, j, (ChatMessage)localObject4), paramInt + 0);
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("detect (M == Y) =======>  egg_jumper animation ,Y=");
            ((StringBuilder)localObject1).append(i2);
            ((StringBuilder)localObject1).append(",crazyModeEnable=");
            ((StringBuilder)localObject1).append(((AioAnimationRule)localObject9).i);
            QLog.d((String)localObject3, 2, ((StringBuilder)localObject1).toString());
          }
          a(paramQQAppInterface, paramChatMessage, 1, 3, (AioAnimationRule)localObject9);
          j = 0;
          while (j < i2)
          {
            if (paramBoolean2) {
              m = 1000;
            } else {
              m = 0;
            }
            if (((AioAnimationRule)localObject9).i)
            {
              n = ((AioAnimationRule)localObject9).j.size();
              i1 = 0;
              while (i1 < n)
              {
                localObject1 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject9).j.get(i1);
                localObject1 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject1);
                int i3 = (i1 + j) * 800;
                ((AioAnimationDetector)localObject6).h.postDelayed(new AioAnimationDetector.3(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject1, i3, (AioAnimationRule)localObject9, paramChatMessage), paramInt + m + i3);
                i1 += 1;
              }
            }
            else
            {
              localObject1 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject9).j.get(0);
              localObject1 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject1);
              n = j * 800;
              ((AioAnimationDetector)localObject6).h.postDelayed(new AioAnimationDetector.4(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject1, n, (AioAnimationRule)localObject9, paramChatMessage), paramInt + m + n);
            }
            j += 1;
            localObject6 = this;
          }
          localObject6 = this;
          localObject1 = paramQQAppInterface;
          localObject4 = paramChatMessage;
          localObject5 = localObject3;
          localObject3 = localObject6;
        }
        else if (j > i2)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("detect (M > Y) =======>  egg_combo animation, checkCombo= ");
            ((StringBuilder)localObject1).append(paramBoolean2);
            QLog.d((String)localObject3, 2, ((StringBuilder)localObject1).toString());
          }
          if (paramBoolean2)
          {
            a(paramQQAppInterface, paramChatMessage, 1, 2, (AioAnimationRule)localObject9);
            localObject1 = this;
            ((AioAnimationDetector)localObject1).a(paramQQAppInterface, paramChatMessage, (AioAnimationRule)localObject9);
            ((AioAnimationDetector)localObject1).h.postDelayed(new AioAnimationDetector.5((AioAnimationDetector)localObject1, paramAIOAnimationConatiner, j, paramChatMessage), paramInt + 0);
          }
          localObject6 = this;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("detect (M > Y) =======>  egg_jumper animation ,Y=");
            ((StringBuilder)localObject1).append(i2);
            ((StringBuilder)localObject1).append(",crazyModeEnable=");
            ((StringBuilder)localObject1).append(((AioAnimationRule)localObject9).i);
            QLog.d((String)localObject3, 2, ((StringBuilder)localObject1).toString());
          }
          a(paramQQAppInterface, paramChatMessage, 1, 3, (AioAnimationRule)localObject9);
          if (paramBoolean2) {
            j = 1000;
          } else {
            j = 0;
          }
          if (((AioAnimationRule)localObject9).i)
          {
            m = ((AioAnimationRule)localObject9).j.size();
            n = 0;
            while (n < m)
            {
              localObject1 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject9).j.get(n);
              localObject1 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject1);
              if (((AioAnimationRule)localObject9).a == 8)
              {
                ((AioAnimationDetector)localObject6).h.post(new AioAnimationDetector.6(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject1, (AioAnimationRule)localObject9, paramChatMessage));
              }
              else
              {
                i1 = n * 800;
                ((AioAnimationDetector)localObject6).h.postDelayed(new AioAnimationDetector.7(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject1, i1, (AioAnimationRule)localObject9, paramChatMessage), paramInt + j + i1);
              }
              n += 1;
            }
          }
          else
          {
            localObject1 = (AioAnimationRule.JumpImage)((AioAnimationRule)localObject9).j.get(0);
            localObject1 = AioAnimationRule.JumpImage.a(paramQQAppInterface.getApplication(), (AioAnimationRule.JumpImage)localObject1);
            if (((AioAnimationRule)localObject9).a == 8) {
              ((AioAnimationDetector)localObject6).h.post(new AioAnimationDetector.8(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject1, (AioAnimationRule)localObject9, paramChatMessage));
            } else {
              ((AioAnimationDetector)localObject6).h.postDelayed(new AioAnimationDetector.9(this, paramQQAppInterface, paramAIOAnimationConatiner, (Drawable)localObject1, (AioAnimationRule)localObject9, paramChatMessage), paramInt + j);
            }
          }
          localObject1 = paramQQAppInterface;
          localObject4 = paramChatMessage;
          localObject5 = localObject3;
          localObject3 = localObject6;
        }
        else
        {
          localObject6 = this;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("detect (X <= M < Y) ======>  egg_combo animation, checkCombo= ");
            ((StringBuilder)localObject1).append(paramBoolean2);
            QLog.d((String)localObject3, 2, ((StringBuilder)localObject1).toString());
          }
          if (!paramBoolean2)
          {
            localObject9 = paramQQAppInterface;
            localObject7 = paramChatMessage;
            localObject8 = localObject3;
            localObject10 = localObject6;
            break label1848;
          }
          a(paramQQAppInterface, paramChatMessage, 1, 2, (AioAnimationRule)localObject9);
          localObject1 = paramQQAppInterface;
          localObject4 = paramChatMessage;
          ((AioAnimationDetector)localObject6).a((QQAppInterface)localObject1, (ChatMessage)localObject4, (AioAnimationRule)localObject9);
          ((AioAnimationDetector)localObject6).h.postDelayed(new AioAnimationDetector.10((AioAnimationDetector)localObject6, paramAIOAnimationConatiner, j, (ChatMessage)localObject4), paramInt + 0);
          localObject5 = localObject3;
          localObject3 = localObject6;
          break label1703;
          localObject1 = localObject5;
          localObject3 = localObject6;
          localObject5 = localObject8;
        }
        label1703:
        localObject6 = localObject2;
        Object localObject11 = localObject7;
        Object localObject9 = localObject1;
        localObject7 = localObject4;
        Object localObject8 = localObject5;
        Object localObject10 = localObject3;
        if (localObject11.k != null)
        {
          if (localObject11.k.a == 1)
          {
            localObject10 = localObject6;
            localObject9 = localObject1;
            localObject7 = localObject4;
            localObject2 = localObject10;
            localObject8 = localObject5;
            localObject6 = localObject3;
            if (localObject10 != null)
            {
              localObject10.q = localObject11.k.d;
              localObject10.r = localObject11.k.e;
              localObject9 = localObject1;
              localObject7 = localObject4;
              localObject2 = localObject10;
              localObject8 = localObject5;
              localObject6 = localObject3;
            }
          }
          else
          {
            localObject2 = localObject6;
            localObject9 = localObject1;
            localObject7 = localObject4;
            localObject8 = localObject5;
            localObject6 = localObject3;
          }
        }
        else {
          label1848:
          localObject6 = localObject10;
        }
        label1852:
        localObject5 = localObject9;
        localObject4 = localObject7;
        k += 1;
        localObject1 = localObject8;
      }
      ((AioAnimationDetector)localObject6).a((QQAppInterface)localObject5, (ArrayList)localObject3, (ChatMessage)localObject4);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, AIOAnimationConatiner paramAIOAnimationConatiner, int paramInt1, Drawable paramDrawable, int paramInt2)
  {
    int j = 0;
    while (j < paramInt2)
    {
      int k = j * 800;
      this.h.postDelayed(new AioAnimationDetector.1(this, paramAIOAnimationConatiner, paramDrawable, k), k + paramInt1);
      j += 1;
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
  
  public void b()
  {
    Handler localHandler = this.h;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    this.a = -1L;
    this.f.clear();
    d();
    e();
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
  
  public ArrayList<AioAnimationRule> c(ChatMessage paramChatMessage)
  {
    Iterator localIterator = null;
    Object localObject = null;
    AioAnimationRule localAioAnimationRule = null;
    if (paramChatMessage != null)
    {
      if (!a(paramChatMessage)) {
        return null;
      }
      localObject = AioAnimationConfigHelper.a().b();
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
          if (localAioAnimationRule.c != null)
          {
            int j = 0;
            for (;;)
            {
              if (j >= localAioAnimationRule.c.size()) {
                break label383;
              }
              if (((EggKeyword)localAioAnimationRule.c.get(j)).b(str))
              {
                if (localAioAnimationRule.k != null)
                {
                  l2 = System.currentTimeMillis() / 1000L;
                  if ((localAioAnimationRule.k.a == 1) && ((localAioAnimationRule.k.b > l2) || (localAioAnimationRule.k.c < l2)))
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
                localAioAnimationRule.f = j;
                paramChatMessage.add(localAioAnimationRule);
                localObject = paramChatMessage;
                if (!QLog.isColorLevel()) {
                  break;
                }
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("matched ===> rule: id=");
                ((StringBuilder)localObject).append(localAioAnimationRule.b);
                ((StringBuilder)localObject).append(", index = ");
                ((StringBuilder)localObject).append(localAioAnimationRule.f);
                QLog.d("AioAnimationDetector", 2, ((StringBuilder)localObject).toString());
                localObject = paramChatMessage;
                break;
              }
              j += 1;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector
 * JD-Core Version:    0.7.0.1
 */