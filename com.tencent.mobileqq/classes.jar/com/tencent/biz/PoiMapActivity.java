package com.tencent.biz;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.widgets.PolyLineOverlay;
import com.tencent.biz.widgets.QQMapRoutingHelper;
import com.tencent.biz.widgets.QQMapRoutingHelper.RouteListener;
import com.tencent.component.network.utils.PlatformUtil;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare.DPBiz;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.proto.lbsshare.LBSShare.Shop;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.MapController;
import com.tencent.tencentmap.mapsdk.map.Overlay;
import com.tencent.tencentmap.mapsdk.map.UiSettings;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import klf;
import klg;
import klh;
import kli;
import klj;
import klk;
import kll;
import klm;
import kln;
import klo;
import klp;
import klq;
import klr;
import kls;
import klt;
import klv;
import klw;
import klx;
import kly;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PoiMapActivity
  extends QQMapActivity
  implements View.OnClickListener, QQMapRoutingHelper.RouteListener
{
  protected float a;
  protected int a;
  public GestureDetector a;
  public View.OnClickListener a;
  View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new klh(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new klr(this);
  protected View a;
  public final ViewTreeObserver.OnPreDrawListener a;
  public EditText a;
  protected ImageButton a;
  public ImageView a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected AuthorizeConfig a;
  protected PoiMapActivity.PoiMapNameTask a;
  PoiMapActivity.SearchResultAdapter jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter;
  protected QQMapRoutingHelper a;
  protected AbsListView.OnScrollListener a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public final String a;
  public List a;
  public boolean a;
  public PoiMapActivity.PoiTab[] a;
  String[] jdField_a_of_type_ArrayOfJavaLangString = { "全部", "写字楼", "小区", "商家" };
  protected int b;
  public View b;
  protected ImageView b;
  public LinearLayout b;
  public String b;
  public boolean b;
  public String[] b;
  protected int c;
  View c;
  public String c;
  protected boolean c;
  protected int d;
  protected View d;
  protected String d;
  public boolean d;
  protected int e;
  public View e;
  public String e;
  protected boolean e;
  protected int f;
  public String f;
  public boolean f;
  protected int g;
  protected boolean g;
  public int h;
  public boolean h;
  public int i;
  public boolean i;
  public int j;
  protected boolean j;
  public int k;
  public int l;
  protected final int m;
  public int n;
  public int o;
  public int p;
  protected int q;
  protected int r;
  public int s;
  public int t;
  protected int u;
  
  public PoiMapActivity()
  {
    this.jdField_a_of_type_JavaLangString = "PoiMapActivity";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_m_of_type_Int = 20;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new kli(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new klk(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener = new kll(this);
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "", "281100|281200", "281000|281010|281011|281012|281013|281099", "100000|130000" };
  }
  
  public Intent a()
  {
    super.a();
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMapCenter();
    localObject = new GeoPoint((int)(((LatLng)localObject).getLatitude() * 1000000.0D), (int)(((LatLng)localObject).getLongitude() * 1000000.0D));
    double d1 = ((GeoPoint)localObject).getLatitudeE6() / 1000000.0D;
    double d2 = ((GeoPoint)localObject).getLongitudeE6() / 1000000.0D;
    localBundle.putString("latitude", String.valueOf(d1));
    localBundle.putString("longitude", String.valueOf(d2));
    localBundle.putString("poiId", this.jdField_b_of_type_JavaLangString);
    localBundle.putBoolean("isForien", this.jdField_i_of_type_Boolean);
    localBundle.putInt("isArk", this.u);
    localBundle.putString("description", this.jdField_g_of_type_JavaLangString);
    localBundle.putString("latSpan", String.valueOf(this.jdField_h_of_type_Int));
    localBundle.putString("lngSpan", String.valueOf(this.jdField_i_of_type_Int));
    if ((TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) || (this.jdField_l_of_type_JavaLangString.equals(getString(2131437033)))) {
      this.jdField_l_of_type_JavaLangString = getString(2131433972);
    }
    if (TextUtils.isEmpty(this.jdField_m_of_type_JavaLangString)) {
      this.jdField_m_of_type_JavaLangString = "Unknown Address";
    }
    localBundle.putString("title", this.jdField_l_of_type_JavaLangString);
    localBundle.putString("summary", this.jdField_m_of_type_JavaLangString);
    localBundle.putString("dianping_id", this.jdField_n_of_type_JavaLangString);
    localIntent.putExtras(localBundle);
    return localIntent;
  }
  
  protected String a()
  {
    switch ()
    {
    default: 
      return "others";
    case 1: 
      return "Wifi";
    case 2: 
      return "2g";
    case 3: 
      return "3g";
    }
    return "4g";
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131371608));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131365662);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131371610);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131371619));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131430505));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.jdField_k_of_type_Boolean)
    {
      a("rec_locate", "pageview_all", "", "", "", "");
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_j_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (!TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.jdField_l_of_type_JavaLangString);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_i_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getUiSettings().setLogoPosition(2);
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidViewView = super.findViewById(2131363397);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131371613));
      super.findViewById(2131368323).setVisibility(8);
      EditText localEditText = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131368324);
      localEditText.setFocusable(false);
      localEditText.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
      g();
      if (!"group_activity".equals(this.jdField_o_of_type_JavaLangString))
      {
        this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this, new klf(this));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.setOnTouchListener(new klq(this));
        this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131371611);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab == null) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length)) {
      return;
    }
    this.jdField_l_of_type_Int = paramInt;
    int i2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    int i1 = 0;
    label30:
    if (i1 < i2)
    {
      if (i1 != paramInt) {
        break label67;
      }
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(true);
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].b(true);
    }
    for (;;)
    {
      i1 += 1;
      break label30;
      break;
      label67:
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.getLbsShareSearch");
    localIntent.putExtra("latitude", paramInt1);
    localIntent.putExtra("longitude", paramInt2);
    localIntent.putExtra("keyword", paramString1);
    localIntent.putExtra("category", paramString2);
    localIntent.putExtra("page", paramInt3);
    localIntent.putExtra("count", paramInt4);
    localIntent.putExtra("coordinate", 1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "getSearchDataFromServer:lat=" + paramInt1 + ",lon=" + paramInt2 + ",keyword=" + paramString1 + ",category=" + paramString2 + ",page=" + paramInt3 + ",count=" + paramInt4);
    }
    if ((paramInt3 == 0) && (TextUtils.isEmpty(paramString1))) {
      if (TextUtils.isEmpty(paramString2)) {
        localIntent.putExtra("requireMyLbs", 1);
      }
    }
    for (;;)
    {
      super.sendBroadcast(localIntent);
      return;
      localIntent.putExtra("requireMyLbs", 0);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      if (!paramBoolean) {
        break label41;
      }
    }
    label41:
    for (localLayoutParams.topMargin += paramInt;; localLayoutParams.topMargin = paramInt)
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void a(PoiMapActivity.POI paramPOI)
  {
    this.jdField_m_of_type_JavaLangString = paramPOI.jdField_b_of_type_JavaLangString;
    this.jdField_l_of_type_JavaLangString = paramPOI.jdField_a_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = paramPOI.jdField_c_of_type_JavaLangString;
    this.jdField_h_of_type_Int = paramPOI.jdField_b_of_type_Int;
    this.jdField_i_of_type_Int = paramPOI.jdField_c_of_type_Int;
    this.jdField_j_of_type_Int = this.jdField_h_of_type_Int;
    this.jdField_k_of_type_Int = this.jdField_i_of_type_Int;
    this.jdField_n_of_type_JavaLangString = paramPOI.jdField_f_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramPOI.jdField_c_of_type_JavaLangString;
    this.jdField_c_of_type_Boolean = true;
    int i2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    int i1 = 0;
    if (i1 < i2)
    {
      if (i1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(false);
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, false);
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(-1, false);
      }
    }
    a(0);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.animateTo(new GeoPoint(paramPOI.jdField_b_of_type_Int, paramPOI.jdField_c_of_type_Int));
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    super.a(paramGeoPoint);
    if (!this.jdField_k_of_type_Boolean) {
      a("share_locate", "drag_location", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, "", "");
    }
  }
  
  protected void a(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp)
  {
    if (paramGetShopsByIdsResp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetShareShopDetail null");
      }
    }
    int i1;
    label64:
    label122:
    label252:
    do
    {
      do
      {
        return;
        i1 = paramGetShopsByIdsResp.ec.get();
        if (i1 != 0) {
          break;
        }
      } while (!paramGetShopsByIdsResp.shops.has());
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramGetShopsByIdsResp.shops.get().iterator();
      LBSShare.DPBiz localDPBiz;
      PoiMapActivity.SingleShops localSingleShops;
      if (localIterator.hasNext())
      {
        localDPBiz = (LBSShare.DPBiz)localIterator.next();
        localSingleShops = new PoiMapActivity.SingleShops(this);
        localSingleShops.jdField_a_of_type_Int = 1;
        if (!localDPBiz.id.has()) {
          break label372;
        }
        paramGetShopsByIdsResp = localDPBiz.id.get();
        localSingleShops.h = paramGetShopsByIdsResp;
        if (!localDPBiz.name.has()) {
          break label378;
        }
        paramGetShopsByIdsResp = localDPBiz.name.get();
        localSingleShops.jdField_e_of_type_JavaLangString = paramGetShopsByIdsResp;
        if (!localDPBiz.logo.has()) {
          break label384;
        }
        paramGetShopsByIdsResp = localDPBiz.logo.get();
        localSingleShops.jdField_f_of_type_JavaLangString = paramGetShopsByIdsResp;
        if (!localDPBiz.url.has()) {
          break label390;
        }
        paramGetShopsByIdsResp = localDPBiz.url.get();
        localSingleShops.jdField_g_of_type_JavaLangString = paramGetShopsByIdsResp;
        if (!localDPBiz.avg_price.has()) {
          break label396;
        }
        paramGetShopsByIdsResp = localDPBiz.avg_price.get();
        localSingleShops.jdField_b_of_type_JavaLangString = paramGetShopsByIdsResp;
        if (!localDPBiz.biz_zone.has()) {
          break label402;
        }
        paramGetShopsByIdsResp = localDPBiz.biz_zone.get();
        localSingleShops.jdField_c_of_type_JavaLangString = paramGetShopsByIdsResp;
        if (!localDPBiz.category.has()) {
          break label408;
        }
        paramGetShopsByIdsResp = localDPBiz.category.get();
        localSingleShops.jdField_a_of_type_JavaLangString = paramGetShopsByIdsResp;
        if (!localDPBiz.has_quan.has()) {
          break label414;
        }
        i1 = localDPBiz.has_quan.get();
        localSingleShops.jdField_c_of_type_Int = i1;
        if (!localDPBiz.has_tuan.has()) {
          break label419;
        }
        i1 = localDPBiz.has_tuan.get();
        localSingleShops.jdField_b_of_type_Int = i1;
        if (!localDPBiz.rate.has()) {
          break label424;
        }
      }
      for (i1 = localDPBiz.rate.get();; i1 = 0)
      {
        localSingleShops.jdField_d_of_type_Int = i1;
        localArrayList.add(localSingleShops);
        break label64;
        break;
        paramGetShopsByIdsResp = "";
        break label122;
        paramGetShopsByIdsResp = "";
        break label148;
        paramGetShopsByIdsResp = "";
        break label174;
        paramGetShopsByIdsResp = "";
        break label200;
        paramGetShopsByIdsResp = "";
        break label226;
        paramGetShopsByIdsResp = "";
        break label252;
        paramGetShopsByIdsResp = "";
        break label278;
        i1 = 0;
        break label304;
        i1 = 0;
        break label330;
      }
    } while (!QLog.isColorLevel());
    label148:
    label174:
    label200:
    label226:
    label372:
    label378:
    QLog.i("PoiMapActivity", 2, "onGetShareShopDetail error:" + i1);
    label278:
    label304:
    label330:
    return;
  }
  
  protected void a(LBSShare.LocationResp paramLocationResp, Bundle paramBundle)
  {
    if (paramLocationResp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch null");
      }
      return;
    }
    int i6 = paramLocationResp.ec.get();
    boolean bool1;
    String str1;
    int i3;
    int i4;
    int i5;
    String str2;
    int i1;
    ArrayList localArrayList;
    if (paramLocationResp.is_foreign.get() == 1)
    {
      bool1 = true;
      this.jdField_i_of_type_Boolean = bool1;
      this.u = paramLocationResp.is_ark.get();
      str1 = paramBundle.getString("keyword");
      i3 = paramBundle.getInt("latitude");
      i4 = paramBundle.getInt("longitude");
      i5 = paramBundle.getInt("page");
      str2 = paramBundle.getString("category");
      this.jdField_e_of_type_JavaLangString = paramBundle.getString("imei");
      this.jdField_f_of_type_JavaLangString = paramLocationResp.search_id.get();
      bool1 = false;
      if (i6 != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("PoiMapActivity", 2, "onGetLbsShareSearch error:" + i6);
        }
        QQToast.a(this, super.getString(2131437026), 0).a();
      }
      i1 = 0;
      i2 = 0;
      paramBundle = null;
      if (i6 != 0) {
        break label1589;
      }
      localArrayList = new ArrayList();
      if (!this.jdField_i_of_type_Boolean) {
        break label933;
      }
      paramBundle = new GeoPoint(i3, i4);
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask != null) {
        break label789;
      }
    }
    for (;;)
    {
      Object localObject;
      LBSShare.POI localPOI1;
      PoiMapActivity.POI localPOI;
      try
      {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask = new PoiMapActivity.PoiMapNameTask(this);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.a(paramBundle);
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.execute(new Void[0]);
        paramBundle = new PoiMapActivity.POI(this);
        paramBundle.jdField_a_of_type_JavaLangString = super.getResources().getString(2131437033);
        paramBundle.jdField_b_of_type_JavaLangString = "";
        this.jdField_m_of_type_JavaLangString = paramBundle.jdField_b_of_type_JavaLangString;
        paramBundle.jdField_b_of_type_Int = i3;
        paramBundle.jdField_c_of_type_Int = i4;
        paramBundle.jdField_d_of_type_JavaLangString = "";
        localArrayList.add(paramBundle);
        i1 = 1;
        if (!paramLocationResp.poilist.has()) {
          break label1510;
        }
        paramBundle = paramLocationResp.poilist.get();
        if (paramBundle.size() <= 0) {
          break label1232;
        }
        i1 = 1;
        bool1 = true;
        localObject = paramBundle.iterator();
        i2 = i1;
        bool2 = bool1;
        if (!((Iterator)localObject).hasNext()) {
          break label1516;
        }
        localPOI1 = (LBSShare.POI)((Iterator)localObject).next();
        localPOI = new PoiMapActivity.POI(this);
        if (!localPOI1.name.has()) {
          break label1240;
        }
        paramBundle = localPOI1.name.get();
        localPOI.jdField_a_of_type_JavaLangString = paramBundle;
        if (!localPOI1.addr.has()) {
          break label1246;
        }
        paramBundle = localPOI1.addr.get();
        localPOI.jdField_b_of_type_JavaLangString = paramBundle;
        if (!localPOI1.lat.has()) {
          break label1252;
        }
        i2 = localPOI1.lat.get();
        localPOI.jdField_b_of_type_Int = i2;
        if (!localPOI1.lng.has()) {
          break label1258;
        }
        i2 = localPOI1.lng.get();
        localPOI.jdField_c_of_type_Int = i2;
        if (!localPOI1.id.has()) {
          break label1264;
        }
        paramBundle = localPOI1.id.get();
        localPOI.jdField_c_of_type_JavaLangString = paramBundle;
        if (!"group_activity".equals(this.jdField_o_of_type_JavaLangString)) {
          break label1270;
        }
        localPOI.jdField_d_of_type_JavaLangString = "";
        localPOI.jdField_e_of_type_JavaLangString = "";
        localPOI.jdField_a_of_type_Int = 0;
        localPOI.jdField_g_of_type_JavaLangString = "";
        localPOI.h = "";
        localPOI.jdField_i_of_type_JavaLangString = "";
        localPOI.jdField_f_of_type_JavaLangString = "";
        if (!TextUtils.isEmpty(localPOI.jdField_d_of_type_JavaLangString)) {
          a("share_locate", "view_share_tuan", "", "", "", "");
        }
        if ((TextUtils.isEmpty(localPOI.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(localPOI.jdField_e_of_type_JavaLangString))) {
          a("share_locate", "view_quan", "", "", "", "");
        }
        if ((!this.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (!this.jdField_d_of_type_JavaLangString.equals(localPOI.jdField_c_of_type_JavaLangString))) {
          break label1499;
        }
        if (!localArrayList.isEmpty())
        {
          paramBundle = (PoiMapActivity.POI)localArrayList.get(0);
          if ((this.jdField_l_of_type_JavaLangString.equals(paramBundle.jdField_a_of_type_JavaLangString)) && (this.jdField_m_of_type_JavaLangString.equals(paramBundle.jdField_b_of_type_JavaLangString))) {
            localArrayList.remove(0);
          }
        }
        localArrayList.add(0, localPOI);
        continue;
        bool1 = false;
      }
      catch (RejectedExecutionException paramBundle)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PoiMapActivity", 2, paramBundle.getMessage());
        continue;
      }
      label789:
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.a = paramBundle;
      if (PlatformUtil.a() >= 11)
      {
        localObject = ((ThreadPoolExecutor)PoiMapActivity.PoiMapNameTask.THREAD_POOL_EXECUTOR).getQueue();
        if ((localObject != null) && (((BlockingQueue)localObject).size() > 0)) {
          ((BlockingQueue)localObject).removeAll((Collection)localObject);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.getStatus() != AsyncTask.Status.FINISHED)
      {
        if (!this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.isCancelled()) {
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.cancel(true);
        }
      }
      else
      {
        try
        {
          localObject = new PoiMapActivity.PoiMapNameTask(this);
          ((PoiMapActivity.PoiMapNameTask)localObject).a(paramBundle);
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask = ((PoiMapActivity.PoiMapNameTask)localObject);
          this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.execute(new Void[0]);
        }
        catch (RejectedExecutionException paramBundle) {}
        if (QLog.isColorLevel())
        {
          QLog.d("PoiMapActivity", 2, paramBundle.getMessage());
          continue;
          label933:
          i1 = i2;
          if (paramLocationResp.mylbs.has())
          {
            localObject = (LBSShare.POI)paramLocationResp.mylbs.get();
            localPOI = new PoiMapActivity.POI(this);
            if (((LBSShare.POI)localObject).name.has())
            {
              paramBundle = ((LBSShare.POI)localObject).name.get();
              label988:
              localPOI.jdField_a_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).shop_url.has()) {
                break label1184;
              }
              paramBundle = ((LBSShare.POI)localObject).shop_url.get();
              label1014:
              localPOI.jdField_d_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).addr.has()) {
                break label1190;
              }
              paramBundle = ((LBSShare.POI)localObject).addr.get();
              label1040:
              localPOI.jdField_b_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).lat.has()) {
                break label1196;
              }
              i1 = ((LBSShare.POI)localObject).lat.get();
              label1066:
              localPOI.jdField_b_of_type_Int = i1;
              if (!((LBSShare.POI)localObject).lng.has()) {
                break label1201;
              }
              i1 = ((LBSShare.POI)localObject).lng.get();
              label1092:
              localPOI.jdField_c_of_type_Int = i1;
              if ((!this.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString))) {
                break label1206;
              }
              localPOI.jdField_a_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
              localPOI.jdField_d_of_type_JavaLangString = "";
              localPOI.jdField_b_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
              localPOI.jdField_b_of_type_Int = this.jdField_h_of_type_Int;
              localPOI.jdField_c_of_type_Int = this.jdField_i_of_type_Int;
            }
            for (;;)
            {
              localArrayList.add(localPOI);
              i1 = 1;
              break;
              paramBundle = super.getResources().getString(2131437033);
              break label988;
              label1184:
              paramBundle = "";
              break label1014;
              label1190:
              paramBundle = "";
              break label1040;
              label1196:
              i1 = 0;
              break label1066;
              label1201:
              i1 = 0;
              break label1092;
              label1206:
              localPOI.jdField_a_of_type_JavaLangString = super.getResources().getString(2131437033);
              this.jdField_m_of_type_JavaLangString = localPOI.jdField_b_of_type_JavaLangString;
            }
            label1232:
            i1 = 0;
            bool1 = false;
            continue;
            label1240:
            paramBundle = "";
            continue;
            label1246:
            paramBundle = "";
            continue;
            label1252:
            i2 = 0;
            continue;
            label1258:
            i2 = 0;
            continue;
            label1264:
            paramBundle = "";
            continue;
            label1270:
            if (localPOI1.shop_url.has())
            {
              paramBundle = localPOI1.shop_url.get();
              localPOI.jdField_d_of_type_JavaLangString = paramBundle;
              if (!localPOI1.shop_url_quan.has()) {
                break label1463;
              }
              paramBundle = localPOI1.shop_url_quan.get();
              localPOI.jdField_e_of_type_JavaLangString = paramBundle;
              if (!localPOI1.shop_count.has()) {
                break label1469;
              }
              i2 = localPOI1.shop_count.get();
              localPOI.jdField_a_of_type_Int = i2;
              if (!localPOI1.shangquan_url.has()) {
                break label1475;
              }
              paramBundle = localPOI1.shangquan_url.get();
              localPOI.jdField_g_of_type_JavaLangString = paramBundle;
              if (!localPOI1.shangquan_wording.has()) {
                break label1481;
              }
              paramBundle = localPOI1.shangquan_wording.get();
              localPOI.h = paramBundle;
              if (!localPOI1.POI_preview_url.has()) {
                break label1487;
              }
              paramBundle = localPOI1.POI_preview_url.get();
              localPOI.jdField_i_of_type_JavaLangString = paramBundle;
              if (!localPOI1.dpid.has()) {
                break label1493;
              }
            }
            label1290:
            label1316:
            label1343:
            label1370:
            label1396:
            for (paramBundle = localPOI1.dpid.get();; paramBundle = "")
            {
              localPOI.jdField_f_of_type_JavaLangString = paramBundle;
              break;
              paramBundle = "";
              break label1290;
              paramBundle = "";
              break label1316;
              i2 = 0;
              break label1343;
              paramBundle = "";
              break label1370;
              paramBundle = "";
              break label1396;
              paramBundle = "";
              break label1422;
            }
            label1422:
            label1463:
            label1469:
            label1475:
            label1481:
            label1487:
            label1493:
            label1499:
            localArrayList.add(localPOI);
          }
        }
      }
    }
    label1510:
    boolean bool2 = false;
    int i2 = i1;
    label1516:
    if (paramLocationResp.next.has())
    {
      i1 = paramLocationResp.next.get();
      paramLocationResp = localArrayList;
      bool1 = bool2;
    }
    for (;;)
    {
      if (i2 == 0) {}
      for (bool2 = true;; bool2 = false)
      {
        runOnUiThread(new klj(this, bool1, str2, str1, paramLocationResp, i1, i3, i4, i5, bool2));
        return;
        i1 = 0;
        break;
      }
      label1589:
      i2 = 0;
      paramLocationResp = paramBundle;
    }
  }
  
  protected void a(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle)
  {
    if (paramNearByShopsResp == null) {
      if (QLog.isColorLevel()) {
        QLog.i("PoiMapActivity", 2, "onGetLbsShareShop null");
      }
    }
    int i1;
    label109:
    label245:
    label375:
    do
    {
      do
      {
        return;
        i1 = paramNearByShopsResp.ec.get();
        if (i1 != 0) {
          break;
        }
        paramBundle.getInt("begin", 0);
        if (paramNearByShopsResp.next_begin.has()) {
          paramNearByShopsResp.next_begin.get();
        }
        if (paramNearByShopsResp.total.has()) {
          paramNearByShopsResp.total.get();
        }
      } while (!paramNearByShopsResp.poilist.has());
      paramBundle = new ArrayList();
      Iterator localIterator = paramNearByShopsResp.poilist.get().iterator();
      LBSShare.Shop localShop;
      PoiMapActivity.GeneralShops localGeneralShops;
      if (localIterator.hasNext())
      {
        localShop = (LBSShare.Shop)localIterator.next();
        localGeneralShops = new PoiMapActivity.GeneralShops(this);
        localGeneralShops.jdField_a_of_type_Int = 1;
        if (!localShop.id.has()) {
          break label417;
        }
        paramNearByShopsResp = localShop.id.get();
        localGeneralShops.h = paramNearByShopsResp;
        if (!localShop.name.has()) {
          break label423;
        }
        paramNearByShopsResp = localShop.name.get();
        localGeneralShops.jdField_e_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.logo.has()) {
          break label429;
        }
        paramNearByShopsResp = localShop.logo.get();
        localGeneralShops.jdField_f_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.url.has()) {
          break label435;
        }
        paramNearByShopsResp = localShop.url.get();
        localGeneralShops.jdField_g_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.detail.has()) {
          break label441;
        }
        paramNearByShopsResp = localShop.detail.get();
        localGeneralShops.jdField_a_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.discount.has()) {
          break label447;
        }
        paramNearByShopsResp = localShop.discount.get();
        localGeneralShops.jdField_b_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.price.has()) {
          break label453;
        }
        paramNearByShopsResp = localShop.price.get();
        localGeneralShops.jdField_c_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.soldnum.has()) {
          break label459;
        }
        paramNearByShopsResp = localShop.soldnum.get();
        localGeneralShops.jdField_d_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.has_tuan.has()) {
          break label465;
        }
        i1 = localShop.has_tuan.get();
        localGeneralShops.jdField_b_of_type_Int = i1;
        if (!localShop.has_quan.has()) {
          break label470;
        }
      }
      for (i1 = localShop.has_quan.get();; i1 = 0)
      {
        localGeneralShops.jdField_c_of_type_Int = i1;
        paramBundle.add(localGeneralShops);
        break label109;
        break;
        paramNearByShopsResp = "";
        break label167;
        paramNearByShopsResp = "";
        break label193;
        paramNearByShopsResp = "";
        break label219;
        paramNearByShopsResp = "";
        break label245;
        paramNearByShopsResp = "";
        break label271;
        paramNearByShopsResp = "";
        break label297;
        paramNearByShopsResp = "";
        break label323;
        paramNearByShopsResp = "";
        break label349;
        i1 = 0;
        break label375;
      }
    } while (!QLog.isColorLevel());
    label167:
    label193:
    label219:
    label349:
    QLog.i("PoiMapActivity", 2, "onGetLbsShareShop error:" + i1);
    label271:
    label297:
    label323:
    label453:
    label459:
    label465:
    label470:
    return;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131437000));
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_n_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, paramString, "", 0, 20);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter.notifyDataSetChanged();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void a(String paramString, List paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_d_of_type_Boolean = paramBoolean;
      this.jdField_f_of_type_Boolean = false;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label216;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131433826));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter.notifyDataSetChanged();
      return;
      if (this.jdField_n_of_type_Int == 0) {
        this.jdField_a_of_type_JavaUtilList.clear();
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        if (this.jdField_k_of_type_Boolean)
        {
          a("share_locate", "click_sch", paramString, "0", "", "");
          break;
        }
        a("share_locate", "click_sch", paramString, "0", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        break;
      }
      if (this.jdField_k_of_type_Boolean)
      {
        a("share_locate", "click_sch", paramString, "1", "", "");
        break;
      }
      a("share_locate", "click_sch", paramString, "1", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      break;
      label216:
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((this.jdField_h_of_type_Int != paramInt1) && (this.jdField_i_of_type_Int != paramInt2)) {}
    label142:
    label159:
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= paramInt2) {
          break label159;
        }
        if (this.jdField_b_of_type_ArrayOfJavaLangString[paramInt1].equals(paramString))
        {
          paramString = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[paramInt1];
          if (paramInt3 != 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramString.a(paramArrayList, bool, paramInt4, paramBoolean);
            if ((paramInt1 != 0) || (!this.jdField_g_of_type_Boolean)) {
              break;
            }
            if ((paramArrayList == null) || (paramArrayList.size() <= 1)) {
              break label142;
            }
            this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, true);
            if (this.jdField_k_of_type_Boolean) {
              break;
            }
            a("share_locate", "pageview_all", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, "", "");
            return;
          }
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, true);
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(List paramList, int paramInt)
  {
    Object localObject;
    if (paramList != null)
    {
      l();
      localObject = new PolyLineOverlay(paramList, DisplayUtil.a(this, 7.0F), Color.parseColor("#389dff"));
      if (this.jdField_a_of_type_ComTencentBizWidgetsPolyLineOverlay == null)
      {
        this.jdField_a_of_type_ComTencentBizWidgetsPolyLineOverlay = ((PolyLineOverlay)localObject);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.addOverlay((Overlay)localObject);
        m();
        this.jdField_e_of_type_AndroidWidgetTextView.setText(QQMapRoutingHelper.a(paramInt));
      }
    }
    for (;;)
    {
      z();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(new LatLng(this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6() / 1000000.0D, this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6() / 1000000.0D));
      if ((paramList != null) && (paramList.size() > 0)) {
        ((ArrayList)localObject).addAll(paramList);
      }
      ((ArrayList)localObject).add(new LatLng(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double));
      QQMapRoutingHelper.a((List)localObject, this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView, DisplayUtil.a(this, 42.0F));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.invalidate();
      return;
      QQToast.a(this, 0, "未查询到路线", 0).b(getResources().getDimensionPixelSize(2131558448));
    }
  }
  
  protected boolean a()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  public void b()
  {
    this.jdField_h_of_type_Boolean = false;
    Dialog localDialog = new Dialog(this);
    localDialog.setCanceledOnTouchOutside(true);
    InputMethodManager localInputMethodManager = (InputMethodManager)super.getSystemService("input_method");
    int i1 = this.jdField_c_of_type_AndroidViewView.getHeight();
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -i1);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
    localDialog.requestWindowFeature(1);
    localDialog.getWindow().setSoftInputMode(36);
    localDialog.setContentView(2130971550);
    Object localObject2 = localDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = 0;
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject2).gravity = 51;
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject2 = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    kls localkls = new kls(this, (TranslateAnimation)localObject1, localDialog, i1, (TranslateAnimation)localObject2);
    ((TranslateAnimation)localObject1).setAnimationListener(localkls);
    ((TranslateAnimation)localObject2).setAnimationListener(localkls);
    localDialog.setOnDismissListener(new klt(this, (TranslateAnimation)localObject2, localInputMethodManager));
    this.jdField_d_of_type_AndroidViewView = localDialog.findViewById(2131362845);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131368324));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new PoiMapActivity.SearchTextWatcher(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131368325));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new klv(this));
    localObject1 = (Button)localDialog.findViewById(2131368323);
    ((Button)localObject1).setVisibility(0);
    ((Button)localObject1).setOnClickListener(new klw(this, localDialog));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localDialog.findViewById(2131363950));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131363948));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new klx(this, localDialog));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131365674));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(super.getResources().getDrawable(2130838219));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter = new PoiMapActivity.SearchResultAdapter(this, this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new kly(this, localInputMethodManager));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new klg(this, localDialog));
    if (1 == HttpUtil.a()) {}
    for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = false)
    {
      this.jdField_b_of_type_Boolean = true;
      QQMapRoutingHelper.a("search", a());
      return;
    }
  }
  
  public void b(GeoPoint paramGeoPoint)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840453);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentBizWidgetsPolyLineOverlay != null;
  }
  
  protected void c()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      a("rec_locate", "click_rec_return", "", "", "", "");
      return;
    }
    a("share_locate", "click_rec_return", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, "", "");
  }
  
  protected void c(GeoPoint paramGeoPoint)
  {
    int i1 = paramGeoPoint.getLatitudeE6();
    int i2 = paramGeoPoint.getLongitudeE6();
    super.c(paramGeoPoint);
    if (QLog.isColorLevel()) {
      QLog.d("PoiMapActivity", 2, "lat=" + i1 + ", lon=" + i2);
    }
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_h_of_type_Int = i1;
    this.jdField_i_of_type_Int = i2;
    this.jdField_j_of_type_Int = this.jdField_h_of_type_Int;
    this.jdField_k_of_type_Int = this.jdField_i_of_type_Int;
    this.jdField_c_of_type_Boolean = false;
    i2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    i1 = 0;
    if (i1 < i2)
    {
      if (i1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(false);
        if (this.jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(-1, false);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, false);
        continue;
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(-1, true);
      }
    }
    this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[this.jdField_l_of_type_Int].b(true);
  }
  
  protected void d()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMapCenter();
    localObject1 = new GeoPoint((int)(((LatLng)localObject1).getLatitude() * 1000000.0D), (int)(((LatLng)localObject1).getLongitude() * 1000000.0D));
    String str1 = String.valueOf(((GeoPoint)localObject1).getLatitudeE6() / 1000000.0D);
    String str2 = String.valueOf(((GeoPoint)localObject1).getLongitudeE6() / 1000000.0D);
    String str3 = str1 + "," + str2 + "," + this.jdField_f_of_type_JavaLangString + "," + this.jdField_e_of_type_JavaLangString;
    Object localObject2;
    label178:
    int i1;
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localObject1 = "0";
      String str4 = this.jdField_l_of_type_Int + 1 + "";
      if (!this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[this.jdField_l_of_type_Int].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean) {
        break label343;
      }
      localObject2 = "2";
      a("share_locate", "click_send", str3, (String)localObject1, str4, (String)localObject2);
      if (this.jdField_i_of_type_Boolean)
      {
        a("rec_locate", "send_googlestation", "", "", "", "");
        a("rec_locate", "send_foursquare", "", "", "", "");
      }
      localObject1 = getIntent();
      if (((Intent)localObject1).getIntExtra("uintype", 0) == 1008)
      {
        localObject2 = new Intent("com.tencent.biz.pubaccount.locationResultAction");
        ((Intent)localObject2).putExtra("latitude", str1);
        ((Intent)localObject2).putExtra("longitude", str2);
        ((Intent)localObject2).putExtra("name", this.jdField_m_of_type_JavaLangString);
        sendBroadcast((Intent)localObject2, "com.tencent.msg.permission.pushnotify");
      }
      i1 = ((Intent)localObject1).getIntExtra("sessionType", 1);
      if (i1 != 1) {
        break label350;
      }
      localObject1 = "group";
    }
    for (;;)
    {
      QQMapRoutingHelper.a("send_location", a(), (String)localObject1);
      return;
      localObject1 = this.jdField_b_of_type_JavaLangString;
      break;
      label343:
      localObject2 = "1";
      break label178;
      label350:
      if (i1 == 0) {
        localObject1 = "person";
      } else if (i1 == 3000) {
        localObject1 = "disc_group";
      } else {
        localObject1 = "other";
      }
    }
  }
  
  protected void e()
  {
    a("rec_locate", "click_view", "", "", "", "");
  }
  
  protected void f()
  {
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("poi_category", "");
    Object localObject1;
    String[] arrayOfString;
    int i1;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = null;
      try
      {
        localObject2 = new JSONArray((String)localObject2);
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          try
          {
            int i2;
            localObject3 = localObject1.getJSONObject(i1);
            str = ((JSONObject)localObject3).getString("name");
            localObject3 = ((JSONObject)localObject3).getString("id");
            localObject2[i1] = str;
            arrayOfString[i1] = localObject3;
            i1 += 1;
          }
          catch (JSONException localJSONException1)
          {
            localJSONException1.printStackTrace();
            i1 = 1;
          }
          localJSONException2 = localJSONException2;
          localJSONException2.printStackTrace();
        }
      }
      if ((localObject1 != null) && (localObject1.length() > 0))
      {
        i2 = localObject1.length();
        localObject2 = new String[i2];
        arrayOfString = new String[i2];
        i1 = 0;
        if (i1 >= i2) {
          break label198;
        }
      }
    }
    for (;;)
    {
      Object localObject3;
      String str;
      if (i1 == 0)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = localJSONException2;
        this.jdField_b_of_type_ArrayOfJavaLangString = arrayOfString;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("PoiMapActivity", 4, "mTabName:" + this.jdField_a_of_type_ArrayOfJavaLangString.toString());
      }
      return;
      label198:
      i1 = 0;
    }
  }
  
  public void g()
  {
    this.p = super.getResources().getDimensionPixelSize(2131558853);
    this.s = super.getResources().getDimensionPixelSize(2131558855);
    this.t = super.getResources().getDimensionPixelSize(2131558851);
    this.jdField_q_of_type_Int = super.getResources().getDimensionPixelSize(2131558858);
    this.jdField_r_of_type_Int = super.getResources().getDimensionPixelSize(2131558859);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131371614));
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(this.jdField_d_of_type_Int);
    if (this.jdField_r_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.jdField_i_of_type_AndroidViewView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.jdField_i_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = (FrameLayout)super.findViewById(2131371615);
    this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab = new PoiMapActivity.PoiTab[this.jdField_a_of_type_ArrayOfJavaLangString.length];
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -1);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams1.weight = 1.0F;
    int i2 = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      PoiMapActivity.PoiTab localPoiTab = new PoiMapActivity.PoiTab(this, this, this.jdField_a_of_type_ArrayOfJavaLangString[i1], i1);
      if (i1 == 0)
      {
        localPoiTab.a(true);
        localPoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Int = 0;
      }
      if (i1 == i2 - 1) {
        localPoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.a();
      }
      this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1] = localPoiTab;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localPoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView, localLayoutParams1);
      ((FrameLayout)localObject).addView(localPoiTab.jdField_a_of_type_ComTencentWidgetXListView, localLayoutParams2);
      i1 += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    }
  }
  
  protected void h()
  {
    super.h();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while ((this.p <= 0) || (this.jdField_o_of_type_Int <= 0)) {
      return;
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(this.jdField_o_of_type_Int + this.p), Integer.valueOf(this.jdField_o_of_type_Int), new klm(this));
    localValueAnimation.setDuration(300L);
    localValueAnimation.setFillAfter(true);
    localValueAnimation.setAnimationListener(new kln(this));
    this.jdField_i_of_type_AndroidViewView.startAnimation(localValueAnimation);
  }
  
  public void j()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((this.p <= 0) || (this.jdField_o_of_type_Int <= 0)) {
      return;
    }
    ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(this.jdField_o_of_type_Int), Integer.valueOf(this.jdField_o_of_type_Int + this.p), new klo(this));
    localValueAnimation.setDuration(300L);
    localValueAnimation.setFillAfter(true);
    localValueAnimation.setAnimationListener(new klp(this));
    this.jdField_i_of_type_AndroidViewView.startAnimation(localValueAnimation);
  }
  
  protected void k()
  {
    super.k();
    String str = "{" + "\"id\":\"" + this.jdField_b_of_type_JavaLangString + "\"," + "\"title\":\"" + this.jdField_l_of_type_JavaLangString + "\"," + "\"address\":\"" + this.jdField_m_of_type_JavaLangString + "\"," + "\"location\":{" + "\"lat\":\"" + this.jdField_j_of_type_Int * 1.0F / 1000000.0D + "\"," + "\"lon\":\"" + this.jdField_k_of_type_Int * 1.0F / 1000000.0D + "\"" + "}" + "}";
    Intent localIntent = new Intent();
    localIntent.putExtra("result", str);
    setResult(-1, localIntent);
    finish();
  }
  
  public void l()
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("onHideRoute:");
          if (this.jdField_a_of_type_ComTencentBizWidgetsPolyLineOverlay != null)
          {
            bool = true;
            QLog.d("Q.qqmap", 2, bool);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentBizWidgetsPolyLineOverlay != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.a(this.jdField_a_of_type_ComTencentBizWidgetsPolyLineOverlay);
            this.jdField_a_of_type_ComTencentBizWidgetsPolyLineOverlay = null;
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.invalidate();
          }
          return;
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("Q.qqmap", 2, "onHideRoute:", localException);
      }
      bool = false;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131371619: 
    case 2131371611: 
      label129:
      do
      {
        return;
        if (this.jdField_k_of_type_Boolean) {
          if (this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint != null)
          {
            z();
            if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController != null) {
              this.jdField_a_of_type_ComTencentTencentmapMapsdkMapMapController.setCenter(this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint);
            }
            if (!this.jdField_k_of_type_Boolean) {
              break label129;
            }
            a("rec_locate", "click_locate_rec", "", "", "", "");
          }
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130840455);
          return;
          a(true);
          break;
          a(true);
          break;
          a("share_locate", "click_locate_share", "", "", "", "");
        }
      } while (this.jdField_a_of_type_Boolean);
      i();
      return;
    }
    paramView = new GeoPoint((int)(this.jdField_a_of_type_Double * 1000000.0D), (int)(this.jdField_b_of_type_Double * 1000000.0D));
    this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper.a(this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint, paramView, this.jdField_q_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString);
    QQMapRoutingHelper.a("navigation_click");
    QQMapRoutingHelper.b("click_navig", "0");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      this.jdField_a_of_type_Int = super.getResources().getColor(2131494270);
      this.jdField_b_of_type_Int = super.getResources().getColor(2131494220);
      this.jdField_c_of_type_Int = super.getResources().getColor(2131493167);
      this.jdField_d_of_type_Int = 2130846017;
      this.jdField_e_of_type_Int = 2130838591;
    }
    for (this.jdField_f_of_type_Int = 2130841533;; this.jdField_f_of_type_Int = 2130841534)
    {
      this.jdField_g_of_type_Int = Color.rgb(0, 121, 255);
      this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
      this.jdField_j_of_type_Boolean = getIntent().getBooleanExtra("is_need_destroy_broadcast", true);
      this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper = new QQMapRoutingHelper(this);
      this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper.a(this);
      f();
      a();
      return;
      this.jdField_a_of_type_Int = super.getResources().getColor(2131494272);
      this.jdField_b_of_type_Int = super.getResources().getColor(2131494224);
      this.jdField_c_of_type_Int = super.getResources().getColor(2131493164);
      this.jdField_d_of_type_Int = 2130846017;
      this.jdField_e_of_type_Int = 2130838591;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity
 * JD-Core Version:    0.7.0.1
 */