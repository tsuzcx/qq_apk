package com.tencent.mobileqq.apollo.aio;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanel;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.bubble.ApolloAioBubblePush;
import com.tencent.mobileqq.apollo.bubble.ApolloBubbleLogic;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData;
import com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData.From;
import com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData.ReportParams;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.mobileqq.apollo.statistics.CmShowStatUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.render.ISurfaceStateListener;
import com.tencent.mobileqq.cmshow.engine.render.ITouchListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.vip.manager.QZoneVipInfoManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ChatApolloViewListener
  extends ApolloExtensionObserver
  implements ISurfaceStateListener, ITouchListener
{
  private WeakReference<BaseChatPie> a;
  
  public ChatApolloViewListener(BaseChatPie paramBaseChatPie)
  {
    if (((paramBaseChatPie instanceof FriendChatPie)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof DiscussChatPie)) || ((paramBaseChatPie instanceof HotChatPie)) || ((paramBaseChatPie instanceof StrangerChatPie)) || ((paramBaseChatPie instanceof LimitChatPie))) {
      this.a = new WeakReference(paramBaseChatPie);
    }
  }
  
  private void a(@NonNull BaseChatPie paramBaseChatPie, int paramInt, String paramString)
  {
    Object localObject = SpriteUtil.i(paramBaseChatPie.d);
    if (localObject != null) {
      ((SpriteActionScript)localObject).a(SpriteUtil.a(paramInt), null, paramString);
    }
    localObject = (SpriteScriptManagerImpl)paramBaseChatPie.d.getRuntimeService(ISpriteScriptManager.class, "all");
    if (localObject == null) {
      return;
    }
    localObject = ((SpriteScriptManagerImpl)localObject).getBubbleLogic();
    if (localObject == null) {
      return;
    }
    int i = ((ApolloBubbleLogic)localObject).a();
    localObject = paramBaseChatPie.d.getApp().getSharedPreferences("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_add_new_game");
    localStringBuilder.append(paramBaseChatPie.d.getCurrentAccountUin());
    boolean bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("new_added_game_id");
    localStringBuilder.append(paramBaseChatPie.d.getCurrentAccountUin());
    int j = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), -1);
    if (9 == paramInt) {
      VipUtils.a(paramBaseChatPie.d, "cmshow", "Apollo", "click_action_hotspot", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramBaseChatPie.ah.a), 0, new String[0]);
    }
    if (i == 1)
    {
      a(paramBaseChatPie, paramString);
      if ((bool) && (-1 != j))
      {
        VipUtils.a(paramBaseChatPie.d, "cmshow", "Apollo", "avatar_clk_togame", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(paramBaseChatPie.ah.a), 1, new String[] { String.valueOf(j) });
        paramString = ((SharedPreferences)localObject).edit();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("is_add_new_game");
        ((StringBuilder)localObject).append(paramBaseChatPie.d.getCurrentAccountUin());
        paramString.remove(((StringBuilder)localObject).toString()).commit();
      }
    }
    else if (i == 2)
    {
      paramBaseChatPie = ApolloUtilImpl.getApolloPanel(paramBaseChatPie);
      if (paramBaseChatPie != null) {
        paramBaseChatPie.g();
      }
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie, long paramLong, ApolloActionData paramApolloActionData)
  {
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)paramBaseChatPie.d.getRuntimeService(IApolloManagerService.class, "all");
    ApolloCmQQStatusData.ReportParams localReportParams = new ApolloCmQQStatusData.ReportParams();
    localReportParams.actionId = paramApolloActionData.actionId;
    localReportParams.personNum = paramApolloActionData.personNum;
    localReportParams.timestamp = String.valueOf(System.currentTimeMillis());
    localReportParams.entry = ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getReportSessionType(paramBaseChatPie.ah.a);
    localReportParams.mode = ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getApolloMode(paramBaseChatPie.d);
    localReportParams.type = 0;
    localReportParams.ownerStatus = ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).getUserStatus(paramBaseChatPie.d);
    if (paramBaseChatPie.ah.a == 0) {
      paramApolloActionData = paramBaseChatPie.ah.b;
    } else {
      paramApolloActionData = paramBaseChatPie.ah.c;
    }
    localReportParams.peerUin = paramApolloActionData;
    localReportParams.peerStatus = localApolloManagerServiceImpl.getApolloStatus(localReportParams.peerUin);
    localReportParams.qqUin = paramBaseChatPie.d.getCurrentUin();
    localReportParams.duration = String.valueOf(System.currentTimeMillis() - paramLong);
    ApolloCmQQStatusData.report(ApolloCmQQStatusData.From.AIO, localReportParams);
  }
  
  private void a(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo, String paramString)
  {
    if ((paramBaseChatPie != null) && (paramBaseChatPie.d != null))
    {
      if (paramBaseChatPie.aE() == null) {
        return;
      }
      SessionInfo localSessionInfo = paramBaseChatPie.aE();
      ApolloActionData localApolloActionData = paramApolloInfo.mAction;
      SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
      localSpriteTaskParam.f = localApolloActionData.actionId;
      localSpriteTaskParam.c = 0;
      localSpriteTaskParam.i = localSessionInfo.a;
      localSpriteTaskParam.g = 3;
      localSpriteTaskParam.h = -10000L;
      localSpriteTaskParam.m = 0;
      localSpriteTaskParam.n = 0.0F;
      int i = paramApolloInfo.mTextType;
      int j = 1;
      boolean bool;
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localSpriteTaskParam.q = bool;
      localSpriteTaskParam.o = paramApolloInfo.mActionText;
      localSpriteTaskParam.e = localApolloActionData.personNum;
      localSpriteTaskParam.j = String.valueOf(paramString);
      if (CmShowAioMatcherImpl.judgeSupported(localSessionInfo.a, 1))
      {
        paramApolloInfo = paramString;
        if (paramString.equals(paramBaseChatPie.d.getCurrentUin())) {
          paramApolloInfo = localSessionInfo.b;
        }
        localSpriteTaskParam.k = paramApolloInfo;
      }
      else if (localSpriteTaskParam.e != 0)
      {
        paramApolloInfo = ((FriendsManager)paramBaseChatPie.d.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramString);
        i = j;
        if (paramApolloInfo != null) {
          if (paramApolloInfo.gender == 1) {
            i = j;
          } else {
            i = 0;
          }
        }
        if (i != 0) {
          paramApolloInfo = "-2";
        } else {
          paramApolloInfo = "-1";
        }
        localSpriteTaskParam.k = paramApolloInfo;
      }
      paramBaseChatPie = (ISpriteScriptManager)paramBaseChatPie.d.getRuntimeService(ISpriteScriptManager.class, "all");
      if (paramBaseChatPie != null) {
        paramBaseChatPie.getSpriteBridge().b(localSpriteTaskParam);
      }
    }
  }
  
  private void a(BaseChatPie paramBaseChatPie, String paramString)
  {
    Object localObject2 = (IApolloDaoManagerService)paramBaseChatPie.d.getRuntimeService(IApolloDaoManagerService.class, "all");
    Object localObject1 = ((IApolloDaoManagerService)localObject2).getApolloBaseInfo(paramString);
    if (localObject1 != null)
    {
      if (((ApolloBaseInfo)localObject1).apolloCmQQStatusData == null) {
        return;
      }
      localObject1 = ((ApolloBaseInfo)localObject1).apolloCmQQStatusData;
      localObject2 = ((IApolloDaoManagerService)localObject2).findActionById(((ApolloCmQQStatusData)localObject1).apolloQQAct);
      ApolloInfo localApolloInfo = new ApolloInfo();
      localApolloInfo.mAction = ((ApolloActionData)localObject2);
      if (localObject2 != null)
      {
        if (!((ApolloCmQQStatusData)localObject1).shouldShowQQCmshowStatusAction(ApolloCmQQStatusData.From.AIO)) {
          return;
        }
        ThreadManager.getUIHandler().postDelayed(new ChatApolloViewListener.3(this, paramBaseChatPie, localApolloInfo, paramString, (ApolloCmQQStatusData)localObject1, (ApolloActionData)localObject2), 1000L);
      }
    }
  }
  
  private boolean a(BaseChatPie paramBaseChatPie)
  {
    return (paramBaseChatPie == null) || (paramBaseChatPie.d == null) || (paramBaseChatPie.ah == null);
  }
  
  private boolean a(@NonNull AppRuntime paramAppRuntime, String paramString)
  {
    if (((ApolloManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all")).isSuperYellow(paramString)) {
      return b(paramString);
    }
    return false;
  }
  
  private boolean b(int paramInt, String paramString)
  {
    QLog.d("[cmshow]ChatApolloViewListener", 1, new Object[] { "onPetBrandClick petId=", Integer.valueOf(paramInt) });
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    localObject = (BaseChatPie)((WeakReference)localObject).get();
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).f == null) {
        return false;
      }
      return QZoneVipInfoManager.a(((BaseChatPie)localObject).f, paramInt, paramString);
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    QLog.d("[cmshow]ChatApolloViewListener", 1, "onSuperYellowBrandClick");
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    localObject = (BaseChatPie)((WeakReference)localObject).get();
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).f == null) {
        return false;
      }
      return QZoneVipInfoManager.b(((BaseChatPie)localObject).f, paramString);
    }
    return false;
  }
  
  private boolean b(@NonNull AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = ((ApolloDaoManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString);
    if (paramAppRuntime != null)
    {
      ApolloDress localApolloDress = paramAppRuntime.getApolloPetDress();
      if ((localApolloDress != null) && (paramAppRuntime.hasPet) && (localApolloDress.dressMap != null) && (!localApolloDress.dressMap.isEmpty())) {
        return b(localApolloDress.roleId, paramString);
      }
    }
    return false;
  }
  
  private boolean c(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ChatApolloViewListener", 1, new Object[] { "onPetClick petId=", Integer.valueOf(paramInt) });
    }
    Object localObject = this.a;
    if (localObject == null) {
      return false;
    }
    localObject = (BaseChatPie)((WeakReference)localObject).get();
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).f == null) {
        return false;
      }
      return QZoneVipInfoManager.a(((BaseChatPie)localObject).f, ((BaseChatPie)localObject).d, paramInt, paramString);
    }
    return false;
  }
  
  private boolean c(@NonNull AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = ((ApolloDaoManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString);
    if (paramAppRuntime != null)
    {
      ApolloDress localApolloDress = paramAppRuntime.getApolloPetDress();
      if ((localApolloDress != null) && (paramAppRuntime.hasPet) && (localApolloDress.dressMap != null) && (!localApolloDress.dressMap.isEmpty())) {
        return c(localApolloDress.roleId, paramString);
      }
    }
    return false;
  }
  
  private boolean d(@NonNull AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = (ApolloGameManagerImpl)paramAppRuntime.getRuntimeService(IApolloGameManager.class, "all");
    if (paramAppRuntime.mBubblePush != null)
    {
      paramAppRuntime = paramAppRuntime.mBubblePush.a();
      if ((paramAppRuntime != null) && ((paramAppRuntime.msg_type == 10) || (paramAppRuntime.msg_type == 7))) {
        ApolloTianshuReportUtil.a(102, String.valueOf(paramAppRuntime.tianshuAdId), paramAppRuntime.tianshuTraceInfo);
      }
    }
    return false;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[TraceReport onSurfaceReady], w:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",h:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("[cmshow]ChatApolloViewListener", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    if (localObject == null)
    {
      QLog.w("[cmshow]ChatApolloViewListener", 2, "[onSurfaceReady] error, mChatPieRef is null!");
      return;
    }
    localObject = (BaseChatPie)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ISpriteScriptManager localISpriteScriptManager = (ISpriteScriptManager)((BaseChatPie)localObject).d.getRuntimeService(ISpriteScriptManager.class, "all");
    if (localISpriteScriptManager.getSpriteContext() != null) {
      TraceReportUtil.a(TraceReportUtil.c(localISpriteScriptManager.getSpriteContext().e()), 100, 0, new Object[] { "onSurfaceReady" });
    }
    if (ApolloUtilImpl.getChatPieApolloViewController((BaseChatPie)localObject) == null)
    {
      QLog.e("[cmshow]ChatApolloViewListener", 1, "TraceReport CmShowStatUtil onSurfaceReady mPreloadEngine:false. apolloViewController is null!");
      return;
    }
    CmShowStatUtil.a("TraceReport_initApolloSurfaceView_PreLoadJS");
    ThreadManager.excute(new ChatApolloViewListener.1(this), 192, null, true);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.a == null) {
      return;
    }
    boolean bool = false;
    QLog.d("[cmshow]ChatApolloViewListener", 1, new Object[] { "onTouch clickPart=", Integer.valueOf(paramInt) });
    BaseChatPie localBaseChatPie = (BaseChatPie)this.a.get();
    if (a(localBaseChatPie)) {
      return;
    }
    ChatPieApolloViewController localChatPieApolloViewController = ApolloUtilImpl.getChatPieApolloViewController(localBaseChatPie);
    if (localChatPieApolloViewController != null)
    {
      if (!localChatPieApolloViewController.a()) {
        return;
      }
      paramString = ApolloUtilImpl.getUinFromApolloId(paramString);
      if (paramInt != 7) {
        switch (paramInt)
        {
        default: 
          break;
        case 12: 
          bool = c(localBaseChatPie.d, paramString);
          break;
        case 11: 
          bool = b(localBaseChatPie.d, paramString);
          break;
        case 10: 
          bool = a(localBaseChatPie.d, paramString);
          break;
        }
      } else {
        d(localBaseChatPie.d, paramString);
      }
      if (bool)
      {
        QLog.d("[cmshow]ChatApolloViewListener", 1, "onNotifyStatusChanged click intercept");
        return;
      }
      a(localBaseChatPie, paramInt, paramString);
    }
  }
  
  public void a(String paramString)
  {
    Object localObject1 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    if ((!TextUtils.isEmpty(paramString)) && (((ITroopAvatarUtilApi)localObject1).isNumeric(paramString)))
    {
      localObject1 = this.a;
      if (localObject1 == null) {
        return;
      }
      BaseChatPie localBaseChatPie = (BaseChatPie)((WeakReference)localObject1).get();
      if ((localBaseChatPie != null) && (localBaseChatPie.d != null))
      {
        if (localBaseChatPie.ah == null) {
          return;
        }
        Object localObject2 = ApolloUtilImpl.getChatPieApolloViewController(localBaseChatPie);
        if (localObject2 != null)
        {
          if (!((ChatPieApolloViewController)localObject2).a()) {
            return;
          }
          if (!NetworkUtil.isNetworkAvailable(localBaseChatPie.e))
          {
            ApolloItemBuilder.a(localBaseChatPie.e.getString(2131886672), 1, localBaseChatPie.e);
            return;
          }
          localObject1 = (ISpriteScriptManager)localBaseChatPie.d.getRuntimeService(ISpriteScriptManager.class, "all");
          if (localObject1 != null)
          {
            localObject1 = ((ISpriteScriptManager)localObject1).getTaskHandler();
            if ((localObject1 != null) && (((ISpriteTaskHandler)localObject1).c())) {
              return;
            }
          }
          Object localObject3 = (ApolloManagerServiceImpl)localBaseChatPie.d.getRuntimeService(IApolloManagerService.class, "all");
          QQAppInterface localQQAppInterface = localBaseChatPie.d;
          String str = localBaseChatPie.ah.b;
          int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(localBaseChatPie.ah.a);
          localObject1 = "";
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "long_press_avatar", str, i, 0, new String[] { "0", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
          ApolloDtReportUtil.a("aio", "sprite", "long_click", new DtReportParamsBuilder().a(ApolloDtReportUtil.a(localBaseChatPie.d)).b(ApolloDtReportUtil.a(localBaseChatPie.ah.a)).d(paramString.equals(localBaseChatPie.d.getAccount()) ^ true).c(localBaseChatPie.ah.b).a());
          if (((ApolloManagerServiceImpl)localObject3).getApolloStatus(paramString) != 1)
          {
            ApolloItemBuilder.a(localBaseChatPie.e.getString(2131886726), 1, localBaseChatPie.e);
            return;
          }
          if (((ApolloManagerServiceImpl)localObject3).getCmShowStatus(paramString) == 2) {
            return;
          }
          if (localBaseChatPie.ah.a == 0) {
            localObject1 = ContactUtils.g(localBaseChatPie.d, paramString);
          } else if (localBaseChatPie.ah.a == 1) {
            localObject1 = ContactUtils.a(localBaseChatPie.d, localBaseChatPie.ah.b, paramString);
          } else if (localBaseChatPie.ah.a == 3000) {
            localObject1 = ContactUtils.a(localBaseChatPie.d, paramString, true);
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("onLoncClick uin = ");
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append(" ,nickName =");
            ((StringBuilder)localObject3).append((String)localObject1);
            QLog.d("[cmshow]ChatApolloViewListener", 2, ((StringBuilder)localObject3).toString());
          }
          ((ChatPieApolloViewController)localObject2).c();
          localObject2 = new Intent(localBaseChatPie.f, ApolloGuestsStateActivity.class);
          ((Intent)localObject2).putExtra("extra_guest_uin", paramString);
          ((Intent)localObject2).putExtra("extra_guest_nick", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_guest_from", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(localBaseChatPie.ah.a));
          localBaseChatPie.f.startActivity((Intent)localObject2);
        }
      }
      return;
    }
    QLog.w("[cmshow]ChatApolloViewListener", 1, "longTouch uin = null");
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onApolloDressChange], result:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",data:");
      localStringBuilder.append(paramObject);
      QLog.d("[cmshow]ChatApolloViewListener", 2, localStringBuilder.toString());
    }
    ThreadManager.post(new ChatApolloViewListener.2(this, paramBoolean, paramObject), 5, null, true);
  }
  
  protected void b(boolean paramBoolean, Object paramObject)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TROOP, [onChangeUserApolloStatus], result:");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(",data:");
      ((StringBuilder)localObject1).append(paramObject);
      QLog.d("[cmshow]ChatApolloViewListener", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramBoolean)
    {
      if (paramObject == null) {
        return;
      }
      localObject1 = this.a;
      if (localObject1 == null) {
        return;
      }
      localObject1 = (BaseChatPie)((WeakReference)localObject1).get();
      if ((localObject1 != null) && (((BaseChatPie)localObject1).ah != null))
      {
        if (((BaseChatPie)localObject1).d == null) {
          return;
        }
        Object localObject2 = ApolloUtilImpl.getApolloPanel((BaseChatPie)localObject1);
        if (localObject2 != null) {
          ((ApolloPanel)localObject2).a(paramBoolean, paramObject);
        }
        localObject2 = ((BaseChatPie)localObject1).d.getHandler(ChatActivity.class);
        if (localObject2 != null) {
          ((MqqHandler)localObject2).obtainMessage(51).sendToTarget();
        }
        paramObject = (Pair)paramObject;
        if (((String)paramObject.first).equals(((BaseChatPie)localObject1).d.getCurrentUin()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("my cmshow status has changed, status:");
          ((StringBuilder)localObject2).append(paramObject.second);
          QLog.i("[cmshow]ChatApolloViewListener", 1, ((StringBuilder)localObject2).toString());
          if ((2 != ((Integer)paramObject.second).intValue()) && (((Integer)paramObject.second).intValue() != 0))
          {
            if (1 == ((Integer)paramObject.second).intValue()) {
              ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(((BaseChatPie)localObject1).i(), "cmshow_status", false);
            }
          }
          else {
            ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(((BaseChatPie)localObject1).i(), "cmshow_status", true);
          }
        }
      }
    }
  }
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      ApolloManagerServiceImpl.sFirstOpenPanel = true;
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ChatApolloViewListener", 2, "onQueryUserApolloAction mChatPieRef == null return");
      }
      return;
    }
    localObject = (BaseChatPie)((WeakReference)localObject).get();
    if (localObject != null)
    {
      localObject = ApolloUtilImpl.getApolloPanel((BaseChatPie)localObject);
      if (localObject != null) {
        ((ApolloPanel)localObject).b(paramBoolean, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ChatApolloViewListener
 * JD-Core Version:    0.7.0.1
 */