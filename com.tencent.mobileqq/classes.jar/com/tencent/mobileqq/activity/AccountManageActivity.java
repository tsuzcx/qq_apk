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
import com.tencent.mobileqq.config.business.qvip.QVipQidConfig;
import com.tencent.mobileqq.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.login.PwdSetUtil;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
  
  private int a()
  {
    int j;
    if (!VipQidHelper.a(this.app)) {
      if (((RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH)).a("100190.100193.100192") != null) {
        j = 1;
      }
    }
    do
    {
      return j;
      return 2;
      j = 3;
    } while (VipInfoHandler.a(this.app, this.app.getCurrentUin(), false) != 2);
    return 4;
  }
  
  private CharSequence a()
  {
    Object localObject2 = this.app.getOnlineStatus();
    long l = OnLineStatusHelper.a().a(this.app);
    Object localObject1 = OnLineStatusHelper.a().b(l, (AppRuntime.Status)localObject2);
    Friends localFriends = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.app.getCurrentUin());
    localObject2 = OnLineStatusHelper.a().a(l, (AppRuntime.Status)localObject2, 1, localFriends);
    if (localObject2 == null) {
      return localObject1;
    }
    int j = AIOUtils.a(16.0F, getResources());
    ((Drawable)localObject2).setBounds(0, 0, j, j);
    if ((localObject2 instanceof URLDrawable)) {
      ((URLDrawable)localObject2).downloadImediatly();
    }
    localObject2 = new VerticalCenterMarginImageSpan((Drawable)localObject2);
    ((VerticalCenterMarginImageSpan)localObject2).a(AIOUtils.a(8.0F, getResources()));
    localObject1 = new SpannableString("[图片]" + (String)localObject1);
    ((SpannableString)localObject1).setSpan(localObject2, 0, "[图片]".length(), 17);
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
    if (GlobalImageCache.a != null) {}
    try
    {
      GlobalImageCache.a.evictAll();
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
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("AccountManageActivity", 1, "sImageCache.evictAll error : ", localException);
      }
    }
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
  
  private void a(String paramString, boolean paramBoolean)
  {
    ((AccountManager)getAppRuntime().getManager(0)).deleteAccount(this.jdField_a_of_type_JavaLangString, this.app.getUinDisplayNameBeforeLogin(this.jdField_a_of_type_JavaLangString), new AccountManageActivity.DelHistoryAccountObserver(this, paramString, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "am.deleteAccount " + this.jdField_a_of_type_JavaLangString);
    }
    if (paramBoolean) {
      NearbyProxy.a(paramString);
    }
  }
  
  private boolean a()
  {
    boolean bool = true;
    if (PwdSetUtil.a(this.app, this))
    {
      QLog.i("AccountManageActivity", 1, "checkHasSetPwd: return false");
      bool = false;
    }
    return bool;
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject3 = (SubAccountManager)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    int n = ((SubAccountManager)localObject3).a();
    Object localObject1 = (TipsBar)findViewById(2131378657);
    ((TipsBar)localObject1).setBackgroundColor(getResources().getColor(2131167005));
    ((TipsBar)localObject1).setTipsIcon(getResources().getDrawable(2130850913));
    ((TipsBar)localObject1).a().setTextColor(getResources().getColorStateList(2131167040));
    if (((TipsBar)localObject1).a() != null) {
      ((TipsBar)localObject1).a().setVisibility(8);
    }
    int k = 0;
    int m = 0;
    int j;
    Object localObject2;
    boolean bool;
    if (paramBoolean)
    {
      j = m;
      if (!this.jdField_f_of_type_Boolean)
      {
        j = m;
        if (n == 0)
        {
          if (!DBUtils.a().a()) {
            break label674;
          }
          if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(5000)) {
            break label649;
          }
          j = m;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("AccountManagerActivity.refreshSubAccount() isAccount2Bind=");
        if (n <= 0) {
          break label679;
        }
        bool = true;
        label181:
        QLog.d("AccountManageActivity", 2, bool);
      }
      k = j;
      if (n == 0)
      {
        ThreadManager.post(new AccountManageActivity.12(this), 8, null, false);
        k = j;
      }
    }
    if ((k == 0) && (n == 1)) {
      if (DBUtils.a().a(this.app.getCurrentAccountUin())) {
        j = k;
      }
    }
    for (;;)
    {
      switch (j)
      {
      default: 
        label250:
        if (((TipsBar)localObject1).getVisibility() != 8) {
          ((TipsBar)localObject1).setVisibility(8);
        }
        label293:
        if (((TipsBar)localObject1).getVisibility() == 0) {
          ((TipsBar)localObject1).setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
        }
        localObject1 = null;
        localObject2 = null;
        if (n == 1)
        {
          SubAccountInfo localSubAccountInfo = ((SubAccountManager)localObject3).a("sub.uin.default");
          localObject1 = localObject2;
          if (localSubAccountInfo != null)
          {
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(localSubAccountInfo.subuin))
            {
              localObject2 = localSubAccountInfo.subname;
              localObject3 = ContactUtils.d(this.app, localSubAccountInfo.subuin, true);
              localObject1 = localObject2;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                if (!TextUtils.isEmpty(localSubAccountInfo.subname))
                {
                  localObject1 = localObject2;
                  if (((String)localObject3).equals(localSubAccountInfo.subname)) {}
                }
                else
                {
                  localSubAccountInfo.subname = ((String)localObject3);
                  localObject1 = localObject3;
                }
              }
            }
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (localSubAccountInfo != null) {
              localObject2 = localSubAccountInfo.subuin;
            }
          }
          if (localSubAccountInfo != null) {
            a(this.jdField_b_of_type_AndroidWidgetImageView, localSubAccountInfo.subuin);
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          label489:
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("refreshSubAccount() uin=").append(this.app.getCurrentAccountUin()).append(" isAccountChanged=").append(paramBoolean).append(" isAccount1Bind=").append(this.jdField_f_of_type_Boolean).append(" account2BindedNum=").append(n).append(" final action=").append(j).append(" sAccountName=");
            if (((String)localObject1).length() != 0) {
              break label1069;
            }
            localObject2 = "_empty_";
          }
        }
        break;
      }
      for (;;)
      {
        QLog.d("SUB_ACCOUNT", 2, (String)localObject2);
        if (AppSetting.jdField_d_of_type_Boolean) {
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号" + (String)localObject1);
        }
        return;
        label649:
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
        {
          j = m;
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
            break;
          }
        }
        j = 2;
        break;
        label674:
        j = 1;
        break;
        label679:
        bool = false;
        break label181;
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 4)) {
          break label1149;
        }
        j = 3;
        break label250;
        DBUtils.a().a(true);
        d();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5000, 1000L);
        if (((TipsBar)localObject1).getVisibility() == 8) {
          break label293;
        }
        ((TipsBar)localObject1).setVisibility(8);
        break label293;
        ReportController.b(this.app, "CliOper", "", "", "0X8004001", "0X8004001", 0, 0, "", "", "", "");
        ((TipsBar)localObject1).setTag("0X8004001");
        localObject2 = getString(2131719574);
        ((TipsBar)localObject1).setTipsText((CharSequence)localObject2);
        if (AppSetting.jdField_d_of_type_Boolean) {
          ((TipsBar)localObject1).setContentDescription((CharSequence)localObject2);
        }
        if (((TipsBar)localObject1).getVisibility() != 0) {
          ((TipsBar)localObject1).setVisibility(0);
        }
        d();
        break label293;
        ((TipsBar)localObject1).setTag("0X8004456");
        localObject2 = getString(2131719606);
        ((TipsBar)localObject1).setTipsText((CharSequence)localObject2);
        if (AppSetting.jdField_d_of_type_Boolean) {
          ((TipsBar)localObject1).setContentDescription((CharSequence)localObject2);
        }
        if (((TipsBar)localObject1).getVisibility() != 0)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8004456", "0X8004456", 0, 0, "", "", "", "");
          ((TipsBar)localObject1).setVisibility(0);
        }
        d();
        break label293;
        if (n > 1)
        {
          localObject2 = n + HardCodeUtil.a(2131699831);
          localObject1 = ((SubAccountManager)localObject3).a();
          if (((ArrayList)localObject1).size() == 2)
          {
            a(this.jdField_b_of_type_AndroidWidgetImageView, (String)((ArrayList)localObject1).get(0));
            this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            a(this.jdField_a_of_type_AndroidWidgetImageView, (String)((ArrayList)localObject1).get(1));
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          break label489;
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject2 = localObject1;
        break label489;
        label1069:
        if ((((String)localObject1).length() == 1) || (((String)localObject1).length() == 2)) {
          localObject2 = localObject1;
        } else if (((String)localObject1).length() > 2) {
          localObject2 = ((String)localObject1).substring(0, 2) + "|" + ((String)localObject1).length();
        } else {
          localObject2 = localObject1;
        }
      }
      label1149:
      j = k;
    }
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
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      label17:
      this.jdField_a_of_type_Boolean = bool;
      if (!this.jdField_a_of_type_Boolean) {
        break label151;
      }
      this.rightViewText.setVisibility(8);
      this.rightHighLView.setVisibility(0);
      this.rightViewText.setText(2131692534);
    }
    for (;;)
    {
      b();
      a(this.jdField_a_of_type_Boolean);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AccountManageActivity.4(this), 250L);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_acc_edit", 0, 0, "", "", "", "");
      ReportController.a(this.app, "0X800B836");
      return;
      bool = false;
      break label17;
      label151:
      this.rightViewText.setVisibility(0);
      this.rightHighLView.setVisibility(8);
      this.rightViewText.setText(2131691933);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370843);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131375240);
    this.jdField_c_of_type_AndroidViewView = findViewById(2131372194);
    if (this.jdField_g_of_type_Boolean)
    {
      this.h = true;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(new ActionMenuItem(getString(2131690084), 1, 0), 0);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addButton(new ActionMenuItem(getString(2131690086), 2, 0), 0);
      this.jdField_b_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new AccountManageActivity.8(this));
      this.jdField_b_of_type_ComTencentWidgetActionSheet.addCancelButton(getString(2131690085));
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
    if (QLog.isColorLevel()) {
      QLog.i("AccountManageActivity", 2, "showLogoutDialog");
    }
    if (!a()) {}
    while ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing())) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays > 0L)
      {
        FriendProfileCardActivity.a = this.jdField_a_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays != 1L) && ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays <= 1L) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= FriendProfileCardActivity.a))) {
          break label198;
        }
        localObject = String.format(getString(2131693909), new Object[] { Integer.valueOf((int)(FriendProfileCardActivity.a - this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays)) });
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidAppDialog == null) {
        break label280;
      }
      localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365807);
      if (localTextView != null)
      {
        localTextView.requestFocus();
        localTextView.setText((CharSequence)localObject);
        localTextView.setContentDescription((CharSequence)localObject);
      }
      this.jdField_b_of_type_AndroidAppDialog.show();
      return;
      FriendProfileCardActivity.a = 30L;
      break;
      label198:
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= FriendProfileCardActivity.a)
      {
        localObject = String.format(getString(2131693910), new Object[] { Integer.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
      else
      {
        localObject = String.format(getString(2131693911), new Object[0]);
        continue;
        localObject = String.format(getString(2131693911), new Object[0]);
      }
    }
    label280:
    this.jdField_b_of_type_AndroidAppDialog = new ReportDialog(this, 2131755842);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2131559060);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365811);
    if (localTextView != null)
    {
      localTextView.setVisibility(4);
      ((ViewGroup.MarginLayoutParams)localTextView.getLayoutParams()).bottomMargin = 0;
      localTextView.setHeight(0);
      localTextView.setLayoutParams(localTextView.getLayoutParams());
    }
    localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365807);
    if (localTextView != null)
    {
      localTextView.requestFocus();
      localTextView.setText((CharSequence)localObject);
      localTextView.setContentDescription((CharSequence)localObject);
    }
    Object localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365796);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131690800);
      ((TextView)localObject).setOnClickListener(new AccountManageActivity.14(this));
    }
    localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365802);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131693908);
      ((TextView)localObject).setOnClickListener(new AccountManageActivity.15(this));
    }
    this.jdField_b_of_type_AndroidAppDialog.show();
    ReportController.a(this.app, "0X800B83C");
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131755842);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558435);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365807)).setText(getString(2131691583));
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
  }
  
  private void n()
  {
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      getAppRuntime().getApplication().refreAccountList();
      localObject2 = getAppRuntime().getApplication().getAllAccounts();
      StringBuilder localStringBuilder = new StringBuilder().append("initAccountList list=").append(localObject2).append(", size=");
      if (localObject2 == null) {
        break label205;
      }
      localObject1 = Integer.valueOf(((List)localObject2).size());
      label78:
      QLog.i("AccountManageActivity", 1, localObject1);
      if (localObject2 != null) {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.add(null);
      }
      localObject2 = new StringBuilder().append("initAccountList accountList=").append(this.jdField_a_of_type_JavaUtilList).append(", size=");
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label212;
      }
    }
    label205:
    label212:
    for (Object localObject1 = Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size());; localObject1 = "null")
    {
      QLog.i("AccountManageActivity", 1, localObject1);
      o();
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      localObject1 = "null";
      break label78;
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    AccountManageActivity.16 local16 = new AccountManageActivity.16(this);
    int j = 0;
    if (j < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AccountManageActivity", 2, "bindAccountListView i=" + j + ", account=" + this.jdField_a_of_type_JavaUtilList.get(j));
      }
      if (this.jdField_a_of_type_JavaUtilList.get(j) == null)
      {
        this.jdField_d_of_type_AndroidViewView = getLayoutInflater().inflate(2131558414, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        this.jdField_d_of_type_AndroidViewView.setTag(null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_d_of_type_AndroidViewView);
      }
      for (;;)
      {
        j += 1;
        break;
        View localView1 = getLayoutInflater().inflate(2131558415, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        localView1.setTag(Integer.valueOf(j));
        localView1.setOnTouchListener(local16);
        ((ImageView)localView1.findViewById(2131368603)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localView1.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if ((localView1 instanceof FormItemRelativeLayout))
        {
          ((FormItemRelativeLayout)localView1).setNeedFocusBg(true);
          ((FormItemRelativeLayout)localView1).setBGType(2);
        }
        Button localButton = (Button)localView1.findViewById(2131365622);
        localButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_Int = localButton.getLayoutParams().width;
        View localView2 = localView1.findViewById(2131365652);
        localView2.setTag(localButton);
        localView2.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView1);
      }
    }
    s();
  }
  
  private void p()
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
  
  private void q()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      b(this.leftView);
      return;
    }
    a(this.leftView);
  }
  
  private void r()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int j = 0;
    label28:
    Object localObject2;
    if (j < k)
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
      localObject1 = ((View)localObject2).getTag();
      if (localObject1 != null) {
        break label62;
      }
    }
    label62:
    ImageView localImageView;
    for (;;)
    {
      j += 1;
      break label28;
      break;
      localImageView = (ImageView)((View)localObject2).findViewById(2131364705);
      localObject2 = (ImageView)((View)localObject2).findViewById(2131365652);
      if (!this.jdField_a_of_type_Boolean) {
        break label118;
      }
      if (localImageView.getVisibility() == 0) {
        b(localImageView);
      }
      ((ImageView)localObject2).setVisibility(0);
    }
    label118:
    int m = ((Integer)localObject1).intValue();
    Object localObject1 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
    if ((localObject1 != null) && (((SimpleAccount)localObject1).getUin() != null) && (((SimpleAccount)localObject1).getUin().length() > 0) && (((SimpleAccount)localObject1).getUin().equals(this.app.getCurrentAccountUin()))) {
      localImageView.setVisibility(0);
    }
    for (;;)
    {
      if (localImageView.getVisibility() == 0) {
        a(localImageView);
      }
      ((ImageView)localObject2).setVisibility(8);
      v();
      break;
      localImageView.setVisibility(8);
    }
  }
  
  private void s()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      QLog.i("AccountManageActivity", 1, "updateAccountListView accountListLinearLayout is null or size is 0.");
    }
    QQAppInterface localQQAppInterface;
    int j;
    label71:
    View localView;
    Object localObject;
    int k;
    SimpleAccount localSimpleAccount;
    do
    {
      do
      {
        return;
        int m = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        QLog.i("AccountManageActivity", 1, "updateAccountListView account size=" + m);
        localQQAppInterface = this.app;
        j = 0;
        if (j >= m) {
          break;
        }
        localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
        localObject = localView.getTag();
        QLog.i("AccountManageActivity", 1, "updateAccountListView i=" + j + ", view tag=" + localObject);
      } while (localObject == null);
      k = ((Integer)localObject).intValue();
      if (k >= this.jdField_a_of_type_JavaUtilList.size())
      {
        QLog.e("AccountManageActivity", 1, "updateAccountListView, view tag is large than account list size");
        finish();
        return;
      }
      localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
    } while (localSimpleAccount == null);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131368603);
    String str1 = localSimpleAccount.getUin();
    ImageView localImageView2 = (ImageView)localView.findViewById(2131364705);
    localImageView2.clearAnimation();
    if ((str1 != null) && (str1.length() > 0) && (str1.equals(this.app.getCurrentAccountUin())) && (!this.jdField_a_of_type_Boolean))
    {
      localImageView2.setVisibility(0);
      label272:
      ((TextView)localView.findViewById(2131361857)).setText(str1);
      TextView localTextView = (TextView)localView.findViewById(2131372115);
      if ((this.jdField_b_of_type_JavaUtilHashMap.containsKey(str1)) && (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_JavaUtilHashMap.get(str1)))) {
        break label448;
      }
      String str2 = BaseApplicationImpl.sApplication.getProperty(Constants.PropertiesKey.nickName.toString() + str1);
      localObject = str2;
      if (TextUtils.isEmpty(str2)) {
        localObject = str1;
      }
      label379:
      localTextView.setText((CharSequence)localObject);
      ThreadManager.postImmediately(new AccountManageActivity.17(this, localQQAppInterface, str1, localSimpleAccount, (String)localObject, localTextView, localImageView1), null, true);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label465;
        }
        localView.setContentDescription((CharSequence)localObject);
      }
    }
    for (;;)
    {
      j += 1;
      break label71;
      break;
      localImageView2.setVisibility(8);
      break label272;
      label448:
      localObject = (String)this.jdField_b_of_type_JavaUtilHashMap.get(str1);
      break label379;
      label465:
      if (localImageView2.getVisibility() == 0) {}
      for (k = 1;; k = 0)
      {
        if (k == 0) {
          break label516;
        }
        localView.setContentDescription((String)localObject + HardCodeUtil.a(2131699834));
        break;
      }
      label516:
      localView.setContentDescription((String)localObject + HardCodeUtil.a(2131699830));
    }
  }
  
  private void t()
  {
    boolean bool = SettingCloneUtil.readValue(this, this.app.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
  }
  
  private void u()
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      d(this.jdField_c_of_type_AndroidWidgetImageView);
      this.jdField_c_of_type_AndroidWidgetImageView = null;
    }
  }
  
  private void v()
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      View localView1 = (View)this.jdField_c_of_type_AndroidWidgetImageView.getParent();
      View localView2 = (View)this.jdField_c_of_type_AndroidWidgetImageView.getTag();
      if (localView1.getTag() != null) {
        ((ObjectAnimator)localView1.getTag()).cancel();
      }
      if (localView2.getTag() != null) {
        ((ObjectAnimator)localView2.getTag()).cancel();
      }
      localView1.setTranslationX(0.0F);
      localView2.setTranslationX(0.0F);
      this.jdField_c_of_type_AndroidWidgetImageView = null;
    }
  }
  
  private void w()
  {
    ReportController.a(null, "dc00898", "", "", "0X800B42F", "0X800B42F", 0, 0, "", "", "", "");
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131719592)).setMessage(getString(2131719591));
    localQQCustomDialog.setPositiveButton(2131717734, new AccountManageActivity.24(this));
    localQQCustomDialog.setCancelable(true);
    localQQCustomDialog.show();
  }
  
  private void x()
  {
    AppRuntime.Status localStatus = this.app.getOnlineStatus();
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText(a());
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setTag(localStatus);
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, String.format("updateOnlineStatus: %s", new Object[] { localStatus }));
    }
  }
  
  private void y()
  {
    FormSimpleItem localFormSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
    if (VipQidHelper.a(this.app)) {}
    for (String str = "已开启";; str = "未开启")
    {
      localFormSimpleItem.setRightText(str);
      VipQidHelper.a("0X800B5C6", a());
      return;
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("100190.100193.100192");
      if (localAppInfo != null) {
        localRedTouchManager.a("100190.100193.100192", 30);
      }
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
    }
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131755842);
    localReportDialog.setContentView(2131559216);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131365811);
    if (localTextView != null)
    {
      if (paramString1 == null) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      paramString1 = (TextView)localReportDialog.findViewById(2131365807);
      if (paramString1 != null)
      {
        if (paramString2 != null) {
          break label149;
        }
        paramString1.setVisibility(8);
      }
    }
    for (;;)
    {
      paramString1 = (TextView)localReportDialog.findViewById(2131365796);
      if (paramString1 != null) {
        paramString1.setText(2131690800);
      }
      paramString1 = (TextView)localReportDialog.findViewById(2131365802);
      if (paramString1 != null) {
        paramString1.setText(2131694615);
      }
      localReportDialog.setOnDismissListener(paramOnDismissListener);
      return localReportDialog;
      localTextView.setVisibility(0);
      localTextView.setText(paramString1);
      break;
      label149:
      paramString1.setVisibility(0);
      paramString1.setText(paramString2);
    }
  }
  
  public void a()
  {
    TextView localTextView = this.rightViewText;
    localTextView.setVisibility(0);
    localTextView.setText(2131691933);
    localTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    ReportController.a(this.app, "0X800B7D2");
    this.rightHighLView = ((TextView)getLayoutInflater().inflate(2131559057, null));
    setLayerType(this.rightHighLView);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(8.0F * this.mDensity));
    this.vg.addView(this.rightHighLView, (ViewGroup.LayoutParams)localObject);
    this.rightHighLView.setVisibility(8);
    this.rightHighLView.setText(2131692534);
    this.rightHighLView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131361860));
    this.jdField_e_of_type_AndroidViewView = findViewById(2131366467);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131374424));
    if (QVipQidProcessor.c().jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem).b(21).d(88).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_g_of_type_AndroidViewView$OnClickListener);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131372518));
      x();
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new AccountManageActivity.5(this));
      ReportController.a(this.app, "0X800B7D5");
      k();
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131378652));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378635));
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130850915);
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378636));
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundResource(2130850915);
      m();
      localObject = getResources().getDisplayMetrics();
      this.jdField_b_of_type_Float = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131364156));
      if (!this.jdField_g_of_type_Boolean) {
        break label520;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(8);
    }
    for (;;)
    {
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        localTextView.setContentDescription(HardCodeUtil.a(2131699833));
        this.rightHighLView.setContentDescription(HardCodeUtil.a(2131699832));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131693907));
        this.jdField_b_of_type_AndroidViewView.setContentDescription("退出QQ");
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号");
        AccessibilityUtil.a(findViewById(2131361901), false);
      }
      findViewById(2131361901).setOnTouchListener(new AccountManageActivity.7(this));
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      break;
      label520:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setVisibility(0);
      t();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new AccountManageActivity.6(this));
    }
  }
  
  void a(int paramInt)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      String[] arrayOfString = getResources().getStringArray(2130968576);
      int j = 0;
      while (j < arrayOfString.length)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(arrayOfString[j], 1);
        j += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$MyOnButtonClickListener.a(paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$MyOnButtonClickListener);
      localObject = getString(2131699688).replace("${account}", ((SimpleAccount)localObject).getUin());
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setMainTitle((CharSequence)localObject);
    } while (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null)
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      if (QLog.isColorLevel()) {
        QLog.w("Switch_Account", 2, "onItemLongClick simple account = null");
      }
      return;
    }
    String str1 = ((SimpleAccount)localObject).getUin();
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
    this.jdField_a_of_type_JavaUtilList.remove(localObject);
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if ((localSubAccountManager != null) && (localSubAccountManager.a(str1)))
    {
      SubAccountControll.a(this.app, (byte)0, str1);
      localSubAccountManager.f(str1);
      localSubAccountManager.a(str1, null, true);
      localSubAccountManager.a(str1, 2);
      SubAccountControll.a(this.app, str1, 7);
      int j = 1 - this.app.getConversationFacade().a(str1, 7000);
      if (j != 0) {
        this.app.getConversationFacade().d(str1, 7000, j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "deleteAccount() hint need to verify,msg num=1, subUin=" + str1);
      }
    }
    GesturePWDUtils.clearGestureData(getActivity(), ((SimpleAccount)localObject).getUin());
    if (str1.equals(str2))
    {
      this.app.getApplication().refreAccountList();
      localObject = getAppRuntime().getApplication().getAllAccounts();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (SimpleAccount)((List)localObject).get(0);
        if (((SimpleAccount)localObject).isLogined()) {
          getAppRuntime().startPCActivePolling(((SimpleAccount)localObject).getUin(), "delAccount");
        }
      }
    }
    ThreadManager.post(new AccountManageActivity.22(this, str1, paramBoolean, paramInt), 8, null, true);
  }
  
  void a(View paramView)
  {
    paramView.setVisibility(0);
    a(paramView, 2130771970, 1);
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
    if (localBitmap == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 1, false);
    }
    for (;;)
    {
      paramImageView.setTag(paramString);
      return;
      QQAppInterface localQQAppInterface = this.app;
      paramImageView.setImageBitmap(QQAppInterface.getRoundFaceBitmap(localBitmap));
    }
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
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
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int j = 0;
    label28:
    View localView;
    if (j < k)
    {
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
      if (localView.getTag() != null) {
        break label108;
      }
      if (!paramBoolean) {
        break label82;
      }
      localView.setOnClickListener(null);
      localView.setBackgroundResource(2130850782);
      localView.setEnabled(false);
    }
    for (;;)
    {
      j += 1;
      break label28;
      break;
      label82:
      localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localView.setBackgroundResource(2130839582);
      localView.setEnabled(true);
      continue;
      label108:
      FormItemRelativeLayout localFormItemRelativeLayout;
      if ((localView instanceof FormItemRelativeLayout))
      {
        localFormItemRelativeLayout = (FormItemRelativeLayout)localView;
        if (paramBoolean) {
          break label173;
        }
      }
      label173:
      for (boolean bool = true;; bool = false)
      {
        localFormItemRelativeLayout.setNeedFocusBg(bool);
        localFormItemRelativeLayout.setBGType(2);
        if ((paramBoolean) && (j == k - 2)) {
          localFormItemRelativeLayout.setBGType(3);
        }
        if (!paramBoolean) {
          break label179;
        }
        localView.setOnClickListener(null);
        break;
      }
      label179:
      localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  void b()
  {
    r();
    q();
    p();
  }
  
  void b(View paramView)
  {
    paramView.setVisibility(0);
    a(paramView, 2130771969, 2);
  }
  
  void c()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {}
    int j;
    label28:
    Object localObject2;
    do
    {
      do
      {
        return;
        int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        j = 0;
        if (j >= k) {
          break;
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(j);
        localObject2 = ((View)localObject1).getTag();
      } while (localObject2 == null);
      int m = ((Integer)localObject2).intValue();
      localObject2 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
    } while (localObject2 == null);
    Object localObject1 = (ImageView)((View)localObject1).findViewById(2131364705);
    if ((((SimpleAccount)localObject2).getUin() != null) && (((SimpleAccount)localObject2).getUin().length() > 0) && (((SimpleAccount)localObject2).getUin().equals(this.app.getCurrentAccountUin())) && (!this.jdField_a_of_type_Boolean)) {
      ((ImageView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      j += 1;
      break label28;
      break;
      ((ImageView)localObject1).setVisibility(8);
    }
  }
  
  void d()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(5000);
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) || (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      label34:
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label34;
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
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      if ((paramInt1 != 1000) && (paramInt1 != 9876)) {
        break label24;
      }
      n();
    }
    label24:
    while ((paramInt1 != 0) || (paramIntent == null)) {
      return;
    }
    x();
  }
  
  public void doOnBackPressed()
  {
    if (!this.jdField_a_of_type_Boolean) {
      super.doOnBackPressed();
    }
    while (!this.i) {
      return;
    }
    j();
    this.i = false;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131558416);
    this.jdField_g_of_type_Boolean = SettingsConfigHelper.a(this.app);
    setTitle(2131699106);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    setContentBackgroundResource(2130838979);
    a();
    n();
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
    ((OnlineStatusPermissionManager)this.app.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER)).a(40001L, false);
    ReportController.a(this.app, "0X800B7D3");
    ReportController.a(this.app, "0X800B7D4");
    return true;
  }
  
  public void doOnDestroy()
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
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
      this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = null;
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    }
    super.doOnDestroy();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.i = true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    b(false);
    s();
    if (QVipQidProcessor.c().jdField_a_of_type_Boolean)
    {
      y();
      z();
    }
    g();
  }
  
  void e()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131719585)).setMessage(getString(2131719560));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(getString(2131719621), new AccountManageActivity.25(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(getString(2131690800), new AccountManageActivity.26(this));
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131694686);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AccountManageActivity", 2, localException.toString());
    }
  }
  
  public void g()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("AccountManageActivity", 2, localException.toString());
    }
  }
  
  void h()
  {
    i();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener == null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener = new AccountManageActivity.35(this).a();
    }
    Dialog localDialog = a(getString(2131690088), null, this.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
    Object localObject = (TextView)localDialog.findViewById(2131365802);
    ((TextView)localObject).setText(2131690087);
    ((TextView)localObject).setOnClickListener(new AccountManageActivity.36(this, localDialog));
    localObject = (TextView)localDialog.findViewById(2131365796);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new AccountManageActivity.37(this));
    }
    localObject = getString(2131718470);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.jdField_c_of_type_Boolean = SettingCloneUtil.readValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountManageActivity", 4, "init CheckBox:receiveMsgWhenExitPerfExist:" + bool + ", bReceiveMsgOnExit:" + this.jdField_c_of_type_Boolean);
    }
    localObject = (CheckBox)localDialog.findViewById(2131364710);
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
    if ((this.jdField_c_of_type_AndroidAppDialog == null) || (this.jdField_c_of_type_AndroidAppDialog.isShowing())) {}
    try
    {
      this.jdField_c_of_type_AndroidAppDialog.dismiss();
      label24:
      this.jdField_c_of_type_AndroidAppDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public void onAccountChanged()
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
      s();
    }
    for (;;)
    {
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
      SubAccountAssistantForward.a(this.app, this);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AccountManageActivity.28(this), 500L);
      t();
      return;
      n();
    }
  }
  
  public void onAccoutChangeFailed()
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
    w();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onLogout(Constants.LogoutReason paramLogoutReason)
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
    b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity
 * JD-Core Version:    0.7.0.1
 */