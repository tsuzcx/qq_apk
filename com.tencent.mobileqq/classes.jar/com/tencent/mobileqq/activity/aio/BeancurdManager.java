package com.tencent.mobileqq.activity.aio;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tofumsg.ITofuManagerNew;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class BeancurdManager
  implements Manager
{
  public static final int[] a;
  public static final int[] b;
  private static int[] c = { -1034, -2015, -2060, -2062, -2061, -7007, -2074, -7009, -7010, -7011, -7012, -2077, -7015, -7016 };
  private final int jdField_a_of_type_Int = 10000;
  private SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ITofuManagerNew jdField_a_of_type_ComTencentMobileqqTofumsgITofuManagerNew;
  private Map<String, Map<Integer, BeancurdMsg>> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 3;
  private Map<String, Long> jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -7015 };
    jdField_b_of_type_ArrayOfInt = new int[] { 13 };
  }
  
  public BeancurdManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTofumsgITofuManagerNew = ((ITofuManagerNew)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TOFU_NEW_MANAGER));
    a();
  }
  
  public static int a(int paramInt)
  {
    if (paramInt > 0)
    {
      int[] arrayOfInt = c;
      if (paramInt <= arrayOfInt.length) {
        return arrayOfInt[(paramInt - 1)];
      }
    }
    return 0;
  }
  
  @Nullable
  private BeancurdMsg a(Map<Integer, BeancurdMsg> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      Object localObject4 = (BeancurdMsg)paramMap.get(Integer.valueOf(((Integer)localIterator.next()).intValue()));
      if (!c((BeancurdMsg)localObject4))
      {
        Object localObject3 = localObject2;
        if (localObject2 == null) {
          localObject3 = new ArrayList();
        }
        ((List)localObject3).add(localObject4);
        localObject2 = localObject3;
      }
      else
      {
        if (localObject1 != null) {}
        try
        {
          int j = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(localObject1.busiid)).intValue();
          int k = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(((BeancurdMsg)localObject4).busiid)).intValue();
          int i = j;
          if (localObject1.ispush) {
            i = j * 100;
          }
          boolean bool = ((BeancurdMsg)localObject4).ispush;
          j = k;
          if (bool) {
            j = k * 100;
          }
          if (i > j) {
            localObject1 = localObject4;
          }
        }
        catch (Exception localException)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("trigger 2 mPriorityMap null...");
          ((StringBuilder)localObject4).append(localException.getMessage());
          c(((StringBuilder)localObject4).toString());
        }
      }
    }
    if (localObject2 != null)
    {
      paramMap = ((List)localObject2).iterator();
      while (paramMap.hasNext())
      {
        localObject2 = (BeancurdMsg)paramMap.next();
        b(((BeancurdMsg)localObject2).frienduin, 0, ((BeancurdMsg)localObject2).busiid);
      }
    }
    return localObject1;
  }
  
  private MessageRecord a(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong)
  {
    String str;
    if ((paramString2 instanceof String)) {
      str = paramString2;
    } else {
      str = "";
    }
    int i = a(paramInt2);
    MessageRecord localMessageRecord = MessageRecordFactory.a(i);
    if (paramLong < 0L) {
      paramLong = MessageCache.a();
    }
    localMessageRecord.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramString1, paramString1, str, paramLong, i, paramInt1, paramLong);
    localMessageRecord.isread = true;
    localMessageRecord.msg = paramString2;
    if (paramInt2 == 5) {}
    try
    {
      localMessageRecord.msg = null;
      localMessageRecord.msgData = paramString2.getBytes("ISO_8859_1");
      ((MessageForQQStoryFeed)localMessageRecord).mergeFrom(localMessageRecord.msgData);
      return localMessageRecord;
    }
    catch (Exception paramString1) {}
    return localMessageRecord;
  }
  
  private MessageRecord a(List<MessageRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
        if (c(localMessageRecord.msgtype) > 0) {
          return localMessageRecord;
        }
        i -= 1;
      }
    }
    return null;
  }
  
  private String a()
  {
    return "{\n\t\"priority\": {\n\t\t\"1\": 1,\n\t\t\"2\": 2,\n\t\t\"3\": 5,\n\t\t\"4\": 6,\n\t\t\"5\": 7,\n\t\t\"6\": 3,\n\t\t\"7\": 4\n\t},\n\t\"interval\": 3\n}";
  }
  
  @Nullable
  private List<MessageRecord> a(String paramString, int paramInt)
  {
    List localList = b(paramString, paramInt);
    paramString = localList;
    if (localList != null)
    {
      paramInt = localList.size();
      paramString = localList;
      if (paramInt > 0)
      {
        int i = this.jdField_b_of_type_Int;
        paramString = localList;
        if (paramInt > i) {
          paramString = localList.subList(paramInt - i, paramInt);
        }
      }
    }
    return paramString;
  }
  
  private void a()
  {
    Object localObject2 = SharedPreUtils.a();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = a();
    }
    a((String)localObject1);
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localObject2 = localEntityManager.query(BeancurdMsg.class, new BeancurdMsg().getTableName(), false, null, null, null, null, null, null);
    if (localObject2 != null) {
      c(String.format("init.beancurd table count = %d", new Object[] { Integer.valueOf(((List)localObject2).size()) }));
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 10000))
    {
      ((List)localObject2).clear();
      localEntityManager.drop(BeancurdMsg.class);
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      c(String.format("init: has BeancurdMsg  size = %d ", new Object[] { Integer.valueOf(((List)localObject2).size()) }));
      localObject1 = null;
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        BeancurdMsg localBeancurdMsg = (BeancurdMsg)localIterator.next();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" the table pending show msg :");
        ((StringBuilder)localObject2).append(localBeancurdMsg);
        c(((StringBuilder)localObject2).toString());
        if (!c(localBeancurdMsg))
        {
          c(String.format("init: has invalid msg  ", new Object[0]));
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((List)localObject2).add(localBeancurdMsg);
          localObject1 = localObject2;
        }
        else
        {
          String str = localBeancurdMsg.frienduin;
          Map localMap = (Map)this.jdField_a_of_type_JavaUtilMap.get(str);
          localObject2 = localMap;
          if (localMap == null) {
            localObject2 = new ConcurrentHashMap(6);
          }
          ((Map)localObject2).put(Integer.valueOf(localBeancurdMsg.busiid), localBeancurdMsg);
          this.jdField_a_of_type_JavaUtilMap.put(str, localObject2);
        }
      }
      if (localObject1 != null) {
        localObject1 = ((List)localObject1).iterator();
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        localEntityManager.remove((BeancurdMsg)((Iterator)localObject1).next());
        continue;
        c(String.format("init: has no BeancurdMsg  ", new Object[0]));
      }
    }
    localEntityManager.close();
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.msgtype, paramMessageRecord.uniseq);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong, BeancurdMsg paramBeancurdMsg)
  {
    paramString1 = a(paramString1, paramInt1, paramInt2, paramString2, paramLong);
    paramString1.isread = true;
    if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, false))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString1, paramString1.selfuin);
      this.jdField_a_of_type_ComTencentMobileqqTofumsgITofuManagerNew.a(paramBeancurdMsg);
    }
  }
  
  private void a(String paramString, int paramInt, MessageRecord paramMessageRecord, BeancurdMsg paramBeancurdMsg)
  {
    if (paramBeancurdMsg != null)
    {
      c(String.format("triggerInsert: best beancurd id = %d ", new Object[] { Integer.valueOf(paramBeancurdMsg.busiid) }));
      if (!this.jdField_a_of_type_ComTencentMobileqqTofumsgITofuManagerNew.a(paramBeancurdMsg))
      {
        QLog.d("TofuNew.TofuManagerNew", 1, new Object[] { "handleBestMsg bug can not insert, bestMsg = ", paramBeancurdMsg.toString() });
        return;
      }
      boolean bool = paramBeancurdMsg.isNeedDelHistory;
      int i = paramBeancurdMsg.busiid;
      String str = paramBeancurdMsg.buffer;
      long l = paramBeancurdMsg.msgTime;
      if (paramMessageRecord == null)
      {
        if (bool) {
          a(paramString, paramInt, i);
        }
        b(paramString, paramInt, i);
        a(paramString, paramInt, i, str, l, paramBeancurdMsg);
      }
      for (;;)
      {
        bool = true;
        break;
        if ((paramMessageRecord.msgtype != a(i)) && (!paramBeancurdMsg.ispush))
        {
          bool = false;
          break;
        }
        a(paramMessageRecord);
        if (bool) {
          a(paramString, paramInt, i);
        }
        b(paramString, paramInt, i);
        a(paramString, paramInt, i, str, l, paramBeancurdMsg);
      }
      if ((bool) && (paramBeancurdMsg.ispush)) {
        a(1, i);
      }
      c(String.format("triggerInsert: is inserted = %b ", new Object[] { Boolean.valueOf(bool) }));
    }
  }
  
  private boolean a(int paramInt)
  {
    int[] arrayOfInt = jdField_b_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    int[] arrayOfInt = c;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if (paramMessageRecord.msgtype == k) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean a(@NonNull String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    return (localQQMessageFacade.a()) && (paramString.equals(localQQMessageFacade.a())) && (localQQMessageFacade.a() == paramInt);
  }
  
  private List<MessageRecord> b(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramInt, null);
  }
  
  private boolean b(BeancurdMsg paramBeancurdMsg)
  {
    String str1 = paramBeancurdMsg.frienduin;
    int i = paramBeancurdMsg.busiid;
    boolean bool1 = paramBeancurdMsg.ispush;
    boolean bool2 = paramBeancurdMsg.isNeedDelHistory;
    String str2 = paramBeancurdMsg.buffer;
    long l1 = paramBeancurdMsg.startTime;
    long l2 = paramBeancurdMsg.validTime;
    long l3 = paramBeancurdMsg.originTime;
    Object localObject2 = (Map)this.jdField_a_of_type_JavaUtilMap.get(str1);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ConcurrentHashMap(6);
    }
    BeancurdMsg localBeancurdMsg = (BeancurdMsg)((Map)localObject1).get(Integer.valueOf(i));
    localObject2 = localBeancurdMsg;
    if (localBeancurdMsg == null) {
      localObject2 = new BeancurdMsg();
    }
    ((BeancurdMsg)localObject2).busiid = i;
    ((BeancurdMsg)localObject2).frienduin = str1;
    ((BeancurdMsg)localObject2).ispush = bool1;
    ((BeancurdMsg)localObject2).isNeedDelHistory = bool2;
    ((BeancurdMsg)localObject2).buffer = str2;
    ((BeancurdMsg)localObject2).startTime = l1;
    ((BeancurdMsg)localObject2).validTime = l2;
    ((BeancurdMsg)localObject2).originTime = l3;
    ((BeancurdMsg)localObject2).token = paramBeancurdMsg.token;
    ((Map)localObject1).put(Integer.valueOf(i), localObject2);
    this.jdField_a_of_type_JavaUtilMap.put(str1, localObject1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().persistOrReplace((Entity)localObject2);
    return true;
  }
  
  private int c(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      int[] arrayOfInt = c;
      if (i >= arrayOfInt.length) {
        break;
      }
      if (arrayOfInt[i] == paramInt) {
        return i + 1;
      }
      i += 1;
    }
    return 0;
  }
  
  private void c(String paramString)
  {
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_Boolean))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fight: ");
      localStringBuilder.append(paramString);
      QLog.d("BeancurdManager", 2, localStringBuilder.toString());
    }
  }
  
  private boolean c(BeancurdMsg paramBeancurdMsg)
  {
    long l = MessageCache.a();
    boolean bool;
    if (l > paramBeancurdMsg.startTime + paramBeancurdMsg.validTime) {
      bool = false;
    } else {
      bool = true;
    }
    c(String.format("busiID:%d,now:%d,BeancurdMsg.startTime:%d,validTime:%d", new Object[] { Integer.valueOf(paramBeancurdMsg.busiid), Long.valueOf(l), Long.valueOf(paramBeancurdMsg.startTime), Long.valueOf(paramBeancurdMsg.validTime) }));
    return bool;
  }
  
  public long a(String paramString)
  {
    c(String.format(" blockBeancurdForQZone ", new Object[0]));
    long l = SystemClock.uptimeMillis() + 5000L;
    this.jdField_b_of_type_JavaUtilMap.put(paramString, Long.valueOf(l));
    return l;
  }
  
  public BeancurdMsg a(String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (Map)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (paramString != null) {
        return (BeancurdMsg)paramString.get(Integer.valueOf(paramInt2));
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    String str;
    if (paramInt1 != 1) {
      if (paramInt1 != 2) {
        if (paramInt1 != 3) {
          if (paramInt1 != 4) {
            str = "";
          }
        }
      }
    }
    for (;;)
    {
      break;
      str = "0x8009434";
      continue;
      str = "0x8009433";
      continue;
      str = "0x8009432";
      continue;
      str = "0x8009431";
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", str, str, 0, 0, "", Integer.toString(paramInt2), "", "");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("priority"))
      {
        localObject = paramString.getJSONObject("priority");
        if ((localObject != null) && (((JSONObject)localObject).length() > 0))
        {
          Iterator localIterator = ((JSONObject)localObject).keys();
          while (localIterator.hasNext())
          {
            String str = localIterator.next().toString();
            int i = ((JSONObject)localObject).optInt(str);
            this.jdField_a_of_type_AndroidUtilSparseArray.append(Integer.parseInt(str), Integer.valueOf(i));
          }
        }
      }
      if (paramString.has("interval"))
      {
        this.jdField_b_of_type_Int = paramString.optInt("interval");
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseConfig.error:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      c(((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      bool = this.jdField_b_of_type_Boolean;
      if (bool) {
        return;
      }
      this.jdField_b_of_type_JavaUtilMap.remove(paramString);
      c(String.format("triggerInfsert: start   ", new Object[0]));
      Object localObject = (Map)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      if (localObject == null)
      {
        c(String.format("triggerInsert: no beancurd  ", new Object[0]));
        return;
      }
      MessageRecord localMessageRecord = a(a(paramString, paramInt));
      localObject = a((Map)localObject);
      if (localObject != null)
      {
        bool = a(((BeancurdMsg)localObject).busiid);
        if (bool) {
          return;
        }
      }
      a(paramString, paramInt, localMessageRecord, (BeancurdMsg)localObject);
      return;
    }
    finally {}
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramInt1, new int[] { a(paramInt2) });
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString.next();
        if (localMessageRecord != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.msgtype, localMessageRecord.uniseq);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
  }
  
  public boolean a(BeancurdMsg paramBeancurdMsg)
  {
    try
    {
      bool1 = this.jdField_b_of_type_Boolean;
      if (bool1) {
        return false;
      }
      if (paramBeancurdMsg == null) {
        return false;
      }
      bool1 = a(paramBeancurdMsg.busiid);
      if (bool1) {
        return false;
      }
      QLog.d("TofuNew.TofuManagerNew", 1, new Object[] { "receiveBeancurd: msg = ", paramBeancurdMsg.toString() });
      if (!this.jdField_a_of_type_ComTencentMobileqqTofumsgITofuManagerNew.a(paramBeancurdMsg))
      {
        QLog.d("TofuNew.TofuManagerNew", 1, "can not add tofu msg");
        return false;
      }
      String str1 = paramBeancurdMsg.frienduin;
      i = paramBeancurdMsg.busiid;
      bool1 = paramBeancurdMsg.ispush;
      boolean bool2 = paramBeancurdMsg.isNeedDelHistory;
      String str2 = paramBeancurdMsg.buffer;
      long l = paramBeancurdMsg.msgTime;
      a(3, i);
      boolean bool3 = a(str1, 0);
      if (this.jdField_b_of_type_JavaUtilMap.containsKey(str1))
      {
        if (((Long)this.jdField_b_of_type_JavaUtilMap.get(str1)).longValue() >= SystemClock.uptimeMillis())
        {
          c(String.format(" receiveBeancurd blocking status ", new Object[0]));
          if ((i != 2) && (i != 12))
          {
            b(paramBeancurdMsg);
            return false;
          }
          this.jdField_b_of_type_JavaUtilMap.remove(str1);
          a(b(str1, 0), true);
          if (bool2) {
            a(str1, 0, i);
          }
          b(str1, 0, i);
          a(str1, 0, i, str2, l, paramBeancurdMsg);
          return true;
        }
        this.jdField_b_of_type_JavaUtilMap.remove(str1);
      }
      if (TextUtils.isEmpty(str2))
      {
        b(str1, 0, i);
        if (bool2) {
          a(str1, 0, i);
        }
        return true;
      }
      c(String.format("receiveBeancurd: msg:%s ", new Object[] { paramBeancurdMsg.toString() }));
      MessageRecord localMessageRecord = a(a(str1, 0));
      if (localMessageRecord == null)
      {
        c(String.format("receiveBeancurd: lastBean == null ", new Object[0]));
        if (bool2) {
          a(str1, 0, i);
        }
        b(str1, 0, i);
        a(str1, 0, i, str2, l, paramBeancurdMsg);
      }
      else
      {
        c(String.format("receiveBeancurd: isAIOFront:%b", new Object[] { Boolean.valueOf(bool3) }));
        if (bool3)
        {
          b(paramBeancurdMsg);
          break label624;
        }
        int j = localMessageRecord.msgtype;
        int k = a(i);
        c(String.format("receiveBeancurd: lastBeanMsgType = %d,newBeanMsgType= %d ", new Object[] { Integer.valueOf(j), Integer.valueOf(k) }));
        if ((j != k) && (!bool1))
        {
          b(paramBeancurdMsg);
          break label624;
        }
        a(localMessageRecord);
        if (bool2) {
          a(str1, 0, i);
        }
        b(str1, 0, i);
        a(str1, 0, i, str2, l, paramBeancurdMsg);
      }
    }
    finally
    {
      for (;;)
      {
        int i;
        for (;;)
        {
          throw paramBeancurdMsg;
        }
        boolean bool1 = true;
        continue;
        label624:
        bool1 = false;
      }
    }
    if ((paramBeancurdMsg.ispush) && (bool1)) {
      a(1, i);
    }
    c(String.format("receiveBeancurd: isInsert = %b ", new Object[] { Boolean.valueOf(bool1) }));
    return bool1;
  }
  
  public boolean a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    int j = this.jdField_b_of_type_Int;
    int k = paramList.size();
    if ((j > 0) && (k > 0))
    {
      int i = 0;
      while ((i < Math.min(j, k)) && (c(((MessageRecord)paramList.get(k - i - 1)).msgtype) <= 0)) {
        i += 1;
      }
      if (i < Math.min(j, k))
      {
        paramList = (MessageRecord)paramList.remove(k - i - 1);
        if ((paramList != null) && (paramBoolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramList.frienduin, paramList.istroop, paramList.msgtype, paramList.uniseq);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramList.frienduin, paramList.istroop, paramList.uniseq);
        }
        paramBoolean = true;
        break label163;
      }
    }
    paramBoolean = false;
    label163:
    c(String.format(" filter beancurd is = %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    return paramBoolean;
  }
  
  public int b(int paramInt)
  {
    return ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, Integer.valueOf(100000))).intValue();
  }
  
  public void b(String paramString)
  {
    int i = 1;
    c(String.format(" onDelFriend = %s", new Object[] { paramString }));
    while (i <= 14)
    {
      b(paramString, 0, i);
      i += 1;
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    Map localMap = (Map)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localMap != null)
    {
      BeancurdMsg localBeancurdMsg = (BeancurdMsg)localMap.get(Integer.valueOf(paramInt2));
      if (localBeancurdMsg != null)
      {
        localMap.remove(Integer.valueOf(paramInt2));
        this.jdField_a_of_type_JavaUtilMap.put(paramString, localMap);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().remove(localBeancurdMsg);
      }
    }
  }
  
  public void onDestroy()
  {
    c(" onDestory...");
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BeancurdManager
 * JD-Core Version:    0.7.0.1
 */