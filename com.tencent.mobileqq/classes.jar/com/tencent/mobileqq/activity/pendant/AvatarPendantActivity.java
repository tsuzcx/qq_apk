package com.tencent.mobileqq.activity.pendant;

import Override;
import akmj;
import akmk;
import akml;
import akmm;
import akmn;
import akmq;
import akmr;
import akms;
import akmt;
import akmu;
import akmv;
import akmw;
import akmx;
import akmy;
import akmz;
import akna;
import aknb;
import aknc;
import aknd;
import akne;
import ammy;
import amnc;
import amne;
import amnf;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anuw;
import anyu;
import anyw;
import anzj;
import aogu;
import aogx;
import aokc;
import aokd;
import aoot;
import ayxl;
import bbav;
import bdgb;
import bdll;
import bhez;
import bhgr;
import bhhz;
import bhjr;
import bhkt;
import bhlq;
import bhmi;
import bhmq;
import bhnv;
import bhpc;
import bhsi;
import bhwh;
import bhwi;
import bhwj;
import bhwl;
import bhyk;
import bhzs;
import bhzu;
import biht;
import bihw;
import blir;
import blji;
import bljm;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.GridView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionGrant;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AvatarPendantActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, View.OnLayoutChangeListener, bljm
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  double jdField_a_of_type_Double;
  public long a;
  public ammy a;
  SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor;
  public Uri a;
  public Handler a;
  SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private anuw jdField_a_of_type_Anuw = new akmj(this);
  private anyu jdField_a_of_type_Anyu = new akmx(this);
  aogu jdField_a_of_type_Aogu;
  private aogx jdField_a_of_type_Aogx = new akmz(this);
  aokc jdField_a_of_type_Aokc;
  aokd jdField_a_of_type_Aokd = new akmk(this);
  private ayxl jdField_a_of_type_Ayxl = new akna(this);
  bhwh jdField_a_of_type_Bhwh;
  public bhwi a;
  public bhwj a;
  bhzs jdField_a_of_type_Bhzs = new akmr(this);
  biht jdField_a_of_type_Biht = new akmq(this);
  public ProfileActivity.AllInOne a;
  public DynamicAvatarView a;
  RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new akmw(this);
  AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  TipsBar jdField_a_of_type_ComTencentMobileqqWidgetTipsBar;
  BusinessInfoCheckUpdate.AppInfo jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo;
  public XListView a;
  String jdField_a_of_type_JavaLangString;
  public List<bhwh> a;
  AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_a_of_type_Boolean;
  double jdField_b_of_type_Double;
  long jdField_b_of_type_Long = -1L;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  AtomicBoolean jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  boolean jdField_b_of_type_Boolean;
  long jdField_c_of_type_Long = -1L;
  View jdField_c_of_type_AndroidViewView;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean;
  public long d;
  View jdField_d_of_type_AndroidViewView;
  String jdField_d_of_type_JavaLangString;
  public boolean d;
  public int e;
  public volatile boolean e;
  int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = true;
  int g;
  int h;
  int i;
  int j;
  int k;
  int l;
  int m;
  int n;
  int o;
  int p;
  int q;
  public int r = 0;
  public int s = -1;
  public int t = -1;
  public int u;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 2;
    jdField_d_of_type_Int = 3;
  }
  
  public AvatarPendantActivity()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
  }
  
  @TargetApi(14)
  private void a(List<View> paramList, List<akne> paramList1, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 14) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, 100 });
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(new aknc(this, paramList, paramList1));
    localValueAnimator.addListener(new aknd(this));
    localValueAnimator.setDuration(paramInt).start();
  }
  
  private void a(boolean paramBoolean)
  {
    int i1 = 0;
    ExtensionInfo localExtensionInfo = this.app.a(this.app.getCurrentAccountUin(), false);
    if (paramBoolean) {}
    for (;;)
    {
      if ((localExtensionInfo != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0) && (i1 != this.s))
      {
        this.s = i1;
        this.t = this.s;
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("ChooseFaceId", -1);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("mSelectFaceId", this.s);
        this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      }
      return;
      if (localExtensionInfo != null) {
        i1 = localExtensionInfo.faceId;
      }
    }
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "initHDHeadUrl: uin=" + paramString);
    }
    Setting localSetting = this.app.c(paramString);
    if ((localSetting != null) && (!TextUtils.isEmpty(localSetting.url)))
    {
      String str = QQHeadDownloadHandler.a(localSetting.url, localSetting.bFaceFlags);
      paramString = str;
      if (!TextUtils.isEmpty(str)) {
        paramString = MsfSdkUtils.insertMtype("QQHeadIcon", str);
      }
      this.jdField_d_of_type_Long = localSetting.headImgTimestamp;
      ThreadManager.getUIHandler().post(new AvatarPendantActivity.24(this, paramString));
      return;
    }
    this.app.e(paramString);
  }
  
  private boolean c()
  {
    Object localObject = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
    boolean bool = ((SharedPreferences)localObject).getBoolean("had_show_pendant_tips", false);
    if (!bool)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("had_show_pendant_tips", true);
      ((SharedPreferences.Editor)localObject).commit();
    }
    return bool;
  }
  
  private void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "onGetHDHeadUrl: url=" + paramString);
    }
    this.jdField_c_of_type_JavaLangString = paramString;
    if (e())
    {
      paramString = aoot.a(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getWidth();
      localURLDrawableOptions.mRequestHeight = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getHeight();
      localURLDrawableOptions.mFailedDrawable = paramString;
      localURLDrawableOptions.mLoadingDrawable = paramString;
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getDrawable() instanceof BitmapDrawable)) {
          localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getDrawable();
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      }
      this.jdField_c_of_type_JavaLangString = (this.jdField_c_of_type_JavaLangString + "?" + this.jdField_d_of_type_Long);
      URLDrawable.removeMemoryCacheByUrl(this.jdField_c_of_type_JavaLangString, localURLDrawableOptions);
      paramString = URLDrawable.getDrawable(this.jdField_c_of_type_JavaLangString, localURLDrawableOptions);
      if (bdgb.b())
      {
        paramString.setDecodeHandler(bhez.j);
        paramString.setTag(new int[] { 640, 640, 45 });
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantActivity", 2, "onGetHDHeadUrl: newDisplayHDHead");
        }
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, paramString, 1, 200, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 640, true, null, false, true, false, true, 7);
        return;
        paramString.setDecodeHandler(bhez.a);
        paramString.setTag(new int[] { 640, 640 });
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AvatarPendantActivity", 2, "onGetHDHeadUrl: oldDisplayHead");
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 640, true, true, true, false, 7);
  }
  
  private boolean d()
  {
    return this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("had_entered_store_face", false);
  }
  
  private boolean e()
  {
    int i1 = 0;
    boolean bool;
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvatarPendantActivity", 2, "isNeedShowHDHead, result=" + bool + ", hdHeadUrl=" + this.jdField_c_of_type_JavaLangString + ",openflag=" + i1);
      }
      this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(bool);
      return bool;
      String[] arrayOfString = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.headCfg.name(), "24|3500|1|0").split("\\|");
      if (arrayOfString.length > 3)
      {
        i1 = Integer.parseInt(arrayOfString[3]);
        if (i1 == 0) {
          bool = false;
        }
      }
      else
      {
        bool = false;
        continue;
      }
      bool = true;
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_JavaUtilList = ((AvatarPendantManager)this.app.getManager(46)).b();
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.app.getManager(184);
      localVasQuickUpdateManager.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      localVasQuickUpdateManager.downloadItem(23L, "avatarInPendant_json", "pendant_market");
      f();
    }
  }
  
  private void i()
  {
    VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.app.getManager(184);
    localVasQuickUpdateManager.addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    Object localObject = ((bihw)this.app.getManager(47)).a(1);
    File localFile1 = new File(bhkt.jdField_b_of_type_JavaLangString);
    if (!localFile1.exists()) {
      localFile1.mkdir();
    }
    File localFile2 = new File(bhkt.jdField_b_of_type_JavaLangString + "/icon.zip");
    if ((localFile1.exists()) && (!localFile2.exists()) && (localObject != null)) {
      ThreadManager.getSubThreadHandler().post(new AvatarPendantActivity.IconRunnable(this, this.jdField_a_of_type_Biht, this.app));
    }
    localObject = ((AvatarPendantManager)this.app.getManager(46)).a();
    this.app.getApp().getSharedPreferences(bhwl.jdField_a_of_type_JavaLangString, 0);
    if (((List)localObject).size() > 0)
    {
      this.jdField_a_of_type_Ammy.a((List)localObject, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    if (new File(this.jdField_a_of_type_JavaLangString).exists())
    {
      ((List)localObject).clear();
      e();
      return;
    }
    localVasQuickUpdateManager.downloadItem(1000L, "pendant_market_json.android.v2", "pendant_market");
  }
  
  private void j()
  {
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131378993);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131363594);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131380373);
    View localView = super.findViewById(2131374418);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131380374));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131372375));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)findViewById(2131380372));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)super.findViewById(2131363327));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131380378));
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131380377);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)super.findViewById(2131378899));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131377012));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131377013));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372390));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366266));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131363328));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131377009));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView, false);
    this.jdField_c_of_type_AndroidViewView.addOnLayoutChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    findViewById(2131369050).setOnClickListener(this);
    Object localObject1 = (TextView)findViewById(2131366265);
    ((TextView)localObject1).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, (View)localObject1).a(53).a();
    l();
    localObject1 = (TextView)super.findViewById(2131369042);
    ((TextView)localObject1).setText("");
    ((TextView)localObject1).setOnClickListener(this);
    localObject1 = (TextView)super.findViewById(2131369088);
    ((TextView)localObject1).setText(" ");
    ((TextView)localObject1).setFocusable(true);
    ((TextView)localObject1).setFocusableInTouchMode(true);
    ((TextView)localObject1).setClickable(true);
    ((TextView)localObject1).setContentDescription(" ");
    localObject1 = (RelativeLayout)super.findViewById(2131378993);
    localObject1 = getWindowManager().getDefaultDisplay();
    int i1 = ((Display)localObject1).getHeight();
    int i2 = ((Display)localObject1).getWidth();
    double d3 = i1 / i2;
    if ((Build.VERSION.SDK_INT >= 24) && (!isInMultiWindowMode()) && (!isInPictureInPictureMode()) && (d3 < 1.5D)) {
      d3 = 1.5D;
    }
    for (;;)
    {
      double d1 = d3 - 1.78D;
      this.jdField_f_of_type_Int = (i1 - a());
      this.jdField_e_of_type_Int = jdField_a_of_type_Int;
      double d2 = 0.58D * (d3 - 2.0D * d1) / 1.8D;
      d1 = (1.85D - d1 * 2.0D) * 0.38D / d3;
      Object localObject2;
      RelativeLayout.LayoutParams localLayoutParams;
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        d1 = d3 - 1.67D;
        a();
        i2 = super.getResources().getDimensionPixelSize(2131299011);
        localObject2 = (RelativeLayout)super.findViewById(2131380361);
        localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
        localLayoutParams.topMargin = (i2 / 2 + 14 - (int)(Math.abs(d1) * 24.0D));
        ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams);
        d2 = 0.58D * (1.8D + 2.0D * d1) / d3;
        d1 = 0.38D * (d1 * 2.0D + 1.95D) / d3;
      }
      for (;;)
      {
        if (d3 < 1.2D)
        {
          this.jdField_f_of_type_Int = i1;
          d2 = 1.0D;
          d1 = 1.0D;
        }
        for (;;)
        {
          this.g = ((int)(this.jdField_f_of_type_Int * d2));
          this.h = ((int)(this.jdField_f_of_type_Int * d1));
          if (!this.jdField_b_of_type_Boolean)
          {
            super.findViewById(2131380365).setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
            this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText("没有SD卡无法使用头像挂件");
            this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.b(false);
            this.g = ((int)((d2 + 0.06D) * this.jdField_f_of_type_Int));
            this.h = ((int)(d1 * this.jdField_f_of_type_Int));
            this.jdField_a_of_type_Boolean = true;
            this.i = ((int)(this.g * 0.383D));
            this.k = ((int)(186.05F * this.i / 150.0F));
            this.m = ((int)(222.05F * this.k / 186.0F));
            this.o = ((this.k - this.i) / 2);
            this.jdField_a_of_type_Double = ((this.h + 0.05F) / this.g);
            this.jdField_a_of_type_Double -= 0.24D;
            this.j = ((int)(this.i * this.jdField_a_of_type_Double));
            this.l = ((int)(this.k * this.jdField_a_of_type_Double));
            this.n = ((int)(this.m * this.jdField_a_of_type_Double));
            this.p = ((int)(this.o * this.jdField_a_of_type_Double));
            this.jdField_b_of_type_Double = ((this.i - this.j + 0.05F) / (this.g - this.h));
            localObject1 = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentWidgetXListView.getLayoutParams();
            localObject2 = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
            ((FrameLayout.LayoutParams)localObject1).topMargin = this.h;
            ((FrameLayout.LayoutParams)localObject2).height = this.g;
            this.jdField_a_of_type_ComTencentWidgetXListView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLayoutParams();
            localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).width = this.i;
            ((RelativeLayout.LayoutParams)localObject1).height = this.i;
            ((RelativeLayout.LayoutParams)localObject2).width = this.k;
            ((RelativeLayout.LayoutParams)localObject2).height = this.m;
            localLayoutParams.height = this.o;
            this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
            this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            ThreadManager.excute(new AvatarPendantActivity.4(this), 32, null, false);
            p();
            if (!ThemeUtil.isInNightMode(this.app)) {
              break label1320;
            }
            if (localView != null) {
              localView.setVisibility(0);
            }
          }
          label1320:
          while (localView == null)
          {
            return;
            if (this.jdField_c_of_type_Boolean)
            {
              super.findViewById(2131380365).setVisibility(8);
              this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
              this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText(anzj.a(2131699797));
              this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.b(false);
              this.g = ((int)((d2 + 0.06D) * this.jdField_f_of_type_Int));
              this.h = ((int)(d1 * this.jdField_f_of_type_Int));
              this.jdField_a_of_type_Boolean = true;
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
            this.jdField_a_of_type_Ammy = new ammy(this, this, this, ((Display)localObject1).getWidth(), this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.g - this.h);
            this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Ammy);
            break;
          }
          localView.setVisibility(8);
          return;
        }
      }
    }
  }
  
  private void k()
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("had_entered_store_face", true);
    localEditor.commit();
  }
  
  private void l()
  {
    ThreadManager.post(new AvatarPendantActivity.6(this), 5, null, true);
  }
  
  private void m()
  {
    if ((this.jdField_e_of_type_Int == jdField_a_of_type_Int) || (this.jdField_e_of_type_Int == jdField_d_of_type_Int)) {}
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = this.o;
    this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new akne();
    akne localakne1 = new akne();
    akne localakne2 = new akne();
    new akne();
    ((akne)localObject).jdField_c_of_type_Int = localLayoutParams.height;
    ((akne)localObject).jdField_d_of_type_Int = this.g;
    int i1 = localLayoutParams.topMargin;
    ((akne)localObject).jdField_b_of_type_Int = i1;
    ((akne)localObject).jdField_a_of_type_Int = i1;
    ((akne)localObject).g = ((int)(Math.abs(this.g - localLayoutParams.height) * 1.0D / this.g * ((akne)localObject).g));
    i1 = localLayoutParams1.topMargin;
    localakne1.jdField_b_of_type_Int = i1;
    localakne1.jdField_a_of_type_Int = i1;
    localakne1.jdField_e_of_type_Int = localLayoutParams1.width;
    localakne1.jdField_f_of_type_Int = this.i;
    localakne1.jdField_c_of_type_Int = localLayoutParams1.height;
    localakne1.jdField_d_of_type_Int = this.i;
    localakne1.g = ((akne)localObject).g;
    i1 = localLayoutParams2.topMargin;
    localakne2.jdField_b_of_type_Int = i1;
    localakne2.jdField_a_of_type_Int = i1;
    localakne2.jdField_e_of_type_Int = localLayoutParams2.width;
    localakne2.jdField_f_of_type_Int = this.k;
    localakne2.jdField_c_of_type_Int = localLayoutParams2.height;
    localakne2.jdField_d_of_type_Int = this.m;
    localakne2.g = ((akne)localObject).g;
    localArrayList2.add(this.jdField_c_of_type_AndroidViewView);
    localArrayList2.add(this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout);
    localArrayList2.add(this.jdField_b_of_type_AndroidWidgetImageView);
    localArrayList1.add(localObject);
    localArrayList1.add(localakne1);
    localArrayList1.add(localakne2);
    if (((akne)localObject).g <= 0)
    {
      QLog.e("AvatarPendantActivity", 2, "heigth: " + this.g + " palytime: " + ((akne)localObject).g);
      return;
    }
    a(localArrayList2, localArrayList1, ((akne)localObject).g);
  }
  
  private void n()
  {
    ThreadManager.getFileThreadHandler().post(new AvatarPendantActivity.11(this));
  }
  
  private void o()
  {
    if (!ProfileActivity.AllInOne.g(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    Object localObject = ((anyw)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
    long l1;
    long l2;
    if (localObject != null)
    {
      l1 = ((ExtensionInfo)localObject).pendantId;
      if (localObject == null) {
        break label181;
      }
      l2 = ((ExtensionInfo)localObject).pendantDiyId;
      label67:
      if ((this.jdField_a_of_type_Long == -1L) || (this.jdField_b_of_type_Long != l1) || (this.jdField_c_of_type_Long != l2)) {
        break label214;
      }
      localObject = (AvatarPendantManager)this.app.getManager(46);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!bhkt.a(this.jdField_a_of_type_Long)) {
        break label190;
      }
      ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.i);
      label150:
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!c()) {
        break label463;
      }
    }
    label181:
    label190:
    label463:
    for (int i1 = 8;; i1 = 0)
    {
      ((TextView)localObject).setVisibility(i1);
      return;
      l1 = this.jdField_b_of_type_Long;
      break;
      l2 = this.jdField_c_of_type_Long;
      break label67;
      ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 5, PendantInfo.i);
      break label150;
      label214:
      if ((localObject != null) && (((ExtensionInfo)localObject).isPendantValid()))
      {
        this.jdField_b_of_type_Long = ((ExtensionInfo)localObject).pendantId;
        this.jdField_c_of_type_Long = ((ExtensionInfo)localObject).pendantDiyId;
        AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.app.getManager(46);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (bhkt.a(((ExtensionInfo)localObject).pendantId)) {
          localAvatarPendantManager.a(((ExtensionInfo)localObject).pendantId).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.i, this.app.getCurrentAccountUin(), ((ExtensionInfo)localObject).pendantDiyId);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131717950);
          bdll.b(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "1", "", "", "");
          break;
          localAvatarPendantManager.a(((ExtensionInfo)localObject).pendantId).a(this.jdField_b_of_type_AndroidWidgetImageView, 5, PendantInfo.i, this.app.getCurrentAccountUin(), ((ExtensionInfo)localObject).pendantDiyId);
        }
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      bdll.b(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "0", "", "", "");
      break label150;
    }
  }
  
  private void p()
  {
    Object localObject = new File(bhkt.jdField_c_of_type_JavaLangString + "/widget_display_bg.jpg");
    if (((File)localObject).exists())
    {
      ColorDrawable localColorDrawable = new ColorDrawable(-16741938);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.jdField_c_of_type_AndroidViewView.getWidth();
      localURLDrawableOptions.mRequestHeight = this.jdField_c_of_type_AndroidViewView.getHeight();
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localObject = URLDrawable.getDrawable((File)localObject, localURLDrawableOptions);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  private void q()
  {
    if ((this.t != -1) && (this.s != -1))
    {
      if (this.t == this.s)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText(anzj.a(2131699787));
        this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetButton.setText(anzj.a(2131699786));
    this.jdField_b_of_type_AndroidWidgetButton.setEnabled(true);
  }
  
  private void r()
  {
    Intent localIntent = new Intent();
    int i1 = bhhz.b(this);
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("Business_Origin", 100);
    localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
    localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
    localIntent.putExtra("fromWhereClick", 11);
    PhotoUtils.a(localIntent, this, AvatarPendantActivity.class.getName(), i1, i1, 1080, 1080, bhhz.a());
    bdll.b(this.app, "CliOper", "", "", "0X8004177", "0X8004177", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
  }
  
  private void s()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {}
      for (int i1 = 1; i1 != 0; i1 = 0)
      {
        requestPermissions(new akmy(this), 0, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      r();
      return;
    }
    r();
  }
  
  public int a()
  {
    Object localObject1 = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
    int i2 = ((Rect)localObject1).top;
    int i1 = i2;
    if (i2 == 0) {}
    try
    {
      localObject1 = Class.forName("com.android.internal.R$dimen");
      Object localObject2 = ((Class)localObject1).newInstance();
      i1 = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
      i1 = super.getResources().getDimensionPixelSize(i1);
      return i1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return i2;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return i2;
    }
    catch (InstantiationException localInstantiationException)
    {
      localInstantiationException.printStackTrace();
      return i2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return i2;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return i2;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return i2;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
    return i2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new aknb(this));
  }
  
  public void a(TextView paramTextView, View paramView)
  {
    int i2 = getWindowManager().getDefaultDisplay().getWidth();
    int i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i4 = View.MeasureSpec.makeMeasureSpec(0, 0);
    paramTextView.measure(i3, i4);
    int i1 = paramTextView.getMeasuredWidth();
    paramView.measure(i3, i4);
    i3 = paramView.getMeasuredWidth();
    float f1 = super.getResources().getDisplayMetrics().density;
    i2 = i2 - i3 - (int)(55 * f1 + 0.5F);
    if (i1 > i2)
    {
      paramTextView.setMaxWidth(i2 - 10);
      paramTextView.setSingleLine(true);
      paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    }
  }
  
  public void a(PendantTipsInfo paramPendantTipsInfo, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantActivity", 2, "verifyAuth, tipsInfo = " + paramPendantTipsInfo + "result = " + paramInt);
    }
    int i1 = paramPendantTipsInfo.type;
    boolean bool = bhnv.d(this);
    if (bool) {}
    for (Object localObject = "4";; localObject = "3") {
      switch (i1)
      {
      default: 
        paramPendantTipsInfo = (PendantTipsInfo)localObject;
        if (paramLong == 0L) {
          break label491;
        }
        bdll.b(this.app, "CliOper", "", "", "0X8005FD7", "0X8005FD7", 0, 0, paramPendantTipsInfo, "", "", "");
        return;
      }
    }
    if (TextUtils.isEmpty(paramPendantTipsInfo.wording))
    {
      QLog.e("AvatarPendantActivity", 1, "verifyAuth, tipsInfo.wording is empty! type = PAYMENT");
      QQToast.a(this, 1, anzj.a(2131699788), 0).b(getTitleBarHeight());
      return;
    }
    if (paramPendantTipsInfo.vipType.equals("LTMCLUB")) {
      localObject = "0";
    }
    for (;;)
    {
      if (!isFinishing()) {
        bhlq.a(this, 230).setTitle(paramPendantTipsInfo.titleWording).setMessage(paramPendantTipsInfo.wording).setPositiveButton(paramPendantTipsInfo.rightBtnWording, new akmt(this, paramPendantTipsInfo, paramInt)).setNegativeButton(paramPendantTipsInfo.leftBtnWording, new akms(this)).show();
      }
      bdll.b(this.app, "CliOper", "", "", "0X8005FD8", "0X8005FD8", 0, 0, "", "", "", "");
      paramPendantTipsInfo = (PendantTipsInfo)localObject;
      break;
      if (paramPendantTipsInfo.equals("CJCLUBT"))
      {
        localObject = "1";
        continue;
        if (TextUtils.isEmpty(paramPendantTipsInfo.wording))
        {
          QLog.e("AvatarPendantActivity", 1, "verifyAuth, tipsInfo.wording is empty! type = JUMP_URL");
          QQToast.a(this, 1, anzj.a(2131699783), 0).b(getTitleBarHeight());
          return;
        }
        paramPendantTipsInfo = bhlq.a(this, 230).setTitle(paramPendantTipsInfo.titleWording).setMessage(paramPendantTipsInfo.wording).setPositiveButton(paramPendantTipsInfo.rightBtnWording, new akmv(this, paramPendantTipsInfo, paramInt)).setNegativeButton(paramPendantTipsInfo.leftBtnWording, new akmu(this));
        localObject = paramPendantTipsInfo.getMessageTextView();
        ViewGroup.LayoutParams localLayoutParams = ((TextView)localObject).getLayoutParams();
        localLayoutParams.width = -1;
        ((TextView)localObject).setLayoutParams(localLayoutParams);
        ((TextView)localObject).setGravity(17);
        paramPendantTipsInfo.setMessageCount(null);
        paramPendantTipsInfo.show();
        paramPendantTipsInfo = "2";
        break;
        a(paramPendantTipsInfo, false, paramInt);
        paramPendantTipsInfo = (PendantTipsInfo)localObject;
        break;
        label491:
        localObject = this.app;
        if (bool) {}
        for (paramPendantTipsInfo = "2";; paramPendantTipsInfo = "1")
        {
          bdll.b((QQAppInterface)localObject, "CliOper", "", "", "0X8006896", "0X8006896", 0, 0, paramPendantTipsInfo, "", "", "");
          return;
        }
      }
    }
  }
  
  public void a(PendantTipsInfo paramPendantTipsInfo, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("AvatarPendantActivity", 2, "openVIP, tipsInfo = " + paramPendantTipsInfo);
    }
    String str1;
    String str2;
    Object localObject;
    if (paramPendantTipsInfo.type == 1)
    {
      if (paramBoolean)
      {
        str1 = "mvip.gxh.android.faceaddon_nati_dft";
        str2 = paramPendantTipsInfo.vipType;
        if (!str2.equals("LTMCLUB")) {
          break label155;
        }
        localObject = getString(2131694534);
      }
      for (;;)
      {
        if ((paramPendantTipsInfo.vipMonth < 1) || (paramPendantTipsInfo.vipMonth > 12))
        {
          QLog.e("AvatarPendantActivity", 1, "openVIP, vipMonth invalid = " + paramPendantTipsInfo.vipMonth);
          return;
          str1 = "mvip.gxh.android.faceaddon_nati_" + this.jdField_a_of_type_Long;
          break;
          label155:
          if (str2.equals("CJCLUBT"))
          {
            localObject = getString(2131718497);
          }
          else if (str2.equals("SVHHZLH"))
          {
            localObject = getString(2131690491);
          }
          else
          {
            QLog.e("AvatarPendantActivity", 2, "openVIP, unknown vipType = " + paramPendantTipsInfo.vipType);
            return;
          }
        }
      }
      if (((paramInt != 9002) && (paramInt != 9003)) || (paramPendantTipsInfo.vipMonth != 12)) {
        break label408;
      }
      if (paramInt != 9003) {
        break label403;
      }
      bool = true;
      paramBoolean = true;
    }
    for (;;)
    {
      bhzu.a(null, this, str1, paramPendantTipsInfo.vipMonth, "1450000515", str2, (String)localObject, "", paramBoolean, bool);
      return;
      if ((paramPendantTipsInfo.type == 2) || (paramPendantTipsInfo.type == 3))
      {
        if (!TextUtils.isEmpty(paramPendantTipsInfo.url))
        {
          localObject = new Intent(this, QQBrowserActivity.class);
          VasWebviewUtil.openQQBrowserWithoutAD(this, paramPendantTipsInfo.url, -1L, (Intent)localObject, true, -1);
          return;
        }
        QLog.e("AvatarPendantActivity", 1, "openVIP, type = jump_url, but url == nul. tipsInfo = " + paramPendantTipsInfo);
        return;
      }
      QLog.e("AvatarPendantActivity", 1, "openVIP, action type is incorrect! tipsInfo = " + paramPendantTipsInfo);
      return;
      label403:
      paramBoolean = true;
      continue;
      label408:
      paramBoolean = false;
    }
  }
  
  public void a(String paramString)
  {
    int i2 = 0;
    SystemClock.uptimeMillis();
    paramString = new File(paramString);
    bhkt.a();
    if (paramString.exists()) {}
    for (;;)
    {
      int i3;
      try
      {
        Object localObject1 = bhmi.b(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = new ArrayList();
        }
        JSONArray localJSONArray;
        int i1;
        bhwh localbhwh;
        Object localObject2;
        String str;
        Object localObject3;
        i1 += 1;
      }
      catch (OutOfMemoryError paramString)
      {
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          localJSONArray = ((JSONObject)localObject1).optJSONArray("avatarInPendantTable");
          i1 = 0;
          if (i1 < localJSONArray.length())
          {
            localbhwh = new bhwh();
            localObject2 = localJSONArray.optJSONObject(i1);
            i3 = ((JSONObject)localObject2).optInt("id");
            str = ((JSONObject)localObject2).optString("type");
            localObject3 = ((JSONObject)localObject2).optJSONArray("baseInfo").optJSONObject(0);
            localObject2 = ((JSONObject)localObject3).getString("name");
            localObject3 = ((JSONObject)localObject3).optJSONObject("smallImg").optString("src");
            localbhwh.a(i3);
            localbhwh.b((String)localObject2);
            localbhwh.a(str);
            localbhwh.c((String)localObject3);
            i3 = i2;
            if (i2 < 8)
            {
              paramString.add(localbhwh);
              i3 = i2 + 1;
            }
            if (i1 >= 4) {
              break label353;
            }
            localbhwh.jdField_a_of_type_Boolean = true;
            break label353;
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("avatarInPendantCount");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
            AvatarPendantManager.jdField_a_of_type_Int = ((JSONArray)localObject1).optJSONObject(0).optInt("count");
          }
          localObject1 = (AvatarPendantManager)this.app.getManager(46);
          if (localObject1 != null)
          {
            ((AvatarPendantManager)localObject1).a(paramString);
            this.jdField_a_of_type_JavaUtilList = paramString;
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1000);
          }
          return;
        }
        catch (Exception paramString)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("AvatarPendantActivity", 2, "parse facedata shop config fail", paramString);
          return;
        }
        paramString = paramString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("AvatarPendantActivity", 2, "read config fail", paramString);
        return;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label353:
      while (i3 != 8)
      {
        i2 = i3;
        break;
      }
    }
  }
  
  public boolean a()
  {
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
    {
      ExtensionInfo localExtensionInfo = ((anyw)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((localExtensionInfo != null) && (localExtensionInfo.pendantId == this.jdField_a_of_type_Long)) {
        return true;
      }
    }
    return false;
  }
  
  public int b()
  {
    int i1 = 0;
    View localView = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    int i2 = -localView.getTop();
    this.jdField_a_of_type_AndroidUtilSparseIntArray.put(this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition(), localView.getHeight());
    if (i1 < this.jdField_a_of_type_ComTencentWidgetXListView.getFirstVisiblePosition())
    {
      if (this.jdField_a_of_type_AndroidUtilSparseIntArray.get(i1) == 0) {
        this.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        i1 += 1;
        break;
        i2 += this.jdField_a_of_type_AndroidUtilSparseIntArray.get(i1);
      }
    }
    return i2;
  }
  
  public void b()
  {
    int i1 = b();
    int i2 = i1 - this.q;
    this.q = i1;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams3 = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    if ((i2 >= 0) || ((i2 <= 0) && (this.q <= this.g - this.h))) {
      localLayoutParams.height -= i2;
    }
    if (localLayoutParams.height <= this.h)
    {
      localLayoutParams.height = this.h;
      i1 = this.j;
      localLayoutParams1.height = i1;
      localLayoutParams1.width = i1;
      localLayoutParams2.width = this.l;
      localLayoutParams2.height = this.n;
      localLayoutParams3.height = this.p;
      this.jdField_e_of_type_Int = jdField_b_of_type_Int;
      if ((this.jdField_e_of_type_Int == jdField_c_of_type_Int) && ((i2 >= 0) || ((i2 <= 0) && (this.q <= this.g - this.h))))
      {
        i1 = i2;
        if (i2 != 0)
        {
          i1 = i2;
          if (i2 != 1) {
            if (i2 != -1) {
              break label423;
            }
          }
        }
      }
    }
    label423:
    for (i1 = i2;; i1 = (int)(i2 * this.jdField_b_of_type_Double))
    {
      localLayoutParams1.width -= i1;
      localLayoutParams1.height = localLayoutParams1.width;
      localLayoutParams2.width -= (int)(i1 * 186.05F / 150.0F);
      localLayoutParams2.height = ((int)(222.05F * localLayoutParams2.width / 186.0F));
      localLayoutParams3.height = ((localLayoutParams2.width - localLayoutParams1.width) / 2);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setLayoutParams(localLayoutParams1);
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams2);
      this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams3);
      return;
      if (localLayoutParams.height >= this.g)
      {
        localLayoutParams.height = this.g;
        i1 = this.i;
        localLayoutParams1.height = i1;
        localLayoutParams1.width = i1;
        localLayoutParams2.width = this.k;
        localLayoutParams2.height = this.m;
        localLayoutParams3.height = this.o;
        this.jdField_e_of_type_Int = jdField_a_of_type_Int;
        break;
      }
      this.jdField_e_of_type_Int = jdField_c_of_type_Int;
      break;
    }
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 1383	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore 6
    //   5: new 563	java/io/File
    //   8: dup
    //   9: aload_1
    //   10: invokespecial 569	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: invokestatic 1385	bhkt:a	()V
    //   17: aload_1
    //   18: invokevirtual 572	java/io/File:exists	()Z
    //   21: ifeq +247 -> 268
    //   24: aload_1
    //   25: invokestatic 1390	bhmi:b	(Ljava/io/File;)Ljava/lang/String;
    //   28: astore 12
    //   30: aload 12
    //   32: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifne +233 -> 268
    //   38: aload_0
    //   39: getfield 222	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: bipush 46
    //   44: invokevirtual 533	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   47: checkcast 535	com/tencent/mobileqq/vas/AvatarPendantManager
    //   50: invokevirtual 587	com/tencent/mobileqq/vas/AvatarPendantManager:a	()Ljava/util/List;
    //   53: astore 11
    //   55: new 1392	org/json/JSONObject
    //   58: dup
    //   59: aload 12
    //   61: invokespecial 1393	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   64: astore 12
    //   66: aload 12
    //   68: ldc_w 1486
    //   71: invokevirtual 1490	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   74: ifeq +155 -> 229
    //   77: aload 12
    //   79: ldc_w 1486
    //   82: invokevirtual 1493	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   85: iconst_1
    //   86: if_icmpne +137 -> 223
    //   89: iconst_1
    //   90: istore 10
    //   92: iload 10
    //   94: putstatic 1494	com/tencent/mobileqq/vas/AvatarPendantManager:jdField_c_of_type_Boolean	Z
    //   97: aload 12
    //   99: ldc_w 1496
    //   102: invokevirtual 1499	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   105: astore 15
    //   107: new 1501	java/util/HashSet
    //   110: dup
    //   111: invokespecial 1502	java/util/HashSet:<init>	()V
    //   114: astore 13
    //   116: aload 15
    //   118: ldc_w 1504
    //   121: invokevirtual 1490	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   124: ifeq +200 -> 324
    //   127: aload 15
    //   129: ldc_w 1504
    //   132: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 14
    //   137: aload 14
    //   139: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifne +182 -> 324
    //   145: aload 14
    //   147: ldc_w 1506
    //   150: invokevirtual 523	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   153: astore 14
    //   155: aload 14
    //   157: arraylength
    //   158: istore_3
    //   159: iconst_0
    //   160: istore_2
    //   161: iload_2
    //   162: iload_3
    //   163: if_icmpge +161 -> 324
    //   166: aload 14
    //   168: iload_2
    //   169: aaload
    //   170: astore 16
    //   172: aload 16
    //   174: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: ifne +14 -> 191
    //   180: aload 13
    //   182: aload 16
    //   184: invokestatic 1510	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   187: invokevirtual 1511	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   190: pop
    //   191: iload_2
    //   192: iconst_1
    //   193: iadd
    //   194: istore_2
    //   195: goto -34 -> 161
    //   198: astore_1
    //   199: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +14 -> 216
    //   205: ldc_w 275
    //   208: iconst_2
    //   209: ldc_w 1460
    //   212: aload_1
    //   213: invokestatic 1463	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   216: return
    //   217: astore_1
    //   218: aload_1
    //   219: invokevirtual 1464	java/io/IOException:printStackTrace	()V
    //   222: return
    //   223: iconst_0
    //   224: istore 10
    //   226: goto -134 -> 92
    //   229: iconst_0
    //   230: putstatic 1494	com/tencent/mobileqq/vas/AvatarPendantManager:jdField_c_of_type_Boolean	Z
    //   233: goto -136 -> 97
    //   236: astore 12
    //   238: aload 11
    //   240: invokeinterface 601 1 0
    //   245: aload_1
    //   246: invokevirtual 1514	java/io/File:delete	()Z
    //   249: pop
    //   250: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +15 -> 268
    //   256: ldc_w 275
    //   259: iconst_2
    //   260: ldc_w 1516
    //   263: aload 12
    //   265: invokestatic 1463	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   268: invokestatic 1383	android/os/SystemClock:uptimeMillis	()J
    //   271: lstore 8
    //   273: invokestatic 273	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq -60 -> 216
    //   279: ldc_w 275
    //   282: iconst_2
    //   283: new 277	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   290: ldc_w 1518
    //   293: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: lload 8
    //   298: lload 6
    //   300: lsub
    //   301: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   304: ldc_w 1520
    //   307: invokevirtual 284	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_1
    //   311: invokevirtual 1522	java/io/File:length	()J
    //   314: invokevirtual 440	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   317: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 290	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: return
    //   324: new 1501	java/util/HashSet
    //   327: dup
    //   328: invokespecial 1502	java/util/HashSet:<init>	()V
    //   331: astore 14
    //   333: aload 15
    //   335: ldc_w 1524
    //   338: invokevirtual 1490	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   341: ifeq +70 -> 411
    //   344: aload 15
    //   346: ldc_w 1524
    //   349: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   352: astore 16
    //   354: aload 16
    //   356: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   359: ifne +52 -> 411
    //   362: aload 16
    //   364: ldc_w 1506
    //   367: invokevirtual 523	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   370: astore 16
    //   372: aload 16
    //   374: arraylength
    //   375: istore_3
    //   376: iconst_0
    //   377: istore_2
    //   378: iload_2
    //   379: iload_3
    //   380: if_icmpge +31 -> 411
    //   383: aload 16
    //   385: iload_2
    //   386: aaload
    //   387: astore 17
    //   389: aload 17
    //   391: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   394: ifne +933 -> 1327
    //   397: aload 14
    //   399: aload 17
    //   401: invokestatic 1510	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   404: invokevirtual 1511	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   407: pop
    //   408: goto +919 -> 1327
    //   411: new 1501	java/util/HashSet
    //   414: dup
    //   415: invokespecial 1502	java/util/HashSet:<init>	()V
    //   418: astore 16
    //   420: aload 15
    //   422: ldc_w 1526
    //   425: invokevirtual 1490	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   428: ifeq +70 -> 498
    //   431: aload 15
    //   433: ldc_w 1526
    //   436: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   439: astore 15
    //   441: aload 15
    //   443: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   446: ifne +52 -> 498
    //   449: aload 15
    //   451: ldc_w 1506
    //   454: invokevirtual 523	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   457: astore 15
    //   459: aload 15
    //   461: arraylength
    //   462: istore_3
    //   463: iconst_0
    //   464: istore_2
    //   465: iload_2
    //   466: iload_3
    //   467: if_icmpge +31 -> 498
    //   470: aload 15
    //   472: iload_2
    //   473: aaload
    //   474: astore 17
    //   476: aload 17
    //   478: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   481: ifne +853 -> 1334
    //   484: aload 16
    //   486: aload 17
    //   488: invokestatic 1510	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   491: invokevirtual 1511	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   494: pop
    //   495: goto +839 -> 1334
    //   498: new 1528	android/util/SparseArray
    //   501: dup
    //   502: invokespecial 1529	android/util/SparseArray:<init>	()V
    //   505: astore 15
    //   507: aload 12
    //   509: ldc_w 1531
    //   512: invokevirtual 1499	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   515: astore 17
    //   517: aload 17
    //   519: invokevirtual 1535	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   522: astore 18
    //   524: aload 18
    //   526: invokeinterface 1540 1 0
    //   531: ifeq +378 -> 909
    //   534: aload 18
    //   536: invokeinterface 1543 1 0
    //   541: invokevirtual 1138	java/lang/Object:toString	()Ljava/lang/String;
    //   544: astore 19
    //   546: aload 19
    //   548: ifnull -24 -> 524
    //   551: aload 17
    //   553: aload 19
    //   555: invokevirtual 1499	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   558: astore 20
    //   560: aload 20
    //   562: ldc_w 1545
    //   565: invokevirtual 1499	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   568: astore 21
    //   570: aload 21
    //   572: ldc_w 1547
    //   575: invokevirtual 1493	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   578: ifeq -54 -> 524
    //   581: aload 21
    //   583: ldc_w 1549
    //   586: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   589: invokestatic 1553	com/tencent/common/config/AppSetting:a	(Ljava/lang/String;)I
    //   592: iflt -68 -> 524
    //   595: new 1555	bhwi
    //   598: dup
    //   599: invokespecial 1556	bhwi:<init>	()V
    //   602: astore 19
    //   604: aload 19
    //   606: aload 21
    //   608: ldc_w 1558
    //   611: invokevirtual 1493	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   614: putfield 1559	bhwi:jdField_c_of_type_Int	I
    //   617: aload 19
    //   619: aload 21
    //   621: ldc_w 1561
    //   624: invokevirtual 1493	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   627: putfield 1562	bhwi:jdField_d_of_type_Int	I
    //   630: aload 19
    //   632: aload 21
    //   634: ldc_w 1564
    //   637: invokevirtual 1568	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   640: putfield 1569	bhwi:jdField_a_of_type_Long	J
    //   643: aload 19
    //   645: aload 21
    //   647: ldc_w 1571
    //   650: invokevirtual 1568	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   653: putfield 1572	bhwi:jdField_b_of_type_Long	J
    //   656: aload 20
    //   658: ldc_w 1423
    //   661: invokevirtual 1499	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   664: astore 20
    //   666: aload 19
    //   668: aload 20
    //   670: ldc_w 1417
    //   673: invokevirtual 1493	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   676: putfield 1573	bhwi:jdField_b_of_type_Int	I
    //   679: aload 19
    //   681: aload 20
    //   683: ldc_w 1424
    //   686: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   689: putfield 1574	bhwi:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   692: aload 19
    //   694: aload 20
    //   696: ldc_w 1576
    //   699: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   702: putfield 1577	bhwi:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   705: aload 19
    //   707: aload 20
    //   709: ldc_w 1413
    //   712: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   715: invokestatic 1510	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   718: invokevirtual 1580	java/lang/Integer:intValue	()I
    //   721: putfield 1581	bhwi:jdField_a_of_type_Int	I
    //   724: aload 20
    //   726: ldc_w 1583
    //   729: invokevirtual 1493	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   732: iconst_1
    //   733: if_icmpne +608 -> 1341
    //   736: iconst_1
    //   737: istore 10
    //   739: aload 19
    //   741: iload 10
    //   743: putfield 1584	bhwi:jdField_a_of_type_Boolean	Z
    //   746: aload 19
    //   748: aload 20
    //   750: ldc_w 1586
    //   753: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   756: putfield 1587	bhwi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   759: aload 13
    //   761: aload 19
    //   763: getfield 1581	bhwi:jdField_a_of_type_Int	I
    //   766: invokestatic 1590	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   769: invokevirtual 1593	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   772: ifeq +91 -> 863
    //   775: aload 19
    //   777: bipush 7
    //   779: putfield 1594	bhwi:jdField_e_of_type_Int	I
    //   782: invokestatic 1599	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   785: lstore 8
    //   787: aload 19
    //   789: getfield 1559	bhwi:jdField_c_of_type_Int	I
    //   792: iconst_1
    //   793: if_icmpne +96 -> 889
    //   796: aload 19
    //   798: getfield 1569	bhwi:jdField_a_of_type_Long	J
    //   801: lload 8
    //   803: lcmp
    //   804: ifgt +85 -> 889
    //   807: lload 8
    //   809: aload 19
    //   811: getfield 1572	bhwi:jdField_b_of_type_Long	J
    //   814: lcmp
    //   815: ifgt +74 -> 889
    //   818: aload 19
    //   820: bipush 10
    //   822: putfield 1600	bhwi:jdField_f_of_type_Int	I
    //   825: aload 16
    //   827: aload 19
    //   829: getfield 1581	bhwi:jdField_a_of_type_Int	I
    //   832: invokestatic 1590	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   835: invokevirtual 1593	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   838: ifeq +10 -> 848
    //   841: aload 19
    //   843: bipush 9
    //   845: putfield 1600	bhwi:jdField_f_of_type_Int	I
    //   848: aload 15
    //   850: aload 19
    //   852: getfield 1581	bhwi:jdField_a_of_type_Int	I
    //   855: aload 19
    //   857: invokevirtual 1603	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   860: goto -336 -> 524
    //   863: aload 14
    //   865: aload 19
    //   867: getfield 1581	bhwi:jdField_a_of_type_Int	I
    //   870: invokestatic 1590	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   873: invokevirtual 1593	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   876: ifeq -94 -> 782
    //   879: aload 19
    //   881: bipush 8
    //   883: putfield 1594	bhwi:jdField_e_of_type_Int	I
    //   886: goto -104 -> 782
    //   889: aload 19
    //   891: getfield 1559	bhwi:jdField_c_of_type_Int	I
    //   894: bipush 6
    //   896: if_icmpne -71 -> 825
    //   899: aload 19
    //   901: bipush 6
    //   903: putfield 1600	bhwi:jdField_f_of_type_Int	I
    //   906: goto -81 -> 825
    //   909: aload 11
    //   911: invokeinterface 601 1 0
    //   916: aload 12
    //   918: ldc_w 1605
    //   921: invokevirtual 1608	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   924: astore 13
    //   926: aload 13
    //   928: invokevirtual 1404	org/json/JSONArray:length	()I
    //   931: istore 4
    //   933: iconst_0
    //   934: istore_2
    //   935: iload_2
    //   936: iload 4
    //   938: if_icmpge +336 -> 1274
    //   941: aload 13
    //   943: iload_2
    //   944: invokevirtual 1611	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   947: checkcast 1392	org/json/JSONObject
    //   950: astore 14
    //   952: aload 14
    //   954: ldc_w 1547
    //   957: invokevirtual 1493	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   960: ifne +6 -> 966
    //   963: goto +384 -> 1347
    //   966: aload 14
    //   968: ldc_w 1613
    //   971: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   974: astore 17
    //   976: aload 17
    //   978: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   981: ifne +366 -> 1347
    //   984: aload 14
    //   986: ldc_w 1615
    //   989: invokevirtual 1493	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   992: bipush 100
    //   994: if_icmpge +353 -> 1347
    //   997: new 1617	bhwj
    //   1000: dup
    //   1001: invokespecial 1618	bhwj:<init>	()V
    //   1004: astore 16
    //   1006: aload 16
    //   1008: new 920	java/util/ArrayList
    //   1011: dup
    //   1012: invokespecial 921	java/util/ArrayList:<init>	()V
    //   1015: putfield 1619	bhwj:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1018: aload 17
    //   1020: ldc_w 1506
    //   1023: invokevirtual 523	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1026: astore 17
    //   1028: aload 17
    //   1030: arraylength
    //   1031: istore 5
    //   1033: iconst_0
    //   1034: istore_3
    //   1035: iload_3
    //   1036: iload 5
    //   1038: if_icmpge +56 -> 1094
    //   1041: aload 17
    //   1043: iload_3
    //   1044: aaload
    //   1045: astore 18
    //   1047: aload 18
    //   1049: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1052: ifne +302 -> 1354
    //   1055: aload 15
    //   1057: aload 18
    //   1059: invokestatic 1510	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1062: invokevirtual 1580	java/lang/Integer:intValue	()I
    //   1065: invokevirtual 1620	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1068: checkcast 1555	bhwi
    //   1071: astore 18
    //   1073: aload 18
    //   1075: ifnull +279 -> 1354
    //   1078: aload 16
    //   1080: getfield 1619	bhwj:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1083: aload 18
    //   1085: invokeinterface 937 2 0
    //   1090: pop
    //   1091: goto +263 -> 1354
    //   1094: aload 16
    //   1096: getfield 1619	bhwj:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1099: invokeinterface 239 1 0
    //   1104: ifle +243 -> 1347
    //   1107: aload 16
    //   1109: aload 14
    //   1111: ldc_w 1615
    //   1114: invokevirtual 1493	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1117: putfield 1621	bhwj:jdField_a_of_type_Int	I
    //   1120: aload 16
    //   1122: aload 14
    //   1124: ldc_w 1623
    //   1127: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1130: putfield 1624	bhwj:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   1133: aload 14
    //   1135: ldc_w 1626
    //   1138: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1141: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1144: ifne +121 -> 1265
    //   1147: aload 16
    //   1149: aload 14
    //   1151: ldc_w 1626
    //   1154: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1157: invokestatic 1510	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1160: invokevirtual 1580	java/lang/Integer:intValue	()I
    //   1163: putfield 1627	bhwj:jdField_b_of_type_Int	I
    //   1166: aload 16
    //   1168: aload 14
    //   1170: ldc_w 1586
    //   1173: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1176: putfield 1629	bhwj:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   1179: aload 16
    //   1181: aload 14
    //   1183: ldc_w 1631
    //   1186: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1189: putfield 1633	bhwj:e	Ljava/lang/String;
    //   1192: aload 16
    //   1194: aload 14
    //   1196: ldc_w 1635
    //   1199: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1202: putfield 1636	bhwj:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1205: aload 16
    //   1207: aload 14
    //   1209: ldc_w 1424
    //   1212: invokevirtual 1426	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1215: putfield 1637	bhwj:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1218: aload 16
    //   1220: iconst_m1
    //   1221: putfield 1638	bhwj:jdField_c_of_type_Int	I
    //   1224: aload 16
    //   1226: getfield 1633	bhwj:e	Ljava/lang/String;
    //   1229: ifnull +23 -> 1252
    //   1232: aload 16
    //   1234: getfield 1633	bhwj:e	Ljava/lang/String;
    //   1237: ldc_w 703
    //   1240: invokevirtual 1246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1243: ifne +9 -> 1252
    //   1246: aload 16
    //   1248: iconst_1
    //   1249: putfield 1639	bhwj:jdField_a_of_type_Boolean	Z
    //   1252: aload 11
    //   1254: aload 16
    //   1256: invokeinterface 937 2 0
    //   1261: pop
    //   1262: goto +85 -> 1347
    //   1265: aload 16
    //   1267: iconst_0
    //   1268: putfield 1627	bhwj:jdField_b_of_type_Int	I
    //   1271: goto -105 -> 1166
    //   1274: aload 12
    //   1276: invokestatic 1644	akng:a	(Lorg/json/JSONObject;)V
    //   1279: aload_0
    //   1280: getfield 1452	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1283: sipush 1000
    //   1286: invokevirtual 1458	android/os/Handler:sendEmptyMessage	(I)Z
    //   1289: pop
    //   1290: aload_0
    //   1291: getfield 222	com/tencent/mobileqq/activity/pendant/AvatarPendantActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1294: invokevirtual 346	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1297: getstatic 590	bhwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1300: iconst_0
    //   1301: invokevirtual 352	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1304: invokeinterface 364 1 0
    //   1309: getstatic 590	bhwl:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1312: iconst_0
    //   1313: invokeinterface 368 3 0
    //   1318: invokeinterface 371 1 0
    //   1323: pop
    //   1324: goto -1056 -> 268
    //   1327: iload_2
    //   1328: iconst_1
    //   1329: iadd
    //   1330: istore_2
    //   1331: goto -953 -> 378
    //   1334: iload_2
    //   1335: iconst_1
    //   1336: iadd
    //   1337: istore_2
    //   1338: goto -873 -> 465
    //   1341: iconst_0
    //   1342: istore 10
    //   1344: goto -605 -> 739
    //   1347: iload_2
    //   1348: iconst_1
    //   1349: iadd
    //   1350: istore_2
    //   1351: goto -416 -> 935
    //   1354: iload_3
    //   1355: iconst_1
    //   1356: iadd
    //   1357: istore_3
    //   1358: goto -323 -> 1035
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1361	0	this	AvatarPendantActivity
    //   0	1361	1	paramString	String
    //   160	1191	2	i1	int
    //   158	1200	3	i2	int
    //   931	8	4	i3	int
    //   1031	8	5	i4	int
    //   3	296	6	l1	long
    //   271	537	8	l2	long
    //   90	1253	10	bool	boolean
    //   53	1200	11	localList	List
    //   28	70	12	localObject1	Object
    //   236	1039	12	localException	Exception
    //   114	828	13	localObject2	Object
    //   135	1073	14	localObject3	Object
    //   105	951	15	localObject4	Object
    //   170	1096	16	localObject5	Object
    //   387	655	17	localObject6	Object
    //   522	562	18	localObject7	Object
    //   544	356	19	localObject8	Object
    //   558	191	20	localJSONObject1	JSONObject
    //   568	78	21	localJSONObject2	JSONObject
    // Exception table:
    //   from	to	target	type
    //   24	30	198	java/lang/OutOfMemoryError
    //   24	30	217	java/io/IOException
    //   55	89	236	java/lang/Exception
    //   92	97	236	java/lang/Exception
    //   97	159	236	java/lang/Exception
    //   172	191	236	java/lang/Exception
    //   229	233	236	java/lang/Exception
    //   324	376	236	java/lang/Exception
    //   389	408	236	java/lang/Exception
    //   411	463	236	java/lang/Exception
    //   476	495	236	java/lang/Exception
    //   498	524	236	java/lang/Exception
    //   524	546	236	java/lang/Exception
    //   551	736	236	java/lang/Exception
    //   739	782	236	java/lang/Exception
    //   782	825	236	java/lang/Exception
    //   825	848	236	java/lang/Exception
    //   848	860	236	java/lang/Exception
    //   863	886	236	java/lang/Exception
    //   889	906	236	java/lang/Exception
    //   909	933	236	java/lang/Exception
    //   941	963	236	java/lang/Exception
    //   966	1033	236	java/lang/Exception
    //   1047	1073	236	java/lang/Exception
    //   1078	1091	236	java/lang/Exception
    //   1094	1166	236	java/lang/Exception
    //   1166	1252	236	java/lang/Exception
    //   1252	1262	236	java/lang/Exception
    //   1265	1271	236	java/lang/Exception
    //   1274	1324	236	java/lang/Exception
  }
  
  public boolean b()
  {
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
    {
      ExtensionInfo localExtensionInfo = ((anyw)this.app.getManager(51)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
      if ((localExtensionInfo != null) && (localExtensionInfo.faceId == this.s)) {
        return true;
      }
    }
    return false;
  }
  
  public void c()
  {
    ImageView localImageView = (ImageView)super.findViewById(2131380366);
    TextView localTextView = (TextView)super.findViewById(2131380367);
    Button localButton = (Button)super.findViewById(2131380364);
    String str2 = this.app.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("uniPaySp_" + str2, 0);
    String str3 = localSharedPreferences.getString("sUin", "");
    int i1 = localSharedPreferences.getInt("isShowOpen", 0);
    int i2 = localSharedPreferences.getInt("iUinpPayType", 0);
    Object localObject3 = "LTMCLUB";
    String str1 = "QQ会员";
    String str4 = super.getString(2131716131);
    Object localObject2 = str1;
    Object localObject1 = localObject3;
    if (str3 != null)
    {
      localObject2 = str1;
      localObject1 = localObject3;
      if (str2 != null)
      {
        localObject2 = str1;
        localObject1 = localObject3;
        if (str3.equals(str2))
        {
          if (1 == i1)
          {
            localImageView.setVisibility(0);
            localTextView.setVisibility(0);
            localButton.setVisibility(0);
          }
          switch (i2)
          {
          default: 
            localObject1 = "QQ会员";
            localObject2 = "LTMCLUB";
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "UniPayUpdateListener back showTitleBtn isShowOpen:" + i1);
      }
      a(localTextView, localButton);
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localButton.setOnClickListener(new akml(this, Integer.valueOf(localSharedPreferences.getString("open_month", "3")).intValue(), (String)localObject1, (String)localObject2));
      return;
      localButton.setText(2131692976);
      localTextView.setText(super.getString(2131690476, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130842564));
      localObject1 = "QQ会员";
      localObject2 = "LTMCLUB";
      continue;
      localButton.setText(2131692977);
      localTextView.setText(super.getString(2131690477, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843890));
      localObject1 = "QQ会员";
      localObject2 = "LTMCLUB";
      continue;
      localButton.setText(2131692976);
      localTextView.setText(super.getString(2131690473, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130842564));
      localObject2 = "CJCLUBT";
      localObject1 = anzj.a(2131699795);
      continue;
      localButton.setText(2131692977);
      localTextView.setText(super.getString(2131690474, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843264));
      localObject2 = "CJCLUBT";
      localObject1 = anzj.a(2131699782);
      continue;
      localButton.setText(2131692977);
      localTextView.setText(super.getString(2131690478, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843891));
      localObject2 = "CJCLUBT";
      localObject1 = anzj.a(2131699800);
      continue;
      localButton.setText(2131692978);
      localTextView.setText(super.getString(2131690479, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843891));
      localObject2 = "CJCLUBT";
      localObject1 = anzj.a(2131699792);
      continue;
      localButton.setText(2131692978);
      localTextView.setText(super.getString(2131690475, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843264));
      localObject2 = "CJCLUBT";
      localObject1 = anzj.a(2131699780);
      continue;
      localButton.setText(2131692977);
      localTextView.setText(super.getString(2131690480, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843892));
      localObject2 = "LTMCLUB";
      localObject1 = "QQ会员";
      continue;
      localButton.setText(2131692978);
      localTextView.setText(super.getString(2131690481, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130843892));
      localObject2 = "LTMCLUB";
      localObject1 = "QQ会员";
    }
  }
  
  public void d()
  {
    int i1 = bhsi.af(this, this.app.getCurrentAccountUin());
    boolean bool;
    Object localObject;
    String[] arrayOfString;
    if ((i1 == 2) || (i1 == -1))
    {
      bool = true;
      localObject = (blir)blji.a(this, null);
      arrayOfString = super.getResources().getStringArray(2130968636);
      if (!bool) {
        break label214;
      }
      ((blir)localObject).c(arrayOfString[27]);
    }
    for (;;)
    {
      ((blir)localObject).c(arrayOfString[22]);
      ((blir)localObject).c(arrayOfString[24]);
      ((blir)localObject).c(arrayOfString[13]);
      ((blir)localObject).d(arrayOfString[16]);
      ((blir)localObject).a(new akmn(this, bool, (blir)localObject));
      try
      {
        if (!isFinishing())
        {
          ((blir)localObject).show();
          localObject = ((blir)localObject).findViewById(0);
          if (localObject != null) {
            ((View)localObject).setContentDescription(anzj.a(2131699790));
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label214:
          localException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "showActionSheet, historyHeadNumFlag=" + i1);
      }
      bdll.b(this.app, "dc00898", "", "", "0X800A8C8", "0X800A8C8", 0, 0, "", "", "", "");
      return;
      bool = false;
      break;
      ((blir)localObject).c(arrayOfString[23]);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    if (paramInt1 == 4) {
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("callbackSn");
        if ((str != null) && (str.startsWith("pendantNativeVip"))) {
          break label35;
        }
      }
    }
    label35:
    label212:
    label226:
    do
    {
      do
      {
        return;
        paramIntent = paramIntent.getStringExtra("result");
        paramInt2 = -1;
        int i2 = -1;
        for (;;)
        {
          try
          {
            paramIntent = new JSONObject(paramIntent);
            paramInt1 = i2;
          }
          catch (JSONException localJSONException1)
          {
            try
            {
              i1 = Integer.parseInt(paramIntent.getString("resultCode"));
              paramInt1 = i2;
              paramInt2 = i1;
              i2 = Integer.parseInt(paramIntent.getString("payState"));
              paramInt1 = i2;
              paramInt2 = i1;
              int i3 = Integer.parseInt(paramIntent.getString("provideState"));
              paramInt1 = i3;
              paramInt2 = i1;
              i1 = paramInt1;
              if ((paramIntent == null) || (paramInt2 != 0) || (i2 != 0) || (i1 != 0)) {
                break;
              }
              if (this.jdField_a_of_type_Aokc != null) {
                this.jdField_a_of_type_Aokc.a("");
              }
              if (!str.equals("pendantNativeVipDefault")) {
                break label226;
              }
              bdll.b(this.app, "CliOper", "", "", "0X8005FDF", "0X8005FDF", 0, 0, "", "", "", "");
              this.jdField_d_of_type_Boolean = true;
              return;
            }
            catch (JSONException localJSONException2)
            {
              int i1;
              Intent localIntent;
              break label212;
            }
            localJSONException1 = localJSONException1;
            paramIntent = null;
            paramInt1 = i2;
          }
          localJSONException1.printStackTrace();
          i1 = -1;
          i2 = paramInt1;
          continue;
          bdll.b(this.app, "CliOper", "", "", "0X8005FDF", "0X8005FDF", 0, 0, str.substring(16, str.length()), "", "", "");
        }
        if (paramInt1 != 1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicAvatar", 2, "record dynamic avatar! resultCode:" + paramInt2);
        }
      } while (paramInt2 != -1);
      n();
      return;
    } while (paramInt2 != -1);
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramIntent = bhmq.b(this, this.jdField_a_of_type_AndroidNetUri);
    paramInt1 = bhhz.b(this);
    localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 100);
    localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
    localIntent.putExtra("fromWhereClick", 10);
    localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
    PhotoUtils.a(localIntent, this, AvatarPendantActivity.class.getName(), paramInt1, paramInt1, 1080, 1080, paramIntent, bhhz.a());
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentViewNoTitle(2131561958);
    getWindow().setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
    this.jdField_a_of_type_Aogu = ((aogu)this.app.a(13));
    paramBundle = super.getIntent();
    boolean bool2;
    boolean bool1;
    if (paramBundle.getParcelableExtra("AllInOne") != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)paramBundle.getParcelableExtra("AllInOne"));
      bool2 = paramBundle.getBooleanExtra("showActionSheet", false);
      c();
      this.jdField_a_of_type_Aokc = ((aokc)this.app.a(44));
      this.jdField_a_of_type_Aokc.a(this.jdField_a_of_type_Aokd);
      super.addObserver(this.jdField_a_of_type_Bhzs);
      this.jdField_a_of_type_Aokc.a("");
      if ((!bhnv.d(this)) && (QLog.isColorLevel())) {
        QLog.d("AvatarPendantActivity", 2, "net is not connected");
      }
      this.jdField_b_of_type_Boolean = bhjr.a();
      if (bhjr.a() >= 1024L) {
        break label456;
      }
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_a_of_type_JavaLangString = (this.app.getApplication().getApplicationContext().getFilesDir() + File.separator + "pendant_market.json");
      this.jdField_b_of_type_JavaLangString = (this.app.getApplication().getApplicationContext().getFilesDir() + File.separator + "avatarInPendant.json");
      j();
      h();
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
        break label461;
      }
      a();
      i();
    }
    for (;;)
    {
      if (bool2) {
        d();
      }
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = getSharedPreferences("facechoosedata", 0).edit();
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("ChooseFaceId", 0);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      this.app.addObserver(this.jdField_a_of_type_Anyu);
      this.app.registObserver(this.jdField_a_of_type_Ayxl);
      this.app.addObserver(this.jdField_a_of_type_Aogx);
      this.jdField_d_of_type_JavaLangString = bhyk.a("vasClassProfileStoryUrl");
      if (paramBundle.getBooleanExtra("fromThirdApp", false)) {
        ThreadManager.getUIHandler().postDelayed(new AvatarPendantActivity.2(this), 500L);
      }
      addObserver(this.jdField_a_of_type_Anuw);
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "AllinOne info is null");
      }
      finish();
      return true;
      label456:
      bool1 = false;
      break;
      label461:
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "sdcard exist:" + this.jdField_b_of_type_Boolean + " sdcard full:" + this.jdField_c_of_type_Boolean);
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Aokc != null) {
      this.jdField_a_of_type_Aokc.b(this.jdField_a_of_type_Aokd);
    }
    if (this.app != null) {
      this.app.unRegistObserver(this.jdField_a_of_type_Ayxl);
    }
    super.removeObserver(this.jdField_a_of_type_Bhzs);
    if (this.jdField_a_of_type_Bhwj != null) {
      this.jdField_a_of_type_Bhwj.jdField_c_of_type_Int = -1;
    }
    if ((this.app != null) && (this.jdField_a_of_type_Long != 0L)) {
      ((AvatarPendantManager)this.app.getManager(46)).a(this.jdField_a_of_type_Long).b();
    }
    if (this.jdField_a_of_type_Ammy != null)
    {
      this.jdField_a_of_type_Ammy.a();
      URLDrawable.resume();
    }
    if (this.app != null)
    {
      ((VasQuickUpdateManager)this.app.getManager(184)).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      this.app.removeObserver(this.jdField_a_of_type_Anyu);
      this.app.removeObserver(this.jdField_a_of_type_Aogx);
    }
    removeObserver(this.jdField_a_of_type_Anuw);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (str != null)
    {
      if (!bhhz.a(this.app, str, paramIntent)) {
        break label159;
      }
      q();
      this.jdField_f_of_type_Boolean = true;
      n();
      a(true);
      switch (paramIntent.getIntExtra("fromWhereClick", -1))
      {
      }
    }
    for (;;)
    {
      o();
      return;
      bdll.b(this.app, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 1, 0, "1", "", "", "");
      continue;
      bdll.b(this.app, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 0, 0, "0", "", "", "");
      continue;
      label159:
      QQToast.a(this, 1, 2131717917, 0).b(getTitleBarHeight());
    }
  }
  
  public void doOnPause()
  {
    ApngImage.pauseAll();
    AbstractVideoImage.pauseAll();
    ((AvatarPendantManager)this.app.getManager(46)).c();
  }
  
  public void doOnResume()
  {
    int i1 = 0;
    super.doOnResume();
    ApngImage.playByTag(10);
    AbstractVideoImage.resumeAll();
    if ((this.mSystemBarComp == null) && (this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      this.mSystemBarComp = new SystemBarCompact(this, true, Color.parseColor("#0089ce"));
      this.mSystemBarComp.init();
    }
    VasWebviewUtil.reportCommercialDrainage(this.app.c(), "widget", "head_show", "", 1, 0, 0, "", "", "");
    Object localObject = (AvatarPendantManager)this.app.getManager(46);
    if (localObject != null)
    {
      List localList = ((AvatarPendantManager)localObject).a();
      this.jdField_a_of_type_JavaUtilList = ((AvatarPendantManager)localObject).b();
      if ((this.jdField_a_of_type_Ammy != null) && (localList != null) && (localList.size() > 0)) {
        this.jdField_a_of_type_Ammy.a(localList, this.jdField_a_of_type_JavaUtilList);
      }
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (d()) {
      i1 = 8;
    }
    ((TextView)localObject).setVisibility(i1);
    o();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public void e()
  {
    ThreadManager.getFileThreadHandler().post(new AvatarPendantActivity.ConfigParser(this.jdField_a_of_type_JavaLangString, this));
  }
  
  public void f()
  {
    ThreadManager.getFileThreadHandler().post(new AvatarPendantActivity.ConfacefigParser(this.jdField_b_of_type_JavaLangString, this));
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      ((AvatarPendantManager)this.app.getManager(46)).a(this.jdField_a_of_type_Long).b();
    }
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    DynamicAvatarRecordActivity.a(this, 1, 1);
    bdll.b(this.app, "dc00898", "", "", "0X8007100", "0X8007100", 0, 0, "", "", "", "");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (isFinishing()) {}
    while (paramMessage.what != 1000) {
      return true;
    }
    runOnUiThread(new AvatarPendantActivity.15(this, ((AvatarPendantManager)this.app.getManager(46)).a()));
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject;
      int i1;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131366241: 
      case 2131366242: 
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.jdField_d_of_type_JavaLangString);
        startActivity((Intent)localObject);
        VasWebviewUtil.reportCommercialDrainage(this.app.c(), "widget", "head_more", "", 1, 0, 0, "", "", "");
        break;
      case 2131369042: 
        finish();
        break;
      case 2131366265: 
        ((bbav)this.app.getManager(36)).b("100100.100125.100127");
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("individuation_url_type", 40100);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject).putExtra("hide_left_button", false);
        ((Intent)localObject).putExtra("show_right_close_button", false);
        ((Intent)localObject).putExtra("url", bhyk.a(this, "faceEntryUrl", ""));
        ((Intent)localObject).putExtra("business", 512L);
        ((Intent)localObject).putExtra("isShowAd", false);
        startActivity((Intent)localObject);
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "face", "0X80088EC", "", 1, 0, 0, null, "", "");
        k();
        break;
      case 2131369050: 
        localObject = new Intent(this, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("individuation_url_type", 40100);
        ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
        ((Intent)localObject).putExtra("hide_left_button", false);
        ((Intent)localObject).putExtra("show_right_close_button", false);
        ((Intent)localObject).putExtra("url", bhyk.a(this, "myPendantUrl", ""));
        ((Intent)localObject).putExtra("business", 512L);
        ((Intent)localObject).putExtra("isShowAd", false);
        startActivity((Intent)localObject);
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "faceAddon", "0X8008A05", "", 1, 0, 0, null, "", "");
        break;
      case 2131377013: 
        if (!bhnv.d(this)) {
          QQToast.a(this, 2131717464, 0).b(getTitleBarHeight());
        } else if (this.jdField_a_of_type_Bhwj != null) {
          if (bdgb.b())
          {
            localObject = bhlq.a(this, 0, null, anzj.a(2131699799), null, anzj.a(2131699784), new akmm(this), null);
            if (!((bhpc)localObject).isShowing()) {
              ((bhpc)localObject).show();
            }
          }
          else
          {
            if (!a()) {
              ((VasExtensionHandler)this.app.a(71)).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Bhwj.jdField_a_of_type_Int, -1);
            }
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "faceAddon", "0X80088EE", "", 1, 0, 0, null, "", "");
            bdll.b(this.app, "CliOper", "", "", "0X8005FDB", "0X8005FDB", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
          }
        }
        break;
      case 2131377009: 
        if (!bhnv.d(this))
        {
          QQToast.a(this, 2131717464, 0).b(getTitleBarHeight());
        }
        else if (!b())
        {
          this.jdField_f_of_type_Boolean = false;
          this.jdField_a_of_type_Aogu.i(this.s);
          VasWebviewUtil.reportCommercialDrainage(this.app.c(), "widget", "head_setresult", "", 1, this.r, 0, "", this.s + "", "");
          this.t = this.s;
          this.jdField_b_of_type_AndroidWidgetButton.setText(anzj.a(2131699793));
          this.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("mSelectFaceId", this.s);
          this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
          localObject = ((AvatarPendantManager)this.app.getManager(46)).a();
          this.jdField_a_of_type_Ammy.a((List)localObject, this.jdField_a_of_type_JavaUtilList);
        }
        break;
      case 2131380372: 
        if (bhhz.a()) {
          QQToast.a(this, 1, 2131719130, 0).b(getTitleBarHeight());
        }
        for (;;)
        {
          bdll.b(this.app, "CliOper", "", "", "0X8004174", "0X8004174", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
          break;
          d();
        }
      case 2131372378: 
      case 2131372379: 
        if (paramView.getTag() != null)
        {
          long l1 = ((Integer)paramView.getTag()).intValue();
          localObject = ((AvatarPendantManager)this.app.getManager(46)).a();
          i1 = 0;
          if (i1 < ((List)localObject).size())
          {
            bhwj localbhwj = (bhwj)((List)localObject).get(i1);
            if ((localbhwj != null) && (localbhwj.jdField_a_of_type_Int == l1)) {
              if (localbhwj.jdField_a_of_type_Boolean) {
                break label1045;
              }
            }
            for (boolean bool = true;; bool = false)
            {
              localbhwj.jdField_a_of_type_Boolean = bool;
              i1 += 1;
              break;
            }
          }
          this.jdField_a_of_type_Ammy.a((List)localObject, this.jdField_a_of_type_JavaUtilList);
        }
        break;
      case 2131380374: 
        label1045:
        i1 = ((FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).height;
        if ((this.jdField_a_of_type_Ammy != null) && (i1 != this.g)) {
          m();
        }
        break;
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject;
    int i1;
    label245:
    int i2;
    label439:
    int i3;
    label645:
    label657:
    label681:
    int i4;
    int i5;
    if (paramAdapterView.getId() == 2131372374)
    {
      if (((paramAdapterView instanceof GridView)) && (paramAdapterView.getTag() != null) && (paramView != null) && (paramView.getTag() != null))
      {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 640, true, true, true, false, 7);
        g();
        this.jdField_a_of_type_Bhwi = ((bhwi)((amne)paramView.getTag()).a.getTag());
        this.jdField_a_of_type_Long = this.jdField_a_of_type_Bhwi.jdField_a_of_type_Int;
        localObject = (AvatarPendantManager)this.app.getManager(46);
        List localList = ((AvatarPendantManager)localObject).a();
        bhwj localbhwj1 = this.jdField_a_of_type_Bhwj;
        bhwj localbhwj2 = (bhwj)paramAdapterView.getTag();
        i1 = 0;
        if (i1 < localList.size())
        {
          bhwj localbhwj3 = (bhwj)localList.get(i1);
          if (localbhwj3 != null)
          {
            if (localbhwj3.jdField_a_of_type_Int != localbhwj2.jdField_a_of_type_Int) {
              break label245;
            }
            localbhwj3.jdField_c_of_type_Int = paramInt;
            this.jdField_a_of_type_Bhwj = localbhwj2;
          }
          for (;;)
          {
            i1 += 1;
            break;
            if ((localbhwj1 != null) && (localbhwj3.jdField_a_of_type_Int == localbhwj1.jdField_a_of_type_Int)) {
              localbhwj3.jdField_c_of_type_Int = -1;
            }
          }
        }
        this.jdField_a_of_type_Ammy.a(localList, this.jdField_a_of_type_JavaUtilList);
        i1 = 3;
        if (!a()) {
          break label439;
        }
        this.jdField_a_of_type_AndroidWidgetButton.setText(2131717950);
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        i1 = 4;
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "faceAddon", "0X80088ED", "", 1, 0, 0, null, String.valueOf(i1), String.valueOf(this.jdField_a_of_type_Long));
        bdll.b(this.app, "CliOper", "", "", "0X8005FD5", "0X8005FD5", 0, 0, String.valueOf(this.jdField_a_of_type_Bhwj.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Long), "", "");
        if (this.jdField_a_of_type_Bhwi.jdField_b_of_type_Int != 1) {
          break label657;
        }
        ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.i);
      }
      for (;;)
      {
        if (Build.VERSION.SDK_INT >= 14) {
          break label681;
        }
        return;
        i2 = 0;
        int i6;
        switch (this.jdField_a_of_type_Bhwi.jdField_c_of_type_Int)
        {
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        default: 
          i6 = 1;
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          if (i6 == 0) {
            break label645;
          }
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131717446);
          i1 = 3;
          break;
          boolean bool = VipUtils.c(this.app);
          i6 = bool;
          if (!bool)
          {
            i2 = 2131719273;
            i1 = 0;
            i6 = bool;
            continue;
            bool = VipUtils.b(this.app);
            i6 = bool;
            if (!bool)
            {
              i2 = 2131718499;
              i1 = 1;
              i6 = bool;
              continue;
              i6 = 0;
              i2 = 2131689538;
              i1 = 2;
              continue;
              bool = VipUtils.a(this.app);
              i6 = bool;
              if (!bool)
              {
                i2 = 2131690504;
                i1 = 5;
                i6 = bool;
              }
            }
          }
        }
        this.jdField_a_of_type_AndroidWidgetButton.setText(i2);
        break;
        ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 5, PendantInfo.i);
      }
      if ((this.jdField_e_of_type_Int == jdField_b_of_type_Int) || (this.jdField_e_of_type_Int == jdField_c_of_type_Int))
      {
        paramAdapterView = (ViewGroup)paramAdapterView.getParent();
        localObject = (ViewGroup)paramAdapterView.getParent();
        i1 = paramAdapterView.getHeight();
        i2 = paramView.getHeight();
        i3 = bhgr.a(this, 7.0F);
        if (!this.jdField_a_of_type_Bhwj.jdField_a_of_type_Boolean) {
          break label1240;
        }
        i4 = (this.jdField_a_of_type_Bhwj.jdField_a_of_type_JavaUtilList.size() - 1) / 4;
        if (paramInt != 0) {
          break label879;
        }
        paramInt = 0;
        i5 = bhgr.a(this, 4.0F);
      }
    }
    label1240:
    for (paramInt = i1 - (i4 + 1 - paramInt) * (i2 + i5) + i5 - i3;; paramInt = i1 - i2 - i3)
    {
      i2 = this.g - this.h;
      i1 = ((ViewGroup)localObject).getTop();
      if (((ViewGroup)localObject).getTag() != null)
      {
        i3 = ((amnf)((ViewGroup)localObject).getTag()).jdField_a_of_type_Int;
        if (i1 >= 0) {
          break label886;
        }
        i1 = paramInt;
        if (paramInt < 0) {
          i1 = 0 - paramInt;
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i3, i2 - i1);
      }
      for (;;)
      {
        m();
        return;
        label879:
        paramInt /= 4;
        break;
        label886:
        if (paramInt + i1 < i2) {
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i3, i2 - paramInt);
        }
      }
      if (paramAdapterView.getId() != 2131374869) {
        break;
      }
      this.jdField_a_of_type_Long = -1L;
      o();
      this.jdField_a_of_type_Bhwh = ((bhwh)((amnc)paramView.getTag()).a.getTag());
      this.s = this.jdField_a_of_type_Bhwh.jdField_a_of_type_Int;
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      q();
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(this.s, 7, "large", ImageView.ScaleType.FIT_XY);
      VasWebviewUtil.reportCommercialDrainage(this.app.c(), "widget", "head_click", "", 1, 0, 0, "", this.jdField_a_of_type_Bhwh.jdField_a_of_type_Int + "", "");
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putInt("ChooseFaceId", this.jdField_a_of_type_Bhwh.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.apply();
      paramView = ((AvatarPendantManager)this.app.getManager(46)).a();
      if (paramView.size() > 0) {
        this.jdField_a_of_type_Ammy.a(paramView, this.jdField_a_of_type_JavaUtilList);
      }
      paramAdapterView = (ViewGroup)((ViewGroup)paramAdapterView.getParent()).getParent();
      if ((paramAdapterView.getTag() == null) || (!(paramAdapterView.getTag() instanceof amnf))) {
        break;
      }
      paramAdapterView = (amnf)paramAdapterView.getTag();
      paramInt = bhgr.a(this, 100.0F);
      i1 = bhgr.a(this, 20.0F);
      i2 = paramAdapterView.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_Bhwh.a()) {
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i2, paramInt);
      }
      for (;;)
      {
        m();
        return;
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i2, i1);
      }
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    boolean bool3 = false;
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      paramView = findViewById(2131380361);
      View localView = findViewById(2131378910);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getRight() > this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.getLeft())
      {
        paramInt1 = 1;
        paramInt2 = paramView.getTop();
        paramInt3 = this.jdField_b_of_type_AndroidWidgetImageView.getBottom();
        paramInt4 = this.jdField_a_of_type_AndroidViewView.getTop();
        if (paramInt2 + paramInt3 <= localView.getTop() + paramInt4) {
          break label227;
        }
        paramInt2 = 1;
        label89:
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break label232;
        }
      }
    }
    label227:
    label232:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool3;
      if (this.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
      {
        bool2 = bool3;
        if (this.jdField_b_of_type_AndroidViewView.getBottom() > this.jdField_c_of_type_AndroidViewView.getTop() + this.jdField_a_of_type_AndroidViewView.getTop()) {
          bool2 = true;
        }
      }
      if ((bool1) || (bool2)) {
        ThreadManager.getUIHandler().post(new AvatarPendantActivity.RemoveTips(this, bool1, bool2));
      }
      paramView = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      paramInt1 = (int)(this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams().width * 0.18D);
      paramView.width = paramInt1;
      paramView.height = paramInt1;
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(paramView);
      return;
      paramInt1 = 0;
      break;
      paramInt2 = 0;
      break label89;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity
 * JD-Core Version:    0.7.0.1
 */