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
  private Activity jdField_a_of_type_AndroidAppActivity;
  private final C2CRoamMsgFetcher.Signal jdField_a_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal = new C2CRoamMsgFetcher.Signal(null);
  private MessageRoamManager jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SVIPObserver jdField_a_of_type_ComTencentMobileqqAppSVIPObserver = new C2CRoamMsgFetcher.1(this);
  private String jdField_a_of_type_JavaLangString;
  Calendar jdField_a_of_type_JavaUtilCalendar;
  private List<ChatMessage> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  private final C2CRoamMsgFetcher.Signal jdField_b_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal = new C2CRoamMsgFetcher.Signal(null);
  private boolean jdField_b_of_type_Boolean;
  private final C2CRoamMsgFetcher.Signal jdField_c_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal = new C2CRoamMsgFetcher.Signal(null);
  private boolean jdField_c_of_type_Boolean;
  private final C2CRoamMsgFetcher.Signal jdField_d_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal = new C2CRoamMsgFetcher.Signal(null);
  private boolean jdField_d_of_type_Boolean = false;
  private final C2CRoamMsgFetcher.Signal jdField_e_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal = new C2CRoamMsgFetcher.Signal(null);
  private boolean jdField_e_of_type_Boolean;
  private final C2CRoamMsgFetcher.Signal jdField_f_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal = new C2CRoamMsgFetcher.Signal(null);
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  
  public C2CRoamMsgFetcher(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private Calendar a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a();
  }
  
  private void a(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    RoamDate localRoamDate = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a().a(this.jdField_a_of_type_JavaLangString, localCalendar.get(1), localCalendar.get(2) + 1);
    if (localRoamDate != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("C2CMsgRoamProxy", 2, "update today's roam date");
      }
      localRoamDate.setLocState(localCalendar.get(5) - 1, paramInt);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (MessageRoamManager)paramQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (((!paramQQAppInterface.d()) || (paramQQAppInterface.a() != 3)) && ((!paramQQAppInterface.c()) || (paramQQAppInterface.a() != 2)))
    {
      if (paramQQAppInterface.c())
      {
        if (paramQQAppInterface.a() == 0) {
          return;
        }
        if (paramQQAppInterface.a() == 1) {
          return;
        }
      }
      if (paramQQAppInterface.a() == 4) {
        return;
      }
      if ((this.jdField_d_of_type_Boolean) && (paramQQAppInterface.a() == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CMsgRoamProxy", 2, "query failed, continue");
        }
        paramQQAppInterface.g();
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, int paramInt)
  {
    if ((paramMessageRecord != null) && (paramInt == 2))
    {
      a(3);
      return;
    }
    a(0);
  }
  
  private void a(Calendar paramCalendar)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5));
    this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.g();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mode: ");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(", isSetPasswd: ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", refreshTimeLine: ");
      ((StringBuilder)localObject2).append(paramBoolean3);
      ((StringBuilder)localObject2).append(", devSetup: ");
      ((StringBuilder)localObject2).append(paramBoolean1);
      ((StringBuilder)localObject2).append(", allowSet: ");
      ((StringBuilder)localObject2).append(paramBoolean2);
      ((StringBuilder)localObject2).append(", da2 length: ");
      int i;
      if (localObject1 == null) {
        i = 0;
      } else {
        i = localObject1.length;
      }
      ((StringBuilder)localObject2).append(i);
      QLog.d("C2CMsgRoamProxy", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "checkDevAuthSync after destroy");
      return;
    }
    if (j == 1)
    {
      if (paramBoolean1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b() != null)
        {
          this.g = true;
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("C2CMsgRoamProxy", 2, "devlock is open but no da2 ticket， refresh da2...");
        }
        localObject2 = (AccountManager)((QQAppInterface)localObject1).getManager(0);
        if (localObject2 != null)
        {
          this.jdField_f_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.a();
          ((AccountManager)localObject2).refreshDA2(((QQAppInterface)localObject1).getCurrentAccountUin(), new C2CRoamMsgFetcher.3(this));
          this.jdField_f_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.a(30000L);
          return;
        }
        this.g = false;
      }
    }
    else {
      this.g = false;
    }
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, Object paramObject)
  {
    paramObject = (List)paramObject;
    paramQQAppInterface = (MessageRoamManager)paramQQAppInterface.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if ((paramObject != null) && (paramObject.size() != 0))
    {
      paramQQAppInterface.a();
      this.jdField_d_of_type_Boolean = false;
    }
    else
    {
      if (((paramQQAppInterface.d()) && (paramQQAppInterface.a() == 3)) || ((paramQQAppInterface.c()) && (paramQQAppInterface.a() == 2)) || ((paramQQAppInterface.c()) && ((paramQQAppInterface.a() == 0) || (paramQQAppInterface.a() == 1)))) {
        return true;
      }
      if (paramQQAppInterface.a() != 4)
      {
        if (this.jdField_d_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("C2CMsgRoamProxy", 2, "query success, continue");
          }
          paramQQAppInterface.g();
          return false;
        }
        return true;
      }
    }
    paramQQAppInterface.h();
    this.jdField_a_of_type_JavaUtilList = paramObject;
    return true;
  }
  
  private void b()
  {
    try
    {
      if (!this.jdField_e_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b(hashCode());
        this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(this);
        this.jdField_e_of_type_Boolean = true;
      }
      return;
    }
    finally {}
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "getRoamMessageTimeLineSync");
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c(true);
    long l1 = SystemClock.uptimeMillis();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.a();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(paramBoolean);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.a(30000L);
    a(3);
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRoamMessageTimeLineSync cost: ");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append(", result: ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("C2CMsgRoamProxy", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.f();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c(this.jdField_a_of_type_Boolean);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.i()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "syncRoamType after destroy");
      return;
    }
    long l1 = SystemClock.uptimeMillis();
    ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    IApolloExtensionHandler localIApolloExtensionHandler = (IApolloExtensionHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    this.jdField_c_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.a();
    localIApolloExtensionHandler.a(new String[] { ((QQAppInterface)localObject).getCurrentAccountUin() }, new int[] { 42255 });
    this.jdField_c_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.a();
    long l2 = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("syncRoamType cost: ");
      ((StringBuilder)localObject).append(l2 - l1);
      QLog.d("C2CMsgRoamProxy", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void c(int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt1)
    {
    default: 
      break;
    case 18: 
      this.jdField_a_of_type_Boolean = true;
      break;
    case 17: 
      this.jdField_a_of_type_Boolean = false;
      break;
    case 16: 
      if (paramInt2 != -1)
      {
        paramObject = this.jdField_a_of_type_AndroidAppActivity;
        QQToast.a(paramObject, paramObject.getString(2131692921), 0).a();
      }
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, new Object[] { "handleTimeLineRsp msg:", Integer.valueOf(paramInt1) });
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.b();
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "checkDevStatusSync");
    }
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "checkDevStatusOnlySync after destroy");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b() != null)
    {
      a(true, true, paramBoolean);
      return;
    }
    long l = System.currentTimeMillis();
    this.jdField_e_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.a();
    int[] arrayOfInt = new int[1];
    DevlockInfo[] arrayOfDevlockInfo = new DevlockInfo[1];
    EquipmentLockImpl.a().a(localQQAppInterface, localQQAppInterface.getCurrentAccountUin(), new C2CRoamMsgFetcher.2(this, l, arrayOfInt, arrayOfDevlockInfo));
    this.jdField_e_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.a(30000L);
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
    this.g = false;
  }
  
  private void d(int paramInt1, int paramInt2, Object paramObject) {}
  
  private boolean d()
  {
    return this.jdField_a_of_type_Boolean;
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "handleRoamMessageRsp after destroy");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.b();
      return;
    }
    localObject1 = (MessageRoamManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    Object localObject2;
    if (paramObject != null)
    {
      localObject2 = Calendar.getInstance();
      paramObject = (Long)paramObject;
      int i;
      if (paramInt2 == 1) {
        i = 1;
      } else {
        i = 0;
      }
      ((Calendar)localObject2).setTimeInMillis(paramObject.longValue() * 1000L);
      if (i == 0) {
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
        ((MessageRoamManager)localObject1).e();
        return;
      }
      if (paramInt2 != -1)
      {
        paramObject = ((MessageRoamManager)localObject1).a();
        if (paramObject != null)
        {
          localObject2 = this.jdField_a_of_type_AndroidAppActivity;
          QQToast.a((Context)localObject2, ((Activity)localObject2).getString(2131692923, new Object[] { Integer.valueOf(paramObject.get(2) + 1), Integer.valueOf(paramObject.get(5)) }), 0).a();
        }
      }
      ((MessageRoamManager)localObject1).e();
      return;
    }
    QLog.e("C2CMsgRoamProxy", 2, new Exception("handleRoamMessageRsp"), new Object[0]);
    ((MessageRoamManager)localObject1).e();
  }
  
  private boolean e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "getAuthModeSync");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "getAuthModeSync after destroy");
      return false;
    }
    localObject = (MessageRoamHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.GET_ROAMMESSAGE_HANDLER);
    if (localObject != null)
    {
      long l1 = SystemClock.uptimeMillis();
      this.jdField_d_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.a();
      ((MessageRoamHandler)localObject).a();
      this.jdField_d_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.a(30000L);
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
  
  int a(String paramString, int paramInt, ArrayList<MessageRecord> paramArrayList)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface == null)
    {
      QLog.w("C2CMsgRoamProxy", 1, "canGetRoamMsg app is null");
      return 0;
    }
    if (localQQAppInterface.getMsgCache().a(paramString))
    {
      if (localQQAppInterface.getMessageProxy(paramInt).a(paramString, paramInt) + paramArrayList.size() < 15)
      {
        QLog.d("C2CMsgRoamProxy", 1, "can't get roam msg");
        return 0;
      }
      localQQAppInterface.getMsgCache().j(paramString);
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
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a();
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
    b();
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = null;
    if (this.jdField_f_of_type_Boolean)
    {
      QLog.w("C2CMsgRoamProxy", 1, "get roam msg canceled");
      return null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a() == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("current page date is null, show roam flag: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.e());
      QLog.e("C2CMsgRoamProxy", 1, ((StringBuilder)localObject).toString());
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(paramInt);
    if ((localObject != null) && (((RoamMessagePreloadInfo)localObject).curday != null))
    {
      l1 = SystemClock.uptimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.a();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(((RoamMessagePreloadInfo)localObject).curday, null, false, false);
      if (QLog.isColorLevel()) {
        QLog.d("C2CMsgRoamProxy", 2, "getHistorySig wait");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.a(30000L);
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
    this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a();
    return this.jdField_a_of_type_JavaUtilList;
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
    if ((((List)localObject1).size() > 0) && (paramMessageRecord != null) && (UniteGrayTipMsgUtil.a(paramMessageRecord)) && (((ChatMessage)((List)localObject1).get(0)).time >= paramMessageRecord.time))
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
    MessageRoamManager localMessageRoamManager = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager;
    if (localMessageRoamManager != null)
    {
      localMessageRoamManager.q();
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(hashCode());
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b(this);
      ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSVIPObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null)
    {
      QLog.d("C2CMsgRoamProxy", 1, "handleQueryMessageFromDBRsp after destroy");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.b();
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
      paramObject = this.jdField_a_of_type_JavaUtilList;
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
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.b();
  }
  
  public void a(MessageRoamManager.MessageRoamListener paramMessageRoamListener)
  {
    try
    {
      this.jdField_f_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b(this);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(hashCode());
      this.jdField_e_of_type_Boolean = false;
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
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt1).a(paramString, paramInt1, l1, paramInt2, String.format(Locale.getDefault(), "time>=%d", new Object[] { Long.valueOf(l2) }));
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((!this.jdField_b_of_type_Boolean) || (paramBoolean)) {
      try
      {
        if ((!this.jdField_b_of_type_Boolean) || (paramBoolean))
        {
          if (localObject1 == null)
          {
            QLog.d("C2CMsgRoamProxy", 1, "init after destroy");
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager = ((MessageRoamManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER));
          this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(this.jdField_a_of_type_JavaLangString, false);
          localObject1 = Calendar.getInstance();
          ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
          this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2), ((Calendar)localObject1).get(5));
          this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a();
          this.jdField_b_of_type_Boolean = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "isDevOpened");
    }
    long l1 = SystemClock.uptimeMillis();
    boolean bool1 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    c();
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.h();
    if (bool1)
    {
      if (!bool2) {
        return false;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.f())
      {
        e();
        if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.f()) {
          c(false);
        } else {
          this.g = false;
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
        localStringBuilder.append(this.g);
        QLog.d("C2CMsgRoamProxy", 2, localStringBuilder.toString());
      }
      return this.g;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, RefreshMessageContext paramRefreshMessageContext, ArrayList<MessageRecord> paramArrayList, MessageRecord paramMessageRecord, long paramLong)
  {
    int i = a(paramString, paramInt1, paramArrayList);
    if (i == 0) {
      return true;
    }
    this.jdField_f_of_type_Boolean = false;
    int j = paramArrayList.size();
    long l;
    if (paramMessageRecord == null) {
      l = NetConnInfoCenter.getServerTime();
    } else {
      l = paramMessageRecord.time;
    }
    if (paramMessageRecord != null)
    {
      paramRefreshMessageContext = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager;
      if ((paramRefreshMessageContext == null) || (!paramRefreshMessageContext.e()) || (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a() != null))
      {
        bool = false;
        break label95;
      }
    }
    boolean bool = true;
    label95:
    a(bool);
    b();
    if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.h())
    {
      QLog.i("C2CMsgRoamProxy", 1, "not open roam");
      return false;
    }
    a(paramMessageRecord, i);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c(true);
    if (a() == null)
    {
      QLog.w("C2CMsgRoamProxy", 1, "current page date is null, init again");
      paramRefreshMessageContext = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.d;
      a(true);
      if (paramRefreshMessageContext != null) {
        a(paramRefreshMessageContext);
      } else {
        QLog.d("C2CMsgRoamProxy", 1, "last query date is null");
      }
    }
    bool = c();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.w("C2CMsgRoamProxy", 1, "getRoamMsg app is null");
      return true;
    }
    paramRefreshMessageContext = a();
    if (paramRefreshMessageContext == null)
    {
      QLog.w("C2CMsgRoamProxy", 1, "last synced date is null");
      return true;
    }
    if ((paramMessageRecord != null) && (i == 2)) {
      a(paramString, paramInt1, paramArrayList, paramInt2 - j, l, paramRefreshMessageContext);
    }
    if ((!bool) && (paramArrayList.size() < paramInt2))
    {
      if (!a())
      {
        QLog.d("C2CMsgRoamProxy", 1, "check auth failed");
        return false;
      }
      if (d())
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
      this.jdField_d_of_type_ComTencentMobileqqActivityAioRoamC2CRoamMsgFetcher$Signal.b();
      return;
    }
    e(paramInt1, paramInt2, paramObject);
  }
  
  boolean b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CMsgRoamProxy", 2, "startQueryTimeLineSync");
    }
    if (this.jdField_c_of_type_Boolean) {
      return this.jdField_a_of_type_Boolean;
    }
    b();
    long l1 = SystemClock.uptimeMillis();
    boolean bool1 = NetworkUtil.isNetSupport(BaseApplication.getContext());
    c();
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.h();
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
      return this.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  boolean c()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.c();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.jdField_a_of_type_JavaUtilCalendar;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b() == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("can not get first page date, roam flag: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.e());
      QLog.e("C2CMsgRoamProxy", 1, ((StringBuilder)localObject1).toString());
      return true;
    }
    long l = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.b().getTimeInMillis();
    while (((Calendar)localObject1).getTimeInMillis() >= l)
    {
      int i = ((Calendar)localObject1).get(5);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a().a(this.jdField_a_of_type_JavaLangString, ((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2) + 1);
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
        this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2), i);
        int k = i - 1;
        int j = ((RoamDate)localObject2).getLocState(k);
        k = ((RoamDate)localObject2).getSerState(k);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ser: ");
          ((StringBuilder)localObject2).append(k);
          ((StringBuilder)localObject2).append(", local: ");
          ((StringBuilder)localObject2).append(j);
          ((StringBuilder)localObject2).append(", day: ");
          ((StringBuilder)localObject2).append(i);
          QLog.d("C2CMsgRoamProxy", 2, ((StringBuilder)localObject2).toString());
        }
        if ((k == 2) && ((j == 1) || (j == 2) || (j == 0)))
        {
          ((Calendar)localObject1).add(5, 1);
          this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2), ((Calendar)localObject1).get(5));
          this.jdField_a_of_type_JavaUtilCalendar = this.jdField_a_of_type_ComTencentMobileqqAppMessageRoamManager.a();
          return false;
        }
        ((Calendar)localObject1).add(5, -1);
      }
    }
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.roam.C2CRoamMsgFetcher
 * JD-Core Version:    0.7.0.1
 */