package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.PasswdRedBagFoldManager;
import com.tencent.mobileqq.utils.StartupTrackerForAio;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class FoldMessageManager
{
  public static void a(BaseMessageManager paramBaseMessageManager, QQAppInterface paramQQAppInterface, List<MessageRecord> paramList1, List<MessageRecord> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList1 != null)
    {
      if (paramList1.isEmpty()) {
        return;
      }
      boolean bool1 = QLog.isColorLevel();
      String str = "msgFold";
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if ((bool1) && (StartupTrackerForAio.a()) && (paramList1 != null) && (paramList1.size() > 0))
      {
        localObject1 = new StringBuilder(paramList1.size() * 48 + 64);
        ((StringBuilder)localObject1).append("BaseMessageManager mergeFoldMsgGrayTips(),searchList size=");
        ((StringBuilder)localObject1).append(paramList1.size());
        ((StringBuilder)localObject1).append(":");
        localObject2 = paramList1.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append("(");
          ((StringBuilder)localObject1).append(((MessageRecord)localObject3).time);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(((MessageRecord)localObject3).shmsgseq);
          ((StringBuilder)localObject1).append(",");
          ((StringBuilder)localObject1).append(((MessageRecord)localObject3).msgtype);
          ((StringBuilder)localObject1).append(") ");
        }
        QLog.d("msgFold", 2, ((StringBuilder)localObject1).toString());
      }
      PasswdRedBagFoldManager localPasswdRedBagFoldManager = (PasswdRedBagFoldManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
      Object localObject4 = new HashMap();
      Object localObject5 = paramList1.iterator();
      for (;;)
      {
        boolean bool2 = ((Iterator)localObject5).hasNext();
        bool1 = false;
        if (!bool2) {
          break;
        }
        localObject1 = (MessageRecord)((Iterator)localObject5).next();
        if ((localObject1 instanceof MessageForFoldMsg))
        {
          MessageForFoldMsg localMessageForFoldMsg = (MessageForFoldMsg)localObject1;
          if ((!TextUtils.isEmpty(localMessageForFoldMsg.redBagIndex)) && (!TextUtils.isEmpty(localMessageForFoldMsg.redBagId))) {
            localPasswdRedBagFoldManager.a(true, localMessageForFoldMsg.redBagId, localMessageForFoldMsg.redBagIndex);
          }
          if ((TextUtils.isEmpty(localMessageForFoldMsg.redBagIndex)) && (!TextUtils.isEmpty(localMessageForFoldMsg.redBagId)))
          {
            if (localPasswdRedBagFoldManager.h.containsKey(localMessageForFoldMsg.redBagId)) {
              localMessageForFoldMsg.redBagIndex = ((String)localPasswdRedBagFoldManager.h.get(localMessageForFoldMsg.redBagId));
            }
          }
          else {
            bool1 = true;
          }
          if ((paramBoolean1) || (!localPasswdRedBagFoldManager.b(localMessageForFoldMsg.frienduin, localMessageForFoldMsg.istroop, localMessageForFoldMsg.redBagId, localMessageForFoldMsg.redBagIndex)))
          {
            do
            {
              while ((localMessageForFoldMsg.isSend()) && (!localMessageForFoldMsg.foldFlag) && (localMessageForFoldMsg.msgtype == -2006)) {}
              if (bool1) {
                localObject1 = localMessageForFoldMsg.redBagIndex;
              } else {
                localObject1 = localMessageForFoldMsg.redBagId;
              }
            } while (TextUtils.isEmpty((CharSequence)localObject1));
            localObject3 = (FoldMessageManager.RedBagFoldContext)((HashMap)localObject4).get(localObject1);
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new FoldMessageManager.RedBagFoldContext();
              ((HashMap)localObject4).put(localObject1, localObject2);
            }
            ((FoldMessageManager.RedBagFoldContext)localObject2).h = bool1;
            if (!localMessageForFoldMsg.foldFlag)
            {
              ((FoldMessageManager.RedBagFoldContext)localObject2).e = true;
              if (localMessageForFoldMsg.shmsgseq > ((FoldMessageManager.RedBagFoldContext)localObject2).f)
              {
                ((FoldMessageManager.RedBagFoldContext)localObject2).f = localMessageForFoldMsg.shmsgseq;
                ((FoldMessageManager.RedBagFoldContext)localObject2).g = localMessageForFoldMsg;
              }
            }
            else
            {
              ((FoldMessageManager.RedBagFoldContext)localObject2).a += 1;
              ((FoldMessageManager.RedBagFoldContext)localObject2).b.add(localMessageForFoldMsg.senderuin);
              if (localMessageForFoldMsg.shmsgseq < ((FoldMessageManager.RedBagFoldContext)localObject2).c)
              {
                ((FoldMessageManager.RedBagFoldContext)localObject2).c = localMessageForFoldMsg.shmsgseq;
                ((FoldMessageManager.RedBagFoldContext)localObject2).d = localMessageForFoldMsg;
              }
            }
          }
        }
      }
      if (!((HashMap)localObject4).isEmpty())
      {
        a(paramQQAppInterface, (HashMap)localObject4);
        localObject2 = ((HashMap)localObject4).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FoldMessageManager.RedBagFoldContext)((Map.Entry)((Iterator)localObject2).next()).getValue();
          if (((FoldMessageManager.RedBagFoldContext)localObject3).a > 0)
          {
            if (((FoldMessageManager.RedBagFoldContext)localObject3).e) {
              ((FoldMessageManager.RedBagFoldContext)localObject3).d = ((FoldMessageManager.RedBagFoldContext)localObject3).g;
            }
            if (paramList2 == null) {
              localObject1 = paramBaseMessageManager.a(paramQQAppInterface, ((MessageRecord)paramList1.get(0)).frienduin, ((MessageRecord)paramList1.get(0)).istroop);
            } else {
              localObject1 = paramList2;
            }
            if (localObject1 == null)
            {
              QLog.e("Q.msg.BaseMessageManager", 1, "mergeFoldMsgGrayTips null aioList");
              return;
            }
            localObject1 = localPasswdRedBagFoldManager.a((List)localObject1, ((FoldMessageManager.RedBagFoldContext)localObject3).d, ((FoldMessageManager.RedBagFoldContext)localObject3).b, ((FoldMessageManager.RedBagFoldContext)localObject3).a, paramBoolean1, paramBoolean2);
            if ((localObject1 != null) && (paramList2 == null))
            {
              if ((QLog.isColorLevel()) && (StartupTrackerForAio.a()) && (paramList2 != null) && (paramList2.size() > 0))
              {
                localObject3 = new StringBuilder(paramList2.size() * 48 + 32);
                ((StringBuilder)localObject3).append("insert to clone list,addlist size=");
                ((StringBuilder)localObject3).append(paramList2.size());
                ((StringBuilder)localObject3).append(":");
                localObject4 = paramList2.iterator();
                while (((Iterator)localObject4).hasNext())
                {
                  localObject5 = (MessageRecord)((Iterator)localObject4).next();
                  ((StringBuilder)localObject3).append("(");
                  ((StringBuilder)localObject3).append(((MessageRecord)localObject5).time);
                  ((StringBuilder)localObject3).append(",");
                  ((StringBuilder)localObject3).append(((MessageRecord)localObject5).shmsgseq);
                  ((StringBuilder)localObject3).append(",");
                  ((StringBuilder)localObject3).append(((MessageRecord)localObject5).msgtype);
                  ((StringBuilder)localObject3).append(") ");
                }
                QLog.d(str, 2, ((StringBuilder)localObject3).toString());
              }
              MsgProxyUtils.c(paramList1, (MessageRecord)localObject1, true);
            }
            else {}
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, HashMap<String, FoldMessageManager.RedBagFoldContext> paramHashMap)
  {
    HashSet localHashSet = new HashSet();
    paramQQAppInterface = (PasswdRedBagFoldManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_FOLD_MANAGER);
    paramQQAppInterface.a(false);
    if (paramQQAppInterface.i.isEmpty()) {
      return;
    }
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      FoldMessageManager.RedBagFoldContext localRedBagFoldContext1 = (FoldMessageManager.RedBagFoldContext)localEntry.getValue();
      if (localRedBagFoldContext1.h)
      {
        String str = (String)paramQQAppInterface.i.get(localEntry.getKey());
        if ((!TextUtils.isEmpty(str)) && (paramHashMap.containsKey(str)))
        {
          FoldMessageManager.RedBagFoldContext localRedBagFoldContext2 = (FoldMessageManager.RedBagFoldContext)paramHashMap.get(str);
          localHashSet.add(str);
          localRedBagFoldContext1.a += localRedBagFoldContext2.a;
          localRedBagFoldContext1.b.addAll(localRedBagFoldContext2.b);
          boolean bool;
          if ((!localRedBagFoldContext1.e) && (!localRedBagFoldContext2.e)) {
            bool = false;
          } else {
            bool = true;
          }
          localRedBagFoldContext1.e = bool;
          if (localRedBagFoldContext1.f < localRedBagFoldContext2.f)
          {
            localRedBagFoldContext1.f = localRedBagFoldContext2.f;
            localRedBagFoldContext1.g = localRedBagFoldContext2.g;
            localRedBagFoldContext1.g.redBagIndex = ((String)localEntry.getKey());
          }
          if (localRedBagFoldContext1.c > localRedBagFoldContext2.c)
          {
            localRedBagFoldContext1.c = localRedBagFoldContext2.c;
            localRedBagFoldContext1.d = localRedBagFoldContext2.d;
            localRedBagFoldContext1.d.redBagIndex = ((String)localEntry.getKey());
          }
        }
      }
    }
    paramHashMap.keySet().removeAll(localHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.FoldMessageManager
 * JD-Core Version:    0.7.0.1
 */