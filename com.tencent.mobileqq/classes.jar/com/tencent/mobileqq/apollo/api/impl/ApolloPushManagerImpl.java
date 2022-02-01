package com.tencent.mobileqq.apollo.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.apollo.api.IApolloPushManager.OnActionPushListener;
import com.tencent.mobileqq.apollo.api.IApolloPushManager.OnPushObserver;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPush;
import com.tencent.mobileqq.apollo.api.model.ApolloGameRedDot;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.store.webview.IApolloSSOConfigHelper;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloActionHelperImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler.ApolloDownloadListener;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AioPushData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3;
import tencent.im.apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4;

public class ApolloPushManagerImpl
  implements IApolloPushManager
{
  private static final int DRAWER_HIRE_PUSH = 2;
  private static final int MSG_SHOW_PLACE_AT_AIO = 1;
  private static final int MSG_SHOW_PLACE_DRAWER = 3;
  private static final int RED_PACK_ACTION_PUSH = 1;
  public static final String TAG = "ApolloPushManager";
  private WeakReference<IApolloPushManager.OnActionPushListener> mActionPushLisRef;
  private QQAppInterface mApp;
  private WeakReference<IApolloPushManager.OnPushObserver> mOnPushObserverRef;
  
  private boolean isNeedPushBySwitch()
  {
    if (this.mApp == null) {
      return false;
    }
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.mApp.getRuntimeService(IApolloManagerService.class, "all");
    if ((localIApolloManagerService != null) && (localIApolloManagerService.isApolloFuncOpen(this.mApp.getApp())) && (1 == localIApolloManagerService.getApolloStatus(this.mApp.getCurrentUin()))) {
      return true;
    }
    QLog.i("ApolloPushManager", 1, "isNeedPushBySwitch false");
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
      QLog.d("ApolloPushManager", 2, "[onDestroy]");
    }
    this.mApp = null;
  }
  
  public void onReceiveAioPush(apollo_push_msgInfo.STPushMsgElem paramSTPushMsgElem)
  {
    if ((paramSTPushMsgElem == null) || (!paramSTPushMsgElem.pm3.has()) || (this.mApp == null))
    {
      QLog.e("ApolloPushManager", 1, "[onReceiveAioPush] msg null or pms none");
      return;
    }
    Object localObject2 = paramSTPushMsgElem.pm3.get();
    Object localObject1 = this.mApp.getEntityManagerFactory().createEntityManager();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      paramSTPushMsgElem = new ArrayList(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      int i = 1;
      if (((Iterator)localObject2).hasNext())
      {
        apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3 localSTPushMsgElem0x3 = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x3)((Iterator)localObject2).next();
        Object localObject3;
        if (localSTPushMsgElem0x3.dotId.get() != 1003)
        {
          localObject3 = new ApolloGameRedDot();
          ((ApolloGameRedDot)localObject3).mDotId = localSTPushMsgElem0x3.dotId.get();
          ((ApolloGameRedDot)localObject3).mStartTime = localSTPushMsgElem0x3.begTs.get();
          ((ApolloGameRedDot)localObject3).mEndTime = localSTPushMsgElem0x3.endTs.get();
          ((ApolloGameRedDot)localObject3).mTipsWording = localSTPushMsgElem0x3.wording.get();
          ((ApolloGameRedDot)localObject3).mGameId = localSTPushMsgElem0x3.busId.get();
          ((ApolloGameRedDot)localObject3).mUrl = localSTPushMsgElem0x3.url.get();
          ((ApolloGameRedDot)localObject3).mActId = localSTPushMsgElem0x3.actId.get();
          ((ApolloGameRedDot)localObject3).mPriority = localSTPushMsgElem0x3.priority.get();
          ((ApolloGameRedDot)localObject3).mSpRegion = localSTPushMsgElem0x3.spRegion.get();
          ((EntityManager)localObject1).persistOrReplace((Entity)localObject3);
          VipUtils.a(this.mApp, "cmshow", "Apollo", "get_notice", ((ApolloGameRedDot)localObject3).mDotId, 1, new String[] { String.valueOf(((ApolloGameRedDot)localObject3).mGameId), "", ((ApolloGameRedDot)localObject3).mActId });
          ApolloGameUtil.a((EntityManager)localObject1);
        }
        for (;;)
        {
          break;
          localObject3 = new AioPushData();
          ((AioPushData)localObject3).begTs = localSTPushMsgElem0x3.begTs.get();
          ((AioPushData)localObject3).busId = localSTPushMsgElem0x3.busId.get();
          ((AioPushData)localObject3).busType = localSTPushMsgElem0x3.busType.get();
          ((AioPushData)localObject3).dotId = localSTPushMsgElem0x3.dotId.get();
          ((AioPushData)localObject3).endTs = localSTPushMsgElem0x3.endTs.get();
          ((AioPushData)localObject3).priority = localSTPushMsgElem0x3.priority.get();
          ((AioPushData)localObject3).them = localSTPushMsgElem0x3.theme.get();
          ((AioPushData)localObject3).wording = localSTPushMsgElem0x3.wording.get();
          ((AioPushData)localObject3).url = localSTPushMsgElem0x3.url.get();
          ((AioPushData)localObject3).actId = localSTPushMsgElem0x3.actId.get();
          ((AioPushData)localObject3).spRegion = localSTPushMsgElem0x3.spRegion.get();
          ((AioPushData)localObject3).folderIconUrl = localSTPushMsgElem0x3.folderIconUrl.get();
          if (QLog.isColorLevel()) {
            QLog.d("ApolloPushManager", 2, "[onReceiveAioPush] receive " + localObject3);
          }
          int j = i;
          if (this.mOnPushObserverRef != null)
          {
            j = i;
            if (this.mOnPushObserverRef.get() != null)
            {
              j = i;
              if (((AioPushData)localObject3).isShow)
              {
                j = 2;
                ((IApolloPushManager.OnPushObserver)this.mOnPushObserverRef.get()).a(1, localObject3);
              }
            }
          }
          i = j;
        }
      }
      localObject1 = (ApolloDaoManagerServiceImpl)this.mApp.getRuntimeService(IApolloDaoManagerService.class, "all");
      if (localObject1 != null) {
        ((ApolloDaoManagerServiceImpl)localObject1).saveAioPushData(paramSTPushMsgElem, i);
      }
      for (;;)
      {
        ((HotChatCenterManager)this.mApp.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER)).a(NetConnInfoCenter.getServerTimeMillis());
        return;
        QLog.e("ApolloPushManager", 1, "[onReceiveAioPush] dao manager is null ");
      }
    }
    QLog.e("ApolloPushManager", 1, "[onReceiveAioPush] pb list is null or empty");
  }
  
  public void onReceiveApolloPush(apollo_push_msgInfo.STPushMsgElem paramSTPushMsgElem)
  {
    if ((paramSTPushMsgElem == null) || (!paramSTPushMsgElem.pm4.has()) || (this.mApp == null)) {
      QLog.e("ApolloPushManager", 1, "[onReceiveApolloPush] msg null or pms none");
    }
    int j;
    do
    {
      do
      {
        return;
        paramSTPushMsgElem = paramSTPushMsgElem.pm4.get();
      } while (paramSTPushMsgElem == null);
      j = 0;
    } while (j >= paramSTPushMsgElem.size());
    Object localObject1 = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4)paramSTPushMsgElem.get(j);
    int k;
    int m;
    if (localObject1 != null)
    {
      k = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4)localObject1).appid.get();
      m = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4)localObject1).newVer.get();
      localObject1 = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x4)localObject1).name.get();
      QLog.i("ApolloPushManager", 1, "appId:" + k + " newVersion:" + m + " name:" + (String)localObject1);
      switch (k)
      {
      case 204: 
      default: 
        QLog.e("ApolloPushManager", 1, "onReceiveApolloPush unRecognition appId:" + k);
      }
    }
    int i;
    label290:
    boolean bool;
    label383:
    Object localObject2;
    label431:
    label446:
    label631:
    long l;
    label643:
    label866:
    do
    {
      do
      {
        for (;;)
        {
          j += 1;
          break;
          if ((isNeedPushBySwitch()) && ("tab_list_android_json_v665".equals(localObject1)))
          {
            i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getApolloPanelJsonVer(1);
            if (m > i)
            {
              ((IApolloManagerService)this.mApp.getRuntimeService(IApolloManagerService.class, "all")).checkApolloPanelJsonCfg(true, "onLinePush", 1);
              if (!QLog.isColorLevel()) {
                continue;
              }
              localObject1 = new StringBuilder().append("appId:").append(k).append(" version:").append(m).append(" jsonVersion:").append(i).append(" update:");
              if (m <= i) {
                break label383;
              }
            }
            for (bool = true;; bool = false)
            {
              QLog.d("ApolloPushManager", 2, bool);
              break;
              QLog.e("ApolloPushManager", 1, "onReceiveApolloPush not newVersion < localVersion");
              break label290;
            }
            if ((isNeedPushBySwitch()) && (ApolloContentUpdateHandler.a().equals(localObject1)))
            {
              i = 0;
              localObject1 = new File(ApolloConstant.I);
              if (!((File)localObject1).exists())
              {
                i = 1;
                int n = (int)ApolloContentUpdateHandler.b();
                if (m <= n) {
                  break label631;
                }
                i = 1;
                localObject1 = ApolloConstant.I + "base.zip";
                if (i != 0)
                {
                  localObject2 = new Bundle();
                  ((Bundle)localObject2).putLong("version", m);
                  ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downLoadCmshowRes(this.mApp, (String)localObject1, ApolloConstant.G, (Bundle)localObject2, new ApolloContentUpdateHandler.ApolloDownloadListener());
                }
                if (!QLog.isColorLevel()) {
                  continue;
                }
                localObject1 = new StringBuilder().append("appId:").append(k).append(" version:").append(m).append(" localVersion:").append(n).append(" update:");
                if (m <= n) {
                  break label643;
                }
              }
              for (bool = true;; bool = false)
              {
                QLog.d("ApolloPushManager", 2, bool);
                break;
                if ((((File)localObject1).list() != null) && (((File)localObject1).list().length != 0)) {
                  break label431;
                }
                i = 1;
                break label431;
                QLog.e("ApolloPushManager", 1, "onReceiveApolloPush not newVersion < localVersion");
                break label446;
              }
              if ("apollo_thunder_json_v670".equals(localObject1)) {
                ((IApolloSSOConfigHelper)QRoute.api(IApolloSSOConfigHelper.class)).checkUpdateApolloWebViewConfig(this.mApp, m, false);
              }
            }
          }
        }
      } while (!isNeedPushBySwitch());
      for (;;)
      {
        try
        {
          i = Integer.parseInt((String)localObject1);
          l = ((IApolloManagerService)this.mApp.getRuntimeService(IApolloManagerService.class, "all")).getApolloResLocalTimestamp(1, i) / 1000L;
          if (l != m) {
            ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloResOrder(this.mApp, this.mApp.getCurrentAccountUin(), null, i, null, -1, -1, true);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          localObject1 = new StringBuilder().append("appId:").append(k).append(" version:").append(m).append(" roleLocalVersion:").append(l).append(" update:");
          if (m <= l) {
            break label866;
          }
          bool = true;
          QLog.d("ApolloPushManager", 2, bool);
        }
        catch (Exception localException1)
        {
          QLog.e("ApolloPushManager", 1, localException1, new Object[0]);
        }
        break;
        bool = false;
      }
    } while (!isNeedPushBySwitch());
    for (;;)
    {
      try
      {
        localObject2 = (IApolloManagerService)this.mApp.getRuntimeService(IApolloManagerService.class, "all");
        if ((!((IApolloManagerService)localObject2).isApolloFuncOpen(this.mApp.getApp())) || (localObject2 == null) || (1 != ((IApolloManagerService)localObject2).getApolloStatus(this.mApp.getCurrentUin()))) {
          break;
        }
        i = Integer.parseInt(localException1);
        l = ((IApolloManagerService)localObject2).getApolloResLocalTimestamp(2, i) / 1000L;
        if (l != m) {
          ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).downloadApolloRes(this.mApp, this.mApp.getCurrentUin(), null, -1, new int[] { i }, -1, -1, true);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        localObject2 = new StringBuilder().append("appId:").append(k).append(" version:").append(m).append(" localVersion:").append(l).append(" update:");
        if (m <= l) {
          break label1121;
        }
        bool = true;
        QLog.d("ApolloPushManager", 2, bool);
      }
      catch (Exception localException2)
      {
        QLog.e("ApolloPushManager", 2, "apollo dress real time update id:" + localException1, localException2);
      }
      break;
      label1121:
      bool = false;
    }
  }
  
  public void onReceiveDrawerHirePush(apollo_push_msgInfo.STPushMsgElem paramSTPushMsgElem)
  {
    if ((paramSTPushMsgElem == null) || (this.mApp == null)) {}
    label70:
    apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2 localSTPushMsgElem0x2;
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            int i = paramSTPushMsgElem.showPlace.get();
            if ((2 == paramSTPushMsgElem.type.get()) && (3 == i)) {
              break label70;
            }
            if (QLog.isColorLevel())
            {
              QLog.i("ApolloPushManager", 2, "onReceiveDrawerHirePush incompatible type");
              return;
            }
          }
          catch (Exception paramSTPushMsgElem) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("ApolloPushManager", 2, "onReceiveDrawerHirePush error:", paramSTPushMsgElem);
      return;
      localSTPushMsgElem0x2 = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x2)paramSTPushMsgElem.pm2.get();
      this.mApp.getApp().getSharedPreferences("apollo_sp" + this.mApp.getCurrentUin(), 0).edit().putLong("hire_for", localSTPushMsgElem0x2.toUin.get()).putInt("hire_action", localSTPushMsgElem0x2.actionId.get()).putLong("hire_end", localSTPushMsgElem0x2.endTs.get()).putString("hire_word", localSTPushMsgElem0x2.diyWords.get()).putInt("hire_priority", paramSTPushMsgElem.priority.get()).putBoolean("hire_bubble_click", false).commit();
    } while (!QLog.isColorLevel());
    QLog.i("ApolloPushManager", 2, "receive drawerHirePush:" + localSTPushMsgElem0x2.actionId.get() + "," + localSTPushMsgElem0x2.endTs.get() + "," + localSTPushMsgElem0x2.diyWords.get() + "," + paramSTPushMsgElem.priority.get());
  }
  
  public void onRecvActionPush(int paramInt, apollo_push_msgInfo.STPushMsgElem paramSTPushMsgElem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPushManager", 2, "[onRecvActionPush], aioType:" + paramInt);
    }
    if (paramSTPushMsgElem == null) {
      return;
    }
    try
    {
      int i = paramSTPushMsgElem.showPlace.get();
      int j = paramSTPushMsgElem.type.get();
      if ((1 != j) || (1 != i))
      {
        QLog.i("ApolloPushManager", 1, "[onRecvActionPush], It doesn't meet show conditions, type:" + j + ",showPlace:" + i);
        return;
      }
    }
    catch (Exception paramSTPushMsgElem)
    {
      paramSTPushMsgElem.printStackTrace();
      QLog.e("ApolloPushManager", 1, "errInfo->" + paramSTPushMsgElem.getMessage());
      return;
    }
    Object localObject = (apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)paramSTPushMsgElem.pm1.get();
    paramSTPushMsgElem = new ApolloActionPush();
    paramSTPushMsgElem.mId = NetConnInfoCenter.getServerTimeMillis();
    paramSTPushMsgElem.mActionId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).actionId.get();
    paramSTPushMsgElem.mActionType = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).actionType.get();
    paramSTPushMsgElem.mAioType = ApolloUtilImpl.getQAioType(((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).aioType.get());
    paramSTPushMsgElem.mContent = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).diyWords.get();
    paramSTPushMsgElem.mRcvUin = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).rcvUin.get();
    paramSTPushMsgElem.mSendUin = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sendUin.get();
    if (!ApolloGameUtil.a(this.mApp))
    {
      QLog.w("ApolloPushManager", 1, "NOT apollo user, return.");
      return;
    }
    paramSTPushMsgElem.mWordShowType = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).wordType.get();
    String str1;
    if (paramInt == 0)
    {
      str1 = this.mApp.getCurrentAccountUin();
      if ((!TextUtils.isEmpty(str1)) && (str1.equals(Long.toString(((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sessionId.get())))) {
        if ((str1.equals(Long.toString(paramSTPushMsgElem.mRcvUin))) || (0L == paramSTPushMsgElem.mRcvUin)) {
          paramSTPushMsgElem.mSessionId = paramSTPushMsgElem.mSendUin;
        }
      }
    }
    for (;;)
    {
      paramSTPushMsgElem.print();
      if (this.mApp == null) {
        break;
      }
      ((ApolloDaoManagerServiceImpl)this.mApp.getRuntimeService(IApolloDaoManagerService.class, "all")).saveActionPushData(paramSTPushMsgElem);
      ThreadManager.post(new ApolloPushManagerImpl.1(this, paramInt, paramSTPushMsgElem), 5, null, true);
      if (paramInt == 0) {
        break;
      }
      localObject = (ApolloManagerServiceImpl)this.mApp.getRuntimeService(IApolloManagerService.class, "all");
      str1 = String.valueOf(paramSTPushMsgElem.mSendUin);
      paramSTPushMsgElem = String.valueOf(paramSTPushMsgElem.mRcvUin);
      String str2 = this.mApp.getCurrentAccountUin();
      if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str1))) {
        ((ApolloManagerServiceImpl)localObject).checkUserDress(this.mApp, str1, "apllo_redPack_action");
      }
      if ((TextUtils.isEmpty(str2)) || (str2.equals(paramSTPushMsgElem))) {
        break;
      }
      ((ApolloManagerServiceImpl)localObject).checkUserDress(this.mApp, paramSTPushMsgElem, "apllo_redPack_action");
      return;
      paramSTPushMsgElem.mSessionId = paramSTPushMsgElem.mRcvUin;
      continue;
      paramSTPushMsgElem.mSessionId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sessionId.get();
      continue;
      paramSTPushMsgElem.mSessionId = ((apollo_push_msgInfo.STPushMsgElem.STPushMsgElem0x1)localObject).sessionId.get();
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
  
  public void setOnPushObserver(IApolloPushManager.OnPushObserver paramOnPushObserver)
  {
    if (paramOnPushObserver == null)
    {
      this.mOnPushObserverRef = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPushManager", 2, "[setOnPushObserver]");
    }
    this.mOnPushObserverRef = new WeakReference(paramOnPushObserver);
  }
  
  public void triggerAction(ApolloActionPush paramApolloActionPush)
  {
    boolean bool = false;
    if (paramApolloActionPush == null)
    {
      QLog.e("ApolloPushManager", 1, "[tiggerAction] pushData is null,return.");
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
    Object localObject1;
    Object localObject2;
    if (paramApolloActionPush.mWordShowType == 1)
    {
      localSpriteTaskParam.jdField_b_of_type_Boolean = true;
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = String.valueOf(paramApolloActionPush.mSendUin);
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = String.valueOf(paramApolloActionPush.mRcvUin);
      if (this.mApp != null)
      {
        if (this.mApp.getCurrentAccountUin().equals(String.valueOf(paramApolloActionPush.mSendUin))) {
          bool = true;
        }
        localSpriteTaskParam.jdField_a_of_type_Boolean = bool;
        localObject1 = (ApolloDaoManagerServiceImpl)this.mApp.getRuntimeService(IApolloDaoManagerService.class, "all");
        localObject2 = ((ApolloDaoManagerServiceImpl)localObject1).findActionById(localSpriteTaskParam.f);
        if (localObject2 == null) {
          break label267;
        }
        if (TextUtils.isEmpty(localSpriteTaskParam.jdField_c_of_type_JavaLangString)) {
          localSpriteTaskParam.jdField_c_of_type_JavaLangString = ApolloActionHelperImpl.getRandomBubbleText(((ApolloActionData)localObject2).bubbleText);
        }
      }
    }
    for (;;)
    {
      localObject1 = (ISpriteScriptManager)this.mApp.getRuntimeService(ISpriteScriptManager.class, "all");
      if (localObject1 != null) {
        ((ISpriteScriptManager)localObject1).getSpriteBridge().b(localSpriteTaskParam);
      }
      ThreadManager.post(new ApolloPushManagerImpl.2(this, paramApolloActionPush, localSpriteTaskParam), 5, null, true);
      return;
      localSpriteTaskParam.jdField_b_of_type_Boolean = false;
      break;
      label267:
      localObject2 = Collections.synchronizedList(new ArrayList());
      ApolloActionData localApolloActionData = new ApolloActionData();
      localApolloActionData.actionId = localSpriteTaskParam.f;
      ((List)localObject2).add(localApolloActionData);
      ((ApolloDaoManagerServiceImpl)localObject1).saveAction((List)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloPushManagerImpl
 * JD-Core Version:    0.7.0.1
 */