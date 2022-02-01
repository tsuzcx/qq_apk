package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.api.IHiBoomManager;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profile.diy.DiyTextView;
import com.tencent.mobileqq.profile.diy.VipDiyCardConstants;
import com.tencent.mobileqq.profile.diy.VipProfileDiyCardConfig;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.mobileqq.profile.upload.task.VipBaseUpsImageUploadTask;
import com.tencent.mobileqq.profile.upload.task.VipImageUploadManager;
import com.tencent.mobileqq.profile.view.HScrollView;
import com.tencent.mobileqq.profile.view.HScrollView.ScrollViewListener;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.profile.view.SingleTouchLayout.SingleTapListener;
import com.tencent.mobileqq.profile.view.SoftInputDetectView;
import com.tencent.mobileqq.profile.view.SoftInputDetectView.OnImStateChangedListener;
import com.tencent.mobileqq.profile.view.VerticalSeekBar;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class VipProfileCardDiyActivity
  extends BaseActivity
  implements Handler.Callback, TextWatcher, View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, SeekBar.OnSeekBarChangeListener, HScrollView.ScrollViewListener, SingleTouchLayout.SingleTapListener, SoftInputDetectView.OnImStateChangedListener
{
  public static final String a = HardCodeUtil.a(2131913693);
  TextView A;
  TextView B;
  VoteView C;
  ImageView D;
  ImageView E;
  Bitmap F;
  Bitmap G;
  AtomicBoolean H = new AtomicBoolean(false);
  int I = 1;
  int J;
  boolean K;
  boolean L;
  boolean M = false;
  volatile boolean N = false;
  int O;
  int P;
  int Q = -1;
  Card R;
  int S;
  long T;
  String U;
  String V;
  String W;
  String X;
  int Y;
  float Z;
  DialogInterface.OnClickListener aA = new VipProfileCardDiyActivity.7(this);
  DialogInterface.OnClickListener aB = new VipProfileCardDiyActivity.8(this);
  DialogInterface.OnClickListener aC = new VipProfileCardDiyActivity.9(this);
  DialogInterface.OnClickListener aD = new VipProfileCardDiyActivity.10(this);
  HashMap<String, String> aE = new HashMap();
  float aa;
  float ab;
  float ac;
  int ad;
  String ae;
  int af;
  Drawable ag;
  IVasQuickUpdateService ah;
  IHiBoomManager ai;
  SharedPreferences aj;
  WeakReferenceHandler ak;
  String al;
  CallBacker am = new VipProfileCardDiyActivity.1(this);
  int an;
  VipProfileCardDiyActivity.OnMeasuredListener ao = new VipProfileCardDiyActivity.3(this);
  public int ap;
  int aq = 30000;
  QQProgressDialog ar;
  QQProgressDialog as;
  QQCustomDialog at;
  QQCustomDialog au;
  int av = 2;
  CardObserver aw = new VipProfileCardDiyActivity.4(this);
  AtomicBoolean ax = new AtomicBoolean(false);
  DialogInterface.OnClickListener ay = new VipProfileCardDiyActivity.5(this);
  DialogInterface.OnClickListener az = new VipProfileCardDiyActivity.6(this);
  Resources b;
  int c;
  SoftInputDetectView d;
  ImmersiveTitleBar2 e;
  TextView f;
  TextView g;
  ImageView h;
  LinearLayout i;
  HScrollView j;
  RelativeLayout k;
  SingleTouchLayout l;
  EditText m;
  DiyTextView n;
  VipProfileCardDiyActivity.DiyDefaultTextView o;
  VerticalSeekBar p;
  VipProfileCardDiyActivity.HiBoomTemplateView q;
  VipProfileCardDiyActivity.HiBoomTemplateView r;
  View s;
  Button t;
  PopupWindow u;
  TextView v;
  View w;
  AvatarLayout x;
  TextView y;
  TextView z;
  
  public static boolean a(long paramLong, String paramString, int paramInt)
  {
    if ((5L == paramLong) && (paramString.startsWith("font.diycard.android."))) {
      return String.valueOf(paramInt).equals(paramString.substring(21, paramString.length()));
    }
    return false;
  }
  
  public static boolean b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(VipDiyCardConstants.a);
    ((StringBuilder)localObject).append(paramInt);
    File localFile = new File(((StringBuilder)localObject).toString());
    if ((localFile.exists()) && (localFile.isDirectory())) {
      localObject = localFile.list();
    } else {
      localObject = null;
    }
    return (localFile.exists()) && (localObject != null) && (localObject.length > 0);
  }
  
  int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i2 = 1;
    int i1 = 1;
    int i4 = i2;
    if (paramInt1 != 0)
    {
      i4 = i2;
      if (paramInt2 != 0)
      {
        i4 = i2;
        if (paramInt1 != -1)
        {
          if (paramInt2 == -1) {
            return 1;
          }
          i2 = paramOptions.outHeight;
          int i3 = paramOptions.outWidth;
          for (;;)
          {
            i4 = i1;
            if (i2 <= paramInt2) {
              break;
            }
            i4 = i1;
            if (i3 <= paramInt1) {
              break;
            }
            int i5 = Math.round(i2 / paramInt2);
            i4 = Math.round(i3 / paramInt1);
            if (i5 <= i4) {
              i5 = i4;
            }
            i4 = i1;
            if (i5 < 2) {
              break;
            }
            i3 /= 2;
            i2 /= 2;
            i1 *= 2;
          }
        }
      }
    }
    return i4;
  }
  
  void a()
  {
    Intent localIntent = getIntent();
    this.S = localIntent.getIntExtra("extra_from", -1);
    this.T = localIntent.getLongExtra("extra_card_id", -1L);
    if (this.T == -1L) {
      finish();
    }
    this.U = localIntent.getStringExtra("extra_card_url");
    this.V = localIntent.getStringExtra("extra_card_default_text");
    if (android.text.TextUtils.isEmpty(this.V)) {
      this.V = a;
    }
    this.W = localIntent.getStringExtra("extra_card_path");
    if (!android.text.TextUtils.isEmpty(this.R.diyText)) {
      this.X = this.R.diyText;
    } else {
      this.X = localIntent.getStringExtra("extra_card_text");
    }
    if (this.R.diyTextFontId > 0) {
      this.Y = this.R.diyTextFontId;
    } else {
      this.Y = localIntent.getIntExtra("extra_card_font", -1);
    }
    long l1 = this.T;
    if ((l1 != 0L) && (l1 == this.R.lCurrentBgId)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i1 != 0) && (!android.text.TextUtils.isEmpty(this.R.diyText)))
    {
      this.Z = (this.R.diyTextLocX * this.O);
      this.aa = (this.R.diyTextLocY * this.P);
      this.ab = this.R.diyTextScale;
      this.ac = this.R.diyTextDegree;
      this.ad = ((int)(this.R.diyTextTransparency * 255.0F));
    }
    else
    {
      this.Z = localIntent.getFloatExtra("extra_card_x", 1.4E-45F);
      this.aa = localIntent.getFloatExtra("extra_card_y", 1.4E-45F);
      this.ab = localIntent.getFloatExtra("extra_card_scale", 1.0F);
      this.ac = localIntent.getFloatExtra("extra_card_rotation", 0.0F);
      this.ad = ((int)(localIntent.getFloatExtra("extra_card_transparency", 0.0F) * 255.0F));
    }
    int i1 = this.ad;
    if (i1 < -77) {
      this.ad = -77;
    } else if (i1 > 77) {
      this.ad = 77;
    }
    this.ad += 77;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      VasWebviewUtil.a("", "card_mall", "0X8008115", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", "");
    }
  }
  
  void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    j();
    i();
    if ((!this.N) && (!isFinishing()))
    {
      this.ax.set(true);
      Object localObject1 = this.q;
      int i1 = 0;
      if ((localObject1 != null) && (paramBoolean))
      {
        int i2 = ((VipProfileCardDiyActivity.HiBoomTemplateView)localObject1).e;
        localObject1 = f();
        Object localObject2 = this.l.getCenterPoint();
        localObject2 = String.format("%s_%s_%s_%s", new Object[] { Float.valueOf(((PointF)localObject2).x / this.O), Float.valueOf(((PointF)localObject2).y / this.P), Float.valueOf(this.l.Q / this.O), Float.valueOf(this.l.R / this.P) });
        float f1 = this.l.getImageDegree();
        float f2 = this.l.getImageScale();
        float f3 = (this.p.getProgress() - 77) / 255.0F;
        ProfileCardUtil.a(this.app, paramLong1, paramLong2, null, 0L, null, i2, (String)localObject1, (String)localObject2, f1, f2, f3, "", 0L);
      }
      else
      {
        ProfileCardUtil.a(this.app, paramLong1, paramLong2);
      }
      this.ae = f();
      localObject1 = this.q;
      if (localObject1 != null) {
        i1 = ((VipProfileCardDiyActivity.HiBoomTemplateView)localObject1).e;
      }
      this.af = i1;
      this.ak.sendEmptyMessageDelayed(6, this.aq);
    }
  }
  
  @TargetApi(11)
  public void a(View paramView)
  {
    if (this.I == 2) {
      return;
    }
    this.m.setVisibility(0);
    this.m.setFocusable(true);
    this.m.setFocusableInTouchMode(true);
    this.m.requestFocus();
    InputMethodUtil.a(this.m);
    c();
  }
  
  public void a(View paramView, float paramFloat)
  {
    c();
    String str = HttpUtil.getNetWorkTypeByStr();
    if (paramFloat > 1.0F) {
      paramView = "0";
    } else {
      paramView = "1";
    }
    VasWebviewUtil.a("", "card_mall", "0X8008111", "", 1, 0, 0, str, paramView, "");
  }
  
  public void a(View paramView, float paramFloat1, float paramFloat2)
  {
    c();
    VasWebviewUtil.a("", "card_mall", "0X8008110", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", "");
  }
  
  void a(String paramString)
  {
    this.m.setText(paramString);
    if (!android.text.TextUtils.isEmpty(paramString)) {
      this.m.setSelection(paramString.length());
    }
  }
  
  void a(String paramString, UpsImageUploadResult paramUpsImageUploadResult, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url from UPS:");
      localStringBuilder.append(paramUpsImageUploadResult.url);
      QLog.d("VipProfileCardDiyActivity", 2, localStringBuilder.toString());
    }
    this.aE.put(paramString, paramUpsImageUploadResult.url);
    a(paramString, paramUpsImageUploadResult.url, paramBoolean);
  }
  
  void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    i();
    long l1 = ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE;
    if ((!this.N) && (!isFinishing()))
    {
      this.ax.set(true);
      Object localObject1 = this.q;
      int i1;
      if ((localObject1 != null) && (paramBoolean))
      {
        int i2 = ((VipProfileCardDiyActivity.HiBoomTemplateView)localObject1).e;
        localObject1 = f();
        Object localObject2 = this.l.getCenterPoint();
        localObject2 = String.format("%s_%s_%s_%s", new Object[] { Float.valueOf(((PointF)localObject2).x / this.O), Float.valueOf(((PointF)localObject2).y / this.P), Float.valueOf(this.l.Q / this.O), Float.valueOf(this.l.R / this.P) });
        float f1 = this.l.getImageDegree();
        float f2 = this.l.getImageScale();
        float f3 = (this.p.getProgress() - 77) / 255.0F;
        if ((!android.text.TextUtils.isEmpty((CharSequence)localObject1)) && (i2 != 0)) {
          i1 = 1600;
        } else {
          i1 = 160;
        }
        ProfileCardUtil.a(this.app, l1, i1, paramString2, ProfileCardUtil.e(paramString1), null, i2, (String)localObject1, (String)localObject2, f1, f2, f3, "", 0L);
      }
      else
      {
        ProfileCardUtil.a(this.app, l1, 160L, paramString2, ProfileCardUtil.e(paramString1), null);
      }
      this.ae = f();
      paramString1 = this.q;
      if (paramString1 == null) {
        i1 = 0;
      } else {
        i1 = paramString1.e;
      }
      this.af = i1;
    }
  }
  
  void a(String paramString, boolean paramBoolean)
  {
    if (android.text.TextUtils.isEmpty(paramString))
    {
      QLog.e("VipProfileCardDiyActivity", 1, "uploadBackgroundToUps filePath is empty");
      return;
    }
    VipProfileCardDiyActivity.12 local12 = new VipProfileCardDiyActivity.12(this, Long.parseLong(this.app.getCurrentAccountUin()), paramString, VipUploadUtils.a(this.app), "qqprofile", paramString, paramBoolean);
    local12.q = VipUploadUtils.a(this.app);
    local12.B = VipUploadUtils.a(this.app, paramString);
    k();
    paramString = (VipImageUploadManager)this.app.getManager(QQManagerFactory.IMAGE_UPLOAD_MANAGER);
    paramString.a(this.app, null);
    local12.h();
    paramString.a(this.app, local12, null);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.m.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.m.getLayoutParams();
      localLayoutParams.bottomMargin = paramInt;
      this.m.setLayoutParams(localLayoutParams);
      VasWebviewUtil.a("", "card_mall", "0X8008112", "", 1, 0, 0, "", "", "");
      return;
    }
    this.m.setVisibility(8);
  }
  
  boolean a(long paramLong, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = localFriendsManager.f(this.app.getCurrentAccountUin());
    if ((localCard != null) && (paramLong >= 0L))
    {
      localCard.lCurrentStyleId = paramLong;
      localCard.lCurrentBgId = paramInt1;
      localCard.strCurrentBgUrl = paramString;
      localCard.backgroundColor = paramInt2;
      localCard.templateRet = paramInt3;
      if (!localFriendsManager.a(localCard))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("VipProfileCardDiyActivity", 4, "save card in db failed ");
        }
        return false;
      }
      return true;
    }
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable) {}
  
  @TargetApi(11)
  void b()
  {
    this.d = ((SoftInputDetectView)findViewById(2131445137));
    this.e = ((ImmersiveTitleBar2)findViewById(2131447582));
    this.f = ((TextView)findViewById(2131436180));
    this.g = ((TextView)findViewById(2131436211));
    this.h = ((ImageView)findViewById(2131440693));
    this.i = ((LinearLayout)findViewById(2131446984));
    this.j = ((HScrollView)findViewById(2131446983));
    this.k = ((RelativeLayout)findViewById(2131432156));
    this.l = ((SingleTouchLayout)findViewById(2131432158));
    this.m = ((EditText)findViewById(2131432150));
    this.p = ((VerticalSeekBar)findViewById(2131437177));
    this.s = findViewById(2131437976);
    this.n = new DiyTextView(this);
    Object localObject = this.n;
    boolean bool = false;
    ((DiyTextView)localObject).setBackgroundColor(0);
    this.l.a(this.n);
    int i1 = AIOUtils.b(10.0F, this.b);
    this.o = new VipProfileCardDiyActivity.DiyDefaultTextView(this, this);
    this.o.setTextColor(-1);
    this.o.setTextSize(18.0F);
    this.o.setPadding(i1, i1, i1, i1);
    this.t = ((Button)findViewById(2131445685));
    this.v = ((TextView)findViewById(2131432149));
    this.w = findViewById(2131440618);
    this.x = ((AvatarLayout)findViewById(2131435701));
    this.y = ((TextView)findViewById(2131435716));
    this.z = ((TextView)findViewById(2131435711));
    this.A = ((TextView)findViewById(2131435709));
    this.B = ((TextView)findViewById(2131435710));
    this.C = ((VoteView)findViewById(2131449991));
    localObject = this.x;
    ((AvatarLayout)localObject).a(0, ((AvatarLayout)localObject).findViewById(2131429335), false);
    this.e.resetBkColor(0);
    this.j.setOnScrollListener(this);
    this.p.setOnSeekBarChangeListener(this);
    this.p.setMaxProgress(154);
    this.p.setProgress(this.ad);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.l.S = this;
    this.k.setOnClickListener(this);
    this.m.addTextChangedListener(this);
    this.m.setFilters(new InputFilter[] { new InputFilter.LengthFilter(VipProfileDiyCardConfig.b) });
    this.t.setOnClickListener(this);
    this.k.getViewTreeObserver().addOnGlobalLayoutListener(this);
    this.n.setOnMeasuredListener(this.ao);
    localObject = this.d;
    if (ImmersiveUtils.isSupporImmersive() != 1) {
      bool = true;
    }
    ((SoftInputDetectView)localObject).setExcludeStatusBar(bool);
    this.d.setOnImStateChangedListener(this);
    float f1 = this.Z;
    if (f1 > 1.4E-45F)
    {
      float f2 = this.aa;
      if (f2 > 1.4E-45F) {
        this.l.setCenterPoint(f1, f2);
      }
    }
    this.l.setImageScale(this.ab);
    this.l.setImageDegree(this.ac);
  }
  
  public void b(View paramView)
  {
    this.l.setVisibility(8);
    this.K = true;
    a("");
    c();
    VasWebviewUtil.a("", "card_mall", "0X800810F", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", "");
  }
  
  void b(String paramString)
  {
    m();
    int i2;
    if ((this.q != null) && (!android.text.TextUtils.isEmpty(f()))) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    boolean bool = VasUtil.b(this.app).getVipStatus().isSVip();
    String str2 = getString(2131892754);
    String str1 = paramString;
    if (android.text.TextUtils.isEmpty(paramString))
    {
      l1 = this.T;
      if ((l1 != 0L) && (l1 != 160L) && (l1 != 1600L))
      {
        if (bool) {
          str1 = getString(2131892753);
        } else {
          str1 = getString(2131892750);
        }
      }
      else if (i2 != 0)
      {
        if (bool) {
          str1 = getString(2131892752);
        } else {
          str1 = getString(2131892750);
        }
      }
      else {
        str1 = getString(2131892751);
      }
    }
    long l1 = this.T;
    int i3;
    if (((l1 == 0L) || (l1 == 160L)) && (bool)) {
      i3 = 2131892772;
    } else {
      i3 = 2131887648;
    }
    int i1;
    if (this.av == 2)
    {
      if (bool) {
        i1 = 2131892768;
      } else {
        i1 = 2131892765;
      }
    }
    else if (VasUtil.b(this.app).getVipStatus().isVip()) {
      i1 = 2131892769;
    } else {
      i1 = 2131892766;
    }
    this.at = DialogUtil.a(this, 0, str2, str1, i3, i1, this.aB, this.aA);
    this.at.show();
    if (i2 != 0)
    {
      if (bool) {
        paramString = "4";
      } else {
        paramString = "3";
      }
      VasWebviewUtil.a("", "card_mall", "0X80081C9", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), paramString, "");
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  void c()
  {
    if (this.M)
    {
      this.v.setVisibility(8);
      this.M = false;
    }
  }
  
  public void c(int paramInt)
  {
    if (paramInt == 2)
    {
      VasH5PayUtil.a(this, "mvip.g.a.mp_wz", 3, "1450000516", "CJCLUBT", getString(2131916948), "svipdiyCardH5Pay");
      return;
    }
    VasH5PayUtil.a(this, "mvip.g.a.mp_wz", 3, "1450000515", "LTMCLUB", getString(2131892806), "vipdiyCardH5Pay");
  }
  
  void c(String paramString)
  {
    ThreadManager.executeOnFileThread(new VipProfileCardDiyActivity.11(this, paramString));
  }
  
  void d()
  {
    boolean bool = android.text.TextUtils.isEmpty(this.W);
    int i2 = 0;
    int i1;
    if (bool)
    {
      localObject2 = ProfileCardManager.a(this, ProfileCardTemplate.PROFILE_CARD_STYLE_DIY, this.T);
      localObject1 = new File((String)localObject2);
      if ((((File)localObject1).isFile()) && (((File)localObject1).exists()))
      {
        c((String)localObject2);
        i1 = 0;
      }
      else
      {
        i1 = 1;
      }
      if (i1 != 0)
      {
        localObject1 = ((VasExtensionManager)this.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e;
        this.al = ((String)localObject2);
        localObject2 = this.app;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("card.");
        ((StringBuilder)localObject3).append(this.T);
        ((ProfileCardManager)localObject1).a((QQAppInterface)localObject2, ((StringBuilder)localObject3).toString());
      }
    }
    else
    {
      c(this.W);
    }
    Object localObject1 = new LinearLayout.LayoutParams(AIOUtils.b(86.0F, this.b), AIOUtils.b(123.0F, this.b));
    ((LinearLayout.LayoutParams)localObject1).setMargins(0, AIOUtils.b(12.0F, this.b), AIOUtils.b(5.0F, this.b), AIOUtils.b(10.0F, this.b));
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    Object localObject3 = VipProfileDiyCardConfig.a;
    if (localObject3 == null)
    {
      VipProfileDiyCardConfig.a(this.app);
      this.l.a(this.o);
      g();
    }
    if ((localObject3 != null) && (((SparseArray)localObject3).size() > 0))
    {
      this.Q = this.Y;
      i1 = this.Q;
      if ((i1 <= 0) || (((SparseArray)localObject3).indexOfKey(i1) < 0)) {
        this.Q = ((SparseArray)localObject3).keyAt(0);
      }
      Object localObject4 = (String)((SparseArray)localObject3).get(this.Q);
      bool = b(this.Q);
      this.r = new VipProfileCardDiyActivity.HiBoomTemplateView(this, this, this.Q, bool);
      localObject4 = URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject2);
      this.r.setImageDrawable((Drawable)localObject4);
      if ((this.T != 0L) && ((!android.text.TextUtils.isEmpty(this.X)) || (this.S != 1)))
      {
        this.r.setChecked(true);
        this.q = this.r;
        this.n.setHiBoom(this.Q, 1, HiBoomConstants.d);
        this.L = (bool ^ true);
        if (this.L) {
          this.q.f = 1;
        }
        if (!android.text.TextUtils.isEmpty(this.X)) {
          a(this.X);
        } else {
          e();
        }
      }
      else
      {
        this.l.setVisibility(8);
        this.K = true;
        e();
      }
      this.i.addView(this.r, (ViewGroup.LayoutParams)localObject1);
      i1 = i2;
      while (i1 < ((SparseArray)localObject3).size())
      {
        i2 = ((SparseArray)localObject3).keyAt(i1);
        if (i2 != this.Q)
        {
          localObject4 = (String)((SparseArray)localObject3).get(i2);
          VipProfileCardDiyActivity.HiBoomTemplateView localHiBoomTemplateView = new VipProfileCardDiyActivity.HiBoomTemplateView(this, this, i2, b(i2));
          localHiBoomTemplateView.setImageDrawable(URLDrawable.getDrawable((String)localObject4, (URLDrawable.URLDrawableOptions)localObject2));
          this.i.addView(localHiBoomTemplateView, (ViewGroup.LayoutParams)localObject1);
        }
        i1 += 1;
      }
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
  
  public void doOnBackPressed()
  {
    onClick(this.f);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    super.setContentView(2131627670);
    this.aj = getSharedPreferences("vip_profile_diy_card", 0);
    this.R = ProfileCardUtil.a(this.app, this.app.getCurrentAccountUin());
    this.b = super.getResources();
    paramBundle = this.b.getDisplayMetrics();
    this.O = paramBundle.widthPixels;
    this.P = paramBundle.heightPixels;
    this.c = AIOUtils.b(130.0F, this.b);
    a();
    this.J = AIOUtils.b(5.0F, this.b);
    this.ah = ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, ""));
    this.ai = ((IVasService)this.app.getRuntimeService(IVasService.class, "")).getHiBoomManager();
    this.ak = new WeakReferenceHandler(Looper.getMainLooper(), this);
    addObserver(this.aw);
    b();
    ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "")).addCallBacker(this.am);
    d();
    VasWebviewUtil.a("", "card_mall", "0X800810D", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", String.valueOf(this.T));
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.N = true;
    this.ak.removeCallbacks(null);
    removeObserver(this.aw);
    j();
    l();
    ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.am);
  }
  
  @TargetApi(9)
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      if (!this.aj.getBoolean("vip_diy_card_guide_shown", false))
      {
        if (this.u == null)
        {
          View localView = getLayoutInflater().inflate(2131627669, null);
          Button localButton = (Button)localView.findViewById(2131429921);
          this.D = ((ImageView)localView.findViewById(2131434499));
          this.E = ((ImageView)localView.findViewById(2131434491));
          localButton.setOnClickListener(this);
          this.u = new PopupWindow(localView, -1, -1);
          this.u.setFocusable(true);
          this.u.setBackgroundDrawable(new BitmapDrawable());
        }
        if (!this.H.get())
        {
          if ((this.F != null) && (this.G != null))
          {
            this.ak.sendEmptyMessage(9);
            return;
          }
          this.H.set(true);
          ThreadManager.executeOnFileThread(new VipProfileCardDiyActivity.2(this));
        }
      }
      else
      {
        this.aj.getBoolean("vip_diy_card_edit_guide_shown", false);
      }
    }
  }
  
  void e()
  {
    long l1 = this.T;
    if ((l1 != 0L) && (l1 != 160L) && (l1 != 1600L))
    {
      if (!android.text.TextUtils.isEmpty(this.V)) {
        a(this.V);
      }
    }
    else {
      a(VipProfileDiyCardConfig.c);
    }
  }
  
  String f()
  {
    if (this.K) {
      return "";
    }
    return this.o.getText().toString();
  }
  
  void g()
  {
    this.l.c();
    this.l.invalidate();
  }
  
  void h()
  {
    if (this.ax.get()) {
      return;
    }
    long l1 = ProfileCardTemplate.PROFILE_CARD_STYLE_SIMPLE;
    long l2 = this.T;
    Object localObject;
    if (l2 == 0L)
    {
      if (q())
      {
        localObject = (String)this.aE.get(this.W);
        if (!android.text.TextUtils.isEmpty((CharSequence)localObject))
        {
          a(this.W, (String)localObject, true);
          return;
        }
        a(this.W, true);
      }
    }
    else
    {
      if ((l2 != 160L) && (l2 != 1600L))
      {
        if (android.text.TextUtils.isEmpty(f()))
        {
          p();
          localObject = this.q;
          if (localObject == null) {
            localObject = "";
          } else {
            localObject = String.valueOf(((VipProfileCardDiyActivity.HiBoomTemplateView)localObject).e);
          }
          VasWebviewUtil.a("", "card_mall", "0X80081C2", "", 1, 0, 0, "", "1", (String)localObject);
          return;
        }
        a(l1, this.T, true);
        return;
      }
      if ((q()) && (!android.text.TextUtils.isEmpty(this.U))) {
        a(ProfileCardManager.a(this, ProfileCardTemplate.PROFILE_CARD_STYLE_DIY, this.T), this.U, true);
      }
    }
  }
  
  @TargetApi(9)
  public boolean handleMessage(Message paramMessage)
  {
    if (!isFinishing())
    {
      if (this.N) {
        return false;
      }
      Object localObject;
      switch (paramMessage.what)
      {
      default: 
        return false;
      case 9: 
        paramMessage = this.F;
        if ((paramMessage != null) && (this.G != null))
        {
          localObject = this.D;
          if ((localObject != null) && (this.E != null) && (this.u != null))
          {
            ((ImageView)localObject).setImageBitmap(paramMessage);
            this.E.setImageBitmap(this.G);
            this.u.showAtLocation(this.d, 80, 0, 0);
            this.l.setVisibility(8);
            this.aj.edit().putBoolean("vip_diy_card_guide_shown", true).apply();
            return false;
          }
        }
        break;
      case 8: 
        localObject = String.format(getString(2131892776), new Object[] { Integer.valueOf(VipProfileDiyCardConfig.b) });
        paramMessage = (String)paramMessage.obj;
        if (android.text.TextUtils.isEmpty(paramMessage)) {
          paramMessage = (Message)localObject;
        }
        QQToast.makeText(this, 1, paramMessage, 0).show();
        return false;
      case 7: 
        localObject = getString(2131892762);
        paramMessage = (String)paramMessage.obj;
        if (android.text.TextUtils.isEmpty(paramMessage)) {
          paramMessage = (Message)localObject;
        }
        QQToast.makeText(this, 1, paramMessage, 0).show();
        return false;
      case 6: 
        j();
        l();
        return false;
      case 5: 
        localObject = (View)paramMessage.obj;
        if (paramMessage.arg1 == 0)
        {
          if (localObject != null)
          {
            ((View)localObject).setVisibility(8);
            return false;
          }
        }
        else
        {
          if (localObject != null)
          {
            paramMessage = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
            paramMessage.bottomMargin = 0;
            ((View)localObject).setLayoutParams(paramMessage);
          }
          QQToast.makeText(this, 1, 2131892761, 0).show();
          paramMessage = this.q;
          if (paramMessage != null) {
            if ((paramMessage.e == this.Q) && (this.L))
            {
              if (this.Y == -1)
              {
                this.q.setChecked(false);
                b(null);
              }
              else
              {
                this.q.setChecked(false);
              }
            }
            else {
              this.q.setChecked(false);
            }
          }
          this.l.a(this.o, this.c);
          return false;
        }
        break;
      case 4: 
        localObject = (View)paramMessage.obj;
        if (localObject != null)
        {
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
          localLayoutParams.bottomMargin = paramMessage.arg1;
          ((View)localObject).setLayoutParams(localLayoutParams);
          return false;
        }
        break;
      case 3: 
        this.h.setImageDrawable(this.ag);
        return false;
      case 2: 
        b((String)paramMessage.obj);
        return false;
      case 1: 
        if (!android.text.TextUtils.isEmpty((String)paramMessage.obj))
        {
          QQToast.makeText(this, (String)paramMessage.obj, 0).show();
          return false;
        }
        QQToast.makeText(this, 2131892773, 0).show();
        return false;
      case 0: 
        paramMessage = ((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardIntentOnly(this, null);
        if (this.S == 1)
        {
          setResult(-1, paramMessage);
        }
        else
        {
          paramMessage.putExtra("AllInOne", new AllInOne(this.app.getCurrentAccountUin(), 0));
          paramMessage.putExtra("diyTextEditResult", true);
          startActivity(paramMessage);
        }
        finish();
      }
    }
    return false;
  }
  
  void i()
  {
    try
    {
      if (!isFinishing())
      {
        this.ar = new QQProgressDialog(this, getTitleBarHeight());
        this.ar.setCancelable(false);
        this.ar.c(2131892860);
        this.ar.show();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void j()
  {
    QQProgressDialog localQQProgressDialog = this.ar;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {}
    try
    {
      this.ar.dismiss();
      label23:
      this.ar = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  protected void k()
  {
    try
    {
      if (!isFinishing())
      {
        this.as = new QQProgressDialog(this, getTitleBarHeight());
        this.as.setCancelable(false);
        this.as.c(2131887775);
        this.as.show();
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void l()
  {
    QQProgressDialog localQQProgressDialog = this.as;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {}
    try
    {
      this.as.dismiss();
      label23:
      this.as = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
    }
  }
  
  void m()
  {
    QQCustomDialog localQQCustomDialog = this.at;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.at = null;
    }
  }
  
  void n()
  {
    o();
    boolean bool = android.text.TextUtils.isEmpty(f()) ^ true;
    int i1;
    if (bool) {
      i1 = 2131892770;
    } else {
      i1 = 2131892760;
    }
    String str = getString(i1);
    if (bool) {
      i1 = 2131892764;
    } else {
      i1 = 2131892759;
    }
    this.au = DialogUtil.a(this, str, i1, 2131892758, this.aD, this.aC);
    this.au.show();
    if (bool) {
      str = "1";
    } else {
      str = "0";
    }
    VasWebviewUtil.a("", "card_mall", "0X80081C9", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), str, "");
  }
  
  void o()
  {
    QQCustomDialog localQQCustomDialog = this.au;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.dismiss();
      this.au = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int i2 = paramView.getId();
    Object localObject2 = "";
    int i1 = 0;
    Object localObject1;
    switch (i2)
    {
    default: 
      break;
    case 2131445685: 
      h();
      if (this.q != null) {
        i1 = 1;
      }
      boolean bool1 = android.text.TextUtils.isEmpty(f()) ^ true;
      if (i1 != 0)
      {
        if (bool1) {
          localObject1 = "2";
        } else {
          localObject1 = "1";
        }
      }
      else if (bool1) {
        localObject1 = "";
      } else {
        localObject1 = "0";
      }
      if (i1 != 0) {
        localObject2 = String.valueOf(this.q.e);
      }
      VasWebviewUtil.a("", "card_mall", "0X8008116", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), (String)localObject1, (String)localObject2);
      break;
    case 2131436211: 
      this.I = 2;
      this.f.setText(2131892756);
      if (android.text.TextUtils.isEmpty(f())) {
        this.l.setVisibility(8);
      } else {
        this.l.setEditable(false);
      }
      this.g.setVisibility(8);
      this.i.setVisibility(8);
      this.m.setVisibility(8);
      this.p.setVisibility(8);
      InputMethodUtil.a(this);
      this.w.setVisibility(0);
      if (android.text.TextUtils.isEmpty(this.y.getText()))
      {
        this.x.setFaceDrawable(this.app, 1, this.app.getCurrentAccountUin(), 200, true, true, true, false, 3);
        this.y.setText(this.R.strNick);
        this.A.setText(String.format("%s岁", new Object[] { Byte.valueOf(this.R.age) }));
        if (this.R.shGender == 1) {}
        for (i1 = 2131913692;; i1 = 2131913697)
        {
          localObject1 = HardCodeUtil.a(i1);
          break label398;
          if (this.R.shGender != 0) {
            break;
          }
        }
        localObject1 = "";
        this.z.setText((CharSequence)localObject1);
        localObject1 = localObject2;
        if (!android.text.TextUtils.isEmpty(this.R.strCountry))
        {
          localObject1 = localObject2;
          if (!HardCodeUtil.a(2131913691).equals(this.R.strCountry))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("");
            ((StringBuilder)localObject1).append(this.R.strCountry);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        localObject2 = localObject1;
        if (!android.text.TextUtils.isEmpty(this.R.strProvince))
        {
          localObject2 = localObject1;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append("，");
            localObject2 = ((StringBuilder)localObject2).toString();
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append((String)localObject2);
          ((StringBuilder)localObject1).append(this.R.strProvince);
          localObject2 = ((StringBuilder)localObject1).toString();
        }
        localObject1 = localObject2;
        if (!android.text.TextUtils.isEmpty(this.R.strCity))
        {
          localObject1 = localObject2;
          if (!android.text.TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("，");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(this.R.strCity);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        this.B.setText((CharSequence)localObject1);
        localObject1 = this.C;
        boolean bool2;
        if (this.R.bVoted == 1) {
          bool2 = true;
        } else {
          bool2 = false;
        }
        ((VoteView)localObject1).a(true, bool2, (int)this.R.lVoteCount, this.R.iVoteIncrement, null, false);
      }
      VasWebviewUtil.a("", "card_mall", "0X80081CB", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", "");
      break;
    case 2131436180: 
      if (this.I == 2)
      {
        this.I = 1;
        if (!this.K)
        {
          this.l.setVisibility(0);
          this.l.setEditable(true);
        }
        this.g.setVisibility(0);
        this.i.setVisibility(0);
        this.p.setVisibility(0);
        this.w.setVisibility(8);
        this.f.setText(2131887626);
        VasWebviewUtil.a("", "card_mall", "0X800820F", "", 1, 0, 0, "", "", "");
      }
      else
      {
        n();
        VasWebviewUtil.a("", "card_mall", "0X800810E", "", 1, 0, 0, "", "", "");
      }
      break;
    case 2131432156: 
      if ((this.K) && (this.I == 1))
      {
        long l1 = this.T;
        if ((l1 != 0L) && (l1 != 160L) && (l1 != 1600L)) {
          a(this.V);
        } else {
          a(VipProfileDiyCardConfig.c);
        }
        if (this.q == null)
        {
          localObject1 = this.r;
          if (localObject1 != null) {
            ((VipProfileCardDiyActivity.HiBoomTemplateView)localObject1).performClick();
          }
        }
        this.l.setVisibility(0);
        g();
        this.K = false;
        if (this.Y == -1)
        {
          localObject1 = this.q;
          if ((localObject1 != null) && (((VipProfileCardDiyActivity.HiBoomTemplateView)localObject1).e == this.Q) && (this.L) && (this.q.f == 0))
          {
            this.n.setHiBoom(this.q.e, 1, HiBoomConstants.d);
            this.q.f = 1;
          }
        }
        VasWebviewUtil.a("", "card_mall", "0X8008113", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", "");
      }
      else
      {
        this.m.setVisibility(8);
        if (this.I != 2) {
          this.l.setEditable(true);
        }
        InputMethodUtil.a(this);
      }
      break;
    case 2131429921: 
      label398:
      localObject1 = this.u;
      if (localObject1 != null)
      {
        ((PopupWindow)localObject1).dismiss();
        if (this.q != null) {
          this.l.setVisibility(0);
        }
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onGlobalLayout()
  {
    if (this.ap <= 0)
    {
      this.ap = (this.k.getWidth() * 2 / 3);
      this.n.setMaxSize(this.ap);
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    paramSeekBar = this.s;
    int i1;
    if (paramInt > 77) {
      i1 = -16777216;
    } else {
      i1 = -1;
    }
    paramSeekBar.setBackgroundColor(i1);
    this.s.getBackground().setAlpha(Math.abs(paramInt - 77));
    this.ad = paramInt;
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    this.an = this.p.getProgress();
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    String str;
    if (this.p.getProgress() - this.an > 0) {
      str = "1";
    } else {
      str = "0";
    }
    VasWebviewUtil.a("", "card_mall", "0X80081CC", "", 1, 0, 0, "", str, "");
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = com.tencent.mobileqq.text.TextUtils.getStringWithoutEmoji(paramCharSequence.toString());
    boolean bool;
    if (!android.text.TextUtils.isEmpty(paramCharSequence))
    {
      this.n.setText(paramCharSequence);
      this.o.setText(paramCharSequence);
      if (this.q == null) {
        bool = this.l.a(this.o, this.c);
      } else {
        bool = this.l.a(this.n);
      }
      if (bool) {
        g();
      }
    }
    else
    {
      bool = this.K;
      this.n.setText(" ");
      this.o.setText("");
    }
  }
  
  void p()
  {
    o();
    this.au = DialogUtil.a(this, getString(2131892763), 2131892755, 2131892771, this.az, this.ay);
    this.au.show();
    VasWebviewUtil.a("", "card_mall", "0X80081C9", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "2", "");
  }
  
  boolean q()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity
 * JD-Core Version:    0.7.0.1
 */