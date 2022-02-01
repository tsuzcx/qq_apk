package com.tencent.mobileqq.activity.aio;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.beancurd.IBeancurdBusinessHandler;
import com.tencent.mobileqq.config.BeancurdConfProcessor;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tofumsg.BeancurdUtil;
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
  public static final int[] a = { -7015 };
  public static final int[] b = { 13, 1, 3 };
  public static int[] c = new int[0];
  private static int[] k = { -1034, -2015, -2060, -2062, -2061, -7007, -2074, -7009, -7010, -7011, -7012, -2077, -7015, -7016 };
  private QQAppInterface d;
  private SparseArray<Integer> e = new SparseArray();
  private Map<String, Map<Integer, BeancurdMsg>> f = new ConcurrentHashMap();
  private Map<String, Long> g = new ConcurrentHashMap();
  private final int h = 10000;
  private boolean i = true;
  private boolean j;
  private int l = 3;
  private ITofuManagerNew m;
  
  public BeancurdManager(QQAppInterface paramQQAppInterface)
  {
    this.d = paramQQAppInterface;
    this.m = ((ITofuManagerNew)this.d.getManager(QQManagerFactory.TOFU_NEW_MANAGER));
    a();
  }
  
  public static int a(int paramInt)
  {
    if (paramInt > 0)
    {
      int[] arrayOfInt = k;
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
          int i1 = ((Integer)this.e.get(localObject1.busiid)).intValue();
          int i2 = ((Integer)this.e.get(((BeancurdMsg)localObject4).busiid)).intValue();
          int n = i1;
          if (localObject1.ispush) {
            n = i1 * 100;
          }
          boolean bool = ((BeancurdMsg)localObject4).ispush;
          i1 = i2;
          if (bool) {
            i1 = i2 * 100;
          }
          if (n > i1) {
            localObject1 = localObject4;
          }
        }
        catch (Exception localException)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("trigger 2 mPriorityMap null...");
          ((StringBuilder)localObject4).append(localException.getMessage());
          d(((StringBuilder)localObject4).toString());
        }
      }
    }
    if (localObject2 != null)
    {
      paramMap = ((List)localObject2).iterator();
      while (paramMap.hasNext())
      {
        localObject2 = (BeancurdMsg)paramMap.next();
        c(((BeancurdMsg)localObject2).frienduin, 0, ((BeancurdMsg)localObject2).busiid);
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
    int n = a(paramInt2);
    MessageRecord localMessageRecord = MessageRecordFactory.a(n);
    if (paramLong < 0L) {
      paramLong = MessageCache.c();
    }
    localMessageRecord.init(this.d.getAccount(), paramString1, paramString1, str, paramLong, n, paramInt1, paramLong);
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
      int n = paramList.size() - 1;
      while (n >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(n);
        if (f(localMessageRecord.msgtype) > 0) {
          return localMessageRecord;
        }
        n -= 1;
      }
    }
    return null;
  }
  
  private void a()
  {
    Object localObject2 = SharedPreUtils.r();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = b();
    }
    a((String)localObject1);
    EntityManager localEntityManager = this.d.getEntityManagerFactory().createEntityManager();
    localObject2 = localEntityManager.query(BeancurdMsg.class, new BeancurdMsg().getTableName(), false, null, null, null, null, null, null);
    if (localObject2 != null) {
      d(String.format("init.beancurd table count = %d", new Object[] { Integer.valueOf(((List)localObject2).size()) }));
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 10000))
    {
      ((List)localObject2).clear();
      localEntityManager.drop(BeancurdMsg.class);
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      d(String.format("init: has BeancurdMsg  size = %d ", new Object[] { Integer.valueOf(((List)localObject2).size()) }));
      localObject1 = null;
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        BeancurdMsg localBeancurdMsg = (BeancurdMsg)localIterator.next();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(" the table pending show msg :");
        ((StringBuilder)localObject2).append(localBeancurdMsg);
        d(((StringBuilder)localObject2).toString());
        if (!c(localBeancurdMsg))
        {
          d(String.format("init: has invalid msg  ", new Object[0]));
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
          Map localMap = (Map)this.f.get(str);
          localObject2 = localMap;
          if (localMap == null) {
            localObject2 = new ConcurrentHashMap(6);
          }
          ((Map)localObject2).put(Integer.valueOf(localBeancurdMsg.busiid), localBeancurdMsg);
          this.f.put(str, localObject2);
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
        d(String.format("init: has no BeancurdMsg  ", new Object[0]));
      }
    }
    localEntityManager.close();
  }
  
  private void a(String paramString1, int paramInt1, int paramInt2, String paramString2, long paramLong, BeancurdMsg paramBeancurdMsg)
  {
    paramString1 = a(paramString1, paramInt1, paramInt2, paramString2, paramLong);
    paramString1.isread = true;
    if (!MessageHandlerUtils.a(this.d, paramString1, false))
    {
      this.d.getMessageFacade().a(paramString1, paramString1.selfuin);
      this.m.b(paramBeancurdMsg);
    }
  }
  
  private void a(String paramString, int paramInt, MessageRecord paramMessageRecord, BeancurdMsg paramBeancurdMsg)
  {
    if (paramBeancurdMsg != null)
    {
      d(String.format("triggerInsert: best beancurd id = %d ", new Object[] { Integer.valueOf(paramBeancurdMsg.busiid) }));
      if (!this.m.a(paramBeancurdMsg))
      {
        QLog.d("TofuNew.TofuManagerNew", 1, new Object[] { "handleBestMsg bug can not insert, bestMsg = ", paramBeancurdMsg.toString() });
        return;
      }
      boolean bool = paramBeancurdMsg.isNeedDelHistory;
      int n = paramBeancurdMsg.busiid;
      String str = paramBeancurdMsg.buffer;
      long l1 = paramBeancurdMsg.msgTime;
      if (paramMessageRecord == null)
      {
        if (bool) {
          a(paramString, paramInt, n);
        }
        c(paramString, paramInt, n);
        a(paramString, paramInt, n, str, l1, paramBeancurdMsg);
      }
      for (;;)
      {
        bool = true;
        break;
        if ((paramMessageRecord.msgtype != a(n)) && (!paramBeancurdMsg.ispush))
        {
          bool = false;
          break;
        }
        b(paramMessageRecord);
        if (bool) {
          a(paramString, paramInt, n);
        }
        c(paramString, paramInt, n);
        a(paramString, paramInt, n, str, l1, paramBeancurdMsg);
      }
      if ((bool) && (paramBeancurdMsg.ispush)) {
        a(1, n);
      }
      d(String.format("triggerInsert: is inserted = %b ", new Object[] { Boolean.valueOf(bool) }));
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    int[] arrayOfInt = k;
    int i1 = arrayOfInt.length;
    int n = 0;
    while (n < i1)
    {
      int i2 = arrayOfInt[n];
      if (paramMessageRecord.msgtype == i2) {
        return true;
      }
      n += 1;
    }
    return false;
  }
  
  private String b()
  {
    return "{\n\t\"priority\": {\n\t\t\"1\": 1,\n\t\t\"2\": 2,\n\t\t\"3\": 5,\n\t\t\"4\": 6,\n\t\t\"5\": 7,\n\t\t\"6\": 3,\n\t\t\"7\": 4\n\t},\n\t\"interval\": 3\n}";
  }
  
  @Nullable
  private List<MessageRecord> b(String paramString, int paramInt)
  {
    List localList = c(paramString, paramInt);
    paramString = localList;
    if (localList != null)
    {
      paramInt = localList.size();
      paramString = localList;
      if (paramInt > 0)
      {
        int n = this.l;
        paramString = localList;
        if (paramInt > n) {
          paramString = localList.subList(paramInt - n, paramInt);
        }
      }
    }
    return paramString;
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    this.d.getMessageFacade().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.msgtype, paramMessageRecord.uniseq);
    this.d.getMessageFacade().h(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
  }
  
  private boolean b(BeancurdMsg paramBeancurdMsg)
  {
    String str1 = paramBeancurdMsg.frienduin;
    int n = paramBeancurdMsg.busiid;
    boolean bool1 = paramBeancurdMsg.ispush;
    boolean bool2 = paramBeancurdMsg.isNeedDelHistory;
    String str2 = paramBeancurdMsg.buffer;
    long l1 = paramBeancurdMsg.startTime;
    long l2 = paramBeancurdMsg.validTime;
    long l3 = paramBeancurdMsg.originTime;
    Object localObject2 = (Map)this.f.get(str1);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ConcurrentHashMap(6);
    }
    BeancurdMsg localBeancurdMsg = (BeancurdMsg)((Map)localObject1).get(Integer.valueOf(n));
    localObject2 = localBeancurdMsg;
    if (localBeancurdMsg == null) {
      localObject2 = new BeancurdMsg();
    }
    ((BeancurdMsg)localObject2).busiid = n;
    ((BeancurdMsg)localObject2).frienduin = str1;
    ((BeancurdMsg)localObject2).ispush = bool1;
    ((BeancurdMsg)localObject2).isNeedDelHistory = bool2;
    ((BeancurdMsg)localObject2).buffer = str2;
    ((BeancurdMsg)localObject2).startTime = l1;
    ((BeancurdMsg)localObject2).validTime = l2;
    ((BeancurdMsg)localObject2).originTime = l3;
    ((BeancurdMsg)localObject2).token = paramBeancurdMsg.token;
    ((Map)localObject1).put(Integer.valueOf(n), localObject2);
    this.f.put(str1, localObject1);
    this.d.getEntityManagerFactory().createEntityManager().persistOrReplace((Entity)localObject2);
    return true;
  }
  
  private List<MessageRecord> c(String paramString, int paramInt)
  {
    return this.d.getMessageFacade().a(paramString, paramInt, null);
  }
  
  public static boolean c(int paramInt)
  {
    int[] arrayOfInt = b;
    int i1 = arrayOfInt.length;
    int n = 0;
    while (n < i1)
    {
      if (arrayOfInt[n] == paramInt) {
        return true;
      }
      n += 1;
    }
    return false;
  }
  
  private boolean c(BeancurdMsg paramBeancurdMsg)
  {
    long l1 = MessageCache.c();
    boolean bool;
    if (l1 > paramBeancurdMsg.startTime + paramBeancurdMsg.validTime) {
      bool = false;
    } else {
      bool = true;
    }
    d(String.format("busiID:%d,now:%d,BeancurdMsg.startTime:%d,validTime:%d", new Object[] { Integer.valueOf(paramBeancurdMsg.busiid), Long.valueOf(l1), Long.valueOf(paramBeancurdMsg.startTime), Long.valueOf(paramBeancurdMsg.validTime) }));
    return bool;
  }
  
  private void d(String paramString)
  {
    if ((QLog.isColorLevel()) && (this.i))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fight: ");
      localStringBuilder.append(paramString);
      QLog.d("BeancurdManager", 2, localStringBuilder.toString());
    }
  }
  
  public static boolean d(int paramInt)
  {
    if (paramInt == 13) {
      return true;
    }
    if (e(paramInt))
    {
      IBeancurdBusinessHandler localIBeancurdBusinessHandler = (IBeancurdBusinessHandler)BeancurdUtil.a().get(Integer.valueOf(paramInt));
      if (localIBeancurdBusinessHandler != null) {
        return localIBeancurdBusinessHandler.a();
      }
    }
    return BeancurdConfProcessor.a();
  }
  
  private boolean d(@NonNull String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    QQMessageFacade localQQMessageFacade = this.d.getMessageFacade();
    return (localQQMessageFacade.n()) && (paramString.equals(localQQMessageFacade.l())) && (localQQMessageFacade.m() == paramInt);
  }
  
  public static boolean e(int paramInt)
  {
    int[] arrayOfInt = c;
    int i1 = arrayOfInt.length;
    int n = 0;
    while (n < i1)
    {
      if (arrayOfInt[n] == paramInt) {
        return true;
      }
      n += 1;
    }
    return false;
  }
  
  private int f(int paramInt)
  {
    int n = 0;
    for (;;)
    {
      int[] arrayOfInt = k;
      if (n >= arrayOfInt.length) {
        break;
      }
      if (arrayOfInt[n] == paramInt) {
        return n + 1;
      }
      n += 1;
    }
    return 0;
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
    ReportController.b(this.d, "dc00898", "", "", str, str, 0, 0, "", Integer.toString(paramInt2), "", "");
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
            int n = ((JSONObject)localObject).optInt(str);
            this.e.append(Integer.parseInt(str), Integer.valueOf(n));
          }
        }
      }
      if (paramString.has("interval"))
      {
        this.l = paramString.optInt("interval");
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseConfig.error:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      d(((StringBuilder)localObject).toString());
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
      bool = this.j;
      if (bool) {
        return;
      }
      this.g.remove(paramString);
      d(String.format("triggerInfsert: start   ", new Object[0]));
      Object localObject = (Map)this.f.get(paramString);
      if (localObject == null)
      {
        d(String.format("triggerInsert: no beancurd  ", new Object[0]));
        return;
      }
      MessageRecord localMessageRecord = a(b(paramString, paramInt));
      localObject = a((Map)localObject);
      if ((localObject != null) && (c(((BeancurdMsg)localObject).busiid)))
      {
        bool = d(((BeancurdMsg)localObject).busiid);
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
    paramString = this.d.getMessageFacade().a(paramString, paramInt1, new int[] { a(paramInt2) });
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString.next();
        if (localMessageRecord != null)
        {
          this.d.getMessageFacade().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.msgtype, localMessageRecord.uniseq);
          this.d.getMessageFacade().h(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
    }
  }
  
  public boolean a(BeancurdMsg paramBeancurdMsg)
  {
    try
    {
      bool1 = this.j;
      if (bool1) {
        return false;
      }
      if (paramBeancurdMsg == null) {
        return false;
      }
      if (c(paramBeancurdMsg.busiid))
      {
        bool1 = d(paramBeancurdMsg.busiid);
        if (bool1) {
          return false;
        }
      }
      QLog.d("TofuNew.TofuManagerNew", 1, new Object[] { "receiveBeancurd: msg = ", paramBeancurdMsg.toString() });
      if (!this.m.a(paramBeancurdMsg))
      {
        QLog.d("TofuNew.TofuManagerNew", 1, "can not add tofu msg");
        return false;
      }
      String str1 = paramBeancurdMsg.frienduin;
      n = paramBeancurdMsg.busiid;
      bool1 = paramBeancurdMsg.ispush;
      boolean bool2 = paramBeancurdMsg.isNeedDelHistory;
      String str2 = paramBeancurdMsg.buffer;
      long l1 = paramBeancurdMsg.msgTime;
      a(3, n);
      boolean bool3 = d(str1, 0);
      if (this.g.containsKey(str1))
      {
        if (((Long)this.g.get(str1)).longValue() >= SystemClock.uptimeMillis())
        {
          d(String.format(" receiveBeancurd blocking status ", new Object[0]));
          if ((n != 2) && (n != 12))
          {
            b(paramBeancurdMsg);
            return false;
          }
          this.g.remove(str1);
          a(c(str1, 0), true);
          if (bool2) {
            a(str1, 0, n);
          }
          c(str1, 0, n);
          a(str1, 0, n, str2, l1, paramBeancurdMsg);
          return true;
        }
        this.g.remove(str1);
      }
      if (TextUtils.isEmpty(str2))
      {
        c(str1, 0, n);
        if (bool2) {
          a(str1, 0, n);
        }
        return true;
      }
      d(String.format("receiveBeancurd: msg:%s ", new Object[] { paramBeancurdMsg.toString() }));
      MessageRecord localMessageRecord = a(b(str1, 0));
      if (localMessageRecord == null)
      {
        d(String.format("receiveBeancurd: lastBean == null ", new Object[0]));
        if (bool2) {
          a(str1, 0, n);
        }
        c(str1, 0, n);
        a(str1, 0, n, str2, l1, paramBeancurdMsg);
      }
      else
      {
        d(String.format("receiveBeancurd: isAIOFront:%b", new Object[] { Boolean.valueOf(bool3) }));
        if (bool3)
        {
          b(paramBeancurdMsg);
          break label633;
        }
        int i1 = localMessageRecord.msgtype;
        int i2 = a(n);
        d(String.format("receiveBeancurd: lastBeanMsgType = %d,newBeanMsgType= %d ", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
        if ((i1 != i2) && (!bool1))
        {
          b(paramBeancurdMsg);
          break label633;
        }
        b(localMessageRecord);
        if (bool2) {
          a(str1, 0, n);
        }
        c(str1, 0, n);
        a(str1, 0, n, str2, l1, paramBeancurdMsg);
      }
    }
    finally
    {
      for (;;)
      {
        int n;
        for (;;)
        {
          throw paramBeancurdMsg;
        }
        boolean bool1 = true;
        continue;
        label633:
        bool1 = false;
      }
    }
    if ((paramBeancurdMsg.ispush) && (bool1)) {
      a(1, n);
    }
    d(String.format("receiveBeancurd: isInsert = %b ", new Object[] { Boolean.valueOf(bool1) }));
    return bool1;
  }
  
  public boolean a(List<MessageRecord> paramList, boolean paramBoolean)
  {
    int i1 = this.l;
    int i2 = paramList.size();
    if ((i1 > 0) && (i2 > 0))
    {
      int n = 0;
      while ((n < Math.min(i1, i2)) && (f(((MessageRecord)paramList.get(i2 - n - 1)).msgtype) <= 0)) {
        n += 1;
      }
      if (n < Math.min(i1, i2))
      {
        paramList = (MessageRecord)paramList.remove(i2 - n - 1);
        if ((paramList != null) && (paramBoolean))
        {
          this.d.getMessageFacade().a(paramList.frienduin, paramList.istroop, paramList.msgtype, paramList.uniseq);
          this.d.getMessageFacade().h(paramList.frienduin, paramList.istroop, paramList.uniseq);
        }
        paramBoolean = true;
        break label163;
      }
    }
    paramBoolean = false;
    label163:
    d(String.format(" filter beancurd is = %b", new Object[] { Boolean.valueOf(paramBoolean) }));
    return paramBoolean;
  }
  
  public int b(int paramInt)
  {
    return ((Integer)this.e.get(paramInt, Integer.valueOf(100000))).intValue();
  }
  
  public long b(String paramString)
  {
    d(String.format(" blockBeancurdForQZone ", new Object[0]));
    long l1 = SystemClock.uptimeMillis() + 5000L;
    this.g.put(paramString, Long.valueOf(l1));
    return l1;
  }
  
  public BeancurdMsg b(String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (Map)this.f.get(paramString);
      if (paramString != null) {
        return (BeancurdMsg)paramString.get(Integer.valueOf(paramInt2));
      }
    }
    return null;
  }
  
  public void c(String paramString)
  {
    int n = 1;
    d(String.format(" onDelFriend = %s", new Object[] { paramString }));
    while (n <= 14)
    {
      c(paramString, 0, n);
      n += 1;
    }
  }
  
  public void c(String paramString, int paramInt1, int paramInt2)
  {
    Map localMap = (Map)this.f.get(paramString);
    if (localMap != null)
    {
      BeancurdMsg localBeancurdMsg = (BeancurdMsg)localMap.get(Integer.valueOf(paramInt2));
      if (localBeancurdMsg != null)
      {
        localMap.remove(Integer.valueOf(paramInt2));
        this.f.put(paramString, localMap);
        this.d.getEntityManagerFactory().createEntityManager().remove(localBeancurdMsg);
      }
    }
  }
  
  public void onDestroy()
  {
    d(" onDestory...");
    this.j = true;
    this.e.clear();
    this.f.clear();
    this.g.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BeancurdManager
 * JD-Core Version:    0.7.0.1
 */