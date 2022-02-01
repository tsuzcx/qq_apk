package com.tencent.mobileqq.apollo.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JDHongbaoActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.IAioAnimListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.api.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.api.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloDress;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.api.script.ISpriteContext;
import com.tencent.mobileqq.apollo.api.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity;
import com.tencent.mobileqq.apollo.task.ApolloAioBubblePush;
import com.tencent.mobileqq.apollo.task.ApolloBubbleLogic;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.CmShowStatUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;
import cooperation.qzone.QZoneVipInfoManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.os.MqqHandler;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActInfo;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActRsp;
import tencent.im.oidb.qqshop.qqshop_act.SQQSHPActShowInfo;

public class ChatApolloViewListener
  extends ApolloExtensionObserverImpl
  implements View.OnClickListener, IAioAnimListener, OnApolloViewListener
{
  public PopupWindow a;
  private Runnable a;
  public WeakReference<BaseChatPie> a;
  public boolean a;
  public boolean b = false;
  public boolean c = false;
  
  public ChatApolloViewListener(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRunnable = new ChatApolloViewListener.3(this);
    if (((paramBaseChatPie instanceof FriendChatPie)) || ((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof DiscussChatPie)) || ((paramBaseChatPie instanceof HotChatPie)) || ((paramBaseChatPie instanceof StrangerChatPie)) || ((paramBaseChatPie instanceof LimitChatPie))) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    }
  }
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[doJDRedPackReport], key:" + paramInt + ",app:" + paramQQAppInterface);
    }
    if (paramQQAppInterface == null) {
      return;
    }
    ((EcshopReportHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(paramInt, "", "", "", "", 0L, false);
  }
  
  private void a(Activity paramActivity, qqshop_act.SQQSHPActShowInfo paramSQQSHPActShowInfo, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramSQQSHPActShowInfo == null)) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, JDHongbaoActivity.class);
    localIntent.putExtra("jd_hb_is_check_delay", paramBoolean);
    localIntent.putExtra("jd_hb_title", paramSQQSHPActShowInfo.title.get());
    localIntent.putExtra("jd_hb_subtitle", paramSQQSHPActShowInfo.subtext.get());
    localIntent.putExtra("jd_hb_detail_text", paramSQQSHPActShowInfo.gift_text.get());
    localIntent.putExtra("jd_hongbao_tips", paramSQQSHPActShowInfo.act_text.get());
    localIntent.putExtra("jd_hb_btn_text", paramSQQSHPActShowInfo.btn_text.get());
    localIntent.putExtra("jd_hb_detail_url", paramSQQSHPActShowInfo.detail_url.get());
    localIntent.putExtra("jd_hb_btn_url", paramSQQSHPActShowInfo.btn_url.get());
    localIntent.putExtra("jd_hb_logo_url", paramSQQSHPActShowInfo.logo.get());
    localIntent.addFlags(67108864);
    paramActivity.startActivity(localIntent);
  }
  
  private boolean a(int paramInt, String paramString)
  {
    QLog.d("ChatApolloViewListener", 1, new Object[] { "onPetBrandClick petId=", Integer.valueOf(paramInt) });
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return false;
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null)) {
      return false;
    }
    return QZoneVipInfoManager.onPetBrandClick(localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramInt, paramString);
  }
  
  private boolean a(String paramString)
  {
    QLog.d("ChatApolloViewListener", 1, "onSuperYellowBrandClick");
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return false;
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null)) {
      return false;
    }
    return QZoneVipInfoManager.onSuperYellowBrandClick(localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramString);
  }
  
  private boolean b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 1, new Object[] { "onPetClick petId=", Integer.valueOf(paramInt) });
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return false;
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null)) {
      return false;
    }
    return QZoneVipInfoManager.onPetClick(localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt, paramString);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[initJDRedPackEntry],mIsJumpEggStart:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      return;
      localObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localObject == null) || (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_Boolean) || (((BaseChatPie)localObject).a() == null));
    ((BaseChatPie)localObject).a().a(this);
    EcshopReportHandler localEcshopReportHandler = (EcshopReportHandler)((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
    String str = Integer.toString(EcShopAssistantManager.a(((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
    if ((((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {}
    for (Object localObject = ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; localObject = "")
    {
      localEcshopReportHandler.a(134247330, "", str, (String)localObject, "", 0L, false);
      return;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onEggAnimStart], mIsJumpEggStart:" + this.jdField_a_of_type_Boolean);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((this.jdField_a_of_type_Boolean) || (localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
    localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class).removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Boolean = true;
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    ((ApolloExtensionHandlerImpl)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(localEcShopAssistantManager.b);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[addJDEndView],imgUrl:" + paramString);
    }
    LinearLayout localLinearLayout = (LinearLayout)View.inflate(BaseApplicationImpl.getContext(), 2131558724, null);
    if (localLinearLayout == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ChatApolloViewListener", 2, "errInfo->inflate err.");
      }
    }
    do
    {
      do
      {
        return;
        Object localObject = (ImageView)localLinearLayout.findViewById(2131369881);
        TextView localTextView = (TextView)localLinearLayout.findViewById(2131369700);
        ((ImageView)localObject).setOnClickListener(this);
        localTextView.setOnClickListener(this);
        localObject = (URLImageView)localLinearLayout.findViewById(2131369554);
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
          if ((localObject != null) && (paramString != null)) {
            ((URLImageView)localObject).setImageDrawable(paramString);
          }
        }
        if (this.jdField_a_of_type_AndroidWidgetPopupWindow == null) {
          this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(localLinearLayout, -1, -1, false);
        }
      } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
      paramString = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (paramString == null);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAsDropDown(paramString.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO);
    a(134247341, paramString.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    boolean bool = true;
    if (paramBoolean)
    {
      this.b = true;
      if (paramInt == 1) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        this.c = paramBoolean;
        return;
      }
    }
    this.b = false;
    this.c = false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onEggAnimEnd], mIsJumpEggStart:" + this.jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (!this.jdField_a_of_type_Boolean)) {}
    do
    {
      return;
      localObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localObject == null);
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "currentDelay:" + localEcShopAssistantManager.c);
    }
    Object localObject = ((BaseChatPie)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
    if (localEcShopAssistantManager.c > 0)
    {
      ((MqqHandler)localObject).postDelayed(this.jdField_a_of_type_JavaLangRunnable, localEcShopAssistantManager.c * 1000);
      return;
    }
    c();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[removeJDRedPackEntry]");
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.a() == null));
    localBaseChatPie.a().d();
  }
  
  public void c(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "TROOP, [onChangeUserApolloStatus], result:" + paramBoolean + ",data:" + paramObject);
    }
    if ((!paramBoolean) || (paramObject == null)) {}
    label50:
    BaseChatPie localBaseChatPie;
    do
    {
      do
      {
        do
        {
          break label50;
          do
          {
            return;
          } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
          localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null));
        if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel != null) {
          localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a(paramBoolean, paramObject);
        }
        MqqHandler localMqqHandler = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localMqqHandler != null) {
          localMqqHandler.obtainMessage(51).sendToTarget();
        }
        paramObject = (Pair)paramObject;
      } while (!((String)paramObject.first).equals(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()));
      QLog.i("ChatApolloViewListener", 1, "my cmshow status has changed, status:" + paramObject.second);
      if ((2 == ((Integer)paramObject.second).intValue()) || (((Integer)paramObject.second).intValue() == 0))
      {
        ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(localBaseChatPie.a(), "cmshow_status", true);
        return;
      }
    } while (1 != ((Integer)paramObject.second).intValue());
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(localBaseChatPie.a(), "cmshow_status", false);
    ApolloGameUtil.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0L);
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "request user game list");
    }
    ((ApolloGameManager)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).e();
  }
  
  public void e(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onApolloDressChange], result:" + paramBoolean + ",data:" + paramObject);
    }
    ThreadManager.post(new ChatApolloViewListener.2(this, paramBoolean, paramObject), 5, null, true);
  }
  
  public void i(boolean paramBoolean, Object paramObject)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      ApolloManagerServiceImpl.sFristOpenPanel = true;
      if (QLog.isColorLevel()) {
        QLog.d("ChatApolloViewListener", 2, "onQueryUserApolloAction mChatPieRef == null return");
      }
    }
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel == null));
    localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.b(paramBoolean, paramObject);
  }
  
  public void m(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onJDHongbaoRsp],result:" + paramBoolean + ",data:" + paramObject + ",mIsAIOFinish:" + this.b);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      Object localObject;
      BaseChatPie localBaseChatPie;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  localObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
                  if ((localObject != null) && (((BaseChatPie)localObject).c != null)) {
                    ((BaseChatPie)localObject).c.dismiss();
                  }
                  if ((!paramBoolean) && (!this.b))
                  {
                    QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131701656), 1).a();
                    return;
                  }
                } while (paramObject == null);
                if ((paramObject instanceof qqshop_act.SQQSHPActRsp)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("ChatApolloViewListener", 2, "errInfo->Wrong data object.");
              return;
              paramObject = (qqshop_act.SQQSHPActRsp)paramObject;
              localObject = paramObject.act_show_info;
            } while ((localObject == null) || (this.jdField_a_of_type_JavaLangRefWeakReference == null));
            localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
            int i = paramObject.code.get();
            if (QLog.isColorLevel()) {
              QLog.d("ChatApolloViewListener", 2, "errCode:" + i);
            }
            switch (i)
            {
            }
          } while (this.b);
          QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131701655), 1).a();
          return;
        } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.b));
        a(localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (qqshop_act.SQQSHPActShowInfo)localObject, false);
        return;
      } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.b));
      a(localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (qqshop_act.SQQSHPActShowInfo)localObject, true);
      return;
    } while ((this.b) || (paramObject.act_info == null));
    a(paramObject.act_info.fail_pic.get());
  }
  
  public void n(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[onJDCheckRsp],result:" + paramBoolean + ",mIsAIOFinish:" + this.b + ",mChatPieRef:" + this.jdField_a_of_type_JavaLangRefWeakReference);
    }
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      do
      {
        return;
        paramObject = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (!paramBoolean) {
          break;
        }
      } while (this.b);
      d();
      return;
    } while ((paramObject == null) || (this.b));
    a(134247332, paramObject.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject1 = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if ((localObject1 == null) || (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131368499: 
          if (((BaseChatPie)localObject1).c == null)
          {
            int i = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299166);
            ((BaseChatPie)localObject1).c = new QQProgressDialog(((BaseChatPie)localObject1).jdField_a_of_type_AndroidContentContext, i);
          }
          ((BaseChatPie)localObject1).c.a(HardCodeUtil.a(2131701654));
          ((BaseChatPie)localObject1).c.show();
          c();
          Object localObject2 = (EcShopAssistantManager)((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
          Object localObject3 = (ApolloExtensionHandlerImpl)((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
          if ((localObject2 != null) && (localObject3 != null))
          {
            ((ApolloExtensionHandlerImpl)localObject3).a(((EcShopAssistantManager)localObject2).b, ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
            localObject2 = (EcshopReportHandler)((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER);
            localObject3 = Integer.toString(EcShopAssistantManager.a(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
            if ((((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) {}
            for (localObject1 = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;; localObject1 = "")
            {
              ((EcshopReportHandler)localObject2).a(134247331, "", (String)localObject3, (String)localObject1, Integer.toString(EcShopAssistantManager.b()), 0L, false);
              break;
            }
          }
          break;
        case 2131369881: 
          if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
          {
            this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
            a(134247343, ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          break;
        case 2131369700: 
          if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null)
          {
            this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
            a(134247343, ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          break;
        }
      }
    }
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    Object localObject1 = (ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class);
    if ((TextUtils.isEmpty(paramString)) || (!((ITroopAvatarUtilApi)localObject1).isNumeric(paramString))) {
      QLog.w("ChatApolloViewListener", 1, "longTouch uin = null");
    }
    label36:
    BaseChatPie localBaseChatPie;
    Object localObject2;
    do
    {
      do
      {
        do
        {
          break label36;
          do
          {
            return;
          } while (this.jdField_a_of_type_JavaLangRefWeakReference == null);
          localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController == null) || (!localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a()) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
        if (!NetworkUtil.g(localBaseChatPie.jdField_a_of_type_AndroidContentContext))
        {
          ApolloItemBuilder.a(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131690107), 1, localBaseChatPie.jdField_a_of_type_AndroidContentContext);
          return;
        }
        localObject1 = (ISpriteScriptManager)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((ISpriteScriptManager)localObject1).getTaskHandler();
      } while ((localObject1 != null) && (((ISpriteTaskHandler)localObject1).a()));
      localObject1 = (ApolloManagerServiceImpl)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_avatar", localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "0", "", "", String.valueOf(System.currentTimeMillis() / 1000L) });
      localObject2 = new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
      if (paramString.equals(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {}
      for (int i = 0;; i = 1)
      {
        ApolloDtReportUtil.a("aio", "sprite", "long_click", ((ApolloDtReportUtil.DtReportParamsBuilder)localObject2).d(i).b(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a());
        if (((ApolloManagerServiceImpl)localObject1).getApolloStatus(paramString) == 1) {
          break;
        }
        ApolloItemBuilder.a(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131690157), 1, localBaseChatPie.jdField_a_of_type_AndroidContentContext);
        return;
      }
    } while (((ApolloManagerServiceImpl)localObject1).getCmShowStatus(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString) == 2);
    if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
      localObject1 = ContactUtils.m(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatApolloViewListener", 2, "onLoncClick uin = " + paramString + " ,nickName =" + (String)localObject1);
      }
      localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.b();
      localObject2 = new Intent(localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ApolloGuestsStateActivity.class);
      ((Intent)localObject2).putExtra("extra_guest_uin", paramString);
      ((Intent)localObject2).putExtra("extra_guest_nick", (String)localObject1);
      ((Intent)localObject2).putExtra("extra_guest_from", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
      localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject2);
      return;
      if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        localObject1 = ContactUtils.d(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString);
      } else if (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) {
        localObject1 = ContactUtils.c(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, true);
      } else {
        localObject1 = "";
      }
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    BaseChatPie localBaseChatPie;
    do
    {
      return;
      QLog.d("ChatApolloViewListener", 1, new Object[] { "onNotifyStatusChanged clickPart=", Integer.valueOf(paramInt) });
      localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localBaseChatPie == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController == null) || (!localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a()) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null));
    paramString = ApolloUtilImpl.getUinFromApolloId(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    label140:
    Object localObject;
    ApolloDress localApolloDress;
    switch (paramInt)
    {
    default: 
      bool1 = bool2;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      while (bool1)
      {
        QLog.d("ChatApolloViewListener", 1, "onNotifyStatusChanged click intercept");
        return;
        bool1 = bool2;
        if (((ApolloManagerServiceImpl)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).isSuperYellow(paramString))
        {
          bool1 = a(paramString);
          continue;
          localObject = ((ApolloManagerServiceImpl)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(paramString);
          bool1 = bool2;
          if (localObject != null)
          {
            localApolloDress = ((ApolloBaseInfo)localObject).getApolloPetDress();
            if ((localApolloDress == null) || (!((ApolloBaseInfo)localObject).hasPet) || (localApolloDress.dressMap == null) || (localApolloDress.dressMap.isEmpty())) {
              break label843;
            }
          }
        }
      }
    }
    label843:
    for (bool1 = a(localApolloDress.roleId, paramString);; bool1 = false)
    {
      break label140;
      localObject = ((ApolloManagerServiceImpl)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloBaseInfo(paramString);
      bool1 = bool2;
      if (localObject == null) {
        break label140;
      }
      localApolloDress = ((ApolloBaseInfo)localObject).getApolloPetDress();
      bool1 = bool2;
      if (localApolloDress == null) {
        break label140;
      }
      bool1 = bool2;
      if (!((ApolloBaseInfo)localObject).hasPet) {
        break label140;
      }
      bool1 = bool2;
      if (localApolloDress.dressMap == null) {
        break label140;
      }
      bool1 = bool2;
      if (localApolloDress.dressMap.isEmpty()) {
        break label140;
      }
      bool1 = b(localApolloDress.roleId, paramString);
      break label140;
      localObject = (ApolloGameManager)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER);
      if (((ApolloGameManager)localObject).jdField_a_of_type_Int != -1)
      {
        ApolloGameUtil.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ApolloGameManager)localObject).jdField_a_of_type_Int, 0L, 0, "", 321, null);
        return;
      }
      bool1 = bool2;
      if (((ApolloGameManager)localObject).jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush == null) {
        break label140;
      }
      localObject = ((ApolloGameManager)localObject).jdField_a_of_type_ComTencentMobileqqApolloTaskApolloAioBubblePush.a();
      bool1 = bool2;
      if (localObject == null) {
        break label140;
      }
      if (((DrawerPushItem)localObject).msg_type != 10)
      {
        bool1 = bool2;
        if (((DrawerPushItem)localObject).msg_type != 7) {
          break label140;
        }
      }
      ApolloTianshuReportUtil.a(102, String.valueOf(((DrawerPushItem)localObject).tianshuAdId), ((DrawerPushItem)localObject).tianshuTraceInfo);
      bool1 = bool2;
      break label140;
      localObject = SpriteUtil.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject != null) {
        ((SpriteActionScript)localObject).a(SpriteUtil.a(paramInt), null, paramString);
      }
      paramString = (SpriteScriptManagerImpl)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
      if (paramString == null) {
        break;
      }
      paramString = paramString.getBubbleLogic();
      if (paramString == null) {
        break;
      }
      int i = paramString.a();
      paramString = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("apollo_sp", 0);
      bool1 = paramString.getBoolean("is_add_new_game" + localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
      int j = paramString.getInt("new_added_game_id" + localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
      if (9 == paramInt) {
        VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "click_action_hotspot", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[0]);
      }
      if (i == 1)
      {
        if ((!bool1) || (-1 == j)) {
          break;
        }
        VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "avatar_clk_togame", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 1, new String[] { String.valueOf(j) });
        paramString.edit().remove("is_add_new_game" + localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).commit();
        return;
      }
      if ((i != 2) || (localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel == null)) {
        break;
      }
      localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.i();
      return;
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatApolloViewListener", 2, "[TraceReport onSurfaceReady], w:" + paramInt1 + ",h:" + paramInt2);
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localBaseChatPie == null) {
      return;
    }
    ISpriteScriptManager localISpriteScriptManager = (ISpriteScriptManager)localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
    if (localISpriteScriptManager.getSpriteContext() != null) {
      TraceReportUtil.a(SpriteUtil.b(localISpriteScriptManager.getSpriteContext().b()), 100, 0, new Object[] { "onSurfaceReady" });
    }
    if (!localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.jdField_a_of_type_Boolean)
    {
      CmShowStatUtil.a("TraceReport_initApolloSurfaceView_PreLoadJS");
      ThreadManager.excute(new ChatApolloViewListener.1(this), 192, null, true);
      return;
    }
    QLog.i("ChatApolloViewListener", 1, "TraceReport CmShowStatUtil onSurfaceReady mPreloadEngine:true");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ChatApolloViewListener
 * JD-Core Version:    0.7.0.1
 */