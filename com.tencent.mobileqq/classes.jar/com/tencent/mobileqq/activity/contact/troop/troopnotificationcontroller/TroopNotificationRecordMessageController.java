package com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller;

import android.os.Looper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.TroopNotificationConfig;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class TroopNotificationRecordMessageController
  extends ITroopNotificationController
{
  private List<MessageRecord> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  private Map<Integer, List<MessageRecord>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  public TroopNotificationRecordMessageController(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private String a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord != null)
    {
      paramMessageRecord = ((MessageForSystemMsg)paramMessageRecord).getSystemMsg();
      if ((paramMessageRecord != null) && (paramMessageRecord.msg.has())) {
        return String.valueOf(((structmsg.SystemMsg)paramMessageRecord.msg.get()).group_code.get()) + "_" + String.valueOf(paramMessageRecord.req_uin.get()) + "_" + String.valueOf(((structmsg.SystemMsg)paramMessageRecord.msg.get()).group_msg_type.get());
      }
    }
    return "";
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {}
    do
    {
      return localArrayList;
      a(paramList);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "removeDuplicatesMessages", "sortListBySeqAndMsgSubType list:" + paramList.toString() + "size:" + paramList.size() });
      }
      paramList = b(paramList);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "removeDuplicatesMessages", "getNoRepeatSeqMsg list:" + paramList.toString() + "size:" + paramList.size() });
      }
      a(paramList, localArrayList);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "removeDuplicatesMessages", "removeDuplicatesMessagesByKey list:" + localArrayList.toString() + "size:" + localArrayList.size() });
      }
      a(localArrayList);
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "removeDuplicatesMessages", "removeExpiredMessage list:" + paramList.toString() + "size:" + paramList.size() });
    return localArrayList;
  }
  
  private List<MessageRecord> a(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    paramList1 = b(paramList1, paramList2);
    if (paramList1.isEmpty()) {
      return paramList1;
    }
    return a(paramList1);
  }
  
  private void a(int paramInt)
  {
    List localList1 = b(2);
    List localList2 = b(0);
    List localList3 = b(1);
    localList1.clear();
    localList2.clear();
    localList3.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
      int k;
      if ((localStructMsg != null) && (localStructMsg.msg.has()))
      {
        int j = ((structmsg.SystemMsg)localStructMsg.msg.get()).group_msg_type.get();
        k = ((structmsg.SystemMsg)localStructMsg.msg.get()).sub_type.get();
        if ((j != 13) && (j != 6)) {
          break label342;
        }
        localList1.add(localMessageRecord);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "classifyMessageRecord", "message is quit Troop" + localMessageRecord.toString() + "size:" + localList1.size() });
        }
      }
      for (;;)
      {
        if (k == 1)
        {
          localList3.add(localMessageRecord);
          if ((i < paramInt) && (!this.jdField_a_of_type_Boolean)) {
            this.jdField_a_of_type_Boolean = true;
          }
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "classifyMessageRecord", "message is undeal" + localMessageRecord.toString() + "size:" + localList3.size() + "mHasUndealDataList" + this.jdField_a_of_type_Boolean });
          }
        }
        i += 1;
        break;
        label342:
        localList2.add(localMessageRecord);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "classifyMessageRecord", "message is not quit Troop" + localMessageRecord.toString() + "size:" + localList2.size() });
        }
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList)
  {
    int i = 0;
    while (i < paramArrayList.size())
    {
      structmsg.StructMsg localStructMsg = ((MessageForSystemMsg)paramArrayList.get(i)).getSystemMsg();
      TroopNotificationConfig localTroopNotificationConfig = (TroopNotificationConfig)QConfigManager.a().a(634);
      if ((localStructMsg != null) && (localStructMsg.msg_time != null) && (localStructMsg.msg_time.has()) && (localTroopNotificationConfig != null) && (NetConnInfoCenter.getServerTimeMillis() - localStructMsg.msg_time.get() * 1000L > localTroopNotificationConfig.b * 1000L)) {
        paramArrayList.remove(i);
      }
      i += 1;
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    Collections.sort(paramList, new TroopNotificationRecordMessageController.3(this));
  }
  
  private void a(List<MessageRecord> paramList, int paramInt, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "addMessageRecordInner", "message is quit Troop" + paramList.toString() + "size:" + paramList.size() + "saveDB" + paramBoolean });
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      b(paramList, paramInt);
      if (paramBoolean) {
        c();
      }
      return;
    }
  }
  
  private void a(List<MessageRecord> paramList, ArrayList<MessageRecord> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      String str = a(localMessageRecord);
      structmsg.StructMsg localStructMsg1 = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
      if (localStructMsg1 != null) {
        if (localHashMap.containsKey(str))
        {
          structmsg.StructMsg localStructMsg2 = ((MessageForSystemMsg)localHashMap.get(str)).getSystemMsg();
          if (a(localStructMsg1.msg.group_msg_type.get()))
          {
            paramArrayList.add(localMessageRecord);
          }
          else if ((localStructMsg2.msg.has()) && (localStructMsg2.msg.sub_type.get() != 1))
          {
            paramArrayList.add(localMessageRecord);
          }
          else if (localStructMsg1.msg_time.get() > localStructMsg2.msg_time.get())
          {
            int i = paramArrayList.indexOf(localHashMap.get(str));
            paramArrayList.remove(i);
            paramArrayList.add(i, localMessageRecord);
            localHashMap.put(str, localMessageRecord);
          }
        }
        else
        {
          paramArrayList.add(localMessageRecord);
          localHashMap.put(str, localMessageRecord);
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return TroopNotifyHelper.c(paramInt);
  }
  
  @NotNull
  private List<MessageRecord> b(int paramInt)
  {
    List localList = null;
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      localList = (List)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    }
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new CopyOnWriteArrayList();
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localObject);
    }
    return localObject;
  }
  
  private List<MessageRecord> b(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    structmsg.StructMsg localStructMsg = null;
    Iterator localIterator = paramList.iterator();
    paramList = localStructMsg;
    if (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      localStructMsg = ((MessageForSystemMsg)localMessageRecord).getSystemMsg();
      if ((paramList != null) && (localStructMsg.msg_seq.get() == paramList.msg_seq.get())) {
        break label87;
      }
      localArrayList.add(localMessageRecord);
      paramList = localStructMsg;
    }
    label87:
    for (;;)
    {
      break;
      return localArrayList;
    }
  }
  
  private List<MessageRecord> b(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList1 != null) && (!paramList1.isEmpty())) {
      localArrayList.addAll(paramList1);
    }
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      localArrayList.addAll(paramList2);
    }
    return localArrayList;
  }
  
  private void b(List<MessageRecord> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_JavaUtilList, paramList);
    if (this.jdField_a_of_type_JavaUtilList.isEmpty()) {
      return;
    }
    paramList = (TroopNotificationConfig)QConfigManager.a().a(634);
    if ((paramList == null) || (!paramList.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(0), this.jdField_a_of_type_JavaUtilList);
      return;
    }
    a(paramInt);
  }
  
  private void c()
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      List localList = this.jdField_a_of_type_JavaUtilList;
      String str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      if ((MessageHandlerUtils.a((ArrayList)this.jdField_a_of_type_JavaUtilList)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop)) {}
      for (boolean bool = true;; bool = false)
      {
        localQQMessageFacade.a(localList, str, bool);
        return;
      }
    }
    ThreadManager.postImmediately(new TroopNotificationRecordMessageController.2(this), null, false);
  }
  
  public List<MessageRecord> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    return localArrayList;
  }
  
  public List<MessageRecord> a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(b(paramInt));
    return localArrayList;
  }
  
  public List<MessageRecord> a(ThreadExcutor.IThreadListener paramIThreadListener)
  {
    if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "getMessageRecordMayBeLoadDB", "getMessageRecordMayBeLoadDB Cache is not empty:" + this.jdField_a_of_type_JavaUtilList.toString() + "size:" + this.jdField_a_of_type_JavaUtilList.size() });
      }
      paramIThreadListener = new ArrayList();
      paramIThreadListener.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    ArrayList localArrayList;
    do
    {
      return paramIThreadListener;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        break;
      }
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(AppConstants.TROOP_SYSTEM_MSG_UIN, 0, null), GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      localArrayList = new ArrayList();
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
      paramIThreadListener = localArrayList;
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "getMessageRecordMayBeLoadDB", "getMessageRecordMayBeLoadDB Cache is empty, currentThread is not mainThread:" + this.jdField_a_of_type_JavaUtilList.toString() + "size:" + this.jdField_a_of_type_JavaUtilList.size() });
    return localArrayList;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, new Object[] { "getMessageRecordMayBeLoadDB", "getMessageRecordMayBeLoadDB Cache is empty, currentThread is mainThread:" });
    }
    ThreadManager.postImmediately(new TroopNotificationRecordMessageController.1(this), paramIThreadListener, false);
    return null;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (localMessageRecord.uniseq == paramLong) {
        this.jdField_a_of_type_JavaUtilList.remove(localMessageRecord);
      }
    }
    a(GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramString, paramInt, paramLong, paramBoolean);
  }
  
  public void a(List<MessageRecord> paramList, int paramInt)
  {
    a(paramList, paramInt, true);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.troopnotificationcontroller.TroopNotificationRecordMessageController
 * JD-Core Version:    0.7.0.1
 */