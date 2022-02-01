package com.tencent.mobileqq.apollo.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.apollo.api.IApolloPushManager.OnActionPushListener;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.store.webview.api.IApolloSSOConfigHelper;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4;

public class ApolloPushManagerImpl
  implements IApolloPushManager
{
  private static final int DRAWER_HIRE_PUSH = 2;
  private static final int MSG_SHOW_PLACE_AT_AIO = 1;
  private static final int MSG_SHOW_PLACE_DRAWER = 3;
  private static final int RED_PACK_ACTION_PUSH = 1;
  public static final String TAG = "[cmshow]ApolloPushManager";
  private WeakReference<IApolloPushManager.OnActionPushListener> mActionPushLisRef;
  private QQAppInterface mApp;
  
  private void handleUpdateBaseRes(int paramInt1, int paramInt2, String paramString)
  {
    if (!isNeedPushBySwitch()) {
      return;
    }
    ApolloResManagerFacade.a.c(paramInt1, paramInt2, paramString);
  }
  
  private void handleUpdateDressRes(int paramInt1, int paramInt2, String paramString)
  {
    if (!isNeedPushBySwitch()) {
      return;
    }
    ApolloResManagerFacade.a.a(paramInt1, paramInt2, paramString);
  }
  
  private void handleUpdatePanelJsonCfg(int paramInt1, int paramInt2, String paramString)
  {
    if (!isNeedPushBySwitch()) {
      return;
    }
    ApolloResManagerFacade.a.a(Scene.AIO).d(paramInt1, paramInt2, paramString);
  }
  
  private void handleUpdateRoleRes(int paramInt1, int paramInt2, String paramString)
  {
    if (!isNeedPushBySwitch()) {
      return;
    }
    ApolloResManagerFacade.a.b(paramInt1, paramInt2, paramString);
  }
  
  private void handleUpdateWebView(int paramInt, String paramString)
  {
    if (!"apollo_thunder_json_v670".equals(paramString)) {
      return;
    }
    ((IApolloSSOConfigHelper)QRoute.api(IApolloSSOConfigHelper.class)).checkUpdateApolloWebViewConfig(this.mApp, paramInt, false);
  }
  
  private boolean isNeedPushBySwitch()
  {
    Object localObject = this.mApp;
    if (localObject == null) {
      return false;
    }
    localObject = (IApolloManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
    if ((((IApolloManagerService)localObject).isApolloSupport(this.mApp.getApp())) && (1 == ((IApolloManagerService)localObject).getApolloStatus(this.mApp.getCurrentUin()))) {
      return true;
    }
    QLog.i("[cmshow]ApolloPushManager", 1, "isNeedPushBySwitch false");
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPushManager", 2, "[onDestroy]");
    }
    this.mApp = null;
  }
  
  public void onReceiveAioPush(Object paramObject)
  {
    if (!(paramObject instanceof apollo_push_msgInfo.STPushMsgElem)) {
      return;
    }
    paramObject = (apollo_push_msgInfo.STPushMsgElem)paramObject;
    if ((paramObject.pm3.has()) && (this.mApp != null))
    {
      paramObject = paramObject.pm3.get();
      if ((paramObject != null) && (paramObject.size() > 0))
      {
        paramObject = new ArrayList(paramObject.size());
        ApolloDaoManagerServiceImpl localApolloDaoManagerServiceImpl = (ApolloDaoManagerServiceImpl)this.mApp.getRuntimeService(IApolloDaoManagerService.class, "all");
        if (localApolloDaoManagerServiceImpl != null) {
          localApolloDaoManagerServiceImpl.saveAioPushData(paramObject, 1);
        } else {
          QLog.e("[cmshow]ApolloPushManager", 1, "[onReceiveAioPush] dao manager is null ");
        }
        ((HotChatCenterManager)this.mApp.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).b(NetConnInfoCenter.getServerTimeMillis());
        return;
      }
      QLog.e("[cmshow]ApolloPushManager", 1, "[onReceiveAioPush] pb list is null or empty");
      return;
    }
    QLog.e("[cmshow]ApolloPushManager", 1, "[onReceiveAioPush] msg null or pms none");
  }
  
  public void onReceiveApolloPush(Object paramObject)
  {
    if (!(paramObject instanceof apollo_push_msgInfo.STPushMsgElem)) {
      return;
    }
    paramObject = (apollo_push_msgInfo.STPushMsgElem)paramObject;
    if ((paramObject.pm4.has()) && (this.mApp != null))
    {
      paramObject = paramObject.pm4.get();
      if (paramObject == null)
      {
        QLog.e("[cmshow]ApolloPushManager", 1, "[onReceiveApolloPush] pushMsgElem0x4List is null");
        return;
      }
      int i = 0;
      while (i < paramObject.size())
      {
        Object localObject = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4)paramObject.get(i);
        if (localObject != null)
        {
          int j = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4)localObject).appid.get();
          int k = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4)localObject).newVer.get();
          localObject = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4)localObject).name.get();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("appId:");
          localStringBuilder.append(j);
          localStringBuilder.append(" newVersion:");
          localStringBuilder.append(k);
          localStringBuilder.append(" name:");
          localStringBuilder.append((String)localObject);
          QLog.i("[cmshow]ApolloPushManager", 1, localStringBuilder.toString());
          switch (j)
          {
          case 204: 
          default: 
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onReceiveApolloPush unRecognition appId:");
            ((StringBuilder)localObject).append(j);
            QLog.e("[cmshow]ApolloPushManager", 1, ((StringBuilder)localObject).toString());
            break;
          case 206: 
            handleUpdateBaseRes(j, k, (String)localObject);
            break;
          case 205: 
            handleUpdateWebView(k, (String)localObject);
            break;
          case 203: 
            handleUpdateDressRes(j, k, (String)localObject);
            break;
          case 202: 
            handleUpdateRoleRes(j, k, (String)localObject);
            break;
          case 201: 
            handleUpdatePanelJsonCfg(j, k, (String)localObject);
          }
        }
        i += 1;
      }
      return;
    }
    QLog.e("[cmshow]ApolloPushManager", 1, "[onReceiveApolloPush] msg null or pms none");
  }
  
  public void onReceiveDrawerHirePush(Object paramObject)
  {
    if (this.mApp == null) {
      return;
    }
    if (!(paramObject instanceof apollo_push_msgInfo.STPushMsgElem)) {
      return;
    }
    paramObject = (apollo_push_msgInfo.STPushMsgElem)paramObject;
    try
    {
      int i = paramObject.showPlace.get();
      if ((2 == paramObject.type.get()) && (3 == i))
      {
        apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2 localSTPushMsgElem0x2 = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2)paramObject.pm2.get();
        Object localObject = this.mApp.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("apollo_sp");
        localStringBuilder.append(this.mApp.getCurrentUin());
        ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putLong("hire_for", localSTPushMsgElem0x2.toUin.get()).putInt("hire_action", localSTPushMsgElem0x2.actionId.get()).putLong("hire_end", localSTPushMsgElem0x2.endTs.get()).putString("hire_word", localSTPushMsgElem0x2.diyWords.get()).putInt("hire_priority", paramObject.priority.get()).putBoolean("hire_bubble_click", false).commit();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("receive drawerHirePush:");
          ((StringBuilder)localObject).append(localSTPushMsgElem0x2.actionId.get());
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(localSTPushMsgElem0x2.endTs.get());
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(localSTPushMsgElem0x2.diyWords.get());
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(paramObject.priority.get());
          QLog.i("[cmshow]ApolloPushManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.i("[cmshow]ApolloPushManager", 2, "onReceiveDrawerHirePush incompatible type");
        }
        return;
      }
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("[cmshow]ApolloPushManager", 2, "onReceiveDrawerHirePush error:", paramObject);
      }
    }
  }
  
  public void onRecvActionPush(int paramInt, Object paramObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onRecvActionPush], aioType:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("[cmshow]ApolloPushManager", 2, ((StringBuilder)localObject).toString());
    }
    if (!(paramObject instanceof apollo_push_msgInfo.STPushMsgElem)) {
      return;
    }
    paramObject = (apollo_push_msgInfo.STPushMsgElem)paramObject;
    try
    {
      int i = paramObject.showPlace.get();
      int j = paramObject.type.get();
      if ((1 == j) && (1 == i))
      {
        paramObject = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)paramObject.pm1.get();
        localObject = new ApolloActionPush();
        ((ApolloActionPush)localObject).mId = NetConnInfoCenter.getServerTimeMillis();
        ((ApolloActionPush)localObject).mActionId = paramObject.actionId.get();
        ((ApolloActionPush)localObject).mActionType = paramObject.actionType.get();
        ((ApolloActionPush)localObject).mAioType = ApolloUtilImpl.getQAioType(paramObject.aioType.get());
        ((ApolloActionPush)localObject).mContent = paramObject.diyWords.get();
        ((ApolloActionPush)localObject).mRcvUin = paramObject.rcvUin.get();
        ((ApolloActionPush)localObject).mSendUin = paramObject.sendUin.get();
        if (!ApolloUtilImpl.isApolloUser(this.mApp))
        {
          QLog.w("[cmshow]ApolloPushManager", 1, "NOT apollo user, return.");
          return;
        }
        ((ApolloActionPush)localObject).mWordShowType = paramObject.wordType.get();
        String str;
        if (paramInt == 0)
        {
          str = this.mApp.getCurrentAccountUin();
          if ((!TextUtils.isEmpty(str)) && (str.equals(Long.toString(paramObject.sessionId.get()))))
          {
            if ((!str.equals(Long.toString(((ApolloActionPush)localObject).mRcvUin))) && (0L != ((ApolloActionPush)localObject).mRcvUin)) {
              ((ApolloActionPush)localObject).mSessionId = ((ApolloActionPush)localObject).mRcvUin;
            } else {
              ((ApolloActionPush)localObject).mSessionId = ((ApolloActionPush)localObject).mSendUin;
            }
          }
          else {
            ((ApolloActionPush)localObject).mSessionId = paramObject.sessionId.get();
          }
        }
        else
        {
          ((ApolloActionPush)localObject).mSessionId = paramObject.sessionId.get();
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloPushManager", 2, new Object[] { "[onRecvActionPush]  actionPush = ", localObject });
        }
        if (this.mApp == null) {
          return;
        }
        ((ApolloDaoManagerServiceImpl)this.mApp.getRuntimeService(IApolloDaoManagerService.class, "all")).saveActionPushData((ApolloActionPush)localObject);
        ThreadManager.post(new ApolloPushManagerImpl.1(this, paramInt, (ApolloActionPush)localObject), 5, null, true);
        if (paramInt != 0)
        {
          paramObject = String.valueOf(((ApolloActionPush)localObject).mSendUin);
          localObject = String.valueOf(((ApolloActionPush)localObject).mRcvUin);
          str = this.mApp.getCurrentAccountUin();
          ApolloResManagerFacade localApolloResManagerFacade = ApolloResManagerFacade.a;
          boolean bool = TextUtils.isEmpty(str);
          if ((!bool) && (!str.equals(paramObject))) {
            localApolloResManagerFacade.a(this.mApp, paramObject, "apllo_redPack_action");
          }
          if ((!TextUtils.isEmpty(str)) && (!str.equals(localObject))) {
            localApolloResManagerFacade.a(this.mApp, (String)localObject, "apllo_redPack_action");
          }
        }
      }
      else
      {
        paramObject = new StringBuilder();
        paramObject.append("[onRecvActionPush], It doesn't meet show conditions, type:");
        paramObject.append(j);
        paramObject.append(",showPlace:");
        paramObject.append(i);
        QLog.i("[cmshow]ApolloPushManager", 1, paramObject.toString());
        return;
      }
    }
    catch (Exception paramObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("errInfo->");
      ((StringBuilder)localObject).append(paramObject.getMessage());
      QLog.e("[cmshow]ApolloPushManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void setActionPushListener(IApolloPushManager.OnActionPushListener paramOnActionPushListener)
  {
    if (paramOnActionPushListener == null)
    {
      this.mActionPushLisRef = null;
      return;
    }
    this.mActionPushLisRef = new WeakReference(paramOnActionPushListener);
  }
  
  public void triggerAction(ApolloActionPush paramApolloActionPush)
  {
    if (paramApolloActionPush == null)
    {
      QLog.e("[cmshow]ApolloPushManager", 1, "[tiggerAction] pushData is null,return.");
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = paramApolloActionPush.mActionId;
    localSpriteTaskParam.c = 0;
    localSpriteTaskParam.i = paramApolloActionPush.mAioType;
    localSpriteTaskParam.g = 4;
    localSpriteTaskParam.h = -10000L;
    localSpriteTaskParam.m = 0;
    localSpriteTaskParam.n = 0.0F;
    localSpriteTaskParam.e = paramApolloActionPush.mActionType;
    localSpriteTaskParam.o = paramApolloActionPush.mContent;
    if (paramApolloActionPush.mWordShowType == 1) {
      localSpriteTaskParam.q = true;
    } else {
      localSpriteTaskParam.q = false;
    }
    localSpriteTaskParam.j = String.valueOf(paramApolloActionPush.mSendUin);
    localSpriteTaskParam.k = String.valueOf(paramApolloActionPush.mRcvUin);
    Object localObject1 = this.mApp;
    if (localObject1 != null)
    {
      localSpriteTaskParam.l = ((QQAppInterface)localObject1).getCurrentAccountUin().equals(String.valueOf(paramApolloActionPush.mSendUin));
      localObject1 = (ApolloDaoManagerServiceImpl)this.mApp.getRuntimeService(IApolloDaoManagerService.class, "all");
      Object localObject2 = ((ApolloDaoManagerServiceImpl)localObject1).findActionById(localSpriteTaskParam.f);
      if (localObject2 != null)
      {
        if (TextUtils.isEmpty(localSpriteTaskParam.o)) {
          localSpriteTaskParam.o = ApolloActionHelperImpl.getRandomBubbleText(((ApolloActionData)localObject2).bubbleText);
        }
      }
      else
      {
        localObject2 = Collections.synchronizedList(new ArrayList());
        ApolloActionData localApolloActionData = new ApolloActionData();
        localApolloActionData.actionId = localSpriteTaskParam.f;
        ((List)localObject2).add(localApolloActionData);
        ((ApolloDaoManagerServiceImpl)localObject1).saveAction((List)localObject2);
      }
    }
    localObject1 = (ISpriteScriptManager)this.mApp.getRuntimeService(ISpriteScriptManager.class, "all");
    if (localObject1 != null) {
      ((ISpriteScriptManager)localObject1).getSpriteBridge().b(localSpriteTaskParam);
    }
    ThreadManager.post(new ApolloPushManagerImpl.2(this, paramApolloActionPush, localSpriteTaskParam), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloPushManagerImpl
 * JD-Core Version:    0.7.0.1
 */