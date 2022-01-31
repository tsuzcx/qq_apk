package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.common.util.SubString;
import com.tencent.biz.widgets.PolyLineOverlay;
import com.tencent.biz.widgets.SelfLocationOverlay;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.CustomDialogFactory;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQMapView.QQMapViewObserver;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.MapActivity;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.MapView.LayoutParams;
import com.tencent.tencentmap.mapsdk.map.Overlay;
import com.tencent.tencentmap.mapsdk.map.UiSettings;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.RejectedExecutionException;
import mqq.app.Foreground;
import org.json.JSONException;
import org.json.JSONObject;
import tok;
import tol;
import ton;
import too;
import top;
import toq;
import tot;
import tou;
import tov;
import tow;
import toy;
import toz;
import tpa;

public class QQMapActivity
  extends MapActivity
  implements QQMapView.QQMapViewObserver, SkinnableActivityProcesser.Callback
{
  public double a;
  public long a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new too(this);
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  public Button a;
  public PolyLineOverlay a;
  public SelfLocationOverlay a;
  GeoPoint jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint;
  SosoInterface.OnLocationListener jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener = new toz(this, 1, true, true, 0L, true, true, "QQMapActivity");
  public QQMapView a;
  public MapController a;
  SkinnableActivityProcesser jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
  public ActionSheet a;
  public SystemBarCompact a;
  public double b;
  float jdField_b_of_type_Float;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new top(this);
  protected View.OnClickListener b;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  protected TextView b;
  public GeoPoint b;
  protected View.OnClickListener c;
  public ImageView c;
  public LinearLayout c;
  public TextView c;
  protected View.OnClickListener d;
  public TextView d;
  protected View.OnClickListener e;
  public TextView e;
  protected View f;
  protected View g;
  public String g;
  public View h;
  protected String h;
  public View i;
  public String i;
  public View j;
  public String j;
  public String k;
  public boolean k;
  public String l;
  public boolean l;
  public String m;
  public boolean m;
  public String n;
  boolean n;
  public String o;
  public boolean o;
  public String p;
  public boolean p = false;
  public String q;
  public boolean q = true;
  public boolean r;
  public boolean s;
  public boolean t = true;
  public boolean u = true;
  public int v;
  
  public QQMapActivity()
  {
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_n_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new tot(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new tou(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new tov(this);
    this.jdField_e_of_type_AndroidViewView$OnClickListener = new tow(this);
  }
  
  public static boolean a(String paramString, ArrayList paramArrayList)
  {
    if (Foreground.sCountActivity > 0) {}
    while ((paramString == null) || (paramString.length() == 0) || ((!paramString.equals(BaseApplicationImpl.getLocalVerify(paramArrayList, false))) && (!paramString.equals(BaseApplicationImpl.getLocalVerify(paramArrayList, true))))) {
      return false;
    }
    return true;
  }
  
  public Dialog a(int paramInt1, int paramInt2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return CustomDialogFactory.a(this, getResources().getString(paramInt1), getResources().getString(paramInt2), paramOnDismissListener);
  }
  
  public Dialog a(String paramString)
  {
    Dialog localDialog = new Dialog(this, 2131624516);
    localDialog.setContentView(2130968871);
    TextView localTextView = (TextView)localDialog.findViewById(2131362781);
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
    return localDialog;
  }
  
  public Intent a()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMapCenter();
    localObject = new GeoPoint((int)(((LatLng)localObject).getLatitude() * 1000000.0D), (int)(((LatLng)localObject).getLongitude() * 1000000.0D));
    double d1 = ((GeoPoint)localObject).getLatitudeE6() / 1000000.0D;
    double d2 = ((GeoPoint)localObject).getLongitudeE6() / 1000000.0D;
    localBundle.putString("latitude", String.valueOf(d1));
    localBundle.putString("longitude", String.valueOf(d2));
    localBundle.putString("description", this.jdField_g_of_type_JavaLangString);
    if ((TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) || (this.jdField_l_of_type_JavaLangString.equals(getString(2131437033)))) {
      this.jdField_l_of_type_JavaLangString = getString(2131433972);
    }
    if (TextUtils.isEmpty(this.m)) {
      this.m = "Unknown Address";
    }
    localBundle.putString("title", this.jdField_l_of_type_JavaLangString);
    localBundle.putString("summary", this.m);
    localBundle.putString("dianping_id", this.jdField_n_of_type_JavaLangString);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  protected void a(double paramDouble1, double paramDouble2)
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController != null)
    {
      GeoPoint localGeoPoint = new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter(localGeoPoint);
      if ((this.jdField_i_of_type_JavaLangString == null) || (this.jdField_i_of_type_JavaLangString.length() <= 0)) {
        a(localGeoPoint, this.jdField_d_of_type_AndroidWidgetTextView, false);
      }
    }
    else
    {
      return;
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_i_of_type_JavaLangString);
    n();
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    if ((!this.jdField_k_of_type_Boolean) && (!a(paramGeoPoint)))
    {
      this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint = paramGeoPoint;
      c(paramGeoPoint);
    }
  }
  
  protected void a(GeoPoint paramGeoPoint, TextView paramTextView, boolean paramBoolean)
  {
    this.jdField_g_of_type_JavaLangString = "";
    try
    {
      new QQMapActivity.GetLocNameTask(this, paramGeoPoint, paramTextView).execute(new GeoPoint[] { paramGeoPoint });
      if (paramBoolean) {
        v();
      }
      return;
    }
    catch (RejectedExecutionException paramGeoPoint)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQMapActivity", 2, paramGeoPoint.getMessage());
    }
  }
  
  public void a(GeoPoint paramGeoPoint, String paramString)
  {
    int i1 = DisplayUtil.a(this, 10.0F);
    try
    {
      paramString = new BitmapFactory.Options();
      paramString.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(getResources(), 2130838210, paramString);
      int i2 = paramString.outHeight;
      i1 = i2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        try
        {
          this.jdField_g_of_type_AndroidViewView = getLayoutInflater().inflate(2130969049, null);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.addView(this.jdField_g_of_type_AndroidViewView, paramGeoPoint);
          paramGeoPoint = (ImageView)this.jdField_g_of_type_AndroidViewView.findViewById(2131364880);
          paramGeoPoint.setImageResource(2130838210);
          paramGeoPoint.setBackgroundDrawable(null);
          paramGeoPoint = (ImageView)this.jdField_g_of_type_AndroidViewView.findViewById(2131364879);
          paramString = AnimationUtils.loadAnimation(this, 17432576);
          paramString.setDuration(800L);
          paramString.setRepeatCount(2);
          paramString.setRepeatCount(-1);
          paramGeoPoint.startAnimation(paramString);
          return;
        }
        catch (Resources.NotFoundException paramGeoPoint)
        {
          paramGeoPoint.printStackTrace();
          return;
        }
        paramString = paramString;
        paramString.printStackTrace();
      }
    }
    paramGeoPoint = new MapView.LayoutParams(-2, -2, paramGeoPoint, 0, i1, 81);
    if (this.jdField_g_of_type_AndroidViewView == null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.updateViewLayout(this.jdField_g_of_type_AndroidViewView, paramGeoPoint);
      return;
    }
    catch (IllegalArgumentException paramGeoPoint)
    {
      paramGeoPoint.printStackTrace();
    }
  }
  
  public void a(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp) {}
  
  public void a(LBSShare.LocationResp paramLocationResp, Bundle paramBundle) {}
  
  public void a(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle) {}
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
    if (!NetworkUtil.d(this)) {
      x();
    }
    do
    {
      return;
      super.showDialog(0);
      SosoInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    } while (!QLog.isColorLevel());
    QLog.d("get_location", 2, "start get location");
  }
  
  public boolean a()
  {
    return true;
  }
  
  boolean a(GeoPoint paramGeoPoint)
  {
    if (this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint == null) {
      this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint = paramGeoPoint;
    }
    while ((paramGeoPoint == null) || (Math.abs(paramGeoPoint.getLatitudeE6() - this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6()) >= 1) || (Math.abs(paramGeoPoint.getLongitudeE6() - this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6()) >= 1)) {
      return false;
    }
    return true;
  }
  
  public void b(GeoPoint paramGeoPoint) {}
  
  public void c() {}
  
  public void c(GeoPoint paramGeoPoint) {}
  
  public void d() {}
  
  public void e() {}
  
  public void h()
  {
    this.jdField_l_of_type_Boolean = false;
    if (!this.jdField_k_of_type_Boolean)
    {
      TextView localTextView = (TextView)findViewById(2131363447);
      localTextView.setVisibility(0);
      localTextView.setText(localTextView.getTag().toString());
    }
  }
  
  public void k() {}
  
  public void m()
  {
    this.jdField_c_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new tok(this));
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "refreshStreetViewIcon: hideStreet=" + this.jdField_o_of_type_Boolean + ", url=" + this.jdField_j_of_type_JavaLangString);
    }
    if ((this.jdField_j_of_type_JavaLangString == null) || (this.jdField_j_of_type_JavaLangString.length() == 0)) {
      if (this.jdField_h_of_type_AndroidViewView != null) {
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      }
    }
    while ((this.jdField_h_of_type_AndroidViewView == null) || (this.jdField_o_of_type_Boolean)) {
      return;
    }
    this.jdField_h_of_type_AndroidViewView.setVisibility(0);
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(new toq(this));
  }
  
  protected void o()
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Bundle localBundle = getIntent().getExtras();
    String str = localBundle.getString("options");
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject(str);
        if (localObject1 == null) {
          break label533;
        }
        localObject5 = ((JSONObject)localObject1).optString("lat");
        str = ((JSONObject)localObject1).optString("lng");
        this.jdField_l_of_type_JavaLangString = ((JSONObject)localObject1).optString("title");
        this.jdField_i_of_type_JavaLangString = ((JSONObject)localObject1).optString("desc");
        if (((JSONObject)localObject1).has("from")) {
          localObject4 = ((JSONObject)localObject1).optString("from");
        }
        this.jdField_o_of_type_JavaLangString = ((String)localObject4);
        this.jdField_n_of_type_Boolean = "share".equals(((JSONObject)localObject1).opt("action"));
        this.jdField_h_of_type_JavaLangString = ("http://maps.google.com/maps?q=" + (String)localObject5 + "," + str + "&iwloc=A&hl=zh-CN (" + this.jdField_i_of_type_JavaLangString + ")");
        localObject1 = str;
        localObject4 = localObject5;
        localObject5 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          localObject5 = localBundle.getString("lat");
        }
        localObject4 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject4 = localBundle.getString("lon");
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject5)) && (!TextUtils.isEmpty((CharSequence)localObject4)))
        {
          this.jdField_k_of_type_Boolean = true;
          this.jdField_a_of_type_Double = Double.valueOf((String)localObject5).doubleValue();
          this.jdField_b_of_type_Double = Double.valueOf((String)localObject4).doubleValue();
        }
        if (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) {
          this.jdField_l_of_type_JavaLangString = localBundle.getString("title");
        }
        this.m = localBundle.getString("summary");
        if (TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString)) {
          this.jdField_h_of_type_JavaLangString = localBundle.getString("url");
        }
        if (TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
          this.jdField_i_of_type_JavaLangString = localBundle.getString("loc");
        }
        if ((this.jdField_i_of_type_JavaLangString != null) && (this.jdField_i_of_type_JavaLangString.contains("+"))) {
          this.jdField_i_of_type_JavaLangString = this.jdField_i_of_type_JavaLangString.replace("+", " ");
        }
        this.jdField_n_of_type_JavaLangString = localBundle.getString("dpid");
        this.jdField_b_of_type_Float = getResources().getDisplayMetrics().density;
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2131034198);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatCount(1);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2131034199);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
        this.jdField_b_of_type_AndroidViewAnimationAnimation.setRepeatCount(1);
        return;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("get_params", 2, "parse params failed, options : " + str);
        }
        Object localObject2 = null;
        continue;
      }
      catch (NullPointerException localNullPointerException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("get_params", 2, "parse params failed, options : " + str);
        }
      }
      Object localObject3 = null;
      continue;
      label533:
      localObject4 = null;
      localObject3 = localObject5;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {}
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    super.setResult(-1, new Intent());
    try
    {
      c();
      super.onBackPressed();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      super.finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser = new SkinnableActivityProcesser(this, this);
    if ((this.t) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.u)
      {
        int i1 = getResources().getColor(2131494260);
        if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact == null) {
          this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(this, true, i1);
        }
      }
    }
    paramBundle = LayoutInflater.from(this).inflate(2130970691, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    super.setContentView(paramBundle);
    this.jdField_k_of_type_JavaLangString = super.getIntent().getStringExtra("uin");
    sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
    this.jdField_j_of_type_AndroidViewView = super.findViewById(2131371621);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131371626));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371623));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371625));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371624));
    this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131371622));
    o();
    t();
    q();
    if (this.jdField_k_of_type_Boolean)
    {
      a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
      a(true);
    }
    for (;;)
    {
      paramBundle = new IntentFilter();
      paramBundle.addAction("com.tencent.mobileqq.onGetStreetViewUrl");
      paramBundle.addAction("com.tencent.mobileqq.onGetLbsShareSearch");
      paramBundle.addAction("com.tencent.mobileqq.onGetLbsShareShop");
      paramBundle.addAction("com.tencent.mobileqq.onGetShareShopDetail");
      registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
      paramBundle = new IntentFilter();
      paramBundle.addAction("android.intent.action.SCREEN_OFF");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      if (this.jdField_k_of_type_Boolean) {
        sendBroadcast(new Intent("com.tencent.mobileqq.getStreetViewUrl").putExtra("latitude", this.jdField_a_of_type_Double).putExtra("longitude", this.jdField_b_of_type_Double));
      }
      return;
      a(true);
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    Dialog localDialog;
    View localView;
    do
    {
      return localObject;
      return a(getString(2131433952));
      localDialog = a(2131433967, 2131433968, new tpa(this));
      localObject = localDialog.findViewById(2131364062);
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new tol(this, localDialog));
      }
      localView = localDialog.findViewById(2131364063);
      localObject = localDialog;
    } while (localView == null);
    localView.setOnClickListener(new ton(this, localDialog));
    return localDialog;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser != null) {
      this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser.destory();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.destroy();
    }
    if (a())
    {
      sendBroadcast(new Intent("com.tencent.mobileqq.removeLbsObserver"));
      sendBroadcast(new Intent("com.tencent.mobileqq.unregisterReceiver"));
    }
    super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null) {
      this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.init();
    }
    BaseActivity.mAppForground = GesturePWDUtils.getAppForground(this);
    if ((!BaseActivity.mAppForground) && (GesturePWDUtils.getGesturePWDState(this, this.jdField_k_of_type_JavaLangString) == 2) && (GesturePWDUtils.getGesturePWDMode(this, this.jdField_k_of_type_JavaLangString) == 21))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqbaseactivity", 2, "qqmapactivity.start lock. GesturePWDUnlockActivity");
      }
      super.startActivity(new Intent(this, GesturePWDUnlockActivity.class));
    }
    for (this.p = true;; this.p = false)
    {
      if (!BaseActivity.mAppForground)
      {
        BaseActivity.mAppForground = true;
        GesturePWDUtils.setAppForground(this, BaseActivity.mAppForground);
      }
      this.q = false;
      if (!this.s) {
        a(false);
      }
      return;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    Foreground.onStart(null, this);
  }
  
  protected void onStop()
  {
    super.onStop();
    this.q = true;
    Foreground.onStop(null);
    BaseActivity.mAppForground = GesturePWDUtils.getAppForground(this);
    SosoInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$OnLocationListener);
    if (!BaseActivity.mAppForground) {
      GesturePWDUtils.setAppForground(this, BaseActivity.mAppForground);
    }
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    sendBroadcast(new Intent("com.tencent.mobileqq.showNotification"));
  }
  
  public void p()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", this.jdField_j_of_type_JavaLangString);
    localIntent.putExtra("reqType", 4);
    super.startActivity(localIntent);
    e();
  }
  
  protected void q()
  {
    findViewById(2131365662).setVisibility(8);
    this.jdField_i_of_type_AndroidViewView = findViewById(2131371609);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView = ((QQMapView)findViewById(2131371617));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368000));
    this.jdField_h_of_type_AndroidViewView = findViewById(2131371620);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130840454);
      if (localBitmap != null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        this.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, localBitmap.getHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setContentDescription(getString(2131430504));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getUiSettings().setLogoPosition(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getUiSettings().setScaleControlsEnabled(false);
      if (!this.jdField_k_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setObserver(this);
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getController();
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setZoom(18);
        r();
        s();
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        MapView.LayoutParams localLayoutParams = null;
        continue;
        if (Build.VERSION.SDK_INT >= 11) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setLayerType(1, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setObserver(this);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
        try
        {
          this.f = getLayoutInflater().inflate(2130969049, null);
          localLayoutParams = new MapView.LayoutParams(-2, -2, new GeoPoint((int)(this.jdField_a_of_type_Double * 1000000.0D), (int)(this.jdField_b_of_type_Double * 1000000.0D)), 81);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.addView(this.f, localLayoutParams);
          n();
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQMapActivity", 2, localNotFoundException.getMessage());
          }
          super.finish();
        }
      }
    }
  }
  
  protected void r()
  {
    String str = TimeZone.getDefault().getID();
    if (QLog.isColorLevel()) {
      QLog.d("QQMapActivity", 2, "default timezone:" + str);
    }
    if (((!"Asia/Shanghai".equals(str)) && (!"Asia/Hong_Kong".equals(str)) && (!"Asia/Chongqing".equals(str)) && (!"Asia/Beijing".equals(str))) || (!"zh".equals(Locale.getDefault().getLanguage())))
    {
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "call_googlemap", 0, 0, "", "", "", "");
      this.r = true;
    }
  }
  
  protected void s()
  {
    Object localObject = (ViewGroup)findViewById(2131363261);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131363397);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131363262);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  public void t()
  {
    Object localObject = (TextView)findViewById(2131363262);
    ((TextView)localObject).setText("返回");
    ((TextView)localObject).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    localObject = (TextView)findViewById(2131363400);
    if ("group_activity".equals(this.jdField_o_of_type_JavaLangString))
    {
      ((TextView)localObject).setText(2131433951);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363447));
      if (!this.jdField_k_of_type_Boolean) {
        break label210;
      }
      if (!this.jdField_n_of_type_Boolean) {
        break label156;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433948);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      return;
      if (this.jdField_k_of_type_Boolean)
      {
        ((TextView)localObject).setText(2131433855);
        break;
      }
      ((TextView)localObject).setText(2131433950);
      break;
      label156:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = (ImageView)findViewById(2131363493);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setImageResource(2130839162);
      ((ImageView)localObject).setContentDescription(getString(2131433953));
      ((ImageView)localObject).setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
    }
    label210:
    if ("group_activity".equals(this.jdField_o_of_type_JavaLangString)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433949);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131433948);
    }
  }
  
  public void u()
  {
    Object localObject2 = SubString.a(this.jdField_l_of_type_JavaLangString, 45, "UTF-8", "...");
    String str1 = SubString.a(this.jdField_i_of_type_JavaLangString, 90, "UTF-8", "...");
    Object localObject3 = "我在这里，点击查看：http://maps.google.com/maps?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "&iwloc=A&hl=zh-CN (" + str1 + ")";
    if (!getResources().getString(2131430562).equals(localObject2)) {}
    for (Object localObject1 = getResources().getString(2131435587) + " " + (String)localObject2;; localObject1 = getResources().getString(2131435587))
    {
      String str2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + this.jdField_a_of_type_Double + "&lon=" + this.jdField_b_of_type_Double + "&title=" + (String)localObject2 + "&loc=" + str1;
      localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).b(32).a((String)localObject1).b((String)localObject3).a("plugin", str2, str2, str2, str2).a();
      localObject3 = StructMsgElementFactory.a(2);
      ((AbsStructMsgItem)localObject3).a("http://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", (String)localObject2, str1);
      ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject3);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("forward_type", -3);
      ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      ForwardBaseOption.a(this, (Intent)localObject2, 0);
      return;
    }
  }
  
  void v()
  {
    if (this.jdField_c_of_type_AndroidWidgetImageView.getVisibility() == 0) {
      this.jdField_c_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void w()
  {
    a(true);
  }
  
  public void x()
  {
    DialogUtil.a(this, 230).setTitle(getString(2131434461)).setMessage(2131433023).setPositiveButton(getString(2131433711), new toy(this)).show();
  }
  
  public void y()
  {
    this.jdField_l_of_type_Boolean = true;
    if (!isFinishing()) {
      super.showDialog(1);
    }
    if (!this.jdField_k_of_type_Boolean)
    {
      TextView localTextView = (TextView)findViewById(2131363447);
      localTextView.setVisibility(0);
      localTextView.setText(2131434368);
    }
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsSelfLocationOverlay == null) {}
    try
    {
      Object localObject = BitmapFactory.decodeResource(getResources(), 2130840451);
      if (localObject != null)
      {
        localObject = new SelfLocationOverlay(this, (Bitmap)localObject, this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint, this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.addOverlay((Overlay)localObject);
        this.jdField_a_of_type_ComTencentBizWidgetsSelfLocationOverlay = ((SelfLocationOverlay)localObject);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqmap", 2, "addSelfLay:", localOutOfMemoryError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity
 * JD-Core Version:    0.7.0.1
 */