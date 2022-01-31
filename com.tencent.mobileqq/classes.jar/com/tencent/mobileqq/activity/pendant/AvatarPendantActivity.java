package com.tencent.mobileqq.activity.pendant;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.util.SparseIntArray;
import android.view.Display;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter.PendantGridAdapter.GridItemHolder;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter.ViewHolder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniPayHandler;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.AvatarPendantShopItemInfo;
import com.tencent.mobileqq.vas.AvatarPendantShopSeriesInfo;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GridView;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import wou;
import wov;
import wow;
import wox;
import woy;
import woz;
import wpa;
import wpb;
import wpc;
import wpd;
import wpe;
import wpg;
import wpi;
import wpj;
import wpk;
import wpl;
import wpn;
import wpp;
import wpq;
import wps;
import wpu;
import wpv;

public class AvatarPendantActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, View.OnLayoutChangeListener, AdapterView.OnItemClickListener
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  double jdField_a_of_type_Double;
  public long a;
  public Uri a;
  public Handler a;
  SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  View jdField_a_of_type_AndroidViewView;
  public Button a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  public LinearLayout a;
  public TextView a;
  public ProfileActivity.AllInOne a;
  public AvatarPendantAdapter a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new wpe(this);
  UniPayHandler.UniPayUpdateListener jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener = new wpl(this);
  UniPayHandler jdField_a_of_type_ComTencentMobileqqAppUniPayHandler;
  public DynamicAvatarView a;
  private GameCenterObserver jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver = new wou(this);
  public RedTouch a;
  public AvatarPendantShopItemInfo a;
  public AvatarPendantShopSeriesInfo a;
  VasExtensionObserver jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new woy(this);
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new wpd(this);
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new wox(this);
  TipsBar jdField_a_of_type_ComTencentMobileqqWidgetTipsBar;
  public BusinessInfoCheckUpdate.AppInfo a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  double jdField_b_of_type_Double;
  long jdField_b_of_type_Long = -1L;
  View jdField_b_of_type_AndroidViewView;
  public ImageView b;
  public TextView b;
  boolean jdField_b_of_type_Boolean;
  long jdField_c_of_type_Long = -1L;
  View jdField_c_of_type_AndroidViewView;
  boolean jdField_c_of_type_Boolean;
  View d;
  public boolean d;
  public int e;
  public volatile boolean e;
  int f;
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
  public int r;
  
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
  }
  
  @TargetApi(14)
  private void a(List paramList1, List paramList2, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 14) {
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 1, 100 });
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addUpdateListener(new wpj(this, paramList1, paramList2));
    localValueAnimator.addListener(new wpk(this));
    localValueAnimator.setDuration(paramInt).start();
  }
  
  private boolean b()
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
  
  private boolean c()
  {
    return this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getBoolean("had_entered_store_face", false);
  }
  
  private void f()
  {
    VasQuickUpdateManager localVasQuickUpdateManager = (VasQuickUpdateManager)this.app.getManager(183);
    localVasQuickUpdateManager.a(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    Object localObject = ((DownloaderFactory)this.app.getManager(46)).a(1);
    File localFile1 = new File(AvatarPendantUtil.b);
    if (!localFile1.exists()) {
      localFile1.mkdir();
    }
    File localFile2 = new File(AvatarPendantUtil.b + "/icon.zip");
    if ((localFile1.exists()) && (!localFile2.exists()) && (localObject != null)) {
      ThreadManager.getSubThreadHandler().post(new wpu(this, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, this.app));
    }
    localObject = ((AvatarPendantManager)this.app.getManager(45)).a();
    this.app.getApp().getSharedPreferences("clubContentPendantMarketJsonUpdate", 0);
    if (((List)localObject).size() > 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
    if (new File(this.jdField_a_of_type_JavaLangString).exists())
    {
      ((List)localObject).clear();
      a(true);
      return;
    }
    localVasQuickUpdateManager.a(1000L, "pendant_market_json.android.v2", "pendant_market");
  }
  
  private void g()
  {
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131363362);
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131363091);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131372078);
    View localView = super.findViewById(2131371045);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131372079));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131372077));
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView = ((DynamicAvatarView)super.findViewById(2131372081));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131372083));
    this.jdField_d_of_type_AndroidViewView = super.findViewById(2131372082);
    this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar = ((TipsBar)super.findViewById(2131365435));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131372092));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131372093));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131372085));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372084));
    this.jdField_c_of_type_AndroidViewView.addOnLayoutChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    findViewById(2131364614).setOnClickListener(this);
    Object localObject1 = (TextView)findViewById(2131372087);
    ((TextView)localObject1).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, (View)localObject1).a(53).a();
    i();
    localObject1 = (TextView)super.findViewById(2131363227);
    ((TextView)localObject1).setText(super.getString(2131433681));
    ((TextView)localObject1).setOnClickListener(this);
    localObject1 = (TextView)super.findViewById(2131363363);
    ((TextView)localObject1).setText(super.getString(2131436710));
    ((TextView)localObject1).setFocusable(true);
    ((TextView)localObject1).setFocusableInTouchMode(true);
    ((TextView)localObject1).setClickable(true);
    ((TextView)localObject1).setContentDescription(super.getString(2131436710));
    localObject1 = (RelativeLayout)super.findViewById(2131363362);
    localObject1 = getWindowManager().getDefaultDisplay();
    int i1 = ((Display)localObject1).getHeight();
    int i2 = ((Display)localObject1).getWidth();
    double d3 = i1 / i2;
    double d2 = d3 - 1.78D;
    this.f = (i1 - a());
    this.jdField_e_of_type_Int = jdField_a_of_type_Int;
    double d1 = 0.58D * (d3 - 2.0D * d2) / 1.8D;
    d2 = (1.85D - d2 * 2.0D) * 0.38D / d3;
    Object localObject2;
    RelativeLayout.LayoutParams localLayoutParams;
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      d2 = d3 - 1.67D;
      a();
      i2 = super.getResources().getDimensionPixelSize(2131558448);
      localObject2 = (RelativeLayout)super.findViewById(2131372080);
      localLayoutParams = (RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams();
      localLayoutParams.topMargin = (i2 / 2 + 14 - (int)(Math.abs(d2) * 24.0D));
      ((RelativeLayout)localObject2).setLayoutParams(localLayoutParams);
      d1 = 0.58D * (1.8D + 2.0D * d2) / d3;
      d2 = 0.38D * (d2 * 2.0D + 1.95D) / d3;
    }
    for (;;)
    {
      if (d3 < 1.2D)
      {
        this.f = i1;
        d1 = 1.0D;
        d2 = 1.0D;
      }
      this.g = ((int)(this.f * d1));
      this.h = ((int)(this.f * d2));
      if (!this.jdField_b_of_type_Boolean)
      {
        super.findViewById(2131372088).setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText("没有SD卡无法使用头像挂件");
        this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.a(false);
        this.g = ((int)((d1 + 0.06D) * this.f));
        this.h = ((int)(d2 * this.f));
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
        localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams();
        localObject2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = this.i;
        ((RelativeLayout.LayoutParams)localObject1).height = this.i;
        ((RelativeLayout.LayoutParams)localObject2).width = this.k;
        ((RelativeLayout.LayoutParams)localObject2).height = this.m;
        localLayoutParams.height = this.o;
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_d_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, 640, true, true, true, false, 7);
        m();
        if (!ThemeUtil.isInNightMode(this.app)) {
          break label1243;
        }
        if (localView != null) {
          localView.setVisibility(0);
        }
      }
      label1243:
      while (localView == null)
      {
        return;
        if (this.jdField_c_of_type_Boolean)
        {
          super.findViewById(2131372088).setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(0);
          this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setTipsText("SD卡已满，可能无法使用头像挂件");
          this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.a(false);
          this.g = ((int)((d1 + 0.06D) * this.f));
          this.h = ((int)(d2 * this.f));
          this.jdField_a_of_type_Boolean = true;
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetTipsBar.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter = new AvatarPendantAdapter(this, this, this, ((Display)localObject1).getWidth(), this.app, this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, this.g - this.h);
        this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter);
        break;
      }
      localView.setVisibility(8);
      return;
    }
  }
  
  private void h()
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit();
    localEditor.putBoolean("had_entered_store_face", true);
    localEditor.commit();
  }
  
  private void i()
  {
    ThreadManager.post(new wpg(this), 5, null, true);
  }
  
  private void j()
  {
    if ((this.jdField_e_of_type_Int == jdField_a_of_type_Int) || (this.jdField_e_of_type_Int == jdField_d_of_type_Int)) {}
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = this.o;
    this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new wps();
    wps localwps1 = new wps();
    wps localwps2 = new wps();
    ((wps)localObject).jdField_c_of_type_Int = localLayoutParams.height;
    ((wps)localObject).jdField_d_of_type_Int = this.g;
    int i1 = localLayoutParams.topMargin;
    ((wps)localObject).jdField_b_of_type_Int = i1;
    ((wps)localObject).jdField_a_of_type_Int = i1;
    ((wps)localObject).g = ((int)(Math.abs(this.g - localLayoutParams.height) * 1.0D / this.g * ((wps)localObject).g));
    i1 = localLayoutParams1.topMargin;
    localwps1.jdField_b_of_type_Int = i1;
    localwps1.jdField_a_of_type_Int = i1;
    localwps1.jdField_e_of_type_Int = localLayoutParams1.width;
    localwps1.f = this.i;
    localwps1.jdField_c_of_type_Int = localLayoutParams1.height;
    localwps1.jdField_d_of_type_Int = this.i;
    localwps1.g = ((wps)localObject).g;
    i1 = localLayoutParams2.topMargin;
    localwps2.jdField_b_of_type_Int = i1;
    localwps2.jdField_a_of_type_Int = i1;
    localwps2.jdField_e_of_type_Int = localLayoutParams2.width;
    localwps2.f = this.k;
    localwps2.jdField_c_of_type_Int = localLayoutParams2.height;
    localwps2.jdField_d_of_type_Int = this.m;
    localwps2.g = ((wps)localObject).g;
    localArrayList2.add(this.jdField_c_of_type_AndroidViewView);
    localArrayList2.add(this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView);
    localArrayList2.add(this.jdField_b_of_type_AndroidWidgetImageView);
    localArrayList1.add(localObject);
    localArrayList1.add(localwps1);
    localArrayList1.add(localwps2);
    if (((wps)localObject).g <= 0)
    {
      QLog.e("AvatarPendantActivity", 2, "heigth: " + this.g + " palytime: " + ((wps)localObject).g);
      return;
    }
    a(localArrayList2, localArrayList1, ((wps)localObject).g);
  }
  
  private void k()
  {
    ThreadManager.getFileThreadHandler().post(new wpn(this));
  }
  
  private void l()
  {
    if (!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      return;
    }
    Object localObject = ((FriendsManager)this.app.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
      localObject = (AvatarPendantManager)this.app.getManager(45);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      if (!AvatarPendantUtil.a(this.jdField_a_of_type_Long)) {
        break label190;
      }
      ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.i);
      label150:
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!b()) {
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
        AvatarPendantManager localAvatarPendantManager = (AvatarPendantManager)this.app.getManager(45);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        if (AvatarPendantUtil.a(((ExtensionInfo)localObject).pendantId)) {
          localAvatarPendantManager.a(((ExtensionInfo)localObject).pendantId).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.i, this.app.getCurrentAccountUin(), ((ExtensionInfo)localObject).pendantDiyId);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131434589);
          ReportController.b(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "1", "", "", "");
          break;
          localAvatarPendantManager.a(((ExtensionInfo)localObject).pendantId).a(this.jdField_b_of_type_AndroidWidgetImageView, 5, PendantInfo.i, this.app.getCurrentAccountUin(), ((ExtensionInfo)localObject).pendantDiyId);
        }
      }
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      ReportController.b(this.app, "CliOper", "", "", "0X8005FDD", "0X8005FDD", 0, 0, "0", "", "", "");
      break label150;
    }
  }
  
  private void m()
  {
    Object localObject = new File(AvatarPendantUtil.c + "/widget_display_bg.jpg");
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
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(new wpi(this));
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
      QLog.i("IphoneTitleBarActivity", 2, "verifyAuth, tipsInfo = " + paramPendantTipsInfo + "result = " + paramInt);
    }
    int i1 = paramPendantTipsInfo.type;
    boolean bool = NetworkUtil.d(this);
    if (bool) {}
    for (Object localObject = "4";; localObject = "3") {
      switch (i1)
      {
      default: 
        paramPendantTipsInfo = (PendantTipsInfo)localObject;
        if (paramLong == 0L) {
          break label478;
        }
        ReportController.b(this.app, "CliOper", "", "", "0X8005FD7", "0X8005FD7", 0, 0, paramPendantTipsInfo, "", "", "");
        return;
      }
    }
    if (TextUtils.isEmpty(paramPendantTipsInfo.wording))
    {
      QLog.e("IphoneTitleBarActivity", 1, "verifyAuth, tipsInfo.wording is empty! type = PAYMENT");
      QQToast.a(this, 1, "设置挂件失败", 0).b(getTitleBarHeight());
      return;
    }
    if (paramPendantTipsInfo.vipType.equals("LTMCLUB")) {
      localObject = "0";
    }
    for (;;)
    {
      DialogUtil.a(this, 230).setTitle(paramPendantTipsInfo.titleWording).setMessage(paramPendantTipsInfo.wording).setPositiveButton(paramPendantTipsInfo.rightBtnWording, new wpa(this, paramPendantTipsInfo, paramInt)).setNegativeButton(paramPendantTipsInfo.leftBtnWording, new woz(this)).show();
      ReportController.b(this.app, "CliOper", "", "", "0X8005FD8", "0X8005FD8", 0, 0, "", "", "", "");
      paramPendantTipsInfo = (PendantTipsInfo)localObject;
      break;
      if (paramPendantTipsInfo.equals("CJCLUBT"))
      {
        localObject = "1";
        continue;
        if (TextUtils.isEmpty(paramPendantTipsInfo.wording))
        {
          QLog.e("IphoneTitleBarActivity", 1, "verifyAuth, tipsInfo.wording is empty! type = JUMP_URL");
          QQToast.a(this, 1, "设置挂件失败", 0).b(getTitleBarHeight());
          return;
        }
        paramPendantTipsInfo = DialogUtil.a(this, 230).setTitle(paramPendantTipsInfo.titleWording).setMessage(paramPendantTipsInfo.wording).setPositiveButton(paramPendantTipsInfo.rightBtnWording, new wpc(this, paramPendantTipsInfo, paramInt)).setNegativeButton(paramPendantTipsInfo.leftBtnWording, new wpb(this));
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
        label478:
        localObject = this.app;
        if (bool) {}
        for (paramPendantTipsInfo = "2";; paramPendantTipsInfo = "1")
        {
          ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8006896", "0X8006896", 0, 0, paramPendantTipsInfo, "", "", "");
          return;
        }
      }
    }
  }
  
  public void a(PendantTipsInfo paramPendantTipsInfo, boolean paramBoolean, int paramInt)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarActivity", 2, "openVIP, tipsInfo = " + paramPendantTipsInfo);
    }
    Object localObject;
    String str2;
    String str1;
    if (paramPendantTipsInfo.type == 1)
    {
      if (paramBoolean)
      {
        localObject = "mvip.gxh.android.faceaddon_nati_dft";
        str2 = paramPendantTipsInfo.vipType;
        if (!str2.equals("LTMCLUB")) {
          break label155;
        }
        str1 = getString(2131436723);
      }
      for (;;)
      {
        if ((paramPendantTipsInfo.vipMonth < 1) || (paramPendantTipsInfo.vipMonth > 12))
        {
          QLog.e("IphoneTitleBarActivity", 1, "openVIP, vipMonth invalid = " + paramPendantTipsInfo.vipMonth);
          return;
          localObject = "mvip.gxh.android.faceaddon_nati_" + this.jdField_a_of_type_Long;
          break;
          label155:
          if (str2.equals("CJCLUBT"))
          {
            str1 = getString(2131436926);
          }
          else
          {
            QLog.e("IphoneTitleBarActivity", 2, "openVIP, unknown vipType = " + paramPendantTipsInfo.vipType);
            return;
          }
        }
      }
      if (((paramInt != 9002) && (paramInt != 9003)) || (paramPendantTipsInfo.vipMonth != 12)) {
        break label385;
      }
      if (paramInt != 9003) {
        break label380;
      }
      bool = true;
      paramBoolean = true;
    }
    for (;;)
    {
      VasH5PayUtil.a(null, this, (String)localObject, paramPendantTipsInfo.vipMonth, "1450000515", str2, str1, "", paramBoolean, bool);
      return;
      if ((paramPendantTipsInfo.type == 2) || (paramPendantTipsInfo.type == 3))
      {
        if (!TextUtils.isEmpty(paramPendantTipsInfo.url))
        {
          localObject = new Intent(this, QQBrowserActivity.class);
          VasWebviewUtil.openQQBrowserWithoutAD(this, paramPendantTipsInfo.url, -1L, (Intent)localObject, true, -1);
          return;
        }
        QLog.e("IphoneTitleBarActivity", 1, "openVIP, type = jump_url, but url == nul. tipsInfo = " + paramPendantTipsInfo);
        return;
      }
      QLog.e("IphoneTitleBarActivity", 1, "openVIP, action type is incorrect! tipsInfo = " + paramPendantTipsInfo);
      return;
      label380:
      paramBoolean = true;
      continue;
      label385:
      paramBoolean = false;
    }
  }
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramAdapterView.getId() != 2131372116) {}
    while ((!(paramAdapterView instanceof GridView)) || (paramAdapterView.getTag() == null) || (paramView == null) || (paramView.getTag() == null)) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    e();
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo = ((AvatarPendantShopItemInfo)((AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)paramView.getTag()).a.getTag());
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_a_of_type_Int;
    Object localObject = (AvatarPendantManager)this.app.getManager(45);
    List localList = ((AvatarPendantManager)localObject).a();
    AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo1 = this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo;
    AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo2 = (AvatarPendantShopSeriesInfo)paramAdapterView.getTag();
    int i1 = 0;
    if (i1 < localList.size())
    {
      AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo3 = (AvatarPendantShopSeriesInfo)localList.get(i1);
      if (localAvatarPendantShopSeriesInfo3 != null)
      {
        if (localAvatarPendantShopSeriesInfo3.jdField_a_of_type_Int != localAvatarPendantShopSeriesInfo2.jdField_a_of_type_Int) {
          break label201;
        }
        localAvatarPendantShopSeriesInfo3.jdField_c_of_type_Int = paramInt;
        this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo = localAvatarPendantShopSeriesInfo2;
      }
      for (;;)
      {
        i1 += 1;
        break;
        label201:
        if ((localAvatarPendantShopSeriesInfo1 != null) && (localAvatarPendantShopSeriesInfo3.jdField_a_of_type_Int == localAvatarPendantShopSeriesInfo1.jdField_a_of_type_Int)) {
          localAvatarPendantShopSeriesInfo3.jdField_c_of_type_Int = -1;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a(localList);
    i1 = 3;
    label268:
    label382:
    int i2;
    int i3;
    int i4;
    label482:
    int i5;
    if (a())
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131434589);
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      i1 = 4;
      VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "faceAddon", "0X80088ED", "", 1, 0, 0, null, String.valueOf(i1), String.valueOf(this.jdField_a_of_type_Long));
      ReportController.b(this.app, "CliOper", "", "", "0X8005FD5", "0X8005FD5", 0, 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_Int), String.valueOf(this.jdField_a_of_type_Long), "", "");
      if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_b_of_type_Int != 1) {
        break label748;
      }
      ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 2, PendantInfo.i);
      if (Build.VERSION.SDK_INT < 14) {
        break label770;
      }
      if ((this.jdField_e_of_type_Int == jdField_b_of_type_Int) || (this.jdField_e_of_type_Int == jdField_c_of_type_Int))
      {
        paramAdapterView = (ViewGroup)paramAdapterView.getParent();
        localObject = (ViewGroup)paramAdapterView.getParent();
        i1 = paramAdapterView.getHeight();
        i2 = paramView.getHeight();
        i3 = DisplayUtil.a(this, 7.0F);
        if (!this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_Boolean) {
          break label804;
        }
        i4 = (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_JavaUtilList.size() - 1) / 4;
        if (paramInt != 0) {
          break label772;
        }
        paramInt = 0;
        i5 = DisplayUtil.a(this, 4.0F);
      }
    }
    label770:
    label772:
    label779:
    label804:
    for (paramInt = i1 - (i4 + 1 - paramInt) * (i2 + i5) + i5 - i3;; paramInt = i1 - i2 - i3)
    {
      i2 = this.g - this.h;
      i1 = ((ViewGroup)localObject).getTop();
      if (((ViewGroup)localObject).getTag() != null)
      {
        i3 = ((AvatarPendantAdapter.ViewHolder)((ViewGroup)localObject).getTag()).jdField_a_of_type_Int;
        if (i1 >= 0) {
          break label779;
        }
        i1 = paramInt;
        if (paramInt < 0) {
          i1 = 0 - paramInt;
        }
        this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i3, i2 - i1);
      }
      for (;;)
      {
        j();
        return;
        i2 = 0;
        int i6;
        switch (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopItemInfo.jdField_c_of_type_Int)
        {
        default: 
          i6 = 1;
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
          if (i6 == 0) {
            break label736;
          }
          this.jdField_a_of_type_AndroidWidgetButton.setText(2131434582);
          i1 = 3;
          break;
          boolean bool = VipUtils.b(this.app);
          i6 = bool;
          if (!bool)
          {
            i2 = 2131434583;
            i1 = 0;
            i6 = bool;
            continue;
            bool = VipUtils.a(this.app);
            i6 = bool;
            if (!bool)
            {
              i2 = 2131434584;
              i1 = 1;
              i6 = bool;
              continue;
              i6 = 0;
              i2 = 2131434585;
              i1 = 2;
            }
          }
        }
        label736:
        this.jdField_a_of_type_AndroidWidgetButton.setText(i2);
        break label268;
        label748:
        ((AvatarPendantManager)localObject).a(this.jdField_a_of_type_Long).a(this.jdField_b_of_type_AndroidWidgetImageView, 5, PendantInfo.i);
        break label382;
        break;
        paramInt /= 4;
        break label482;
        if (paramInt + i1 < i2) {
          this.jdField_a_of_type_ComTencentWidgetXListView.setSelectionFromTop(i3, i2 - paramInt);
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    ThreadManager.getFileThreadHandler().post(new wow(this, str));
  }
  
  public boolean a()
  {
    if ((this.app != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne != null))
    {
      ExtensionInfo localExtensionInfo = ((FriendsManager)this.app.getManager(50)).a(this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
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
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.getLayoutParams();
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
      this.jdField_a_of_type_ComTencentMobileqqAvatarDynamicavatarDynamicAvatarView.setLayoutParams(localLayoutParams1);
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
  
  public void c()
  {
    ImageView localImageView = (ImageView)super.findViewById(2131372089);
    TextView localTextView = (TextView)super.findViewById(2131372090);
    Button localButton = (Button)super.findViewById(2131372091);
    String str2 = this.app.getCurrentAccountUin();
    SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("uniPaySp_" + str2, 0);
    String str3 = localSharedPreferences.getString("sUin", "");
    int i1 = localSharedPreferences.getInt("isShowOpen", 0);
    int i2 = localSharedPreferences.getInt("iUinpPayType", 0);
    Object localObject3 = "LTMCLUB";
    String str1 = "QQ会员";
    String str4 = super.getString(2131436891);
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
      localButton.setOnClickListener(new wpp(this, Integer.valueOf(localSharedPreferences.getString("open_month", "3")).intValue(), (String)localObject1, (String)localObject2));
      return;
      localButton.setText(2131436167);
      localTextView.setText(super.getString(2131436226, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130840606));
      localObject1 = "QQ会员";
      localObject2 = "LTMCLUB";
      continue;
      localButton.setText(2131436168);
      localTextView.setText(super.getString(2131436227, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130841471));
      localObject1 = "QQ会员";
      localObject2 = "LTMCLUB";
      continue;
      localButton.setText(2131436167);
      localTextView.setText(super.getString(2131436228, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130840606));
      localObject2 = "CJCLUBT";
      localObject1 = "超级会员";
      continue;
      localButton.setText(2131436168);
      localTextView.setText(super.getString(2131436229, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130840935));
      localObject2 = "CJCLUBT";
      localObject1 = "超级会员";
      continue;
      localButton.setText(2131436168);
      localTextView.setText(super.getString(2131436233, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130841472));
      localObject2 = "CJCLUBT";
      localObject1 = "超级会员";
      continue;
      localButton.setText(2131436169);
      localTextView.setText(super.getString(2131436234, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130841472));
      localObject2 = "CJCLUBT";
      localObject1 = "超级会员";
      continue;
      localButton.setText(2131436169);
      localTextView.setText(super.getString(2131436230, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130840935));
      localObject2 = "CJCLUBT";
      localObject1 = "超级会员";
      continue;
      localButton.setText(2131436168);
      localTextView.setText(super.getString(2131436231, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130841473));
      localObject2 = "LTMCLUB";
      localObject1 = "QQ会员";
      continue;
      localButton.setText(2131436169);
      localTextView.setText(super.getString(2131436232, new Object[] { str4 }));
      localImageView.setBackgroundDrawable(super.getResources().getDrawable(2130841473));
      localObject2 = "LTMCLUB";
      localObject1 = "QQ会员";
    }
  }
  
  public void d()
  {
    int i1 = SharedPreUtils.az(this, this.app.getCurrentAccountUin());
    boolean bool;
    Object localObject;
    String[] arrayOfString;
    if ((i1 == 2) || (i1 == -1))
    {
      bool = true;
      localObject = (ActionSheet)ActionSheetHelper.a(this, null);
      arrayOfString = super.getResources().getStringArray(2131296278);
      ((ActionSheet)localObject).c(arrayOfString[22]);
      ((ActionSheet)localObject).c(arrayOfString[24]);
      ((ActionSheet)localObject).c(arrayOfString[13]);
      if (!bool) {
        break label175;
      }
      ((ActionSheet)localObject).c(arrayOfString[27]);
    }
    for (;;)
    {
      ((ActionSheet)localObject).d(arrayOfString[16]);
      ((ActionSheet)localObject).a(new wpq(this, bool, (ActionSheet)localObject));
      try
      {
        if (!isFinishing())
        {
          ((ActionSheet)localObject).show();
          localObject = ((ActionSheet)localObject).findViewById(0);
          if (localObject != null) {
            ((View)localObject).setContentDescription("拍摄动态头像按钮");
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "showActionSheet, historyHeadNumFlag=" + i1);
      }
      return;
      bool = false;
      break;
      label175:
      ((ActionSheet)localObject).c(arrayOfString[23]);
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
              if (this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler != null) {
                this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a("");
              }
              if (!str.equals("pendantNativeVipDefault")) {
                break label226;
              }
              ReportController.b(this.app, "CliOper", "", "", "0X8005FDF", "0X8005FDF", 0, 0, "", "", "", "");
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
          ReportController.b(this.app, "CliOper", "", "", "0X8005FDF", "0X8005FDF", 0, 0, str.substring(16, str.length()), "", "", "");
        }
        if (paramInt1 != 1) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("DynamicAvatar", 2, "record dynamic avatar! resultCode:" + paramInt2);
        }
      } while (paramInt2 != -1);
      k();
      return;
    } while (paramInt2 != -1);
    switch (paramInt1)
    {
    default: 
      return;
    }
    paramIntent = ImageUtil.b(this, this.jdField_a_of_type_AndroidNetUri);
    paramInt1 = ProfileCardUtil.b(this);
    localIntent = new Intent();
    localIntent.putExtra("Business_Origin", 100);
    localIntent.putExtra("BUSINESS_ORIGIN_NEW", 100);
    localIntent.putExtra("fromWhereClick", 10);
    localIntent.putExtra("PhotoConst.SOURCE_FROM", "FROM_TAKE_PHOTO");
    PhotoUtils.a(localIntent, this, AvatarPendantActivity.class.getName(), paramInt1, paramInt1, 640, 640, paramIntent, ProfileCardUtil.a());
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    super.setContentViewNoTitle(2130970885);
    getWindow().setBackgroundDrawable(null);
    paramBundle = super.getIntent();
    boolean bool2;
    boolean bool1;
    if (paramBundle.getParcelableExtra("AllInOne") != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne = ((ProfileActivity.AllInOne)paramBundle.getParcelableExtra("AllInOne"));
      bool2 = paramBundle.getBooleanExtra("showActionSheet", false);
      c();
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler = ((UniPayHandler)this.app.a(44));
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
      super.addObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.a("");
      if ((!NetworkUtil.d(this)) && (QLog.isColorLevel())) {
        QLog.d("AvatarPendantActivity", 2, "net is not connected");
      }
      this.jdField_b_of_type_Boolean = SystemUtil.a();
      if (SystemUtil.a() >= 1024L) {
        break label282;
      }
      bool1 = true;
      this.jdField_c_of_type_Boolean = bool1;
      this.jdField_a_of_type_JavaLangString = (this.app.getApplication().getApplicationContext().getFilesDir() + File.separator + "pendant_market.json");
      g();
      if ((!this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean)) {
        break label287;
      }
      a();
      f();
    }
    for (;;)
    {
      if (bool2) {
        d();
      }
      this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "AllinOne info is null");
      }
      finish();
      return true;
      label282:
      bool1 = false;
      break;
      label287:
      if (QLog.isColorLevel()) {
        QLog.d("AvatarPendantActivity", 2, "sdcard exist:" + this.jdField_b_of_type_Boolean + " sdcard full:" + this.jdField_c_of_type_Boolean);
      }
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler.b(this.jdField_a_of_type_ComTencentMobileqqAppUniPayHandler$UniPayUpdateListener);
    }
    if (this.app != null) {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGameCenterObserver);
    }
    super.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_c_of_type_Int = -1;
    }
    if ((this.app != null) && (this.jdField_a_of_type_Long != 0L)) {
      ((AvatarPendantManager)this.app.getManager(45)).a(this.jdField_a_of_type_Long).b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a();
      URLDrawable.resume();
    }
    if (this.app != null)
    {
      ((VasQuickUpdateManager)this.app.getManager(183)).b(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    String str = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (str != null)
    {
      if (!ProfileCardUtil.a(this.app, str, paramIntent)) {
        break label147;
      }
      k();
      switch (paramIntent.getIntExtra("fromWhereClick", -1))
      {
      }
    }
    for (;;)
    {
      l();
      return;
      ReportController.b(this.app, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 1, 0, "1", "", "", "");
      continue;
      ReportController.b(this.app, "CliOper", "", "", "0X8005FDE", "0X8005FDE", 0, 0, "0", "", "", "");
      continue;
      label147:
      QQToast.a(this, 1, 2131435908, 0).b(getTitleBarHeight());
    }
  }
  
  protected void doOnPause()
  {
    ApngImage.pauseAll();
    AbstractVideoImage.pauseAll();
    ((AvatarPendantManager)this.app.getManager(45)).c();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ApngImage.playByTag(10);
    AbstractVideoImage.resumeAll();
    if ((this.mSystemBarComp == null) && (this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      this.mSystemBarComp = new SystemBarCompact(this, true, Color.parseColor("#0089ce"));
      this.mSystemBarComp.init();
    }
    Object localObject = ((AvatarPendantManager)this.app.getManager(45)).a();
    if ((this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter != null) && (((List)localObject).size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a((List)localObject);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if (c()) {}
    for (int i1 = 8;; i1 = 0)
    {
      ((TextView)localObject).setVisibility(i1);
      l();
      return;
    }
  }
  
  protected void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Long != 0L) {
      ((AvatarPendantManager)this.app.getManager(45)).a(this.jdField_a_of_type_Long).b();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (isFinishing()) {}
    while (paramMessage.what != 1000) {
      return true;
    }
    runOnUiThread(new wov(this, ((AvatarPendantManager)this.app.getManager(45)).a()));
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    int i1;
    label670:
    do
    {
      do
      {
        do
        {
          return;
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131363227: 
            finish();
            return;
          case 2131372087: 
            ((RedTouchManager)this.app.getManager(35)).b("100100.100125.100127");
            paramView = new Intent(this, QQBrowserActivity.class);
            paramView.putExtra("individuation_url_type", 40100);
            paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
            paramView.putExtra("hide_left_button", false);
            paramView.putExtra("show_right_close_button", false);
            paramView.putExtra("url", IndividuationUrlHelper.a(this, "faceEntryUrl", ""));
            paramView.putExtra("business", 512L);
            paramView.putExtra("isShowAd", false);
            startActivity(paramView);
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "face", "0X80088EC", "", 1, 0, 0, null, "", "");
            h();
            return;
          case 2131364614: 
            paramView = new Intent(this, QQBrowserActivity.class);
            paramView.putExtra("individuation_url_type", 40100);
            paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
            paramView.putExtra("hide_left_button", false);
            paramView.putExtra("show_right_close_button", false);
            paramView.putExtra("url", IndividuationUrlHelper.a(this, "myPendantUrl", ""));
            paramView.putExtra("business", 512L);
            paramView.putExtra("isShowAd", false);
            startActivity(paramView);
            VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "faceAddon", "0X8008A05", "", 1, 0, 0, null, "", "");
            return;
          case 2131372093: 
            if (!NetworkUtil.d(this))
            {
              QQToast.a(this, 2131436452, 0).b(getTitleBarHeight());
              return;
            }
            break;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo == null);
        if (!a()) {
          ((VasExtensionHandler)this.app.a(71)).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqVasAvatarPendantShopSeriesInfo.jdField_a_of_type_Int, -1);
        }
        VasWebviewUtil.reportCommercialDrainage(this.app.getCurrentAccountUin(), "faceAddon", "0X80088EE", "", 1, 0, 0, null, "", "");
        ReportController.b(this.app, "CliOper", "", "", "0X8005FDB", "0X8005FDB", 0, 0, String.valueOf(this.jdField_a_of_type_Long), "", "", "");
        return;
        if (ProfileCardUtil.a()) {
          QQToast.a(this, 1, 2131434550, 0).b(getTitleBarHeight());
        }
        for (;;)
        {
          ReportController.b(this.app, "CliOper", "", "", "0X8004174", "0X8004174", this.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h, 0, "", "", "", "");
          return;
          d();
        }
      } while (paramView.getTag() == null);
      long l1 = ((Integer)paramView.getTag()).intValue();
      paramView = ((AvatarPendantManager)this.app.getManager(45)).a();
      i1 = 0;
      if (i1 < paramView.size())
      {
        AvatarPendantShopSeriesInfo localAvatarPendantShopSeriesInfo = (AvatarPendantShopSeriesInfo)paramView.get(i1);
        if ((localAvatarPendantShopSeriesInfo != null) && (localAvatarPendantShopSeriesInfo.jdField_a_of_type_Int == l1)) {
          if (localAvatarPendantShopSeriesInfo.jdField_a_of_type_Boolean) {
            break label670;
          }
        }
        for (boolean bool = true;; bool = false)
        {
          localAvatarPendantShopSeriesInfo.jdField_a_of_type_Boolean = bool;
          i1 += 1;
          break;
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a(paramView);
      return;
      i1 = ((FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams()).height;
    } while ((this.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter == null) || (i1 == this.g));
    j();
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    boolean bool3 = false;
    if (this.jdField_a_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      paramView = findViewById(2131372080);
      View localView = findViewById(2131367454);
      if (this.jdField_a_of_type_AndroidWidgetTextView.getRight() > this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.getLeft())
      {
        paramInt1 = 1;
        paramInt2 = paramView.getTop();
        paramInt3 = this.jdField_b_of_type_AndroidWidgetImageView.getBottom();
        paramInt4 = this.jdField_a_of_type_AndroidViewView.getTop();
        if (paramInt2 + paramInt3 <= localView.getTop() + paramInt4) {
          break label181;
        }
        paramInt2 = 1;
        label89:
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break label186;
        }
      }
    }
    label181:
    label186:
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
        ThreadManager.getUIHandler().post(new wpv(this, bool1, bool2));
      }
      return;
      paramInt1 = 0;
      break;
      paramInt2 = 0;
      break label89;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity
 * JD-Core Version:    0.7.0.1
 */