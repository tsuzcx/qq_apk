package com.tencent.mobileqq.activity.registerGuideLogin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.widget.ConfigClearableEditText.OnTextClearedListener;
import com.tencent.mobileqq.widget.CustomSafeEditText;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout.onSizeChangedListenner;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.mobileqq.widget.NewStyleDropdownView.DropdownCallback;
import com.tencent.mobileqq.widget.PadQQCheckBox;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.OpenProxy;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import xsd;
import xse;
import xsg;
import xsh;
import xsi;
import xsk;
import xsl;
import xsm;
import xsn;
import xso;
import xsp;
import xst;
import xsv;
import xsw;
import xsx;
import xsy;
import xta;
import xtb;
import xtc;
import xtd;

public class LoginView
  extends GuideBaseFragment
  implements DialogInterface.OnClickListener, View.OnClickListener, View.OnTouchListener, ConfigClearableEditText.OnTextClearedListener, InputMethodRelativeLayout.onSizeChangedListenner, NewStyleDropdownView.DropdownCallback
{
  public int a;
  public TextWatcher a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new xsk(this);
  private View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new xso(this);
  View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  public AutoCompleteTextView a;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public CustomSafeEditText a;
  public InputMethodRelativeLayout a;
  public NewStyleDropdownView a;
  public PadQQCheckBox a;
  public SimpleAccount a;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  public List a;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new xsp(this);
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  public TextWatcher b;
  public View b;
  private Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  public TextWatcher c;
  public View c;
  private Button jdField_c_of_type_AndroidWidgetButton;
  public ImageView c;
  private boolean jdField_c_of_type_Boolean = true;
  View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean = true;
  public View e;
  private boolean e;
  View jdField_f_of_type_AndroidViewView;
  private boolean jdField_f_of_type_Boolean;
  View jdField_g_of_type_AndroidViewView;
  private boolean jdField_g_of_type_Boolean;
  private View jdField_h_of_type_AndroidViewView;
  private boolean jdField_h_of_type_Boolean;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  
  public LoginView()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidTextTextWatcher = new xsl(this);
    this.jdField_b_of_type_AndroidTextTextWatcher = new xsm(this);
    this.jdField_c_of_type_AndroidTextTextWatcher = new xsn(this);
  }
  
  @SuppressLint({"ValidFragment"})
  public LoginView(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = -1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidTextTextWatcher = new xsl(this);
    this.jdField_b_of_type_AndroidTextTextWatcher = new xsm(this);
    this.jdField_c_of_type_AndroidTextTextWatcher = new xsn(this);
  }
  
  private void a(View paramView)
  {
    this.jdField_h_of_type_AndroidViewView = paramView.findViewById(2131364951);
    paramView.findViewById(2131372226).setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131364952);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView = ((NewStyleDropdownView)paramView.findViewById(2131364855));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.setHeadBorder(2130839314);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a();
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setDropDownBackgroundDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a = this;
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427434));
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getInputExtras(true);
    if (localObject1 != null) {
      ((Bundle)localObject1).putInt("INPUT_TYPE_ON_START", 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText = ((CustomSafeEditText)paramView.findViewById(2131364856));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427435));
    if (Build.VERSION.SDK_INT >= 26) {}
    Object localObject2;
    try
    {
      View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText, new Object[] { Integer.valueOf(8) });
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131364367));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427437));
      paramView.findViewById(2131364960).setOnClickListener(this);
      localObject1 = paramView.findViewById(2131364959);
      ViewCompat.setImportantForAccessibility((View)localObject1, 2);
      ((View)localObject1).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433223) + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435580));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      a(this.jdField_a_of_type_AndroidWidgetButton);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131364860));
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427439));
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)paramView.findViewById(2131364950));
      this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131364958);
      this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131364853);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnTouchListener(this);
      this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131364953);
      this.jdField_e_of_type_AndroidViewView.setOnTouchListener(new xtb(this));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364954));
      if (this.j) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131364858);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131364859));
      this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433277));
      paramView.findViewById(2131372227).setOnClickListener(this);
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method"));
      this.jdField_b_of_type_AndroidWidgetImageView = this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a();
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        localObject1 = BaseApplicationImpl.sApplication.getAllAccounts();
        if (localObject1 != null) {
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject1);
        }
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label1721;
        }
        while (this.jdField_a_of_type_JavaUtilList.size() > 8) {
          this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.w("LoginActivity.LoginView", 2, "disable auto fill error", localException);
        continue;
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setAdapter(new xtd(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
      int m;
      if (((!this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) && (!this.i))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
        String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("befault_uin");
        if ((!this.jdField_f_of_type_Boolean) || (localObject2 == null) || (((String)localObject2).length() <= 0)) {
          break label1696;
        }
        m = 0;
        int n = -1;
        if (m < this.jdField_a_of_type_JavaUtilList.size())
        {
          SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
          int i2 = n;
          if (localSimpleAccount != null)
          {
            if (localSimpleAccount.getUin() != null) {
              break label819;
            }
            i2 = n;
          }
          for (;;)
          {
            m += 1;
            n = i2;
            break;
            label819:
            int i1 = n;
            if (str != null)
            {
              i1 = n;
              if (str.equals(localSimpleAccount.getUin())) {
                i1 = m;
              }
            }
            i2 = i1;
            if (((String)localObject2).equals(localSimpleAccount.getUin()))
            {
              a(localSimpleAccount);
              this.jdField_a_of_type_Int = m;
              i2 = i1;
            }
          }
        }
        if (n != -1) {
          this.jdField_a_of_type_JavaUtilList.remove(n);
        }
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setLongClickable(false);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364957));
      this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
        if ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.i))
        {
          m = 2130843934;
          label1019:
          ((ImageView)localObject2).setImageResource(m);
          this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription("隐藏密码");
          this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
          if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.mSystemBarComp != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.mSystemBarComp.init();
          }
          this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131364854);
          this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131364955);
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextClearedListener(this);
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_c_of_type_AndroidTextTextWatcher);
          b(paramView);
          if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("reason_for_upgrade", false)) {
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.showDialog(2);
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("key_req_by_contact_sync", false)) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false))) {
            this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("key_uin_to_login"));
          }
          if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_f_of_type_Boolean) && (!this.i)) {
            break label1849;
          }
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setVisibility(8);
          localObject2 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(22.0F * getResources().getDisplayMetrics().density));
          this.jdField_h_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_h_of_type_AndroidViewView.setVisibility(0);
          this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
          localObject2 = (TextView)paramView.findViewById(2131372228);
          if ((!this.jdField_g_of_type_Boolean) || (!this.jdField_h_of_type_Boolean)) {
            break label1810;
          }
          ((TextView)localObject2).setText("添加帐号");
          label1356:
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          this.jdField_f_of_type_AndroidViewView.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.setHeadBorder(2130839320);
          localObject2 = new RelativeLayout.LayoutParams(-1, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364951);
          ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(23.0F * getResources().getDisplayMetrics().density));
          this.jdField_g_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setTextColor(getResources().getColor(2131492879));
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setHintTextColor(getResources().getColor(2131493254));
          this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a().setImageResource(2130843929);
          paramView.findViewById(2131364512).setBackgroundResource(2131493226);
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextColor(getResources().getColor(2131492879));
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setHintTextColor(getResources().getColor(2131493254));
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.a(getResources().getDrawable(2130843929));
          paramView.findViewById(2131364519).setBackgroundResource(2131493226);
          if (!this.i) {
            break label1821;
          }
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
          if (!TextUtils.isEmpty(paramView))
          {
            m = paramView.length();
            this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(paramView.substring(0, 2) + "****" + paramView.substring(m - 2, m));
            b(paramView);
            this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(false);
            this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(false);
          }
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidWidgetButton.getBackground().setAlpha(255);
        return;
        label1696:
        a((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(0));
        this.jdField_a_of_type_Int = 0;
        break;
        label1721:
        this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(8);
        break;
        m = 2130842110;
        break label1019;
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
        if ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.i)) {}
        for (m = 2130843935;; m = 2130842113)
        {
          ((ImageView)localObject2).setImageResource(m);
          this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription("显示密码");
          break;
        }
        label1810:
        ((TextView)localObject2).setText("登录");
        break label1356;
        label1821:
        this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(true);
      }
      label1849:
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()) {
        break label2098;
      }
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(40.0F * getResources().getDisplayMetrics().density));
      this.jdField_g_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setTextColor(getResources().getColor(2131492894));
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setHintTextColor(getResources().getColor(2131492978));
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(true);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(true);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a().setImageResource(2130842109);
      paramView.findViewById(2131364512).setBackgroundResource(2131492977);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextColor(getResources().getColor(2131492894));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setHintTextColor(getResources().getColor(2131492978));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.a(getResources().getDrawable(2130842109));
      paramView.findViewById(2131364519).setBackgroundResource(2131492977);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      return;
      label2098:
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131364954);
    }
  }
  
  private void a(Button paramButton)
  {
    if (paramButton == null) {
      return;
    }
    AppRuntime localAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).s()))
    {
      paramButton.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131435163));
      return;
    }
    paramButton.setText(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433211));
  }
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.removeTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
        this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = null;
        if (paramSimpleAccount == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
          return;
        }
        AppRuntime localAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppRuntime);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(paramSimpleAccount.getUin()));
        }
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.selectAll();
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("!@#ewaGbhkc$!!=");
          b(paramSimpleAccount.getUin());
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
        }
      }
      finally {}
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    e();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(paramString1).setMessage(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString3, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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
          paramIntent = paramIntent.getString("password");
          if ((paramIntent != null) && (paramIntent.length() > 0)) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText(paramIntent);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(View paramView)
  {
    View localView = paramView.findViewById(2131363261);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = paramView.findViewById(2131364951);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    paramView = paramView.findViewById(2131363262);
    if (paramView != null) {
      IphoneTitleBarActivity.setLayerType(paramView);
    }
  }
  
  private void c(View paramView)
  {
    if (paramView != null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
    }
    if (this.i)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("hasPwd", true))
      {
        a(null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131434350), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131436340), this);
        return;
      }
    }
    while ((paramView == null) || (paramView.length() == 0) || (paramView.trim().length() == 0))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131433234, 0).a();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
      paramView = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    }
    if (paramView.startsWith("0"))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131433240, 0).a();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().toString();
    if ((localObject == null) || (((String)localObject).length() < 1))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131433237, 0).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText, 2);
      return;
    }
    int n = this.jdField_a_of_type_JavaUtilList.size();
    int m = 0;
    if (m < n)
    {
      localObject = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
      if ((localObject == null) || (!paramView.equals(((SimpleAccount)localObject).getUin()))) {}
    }
    for (m = 0;; m = 1)
    {
      if (m != 0) {}
      for (m = n + 1;; m = n)
      {
        if (m <= 8) {
          break label357;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131433280, 0).a();
        return;
        m += 1;
        break;
      }
      label357:
      if ((this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount == null) && (libsafeedit.checkPassLegal("!@#ewaGbhkc$!!=")))
      {
        localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        m = 0;
        if (m < this.jdField_a_of_type_JavaUtilList.size())
        {
          if ((this.jdField_a_of_type_JavaUtilList.get(m) == null) || (((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m)).getUin() == null)) {}
          while (!((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m)).getUin().equals(localObject))
          {
            m += 1;
            break;
          }
          this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("userguide", 2, "login");
      }
      if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null)
      {
        BaseApplicationImpl.isFirstLogin = false;
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.showDialog(0);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.login(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount);
        }
      }
      for (;;)
      {
        AlbumUtil.b();
        return;
        BaseApplicationImpl.isFirstLogin = true;
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.showDialog(0);
          localObject = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
          AppRuntime localAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
          if (localAppRuntime != null) {
            localAppRuntime.login(paramView, (byte[])localObject, null);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
          QLog.e("LoginActivity.LoginView", 1, "login() appRuntime is null");
        }
      }
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  private void f()
  {
    if ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.i))
    {
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setTextColor(getResources().getColor(2131492879));
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setHintTextColor(getResources().getColor(2131493254));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextColor(getResources().getColor(2131492879));
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setHintTextColor(getResources().getColor(2131493254));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setTextColor(getResources().getColor(2131492894));
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setHintTextColor(getResources().getColor(2131492978));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTextColor(getResources().getColor(2131492894));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setHintTextColor(getResources().getColor(2131492978));
  }
  
  public Dialog a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 4: 
    case 1: 
      do
      {
        return null;
        localObject1 = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        ((QQProgressDialog)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433224));
        return localObject1;
        localObject1 = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        ((QQProgressDialog)localObject1).a("请稍候...");
        ((QQProgressDialog)localObject1).setCancelable(false);
        return localObject1;
      } while (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "onCreateDialog  DIALOG_CLEAR_ACCOUNT");
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2130968920, null);
      return DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setPositiveButton(2131433245, this).setNegativeButton(2131433256, new xsv(this)).addView((View)localObject1);
    case 2: 
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
      str1 = ((Intent)localObject1).getStringExtra("StrTitle");
      str2 = ((Intent)localObject1).getStringExtra("StrUpgradeDesc");
      ((Intent)localObject1).getStringExtra("StrUrl");
      localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(str1).setMessage(str2);
      ((QQCustomDialog)localObject1).setPositiveButton("升级", new xsw(this));
      ((QQCustomDialog)localObject1).setPositiveButtonContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433819));
      ((QQCustomDialog)localObject1).setNegativeButton("取消", new xsx(this));
      return localObject1;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
    Object localObject2 = ((Intent)localObject3).getStringExtra("StrTitle");
    String str3 = ((Intent)localObject3).getStringExtra("StrUpgradeDesc");
    Object localObject1 = ((Intent)localObject3).getStringExtra("StrButton");
    String str1 = ((Intent)localObject3).getStringExtra("StrClientUrl");
    String str2 = ((Intent)localObject3).getStringExtra("StrH5Url");
    localObject3 = ((Intent)localObject3).getStringExtra("StrCode");
    localObject2 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle((String)localObject2).setMessage(str3);
    ((QQCustomDialog)localObject2).setPositiveButton((String)localObject1, new xsy(this, str1, str2, (String)localObject3));
    ((QQCustomDialog)localObject2).setNegativeButton("取消", new xta(this));
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8006795", "0X8006795", 0, 0, "", "", "", "");
    return localObject2;
  }
  
  public Object a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface))) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, (byte)3, false);
      QLog.d("Q.qqhead.freq", 1, "LoginView getHead bitmap: " + localBitmap);
      localObject = localBitmap;
      if (paramBoolean)
      {
        localObject = localBitmap;
        if (localBitmap != null)
        {
          localObject = localBitmap;
          if (VasApngUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            int m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences(paramString, 0).getInt("my_store_face_id", 0);
            localObject = localBitmap;
            if (m > 0)
            {
              paramString = VasFaceManager.a(m, 100);
              localObject = localBitmap;
              if (new File(paramString).exists()) {
                localObject = new BitmapDrawable(localBitmap);
              }
            }
          }
        }
      }
      try
      {
        URL localURL = new URL("vasapngdownloader", paramString, "-login-face-");
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mUseApngImage = true;
        localURLDrawableOptions.mUseMemoryCache = true;
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mExtraInfo = VasFaceManager.a();
        localObject = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
        return localObject;
      }
      catch (Exception localException)
      {
        QLog.e("LoginActivity.LoginView", 1, "getApngDrawable ApngImage err, path:" + paramString, localException);
        return localBitmap;
      }
    }
    return null;
  }
  
  public void a()
  {
    
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.stopPCActivePolling("clearPassInput");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      if ((this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView == null) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText() == null) || (this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString() == null)) {
        return;
      }
      int m = 0;
      if (m < this.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(m);
        if (localSimpleAccount == null) {}
        while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(localSimpleAccount.getUin()))))
        {
          m += 1;
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateSubAccountLogin(localSimpleAccount.getUin(), false);
        OpenProxy.a().b((String)localObject);
        this.jdField_a_of_type_JavaLangString = null;
        BaseApplicationImpl.sApplication.refreAccountList();
        localObject = BaseApplicationImpl.sApplication.getAllAccounts();
        if ((localObject != null) && (this.jdField_a_of_type_JavaUtilList != null))
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          this.jdField_a_of_type_JavaUtilList.addAll((Collection)localObject);
        }
      }
    }
    f();
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    if (paramInt == 1)
    {
      TextView localTextView = (TextView)paramDialog.findViewById(2131362966);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433243);
      xtd localxtd = (xtd)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      if (this.jdField_a_of_type_Int != -1) {
        localTextView.setText(str.replace("${account}", localxtd.a(this.jdField_a_of_type_Int)));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox = ((PadQQCheckBox)paramDialog.findViewById(2131364292));
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    a(paramIntent);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "----clear_sp----deleteDataFromSP: uin:" + paramString);
    }
    paramString = BaseApplicationImpl.sApplication.getSharedPreferences(paramString, 0).edit();
    paramString.clear();
    paramString.commit();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView == null) || (this.jdField_g_of_type_AndroidViewView == null)) {}
    while ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.i)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      localLayoutParams.addRule(10);
      localLayoutParams.topMargin = ((int)(getResources().getDisplayMetrics().density * 40.0F));
      this.jdField_g_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    localLayoutParams.addRule(3, 2131364954);
    localLayoutParams.topMargin = ((int)(getResources().getDisplayMetrics().density * 40.0F));
    this.jdField_g_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onSizeChange isOpen:" + paramBoolean + " preH:" + paramInt1 + " curH:" + paramInt2);
    }
    int m;
    if (paramBoolean)
    {
      this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      if (((!this.jdField_g_of_type_Boolean) || (!this.jdField_h_of_type_Boolean)) && (!this.i))
      {
        paramInt1 = (int)(35.0F * getResources().getDisplayMetrics().density);
        m = this.jdField_b_of_type_Int - paramInt1;
        if (QLog.isColorLevel()) {
          QLog.d("LoginActivity.LoginView", 2, "onSizeChange bottomLine" + this.jdField_b_of_type_Int + " mLoginHelpLayout.bottom:" + m + " curH:" + paramInt2);
        }
        if (m <= paramInt2) {
          break label216;
        }
        paramInt1 = this.jdField_b_of_type_Int;
        m = (int)(5.0F * getResources().getDisplayMetrics().density);
      }
    }
    for (;;)
    {
      label216:
      try
      {
        this.jdField_e_of_type_AndroidViewView.scrollTo(0, paramInt1 - paramInt2 + m);
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      catch (Exception localException) {}
      this.jdField_e_of_type_AndroidViewView.scrollTo(0, paramInt1);
      this.jdField_b_of_type_Boolean = true;
      return;
      if (((this.jdField_g_of_type_Boolean) && (this.jdField_h_of_type_Boolean)) || (this.i) || (this.jdField_f_of_type_Boolean))
      {
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "onSizeChange isArrowUP = " + this.jdField_c_of_type_Boolean + " isScrolled = " + this.jdField_b_of_type_Boolean);
      }
      if ((this.jdField_b_of_type_Boolean == true) && (this.jdField_c_of_type_Boolean))
      {
        this.jdField_e_of_type_AndroidViewView.scrollTo(0, 0);
        this.jdField_b_of_type_Boolean = false;
        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
        return;
      }
    }
  }
  
  public void b()
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a();
    }
  }
  
  public void b(String paramString)
  {
    ThreadManager.postImmediately(new xsi(this, paramString), null, true);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_d_of_type_Boolean) && ((!this.jdField_g_of_type_Boolean) || (!this.jdField_h_of_type_Boolean)) && (!this.i) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = false;
      if (this.k) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while ((!paramBoolean) || (!this.j) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()))
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new xst(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().removeExtra("is_need_show_logo_animation");
    this.j = false;
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
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      String str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      if (!TextUtils.isEmpty(str)) {
        b(str);
      }
    }
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "arrowChangeCallback isArrowUP = " + this.jdField_c_of_type_Boolean + " isScrolled = " + this.jdField_b_of_type_Boolean);
    }
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131433219);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.b(2131433220);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131433029);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new xsg(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(new xsh(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.l = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    xtd localxtd;
    String str1;
    String str3;
    if (this.jdField_a_of_type_Int != -1)
    {
      paramDialogInterface = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      paramDialogInterface.c(true);
      paramDialogInterface.setContentView(2130971534);
      paramDialogInterface.c(2131434058);
      paramDialogInterface.show();
      localxtd = (xtd)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      str1 = localxtd.b(this.jdField_a_of_type_Int);
      String str2 = localxtd.a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = -1;
      str3 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
      if ((!this.jdField_a_of_type_JavaUtilList.isEmpty()) && (!str2.equals(str3))) {
        break label217;
      }
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setText("");
    }
    for (;;)
    {
      localxtd.notifyDataSetChanged();
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str1))) {
        this.jdField_a_of_type_JavaLangString = null;
      }
      f();
      ThreadManager.post(new xse(this, str1, paramDialogInterface), 8, null, false);
      return;
      label217:
      if (!TextUtils.isEmpty(str3)) {
        b(str3);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    switch (paramView.getId())
    {
    default: 
    case 2131364367: 
    case 2131364860: 
    case 2131364859: 
    case 2131372227: 
      do
      {
        do
        {
          return;
          c(paramView);
          ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007366", "0X8007366", 0, 0, "", "", "", "");
          return;
        } while (!this.jdField_e_of_type_Boolean);
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80072E9", "0X80072E9", 0, 0, "", "", "", "");
        if ((this.jdField_g_of_type_Boolean) && (this.jdField_h_of_type_Boolean))
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800664F", "0X800664F", 0, 0, "", "", "", "");
          if (!NetworkUtil.d(BaseApplicationImpl.sApplication))
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131433023, 0).a();
            return;
          }
        }
        for (;;)
        {
          try
          {
            ((AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0)).checkQuickRegisterAccount(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid(), "7.6.8", null);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.showDialog(4);
            this.jdField_e_of_type_Boolean = false;
            new Handler().postDelayed(new xtc(this), 1000L);
            return;
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Mobile_signup", "Clk_new_user", 0, 0, "", "", "", "");
          paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, RegisterPhoneNumActivity.class);
          paramView.putExtra("key_report_extra_from", 2);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
        }
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80072EA", "0X80072EA", 0, 0, "", "", "", "");
        if ((this.jdField_g_of_type_Boolean) && (this.jdField_h_of_type_Boolean)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800664E", "0X800664E", 0, 0, "", "", "", "");
        }
        d();
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$GuideCallBack == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$GuideCallBack.a();
      return;
    case 2131364960: 
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80072E8", "0X80072E8", 0, 0, "", "", "", "");
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      paramView.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      paramView.putExtra("ba_is_login", false);
      paramView.putExtra("url", "http://ti.qq.com/agreement/index.html");
      paramView.putExtra("hide_more_button", true);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.getText().toString();
    if (!this.jdField_a_of_type_Boolean) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
      if ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.i)) {}
      for (m = 2130843934;; m = 2130842110)
      {
        localImageView.setImageResource(m);
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription("隐藏密码");
        label675:
        if (TextUtils.isEmpty(paramView)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setSelection(this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.length());
        return;
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
    if ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.i)) {}
    for (int m = 2130843935;; m = 2130842113)
    {
      localImageView.setImageResource(m);
      this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription("显示密码");
      break label675;
      break;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130969064, paramViewGroup, false);
    boolean bool;
    if (paramBundle != null)
    {
      bool = true;
      this.k = bool;
      this.jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("is_change_account", false);
      this.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
      this.i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("from_register_choose", false);
      this.jdField_h_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("login_from_account_change", false);
      this.j = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("is_need_show_logo_animation", false);
      a(paramLayoutInflater);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("logout_intent", false)) && (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null))
      {
        SharedPreUtils.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), false);
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label234;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewView.post(new xsd(this));
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("reason_for_checkAuth", false)) {
        getActivity().showDialog(3);
      }
      return paramLayoutInflater;
      bool = false;
      break;
      label234:
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
      if ((paramViewGroup != null) && ((paramViewGroup instanceof QQAppInterface))) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramViewGroup);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseAll();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
  }
  
  public void onResume()
  {
    super.onResume();
    ApngImage.playByTag(11);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetCustomSafeEditText.setClearButtonVisible(false);
    if (NotificationActivity.a != null)
    {
      NotificationActivity.a.finish();
      NotificationActivity.a = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(-1L);
    }
    PhoneNumLoginImpl.a().a(false);
    b(true);
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
        b(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView
 * JD-Core Version:    0.7.0.1
 */