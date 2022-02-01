package com.tencent.biz;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.widgets.QQMapRoutingHelper;
import com.tencent.biz.widgets.QQMapRoutingHelper.RouteListener;
import com.tencent.component.network.utils.PlatformUtil;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare.DPBiz;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.proto.lbsshare.LBSShare.Shop;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PoiMapActivity
  extends QQMapActivity
  implements View.OnClickListener, QQMapRoutingHelper.RouteListener
{
  protected ImageButton A;
  protected TextView B;
  protected RelativeLayout C;
  protected View D;
  XListView E;
  protected String F;
  protected boolean G = false;
  protected int H = 0;
  protected boolean I = false;
  protected boolean J = false;
  protected List<PoiMapActivity.POI> K = new ArrayList();
  PoiMapActivity.SearchResultAdapter L;
  protected View M;
  protected int N;
  protected int O;
  protected int P;
  protected int Q;
  protected int R;
  protected int S;
  protected int T;
  protected String U;
  protected boolean V = true;
  protected boolean W = false;
  protected ImageView X;
  protected PoiMapActivity.PoiMapNameTask Y;
  protected boolean Z;
  public final String a = "PoiMapActivity";
  protected int aa;
  protected String ab;
  protected String ac;
  protected boolean ad = true;
  protected QQMapRoutingHelper ae;
  protected ImageView af;
  View.OnTouchListener ag = new PoiMapActivity.2(this);
  View.OnKeyListener ah = new PoiMapActivity.10(this);
  protected AbsListView.OnScrollListener ai = new PoiMapActivity.11(this);
  public View.OnClickListener aj = new PoiMapActivity.13(this);
  public final ViewTreeObserver.OnPreDrawListener ak = new PoiMapActivity.14(this);
  String[] al = { HardCodeUtil.a(2131906101), HardCodeUtil.a(2131906100), HardCodeUtil.a(2131906102), HardCodeUtil.a(2131906098) };
  String[] am = { "", "281100|281200", "281000|281010|281011|281012|281013|281099", "100000|130000" };
  protected LinearLayout an;
  private View ao;
  protected View b;
  protected View c;
  protected PoiMapActivity.PoiTab[] d;
  protected int e;
  protected int f;
  protected int g;
  protected int h;
  protected int i;
  protected int j;
  protected int k;
  protected float l;
  public int m;
  public int n;
  public int o;
  public int p;
  public String q;
  protected int r;
  protected boolean s = true;
  View t;
  LinearLayout u;
  protected boolean v = false;
  protected final int w = 20;
  protected boolean x = false;
  protected AuthorizeConfig y;
  EditText z;
  
  public void a()
  {
    this.u = ((LinearLayout)super.findViewById(2131442438));
    this.b = super.findViewById(2131445383);
    this.c = super.findViewById(2131440467);
    this.ao = super.findViewById(2131437940);
    this.af = ((ImageView)super.findViewById(2131440472));
    this.af.setContentDescription(getString(2131892672));
    this.af.setVisibility(0);
    this.af.setOnClickListener(this);
    if (this.startWithPos)
    {
      a("rec_locate", "pageview_all", "", "", "", "");
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      this.mRouteBar.setVisibility(0);
      this.mRouteBtn.setOnClickListener(this);
      if (!TextUtils.isEmpty(this.mCurPoiName))
      {
        this.mAddrTxt.setText(this.mCurPoiName);
        this.mAddrTxt.setVisibility(0);
      }
      else
      {
        this.mAddrTxt.setVisibility(8);
      }
      this.mDetailAddrTxt.setText(this.loc);
      this.mapView.getMap().getUiSettings().setLogoPosition(2);
    }
    else
    {
      this.b.setVisibility(0);
      this.c.setVisibility(0);
      this.mRouteBar.setVisibility(8);
      e();
      if (!"group_activity".equals(this.mFrom))
      {
        this.mapView.getMap().setOnMapClickListener(new PoiMapActivity.1(this));
        this.M = this.c.findViewById(2131440474);
        this.M.setOnClickListener(this);
      }
    }
    Object localObject = (FrameLayout.LayoutParams)this.ao.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = (this.O + this.P);
    this.ao.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.t = super.findViewById(2131447463);
    this.X = ((ImageView)super.findViewById(2131433666));
    super.findViewById(2131429816).setVisibility(8);
    localObject = (EditText)this.b.findViewById(2131432634);
    ((EditText)localObject).setFocusable(false);
    ((EditText)localObject).setOnTouchListener(this.ag);
  }
  
  public void a(int paramInt)
  {
    PoiMapActivity.PoiTab[] arrayOfPoiTab = this.d;
    if (arrayOfPoiTab != null)
    {
      if (paramInt >= arrayOfPoiTab.length) {
        return;
      }
      this.r = paramInt;
      int i2 = arrayOfPoiTab.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (i1 == paramInt)
        {
          this.d[i1].a(true);
          this.d[i1].b(true);
        }
        else
        {
          this.d[i1].a(false);
        }
        i1 += 1;
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.getLbsShareSearch");
    localIntent.putExtra("latitude", paramInt1);
    localIntent.putExtra("longitude", paramInt2);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("category", paramString2);
    localIntent.putExtra("page", paramInt3);
    localIntent.putExtra("count", paramInt4);
    localIntent.putExtra("coordinate", 1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSearchDataFromServer:lat=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",lon=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",keyword=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",category=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",page=");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(",count=");
      localStringBuilder.append(paramInt4);
      QLog.d("Q.qqmap", 2, localStringBuilder.toString());
    }
    if ((paramInt3 == 0) && (TextUtils.isEmpty(paramString1)))
    {
      if (TextUtils.isEmpty(paramString2)) {
        localIntent.putExtra("requireMyLbs", 1);
      }
    }
    else {
      localIntent.putExtra("requireMyLbs", 0);
    }
    super.sendBroadcast(localIntent);
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    if (this.pinView != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.pinView.getLayoutParams();
      if (paramBoolean) {
        localLayoutParams.topMargin += paramInt;
      } else {
        localLayoutParams.topMargin = paramInt;
      }
      this.pinView.setLayoutParams(localLayoutParams);
    }
  }
  
  protected void a(PoiMapActivity.POI paramPOI)
  {
    this.mCurPoiAdr = paramPOI.b;
    this.mCurPoiName = paramPOI.a;
    this.U = paramPOI.c;
    this.m = paramPOI.k;
    this.n = paramPOI.l;
    this.o = this.m;
    this.p = this.n;
    this.mDianpingId = paramPOI.f;
    this.q = paramPOI.c;
    this.x = true;
    int i2 = this.d.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (i1 == 0)
      {
        this.d[0].h.a(false);
        this.d[0].a(0, false);
      }
      else
      {
        this.d[i1].a(-1, false);
      }
      i1 += 1;
    }
    a(0);
    TencentMap localTencentMap = this.tencentMap;
    double d1 = paramPOI.k;
    Double.isNaN(d1);
    d1 /= 1000000.0D;
    double d2 = paramPOI.l;
    Double.isNaN(d2);
    localTencentMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(d1, d2 / 1000000.0D)));
  }
  
  protected void a(String paramString)
  {
    this.E.setVisibility(8);
    this.B.setVisibility(0);
    this.B.setText(getString(2131892665));
    this.F = paramString;
    this.H = 0;
    this.G = false;
    this.J = false;
    a(this.m, this.n, paramString, "", 0, 20);
    this.L.notifyDataSetChanged();
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  protected void a(String paramString, List<PoiMapActivity.POI> paramList, boolean paramBoolean)
  {
    List localList = this.K;
    if (localList == null)
    {
      this.K = new ArrayList();
    }
    else
    {
      if (this.H == 0) {
        localList.clear();
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.K.addAll(paramList);
        if (this.startWithPos) {
          a("share_locate", "click_sch", paramString, "0", "", "");
        } else {
          a("share_locate", "click_sch", paramString, "0", this.ac, this.ab);
        }
      }
      else if (this.startWithPos)
      {
        a("share_locate", "click_sch", paramString, "1", "", "");
      }
      else
      {
        a("share_locate", "click_sch", paramString, "1", this.ac, this.ab);
      }
    }
    this.G = paramBoolean;
    this.J = false;
    if (this.K.isEmpty())
    {
      this.B.setText(getString(2131916105));
      this.B.setVisibility(0);
    }
    else
    {
      this.B.setVisibility(8);
      this.E.setVisibility(0);
    }
    this.L.notifyDataSetChanged();
  }
  
  public void a(ArrayList<PoiMapActivity.POI> paramArrayList, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((this.m != paramInt1) && (this.n != paramInt2)) {
      return;
    }
    paramInt2 = this.d.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (this.am[paramInt1].equals(paramString))
      {
        paramString = this.d[paramInt1];
        boolean bool;
        if (paramInt3 != 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramString.a(paramArrayList, bool, paramInt4, paramBoolean);
        if ((paramInt1 != 0) || (!this.V)) {
          break;
        }
        if ((paramArrayList != null) && (paramArrayList.size() > 1))
        {
          this.d[0].a(0, true);
          if (this.startWithPos) {
            break;
          }
          a("share_locate", "pageview_all", this.ac, this.ab, "", "");
          return;
        }
        this.d[0].a(0, true);
        return;
      }
      paramInt1 += 1;
    }
  }
  
  public void a(List<LatLng> paramList, int paramInt)
  {
    if (paramList != null)
    {
      h();
      localObject = this.tencentMap.addPolyline(new PolylineOptions().addAll(paramList).width(DisplayUtil.a(this, 7.0F)).color(Color.parseColor("#389dff")));
      if (this.mPolyLine == null)
      {
        this.mPolyLine = ((Polyline)localObject);
        listenDistanceChange();
        this.mDistanceTxt.setText(QQMapRoutingHelper.a(paramInt));
      }
    }
    else
    {
      QQToast.makeText(this, 0, HardCodeUtil.a(2131906099), 0).show(getResources().getDimensionPixelSize(2131299920));
    }
    addSelfLay();
    Object localObject = new ArrayList();
    double d1 = this.mSelfGeoPoint.getLatitudeE6();
    Double.isNaN(d1);
    d1 /= 1000000.0D;
    double d2 = this.mSelfGeoPoint.getLongitudeE6();
    Double.isNaN(d2);
    ((ArrayList)localObject).add(new LatLng(d1, d2 / 1000000.0D));
    if ((paramList != null) && (paramList.size() > 0)) {
      ((ArrayList)localObject).addAll(paramList);
    }
    ((ArrayList)localObject).add(new LatLng(this.latitude, this.longitude));
    QQMapRoutingHelper.a((List)localObject, this.mapView, DisplayUtil.a(this, 42.0F));
    this.mapView.invalidate();
  }
  
  void b()
  {
    this.W = false;
    ReportDialog localReportDialog = new ReportDialog(this);
    localReportDialog.setCanceledOnTouchOutside(true);
    InputMethodManager localInputMethodManager = (InputMethodManager)super.getSystemService("input_method");
    int i1 = this.t.getHeight();
    float f1 = -i1;
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, f1);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.u.startAnimation((Animation)localObject1);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setSoftInputMode(36);
    localReportDialog.setContentView(2131629224);
    Object localObject2 = localReportDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = 0;
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject2).gravity = 51;
    localReportDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject2 = new TranslateAnimation(0.0F, 0.0F, f1, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    PoiMapActivity.3 local3 = new PoiMapActivity.3(this, (TranslateAnimation)localObject1, localReportDialog, i1, (TranslateAnimation)localObject2);
    ((TranslateAnimation)localObject1).setAnimationListener(local3);
    ((TranslateAnimation)localObject2).setAnimationListener(local3);
    localReportDialog.setOnDismissListener(new PoiMapActivity.4(this, (TranslateAnimation)localObject2, localInputMethodManager));
    this.D = localReportDialog.findViewById(2131445137);
    this.z = ((EditText)localReportDialog.findViewById(2131432634));
    this.z.addTextChangedListener(new PoiMapActivity.SearchTextWatcher(this));
    this.z.setSelection(0);
    this.z.requestFocus();
    this.z.setOnKeyListener(this.ah);
    this.A = ((ImageButton)localReportDialog.findViewById(2131435215));
    this.A.setOnClickListener(new PoiMapActivity.5(this));
    localObject1 = (Button)localReportDialog.findViewById(2131429816);
    ((Button)localObject1).setVisibility(0);
    ((Button)localObject1).setOnClickListener(new PoiMapActivity.6(this, localReportDialog));
    this.B = ((TextView)localReportDialog.findViewById(2131439366));
    this.C = ((RelativeLayout)localReportDialog.findViewById(2131444724));
    this.C.setOnClickListener(new PoiMapActivity.7(this, localReportDialog));
    this.E = ((XListView)localReportDialog.findViewById(2131445380));
    this.E.setBackgroundDrawable(super.getResources().getDrawable(2130838958));
    this.E.setDividerHeight(0);
    this.K.clear();
    this.L = new PoiMapActivity.SearchResultAdapter(this, this);
    this.E.setAdapter(this.L);
    this.E.setOnScrollListener(this.ai);
    this.E.setOnTouchListener(new PoiMapActivity.8(this, localInputMethodManager));
    this.E.setOnItemClickListener(new PoiMapActivity.9(this, localReportDialog));
    if (1 == HttpUtil.getNetWorkType()) {
      this.I = true;
    } else {
      this.I = false;
    }
    this.v = true;
    QQMapRoutingHelper.a("search", c());
  }
  
  protected void backCall()
  {
    if (this.startWithPos)
    {
      a("rec_locate", "click_rec_return", "", "", "", "");
      return;
    }
    a("share_locate", "click_rec_return", this.ac, this.ab, "", "");
  }
  
  protected String c()
  {
    int i1 = HttpUtil.getNetWorkType();
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          if (i1 != 4) {
            return "others";
          }
          return "4g";
        }
        return "3g";
      }
      return "2g";
    }
    return "Wifi";
  }
  
  protected void d()
  {
    this.y = AuthorizeConfig.a();
    Object localObject2 = this.y.c("poi_category", "");
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      Object localObject1 = null;
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
      if ((localObject1 != null) && (localObject1.length() > 0))
      {
        int i4 = localObject1.length();
        String[] arrayOfString1 = new String[i4];
        String[] arrayOfString2 = new String[i4];
        int i3 = 0;
        int i1 = 0;
        int i2;
        for (;;)
        {
          i2 = i3;
          if (i1 < i4) {
            try
            {
              Object localObject3 = localObject1.getJSONObject(i1);
              String str = ((JSONObject)localObject3).getString("name");
              localObject3 = ((JSONObject)localObject3).getString("id");
              arrayOfString1[i1] = str;
              arrayOfString2[i1] = localObject3;
              i1 += 1;
            }
            catch (JSONException localJSONException1)
            {
              localJSONException1.printStackTrace();
              i2 = 1;
            }
          }
        }
        if (i2 == 0)
        {
          this.al = arrayOfString1;
          this.am = arrayOfString2;
        }
      }
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mTabName:");
      localStringBuilder.append(this.al.toString());
      QLog.i("PoiMapActivity", 4, localStringBuilder.toString());
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
  
  public void e()
  {
    this.O = super.getResources().getDimensionPixelSize(2131298231);
    this.P = super.getResources().getDimensionPixelSize(2131298240);
    this.S = super.getResources().getDimensionPixelSize(2131298234);
    this.T = super.getResources().getDimensionPixelSize(2131298233);
    this.Q = super.getResources().getDimensionPixelSize(2131298226);
    this.R = super.getResources().getDimensionPixelSize(2131298227);
    this.an = ((LinearLayout)super.findViewById(2131440476));
    this.c.setBackgroundColor(this.g);
    this.an.setBackgroundDrawable(null);
    this.an.setBackgroundResource(this.h);
    if (this.isChangeToGoogleMap)
    {
      this.an.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.mQQMapLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.mQQMapLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = (FrameLayout)super.findViewById(2131440469);
    this.d = new PoiMapActivity.PoiTab[this.al.length];
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -1);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams1.weight = 1.0F;
    int i2 = this.al.length;
    int i1 = 0;
    while (i1 < i2)
    {
      PoiMapActivity.PoiTab localPoiTab = new PoiMapActivity.PoiTab(this, this, this.al[i1], i1);
      if (i1 == 0)
      {
        localPoiTab.a(true);
        localPoiTab.h.c = 0;
      }
      if (i1 == i2 - 1) {
        localPoiTab.f.a();
      }
      this.d[i1] = localPoiTab;
      this.an.addView(localPoiTab.f, localLayoutParams1);
      ((FrameLayout)localObject).addView(localPoiTab.g, localLayoutParams2);
      i1 += 1;
    }
    if (this.mapView != null) {
      this.mapView.getViewTreeObserver().addOnPreDrawListener(this.ak);
    }
    if (this.pinView != null) {
      this.pinView.getViewTreeObserver().addOnPreDrawListener(this.ak);
    }
  }
  
  protected void f()
  {
    if (this.s) {
      return;
    }
    int i1 = this.O;
    if (i1 > 0)
    {
      int i2 = this.N;
      if (i2 <= 0) {
        return;
      }
      ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(i2 + i1), Integer.valueOf(this.N), new PoiMapActivity.15(this));
      localValueAnimation.setDuration(200L);
      localValueAnimation.setFillAfter(true);
      localValueAnimation.setAnimationListener(new PoiMapActivity.16(this));
      this.mQQMapLayout.startAnimation(localValueAnimation);
    }
  }
  
  protected void g()
  {
    if (!this.s) {
      return;
    }
    if (this.O > 0)
    {
      int i1 = this.N;
      if (i1 <= 0) {
        return;
      }
      ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(i1), Integer.valueOf(this.N + this.O), new PoiMapActivity.17(this));
      localValueAnimation.setDuration(200L);
      localValueAnimation.setFillAfter(true);
      localValueAnimation.setAnimationListener(new PoiMapActivity.18(this));
      this.mQQMapLayout.startAnimation(localValueAnimation);
    }
  }
  
  protected Intent getLocationData()
  {
    super.getLocationData();
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if ((this.mapView != null) && (this.mapView.getMap() != null) && (this.mapView.getMap().getCameraPosition() != null) && (this.mapView.getMap().getCameraPosition().target != null))
    {
      LatLng localLatLng = this.mapView.getMap().getCameraPosition().target;
      localBundle.putString("latitude", String.valueOf(localLatLng.getLatitude()));
      localBundle.putString("longitude", String.valueOf(localLatLng.getLongitude()));
    }
    localBundle.putString("poiId", this.q);
    localBundle.putBoolean("isForien", this.Z);
    localBundle.putInt("isArk", this.aa);
    localBundle.putString("description", this.location);
    localBundle.putString("latSpan", String.valueOf(this.m));
    localBundle.putString("lngSpan", String.valueOf(this.n));
    if ((TextUtils.isEmpty(this.mCurPoiName)) || (this.mCurPoiName.equals(getString(2131892668)))) {
      this.mCurPoiName = getString(2131891400);
    }
    if (TextUtils.isEmpty(this.mCurPoiAdr)) {
      this.mCurPoiAdr = "Unknown Address";
    }
    localBundle.putString("title", this.mCurPoiName);
    localBundle.putString("summary", this.mCurPoiAdr);
    localBundle.putString("dianping_id", this.mDianpingId);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  public void h()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onHideRoute:");
          if (this.mPolyLine == null) {
            break label97;
          }
          bool = true;
          localStringBuilder.append(bool);
          QLog.d("Q.qqmap", 2, localStringBuilder.toString());
        }
        if (this.mPolyLine != null)
        {
          this.mPolyLine.remove();
          this.mPolyLine = null;
          this.mapView.invalidate();
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqmap", 2, "onHideRoute:", localException);
        }
      }
      return;
      label97:
      boolean bool = false;
    }
  }
  
  public boolean i()
  {
    return this.mPolyLine != null;
  }
  
  protected boolean isNeedDestroyBoradcast()
  {
    return this.ad;
  }
  
  protected void jumpToStreetViewMapReport()
  {
    a("rec_locate", "click_view", "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject;
    if (i1 != 2131440472)
    {
      if (i1 != 2131440474)
      {
        if (i1 == 2131445181)
        {
          localObject = new GeoPoint((int)(this.latitude * 1000000.0D), (int)(this.longitude * 1000000.0D));
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
              requestPermissions(new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 1);
            } else {
              this.ae.a(this.mSelfGeoPoint, (GeoPoint)localObject, this.mSelfPoiName, this.mCurPoiName);
            }
          }
          else {
            this.ae.a(this.mSelfGeoPoint, (GeoPoint)localObject, this.mSelfPoiName, this.mCurPoiName);
          }
          QQMapRoutingHelper.a("navigation_click");
          QQMapRoutingHelper.b("click_navig", "0");
        }
      }
      else if (!this.s) {
        f();
      }
    }
    else
    {
      if (this.startWithPos)
      {
        if (this.mSelfGeoPoint != null)
        {
          addSelfLay();
          if (this.tencentMap != null)
          {
            localObject = this.tencentMap;
            double d1 = this.mSelfGeoPoint.getLatitudeE6();
            Double.isNaN(d1);
            d1 /= 1000000.0D;
            double d2 = this.mSelfGeoPoint.getLongitudeE6();
            Double.isNaN(d2);
            ((TencentMap)localObject).moveCamera(CameraUpdateFactory.newLatLng(new LatLng(d1, d2 / 1000000.0D)));
          }
        }
        else
        {
          getMyLocation(true);
        }
      }
      else {
        getMyLocation(true);
      }
      if (this.startWithPos) {
        a("rec_locate", "click_locate_rec", "", "", "", "");
      } else {
        a("share_locate", "click_locate_share", "", "", "", "");
      }
      this.af.setImageResource(2130843427);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    this.e = super.getResources().getColor(2131168118);
    this.f = super.getResources().getColor(2131167993);
    this.h = 2130852374;
    this.i = 2130839574;
    this.j = 2130845020;
    if ("1103".equals(paramBundle)) {
      this.g = super.getResources().getColor(2131166649);
    } else {
      this.g = super.getResources().getColor(2131166648);
    }
    this.k = Color.rgb(0, 121, 255);
    this.l = super.getResources().getDisplayMetrics().density;
    this.ad = getIntent().getBooleanExtra("is_need_destroy_broadcast", true);
    this.ae = new QQMapRoutingHelper(this);
    this.ae.a(this);
    d();
    a();
  }
  
  protected void onFetchDataSuceeded()
  {
    super.onFetchDataSuceeded();
  }
  
  protected void onGetLbsShareSearch(LBSShare.LocationResp paramLocationResp, Bundle paramBundle)
  {
    if (paramLocationResp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch null");
      }
      return;
    }
    int i1 = paramLocationResp.ec.get();
    int i2 = paramLocationResp.is_foreign.get();
    int i3 = 0;
    boolean bool;
    if (i2 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.Z = bool;
    this.aa = paramLocationResp.is_ark.get();
    String str1 = paramBundle.getString("keyword");
    int i4 = paramBundle.getInt("latitude");
    int i5 = paramBundle.getInt("longitude");
    int i6 = paramBundle.getInt("page");
    String str2 = paramBundle.getString("category");
    this.ab = paramBundle.getString("imei");
    this.ac = paramLocationResp.search_id.get();
    if (i1 != 0)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onGetLbsShareSearch error:");
        paramBundle.append(i1);
        QLog.i("PoiMapActivity", 2, paramBundle.toString());
      }
      QQToast.makeText(this, super.getString(2131891139), 0).show();
    }
    if (i1 == 0)
    {
      ArrayList localArrayList = new ArrayList();
      bool = this.Z;
      Object localObject1 = "";
      Object localObject2;
      if (bool)
      {
        paramBundle = new GeoPoint(i4, i5);
        localObject2 = this.Y;
        if (localObject2 == null)
        {
          try
          {
            this.Y = new PoiMapActivity.PoiMapNameTask(this);
            this.Y.a(paramBundle);
            this.Y.execute(new Void[0]);
          }
          catch (RejectedExecutionException paramBundle)
          {
            if (!QLog.isColorLevel()) {
              break label442;
            }
          }
          QLog.d("PoiMapActivity", 2, paramBundle.getMessage());
        }
        else
        {
          ((PoiMapActivity.PoiMapNameTask)localObject2).a = paramBundle;
          if (PlatformUtil.version() >= 11)
          {
            localObject2 = ((ThreadPoolExecutor)PoiMapActivity.PoiMapNameTask.THREAD_POOL_EXECUTOR).getQueue();
            if ((localObject2 != null) && (((BlockingQueue)localObject2).size() > 0)) {
              ((BlockingQueue)localObject2).removeAll((Collection)localObject2);
            }
          }
          if (this.Y.getStatus() != AsyncTask.Status.FINISHED)
          {
            if (!this.Y.isCancelled()) {
              this.Y.cancel(true);
            }
          }
          else {
            try
            {
              localObject2 = new PoiMapActivity.PoiMapNameTask(this);
              ((PoiMapActivity.PoiMapNameTask)localObject2).a(paramBundle);
              this.Y = ((PoiMapActivity.PoiMapNameTask)localObject2);
              this.Y.execute(new Void[0]);
            }
            catch (RejectedExecutionException paramBundle)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PoiMapActivity", 2, paramBundle.getMessage());
              }
            }
          }
        }
        label442:
        paramBundle = new PoiMapActivity.POI(this);
        paramBundle.a = super.getResources().getString(2131892668);
        paramBundle.b = "";
        this.mCurPoiAdr = paramBundle.b;
        paramBundle.k = i4;
        paramBundle.l = i5;
        paramBundle.d = "";
        localArrayList.add(paramBundle);
      }
      Object localObject3;
      for (;;)
      {
        i1 = 1;
        break label807;
        if (!paramLocationResp.mylbs.has()) {
          break;
        }
        localObject2 = (LBSShare.POI)paramLocationResp.mylbs.get();
        localObject3 = new PoiMapActivity.POI(this);
        if (((LBSShare.POI)localObject2).name.has()) {
          paramBundle = ((LBSShare.POI)localObject2).name.get();
        } else {
          paramBundle = super.getResources().getString(2131892668);
        }
        ((PoiMapActivity.POI)localObject3).a = paramBundle;
        if (((LBSShare.POI)localObject2).shop_url.has()) {
          paramBundle = ((LBSShare.POI)localObject2).shop_url.get();
        } else {
          paramBundle = "";
        }
        ((PoiMapActivity.POI)localObject3).d = paramBundle;
        if (((LBSShare.POI)localObject2).addr.has()) {
          paramBundle = ((LBSShare.POI)localObject2).addr.get();
        } else {
          paramBundle = "";
        }
        ((PoiMapActivity.POI)localObject3).b = paramBundle;
        if (((LBSShare.POI)localObject2).lat.has()) {
          i1 = ((LBSShare.POI)localObject2).lat.get();
        } else {
          i1 = 0;
        }
        ((PoiMapActivity.POI)localObject3).k = i1;
        if (((LBSShare.POI)localObject2).lng.has()) {
          i1 = ((LBSShare.POI)localObject2).lng.get();
        } else {
          i1 = 0;
        }
        ((PoiMapActivity.POI)localObject3).l = i1;
        if ((this.x) && (!TextUtils.isEmpty(this.mCurPoiName)))
        {
          ((PoiMapActivity.POI)localObject3).a = this.mCurPoiName;
          ((PoiMapActivity.POI)localObject3).d = "";
          ((PoiMapActivity.POI)localObject3).b = this.mCurPoiAdr;
          ((PoiMapActivity.POI)localObject3).k = this.m;
          ((PoiMapActivity.POI)localObject3).l = this.n;
        }
        else
        {
          ((PoiMapActivity.POI)localObject3).a = super.getResources().getString(2131892668);
          this.mCurPoiAdr = ((PoiMapActivity.POI)localObject3).b;
        }
        localArrayList.add(localObject3);
      }
      i1 = 0;
      label807:
      if (paramLocationResp.poilist.has())
      {
        paramBundle = paramLocationResp.poilist.get();
        if (paramBundle.size() > 0)
        {
          bool = true;
          i1 = 1;
        }
        else
        {
          bool = false;
          i1 = 0;
        }
        localObject3 = paramBundle.iterator();
        paramBundle = (Bundle)localObject1;
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (LBSShare.POI)((Iterator)localObject3).next();
          localObject2 = new PoiMapActivity.POI(this);
          if (((LBSShare.POI)localObject4).name.has()) {
            localObject1 = ((LBSShare.POI)localObject4).name.get();
          } else {
            localObject1 = paramBundle;
          }
          ((PoiMapActivity.POI)localObject2).a = ((String)localObject1);
          if (((LBSShare.POI)localObject4).addr.has()) {
            localObject1 = ((LBSShare.POI)localObject4).addr.get();
          } else {
            localObject1 = paramBundle;
          }
          ((PoiMapActivity.POI)localObject2).b = ((String)localObject1);
          if (((LBSShare.POI)localObject4).lat.has()) {
            i2 = ((LBSShare.POI)localObject4).lat.get();
          } else {
            i2 = 0;
          }
          ((PoiMapActivity.POI)localObject2).k = i2;
          if (((LBSShare.POI)localObject4).lng.has()) {
            i2 = ((LBSShare.POI)localObject4).lng.get();
          } else {
            i2 = 0;
          }
          ((PoiMapActivity.POI)localObject2).l = i2;
          if (((LBSShare.POI)localObject4).id.has()) {
            localObject1 = ((LBSShare.POI)localObject4).id.get();
          } else {
            localObject1 = paramBundle;
          }
          ((PoiMapActivity.POI)localObject2).c = ((String)localObject1);
          if ("group_activity".equals(this.mFrom))
          {
            ((PoiMapActivity.POI)localObject2).d = paramBundle;
            ((PoiMapActivity.POI)localObject2).e = paramBundle;
            ((PoiMapActivity.POI)localObject2).g = 0;
            ((PoiMapActivity.POI)localObject2).h = paramBundle;
            ((PoiMapActivity.POI)localObject2).i = paramBundle;
            ((PoiMapActivity.POI)localObject2).j = paramBundle;
            ((PoiMapActivity.POI)localObject2).f = paramBundle;
          }
          else
          {
            if (((LBSShare.POI)localObject4).shop_url.has()) {
              localObject1 = ((LBSShare.POI)localObject4).shop_url.get();
            } else {
              localObject1 = paramBundle;
            }
            ((PoiMapActivity.POI)localObject2).d = ((String)localObject1);
            if (((LBSShare.POI)localObject4).shop_url_quan.has()) {
              localObject1 = ((LBSShare.POI)localObject4).shop_url_quan.get();
            } else {
              localObject1 = paramBundle;
            }
            ((PoiMapActivity.POI)localObject2).e = ((String)localObject1);
            if (((LBSShare.POI)localObject4).shop_count.has()) {
              i2 = ((LBSShare.POI)localObject4).shop_count.get();
            } else {
              i2 = 0;
            }
            ((PoiMapActivity.POI)localObject2).g = i2;
            if (((LBSShare.POI)localObject4).shangquan_url.has()) {
              localObject1 = ((LBSShare.POI)localObject4).shangquan_url.get();
            } else {
              localObject1 = paramBundle;
            }
            ((PoiMapActivity.POI)localObject2).h = ((String)localObject1);
            if (((LBSShare.POI)localObject4).shangquan_wording.has()) {
              localObject1 = ((LBSShare.POI)localObject4).shangquan_wording.get();
            } else {
              localObject1 = paramBundle;
            }
            ((PoiMapActivity.POI)localObject2).i = ((String)localObject1);
            if (((LBSShare.POI)localObject4).POI_preview_url.has()) {
              localObject1 = ((LBSShare.POI)localObject4).POI_preview_url.get();
            } else {
              localObject1 = paramBundle;
            }
            ((PoiMapActivity.POI)localObject2).j = ((String)localObject1);
            if (((LBSShare.POI)localObject4).dpid.has()) {
              localObject1 = ((LBSShare.POI)localObject4).dpid.get();
            } else {
              localObject1 = paramBundle;
            }
            ((PoiMapActivity.POI)localObject2).f = ((String)localObject1);
          }
          if (!TextUtils.isEmpty(((PoiMapActivity.POI)localObject2).d)) {
            a("share_locate", "view_share_tuan", "", "", "", "");
          }
          if ((TextUtils.isEmpty(((PoiMapActivity.POI)localObject2).d)) && (!TextUtils.isEmpty(((PoiMapActivity.POI)localObject2).e))) {
            a("share_locate", "view_quan", "", "", "", "");
          }
          if ((this.x) && (!TextUtils.isEmpty(this.U)) && (this.U.equals(((PoiMapActivity.POI)localObject2).c)))
          {
            if (!localArrayList.isEmpty())
            {
              localObject1 = localArrayList;
              localObject4 = (PoiMapActivity.POI)((ArrayList)localObject1).get(0);
              if ((this.mCurPoiName.equals(((PoiMapActivity.POI)localObject4).a)) && (this.mCurPoiAdr.equals(((PoiMapActivity.POI)localObject4).b))) {
                ((ArrayList)localObject1).remove(0);
              }
            }
            localArrayList.add(0, localObject2);
          }
          else
          {
            localArrayList.add(localObject2);
          }
        }
        paramBundle = localArrayList;
      }
      else
      {
        paramBundle = localArrayList;
        bool = false;
      }
      i2 = i3;
      if (paramLocationResp.next.has()) {
        i2 = paramLocationResp.next.get();
      }
    }
    else
    {
      paramBundle = null;
      i1 = 0;
      bool = false;
      i2 = 0;
    }
    runOnUiThread(new PoiMapActivity.12(this, bool, str2, str1, paramBundle, i2, i4, i5, i6, i1 ^ 0x1));
  }
  
  protected void onGetLbsShareShop(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle)
  {
    if (paramNearByShopsResp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetLbsShareShop null");
      }
      return;
    }
    int i1 = paramNearByShopsResp.ec.get();
    if (i1 == 0)
    {
      paramBundle.getInt("begin", 0);
      if (paramNearByShopsResp.next_begin.has()) {
        paramNearByShopsResp.next_begin.get();
      }
      if (paramNearByShopsResp.total.has()) {
        paramNearByShopsResp.total.get();
      }
      if (paramNearByShopsResp.poilist.has())
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramNearByShopsResp.poilist.get().iterator();
        while (localIterator.hasNext())
        {
          LBSShare.Shop localShop = (LBSShare.Shop)localIterator.next();
          PoiMapActivity.GeneralShops localGeneralShops = new PoiMapActivity.GeneralShops(this);
          localGeneralShops.f = 1;
          boolean bool = localShop.id.has();
          paramBundle = "";
          if (bool) {
            paramNearByShopsResp = localShop.id.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.j = paramNearByShopsResp;
          if (localShop.name.has()) {
            paramNearByShopsResp = localShop.name.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.g = paramNearByShopsResp;
          if (localShop.logo.has()) {
            paramNearByShopsResp = localShop.logo.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.h = paramNearByShopsResp;
          if (localShop.url.has()) {
            paramNearByShopsResp = localShop.url.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.i = paramNearByShopsResp;
          if (localShop.detail.has()) {
            paramNearByShopsResp = localShop.detail.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.a = paramNearByShopsResp;
          if (localShop.discount.has()) {
            paramNearByShopsResp = localShop.discount.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.b = paramNearByShopsResp;
          if (localShop.price.has()) {
            paramNearByShopsResp = localShop.price.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.c = paramNearByShopsResp;
          paramNearByShopsResp = paramBundle;
          if (localShop.soldnum.has()) {
            paramNearByShopsResp = localShop.soldnum.get();
          }
          localGeneralShops.d = paramNearByShopsResp;
          if (localShop.has_tuan.has()) {
            i1 = localShop.has_tuan.get();
          } else {
            i1 = 0;
          }
          localGeneralShops.k = i1;
          if (localShop.has_quan.has()) {
            i1 = localShop.has_quan.get();
          } else {
            i1 = 0;
          }
          localGeneralShops.l = i1;
          localArrayList.add(localGeneralShops);
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramNearByShopsResp = new StringBuilder();
      paramNearByShopsResp.append("onGetLbsShareShop error:");
      paramNearByShopsResp.append(i1);
      QLog.i("PoiMapActivity", 2, paramNearByShopsResp.toString());
    }
  }
  
  protected void onGetShareShopDetail(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp)
  {
    if (paramGetShopsByIdsResp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetShareShopDetail null");
      }
      return;
    }
    int i1 = paramGetShopsByIdsResp.ec.get();
    if (i1 == 0)
    {
      if (paramGetShopsByIdsResp.shops.has())
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramGetShopsByIdsResp.shops.get().iterator();
        while (localIterator.hasNext())
        {
          LBSShare.DPBiz localDPBiz = (LBSShare.DPBiz)localIterator.next();
          PoiMapActivity.SingleShops localSingleShops = new PoiMapActivity.SingleShops(this);
          localSingleShops.f = 1;
          boolean bool = localDPBiz.id.has();
          String str = "";
          if (bool) {
            paramGetShopsByIdsResp = localDPBiz.id.get();
          } else {
            paramGetShopsByIdsResp = "";
          }
          localSingleShops.j = paramGetShopsByIdsResp;
          if (localDPBiz.name.has()) {
            paramGetShopsByIdsResp = localDPBiz.name.get();
          } else {
            paramGetShopsByIdsResp = "";
          }
          localSingleShops.g = paramGetShopsByIdsResp;
          if (localDPBiz.logo.has()) {
            paramGetShopsByIdsResp = localDPBiz.logo.get();
          } else {
            paramGetShopsByIdsResp = "";
          }
          localSingleShops.h = paramGetShopsByIdsResp;
          if (localDPBiz.url.has()) {
            paramGetShopsByIdsResp = localDPBiz.url.get();
          } else {
            paramGetShopsByIdsResp = "";
          }
          localSingleShops.i = paramGetShopsByIdsResp;
          if (localDPBiz.avg_price.has()) {
            paramGetShopsByIdsResp = localDPBiz.avg_price.get();
          } else {
            paramGetShopsByIdsResp = "";
          }
          localSingleShops.c = paramGetShopsByIdsResp;
          if (localDPBiz.biz_zone.has()) {
            paramGetShopsByIdsResp = localDPBiz.biz_zone.get();
          } else {
            paramGetShopsByIdsResp = "";
          }
          localSingleShops.d = paramGetShopsByIdsResp;
          paramGetShopsByIdsResp = str;
          if (localDPBiz.category.has()) {
            paramGetShopsByIdsResp = localDPBiz.category.get();
          }
          localSingleShops.a = paramGetShopsByIdsResp;
          bool = localDPBiz.has_quan.has();
          int i2 = 0;
          if (bool) {
            i1 = localDPBiz.has_quan.get();
          } else {
            i1 = 0;
          }
          localSingleShops.l = i1;
          if (localDPBiz.has_tuan.has()) {
            i1 = localDPBiz.has_tuan.get();
          } else {
            i1 = 0;
          }
          localSingleShops.k = i1;
          i1 = i2;
          if (localDPBiz.rate.has()) {
            i1 = localDPBiz.rate.get();
          }
          localSingleShops.b = i1;
          localArrayList.add(localSingleShops);
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      paramGetShopsByIdsResp = new StringBuilder();
      paramGetShopsByIdsResp.append("onGetShareShopDetail error:");
      paramGetShopsByIdsResp.append(i1);
      QLog.i("PoiMapActivity", 2, paramGetShopsByIdsResp.toString());
    }
  }
  
  public void onMapScrollEnd(GeoPoint paramGeoPoint)
  {
    super.onMapScrollEnd(paramGeoPoint);
    if (!this.startWithPos) {
      a("share_locate", "drag_location", this.ac, this.ab, "", "");
    }
  }
  
  public void onMapScrollStart(GeoPoint paramGeoPoint)
  {
    this.af.setImageResource(2130843425);
  }
  
  protected void onTroopActivityCallback()
  {
    super.onTroopActivityCallback();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("{");
    ((StringBuilder)localObject).append("\"id\":\"");
    ((StringBuilder)localObject).append(this.q);
    ((StringBuilder)localObject).append("\",");
    ((StringBuilder)localObject).append("\"title\":\"");
    ((StringBuilder)localObject).append(this.mCurPoiName);
    ((StringBuilder)localObject).append("\",");
    ((StringBuilder)localObject).append("\"address\":\"");
    ((StringBuilder)localObject).append(this.mCurPoiAdr);
    ((StringBuilder)localObject).append("\",");
    ((StringBuilder)localObject).append("\"location\":{");
    ((StringBuilder)localObject).append("\"lat\":\"");
    double d1 = this.o * 1.0F;
    Double.isNaN(d1);
    ((StringBuilder)localObject).append(d1 / 1000000.0D);
    ((StringBuilder)localObject).append("\",");
    ((StringBuilder)localObject).append("\"lon\":\"");
    d1 = this.p * 1.0F;
    Double.isNaN(d1);
    ((StringBuilder)localObject).append(d1 / 1000000.0D);
    ((StringBuilder)localObject).append("\"");
    ((StringBuilder)localObject).append("}");
    ((StringBuilder)localObject).append("}");
    localObject = ((StringBuilder)localObject).toString();
    Intent localIntent = new Intent();
    localIntent.putExtra("result", (String)localObject);
    setResult(-1, localIntent);
    finish();
  }
  
  protected void sendSuccessCall()
  {
    Object localObject1;
    Object localObject2;
    if ((this.mapView.getMap() != null) && (this.mapView.getMap().getCameraPosition() != null) && (this.mapView.getMap().getCameraPosition().target != null))
    {
      localObject1 = this.mapView.getMap().getCameraPosition().target;
      double d1 = ((LatLng)localObject1).getLatitude();
      localObject2 = String.valueOf(((LatLng)localObject1).getLongitude());
      localObject1 = String.valueOf(d1);
    }
    else
    {
      localObject1 = "";
      localObject2 = localObject1;
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append(this.ac);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append(this.ab);
    String str1 = ((StringBuilder)localObject3).toString();
    if (TextUtils.isEmpty(this.q)) {
      localObject3 = "0";
    } else {
      localObject3 = this.q;
    }
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(this.r + 1);
    ((StringBuilder)localObject4).append("");
    String str2 = ((StringBuilder)localObject4).toString();
    if (this.d[this.r].h.b) {
      localObject4 = "2";
    } else {
      localObject4 = "1";
    }
    a("share_locate", "click_send", str1, (String)localObject3, str2, (String)localObject4);
    if (this.Z)
    {
      a("rec_locate", "send_googlestation", "", "", "", "");
      a("rec_locate", "send_foursquare", "", "", "", "");
    }
    localObject3 = getIntent();
    if (((Intent)localObject3).getIntExtra("uintype", 0) == 1008)
    {
      localObject4 = new Intent("com.tencent.biz.pubaccount.locationResultAction");
      ((Intent)localObject4).putExtra("latitude", (String)localObject1);
      ((Intent)localObject4).putExtra("longitude", (String)localObject2);
      ((Intent)localObject4).putExtra("name", this.mCurPoiAdr);
      sendBroadcast((Intent)localObject4, "com.tencent.msg.permission.pushnotify");
    }
    int i1 = ((Intent)localObject3).getIntExtra("sessionType", 1);
    if (i1 == 1) {
      localObject1 = "group";
    } else if (i1 == 0) {
      localObject1 = "person";
    } else if (i1 == 3000) {
      localObject1 = "disc_group";
    } else {
      localObject1 = "other";
    }
    QQMapRoutingHelper.a("send_location", c(), (String)localObject1);
  }
  
  protected void updateLocationAddress(GeoPoint paramGeoPoint)
  {
    int i1 = paramGeoPoint.getLatitudeE6();
    int i2 = paramGeoPoint.getLongitudeE6();
    if ((this.m == i1) && (this.n == i2)) {
      return;
    }
    super.updateLocationAddress(paramGeoPoint);
    if (QLog.isColorLevel())
    {
      paramGeoPoint = new StringBuilder();
      paramGeoPoint.append("lat=");
      paramGeoPoint.append(i1);
      paramGeoPoint.append(", lon=");
      paramGeoPoint.append(i2);
      QLog.d("PoiMapActivity", 2, paramGeoPoint.toString());
    }
    this.mCurPoiName = "";
    this.m = i1;
    this.n = i2;
    this.o = this.m;
    this.p = this.n;
    this.x = false;
    i2 = this.d.length;
    i1 = 0;
    while (i1 < i2)
    {
      if (i1 == 0)
      {
        this.d[0].h.a(false);
        if (this.V) {
          this.d[0].a(-1, false);
        } else {
          this.d[0].a(0, false);
        }
      }
      else
      {
        this.d[i1].a(-1, true);
      }
      i1 += 1;
    }
    this.d[this.r].b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity
 * JD-Core Version:    0.7.0.1
 */