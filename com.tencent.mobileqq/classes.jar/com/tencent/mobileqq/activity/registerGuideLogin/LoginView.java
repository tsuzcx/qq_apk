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
  boolean A;
  protected boolean B;
  LoginProxy C;
  EquipLockProxy D;
  Map<String, Object> E;
  boolean F = false;
  public BroadcastReceiver G = new LoginView.3(this);
  TextWatcher H = new LoginView.25(this);
  TextWatcher I = new LoginView.26(this);
  TextWatcher J = new LoginView.27(this);
  protected final WtloginObserver K = new LoginView.29(this);
  protected AccountObserver L = new LoginView.30(this);
  private boolean M = true;
  private Button N;
  private Button O;
  private Button P;
  private Button Q;
  private View R;
  private boolean S;
  private boolean T = true;
  private int U = 0;
  private boolean V = true;
  private InputMethodManager W;
  private View X = null;
  private boolean Y = true;
  private boolean Z;
  private int aA;
  private int aB;
  private int aC;
  private int aD;
  private int aE;
  private int aF;
  private int aG;
  private RelativeLayout.LayoutParams aH;
  private RelativeLayout.LayoutParams aI;
  private RelativeLayout.LayoutParams aJ;
  private ValueAnimator aK = null;
  private boolean aL = true;
  private boolean aM = false;
  private Runnable aN = new LoginView.18(this);
  private Runnable aO = new LoginView.19(this);
  private final View.OnClickListener aP = new LoginView.24(this);
  private View.OnFocusChangeListener aQ = new LoginView.28(this);
  private boolean aa;
  private boolean ab;
  private boolean ac;
  private boolean ad;
  private boolean ae;
  private boolean af;
  private QQCustomDialog ag;
  private String ah = null;
  private float ai = 1.0F;
  private boolean aj = false;
  private boolean ak = false;
  private boolean al = false;
  private boolean am = false;
  private boolean an;
  private String ao;
  private String ap;
  private GetLocalPhone.MaskPhoneData aq;
  private boolean ar;
  private long as;
  private ILoginApi at;
  private String au;
  private BroadcastReceiver av;
  private LoginFailedHelper aw = new LoginFailedHelper();
  private SparseIntArray ax;
  private int ay;
  private int az;
  View f;
  ImageView g;
  PastablePwdEditText h;
  ImageView i;
  ImageView j;
  LoginAnimBtnView k;
  View l;
  View m;
  View n;
  View o;
  AutoCompleteTextView p;
  NewStyleDropdownView q;
  InputMethodRelativeLayout r;
  View s;
  View t;
  View u;
  List<SimpleAccount> v;
  SimpleAccount w;
  int x = -1;
  PadQQCheckBox y;
  boolean z;
  
  public LoginView() {}
  
  @SuppressLint({"ValidFragment"})
  public LoginView(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat)
  {
    if (this.aH.topMargin != paramInt4)
    {
      this.aH.topMargin = paramInt4;
      this.k.requestLayout();
    }
    if (this.aI.topMargin != paramInt3)
    {
      this.aI.topMargin = paramInt3;
      this.t.requestLayout();
    }
    if (this.aJ.topMargin != paramInt2)
    {
      this.aJ.topMargin = paramInt2;
      this.g.requestLayout();
    }
    try
    {
      this.o.scrollTo(0, paramInt1);
      label89:
      if (this.aM)
      {
        if (this.aL)
        {
          if (paramFloat < 0.99F)
          {
            this.g.setVisibility(0);
            float f1 = this.g.getAlpha();
            paramFloat = 1.0F - paramFloat;
            if (f1 > paramFloat) {
              this.g.setAlpha(paramFloat);
            }
          }
          else
          {
            this.g.setVisibility(4);
            this.g.setAlpha(0.0F);
          }
        }
        else if (paramFloat < 0.99F)
        {
          this.g.setVisibility(0);
          if (this.g.getAlpha() < paramFloat) {
            this.g.setAlpha(paramFloat);
          }
        }
        else
        {
          this.g.setVisibility(0);
          this.g.setAlpha(1.0F);
        }
      }
      else if (!this.b.isInMultiWindow())
      {
        this.g.setVisibility(0);
        this.g.setAlpha(1.0F);
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
    String str1 = this.b.getIntent().getStringExtra("appid");
    if (str1 == null) {
      str1 = "";
    }
    String str2 = this.b.getIntent().getStringExtra("oauth_app_name");
    if (str2 == null) {
      str2 = "";
    }
    ReportController.b(this.a, "dc00898", "", "", paramString, paramString, paramInt, 0, str1, "", str2, "");
  }
  
  private void a(View paramView)
  {
    this.X = paramView.findViewById(2131444595);
    paramView.findViewById(2131444594).setVisibility(8);
    this.f = paramView.findViewById(2131429417);
    this.q = ((NewStyleDropdownView)paramView.findViewById(2131437926));
    this.R = paramView.findViewById(2131442877);
    if ((w()) && (getActivity() != null))
    {
      this.R.setVisibility(0);
      this.R.setOnClickListener(this);
      a(0, "0X800BA14");
      this.av = new LoginView.7(this);
      getActivity().registerReceiver(this.av, new IntentFilter("mqq.intent.action.QRCODE_LOGIN_FINISH"));
    }
    this.q.setHeadBorder(2130848153);
    this.q.setHeadDrawableDownListener(new LoginView.8(this));
    this.p = this.q.getView();
    this.q.f = this;
    this.p.setContentDescription(this.b.getString(2131897876));
    this.p.setTextAlignment(4);
    Object localObject1 = this.p.getInputExtras(true);
    if (localObject1 != null) {
      ((Bundle)localObject1).putInt("INPUT_TYPE_ON_START", 1);
    }
    this.h = ((PastablePwdEditText)paramView.findViewById(2131439858));
    this.h.setTextAlignment(4);
    localObject1 = (ImageView)paramView.findViewById(2131439859);
    ((ImageView)localObject1).setOnClickListener(this);
    int i1 = (int)(this.ai * 43.0F + 0.5F);
    this.h.setCustomClearButtonCallback(new LoginView.9(this, (ImageView)localObject1, i1));
    this.h.setOnTextContextSelectListener(new LoginView.10(this));
    this.h.setContentDescription(this.b.getString(2131897881));
    localObject1 = new SpannableString(HardCodeUtil.a(2131897872));
    ((SpannableString)localObject1).setSpan(new AbsoluteSizeSpan(17, true), 0, ((SpannableString)localObject1).length(), 33);
    this.h.setHint((CharSequence)localObject1);
    if (Build.VERSION.SDK_INT >= 26) {
      try
      {
        View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.h, new Object[] { Integer.valueOf(8) });
      }
      catch (Exception localException1)
      {
        QLog.w("LoginActivity.LoginView", 2, "disable auto fill error", localException1);
      }
    }
    this.k = ((LoginAnimBtnView)paramView.findViewById(2131437716));
    this.k.setContentDescription(this.b.getString(2131897880));
    this.k.setOnClickListener(this);
    this.k.a();
    r();
    this.N = ((Button)paramView.findViewById(2131444570));
    this.N.setContentDescription(this.b.getString(2131917042));
    this.N.setOnClickListener(this);
    this.Q = ((Button)paramView.findViewById(2131440045));
    this.Q.setOnClickListener(this);
    this.P = ((Button)paramView.findViewById(2131439504));
    this.P.setContentDescription(this.b.getString(2131916707));
    this.P.setOnClickListener(this);
    this.r = ((InputMethodRelativeLayout)paramView.findViewById(2131437734));
    this.s = paramView.findViewById(2131436896);
    this.t = paramView.findViewById(2131445359);
    this.r.setOnSizeChangedListenner(this);
    this.r.setOnTouchListener(this);
    this.o = paramView.findViewById(2131445369);
    this.o.setOnTouchListener(new LoginView.11(this));
    this.g = ((ImageView)paramView.findViewById(2131437727));
    if (this.ac) {
      this.g.setVisibility(4);
    }
    this.l = paramView.findViewById(2131436933);
    this.O = ((Button)paramView.findViewById(2131433173));
    this.O.setContentDescription(this.b.getString(2131897868));
    paramView.findViewById(2131430169).setOnClickListener(this);
    this.W = ((InputMethodManager)this.b.getSystemService("input_method"));
    this.i = this.q.getDelIcon();
    this.i.setOnClickListener(this.aP);
    List localList = this.v;
    if (localList == null) {
      this.v = new ArrayList();
    } else {
      try
      {
        localList.clear();
      }
      catch (Exception localException2)
      {
        QLog.d("LoginActivity.LoginView", 1, "initViews crash: ", localException2);
        this.v = new ArrayList();
      }
    }
    Object localObject2 = MobileQQ.sMobileQQ.getAllAccounts();
    if (localObject2 != null) {
      this.v.addAll((Collection)localObject2);
    }
    localObject2 = this.v;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      d(false);
      PhoneNumQuickLoginManager.b("0X800B8C9");
    }
    localObject2 = this.v;
    Object localObject3;
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      while (this.v.size() > 8)
      {
        localObject2 = this.v;
        ((List)localObject2).remove(((List)localObject2).size() - 1);
      }
      this.p.setAdapter(new LoginView.AccountAdapter(this, this.b));
      if (((!this.aa) || (this.Z)) && (!this.z) && (!this.an) && (!this.ad))
      {
        localObject2 = this.b.getIntent().getStringExtra("uin");
        localObject3 = this.b.getIntent().getStringExtra("befault_uin");
        boolean bool = this.b.getIntent().getBooleanExtra("is_show_not_login_uin", false);
        if ((this.Z) && (localObject2 != null) && (((String)localObject2).length() > 0))
        {
          i1 = 0;
          int i4 = 0;
          int i5;
          for (int i2 = -1; i1 < this.v.size(); i2 = i5)
          {
            SimpleAccount localSimpleAccount = (SimpleAccount)this.v.get(i1);
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
                  this.x = i1;
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
            this.p.setText((CharSequence)localObject2);
          }
          if (i2 != -1) {
            this.v.remove(i2);
          }
        }
        else
        {
          a((SimpleAccount)this.v.get(0));
          this.x = 0;
        }
      }
      a(this.v);
    }
    else
    {
      this.q.getDropDownIcon().setVisibility(8);
    }
    this.p.addTextChangedListener(this.H);
    this.h.addTextChangedListener(this.I);
    this.p.setOnFocusChangeListener(this.aQ);
    this.h.setOnFocusChangeListener(this.aQ);
    this.h.setLongClickable(true);
    this.j = ((ImageView)paramView.findViewById(2131439862));
    this.j.setOnClickListener(this);
    if (this.M)
    {
      this.h.setTransformationMethod(PasswordTransformationMethod.getInstance());
      localObject2 = this.j;
      if ((!this.aa) && (!this.Z) && (!this.z) && (!this.an)) {
        i1 = 2130846063;
      } else {
        i1 = 2130848790;
      }
      ((ImageView)localObject2).setImageResource(i1);
      this.j.setContentDescription(HardCodeUtil.a(2131904277));
    }
    else
    {
      this.h.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
      localObject2 = this.j;
      if ((!this.aa) && (!this.Z) && (!this.z) && (!this.an)) {
        i1 = 2130846066;
      } else {
        i1 = 2130848791;
      }
      ((ImageView)localObject2).setImageResource(i1);
      this.j.setContentDescription(HardCodeUtil.a(2131904284));
    }
    this.j.setVisibility(8);
    this.O.setOnClickListener(this);
    if ((this.b.mSystemBarComp != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      this.b.mSystemBarComp.init();
    }
    this.m = paramView.findViewById(2131437718);
    this.n = paramView.findViewById(2131435822);
    this.p.clearFocus();
    this.h.clearFocus();
    this.h.setClearButtonVisible(false);
    this.h.setTextClearedListener(this);
    this.p.addTextChangedListener(this.J);
    b(paramView);
    if ((this.b.getIntent().getBooleanExtra("key_req_by_contact_sync", false)) && (this.b.getIntent().getBooleanExtra("IS_ADD_ACCOUNT", false)))
    {
      paramView = this.b.getIntent().getStringExtra("key_uin_to_login");
      this.p.setText(paramView);
      if (!TextUtils.isEmpty(paramView)) {
        c(paramView);
      }
    }
    if ((this.an) && (!TextUtils.isEmpty(this.ao))) {
      this.p.setText(this.ao);
    }
    this.f.setVisibility(0);
    this.X.setVisibility(8);
    this.s.setVisibility(0);
    this.l.setVisibility(0);
    this.q.a(false, null);
    this.p.setTextColor(-16578534);
    this.p.setHintTextColor(-5196865);
    this.p.setFocusable(true);
    this.p.setFocusableInTouchMode(true);
    this.h.setTextColor(-16578534);
    this.h.setHintTextColor(-5196865);
    this.N.setVisibility(0);
    this.l.findViewById(2131432031).setVisibility(0);
    this.N.setVisibility(0);
    this.O.setVisibility(0);
    c(this.b.isInMultiWindow());
    if ((!this.aa) && (!this.Z) && (!this.z) && (!this.an))
    {
      if ((this.ae) || (this.b.isInMultiWindow())) {
        this.m.setVisibility(0);
      }
    }
    else
    {
      QLog.d("LoginActivity.LoginView", 1, new Object[] { "isChange : ", Boolean.valueOf(this.Z), " isAddAccount : ", Boolean.valueOf(this.aa), " isFromRegisterChoose: ", Boolean.valueOf(this.z), " mIsNeedLoginWithMask : ", Boolean.valueOf(this.an) });
      this.m.setVisibility(0);
      this.f.setVisibility(8);
      this.X.setVisibility(0);
      this.X.setOnClickListener(this);
      if (this.z)
      {
        paramView = this.b.getIntent().getStringExtra("uin");
        if (!TextUtils.isEmpty(paramView))
        {
          i1 = paramView.length();
          localObject2 = this.p;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramView.substring(0, 2));
          ((StringBuilder)localObject3).append("****");
          ((StringBuilder)localObject3).append(paramView.substring(i1 - 2, i1));
          ((AutoCompleteTextView)localObject2).setText(((StringBuilder)localObject3).toString());
          c(paramView);
          this.p.setFocusable(false);
          this.p.setFocusableInTouchMode(false);
          this.q.getDropDownIcon().setVisibility(8);
        }
        if (this.af)
        {
          this.l.findViewById(2131432031).setVisibility(8);
          this.l.findViewById(2131446189).setVisibility(8);
          this.l.findViewById(2131446190).setVisibility(8);
          this.N.setVisibility(8);
          this.P.setVisibility(8);
        }
        else
        {
          this.l.findViewById(2131432031).setVisibility(0);
          this.N.setVisibility(8);
          this.P.setVisibility(0);
        }
      }
      else if (this.an)
      {
        o();
      }
      else
      {
        this.q.a(false, null);
        this.p.setFocusable(true);
        this.p.setFocusableInTouchMode(true);
      }
    }
    this.aH = ((RelativeLayout.LayoutParams)this.k.getLayoutParams());
    this.aI = ((RelativeLayout.LayoutParams)this.t.getLayoutParams());
    this.aJ = ((RelativeLayout.LayoutParams)this.g.getLayoutParams());
    b();
  }
  
  private void a(ImageView paramImageView, Object paramObject)
  {
    if ((paramObject instanceof Bitmap))
    {
      paramImageView.setImageBitmap((Bitmap)paramObject);
      return;
    }
    paramImageView.setImageResource(2130841444);
  }
  
  private void a(SimpleAccount paramSimpleAccount)
  {
    try
    {
      this.h.removeTextChangedListener(this.I);
      this.w = null;
      if (paramSimpleAccount == null)
      {
        this.h.setText("");
      }
      else
      {
        this.a = this.b.getAppRuntime();
        if (this.a != null)
        {
          this.p.setText(LoginUtils.a(paramSimpleAccount.getUin()));
          if (!TextUtils.isEmpty(paramSimpleAccount.getUin())) {
            c(paramSimpleAccount.getUin());
          }
        }
        this.p.selectAll();
        if ((paramSimpleAccount != null) && (paramSimpleAccount.isLogined()))
        {
          this.w = paramSimpleAccount;
          this.h.setText("!@#ewaGbhkc$!!=");
        }
        else
        {
          this.h.setText("");
        }
      }
      b();
      this.h.addTextChangedListener(this.I);
      return;
    }
    finally {}
  }
  
  private void a(List<SimpleAccount> paramList)
  {
    try
    {
      if (this.E == null) {
        this.E = new HashMap();
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
  
  private void b(View paramView)
  {
    View localView = paramView.findViewById(2131444897);
    if (localView != null) {
      QIphoneTitleBarActivity.setLayerType(localView);
    }
    localView = paramView.findViewById(2131444595);
    if (localView != null) {
      QIphoneTitleBarActivity.setLayerType(localView);
    }
    paramView = paramView.findViewById(2131436180);
    if (paramView != null) {
      QIphoneTitleBarActivity.setLayerType(paramView);
    }
  }
  
  private void b(String paramString, boolean paramBoolean)
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
        localObject = this.C;
        localQBaseActivity = this.b;
        if (paramBoolean) {
          break label160;
        }
        if ((this.y == null) || (!this.y.a())) {
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
  
  private boolean b(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        String str = paramIntent.getString("uin");
        if ((str != null) && (str.length() > 0))
        {
          this.p.setText(str);
          c(str);
          paramIntent = paramIntent.getString("password");
          if ((paramIntent != null) && (paramIntent.length() > 0))
          {
            this.h.setText(paramIntent);
            b();
          }
          return true;
        }
      }
    }
    return false;
  }
  
  private void c(View paramView)
  {
    int i1 = this.ax.get(paramView.getId(), 0);
    this.C.a(this.b, i1);
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
      this.g.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(this.ai * 25.0F));
      this.t.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.s.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = Utils.a(15.0F, getResources());
      this.s.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = Utils.a(24.0F, getResources());
      this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    this.g.setVisibility(0);
    this.g.setAlpha(1.0F);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, 2131437727);
    ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(this.ai * 32.0F));
    this.t.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.s.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = Utils.a(35.0F, getResources());
    this.s.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = Utils.a(57.0F, getResources());
    this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void d(String paramString)
  {
    ThreadManager.getUIHandler().post(new LoginView.20(this, paramString));
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.showDialog(4);
    }
    if (this.ar)
    {
      QLog.d("LoginActivity.LoginView", 1, "is getting phone");
      PhoneNumQuickLoginManager.b(3);
      return;
    }
    if (this.aq != null)
    {
      b(4);
      a(this.aq, paramBoolean);
      PhoneNumQuickLoginManager.b(2);
      return;
    }
    this.ar = true;
    PhoneNumQuickLoginManager.b(1);
    PhoneNumQuickLoginManager.a(this.a, new LoginView.WeakMaskCallback(this, paramBoolean));
  }
  
  private void e(String paramString)
  {
    MsfSdkUtils.addLoginSimpleAccount(paramString, true);
    MobileQQ localMobileQQ = this.b.getAppRuntime().getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Constants.PropertiesKey.uinDisplayName.toString());
    localStringBuilder.append(paramString);
    localMobileQQ.setProperty(localStringBuilder.toString(), paramString);
    this.b.getAppRuntime().getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
    paramString = f(paramString);
    this.a.login(paramString);
  }
  
  private SimpleAccount f(String paramString)
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
  
  private void n()
  {
    if (this.am)
    {
      this.am = false;
      if (this.F)
      {
        QLog.d("LoginActivity.LoginView", 1, "mShouldAutoLogin: true, then loginByPhoneToken()");
        this.F = false;
        Map localMap = u();
        localMap.put("key_phone_num", this.aq.str_mask_phone.get());
        localMap.put("key_from_user_click", Boolean.valueOf(false));
        String str = PhoneNumQuickLoginManager.a(this.a);
        PhoneNumQuickLoginManager.a(this.b, this.a, str, localMap, this.K);
        QuickLoginReporter.b(0, "SUCCESS");
        return;
      }
      QLog.d("LoginActivity.LoginView", 1, "mShouldAutoLogin: true, then login()");
      g();
    }
  }
  
  private void o()
  {
    if (!TextUtils.isEmpty(this.ao))
    {
      this.p.setText(this.ao);
      this.p.setFocusable(false);
      this.p.setFocusableInTouchMode(false);
      this.q.getDropDownIcon().setVisibility(8);
    }
    this.l.findViewById(2131432031).setVisibility(8);
    this.l.findViewById(2131446189).setVisibility(8);
    this.l.findViewById(2131446190).setVisibility(8);
    this.N.setVisibility(8);
    this.P.setVisibility(8);
  }
  
  private void p()
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.b, "/base/browser");
    localActivityURIRequest.extra().putString("url", this.au);
    localActivityURIRequest.extra().putBoolean("hide_more_button", true);
    localActivityURIRequest.extra().putBoolean("key_from_opensdk_qrcode", true);
    QRoute.startUri(localActivityURIRequest, null);
    this.R.setClickable(false);
    ThreadManager.getUIHandler().postDelayed(new LoginView.14(this), 1000L);
    a(0, "0X800BA15");
  }
  
  private void q()
  {
    if (this.aK != null) {
      return;
    }
    this.aK = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.aK.setDuration(200L);
    this.aK.addUpdateListener(new LoginView.16(this));
    this.aK.addListener(new LoginView.17(this));
  }
  
  private void r()
  {
    if (this.k == null) {
      return;
    }
    if (LoginUtils.a(this.b))
    {
      this.k.setContentDescription(this.b.getString(2131916179));
      return;
    }
    this.k.setContentDescription(this.b.getString(2131891418));
  }
  
  private void s()
  {
    QQCustomDialog localQQCustomDialog = this.ag;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing()))
    {
      this.ag.dismiss();
      this.ag = null;
    }
  }
  
  private void t()
  {
    this.p.setTextColor(-16578534);
    this.p.setHintTextColor(-5196865);
    this.h.setTextColor(-16578534);
    this.h.setHintTextColor(-5196865);
  }
  
  private Map<String, Object> u()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("login_from_account_change", Boolean.valueOf(this.ab));
    return localHashMap;
  }
  
  private void v()
  {
    this.ax = new SparseIntArray(4);
    this.ax.put(2131437716, 1);
    this.ax.put(2131444570, 3);
    this.ax.put(2131440045, 2);
    this.ax.put(2131433173, 4);
  }
  
  private boolean w()
  {
    return TextUtils.isEmpty(this.au) ^ true;
  }
  
  public Dialog a(int paramInt)
  {
    if (this.b == null)
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
          localObject = new QQProgressDialog(this.b, this.b.getTitleBarHeight());
          ((QQProgressDialog)localObject).a(HardCodeUtil.a(2131897870));
          return localObject;
        }
        localObject = new QQProgressDialog(this.b, this.b.getTitleBarHeight());
        ((QQProgressDialog)localObject).a(HardCodeUtil.a(2131897873));
        return localObject;
      }
      if (!this.b.isResume()) {
        return null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("LoginActivity.LoginView", 2, "onCreateDialog  DIALOG_CLEAR_ACCOUNT");
      }
      localObject = this.b.getLayoutInflater().inflate(2131624706, null);
      return DialogUtil.a(this.b, 230).setPositiveButton(2131897865, this).setNegativeButton(2131897864, new LoginView.6(this)).addView((View)localObject);
    }
    Object localObject = new QQProgressDialog(this.b, this.b.getTitleBarHeight());
    ((QQProgressDialog)localObject).a(this.b.getString(2131897871));
    return localObject;
  }
  
  Object a(String paramString, boolean paramBoolean)
  {
    if (this.a == null) {
      this.a = this.b.getAppRuntime();
    }
    if (this.a != null) {
      return this.at.getFaceBitmap(this.a, paramString, (byte)4, false, paramBoolean);
    }
    return null;
  }
  
  protected String a(byte[] paramArrayOfByte)
  {
    return util.buf_to_string(paramArrayOfByte);
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    if (paramInt == 1)
    {
      TextView localTextView = (TextView)paramDialog.findViewById(2131447090);
      String str = this.b.getString(2131897866);
      LoginView.AccountAdapter localAccountAdapter = (LoginView.AccountAdapter)this.p.getAdapter();
      paramInt = this.x;
      if (paramInt != -1) {
        localTextView.setText(str.replace("${account}", localAccountAdapter.a(paramInt)));
      }
      this.y = ((PadQQCheckBox)paramDialog.findViewById(2131430664));
      this.y.setText(getText(2131897867));
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    b(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity.LoginView", 2, "onNewIntent");
    }
  }
  
  protected void a(Intent paramIntent, Bundle paramBundle)
  {
    if (paramIntent == null)
    {
      QLog.e("LoginActivity.LoginView", 1, "initDatas, intent is null");
      return;
    }
    this.ai = getResources().getDisplayMetrics().density;
    boolean bool;
    if (paramBundle != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.A = bool;
    this.Z = paramIntent.getBooleanExtra("is_change_account", false);
    this.aa = paramIntent.getBooleanExtra("IS_ADD_ACCOUNT", false);
    this.z = paramIntent.getBooleanExtra("from_register_choose", false);
    this.ab = paramIntent.getBooleanExtra("login_from_account_change", false);
    this.ac = false;
    this.ad = paramIntent.getBooleanExtra("is_from_account_release", false);
    this.ae = paramIntent.getBooleanExtra("is_from_account_another_login_exit", false);
    this.au = paramIntent.getStringExtra("param_qr_code_url");
    this.af = paramIntent.getBooleanExtra("hasPwd", true);
    this.an = paramIntent.getBooleanExtra("is_need_login_with_mask", false);
    if (this.an)
    {
      this.ao = paramIntent.getStringExtra("uinMask");
      this.ap = paramIntent.getStringExtra("uinEncrpyt");
    }
    this.at = ((ILoginApi)QRoute.api(ILoginApi.class));
    this.C = new LoginProxy();
    this.D = new EquipLockProxy();
  }
  
  void a(ImageView paramImageView, String paramString, boolean paramBoolean)
  {
    if (this.b == null)
    {
      QLog.e("LoginActivity.LoginView", 1, "getAvatarIcon, context is null");
      return;
    }
    ThreadManager.postImmediately(new LoginView.23(this, paramString, paramBoolean, paramImageView), null, true);
  }
  
  protected void a(String paramString)
  {
    QQToast.makeText(this.b, paramString, 0).show();
    this.p.requestFocus();
    this.W.showSoftInput(this.p, 2);
  }
  
  protected void a(String paramString1, CharSequence paramCharSequence, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    s();
    this.ag = DialogUtil.a(this.b, 230).setTitle(paramString1).setMessage(paramCharSequence);
    this.ag.setPositiveButton(paramString2, (DialogInterface.OnClickListener)localObject);
    this.ag.setCancelable(false);
    this.ag.show();
  }
  
  protected void a(GetLocalPhone.MaskPhoneData paramMaskPhoneData, boolean paramBoolean)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.as;
      int i1 = 1;
      if (l1 - l2 < 500L)
      {
        QLog.d("LoginActivity.LoginView", 1, "showMaskPhoneDialog, but repeating showing");
        return;
      }
      this.W.hideSoftInputFromWindow(this.b.getWindow().getDecorView().getWindowToken(), 0);
      if (paramBoolean) {
        i1 = 2;
      }
      PhoneNumQuickLoginManager.c(i1);
      this.as = l1;
      Map localMap = u();
      localMap.put("key_phone_num", paramMaskPhoneData.str_mask_phone.get());
      localMap.put("key_self_btn_text", getString(2131897201));
      localMap.put("key_other_btn_text", getString(2131897202));
      localMap.put("key_user_agreement", paramMaskPhoneData.str_terms_wording.get());
      localMap.put("key_from_user_click", Boolean.valueOf(paramBoolean));
      PhoneNumQuickLoginManager.a(getQBaseActivity(), new LoginView.21(this), localMap);
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.V) && ((!this.aa) || (!this.ab)) && (!this.z) && (!this.an) && (!this.ae) && (!this.b.isInMultiWindow()) && (this.V))
    {
      this.V = false;
      if (this.A)
      {
        this.m.setVisibility(0);
        return;
      }
      this.b.runOnUiThread(new LoginView.5(this));
    }
    if ((paramBoolean) && (this.ac) && (!this.b.isInMultiWindow()))
    {
      this.b.getIntent().removeExtra("is_need_show_logo_animation");
      this.ac = false;
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
      this.g.startAnimation(localAnimationSet);
      this.g.setVisibility(0);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSizeChange isOpen:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" preH:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" curH:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append("  isInMultiWindow:");
    ((StringBuilder)localObject).append(this.b.isInMultiWindow());
    QLog.d("LoginActivity.LoginView", 1, ((StringBuilder)localObject).toString());
    this.B = paramBoolean;
    ThreadManager.getUIHandler().removeCallbacks(this.aO);
    ThreadManager.getUIHandler().removeCallbacks(this.aN);
    this.ay = paramInt2;
    if ((paramBoolean) && (getQBaseActivity() != null))
    {
      if (!this.al)
      {
        this.ak = true;
        ThreadManager.getUIHandler().post(this.aN);
      }
    }
    else
    {
      this.al = false;
      this.ak = false;
      ThreadManager.getUIHandler().postDelayed(this.aO, 200L);
      if (this.b.isInMultiWindow())
      {
        localObject = new int[2];
        int[] arrayOfInt = new int[2];
        this.l.getLocationOnScreen((int[])localObject);
        this.k.getLocationOnScreen(arrayOfInt);
        if (localObject[1] < arrayOfInt[1] + this.k.getHeight() + (int)(this.ai * 2.0F + 0.5F))
        {
          this.l.setVisibility(4);
          this.s.setVisibility(4);
          return;
        }
        this.l.setVisibility(0);
        arrayOfInt = new int[2];
        this.s.getLocationOnScreen(arrayOfInt);
        if (arrayOfInt[1] < localObject[1] + this.l.getHeight() + (int)(this.ai * 2.0F + 0.5F))
        {
          this.s.setVisibility(4);
          return;
        }
        this.s.setVisibility(0);
      }
    }
  }
  
  protected void b()
  {
    int i1;
    if ((!this.b.getIntent().getBooleanExtra("from_register_choose", false)) && (!this.b.getIntent().getBooleanExtra("is_need_login_with_mask", false))) {
      i1 = 1;
    } else {
      i1 = 6;
    }
    Object localObject = h();
    String str = c();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)) && (str.length() >= i1)) {
      this.k.setEnabled(true);
    } else {
      this.k.setEnabled(false);
    }
    if ((!TextUtils.isEmpty(str)) && (str.length() >= 12)) {
      this.h.setTextSize(1, 17.0F);
    } else {
      this.h.setTextSize(1, 22.0F);
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.p;
      f1 = this.ai;
      ((AutoCompleteTextView)localObject).setPadding((int)(f1 * 63.0F + 0.5F), 0, (int)(f1 * 63.0F + 0.5F), 0);
      return;
    }
    localObject = this.p;
    float f1 = this.ai;
    ((AutoCompleteTextView)localObject).setPadding((int)(f1 * 36.0F + 0.5F), 0, (int)(f1 * 36.0F + 0.5F), 0);
  }
  
  protected void b(int paramInt)
  {
    if (!this.b.isFinishing()) {
      try
      {
        this.b.dismissDialog(paramInt);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("LoginActivity.LoginView", 1, "hideLoadingDialog error : ", localException);
      }
    }
  }
  
  protected void b(String paramString)
  {
    QQToast.makeText(this.b, paramString, 0).show();
    this.h.requestFocus();
    this.W.showSoftInput(this.h, 2);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = h();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        c((String)localObject);
      }
    }
    this.T = paramBoolean;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("arrowChangeCallback isArrowUP = ");
      ((StringBuilder)localObject).append(this.T);
      ((StringBuilder)localObject).append(" isScrolled = ");
      ((StringBuilder)localObject).append(this.S);
      QLog.d("LoginActivity.LoginView", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected String c()
  {
    return this.h.getText().toString();
  }
  
  void c(String paramString)
  {
    ThreadManager.postImmediately(new LoginView.22(this, paramString), null, true);
  }
  
  public void d()
  {
    if (w()) {
      this.R.setVisibility(8);
    }
    this.l.setVisibility(8);
    this.n.setVisibility(8);
    this.s.setVisibility(8);
    this.q.a(false, null);
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing())) {
      this.q.a();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideDropdown isArrowUP = ");
      ((StringBuilder)localObject).append(this.T);
      ((StringBuilder)localObject).append(" isScrolled = ");
      ((StringBuilder)localObject).append(this.S);
      QLog.d("LoginActivity.LoginView", 2, ((StringBuilder)localObject).toString());
    }
    if (this.S)
    {
      this.o.scrollTo(0, 0);
      this.S = false;
    }
    this.T = true;
    this.n.setVisibility(0);
    this.l.setVisibility(0);
    if (w()) {
      this.R.setVisibility(0);
    }
    this.s.setVisibility(0);
    Object localObject = h();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      c((String)localObject);
    }
  }
  
  public void f()
  {
    
    if (this.a != null) {
      this.a.stopPCActivePolling("clearPassInput");
    }
    Object localObject1 = this.v;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = this.p;
      int i1;
      if ((localObject1 != null) && (((AutoCompleteTextView)localObject1).getText() != null))
      {
        if (h() == null) {
          return;
        }
        i1 = 0;
      }
      while (i1 < this.v.size())
      {
        localObject1 = h();
        Object localObject2 = (SimpleAccount)this.v.get(i1);
        if ((localObject2 != null) && (this.a != null) && (((String)localObject1).equals(LoginUtils.a(((SimpleAccount)localObject2).getUin()))))
        {
          this.a.updateSubAccountLogin(((SimpleAccount)localObject2).getUin(), false);
          this.C.a((String)localObject1);
          this.d = null;
          MobileQQ.sMobileQQ.refreAccountList();
          localObject1 = MobileQQ.sMobileQQ.getAllAccounts();
          if (localObject1 != null)
          {
            localObject2 = this.v;
            if (localObject2 != null)
            {
              ((List)localObject2).clear();
              this.v.addAll((Collection)localObject1);
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
    t();
  }
  
  protected void g()
  {
    String str;
    if (this.z)
    {
      str = this.b.getIntent().getStringExtra("uin");
      if (!this.b.getIntent().getBooleanExtra("hasPwd", true)) {
        a(null, this.b.getString(2131914048), this.b.getString(2131897869), this);
      }
    }
    else
    {
      str = h();
    }
    if ((str != null) && (str.length() != 0) && (str.trim().length() != 0))
    {
      if (str.startsWith("0"))
      {
        a(HardCodeUtil.a(2131891024));
        return;
      }
      if (c().length() < 1)
      {
        b(HardCodeUtil.a(2131892395));
        return;
      }
      int i3 = this.v.size();
      int i1 = 0;
      while (i1 < i3)
      {
        localObject = (SimpleAccount)this.v.get(i1);
        if ((localObject != null) && (str.equals(((SimpleAccount)localObject).getUin())))
        {
          i1 = 0;
          break label207;
        }
        i1 += 1;
      }
      i1 = 1;
      label207:
      int i2 = i3;
      if (i1 != 0) {
        i2 = i3 + 1;
      }
      if (i2 > 8)
      {
        QQToast.makeText(this.b, 2131891426, 0).show();
        return;
      }
      if ((this.w == null) && (libsafeedit.checkPassLegal("!@#ewaGbhkc$!!=")))
      {
        localObject = h();
        i1 = 0;
        while (i1 < this.v.size())
        {
          if ((this.v.get(i1) != null) && (((SimpleAccount)this.v.get(i1)).getUin() != null) && (((SimpleAccount)this.v.get(i1)).getUin().equals(localObject)))
          {
            this.w = ((SimpleAccount)this.v.get(i1));
            break;
          }
          i1 += 1;
        }
      }
      QLog.d("LoginActivity.LoginView", 1, "login");
      LoginStaticField.a(1);
      Object localObject = this.w;
      if (localObject != null)
      {
        QLog.d("LoginActivity.LoginView", 1, new Object[] { "login without input pwd, ", MsfSdkUtils.getShortUin(((SimpleAccount)localObject).getUin()) });
        com.tencent.mobileqq.util.LoginSetting.a = false;
        this.b.showDialog(0);
        if (this.a != null) {
          this.a.login(this.w);
        }
      }
      else
      {
        QLog.d("LoginActivity.LoginView", 1, "login by pwd");
        com.tencent.mobileqq.util.LoginSetting.a = true;
        try
        {
          this.b.showDialog(0);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        byte[] arrayOfByte = libsafeedit.byteSafeEditTextToMD5(Boolean.valueOf(true));
        AppRuntime localAppRuntime = this.b.getAppRuntime();
        if (localAppRuntime != null)
        {
          if (RegisterLimitHelperImpl.a().a(this.an, str, this.ap)) {
            localAppRuntime.login(RegisterLimitHelperImpl.a().a(this.ap), str, arrayOfByte, null);
          } else {
            localAppRuntime.login(str, arrayOfByte, null);
          }
        }
        else {
          QLog.e("LoginActivity.LoginView", 1, "login() appRuntime is null");
        }
      }
      this.C.a(this.b);
      return;
    }
    a(HardCodeUtil.a(2131892234));
  }
  
  protected String h()
  {
    return this.p.getText().toString();
  }
  
  protected void i()
  {
    ReportController.a(this.a, "dc00898", "", "", "0X8007353", "0X8007353", 0, 0, "", "", "", "");
    ReportController.a(this.a, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
    ReportController.a(this.a, "dc00898", "", "", "0X8007365", "0X8007365", 3, 0, "", "", "", "");
    ReportController.a(this.a, "new_reg_805", "log_page", "re_clk", "", 1, "");
    ReportController.a(this.a, "dc00898", "", "", "0X800AA2C", "0X800AA2C", 0, 0, "", "", "", "");
    Object localObject4 = this.p;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (localObject4 != null)
    {
      localObject1 = h();
      try
      {
        Long.parseLong((String)localObject1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = localObject3;
        if (QLog.isDevelopLevel())
        {
          QLog.i("LoginActivity.LoginView", 4, String.format(Locale.getDefault(), "forget pwd %s", new Object[] { h() }));
          localObject2 = localObject3;
        }
      }
    }
    localObject3 = "https://ti.qq.com/safe/forgetpw?source_id=2756";
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject3 = String.format(Locale.getDefault(), "%s&account=%s", new Object[] { "https://ti.qq.com/safe/forgetpw?source_id=2756", localObject2 });
    }
    Object localObject2 = new StringBuilder((String)localObject3);
    localObject3 = ((WtloginManagerImpl)this.a.getManager(1)).getGUID();
    localObject4 = j();
    if ((localObject4 != null) && (localObject4.length > 0))
    {
      ((StringBuilder)localObject2).append("&bssid=");
      ((StringBuilder)localObject2).append(MD5.toMD5((byte[])localObject4));
    }
    ((StringBuilder)localObject2).append("&guid=");
    ((StringBuilder)localObject2).append(a((byte[])localObject3));
    ((StringBuilder)localObject2).append("&appid=");
    ((StringBuilder)localObject2).append(AppSetting.d());
    localObject2 = ((StringBuilder)localObject2).toString();
    QLog.d("LoginActivity.LoginView", 1, new Object[] { "forgetpwd url is ", localObject2 });
    localObject3 = new Intent();
    ((Intent)localObject3).putExtra("uin", this.a.getAccount());
    ((Intent)localObject3).putExtra("url", (String)localObject2);
    ((Intent)localObject3).putExtra("reqType", 3);
    LoginUtils.a(this.b, (Intent)localObject3, "/base/browser");
  }
  
  protected byte[] j()
  {
    return util.get_bssid_addr(this.b);
  }
  
  protected void k()
  {
    String str1 = this.b.getIntent().getStringExtra("release_account_uin");
    String str2 = this.b.getIntent().getStringExtra("release_bold_text");
    Object localObject3 = this.b.getIntent().getStringExtra("release_success_text");
    if ((!TextUtils.isEmpty(str1)) && (!this.v.isEmpty()))
    {
      localObject2 = this.v.iterator();
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
        if (this.a != null) {
          localObject2 = LoginUtils.a(str1);
        } else {
          localObject2 = str1;
        }
        String str3 = h();
        LoginView.AccountAdapter localAccountAdapter = (LoginView.AccountAdapter)this.p.getAdapter();
        if ((!TextUtils.isEmpty(str3)) && (str3.equals(localObject2)))
        {
          this.p.setText("");
          this.q.a(false, null);
          this.h.setText("");
        }
        b();
        this.v.remove(localObject1);
        localAccountAdapter.notifyDataSetChanged();
        t();
        ThreadManager.postImmediately(new LoginView.31(this, str1), null, false);
      }
    }
    Object localObject2 = str2;
    Object localObject1 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject1 = getString(2131896406);
      localObject2 = getString(2131896407);
    }
    localObject3 = new SpannableString((CharSequence)localObject1);
    if (((String)localObject1).contains((CharSequence)localObject2))
    {
      localObject3 = new SpannableString((CharSequence)localObject1);
      int i1 = ((String)localObject1).indexOf((String)localObject2);
      int i2 = ((String)localObject2).length();
      ((SpannableString)localObject3).setSpan(new StyleSpan(1), i1, i2 + i1, 33);
    }
    a(getString(2131896408), (CharSequence)localObject3, getString(2131896405), new LoginView.32(this));
  }
  
  public AutoCompleteTextView l()
  {
    return this.p;
  }
  
  protected boolean m()
  {
    return (getQBaseActivity() != null) && (!getQBaseActivity().isFinishing());
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.x != -1)
    {
      paramDialogInterface = new QQProgressDialog(this.b, this.b.getTitleBarHeight());
      paramDialogInterface.c(true);
      paramDialogInterface.setContentView(2131629210);
      paramDialogInterface.c(2131888463);
      paramDialogInterface.show();
      LoginView.AccountAdapter localAccountAdapter = (LoginView.AccountAdapter)this.p.getAdapter();
      String str1 = localAccountAdapter.b(this.x);
      String str2 = localAccountAdapter.a(this.x);
      this.v.remove(this.x);
      this.x = -1;
      String str3 = h();
      if ((!this.v.isEmpty()) && (!str2.equals(str3)))
      {
        if (!TextUtils.isEmpty(str3)) {
          c(str3);
        }
      }
      else
      {
        this.p.setText("");
        this.q.a(false, null);
        this.h.setText("");
      }
      b();
      localAccountAdapter.notifyDataSetChanged();
      if ((!TextUtils.isEmpty(this.d)) && (this.d.equalsIgnoreCase(str1))) {
        this.d = null;
      }
      t();
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
    if (i1 == 2131437716)
    {
      ReportController.a(this.a, "dc00898", "", "", "0X800AA28", "0X800AA28", 0, 0, "", "", "", "");
      this.W.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      if ((this.e == null) || (this.e.a(getQBaseActivity())))
      {
        g();
        ReportController.a(this.a, "dc00898", "", "", "0X8007366", "0X8007366", 0, 0, "", "", "", "");
        ReportController.a(this.a, "new_reg_805", "log_page", "log_clk", "", 1, "");
      }
    }
    else
    {
      Object localObject;
      if (i1 == 2131444570)
      {
        ReportController.a(this.a, "dc00898", "", "", "0X800AA2A", "0X800AA2A", 0, 0, "", "", "", "");
        if (Utils.e())
        {
          QQToast.makeText(this.b, 2131891426, 0).show();
        }
        else if (this.Y)
        {
          ReportController.a(this.a, "dc00898", "", "", "0X80072E9", "0X80072E9", 0, 0, "", "", "", "");
          if ((this.aa) && (this.ab))
          {
            ReportController.b(this.a, "CliOper", "", "", "0X800664F", "0X800664F", 0, 0, "", "", "", "");
            if (!NetworkUtil.isNetSupport(this.b))
            {
              QQToast.makeText(this.b, 2131889169, 0).show();
              break label1451;
            }
            try
            {
              ((AccountManager)this.a.getManager(0)).checkQuickRegisterAccount(this.a.getAccount(), AppSetting.d(), "8.8.17", null);
              this.b.showDialog(4);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
          else
          {
            ReportController.b(this.a, "CliOper", "", "", "Mobile_signup", "Clk_new_user", 0, 0, "", "", "", "");
            localObject = new ActivityURIRequest(this.b, "/base/register/registerPhoneNumber");
            ((ActivityURIRequest)localObject).extra().putInt("key_register_from", 1);
            ((ActivityURIRequest)localObject).extra().putInt("key_report_extra_from", 1);
            QRoute.startUri((URIRequest)localObject, null);
          }
          this.Y = false;
          new Handler().postDelayed(new LoginView.12(this), 1000L);
        }
      }
      else if (i1 == 2131433173)
      {
        QLog.d("LoginActivity.LoginView", 1, "onClick findPass");
        this.O.setClickable(false);
        ThreadManager.getUIHandler().postDelayed(new LoginView.13(this), 500L);
        if (!this.ak)
        {
          ReportController.a(this.a, "dc00898", "", "", "0X80072EA", "0X80072EA", 0, 0, "", "", "", "");
          ReportController.a(this.a, "new_reg_805", "log_page", "forge_clk", "", 1, "");
          ReportController.a(this.a, "dc00898", "", "", "0X800AA29", "0X800AA29", 0, 0, "", "", "", "");
          if ((this.aa) && (this.ab)) {
            ReportController.b(this.a, "CliOper", "", "", "0X800664E", "0X800664E", 0, 0, "", "", "", "");
          }
          i();
          this.al = true;
        }
      }
      else if (i1 == 2131430169)
      {
        if (this.c != null) {
          this.c.handleBackEvent();
        }
      }
      else if (i1 == 2131448923)
      {
        ReportController.a(this.a, "dc00898", "", "", "0X80072E8", "0X80072E8", 0, 0, "", "", "", "");
        ReportController.a(this.a, "dc00898", "", "", "0X800AA2B", "0X800AA2B", 0, 0, "", "", "", "");
        localObject = new ActivityURIRequest(this.b, "/base/browser");
        ((ActivityURIRequest)localObject).extra().putString("uin", this.a.getAccount());
        ((ActivityURIRequest)localObject).extra().putBoolean("ba_is_login", false);
        ((ActivityURIRequest)localObject).extra().putString("url", "https://ti.qq.com/agreement/index.html");
        ((ActivityURIRequest)localObject).extra().putBoolean("hide_more_button", true);
        QRoute.startUri((URIRequest)localObject, null);
      }
      else if (i1 == 2131439862)
      {
        localObject = c();
        this.M ^= true;
        ImageView localImageView;
        if (this.M)
        {
          this.h.setTransformationMethod(PasswordTransformationMethod.getInstance());
          localImageView = this.j;
          if ((!this.aa) && (!this.Z) && (!this.z) && (!this.an)) {
            i1 = 2130846063;
          } else {
            i1 = 2130848790;
          }
          localImageView.setImageResource(i1);
          this.j.setContentDescription(HardCodeUtil.a(2131904278));
        }
        else
        {
          this.h.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
          localImageView = this.j;
          if ((!this.aa) && (!this.Z) && (!this.z) && (!this.an)) {
            i1 = 2130846066;
          } else {
            i1 = 2130848791;
          }
          localImageView.setImageResource(i1);
          this.j.setContentDescription(HardCodeUtil.a(2131904282));
        }
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = this.h;
          ((PastablePwdEditText)localObject).setSelection(((PastablePwdEditText)localObject).length());
        }
      }
      else if (i1 == 2131439504)
      {
        ReportController.a(this.a, "dc00898", "", "", "0X8007354", "0X8007354", 0, 0, "", "", "", "");
        ReportController.a(this.a, "dc00898", "", "", "0X8007365", "0X8007365", 0, 0, "", "", "", "");
        ReportController.a(this.a, "dc00898", "", "", "0X8007365", "0X8007365", 2, 0, "", "", "", "");
        ReportController.b(this.a, "CliOper", "", "", "Mobile_signup", "Clk_ems_login", 0, 0, "", "", "", "");
        ReportController.a(this.a, "new_reg_805", "log_page", "log_msg_clk", "", 1, "");
        boolean bool = this.b.getIntent().getBooleanExtra("login_from_account_change", false);
        localObject = new Intent(this.b, LoginPhoneNumActivity.class);
        ((Intent)localObject).putExtra("login_from_account_change", bool);
        this.b.startActivity((Intent)localObject);
      }
      else if (i1 == 2131440045)
      {
        if (!NetworkUtil.isNetworkAvailable()) {
          QQToast.makeText(this.b, 2131892102, 0).show();
        } else {
          d(true);
        }
      }
      else if (i1 == 2131442877)
      {
        p();
      }
      else if (i1 == 2131439859)
      {
        this.h.a();
      }
    }
    label1451:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131625271, paramViewGroup, false);
    if (this.a == null) {
      this.a = this.b.getAppRuntime();
    }
    if (this.a == null)
    {
      this.b.finish();
      QLog.e("LoginActivity.LoginView", 1, "mAppInterface is null");
    }
    else
    {
      a(this.b.getIntent(), paramBundle);
      a(paramLayoutInflater);
      if ((this.b.getIntent().getBooleanExtra("logout_intent", false)) && (this.w != null))
      {
        LoginSharedPreUtils.a(this.b, this.w.getUin(), false);
        this.d = this.w.getUin();
      }
      if ((getQBaseActivity() != null) && (this.G != null))
      {
        paramViewGroup = new IntentFilter();
        paramViewGroup.addAction("com.tencent.mobileqq.InvitationWebViewPlugin");
        getQBaseActivity().registerReceiver(this.G, paramViewGroup);
      }
      this.u = paramLayoutInflater.findViewById(2131444546);
      this.u.post(new LoginView.1(this));
      if (this.ad) {
        k();
      }
      if (this.e != null)
      {
        paramViewGroup = new LoginView.2(this);
        this.e.a(paramViewGroup);
      }
      v();
      this.C.a(this.b, this.b.getIntent().getExtras());
      ReportController.a(this.a, "new_reg_805", "log_page", "page_exp", "", 1, "");
      ReportController.a(this.a, "dc00898", "", "", "0X8009E3D", "0X8009E3D", 0, 0, "", "", "", "");
      ReportController.a(this.a, "dc00898", "", "", "0X800AA27", "0X800AA27", 0, 0, "", "", "", "");
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
    if ((getQBaseActivity() != null) && (this.G != null))
    {
      getQBaseActivity().unregisterReceiver(this.G);
      this.G = null;
    }
    ThreadManager.getUIHandler().removeCallbacks(this.aO);
    ThreadManager.getUIHandler().removeCallbacks(this.aN);
    Object localObject = this.aK;
    if (localObject != null)
    {
      if (((ValueAnimator)localObject).isRunning()) {
        this.aK.cancel();
      }
      this.aK.removeAllUpdateListeners();
      this.aK.removeAllListeners();
    }
    localObject = this.k;
    if (localObject != null) {
      ((LoginAnimBtnView)localObject).f();
    }
    b(4);
    this.aj = true;
    this.C.a();
    PhoneNumQuickLoginManager.a();
    if ((this.av != null) && (getActivity() != null))
    {
      getActivity().unregisterReceiver(this.av);
      this.av = null;
    }
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    if (this.g != null)
    {
      if (this.t == null) {
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
      this.ak = false;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    this.W.hideSoftInputFromWindow(this.b.getWindow().getDecorView().getWindowToken(), 0);
    if (this.a != null) {
      this.a.unRegistObserver(this.L);
    }
    LoginAnimBtnView localLoginAnimBtnView = this.k;
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
    this.ak = false;
    this.p.clearFocus();
    this.i.setVisibility(8);
    this.h.clearFocus();
    this.h.setClearButtonVisible(false);
    if (this.a != null)
    {
      this.a.cancelSyncOnlineFriend(-1L);
      this.a.registObserver(this.L);
    }
    PhoneNumLoginImpl.a().a(false);
    a(true);
    n();
    LoginAnimBtnView localLoginAnimBtnView = this.k;
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
      paramBundle.putInt("position", this.x);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.p.isPopupShowing())
    {
      this.p.dismissDropDown();
      paramView = h();
      if (!TextUtils.isEmpty(paramView)) {
        c(paramView);
      }
    }
    return false;
  }
  
  public void onViewStateRestored(Bundle paramBundle)
  {
    super.onViewStateRestored(paramBundle);
    if (paramBundle != null) {
      this.x = paramBundle.getInt("position", -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView
 * JD-Core Version:    0.7.0.1
 */