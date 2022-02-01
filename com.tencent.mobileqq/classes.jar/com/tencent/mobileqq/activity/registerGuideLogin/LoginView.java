package com.tencent.mobileqq.activity.registerGuideLogin;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.QFragmentActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.LoginUserPrivateHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.loginregister.EquipLockProxy;
import com.tencent.mobileqq.loginregister.LoginProxy;
import com.tencent.mobileqq.loginregister.LoginSharedPreUtils;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.register.RegisterLimitHelperImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.PhoneNumQuickLoginManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ConfigClearableEditText.OnTextClearedListener;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.mobileqq.widget.NewStyleDropdownView.DropdownCallback;
import com.tencent.mobileqq.widget.PadQQCheckBox;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.app.WtloginManagerImpl;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.observer.WtloginObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.tools.MD5;
import oicq.wlogin_sdk.tools.util;
import tencent.im.login.GetLocalPhone.MaskPhoneData;

public class LoginView
  extends GuideBaseFragment
  implements DialogInterface.OnClickListener, View.OnClickListener, View.OnTouchListener, ConfigClearableEditText.OnTextClearedListener, InputMethodRelativeLayout.onSizeChangedListenner, NewStyleDropdownView.DropdownCallback
{
  private float jdField_a_of_type_Float = 1.0F;
  int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator = null;
  public BroadcastReceiver a;
  TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new LoginView.25(this);
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  private final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new LoginView.24(this);
  private View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new LoginView.28(this);
  View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  AutoCompleteTextView jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  LoginAnimBtnView jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView;
  private LoginFailedHelper jdField_a_of_type_ComTencentMobileqqAppLoginFailedHelper = new LoginFailedHelper();
  private EquipLockProxy jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy;
  private LoginProxy jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy;
  private ILoginApi jdField_a_of_type_ComTencentMobileqqLogintempapiILoginApi;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  InputMethodRelativeLayout jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout;
  NewStyleDropdownView jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView;
  PadQQCheckBox jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox;
  PastablePwdEditText jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText;
  SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  private Runnable jdField_a_of_type_JavaLangRunnable = new LoginView.18(this);
  List<SimpleAccount> jdField_a_of_type_JavaUtilList;
  private Map<String, Object> jdField_a_of_type_JavaUtilMap;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new LoginView.30(this);
  private final WtloginObserver jdField_a_of_type_MqqObserverWtloginObserver = new LoginView.29(this);
  private GetLocalPhone.MaskPhoneData jdField_a_of_type_TencentImLoginGetLocalPhone$MaskPhoneData;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver;
  TextWatcher jdField_b_of_type_AndroidTextTextWatcher = new LoginView.26(this);
  View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private Runnable jdField_b_of_type_JavaLangRunnable = new LoginView.19(this);
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  TextWatcher jdField_c_of_type_AndroidTextTextWatcher = new LoginView.27(this);
  View jdField_c_of_type_AndroidViewView;
  private Button jdField_c_of_type_AndroidWidgetButton;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout.LayoutParams jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  View jdField_d_of_type_AndroidViewView;
  private Button jdField_d_of_type_AndroidWidgetButton;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  View jdField_e_of_type_AndroidViewView;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  View jdField_g_of_type_AndroidViewView;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  View jdField_h_of_type_AndroidViewView;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private View jdField_i_of_type_AndroidViewView;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private View jdField_j_of_type_AndroidViewView = null;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o = false;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s;
  private boolean t;
  private boolean u;
  private boolean v = false;
  private boolean w = true;
  private boolean x = false;
  
  public LoginView()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new LoginView.3(this);
  }
  
  @SuppressLint({"ValidFragment"})
  public LoginView(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new LoginView.3(this);
  }
  
  private SimpleAccount a(String paramString)
  {
    QLog.d("LoginActivity.LoginView", 1, "start getSimpleAccountByUin");
    if (TextUtils.isEmpty(paramString))
    {
      QLog.d("LoginActivity.LoginView", 1, "getSimpleAccountByUin, but uin is empty");
      return null;
    }
    Object localObject = MsfSdkUtils.getLoginedAccountList();
    if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
    {
      QLog.d("LoginActivity.LoginView", 1, "getSimpleAccountByUin, but accountList is null or empty");
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
      if (paramString.equals(localSimpleAccount.getUin())) {
        return localSimpleAccount;
      }
    }
    return null;
  }
  
  private Map<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_from_account_change", Boolean.valueOf(this.jdField_h_of_type_Boolean));
    return localHashMap;
  }
  
  private void a(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isFinishing()) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.dismissDialog(paramInt);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("LoginActivity.LoginView", 1, "hideLoadingDialog error : ", localException);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin != paramInt4)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = paramInt4;
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.requestLayout();
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin != paramInt3)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = paramInt3;
      this.jdField_g_of_type_AndroidViewView.requestLayout();
    }
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin != paramInt2)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = paramInt2;
      this.jdField_a_of_type_AndroidWidgetImageView.requestLayout();
    }
    try
    {
      this.jdField_e_of_type_AndroidViewView.scrollTo(0, paramInt1);
      label89:
      if (this.x) {
        if (this.w) {
          if (paramFloat < 0.99F)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            if (this.jdField_a_of_type_AndroidWidgetImageView.getAlpha() > 1.0F - paramFloat) {
              this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F - paramFloat);
            }
          }
        }
      }
      while (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow())
      {
        do
        {
          return;
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.0F);
          return;
          if (paramFloat >= 0.99F) {
            break;
          }
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        } while (this.jdField_a_of_type_AndroidWidgetImageView.getAlpha() >= paramFloat);
        this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(paramFloat);
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      return;
    }
    catch (Exception localException)
    {
      break label89;
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("appid");
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    ReportController.b(localAppRuntime, "dc00898", "", "", paramString, paramString, paramInt, 0, "", str1, "", "");
  }
  
  private void a(View paramView)
  {
    this.jdField_j_of_type_AndroidViewView = paramView.findViewById(2131376889);
    paramView.findViewById(2131376888).setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363591);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView = ((NewStyleDropdownView)paramView.findViewById(2131371016));
    this.jdField_i_of_type_AndroidViewView = paramView.findViewById(2131375180);
    if ((b()) && (getActivity() != null))
    {
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
      a(0, "0X800BA14");
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new LoginView.7(this);
      getActivity().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, new IntentFilter("mqq.intent.action.QRCODE_LOGIN_FINISH"));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.setHeadBorder(2130846721);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.setHeadDrawableDownListener(new LoginView.8(this));
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a = this;
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699698));
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getInputExtras(true);
    if (localObject1 != null) {
      ((Bundle)localObject1).putInt("INPUT_TYPE_ON_START", 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText = ((PastablePwdEditText)paramView.findViewById(2131372766));
    localObject1 = (ImageView)paramView.findViewById(2131372767);
    int i1 = (int)(43.0F * this.jdField_a_of_type_Float + 0.5F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setCustomClearButtonCallback(new LoginView.9(this, (ImageView)localObject1, i1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setOnTextContextSelectListener(new LoginView.10(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699700));
    localObject1 = new SpannableString(HardCodeUtil.a(2131699694));
    ((SpannableString)localObject1).setSpan(new AbsoluteSizeSpan(17, true), 0, ((SpannableString)localObject1).length(), 33);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setHint((CharSequence)localObject1);
    if (Build.VERSION.SDK_INT >= 26) {}
    Object localObject2;
    try
    {
      View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText, new Object[] { Integer.valueOf(8) });
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView = ((LoginAnimBtnView)paramView.findViewById(2131370817));
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699699));
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.a();
      h();
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376864));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719755));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131372934));
      this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131372458));
      this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719447));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)paramView.findViewById(2131370831));
      this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131370090);
      this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131377553);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnTouchListener(this);
      this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131377561);
      this.jdField_e_of_type_AndroidViewView.setOnTouchListener(new LoginView.11(this));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370826));
      if (this.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131370130);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131366994));
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699690));
      paramView.findViewById(2131364268).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSystemService("input_method"));
      this.jdField_b_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a();
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject1 = MobileQQ.sMobileQQ.getAllAccounts();
        if (localObject1 != null) {
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
        }
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
        {
          e(false);
          PhoneNumQuickLoginManager.b("0X800B8C9");
        }
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label2143;
        }
        while (this.jdField_a_of_type_JavaUtilList.size() > 8) {
          this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        QLog.w("LoginActivity.LoginView", 2, "disable auto fill error", localException1);
        continue;
        try
        {
          this.jdField_a_of_type_JavaUtilList.clear();
        }
        catch (Exception localException2)
        {
          QLog.d("LoginActivity.LoginView", 1, "initViews crash: ", localException2);
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
        }
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setAdapter(new LoginView.AccountAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity));
      if (((!this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) && (!this.jdField_i_of_type_Boolean) && (!this.s) && (!this.jdField_k_of_type_Boolean))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("uin");
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("befault_uin");
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("is_show_not_login_uin", false);
        if ((!this.jdField_f_of_type_Boolean) || (localObject2 == null) || (((String)localObject2).length() <= 0)) {
          break label2118;
        }
        i1 = 0;
        int i4 = 0;
        int i2 = -1;
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1);
          int i5 = i4;
          int i6 = i2;
          if (localSimpleAccount != null)
          {
            if (localSimpleAccount.getUin() != null) {
              break label1130;
            }
            i6 = i2;
            i5 = i4;
          }
          for (;;)
          {
            i1 += 1;
            i4 = i5;
            i2 = i6;
            break;
            label1130:
            int i3 = i2;
            if (str != null)
            {
              i3 = i2;
              if (str.equals(localSimpleAccount.getUin())) {
                i3 = i1;
              }
            }
            i5 = i4;
            i6 = i3;
            if (((String)localObject2).equals(localSimpleAccount.getUin()))
            {
              a(localSimpleAccount);
              this.jdField_a_of_type_Int = i1;
              i5 = 1;
              i6 = i3;
            }
          }
        }
        if ((bool) && (i4 == 0))
        {
          QLog.d("LoginActivity.LoginView", 1, "initViews: show not login uin.");
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText((CharSequence)localObject2);
        }
        if (i2 != -1) {
          this.jdField_a_of_type_JavaUtilList.remove(i2);
        }
      }
    }
    a(this.jdField_a_of_type_JavaUtilList);
    label1251:
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setLongClickable(true);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372770));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
      if ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_i_of_type_Boolean) || (this.s))
      {
        i1 = 2130847341;
        label1380:
        ((ImageView)localObject2).setImageResource(i1);
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706367));
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.mSystemBarComp != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
          this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.mSystemBarComp.init();
        }
        this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370819);
        this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131369151);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.clearFocus();
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setClearButtonVisible(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTextClearedListener(this);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_c_of_type_AndroidTextTextWatcher);
        b(paramView);
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("key_req_by_contact_sync", false)) && (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("key_uin_to_login");
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(paramView);
          if (!TextUtils.isEmpty(paramView)) {
            a(paramView);
          }
        }
        if ((this.s) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_c_of_type_JavaLangString);
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_j_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setTextColor(-16578534);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setHintTextColor(-5196865);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(true);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTextColor(-16578534);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setHintTextColor(-5196865);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131365937).setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        d(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow());
        if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_f_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (!this.s)) {
          break label2318;
        }
        QLog.d("LoginActivity.LoginView", 1, new Object[] { "isChange : ", Boolean.valueOf(this.jdField_f_of_type_Boolean), " isAddAccount : ", Boolean.valueOf(this.jdField_g_of_type_Boolean), " isFromRegisterChoose: ", Boolean.valueOf(this.jdField_i_of_type_Boolean), " mIsNeedLoginWithMask : ", Boolean.valueOf(this.s) });
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_j_of_type_AndroidViewView.setVisibility(0);
        this.jdField_j_of_type_AndroidViewView.setOnClickListener(this);
        if (!this.jdField_i_of_type_Boolean) {
          break label2276;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("uin");
        if (!TextUtils.isEmpty(paramView))
        {
          i1 = paramView.length();
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(paramView.substring(0, 2) + "****" + paramView.substring(i1 - 2, i1));
          a(paramView);
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(false);
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(8);
        }
        if (!this.m) {
          break label2242;
        }
        this.jdField_b_of_type_AndroidViewView.findViewById(2131365937).setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131378323).setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.findViewById(2131378324).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    label2318:
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLayoutParams());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidViewView.getLayoutParams());
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams());
      e();
      return;
      label2118:
      a((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(0));
      this.jdField_a_of_type_Int = 0;
      break;
      label2143:
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(8);
      break label1251;
      i1 = 2130844814;
      break label1380;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
      localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
      if ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_i_of_type_Boolean) || (this.s)) {}
      for (i1 = 2130847342;; i1 = 2130844817)
      {
        ((ImageView)localObject2).setImageResource(i1);
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706374));
        break;
      }
      label2242:
      this.jdField_b_of_type_AndroidViewView.findViewById(2131365937).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      continue;
      label2276:
      if (this.s)
      {
        d();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(true);
        continue;
        if ((this.l) || (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow())) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
  }
  
  private void a(ImageView paramImageView, Object paramObject)
  {
    if ((paramObject instanceof Bitmap))
    {
      paramImageView.setImageBitmap((Bitmap)paramObject);
      return;
    }
    paramImageView.setImageResource(2130840792);
  }
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.removeTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
        if (paramSimpleAccount == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText("");
          e();
          this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
          return;
        }
        this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
        if (this.jdField_a_of_type_MqqAppAppRuntime != null)
        {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(LoginUtils.a(paramSimpleAccount.getUin()));
          if (!TextUtils.isEmpty(paramSimpleAccount.getUin())) {
            a(paramSimpleAccount.getUin());
          }
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.selectAll();
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
          this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText("!@#ewaGbhkc$!!=");
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText("");
        }
      }
      finally {}
    }
  }
  
  private void a(String paramString1, CharSequence paramCharSequence, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    j();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 230).setTitle(paramString1).setMessage(paramCharSequence);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString2, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    label154:
    for (;;)
    {
      try
      {
        Object localObject = BaseApplication.getContext().getSharedPreferences("Last_Login", 4);
        if ((localObject != null) && (((SharedPreferences)localObject).contains("uin")) && (((SharedPreferences)localObject).getString("uin", "").equals(paramString)))
        {
          ((SharedPreferences)localObject).edit().remove("uin").commit();
          if (QLog.isColorLevel()) {
            QLog.d("login", 2, "delete Last_Login, isRelease:" + paramBoolean);
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy;
        QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
        if (!paramBoolean) {
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox.a()))
          {
            break label154;
            ((LoginProxy)localObject).a(localQBaseActivity, paramString, paramBoolean);
          }
          else
          {
            paramBoolean = false;
            continue;
          }
        }
        paramBoolean = true;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
    }
  }
  
  /* Error */
  private void a(List<SimpleAccount> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 285	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 263	java/util/HashMap
    //   13: dup
    //   14: invokespecial 264	java/util/HashMap:<init>	()V
    //   17: putfield 285	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   20: aload_1
    //   21: ifnull +12 -> 33
    //   24: aload_1
    //   25: invokeinterface 641 1 0
    //   30: ifeq +15 -> 45
    //   33: ldc 205
    //   35: iconst_1
    //   36: ldc_w 1007
    //   39: invokestatic 1009	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: new 1011	com/tencent/mobileqq/activity/registerGuideLogin/LoginView$4
    //   48: dup
    //   49: aload_0
    //   50: new 228	java/util/ArrayList
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 1014	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   58: invokespecial 1017	com/tencent/mobileqq/activity/registerGuideLogin/LoginView$4:<init>	(Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginView;Ljava/util/List;)V
    //   61: aconst_null
    //   62: iconst_1
    //   63: invokestatic 1023	com/tencent/mobileqq/app/ThreadManager:postImmediately	(Ljava/lang/Runnable;Lcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   66: goto -24 -> 42
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	LoginView
    //   0	74	1	paramList	List<SimpleAccount>
    // Exception table:
    //   from	to	target	type
    //   2	20	69	finally
    //   24	33	69	finally
    //   33	42	69	finally
    //   45	66	69	finally
  }
  
  /* Error */
  private void a(GetLocalPhone.MaskPhoneData paramMaskPhoneData, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 1030	java/lang/System:currentTimeMillis	()J
    //   7: lstore 4
    //   9: lload 4
    //   11: aload_0
    //   12: getfield 1032	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:jdField_a_of_type_Long	J
    //   15: lsub
    //   16: ldc2_w 1033
    //   19: lcmp
    //   20: ifge +15 -> 35
    //   23: ldc 205
    //   25: iconst_1
    //   26: ldc_w 1036
    //   29: invokestatic 212	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: getfield 189	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:jdField_a_of_type_AndroidViewInputmethodInputMethodManager	Landroid/view/inputmethod/InputMethodManager;
    //   39: aload_0
    //   40: getfield 295	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:jdField_a_of_type_ComTencentMobileqqAppQBaseActivity	Lcom/tencent/mobileqq/app/QBaseActivity;
    //   43: invokevirtual 1040	com/tencent/mobileqq/app/QBaseActivity:getWindow	()Landroid/view/Window;
    //   46: invokevirtual 1046	android/view/Window:getDecorView	()Landroid/view/View;
    //   49: invokevirtual 1050	android/view/View:getWindowToken	()Landroid/os/IBinder;
    //   52: iconst_0
    //   53: invokevirtual 1054	android/view/inputmethod/InputMethodManager:hideSoftInputFromWindow	(Landroid/os/IBinder;I)Z
    //   56: pop
    //   57: iload_2
    //   58: ifeq +5 -> 63
    //   61: iconst_2
    //   62: istore_3
    //   63: iload_3
    //   64: invokestatic 1056	com/tencent/mobileqq/util/PhoneNumQuickLoginManager:b	(I)V
    //   67: aload_0
    //   68: lload 4
    //   70: putfield 1032	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:jdField_a_of_type_Long	J
    //   73: aload_0
    //   74: invokespecial 1058	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:a	()Ljava/util/Map;
    //   77: astore 6
    //   79: aload 6
    //   81: ldc_w 1060
    //   84: aload_1
    //   85: getfield 1066	tencent/im/login/GetLocalPhone$MaskPhoneData:str_mask_phone	Lcom/tencent/mobileqq/pb/PBStringField;
    //   88: invokevirtual 1070	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   91: invokeinterface 280 3 0
    //   96: pop
    //   97: aload 6
    //   99: ldc_w 1072
    //   102: aload_0
    //   103: ldc_w 1073
    //   106: invokevirtual 1074	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:getString	(I)Ljava/lang/String;
    //   109: invokeinterface 280 3 0
    //   114: pop
    //   115: aload 6
    //   117: ldc_w 1076
    //   120: aload_0
    //   121: ldc_w 1077
    //   124: invokevirtual 1074	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:getString	(I)Ljava/lang/String;
    //   127: invokeinterface 280 3 0
    //   132: pop
    //   133: aload 6
    //   135: ldc_w 1079
    //   138: aload_1
    //   139: getfield 1082	tencent/im/login/GetLocalPhone$MaskPhoneData:str_terms_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   142: invokevirtual 1070	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   145: invokeinterface 280 3 0
    //   150: pop
    //   151: aload 6
    //   153: ldc_w 1084
    //   156: iload_2
    //   157: invokestatic 274	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   160: invokeinterface 280 3 0
    //   165: pop
    //   166: aload_0
    //   167: invokevirtual 404	com/tencent/mobileqq/activity/registerGuideLogin/LoginView:getActivity	()Landroid/support/v4/app/QFragmentActivity;
    //   170: new 1086	com/tencent/mobileqq/activity/registerGuideLogin/LoginView$21
    //   173: dup
    //   174: aload_0
    //   175: invokespecial 1087	com/tencent/mobileqq/activity/registerGuideLogin/LoginView$21:<init>	(Lcom/tencent/mobileqq/activity/registerGuideLogin/LoginView;)V
    //   178: aload 6
    //   180: invokestatic 1090	com/tencent/mobileqq/util/PhoneNumQuickLoginManager:a	(Landroid/content/Context;Landroid/view/View$OnClickListener;Ljava/util/Map;)V
    //   183: goto -151 -> 32
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	LoginView
    //   0	191	1	paramMaskPhoneData	GetLocalPhone.MaskPhoneData
    //   0	191	2	paramBoolean	boolean
    //   1	63	3	i1	int
    //   7	62	4	l1	long
    //   77	102	6	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   4	32	186	finally
    //   35	57	186	finally
    //   63	183	186	finally
  }
  
  private boolean a()
  {
    return (getActivity() != null) && (!getActivity().isFinishing());
  }
  
  private boolean a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        String str = paramIntent.getString("uin");
        if ((str != null) && (str.length() > 0))
        {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(str);
          a(str);
          paramIntent = paramIntent.getString("password");
          if ((paramIntent != null) && (paramIntent.length() > 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText(paramIntent);
            e();
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(View paramView)
  {
    View localView = paramView.findViewById(2131377159);
    if (localView != null) {
      QIphoneTitleBarActivity.setLayerType(localView);
    }
    localView = paramView.findViewById(2131376889);
    if (localView != null) {
      QIphoneTitleBarActivity.setLayerType(localView);
    }
    paramView = paramView.findViewById(2131369487);
    if (paramView != null) {
      QIphoneTitleBarActivity.setLayerType(paramView);
    }
  }
  
  private void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new LoginView.20(this, paramString));
  }
  
  private boolean b()
  {
    return !TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString);
  }
  
  private void c(View paramView)
  {
    int i1 = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramView.getId(), 0);
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, i1);
  }
  
  private void c(String paramString)
  {
    MsfSdkUtils.addLoginSimpleAccount(paramString, true);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getApplication().setProperty(Constants.PropertiesKey.uinDisplayName.toString() + paramString, paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    paramString = a(paramString);
    this.jdField_a_of_type_MqqAppAppRuntime.login(paramString);
  }
  
  private void d()
  {
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(false);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(8);
    }
    this.jdField_b_of_type_AndroidViewView.findViewById(2131365937).setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131378323).setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131378324).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  private void d(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "checkMultiWindowDisplay isInMultiWindowMode:" + paramBoolean);
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localLayoutParams.addRule(10);
      localLayoutParams.topMargin = ((int)(25.0F * this.jdField_a_of_type_Float));
      this.jdField_g_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.bottomMargin = Utils.a(15.0F, getResources());
      this.jdField_f_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLayoutParams();
      localLayoutParams.topMargin = Utils.a(24.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setLayoutParams(localLayoutParams);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    localLayoutParams.addRule(3, 2131370826);
    localLayoutParams.topMargin = ((int)(32.0F * this.jdField_a_of_type_Float));
    this.jdField_g_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.bottomMargin = Utils.a(35.0F, getResources());
    this.jdField_f_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLayoutParams();
    localLayoutParams.topMargin = Utils.a(57.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("from_register_choose", false)) || (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("is_need_login_with_mask", false))) {}
    for (int i1 = 6;; i1 = 1)
    {
      String str1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      String str2 = this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString();
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (str2.length() >= i1))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setEnabled(true);
        if ((TextUtils.isEmpty(str2)) || (str2.length() < 12)) {
          break label170;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTextSize(1, 17.0F);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(str1)) {
          break label184;
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setPadding((int)(this.jdField_a_of_type_Float * 63.0F + 0.5F), 0, (int)(this.jdField_a_of_type_Float * 63.0F + 0.5F), 0);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setEnabled(false);
        break;
        label170:
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTextSize(1, 22.0F);
      }
      label184:
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setPadding((int)(this.jdField_a_of_type_Float * 36.0F + 0.5F), 0, (int)(this.jdField_a_of_type_Float * 36.0F + 0.5F), 0);
      return;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.showDialog(4);
    }
    if (this.t)
    {
      QLog.d("LoginActivity.LoginView", 1, "is getting phone");
      PhoneNumQuickLoginManager.a(3);
      return;
    }
    if (this.jdField_a_of_type_TencentImLoginGetLocalPhone$MaskPhoneData != null)
    {
      a(4);
      a(this.jdField_a_of_type_TencentImLoginGetLocalPhone$MaskPhoneData, paramBoolean);
      PhoneNumQuickLoginManager.a(2);
      return;
    }
    this.t = true;
    PhoneNumQuickLoginManager.a(1);
    PhoneNumQuickLoginManager.a(this.jdField_a_of_type_MqqAppAppRuntime, new LoginView.WeakMaskCallback(this, paramBoolean));
  }
  
  private void f()
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "/base/browser");
    localActivityURIRequest.extra().putString("url", this.jdField_e_of_type_JavaLangString);
    localActivityURIRequest.extra().putBoolean("hide_more_button", true);
    localActivityURIRequest.extra().putBoolean("key_from_opensdk_qrcode", true);
    QRoute.startUri(localActivityURIRequest, null);
    this.jdField_i_of_type_AndroidViewView.setClickable(false);
    ThreadManager.getUIHandler().postDelayed(new LoginView.14(this), 1000L);
    a(0, "0X800BA15");
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new LoginView.16(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new LoginView.17(this));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView == null) {
      return;
    }
    if (LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131718962));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131693888));
  }
  
  private void i()
  {
    String str;
    if (this.jdField_i_of_type_Boolean)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("uin");
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("hasPwd", true))
      {
        a(null, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131716932), this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699691), this);
        return;
      }
    }
    while ((str == null) || (str.length() == 0) || (str.trim().length() == 0))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131694582, 0).a();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
      str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    }
    if (str.startsWith("0"))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131693520, 0).a();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString().length() < 1)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131694725, 0).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText, 2);
      return;
    }
    int i2 = this.jdField_a_of_type_JavaUtilList.size();
    int i1 = 0;
    Object localObject;
    if (i1 < i2)
    {
      localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1);
      if ((localObject == null) || (!str.equals(((SimpleAccount)localObject).getUin()))) {}
    }
    for (i1 = 0;; i1 = 1)
    {
      if (i1 != 0) {}
      for (i1 = i2 + 1;; i1 = i2)
      {
        if (i1 <= 8) {
          break label331;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131693892, 0).a();
        return;
        i1 += 1;
        break;
      }
      label331:
      if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (libsafeedit.checkPassLegal("!@#ewaGbhkc$!!=")))
      {
        localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        i1 = 0;
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          if ((this.jdField_a_of_type_JavaUtilList.get(i1) == null) || (((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1)).getUin() == null)) {}
          while (!((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1)).getUin().equals(localObject))
          {
            i1 += 1;
            break;
          }
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("userguide", 2, "login");
      }
      LoginStaticField.a(1);
      if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
      {
        com.tencent.mobileqq.util.LoginSetting.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.showDialog(0);
        if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
          this.jdField_a_of_type_MqqAppAppRuntime.login(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
        return;
        com.tencent.mobileqq.util.LoginSetting.jdField_a_of_type_Boolean = true;
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.showDialog(0);
          localObject = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
          localAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
          if (localAppRuntime == null) {
            break label620;
          }
          if (RegisterLimitHelperImpl.a().a(this.s, str, this.jdField_d_of_type_JavaLangString)) {
            localAppRuntime.login(RegisterLimitHelperImpl.a().a(this.jdField_d_of_type_JavaLangString), str, (byte[])localObject, null);
          }
        }
        catch (Exception localException)
        {
          AppRuntime localAppRuntime;
          for (;;)
          {
            localException.printStackTrace();
          }
          localAppRuntime.login(str, localException, null);
        }
        continue;
        label620:
        QLog.e("LoginActivity.LoginView", 1, "login() appRuntime is null");
      }
    }
  }
  
  private void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  private void k()
  {
    ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8007353", "0X8007353", 0, 0, "", "", "", "");
    ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
    ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8007365", "0X8007365", 3, 0, "", "", "", "");
    ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "new_reg_805", "log_page", "re_clk", "", 1, "");
    ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800AA2C", "0X800AA2C", 0, 0, "", "", "", "");
    Object localObject1 = null;
    if (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView != null) {
      localObject1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    }
    try
    {
      Long.parseLong((String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", localObject1 });
        localObject1 = new StringBuilder((String)localObject1);
        localObject3 = ((WtloginManagerImpl)this.jdField_a_of_type_MqqAppAppRuntime.getManager(1)).getGUID();
        byte[] arrayOfByte = util.get_bssid_addr(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
        if ((arrayOfByte != null) && (arrayOfByte.length > 0)) {
          ((StringBuilder)localObject1).append("&bssid=").append(MD5.toMD5(arrayOfByte));
        }
        ((StringBuilder)localObject1).append("&guid=").append(util.buf_to_string((byte[])localObject3)).append("&appid=").append(AppSetting.a());
        localObject1 = ((StringBuilder)localObject1).toString();
        QLog.d("LoginActivity.LoginView", 1, new Object[] { "forgetpwd url is ", localObject1 });
        localObject3 = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "/base/browser");
        ((ActivityURIRequest)localObject3).extra().putString("uin", this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
        ((ActivityURIRequest)localObject3).extra().putString("url", (String)localObject1);
        ((ActivityURIRequest)localObject3).extra().putInt("reqType", 3);
        QRoute.startUri((URIRequest)localObject3, null);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject3 = null;
        Object localObject2 = localObject3;
        if (QLog.isDevelopLevel())
        {
          QLog.i("LoginActivity.LoginView", 4, String.format(Locale.getDefault(), "forget pwd %s", new Object[] { this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString() }));
          localObject2 = localObject3;
          continue;
          localObject2 = "https://ti.qq.com/safe/forgetpw?source_id=2756";
        }
      }
    }
  }
  
  private void l()
  {
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setTextColor(-16578534);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setHintTextColor(-5196865);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTextColor(-16578534);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setHintTextColor(-5196865);
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray(4);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2131370817, 1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2131376864, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2131372934, 2);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2131366994, 4);
  }
  
  private void n()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("release_account_uin");
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("release_bold_text");
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("release_success_text");
    Object localObject2;
    Object localObject1;
    if ((!TextUtils.isEmpty(str1)) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (SimpleAccount)((Iterator)localObject2).next();
      } while (!str1.equals(((SimpleAccount)localObject1).getUin()));
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        if (this.jdField_a_of_type_MqqAppAppRuntime != null)
        {
          localObject2 = LoginUtils.a(str1);
          String str3 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
          LoginView.AccountAdapter localAccountAdapter = (LoginView.AccountAdapter)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
          if ((!TextUtils.isEmpty(str3)) && (str3.equals(localObject2)))
          {
            this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
            this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
            this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText("");
          }
          e();
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
          localAccountAdapter.notifyDataSetChanged();
          l();
          ThreadManager.postImmediately(new LoginView.31(this, str1), null, false);
        }
      }
      else
      {
        if (!TextUtils.isEmpty(str2)) {
          break label367;
        }
        localObject1 = getString(2131698401);
      }
      for (localObject2 = getString(2131698402);; localObject2 = localObject3)
      {
        localObject3 = new SpannableString((CharSequence)localObject1);
        if (((String)localObject1).contains((CharSequence)localObject2))
        {
          localObject3 = new SpannableString((CharSequence)localObject1);
          int i1 = ((String)localObject1).indexOf((String)localObject2);
          int i2 = ((String)localObject2).length();
          ((SpannableString)localObject3).setSpan(new StyleSpan(1), i1, i2 + i1, 33);
        }
        for (localObject1 = localObject3;; localObject1 = localObject3)
        {
          a(getString(2131698403), (CharSequence)localObject1, getString(2131698400), new LoginView.32(this));
          return;
          localObject2 = str1;
          break;
        }
        label367:
        localObject1 = str2;
      }
      localObject1 = null;
    }
  }
  
  public Dialog a(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return null;
      localObject = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
      ((QQProgressDialog)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699693));
      return localObject;
      localObject = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
      ((QQProgressDialog)localObject).a(HardCodeUtil.a(2131699695));
      return localObject;
      localObject = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
      ((QQProgressDialog)localObject).a(HardCodeUtil.a(2131699692));
      return localObject;
    } while (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isResume());
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onCreateDialog  DIALOG_CLEAR_ACCOUNT");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getLayoutInflater().inflate(2131559160, null);
    return DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 230).setPositiveButton(2131699687, this).setNegativeButton(2131699686, new LoginView.6(this)).addView((View)localObject);
  }
  
  public AutoCompleteTextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
  }
  
  Object a(String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqLogintempapiILoginApi.getFaceBitmap(this.jdField_a_of_type_MqqAppAppRuntime, paramString, (byte)4, false, paramBoolean);
    }
    return localObject;
  }
  
  public void a()
  {
    
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      this.jdField_a_of_type_MqqAppAppRuntime.stopPCActivePolling("clearPassInput");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if ((this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView == null) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText() == null) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString() == null)) {
        return;
      }
      int i1 = 0;
      if (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localSimpleAccount == null) {}
        while ((this.jdField_a_of_type_MqqAppAppRuntime == null) || (!((String)localObject).equals(LoginUtils.a(localSimpleAccount.getUin()))))
        {
          i1 += 1;
          break;
        }
        this.jdField_a_of_type_MqqAppAppRuntime.updateSubAccountLogin(localSimpleAccount.getUin(), false);
        this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy.a((String)localObject);
        this.jdField_a_of_type_JavaLangString = null;
        MobileQQ.sMobileQQ.refreAccountList();
        localObject = MobileQQ.sMobileQQ.getAllAccounts();
        if ((localObject != null) && (this.jdField_a_of_type_JavaUtilList != null))
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
        }
      }
    }
    l();
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    if (paramInt == 1)
    {
      TextView localTextView = (TextView)paramDialog.findViewById(2131379106);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699688);
      LoginView.AccountAdapter localAccountAdapter = (LoginView.AccountAdapter)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      if (this.jdField_a_of_type_Int != -1) {
        localTextView.setText(str.replace("${account}", localAccountAdapter.a(this.jdField_a_of_type_Int)));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox = ((PadQQCheckBox)paramDialog.findViewById(2131364708));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox.setText(getText(2131699689));
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    a(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onNewIntent");
    }
  }
  
  void a(ImageView paramImageView, String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null)
    {
      QLog.e("LoginActivity.LoginView", 1, "getAvatarIcon, context is null");
      return;
    }
    ThreadManager.postImmediately(new LoginView.23(this, paramString, paramBoolean, paramImageView), null, true);
  }
  
  void a(String paramString)
  {
    ThreadManager.postImmediately(new LoginView.22(this, paramString), null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_g_of_type_AndroidViewView == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onMultiWindowModeChanged isInMultiWindowMode:" + paramBoolean);
    }
    d(paramBoolean);
    this.p = false;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onSizeChange isOpen:" + paramBoolean + " preH:" + paramInt1 + " curH:" + paramInt2 + "  isInMultiWindow:" + this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow());
    }
    this.u = paramBoolean;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_c_of_type_Int = paramInt2;
    if ((paramBoolean) && (getActivity() != null)) {
      if (!this.q)
      {
        this.p = true;
        ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    do
    {
      return;
      this.q = false;
      this.p = false;
      ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 200L);
    } while (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow());
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    this.jdField_b_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt1);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLocationOnScreen(arrayOfInt2);
    if (arrayOfInt1[1] < arrayOfInt2[1] + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getHeight() + (int)(2.0F * this.jdField_a_of_type_Float + 0.5F))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(4);
      this.jdField_f_of_type_AndroidViewView.setVisibility(4);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    arrayOfInt2 = new int[2];
    this.jdField_f_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt2);
    if (arrayOfInt2[1] < arrayOfInt1[1] + this.jdField_b_of_type_AndroidViewView.getHeight() + (int)(2.0F * this.jdField_a_of_type_Float + 0.5F))
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(4);
      return;
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void b()
  {
    if (b()) {
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
    QFragmentActivity localQFragmentActivity = getActivity();
    if ((localQFragmentActivity != null) && (!localQFragmentActivity.isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_d_of_type_Boolean) && ((!this.jdField_g_of_type_Boolean) || (!this.jdField_h_of_type_Boolean)) && (!this.jdField_i_of_type_Boolean) && (!this.s) && (!this.l) && (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow()) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = false;
      if (this.n) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while ((!paramBoolean) || (!this.jdField_j_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow()))
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new LoginView.5(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().removeExtra("is_need_show_logo_animation");
    this.jdField_j_of_type_Boolean = false;
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new ScaleAnimation(1.429F, 1.0F, 1.429F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(500L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillAfter(true);
    float f1 = ViewUtils.a();
    localObject = new TranslateAnimation(ViewUtils.a() / 2.0F - 65.5F * f1, 0.0F, f1 * -8.0F, 0.0F);
    ((Animation)localObject).setDuration(500L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillBefore(true);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "hideDropdown isArrowUP = " + this.jdField_c_of_type_Boolean + " isScrolled = " + this.jdField_b_of_type_Boolean);
    }
    if (this.jdField_b_of_type_Boolean == true)
    {
      this.jdField_e_of_type_AndroidViewView.scrollTo(0, 0);
      this.jdField_b_of_type_Boolean = false;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    if (b()) {
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    String str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    if (!TextUtils.isEmpty(str)) {
      a(str);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      if (!TextUtils.isEmpty(str)) {
        a(str);
      }
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "arrowChangeCallback isArrowUP = " + this.jdField_c_of_type_Boolean + " isScrolled = " + this.jdField_b_of_type_Boolean);
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LoginView.AccountAdapter localAccountAdapter;
    String str1;
    String str3;
    if (this.jdField_a_of_type_Int != -1)
    {
      paramDialogInterface = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
      paramDialogInterface.c(true);
      paramDialogInterface.setContentView(2131562946);
      paramDialogInterface.c(2131691583);
      paramDialogInterface.show();
      localAccountAdapter = (LoginView.AccountAdapter)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      str1 = localAccountAdapter.b(this.jdField_a_of_type_Int);
      String str2 = localAccountAdapter.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
      str3 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      if ((!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (!str2.equals(str3))) {
        break label221;
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText("");
    }
    for (;;)
    {
      e();
      localAccountAdapter.notifyDataSetChanged();
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str1))) {
        this.jdField_a_of_type_JavaLangString = null;
      }
      l();
      ThreadManager.post(new LoginView.15(this, str1, paramDialogInterface), 8, null, false);
      return;
      label221:
      if (!TextUtils.isEmpty(str3)) {
        a(str3);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onClick id=" + i1);
    }
    c(paramView);
    if (i1 == 2131370817)
    {
      ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800AA28", "0X800AA28", 0, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityLoginUserPrivateHelper == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityLoginUserPrivateHelper.a(getActivity()))) {}
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i();
      ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8007366", "0X8007366", 0, 0, "", "", "", "");
      ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "new_reg_805", "log_page", "log_clk", "", 1, "");
      continue;
      Object localObject;
      if (i1 == 2131376864)
      {
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800AA2A", "0X800AA2A", 0, 0, "", "", "", "");
        if (Utils.c())
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131693892, 0).a();
        }
        else if (this.jdField_e_of_type_Boolean)
        {
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X80072E9", "0X80072E9", 0, 0, "", "", "", "");
          if ((this.jdField_g_of_type_Boolean) && (this.jdField_h_of_type_Boolean))
          {
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X800664F", "0X800664F", 0, 0, "", "", "", "");
            if (!NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
            {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131692257, 0).a();
              continue;
            }
          }
          for (;;)
          {
            try
            {
              ((AccountManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(0)).checkQuickRegisterAccount(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), AppSetting.a(), "8.5.5", null);
              this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.showDialog(4);
              this.jdField_e_of_type_Boolean = false;
              new Handler().postDelayed(new LoginView.12(this), 1000L);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              continue;
            }
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Mobile_signup", "Clk_new_user", 0, 0, "", "", "", "");
            localObject = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "/base/register/registerPhoneNumber");
            ((ActivityURIRequest)localObject).extra().putInt("key_register_from", 3);
            ((ActivityURIRequest)localObject).extra().putInt("key_report_extra_from", 3);
            QRoute.startUri((URIRequest)localObject, null);
          }
        }
      }
      else if (i1 == 2131366994)
      {
        QLog.d("LoginActivity.LoginView", 1, "onClick findPass");
        this.jdField_b_of_type_AndroidWidgetButton.setClickable(false);
        ThreadManager.getUIHandler().postDelayed(new LoginView.13(this), 500L);
        if (!this.p)
        {
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X80072EA", "0X80072EA", 0, 0, "", "", "", "");
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "new_reg_805", "log_page", "forge_clk", "", 1, "");
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800AA29", "0X800AA29", 0, 0, "", "", "", "");
          if ((this.jdField_g_of_type_Boolean) && (this.jdField_h_of_type_Boolean)) {
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X800664E", "0X800664E", 0, 0, "", "", "", "");
          }
          k();
          this.q = true;
        }
      }
      else if (i1 == 2131364268)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$GuideCallBack != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$GuideCallBack.handleBackEvent();
        }
      }
      else if (i1 == 2131380750)
      {
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X80072E8", "0X80072E8", 0, 0, "", "", "", "");
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800AA2B", "0X800AA2B", 0, 0, "", "", "", "");
        localObject = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "/base/browser");
        ((ActivityURIRequest)localObject).extra().putString("uin", this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
        ((ActivityURIRequest)localObject).extra().putBoolean("ba_is_login", false);
        ((ActivityURIRequest)localObject).extra().putString("url", "https://ti.qq.com/agreement/index.html");
        ((ActivityURIRequest)localObject).extra().putBoolean("hide_more_button", true);
        QRoute.startUri((URIRequest)localObject, null);
      }
      else
      {
        boolean bool;
        if (i1 == 2131372770)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString();
          if (!this.jdField_a_of_type_Boolean)
          {
            bool = true;
            label964:
            this.jdField_a_of_type_Boolean = bool;
            if (!this.jdField_a_of_type_Boolean) {
              break label1080;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
            if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_f_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (!this.s)) {
              break label1073;
            }
          }
          label1043:
          label1073:
          for (i1 = 2130847341;; i1 = 2130844814)
          {
            localImageView.setImageResource(i1);
            this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706368));
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break label1148;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setSelection(this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.length());
            break;
            bool = false;
            break label964;
          }
          label1080:
          this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
          ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
          if ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_i_of_type_Boolean) || (this.s)) {}
          for (i1 = 2130847342;; i1 = 2130844817)
          {
            localImageView.setImageResource(i1);
            this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706372));
            break label1043;
            label1148:
            break;
          }
        }
        if (i1 == 2131372458)
        {
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8007354", "0X8007354", 0, 0, "", "", "", "");
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8007365", "0X8007365", 2, 0, "", "", "", "");
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "new_reg_805", "log_page", "log_msg_clk", "", 1, "");
          bool = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("login_from_account_change", false);
          localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, LoginPhoneNumActivity.class);
          ((Intent)localObject).putExtra("login_from_account_change", bool);
          this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity((Intent)localObject);
        }
        else if (i1 == 2131372934)
        {
          if (!NetworkUtil.a()) {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131694457, 0).a();
          } else {
            e(true);
          }
        }
        else if (i1 == 2131375180)
        {
          f();
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    }
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    paramLayoutInflater = paramLayoutInflater.inflate(2131559448, paramViewGroup, false);
    if (paramBundle != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.n = bool;
      this.jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("is_change_account", false);
      this.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
      this.jdField_i_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("from_register_choose", false);
      this.jdField_h_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("login_from_account_change", false);
      this.jdField_j_of_type_Boolean = false;
      this.jdField_k_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("is_from_account_release", false);
      this.l = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("is_from_account_another_login_exit", false);
      this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("param_qr_code_url");
      this.m = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("hasPwd", true);
      this.s = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("is_need_login_with_mask", false);
      if (this.s)
      {
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("uinMask");
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("uinEncrpyt");
      }
      this.jdField_a_of_type_ComTencentMobileqqLogintempapiILoginApi = ((ILoginApi)QRoute.api(ILoginApi.class));
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy = new LoginProxy();
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy = new EquipLockProxy();
      a(paramLayoutInflater);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("logout_intent", false)) && (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null))
      {
        LoginSharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), false);
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin();
      }
      if ((getActivity() != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
      {
        paramViewGroup = new IntentFilter();
        paramViewGroup.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
        getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramViewGroup);
      }
      this.jdField_h_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131376842);
      this.jdField_h_of_type_AndroidViewView.post(new LoginView.1(this));
      if (this.jdField_k_of_type_Boolean) {
        n();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityLoginUserPrivateHelper != null)
      {
        paramViewGroup = new LoginView.2(this);
        this.jdField_a_of_type_ComTencentMobileqqActivityLoginUserPrivateHelper.a(paramViewGroup);
      }
      m();
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getExtras());
      ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "new_reg_805", "log_page", "page_exp", "", 1, "");
      ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8009E3D", "0X8009E3D", 0, 0, "", "", "", "");
      ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800AA27", "0X800AA27", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "onCreateView");
      }
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onDestroy");
    }
    super.onDestroy();
    if ((getActivity() != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
    {
      getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null)
    {
      if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning()) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.f();
    }
    a(4);
    this.o = true;
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy.a();
    if ((this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) && (getActivity() != null))
    {
      getActivity().unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.c();
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onPause");
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.p = false;
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setClearButtonVisible(false);
    if (this.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      this.jdField_a_of_type_MqqAppAppRuntime.cancelSyncOnlineFriend(-1L);
      this.jdField_a_of_type_MqqAppAppRuntime.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
    PhoneNumLoginImpl.a().a(false);
    b(true);
    if (this.r)
    {
      QLog.d("LoginActivity.LoginView", 1, "mShouldAutoLogin: true, then login()");
      this.r = false;
      if (!this.v) {
        break label207;
      }
      Map localMap = a();
      localMap.put("key_phone_num", this.jdField_a_of_type_TencentImLoginGetLocalPhone$MaskPhoneData.str_mask_phone.get());
      localMap.put("key_from_user_click", Boolean.valueOf(false));
      String str = PhoneNumQuickLoginManager.a(this.jdField_a_of_type_MqqAppAppRuntime);
      PhoneNumQuickLoginManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, str, localMap, this.jdField_a_of_type_MqqObserverWtloginObserver);
      this.v = false;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.b();
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "onResume");
      }
      return;
      label207:
      i();
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (paramBundle != null) {
      paramBundle.putInt("position", this.jdField_a_of_type_Int);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.isPopupShowing())
    {
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.dismissDropDown();
      paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      if (!TextUtils.isEmpty(paramView)) {
        a(paramView);
      }
    }
    return false;
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    if (paramBundle != null) {
      this.jdField_a_of_type_Int = paramBundle.getInt("position", -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView
 * JD-Core Version:    0.7.0.1
 */