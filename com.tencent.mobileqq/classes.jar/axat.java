import android.content.ContentValues;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager.1;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager.2;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class axat
  implements Manager
{
  atmp jdField_a_of_type_Atmp;
  ArrayList<SubAccountInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public HashMap<String, ArrayList<SubAccountMessage>> a;
  Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  
  public axat(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_Atmp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = this.jdField_a_of_type_Atmp.a(SubAccountInfo.class);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("initSubAccountInfos() uin=").append(paramQQAppInterface.getCurrentAccountUin()).append(" result=");
      if (localList != null) {
        break label123;
      }
    }
    label123:
    for (paramQQAppInterface = null;; paramQQAppInterface = Integer.valueOf(localList.size()))
    {
      QLog.d("SUB_ACCOUNT", 2, paramQQAppInterface);
      if ((localList != null) && (localList.size() != 0)) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(localList);
    c();
  }
  
  private void a(SubAccountInfo paramSubAccountInfo, ArrayList<SubAccountMessage> paramArrayList, int paramInt)
  {
    if ((paramSubAccountInfo == null) || (paramArrayList == null))
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder().append("countUnreadDatum() return,");
        if (paramSubAccountInfo != null) {
          break label49;
        }
      }
      label49:
      for (paramSubAccountInfo = "info == null";; paramSubAccountInfo = "list == null")
      {
        QLog.d("SUB_ACCOUNT", 2, paramSubAccountInfo);
        return;
      }
    }
    Collections.sort(paramArrayList);
    paramArrayList = paramArrayList.iterator();
    int n = 0;
    int m = 0;
    int i = 0;
    int i2 = 1;
    label76:
    Object localObject;
    int j;
    int k;
    long l;
    label177:
    int i1;
    for (;;)
    {
      if (paramArrayList.hasNext())
      {
        localObject = (SubAccountMessage)paramArrayList.next();
        if (localObject != null)
        {
          j = i2;
          if (i2 != 0)
          {
            k = 0;
            if ((((SubAccountMessage)localObject).mEmoRecentMsg == null) && (((SubAccountMessage)localObject).msg != null)) {
              ((SubAccountMessage)localObject).mEmoRecentMsg = new axkd(((SubAccountMessage)localObject).msg, 3, 16);
            }
            paramSubAccountInfo.lastMsg = ((SubAccountMessage)localObject).mEmoRecentMsg;
            if (paramSubAccountInfo.lasttime <= ((SubAccountMessage)localObject).time) {
              break;
            }
            l = paramSubAccountInfo.lasttime;
            paramSubAccountInfo.lasttime = l;
            paramSubAccountInfo.lastUin = ((SubAccountMessage)localObject).frienduin;
            paramSubAccountInfo.lastUinNick = ((SubAccountMessage)localObject).sendername;
            j = k;
            if (QLog.isColorLevel())
            {
              QLog.d("SUB_ACCOUNT", 2, "countUnreadDatum() change lasttime=" + paramSubAccountInfo.lasttime);
              j = k;
            }
          }
          i1 = m;
          k = n;
          if (!((SubAccountMessage)localObject).isread)
          {
            k = n + ((SubAccountMessage)localObject).unreadNum;
            i1 = m + 1;
          }
          if (!((SubAccountMessage)localObject).needNotify) {
            break label526;
          }
          i += 1;
        }
      }
    }
    label526:
    for (;;)
    {
      i2 = j;
      m = i1;
      n = k;
      break label76;
      l = ((SubAccountMessage)localObject).time;
      break label177;
      paramSubAccountInfo.unNotifySender = i;
      paramSubAccountInfo.unreadMsgNum = n;
      paramSubAccountInfo.unreadSenderNum = m;
      if (i2 != 0)
      {
        paramSubAccountInfo.lastMsg = null;
        paramSubAccountInfo.lasttime = 0L;
        paramSubAccountInfo.lastUin = null;
        paramSubAccountInfo.lastUinNick = null;
      }
      if ((paramInt == 1) && (paramSubAccountInfo.hintIsNew))
      {
        paramSubAccountInfo.hintIsNew = false;
        a(paramSubAccountInfo);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "countUnreadDatum() set hintIsNew=false");
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      localObject = new StringBuilder().append("countUnreadDatum() info.subuin=").append(paramSubAccountInfo.subuin).append(" unreadMsg=").append(paramSubAccountInfo.unreadMsgNum).append(" unNotify=").append(paramSubAccountInfo.unNotifySender).append(" unreadSender=").append(paramSubAccountInfo.unreadSenderNum).append(" lastUin=").append(paramSubAccountInfo.lastUin).append(" lastNick=");
      if (paramSubAccountInfo.lastUinNick == null) {}
      for (paramArrayList = "null";; paramArrayList = Integer.valueOf(paramSubAccountInfo.lastUinNick.length()))
      {
        QLog.d("SUB_ACCOUNT", 2, paramArrayList + " lastTime=" + paramSubAccountInfo.lasttime);
        return;
      }
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        String str = localSubAccountInfo.subuin;
        ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_Atmp.a(SubAccountMessage.class, SubAccountMessage.class.getSimpleName(), false, "subUin=?", new String[] { str }, null, null, "time desc", null);
        if ((localArrayList != null) && (localArrayList.size() > 0)) {
          this.jdField_a_of_type_JavaUtilHashMap.put(str, localArrayList);
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("init() query subUin:").append(str).append(" allMsg and put map.list=");
          if (localArrayList == null)
          {
            str = null;
            QLog.d("SUB_ACCOUNT", 2, str);
          }
        }
        else
        {
          a(localSubAccountInfo, localArrayList, 0);
          continue;
        }
        i = localArrayList.size();
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      int i;
      Integer localInteger = Integer.valueOf(i);
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
  }
  
  public int a()
  {
    int i = 0;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        i = this.jdField_a_of_type_JavaUtilArrayList.size();
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getBindedNumber() bindedNum=" + i);
      }
      return i;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public int a(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getStatus() subUin is null.");
      }
    }
    do
    {
      return 0;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getStatus() listSubInfo is null.");
    return 0;
    Object localObject = null;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    label201:
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          boolean bool = paramString.equals(localSubAccountInfo.subuin);
          if (!bool) {
            break label201;
          }
          localObject = localSubAccountInfo;
          continue;
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (localObject != null)
        {
          int j = localObject.status;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("SUB_ACCOUNT", 2, "getStatus() findInfo status=" + j);
            i = j;
          }
          return i;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getStatus() findInfo is null. return default 0");
      }
      int i = 0;
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    int j = 0;
    if ((paramString1 == null) || (paramString2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "removeMessage() return, NULL, subUin=" + paramString1 + " sendUin=" + paramString2);
      }
      return 0;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
        {
          ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString1);
          if ((localArrayList != null) && (localArrayList.size() > 0))
          {
            i = localArrayList.size() - 1;
            if (i < 0) {
              break label345;
            }
            localSubAccountMessage = (SubAccountMessage)localArrayList.get(i);
            if ((paramString1.equals(localSubAccountMessage.subUin)) && (paramString2.equals(localSubAccountMessage.senderuin)))
            {
              localArrayList.remove(i);
              i = 0 - localSubAccountMessage.unreadNum;
              Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
              if (localIterator.hasNext())
              {
                localSubAccountInfo = (SubAccountInfo)localIterator.next();
                if ((localSubAccountInfo == null) || (!paramString1.equals(localSubAccountInfo.subuin))) {
                  continue;
                }
                a(localSubAccountInfo, localArrayList, 2);
                this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
                if (localSubAccountMessage != null) {
                  this.jdField_a_of_type_Atmp.b(localSubAccountMessage);
                }
                if (QLog.isColorLevel()) {
                  QLog.d("SUB_ACCOUNT", 2, "removeMessage() subUin=" + paramString1 + " sendUin=" + paramString2 + " changedNum=" + i);
                }
                return i;
              }
            }
            else
            {
              i -= 1;
              continue;
            }
          }
          else
          {
            return 0;
          }
        }
        else
        {
          return 0;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      SubAccountInfo localSubAccountInfo = null;
      continue;
      label345:
      SubAccountMessage localSubAccountMessage = null;
      int i = j;
    }
  }
  
  public long a(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getActionTime() subUin is null.");
      }
      return 0L;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getActionTime() listSubInfo is null.");
      }
      return 0L;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label131;
        }
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        boolean bool = paramString.equals(localSubAccountInfo.subuin);
        if (!bool) {
          continue;
        }
        paramString = localSubAccountInfo;
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (paramString != null) {
          return paramString.lasttime;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      return 0L;
      label131:
      paramString = null;
    }
  }
  
  public SubAccountInfo a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getSubAccountInfo() subUin=" + paramString);
    }
    if (paramString == null) {
      return null;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaUtilArrayList != null)
        {
          Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (localIterator.hasNext())
          {
            SubAccountInfo localSubAccountInfo2 = (SubAccountInfo)localIterator.next();
            if (localSubAccountInfo2 == null) {
              continue;
            }
            localSubAccountInfo1 = localSubAccountInfo2;
            if (!"sub.uin.default".equals(paramString))
            {
              boolean bool = paramString.equals(localSubAccountInfo2.subuin);
              if (!bool) {
                continue;
              }
              localSubAccountInfo1 = localSubAccountInfo2;
            }
            return localSubAccountInfo1;
          }
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      SubAccountInfo localSubAccountInfo1 = null;
    }
  }
  
  public SubAccountMessage a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "findSubAccountMessage() return, subUin=" + paramString1 + " sendUin=" + paramString2);
      }
    }
    Object localObject;
    do
    {
      return null;
      localObject = a(paramString1);
    } while ((localObject == null) || (((List)localObject).size() == 0));
    Iterator localIterator = ((List)localObject).iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (SubAccountMessage)localIterator.next();
    } while ((localObject == null) || (!paramString1.equals(((SubAccountMessage)localObject).subUin)) || (!paramString2.equals(((SubAccountMessage)localObject).senderuin)));
    for (paramString1 = (String)localObject;; paramString1 = null) {
      return paramString1;
    }
  }
  
  public Pair<Integer, String> a(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getServerError() subUin is null.");
      }
    }
    do
    {
      return null;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getServerError() listSubInfo is null.");
    return null;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    label228:
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        Object localObject1 = null;
        Object localObject2;
        if (localIterator.hasNext())
        {
          localObject2 = (SubAccountInfo)localIterator.next();
          boolean bool = paramString.equals(((SubAccountInfo)localObject2).subuin);
          if (!bool) {
            break label228;
          }
          localObject1 = localObject2;
          continue;
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (localObject1 != null)
        {
          localObject2 = new Pair(Integer.valueOf(localObject1.serverErrorType), localObject1.serverErrorMsg);
          paramString = (String)localObject2;
          if (QLog.isColorLevel())
          {
            QLog.d("SUB_ACCOUNT", 2, "getServerError() findInfo errType=" + localObject1.serverErrorType + " errMsg=" + localObject1.serverErrorMsg);
            paramString = (String)localObject2;
          }
          return paramString;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getServerError() findInfo is null.");
      }
      paramString = null;
    }
  }
  
  public CharSequence a(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getLatestMsg() subUin is null.");
      }
    }
    do
    {
      return null;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getLatestMsg() listSubInfo is null.");
    return null;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          boolean bool = paramString.equals(localSubAccountInfo.subuin);
          if (!bool) {
            continue;
          }
          paramString = localSubAccountInfo;
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if (paramString == null) {
            break;
          }
          return paramString.lastMsg;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      paramString = null;
    }
  }
  
  public String a(String paramString)
  {
    String str = "";
    SubAccountInfo localSubAccountInfo = a(paramString);
    paramString = str;
    if (localSubAccountInfo != null) {
      paramString = localSubAccountInfo.A2;
    }
    return paramString;
  }
  
  public ArrayList<String> a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getAllSubUin() listSubInfo is null. return null;");
      }
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
        if (localSubAccountInfo != null) {
          localArrayList.add(localSubAccountInfo.subuin);
        }
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getAllSubUin() return:" + String.valueOf(localObject));
    }
    return localObject;
  }
  
  public List<SubAccountMessage> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)))
        {
          localArrayList.addAll((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString));
          return localArrayList;
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("getAllMessage() subUin:").append(paramString).append(" mspSubMsg=");
          if (this.jdField_a_of_type_JavaUtilHashMap == null)
          {
            paramString = null;
            QLog.d("SUB_ACCOUNT", 2, paramString);
          }
          else
          {
            paramString = "containsKey=" + this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString);
          }
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "removeAllMessage()");
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          localSubAccountInfo.unNotifySender = 0;
          localSubAccountInfo.unreadSenderNum = 0;
          localSubAccountInfo.unreadMsgNum = 0;
          localSubAccountInfo.lastMsg = null;
          localSubAccountInfo.lastUin = null;
          localSubAccountInfo.lastUinNick = null;
          a(localSubAccountInfo);
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "removeAllMessage() info.subuin=" + localSubAccountInfo.subuin + " unreadMsg=" + localSubAccountInfo.unreadMsgNum + " unNotify=" + localSubAccountInfo.unNotifySender + " unreadSender=" + localSubAccountInfo.unreadSenderNum);
          }
        }
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    this.jdField_a_of_type_Atmp.a(SubAccountMessage.class.getSimpleName());
  }
  
  public void a(axau paramaxau)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("addAllSubAccountInfo() ");
      if (paramaxau == null)
      {
        localObject1 = "data == null";
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      }
    }
    else
    {
      if ((paramaxau != null) && (paramaxau.jdField_b_of_type_JavaLangString != null) && (paramaxau.c())) {
        break label183;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("addAllSubAccountInfo() return,");
        if (paramaxau != null) {
          break label143;
        }
      }
    }
    label143:
    for (paramaxau = "data == null";; paramaxau = "data.mMainAccount=" + paramaxau.jdField_b_of_type_JavaLangString + " data.mSubUin=" + paramaxau.jdField_c_of_type_JavaLangString)
    {
      QLog.d("SUB_ACCOUNT", 2, paramaxau);
      return;
      localObject1 = "data.mMainAccount=" + paramaxau.jdField_b_of_type_JavaLangString + " data.mSubUin=" + paramaxau.jdField_c_of_type_JavaLangString;
      break;
    }
    label183:
    ArrayList localArrayList2 = paramaxau.a();
    Object localObject1 = paramaxau.c();
    ArrayList localArrayList3 = paramaxau.b();
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "addAllSubAccountInfo() allSubUin:" + ((ArrayList)localObject1).toString());
      QLog.d("SUB_ACCOUNT", 2, "removeOverdueSubAccountInfo() overdueUin:" + localArrayList3.toString());
    }
    ArrayList localArrayList1 = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          if (!((Iterator)localObject2).hasNext()) {
            break label629;
          }
          localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
          if ((!paramaxau.jdField_b_of_type_JavaLangString.equals(((SubAccountInfo)localObject1).trunkuin)) || (!str.equals(((SubAccountInfo)localObject1).subuin))) {
            continue;
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new SubAccountInfo();
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
          ((SubAccountInfo)localObject2).subuin = str;
          ((SubAccountInfo)localObject2).trunkuin = paramaxau.jdField_b_of_type_JavaLangString;
          ((SubAccountInfo)localObject2).serverErrorType = paramaxau.jdField_b_of_type_Int;
          ((SubAccountInfo)localObject2).serverErrorMsg = paramaxau.jdField_a_of_type_JavaLangString;
          if ((localArrayList2 != null) && (localArrayList2.contains(str)))
          {
            ((SubAccountInfo)localObject2).hintIsNew = true;
            ((SubAccountInfo)localObject2).lasttime = (System.currentTimeMillis() / 1000L);
            if (QLog.isColorLevel()) {
              QLog.d("SUB_ACCOUNT", 2, "addSubAccountInfo() change subUin=" + ((SubAccountInfo)localObject2).subuin + " hintIsNew=" + ((SubAccountInfo)localObject2).hintIsNew + " lasttime=" + ((SubAccountInfo)localObject2).lasttime);
            }
          }
          localArrayList1.add(localObject2);
          continue;
        }
        if (localArrayList3 == null) {
          break label575;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      if (localArrayList3.size() > 0)
      {
        paramaxau = localArrayList3.iterator();
        while (paramaxau.hasNext()) {
          a((String)paramaxau.next());
        }
      }
      label575:
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      if ((localArrayList1 == null) || (localArrayList1.size() <= 0)) {
        break;
      }
      paramaxau = localArrayList1.iterator();
      while (paramaxau.hasNext()) {
        a((SubAccountInfo)paramaxau.next());
      }
      break;
      label629:
      localObject1 = null;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "updateUnreadNum");
    }
    SubAccountMessage localSubAccountMessage = a(paramString1, paramString2);
    if (localSubAccountMessage == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        int i = localSubAccountMessage.unreadNum;
        i -= paramInt;
        if (i == 0) {
          return;
        }
        localSubAccountMessage.unreadNum = paramInt;
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          paramString2 = (SubAccountInfo)localIterator.next();
          if (paramString2 == null) {
            continue;
          }
          boolean bool = paramString1.equals(paramString2.subuin);
          if (!bool) {
            continue;
          }
          if (paramString2 == null) {
            return;
          }
          paramString2.unreadMsgNum -= i;
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          a(localSubAccountMessage);
          axam.a(paramQQAppInterface, paramString1, 6);
          paramQQAppInterface.a().c(paramString1, 7000, -i);
          paramQQAppInterface.a().a(new String[] { ajed.x, paramString1 });
          paramQQAppInterface.C();
          paramString2 = new axau();
          paramString2.jdField_c_of_type_JavaLangString = paramString1;
          paramString2.jdField_c_of_type_Boolean = true;
          paramString2.d = true;
          paramString2.jdField_a_of_type_Int = 0;
          paramQQAppInterface.a().a().a(8003, true, paramString2);
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      paramString2 = null;
    }
  }
  
  public void a(SubAccountMessage paramSubAccountMessage)
  {
    if (QLog.isColorLevel()) {
      if (paramSubAccountMessage != null) {
        break label58;
      }
    }
    label58:
    for (Object localObject1 = "null";; localObject1 = "subUin=" + paramSubAccountMessage.subUin + " senderUin=" + paramSubAccountMessage.senderuin)
    {
      QLog.d("SUB_ACCOUNT", 2, "addNewMessage() " + (String)localObject1);
      if ((paramSubAccountMessage != null) && (paramSubAccountMessage.subUin != null) && (paramSubAccountMessage.senderuin != null)) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label375;
        }
        localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
        if ((localObject1 == null) || (!paramSubAccountMessage.subUin.equals(((SubAccountInfo)localObject1).subuin))) {
          continue;
        }
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramSubAccountMessage.subUin))
        {
          localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramSubAccountMessage.subUin);
          if (localObject2 == null)
          {
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramSubAccountMessage);
            this.jdField_a_of_type_JavaUtilHashMap.put(paramSubAccountMessage.subUin, localObject2);
            a((SubAccountInfo)localObject1, (ArrayList)localObject2, 1);
            this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
            a(paramSubAccountMessage);
            return;
          }
          Iterator localIterator = ((ArrayList)localObject2).iterator();
          if (localIterator.hasNext())
          {
            SubAccountMessage localSubAccountMessage = (SubAccountMessage)localIterator.next();
            if ((!paramSubAccountMessage.subUin.equals(localSubAccountMessage.subUin)) || (!paramSubAccountMessage.senderuin.equals(localSubAccountMessage.senderuin))) {
              continue;
            }
            ((ArrayList)localObject2).remove(localSubAccountMessage);
            this.jdField_a_of_type_Atmp.b(localSubAccountMessage);
          }
          ((ArrayList)localObject2).add(0, paramSubAccountMessage);
          a((SubAccountInfo)localObject1, (ArrayList)localObject2, 1);
          continue;
        }
        localObject2 = new ArrayList();
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      ((ArrayList)localObject2).add(paramSubAccountMessage);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramSubAccountMessage.subUin, localObject2);
      a((SubAccountInfo)localObject1, (ArrayList)localObject2, 1);
      continue;
      label375:
      localObject1 = null;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "removeSubAccountInfo() subUin=" + paramString);
    }
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (!paramString.equals(localSubAccountInfo.subuin)) {
            continue;
          }
          this.jdField_a_of_type_JavaUtilArrayList.remove(localSubAccountInfo);
          paramString = localSubAccountInfo;
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if (paramString == null) {
            break;
          }
          this.jdField_a_of_type_Atmp.b(paramString);
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      paramString = null;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "updateServerError() subUin=" + paramString1 + " error type=" + paramInt + " msg=" + paramString2);
    }
    if (paramString1 == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateServerError() subUin is null.");
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "updateServerError() listSubInfo is null.");
    return;
    Object localObject = null;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (paramString1.equals(localSubAccountInfo.subuin))
          {
            localSubAccountInfo.serverErrorType = paramInt;
            localSubAccountInfo.serverErrorMsg = paramString2;
            localObject = localSubAccountInfo;
          }
        }
        else
        {
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if (localObject == null) {
            break;
          }
          a(localObject);
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setActionTime() subUin=" + paramString + " time=" + paramLong);
    }
    if (paramString == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "setActionTime() listSubInfo is null.");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setActionTime() subUin=" + paramString + " change lasttime=" + paramLong);
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (!paramString.equals(localSubAccountInfo.subuin)) {
            continue;
          }
          localSubAccountInfo.lasttime = paramLong;
          paramString = localSubAccountInfo;
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if (paramString == null) {
            break;
          }
          ThreadManager.getFileThreadHandler().post(new SubAccountManager.2(this, paramString));
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      paramString = null;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int j = 1;
    int k = 0;
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("updateA2() subUin=").append(paramString1).append(" A2=");
      if (paramString2 == null)
      {
        localObject1 = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject1 + " change=" + paramBoolean);
      }
    }
    else
    {
      if (paramString1 != null) {
        break label103;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateA2() subUin is null.");
      }
    }
    label103:
    do
    {
      return;
      localObject1 = Integer.valueOf(paramString2.length());
      break;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label126;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "updateA2() listSubInfo is null.");
    return;
    label126:
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
          if (!paramString1.equals(((SubAccountInfo)localObject1).subuin)) {
            continue;
          }
          if ((paramString2 != null) || (((SubAccountInfo)localObject1).A2 == null))
          {
            i = k;
            if (paramString2 != null)
            {
              i = k;
              if (paramString2.equals(((SubAccountInfo)localObject1).A2)) {}
            }
          }
          else
          {
            if (paramBoolean)
            {
              ((SubAccountInfo)localObject1).lasttime = (System.currentTimeMillis() / 1000L);
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "updateA2() change lasttime=" + ((SubAccountInfo)localObject1).lasttime);
              }
            }
            ((SubAccountInfo)localObject1).A2 = paramString2;
            if (paramString2 != null) {
              break label438;
            }
            ((SubAccountInfo)localObject1).hintIsNew = false;
            if (!QLog.isColorLevel()) {
              break label438;
            }
            QLog.d("SUB_ACCOUNT", 2, "updateA2() set hintIsNew=false");
            break label438;
          }
          if (paramString2 == null)
          {
            ((SubAccountInfo)localObject1).cookie = null;
            if (((SubAccountInfo)localObject1).status != 0) {
              continue;
            }
            ((SubAccountInfo)localObject1).status = 3;
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("SUB_ACCOUNT", 2, "updateA2() change status=" + ((SubAccountInfo)localObject1).status);
              i = j;
            }
            if (i == 0) {
              break label433;
            }
            paramString1 = (String)localObject1;
            this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
            if (paramString1 == null) {
              break;
            }
            ThreadManager.getFileThreadHandler().post(new SubAccountManager.1(this, paramString1));
            return;
          }
          ((SubAccountInfo)localObject1).serverErrorMsg = null;
          ((SubAccountInfo)localObject1).serverErrorType = 0;
          continue;
        }
        paramString1 = null;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      label433:
      continue;
      label438:
      int i = 1;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setRecentListTop() subUin=" + paramString + " isTop=" + paramBoolean);
    }
    if ((paramString == null) || (paramString.length() < 5)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setRecentListTop() subUin=" + paramString + " isTop=" + paramBoolean);
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (!paramString.equals(localSubAccountInfo.subuin)) {
            continue;
          }
          localSubAccountInfo.isTop = paramBoolean;
          paramString = localSubAccountInfo;
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if (paramString == null) {
            break;
          }
          a(paramString);
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      paramString = null;
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("updateCookie() subUin=").append(paramString).append(" cookie=");
      if (paramArrayOfByte == null)
      {
        localObject1 = "null";
        QLog.d("SUB_ACCOUNT", 2, localObject1);
      }
    }
    else
    {
      if (paramString != null) {
        break label82;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateCookie() subUin is null.");
      }
    }
    label82:
    do
    {
      return;
      localObject1 = Integer.valueOf(paramArrayOfByte.length);
      break;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break label105;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "updateCookie() listSubInfo is null.");
    return;
    label105:
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
          if (!paramString.equals(((SubAccountInfo)localObject1).subuin)) {
            continue;
          }
          ((SubAccountInfo)localObject1).cookie = paramArrayOfByte;
          paramString = (String)localObject1;
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if (paramString == null) {
            break;
          }
          a(paramString);
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      paramString = null;
    }
  }
  
  public boolean a(atmo paramatmo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Atmp.a())
    {
      if (paramatmo.getStatus() != 1000) {
        break label48;
      }
      this.jdField_a_of_type_Atmp.b(paramatmo);
      bool1 = bool2;
      if (paramatmo.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label48:
    do
    {
      return bool1;
      if (paramatmo.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramatmo.getStatus() != 1002);
    return this.jdField_a_of_type_Atmp.a(paramatmo);
  }
  
  public boolean a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "isSubAccountUin() , subUin=" + paramString);
    }
    if (paramString == null) {}
    do
    {
      return false;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "isSubAccountUin() listSubInfo is null.");
    return false;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (localSubAccountInfo == null) {
            continue;
          }
          bool = paramString.equals(localSubAccountInfo.subuin);
          if (!bool) {
            continue;
          }
          bool = true;
          return bool;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      boolean bool = false;
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setStatus() subUin=" + paramString + " status=" + paramInt);
    }
    if (paramString == null) {
      return false;
    }
    Object localObject = null;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    label230:
    label235:
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          bool1 = paramString.equals(localSubAccountInfo.subuin);
          if (!bool1) {
            break label235;
          }
          localObject = localSubAccountInfo;
          continue;
        }
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        if (localObject != null)
        {
          if (localObject.status == paramInt) {
            break;
          }
          if ((paramInt != 2) && (paramInt != 3)) {
            break label230;
          }
          boolean bool2 = true;
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("SUB_ACCOUNT", 2, "setStatus() need2setMsgNum_1=" + true);
            bool1 = bool2;
          }
          localObject.status = paramInt;
          a(localObject);
          return bool1;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "setStatus() findInfo is null. return default 0");
      return false;
      boolean bool1 = false;
    }
  }
  
  public byte[] a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "getCookie() subUin=" + paramString);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getCookie() subUin is null.");
      }
    }
    do
    {
      return null;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getCookie() listSubInfo is null.");
    return null;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          boolean bool = paramString.equals(localSubAccountInfo.subuin);
          if (!bool) {
            continue;
          }
          paramString = localSubAccountInfo;
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if (paramString == null) {
            break;
          }
          return paramString.cookie;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      paramString = null;
    }
  }
  
  public int b(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUnNotificationSenderNum() subUin is null.");
      }
    }
    do
    {
      return 0;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getUnNotificationSenderNum() listSubInfo is null.");
    return 0;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (paramString.equals(localSubAccountInfo.subuin)) {
            i = localSubAccountInfo.unNotifySender;
          }
        }
        else
        {
          return i;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public String b(String paramString)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getLatestNick() subUin is null.");
      }
    }
    do
    {
      return null;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getLatestNick() listSubInfo is null.");
    return null;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          boolean bool = paramString.equals(localSubAccountInfo.subuin);
          if (!bool) {
            continue;
          }
          paramString = localSubAccountInfo;
          this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          if (paramString == null) {
            break;
          }
          return paramString.lastUinNick;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      paramString = null;
    }
  }
  
  public ArrayList<SubAccountInfo> b()
  {
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      localArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
      return localArrayList;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "clearAllUnNotifySenderNum()");
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "clearAllUnNotifySenderNum() mapSubMsg is null.");
    return;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (SubAccountInfo)localIterator.next();
        if (localObject2 != null)
        {
          ((SubAccountInfo)localObject2).unNotifySender = 0;
          localObject2 = ((SubAccountInfo)localObject2).subuin;
          localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
          if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
          {
            localObject2 = ((ArrayList)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              SubAccountMessage localSubAccountMessage = (SubAccountMessage)((Iterator)localObject2).next();
              if (localSubAccountMessage.needNotify) {
                localSubAccountMessage.needNotify = false;
              }
            }
          }
        }
      }
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "setAllSubMessageReaded() subUin=" + paramString);
    }
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    Object localObject1;
    Object localObject2;
    try
    {
      if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString)) {
        break label399;
      }
      localObject1 = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label389;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SubAccountMessage)((Iterator)localObject1).next();
        ((SubAccountMessage)localObject2).isread = true;
        ((SubAccountMessage)localObject2).needNotify = false;
        ((SubAccountMessage)localObject2).unreadNum = 0;
      }
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
    } while ((localObject1 == null) || (!paramString.equals(((SubAccountInfo)localObject1).subuin)));
    for (;;)
    {
      if (localObject1 != null)
      {
        ((SubAccountInfo)localObject1).unNotifySender = 0;
        ((SubAccountInfo)localObject1).unreadSenderNum = 0;
        ((SubAccountInfo)localObject1).unreadSenderNum = 0;
        ((SubAccountInfo)localObject1).unreadMsgNum = 0;
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "setAllMessageReaded() info.subuin=" + ((SubAccountInfo)localObject1).subuin + " unreadMsg=" + ((SubAccountInfo)localObject1).unreadMsgNum + " unNotify=" + ((SubAccountInfo)localObject1).unNotifySender + " unreadSender=" + ((SubAccountInfo)localObject1).unreadSenderNum);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      localObject1 = new SubAccountMessage().getTableName();
      localObject2 = new ContentValues();
      ((ContentValues)localObject2).put("isread", Boolean.valueOf(true));
      ((ContentValues)localObject2).put("unreadNum", Integer.valueOf(0));
      boolean bool = this.jdField_a_of_type_Atmp.a((String)localObject1, (ContentValues)localObject2, "subUin=?", new String[] { paramString });
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("SUB_ACCOUNT", 2, "setAllSubMessageReaded() set isRead and unreadNum, result" + bool);
      return;
      label389:
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      return;
      label399:
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      return;
      localObject1 = null;
    }
  }
  
  public int c(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "getUnreadAllMsgNum() subUin is null.");
      }
    }
    do
    {
      return 0;
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SUB_ACCOUNT", 2, "getUnreadAllMsgNum() listSubInfo is null.");
    return 0;
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (paramString.equals(localSubAccountInfo.subuin)) {
            i = localSubAccountInfo.unreadMsgNum;
          }
        }
        else
        {
          return i;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "removeAllMessage() subUin=" + paramString);
    }
    if (paramString == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    Object localObject1;
    Object localObject2;
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
      {
        localObject1 = (List)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SubAccountMessage)((Iterator)localObject1).next();
            this.jdField_a_of_type_Atmp.b((atmo)localObject2);
          }
        }
      }
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
    do
    {
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
    } while ((localObject1 == null) || (!paramString.equals(((SubAccountInfo)localObject1).subuin)));
    for (paramString = (String)localObject1;; paramString = null)
    {
      if (paramString != null)
      {
        paramString.unNotifySender = 0;
        paramString.unreadSenderNum = 0;
        paramString.unreadMsgNum = 0;
        paramString.lastMsg = null;
        paramString.lastUin = null;
        paramString.lastUinNick = null;
        a(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "removeAllMessage() info.subuin=" + paramString.subuin + " unreadMsg=" + paramString.unreadMsgNum + " unNotify=" + paramString.unNotifySender + " unreadSender=" + paramString.unreadSenderNum);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      return;
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "updateSubAccountMsgTimeStr() dateFormate=" + paramString);
    }
    if (paramString == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) && (this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    Object localObject1 = new StringBuilder().append("updateSubAccountMsgTimeStr() ");
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      paramString = "listSubInfo == null";
      QLog.d("SUB_ACCOUNT", 2, paramString);
      localObject1 = new StringBuilder().append("updateSubAccountMsgTimeStr() ");
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        break label163;
      }
    }
    label163:
    for (paramString = "mapSubMsg == null";; paramString = "mapSubMsg.size() == 0")
    {
      QLog.d("SUB_ACCOUNT", 2, paramString);
      return;
      paramString = "listSubInfo.size() == 0";
      break;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    label332:
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (SubAccountInfo)((Iterator)localObject1).next();
          if (localObject2 != null)
          {
            localObject2 = ((SubAccountInfo)localObject2).subuin;
            localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
            if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
            {
              localObject2 = ((ArrayList)localObject2).iterator();
              int i = 1;
              if (((Iterator)localObject2).hasNext())
              {
                SubAccountMessage localSubAccountMessage = (SubAccountMessage)((Iterator)localObject2).next();
                if (localSubAccountMessage == null) {
                  continue;
                }
                localSubAccountMessage.mTimeString = baiu.a(localSubAccountMessage.time * 1000L, true, paramString);
                if (i == 0) {
                  break label332;
                }
                i = 0;
              }
            }
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
    }
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "clearUnreadNum() subUin=" + paramString);
    }
    if (paramString == null) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() != 0) && (this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.size() != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    Object localObject1 = new StringBuilder().append("clearUnreadNum() ");
    if (this.jdField_a_of_type_JavaUtilArrayList == null)
    {
      paramString = "listSubInfo == null";
      QLog.d("SUB_ACCOUNT", 2, paramString);
      localObject1 = new StringBuilder().append("clearUnreadNum() ");
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {
        break label163;
      }
    }
    label163:
    for (paramString = "mapSubMsg == null";; paramString = "mapSubMsg.size() == 0")
    {
      QLog.d("SUB_ACCOUNT", 2, paramString);
      return;
      paramString = "listSubInfo.size() == 0";
      break;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label426;
        }
        localObject1 = (SubAccountInfo)((Iterator)localObject2).next();
        if ((localObject1 == null) || (!paramString.equals(((SubAccountInfo)localObject1).subuin))) {
          continue;
        }
        ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if ((localArrayList == null) || (localArrayList.size() == 0)) {
          continue;
        }
        paramString = localArrayList.iterator();
        if (paramString.hasNext())
        {
          localObject2 = (SubAccountMessage)paramString.next();
          if (localObject2 == null) {
            continue;
          }
          if (!((SubAccountMessage)localObject2).needNotify) {
            break label436;
          }
          ((SubAccountMessage)localObject2).needNotify = false;
          i = 1;
          if (((SubAccountMessage)localObject2).unreadNum != 0)
          {
            ((SubAccountMessage)localObject2).unreadNum = 0;
            i = 1;
          }
          if (i == 0) {
            continue;
          }
          a((atmo)localObject2);
          continue;
        }
        ((SubAccountInfo)localObject1).unNotifySender = 0;
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      ((SubAccountInfo)localObject1).unreadMsgNum = 0;
      ((SubAccountInfo)localObject1).unreadSenderNum = 0;
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "clearUnreadNum() info.subuin=" + ((SubAccountInfo)localObject1).subuin + " unreadMsgNum=" + ((SubAccountInfo)localObject1).unreadMsgNum + " unNotify=" + ((SubAccountInfo)localObject1).unNotifySender + " unreadSender=" + ((SubAccountInfo)localObject1).unreadSenderNum);
      }
      label426:
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      return;
      label436:
      int i = 0;
    }
  }
  
  public void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "cancelHintIsNew() subUin=" + paramString);
    }
    if ((paramString == null) || (paramString.length() <= 4)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    for (;;)
    {
      try
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        if (localIterator.hasNext())
        {
          SubAccountInfo localSubAccountInfo = (SubAccountInfo)localIterator.next();
          if (!paramString.equals(localSubAccountInfo.subuin)) {
            continue;
          }
          if (localSubAccountInfo.hintIsNew)
          {
            localSubAccountInfo.hintIsNew = false;
            paramString = localSubAccountInfo;
            this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
            if (paramString == null) {
              break;
            }
            ThreadManager.getFileThreadHandler().post(new SubAccountManager.3(this, paramString));
            return;
          }
        }
      }
      finally
      {
        this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      paramString = null;
    }
  }
  
  public void g(String paramString)
  {
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "updateMsgData2SupportSubUin() subuin==null");
      }
      return;
    }
    String str = new SubAccountMessage().getTableName();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("subUin", paramString);
    boolean bool = this.jdField_a_of_type_Atmp.a(str, localContentValues, null, null);
    if (QLog.isColorLevel()) {
      QLog.d("SUB_ACCOUNT", 2, "updateMsgData2SupportSubUin() set subUin=" + paramString + " result" + bool);
    }
    if (bool)
    {
      c();
      return;
    }
    a();
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      return;
    }
    finally
    {
      this.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axat
 * JD-Core Version:    0.7.0.1
 */