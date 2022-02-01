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
import com.tencent.mobileqq.simpleui.SimpleUIFixHelper;
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
  private FormSimpleItem A;
  private ImageView B;
  private ImageView C;
  private ActionSheet D;
  private TipsBar E;
  private boolean F = false;
  private boolean G = false;
  private float H;
  private boolean I = false;
  private Card J = null;
  private IFaceDecoder K;
  private boolean L = false;
  private int M = 0;
  private boolean N = false;
  private MqqHandler O = new AccountManageActivity.2(this);
  private View.OnClickListener P = new AccountManageActivity.3(this);
  private View.OnClickListener Q = new AccountManageActivity.10(this);
  private HashMap<String, Bitmap> R = new HashMap();
  private HashMap<String, String> S = new HashMap();
  private ImageView T;
  private View.OnClickListener U = new AccountManageActivity.17(this);
  private View.OnClickListener V = new AccountManageActivity.18(this);
  private AccountManageActivity.MyOnButtonClickListener W = new AccountManageActivity.MyOnButtonClickListener(this);
  private String X;
  private SubAccountBindObserver Y = new AccountManageActivity.29(this);
  private MessageObserver Z = new AccountManageActivity.30(this);
  LinearLayout a;
  private QQProgressDialog aa;
  private View.OnClickListener ab = new AccountManageActivity.31(this);
  private AccountObserver ac = new AccountManageActivity.35(this);
  private OnlineStatusObserver ad = new AccountManageActivity.36(this);
  private DecodeTaskCompletionListener ae = new AccountManageActivity.37(this);
  FormSimpleItem b;
  RedTouch c;
  FormSimpleItem d;
  List<SimpleAccount> e;
  float f;
  Dialog g;
  Dialog h;
  QQCustomDialog i;
  DialogInterface.OnDismissListener j;
  boolean k = false;
  boolean l = true;
  SimpleAccount m = null;
  View.OnClickListener n = new AccountManageActivity.15(this);
  View.OnClickListener o = new AccountManageActivity.16(this);
  ActionSheet p = null;
  AccountObserver q = new AccountManageActivity.20(this);
  AvatarObserver r = new AccountManageActivity.26(this);
  FriendListObserver s = new AccountManageActivity.27(this);
  Dialog t;
  boolean u = true;
  private View v;
  private View w;
  private View x;
  private View y;
  private View z;
  
  private CharSequence A()
  {
    Object localObject2 = ((IOnlineStatusService)this.app.getRuntimeService(IOnlineStatusService.class)).getOnlineStatus();
    long l1 = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(this.app);
    Object localObject1 = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfStatusNameBySubTitle(l1, (AppRuntime.Status)localObject2);
    Object localObject3 = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.app.getCurrentUin());
    localObject2 = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfStatusDrawable(l1, (AppRuntime.Status)localObject2, 1, (Friends)localObject3);
    if (localObject2 == null) {
      return localObject1;
    }
    int i1 = AIOUtils.b(16.0F, getResources());
    ((Drawable)localObject2).setBounds(0, 0, i1, i1);
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
  
  private void B()
  {
    FormSimpleItem localFormSimpleItem = this.b;
    String str;
    if (VipQidHelper.a(this.app)) {
      str = "已开启";
    } else {
      str = "未开启";
    }
    localFormSimpleItem.setRightText(str);
    VipQidHelper.a("0X800B5C6", D());
  }
  
  private void C()
  {
    if (this.c != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("100190.100193.100192");
      if (localAppInfo != null) {
        localIRedTouchManager.reportLevelOneRedInfo("100190.100193.100192", 30);
      }
      this.c.a(localAppInfo);
    }
  }
  
  private int D()
  {
    boolean bool = VipQidHelper.a(this.app);
    int i1 = 2;
    if (!bool)
    {
      if (((IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("100190.100193.100192") != null) {
        i1 = 1;
      }
      return i1;
    }
    i1 = 3;
    if (VipInfoHandler.a(this.app, this.app.getCurrentUin(), false) == 2) {
      i1 = 4;
    }
    return i1;
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.j();
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
    int i1 = QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i1 + 1);
    RouteUtils.a(paramActivity, localIntent, "/base/login");
    if (QQPlayerService.b())
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
        a(this.C, localSubAccountInfo.subuin);
      }
      this.C.setVisibility(0);
      this.B.setVisibility(8);
      paramISubAccountService = (ISubAccountService)localObject1;
    }
    else if (paramInt > 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131898018));
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = paramISubAccountService.getAllSubUin();
      paramISubAccountService = (ISubAccountService)localObject1;
      if (((ArrayList)localObject2).size() == 2)
      {
        a(this.C, (String)((ArrayList)localObject2).get(0));
        this.C.setVisibility(0);
        a(this.B, (String)((ArrayList)localObject2).get(1));
        this.B.setVisibility(0);
        paramISubAccountService = (ISubAccountService)localObject1;
      }
    }
    else
    {
      this.B.setVisibility(8);
      this.C.setVisibility(8);
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
      ((StringBuilder)localObject2).append(this.I);
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
    if (AppSetting.e)
    {
      paramISubAccountService = this.A;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("关联QQ号");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramISubAccountService.setContentDescription(((StringBuilder)localObject2).toString());
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    ((AccountManager)getAppRuntime().getManager(0)).deleteAccount(this.X, this.app.getUinDisplayNameBeforeLogin(this.X), new AccountManageActivity.DelHistoryAccountObserver(this, paramString, paramBoolean));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("am.deleteAccount ");
      localStringBuilder.append(this.X);
      QLog.d("Switch_Account", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      NearbyProxyUtils.a(paramString);
    }
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    l();
    int i1 = 0;
    boolean bool = false;
    if (paramBoolean)
    {
      if ((!this.I) && (paramInt == 0)) {
        if (DBUtils.a().b())
        {
          if (!this.O.hasMessages(5000))
          {
            localObject = this.i;
            if ((localObject == null) || (!((QQCustomDialog)localObject).isShowing()))
            {
              i1 = 2;
              break label83;
            }
          }
        }
        else
        {
          i1 = 1;
          break label83;
        }
      }
      i1 = 0;
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
    int i2 = i1;
    if (i1 == 0)
    {
      i2 = i1;
      if (paramInt == 1) {
        if (DBUtils.a().a(this.app.getCurrentAccountUin()))
        {
          i2 = i1;
        }
        else
        {
          localObject = this.e;
          i2 = i1;
          if (localObject != null)
          {
            i2 = i1;
            if (((List)localObject).size() >= 4) {
              i2 = 3;
            }
          }
        }
      }
    }
    b(i2);
    if (this.E.getVisibility() == 0) {
      this.E.setOnClickListener(this.Q);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshSubAccountTipbar() isAccountChanged=");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" isAccount1Bind=");
    ((StringBuilder)localObject).append(this.I);
    ((StringBuilder)localObject).append(" account2BindedNum=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" final action=");
    ((StringBuilder)localObject).append(i2);
    QLog.d("AccountManageActivity", 1, ((StringBuilder)localObject).toString());
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
          if (this.E.getVisibility() != 8) {
            this.E.setVisibility(8);
          }
        }
        else
        {
          this.E.setTag("0X8004456");
          str = getString(2131916877);
          this.E.setTipsText(str);
          if (AppSetting.e) {
            this.E.setContentDescription(str);
          }
          if (this.E.getVisibility() != 0)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X8004456", "0X8004456", 0, 0, "", "", "", "");
            QLog.d("AccountManageActivity", 2, "showSubAccountTipbarByAction AccountManageActivity-bannerShow HINT_BIND_QQ_AGAIN");
            ReportController.b(this.app, "dc00898", "", "", "0X800BDF1", "0X800BDF1", 0, 0, "", "", "", "");
            this.E.setVisibility(0);
          }
          d();
        }
      }
      else
      {
        ReportController.b(this.app, "CliOper", "", "", "0X8004001", "0X8004001", 0, 0, "", "", "", "");
        this.E.setTag("0X8004001");
        str = getString(2131916845);
        this.E.setTipsText(str);
        if (AppSetting.e) {
          this.E.setContentDescription(str);
        }
        if (this.E.getVisibility() != 0)
        {
          this.E.setVisibility(0);
          QLog.d("AccountManageActivity", 2, "showSubAccountTipbarByAction AccountManageActivity-bannerShow HINT_BIND_N_QQ");
          ReportController.b(this.app, "dc00898", "", "", "0X800BDF1", "0X800BDF1", 0, 0, "", "", "", "");
        }
        d();
      }
    }
    else
    {
      DBUtils.a().a(true);
      d();
      this.O.sendEmptyMessageDelayed(5000, 1000L);
      if (this.E.getVisibility() != 8) {
        this.E.setVisibility(8);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    ISubAccountService localISubAccountService = (ISubAccountService)this.app.getRuntimeService(ISubAccountService.class, "");
    int i1 = localISubAccountService.getBindedNumber();
    a(paramBoolean, i1);
    a(localISubAccountService, i1);
  }
  
  private void c(View paramView)
  {
    a((View)paramView.getParent(), 0.0F, -this.M);
    a((View)paramView.getTag(), 0.0F, -this.M);
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
    if (!this.l) {
      return;
    }
    this.k ^= true;
    if (this.k)
    {
      this.rightViewText.setVisibility(8);
      this.rightHighLView.setVisibility(0);
      this.rightViewText.setText(2131889474);
    }
    else
    {
      this.rightViewText.setVisibility(0);
      this.rightHighLView.setVisibility(8);
      this.rightViewText.setText(2131888824);
    }
    b();
    a(this.k);
    this.l = false;
    this.O.postDelayed(new AccountManageActivity.4(this), 250L);
    if (this.k)
    {
      ReportController.b(this.app, "CliOper", "", "", "Setting_tab", "Clk_acc_edit", 0, 0, "", "", "", "");
      ReportController.a(this.app, "0X800B836");
    }
  }
  
  private void k()
  {
    this.v = findViewById(2131437745);
    this.w = findViewById(2131442945);
    this.x = findViewById(2131439214);
    this.L = true;
    this.v.setVisibility(8);
    this.w.setVisibility(8);
    this.x.setVisibility(0);
    this.D = ActionSheet.create(this);
    this.D.addButton(new ActionMenuItem(getString(2131886643), 1, 0), 0);
    this.D.addButton(new ActionMenuItem(getString(2131886645), 2, 0), 0);
    this.D.setOnButtonClickListener(new AccountManageActivity.7(this));
    this.D.addCancelButton(getString(2131886644));
    this.x.setOnClickListener(new AccountManageActivity.8(this));
    ReportController.a(this.app, "0X800B7D7");
  }
  
  private void l()
  {
    this.E.setBackgroundColor(getResources().getColor(2131167964));
    this.E.setTipsIcon(getResources().getDrawable(2130852697));
    this.E.getTextView().setTextColor(getResources().getColorStateList(2131168001));
    if (this.E.b() != null) {
      this.E.b().setVisibility(8);
    }
  }
  
  private void m()
  {
    ThreadManager.post(new AccountManageActivity.9(this), 8, null, false);
  }
  
  private boolean n()
  {
    if (PwdSetUtil.a(this.app, this))
    {
      QLog.i("AccountManageActivity", 1, "checkHasSetPwd: return false");
      return false;
    }
    return true;
  }
  
  private void o()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountManageActivity", 2, "showLogoutDialog");
    }
    if (!n()) {
      return;
    }
    Object localObject1 = this.h;
    if ((localObject1 != null) && (((Dialog)localObject1).isShowing())) {
      return;
    }
    localObject1 = this.J;
    if (localObject1 != null)
    {
      if (((Card)localObject1).lQQMasterLogindays > 0L) {
        QQDarenUtils.sQQDarenLoginDays = this.J.lQQMasterLogindays;
      } else {
        QQDarenUtils.sQQDarenLoginDays = 30L;
      }
      if ((this.J.lLoginDays != 1L) && ((this.J.lLoginDays <= 1L) || (this.J.lLoginDays >= QQDarenUtils.sQQDarenLoginDays)))
      {
        if (this.J.lLoginDays >= QQDarenUtils.sQQDarenLoginDays) {
          localObject1 = String.format(getString(2131891445), new Object[] { Integer.valueOf((int)this.J.lLoginDays) });
        } else {
          localObject1 = String.format(getString(2131891446), new Object[0]);
        }
      }
      else {
        localObject1 = String.format(getString(2131891444), new Object[] { Integer.valueOf((int)(QQDarenUtils.sQQDarenLoginDays - this.J.lLoginDays)) });
      }
    }
    else
    {
      localObject1 = String.format(getString(2131891446), new Object[0]);
    }
    Object localObject2 = this.h;
    if (localObject2 != null)
    {
      localObject2 = (TextView)((Dialog)localObject2).findViewById(2131431876);
      if (localObject2 != null)
      {
        ((TextView)localObject2).requestFocus();
        ((TextView)localObject2).setText((CharSequence)localObject1);
        ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
      }
      this.h.show();
      return;
    }
    this.h = new ReportDialog(this, 2131953338);
    this.h.setContentView(2131624587);
    SimpleUIFixHelper.a(this.h);
    SimpleUIFixHelper.b(this.h);
    localObject2 = (TextView)this.h.findViewById(2131431880);
    if (localObject2 != null)
    {
      ((TextView)localObject2).setVisibility(4);
      ((ViewGroup.MarginLayoutParams)((TextView)localObject2).getLayoutParams()).bottomMargin = 0;
      ((TextView)localObject2).setHeight(0);
      ((TextView)localObject2).setLayoutParams(((TextView)localObject2).getLayoutParams());
    }
    localObject2 = (TextView)this.h.findViewById(2131431876);
    if (localObject2 != null)
    {
      ((TextView)localObject2).requestFocus();
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setContentDescription((CharSequence)localObject1);
    }
    localObject1 = (TextView)this.h.findViewById(2131431864);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(2131887648);
      ((TextView)localObject1).setOnClickListener(new AccountManageActivity.11(this));
    }
    localObject1 = (TextView)this.h.findViewById(2131431870);
    if (localObject1 != null)
    {
      ((TextView)localObject1).setText(2131891443);
      ((TextView)localObject1).setOnClickListener(new AccountManageActivity.12(this));
    }
    this.h.show();
    ReportController.a(this.app, "0X800B83C");
  }
  
  private void p()
  {
    this.g = new ReportDialog(this, 2131953338);
    this.g.setContentView(2131623999);
    ((TextView)this.g.findViewById(2131431876)).setText(getString(2131888463));
    this.g.setCancelable(false);
  }
  
  private void q()
  {
    Object localObject1 = this.e;
    if (localObject1 == null) {
      this.e = new ArrayList();
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
      this.e.addAll((Collection)localObject2);
    }
    localObject1 = this.e;
    if (localObject1 != null) {
      ((List)localObject1).add(null);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("initAccountList accountList=");
    ((StringBuilder)localObject2).append(this.e);
    ((StringBuilder)localObject2).append(", size=");
    localObject3 = this.e;
    localObject1 = str;
    if (localObject3 != null) {
      localObject1 = Integer.valueOf(((List)localObject3).size());
    }
    ((StringBuilder)localObject2).append(localObject1);
    QLog.i("AccountManageActivity", 1, ((StringBuilder)localObject2).toString());
    r();
  }
  
  private void r()
  {
    this.a.removeAllViews();
    if (this.e == null) {
      return;
    }
    AccountManageActivity.13 local13 = new AccountManageActivity.13(this);
    int i1 = 0;
    while (i1 < this.e.size())
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("bindAccountListView i=");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(", account=");
        ((StringBuilder)localObject1).append(this.e.get(i1));
        QLog.i("AccountManageActivity", 2, ((StringBuilder)localObject1).toString());
      }
      if (this.e.get(i1) == null)
      {
        this.y = getLayoutInflater().inflate(2131623978, this.a, false);
        this.y.setOnClickListener(this.o);
        this.y.setTag(null);
        this.a.addView(this.y);
      }
      else
      {
        localObject1 = getLayoutInflater().inflate(2131623979, this.a, false);
        ((View)localObject1).setTag(Integer.valueOf(i1));
        ((View)localObject1).setOnTouchListener(local13);
        ((ImageView)((View)localObject1).findViewById(2131435219)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((View)localObject1).setOnClickListener(this.n);
        if ((localObject1 instanceof FormItemRelativeLayout))
        {
          localObject2 = (FormItemRelativeLayout)localObject1;
          ((FormItemRelativeLayout)localObject2).setNeedFocusBg(true);
          ((FormItemRelativeLayout)localObject2).setBGType(2);
        }
        Object localObject2 = (Button)((View)localObject1).findViewById(2131431681);
        ((Button)localObject2).setOnClickListener(this.V);
        this.M = ((Button)localObject2).getLayoutParams().width;
        View localView = ((View)localObject1).findViewById(2131431711);
        localView.setTag(localObject2);
        localView.setOnClickListener(this.U);
        this.a.addView((View)localObject1);
      }
      i1 += 1;
    }
    v();
  }
  
  private void s()
  {
    if (this.k)
    {
      b(this.y);
      b(this.z);
      return;
    }
    a(this.y);
    a(this.z);
  }
  
  private void t()
  {
    if (this.k)
    {
      b(this.leftView);
      return;
    }
    a(this.leftView);
  }
  
  private void u()
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (((LinearLayout)localObject1).getChildCount() <= 0) {
        return;
      }
      int i2 = this.a.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject3 = this.a.getChildAt(i1);
        Object localObject2 = ((View)localObject3).getTag();
        if (localObject2 != null)
        {
          localObject1 = (ImageView)((View)localObject3).findViewById(2131430661);
          localObject3 = (ImageView)((View)localObject3).findViewById(2131431711);
          if (this.k)
          {
            if (((ImageView)localObject1).getVisibility() == 0) {
              b((View)localObject1);
            }
            ((ImageView)localObject3).setVisibility(0);
          }
          else
          {
            int i3 = ((Integer)localObject2).intValue();
            localObject2 = (SimpleAccount)this.e.get(i3);
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
        i1 += 1;
      }
    }
  }
  
  private void v()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((LinearLayout)localObject1).getChildCount() > 0))
    {
      int i3 = this.a.getChildCount();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateAccountListView account size=");
      ((StringBuilder)localObject1).append(i3);
      QLog.i("AccountManageActivity", 1, ((StringBuilder)localObject1).toString());
      QQAppInterface localQQAppInterface = this.app;
      int i1 = 0;
      while (i1 < i3)
      {
        View localView = this.a.getChildAt(i1);
        localObject1 = localView.getTag();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("updateAccountListView i=");
        ((StringBuilder)localObject2).append(i1);
        ((StringBuilder)localObject2).append(", view tag=");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.i("AccountManageActivity", 1, ((StringBuilder)localObject2).toString());
        if (localObject1 == null) {
          return;
        }
        int i2 = ((Integer)localObject1).intValue();
        if (i2 >= this.e.size())
        {
          QLog.e("AccountManageActivity", 1, "updateAccountListView, view tag is large than account list size");
          finish();
          return;
        }
        SimpleAccount localSimpleAccount = (SimpleAccount)this.e.get(i2);
        if (localSimpleAccount == null) {
          return;
        }
        ImageView localImageView1 = (ImageView)localView.findViewById(2131435219);
        localObject2 = localSimpleAccount.getUin();
        ImageView localImageView2 = (ImageView)localView.findViewById(2131430661);
        localImageView2.clearAnimation();
        if ((localObject2 != null) && (((String)localObject2).length() > 0) && (((String)localObject2).equals(this.app.getCurrentAccountUin())) && (!this.k)) {
          localImageView2.setVisibility(0);
        } else {
          localImageView2.setVisibility(8);
        }
        ((TextView)localView.findViewById(2131427416)).setText((CharSequence)localObject2);
        TextView localTextView = (TextView)localView.findViewById(2131439121);
        if ((this.S.containsKey(localObject2)) && (!TextUtils.isEmpty((CharSequence)this.S.get(localObject2))))
        {
          localObject1 = (String)this.S.get(localObject2);
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
        ThreadManager.postImmediately(new AccountManageActivity.14(this, localQQAppInterface, (String)localObject2, localSimpleAccount, (String)localObject1, localTextView, localImageView1), null, true);
        if (AppSetting.e) {
          if (this.k)
          {
            localView.setContentDescription((CharSequence)localObject1);
          }
          else
          {
            if (localImageView2.getVisibility() == 0) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            if (i2 != 0)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898021));
              localView.setContentDescription(((StringBuilder)localObject2).toString());
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append((String)localObject1);
              ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898017));
              localView.setContentDescription(((StringBuilder)localObject2).toString());
            }
          }
        }
        i1 += 1;
      }
      return;
    }
    QLog.i("AccountManageActivity", 1, "updateAccountListView accountListLinearLayout is null or size is 0.");
  }
  
  private void w()
  {
    ImageView localImageView = this.T;
    if (localImageView != null)
    {
      d(localImageView);
      this.T = null;
    }
  }
  
  private void x()
  {
    Object localObject = this.T;
    if (localObject != null)
    {
      localObject = (View)((ImageView)localObject).getParent();
      View localView = (View)this.T.getTag();
      if (((View)localObject).getTag() != null) {
        ((ObjectAnimator)((View)localObject).getTag()).cancel();
      }
      if (localView.getTag() != null) {
        ((ObjectAnimator)localView.getTag()).cancel();
      }
      ((View)localObject).setTranslationX(0.0F);
      localView.setTranslationX(0.0F);
      this.T = null;
    }
  }
  
  private void y()
  {
    ReportController.a(null, "dc00898", "", "", "0X800B42F", "0X800B42F", 0, 0, "", "", "", "");
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131916863)).setMessage(getString(2131916862));
    localQQCustomDialog.setPositiveButton(2131914866, new AccountManageActivity.21(this));
    localQQCustomDialog.setCancelable(true);
    localQQCustomDialog.show();
  }
  
  private void z()
  {
    AppRuntime.Status localStatus = ((IOnlineStatusService)this.app.getRuntimeService(IOnlineStatusService.class)).getOnlineStatus();
    this.d.setRightText(A());
    this.d.setTag(localStatus);
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, String.format("updateOnlineStatus: %s", new Object[] { localStatus }));
    }
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ReportDialog localReportDialog = new ReportDialog(getActivity(), 2131953338);
    localReportDialog.setContentView(2131624755);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131431880);
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
    paramString1 = (TextView)localReportDialog.findViewById(2131431876);
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
    paramString1 = (TextView)localReportDialog.findViewById(2131431864);
    if (paramString1 != null) {
      paramString1.setText(2131887648);
    }
    paramString1 = (TextView)localReportDialog.findViewById(2131431870);
    if (paramString1 != null) {
      paramString1.setText(2131892267);
    }
    localReportDialog.setOnDismissListener(paramOnDismissListener);
    return localReportDialog;
  }
  
  public void a()
  {
    TextView localTextView = this.rightViewText;
    localTextView.setVisibility(0);
    localTextView.setText(2131888824);
    localTextView.setOnClickListener(this.P);
    ReportController.a(this.app, "0X800B7D2");
    this.rightHighLView = ((TextView)getLayoutInflater().inflate(2131624584, null));
    setLayerType(this.rightHighLView);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(this.mDensity * 8.0F));
    this.vg.addView(this.rightHighLView, (ViewGroup.LayoutParams)localObject);
    this.rightHighLView.setVisibility(8);
    this.rightHighLView.setText(2131889474);
    this.rightHighLView.setOnClickListener(this.P);
    this.a = ((LinearLayout)findViewById(2131427419));
    this.z = findViewById(2131432647);
    this.b = ((FormSimpleItem)findViewById(2131442040));
    if (QVipQidProcessor.e().a)
    {
      this.b.setVisibility(0);
      this.c = new RedTouch(this, this.b).c(21).b(88.0F).a();
      this.b.setOnClickListener(this.ab);
    }
    else
    {
      this.b.setVisibility(8);
    }
    this.d = ((FormSimpleItem)findViewById(2131439572));
    z();
    this.d.setOnClickListener(new AccountManageActivity.5(this));
    ReportController.a(this.app, "0X800B7D5");
    k();
    this.E = ((TipsBar)findViewById(2131446550));
    this.A = ((FormSimpleItem)findViewById(2131446545));
    this.A.setOnClickListener(this.Q);
    this.B = ((ImageView)findViewById(2131446526));
    this.B.setBackgroundResource(2130852699);
    this.C = ((ImageView)findViewById(2131446527));
    this.C.setBackgroundResource(2130852699);
    p();
    localObject = getResources().getDisplayMetrics();
    this.H = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    if (AppSetting.e)
    {
      localTextView.setContentDescription(HardCodeUtil.a(2131898020));
      this.rightHighLView.setContentDescription(HardCodeUtil.a(2131898019));
      this.v.setContentDescription(getString(2131891442));
      this.w.setContentDescription("退出QQ");
      this.A.setContentDescription("关联QQ号");
      AccessibilityUtil.a(findViewById(2131427461), false);
    }
    findViewById(2131427461).setOnTouchListener(new AccountManageActivity.6(this));
  }
  
  void a(int paramInt)
  {
    Object localObject = (SimpleAccount)this.e.get(paramInt);
    if (localObject == null) {
      return;
    }
    this.p = ((ActionSheet)ActionSheetHelper.b(this, null));
    String[] arrayOfString = getResources().getStringArray(2130968576);
    int i1 = 0;
    while (i1 < arrayOfString.length)
    {
      this.p.addButton(arrayOfString[i1], 1);
      i1 += 1;
    }
    this.p.addCancelButton(2131887648);
    this.W.a(paramInt);
    this.p.setOnButtonClickListener(this.W);
    localObject = getString(2131897866).replace("${account}", ((SimpleAccount)localObject).getUin());
    this.p.setMainTitle((CharSequence)localObject);
    if (!this.p.isShowing()) {
      this.p.show();
    }
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = (SimpleAccount)this.e.get(paramInt);
    if (localObject1 == null)
    {
      this.g.dismiss();
      if (QLog.isColorLevel()) {
        QLog.w("Switch_Account", 2, "onItemLongClick simple account = null");
      }
      return;
    }
    String str1 = ((SimpleAccount)localObject1).getUin();
    String str2 = this.app.getCurrentAccountUin();
    this.X = str1;
    if (str1.equals(str2)) {
      a(this, this.app);
    }
    if (QLog.isColorLevel()) {
      QLog.d("hunter", 2, "++++++++++");
    }
    a(this.X, paramBoolean);
    HistoryChatMsgSearchKeyUtil.b(str1);
    CrmUtils.a(getBaseContext(), str2);
    this.e.remove(localObject1);
    Object localObject2 = (ISubAccountService)this.app.getRuntimeService(ISubAccountService.class, "");
    if ((localObject2 != null) && (((ISubAccountService)localObject2).isSubAccountUin(str1)))
    {
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).setBindUinStatus(this.app, (byte)0, str1);
      ((ISubAccountService)localObject2).clearUnreadNum(str1);
      ((ISubAccountService)localObject2).updateA2(str1, null, true);
      ((ISubAccountService)localObject2).setStatus(str1, 2);
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).bindRecentItem(this.app, str1, 7);
      int i1 = 1 - this.app.getConversationFacade().a(str1, 7000);
      if (i1 != 0) {
        this.app.getConversationFacade().e(str1, 7000, i1);
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
    ThreadManager.post(new AccountManageActivity.19(this, str1, paramBoolean, paramInt), 8, null, true);
  }
  
  void a(View paramView)
  {
    paramView.setVisibility(0);
    a(paramView, 2130771984, 1);
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
    Bitmap localBitmap = this.K.getBitmapFromCache(1, paramString);
    if (localBitmap == null)
    {
      this.K.requestDecodeFace(paramString, 1, false);
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
    runOnUiThread(new AccountManageActivity.28(this, paramString, paramInt));
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (((LinearLayout)localObject).getChildCount() <= 0) {
        return;
      }
      int i2 = this.a.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = this.a.getChildAt(i1);
        if (((View)localObject).getTag() == null)
        {
          if (paramBoolean)
          {
            ((View)localObject).setOnClickListener(null);
            ((View)localObject).setBackgroundResource(2130852512);
            ((View)localObject).setEnabled(false);
          }
          else
          {
            ((View)localObject).setOnClickListener(this.o);
            ((View)localObject).setBackgroundResource(2130839629);
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
            if ((paramBoolean) && (i1 == i2 - 2)) {
              localFormItemRelativeLayout.setBGType(3);
            }
          }
          if (paramBoolean) {
            ((View)localObject).setOnClickListener(null);
          } else {
            ((View)localObject).setOnClickListener(this.n);
          }
        }
        i1 += 1;
      }
    }
  }
  
  void b()
  {
    u();
    t();
    s();
  }
  
  void b(View paramView)
  {
    paramView.setVisibility(0);
    a(paramView, 2130771983, 2);
  }
  
  void c()
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      if (((LinearLayout)localObject1).getChildCount() <= 0) {
        return;
      }
      int i2 = this.a.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject1 = this.a.getChildAt(i1);
        Object localObject2 = ((View)localObject1).getTag();
        if (localObject2 == null) {
          return;
        }
        int i3 = ((Integer)localObject2).intValue();
        localObject2 = (SimpleAccount)this.e.get(i3);
        if (localObject2 == null) {
          return;
        }
        localObject1 = (ImageView)((View)localObject1).findViewById(2131430661);
        if ((((SimpleAccount)localObject2).getUin() != null) && (((SimpleAccount)localObject2).getUin().length() > 0) && (((SimpleAccount)localObject2).getUin().equals(this.app.getCurrentAccountUin())) && (!this.k)) {
          ((ImageView)localObject1).setVisibility(0);
        } else {
          ((ImageView)localObject1).setVisibility(8);
        }
        i1 += 1;
      }
    }
  }
  
  void d()
  {
    this.O.removeMessages(5000);
    QQCustomDialog localQQCustomDialog = this.i;
    if ((localQQCustomDialog == null) || (localQQCustomDialog.isShowing())) {}
    try
    {
      this.i.dismiss();
      label33:
      this.i = null;
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
        q();
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if (!this.k)
    {
      super.doOnBackPressed();
      return;
    }
    if (this.N)
    {
      j();
      this.N = false;
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131623980);
    setTitle(2131897226);
    this.f = getResources().getDisplayMetrics().density;
    setContentBackgroundResource(2130838958);
    a();
    q();
    addObserver(this.s);
    addObserver(this.r);
    addObserver(this.Y);
    addObserver(this.Z);
    this.app.registObserver(this.ac);
    this.app.addObserver(this.ad);
    this.app.setHandler(getClass(), this.O);
    ThreadManager.post(new AccountManageActivity.1(this), 5, null, true);
    this.K = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.K.setDecodeTaskCompletionListener(this.ae);
    sendBroadcast(new Intent("before_account_change"));
    ReportController.b(this.app, "dc00898", "", "", "0X800AC37", "0X800AC37", 0, 0, "", "", "", "");
    ReportController.b(this.app, "dc00898", "", "", "0X800735C", "0X800735C", 0, 0, "", "", "", "");
    QLog.d("AccountManageActivity", 2, "doOnCreate AccountManageActivity-accountShow");
    ReportController.b(this.app, "dc00898", "", "", "0X800BDEF", "0X800BDEF", 0, 0, "", "", "", "");
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
    this.app.unRegistObserver(this.ac);
    removeObserver(this.s);
    removeObserver(this.r);
    removeObserver(this.Y);
    removeObserver(this.Z);
    this.app.removeObserver(this.ad);
    if (this.g.isShowing()) {
      this.g.dismiss();
    }
    d();
    Object localObject = this.h;
    if ((localObject != null) && (((Dialog)localObject).isShowing()))
    {
      this.h.dismiss();
      this.h = null;
    }
    localObject = this.K;
    if (localObject != null)
    {
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(null);
      this.ae = null;
      this.K.destory();
    }
    super.doOnDestroy();
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.N = true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    b(false);
    v();
    if (QVipQidProcessor.e().a)
    {
      B();
      C();
    }
    g();
  }
  
  void e()
  {
    d();
    this.i = DialogUtil.a(this, 230).setTitle(getString(2131916856)).setMessage(getString(2131916831));
    this.i.setPositiveButton(getString(2131916892), new AccountManageActivity.22(this));
    this.i.setNegativeButton(getString(2131887648), new AccountManageActivity.23(this));
    try
    {
      this.i.show();
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
      if (this.aa == null)
      {
        this.aa = new QQProgressDialog(getActivity(), getTitleBarHeight());
        this.aa.c(2131892342);
        this.aa.c(false);
      }
      this.aa.show();
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
      if ((this.aa != null) && (this.aa.isShowing()))
      {
        this.aa.dismiss();
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
    if (this.j == null) {
      this.j = new AccountManageActivity.32(this).a();
    }
    Dialog localDialog = a(getString(2131886647), null, this.j);
    Object localObject = (TextView)localDialog.findViewById(2131431870);
    ((TextView)localObject).setText(2131886646);
    ((TextView)localObject).setOnClickListener(new AccountManageActivity.33(this, localDialog));
    localObject = (TextView)localDialog.findViewById(2131431864);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new AccountManageActivity.34(this));
    }
    localObject = getString(2131915612);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.u = SettingCloneUtil.readValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("init CheckBox:receiveMsgWhenExitPerfExist:");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(", bReceiveMsgOnExit:");
      ((StringBuilder)localObject).append(this.u);
      QLog.d("AccountManageActivity", 4, ((StringBuilder)localObject).toString());
    }
    localObject = (CheckBox)localDialog.findViewById(2131430666);
    if ((bool) && (this.u)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.u);
    this.t = localDialog;
    this.t.show();
    ReportController.a(this.app, "0X800B83D");
  }
  
  void i()
  {
    Dialog localDialog = this.t;
    if ((localDialog == null) || (localDialog.isShowing())) {}
    try
    {
      this.t.dismiss();
      label23:
      this.t = null;
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
    if (this.F)
    {
      this.F = false;
      v();
    }
    else
    {
      q();
    }
    addObserver(this.s);
    addObserver(this.r);
    addObserver(this.Y);
    addObserver(this.Z);
    this.app.registObserver(this.ac);
    this.app.addObserver(this.ad);
    this.app.setHandler(getClass(), this.O);
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "onAccountChanged2");
    }
    ThreadManager.postImmediately(new AccountManageActivity.24(this), null, true);
    ((ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class)).doSomethingAfterSwitchAccountSuccess(this.app, this);
    this.O.postDelayed(new AccountManageActivity.25(this), 500L);
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
    this.F = false;
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
      this.G = false;
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity
 * JD-Core Version:    0.7.0.1
 */