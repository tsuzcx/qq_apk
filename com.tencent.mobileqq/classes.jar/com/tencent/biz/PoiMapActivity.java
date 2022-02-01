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
  protected float a;
  protected int a;
  public View.OnClickListener a;
  View.OnKeyListener jdField_a_of_type_AndroidViewView$OnKeyListener = new PoiMapActivity.10(this);
  View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = new PoiMapActivity.2(this);
  protected View a;
  public final ViewTreeObserver.OnPreDrawListener a;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  protected ImageButton a;
  protected ImageView a;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected RelativeLayout a;
  protected TextView a;
  protected AuthorizeConfig a;
  protected PoiMapActivity.PoiMapNameTask a;
  PoiMapActivity.SearchResultAdapter jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter;
  protected QQMapRoutingHelper a;
  protected AbsListView.OnScrollListener a;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  public final String a;
  protected List<PoiMapActivity.POI> a;
  protected boolean a;
  protected PoiMapActivity.PoiTab[] a;
  String[] jdField_a_of_type_ArrayOfJavaLangString = { HardCodeUtil.a(2131708311), HardCodeUtil.a(2131708310), HardCodeUtil.a(2131708312), HardCodeUtil.a(2131708308) };
  protected int b;
  protected View b;
  protected ImageView b;
  protected LinearLayout b;
  public String b;
  protected boolean b;
  String[] b;
  protected int c;
  View c;
  protected String c;
  protected boolean c;
  protected int d;
  protected View d;
  protected String d;
  protected boolean d;
  protected int e;
  protected View e;
  protected String e;
  protected boolean e;
  protected int f;
  private View f;
  protected String f;
  protected boolean f;
  protected int g;
  protected boolean g;
  public int h;
  protected boolean h;
  public int i;
  protected boolean i;
  public int j;
  protected boolean j;
  public int k;
  protected int l;
  protected final int m = 20;
  protected int n = 0;
  protected int o;
  protected int p;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  protected int u;
  protected int v;
  
  public PoiMapActivity()
  {
    this.jdField_a_of_type_JavaLangString = "PoiMapActivity";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new PoiMapActivity.11(this);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new PoiMapActivity.13(this);
    this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener = new PoiMapActivity.14(this);
    this.jdField_b_of_type_ArrayOfJavaLangString = new String[] { "", "281100|281200", "281000|281010|281011|281012|281013|281099", "100000|130000" };
  }
  
  protected String a()
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
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131374275));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131377019);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131372904);
    this.jdField_f_of_type_AndroidViewView = super.findViewById(2131370663);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131372909));
    this.jdField_b_of_type_AndroidWidgetImageView.setContentDescription(getString(2131694945));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (this.startWithPos)
    {
      a("rec_locate", "pageview_all", "", "", "", "");
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
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
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.mRouteBar.setVisibility(8);
      d();
      if (!"group_activity".equals(this.mFrom))
      {
        this.mapView.getMap().setOnMapClickListener(new PoiMapActivity.1(this));
        this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131372911);
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
      }
    }
    Object localObject = (FrameLayout.LayoutParams)this.jdField_f_of_type_AndroidViewView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin = (this.p + this.q);
    this.jdField_f_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131378784);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131367210));
    super.findViewById(2131363868).setVisibility(8);
    localObject = (EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366333);
    ((EditText)localObject).setFocusable(false);
    ((EditText)localObject).setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
  }
  
  public void a(int paramInt)
  {
    PoiMapActivity.PoiTab[] arrayOfPoiTab = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab;
    if (arrayOfPoiTab != null)
    {
      if (paramInt >= arrayOfPoiTab.length) {
        return;
      }
      this.l = paramInt;
      int i2 = arrayOfPoiTab.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (i1 == paramInt)
        {
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(true);
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].b(true);
        }
        else
        {
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(false);
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
    this.mCurPoiAdr = paramPOI.jdField_b_of_type_JavaLangString;
    this.mCurPoiName = paramPOI.jdField_a_of_type_JavaLangString;
    this.jdField_d_of_type_JavaLangString = paramPOI.jdField_c_of_type_JavaLangString;
    this.jdField_h_of_type_Int = paramPOI.jdField_b_of_type_Int;
    this.jdField_i_of_type_Int = paramPOI.jdField_c_of_type_Int;
    this.jdField_j_of_type_Int = this.jdField_h_of_type_Int;
    this.k = this.jdField_i_of_type_Int;
    this.mDianpingId = paramPOI.jdField_f_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramPOI.jdField_c_of_type_JavaLangString;
    this.jdField_c_of_type_Boolean = true;
    int i2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (i1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(false);
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, false);
      }
      else
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(-1, false);
      }
      i1 += 1;
    }
    a(0);
    TencentMap localTencentMap = this.tencentMap;
    double d1 = paramPOI.jdField_b_of_type_Int;
    Double.isNaN(d1);
    d1 /= 1000000.0D;
    double d2 = paramPOI.jdField_c_of_type_Int;
    Double.isNaN(d2);
    localTencentMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(d1, d2 / 1000000.0D)));
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131694938));
    this.jdField_c_of_type_JavaLangString = paramString;
    this.n = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    a(this.jdField_h_of_type_Int, this.jdField_i_of_type_Int, paramString, "", 0, 20);
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter.notifyDataSetChanged();
  }
  
  protected void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", paramString1, paramString2, 0, 0, paramString3, paramString4, paramString5, paramString6);
  }
  
  protected void a(String paramString, List<PoiMapActivity.POI> paramList, boolean paramBoolean)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    else
    {
      if (this.n == 0) {
        localList.clear();
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
        if (this.startWithPos) {
          a("share_locate", "click_sch", paramString, "0", "", "");
        } else {
          a("share_locate", "click_sch", paramString, "0", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
        }
      }
      else if (this.startWithPos)
      {
        a("share_locate", "click_sch", paramString, "1", "", "");
      }
      else
      {
        a("share_locate", "click_sch", paramString, "1", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString);
      }
    }
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_f_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131718604));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter.notifyDataSetChanged();
  }
  
  public void a(ArrayList<PoiMapActivity.POI> paramArrayList, int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    if ((this.jdField_h_of_type_Int != paramInt1) && (this.jdField_i_of_type_Int != paramInt2)) {
      return;
    }
    paramInt2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (this.jdField_b_of_type_ArrayOfJavaLangString[paramInt1].equals(paramString))
      {
        paramString = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[paramInt1];
        boolean bool;
        if (paramInt3 != 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramString.a(paramArrayList, bool, paramInt4, paramBoolean);
        if ((paramInt1 != 0) || (!this.jdField_g_of_type_Boolean)) {
          break;
        }
        if ((paramArrayList != null) && (paramArrayList.size() > 1))
        {
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, true);
          if (this.startWithPos) {
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
  
  public void a(List<LatLng> paramList, int paramInt)
  {
    if (paramList != null)
    {
      g();
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
      QQToast.a(this, 0, HardCodeUtil.a(2131708309), 0).b(getResources().getDimensionPixelSize(2131299168));
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
  
  public boolean a()
  {
    return this.mPolyLine != null;
  }
  
  void b()
  {
    this.jdField_h_of_type_Boolean = false;
    ReportDialog localReportDialog = new ReportDialog(this);
    localReportDialog.setCanceledOnTouchOutside(true);
    InputMethodManager localInputMethodManager = (InputMethodManager)super.getSystemService("input_method");
    int i1 = this.jdField_c_of_type_AndroidViewView.getHeight();
    float f1 = -i1;
    Object localObject1 = new TranslateAnimation(0.0F, 0.0F, 0.0F, f1);
    ((TranslateAnimation)localObject1).setDuration(300L);
    ((TranslateAnimation)localObject1).setFillAfter(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
    localReportDialog.requestWindowFeature(1);
    localReportDialog.getWindow().setSoftInputMode(36);
    localReportDialog.setContentView(2131562779);
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
    this.jdField_d_of_type_AndroidViewView = localReportDialog.findViewById(2131376809);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)localReportDialog.findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new PoiMapActivity.SearchTextWatcher(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(0);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(this.jdField_a_of_type_AndroidViewView$OnKeyListener);
    this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)localReportDialog.findViewById(2131368340));
    this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new PoiMapActivity.5(this));
    localObject1 = (Button)localReportDialog.findViewById(2131363868);
    ((Button)localObject1).setVisibility(0);
    ((Button)localObject1).setOnClickListener(new PoiMapActivity.6(this, localReportDialog));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localReportDialog.findViewById(2131371921));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localReportDialog.findViewById(2131376483));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new PoiMapActivity.7(this, localReportDialog));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localReportDialog.findViewById(2131377016));
    this.jdField_a_of_type_ComTencentWidgetXListView.setBackgroundDrawable(super.getResources().getDrawable(2130838739));
    this.jdField_a_of_type_ComTencentWidgetXListView.setDividerHeight(0);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter = new PoiMapActivity.SearchResultAdapter(this, this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentBizPoiMapActivity$SearchResultAdapter);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnTouchListener(new PoiMapActivity.8(this, localInputMethodManager));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new PoiMapActivity.9(this, localReportDialog));
    if (1 == HttpUtil.getNetWorkType()) {
      this.jdField_e_of_type_Boolean = true;
    } else {
      this.jdField_e_of_type_Boolean = false;
    }
    this.jdField_b_of_type_Boolean = true;
    QQMapRoutingHelper.a("search", a());
  }
  
  protected void backCall()
  {
    if (this.startWithPos)
    {
      a("rec_locate", "click_rec_return", "", "", "", "");
      return;
    }
    a("share_locate", "click_rec_return", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, "", "");
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
    Object localObject2 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a("poi_category", "");
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
          this.jdField_a_of_type_ArrayOfJavaLangString = arrayOfString1;
          this.jdField_b_of_type_ArrayOfJavaLangString = arrayOfString2;
        }
      }
    }
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mTabName:");
      localStringBuilder.append(this.jdField_a_of_type_ArrayOfJavaLangString.toString());
      QLog.i("PoiMapActivity", 4, localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    this.p = super.getResources().getDimensionPixelSize(2131297567);
    this.q = super.getResources().getDimensionPixelSize(2131297576);
    this.t = super.getResources().getDimensionPixelSize(2131297570);
    this.u = super.getResources().getDimensionPixelSize(2131297569);
    this.r = super.getResources().getDimensionPixelSize(2131297562);
    this.s = super.getResources().getDimensionPixelSize(2131297563);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)super.findViewById(2131372913));
    this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundResource(this.jdField_d_of_type_Int);
    if (this.isChangeToGoogleMap)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      localObject = (LinearLayout.LayoutParams)this.mQQMapLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      this.mQQMapLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = (FrameLayout)super.findViewById(2131372906);
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
    if (this.mapView != null) {
      this.mapView.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
    }
    if (this.pinView != null) {
      this.pinView.getViewTreeObserver().addOnPreDrawListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnPreDrawListener);
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
  
  protected void e()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i1 = this.p;
    if (i1 > 0)
    {
      int i2 = this.o;
      if (i2 <= 0) {
        return;
      }
      ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(i2 + i1), Integer.valueOf(this.o), new PoiMapActivity.15(this));
      localValueAnimation.setDuration(200L);
      localValueAnimation.setFillAfter(true);
      localValueAnimation.setAnimationListener(new PoiMapActivity.16(this));
      this.mQQMapLayout.startAnimation(localValueAnimation);
    }
  }
  
  protected void f()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.p > 0)
    {
      int i1 = this.o;
      if (i1 <= 0) {
        return;
      }
      ValueAnimation localValueAnimation = new ValueAnimation(Integer.valueOf(i1), Integer.valueOf(this.o + this.p), new PoiMapActivity.17(this));
      localValueAnimation.setDuration(200L);
      localValueAnimation.setFillAfter(true);
      localValueAnimation.setAnimationListener(new PoiMapActivity.18(this));
      this.mQQMapLayout.startAnimation(localValueAnimation);
    }
  }
  
  public void g()
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
    localBundle.putString("poiId", this.jdField_b_of_type_JavaLangString);
    localBundle.putBoolean("isForien", this.jdField_i_of_type_Boolean);
    localBundle.putInt("isArk", this.v);
    localBundle.putString("description", this.location);
    localBundle.putString("latSpan", String.valueOf(this.jdField_h_of_type_Int));
    localBundle.putString("lngSpan", String.valueOf(this.jdField_i_of_type_Int));
    if ((TextUtils.isEmpty(this.mCurPoiName)) || (this.mCurPoiName.equals(getString(2131694941)))) {
      this.mCurPoiName = getString(2131693824);
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
  
  protected boolean isNeedDestroyBoradcast()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  protected void jumpToStreetViewMapReport()
  {
    a("rec_locate", "click_view", "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject;
    if (i1 != 2131372909)
    {
      if (i1 != 2131372911)
      {
        if (i1 == 2131376848)
        {
          localObject = new GeoPoint((int)(this.latitude * 1000000.0D), (int)(this.longitude * 1000000.0D));
          if (Build.VERSION.SDK_INT >= 23)
          {
            if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
              requestPermissions(new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 1);
            } else {
              this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper.a(this.mSelfGeoPoint, (GeoPoint)localObject, this.mSelfPoiName, this.mCurPoiName);
            }
          }
          else {
            this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper.a(this.mSelfGeoPoint, (GeoPoint)localObject, this.mSelfPoiName, this.mCurPoiName);
          }
          QQMapRoutingHelper.a("navigation_click");
          QQMapRoutingHelper.b("click_navig", "0");
        }
      }
      else if (!this.jdField_a_of_type_Boolean) {
        e();
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
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842474);
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
    this.jdField_a_of_type_Int = super.getResources().getColor(2131167138);
    this.jdField_b_of_type_Int = super.getResources().getColor(2131167056);
    this.jdField_d_of_type_Int = 2130850578;
    this.jdField_e_of_type_Int = 2130839390;
    this.jdField_f_of_type_Int = 2130844065;
    if ("1103".equals(paramBundle)) {
      this.jdField_c_of_type_Int = super.getResources().getColor(2131165933);
    } else {
      this.jdField_c_of_type_Int = super.getResources().getColor(2131165932);
    }
    this.jdField_g_of_type_Int = Color.rgb(0, 121, 255);
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    this.jdField_j_of_type_Boolean = getIntent().getBooleanExtra("is_need_destroy_broadcast", true);
    this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper = new QQMapRoutingHelper(this);
    this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper.a(this);
    c();
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
    this.jdField_i_of_type_Boolean = bool;
    this.v = paramLocationResp.is_ark.get();
    String str1 = paramBundle.getString("keyword");
    int i4 = paramBundle.getInt("latitude");
    int i5 = paramBundle.getInt("longitude");
    int i6 = paramBundle.getInt("page");
    String str2 = paramBundle.getString("category");
    this.jdField_e_of_type_JavaLangString = paramBundle.getString("imei");
    this.jdField_f_of_type_JavaLangString = paramLocationResp.search_id.get();
    if (i1 != 0)
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("onGetLbsShareSearch error:");
        paramBundle.append(i1);
        QLog.i("PoiMapActivity", 2, paramBundle.toString());
      }
      QQToast.a(this, super.getString(2131693575), 0).a();
    }
    if (i1 == 0)
    {
      ArrayList localArrayList = new ArrayList();
      bool = this.jdField_i_of_type_Boolean;
      Object localObject1 = "";
      Object localObject2;
      if (bool)
      {
        paramBundle = new GeoPoint(i4, i5);
        localObject2 = this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask;
        if (localObject2 == null)
        {
          try
          {
            this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask = new PoiMapActivity.PoiMapNameTask(this);
            this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.a(paramBundle);
            this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.execute(new Void[0]);
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
          if (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.getStatus() != AsyncTask.Status.FINISHED)
          {
            if (!this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.isCancelled()) {
              this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.cancel(true);
            }
          }
          else {
            try
            {
              localObject2 = new PoiMapActivity.PoiMapNameTask(this);
              ((PoiMapActivity.PoiMapNameTask)localObject2).a(paramBundle);
              this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask = ((PoiMapActivity.PoiMapNameTask)localObject2);
              this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiMapNameTask.execute(new Void[0]);
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
        paramBundle.jdField_a_of_type_JavaLangString = super.getResources().getString(2131694941);
        paramBundle.jdField_b_of_type_JavaLangString = "";
        this.mCurPoiAdr = paramBundle.jdField_b_of_type_JavaLangString;
        paramBundle.jdField_b_of_type_Int = i4;
        paramBundle.jdField_c_of_type_Int = i5;
        paramBundle.jdField_d_of_type_JavaLangString = "";
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
          paramBundle = super.getResources().getString(2131694941);
        }
        ((PoiMapActivity.POI)localObject3).jdField_a_of_type_JavaLangString = paramBundle;
        if (((LBSShare.POI)localObject2).shop_url.has()) {
          paramBundle = ((LBSShare.POI)localObject2).shop_url.get();
        } else {
          paramBundle = "";
        }
        ((PoiMapActivity.POI)localObject3).jdField_d_of_type_JavaLangString = paramBundle;
        if (((LBSShare.POI)localObject2).addr.has()) {
          paramBundle = ((LBSShare.POI)localObject2).addr.get();
        } else {
          paramBundle = "";
        }
        ((PoiMapActivity.POI)localObject3).jdField_b_of_type_JavaLangString = paramBundle;
        if (((LBSShare.POI)localObject2).lat.has()) {
          i1 = ((LBSShare.POI)localObject2).lat.get();
        } else {
          i1 = 0;
        }
        ((PoiMapActivity.POI)localObject3).jdField_b_of_type_Int = i1;
        if (((LBSShare.POI)localObject2).lng.has()) {
          i1 = ((LBSShare.POI)localObject2).lng.get();
        } else {
          i1 = 0;
        }
        ((PoiMapActivity.POI)localObject3).jdField_c_of_type_Int = i1;
        if ((this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(this.mCurPoiName)))
        {
          ((PoiMapActivity.POI)localObject3).jdField_a_of_type_JavaLangString = this.mCurPoiName;
          ((PoiMapActivity.POI)localObject3).jdField_d_of_type_JavaLangString = "";
          ((PoiMapActivity.POI)localObject3).jdField_b_of_type_JavaLangString = this.mCurPoiAdr;
          ((PoiMapActivity.POI)localObject3).jdField_b_of_type_Int = this.jdField_h_of_type_Int;
          ((PoiMapActivity.POI)localObject3).jdField_c_of_type_Int = this.jdField_i_of_type_Int;
        }
        else
        {
          ((PoiMapActivity.POI)localObject3).jdField_a_of_type_JavaLangString = super.getResources().getString(2131694941);
          this.mCurPoiAdr = ((PoiMapActivity.POI)localObject3).jdField_b_of_type_JavaLangString;
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
          ((PoiMapActivity.POI)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
          if (((LBSShare.POI)localObject4).addr.has()) {
            localObject1 = ((LBSShare.POI)localObject4).addr.get();
          } else {
            localObject1 = paramBundle;
          }
          ((PoiMapActivity.POI)localObject2).jdField_b_of_type_JavaLangString = ((String)localObject1);
          if (((LBSShare.POI)localObject4).lat.has()) {
            i2 = ((LBSShare.POI)localObject4).lat.get();
          } else {
            i2 = 0;
          }
          ((PoiMapActivity.POI)localObject2).jdField_b_of_type_Int = i2;
          if (((LBSShare.POI)localObject4).lng.has()) {
            i2 = ((LBSShare.POI)localObject4).lng.get();
          } else {
            i2 = 0;
          }
          ((PoiMapActivity.POI)localObject2).jdField_c_of_type_Int = i2;
          if (((LBSShare.POI)localObject4).id.has()) {
            localObject1 = ((LBSShare.POI)localObject4).id.get();
          } else {
            localObject1 = paramBundle;
          }
          ((PoiMapActivity.POI)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
          if ("group_activity".equals(this.mFrom))
          {
            ((PoiMapActivity.POI)localObject2).jdField_d_of_type_JavaLangString = paramBundle;
            ((PoiMapActivity.POI)localObject2).jdField_e_of_type_JavaLangString = paramBundle;
            ((PoiMapActivity.POI)localObject2).jdField_a_of_type_Int = 0;
            ((PoiMapActivity.POI)localObject2).g = paramBundle;
            ((PoiMapActivity.POI)localObject2).h = paramBundle;
            ((PoiMapActivity.POI)localObject2).i = paramBundle;
            ((PoiMapActivity.POI)localObject2).jdField_f_of_type_JavaLangString = paramBundle;
          }
          else
          {
            if (((LBSShare.POI)localObject4).shop_url.has()) {
              localObject1 = ((LBSShare.POI)localObject4).shop_url.get();
            } else {
              localObject1 = paramBundle;
            }
            ((PoiMapActivity.POI)localObject2).jdField_d_of_type_JavaLangString = ((String)localObject1);
            if (((LBSShare.POI)localObject4).shop_url_quan.has()) {
              localObject1 = ((LBSShare.POI)localObject4).shop_url_quan.get();
            } else {
              localObject1 = paramBundle;
            }
            ((PoiMapActivity.POI)localObject2).jdField_e_of_type_JavaLangString = ((String)localObject1);
            if (((LBSShare.POI)localObject4).shop_count.has()) {
              i2 = ((LBSShare.POI)localObject4).shop_count.get();
            } else {
              i2 = 0;
            }
            ((PoiMapActivity.POI)localObject2).jdField_a_of_type_Int = i2;
            if (((LBSShare.POI)localObject4).shangquan_url.has()) {
              localObject1 = ((LBSShare.POI)localObject4).shangquan_url.get();
            } else {
              localObject1 = paramBundle;
            }
            ((PoiMapActivity.POI)localObject2).g = ((String)localObject1);
            if (((LBSShare.POI)localObject4).shangquan_wording.has()) {
              localObject1 = ((LBSShare.POI)localObject4).shangquan_wording.get();
            } else {
              localObject1 = paramBundle;
            }
            ((PoiMapActivity.POI)localObject2).h = ((String)localObject1);
            if (((LBSShare.POI)localObject4).POI_preview_url.has()) {
              localObject1 = ((LBSShare.POI)localObject4).POI_preview_url.get();
            } else {
              localObject1 = paramBundle;
            }
            ((PoiMapActivity.POI)localObject2).i = ((String)localObject1);
            if (((LBSShare.POI)localObject4).dpid.has()) {
              localObject1 = ((LBSShare.POI)localObject4).dpid.get();
            } else {
              localObject1 = paramBundle;
            }
            ((PoiMapActivity.POI)localObject2).jdField_f_of_type_JavaLangString = ((String)localObject1);
          }
          if (!TextUtils.isEmpty(((PoiMapActivity.POI)localObject2).jdField_d_of_type_JavaLangString)) {
            a("share_locate", "view_share_tuan", "", "", "", "");
          }
          if ((TextUtils.isEmpty(((PoiMapActivity.POI)localObject2).jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(((PoiMapActivity.POI)localObject2).jdField_e_of_type_JavaLangString))) {
            a("share_locate", "view_quan", "", "", "", "");
          }
          if ((this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_d_of_type_JavaLangString.equals(((PoiMapActivity.POI)localObject2).jdField_c_of_type_JavaLangString)))
          {
            if (!localArrayList.isEmpty())
            {
              localObject1 = localArrayList;
              localObject4 = (PoiMapActivity.POI)((ArrayList)localObject1).get(0);
              if ((this.mCurPoiName.equals(((PoiMapActivity.POI)localObject4).jdField_a_of_type_JavaLangString)) && (this.mCurPoiAdr.equals(((PoiMapActivity.POI)localObject4).jdField_b_of_type_JavaLangString))) {
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
          localGeneralShops.jdField_a_of_type_Int = 1;
          boolean bool = localShop.id.has();
          paramBundle = "";
          if (bool) {
            paramNearByShopsResp = localShop.id.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.h = paramNearByShopsResp;
          if (localShop.name.has()) {
            paramNearByShopsResp = localShop.name.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.jdField_e_of_type_JavaLangString = paramNearByShopsResp;
          if (localShop.logo.has()) {
            paramNearByShopsResp = localShop.logo.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.jdField_f_of_type_JavaLangString = paramNearByShopsResp;
          if (localShop.url.has()) {
            paramNearByShopsResp = localShop.url.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.g = paramNearByShopsResp;
          if (localShop.detail.has()) {
            paramNearByShopsResp = localShop.detail.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.jdField_a_of_type_JavaLangString = paramNearByShopsResp;
          if (localShop.discount.has()) {
            paramNearByShopsResp = localShop.discount.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.jdField_b_of_type_JavaLangString = paramNearByShopsResp;
          if (localShop.price.has()) {
            paramNearByShopsResp = localShop.price.get();
          } else {
            paramNearByShopsResp = "";
          }
          localGeneralShops.jdField_c_of_type_JavaLangString = paramNearByShopsResp;
          paramNearByShopsResp = paramBundle;
          if (localShop.soldnum.has()) {
            paramNearByShopsResp = localShop.soldnum.get();
          }
          localGeneralShops.jdField_d_of_type_JavaLangString = paramNearByShopsResp;
          if (localShop.has_tuan.has()) {
            i1 = localShop.has_tuan.get();
          } else {
            i1 = 0;
          }
          localGeneralShops.jdField_b_of_type_Int = i1;
          if (localShop.has_quan.has()) {
            i1 = localShop.has_quan.get();
          } else {
            i1 = 0;
          }
          localGeneralShops.jdField_c_of_type_Int = i1;
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
          localSingleShops.jdField_a_of_type_Int = 1;
          boolean bool = localDPBiz.id.has();
          String str = "";
          if (bool) {
            paramGetShopsByIdsResp = localDPBiz.id.get();
          } else {
            paramGetShopsByIdsResp = "";
          }
          localSingleShops.h = paramGetShopsByIdsResp;
          if (localDPBiz.name.has()) {
            paramGetShopsByIdsResp = localDPBiz.name.get();
          } else {
            paramGetShopsByIdsResp = "";
          }
          localSingleShops.jdField_e_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (localDPBiz.logo.has()) {
            paramGetShopsByIdsResp = localDPBiz.logo.get();
          } else {
            paramGetShopsByIdsResp = "";
          }
          localSingleShops.jdField_f_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (localDPBiz.url.has()) {
            paramGetShopsByIdsResp = localDPBiz.url.get();
          } else {
            paramGetShopsByIdsResp = "";
          }
          localSingleShops.g = paramGetShopsByIdsResp;
          if (localDPBiz.avg_price.has()) {
            paramGetShopsByIdsResp = localDPBiz.avg_price.get();
          } else {
            paramGetShopsByIdsResp = "";
          }
          localSingleShops.jdField_b_of_type_JavaLangString = paramGetShopsByIdsResp;
          if (localDPBiz.biz_zone.has()) {
            paramGetShopsByIdsResp = localDPBiz.biz_zone.get();
          } else {
            paramGetShopsByIdsResp = "";
          }
          localSingleShops.jdField_c_of_type_JavaLangString = paramGetShopsByIdsResp;
          paramGetShopsByIdsResp = str;
          if (localDPBiz.category.has()) {
            paramGetShopsByIdsResp = localDPBiz.category.get();
          }
          localSingleShops.jdField_a_of_type_JavaLangString = paramGetShopsByIdsResp;
          bool = localDPBiz.has_quan.has();
          int i2 = 0;
          if (bool) {
            i1 = localDPBiz.has_quan.get();
          } else {
            i1 = 0;
          }
          localSingleShops.jdField_c_of_type_Int = i1;
          if (localDPBiz.has_tuan.has()) {
            i1 = localDPBiz.has_tuan.get();
          } else {
            i1 = 0;
          }
          localSingleShops.jdField_b_of_type_Int = i1;
          i1 = i2;
          if (localDPBiz.rate.has()) {
            i1 = localDPBiz.rate.get();
          }
          localSingleShops.jdField_d_of_type_Int = i1;
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
      a("share_locate", "drag_location", this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, "", "");
    }
  }
  
  public void onMapScrollStart(GeoPoint paramGeoPoint)
  {
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842472);
  }
  
  protected void onTroopActivityCallback()
  {
    super.onTroopActivityCallback();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("{");
    ((StringBuilder)localObject).append("\"id\":\"");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject).append("\",");
    ((StringBuilder)localObject).append("\"title\":\"");
    ((StringBuilder)localObject).append(this.mCurPoiName);
    ((StringBuilder)localObject).append("\",");
    ((StringBuilder)localObject).append("\"address\":\"");
    ((StringBuilder)localObject).append(this.mCurPoiAdr);
    ((StringBuilder)localObject).append("\",");
    ((StringBuilder)localObject).append("\"location\":{");
    ((StringBuilder)localObject).append("\"lat\":\"");
    double d1 = this.jdField_j_of_type_Int * 1.0F;
    Double.isNaN(d1);
    ((StringBuilder)localObject).append(d1 / 1000000.0D);
    ((StringBuilder)localObject).append("\",");
    ((StringBuilder)localObject).append("\"lon\":\"");
    d1 = this.k * 1.0F;
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
    ((StringBuilder)localObject3).append(this.jdField_f_of_type_JavaLangString);
    ((StringBuilder)localObject3).append(",");
    ((StringBuilder)localObject3).append(this.jdField_e_of_type_JavaLangString);
    String str1 = ((StringBuilder)localObject3).toString();
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localObject3 = "0";
    } else {
      localObject3 = this.jdField_b_of_type_JavaLangString;
    }
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(this.l + 1);
    ((StringBuilder)localObject4).append("");
    String str2 = ((StringBuilder)localObject4).toString();
    if (this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[this.l].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.jdField_a_of_type_Boolean) {
      localObject4 = "2";
    } else {
      localObject4 = "1";
    }
    a("share_locate", "click_send", str1, (String)localObject3, str2, (String)localObject4);
    if (this.jdField_i_of_type_Boolean)
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
    QQMapRoutingHelper.a("send_location", a(), (String)localObject1);
  }
  
  protected void updateLocationAddress(GeoPoint paramGeoPoint)
  {
    int i1 = paramGeoPoint.getLatitudeE6();
    int i2 = paramGeoPoint.getLongitudeE6();
    if ((this.jdField_h_of_type_Int == i1) && (this.jdField_i_of_type_Int == i2)) {
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
    this.jdField_h_of_type_Int = i1;
    this.jdField_i_of_type_Int = i2;
    this.jdField_j_of_type_Int = this.jdField_h_of_type_Int;
    this.k = this.jdField_i_of_type_Int;
    this.jdField_c_of_type_Boolean = false;
    i2 = this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab.length;
    i1 = 0;
    while (i1 < i2)
    {
      if (i1 == 0)
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.a(false);
        if (this.jdField_g_of_type_Boolean) {
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(-1, false);
        } else {
          this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[0].a(0, false);
        }
      }
      else
      {
        this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[i1].a(-1, true);
      }
      i1 += 1;
    }
    this.jdField_a_of_type_ArrayOfComTencentBizPoiMapActivity$PoiTab[this.l].b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity
 * JD-Core Version:    0.7.0.1
 */