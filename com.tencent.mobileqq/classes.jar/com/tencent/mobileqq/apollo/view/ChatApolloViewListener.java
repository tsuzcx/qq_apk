package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.IAioAnimListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.apollo.aio.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanel;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.game.api.IApolloGameManager;
import com.tencent.mobileqq.apollo.game.api.impl.ApolloGameManagerImpl;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.player.CMSHelper;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.mobileqq.apollo.statistics.CmShowStatUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.task.ApolloAioBubblePush;
import com.tencent.mobileqq.apollo.task.ApolloBubbleLogic;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.render.ISurfaceStateListener;
import com.tencent.mobileqq.cmshow.engine.render.ITouchListener;
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
import mqq.os.MqqHandler;

public class ChatApolloViewListener
  extends ApolloExtensionObserver
  implements View.OnClickListener, IAioAnimListener, ISurfaceStateListener, ITouchListener
{
  public WeakReference<BaseChatPie> a;
  public boolean a;
  
  public ChatApolloViewListener(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Boolean = false;
    if (((paramBaseChatPie instanceof FriendChatPie)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof DiscussChatPie)) || ((paramBaseChatPie instanceof HotChatPie)) || ((paramBaseChatPie instanceof StrangerChatPie)) || ((paramBaseChatPie instanceof LimitChatPie))) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    }
  }
  
  private boolean a(int paramInt, String paramString)
  {
    QLog.d("[cmshow]ChatApolloViewListener", 1, new Object[] { "onPetBrandClick petId=", Integer.valueOf(paramInt) });
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return false;
    }
    localObject = (BaseChatPie)((WeakReference)localObject).get();
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
        return false;
      }
      return QZoneVipInfoManager.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramInt, paramString);
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    QLog.d("[cmshow]ChatApolloViewListener", 1, "onSuperYellowBrandClick");
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return false;
    }
    localObject = (BaseChatPie)((WeakReference)localObject).get();
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
        return false;
      }
      return QZoneVipInfoManager.b(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramString);
    }
    return false;
  }
  
  private boolean b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ChatApolloViewListener", 1, new Object[] { "onPetClick petId=", Integer.valueOf(paramInt) });
    }
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return false;
    }
    localObject = (BaseChatPie)((WeakReference)localObject).get();
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) {
        return false;
      }
      return QZoneVipInfoManager.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramString);
    }
    return false;
  }
  
  public void a() {}
  
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
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null)
    {
      QLog.w("[cmshow]ChatApolloViewListener", 2, "[onSurfaceReady] error, mChatPieRef is null!");
      return;
    }
    localObject = (BaseChatPie)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ISpriteScriptManager localISpriteScriptManager = (ISpriteScriptManager)((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
    if (localISpriteScriptManager.getSpriteContext() != null) {
      TraceReportUtil.a(TraceReportUtil.a(localISpriteScriptManager.getSpriteContext().a()), 100, 0, new Object[] { "onSurfaceReady" });
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
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return;
    }
    QLog.d("[cmshow]ChatApolloViewListener", 1, new Object[] { "onNotifyStatusChanged clickPart=", Integer.valueOf(paramInt) });
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
        return;
      }
      Object localObject = ApolloUtilImpl.getChatPieApolloViewController(localBaseChatPie);
      if (localObject != null)
      {
        if (!((ChatPieApolloViewController)localObject).a()) {
          return;
        }
        paramString = ApolloUtilImpl.getUinFromApolloId(paramString);
        if (paramInt != 7)
        {
          ApolloDress localApolloDress;
          switch (paramInt)
          {
          default: 
            break;
          case 12: 
            localObject = ((ApolloDaoManagerServiceImpl)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString);
            if (localObject == null) {
              break;
            }
            localApolloDress = ((ApolloBaseInfo)localObject).getApolloPetDress();
            if ((localApolloDress == null) || (!((ApolloBaseInfo)localObject).hasPet) || (localApolloDress.dressMap == null) || (localApolloDress.dressMap.isEmpty())) {
              break;
            }
            bool = b(localApolloDress.roleId, paramString);
            break;
          case 11: 
            localObject = ((ApolloDaoManagerServiceImpl)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString);
            if (localObject == null) {
              break;
            }
            localApolloDress = ((ApolloBaseInfo)localObject).getApolloPetDress();
            if ((localApolloDress == null) || (!((ApolloBaseInfo)localObject).hasPet) || (localApolloDress.dressMap == null) || (localApolloDress.dressMap.isEmpty())) {
              break;
            }
            bool = a(localApolloDress.roleId, paramString);
            break;
          case 10: 
            if (!((ApolloManagerServiceImpl)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isSuperYellow(paramString)) {
              break;
            }
            bool = a(paramString);
            break;
          }
        }
        else
        {
          localObject = (ApolloGameManagerImpl)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloGameManager.class, "all");
          if (((ApolloGameManagerImpl)localObject).mBubblePush != null)
          {
            localObject = ((ApolloGameManagerImpl)localObject).mBubblePush.a();
            if ((localObject != null) && ((((DrawerPushItem)localObject).msg_type == 10) || (((DrawerPushItem)localObject).msg_type == 7))) {
              ApolloTianshuReportUtil.a(102, String.valueOf(((DrawerPushItem)localObject).tianshuAdId), ((DrawerPushItem)localObject).tianshuTraceInfo);
            }
          }
        }
        boolean bool = false;
        if (bool)
        {
          QLog.d("[cmshow]ChatApolloViewListener", 1, "onNotifyStatusChanged click intercept");
          return;
        }
        localObject = SpriteUtil.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localObject != null) {
          ((SpriteActionScript)localObject).a(SpriteUtil.a(paramInt), null, paramString);
        }
        paramString = (SpriteScriptManagerImpl)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
        if (paramString == null) {
          return;
        }
        paramString = paramString.getBubbleLogic();
        if (paramString == null) {
          return;
        }
        int i = paramString.a();
        paramString = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp", 0);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("is_add_new_game");
        ((StringBuilder)localObject).append(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        bool = paramString.getBoolean(((StringBuilder)localObject).toString(), false);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("new_added_game_id");
        ((StringBuilder)localObject).append(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        int j = paramString.getInt(((StringBuilder)localObject).toString(), -1);
        if (9 == paramInt) {
          VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "click_action_hotspot", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[0]);
        }
        if (i == 1)
        {
          if ((bool) && (-1 != j))
          {
            VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "avatar_clk_togame", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 1, new String[] { String.valueOf(j) });
            paramString = paramString.edit();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("is_add_new_game");
            ((StringBuilder)localObject).append(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            paramString.remove(((StringBuilder)localObject).toString()).commit();
          }
        }
        else if (i == 2)
        {
          paramString = ApolloUtilImpl.getApolloPanel(localBaseChatPie);
          if (paramString != null) {
            paramString.g();
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    Object localObject1 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    if ((!TextUtils.isEmpty(paramString)) && (((ITroopAvatarUtilApi)localObject1).isNumeric(paramString)))
    {
      localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 == null) {
        return;
      }
      BaseChatPie localBaseChatPie = (BaseChatPie)((WeakReference)localObject1).get();
      if ((localBaseChatPie != null) && (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
      {
        if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
          return;
        }
        Object localObject2 = ApolloUtilImpl.getChatPieApolloViewController(localBaseChatPie);
        if (localObject2 != null)
        {
          if (!((ChatPieApolloViewController)localObject2).a()) {
            return;
          }
          if (!NetworkUtil.isNetworkAvailable(localBaseChatPie.jdField_a_of_type_AndroidContentContext))
          {
            ApolloItemBuilder.a(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131690023), 1, localBaseChatPie.jdField_a_of_type_AndroidContentContext);
            return;
          }
          localObject1 = (ISpriteScriptManager)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
          if (localObject1 != null)
          {
            localObject1 = ((ISpriteScriptManager)localObject1).getTaskHandler();
            if ((localObject1 != null) && (((ISpriteTaskHandler)localObject1).a())) {
              return;
            }
          }
          Object localObject3 = (ApolloManagerServiceImpl)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
          QQAppInterface localQQAppInterface = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          String str = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          localObject1 = "";
          VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "long_press_avatar", str, i, 0, new String[] { "0", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
          ApolloDtReportUtil.a("aio", "sprite", "long_click", new DtReportParamsBuilder().a(ApolloDtReportUtil.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)).d(paramString.equals(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()) ^ true).b(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
          if (((ApolloManagerServiceImpl)localObject3).getApolloStatus(paramString) != 1)
          {
            ApolloItemBuilder.a(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131690074), 1, localBaseChatPie.jdField_a_of_type_AndroidContentContext);
            return;
          }
          if (((ApolloManagerServiceImpl)localObject3).getCmShowStatus(paramString) == 2) {
            return;
          }
          if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
            localObject1 = ContactUtils.f(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
          } else if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
            localObject1 = ContactUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString);
          } else if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
            localObject1 = ContactUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, true);
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
          ((ChatPieApolloViewController)localObject2).b();
          localObject2 = new Intent(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, ApolloGuestsStateActivity.class);
          ((Intent)localObject2).putExtra("extra_guest_uin", paramString);
          ((Intent)localObject2).putExtra("extra_guest_nick", (String)localObject1);
          ((Intent)localObject2).putExtra("extra_guest_from", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
          localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject2);
        }
      }
      return;
    }
    QLog.w("[cmshow]ChatApolloViewListener", 1, "longTouch uin = null");
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setAIOFinish to ");
    localStringBuilder.append(paramBoolean);
    QLog.w("[cmshow]ChatApolloViewListener", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = paramBoolean;
    CMSHelper.a.a(paramBoolean);
  }
  
  public void b() {}
  
  protected void b(boolean paramBoolean, Object paramObject)
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
  
  protected void e(boolean paramBoolean, Object paramObject)
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
      localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject1 == null) {
        return;
      }
      localObject1 = (BaseChatPie)((WeakReference)localObject1).get();
      if ((localObject1 != null) && (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        if (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          return;
        }
        Object localObject2 = ApolloUtilImpl.getApolloPanel((BaseChatPie)localObject1);
        if (localObject2 != null) {
          ((ApolloPanel)localObject2).a(paramBoolean, paramObject);
        }
        localObject2 = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject2 != null) {
          ((MqqHandler)localObject2).obtainMessage(51).sendToTarget();
        }
        paramObject = (Pair)paramObject;
        if (((String)paramObject.first).equals(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("my cmshow status has changed, status:");
          ((StringBuilder)localObject2).append(paramObject.second);
          QLog.i("[cmshow]ChatApolloViewListener", 1, ((StringBuilder)localObject2).toString());
          if ((2 != ((Integer)paramObject.second).intValue()) && (((Integer)paramObject.second).intValue() != 0))
          {
            if (1 == ((Integer)paramObject.second).intValue()) {
              ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(((BaseChatPie)localObject1).a(), "cmshow_status", false);
            }
          }
          else {
            ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(((BaseChatPie)localObject1).a(), "cmshow_status", true);
          }
        }
      }
    }
  }
  
  protected void i(boolean paramBoolean, Object paramObject)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject == null) {
      return;
    }
    localObject = (BaseChatPie)((WeakReference)localObject).get();
    if (localObject != null)
    {
      if (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      paramView.getId();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ChatApolloViewListener
 * JD-Core Version:    0.7.0.1
 */