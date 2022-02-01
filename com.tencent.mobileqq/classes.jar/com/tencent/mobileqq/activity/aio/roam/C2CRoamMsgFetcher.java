package com.tencent.mobileqq.activity.aio.roam;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.IRoamMsgFetcher;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.MessageRoamManager.MessageRoamListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache;
import com.tencent.mobileqq.app.utils.MessageRoamHandler;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RoamDate;
import com.tencent.mobileqq.data.RoamMessagePreloadInfo;
import com.tencent.mobileqq.equipmentlock.EquipmentLockImpl;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.manager.AccountManager;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class C2CRoamMsgFetcher
  implements IRoamMsgFetcher, MessageRoamManager.MessageRoamListener
{
  boolean a;
  Calendar b;
  private QQAppInterface c;
  private Activity d;
  private MessageRoamManager e;
  private String f;
  private boolean g;
  private boolean h;
  private boolean i = false;
  private boolean j;
  private boolean k;
  private List<ChatMessage> l;
  private final C2CRoamMsgFetcher.Signal m = new C2CRoamMsgFetcher.Signal(null);
  private final C2CRoamMsgFetcher.Signal n = new C2CRoamMsgFetcher.Signal(null);
  private SVIPObserver o = new C2CRoamMsgFetcher.1(this);
  private final C2CRoamMsgFetcher.Signal p = new C2CRoamMsgFetcher.Signal(null);
  private boolean q;
  private final C2CRoamMsgFetcher.Signal r = new C2CRoamMsgFetcher.Signal(null);
  private final C2CRoamMsgFetcher.Signal s = new C2CRoamMsgFetcher.Signal(null);
  private final C2CRoamMsgFetcher.Signal t = new C2CRoamMsgFetcher.Signal(null);
  
  public C2CRoamMsgFetcher(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    this.c = paramQQAppInterface;
    this.d = paramActivity;
    this.f = paramString;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (MessageRoamManager)paramQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (((!paramQQAppInterface.l()) || (paramQQAppInterface.s() != 3)) && ((!paramQQAppInterface.k()) || (paramQQAppInterface.s() != 2)))
    {
      if (paramQQAppInterface.k())
      {
        if (paramQQAppInterface.s() == 0) {
          return;
        }
        if (paramQQAppInterface.s() == 1) {
          return;
        }
      }
      if (paramQQAppInterface.s() == 4) {
        return;
      }
      if ((this.i) && (paramQQAppInterface.s() == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CMsgRoamProxy", 2, "query failed, continue");
        }
        paramQQAppInterface.q();
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, int paramInt)
  {
    if ((paramMessageRecord != null) && (paramInt == 2))
    {
      b(3);
      return;
    }
    b(0);
  }
  
  private void a(Calendar paramCalendar)
  {
    this.e.a(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5));
    this.b = this.e.e();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i2 = this.e.z();
    boolean bool = this.e.B();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.e.H();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mode: ");
      ((StringBuilder)localObject2).append(i2);
      ((StringBuilder)localObject2).append(", isSetPasswd: ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", refreshTimeLine: ");
      ((StringBuilder)localObject2).append(paramBoolean3);
      ((StringBuilder)localObject2).append(", devSetup: ");
      ((StringBuilder)localObject2).append(paramBoolean1);
      ((StringBuilder)localObject2).append(", allowSet: ");
      ((StringBuilder)localObject2).append(paramBoolean2);
      ((StringBuilder)localObject2).append(", da2 length: ");
      int i1;
      if (localObject1 == null) {
        i1 = 0;
      } else {
        i1 = localObject1.length;
      }
      ((StringBuilder)localObject2).append(i1);
      QLog.d("C2CMsgRoamProxy", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.c;
    if (localObject1 == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "checkDevAuthSync after destroy");
      return;
    }
    if (i2 == 1)
    {
      if (paramBoolean1)
      {
        if (this.e.H() != null)
        {
          this.q = true;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("C2CMsgRoamProxy", 2, "devlock is open but no da2 ticket， refresh da2...");
        }
        localObject2 = (AccountManager)((QQAppInterface)localObject1).getManager(0);
        if (localObject2 != null)
        {
          this.t.a();
          ((AccountManager)localObject2).refreshDA2(((QQAppInterface)localObject1).getCurrentAccountUin(), new C2CRoamMsgFetcher.3(this));
          this.t.a(30000L);
          return;
        }
        this.q = false;
      }
    }
    else {
      this.q = false;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, Object paramObject)
  {
    paramObject = (List)paramObject;
    paramQQAppInterface = (MessageRoamManager)paramQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if ((paramObject != null) && (paramObject.size() != 0))
    {
      paramQQAppInterface.s();
      this.i = false;
    }
    else
    {
      if (((paramQQAppInterface.l()) && (paramQQAppInterface.s() == 3)) || ((paramQQAppInterface.k()) && (paramQQAppInterface.s() == 2)) || ((paramQQAppInterface.k()) && ((paramQQAppInterface.s() == 0) || (paramQQAppInterface.s() == 1)))) {
        return true;
      }
      if (paramQQAppInterface.s() != 4)
      {
        if (this.i)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CMsgRoamProxy", 2, "query success, continue");
          }
          paramQQAppInterface.q();
          return false;
        }
        return true;
      }
    }
    paramQQAppInterface.r();
    this.l = paramObject;
    return true;
  }
  
  private void b(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    RoamDate localRoamDate = this.e.b().a(this.f, localCalendar.get(1), localCalendar.get(2) + 1);
    if (localRoamDate != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("C2CMsgRoamProxy", 2, "update today's roam date");
      }
      localRoamDate.setLocState(localCalendar.get(5) - 1, paramInt);
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "getRoamMessageTimeLineSync");
    }
    this.a = false;
    this.e.c(true);
    long l1 = SystemClock.uptimeMillis();
    this.n.a();
    this.e.a(paramBoolean);
    this.n.a(30000L);
    b(3);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRoamMessageTimeLineSync cost: ");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append(", result: ");
      localStringBuilder.append(this.a);
      QLog.d("C2CMsgRoamProxy", 2, localStringBuilder.toString());
    }
    this.e.p();
    this.e.c(this.a);
  }
  
  private void c(int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt1)
    {
    default: 
      break;
    case 18: 
      this.a = true;
      break;
    case 17: 
      this.a = false;
      break;
    case 16: 
      if (paramInt2 != -1)
      {
        paramObject = this.d;
        QQToast.makeText(paramObject, paramObject.getString(2131890032), 0).show();
      }
      this.a = false;
    }
    this.h = true;
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, new Object[] { "handleTimeLineRsp msg:", Integer.valueOf(paramInt1) });
    }
    this.n.c();
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "checkDevStatusSync");
    }
    QQAppInterface localQQAppInterface = this.c;
    if (localQQAppInterface == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "checkDevStatusOnlySync after destroy");
      return;
    }
    if (this.e.H() != null)
    {
      a(true, true, paramBoolean);
      return;
    }
    long l1 = System.currentTimeMillis();
    this.s.a();
    int[] arrayOfInt = new int[1];
    DevlockInfo[] arrayOfDevlockInfo = new DevlockInfo[1];
    EquipmentLockImpl.a().a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), new C2CRoamMsgFetcher.2(this, l1, arrayOfInt, arrayOfDevlockInfo));
    this.s.a(30000L);
    boolean bool2 = false;
    if ((arrayOfInt[0] == 0) && (arrayOfDevlockInfo[0] != null))
    {
      boolean bool1;
      if (arrayOfDevlockInfo[0].DevSetup == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (arrayOfDevlockInfo[0].AllowSet == 1) {
        bool2 = true;
      }
      a(bool1, bool2, paramBoolean);
      return;
    }
    this.q = false;
  }
  
  private void d(int paramInt1, int paramInt2, Object paramObject) {}
  
  private void e()
  {
    try
    {
      if (!this.j)
      {
        this.e.b(hashCode());
        this.e.a(this);
        this.j = true;
      }
      return;
    }
    finally {}
  }
  
  private void e(int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleRoamMessageRsp, what: ");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d("C2CMsgRoamProxy", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.c;
    if (localObject1 == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "handleRoamMessageRsp after destroy");
      this.m.c();
      return;
    }
    localObject1 = (MessageRoamManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    Object localObject2;
    if (paramObject != null)
    {
      localObject2 = Calendar.getInstance();
      paramObject = (Long)paramObject;
      int i1;
      if (paramInt2 == 1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      ((Calendar)localObject2).setTimeInMillis(paramObject.longValue() * 1000L);
      if (i1 == 0) {
        ((MessageRoamManager)localObject1).a((Calendar)localObject2, false);
      }
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2) {
          return;
        }
        ((MessageRoamManager)localObject1).n();
        return;
      }
      if (paramInt2 != -1)
      {
        paramObject = ((MessageRoamManager)localObject1).e();
        if (paramObject != null)
        {
          localObject2 = this.d;
          QQToast.makeText((Context)localObject2, ((Activity)localObject2).getString(2131890034, new Object[] { Integer.valueOf(paramObject.get(2) + 1), Integer.valueOf(paramObject.get(5)) }), 0).show();
        }
      }
      ((MessageRoamManager)localObject1).n();
      return;
    }
    QLog.e("C2CMsgRoamProxy", 2, new Exception("handleRoamMessageRsp"), new Object[0]);
    ((MessageRoamManager)localObject1).n();
  }
  
  private void f()
  {
    if (this.e.D()) {
      return;
    }
    Object localObject = this.c;
    if (localObject == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "syncRoamType after destroy");
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    ((BaseActivity)this.d).addObserver(this.o);
    IApolloExtensionHandler localIApolloExtensionHandler = (IApolloExtensionHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    this.p.a();
    localIApolloExtensionHandler.a(new String[] { ((QQAppInterface)localObject).getCurrentAccountUin() }, new int[] { 42255 });
    this.p.b();
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("syncRoamType cost: ");
      ((StringBuilder)localObject).append(l2 - l1);
      QLog.d("C2CMsgRoamProxy", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean g()
  {
    return this.a;
  }
  
  private boolean h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "getAuthModeSync");
    }
    Object localObject = this.c;
    if (localObject == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "getAuthModeSync after destroy");
      return false;
    }
    localObject = (MessageRoamHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.GET_ROAMMESSAGE_HANDLER);
    if (localObject != null)
    {
      long l1 = SystemClock.uptimeMillis();
      this.r.a();
      ((MessageRoamHandler)localObject).a();
      this.r.a(30000L);
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getAuthModeSync cost: ");
        ((StringBuilder)localObject).append(l2 - l1);
        QLog.d("C2CMsgRoamProxy", 2, ((StringBuilder)localObject).toString());
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "hasGetAuthMode false hanlder is null");
    }
    return false;
  }
  
  private Calendar i()
  {
    return this.e.e();
  }
  
  int a(String paramString, int paramInt, ArrayList<MessageRecord> paramArrayList)
  {
    QQAppInterface localQQAppInterface = this.c;
    if (localQQAppInterface == null)
    {
      QLog.w("C2CMsgRoamProxy", 1, "canGetRoamMsg app is null");
      return 0;
    }
    if (localQQAppInterface.getMsgCache().X(paramString))
    {
      if (localQQAppInterface.getMessageProxy(paramInt).h(paramString, paramInt) + paramArrayList.size() < 15)
      {
        QLog.d("C2CMsgRoamProxy", 1, "can't get roam msg");
        return 0;
      }
      localQQAppInterface.getMsgCache().W(paramString);
      return 1;
    }
    return 2;
  }
  
  @Nullable
  List<ChatMessage> a(int paramInt)
  {
    long l1;
    if (QLog.isColorLevel())
    {
      localObject = this.e.e();
      if (localObject == null) {
        l1 = 0L;
      } else {
        l1 = ((Calendar)localObject).getTimeInMillis();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getHistorySync, current date: ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", type: ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("C2CMsgRoamProxy", 2, ((StringBuilder)localObject).toString());
    }
    e();
    this.i = true;
    this.l = null;
    if (this.k)
    {
      QLog.w("C2CMsgRoamProxy", 1, "get roam msg canceled");
      return null;
    }
    if (this.e.e() == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("current page date is null, show roam flag: ");
      ((StringBuilder)localObject).append(this.e.w());
      QLog.e("C2CMsgRoamProxy", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    Object localObject = this.e.f(paramInt);
    if ((localObject != null) && (((RoamMessagePreloadInfo)localObject).curday != null))
    {
      l1 = SystemClock.uptimeMillis();
      this.m.a();
      this.e.a(((RoamMessagePreloadInfo)localObject).curday, null, false, false);
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, "getHistorySig wait");
      }
      this.m.a(30000L);
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getHistorySync cost: ");
        ((StringBuilder)localObject).append(l2 - l1);
        QLog.d("C2CMsgRoamProxy", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.w("C2CMsgRoamProxy", 2, "preload info is null");
    }
    this.b = this.e.e();
    return this.l;
  }
  
  @Nullable
  List<ChatMessage> a(List<MessageRecord> paramList, long paramLong, MessageRecord paramMessageRecord)
  {
    Object localObject1 = a(1);
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator1.next();
      Iterator localIterator2 = ((List)localObject1).iterator();
      while (localIterator2.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator2.next();
        if (MsgProxyUtils.a(localMessageRecord, localChatMessage, true)) {
          ((ArrayList)localObject2).add(localChatMessage);
        }
      }
    }
    ((List)localObject1).removeAll((Collection)localObject2);
    if ((((List)localObject1).size() > 0) && (paramMessageRecord != null) && (UniteGrayTipMsgUtil.b(paramMessageRecord)) && (((ChatMessage)((List)localObject1).get(0)).time >= paramMessageRecord.time))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("roam msg is later than top revoke msg. revoke msg time: ");
        ((StringBuilder)localObject2).append(paramMessageRecord.time);
        ((StringBuilder)localObject2).append(", top msg time: ");
        ((StringBuilder)localObject2).append(((ChatMessage)((List)localObject1).get(0)).time);
        QLog.d("C2CMsgRoamProxy", 2, ((StringBuilder)localObject2).toString());
      }
      try
      {
        Thread.sleep(200L);
      }
      catch (InterruptedException localInterruptedException2)
      {
        localInterruptedException2.printStackTrace();
      }
      localObject1 = new ArrayList((Collection)localObject1);
      paramList = a(paramList, paramLong, paramMessageRecord);
      if (paramList != null) {
        ((List)localObject1).addAll(0, paramList);
      }
      return localObject1;
    }
    if ((((List)localObject1).size() != 0) && ((paramLong == 0L) || (((ChatMessage)((List)localObject1).get(0)).time < paramLong)) && ((paramLong != 0L) || (paramMessageRecord == null) || (((ChatMessage)((List)localObject1).get(0)).time < paramMessageRecord.time))) {
      return localObject1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get duplicate msg, try again. break time: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", top msg time: ");
      if (((List)localObject1).size() == 0) {
        localObject1 = "";
      } else {
        localObject1 = Long.valueOf(((ChatMessage)((List)localObject1).get(0)).time);
      }
      localStringBuilder.append(localObject1);
      QLog.d("C2CMsgRoamProxy", 2, localStringBuilder.toString());
    }
    try
    {
      Thread.sleep(200L);
    }
    catch (InterruptedException localInterruptedException1)
    {
      QLog.e("C2CMsgRoamProxy", 1, localInterruptedException1, new Object[0]);
    }
    return a(paramList, paramLong, paramMessageRecord);
  }
  
  public void a()
  {
    MessageRoamManager localMessageRoamManager = this.e;
    if (localMessageRoamManager != null)
    {
      localMessageRoamManager.M();
      this.e.c(hashCode());
      this.e.b(this);
      ((BaseActivity)this.d).removeObserver(this.o);
    }
    this.c = null;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleQueryMessageFromDBRsp, what: ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("C2CMsgRoamProxy", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    if (localObject == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "handleQueryMessageFromDBRsp after destroy");
      this.m.c();
      return;
    }
    if (paramInt1 != 22)
    {
      if ((paramInt1 != 23) || (a((QQAppInterface)localObject, paramObject))) {}
    }
    else {
      a((QQAppInterface)localObject);
    }
    if (QLog.isColorLevel())
    {
      paramObject = this.l;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getHistorySig notify, result ");
      if (paramObject == null)
      {
        paramObject = "is null";
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" size: ");
        localStringBuilder.append(paramObject.size());
        paramObject = localStringBuilder.toString();
      }
      ((StringBuilder)localObject).append(paramObject);
      QLog.d("C2CMsgRoamProxy", 2, ((StringBuilder)localObject).toString());
    }
    this.m.c();
  }
  
  public void a(MessageRoamManager.MessageRoamListener paramMessageRoamListener)
  {
    try
    {
      this.k = true;
      this.e.b(this);
      this.e.c(hashCode());
      this.j = false;
      return;
    }
    finally {}
  }
  
  void a(String paramString, int paramInt1, ArrayList<MessageRecord> paramArrayList, int paramInt2, long paramLong, Calendar paramCalendar)
  {
    long l1;
    if (paramArrayList.size() > 0) {
      l1 = ((MessageRecord)paramArrayList.get(0)).time;
    } else {
      l1 = paramLong;
    }
    long l2 = paramCalendar.getTimeInMillis() / 1000L;
    paramCalendar = new StringBuilder();
    paramCalendar.append("query local msg from ");
    paramCalendar.append(l1);
    paramCalendar.append(" to ");
    paramCalendar.append(l2);
    QLog.d("C2CMsgRoamProxy", 1, paramCalendar.toString());
    if ((paramLong >= 0L) && (paramLong > l2))
    {
      paramString = this.c.getMessageProxy(paramInt1).a(paramString, paramInt1, l1, paramInt2, String.format(Locale.getDefault(), "time>=%d", new Object[] { Long.valueOf(l2) }));
      if ((paramString.size() > 0) && (QLog.isColorLevel()))
      {
        paramCalendar = new StringBuilder();
        paramCalendar.append("query local msg size: ");
        paramCalendar.append(paramString.size());
        paramCalendar.append(", first msg: ");
        paramCalendar.append(((MessageRecord)paramString.get(0)).toString());
        QLog.d("C2CMsgRoamProxy", 2, paramCalendar.toString());
      }
      paramArrayList.addAll(0, paramString);
      return;
    }
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject1 = this.c;
    if ((!this.g) || (paramBoolean)) {
      try
      {
        if ((!this.g) || (paramBoolean))
        {
          if (localObject1 == null)
          {
            QLog.d("C2CMsgRoamProxy", 1, "init after destroy");
            return;
          }
          this.e = ((MessageRoamManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER));
          this.e.a(this.f, false);
          localObject1 = Calendar.getInstance();
          ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
          this.e.a(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2), ((Calendar)localObject1).get(5));
          this.b = this.e.e();
          this.g = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public boolean a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord, long paramLong)
  {
    int i1 = a(paramString, paramInt1, paramArrayList);
    if (i1 == 0) {
      return true;
    }
    this.k = false;
    int i2 = paramArrayList.size();
    long l1;
    if (paramMessageRecord == null) {
      l1 = NetConnInfoCenter.getServerTime();
    } else {
      l1 = paramMessageRecord.time;
    }
    if (paramMessageRecord != null)
    {
      paramRefreshMessageContext = this.e;
      if ((paramRefreshMessageContext == null) || (!paramRefreshMessageContext.w()) || (this.e.e() != null))
      {
        bool = false;
        break label95;
      }
    }
    boolean bool = true;
    label95:
    a(bool);
    c();
    if (!this.e.C())
    {
      QLog.i("C2CMsgRoamProxy", 1, "not open roam");
      return false;
    }
    a(paramMessageRecord, i1);
    this.e.c(true);
    if (i() == null)
    {
      QLog.w("C2CMsgRoamProxy", 1, "current page date is null, init again");
      paramRefreshMessageContext = this.e.h;
      a(true);
      if (paramRefreshMessageContext != null) {
        a(paramRefreshMessageContext);
      } else {
        QLog.d("C2CMsgRoamProxy", 1, "last query date is null");
      }
    }
    bool = d();
    if (this.c == null)
    {
      QLog.w("C2CMsgRoamProxy", 1, "getRoamMsg app is null");
      return true;
    }
    paramRefreshMessageContext = i();
    if (paramRefreshMessageContext == null)
    {
      QLog.w("C2CMsgRoamProxy", 1, "last synced date is null");
      return true;
    }
    if ((paramMessageRecord != null) && (i1 == 2)) {
      a(paramString, paramInt1, paramArrayList, paramInt2 - i2, l1, paramRefreshMessageContext);
    }
    if ((!bool) && (paramArrayList.size() < paramInt2))
    {
      if (!b())
      {
        QLog.d("C2CMsgRoamProxy", 1, "check auth failed");
        return false;
      }
      if (g())
      {
        paramString = a(paramArrayList, paramLong, paramMessageRecord);
        if (paramString != null)
        {
          if (QLog.isColorLevel())
          {
            paramRefreshMessageContext = new StringBuilder();
            paramRefreshMessageContext.append("get roam msg size: ");
            paramRefreshMessageContext.append(paramString.size());
            QLog.d("C2CMsgRoamProxy", 2, paramRefreshMessageContext.toString());
            if (paramString.size() > 0)
            {
              paramRefreshMessageContext = new StringBuilder();
              paramRefreshMessageContext.append("first roam msg: ");
              paramRefreshMessageContext.append(((ChatMessage)paramString.get(0)).toString());
              QLog.d("C2CMsgRoamProxy", 2, paramRefreshMessageContext.toString());
            }
          }
          paramArrayList.addAll(0, paramString);
          return true;
        }
        QLog.d("C2CMsgRoamProxy", 1, "no more roam msg");
        return true;
      }
      QLog.d("C2CMsgRoamProxy", 1, "get timeline failed");
      return false;
    }
    return true;
  }
  
  public void b(int paramInt1, int paramInt2, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHandleMsg: ");
      localStringBuilder.append(paramInt1);
      QLog.d("C2CMsgRoamProxy", 2, localStringBuilder.toString());
    }
    if ((paramInt1 != 0) && (paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 != 4))
    {
      if (paramInt1 != 34)
      {
        switch (paramInt1)
        {
        default: 
          return;
        case 24: 
        case 25: 
          d(paramInt1, paramInt2, paramObject);
          return;
        case 22: 
        case 23: 
          a(paramInt1, paramInt2, paramObject);
          return;
        }
        c(paramInt1, paramInt2, paramObject);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, "handle_get_roam_msg_auth_mode notify");
      }
      this.r.c();
      return;
    }
    e(paramInt1, paramInt2, paramObject);
  }
  
  boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "isDevOpened");
    }
    long l1 = SystemClock.uptimeMillis();
    boolean bool1 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    f();
    boolean bool2 = this.e.C();
    if (bool1)
    {
      if (!bool2) {
        return false;
      }
      if (!this.e.A())
      {
        h();
        if (this.e.A()) {
          c(false);
        } else {
          this.q = false;
        }
      }
      else
      {
        c(false);
      }
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isDevOpened cost: ");
        localStringBuilder.append(l2 - l1);
        localStringBuilder.append(", ret: ");
        localStringBuilder.append(this.q);
        QLog.d("C2CMsgRoamProxy", 2, localStringBuilder.toString());
      }
      return this.q;
    }
    return false;
  }
  
  boolean c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "startQueryTimeLineSync");
    }
    if (this.h) {
      return this.a;
    }
    e();
    long l1 = SystemClock.uptimeMillis();
    boolean bool1 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    f();
    boolean bool2 = this.e.C();
    if (bool1)
    {
      if (!bool2) {
        return false;
      }
      b(false);
      long l2 = SystemClock.uptimeMillis();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startQueryTimeLineSync cost: ");
        localStringBuilder.append(l2 - l1);
        QLog.d("C2CMsgRoamProxy", 2, localStringBuilder.toString());
      }
      return this.a;
    }
    return false;
  }
  
  boolean d()
  {
    Object localObject2 = this.e.g();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.b;
    }
    if (this.e.f() == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("can not get first page date, roam flag: ");
      ((StringBuilder)localObject1).append(this.e.w());
      QLog.e("C2CMsgRoamProxy", 1, ((StringBuilder)localObject1).toString());
      return true;
    }
    long l1 = this.e.f().getTimeInMillis();
    while (((Calendar)localObject1).getTimeInMillis() >= l1)
    {
      int i1 = ((Calendar)localObject1).get(5);
      localObject2 = this.e.b().a(this.f, ((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2) + 1);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("roam date cache is null: ");
          ((StringBuilder)localObject2).append(((Calendar)localObject1).getTimeInMillis());
          QLog.w("C2CMsgRoamProxy", 2, ((StringBuilder)localObject2).toString());
        }
        ((Calendar)localObject1).set(5, 1);
        ((Calendar)localObject1).add(5, -1);
        a((Calendar)localObject1);
      }
      else
      {
        this.e.a(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2), i1);
        int i3 = i1 - 1;
        int i2 = ((RoamDate)localObject2).getLocState(i3);
        i3 = ((RoamDate)localObject2).getSerState(i3);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ser: ");
          ((StringBuilder)localObject2).append(i3);
          ((StringBuilder)localObject2).append(", local: ");
          ((StringBuilder)localObject2).append(i2);
          ((StringBuilder)localObject2).append(", day: ");
          ((StringBuilder)localObject2).append(i1);
          QLog.d("C2CMsgRoamProxy", 2, ((StringBuilder)localObject2).toString());
        }
        if ((i3 == 2) && ((i2 == 1) || (i2 == 2) || (i2 == 0)))
        {
          ((Calendar)localObject1).add(5, 1);
          this.e.a(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2), ((Calendar)localObject1).get(5));
          this.b = this.e.e();
          return false;
        }
        ((Calendar)localObject1).add(5, -1);
      }
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.roam.C2CRoamMsgFetcher
 * JD-Core Version:    0.7.0.1
 */