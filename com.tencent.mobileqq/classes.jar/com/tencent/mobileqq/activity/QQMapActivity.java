package com.tencent.mobileqq.activity;

import aaek;
import ablk;
import abll;
import ablm;
import abln;
import ablo;
import ablp;
import abls;
import ablt;
import ablu;
import ablv;
import ablx;
import ably;
import ablz;
import abma;
import ajjy;
import akfu;
import akfx;
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
import android.support.annotation.NonNull;
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
import aphp;
import awqx;
import awui;
import awul;
import awum;
import awuv;
import azvu;
import babr;
import badq;
import bafb;
import bbmr;
import begr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.out.activity.MapActivity;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.theme.SkinnableActivityProcesser;
import com.tencent.theme.SkinnableActivityProcesser.Callback;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.RejectedExecutionException;
import mpv;
import mqq.app.Foreground;
import org.json.JSONException;
import org.json.JSONObject;

public class QQMapActivity
  extends MapActivity
  implements bbmr, SkinnableActivityProcesser.Callback
{
  public double a;
  public long a;
  akfx jdField_a_of_type_Akfx = new ably(this, "QQMapActivity", true);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new abln(this);
  Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  protected Button a;
  public begr a;
  GeoPoint jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint;
  public QQMapView a;
  public TencentMap a;
  public Marker a;
  public Polyline a;
  SkinnableActivityProcesser jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser;
  public SystemBarCompact a;
  public double b;
  float jdField_b_of_type_Float;
  private BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = new ablo(this);
  protected View.OnClickListener b;
  Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  protected TextView b;
  public GeoPoint b;
  private Marker jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelMarker;
  protected View.OnClickListener c;
  public ImageView c;
  public LinearLayout c;
  public TextView c;
  protected View.OnClickListener d;
  protected TextView d;
  protected View.OnClickListener e;
  public TextView e;
  protected View f;
  protected View g;
  public String g;
  protected View h;
  protected String h;
  public View i;
  public String i;
  protected View j;
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
  protected boolean o;
  public String p;
  public boolean p = false;
  public String q;
  public boolean q = true;
  protected boolean r;
  public boolean s;
  public boolean t = true;
  public boolean u = true;
  public int w;
  
  public QQMapActivity()
  {
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_n_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidViewView$OnClickListener = new abls(this);
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new ablt(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new ablu(this);
    this.jdField_e_of_type_AndroidViewView$OnClickListener = new ablv(this);
  }
  
  private void a()
  {
    super.showDialog(0);
    akfu.a(this.jdField_a_of_type_Akfx);
    if (QLog.isColorLevel()) {
      QLog.d("get_location", 2, "start get location");
    }
  }
  
  public static boolean a(String paramString, ArrayList<String> paramArrayList)
  {
    if (Foreground.sCountActivity > 0) {}
    while ((paramString == null) || (paramString.length() == 0) || ((!paramString.equals(BaseApplicationImpl.getLocalVerify(paramArrayList, false))) && (!paramString.equals(BaseApplicationImpl.getLocalVerify(paramArrayList, true))))) {
      return false;
    }
    return true;
  }
  
  public Dialog a(int paramInt1, int paramInt2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return azvu.a(this, getResources().getString(paramInt1), getResources().getString(paramInt2), paramOnDismissListener);
  }
  
  public Dialog a(String paramString)
  {
    Dialog localDialog = new Dialog(this, 2131690181);
    localDialog.setContentView(2131493365);
    TextView localTextView = (TextView)localDialog.findViewById(2131299579);
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
    return localDialog;
  }
  
  public Intent a()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap() != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().getCameraPosition() != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().getCameraPosition().target != null))
    {
      LatLng localLatLng = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().getCameraPosition().target;
      localBundle.putString("latitude", String.valueOf(localLatLng.getLatitude()));
      localBundle.putString("longitude", String.valueOf(localLatLng.getLongitude()));
    }
    localBundle.putString("description", this.jdField_g_of_type_JavaLangString);
    if ((TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) || (this.jdField_l_of_type_JavaLangString.equals(getString(2131629546)))) {
      this.jdField_l_of_type_JavaLangString = getString(2131628363);
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
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap != null)
    {
      GeoPoint localGeoPoint = new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(localGeoPoint.getLatitudeE6() / 1000000.0D, localGeoPoint.getLongitudeE6() / 1000000.0D)));
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
  
  public void a(GeoPoint paramGeoPoint) {}
  
  protected void a(GeoPoint paramGeoPoint, TextView paramTextView, boolean paramBoolean)
  {
    this.jdField_g_of_type_JavaLangString = "";
    try
    {
      new abma(this, paramGeoPoint, paramTextView).execute(new GeoPoint[] { paramGeoPoint });
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
    do
    {
      try
      {
        paramString = new BitmapFactory.Options();
        paramString.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), 2130838492, paramString);
        if ((this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap != null) && (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getProjection() != null))
        {
          paramGeoPoint = new LatLng(paramGeoPoint.getLatitudeE6() / 1000000.0D, paramGeoPoint.getLongitudeE6() / 1000000.0D);
          if (this.jdField_g_of_type_AndroidViewView != null) {
            continue;
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          try
          {
            this.jdField_g_of_type_AndroidViewView = getLayoutInflater().inflate(2131493612, null);
            paramString = (ImageView)this.jdField_g_of_type_AndroidViewView.findViewById(2131300706);
            paramString.setImageResource(2130838492);
            paramString.setBackgroundDrawable(null);
            this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelMarker = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.jdField_g_of_type_AndroidViewView)).position(paramGeoPoint).snippet(""));
            this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelMarker.showInfoWindow();
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
    } while ((this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelMarker == null) || ((paramGeoPoint.getLatitude() == this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelMarker.getPosition().getLatitude()) && (paramGeoPoint.getLongitude() == this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelMarker.getPosition().getLongitude())));
    this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelMarker.setPosition(paramGeoPoint);
    this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelMarker.setSnippet("");
    this.jdField_b_of_type_ComTencentTencentmapMapsdkMapsModelMarker.showInfoWindow();
  }
  
  public void a(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp) {}
  
  public void a(LBSShare.LocationResp paramLocationResp, Bundle paramBundle) {}
  
  public void a(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
    if (!badq.d(this))
    {
      x();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        requestPermissions(new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 1);
        return;
      }
      a();
      return;
    }
    a();
  }
  
  protected boolean a()
  {
    return true;
  }
  
  boolean a(GeoPoint paramGeoPoint)
  {
    if (this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint == null) {
      this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint = paramGeoPoint;
    }
    while ((paramGeoPoint == null) || (Math.abs(paramGeoPoint.getLatitudeE6() - this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6()) >= 1) || (Math.abs(paramGeoPoint.getLongitudeE6() - this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6()) >= 1)) {
      return false;
    }
    return true;
  }
  
  protected void c() {}
  
  public void d() {}
  
  protected void e() {}
  
  public void h()
  {
    this.jdField_l_of_type_Boolean = false;
    if (!this.jdField_k_of_type_Boolean)
    {
      TextView localTextView = (TextView)findViewById(2131302832);
      localTextView.setVisibility(0);
      localTextView.setText(localTextView.getTag().toString());
    }
  }
  
  public void k() {}
  
  public void m()
  {
    this.jdField_c_of_type_AndroidWidgetLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ablk(this));
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
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(new ablp(this));
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
          break label536;
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
        this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130772072);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatMode(2);
        this.jdField_a_of_type_AndroidViewAnimationAnimation.setRepeatCount(1);
        this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this, 2130772073);
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
      label536:
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
      if (!this.u) {}
    }
    try
    {
      int i1 = getResources().getColor(2131101315);
      if (this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact == null)
      {
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact = new SystemBarCompact(this, true, i1);
        if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
          break label409;
        }
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(getResources().getDrawable(2130845215));
      }
      for (;;)
      {
        paramBundle = LayoutInflater.from(this).inflate(2131495599, null);
        if (ImmersiveUtils.isSupporImmersive() == 1)
        {
          paramBundle.setFitsSystemWindows(true);
          paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
          ImmersiveUtils.a(getWindow(), true);
        }
        super.setContentView(paramBundle);
        this.jdField_k_of_type_JavaLangString = super.getIntent().getStringExtra("uin");
        sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
        this.jdField_j_of_type_AndroidViewView = super.findViewById(2131309776);
        this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131309772));
        this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131296589));
        this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299485));
        this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131299694));
        this.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131311760));
        o();
        t();
        q();
        if (!this.jdField_k_of_type_Boolean) {
          break;
        }
        a(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double);
        a(true);
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
        label409:
        this.jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusDrawable(null);
      }
    }
    catch (IllegalStateException paramBundle)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QQMapActivity", 2, " getResources() has IllegalStateException e = " + paramBundle);
          continue;
          a(true);
        }
      }
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
      return a(getString(2131627394));
      localDialog = a(2131626987, 2131626986, new ablz(this));
      localObject = localDialog.findViewById(2131299568);
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new abll(this, localDialog));
      }
      localView = localDialog.findViewById(2131299574);
      localObject = localDialog;
    } while (localView == null);
    localView.setOnClickListener(new ablm(this, localDialog));
    return localDialog;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser != null) {
      this.jdField_a_of_type_ComTencentThemeSkinnableActivityProcesser.destory();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.a();
    }
    if (a())
    {
      sendBroadcast(new Intent("com.tencent.mobileqq.removeLbsObserver"));
      sendBroadcast(new Intent("com.tencent.mobileqq.unregisterReceiver"));
    }
    super.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    super.unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onMapScrollEnd(GeoPoint paramGeoPoint)
  {
    if ((!this.jdField_k_of_type_Boolean) && (!a(paramGeoPoint)))
    {
      this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint = paramGeoPoint;
      a(paramGeoPoint);
    }
  }
  
  public void onMapScrollStart(GeoPoint paramGeoPoint) {}
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.onPause();
    }
  }
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramInt == 1)
    {
      if (paramArrayOfInt[0] == 0) {
        a(this.s);
      }
    }
    else {
      return;
    }
    babr.a(this, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.onResume();
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.onStart();
    }
    Foreground.onStart(null, this);
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.onStop();
    }
    this.q = true;
    Foreground.onStop(null);
    BaseActivity.mAppForground = GesturePWDUtils.getAppForground(this);
    akfu.b(this.jdField_a_of_type_Akfx);
    if (!BaseActivity.mAppForground) {
      GesturePWDUtils.setAppForground(this, BaseActivity.mAppForground);
    }
  }
  
  public void onUserLeaveHint()
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
    findViewById(2131309912).setVisibility(8);
    this.jdField_i_of_type_AndroidViewView = findViewById(2131307351);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView = ((QQMapView)findViewById(2131304094));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131306017));
    this.jdField_h_of_type_AndroidViewView = findViewById(2131303106);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130841777);
      if (localBitmap != null)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
        this.jdField_c_of_type_AndroidWidgetImageView.setPadding(0, 0, 0, localBitmap.getHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setContentDescription(getString(2131629551));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().getUiSettings().setLogoPosition(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().getUiSettings().setScaleViewEnabled(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().getUiSettings().setGestureScaleByMapCenter(true);
      if (!this.jdField_k_of_type_Boolean)
      {
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setObserver(this);
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap();
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.zoomTo(15.0F));
        r();
        s();
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject = null;
        continue;
        if (("SMARTISAN".equals(ROMUtil.getRomName())) && (Build.VERSION.SDK_INT >= 11)) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setLayerType(1, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setObserver(this);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(4);
        try
        {
          this.f = getLayoutInflater().inflate(2131493612, null);
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.f)).position(new LatLng(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double)));
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
      awqx.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "call_googlemap", 0, 0, "", "", "", "");
      this.r = true;
    }
  }
  
  protected void s()
  {
    Object localObject = (ViewGroup)findViewById(2131309578);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131311534);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131302804);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  protected void t()
  {
    Object localObject = (TextView)findViewById(2131302804);
    ((TextView)localObject).setContentDescription(ajjy.a(2131644655));
    ((TextView)localObject).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    localObject = (TextView)findViewById(2131302847);
    if ("group_activity".equals(this.jdField_o_of_type_JavaLangString))
    {
      ((TextView)localObject).setText(2131625237);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302832));
      if (!this.jdField_k_of_type_Boolean) {
        break label213;
      }
      if (!this.jdField_n_of_type_Boolean) {
        break label159;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131629547);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(this.jdField_b_of_type_AndroidWidgetTextView.getText());
      return;
      if (this.jdField_k_of_type_Boolean)
      {
        ((TextView)localObject).setText(2131654467);
        break;
      }
      ((TextView)localObject).setText(2131625236);
      break;
      label159:
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      localObject = (ImageView)findViewById(2131302816);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setImageResource(2130839704);
      ((ImageView)localObject).setContentDescription(getString(2131628666));
      ((ImageView)localObject).setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
    }
    label213:
    if ("group_activity".equals(this.jdField_o_of_type_JavaLangString)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131629541);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setText(2131629547);
    }
  }
  
  public void u()
  {
    Object localObject2 = mpv.a(this.jdField_l_of_type_JavaLangString, 45, "UTF-8", "...");
    String str1 = mpv.a(this.jdField_i_of_type_JavaLangString, 90, "UTF-8", "...");
    Object localObject3 = aaek.f + "http://maps.google.com/maps?q=" + this.jdField_a_of_type_Double + "," + this.jdField_b_of_type_Double + "&iwloc=A&hl=zh-CN (" + str1 + ")";
    if (!getResources().getString(2131630691).equals(localObject2)) {}
    for (Object localObject1 = getResources().getString(2131625719) + " " + (String)localObject2;; localObject1 = getResources().getString(2131625719))
    {
      String str2 = "mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + this.jdField_a_of_type_Double + "&lon=" + this.jdField_b_of_type_Double + "&title=" + (String)localObject2 + "&loc=" + str1;
      localObject1 = new awui(StructMsgForGeneralShare.class).c(32).a((String)localObject1).d((String)localObject3).a("plugin", "", str2, str2, str2).a();
      localObject3 = awuv.a(2);
      ((awum)localObject3).a("http://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", (String)localObject2, str1);
      ((AbsShareMsg)localObject1).addItem((awul)localObject3);
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("forward_type", -3);
      ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
      aphp.a(this, (Intent)localObject2, 0);
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
    babr.a(this, 230).setTitle(getString(2131628951)).setMessage(2131626719).setPositiveButton(getString(2131625014), new ablx(this)).show();
  }
  
  public void y()
  {
    this.jdField_l_of_type_Boolean = true;
    if (!isFinishing()) {
      super.showDialog(1);
    }
    if (!this.jdField_k_of_type_Boolean)
    {
      TextView localTextView = (TextView)findViewById(2131302832);
      localTextView.setVisibility(0);
      localTextView.setText(2131624934);
    }
  }
  
  public void z()
  {
    if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker == null) {}
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130841774);
      if ((localBitmap != null) && (this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint != null))
      {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(localBitmap)).position(new LatLng(this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6() / 1000000.0D, this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6() / 1000000.0D)).title("").snippet(""));
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelMarker.showInfoWindow();
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