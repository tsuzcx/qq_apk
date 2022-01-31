package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.HistoryChatMsgSearchKeyUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.RotateSwitchImageView;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
import rfv;
import rfw;
import rfx;
import rfy;
import rga;
import rgc;
import rgd;
import rge;
import rgf;
import rgg;
import rgi;
import rgj;
import rgk;
import rgl;
import rgm;
import rgo;
import rgp;
import rgr;
import rgs;
import rgu;
import rgv;
import rgw;
import rgx;
import rgz;
import rhb;
import rhc;
import rhd;
import rhe;
import rhf;
import rhg;
import rhh;
import rhi;

public class AccountManageActivity
  extends IphoneTitleBarActivity
{
  public float a;
  public Dialog a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new rgc(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new rfy(this);
  private View jdField_a_of_type_AndroidViewView;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public LinearLayout a;
  public TextView a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new rgp(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new rgs(this);
  private SubAccountBindObserver jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver = new rgr(this);
  private Card jdField_a_of_type_ComTencentMobileqqDataCard;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private RotateSwitchImageView jdField_a_of_type_ComTencentMobileqqWidgetRotateSwitchImageView;
  public SimpleAccount a;
  public ActionSheet a;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List a;
  AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new rgi(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new rgj(this);
  private rhi jdField_a_of_type_Rhi = new rhi(this);
  public boolean a;
  private float jdField_b_of_type_Float;
  public Dialog b;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new rgd(this);
  private View jdField_b_of_type_AndroidViewView;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  public boolean b;
  private float jdField_c_of_type_Float;
  public Dialog c;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new rhe(this);
  private FormSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  public boolean c;
  private View.OnClickListener d;
  public boolean d;
  private View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new rge(this);
  private boolean jdField_e_of_type_Boolean;
  private View.OnClickListener jdField_f_of_type_AndroidViewView$OnClickListener = new rgf(this);
  private boolean jdField_f_of_type_Boolean;
  private boolean g;
  
  public AccountManageActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new rhf(this);
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_d_of_type_Boolean = true;
  }
  
  private View a(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131362741);
    }
    return null;
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, LoginActivity.class);
    localIntent.putExtra("logout_intent", true);
    localIntent.putExtra("tab_index", MainFragment.a);
    ThemeUiPlugin.destroy(paramQQAppInterface);
    ChatBackgroundManager.a();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences("unreadcount", 4).edit();
    localEditor.putInt("unread", 0);
    localEditor.commit();
    paramQQAppInterface.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    int i = QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin());
    QQSettingUtil.a(paramActivity, paramQQAppInterface.getCurrentAccountUin(), i + 1);
    paramActivity.startActivity(localIntent);
    if (QQPlayerService.a())
    {
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setAction("qqplayer_exit_action");
      paramActivity.sendBroadcast(paramQQAppInterface);
    }
    paramActivity.finish();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    ((AccountManager)getAppRuntime().getManager(0)).deleteAccount(this.jdField_a_of_type_JavaLangString, this.app.b(this.jdField_a_of_type_JavaLangString), new rhh(this, paramString, paramBoolean));
    if (QLog.isColorLevel()) {
      QLog.d("Switch_Account", 2, "am.deleteAccount " + this.jdField_a_of_type_JavaLangString);
    }
    if (paramBoolean) {
      NearbyProxy.a(paramString);
    }
  }
  
  private View b(View paramView)
  {
    paramView = (View)paramView.getParent();
    if (paramView != null) {
      return paramView.findViewById(2131362753);
    }
    return null;
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject3 = (SubAccountManager)this.app.getManager(60);
    int m = ((SubAccountManager)localObject3).a();
    Object localObject1 = (TipsBar)findViewById(2131362757);
    int j = 0;
    int k = 0;
    int i;
    Object localObject2;
    boolean bool;
    if (paramBoolean)
    {
      i = k;
      if (!this.g)
      {
        i = k;
        if (m == 0)
        {
          if (!DBUtils.a().a()) {
            break label584;
          }
          if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(5000)) {
            break label559;
          }
          i = k;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("AccountManagerActivity.refreshSubAccount() isAccount2Bind=");
        if (m <= 0) {
          break label589;
        }
        bool = true;
        label114:
        QLog.d("AccountManageActivity", 2, bool);
      }
      j = i;
      if (m == 0)
      {
        ThreadManager.post(new rhd(this), 8, null, false);
        j = i;
      }
    }
    if ((j == 0) && (m == 1)) {
      if (DBUtils.a().a(this.app.getCurrentAccountUin())) {
        i = j;
      }
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        label183:
        if (((TipsBar)localObject1).getVisibility() != 8) {
          ((TipsBar)localObject1).setVisibility(8);
        }
        label229:
        if (((TipsBar)localObject1).getVisibility() == 0) {
          ((TipsBar)localObject1).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
        }
        localObject2 = null;
        localObject1 = null;
        if (m == 1)
        {
          SubAccountInfo localSubAccountInfo = ((SubAccountManager)localObject3).a("sub.uin.default");
          localObject2 = localObject1;
          if (localSubAccountInfo != null)
          {
            localObject2 = localObject1;
            if (!TextUtils.isEmpty(localSubAccountInfo.subuin))
            {
              localObject1 = localSubAccountInfo.subname;
              localObject3 = ContactUtils.c(this.app, localSubAccountInfo.subuin, true);
              localObject2 = localObject1;
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                if (!TextUtils.isEmpty(localSubAccountInfo.subname))
                {
                  localObject2 = localObject1;
                  if (((String)localObject3).equals(localSubAccountInfo.subname)) {}
                }
                else
                {
                  localSubAccountInfo.subname = ((String)localObject3);
                  localObject2 = localObject3;
                }
              }
            }
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            if (localSubAccountInfo != null) {
              localObject1 = localSubAccountInfo.subuin;
            }
          }
          label390:
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = "";
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder().append("refreshSubAccount() uin=").append(this.app.getCurrentAccountUin()).append(" isAccountChanged=").append(paramBoolean).append(" isAccount1Bind=").append(this.g).append(" account2BindedNum=").append(m).append(" final action=").append(i).append(" sAccountName=");
            if (((String)localObject2).length() != 0) {
              break label889;
            }
            localObject1 = "_empty_";
          }
        }
        break;
      }
      for (;;)
      {
        QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightText((CharSequence)localObject2);
        if (AppSetting.jdField_b_of_type_Boolean) {
          this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号" + (String)localObject2);
        }
        return;
        label559:
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
        {
          i = k;
          if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
            break;
          }
        }
        i = 2;
        break;
        label584:
        i = 1;
        break;
        label589:
        bool = false;
        break label114;
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() < 4)) {
          break label969;
        }
        i = 3;
        break label183;
        DBUtils.a().a(true);
        d();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(5000, 1000L);
        if (((TipsBar)localObject1).getVisibility() == 8) {
          break label229;
        }
        ((TipsBar)localObject1).setVisibility(8);
        break label229;
        ReportController.b(this.app, "CliOper", "", "", "0X8004001", "0X8004001", 0, 0, "", "", "", "");
        ((TipsBar)localObject1).setTag("0X8004001");
        localObject2 = getString(2131436390);
        ((TipsBar)localObject1).setTipsText((CharSequence)localObject2);
        if (AppSetting.jdField_b_of_type_Boolean) {
          ((TipsBar)localObject1).setContentDescription((CharSequence)localObject2);
        }
        if (((TipsBar)localObject1).getVisibility() != 0) {
          ((TipsBar)localObject1).setVisibility(0);
        }
        d();
        break label229;
        ((TipsBar)localObject1).setTag("0X8004456");
        localObject2 = getString(2131436391);
        ((TipsBar)localObject1).setTipsText((CharSequence)localObject2);
        if (AppSetting.jdField_b_of_type_Boolean) {
          ((TipsBar)localObject1).setContentDescription((CharSequence)localObject2);
        }
        if (((TipsBar)localObject1).getVisibility() != 0)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8004456", "0X8004456", 0, 0, "", "", "", "");
          ((TipsBar)localObject1).setVisibility(0);
        }
        d();
        break label229;
        localObject1 = localObject2;
        if (m <= 1) {
          break label390;
        }
        localObject1 = m + "个";
        break label390;
        label889:
        if ((((String)localObject2).length() == 1) || (((String)localObject2).length() == 2)) {
          localObject1 = localObject2;
        } else if (((String)localObject2).length() > 2) {
          localObject1 = ((String)localObject2).substring(0, 2) + "|" + ((String)localObject2).length();
        } else {
          localObject1 = localObject2;
        }
      }
      label969:
      i = j;
    }
  }
  
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountManageActivity", 2, "showLogoutDialog");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays > 0L)
      {
        FriendProfileCardActivity.a = this.jdField_a_of_type_ComTencentMobileqqDataCard.lQQMasterLogindays;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays != 1L) && ((this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays <= 1L) || (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= FriendProfileCardActivity.a))) {
          break label173;
        }
        localObject = String.format(getString(2131435431), new Object[] { Integer.valueOf((int)(FriendProfileCardActivity.a - this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays)) });
      }
    }
    for (;;)
    {
      if (this.jdField_b_of_type_AndroidAppDialog == null) {
        break label255;
      }
      localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131362776);
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
      label173:
      if (this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays >= FriendProfileCardActivity.a)
      {
        localObject = String.format(getString(2131435432), new Object[] { Integer.valueOf((int)this.jdField_a_of_type_ComTencentMobileqqDataCard.lLoginDays) });
      }
      else
      {
        localObject = String.format(getString(2131435433), new Object[0]);
        continue;
        localObject = String.format(getString(2131435433), new Object[0]);
      }
    }
    label255:
    this.jdField_b_of_type_AndroidAppDialog = new Dialog(this, 2131624516);
    this.jdField_b_of_type_AndroidAppDialog.setContentView(2130968842);
    TextView localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131364034);
    if (localTextView != null) {
      localTextView.setText(getString(2131435427));
    }
    localTextView = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131362776);
    if (localTextView != null)
    {
      localTextView.requestFocus();
      localTextView.setText((CharSequence)localObject);
      localTextView.setContentDescription((CharSequence)localObject);
    }
    Object localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131364037);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131433015);
      ((TextView)localObject).setOnClickListener(new rfw(this));
    }
    localObject = (TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131364038);
    if (localObject != null)
    {
      ((TextView)localObject).setText(2131435430);
      ((TextView)localObject).setOnClickListener(new rfx(this));
    }
    this.jdField_b_of_type_AndroidAppDialog.show();
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624516);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130968595);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131362776)).setText(getString(2131434042));
    this.jdField_a_of_type_AndroidAppDialog.setCancelable(false);
  }
  
  private void l()
  {
    Object localObject2;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      getAppRuntime().getApplication().refreAccountList();
      localObject2 = getAppRuntime().getApplication().getAllAccounts();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("initAccountList list=").append(localObject2).append(", size=");
        if (localObject2 == null) {
          break label217;
        }
        localObject1 = Integer.valueOf(((List)localObject2).size());
        label84:
        QLog.i("AccountManageActivity", 2, localObject1);
      }
      if (localObject2 != null) {
        this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
      }
      if (this.jdField_a_of_type_JavaUtilList != null) {
        this.jdField_a_of_type_JavaUtilList.add(null);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("initAccountList accountList=").append(this.jdField_a_of_type_JavaUtilList).append(", size=");
        if (this.jdField_a_of_type_JavaUtilList == null) {
          break label224;
        }
      }
    }
    label217:
    label224:
    for (Object localObject1 = Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size());; localObject1 = "null")
    {
      QLog.i("AccountManageActivity", 2, localObject1);
      m();
      return;
      this.jdField_a_of_type_JavaUtilList.clear();
      break;
      localObject1 = "null";
      break label84;
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return;
    }
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.i("AccountManageActivity", 2, "bindAccountListView i=" + i + ", account=" + this.jdField_a_of_type_JavaUtilList.get(i));
      }
      View localView;
      if (this.jdField_a_of_type_JavaUtilList.get(i) == null)
      {
        localView = getLayoutInflater().inflate(2130968589, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131362750));
        localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        localView.setTag(null);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
      for (;;)
      {
        i += 1;
        break;
        localView = getLayoutInflater().inflate(2130968590, this.jdField_a_of_type_AndroidWidgetLinearLayout, false);
        if (i == 0) {
          localView.setBackgroundResource(2130838635);
        }
        localView.setTag(Integer.valueOf(i));
        ((ImageView)localView.findViewById(2131362719)).setScaleType(ImageView.ScaleType.FIT_CENTER);
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
        ((Button)localView.findViewById(2131362742)).setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
        ((RotateSwitchImageView)localView.findViewById(2131362752)).setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView);
      }
    }
    n();
  }
  
  private void n()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("AccountManageActivity", 2, "updateAccountListView accountListLinearLayout is null or size is 0.");
      }
    }
    int i;
    label77:
    View localView;
    Object localObject;
    int j;
    SimpleAccount localSimpleAccount;
    do
    {
      do
      {
        return;
        int k = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        if (QLog.isColorLevel()) {
          QLog.i("AccountManageActivity", 2, "updateAccountListView account size=" + k);
        }
        i = 0;
        if (i >= k) {
          break;
        }
        localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject = localView.getTag();
        if (QLog.isColorLevel()) {
          QLog.i("AccountManageActivity", 2, "updateAccountListView i=" + i + ", view tag=" + localObject);
        }
      } while (localObject == null);
      j = ((Integer)localObject).intValue();
      localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(j);
    } while (localSimpleAccount == null);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131362719);
    String str1 = localSimpleAccount.getUin();
    ImageView localImageView2 = (ImageView)localView.findViewById(2131362756);
    localImageView2.clearAnimation();
    if ((str1 != null) && (str1.length() > 0) && (str1.equals(this.app.getCurrentAccountUin())) && (!this.jdField_a_of_type_Boolean))
    {
      localImageView2.setVisibility(0);
      label256:
      ((TextView)localView.findViewById(2131362755)).setText(str1);
      TextView localTextView = (TextView)localView.findViewById(2131362754);
      if ((this.jdField_b_of_type_JavaUtilHashMap.containsKey(str1)) && (!TextUtils.isEmpty((CharSequence)this.jdField_b_of_type_JavaUtilHashMap.get(str1)))) {
        break label430;
      }
      String str2 = BaseApplicationImpl.sApplication.getProperty(Constants.PropertiesKey.nickName.toString() + str1);
      localObject = str2;
      if (TextUtils.isEmpty(str2)) {
        localObject = str1;
      }
      label363:
      localTextView.setText((CharSequence)localObject);
      ThreadManager.postImmediately(new rga(this, str1, localSimpleAccount, (String)localObject, localTextView, localImageView1), null, true);
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label447;
        }
        localView.setContentDescription((CharSequence)localObject);
      }
    }
    for (;;)
    {
      i += 1;
      break label77;
      break;
      localImageView2.setVisibility(8);
      break label256;
      label430:
      localObject = (String)this.jdField_b_of_type_JavaUtilHashMap.get(str1);
      break label363;
      label447:
      if (localImageView2.getVisibility() == 0) {}
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label495;
        }
        localView.setContentDescription((String)localObject + "已登录");
        break;
      }
      label495:
      localView.setContentDescription((String)localObject + "未登录");
    }
  }
  
  private void o()
  {
    Intent localIntent = new Intent();
    localIntent.setPackage(getPackageName());
    localIntent.setClass(this, LoginActivity.class);
    localIntent.putExtra("is_change_account", true);
    localIntent.putExtra("login_from_account_change", true);
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null) {
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin());
    }
    localIntent.putExtra("befault_uin", this.app.getCurrentAccountUin());
    startActivityForResult(localIntent, 9876);
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2131034117);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
    if (this.jdField_b_of_type_AndroidViewAnimationAnimation == null)
    {
      this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2131034118);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    }
  }
  
  public long a(AppRuntime.Status paramStatus)
  {
    if (paramStatus == AppRuntime.Status.online) {}
    do
    {
      return 11L;
      if (paramStatus == AppRuntime.Status.invisiable) {
        return 41L;
      }
    } while (paramStatus != AppRuntime.Status.away);
    return 31L;
  }
  
  public Dialog a(String paramString1, String paramString2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Dialog localDialog = new Dialog(getActivity(), 2131624516);
    localDialog.setContentView(2130968978);
    TextView localTextView = (TextView)localDialog.findViewById(2131364034);
    if (localTextView != null)
    {
      if (paramString1 == null) {
        localTextView.setVisibility(8);
      }
    }
    else
    {
      paramString1 = (TextView)localDialog.findViewById(2131362776);
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
      paramString1 = (TextView)localDialog.findViewById(2131364037);
      if (paramString1 != null) {
        paramString1.setText(2131433015);
      }
      paramString1 = (TextView)localDialog.findViewById(2131364038);
      if (paramString1 != null) {
        paramString1.setText(2131433016);
      }
      localDialog.setOnDismissListener(paramOnDismissListener);
      return localDialog;
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
    p();
    TextView localTextView = this.rightViewText;
    localTextView.setVisibility(0);
    localTextView.setText(2131434552);
    localTextView.setOnClickListener(new rgx(this));
    this.rightHighLView = ((TextView)getLayoutInflater().inflate(2130968840, null));
    setLayerType(this.rightHighLView);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11, 1);
    ((RelativeLayout.LayoutParams)localObject).addRule(15, 1);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = ((int)(8.0F * this.mDensity));
    this.vg.addView(this.rightHighLView, (ViewGroup.LayoutParams)localObject);
    this.rightHighLView.setVisibility(8);
    this.rightHighLView.setText(2131434534);
    this.rightHighLView.setOnClickListener(new rgz(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131362759));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131362761));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131361826));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    a(this.app.a());
    this.jdField_a_of_type_AndroidViewView = findViewById(2131362768);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new rhb(this));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131362769);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new rhc(this));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131362760));
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    k();
    localObject = getResources().getDisplayMetrics();
    this.jdField_c_of_type_Float = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    this.jdField_b_of_type_Float = (this.jdField_c_of_type_Float - 110.0F * this.mDensity);
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      localTextView.setContentDescription("编辑按钮");
      this.rightHighLView.setContentDescription("完成");
      this.jdField_a_of_type_AndroidViewView.setContentDescription(getString(2131435427));
      this.jdField_b_of_type_AndroidViewView.setContentDescription("退出QQ");
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription("关联QQ号");
      AccessibilityUtil.a(findViewById(2131362758), false);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (localObject == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this, null));
      String[] arrayOfString = getResources().getStringArray(2131296283);
      int i = 0;
      while (i < arrayOfString.length)
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.a(arrayOfString[i], 1);
        i += 1;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433015);
      this.jdField_a_of_type_Rhi.a(paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this.jdField_a_of_type_Rhi);
      localObject = getString(2131433229).replace("${account}", ((SimpleAccount)localObject).getUin());
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a((CharSequence)localObject);
    } while (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing());
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  public void a(int paramInt, boolean paramBoolean)
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
    SubAccountManager localSubAccountManager = (SubAccountManager)this.app.getManager(60);
    if ((localSubAccountManager != null) && (localSubAccountManager.a(str1)))
    {
      SubAccountControll.a(this.app, (byte)0, str1);
      localSubAccountManager.e(str1);
      localSubAccountManager.a(str1, null, true);
      localSubAccountManager.a(str1, 2);
      SubAccountControll.a(this.app, str1, 7);
      int i = 1 - this.app.a().a(str1, 7000);
      if (i != 0) {
        this.app.a().c(str1, 7000, i);
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
    ThreadManager.post(new rgg(this, str1, paramBoolean, paramInt), 8, null, true);
  }
  
  public void a(long paramLong)
  {
    AppRuntime.Status localStatus = AppRuntime.Status.offline;
    if (paramLong == 11L) {
      localStatus = AppRuntime.Status.online;
    }
    for (;;)
    {
      a(localStatus);
      return;
      if (paramLong == 41L) {
        localStatus = AppRuntime.Status.invisiable;
      } else if (paramLong == 31L) {
        localStatus = AppRuntime.Status.away;
      }
    }
  }
  
  void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramInt2 == 0)
    {
      localObject = new TranslateAnimation(0.0F, 34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
      ((Animation)localObject).setDuration(250L);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((Animation)localObject).setFillAfter(true);
        ((Animation)localObject).setAnimationListener(new rhg(this, paramView, paramInt2));
        paramView.clearAnimation();
        paramView.startAnimation((Animation)localObject);
      }
      return;
      if (paramInt2 == 1)
      {
        localObject = new TranslateAnimation(0.0F, -34.0F * this.jdField_a_of_type_Float, 0.0F, 0.0F);
        ((Animation)localObject).setDuration(250L);
      }
      else
      {
        localObject = AnimationUtils.loadAnimation(this, paramInt1);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = this.app.getApp().getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  public void a(AppRuntime.Status paramStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AccountManageActivity", 2, "updateOnlineStatusFlag status=" + paramStatus);
    }
    if (paramStatus == AppRuntime.Status.online)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130846279), DisplayUtil.a(this, 18.5F), DisplayUtil.a(this, 13.0F));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131433488) + getString(2131437129));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131433490) + getString(2131437130));
      }
    }
    do
    {
      do
      {
        return;
        if (paramStatus != AppRuntime.Status.invisiable) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(getResources().getDrawable(2130846279), DisplayUtil.a(this, 18.5F), DisplayUtil.a(this, 13.0F));
      } while (!AppSetting.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131433488) + getString(2131437130));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getString(2131433490) + getString(2131437129));
      return;
    } while (paramStatus != AppRuntime.Status.away);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setRightIcon(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    label28:
    View localView;
    if (i < j)
    {
      localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      if (localView.getTag() != null) {
        break label108;
      }
      if (!paramBoolean) {
        break label82;
      }
      localView.setOnClickListener(null);
      localView.setBackgroundResource(2130846006);
      localView.setEnabled(false);
    }
    for (;;)
    {
      i += 1;
      break label28;
      break;
      label82:
      localView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      localView.setBackgroundResource(2130838630);
      localView.setEnabled(true);
      continue;
      label108:
      ImageView localImageView = (ImageView)localView.findViewById(2131362756);
      TextView localTextView = (TextView)localView.findViewById(2131362754);
      if (i == 0)
      {
        if (paramBoolean)
        {
          localView.setOnClickListener(null);
          localView.setBackgroundResource(2130846021);
          localImageView.setImageResource(2130846279);
        }
        else
        {
          localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localView.setBackgroundResource(2130838635);
          localImageView.setImageResource(2130846280);
        }
      }
      else if (paramBoolean)
      {
        localView.setOnClickListener(null);
        localView.setBackgroundResource(2130846015);
        localImageView.setImageResource(2130846279);
      }
      else
      {
        localView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localView.setBackgroundResource(2130838633);
        localImageView.setImageResource(2130846280);
      }
    }
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {
      return;
    }
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
    int i = 0;
    label28:
    Object localObject2;
    if (i < j)
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
      localObject1 = ((View)localObject2).getTag();
      if (localObject1 != null) {
        break label62;
      }
    }
    label62:
    ImageView localImageView1;
    ImageView localImageView2;
    RelativeLayout localRelativeLayout;
    RotateSwitchImageView localRotateSwitchImageView;
    for (;;)
    {
      i += 1;
      break label28;
      break;
      localImageView1 = (ImageView)((View)localObject2).findViewById(2131362756);
      localImageView2 = (ImageView)((View)localObject2).findViewById(2131362719);
      localRelativeLayout = (RelativeLayout)((View)localObject2).findViewById(2131362753);
      localRotateSwitchImageView = (RotateSwitchImageView)((View)localObject2).findViewById(2131362752);
      localObject2 = (ImageView)((View)localObject2).findViewById(2131362751);
      if ((localImageView2.getTag() == null) || (localRelativeLayout.getTag() == null))
      {
        localImageView2.setTag("left");
        localRelativeLayout.setTag("left");
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label247;
      }
      if (localImageView1.getVisibility() == 0) {
        a(localImageView1, 2131034113, 5);
      }
      localRotateSwitchImageView.setVisibility(0);
      ((ImageView)localObject2).setVisibility(0);
      localRotateSwitchImageView.setImageResource(2130845519);
      a(localRotateSwitchImageView, 2131034114, 4);
      a((View)localObject2, 2131034114, 4);
      a(localImageView2, 2131034118, 0);
      a(localRelativeLayout, 2131034118, 0);
    }
    label247:
    localRotateSwitchImageView.setVisibility(8);
    ((ImageView)localObject2).setVisibility(8);
    int k = ((Integer)localObject1).intValue();
    Object localObject1 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
    if ((localObject1 != null) && (((SimpleAccount)localObject1).getUin() != null) && (((SimpleAccount)localObject1).getUin().length() > 0) && (((SimpleAccount)localObject1).getUin().equals(this.app.getCurrentAccountUin()))) {
      localImageView1.setVisibility(0);
    }
    for (;;)
    {
      if (localImageView1.getVisibility() == 0) {
        a(localImageView1, 2131034114, 4);
      }
      a(localRotateSwitchImageView, 2131034113, 5);
      a((View)localObject2, 2131034113, 5);
      a(localImageView2, 2131034117, 1);
      a(localRelativeLayout, 2131034117, 1);
      break;
      localImageView1.setVisibility(8);
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount() <= 0)) {}
    int i;
    label28:
    Object localObject2;
    do
    {
      do
      {
        return;
        int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
        i = 0;
        if (i >= j) {
          break;
        }
        localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        localObject2 = ((View)localObject1).getTag();
      } while (localObject2 == null);
      int k = ((Integer)localObject2).intValue();
      localObject2 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(k);
    } while (localObject2 == null);
    Object localObject1 = (ImageView)((View)localObject1).findViewById(2131362756);
    if ((((SimpleAccount)localObject2).getUin() != null) && (((SimpleAccount)localObject2).getUin().length() > 0) && (((SimpleAccount)localObject2).getUin().equals(this.app.getCurrentAccountUin())) && (!this.jdField_a_of_type_Boolean)) {
      ((ImageView)localObject1).setVisibility(0);
    }
    for (;;)
    {
      i += 1;
      break label28;
      break;
      ((ImageView)localObject1).setVisibility(8);
    }
  }
  
  public void d()
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 2010) {}
    do
    {
      return;
      if ((paramInt2 == -1) && (paramInt1 == 1000))
      {
        l();
        return;
      }
    } while ((paramInt2 != -1) || (paramInt1 != 9876));
    l();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130968591);
    setTitle(2131436804);
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    setContentBackgroundResource(2130838214);
    a();
    l();
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    ThreadManager.post(new rfv(this), 5, null, true);
    sendBroadcast(new Intent("before_account_change"));
    ReportController.b(this.app, "dc00898", "", "", "0X800735C", "0X800735C", 0, 0, "", "", "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.removeHandler(getClass());
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    d();
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    b(false);
    n();
    g();
  }
  
  public void e()
  {
    d();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230).setTitle(getString(2131436308)).setMessage(getString(2131436319));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(getString(2131436321), new rgk(this));
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setNegativeButton(getString(2131433015), new rgl(this));
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131435613);
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
  
  public void h()
  {
    i();
    Dialog localDialog = a("你确定退出QQ？", null, new rgu(this));
    Object localObject = (TextView)localDialog.findViewById(2131364038);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new rgv(this, localDialog));
    }
    localObject = (TextView)localDialog.findViewById(2131364037);
    if (localObject != null) {
      ((TextView)localObject).setOnClickListener(new rgw(this));
    }
    localObject = getString(2131435403);
    boolean bool = SettingCloneUtil.isContainValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key");
    this.jdField_d_of_type_Boolean = SettingCloneUtil.readValue(getActivity(), this.app.getCurrentAccountUin(), (String)localObject, "qqsetting_receivemsg_whenexit_key", true);
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountManageActivity", 4, "init CheckBox:receiveMsgWhenExitPerfExist:" + bool + ", bReceiveMsgOnExit:" + this.jdField_d_of_type_Boolean);
    }
    localObject = (CheckBox)localDialog.findViewById(2131363685);
    if ((bool) && (this.jdField_d_of_type_Boolean)) {
      ((CheckBox)localObject).setVisibility(8);
    }
    ((CheckBox)localObject).setChecked(this.jdField_d_of_type_Boolean);
    this.jdField_c_of_type_AndroidAppDialog = localDialog;
    this.jdField_c_of_type_AndroidAppDialog.show();
  }
  
  public void i()
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
  
  protected void onAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountManageActivity", 2, "onAccountChanged zsw");
    }
    super.onAccountChanged();
    com.tencent.mobileqq.servlet.CliNotifyPush.a = 0;
    this.app.removeHandler(getClass());
    this.app = ((QQAppInterface)getAppRuntime());
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_Boolean = false;
      n();
    }
    for (;;)
    {
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSubAccountBindObserver);
      addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      if (QLog.isColorLevel()) {
        QLog.d("Switch_Account", 2, "onAccountChanged2");
      }
      ThreadManager.postImmediately(new rgm(this), null, true);
      SubAccountAssistantForward.b(this.app, this);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rgo(this), 500L);
      return;
      l();
    }
  }
  
  protected void onAccoutChangeFailed()
  {
    g();
    this.jdField_e_of_type_Boolean = false;
    o();
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    if (paramLogoutReason == Constants.LogoutReason.user)
    {
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "zsw onLogout");
      }
      this.jdField_f_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity
 * JD-Core Version:    0.7.0.1
 */