package com.tencent.mobileqq.apollo.aio.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ListAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie;
import com.tencent.mobileqq.apollo.aio.ApolloResponseManager;
import com.tencent.mobileqq.apollo.aio.ChatApolloViewListener;
import com.tencent.mobileqq.apollo.aio.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.aio.item.api.IApolloItemBuilderHelper;
import com.tencent.mobileqq.apollo.aio.panel.api.impl.ApolloPanelProviderImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.apollo.meme.MemeHelper;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloFavActionData;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.script.ISpriteActionScript;
import com.tencent.mobileqq.apollo.script.api.ISpriteUtil;
import com.tencent.mobileqq.apollo.statistics.CmShowStatUtil;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloMessageUtilImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import cooperation.vip.manager.QZoneVipInfoManager;
import java.util.HashMap;
import java.util.Map;

public class ApolloAIOHelperImpl
  implements Handler.Callback, IApolloAIOHelper
{
  public static final String TAG = "[cmshow]ApolloAIOHelperImpl";
  private boolean apolloIsShowing = false;
  private QQAppInterface app;
  private BaseChatPie chatPie;
  IApolloExtensionObserver cmShowActionObserver = new ApolloAIOHelperImpl.1(this);
  private Activity mActivity;
  private QQCustomDialog mApolloDialog;
  public ChatPieApolloViewController mApolloViewController;
  public ChatApolloViewListener mApolloViewObserver;
  private Context mContext;
  private SessionInfo sessionInfo;
  
  private void destroyApollo()
  {
    ChatPieApolloViewController localChatPieApolloViewController = this.mApolloViewController;
    if (localChatPieApolloViewController != null) {
      localChatPieApolloViewController.g(this.chatPie);
    }
    ((ApolloManagerServiceImpl)this.app.getRuntimeService(IApolloManagerService.class, "all")).setActionDownloadList(null);
    ((ApolloResponseManager)this.app.getManager(QQManagerFactory.APOLLO_RESPONSE_MANAGER)).a();
  }
  
  private void doOnCreate_initData() {}
  
  private void doOnCreate_initUI() {}
  
  private void doOnDestroy()
  {
    Object localObject = this.mApolloDialog;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      this.mApolloDialog.dismiss();
    }
    localObject = this.app;
    if (localObject != null)
    {
      ((QQAppInterface)localObject).removeObserver(this.cmShowActionObserver);
      this.app.removeObserver(this.mApolloViewObserver);
    }
    destroyApollo();
  }
  
  private void doOnPause()
  {
    ChatPieApolloViewController localChatPieApolloViewController = this.mApolloViewController;
    if (localChatPieApolloViewController != null) {
      localChatPieApolloViewController.f(this.chatPie);
    }
    ((IApolloItemBuilderHelper)QRoute.api(IApolloItemBuilderHelper.class)).pauseAllBrickPlayer();
  }
  
  private void doOnStart()
  {
    
    if (QLog.isColorLevel()) {
      QLog.i("ChatPieApolloViewController", 1, "START");
    }
    checkInitApolloViewController();
    this.mApolloViewController.a(this.chatPie);
  }
  
  private void doOnStop()
  {
    ((IApolloItemBuilderHelper)QRoute.api(IApolloItemBuilderHelper.class)).releaseAllBrickPlayer();
  }
  
  private void doOnUpdateSession_otherThings()
  {
    updateSession_checkUpdateFooterView();
  }
  
  private void finish()
  {
    Object localObject = this.mApolloViewController;
    if (localObject != null) {
      ((ChatPieApolloViewController)localObject).a(false);
    }
    localObject = this.chatPie.V;
    if ((localObject != null) && (((ListAdapter)localObject).getCount() > 0))
    {
      localObject = (ChatMessage)((ListAdapter)localObject).getItem(((ListAdapter)localObject).getCount() - 1);
      if ((localObject != null) && (((ChatMessage)localObject).msgtype == -2039))
      {
        localObject = (MessageForApollo)localObject;
        if ((!((MessageForApollo)localObject).hasPlayed) && (((MessageForApollo)localObject).isSend())) {
          ApolloMessageUtilImpl.markRead((MessageForApollo)localObject, this.app, this.sessionInfo.b, this.sessionInfo.a);
        }
      }
    }
  }
  
  private void onPreFinish()
  {
    MemeHelper.a.a(true);
  }
  
  private void onResume()
  {
    ChatPieApolloViewController localChatPieApolloViewController = this.mApolloViewController;
    if (localChatPieApolloViewController != null) {
      localChatPieApolloViewController.e(this.chatPie);
    }
  }
  
  private void onScrollStateChanged(int paramInt)
  {
    if (paramInt == 0)
    {
      ((IApolloItemBuilderHelper)QRoute.api(IApolloItemBuilderHelper.class)).resumeAllBrickPlayer();
      ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).bulkUpdateUserDress();
      return;
    }
    ((IApolloItemBuilderHelper)QRoute.api(IApolloItemBuilderHelper.class)).pauseAllBrickPlayer();
  }
  
  private void onShow() {}
  
  private void onShowFirst()
  {
    ((ISpriteUtil)QRoute.api(ISpriteUtil.class)).canInitCmShow(this.app);
    StartupTracker.a(null, "AIO_apolloSurface");
    checkInitApolloViewController();
    if (!validateCmShowFun())
    {
      this.chatPie.aV.b();
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloAIOHelperImpl", 2, "remove footerview for initApolloSurfaceView failed");
      }
    }
    StartupTracker.a("AIO_apolloSurface", null);
    CmShowStatUtil.a("aio_pre");
    IApolloExtensionHandler localIApolloExtensionHandler = (IApolloExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
    localIApolloExtensionHandler.d(this.sessionInfo.b);
    localIApolloExtensionHandler.e(this.sessionInfo.b);
    MemeHelper.a.a(false);
  }
  
  private void updateSession_business()
  {
    QQAppInterface localQQAppInterface = this.app;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.addObserver(this.cmShowActionObserver);
      this.app.addObserver(this.mApolloViewObserver);
    }
  }
  
  private void updateSession_initIntentData() {}
  
  public void addApolloBackgroundSurfaceView()
  {
    checkInitApolloViewController();
    this.mApolloViewController.d(this.chatPie);
  }
  
  public void addFooter(Message paramMessage)
  {
    this.apolloIsShowing = true;
    int i = Math.max(ViewUtils.dip2px(46.0F), paramMessage.arg1);
    this.chatPie.aV.a(i, false, "handleMsg_addFooter", 0);
  }
  
  public void checkInitApolloViewController()
  {
    if (this.mApolloViewController == null) {
      this.mApolloViewController = new ChatPieApolloViewController();
    }
  }
  
  public void doOnPanelChanged(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 18)
    {
      localObject = this.mApolloViewController;
      if (localObject != null)
      {
        ((ChatPieApolloViewController)localObject).a(true);
        this.mApolloViewController.d();
      }
    }
    int i = 0;
    if (paramInt2 == 18)
    {
      localObject = this.mApolloViewController;
      if (localObject != null)
      {
        ((ChatPieApolloViewController)localObject).c();
        this.mApolloViewController.a(false);
      }
    }
    Object localObject = (ISpriteUtil)QRoute.api(ISpriteUtil.class);
    if ((((ISpriteUtil)localObject).canUseCmShow(this.app, this.sessionInfo.a, this.sessionInfo.b)) && (!((ISpriteUtil)localObject).isSpriteHidden(this.app)))
    {
      localObject = ((ISpriteUtil)localObject).getActionScript(this.app);
      if (paramInt1 == 21)
      {
        if (localObject != null) {
          ((ISpriteActionScript)localObject).a(1);
        }
      }
      else if ((paramInt2 == 21) && (localObject != null)) {
        ((ISpriteActionScript)localObject).a(2);
      }
      if (localObject != null) {
        ((ISpriteActionScript)localObject).a(ApolloPanelUtil.a(), "tabStatusChange");
      }
      if (this.mApolloViewController != null)
      {
        paramInt1 = i;
        if (this.chatPie.U != null)
        {
          paramInt1 = i;
          if (this.chatPie.p != null)
          {
            paramInt1 = i;
            if (this.chatPie.Y != null) {
              paramInt1 = this.chatPie.U.getBottom() - this.chatPie.U.getPaddingBottom() - this.chatPie.p.getHeight() + this.chatPie.Y.getTop();
            }
          }
        }
        this.mApolloViewController.a(this.app, paramInt1);
      }
    }
  }
  
  public ChatPieApolloViewController getChatPieApolloViewController()
  {
    return this.mApolloViewController;
  }
  
  public String getTag()
  {
    return "[cmshow]ApolloAIOHelperImpl";
  }
  
  public boolean handleApolloMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    int k = 0;
    if (i != 47)
    {
      if (i != 48)
      {
        if (i != 61)
        {
          if (i != 62)
          {
            if (i != 65)
            {
              if (i != 77)
              {
                if (i != 79)
                {
                  if (i != 80)
                  {
                    if (i != 82)
                    {
                      if (i != 83) {
                        return false;
                      }
                      ((ApolloResponseManager)this.app.getManager(QQManagerFactory.APOLLO_RESPONSE_MANAGER)).a();
                      return true;
                    }
                    if ((paramMessage.obj instanceof ApolloActionData))
                    {
                      i = paramMessage.arg1;
                      String str = paramMessage.getData().getString("senderUin");
                      paramMessage = (ApolloActionData)paramMessage.obj;
                      ((ApolloResponseManager)this.app.getManager(QQManagerFactory.APOLLO_RESPONSE_MANAGER)).a(this.chatPie, paramMessage, i, str);
                      return true;
                    }
                  }
                  else
                  {
                    showApolloView(true);
                    return false;
                  }
                }
                else
                {
                  showApolloView(false);
                  return false;
                }
              }
              else
              {
                paramMessage = (String)paramMessage.obj;
                if (!TextUtils.isEmpty(paramMessage))
                {
                  QQToast.makeText(this.mContext, paramMessage, 0).show();
                  return true;
                }
              }
            }
            else
            {
              initApolloSurfaceView();
              return true;
            }
          }
          else
          {
            this.apolloIsShowing = false;
            this.chatPie.aV.a(1, 0);
            this.chatPie.aV.b();
            return true;
          }
        }
        else
        {
          addFooter(paramMessage);
          return true;
        }
      }
      else if (this.chatPie.Y != null)
      {
        this.chatPie.Y.setText("");
        return true;
      }
    }
    else
    {
      if (this.chatPie.aV.a() != null)
      {
        i = Math.max(ViewUtils.dip2px(46.0F), paramMessage.arg1);
        this.chatPie.aV.a(1, i);
        this.chatPie.aV.a(i, true, "handleMsg_showFooter", 0);
        return true;
      }
      if (1 != ((IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.app.getCurrentUin())) {
        i = 1;
      } else {
        i = 0;
      }
      int j = k;
      if (i != 0)
      {
        j = k;
        if (!((ISpriteUtil)QRoute.api(ISpriteUtil.class)).isSpriteHidden(this.app)) {
          j = 1;
        }
      }
      if (j == 0) {
        addFooter(paramMessage);
      }
    }
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return handleApolloMessage(paramMessage);
  }
  
  public void init(Object paramObject)
  {
    this.chatPie = ((BaseChatPie)paramObject);
    this.app = this.chatPie.d;
    this.mContext = this.chatPie.e;
    this.mActivity = this.chatPie.f;
    this.sessionInfo = this.chatPie.ah;
    this.mApolloViewObserver = new ChatApolloViewListener(this.chatPie);
    paramObject = this.chatPie.bv().d();
    if (paramObject != null)
    {
      paramObject.a(this);
      return;
    }
    QLog.e("[cmshow]ApolloAIOHelperImpl", 2, "[init] error! helperProvider is null!");
  }
  
  public void initApolloSurfaceView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloAIOHelperImpl", 2, "[initApolloSurfaceView]");
    }
    checkInitApolloViewController();
    this.mApolloViewController.c(this.chatPie);
  }
  
  public int[] interestedIn()
  {
    return new int[] { 0, 1, 2, 3, 4, 5, 9, 10, 11, 7, 13, 14, 15, 16, 17, 18 };
  }
  
  public boolean isApolloForward()
  {
    Activity localActivity = this.mActivity;
    return (localActivity != null) && (localActivity.getIntent() != null) && (this.mActivity.getIntent().getExtras() != null) && (this.mActivity.getIntent().getExtras().containsKey("apollo_forward_key"));
  }
  
  public void onAuthActionResponse(boolean paramBoolean, Object paramObject)
  {
    if ((this.app != null) && (this.mContext != null))
    {
      if (this.sessionInfo == null) {
        return;
      }
      if ((this.chatPie.ag != null) && (this.chatPie.ag.isShowing())) {
        this.chatPie.ag.dismiss();
      }
      Object localObject2 = (HashMap)paramObject;
      paramObject = (String)((Map)localObject2).get("optFrom");
      if (!TextUtils.isEmpty(paramObject))
      {
        if (!"actionAdd".equals(paramObject)) {
          return;
        }
        int m = Integer.parseInt((String)((Map)localObject2).get("id"));
        String str = (String)((Map)localObject2).get("actionText");
        if (!TextUtils.isEmpty((String)((Map)localObject2).get("textType"))) {
          i = Integer.parseInt((String)((Map)localObject2).get("textType"));
        } else {
          i = 0;
        }
        paramObject = (String)((Map)localObject2).get("audioId");
        int j;
        if (!TextUtils.isEmpty(paramObject)) {
          j = Integer.parseInt(paramObject);
        } else {
          j = 0;
        }
        float f = 0.0F;
        paramObject = (String)((Map)localObject2).get("audioTime");
        if (!TextUtils.isEmpty(paramObject)) {
          f = Float.parseFloat(paramObject);
        }
        paramObject = (String)((Map)localObject2).get("isPlayDefultAudio");
        int k;
        if (!TextUtils.isEmpty(paramObject)) {
          k = Integer.parseInt(paramObject);
        } else {
          k = 0;
        }
        paramObject = new ApolloFavActionData();
        paramObject.textType = i;
        paramObject.text = str;
        paramObject.actionId = m;
        paramObject.audioId = j;
        paramObject.audioStartTime = f;
        paramObject.playOriginalAudio = k;
        Object localObject1;
        if (paramBoolean)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("action auth success from add fav action=");
            ((StringBuilder)localObject1).append(paramObject.toString());
            QLog.d("[cmshow]ApolloAIOHelperImpl", 2, ((StringBuilder)localObject1).toString());
          }
          ApolloItemBuilder.a(this.app, this.mContext, paramObject, this.sessionInfo);
          return;
        }
        int i = Integer.parseInt((String)((Map)localObject2).get("ret"));
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("action auth fail from fav add action=");
          ((StringBuilder)localObject1).append(paramObject.toString());
          ((StringBuilder)localObject1).append(" errcode = ");
          ((StringBuilder)localObject1).append(i);
          QLog.d("[cmshow]ApolloAIOHelperImpl", 2, ((StringBuilder)localObject1).toString());
        }
        if (i != 1002)
        {
          Object localObject3;
          switch (i)
          {
          default: 
            localObject1 = this.mContext.getResources().getString(2131886696);
            paramObject = this.mContext.getResources().getString(2131886696);
            if (QLog.isColorLevel()) {
              QLog.d("[cmshow]ApolloAIOHelperImpl", 2, "unknown action auth errcode");
            }
            localObject3 = null;
            localObject2 = "";
            break;
          case 31006: 
            localObject1 = (String)((Map)localObject2).get("content");
            paramObject = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramObject = this.mContext.getResources().getString(2131886688);
            }
            localObject1 = (String)((Map)localObject2).get("url");
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("&actionid=");
            ((StringBuilder)localObject2).append(m);
            localObject3 = ((StringBuilder)localObject2).toString();
            localObject1 = this.mContext.getResources().getString(2131886687);
            localObject2 = this.mContext.getResources().getString(2131886687);
            localObject3 = new ApolloAIOHelperImpl.2(this, (String)localObject3, m);
            QQAppInterface localQQAppInterface = this.app;
            i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.sessionInfo.a);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("");
            localStringBuilder.append(m);
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "activity_alert_show", i, 0, new String[] { localStringBuilder.toString(), "1" });
            this.mApolloDialog = DialogUtil.a(this.mActivity, 0, (String)localObject1, paramObject, this.mContext.getResources().getString(2131892733), (String)localObject2, (DialogInterface.OnClickListener)localObject3, new ApolloAIOHelperImpl.3(this));
            if (!this.mActivity.isFinishing()) {
              this.mApolloDialog.show();
            }
            localObject1 = this.app;
            localObject2 = this.sessionInfo.b;
            i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.sessionInfo.a);
            paramObject = new StringBuilder();
            paramObject.append("");
            paramObject.append(m);
            localObject3 = paramObject.toString();
            paramObject = str;
            if (TextUtils.isEmpty(str)) {
              paramObject = "0";
            }
            VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "add_action", (String)localObject2, i, 0, new String[] { localObject3, "", paramObject, String.valueOf(System.currentTimeMillis() / 1000L) });
            return;
          }
          QZoneVipInfoManager.a((Activity)this.mContext, this.app.getCurrentUin(), "lmx_actchat");
          return;
        }
        QQToast.makeText(this.mContext.getApplicationContext(), 1, this.mContext.getResources().getString(2131886671), 0).show(this.mContext.getResources().getDimensionPixelSize(2131299920));
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloAIOHelperImpl", 2, "fav action network error");
        }
      }
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    case 8: 
    default: 
      break;
    case 18: 
      onScrollStateChanged(0);
      break;
    case 17: 
      onScrollStateChanged(2);
      break;
    case 16: 
      onScrollStateChanged(1);
      break;
    case 15: 
      doOnDestroy();
      break;
    case 14: 
      finish();
      break;
    case 13: 
      onPreFinish();
      break;
    case 12: 
      doOnStop();
      break;
    case 11: 
      doOnPause();
      break;
    case 10: 
      onShow();
      break;
    case 9: 
      onShowFirst();
      break;
    case 7: 
      onResume();
      break;
    case 5: 
      doOnStart();
      break;
    case 4: 
      doOnUpdateSession_otherThings();
      break;
    case 3: 
      updateSession_business();
      break;
    case 2: 
      updateSession_initIntentData();
      break;
    case 1: 
      doOnCreate_initData();
      break;
    case 0: 
      doOnCreate_initUI();
    }
    ApolloPanelProviderImpl localApolloPanelProviderImpl = ApolloUtilImpl.getApolloPanelProvider(this.chatPie);
    if (localApolloPanelProviderImpl != null) {
      localApolloPanelProviderImpl.onMoveToState(paramInt);
    }
  }
  
  public void showApolloView(boolean paramBoolean)
  {
    ChatPieApolloViewController localChatPieApolloViewController = this.mApolloViewController;
    if (localChatPieApolloViewController != null) {
      localChatPieApolloViewController.a(paramBoolean);
    }
  }
  
  public void updateSession_checkUpdateFooterView()
  {
    if ((this.chatPie instanceof RobotChatPie)) {
      return;
    }
    StartupTracker.a(null, "AIO_apolloFooterview");
    this.sessionInfo.a = this.mActivity.getIntent().getIntExtra("uintype", -1);
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.app.getRuntimeService(IApolloManagerService.class, "all");
    ISpriteUtil localISpriteUtil = (ISpriteUtil)QRoute.api(ISpriteUtil.class);
    int i;
    if ((localIApolloManagerService.isInitDone()) && (1 == localIApolloManagerService.getApolloStatus(this.app.getCurrentUin())) && (!((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(this.sessionInfo.b)) && (!localISpriteUtil.isSpriteHidden(this.app)) && (localISpriteUtil.canUseCmShow(this.app, this.sessionInfo.a, this.sessionInfo.b)))
    {
      int j = localISpriteUtil.getWaitingMargin(this.mContext);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("[cmshow]ApolloAIOHelperImpl", 2, new Object[] { "add apollo footerview on init UI, footerHeight:", Integer.valueOf(j) });
        i = j;
      }
    }
    else
    {
      i = 0;
    }
    if (i > 0) {
      this.chatPie.aV.a(i, false, "initUI", 0);
    }
    StartupTracker.a("AIO_apolloFooterview", null);
  }
  
  public boolean validateCmShowFun()
  {
    if ((this.chatPie instanceof GameRoomChatPie)) {
      return false;
    }
    checkInitApolloViewController();
    return this.mApolloViewController.b(this.chatPie);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.api.impl.ApolloAIOHelperImpl
 * JD-Core Version:    0.7.0.1
 */