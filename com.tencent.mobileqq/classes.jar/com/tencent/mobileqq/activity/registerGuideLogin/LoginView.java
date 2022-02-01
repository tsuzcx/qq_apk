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
import android.view.ViewGroup.LayoutParams;
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
import androidx.fragment.app.FragmentActivity;
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
import com.tencent.mobileqq.util.QuickLoginReporter;
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
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
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
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
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
    QLog.d("LoginActivity.LoginView", 1, "getSimpleAccountByUin, but accountList is null or empty");
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
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isFinishing()) {
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
      if (this.x)
      {
        if (this.w)
        {
          if (paramFloat < 0.99F)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            float f1 = this.jdField_a_of_type_AndroidWidgetImageView.getAlpha();
            paramFloat = 1.0F - paramFloat;
            if (f1 > paramFloat) {
              this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(paramFloat);
            }
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
            this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(0.0F);
          }
        }
        else if (paramFloat < 0.99F)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          if (this.jdField_a_of_type_AndroidWidgetImageView.getAlpha() < paramFloat) {
            this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(paramFloat);
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
        }
      }
      else if (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
      }
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
    this.jdField_j_of_type_AndroidViewView = paramView.findViewById(2131376379);
    paramView.findViewById(2131376378).setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363514);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView = ((NewStyleDropdownView)paramView.findViewById(2131370650));
    this.jdField_i_of_type_AndroidViewView = paramView.findViewById(2131374695);
    if ((b()) && (getActivity() != null))
    {
      this.jdField_i_of_type_AndroidViewView.setVisibility(0);
      this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
      a(0, "0X800BA14");
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new LoginView.7(this);
      getActivity().registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, new IntentFilter("mqq.intent.action.QRCODE_LOGIN_FINISH"));
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.setHeadBorder(2130846601);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.setHeadDrawableDownListener(new LoginView.8(this));
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a = this;
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699831));
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setTextAlignment(4);
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getInputExtras(true);
    if (localObject1 != null) {
      ((Bundle)localObject1).putInt("INPUT_TYPE_ON_START", 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText = ((PastablePwdEditText)paramView.findViewById(2131372343));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTextAlignment(4);
    localObject1 = (ImageView)paramView.findViewById(2131372344);
    ((ImageView)localObject1).setOnClickListener(this);
    int i1 = (int)(this.jdField_a_of_type_Float * 43.0F + 0.5F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setCustomClearButtonCallback(new LoginView.9(this, (ImageView)localObject1, i1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setOnTextContextSelectListener(new LoginView.10(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699833));
    localObject1 = new SpannableString(HardCodeUtil.a(2131699827));
    ((SpannableString)localObject1).setSpan(new AbsoluteSizeSpan(17, true), 0, ((SpannableString)localObject1).length(), 33);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setHint((CharSequence)localObject1);
    if (Build.VERSION.SDK_INT >= 26) {
      try
      {
        View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText, new Object[] { Integer.valueOf(8) });
      }
      catch (Exception localException1)
      {
        QLog.w("LoginActivity.LoginView", 2, "disable auto fill error", localException1);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView = ((LoginAnimBtnView)paramView.findViewById(2131370448));
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699832));
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.a();
    h();
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376354));
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719479));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131372521));
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131372041));
    this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131719165));
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)paramView.findViewById(2131370462));
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131369768);
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131376995);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnTouchListener(this);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131377005);
    this.jdField_e_of_type_AndroidViewView.setOnTouchListener(new LoginView.11(this));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370457));
    if (this.jdField_j_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131369801);
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131366847));
    this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699823));
    paramView.findViewById(2131364182).setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSystemService("input_method"));
    this.jdField_b_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a();
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    } else {
      try
      {
        localList.clear();
      }
      catch (Exception localException2)
      {
        QLog.d("LoginActivity.LoginView", 1, "initViews crash: ", localException2);
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
    }
    Object localObject2 = MobileQQ.sMobileQQ.getAllAccounts();
    if (localObject2 != null) {
      this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject2);
    }
    localObject2 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      d(false);
      PhoneNumQuickLoginManager.b("0X800B8C9");
    }
    localObject2 = this.jdField_a_of_type_JavaUtilList;
    Object localObject3;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      while (this.jdField_a_of_type_JavaUtilList.size() > 8)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilList;
        ((List)localObject2).remove(((List)localObject2).size() - 1);
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setAdapter(new LoginView.AccountAdapter(this, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity));
      if (((!this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) && (!this.jdField_i_of_type_Boolean) && (!this.s) && (!this.jdField_k_of_type_Boolean))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("uin");
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("befault_uin");
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("is_show_not_login_uin", false);
        if ((this.jdField_f_of_type_Boolean) && (localObject2 != null) && (((String)localObject2).length() > 0))
        {
          i1 = 0;
          int i4 = 0;
          int i5;
          for (int i2 = -1; i1 < this.jdField_a_of_type_JavaUtilList.size(); i2 = i5)
          {
            SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1);
            int i6 = i4;
            i5 = i2;
            if (localSimpleAccount != null) {
              if (localSimpleAccount.getUin() == null)
              {
                i6 = i4;
                i5 = i2;
              }
              else
              {
                int i3 = i2;
                if (localObject3 != null)
                {
                  i3 = i2;
                  if (((String)localObject3).equals(localSimpleAccount.getUin())) {
                    i3 = i1;
                  }
                }
                i6 = i4;
                i5 = i3;
                if (((String)localObject2).equals(localSimpleAccount.getUin()))
                {
                  a(localSimpleAccount);
                  this.jdField_a_of_type_Int = i1;
                  i6 = 1;
                  i5 = i3;
                }
              }
            }
            i1 += 1;
            i4 = i6;
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
        else
        {
          a((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(0));
          this.jdField_a_of_type_Int = 0;
        }
      }
      a(this.jdField_a_of_type_JavaUtilList);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setLongClickable(true);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372347));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
      if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_f_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (!this.s)) {
        i1 = 2130844690;
      } else {
        i1 = 2130847210;
      }
      ((ImageView)localObject2).setImageResource(i1);
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706418));
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
      localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
      if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_f_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (!this.s)) {
        i1 = 2130844693;
      } else {
        i1 = 2130847211;
      }
      ((ImageView)localObject2).setImageResource(i1);
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706425));
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.mSystemBarComp != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.mSystemBarComp.init();
    }
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370450);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131368883);
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
    this.jdField_b_of_type_AndroidViewView.findViewById(2131365774).setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    c(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow());
    if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_f_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (!this.s))
    {
      if ((this.l) || (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow())) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else
    {
      QLog.d("LoginActivity.LoginView", 1, new Object[] { "isChange : ", Boolean.valueOf(this.jdField_f_of_type_Boolean), " isAddAccount : ", Boolean.valueOf(this.jdField_g_of_type_Boolean), " isFromRegisterChoose: ", Boolean.valueOf(this.jdField_i_of_type_Boolean), " mIsNeedLoginWithMask : ", Boolean.valueOf(this.s) });
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_j_of_type_AndroidViewView.setVisibility(0);
      this.jdField_j_of_type_AndroidViewView.setOnClickListener(this);
      if (this.jdField_i_of_type_Boolean)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("uin");
        if (!TextUtils.isEmpty(paramView))
        {
          i1 = paramView.length();
          localObject2 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramView.substring(0, 2));
          ((StringBuilder)localObject3).append("****");
          ((StringBuilder)localObject3).append(paramView.substring(i1 - 2, i1));
          ((AutoCompleteTextView)localObject2).setText(((StringBuilder)localObject3).toString());
          a(paramView);
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(false);
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(8);
        }
        if (this.m)
        {
          this.jdField_b_of_type_AndroidViewView.findViewById(2131365774).setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131377731).setVisibility(8);
          this.jdField_b_of_type_AndroidViewView.findViewById(2131377732).setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
        }
        else
        {
          this.jdField_b_of_type_AndroidViewView.findViewById(2131365774).setVisibility(0);
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
        }
      }
      else if (this.s)
      {
        d();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(true);
      }
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLayoutParams());
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidViewView.getLayoutParams());
    this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams());
    e();
  }
  
  private void a(ImageView paramImageView, Object paramObject)
  {
    if ((paramObject instanceof Bitmap))
    {
      paramImageView.setImageBitmap((Bitmap)paramObject);
      return;
    }
    paramImageView.setImageResource(2130840667);
  }
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.removeTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
      if (paramSimpleAccount == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText("");
      }
      else
      {
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
      e();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
      return;
    }
    finally {}
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
    for (;;)
    {
      try
      {
        localObject = BaseApplication.getContext().getSharedPreferences("Last_Login", 4);
        if ((localObject != null) && (((SharedPreferences)localObject).contains("uin")) && (((SharedPreferences)localObject).getString("uin", "").equals(paramString)))
        {
          ((SharedPreferences)localObject).edit().remove("uin").commit();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("delete Last_Login, isRelease:");
            ((StringBuilder)localObject).append(paramBoolean);
            QLog.d("login", 2, ((StringBuilder)localObject).toString());
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy;
        localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
        if (paramBoolean) {
          break label160;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox == null) || (!this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox.a())) {
          break label155;
        }
      }
      catch (Exception paramString)
      {
        Object localObject;
        QBaseActivity localQBaseActivity;
        paramString.printStackTrace();
        return;
      }
      ((LoginProxy)localObject).a(localQBaseActivity, paramString, paramBoolean);
      return;
      label155:
      paramBoolean = false;
      continue;
      label160:
      paramBoolean = true;
    }
  }
  
  private void a(List<SimpleAccount> paramList)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilMap == null) {
        this.jdField_a_of_type_JavaUtilMap = new HashMap();
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        ThreadManager.postImmediately(new LoginView.4(this, new ArrayList(paramList)), null, true);
        return;
      }
      QLog.e("LoginActivity.LoginView", 1, "initFaceCache, uinList is empty");
      return;
    }
    finally {}
  }
  
  private void a(GetLocalPhone.MaskPhoneData paramMaskPhoneData, boolean paramBoolean)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      int i1 = 1;
      if (l1 - l2 < 500L)
      {
        QLog.d("LoginActivity.LoginView", 1, "showMaskPhoneDialog, but repeating showing");
        return;
      }
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
      if (paramBoolean) {
        i1 = 2;
      }
      PhoneNumQuickLoginManager.b(i1);
      this.jdField_a_of_type_Long = l1;
      Map localMap = a();
      localMap.put("key_phone_num", paramMaskPhoneData.str_mask_phone.get());
      localMap.put("key_self_btn_text", getString(2131699185));
      localMap.put("key_other_btn_text", getString(2131699186));
      localMap.put("key_user_agreement", paramMaskPhoneData.str_terms_wording.get());
      localMap.put("key_from_user_click", Boolean.valueOf(paramBoolean));
      PhoneNumQuickLoginManager.a(getQBaseActivity(), new LoginView.21(this), localMap);
      return;
    }
    finally {}
  }
  
  private boolean a()
  {
    return (getQBaseActivity() != null) && (!getQBaseActivity().isFinishing());
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
    View localView = paramView.findViewById(2131376636);
    if (localView != null) {
      QIphoneTitleBarActivity.setLayerType(localView);
    }
    localView = paramView.findViewById(2131376379);
    if (localView != null) {
      QIphoneTitleBarActivity.setLayerType(localView);
    }
    paramView = paramView.findViewById(2131369202);
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
    return TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString) ^ true;
  }
  
  private void c()
  {
    if (this.r)
    {
      this.r = false;
      if (this.v)
      {
        QLog.d("LoginActivity.LoginView", 1, "mShouldAutoLogin: true, then loginByPhoneToken()");
        this.v = false;
        Map localMap = a();
        localMap.put("key_phone_num", this.jdField_a_of_type_TencentImLoginGetLocalPhone$MaskPhoneData.str_mask_phone.get());
        localMap.put("key_from_user_click", Boolean.valueOf(false));
        String str = PhoneNumQuickLoginManager.a(this.jdField_a_of_type_MqqAppAppRuntime);
        PhoneNumQuickLoginManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, str, localMap, this.jdField_a_of_type_MqqObserverWtloginObserver);
        QuickLoginReporter.b(0, "SUCCESS");
        return;
      }
      QLog.d("LoginActivity.LoginView", 1, "mShouldAutoLogin: true, then login()");
      i();
    }
  }
  
  private void c(View paramView)
  {
    int i1 = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramView.getId(), 0);
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, i1);
  }
  
  private void c(String paramString)
  {
    MsfSdkUtils.addLoginSimpleAccount(paramString, true);
    MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Constants.PropertiesKey.uinDisplayName.toString());
    localStringBuilder.append(paramString);
    localMobileQQ.setProperty(localStringBuilder.toString(), paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    paramString = a(paramString);
    this.jdField_a_of_type_MqqAppAppRuntime.login(paramString);
  }
  
  private void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkMultiWindowDisplay isInMultiWindowMode:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("LoginActivity.LoginView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(this.jdField_a_of_type_Float * 25.0F));
      this.jdField_g_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = Utils.a(15.0F, getResources());
      this.jdField_f_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = Utils.a(24.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131370457);
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(this.jdField_a_of_type_Float * 32.0F));
    this.jdField_g_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = Utils.a(35.0F, getResources());
    this.jdField_f_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = Utils.a(57.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
    this.jdField_b_of_type_AndroidViewView.findViewById(2131365774).setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131377731).setVisibility(8);
    this.jdField_b_of_type_AndroidViewView.findViewById(2131377732).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  private void d(boolean paramBoolean)
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
  
  private void e()
  {
    int i1;
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("from_register_choose", false)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("is_need_login_with_mask", false))) {
      i1 = 1;
    } else {
      i1 = 6;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    String str = this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)) && (str.length() >= i1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setEnabled(true);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setEnabled(false);
    }
    if ((!TextUtils.isEmpty(str)) && (str.length() >= 12)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTextSize(1, 17.0F);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTextSize(1, 22.0F);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
      f1 = this.jdField_a_of_type_Float;
      ((AutoCompleteTextView)localObject).setPadding((int)(f1 * 63.0F + 0.5F), 0, (int)(f1 * 63.0F + 0.5F), 0);
      return;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
    float f1 = this.jdField_a_of_type_Float;
    ((AutoCompleteTextView)localObject).setPadding((int)(f1 * 36.0F + 0.5F), 0, (int)(f1 * 36.0F + 0.5F), 0);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131718678));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131693842));
  }
  
  private void i()
  {
    String str;
    if (this.jdField_i_of_type_Boolean)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("uin");
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("hasPwd", true)) {
        a(null, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131716585), this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699824), this);
      }
    }
    else
    {
      str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    }
    if ((str != null) && (str.length() != 0) && (str.trim().length() != 0))
    {
      if (str.startsWith("0"))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131693475, 0).a();
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
        this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString().length() < 1)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131694703, 0).a();
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.requestFocus();
        this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText, 2);
        return;
      }
      int i3 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      Object localObject;
      while (i1 < i3)
      {
        localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((localObject != null) && (str.equals(((SimpleAccount)localObject).getUin())))
        {
          i1 = 0;
          break label271;
        }
        i1 += 1;
      }
      i1 = 1;
      label271:
      int i2 = i3;
      if (i1 != 0) {
        i2 = i3 + 1;
      }
      if (i2 > 8)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131693846, 0).a();
        return;
      }
      if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (libsafeedit.checkPassLegal("!@#ewaGbhkc$!!=")))
      {
        localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        i1 = 0;
        while (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          if ((this.jdField_a_of_type_JavaUtilList.get(i1) != null) && (((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1)).getUin() != null) && (((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1)).getUin().equals(localObject)))
          {
            this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1));
            break;
          }
          i1 += 1;
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
      else
      {
        com.tencent.mobileqq.util.LoginSetting.jdField_a_of_type_Boolean = true;
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.showDialog(0);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        byte[] arrayOfByte = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
        AppRuntime localAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
        if (localAppRuntime != null)
        {
          if (RegisterLimitHelperImpl.a().a(this.s, str, this.jdField_d_of_type_JavaLangString)) {
            localAppRuntime.login(RegisterLimitHelperImpl.a().a(this.jdField_d_of_type_JavaLangString), str, arrayOfByte, null);
          } else {
            localAppRuntime.login(str, arrayOfByte, null);
          }
        }
        else {
          QLog.e("LoginActivity.LoginView", 1, "login() appRuntime is null");
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131694550, 0).a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
  }
  
  private void j()
  {
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing()))
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
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
    if (localObject1 != null)
    {
      localObject1 = ((AutoCompleteTextView)localObject1).getText().toString();
      try
      {
        Long.parseLong((String)localObject1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isDevelopLevel()) {
          QLog.i("LoginActivity.LoginView", 4, String.format(Locale.getDefault(), "forget pwd %s", new Object[] { this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString() }));
        }
      }
    }
    else
    {
      localObject2 = null;
    }
    Object localObject3 = "https://ti.qq.com/safe/forgetpw?source_id=2756";
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject3 = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", localObject2 });
    }
    Object localObject2 = new StringBuilder((String)localObject3);
    localObject3 = ((WtloginManagerImpl)this.jdField_a_of_type_MqqAppAppRuntime.getManager(1)).getGUID();
    byte[] arrayOfByte = util.get_bssid_addr(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
    {
      ((StringBuilder)localObject2).append("&bssid=");
      ((StringBuilder)localObject2).append(MD5.toMD5(arrayOfByte));
    }
    ((StringBuilder)localObject2).append("&guid=");
    ((StringBuilder)localObject2).append(util.buf_to_string((byte[])localObject3));
    ((StringBuilder)localObject2).append("&appid=");
    ((StringBuilder)localObject2).append(AppSetting.a());
    localObject2 = ((StringBuilder)localObject2).toString();
    QLog.d("LoginActivity.LoginView", 1, new Object[] { "forgetpwd url is ", localObject2 });
    localObject3 = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "/base/browser");
    ((ActivityURIRequest)localObject3).extra().putString("uin", this.jdField_a_of_type_MqqAppAppRuntime.getAccount());
    ((ActivityURIRequest)localObject3).extra().putString("url", (String)localObject2);
    ((ActivityURIRequest)localObject3).extra().putInt("reqType", 3);
    QRoute.startUri((URIRequest)localObject3, null);
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
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2131370448, 1);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2131376354, 3);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2131372521, 2);
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(2131366847, 4);
  }
  
  private void n()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("release_account_uin");
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("release_bold_text");
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getStringExtra("release_success_text");
    if ((!TextUtils.isEmpty(str1)) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (SimpleAccount)((Iterator)localObject2).next();
        if (str1.equals(((SimpleAccount)localObject1).getUin())) {
          break label114;
        }
      }
      localObject1 = null;
      label114:
      if (localObject1 != null)
      {
        if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
          localObject2 = LoginUtils.a(str1);
        } else {
          localObject2 = str1;
        }
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
    Object localObject2 = str2;
    Object localObject1 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject1 = getString(2131698467);
      localObject2 = getString(2131698468);
    }
    localObject3 = new SpannableString((CharSequence)localObject1);
    if (((String)localObject1).contains((CharSequence)localObject2))
    {
      localObject3 = new SpannableString((CharSequence)localObject1);
      int i1 = ((String)localObject1).indexOf((String)localObject2);
      int i2 = ((String)localObject2).length();
      ((SpannableString)localObject3).setSpan(new StyleSpan(1), i1, i2 + i1, 33);
    }
    a(getString(2131698469), (CharSequence)localObject3, getString(2131698466), new LoginView.32(this));
  }
  
  public Dialog a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null)
    {
      QLog.e("LoginActivity.LoginView", 1, "onCreateDialog, context is null");
      return null;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 4)
        {
          if (paramInt != 6) {
            return null;
          }
          localObject = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
          ((QQProgressDialog)localObject).a(HardCodeUtil.a(2131699825));
          return localObject;
        }
        localObject = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
        ((QQProgressDialog)localObject).a(HardCodeUtil.a(2131699828));
        return localObject;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isResume()) {
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "onCreateDialog  DIALOG_CLEAR_ACCOUNT");
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getLayoutInflater().inflate(2131559054, null);
      return DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 230).setPositiveButton(2131699820, this).setNegativeButton(2131699819, new LoginView.6(this)).addView((View)localObject);
    }
    Object localObject = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
    ((QQProgressDialog)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699826));
    return localObject;
  }
  
  public AutoCompleteTextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
  }
  
  Object a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      return this.jdField_a_of_type_ComTencentMobileqqLogintempapiILoginApi.getFaceBitmap(this.jdField_a_of_type_MqqAppAppRuntime, paramString, (byte)4, false, paramBoolean);
    }
    return null;
  }
  
  public void a()
  {
    if (b()) {
      this.jdField_i_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a();
    }
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    if (paramInt == 1)
    {
      TextView localTextView = (TextView)paramDialog.findViewById(2131378476);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131699821);
      LoginView.AccountAdapter localAccountAdapter = (LoginView.AccountAdapter)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      paramInt = this.jdField_a_of_type_Int;
      if (paramInt != -1) {
        localTextView.setText(str.replace("${account}", localAccountAdapter.a(paramInt)));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox = ((PadQQCheckBox)paramDialog.findViewById(2131364595));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox.setText(getText(2131699822));
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
    if ((paramBoolean) && (this.jdField_d_of_type_Boolean) && ((!this.jdField_g_of_type_Boolean) || (!this.jdField_h_of_type_Boolean)) && (!this.jdField_i_of_type_Boolean) && (!this.s) && (!this.l) && (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow()) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = false;
      if (this.n)
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.runOnUiThread(new LoginView.5(this));
    }
    if ((paramBoolean) && (this.jdField_j_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow()))
    {
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
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSizeChange isOpen:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" preH:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" curH:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("  isInMultiWindow:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow());
      QLog.d("LoginActivity.LoginView", 2, ((StringBuilder)localObject).toString());
    }
    this.u = paramBoolean;
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_c_of_type_Int = paramInt2;
    if ((paramBoolean) && (getQBaseActivity() != null))
    {
      if (!this.q)
      {
        this.p = true;
        ThreadManager.getUIHandler().post(this.jdField_a_of_type_JavaLangRunnable);
      }
    }
    else
    {
      this.q = false;
      this.p = false;
      ThreadManager.getUIHandler().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 200L);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isInMultiWindow())
      {
        localObject = new int[2];
        int[] arrayOfInt = new int[2];
        this.jdField_b_of_type_AndroidViewView.getLocationOnScreen((int[])localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLocationOnScreen(arrayOfInt);
        if (localObject[1] < arrayOfInt[1] + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getHeight() + (int)(this.jdField_a_of_type_Float * 2.0F + 0.5F))
        {
          this.jdField_b_of_type_AndroidViewView.setVisibility(4);
          this.jdField_f_of_type_AndroidViewView.setVisibility(4);
          return;
        }
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        arrayOfInt = new int[2];
        this.jdField_f_of_type_AndroidViewView.getLocationOnScreen(arrayOfInt);
        if (arrayOfInt[1] < localObject[1] + this.jdField_b_of_type_AndroidViewView.getHeight() + (int)(this.jdField_a_of_type_Float * 2.0F + 0.5F))
        {
          this.jdField_f_of_type_AndroidViewView.setVisibility(4);
          return;
        }
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      }
    }
  }
  
  public void afterTextCleared()
  {
    
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      this.jdField_a_of_type_MqqAppAppRuntime.stopPCActivePolling("clearPassInput");
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
      int i1;
      if ((localObject1 != null) && (((AutoCompleteTextView)localObject1).getText() != null))
      {
        if (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString() == null) {
          return;
        }
        i1 = 0;
      }
      while (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        Object localObject2 = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((localObject2 != null) && (this.jdField_a_of_type_MqqAppAppRuntime != null) && (((String)localObject1).equals(LoginUtils.a(((SimpleAccount)localObject2).getUin()))))
        {
          this.jdField_a_of_type_MqqAppAppRuntime.updateSubAccountLogin(((SimpleAccount)localObject2).getUin(), false);
          this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy.a((String)localObject1);
          this.jdField_a_of_type_JavaLangString = null;
          MobileQQ.sMobileQQ.refreAccountList();
          localObject1 = MobileQQ.sMobileQQ.getAllAccounts();
          if (localObject1 != null)
          {
            localObject2 = this.jdField_a_of_type_JavaUtilList;
            if (localObject2 != null)
            {
              ((List)localObject2).clear();
              this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
            }
          }
        }
        else
        {
          i1 += 1;
          continue;
          return;
        }
      }
    }
    l();
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideDropdown isArrowUP = ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      ((StringBuilder)localObject).append(" isScrolled = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.d("LoginActivity.LoginView", 2, ((StringBuilder)localObject).toString());
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
    Object localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      a((String)localObject);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        a((String)localObject);
      }
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("arrowChangeCallback isArrowUP = ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Boolean);
      ((StringBuilder)localObject).append(" isScrolled = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.d("LoginActivity.LoginView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Int != -1)
    {
      paramDialogInterface = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
      paramDialogInterface.c(true);
      paramDialogInterface.setContentView(2131562765);
      paramDialogInterface.c(2131691504);
      paramDialogInterface.show();
      LoginView.AccountAdapter localAccountAdapter = (LoginView.AccountAdapter)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      String str1 = localAccountAdapter.b(this.jdField_a_of_type_Int);
      String str2 = localAccountAdapter.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
      String str3 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      if ((!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (!str2.equals(str3)))
      {
        if (!TextUtils.isEmpty(str3)) {
          a(str3);
        }
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
        this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText("");
      }
      e();
      localAccountAdapter.notifyDataSetChanged();
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str1))) {
        this.jdField_a_of_type_JavaLangString = null;
      }
      l();
      ThreadManager.post(new LoginView.15(this, str1, paramDialogInterface), 8, null, false);
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick id=");
      localStringBuilder.append(i1);
      QLog.d("LoginActivity.LoginView", 2, localStringBuilder.toString());
    }
    c(paramView);
    if (i1 == 2131370448)
    {
      ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800AA28", "0X800AA28", 0, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityLoginUserPrivateHelper == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityLoginUserPrivateHelper.a(getQBaseActivity())))
      {
        i();
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8007366", "0X8007366", 0, 0, "", "", "", "");
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "new_reg_805", "log_page", "log_clk", "", 1, "");
      }
    }
    else
    {
      Object localObject;
      if (i1 == 2131376354)
      {
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800AA2A", "0X800AA2A", 0, 0, "", "", "", "");
        if (Utils.c())
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131693846, 0).a();
        }
        else if (this.jdField_e_of_type_Boolean)
        {
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X80072E9", "0X80072E9", 0, 0, "", "", "", "");
          if ((this.jdField_g_of_type_Boolean) && (this.jdField_h_of_type_Boolean))
          {
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X800664F", "0X800664F", 0, 0, "", "", "", "");
            if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity))
            {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131692183, 0).a();
              break label1455;
            }
            try
            {
              ((AccountManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(0)).checkQuickRegisterAccount(this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), AppSetting.a(), "8.7.0", null);
              this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.showDialog(4);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
          else
          {
            ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Mobile_signup", "Clk_new_user", 0, 0, "", "", "", "");
            localObject = new ActivityURIRequest(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "/base/register/registerPhoneNumber");
            ((ActivityURIRequest)localObject).extra().putInt("key_register_from", 3);
            ((ActivityURIRequest)localObject).extra().putInt("key_report_extra_from", 3);
            QRoute.startUri((URIRequest)localObject, null);
          }
          this.jdField_e_of_type_Boolean = false;
          new Handler().postDelayed(new LoginView.12(this), 1000L);
        }
      }
      else if (i1 == 2131366847)
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
      else if (i1 == 2131364182)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$GuideCallBack != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$GuideCallBack.handleBackEvent();
        }
      }
      else if (i1 == 2131380018)
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
      else if (i1 == 2131372347)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString();
        this.jdField_a_of_type_Boolean ^= true;
        ImageView localImageView;
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
          localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
          if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_f_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (!this.s)) {
            i1 = 2130844690;
          } else {
            i1 = 2130847210;
          }
          localImageView.setImageResource(i1);
          this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706419));
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
          localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
          if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_f_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (!this.s)) {
            i1 = 2130844693;
          } else {
            i1 = 2130847211;
          }
          localImageView.setImageResource(i1);
          this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131706423));
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText;
          ((PastablePwdEditText)localObject).setSelection(((PastablePwdEditText)localObject).length());
        }
      }
      else if (i1 == 2131372041)
      {
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8007354", "0X8007354", 0, 0, "", "", "", "");
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X8007365", "0X8007365", 2, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "new_reg_805", "log_page", "log_msg_clk", "", 1, "");
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent().getBooleanExtra("login_from_account_change", false);
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, LoginPhoneNumActivity.class);
        ((Intent)localObject).putExtra("login_from_account_change", bool);
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity((Intent)localObject);
      }
      else if (i1 == 2131372521)
      {
        if (!NetworkUtil.isNetworkAvailable()) {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131694422, 0).a();
        } else {
          d(true);
        }
      }
      else if (i1 == 2131374695)
      {
        f();
      }
      else if (i1 == 2131372344)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.a();
      }
    }
    label1455:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559322, paramViewGroup, false);
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    }
    if (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
      QLog.e("LoginActivity.LoginView", 1, "mAppInterface is null");
    }
    else
    {
      this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
      boolean bool;
      if (paramBundle != null) {
        bool = true;
      } else {
        bool = false;
      }
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
      if ((getQBaseActivity() != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
      {
        paramViewGroup = new IntentFilter();
        paramViewGroup.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
        getQBaseActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramViewGroup);
      }
      this.jdField_h_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131376333);
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
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onDestroy");
    }
    super.onDestroy();
    if ((getQBaseActivity() != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
    {
      getQBaseActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null)
    {
      if (((ValueAnimator)localObject).isRunning()) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView;
    if (localObject != null) {
      ((LoginAnimBtnView)localObject).f();
    }
    a(4);
    this.o = true;
    this.jdField_a_of_type_ComTencentMobileqqLoginregisterLoginProxy.a();
    PhoneNumQuickLoginManager.a();
    if ((this.jdField_b_of_type_AndroidContentBroadcastReceiver != null) && (getActivity() != null))
    {
      getActivity().unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (this.jdField_g_of_type_AndroidViewView == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onMultiWindowModeChanged isInMultiWindowMode:");
        localStringBuilder.append(paramBoolean);
        QLog.d("LoginActivity.LoginView", 2, localStringBuilder.toString());
      }
      c(paramBoolean);
      this.p = false;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
    if (this.jdField_a_of_type_MqqAppAppRuntime != null) {
      this.jdField_a_of_type_MqqAppAppRuntime.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
    LoginAnimBtnView localLoginAnimBtnView = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView;
    if (localLoginAnimBtnView != null) {
      localLoginAnimBtnView.c();
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
    a(true);
    c();
    LoginAnimBtnView localLoginAnimBtnView = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView;
    if (localLoginAnimBtnView != null) {
      localLoginAnimBtnView.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onResume");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView
 * JD-Core Version:    0.7.0.1
 */