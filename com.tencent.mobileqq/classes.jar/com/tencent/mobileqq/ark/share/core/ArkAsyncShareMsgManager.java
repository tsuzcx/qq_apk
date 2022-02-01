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
import com.tencent.mobileqq.ark.share.ArkMessagePreprocessorMgr;
import com.tencent.mobileqq.ark.share.IArkMessagePreprocessor;
import com.tencent.mobileqq.ark.share.IArkMessagePreprocessorCallback;
import com.tencent.mobileqq.ark.share.api.IArkAsyncShareMsgService;
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
  private final WeakReference<AppRuntime> a;
  private final HashMap<Long, Bundle> b = new HashMap();
  private HandlerThread c = null;
  private Handler d = null;
  private boolean e = false;
  private long f = 120000L;
  private final Object g = new Object();
  private IArkMessagePreprocessorCallback h = new ArkAsyncShareMsgManager.1(this);
  
  public ArkAsyncShareMsgManager(AppRuntime paramAppRuntime)
  {
    this.a = new WeakReference(paramAppRuntime);
  }
  
  private void a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp)
  {
    if (paramQQAppInterface != null)
    {
      if (paramMessageForArkApp == null) {
        return;
      }
      if (paramMessageForArkApp != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.notifyUpdateMsgUI uniseq=", Long.valueOf(paramMessageForArkApp.uniseq), ", frienduin=", paramMessageForArkApp.frienduin });
        }
        int i = paramMessageForArkApp.getProcessState();
        if (i == 1001)
        {
          paramQQAppInterface.getMsgHandler().notifyUI(6003, true, new String[] { paramMessageForArkApp.frienduin, String.valueOf(paramMessageForArkApp.uniseq) });
          return;
        }
        if (i == 1003)
        {
          Object[] arrayOfObject = new Object[8];
          arrayOfObject[0] = paramMessageForArkApp.frienduin;
          arrayOfObject[1] = Integer.valueOf(paramMessageForArkApp.istroop);
          arrayOfObject[2] = Integer.valueOf(0);
          arrayOfObject[3] = null;
          arrayOfObject[4] = Long.valueOf(a());
          arrayOfObject[5] = Long.valueOf(paramMessageForArkApp.uniseq);
          paramQQAppInterface.getMsgHandler().a(3001, false, arrayOfObject);
        }
      }
    }
  }
  
  public static void d(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp == null)
    {
      QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.updateProcessStateUI return ");
      return;
    }
    if (paramMessageForArkApp.getProcessState() == 1001)
    {
      Object localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject instanceof QQAppInterface))
      {
        localObject = (QQAppInterface)localObject;
        ArkAsyncShareMsgManager localArkAsyncShareMsgManager = ((IArkAsyncShareMsgService)((QQAppInterface)localObject).getRuntimeService(IArkAsyncShareMsgService.class, "")).getAsyncShareMsgManager();
        if ((localArkAsyncShareMsgManager != null) && (!localArkAsyncShareMsgManager.b(paramMessageForArkApp)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.change last sending msg to fail state, uniseq=", Long.valueOf(paramMessageForArkApp.uniseq) });
          }
          paramMessageForArkApp.updateProcessStateAndExtraFlag(1003);
          paramMessageForArkApp.saveMsgExtStrAndFlag((QQAppInterface)localObject);
          localArkAsyncShareMsgManager.a((QQAppInterface)localObject, paramMessageForArkApp);
        }
      }
    }
  }
  
  public long a()
  {
    QLog.d("ArkApp.ArkAsyncShareMsgManager", 1, new Object[] { "AAShare.get timeout=", Long.valueOf(this.f) });
    return this.f;
  }
  
  public void a(MessageForArkApp paramMessageForArkApp)
  {
    if ((paramMessageForArkApp != null) && (paramMessageForArkApp.ark_app_message != null))
    {
      Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
      QQAppInterface localQQAppInterface;
      if ((localObject1 instanceof QQAppInterface))
      {
        localQQAppInterface = (QQAppInterface)localObject1;
        localObject1 = ((IArkAsyncShareMsgService)localQQAppInterface.getRuntimeService(IArkAsyncShareMsgService.class, "")).getMessagePreprocessorMgr();
        if (localObject1 != null) {
          localObject1 = ((ArkMessagePreprocessorMgr)localObject1).a(paramMessageForArkApp.ark_app_message.appName);
        } else {
          localObject1 = null;
        }
      }
      else
      {
        localQQAppInterface = null;
        localObject1 = localQQAppInterface;
      }
      boolean bool1;
      if (localObject1 != null)
      {
        boolean bool2 = ((IArkMessagePreprocessor)localObject1).a(paramMessageForArkApp.ark_app_message.toShareMsgJSONObject());
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.retryAsyncShareArkMsg needProcess=", Boolean.valueOf(bool2), ", uniseq=", Long.valueOf(paramMessageForArkApp.uniseq), paramMessageForArkApp.getBaseInfoString() });
        }
        Object localObject2 = new HashMap();
        ((HashMap)localObject2).put("appid", paramMessageForArkApp.ark_app_message.appName);
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAsyncShareRetry", true, 0L, 0L, (HashMap)localObject2, null);
        bool1 = bool2;
        if (bool2)
        {
          paramMessageForArkApp.updateProcessStateAndExtraFlag(1001);
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShareTEST.retryAsyncShareArkMsg mr.msguid=", Long.valueOf(paramMessageForArkApp.msgUid) });
          }
          a(localQQAppInterface, paramMessageForArkApp);
          localQQAppInterface.getMessageFacade().a(paramMessageForArkApp);
          localObject2 = c(paramMessageForArkApp);
          ((IArkMessagePreprocessor)localObject1).a(paramMessageForArkApp.ark_app_message.toShareMsgJSONObject(), this.h, localObject2);
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = false;
      }
      if ((!bool1) && (localQQAppInterface != null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.failed onclick direct send msg uniseq=", Long.valueOf(paramMessageForArkApp.uniseq) });
        }
        paramMessageForArkApp.updateProcessStateAndExtraFlag(1002);
        paramMessageForArkApp.saveMsgExtStrAndFlag(localQQAppInterface);
        localQQAppInterface.getMessageFacade().a(paramMessageForArkApp, null);
      }
      return;
    }
    QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.retryShare msg is null");
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, String paramString, SessionInfo paramSessionInfo, MessageForArkApp paramMessageForArkApp)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)) && (paramSessionInfo != null) && (paramMessageForArkApp != null))
    {
      IArkMessagePreprocessor localIArkMessagePreprocessor = ((IArkAsyncShareMsgService)paramQQAppInterface.getRuntimeService(IArkAsyncShareMsgService.class, "")).getMessagePreprocessorMgr().a(paramString);
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.shareData curType=", Integer.valueOf(paramSessionInfo.a), ", curFriendUin= ", paramSessionInfo.b, ", troopUin=", paramSessionInfo.c, ", istroop=", Integer.valueOf(paramMessageForArkApp.istroop), ", \n --shareMessage=", paramMessageForArkApp.ark_app_message.toShareMsgJSONObject() });
      }
      if (localIArkMessagePreprocessor != null)
      {
        boolean bool = localIArkMessagePreprocessor.a(paramMessageForArkApp.ark_app_message.toShareMsgJSONObject());
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.sendArkMessage needProcess=", Boolean.valueOf(bool) });
        }
        paramSessionInfo = new HashMap();
        paramSessionInfo.put("appid", paramString);
        if (bool) {
          paramString = "1";
        } else {
          paramString = "2";
        }
        paramSessionInfo.put("isProcess", paramString);
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actAsyncShare", true, 0L, 0L, paramSessionInfo, null);
        if (bool)
        {
          paramMessageForArkApp.updateProcessStateAndExtraFlag(1001);
          paramQQAppInterface.getMessageFacade().a(paramMessageForArkApp);
          paramQQAppInterface = c(paramMessageForArkApp);
          localIArkMessagePreprocessor.a(paramMessageForArkApp.ark_app_message.toShareMsgJSONObject(), this.h, paramQQAppInterface);
          return true;
        }
      }
      return false;
    }
    QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, "AAShare.checkToAsyncShareArkMsg invalid");
    return false;
  }
  
  public boolean b(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp == null) {
      return false;
    }
    for (;;)
    {
      synchronized (this.g)
      {
        if ((Bundle)this.b.get(Long.valueOf(paramMessageForArkApp.uniseq)) != null)
        {
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.isProcessMsg isProcess=", Boolean.valueOf(bool), ", msgid=", Long.valueOf(paramMessageForArkApp.uniseq) });
          }
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public Bundle c(MessageForArkApp paramMessageForArkApp)
  {
    if (paramMessageForArkApp == null) {
      return null;
    }
    synchronized (this.g)
    {
      Bundle localBundle = (Bundle)this.b.get(Long.valueOf(paramMessageForArkApp.uniseq));
      if (localBundle != null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.allready add to timeout check bundle=", localBundle.toString() });
        }
        return localBundle;
      }
      localBundle = new Bundle();
      localBundle.putLong("key_process_message_uniseq", paramMessageForArkApp.uniseq);
      localBundle.putString("key_process_message_friend_uin", paramMessageForArkApp.frienduin);
      localBundle.putInt("key_process_message_uin_type", paramMessageForArkApp.istroop);
      this.b.put(Long.valueOf(paramMessageForArkApp.uniseq), localBundle);
      if (!this.e)
      {
        this.c = new HandlerThread("Ark-Msg-Monitor");
        this.c.start();
        this.d = new Handler(this.c.getLooper(), this);
      }
      paramMessageForArkApp = this.d.obtainMessage(1, localBundle);
      this.d.sendMessageDelayed(paramMessageForArkApp, this.f);
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.--add timeout check bundle=", Integer.valueOf(System.identityHashCode(localBundle)), ", content", localBundle.toString() });
      }
      return localBundle;
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    if (???.what != 1) {
      return true;
    }
    Object localObject2 = (AppRuntime)this.a.get();
    ??? = ???.obj;
    if ((localObject2 != null) && (??? != null) && ((??? instanceof Bundle)))
    {
      Object localObject3 = (Bundle)???;
      long l = ((Bundle)localObject3).getLong("key_process_message_uniseq");
      String str = ((Bundle)localObject3).getString("key_process_message_friend_uin");
      int i = ((Bundle)localObject3).getInt("key_process_message_uin_type");
      synchronized (this.g)
      {
        if (this.b.get(Long.valueOf(l)) != null)
        {
          this.b.remove(Long.valueOf(l));
          if ((localObject2 instanceof QQAppInterface)) {
            ??? = (QQAppInterface)localObject2;
          } else {
            ??? = null;
          }
          if (??? == null)
          {
            QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.--handleMessage should in main process, uniseq=", Long.valueOf(l) });
            return true;
          }
          localObject2 = ???.getMessageFacade().b(str, i, l);
          if (!(localObject2 instanceof MessageForArkApp))
          {
            QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, "AAShare.handleMessage find ArkMsg failed!");
            return true;
          }
          localObject3 = (MessageForArkApp)localObject2;
          if (QLog.isColorLevel()) {
            QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.handleMessage find ArkMsg uniseq=", Long.valueOf(l), ", frienduin=", str, ", type=", Integer.valueOf(i), "\n ------>msgR=", ((MessageRecord)localObject2).getLogColorContent() });
          }
          ((MessageForArkApp)localObject3).updateProcessStateAndExtraFlag(1003);
          ((MessageForArkApp)localObject3).saveMsgExtStrAndFlag(???);
          ???.getMsgCache().b(((MessageForArkApp)localObject3).frienduin, ((MessageForArkApp)localObject3).istroop, ((MessageForArkApp)localObject3).uniseq);
          a(???, (MessageForArkApp)localObject3);
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.ArkAsyncShareMsgManager", 2, new Object[] { "AAShare.--handleMessage return bundle=", Integer.valueOf(System.identityHashCode(localObject3)), ", uniseq=", Long.valueOf(l) });
        }
        return true;
      }
    }
    QLog.e("ArkApp.ArkAsyncShareMsgManager", 1, new Object[] { "AAShare.handleMessage param invalid app=", localObject2, ",userData=", ??? });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager
 * JD-Core Version:    0.7.0.1
 */