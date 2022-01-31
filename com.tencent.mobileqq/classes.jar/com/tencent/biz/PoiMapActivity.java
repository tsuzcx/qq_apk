package com.tencent.biz;

import alpo;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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
import azmj;
import bcwh;
import bdjs;
import bhpo;
import com.tencent.component.network.utils.PlatformUtil;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare.DPBiz;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.proto.lbsshare.LBSShare.Shop;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import myl;
import myu;
import myv;
import myw;
import myx;
import myy;
import myz;
import mza;
import mzb;
import mzc;
import mzd;
import mze;
import mzf;
import mzg;
import mzh;
import mzi;
import mzj;
import mzk;
import mzl;
import mzm;
import mzn;
import mzp;
import mzq;
import mzt;
import mzu;
import mzw;
import ndd;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zcg;
import zci;

public class PoiMapActivity
  extends QQMapActivity
  implements View.OnClickListener, zci
{
  protected float a;
  public int a;
  public View.OnClickListener a;
  View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new myv(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new mzd(this);
  protected View a;
  public final ViewTreeObserver.OnPreDrawListener a;
  public EditText a;
  public ImageButton a;
  protected ImageView a;
  public LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected bhpo a;
  public XListView a;
  public final String a;
  public List<mzm> a;
  protected myl a;
  public mzp a;
  public mzt a;
  protected zcg a;
  public boolean a;
  String[] jdField_a_of_type_ArrayOfJavaLangString = { alpo.a(2131708699), alpo.a(2131708698), alpo.a(2131708700), alpo.a(2131708696) };
  public mzq[] a;
  public int b;
  public View b;
  protected ImageView b;
  protected LinearLayout b;
  public String b;
  protected boolean b;
  public String[] b;
  protected int c;
  View c;
  public String c;
  public boolean c;
  public int d;
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
  public int g;
  public boolean g;
  public int h;
  public boolean h;
  public int i;
  protected boolean i;
  public int j;
  protected boolean j;
  public int k;
  private View k;
  public int l;
  protected final int m;
  public int n;
  public int o;
  public int p;
  public int q;
  protected int r;
  protected int s;
  public int t;
  public int u;
  protected int v;
  
  public PoiMapActivity()
  {
    this.jdField_a_of_type_JavaLangString = "PoiMapActivity";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_m_of_type_Int = 20;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_Boolean = true;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_a_of_type_Bhpo = new myw(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new myx(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener = new myy(this);
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "", "281100|281200", "281000|281010|281011|281012|281013|281099", "100000|130000" };
  }
  
  public Intent a()
  {
    super.a();
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap() != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().getCameraPosition() != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().getCameraPosition().target != null))
    {
      LatLng localLatLng = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().getCameraPosition().target;
      localBundle.putString("latitude", String.valueOf(localLatLng.getLatitude()));
      localBundle.putString("longitude", String.valueOf(localLatLng.getLongitude()));
    }
    localBundle.putString("poiId", this.jdField_b_of_type_JavaLangString);
    localBundle.putBoolean("isForien", this.jdField_i_of_type_Boolean);
    localBundle.putInt("isArk", this.v);
    localBundle.putString("description", this.jdField_g_of_type_JavaLangString);
    localBundle.putString("latSpan", String.valueOf(this.jdField_h_of_type_Int));
    localBundle.putString("lngSpan", String.valueOf(this.jdField_i_of_type_Int));
    if ((TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString)) || (this.jdField_l_of_type_JavaLangString.equals(getString(2131695386)))) {
      this.jdField_l_of_type_JavaLangString = getString(2131694121);
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
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131373500));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131376168);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131372127);
    this.jdField_k_of_type_AndroidViewView = super.findViewById(2131370033);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131372133));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131695390));
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
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().getUiSettings().setLogoPosition(2);
      }
    }
    for (;;)
    {
      Object localObject = (FrameLayout.LayoutParams)this.jdField_k_of_type_AndroidViewView.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).bottomMargin = (this.p + this.jdField_q_of_type_Int);
      this.jdField_k_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_c_of_type_AndroidViewView = super.findViewById(2131377884);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131366779));
      super.findViewById(2131363520).setVisibility(8);
      localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131365849);
      ((EditText)localObject).setFocusable(false);
      ((EditText)localObject).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_j_of_type_AndroidViewView.setVisibility(8);
      g();
      if (!"group_activity".equals(this.jdField_o_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().setOnMapClickListener(new myu(this));
        this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131372135);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ArrayOfMzq == null) || (paramInt >= this.jdField_a_of_type_ArrayOfMzq.length)) {
      return;
    }
    this.jdField_l_of_type_Int = paramInt;
    int i2 = this.jdField_a_of_type_ArrayOfMzq.length;
    int i1 = 0;
    label30:
    if (i1 < i2)
    {
      if (i1 != paramInt) {
        break label67;
      }
      this.jdField_a_of_type_ArrayOfMzq[i1].a(true);
      this.jdField_a_of_type_ArrayOfMzq[i1].b(true);
    }
    for (;;)
    {
      i1 += 1;
      break label30;
      break;
      label67:
      this.jdField_a_of_type_ArrayOfMzq[i1].a(false);
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
  
  public void a(GeoPoint paramGeoPoint)
  {
    int i1 = paramGeoPoint.getLatitudeE6();
    int i2 = paramGeoPoint.getLongitudeE6();
    if ((this.jdField_h_of_type_Int == i1) && (this.jdField_i_of_type_Int == i2)) {
      return;
    }
    super.a(paramGeoPoint);
    if (QLog.isColorLevel()) {
      QLog.d("PoiMapActivity", 2, "lat=" + i1 + ", lon=" + i2);
    }
    this.jdField_l_of_type_JavaLangString = "";
    this.jdField_h_of_type_Int = i1;
    this.jdField_i_of_type_Int = i2;
    this.jdField_j_of_type_Int = this.jdField_h_of_type_Int;
    this.jdField_k_of_type_Int = this.jdField_i_of_type_Int;
    this.jdField_c_of_type_Boolean = false;
    i2 = this.jdField_a_of_type_ArrayOfMzq.length;
    i1 = 0;
    if (i1 < i2)
    {
      if (i1 == 0)
      {
        this.jdField_a_of_type_ArrayOfMzq[0].jdField_a_of_type_Mzn.a(false);
        if (this.jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfMzq[0].a(-1, false);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.jdField_a_of_type_ArrayOfMzq[0].a(0, false);
        continue;
        this.jdField_a_of_type_ArrayOfMzq[i1].a(-1, true);
      }
    }
    this.jdField_a_of_type_ArrayOfMzq[this.jdField_l_of_type_Int].b(true);
  }
  
  public void a(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp)
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
      mzw localmzw;
      if (localIterator.hasNext())
      {
        localDPBiz = (LBSShare.DPBiz)localIterator.next();
        localmzw = new mzw(this);
        localmzw.jdField_a_of_type_Int = 1;
        if (!localDPBiz.id.has()) {
          break label372;
        }
        paramGetShopsByIdsResp = localDPBiz.id.get();
        localmzw.h = paramGetShopsByIdsResp;
        if (!localDPBiz.name.has()) {
          break label378;
        }
        paramGetShopsByIdsResp = localDPBiz.name.get();
        localmzw.jdField_e_of_type_JavaLangString = paramGetShopsByIdsResp;
        if (!localDPBiz.logo.has()) {
          break label384;
        }
        paramGetShopsByIdsResp = localDPBiz.logo.get();
        localmzw.jdField_f_of_type_JavaLangString = paramGetShopsByIdsResp;
        if (!localDPBiz.url.has()) {
          break label390;
        }
        paramGetShopsByIdsResp = localDPBiz.url.get();
        localmzw.jdField_g_of_type_JavaLangString = paramGetShopsByIdsResp;
        if (!localDPBiz.avg_price.has()) {
          break label396;
        }
        paramGetShopsByIdsResp = localDPBiz.avg_price.get();
        localmzw.jdField_b_of_type_JavaLangString = paramGetShopsByIdsResp;
        if (!localDPBiz.biz_zone.has()) {
          break label402;
        }
        paramGetShopsByIdsResp = localDPBiz.biz_zone.get();
        localmzw.jdField_c_of_type_JavaLangString = paramGetShopsByIdsResp;
        if (!localDPBiz.category.has()) {
          break label408;
        }
        paramGetShopsByIdsResp = localDPBiz.category.get();
        localmzw.jdField_a_of_type_JavaLangString = paramGetShopsByIdsResp;
        if (!localDPBiz.has_quan.has()) {
          break label414;
        }
        i1 = localDPBiz.has_quan.get();
        localmzw.jdField_c_of_type_Int = i1;
        if (!localDPBiz.has_tuan.has()) {
          break label419;
        }
        i1 = localDPBiz.has_tuan.get();
        localmzw.jdField_b_of_type_Int = i1;
        if (!localDPBiz.rate.has()) {
          break label424;
        }
      }
      for (i1 = localDPBiz.rate.get();; i1 = 0)
      {
        localmzw.jdField_d_of_type_Int = i1;
        localArrayList.add(localmzw);
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
  
  public void a(LBSShare.LocationResp paramLocationResp, Bundle paramBundle)
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
      this.v = paramLocationResp.is_ark.get();
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
        QQToast.a(this, super.getString(2131693849), 0).a();
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
      if (this.jdField_a_of_type_Mzp != null) {
        break label789;
      }
    }
    for (;;)
    {
      Object localObject;
      LBSShare.POI localPOI;
      mzm localmzm;
      try
      {
        this.jdField_a_of_type_Mzp = new mzp(this);
        this.jdField_a_of_type_Mzp.a(paramBundle);
        this.jdField_a_of_type_Mzp.execute(new Void[0]);
        paramBundle = new mzm(this);
        paramBundle.jdField_a_of_type_JavaLangString = super.getResources().getString(2131695386);
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
        localPOI = (LBSShare.POI)((Iterator)localObject).next();
        localmzm = new mzm(this);
        if (!localPOI.name.has()) {
          break label1240;
        }
        paramBundle = localPOI.name.get();
        localmzm.jdField_a_of_type_JavaLangString = paramBundle;
        if (!localPOI.addr.has()) {
          break label1246;
        }
        paramBundle = localPOI.addr.get();
        localmzm.jdField_b_of_type_JavaLangString = paramBundle;
        if (!localPOI.lat.has()) {
          break label1252;
        }
        i2 = localPOI.lat.get();
        localmzm.jdField_b_of_type_Int = i2;
        if (!localPOI.lng.has()) {
          break label1258;
        }
        i2 = localPOI.lng.get();
        localmzm.jdField_c_of_type_Int = i2;
        if (!localPOI.id.has()) {
          break label1264;
        }
        paramBundle = localPOI.id.get();
        localmzm.jdField_c_of_type_JavaLangString = paramBundle;
        if (!"group_activity".equals(this.jdField_o_of_type_JavaLangString)) {
          break label1270;
        }
        localmzm.jdField_d_of_type_JavaLangString = "";
        localmzm.jdField_e_of_type_JavaLangString = "";
        localmzm.jdField_a_of_type_Int = 0;
        localmzm.jdField_g_of_type_JavaLangString = "";
        localmzm.h = "";
        localmzm.jdField_i_of_type_JavaLangString = "";
        localmzm.jdField_f_of_type_JavaLangString = "";
        if (!TextUtils.isEmpty(localmzm.jdField_d_of_type_JavaLangString)) {
          a("share_locate", "view_share_tuan", "", "", "", "");
        }
        if ((TextUtils.isEmpty(localmzm.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(localmzm.jdField_e_of_type_JavaLangString))) {
          a("share_locate", "view_quan", "", "", "", "");
        }
        if ((!this.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) || (!this.jdField_d_of_type_JavaLangString.equals(localmzm.jdField_c_of_type_JavaLangString))) {
          break label1499;
        }
        if (!localArrayList.isEmpty())
        {
          paramBundle = (mzm)localArrayList.get(0);
          if ((this.jdField_l_of_type_JavaLangString.equals(paramBundle.jdField_a_of_type_JavaLangString)) && (this.jdField_m_of_type_JavaLangString.equals(paramBundle.jdField_b_of_type_JavaLangString))) {
            localArrayList.remove(0);
          }
        }
        localArrayList.add(0, localmzm);
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
      this.jdField_a_of_type_Mzp.a = paramBundle;
      if (PlatformUtil.version() >= 11)
      {
        localObject = ((ThreadPoolExecutor)mzp.THREAD_POOL_EXECUTOR).getQueue();
        if ((localObject != null) && (((BlockingQueue)localObject).size() > 0)) {
          ((BlockingQueue)localObject).removeAll((Collection)localObject);
        }
      }
      if (this.jdField_a_of_type_Mzp.getStatus() != AsyncTask.Status.FINISHED)
      {
        if (!this.jdField_a_of_type_Mzp.isCancelled()) {
          this.jdField_a_of_type_Mzp.cancel(true);
        }
      }
      else
      {
        try
        {
          localObject = new mzp(this);
          ((mzp)localObject).a(paramBundle);
          this.jdField_a_of_type_Mzp = ((mzp)localObject);
          this.jdField_a_of_type_Mzp.execute(new Void[0]);
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
            localmzm = new mzm(this);
            if (((LBSShare.POI)localObject).name.has())
            {
              paramBundle = ((LBSShare.POI)localObject).name.get();
              label988:
              localmzm.jdField_a_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).shop_url.has()) {
                break label1184;
              }
              paramBundle = ((LBSShare.POI)localObject).shop_url.get();
              label1014:
              localmzm.jdField_d_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).addr.has()) {
                break label1190;
              }
              paramBundle = ((LBSShare.POI)localObject).addr.get();
              label1040:
              localmzm.jdField_b_of_type_JavaLangString = paramBundle;
              if (!((LBSShare.POI)localObject).lat.has()) {
                break label1196;
              }
              i1 = ((LBSShare.POI)localObject).lat.get();
              label1066:
              localmzm.jdField_b_of_type_Int = i1;
              if (!((LBSShare.POI)localObject).lng.has()) {
                break label1201;
              }
              i1 = ((LBSShare.POI)localObject).lng.get();
              label1092:
              localmzm.jdField_c_of_type_Int = i1;
              if ((!this.jdField_c_of_type_Boolean) || (TextUtils.isEmpty(this.jdField_l_of_type_JavaLangString))) {
                break label1206;
              }
              localmzm.jdField_a_of_type_JavaLangString = this.jdField_l_of_type_JavaLangString;
              localmzm.jdField_d_of_type_JavaLangString = "";
              localmzm.jdField_b_of_type_JavaLangString = this.jdField_m_of_type_JavaLangString;
              localmzm.jdField_b_of_type_Int = this.jdField_h_of_type_Int;
              localmzm.jdField_c_of_type_Int = this.jdField_i_of_type_Int;
            }
            for (;;)
            {
              localArrayList.add(localmzm);
              i1 = 1;
              break;
              paramBundle = super.getResources().getString(2131695386);
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
              localmzm.jdField_a_of_type_JavaLangString = super.getResources().getString(2131695386);
              this.jdField_m_of_type_JavaLangString = localmzm.jdField_b_of_type_JavaLangString;
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
            if (localPOI.shop_url.has())
            {
              paramBundle = localPOI.shop_url.get();
              localmzm.jdField_d_of_type_JavaLangString = paramBundle;
              if (!localPOI.shop_url_quan.has()) {
                break label1463;
              }
              paramBundle = localPOI.shop_url_quan.get();
              localmzm.jdField_e_of_type_JavaLangString = paramBundle;
              if (!localPOI.shop_count.has()) {
                break label1469;
              }
              i2 = localPOI.shop_count.get();
              localmzm.jdField_a_of_type_Int = i2;
              if (!localPOI.shangquan_url.has()) {
                break label1475;
              }
              paramBundle = localPOI.shangquan_url.get();
              localmzm.jdField_g_of_type_JavaLangString = paramBundle;
              if (!localPOI.shangquan_wording.has()) {
                break label1481;
              }
              paramBundle = localPOI.shangquan_wording.get();
              localmzm.h = paramBundle;
              if (!localPOI.POI_preview_url.has()) {
                break label1487;
              }
              paramBundle = localPOI.POI_preview_url.get();
              localmzm.jdField_i_of_type_JavaLangString = paramBundle;
              if (!localPOI.dpid.has()) {
                break label1493;
              }
            }
            label1290:
            label1316:
            label1343:
            label1370:
            label1396:
            for (paramBundle = localPOI.dpid.get();; paramBundle = "")
            {
              localmzm.jdField_f_of_type_JavaLangString = paramBundle;
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
            localArrayList.add(localmzm);
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
        runOnUiThread(new PoiMapActivity.12(this, bool1, str2, str1, paramLocationResp, i1, i3, i4, i5, bool2));
        return;
        i1 = 0;
        break;
      }
      label1589:
      i2 = 0;
      paramLocationResp = paramBundle;
    }
  }
  
  public void a(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle)
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
      mzl localmzl;
      if (localIterator.hasNext())
      {
        localShop = (LBSShare.Shop)localIterator.next();
        localmzl = new mzl(this);
        localmzl.jdField_a_of_type_Int = 1;
        if (!localShop.id.has()) {
          break label417;
        }
        paramNearByShopsResp = localShop.id.get();
        localmzl.h = paramNearByShopsResp;
        if (!localShop.name.has()) {
          break label423;
        }
        paramNearByShopsResp = localShop.name.get();
        localmzl.jdField_e_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.logo.has()) {
          break label429;
        }
        paramNearByShopsResp = localShop.logo.get();
        localmzl.jdField_f_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.url.has()) {
          break label435;
        }
        paramNearByShopsResp = localShop.url.get();
        localmzl.jdField_g_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.detail.has()) {
          break label441;
        }
        paramNearByShopsResp = localShop.detail.get();
        localmzl.jdField_a_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.discount.has()) {
          break label447;
        }
        paramNearByShopsResp = localShop.discount.get();
        localmzl.jdField_b_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.price.has()) {
          break label453;
        }
        paramNearByShopsResp = localShop.price.get();
        localmzl.jdField_c_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.soldnum.has()) {
          break label459;
        }
        paramNearByShopsResp = localShop.soldnum.get();
        localmzl.jdField_d_of_type_JavaLangString = paramNearByShopsResp;
        if (!localShop.has_tuan.has()) {
          break label465;
        }
        i1 = localShop.has_tuan.get();
        localmzl.jdField_b_of_type_Int = i1;
        if (!localShop.has_quan.has()) {
          break label470;
        }
      }
      for (i1 = localShop.has_quan.get();; i1 = 0)
      {
        localmzl.jdField_c_of_type_Int = i1;
        paramBundle.add(localmzl);
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131695382));
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_n_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, paramString, "", 0, 20);
    this.jdField_a_of_type_Mzt.notifyDataSetChanged();
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    azmj.b(null, "P_CliOper", "Pb_account_lifeservice", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  protected void a(String paramString, List<mzm> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_d_of_type_Boolean = paramBoolean;
      this.jdField_f_of_type_Boolean = false;
      if (!this.jdField_a_of_type_JavaUtilList.isEmpty()) {
        break label216;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131719567));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Mzt.notifyDataSetChanged();
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
  
  public void a(ArrayList<mzm> paramArrayList, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((this.jdField_h_of_type_Int != paramInt1) && (this.jdField_i_of_type_Int != paramInt2)) {}
    label142:
    label159:
    for (;;)
    {
      return;
      paramInt2 = this.jdField_a_of_type_ArrayOfMzq.length;
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 >= paramInt2) {
          break label159;
        }
        if (this.jdField_b_of_type_ArrayOfJavaLangString[paramInt1].equals(paramString))
        {
          paramString = this.jdField_a_of_type_ArrayOfMzq[paramInt1];
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
            this.jdField_a_of_type_ArrayOfMzq[0].a(0, true);
            if (this.jdField_k_of_type_Boolean) {
              break;
            }
            a("share_locate", "pageview_all", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, "", "");
            return;
          }
          this.jdField_a_of_type_ArrayOfMzq[0].a(0, true);
          return;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void a(List<LatLng> paramList, int paramInt)
  {
    Object localObject;
    if (paramList != null)
    {
      l();
      localObject = this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.addPolyline(new PolylineOptions().addAll(paramList).width(bcwh.a(this, 7.0F)).color(Color.parseColor("#389dff")));
      if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline == null)
      {
        this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline = ((Polyline)localObject);
        m();
        this.jdField_e_of_type_AndroidWidgetTextView.setText(zcg.a(paramInt));
      }
    }
    for (;;)
    {
      z();
      localObject = new ArrayList();
      ((ArrayList)localObject).add(new LatLng(this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6() / 1000000.0D, this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6() / 1000000.0D));
      if ((paramList != null) && (paramList.size() > 0)) {
        ((ArrayList)localObject).addAll(paramList);
      }
      ((ArrayList)localObject).add(new LatLng(this.jdField_a_of_type_Double, this.jdField_b_of_type_Double));
      zcg.a((List)localObject, this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView, bcwh.a(this, 42.0F));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.invalidate();
      return;
      QQToast.a(this, 0, alpo.a(2131708697), 0).b(getResources().getDimensionPixelSize(2131298914));
    }
  }
  
  public void a(mzm parammzm)
  {
    this.jdField_m_of_type_JavaLangString = parammzm.jdField_b_of_type_JavaLangString;
    this.jdField_l_of_type_JavaLangString = parammzm.jdField_a_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = parammzm.jdField_c_of_type_JavaLangString;
    this.jdField_h_of_type_Int = parammzm.jdField_b_of_type_Int;
    this.jdField_i_of_type_Int = parammzm.jdField_c_of_type_Int;
    this.jdField_j_of_type_Int = this.jdField_h_of_type_Int;
    this.jdField_k_of_type_Int = this.jdField_i_of_type_Int;
    this.jdField_n_of_type_JavaLangString = parammzm.jdField_f_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = parammzm.jdField_c_of_type_JavaLangString;
    this.jdField_c_of_type_Boolean = true;
    int i2 = this.jdField_a_of_type_ArrayOfMzq.length;
    int i1 = 0;
    if (i1 < i2)
    {
      if (i1 == 0)
      {
        this.jdField_a_of_type_ArrayOfMzq[0].jdField_a_of_type_Mzn.a(false);
        this.jdField_a_of_type_ArrayOfMzq[0].a(0, false);
      }
      for (;;)
      {
        i1 += 1;
        break;
        this.jdField_a_of_type_ArrayOfMzq[i1].a(-1, false);
      }
    }
    a(0);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(parammzm.jdField_b_of_type_Int / 1000000.0D, parammzm.jdField_c_of_type_Int / 1000000.0D)));
  }
  
  public boolean a()
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
    localDialog.setContentView(2131562573);
    Object localObject2 = localDialog.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject2).x = 0;
    ((WindowManager.LayoutParams)localObject2).y = 0;
    ((WindowManager.LayoutParams)localObject2).width = -1;
    ((WindowManager.LayoutParams)localObject2).windowAnimations = 16973824;
    ((WindowManager.LayoutParams)localObject2).gravity = 51;
    localDialog.getWindow().setBackgroundDrawable(new ColorDrawable());
    localObject2 = new TranslateAnimation(0.0F, 0.0F, -i1, 0.0F);
    ((TranslateAnimation)localObject2).setDuration(300L);
    mze localmze = new mze(this, (TranslateAnimation)localObject1, localDialog, i1, (TranslateAnimation)localObject2);
    ((TranslateAnimation)localObject1).setAnimationListener(localmze);
    ((TranslateAnimation)localObject2).setAnimationListener(localmze);
    localDialog.setOnDismissListener(new mzf(this, (TranslateAnimation)localObject2, localInputMethodManager));
    this.jdField_d_of_type_AndroidViewView = localDialog.findViewById(2131375981);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localDialog.findViewById(2131365849));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new mzu(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localDialog.findViewById(2131367807));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new mzg(this));
    localObject1 = (Button)localDialog.findViewById(2131363520);
    ((Button)localObject1).setVisibility(0);
    ((Button)localObject1).setOnClickListener(new mzh(this, localDialog));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localDialog.findViewById(2131371186));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localDialog.findViewById(2131375671));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new mzi(this, localDialog));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localDialog.findViewById(2131376166));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(super.getResources().getDrawable(2130838591));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Mzt = new mzt(this, this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Mzt);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_Bhpo);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new mzj(this, localInputMethodManager));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new mzk(this, localDialog));
    if (1 == ndd.a()) {}
    for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = false)
    {
      this.jdField_b_of_type_Boolean = true;
      zcg.a("search", a());
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null;
  }
  
  public void c()
  {
    if (this.jdField_k_of_type_Boolean)
    {
      a("rec_locate", "click_rec_return", "", "", "", "");
      return;
    }
    a("share_locate", "click_rec_return", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, "", "");
  }
  
  public void d()
  {
    Object localObject1;
    double d1;
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap() != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().getCameraPosition() != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().getCameraPosition().target != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getMap().getCameraPosition().target;
      d1 = ((LatLng)localObject1).getLatitude();
      localObject1 = String.valueOf(((LatLng)localObject1).getLongitude());
    }
    for (String str1 = String.valueOf(d1);; str1 = "")
    {
      String str2 = str1 + "," + (String)localObject1 + "," + this.jdField_f_of_type_JavaLangString + "," + this.jdField_e_of_type_JavaLangString;
      Object localObject2;
      Object localObject3;
      label194:
      int i1;
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
      {
        localObject2 = "0";
        String str3 = this.jdField_l_of_type_Int + 1 + "";
        if (!this.jdField_a_of_type_ArrayOfMzq[this.jdField_l_of_type_Int].jdField_a_of_type_Mzn.jdField_a_of_type_Boolean) {
          break label372;
        }
        localObject3 = "2";
        a("share_locate", "click_send", str2, (String)localObject2, str3, (String)localObject3);
        if (this.jdField_i_of_type_Boolean)
        {
          a("rec_locate", "send_googlestation", "", "", "", "");
          a("rec_locate", "send_foursquare", "", "", "", "");
        }
        localObject2 = getIntent();
        if (((Intent)localObject2).getIntExtra("uintype", 0) == 1008)
        {
          localObject3 = new Intent("com.tencent.biz.pubaccount.locationResultAction");
          ((Intent)localObject3).putExtra("latitude", str1);
          ((Intent)localObject3).putExtra("longitude", (String)localObject1);
          ((Intent)localObject3).putExtra("name", this.jdField_m_of_type_JavaLangString);
          sendBroadcast((Intent)localObject3, "com.tencent.msg.permission.pushnotify");
        }
        i1 = ((Intent)localObject2).getIntExtra("sessionType", 1);
        if (i1 != 1) {
          break label380;
        }
        localObject1 = "group";
      }
      for (;;)
      {
        zcg.a("send_location", a(), (String)localObject1);
        return;
        localObject2 = this.jdField_b_of_type_JavaLangString;
        break;
        label372:
        localObject3 = "1";
        break label194;
        label380:
        if (i1 == 0) {
          localObject1 = "person";
        } else if (i1 == 3000) {
          localObject1 = "disc_group";
        } else {
          localObject1 = "other";
        }
      }
      localObject1 = "";
    }
  }
  
  public void e()
  {
    a("rec_locate", "click_view", "", "", "", "");
  }
  
  protected void f()
  {
    this.jdField_a_of_type_Myl = myl.a();
    Object localObject2 = this.jdField_a_of_type_Myl.a("poi_category", "");
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
    this.p = super.getResources().getDimensionPixelSize(2131297362);
    this.jdField_q_of_type_Int = super.getResources().getDimensionPixelSize(2131297371);
    this.t = super.getResources().getDimensionPixelSize(2131297365);
    this.u = super.getResources().getDimensionPixelSize(2131297364);
    this.jdField_r_of_type_Int = super.getResources().getDimensionPixelSize(2131297357);
    this.s = super.getResources().getDimensionPixelSize(2131297358);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131372138));
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
    Object localObject = (FrameLayout)super.findViewById(2131372130);
    this.jdField_a_of_type_ArrayOfMzq = new mzq[this.jdField_a_of_type_ArrayOfJavaLangString.length];
    LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -1);
    LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams1.weight = 1.0F;
    int i2 = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      mzq localmzq = new mzq(this, this, this.jdField_a_of_type_ArrayOfJavaLangString[i1], i1);
      if (i1 == 0)
      {
        localmzq.a(true);
        localmzq.jdField_a_of_type_Mzn.jdField_a_of_type_Int = 0;
      }
      if (i1 == i2 - 1) {
        localmzq.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView.a();
      }
      this.jdField_a_of_type_ArrayOfMzq[i1] = localmzq;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localmzq.jdField_a_of_type_ComTencentBizPoiMapActivity$TabView, localLayoutParams1);
      ((FrameLayout)localObject).addView(localmzq.jdField_a_of_type_ComTencentWidgetXListView, localLayoutParams2);
      i1 += 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    }
    if (this.jdField_c_of_type_AndroidWidgetImageView != null) {
      this.jdField_c_of_type_AndroidWidgetImageView.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    }
  }
  
  public void h()
  {
    super.h();
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Boolean) {}
    while ((this.p <= 0) || (this.jdField_o_of_type_Int <= 0)) {
      return;
    }
    bdjs localbdjs = new bdjs(Integer.valueOf(this.jdField_o_of_type_Int + this.p), Integer.valueOf(this.jdField_o_of_type_Int), new myz(this));
    localbdjs.setDuration(200L);
    localbdjs.setFillAfter(true);
    localbdjs.setAnimationListener(new mza(this));
    this.jdField_i_of_type_AndroidViewView.startAnimation(localbdjs);
  }
  
  public void j()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((this.p <= 0) || (this.jdField_o_of_type_Int <= 0)) {
      return;
    }
    bdjs localbdjs = new bdjs(Integer.valueOf(this.jdField_o_of_type_Int), Integer.valueOf(this.jdField_o_of_type_Int + this.p), new mzb(this));
    localbdjs.setDuration(200L);
    localbdjs.setFillAfter(true);
    localbdjs.setAnimationListener(new mzc(this));
    this.jdField_i_of_type_AndroidViewView.startAnimation(localbdjs);
  }
  
  public void k()
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
          if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null)
          {
            bool = true;
            QLog.d("Q.qqmap", 2, bool);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline != null)
          {
            this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline.remove();
            this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelPolyline = null;
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
    case 2131372133: 
    case 2131372135: 
      label159:
      do
      {
        return;
        if (this.jdField_k_of_type_Boolean) {
          if (this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint != null)
          {
            z();
            if (this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap != null) {
              this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6() / 1000000.0D, this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6() / 1000000.0D)));
            }
            if (!this.jdField_k_of_type_Boolean) {
              break label159;
            }
            a("rec_locate", "click_locate_rec", "", "", "", "");
          }
        }
        for (;;)
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842024);
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
    if (Build.VERSION.SDK_INT >= 23) {
      if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
        requestPermissions(new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 1);
      }
    }
    for (;;)
    {
      zcg.a("navigation_click");
      zcg.b("click_navig", "0");
      return;
      this.jdField_a_of_type_Zcg.a(this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint, paramView, this.jdField_q_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString);
      continue;
      this.jdField_a_of_type_Zcg.a(this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint, paramView, this.jdField_q_of_type_JavaLangString, this.jdField_l_of_type_JavaLangString);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = ThemeUtil.getCurrentThemeInfo().getString("themeId");
    this.jdField_a_of_type_Int = super.getResources().getColor(2131166975);
    this.jdField_b_of_type_Int = super.getResources().getColor(2131166901);
    this.jdField_d_of_type_Int = 2130849570;
    this.jdField_e_of_type_Int = 2130839213;
    this.jdField_f_of_type_Int = 2130843496;
    if ("1103".equals(paramBundle)) {}
    for (this.jdField_c_of_type_Int = super.getResources().getColor(2131165844);; this.jdField_c_of_type_Int = super.getResources().getColor(2131165843))
    {
      this.jdField_g_of_type_Int = Color.rgb(0, 121, 255);
      this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
      this.jdField_j_of_type_Boolean = getIntent().getBooleanExtra("is_need_destroy_broadcast", true);
      this.jdField_a_of_type_Zcg = new zcg(this);
      this.jdField_a_of_type_Zcg.a(this);
      f();
      a();
      return;
    }
  }
  
  public void onMapScrollEnd(GeoPoint paramGeoPoint)
  {
    super.onMapScrollEnd(paramGeoPoint);
    if (!this.jdField_k_of_type_Boolean) {
      a("share_locate", "drag_location", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, "", "");
    }
  }
  
  public void onMapScrollStart(GeoPoint paramGeoPoint)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity
 * JD-Core Version:    0.7.0.1
 */