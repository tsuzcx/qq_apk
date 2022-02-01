package com.tencent.mobileqq.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.login.PwdSetUtil;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearby.NearbyProxyUtils;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusPermissionManager;
import com.tencent.mobileqq.profilecard.utils.QQDarenUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.VerticalCenterMarginImageSpan;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.app.Constants.LogoutReason;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class AccountManageActivity
  extends IphoneTitleBarActivity
{
  float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  Dialog jdField_a_of_type_AndroidAppDialog;
  DialogInterface.OnDismissListener jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new AccountManageActivity.18(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private AccountManageActivity.MyOnButtonClickListener jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$MyOnButtonClickListener = new AccountManageActivity.MyOnButtonClickListener(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new AccountManageActivity.30(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new AccountManageActivity.33(this);
  private SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new AccountManageActivity.32(this);
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = new AccountManageActivity.40(this);
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new AccountManageActivity.29(this);
  private TipsBar jdField_a_of_type_ComTencentMobileqqBannerTipsBar;
  private Card jdField_a_of_type_ComTencentMobileqqDataCard = null;
  private OnlineStatusObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver = new AccountManageActivity.39(this);
  RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet = null;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<SimpleAccount> jdField_a_of_type_JavaUtilList;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new AccountManageActivity.23(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new AccountManageActivity.2(this);
  boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  Dialog jdField_b_of_type_AndroidAppDialog;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new AccountManageActivity.19(this);
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private ActionSheet jdField_b_of_type_ComTencentWidgetActionSheet;
  private HashMap<String, String> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private AccountObserver jdField_b_of_type_MqqObserverAccountObserver = new AccountManageActivity.38(this);
  boolean jdField_b_of_type_Boolean = true;
  Dialog jdField_c_of_type_AndroidAppDialog;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new AccountManageActivity.3(this);
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  boolean jdField_c_of_type_Boolean = true;
  private View.OnClickListener jdField_d_of_type_AndroidViewView$OnClickListener = new AccountManageActivity.13(this);
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = false;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new AccountManageActivity.20(this);
  private View jdField_e_of_type_AndroidViewView;
  private boolean jdField_e_of_type_Boolean = false;
  private View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener = new AccountManageActivity.21(this);
  private boolean jdField_f_of_type_Boolean = false;
  private View.OnClickListener jdField_g_of_type_AndroidViewView$OnClickListener = new AccountManageActivity.34(this);
  private boolean jdField_g_of_type_Boolean = false;
  private boolean h = false;
  private boolean i = false;
  
  private void A()
  {
    FormSimpleItem localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    String str;
    if (VipQidHelper.a(this.app)) {
      str = "已开启";
    } else {
      str = "未开启";
    }
    localFormSimpleItem.setRightText(str);
    VipQidHelper.a("0X800B5C6", a());
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("100190.100193.100192");
      if (localAppInfo != null) {
        localIRedTouchManager.reportLevelOneRedInfo("100190.100193.100192", 30);
      }
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
    }
  }
  
  private int a()
  {
    boolean bool = VipQidHelper.a(this.app);
    int j = 2;
    if (!bool)
    {
      if (((IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("100190.100193.100192") != null) {
        j = 1;
      }
      return j;
    }
    j = 3;
    if (VipInfoHandler.a(this.app, this.app.getCurrentUin(), false) == 2) {
      j = 4;
    }
    return j;
  }
  
  private CharSequence a()
  {
    Object localObject2 = ((IOnlineStatusService)this.app.getRuntimeService(IOnlineStatusService.class)).getOnlineStatus();
    long l = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(this.app);
    Object localObject1 = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfStatusNameBySubTitle(l, (AppRuntime.Status)localObject2);
    Object localObject3 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.app.getCurrentUin());
    localObject2 = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfStatusDrawable(l, (AppRuntime.Status)localObject2, 1, (Friends)localObject3);
    if (localObject2 == null) {
      return localObject1;
    }
    int j = AIOUtils.b(16.0F, getResources());
    ((Drawable)localObject2).setBounds(0, 0, j, j);
    if ((localObject2 instanceof URLDrawable)) {
      ((URLDrawable)localObject2).downloadImediatly();
    }
    localObject2 = new VerticalCenterMarginImageSpan((Drawable)localObject2);
    ((VerticalCenterMarginImageSpan)localObject2).a(AIOUtils.b(8.0F, getResources()));
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[图片]");
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject1 = new SpannableString(((StringBuilder)localObject3).toString());
    ((SpannableString)localObject1).setSpan(localObject2, 0, 4, 17);
    return localObject1;
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", FrameControllerUtil.jdField_a_of_type_Int);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.b();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    paramQQAppInterface.logout(true);
    if (GlobalImageCache.a != null) {
      try
      {
        GlobalImageCache.a.evictAll();
      }
      catch (Exception localException)
      {
        QLog.e("AccountManageActivity", 1, "sImageCache.evictAll error : ", localException);
      }
    }
    int j = QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), j + 1);
    RouteUtils.a(paramActivity, localIntent, "/base/login");
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    paramActivity.finish();
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramFloat1, paramFloat2 });
    localObjectAnimator.setDuration(250L);
    if (paramView.getTag() != null) {
      ((ObjectAnimator)paramView.getTag()).cancel();
    }
    paramView.setTag(localObjectAnimator);
    localObjectAnimator.start();
  }
  
  private void a(ISubAccountService paramISubAccountService, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramInt == 1)
    {
      SubAccountInfo localSubAccountInfo = paramISubAccountService.getSubAccountInfo("sub.uin.default");
      paramISubAccountService = (ISubAccountService)localObject1;
      if (localSubAccountInfo != null)
      {
        paramISubAccountService = (ISubAccountService)localObject1;
        if (!TextUtils.isEmpty(localSubAccountInfo.subuin))
        {
          localObject1 = localSubAccountInfo.subname;
          localObject2 = ContactUtils.b(this.app, localSubAccountInfo.subuin, true);
          paramISubAccountService = (ISubAccountService)localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            if (!TextUtils.isEmpty(localSubAccountInfo.subname))
            {
              paramISubAccountService = (ISubAccountService)localObject1;
              if (((String)localObject2).equals(localSubAccountInfo.subname)) {}
            }
            else
            {
              localSubAccountInfo.subname = ((String)localObject2);
              paramISubAccountService = (ISubAccountService)localObject2;
            }
          }
        }
      }
      localObject1 = paramISubAccountService;
      if (paramISubAccountService == null)
      {
        localObject1 = paramISubAccountService;
        if (localSubAccountInfo != null) {
          localObject1 = localSubAccountInfo.subuin;
        }
      }
      if (localSubAccountInfo != null) {
        a(this.jdField_b_of_type_AndroidWidgetImageView, localSubAccountInfo.subuin);
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramISubAccountService = (ISubAccountService)localObject1;
    }
    else if (paramInt > 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131699972));
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = paramISubAccountService.getAllSubUin();
      paramISubAccountService = (ISubAccountService)localObject1;
      if (((ArrayList)localObject2).size() == 2)
      {
        a(this.jdField_b_of_type_AndroidWidgetImageView, (String)((ArrayList)localObject2).get(0));
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        a(this.jdField_a_of_type_AndroidWidgetImageView, (String)((ArrayList)localObject2).get(1));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        paramISubAccountService = (ISubAccountService)localObject1;
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramISubAccountService = (ISubAccountService)localObject2;
    }
    localObject1 = paramISubAccountService;
    if (paramISubAccountService == null) {
      localObject1 = "";
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshAssociatedAccount() uin=");
      ((StringBuilder)localObject2).append(this.app.getCurrentAccountUin());
      ((StringBuilder)localObject2).append(" isAccount1Bind=");
      ((StringBuilder)localObject2).append(this.jdField_f_of_type_Boolean);
      ((StringBuilder)localObject2).append(" account2BindedNum=");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" sAccountName=");
      if (((String)localObject1).length() == 0)
      {
        paramISubAccountService = "_empty_";
      }
      else if ((((String)localObject1).length() != 1) && (((String)localObject1).length() != 2) && (((String)localObject1).length() > 2))
      {
        paramISubAccountService = new StringBuilder();
        paramISubAccountService.append(((String)localObject1).substring(0, 2));
        paramISubAccountService.append("|");
        paramISubAccountService.append(((String)localObject1).length());
        paramISubAccountService = paramISubAccountService.toString();
      }
      else
      {
        paramISubAccountService = (ISubAccountService)localObject1;
      }
      ((StringBuilder)localObject2).append(paramISubAccountService);
      QLog.d("AccountManageActivity", 2, ((StringBuilder)localObject2).toString());
    }
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      paramISubAccountService = this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("关联QQ号");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramISubAccountService.setContentDescription(((StringBuilder)localObject2).toString());
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    ((AccountManager)getAppRuntime().getManager(0)).deleteAccount(this.jdField_a_of_type_JavaLangString, this.app.getUinDisplayNameBeforeLogin(this.jdField_a_of_type_JavaLangString), new AccountManageActivity.DelHistoryAccountObserver(this, paramString, paramBoolean));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("am.deleteAccount ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("Switch_Account", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      NearbyProxyUtils.a(paramString);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    l();
    int j = 0;
    boolean bool = false;
    if (paramBoolean)
    {
      if ((!this.jdField_f_of_type_Boolean) && (paramInt == 0)) {
        if (DBUtils.a().a())
        {
          if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(5000))
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
            if ((localObject == null) || (!((QQCustomDialog)localObject).isShowing()))
            {
              j = 2;
              break label83;
            }
          }
        }
        else
        {
          j = 1;
          break label83;
        }
      }
      j = 0;
      label83:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("AccountManagerActivity.refreshSubAccount() isAccount2Bind=");
        if (paramInt > 0) {
          bool = true;
        }
        ((StringBuilder)localObject).append(bool);
        QLog.d("AccountManageActivity", 2, ((StringBuilder)localObject).toString());
      }
      if (paramInt == 0) {
        m();
      }
    }
    int k = j;
    if (j == 0)
    {
      k = j;
      if (paramInt == 1) {
        if (DBUtils.a().a(this.app.getCurrentAccountUin()))
        {
          k = j;
        }
        else
        {
          localObject = this.jdField_a_of_type_JavaUtilList;
          k = j;
          if (localObject != null)
          {
            k = j;
            if (((List)localObject).size() >= 4) {
              k = 3;
            }
          }
        }
      }
    }
    b(k);
    if (this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.getVisibility() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshSubAccountTipbar() isAccountChanged=");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" isAccount1Bind=");
    ((StringBuilder)localObject).append(this.jdField_f_of_type_Boolean);
    ((StringBuilder)localObject).append(" account2BindedNum=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" final action=");
    ((StringBuilder)localObject).append(k);
    QLog.d("AccountManageActivity", 1, ((StringBuilder)localObject).toString());
  }
  
  private boolean a()
  {
    if (PwdSetUtil.a(this.app, this))
    {
      QLog.i("AccountManageActivity", 1, "checkHasSetPwd: return false");
      return false;
    }
    return true;
  }
  
  private void b(int paramInt)
  {
    if (paramInt != 1)
    {
      String str;
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.getVisibility() != 8) {
            this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(8);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTag("0X8004456");
          str = getString(2131719325);
          this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTipsText(str);
          if (AppSetting.jdField_d_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setContentDescription(str);
          }
          if (this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.getVisibility() != 0)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X8004456", "0X8004456", 0, 0, "", "", "", "");
            this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(0);
          }
          d();
        }
      }
      else
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004001", "0X8004001", 0, 0, "", "", "", "");
        this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTag("0X8004001");
        str = getString(2131719293);
        this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTipsText(str);
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setContentDescription(str);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.getVisibility() != 0) {
          this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(0);
        }
        d();
      }
    }
    else
    {
      DBUtils.a().a(true);
      d();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5000, 1000L);
      if (this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.getVisibility() != 8) {
        this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setVisibility(8);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    ISubAccountService localISubAccountService = (ISubAccountService)this.app.getRuntimeService(ISubAccountService.class, "");
    int j = localISubAccountService.getBindedNumber();
    a(paramBoolean, j);
    a(localISubAccountService, j);
  }
  
  private void c(View paramView)
  {
    a((View)paramView.getParent(), 0.0F, -this.jdField_a_of_type_Int);
    a((View)paramView.getTag(), 0.0F, -this.jdField_a_of_type_Int);
  }
  
  private void d(View paramView)
  {
    View localView = (View)paramView.getParent();
    paramView = (View)paramView.getTag();
    a(localView, localView.getTranslationX(), 0.0F);
    a(paramView, paramView.getTranslationX(), 0.0F);
  }
  
  private void j()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean ^= true;
    if (this.jdField_a_of_type_Boolean)
    {
      this.rightViewText.setVisibility(8);
      this.rightHighLView.setVisibility(0);
      this.rightViewText.setText(2131692486);
    }
    else
    {
      this.rightViewText.setVisibility(0);
      this.rightHighLView.setVisibility(8);
      this.rightViewText.setText(2131691859);
    }
    b();
    a(this.jdField_a_of_type_Boolean);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AccountManageActivity.4(this), 250L);
    if (this.jdField_a_of_type_Boolean)
    {
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_acc_edit", 0, 0, "", "", "", "");
      ReportController.a(this.app, "0X800B836");
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370473);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131374755);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131371779);
    if (this.jdField_g_of_type_Boolean)
    {
      this.h = true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(new ActionMenuItem(getString(2131690000), 1, 0), 0);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(new ActionMenuItem(getString(2131690002), 2, 0), 0);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new AccountManageActivity.8(this));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addCancelButton(getString(2131690001));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new AccountManageActivity.9(this));
      ReportController.a(this.app, "0X800B7D7");
      return;
    }
    this.h = false;
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    ReportController.a(this.app, "0X800B7D8");
    ReportController.a(this.app, "0X800B7D9");
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new AccountManageActivity.10(this));
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new AccountManageActivity.11(this));
  }
  
  private void l()
  {
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setBackgroundColor(getResources().getColor(2131167028));
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.setTipsIcon(getResources().getDrawable(2130850853));
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.a().setTextColor(getResources().getColorStateList(2131167063));
    if (this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar.a().setVisibility(8);
    }
  }
  
  private void m()
  {
    ThreadManager.post(new AccountManageActivity.12(this), 8, null, false);
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountManageActivity", 2, "showLogoutDialog");
    }
    if (!a()) {
      return;
    }
    Object localObject1 = this.jdField_b_of_type_AndroidAppDialog;
    if ((localObject1 != null) && (((Dialog)localObject1).isShowing())) {
      return;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataCard;
    if (localObject1 != null)
    {
      if (((Card)localObject1).lQQMasterLogindays > 0L) {
        QQDarenUtils.sQQDarenLoginDays = this.jdField_a_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays;
      } else {
        QQDarenUtils.sQQDarenLoginDays = 30L;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays != 1L) && ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays <= 1L) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= QQDarenUtils.sQQDarenLoginDays)))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= QQDarenUtils.sQQDarenLoginDays) {
          localObject1 = String.format(getString(2131693864), new Object[] { Integer.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
        } else {
          localObject1 = String.format(getString(2131693865), new Object[0]);
        }
      }
      else {
        localObject1 = String.format(getString(2131693863), new Object[] { Integer.valueOf((int)(QQDarenUtils.sQQDarenLoginDays - this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays)) });
      }
    }
    else
    {
      localObject1 = String.format(getString(2131693865), new Object[0]);
    }
    Object localObject2 = this.jdField_b_of_type_AndroidAppDialog;
    if (localObject2 != null)
    {
      localObject2 = (TextView)((Dialog)localObject2).findViewById(2131365644);
      if (localObject2 != null)
      {
        ((TextView)localObject2).requestFocus();
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
      }
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
    }
    this.jdField_b_of_type_AndroidAppDialog = new ReportDialog(this, 2131756189);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2131558954);
    localObject2 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365648);
    if (localObject2 != null)
    {
      ((TextView)localObject2).setVisibility(4);
      ((ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams()).bottomMargin = 0;
      ((TextView)localObject2).setHeight(0);
      ((TextView)localObject2).setLayoutParams(((TextView)localObject2).getLayoutParams());
    }
    localObject2 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365644);
    if (localObject2 != null)
    {
      ((TextView)localObject2).requestFocus();
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    localObject1 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365633);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(2131690728);
      ((TextView)localObject1).setOnClickListener(new AccountManageActivity.14(this));
    }
    localObject1 = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365639);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(2131693862);
      ((TextView)localObject1).setOnClickListener(new AccountManageActivity.15(this));
    }
    this.jdField_b_of_type_AndroidAppDialog.show();
    ReportController.a(this.app, "0X800B83C");
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131756189);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558463);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365644)).setText(getString(2131691504));
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
  }
  
  private void p()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if (localObject1 == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    } else {
      ((List)localObject1).clear();
    }
    getAppRuntime().getApplication().refreAccountList();
    Object localObject2 = getAppRuntime().getApplication().getAllAccounts();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("initAccountList list=");
    ((StringBuilder)localObject3).append(localObject2);
    ((StringBuilder)localObject3).append(", size=");
    String str = "null";
    if (localObject2 != null) {
      localObject1 = Integer.valueOf(((List)localObject2).size());
    } else {
      localObject1 = "null";
    }
    ((StringBuilder)localObject3).append(localObject1);
    QLog.i("AccountManageActivity", 1, ((StringBuilder)localObject3).toString());
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
    }
    localObject1 = this.jdField_a_of_type_JavaUtilList;
    if (localObject1 != null) {
      ((List)localObject1).add(null);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initAccountList accountList=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilList);
    ((StringBuilder)localObject2).append(", size=");
    localObject3 = this.jdField_a_of_type_JavaUtilList;
    localObject1 = str;
    if (localObject3 != null) {
      localObject1 = Integer.valueOf(((List)localObject3).size());
    }
    ((StringBuilder)localObject2).append(localObject1);
    QLog.i("AccountManageActivity", 1, ((StringBuilder)localObject2).toString());
    q();
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    AccountManageActivity.16 local16 = new AccountManageActivity.16(this);
    int j = 0;
    while (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("bindAccountListView i=");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(", account=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilList.get(j));
        QLog.i("AccountManageActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if (this.jdField_a_of_type_JavaUtilList.get(j) == null)
      {
        this.jdField_d_of_type_AndroidViewView = getLayoutInflater().inflate(2131558442, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_d_of_type_AndroidViewView.setTag(null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_d_of_type_AndroidViewView);
      }
      else
      {
        localObject1 = getLayoutInflater().inflate(2131558443, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        ((View)localObject1).setTag(Integer.valueOf(j));
        ((View)localObject1).setOnTouchListener(local16);
        ((ImageView)((View)localObject1).findViewById(2131368343)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((View)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if ((localObject1 instanceof FormItemRelativeLayout))
        {
          localObject2 = (FormItemRelativeLayout)localObject1;
          ((FormItemRelativeLayout)localObject2).setNeedFocusBg(true);
          ((FormItemRelativeLayout)localObject2).setBGType(2);
        }
        Object localObject2 = (Button)((View)localObject1).findViewById(2131365466);
        ((Button)localObject2).setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_Int = ((Button)localObject2).getLayoutParams().width;
        View localView = ((View)localObject1).findViewById(2131365496);
        localView.setTag(localObject2);
        localView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      j += 1;
    }
    u();
  }
  
  private void r()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      b(this.jdField_d_of_type_AndroidViewView);
      b(this.jdField_e_of_type_AndroidViewView);
      return;
    }
    a(this.jdField_d_of_type_AndroidViewView);
    a(this.jdField_e_of_type_AndroidViewView);
  }
  
  private void s()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      b(this.leftView);
      return;
    }
    a(this.leftView);
  }
  
  private void t()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject1 != null)
    {
      if (((LinearLayout)localObject1).getChildCount() <= 0) {
        return;
      }
      int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      int j = 0;
      while (j < k)
      {
        Object localObject3 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
        Object localObject2 = ((View)localObject3).getTag();
        if (localObject2 != null)
        {
          localObject1 = (ImageView)((View)localObject3).findViewById(2131364592);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131365496);
          if (this.jdField_a_of_type_Boolean)
          {
            if (((ImageView)localObject1).getVisibility() == 0) {
              b((View)localObject1);
            }
            ((ImageView)localObject3).setVisibility(0);
          }
          else
          {
            int m = ((Integer)localObject2).intValue();
            localObject2 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
            if ((localObject2 != null) && (((SimpleAccount)localObject2).getUin() != null) && (((SimpleAccount)localObject2).getUin().length() > 0) && (((SimpleAccount)localObject2).getUin().equals(this.app.getCurrentAccountUin()))) {
              ((ImageView)localObject1).setVisibility(0);
            } else {
              ((ImageView)localObject1).setVisibility(8);
            }
            if (((ImageView)localObject1).getVisibility() == 0) {
              a((View)localObject1);
            }
            ((ImageView)localObject3).setVisibility(8);
            x();
          }
        }
        j += 1;
      }
    }
  }
  
  private void u()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if ((localObject1 != null) && (((LinearLayout)localObject1).getChildCount() > 0))
    {
      int m = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateAccountListView account size=");
      ((StringBuilder)localObject1).append(m);
      QLog.i("AccountManageActivity", 1, ((StringBuilder)localObject1).toString());
      QQAppInterface localQQAppInterface = this.app;
      int j = 0;
      while (j < m)
      {
        View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
        localObject1 = localView.getTag();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateAccountListView i=");
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(", view tag=");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.i("AccountManageActivity", 1, ((StringBuilder)localObject2).toString());
        if (localObject1 == null) {
          return;
        }
        int k = ((Integer)localObject1).intValue();
        if (k >= this.jdField_a_of_type_JavaUtilList.size())
        {
          QLog.e("AccountManageActivity", 1, "updateAccountListView, view tag is large than account list size");
          finish();
          return;
        }
        SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
        if (localSimpleAccount == null) {
          return;
        }
        ImageView localImageView1 = (ImageView)localView.findViewById(2131368343);
        localObject2 = localSimpleAccount.getUin();
        ImageView localImageView2 = (ImageView)localView.findViewById(2131364592);
        localImageView2.clearAnimation();
        if ((localObject2 != null) && (((String)localObject2).length() > 0) && (((String)localObject2).equals(this.app.getCurrentAccountUin())) && (!this.jdField_a_of_type_Boolean)) {
          localImageView2.setVisibility(0);
        } else {
          localImageView2.setVisibility(8);
        }
        ((TextView)localView.findViewById(2131361863)).setText((CharSequence)localObject2);
        TextView localTextView = (TextView)localView.findViewById(2131371697);
        if ((this.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject2)) && (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_JavaUtilHashMap.get(localObject2))))
        {
          localObject1 = (String)this.jdField_b_of_type_JavaUtilHashMap.get(localObject2);
        }
        else
        {
          localObject1 = BaseApplicationImpl.sApplication;
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(Constants.PropertiesKey.nickName.toString());
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject3 = ((BaseApplicationImpl)localObject1).getProperty(((StringBuilder)localObject3).toString());
          localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject1 = localObject2;
          }
        }
        localTextView.setText((CharSequence)localObject1);
        ThreadManager.postImmediately(new AccountManageActivity.17(this, localQQAppInterface, (String)localObject2, localSimpleAccount, (String)localObject1, localTextView, localImageView1), null, true);
        if (AppSetting.jdField_d_of_type_Boolean) {
          if (this.jdField_a_of_type_Boolean)
          {
            localView.setContentDescription((CharSequence)localObject1);
          }
          else
          {
            if (localImageView2.getVisibility() == 0) {
              k = 1;
            } else {
              k = 0;
            }
            if (k != 0)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(HardCodeUtil.a(2131699975));
              localView.setContentDescription(((StringBuilder)localObject2).toString());
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(HardCodeUtil.a(2131699971));
              localView.setContentDescription(((StringBuilder)localObject2).toString());
            }
          }
        }
        j += 1;
      }
      return;
    }
    QLog.i("AccountManageActivity", 1, "updateAccountListView accountListLinearLayout is null or size is 0.");
  }
  
  private void v()
  {
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
  }
  
  private void w()
  {
    ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localImageView != null)
    {
      d(localImageView);
      this.jdField_c_of_type_AndroidWidgetImageView = null;
    }
  }
  
  private void x()
  {
    Object localObject = this.jdField_c_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      localObject = (View)((ImageView)localObject).getParent();
      View localView = (View)this.jdField_c_of_type_AndroidWidgetImageView.getTag();
      if (((View)localObject).getTag() != null) {
        ((ObjectAnimator)((View)localObject).getTag()).cancel();
      }
      if (localView.getTag() != null) {
        ((ObjectAnimator)localView.getTag()).cancel();
      }
      ((View)localObject).setTranslationX(0.0F);
      localView.setTranslationX(0.0F);
      this.jdField_c_of_type_AndroidWidgetImageView = null;
    }
  }
  
  private void y()
  {
    ReportController.a(null, "dc00898", "", "", "0X800B42F", "0X800B42F", 0, 0, "", "", "", "");
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131719311)).setMessage(getString(2131719310));
    localQQCustomDialog.setPositiveButton(2131717393, new AccountManageActivity.24(this));
    localQQCustomDialog.setCancelable(true);
    localQQCustomDialog.show();
  }
  
  private void z()
  {
    AppRuntime.Status localStatus = ((IOnlineStatusService)this.app.getRuntimeService(IOnlineStatusService.class)).getOnlineStatus();
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(a());
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(localStatus);
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, String.format("updateOnlineStatus: %s", new Object[] { localStatus }));
    }
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131756189);
    localReportDialog.setContentView(2131559094);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365648);
    if (localTextView != null) {
      if (paramString1 == null)
      {
        localTextView.setVisibility(8);
      }
      else
      {
        localTextView.setVisibility(0);
        localTextView.setText(paramString1);
      }
    }
    paramString1 = (TextView)localReportDialog.findViewById(2131365644);
    if (paramString1 != null) {
      if (paramString2 == null)
      {
        paramString1.setVisibility(8);
      }
      else
      {
        paramString1.setVisibility(0);
        paramString1.setText(paramString2);
      }
    }
    paramString1 = (TextView)localReportDialog.findViewById(2131365633);
    if (paramString1 != null) {
      paramString1.setText(2131690728);
    }
    paramString1 = (TextView)localReportDialog.findViewById(2131365639);
    if (paramString1 != null) {
      paramString1.setText(2131694583);
    }
    localReportDialog.setOnDismissListener(paramOnDismissListener);
    return localReportDialog;
  }
  
  public void a()
  {
    TextView localTextView = this.rightViewText;
    localTextView.setVisibility(0);
    localTextView.setText(2131691859);
    localTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    ReportController.a(this.app, "0X800B7D2");
    this.rightHighLView = ((TextView)getLayoutInflater().inflate(2131558951, null));
    setLayerType(this.rightHighLView);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(this.mDensity * 8.0F));
    this.vg.addView(this.rightHighLView, (ViewGroup.LayoutParams)localObject);
    this.rightHighLView.setVisibility(8);
    this.rightHighLView.setText(2131692486);
    this.rightHighLView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131361866));
    this.jdField_e_of_type_AndroidViewView = findViewById(2131366346);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131373974));
    if (QVipQidProcessor.c().jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem).b(21).d(88).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_g_of_type_AndroidViewView$OnClickListener);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372102));
    z();
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AccountManageActivity.5(this));
    ReportController.a(this.app, "0X800B7D5");
    k();
    this.jdField_a_of_type_ComTencentMobileqqBannerTipsBar = ((TipsBar)findViewById(2131378050));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378045));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378027));
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850855);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378028));
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130850855);
    o();
    localObject = getResources().getDisplayMetrics();
    this.jdField_b_of_type_Float = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131364077));
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      v();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AccountManageActivity.6(this));
    }
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      localTextView.setContentDescription(HardCodeUtil.a(2131699974));
      this.rightHighLView.setContentDescription(HardCodeUtil.a(2131699973));
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131693861));
      this.jdField_b_of_type_AndroidViewView.setContentDescription("退出QQ");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号");
      AccessibilityUtil.a(findViewById(2131361907), false);
    }
    findViewById(2131361907).setOnTouchListener(new AccountManageActivity.7(this));
  }
  
  void a(int paramInt)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
    String[] arrayOfString = getResources().getStringArray(2130968576);
    int j = 0;
    while (j < arrayOfString.length)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(arrayOfString[j], 1);
      j += 1;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$MyOnButtonClickListener.a(paramInt);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$MyOnButtonClickListener);
    localObject = getString(2131699821).replace("${account}", ((SimpleAccount)localObject).getUin());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle((CharSequence)localObject);
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject1 == null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      if (QLog.isColorLevel()) {
        QLog.w("Switch_Account", 2, "onItemLongClick simple account = null");
      }
      return;
    }
    String str1 = ((SimpleAccount)localObject1).getUin();
    String str2 = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_JavaLangString = str1;
    if (str1.equals(str2)) {
      a(this, this.app);
    }
    if (QLog.isColorLevel()) {
      QLog.d("hunter", 2, "++++++++++");
    }
    a(this.jdField_a_of_type_JavaLangString, paramBoolean);
    HistoryChatMsgSearchKeyUtil.a(str1);
    CrmUtils.a(getBaseContext(), str2);
    this.jdField_a_of_type_JavaUtilList.remove(localObject1);
    Object localObject2 = (ISubAccountService)this.app.getRuntimeService(ISubAccountService.class, "");
    if ((localObject2 != null) && (((ISubAccountService)localObject2).isSubAccountUin(str1)))
    {
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).setBindUinStatus(this.app, (byte)0, str1);
      ((ISubAccountService)localObject2).clearUnreadNum(str1);
      ((ISubAccountService)localObject2).updateA2(str1, null, true);
      ((ISubAccountService)localObject2).setStatus(str1, 2);
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(this.app, str1, 7);
      int j = 1 - this.app.getConversationFacade().a(str1, 7000);
      if (j != 0) {
        this.app.getConversationFacade().d(str1, 7000, j);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("deleteAccount() hint need to verify,msg num=1, subUin=");
        ((StringBuilder)localObject2).append(str1);
        QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject2).toString());
      }
    }
    GesturePWDUtils.clearGestureData(getActivity(), ((SimpleAccount)localObject1).getUin());
    if (str1.equals(str2))
    {
      this.app.getApplication().refreAccountList();
      localObject1 = getAppRuntime().getApplication().getAllAccounts();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = (SimpleAccount)((List)localObject1).get(0);
        if (((SimpleAccount)localObject1).isLogined()) {
          getAppRuntime().startPCActivePolling(((SimpleAccount)localObject1).getUin(), "delAccount");
        }
      }
    }
    ThreadManager.post(new AccountManageActivity.22(this, str1, paramBoolean, paramInt), 8, null, true);
  }
  
  void a(View paramView)
  {
    paramView.setVisibility(0);
    a(paramView, 2130771982, 1);
  }
  
  void a(View paramView, int paramInt1, int paramInt2)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(this, paramInt1);
    localAnimation.setFillAfter(true);
    localAnimation.setAnimationListener(new AccountManageActivity.AnimationEndClearListener(this, paramView, paramInt2));
    paramView.clearAnimation();
    paramView.startAnimation(localAnimation);
  }
  
  void a(ImageView paramImageView, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString);
    if (localBitmap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 1, false);
    }
    else
    {
      QQAppInterface localQQAppInterface = this.app;
      paramImageView.setImageBitmap(QQAppInterface.getRoundFaceBitmap(localBitmap));
    }
    paramImageView.setTag(paramString);
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("----clear_sp----deleteDataFromSP: uin:");
      localStringBuilder.append(paramString);
      QLog.d("AccountManageActivity", 2, localStringBuilder.toString());
    }
    paramString = this.app.getApp().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  void a(String paramString, int paramInt)
  {
    runOnUiThread(new AccountManageActivity.31(this, paramString, paramInt));
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject != null)
    {
      if (((LinearLayout)localObject).getChildCount() <= 0) {
        return;
      }
      int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      int j = 0;
      while (j < k)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
        if (((View)localObject).getTag() == null)
        {
          if (paramBoolean)
          {
            ((View)localObject).setOnClickListener(null);
            ((View)localObject).setBackgroundResource(2130850708);
            ((View)localObject).setEnabled(false);
          }
          else
          {
            ((View)localObject).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            ((View)localObject).setBackgroundResource(2130839440);
            ((View)localObject).setEnabled(true);
          }
        }
        else
        {
          if ((localObject instanceof FormItemRelativeLayout))
          {
            FormItemRelativeLayout localFormItemRelativeLayout = (FormItemRelativeLayout)localObject;
            localFormItemRelativeLayout.setNeedFocusBg(paramBoolean ^ true);
            localFormItemRelativeLayout.setBGType(2);
            if ((paramBoolean) && (j == k - 2)) {
              localFormItemRelativeLayout.setBGType(3);
            }
          }
          if (paramBoolean) {
            ((View)localObject).setOnClickListener(null);
          } else {
            ((View)localObject).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          }
        }
        j += 1;
      }
    }
  }
  
  void b()
  {
    t();
    s();
    r();
  }
  
  void b(View paramView)
  {
    paramView.setVisibility(0);
    a(paramView, 2130771981, 2);
  }
  
  void c()
  {
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout;
    if (localObject1 != null)
    {
      if (((LinearLayout)localObject1).getChildCount() <= 0) {
        return;
      }
      int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      int j = 0;
      while (j < k)
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
        Object localObject2 = ((View)localObject1).getTag();
        if (localObject2 == null) {
          return;
        }
        int m = ((Integer)localObject2).intValue();
        localObject2 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
        if (localObject2 == null) {
          return;
        }
        localObject1 = (ImageView)((View)localObject1).findViewById(2131364592);
        if ((((SimpleAccount)localObject2).getUin() != null) && (((SimpleAccount)localObject2).getUin().length() > 0) && (((SimpleAccount)localObject2).getUin().equals(this.app.getCurrentAccountUin())) && (!this.jdField_a_of_type_Boolean)) {
          ((ImageView)localObject1).setVisibility(0);
        } else {
          ((ImageView)localObject1).setVisibility(8);
        }
        j += 1;
      }
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5000);
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog == null) || (localQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label33:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label33;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      if ((paramInt1 != 1000) && (paramInt1 != 9876))
      {
        if ((paramInt1 == 0) && (paramIntent != null)) {
          z();
        }
      }
      else {
        p();
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      super.doOnBackPressed();
      return;
    }
    if (this.i)
    {
      j();
      this.i = false;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558444);
    this.jdField_g_of_type_Boolean = SettingsConfigHelper.a(this.app);
    setTitle(2131699210);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    setContentBackgroundResource(2130838739);
    a();
    p();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.registObserver(this.jdField_b_of_type_MqqObserverAccountObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    ThreadManager.post(new AccountManageActivity.1(this), 5, null, true);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener);
    sendBroadcast(new Intent("before_account_change"));
    ReportController.b(this.app, "dc00898", "", "", "0X800AC37", "0X800AC37", 0, 0, "", "", "", "");
    ReportController.b(this.app, "dc00898", "", "", "0X800735C", "0X800735C", 0, 0, "", "", "", "");
    paramBundle = (IOnlineStatusPermissionManager)((IOnlineStatusManagerService)this.app.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class);
    if (paramBundle != null) {
      paramBundle.a(40001L, false);
    }
    ReportController.a(this.app, "0X800B7D3");
    ReportController.a(this.app, "0X800B7D4");
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.removeHandler(getClass());
    this.app.unRegistObserver(this.jdField_b_of_type_MqqObserverAccountObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    d();
    Object localObject = this.jdField_b_of_type_AndroidAppDialog;
    if ((localObject != null) && (((Dialog)localObject).isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = null;
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    super.doOnDestroy();
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.i = true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    b(false);
    u();
    if (QVipQidProcessor.c().jdField_a_of_type_Boolean)
    {
      A();
      B();
    }
    g();
  }
  
  void e()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131719304)).setMessage(getString(2131719279));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(getString(2131719340), new AccountManageActivity.25(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(getString(2131690728), new AccountManageActivity.26(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void f()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694655);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AccountManageActivity", 2, localException.toString());
      }
    }
  }
  
  public void g()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AccountManageActivity", 2, localException.toString());
      }
    }
  }
  
  void h()
  {
    i();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener == null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new AccountManageActivity.35(this).a();
    }
    Dialog localDialog = a(getString(2131690004), null, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    Object localObject = (TextView)localDialog.findViewById(2131365639);
    ((TextView)localObject).setText(2131690003);
    ((TextView)localObject).setOnClickListener(new AccountManageActivity.36(this, localDialog));
    localObject = (TextView)localDialog.findViewById(2131365633);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new AccountManageActivity.37(this));
    }
    localObject = getString(2131718135);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.jdField_c_of_type_Boolean = SettingCloneUtil.readValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init CheckBox:receiveMsgWhenExitPerfExist:");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(", bReceiveMsgOnExit:");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      QLog.d("AccountManageActivity", 4, ((StringBuilder)localObject).toString());
    }
    localObject = (CheckBox)localDialog.findViewById(2131364597);
    if ((bool) && (this.jdField_c_of_type_Boolean)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.jdField_c_of_type_Boolean);
    this.jdField_c_of_type_AndroidAppDialog = localDialog;
    this.jdField_c_of_type_AndroidAppDialog.show();
    ReportController.a(this.app, "0X800B83D");
  }
  
  void i()
  {
    Dialog localDialog = this.jdField_c_of_type_AndroidAppDialog;
    if ((localDialog == null) || (localDialog.isShowing())) {}
    try
    {
      this.jdField_c_of_type_AndroidAppDialog.dismiss();
      label23:
      this.jdField_c_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  protected void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "onAccountChanged zsw");
    }
    super.onAccountChanged();
    this.app.removeHandler(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    if (this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = false;
      u();
    }
    else
    {
      p();
    }
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.registObserver(this.jdField_b_of_type_MqqObserverAccountObserver);
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "onAccountChanged2");
    }
    ThreadManager.postImmediately(new AccountManageActivity.27(this), null, true);
    ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccountSuccess(this.app, this);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AccountManageActivity.28(this), 500L);
    v();
  }
  
  protected void onAccoutChangeFailed()
  {
    if (!isResume())
    {
      if (QLog.isColorLevel()) {
        QLog.d("AccountManageActivity", 2, "do nothing");
      }
      return;
    }
    QLog.d("AccountManageActivity", 1, "onAccoutChangeFailed");
    g();
    this.jdField_d_of_type_Boolean = false;
    y();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (paramLogoutReason == Constants.LogoutReason.user)
    {
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "zsw onLogout");
      }
      this.jdField_e_of_type_Boolean = false;
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity
 * JD-Core Version:    0.7.0.1
 */