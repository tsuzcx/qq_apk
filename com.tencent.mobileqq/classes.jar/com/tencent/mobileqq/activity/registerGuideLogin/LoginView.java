package com.tencent.mobileqq.activity.registerGuideLogin;

import aeia;
import almu;
import alna;
import alnb;
import alnc;
import alnd;
import alne;
import alnf;
import alng;
import alnh;
import alni;
import alnj;
import alnk;
import alnl;
import alnm;
import alnn;
import alnq;
import alnr;
import alnt;
import alnu;
import alnv;
import alnw;
import alnx;
import alny;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
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
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
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
import anvx;
import aoae;
import aojx;
import aojy;
import aoxx;
import awtj;
import azit;
import bbby;
import bdla;
import bhbx;
import bhdj;
import bhec;
import bhhr;
import binc;
import bipu;
import biqg;
import bisl;
import bizp;
import bkxz;
import bkzi;
import bkzz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.AuthDevUgActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngIPCModule;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.mobileqq.widget.PadQQCheckBox;
import com.tencent.mobileqq.widget.PastablePwdEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class LoginView
  extends GuideBaseFragment
  implements DialogInterface.OnClickListener, View.OnClickListener, View.OnTouchListener, binc, bipu, biqg
{
  private float jdField_a_of_type_Float = 1.0F;
  public int a;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  public BroadcastReceiver a;
  public TextWatcher a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new alni(this);
  private View.OnFocusChangeListener jdField_a_of_type_AndroidViewView$OnFocusChangeListener = new alnm(this);
  View jdField_a_of_type_AndroidViewView;
  private InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  public AutoCompleteTextView a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private aojx jdField_a_of_type_Aojx;
  private bkzi jdField_a_of_type_Bkzi;
  public LoginAnimBtnView a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public InputMethodRelativeLayout a;
  public NewStyleDropdownView a;
  PadQQCheckBox jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox;
  public PastablePwdEditText a;
  public SimpleAccount a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new LoginView.16(this);
  public List<SimpleAccount> a;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new alnn(this);
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  public TextWatcher b;
  View jdField_b_of_type_AndroidViewView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  private RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private Runnable jdField_b_of_type_JavaLangRunnable = new LoginView.17(this);
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  public TextWatcher c;
  public View c;
  private Button jdField_c_of_type_AndroidWidgetButton;
  public ImageView c;
  private RelativeLayout.LayoutParams jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  View jdField_d_of_type_AndroidViewView;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int;
  View jdField_e_of_type_AndroidViewView;
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
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t = true;
  private boolean u;
  private boolean v;
  
  public LoginView()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new alnr(this);
    this.jdField_a_of_type_AndroidTextTextWatcher = new alnj(this);
    this.jdField_b_of_type_AndroidTextTextWatcher = new alnk(this);
    this.jdField_c_of_type_AndroidTextTextWatcher = new alnl(this);
  }
  
  @SuppressLint({"ValidFragment"})
  public LoginView(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new alnr(this);
    this.jdField_a_of_type_AndroidTextTextWatcher = new alnj(this);
    this.jdField_b_of_type_AndroidTextTextWatcher = new alnk(this);
    this.jdField_c_of_type_AndroidTextTextWatcher = new alnl(this);
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
      if (this.u) {
        if (this.t) {
          if (paramFloat < 0.99F)
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
            if (this.jdField_a_of_type_AndroidWidgetImageView.getAlpha() > 1.0F - paramFloat) {
              this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F - paramFloat);
            }
          }
        }
      }
      while (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow())
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
  
  private void a(View paramView)
  {
    this.jdField_i_of_type_AndroidViewView = paramView.findViewById(2131376496);
    paramView.findViewById(2131376495).setVisibility(8);
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363504);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView = ((NewStyleDropdownView)paramView.findViewById(2131370735));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.setHeadBorder(2130840657);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView = this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a = this;
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719174));
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getInputExtras(true);
    if (localObject1 != null) {
      ((Bundle)localObject1).putInt("INPUT_TYPE_ON_START", 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText = ((PastablePwdEditText)paramView.findViewById(2131372456));
    localObject1 = (ImageView)paramView.findViewById(2131372457);
    int i1 = (int)(43.0F * this.jdField_a_of_type_Float + 0.5F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setCustomClearButtonCallback(new alna(this, (ImageView)localObject1, i1));
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719196));
    localObject1 = new SpannableString(anvx.a(2131705828));
    ((SpannableString)localObject1).setSpan(new AbsoluteSizeSpan(17, true), 0, ((SpannableString)localObject1).length(), 33);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setHint((CharSequence)localObject1);
    if (Build.VERSION.SDK_INT >= 26) {}
    Object localObject2;
    try
    {
      View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText, new Object[] { Integer.valueOf(8) });
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView = ((LoginAnimBtnView)paramView.findViewById(2131370534));
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719188));
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.a();
      h();
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376471));
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719200));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131372156));
      this.jdField_c_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718920));
      this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout = ((InputMethodRelativeLayout)paramView.findViewById(2131370546));
      this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131369821);
      this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131377133);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnSizeChangedListenner(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetInputMethodRelativeLayout.setOnTouchListener(this);
      this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131377141);
      this.jdField_e_of_type_AndroidViewView.setOnTouchListener(new alnb(this));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370541));
      if (this.jdField_j_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131369859);
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131366811));
      this.jdField_b_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693721));
      paramView.findViewById(2131364161).setOnClickListener(this);
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
          break label1921;
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
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setAdapter(new alny(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
      if (((!this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean)) && (!this.jdField_i_of_type_Boolean) && (!this.s) && (!this.jdField_k_of_type_Boolean))
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
        String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("befault_uin");
        if ((!this.jdField_f_of_type_Boolean) || (localObject2 == null) || (((String)localObject2).length() <= 0)) {
          break label1896;
        }
        i1 = 0;
        int i2 = -1;
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1);
          int i4 = i2;
          if (localSimpleAccount != null)
          {
            if (localSimpleAccount.getUin() != null) {
              break label929;
            }
            i4 = i2;
          }
          for (;;)
          {
            i1 += 1;
            i2 = i4;
            break;
            label929:
            int i3 = i2;
            if (str != null)
            {
              i3 = i2;
              if (str.equals(localSimpleAccount.getUin())) {
                i3 = i1;
              }
            }
            i4 = i3;
            if (((String)localObject2).equals(localSimpleAccount.getUin()))
            {
              a(localSimpleAccount);
              this.jdField_a_of_type_Int = i1;
              i4 = i3;
            }
          }
        }
        if (i2 != -1) {
          this.jdField_a_of_type_JavaUtilList.remove(i2);
        }
      }
    }
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setOnFocusChangeListener(this.jdField_a_of_type_AndroidViewView$OnFocusChangeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setLongClickable(true);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372460));
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
      localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
      if ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_i_of_type_Boolean) || (this.s))
      {
        i1 = 2130846987;
        label1136:
        ((ImageView)localObject2).setImageResource(i1);
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131705825));
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
        if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.mSystemBarComp != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.mSystemBarComp.init();
        }
        this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131370536);
        this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131368919);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.clearFocus();
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setClearButtonVisible(false);
        this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTextClearedListener(this);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.addTextChangedListener(this.jdField_c_of_type_AndroidTextTextWatcher);
        b(paramView);
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("reason_for_upgrade", false)) {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.showDialog(2);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("key_req_by_contact_sync", false)) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("key_uin_to_login");
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(paramView);
          if (!TextUtils.isEmpty(paramView)) {
            b(paramView);
          }
        }
        if ((this.s) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))) {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_c_of_type_JavaLangString);
        }
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_i_of_type_AndroidViewView.setVisibility(8);
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
        this.jdField_b_of_type_AndroidViewView.findViewById(2131365775).setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
        d(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow());
        if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_f_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (!this.s)) {
          break label2129;
        }
        QLog.d("LoginActivity.LoginView", 1, new Object[] { "isChange : ", Boolean.valueOf(this.jdField_f_of_type_Boolean), " isAddAccount : ", Boolean.valueOf(this.jdField_g_of_type_Boolean), " isFromRegisterChoose: ", Boolean.valueOf(this.jdField_i_of_type_Boolean), " mIsNeedLoginWithMask : ", Boolean.valueOf(this.s) });
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        this.jdField_i_of_type_AndroidViewView.setVisibility(0);
        this.jdField_i_of_type_AndroidViewView.setOnClickListener(this);
        if (!this.jdField_i_of_type_Boolean) {
          break label2087;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
        if (!TextUtils.isEmpty(paramView))
        {
          i1 = paramView.length();
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(paramView.substring(0, 2) + "****" + paramView.substring(i1 - 2, i1));
          b(paramView);
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(false);
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(false);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(8);
        }
        if (!this.m) {
          break label2020;
        }
        this.jdField_b_of_type_AndroidViewView.findViewById(2131365775).setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramView = new RelativeLayout.LayoutParams(-2, -2);
        paramView.addRule(13);
        this.jdField_b_of_type_AndroidWidgetButton.setLayoutParams(paramView);
        this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLayoutParams());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidViewView.getLayoutParams());
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams());
      f();
      return;
      label1896:
      a((SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(0));
      this.jdField_a_of_type_Int = 0;
      break;
      label1921:
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(8);
      break;
      i1 = 2130844653;
      break label1136;
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
      localObject2 = this.jdField_c_of_type_AndroidWidgetImageView;
      if ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_i_of_type_Boolean) || (this.s)) {}
      for (i1 = 2130846988;; i1 = 2130844656)
      {
        ((ImageView)localObject2).setImageResource(i1);
        this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131705834));
        break;
      }
      label2020:
      paramView = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetButton.getLayoutParams();
      paramView.leftMargin = AIOUtils.dp2px(25.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetButton.setLayoutParams(paramView);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131365775).setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      continue;
      label2087:
      if (this.s)
      {
        e();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(true);
        this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(true);
        continue;
        label2129:
        if ((this.l) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow())) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
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
          f();
          this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.addTextChangedListener(this.jdField_b_of_type_AndroidTextTextWatcher);
          return;
        }
        AppRuntime localAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localAppRuntime);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getUinDisplayNameBeforeLogin(paramSimpleAccount.getUin()));
          if (!TextUtils.isEmpty(paramSimpleAccount.getUin())) {
            b(paramSimpleAccount.getUin());
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
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle(paramString1).setMessage(paramCharSequence);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setPositiveButton(paramString2, (DialogInterface.OnClickListener)localObject);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime() != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
        ((AppRuntime)localObject).stopPCActivePolling("deleteAccount");
        ((AccountManager)((AppRuntime)localObject).getManager(0)).deleteAccount(paramString, paramString, null);
        bhec.a(paramString);
        if ((paramBoolean) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox.a())))
        {
          if ((localObject instanceof QQAppInterface)) {
            aoxx.a((QQAppInterface)localObject, paramString, true);
          }
          new awtj().a(paramString);
          a(paramString);
        }
      }
      bizp.a().b(paramString);
      Object localObject = BaseApplicationImpl.getApplication();
      if (Build.VERSION.SDK_INT > 10) {}
      for (int i1 = 4;; i1 = 0)
      {
        localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("Last_Login", i1);
        if ((localObject != null) && (((SharedPreferences)localObject).contains("uin")) && (((SharedPreferences)localObject).getString("uin", "").equals(paramString)))
        {
          ((SharedPreferences)localObject).edit().remove("uin").commit();
          if (QLog.isColorLevel()) {
            QLog.d("login", 2, "delete Last_Login, isRelease:" + paramBoolean);
          }
        }
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
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
          b(str);
          paramIntent = paramIntent.getString("password");
          if ((paramIntent != null) && (paramIntent.length() > 0))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText(paramIntent);
            f();
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private void b(View paramView)
  {
    View localView = paramView.findViewById(2131376760);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = paramView.findViewById(2131376496);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    paramView = paramView.findViewById(2131369231);
    if (paramView != null) {
      IphoneTitleBarActivity.setLayerType(paramView);
    }
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
      localLayoutParams.bottomMargin = AIOUtils.dp2px(15.0F, getResources());
      this.jdField_f_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLayoutParams();
      localLayoutParams.topMargin = AIOUtils.dp2px(24.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setLayoutParams(localLayoutParams);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(1.0F);
    localLayoutParams.addRule(3, 2131370541);
    localLayoutParams.topMargin = ((int)(32.0F * this.jdField_a_of_type_Float));
    this.jdField_g_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.bottomMargin = AIOUtils.dp2px(35.0F, getResources());
    this.jdField_f_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.getLayoutParams();
    localLayoutParams.topMargin = AIOUtils.dp2px(57.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setLayoutParams(localLayoutParams);
  }
  
  private void e()
  {
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText(this.jdField_c_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusable(false);
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setFocusableInTouchMode(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(8);
    }
    this.jdField_b_of_type_AndroidViewView.findViewById(2131365775).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.jdField_b_of_type_AndroidWidgetButton.setLayoutParams(localLayoutParams);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("from_register_choose", false)) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("is_need_login_with_mask", false))) {}
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
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator != null) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(200L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new alnc(this));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new alnd(this));
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView == null) {
      return;
    }
    AppRuntime localAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).isNeedSecurityScan()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131718439));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693719));
  }
  
  private void i()
  {
    String str;
    if (this.jdField_i_of_type_Boolean)
    {
      str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
      if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("hasPwd", true))
      {
        a(null, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131716439), this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719059), this);
        return;
      }
    }
    while ((str == null) || (str.length() == 0) || (str.trim().length() == 0))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694366, 0).a();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
      str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    }
    if (str.startsWith("0"))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693368, 0).a();
      this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView, 2);
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString();
    if ((localObject == null) || (((String)localObject).length() < 1))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694507, 0).a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.requestFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText, 2);
      return;
    }
    int i2 = this.jdField_a_of_type_JavaUtilList.size();
    int i1 = 0;
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
          break label340;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693722, 0).a();
        return;
        i1 += 1;
        break;
      }
      label340:
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
      AuthDevUgActivity.a(1);
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
        AlbumUtil.clearLastAlbumInfo();
        return;
        BaseApplicationImpl.isFirstLogin = true;
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.showDialog(0);
          localObject = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
          localAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
          if (localAppRuntime == null) {
            break label621;
          }
          if (bbby.a().a(this.s, str, this.jdField_d_of_type_JavaLangString)) {
            localAppRuntime.login(bbby.a().a(this.jdField_d_of_type_JavaLangString), str, (byte[])localObject, null);
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
        label621:
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
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setTextColor(-16578534);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setHintTextColor(-5196865);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTextColor(-16578534);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setHintTextColor(-5196865);
  }
  
  private void l()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("release_account_uin");
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("release_bold_text");
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("release_success_text");
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
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getUinDisplayNameBeforeLogin(str1);
          String str3 = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
          alny localalny = (alny)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
          if ((!TextUtils.isEmpty(str3)) && (str3.equals(localObject2)))
          {
            this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.setText("");
            this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.a(false, null);
            this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setText("");
          }
          f();
          this.jdField_a_of_type_JavaUtilList.remove(localObject1);
          localalny.notifyDataSetChanged();
          k();
          ThreadManager.postImmediately(new LoginView.28(this, str1), null, false);
        }
      }
      else
      {
        if (!TextUtils.isEmpty(str2)) {
          break label371;
        }
        localObject1 = getString(2131698125);
      }
      for (localObject2 = getString(2131698126);; localObject2 = localObject3)
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
          a(getString(2131698127), (CharSequence)localObject1, getString(2131698124), new alnq(this));
          return;
          localObject2 = str1;
          break;
        }
        label371:
        localObject1 = str2;
      }
      localObject1 = null;
    }
  }
  
  public Dialog a(int paramInt)
  {
    String str1;
    switch (paramInt)
    {
    default: 
    case 0: 
    case 4: 
    case 1: 
      do
      {
        return null;
        localObject1 = new bisl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        ((bisl)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131693727));
        return localObject1;
        localObject1 = new bisl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        ((bisl)localObject1).a(anvx.a(2131705832));
        ((bisl)localObject1).setCancelable(false);
        return localObject1;
      } while (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume());
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "onCreateDialog  DIALOG_CLEAR_ACCOUNT");
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getLayoutInflater().inflate(2131559118, null);
      return bhdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setPositiveButton(2131690830, this).setNegativeButton(2131690829, new alnt(this)).addView((View)localObject1);
    case 2: 
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
      localObject2 = ((Intent)localObject1).getStringExtra("StrTitle");
      str1 = ((Intent)localObject1).getStringExtra("StrUpgradeDesc");
      ((Intent)localObject1).getStringExtra("StrUrl");
      localObject1 = bhdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle((String)localObject2).setMessage(str1);
      ((QQCustomDialog)localObject1).setPositiveButton(anvx.a(2131705822), new alnu(this));
      ((QQCustomDialog)localObject1).setPositiveButtonContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131719832));
      ((QQCustomDialog)localObject1).setNegativeButton(anvx.a(2131705833), new alnv(this));
      return localObject1;
    case 3: 
      Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
      Object localObject3 = ((Intent)localObject4).getStringExtra("StrTitle");
      String str2 = ((Intent)localObject4).getStringExtra("StrUpgradeDesc");
      localObject1 = ((Intent)localObject4).getStringExtra("StrButton");
      localObject2 = ((Intent)localObject4).getStringExtra("StrClientUrl");
      str1 = ((Intent)localObject4).getStringExtra("StrH5Url");
      localObject4 = ((Intent)localObject4).getStringExtra("StrCode");
      localObject3 = bhdj.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 230).setTitle((String)localObject3).setMessage(str2);
      ((QQCustomDialog)localObject3).setPositiveButton((String)localObject1, new alnw(this, (String)localObject2, str1, (String)localObject4));
      ((QQCustomDialog)localObject3).setNegativeButton(anvx.a(2131705827), new alnx(this));
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8006795", "0X8006795", 0, 0, "", "", "", "");
      return localObject3;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; localObject1 = "") {
      return aoae.a((Context)localObject2, (String)localObject1);
    }
  }
  
  public AutoCompleteTextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView;
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
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(paramString, (byte)4, false);
      QLog.d("Q.qqhead.freq", 1, "LoginView getHead bitmap: " + localBitmap);
      localObject = localBitmap;
      if (paramBoolean)
      {
        localObject = localBitmap;
        if (localBitmap != null)
        {
          localObject = localBitmap;
          if (VasApngIPCModule.getInstance().loadSoLib())
          {
            int i1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences(paramString, 0).getInt("my_store_face_id", 0);
            localObject = localBitmap;
            if (i1 > 0)
            {
              paramString = VasFaceManager.a(i1, "small");
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
      int i1 = 0;
      if (i1 < this.jdField_a_of_type_JavaUtilList.size())
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
        SimpleAccount localSimpleAccount = (SimpleAccount)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (localSimpleAccount == null) {}
        while ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!((String)localObject).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getUinDisplayNameBeforeLogin(localSimpleAccount.getUin()))))
        {
          i1 += 1;
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateSubAccountLogin(localSimpleAccount.getUin(), false);
        bizp.a().b((String)localObject);
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
    k();
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    if (paramInt == 1)
    {
      TextView localTextView = (TextView)paramDialog.findViewById(2131378673);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690831);
      alny localalny = (alny)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      if (this.jdField_a_of_type_Int != -1) {
        localTextView.setText(str.replace("${account}", localalny.a(this.jdField_a_of_type_Int)));
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox = ((PadQQCheckBox)paramDialog.findViewById(2131364594));
      this.jdField_a_of_type_ComTencentMobileqqWidgetPadQQCheckBox.setText(getText(2131690839));
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
  
  void a(String paramString)
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
      QLog.d("LoginActivity.LoginView", 2, "onSizeChange isOpen:" + paramBoolean + " preH:" + paramInt1 + " curH:" + paramInt2 + "  isInMultiWindow:" + this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow());
    }
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
    } while (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow());
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
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
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
    ThreadManager.postImmediately(new LoginView.21(this, paramString), null, true);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_d_of_type_Boolean) && ((!this.jdField_g_of_type_Boolean) || (!this.jdField_h_of_type_Boolean)) && (!this.jdField_i_of_type_Boolean) && (!this.s) && (!this.l) && (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = false;
      if (this.n) {
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      }
    }
    while ((!paramBoolean) || (!this.jdField_j_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow()))
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new LoginView.4(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().removeExtra("is_need_show_logo_animation");
    this.jdField_j_of_type_Boolean = false;
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new ScaleAnimation(1.429F, 1.0F, 1.429F, 1.0F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(500L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.setFillAfter(true);
    float f1 = ViewUtils.getDensity();
    localObject = new TranslateAnimation(ViewUtils.getScreenWidth() / 2.0F - 65.5F * f1, 0.0F, f1 * -8.0F, 0.0F);
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
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    String str = this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getText().toString();
    if (!TextUtils.isEmpty(str)) {
      b(str);
    }
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
    if (this.jdField_a_of_type_Bkzi == null)
    {
      this.jdField_a_of_type_Bkzi = ((bkzi)bkzz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null));
      this.jdField_a_of_type_Bkzi.b(2131692402);
      if (this.jdField_c_of_type_AndroidWidgetButton.getVisibility() != 0) {
        this.jdField_a_of_type_Bkzi.b(2131718920);
      }
      this.jdField_a_of_type_Bkzi.c(2131692401);
      this.jdField_a_of_type_Bkzi.setOnDismissListener(new alne(this));
      this.jdField_a_of_type_Bkzi.a(new alnf(this));
      this.jdField_a_of_type_Bkzi.a(new alnh(this));
    }
    if (!this.jdField_a_of_type_Bkzi.isShowing())
    {
      bkxz.b(this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView);
      this.v = false;
      this.jdField_a_of_type_Bkzi.show();
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    alny localalny;
    String str1;
    String str3;
    if (this.jdField_a_of_type_Int != -1)
    {
      paramDialogInterface = new bisl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
      paramDialogInterface.c(true);
      paramDialogInterface.setContentView(2131562799);
      paramDialogInterface.c(2131691473);
      paramDialogInterface.show();
      localalny = (alny)this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.getAdapter();
      str1 = localalny.b(this.jdField_a_of_type_Int);
      String str2 = localalny.a(this.jdField_a_of_type_Int);
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
      f();
      localalny.notifyDataSetChanged();
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str1))) {
        this.jdField_a_of_type_JavaLangString = null;
      }
      k();
      ThreadManager.post(new LoginView.13(this, str1, paramDialogInterface), 8, null, false);
      return;
      label221:
      if (!TextUtils.isEmpty(str3)) {
        b(str3);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onClick id=" + i1);
    }
    switch (i1)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA28", "0X800AA28", 0, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      if ((this.jdField_a_of_type_Aeia == null) || (this.jdField_a_of_type_Aeia.a(getActivity())))
      {
        i();
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007366", "0X8007366", 0, 0, "", "", "", "");
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "new_reg_805", "log_page", "log_clk", "", 1, "");
        continue;
        bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA2A", "0X800AA2A", 0, 0, "", "", "", "");
        if (bhbx.c())
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693722, 0).a();
        }
        else if (this.jdField_e_of_type_Boolean)
        {
          bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80072E9", "0X80072E9", 0, 0, "", "", "", "");
          if ((this.jdField_g_of_type_Boolean) && (this.jdField_h_of_type_Boolean))
          {
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800664F", "0X800664F", 0, 0, "", "", "", "");
            if (!NetworkUtil.isNetSupport(BaseApplicationImpl.sApplication))
            {
              QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131692125, 0).a();
              continue;
            }
          }
          Object localObject;
          for (;;)
          {
            try
            {
              ((AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0)).checkQuickRegisterAccount(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAppid(), "8.4.10", null);
              this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.showDialog(4);
              this.jdField_e_of_type_Boolean = false;
              new Handler().postDelayed(new LoginView.12(this), 1000L);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              continue;
            }
            bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Mobile_signup", "Clk_new_user", 0, 0, "", "", "", "");
            localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, RegisterPhoneNumActivity.class);
            ((Intent)localObject).putExtra("key_register_from", 3);
            ((Intent)localObject).putExtra("key_report_extra_from", 2);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
          }
          if (!this.p)
          {
            bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80072EA", "0X80072EA", 0, 0, "", "", "", "");
            bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "new_reg_805", "log_page", "forge_clk", "", 1, "");
            bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA29", "0X800AA29", 0, 0, "", "", "", "");
            if ((this.jdField_g_of_type_Boolean) && (this.jdField_h_of_type_Boolean)) {
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800664E", "0X800664E", 0, 0, "", "", "", "");
            }
            d();
            this.q = true;
            continue;
            if (this.jdField_a_of_type_Almu != null)
            {
              this.jdField_a_of_type_Almu.a();
              continue;
              bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80072E8", "0X80072E8", 0, 0, "", "", "", "");
              bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA2B", "0X800AA2B", 0, 0, "", "", "", "");
              localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
              ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              ((Intent)localObject).putExtra("ba_is_login", false);
              ((Intent)localObject).putExtra("url", "https://ti.qq.com/agreement/index.html");
              ((Intent)localObject).putExtra("hide_more_button", true);
              this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
              continue;
              localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.getText().toString();
              if (!this.jdField_a_of_type_Boolean)
              {
                bool = true;
                label946:
                this.jdField_a_of_type_Boolean = bool;
                if (!this.jdField_a_of_type_Boolean) {
                  break label1062;
                }
                this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
                if ((!this.jdField_g_of_type_Boolean) && (!this.jdField_f_of_type_Boolean) && (!this.jdField_i_of_type_Boolean) && (!this.s)) {
                  break label1055;
                }
              }
              label1055:
              for (i1 = 2130846987;; i1 = 2130844653)
              {
                localImageView.setImageResource(i1);
                this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131705826));
                if (TextUtils.isEmpty((CharSequence)localObject)) {
                  break;
                }
                this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setSelection(this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.length());
                break;
                bool = false;
                break label946;
              }
              label1062:
              this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
              ImageView localImageView = this.jdField_c_of_type_AndroidWidgetImageView;
              if ((this.jdField_g_of_type_Boolean) || (this.jdField_f_of_type_Boolean) || (this.jdField_i_of_type_Boolean) || (this.s)) {}
              for (i1 = 2130846988;; i1 = 2130844656)
              {
                localImageView.setImageResource(i1);
                this.jdField_c_of_type_AndroidWidgetImageView.setContentDescription(anvx.a(2131705831));
                break;
              }
              bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007354", "0X8007354", 0, 0, "", "", "", "");
              bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
              bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007365", "0X8007365", 2, 0, "", "", "", "");
              bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
              bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "new_reg_805", "log_page", "log_msg_clk", "", 1, "");
              boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("login_from_account_change", false);
              localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, LoginPhoneNumActivity.class);
              ((Intent)localObject).putExtra("login_from_account_change", bool);
              this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
            }
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Float = getResources().getDisplayMetrics().density;
    paramLayoutInflater = paramLayoutInflater.inflate(2131559381, paramViewGroup, false);
    boolean bool;
    if (paramBundle != null)
    {
      bool = true;
      this.n = bool;
      this.jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("is_change_account", false);
      this.jdField_g_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false);
      this.jdField_i_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("from_register_choose", false);
      this.jdField_h_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("login_from_account_change", false);
      this.jdField_j_of_type_Boolean = false;
      this.jdField_k_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("is_from_account_release", false);
      this.l = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("is_from_account_another_login_exit", false);
      this.m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("hasPwd", true);
      this.s = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("is_need_login_with_mask", false);
      if (this.s)
      {
        this.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uinMask");
        this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uinEncrpyt");
      }
      a(paramLayoutInflater);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("logout_intent", false)) && (this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount != null))
      {
        bhhr.a(BaseApplicationImpl.sApplication, this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), false);
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label552;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
    for (;;)
    {
      if ((getActivity() != null) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null))
      {
        paramViewGroup = new IntentFilter();
        paramViewGroup.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
        getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramViewGroup);
      }
      this.jdField_h_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131376449);
      this.jdField_h_of_type_AndroidViewView.post(new LoginView.1(this));
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("reason_for_checkAuth", false)) {
        getActivity().showDialog(3);
      }
      if (this.jdField_k_of_type_Boolean) {
        l();
      }
      if (this.jdField_a_of_type_Aeia != null)
      {
        paramViewGroup = new alng(this);
        this.jdField_a_of_type_Aeia.a(paramViewGroup);
      }
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "new_reg_805", "log_page", "page_exp", "", 1, "");
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009E3D", "0X8009E3D", 0, 0, "", "", "", "");
      bdla.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA27", "0X800AA27", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "onCreateView");
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      bool = false;
      break;
      label552:
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
      if ((paramViewGroup != null) && ((paramViewGroup instanceof QQAppInterface))) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramViewGroup);
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
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
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.dismissDialog(5);
      if (this.jdField_a_of_type_Aojx != null)
      {
        aojy.a().a();
        this.jdField_a_of_type_Aojx = null;
      }
      this.o = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ApngImage.pauseAll();
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
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
    ApngImage.playByTag(11);
    this.jdField_a_of_type_AndroidWidgetAutoCompleteTextView.clearFocus();
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.clearFocus();
    this.jdField_a_of_type_ComTencentMobileqqWidgetPastablePwdEditText.setClearButtonVisible(false);
    if (NotificationActivity.a != null)
    {
      NotificationActivity.a.finish();
      NotificationActivity.a = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.cancelSyncOnlineFriend(-1L);
    }
    azit.a().a(false);
    b(true);
    if (this.r)
    {
      QLog.d("LoginActivity.LoginView", 1, "mShouldAutoLogin: true, then login()");
      this.r = false;
      i();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginAnimBtnView.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView
 * JD-Core Version:    0.7.0.1
 */