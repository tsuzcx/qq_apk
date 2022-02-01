package com.tencent.mobileqq.apollo.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.apollo.api.IApolloPushManager.OnActionPushListener;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler.ApolloDownloadListener;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionPush;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl;
import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.store.webview.api.IApolloSSOConfigHelper;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
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
    Object localObject = (ApolloContentUpdateHandler)this.mApp.getBusinessHandler(BusinessHandlerFactory.APOLLO_CONTENT_UPDATE_HANDLER);
    if (!TextUtils.equals(((ApolloContentUpdateHandler)localObject).a(), paramString)) {
      return;
    }
    paramString = new File(ApolloConstant.N);
    boolean bool2 = paramString.exists();
    boolean bool1 = false;
    if (!bool2) {}
    while ((paramString.list() == null) || (paramString.list().length == 0))
    {
      i = 1;
      break;
    }
    int i = 0;
    int j = (int)((ApolloContentUpdateHandler)localObject).b();
    if (paramInt2 > j) {
      i = 1;
    } else {
      QLog.e("[cmshow]ApolloPushManager", 1, "onReceiveApolloPush not newVersion < localVersion");
    }
    paramString = new StringBuilder();
    paramString.append(ApolloConstant.N);
    paramString.append("base.zip");
    paramString = paramString.toString();
    if (i != 0)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putLong("version", paramInt2);
      ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadCmshowRes(this.mApp, paramString, ApolloConstant.L, (Bundle)localObject, new ApolloContentUpdateHandler.ApolloDownloadListener());
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("appId:");
      paramString.append(paramInt1);
      paramString.append(" version:");
      paramString.append(paramInt2);
      paramString.append(" localVersion:");
      paramString.append(j);
      paramString.append(" update:");
      if (paramInt2 > j) {
        bool1 = true;
      }
      paramString.append(bool1);
      QLog.d("[cmshow]ApolloPushManager", 2, paramString.toString());
    }
  }
  
  private void handleUpdateDressRes(int paramInt1, int paramInt2, String paramString)
  {
    if (!isNeedPushBySwitch()) {
      return;
    }
    try
    {
      Object localObject = (IApolloManagerService)this.mApp.getRuntimeService(IApolloManagerService.class, "all");
      if ((((IApolloManagerService)localObject).isApolloSupport(this.mApp.getApp())) && (1 == ((IApolloManagerService)localObject).getApolloStatus(this.mApp.getCurrentUin())))
      {
        int i = Integer.parseInt(paramString);
        long l1 = ((IApolloManagerService)localObject).getApolloResLocalTimestamp(2, i) / 1000L;
        long l2 = paramInt2;
        boolean bool = false;
        if (l1 != l2) {
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(this.mApp, this.mApp.getCurrentUin(), null, -1, new int[] { i }, -1, -1, true);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("appId:");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(" version:");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(" localVersion:");
          ((StringBuilder)localObject).append(l1);
          ((StringBuilder)localObject).append(" update:");
          if (l2 > l1) {
            bool = true;
          }
          ((StringBuilder)localObject).append(bool);
          QLog.d("[cmshow]ApolloPushManager", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo dress real time update id:");
      localStringBuilder.append(paramString);
      QLog.e("[cmshow]ApolloPushManager", 2, localStringBuilder.toString(), localException);
    }
  }
  
  private void handleUpdatePanelJsonCfg(int paramInt1, int paramInt2, String paramString)
  {
    if (!isNeedPushBySwitch()) {
      return;
    }
    if (!"tab_list_android_json_v665".equals(paramString)) {
      return;
    }
    paramString = (IApolloUtil)QRoute.api(IApolloUtil.class);
    boolean bool = true;
    int i = paramString.getApolloPanelJsonVer(1);
    if (paramInt2 > i) {
      ((ApolloResManagerImpl)this.mApp.getRuntimeService(IApolloResManager.class, "all")).checkApolloPanelJsonCfg(true, "onLinePush", 1);
    } else {
      QLog.e("[cmshow]ApolloPushManager", 1, "onReceiveApolloPush not newVersion < localVersion");
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("appId:");
      paramString.append(paramInt1);
      paramString.append(" version:");
      paramString.append(paramInt2);
      paramString.append(" jsonVersion:");
      paramString.append(i);
      paramString.append(" update:");
      if (paramInt2 <= i) {
        bool = false;
      }
      paramString.append(bool);
      QLog.d("[cmshow]ApolloPushManager", 2, paramString.toString());
    }
  }
  
  private void handleUpdateRoleRes(int paramInt1, int paramInt2, String paramString)
  {
    if (!isNeedPushBySwitch()) {
      return;
    }
    for (;;)
    {
      try
      {
        int i = Integer.parseInt(paramString);
        long l1 = ((IApolloManagerService)this.mApp.getRuntimeService(IApolloManagerService.class, "all")).getApolloResLocalTimestamp(1, i) / 1000L;
        long l2 = paramInt2;
        if (l1 == l2) {
          break label194;
        }
        ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(this.mApp, this.mApp.getCurrentAccountUin(), null, i, null, -1, -1, true);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("appId:");
          paramString.append(paramInt1);
          paramString.append(" version:");
          paramString.append(paramInt2);
          paramString.append(" roleLocalVersion:");
          paramString.append(l1);
          paramString.append(" update:");
          if (l2 <= l1) {
            break label197;
          }
          bool = true;
          paramString.append(bool);
          QLog.d("[cmshow]ApolloPushManager", 2, paramString.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("[cmshow]ApolloPushManager", 1, paramString, new Object[0]);
      }
      return;
      label194:
      continue;
      label197:
      boolean bool = false;
    }
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
        ((HotChatCenterManager)this.mApp.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a(NetConnInfoCenter.getServerTimeMillis());
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
        localObject = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)paramObject.pm1.get();
        paramObject = new ApolloActionPush();
        paramObject.mId = NetConnInfoCenter.getServerTimeMillis();
        paramObject.mActionId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).actionId.get();
        paramObject.mActionType = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).actionType.get();
        paramObject.mAioType = ApolloUtilImpl.getQAioType(((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).aioType.get());
        paramObject.mContent = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).diyWords.get();
        paramObject.mRcvUin = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).rcvUin.get();
        paramObject.mSendUin = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sendUin.get();
        if (!ApolloUtilImpl.isApolloUser(this.mApp))
        {
          QLog.w("[cmshow]ApolloPushManager", 1, "NOT apollo user, return.");
          return;
        }
        paramObject.mWordShowType = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).wordType.get();
        String str1;
        if (paramInt == 0)
        {
          str1 = this.mApp.getCurrentAccountUin();
          if ((!TextUtils.isEmpty(str1)) && (str1.equals(Long.toString(((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sessionId.get()))))
          {
            if ((!str1.equals(Long.toString(paramObject.mRcvUin))) && (0L != paramObject.mRcvUin)) {
              paramObject.mSessionId = paramObject.mRcvUin;
            } else {
              paramObject.mSessionId = paramObject.mSendUin;
            }
          }
          else {
            paramObject.mSessionId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sessionId.get();
          }
        }
        else
        {
          paramObject.mSessionId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sessionId.get();
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloPushManager", 2, new Object[] { "[onRecvActionPush]  actionPush = ", paramObject });
        }
        if (this.mApp == null) {
          return;
        }
        ((ApolloDaoManagerServiceImpl)this.mApp.getRuntimeService(IApolloDaoManagerService.class, "all")).saveActionPushData(paramObject);
        ThreadManager.post(new ApolloPushManagerImpl.1(this, paramInt, paramObject), 5, null, true);
        if (paramInt != 0)
        {
          localObject = (ApolloManagerServiceImpl)this.mApp.getRuntimeService(IApolloManagerService.class, "all");
          str1 = String.valueOf(paramObject.mSendUin);
          paramObject = String.valueOf(paramObject.mRcvUin);
          String str2 = this.mApp.getCurrentAccountUin();
          boolean bool = TextUtils.isEmpty(str2);
          if ((!bool) && (!str2.equals(str1))) {
            ((ApolloManagerServiceImpl)localObject).checkUserDress(this.mApp, str1, "apllo_redPack_action");
          }
          if ((!TextUtils.isEmpty(str2)) && (!str2.equals(paramObject))) {
            ((ApolloManagerServiceImpl)localObject).checkUserDress(this.mApp, paramObject, "apllo_redPack_action");
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
    localSpriteTaskParam.jdField_c_of_type_Int = 0;
    localSpriteTaskParam.h = paramApolloActionPush.mAioType;
    localSpriteTaskParam.g = 4;
    localSpriteTaskParam.jdField_a_of_type_Long = -10000L;
    localSpriteTaskParam.i = 0;
    localSpriteTaskParam.jdField_a_of_type_Float = 0.0F;
    localSpriteTaskParam.e = paramApolloActionPush.mActionType;
    localSpriteTaskParam.jdField_c_of_type_JavaLangString = paramApolloActionPush.mContent;
    if (paramApolloActionPush.mWordShowType == 1) {
      localSpriteTaskParam.jdField_b_of_type_Boolean = true;
    } else {
      localSpriteTaskParam.jdField_b_of_type_Boolean = false;
    }
    localSpriteTaskParam.jdField_a_of_type_JavaLangString = String.valueOf(paramApolloActionPush.mSendUin);
    localSpriteTaskParam.jdField_b_of_type_JavaLangString = String.valueOf(paramApolloActionPush.mRcvUin);
    Object localObject1 = this.mApp;
    if (localObject1 != null)
    {
      localSpriteTaskParam.jdField_a_of_type_Boolean = ((QQAppInterface)localObject1).getCurrentAccountUin().equals(String.valueOf(paramApolloActionPush.mSendUin));
      localObject1 = (ApolloDaoManagerServiceImpl)this.mApp.getRuntimeService(IApolloDaoManagerService.class, "all");
      Object localObject2 = ((ApolloDaoManagerServiceImpl)localObject1).findActionById(localSpriteTaskParam.f);
      if (localObject2 != null)
      {
        if (TextUtils.isEmpty(localSpriteTaskParam.jdField_c_of_type_JavaLangString)) {
          localSpriteTaskParam.jdField_c_of_type_JavaLangString = ApolloActionHelperImpl.getRandomBubbleText(((ApolloActionData)localObject2).bubbleText);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloPushManagerImpl
 * JD-Core Version:    0.7.0.1
 */