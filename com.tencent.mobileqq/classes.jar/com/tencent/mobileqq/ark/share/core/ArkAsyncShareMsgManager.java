package com.tencent.mobileqq.ark.share.core;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.share.ArkMessagePreprocessorMgr;
import com.tencent.mobileqq.ark.share.IArkMessagePreprocessor;
import com.tencent.mobileqq.ark.share.IArkMessagePreprocessorCallback;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class ArkAsyncShareMsgManager
  implements Handler.Callback
{
  private long jdField_a_of_type_Long = 120000L;
  private Handler jdField_a_of_type_AndroidOsHandler = null;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = null;
  private IArkMessagePreprocessorCallback jdField_a_of_type_ComTencentMobileqqArkShareIArkMessagePreprocessorCallback = new ArkAsyncShareMsgManager.1(this);
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<Long, Bundle> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  public ArkAsyncShareMsgManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp)
  {
    if ((paramQQAppInterface == null) || (paramMessageForArkApp == null)) {}
    int i;
    do
    {
      do
      {
        return;
      } while (paramMessageForArkApp == null);
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.notifyUpdateMsgUI uniseq=", Long.valueOf(paramMessageForArkApp.uniseq), ", frienduin=", paramMessageForArkApp.frienduin });
      }
      i = paramMessageForArkApp.getProcessState();
      if (i == 1001)
      {
        paramQQAppInterface.getMsgHandler().notifyUI(6003, true, new String[] { paramMessageForArkApp.frienduin, String.valueOf(paramMessageForArkApp.uniseq) });
        return;
      }
    } while (i != 1003);
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = paramMessageForArkApp.frienduin;
    arrayOfObject[1] = Integer.valueOf(paramMessageForArkApp.istroop);
    arrayOfObject[2] = Integer.valueOf(0);
    arrayOfObject[3] = null;
    arrayOfObject[4] = Long.valueOf(a());
    arrayOfObject[5] = Long.valueOf(paramMessageForArkApp.uniseq);
    paramQQAppInterface.getMsgHandler().a(3001, false, arrayOfObject);
  }
  
  public static void b(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp == null) {
      QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.updateProcessStateUI return ");
    }
    label12:
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          break label12;
          do
          {
            return;
          } while (paramMessageForArkApp.getProcessState() != 1001);
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        } while (!(localObject1 instanceof QQAppInterface));
        localObject1 = (QQAppInterface)localObject1;
        localObject2 = (ArkAppCenter)((QQAppInterface)localObject1).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
      } while (localObject2 == null);
      localObject2 = ((ArkAppCenter)localObject2).a();
    } while ((localObject2 == null) || (((ArkAsyncShareMsgManager)localObject2).a(paramMessageForArkApp)));
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.change last sending msg to fail state, uniseq=", Long.valueOf(paramMessageForArkApp.uniseq) });
    }
    paramMessageForArkApp.updateProcessStateAndExtraFlag(1003);
    paramMessageForArkApp.saveMsgExtStrAndFlag((QQAppInterface)localObject1);
    ((ArkAsyncShareMsgManager)localObject2).a((QQAppInterface)localObject1, paramMessageForArkApp);
  }
  
  public long a()
  {
    QLog.d("ArkApp.ArkAsyncShareMsgManager", 1, new Object[] { "AAShare.get timeout=", Long.valueOf(this.jdField_a_of_type_Long) });
    return this.jdField_a_of_type_Long;
  }
  
  public Bundle a(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp == null) {
      paramMessageForArkApp = null;
    }
    Bundle localBundle;
    do
    {
      return paramMessageForArkApp;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        localBundle = (Bundle)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramMessageForArkApp.uniseq));
        if (localBundle != null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.allready add to timeout check bundle=", localBundle.toString() });
          }
          return localBundle;
        }
      }
      localBundle = new Bundle();
      localBundle.putLong("key_process_message_uniseq", paramMessageForArkApp.uniseq);
      localBundle.putString("key_process_message_friend_uin", paramMessageForArkApp.frienduin);
      localBundle.putInt("key_process_message_uin_type", paramMessageForArkApp.istroop);
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageForArkApp.uniseq), localBundle);
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("Ark-Msg-Monitor");
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      }
      paramMessageForArkApp = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, localBundle);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramMessageForArkApp, this.jdField_a_of_type_Long);
      paramMessageForArkApp = localBundle;
    } while (!QLog.isColorLevel());
    QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.--add timeout check bundle=", Integer.valueOf(System.identityHashCode(localBundle)), ", content", localBundle.toString() });
    return localBundle;
  }
  
  public void a(MessageForArkApp paramMessageForArkApp)
  {
    if ((paramMessageForArkApp == null) || (paramMessageForArkApp.ark_app_message == null))
    {
      QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.retryShare msg is null");
      return;
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
    {
      localQQAppInterface = (QQAppInterface)localObject1;
      localObject1 = (ArkAppCenter)((AppRuntime)localObject1).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
      if (localObject1 != null)
      {
        localObject1 = ((ArkAppCenter)localObject1).a();
        if (localObject1 != null) {
          localObject1 = ((ArkMessagePreprocessorMgr)localObject1).a(paramMessageForArkApp.ark_app_message.appName);
        }
      }
    }
    for (;;)
    {
      boolean bool = false;
      if (localObject1 != null)
      {
        bool = ((IArkMessagePreprocessor)localObject1).needProcess(paramMessageForArkApp.ark_app_message.toShareMsgJSONObject());
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.retryAsyncShareArkMsg needProcess=", Boolean.valueOf(bool), ", uniseq=", Long.valueOf(paramMessageForArkApp.uniseq), paramMessageForArkApp.getBaseInfoString() });
        }
        Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("appid", paramMessageForArkApp.ark_app_message.appName);
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAsyncShareRetry", true, 0L, 0L, (HashMap)localObject2, null);
        if (bool)
        {
          paramMessageForArkApp.updateProcessStateAndExtraFlag(1001);
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShareTEST.retryAsyncShareArkMsg mr.msguid=", Long.valueOf(paramMessageForArkApp.msgUid) });
          }
          a(localQQAppInterface, paramMessageForArkApp);
          localQQAppInterface.getMessageFacade().a(paramMessageForArkApp);
          localObject2 = a(paramMessageForArkApp);
          ((IArkMessagePreprocessor)localObject1).process(paramMessageForArkApp.ark_app_message.toShareMsgJSONObject(), this.jdField_a_of_type_ComTencentMobileqqArkShareIArkMessagePreprocessorCallback, localObject2);
        }
      }
      if ((bool) || (localQQAppInterface == null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.failed onclick direct send msg uniseq=", Long.valueOf(paramMessageForArkApp.uniseq) });
      }
      paramMessageForArkApp.updateProcessStateAndExtraFlag(1002);
      paramMessageForArkApp.saveMsgExtStrAndFlag(localQQAppInterface);
      localQQAppInterface.getMessageFacade().a(paramMessageForArkApp, null);
      return;
      localObject1 = null;
      continue;
      localQQAppInterface = null;
      localObject1 = null;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageForArkApp paramMessageForArkApp)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || (paramSessionInfo == null) || (paramMessageForArkApp == null))
    {
      QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, "AAShare.checkToAsyncShareArkMsg invalid");
      return false;
    }
    Object localObject = (ArkAppCenter)paramQQAppInterface.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
    if (localObject != null)
    {
      localObject = ((ArkAppCenter)localObject).a();
      if (localObject == null) {}
    }
    for (localObject = ((ArkMessagePreprocessorMgr)localObject).a(paramString);; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.shareData curType=", Integer.valueOf(paramSessionInfo.jdField_a_of_type_Int), ", curFriendUin= ", paramSessionInfo.jdField_a_of_type_JavaLangString, ", troopUin=", paramSessionInfo.b, ", istroop=", Integer.valueOf(paramMessageForArkApp.istroop), ", \n --shareMessage=", paramMessageForArkApp.ark_app_message.toShareMsgJSONObject() });
      }
      if (localObject != null)
      {
        boolean bool = ((IArkMessagePreprocessor)localObject).needProcess(paramMessageForArkApp.ark_app_message.toShareMsgJSONObject());
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.sendArkMessage needProcess=", Boolean.valueOf(bool) });
        }
        paramSessionInfo = new HashMap();
        paramSessionInfo.put("appid", paramString);
        if (bool) {}
        for (paramString = "1";; paramString = "2")
        {
          paramSessionInfo.put("isProcess", paramString);
          StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAsyncShare", true, 0L, 0L, paramSessionInfo, null);
          if (!bool) {
            break;
          }
          paramMessageForArkApp.updateProcessStateAndExtraFlag(1001);
          paramQQAppInterface.getMessageFacade().a(paramMessageForArkApp);
          paramQQAppInterface = a(paramMessageForArkApp);
          ((IArkMessagePreprocessor)localObject).process(paramMessageForArkApp.ark_app_message.toShareMsgJSONObject(), this.jdField_a_of_type_ComTencentMobileqqArkShareIArkMessagePreprocessorCallback, paramQQAppInterface);
          return true;
        }
      }
      return false;
    }
  }
  
  public boolean a(MessageForArkApp paramMessageForArkApp)
  {
    boolean bool2;
    if (paramMessageForArkApp == null)
    {
      bool2 = false;
      return bool2;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if ((Bundle)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramMessageForArkApp.uniseq)) != null)
        {
          bool1 = true;
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.isProcessMsg isProcess=", Boolean.valueOf(bool1), ", msgid=", Long.valueOf(paramMessageForArkApp.uniseq) });
          return bool1;
        }
      }
      boolean bool1 = false;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      paramMessage = paramMessage.obj;
      if ((localQQAppInterface == null) || (paramMessage == null) || (!(paramMessage instanceof Bundle)))
      {
        QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, new Object[] { "AAShare.handleMessage param invalid app=", localQQAppInterface, ",userData=", paramMessage });
        return true;
      }
      Object localObject2 = (Bundle)paramMessage;
      long l = ((Bundle)localObject2).getLong("key_process_message_uniseq");
      paramMessage = ((Bundle)localObject2).getString("key_process_message_friend_uin");
      int i = ((Bundle)localObject2).getInt("key_process_message_uin_type");
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(l)) != null)
        {
          this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(l));
          ??? = localQQAppInterface.getMessageFacade().b(paramMessage, i, l);
          if ((??? == null) || (!(??? instanceof MessageForArkApp)))
          {
            QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.handleMessage find ArkMsg failed!");
            return true;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.--handleMessage return bundle=", Integer.valueOf(System.identityHashCode(localObject2)), ", uniseq=", Long.valueOf(l) });
          }
          return true;
        }
      }
      localObject2 = (MessageForArkApp)???;
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.handleMessage find ArkMsg uniseq=", Long.valueOf(l), ", frienduin=", paramMessage, ", type=", Integer.valueOf(i), "\n ------>msgR=", ((MessageRecord)???).getLogColorContent() });
      }
      ((MessageForArkApp)localObject2).updateProcessStateAndExtraFlag(1003);
      ((MessageForArkApp)localObject2).saveMsgExtStrAndFlag(localQQAppInterface);
      localQQAppInterface.getMsgCache().a(((MessageForArkApp)localObject2).frienduin, ((MessageForArkApp)localObject2).istroop, ((MessageForArkApp)localObject2).uniseq);
      a(localQQAppInterface, (MessageForArkApp)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager
 * JD-Core Version:    0.7.0.1
 */