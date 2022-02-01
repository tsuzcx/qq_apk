package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.qq.jce.wup.UniPacket;
import com.tencent.biz.common.util.SubString;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.mini.out.activity.MapActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.util.CustomDialogFactory;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQMapView.QQMapViewObserver;
import com.tencent.proto.lbsshare.LBSShare.GetShopsByIdsResp;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.NearByShopsResp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.ROMUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
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

@RoutePage(desc="QQ地图", path="/base/qqmap")
public class QQMapActivity
  extends MapActivity
  implements QQMapView.QQMapViewObserver, SkinnableActivityProcesser.Callback
{
  protected static final int ACTIVITY_RESULT_SEND_SHARE_STRUCT_MESSAGE = 0;
  private static final int LOCATING_FAILED = 1;
  private static final int LOCATING_POS = 0;
  protected static final String ON_GET_STREET_VIEW_URL = "com.tencent.mobileqq.onGetStreetViewUrl";
  public static final String REQUEST_FROM_TROOP_ACTIVITY = "group_activity";
  public static final String TAG = "QQMapActivity";
  protected static final String TAG_FETCH_ADDRESS = "fetch_address";
  protected static final String TAG_GET_LOCATION = "get_location";
  protected static final int TENCENT_MAP_DOWNLOAD_STATUS_DOWNLOADING = 1;
  protected static final int TENCENT_MAP_DOWNLOAD_STATUS_PAUSE = 2;
  protected static final int TENCENT_MAP_DOWNLOAD_STATUS_STOP = 0;
  Drawable defaultMarker;
  protected boolean fetchDataFailed = false;
  protected View fixedPopView;
  boolean hasLocked = false;
  boolean hasStoped = true;
  protected boolean hideJiejingIcon = false;
  protected boolean isChangeToGoogleMap = false;
  boolean isRefreshPressed;
  boolean isRightBtnShowShare = false;
  protected View jiejingIcon;
  protected double latitude;
  protected String loc;
  protected String location = "";
  protected double longitude;
  public boolean mActNeedImmersive = true;
  protected ActionSheet mActionSheet;
  protected TextView mAddrTxt;
  private BroadcastReceiver mBroadcastReceiver = new QQMapActivity.14(this);
  public String mCurPoiAdr;
  public String mCurPoiName;
  float mDensity;
  protected TextView mDetailAddrTxt;
  protected String mDianpingId;
  protected TextView mDistanceTxt;
  protected String mFrom = null;
  protected boolean mIsGetMyLocation = false;
  GeoPoint mLastPoint;
  protected long mLastUpdateSelfPoiTime = 0L;
  LbsManagerServiceOnLocationChangeListener mLocationListener = new QQMapActivity.9(this, "QQMapActivity", true);
  public boolean mNeedStatusTrans = true;
  protected int mPinViewImageHeight;
  protected Polyline mPolyLine;
  protected View mQQMapLayout;
  protected View mRouteBar;
  protected Button mRouteBtn;
  private BroadcastReceiver mScreenReceiver = new QQMapActivity.13(this);
  protected String mSelfAddress;
  protected GeoPoint mSelfGeoPoint;
  protected Marker mSelfLocationMarker;
  protected String mSelfPoiName;
  String mStreetViewUrl;
  public SystemBarCompact mSystemBarComp;
  protected LinearLayout mTopLineLay;
  protected QQMapView mapView;
  private Marker myLocMarker;
  protected View.OnClickListener onTitleLeftClickLister = new QQMapActivity.4(this);
  protected View.OnClickListener onTitleRightClickShareListener = new QQMapActivity.6(this);
  protected View.OnClickListener onTitleRightHouseClickLister = new QQMapActivity.7(this);
  protected View.OnClickListener onTitleRightSendClickLister = new QQMapActivity.5(this);
  Animation pinAnim;
  Animation pinShadowAnim;
  protected ImageView pinView;
  SkinnableActivityProcesser processer;
  protected View selfFixedPopView;
  protected boolean startWithPos = false;
  protected TencentMap tencentMap;
  protected TextView tvTitleBtnRight;
  String uin;
  protected String url;
  
  private void doStartLocation()
  {
    super.showDialog(0);
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(this.mLocationListener);
    if (QLog.isColorLevel()) {
      QLog.d("get_location", 2, "start get location");
    }
  }
  
  protected static boolean isLegalBroadcast(String paramString, ArrayList<String> paramArrayList)
  {
    if (Foreground.getActivityCount() > 0) {
      return false;
    }
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return false;
      }
      if (!paramString.equals(BaseApplicationImpl.getLocalVerify(paramArrayList, false))) {
        return paramString.equals(BaseApplicationImpl.getLocalVerify(paramArrayList, true));
      }
      return true;
    }
    return false;
  }
  
  public static void showInfoWindow(Marker paramMarker)
  {
    if (paramMarker != null)
    {
      String str1 = paramMarker.getTitle();
      String str2 = paramMarker.getSnippet();
      if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)))
      {
        paramMarker.hideInfoWindow();
        return;
      }
      paramMarker.showInfoWindow();
    }
  }
  
  protected void Forward()
  {
    Object localObject2 = SubString.a(this.mCurPoiName, 45, "UTF-8", "...");
    String str = SubString.a(this.loc, 90, "UTF-8", "...");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(ChatActivityConstants.a);
    ((StringBuilder)localObject1).append("http://maps.google.com/maps?q=");
    ((StringBuilder)localObject1).append(this.latitude);
    ((StringBuilder)localObject1).append(",");
    ((StringBuilder)localObject1).append(this.longitude);
    ((StringBuilder)localObject1).append("&iwloc=A&hl=zh-CN (");
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append(")");
    Object localObject3 = ((StringBuilder)localObject1).toString();
    if (!getResources().getString(2131893857).equals(localObject2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(getResources().getString(2131888235));
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = getResources().getString(2131888235);
    }
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("mqqapi://app/action?pkg=com.tencent.mobileqq&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=");
    ((StringBuilder)localObject4).append(this.latitude);
    ((StringBuilder)localObject4).append("&lon=");
    ((StringBuilder)localObject4).append(this.longitude);
    ((StringBuilder)localObject4).append("&title=");
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append("&loc=");
    ((StringBuilder)localObject4).append(str);
    localObject4 = ((StringBuilder)localObject4).toString();
    localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(32).a((String)localObject1).d((String)localObject3).a("plugin", "", (String)localObject4, (String)localObject4, (String)localObject4).a();
    localObject3 = StructMsgElementFactory.a(2);
    ((AbsStructMsgItem)localObject3).a("https://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", (String)localObject2, str);
    ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject3);
    localObject2 = new Intent();
    ((Intent)localObject2).putExtra("forward_type", -3);
    ((Intent)localObject2).putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    ForwardBaseOption.a(this, (Intent)localObject2, 0);
  }
  
  protected void addMyPosition(GeoPoint paramGeoPoint, String paramString)
  {
    try
    {
      paramString = new BitmapFactory.Options();
      paramString.inJustDecodeBounds = true;
      BitmapFactory.decodeResource(getResources(), 2130838935, paramString);
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    paramString = this.tencentMap;
    if ((paramString != null) && (paramString.getProjection() != null))
    {
      double d1 = paramGeoPoint.getLatitudeE6();
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      double d2 = paramGeoPoint.getLongitudeE6();
      Double.isNaN(d2);
      paramGeoPoint = new LatLng(d1, d2 / 1000000.0D);
      if (this.selfFixedPopView == null) {
        try
        {
          this.selfFixedPopView = getLayoutInflater().inflate(2131625252, null);
          paramString = (ImageView)this.selfFixedPopView.findViewById(2131433226);
          paramString.setImageResource(2130838935);
          paramString.setBackgroundDrawable(null);
          this.myLocMarker = this.tencentMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.selfFixedPopView)).position(paramGeoPoint).snippet(""));
          showInfoWindow(this.myLocMarker);
          return;
        }
        catch (Resources.NotFoundException paramGeoPoint)
        {
          paramGeoPoint.printStackTrace();
          return;
        }
      }
      if ((this.myLocMarker != null) && ((paramGeoPoint.getLatitude() != this.myLocMarker.getPosition().getLatitude()) || (paramGeoPoint.getLongitude() != this.myLocMarker.getPosition().getLongitude())))
      {
        this.myLocMarker.setPosition(paramGeoPoint);
        this.myLocMarker.setSnippet("");
        showInfoWindow(this.myLocMarker);
      }
    }
  }
  
  public void addSelfLay()
  {
    if (this.mSelfLocationMarker == null) {
      try
      {
        Object localObject = BitmapFactory.decodeResource(getResources(), 2130843423);
        if ((localObject != null) && (this.mSelfGeoPoint != null))
        {
          TencentMap localTencentMap = this.tencentMap;
          localObject = new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap((Bitmap)localObject));
          int i = this.mSelfGeoPoint.getLatitudeE6();
          double d1 = i;
          Double.isNaN(d1);
          d1 /= 1000000.0D;
          i = this.mSelfGeoPoint.getLongitudeE6();
          double d2 = i;
          Double.isNaN(d2);
          d2 /= 1000000.0D;
          this.mSelfLocationMarker = localTencentMap.addMarker(((MarkerOptions)localObject).position(new LatLng(d1, d2)).title("").snippet(""));
          showInfoWindow(this.mSelfLocationMarker);
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqmap", 2, "addSelfLay:", localOutOfMemoryError);
        }
      }
    }
  }
  
  protected void asyncGetLocationName(GeoPoint paramGeoPoint, TextView paramTextView, boolean paramBoolean)
  {
    this.location = "";
    try
    {
      new QQMapActivity.GetLocNameTask(this, paramGeoPoint, paramTextView).execute(new GeoPoint[] { paramGeoPoint });
      if (paramBoolean) {
        playPinAnimation();
      }
      return;
    }
    catch (RejectedExecutionException paramGeoPoint)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQMapActivity", 2, paramGeoPoint.getMessage());
      }
    }
  }
  
  protected void backCall() {}
  
  protected void changeMap()
  {
    String str = TimeZone.getDefault().getID();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("default timezone:");
      localStringBuilder.append(str);
      QLog.d("QQMapActivity", 2, localStringBuilder.toString());
    }
    if (((!"Asia/Shanghai".equals(str)) && (!"Asia/Hong_Kong".equals(str)) && (!"Asia/Chongqing".equals(str)) && (!"Asia/Beijing".equals(str))) || (!"zh".equals(Locale.getDefault().getLanguage())))
    {
      ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", "call_googlemap", 0, 0, "", "", "", "");
      this.isChangeToGoogleMap = true;
    }
  }
  
  boolean compare2LastPoint(GeoPoint paramGeoPoint)
  {
    if (this.mLastPoint == null)
    {
      this.mLastPoint = paramGeoPoint;
      return false;
    }
    if (paramGeoPoint == null) {
      return false;
    }
    return (Math.abs(paramGeoPoint.getLatitudeE6() - this.mLastPoint.getLatitudeE6()) < 1) && (Math.abs(paramGeoPoint.getLongitudeE6() - this.mLastPoint.getLongitudeE6()) < 1);
  }
  
  public final <T> T decodePacket(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (RuntimeException|Exception paramArrayOfByte) {}
    return null;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected Intent getLocationData()
  {
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    Object localObject = this.mapView;
    if ((localObject != null) && (((QQMapView)localObject).getMap() != null) && (this.mapView.getMap().getCameraPosition() != null) && (this.mapView.getMap().getCameraPosition().target != null))
    {
      localObject = this.mapView.getMap().getCameraPosition().target;
      localBundle.putString("latitude", String.valueOf(((LatLng)localObject).getLatitude()));
      localBundle.putString("longitude", String.valueOf(((LatLng)localObject).getLongitude()));
    }
    localBundle.putString("description", this.location);
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
  
  protected void getMyLocation(boolean paramBoolean)
  {
    this.mIsGetMyLocation = paramBoolean;
    if (!NetworkUtil.isNetSupport(this))
    {
      showInvalidNetworkAlert();
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        requestPermissions(new String[] { "android.permission.ACCESS_FINE_LOCATION" }, 1);
        return;
      }
      doStartLocation();
      return;
    }
    doStartLocation();
  }
  
  protected void initData()
  {
    Bundle localBundle = getIntent().getExtras();
    String str = localBundle.getString("options");
    boolean bool = TextUtils.isEmpty(str);
    Object localObject3 = null;
    Object localObject2 = null;
    if (!bool) {}
    try
    {
      localObject1 = new JSONObject(str);
    }
    catch (JSONException localJSONException)
    {
      Object localObject1;
      label130:
      break label90;
    }
    catch (NullPointerException localNullPointerException)
    {
      label47:
      label90:
      break label47;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parse params failed, options : ");
      ((StringBuilder)localObject1).append(str);
      QLog.d("get_params", 2, ((StringBuilder)localObject1).toString());
      break label130;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parse params failed, options : ");
        ((StringBuilder)localObject1).append(str);
        QLog.d("get_params", 2, ((StringBuilder)localObject1).toString());
      }
    }
    localObject1 = null;
    if (localObject1 != null)
    {
      localObject3 = ((JSONObject)localObject1).optString("lat");
      str = ((JSONObject)localObject1).optString("lng");
      this.mCurPoiName = ((JSONObject)localObject1).optString("title");
      this.loc = ((JSONObject)localObject1).optString("desc");
      if (((JSONObject)localObject1).has("from")) {
        localObject2 = ((JSONObject)localObject1).optString("from");
      }
      this.mFrom = ((String)localObject2);
      this.isRightBtnShowShare = "share".equals(((JSONObject)localObject1).opt("action"));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("http://maps.google.com/maps?q=");
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append(",");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("&iwloc=A&hl=zh-CN (");
      ((StringBuilder)localObject1).append(this.loc);
      ((StringBuilder)localObject1).append(")");
      this.url = ((StringBuilder)localObject1).toString();
      localObject1 = str;
      localObject2 = localObject3;
    }
    else
    {
      localObject2 = null;
      localObject1 = localObject3;
    }
    localObject3 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject3 = localBundle.getString("lat");
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = localBundle.getString("lon");
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      this.startWithPos = true;
      this.latitude = Double.valueOf((String)localObject3).doubleValue();
      this.longitude = Double.valueOf((String)localObject2).doubleValue();
    }
    if (TextUtils.isEmpty(this.mCurPoiName)) {
      this.mCurPoiName = localBundle.getString("title");
    }
    this.mCurPoiAdr = localBundle.getString("summary");
    if (TextUtils.isEmpty(this.url)) {
      this.url = localBundle.getString("url");
    }
    if (TextUtils.isEmpty(this.loc)) {
      this.loc = localBundle.getString("loc");
    }
    localObject1 = this.loc;
    if ((localObject1 != null) && (((String)localObject1).contains("+"))) {
      this.loc = this.loc.replace("+", " ");
    }
    this.mDianpingId = localBundle.getString("dpid");
    this.mDensity = getResources().getDisplayMetrics().density;
    this.pinAnim = AnimationUtils.loadAnimation(this, 2130772166);
    this.pinAnim.setRepeatMode(2);
    this.pinAnim.setRepeatCount(1);
    this.pinShadowAnim = AnimationUtils.loadAnimation(this, 2130772167);
    this.pinShadowAnim.setRepeatMode(2);
    this.pinShadowAnim.setRepeatCount(1);
  }
  
  protected void initMap()
  {
    findViewById(2131445383).setVisibility(8);
    this.mQQMapLayout = findViewById(2131442437);
    this.mapView = ((QQMapView)findViewById(2131437937));
    this.pinView = ((ImageView)findViewById(2131440347));
    this.jiejingIcon = findViewById(2131436670);
    try
    {
      localBitmap = BitmapFactory.decodeResource(getResources(), 2130843426);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Bitmap localBitmap;
      label76:
      break label76;
    }
    localBitmap = null;
    if (localBitmap != null)
    {
      this.pinView.setImageBitmap(localBitmap);
      this.pinView.setPadding(0, 0, 0, localBitmap.getHeight());
    }
    this.mapView.setContentDescription(getString(2131892673));
    this.mapView.getMap().getUiSettings().setLogoPosition(0);
    this.mapView.getMap().getUiSettings().setScaleViewEnabled(false);
    this.mapView.getMap().getUiSettings().setGestureScaleByMapCenter(true);
    if (!this.startWithPos)
    {
      this.pinView.setVisibility(0);
      this.mapView.setObserver(this);
    }
    else
    {
      if (("SMARTISAN".equals(ROMUtil.getRomName())) && (Build.VERSION.SDK_INT >= 11)) {
        this.mapView.setLayerType(1, null);
      }
      this.mapView.setObserver(this);
      this.pinView.setVisibility(4);
    }
    try
    {
      this.fixedPopView = getLayoutInflater().inflate(2131625252, null);
      this.mapView.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromView(this.fixedPopView)).position(new LatLng(this.latitude, this.longitude)));
      refreshStreetViewIcon();
      this.tencentMap = this.mapView.getMap();
      this.tencentMap.moveCamera(CameraUpdateFactory.zoomTo(15.0F));
      this.tencentMap.setOnMarkerClickListener(new QQMapActivity.3(this));
      changeMap();
      setAccSoft();
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQMapActivity", 2, localNotFoundException.getMessage());
      }
      super.finish();
      return;
    }
  }
  
  protected void initTitleBar()
  {
    Object localObject = (TextView)findViewById(2131436180);
    ((TextView)localObject).setContentDescription(HardCodeUtil.a(2131908085));
    ((TextView)localObject).setOnClickListener(this.onTitleLeftClickLister);
    localObject = (TextView)findViewById(2131436227);
    if ("group_activity".equals(this.mFrom)) {
      ((TextView)localObject).setText(2131887794);
    } else if (this.startWithPos) {
      ((TextView)localObject).setText(2131917343);
    } else {
      ((TextView)localObject).setText(2131887793);
    }
    this.tvTitleBtnRight = ((TextView)findViewById(2131436211));
    if (this.startWithPos)
    {
      if (this.isRightBtnShowShare)
      {
        this.tvTitleBtnRight.setVisibility(0);
        this.tvTitleBtnRight.setText(2131892669);
        this.tvTitleBtnRight.setOnClickListener(this.onTitleRightClickShareListener);
      }
      else
      {
        this.tvTitleBtnRight.setVisibility(8);
        localObject = (ImageView)findViewById(2131436194);
        ((ImageView)localObject).setVisibility(0);
        ((ImageView)localObject).setImageResource(2130841087);
        ((ImageView)localObject).setContentDescription(getString(2131891858));
        ((ImageView)localObject).setOnClickListener(this.onTitleRightHouseClickLister);
      }
    }
    else
    {
      if ("group_activity".equals(this.mFrom)) {
        this.tvTitleBtnRight.setText(2131892664);
      } else {
        this.tvTitleBtnRight.setText(2131892669);
      }
      this.tvTitleBtnRight.setOnClickListener(this.onTitleRightSendClickLister);
    }
    localObject = this.tvTitleBtnRight;
    ((TextView)localObject).setTag(((TextView)localObject).getText());
  }
  
  protected boolean isNeedDestroyBoradcast()
  {
    return true;
  }
  
  protected void jumpToStreetViewMap()
  {
    Intent localIntent = new Intent(this, QQBrowserActivity.class);
    localIntent.putExtra("url", this.mStreetViewUrl);
    localIntent.putExtra("reqType", 4);
    super.startActivity(localIntent);
    jumpToStreetViewMapReport();
  }
  
  protected void jumpToStreetViewMapReport() {}
  
  protected void listenDistanceChange()
  {
    this.mTopLineLay.getViewTreeObserver().addOnGlobalLayoutListener(new QQMapActivity.1(this));
  }
  
  protected void move2Location(double paramDouble1, double paramDouble2)
  {
    if (this.tencentMap != null)
    {
      GeoPoint localGeoPoint = new GeoPoint((int)(paramDouble1 * 1000000.0D), (int)(paramDouble2 * 1000000.0D));
      Object localObject = this.tencentMap;
      paramDouble1 = localGeoPoint.getLatitudeE6();
      Double.isNaN(paramDouble1);
      paramDouble1 /= 1000000.0D;
      paramDouble2 = localGeoPoint.getLongitudeE6();
      Double.isNaN(paramDouble2);
      ((TencentMap)localObject).moveCamera(CameraUpdateFactory.newLatLng(new LatLng(paramDouble1, paramDouble2 / 1000000.0D)));
      localObject = this.loc;
      if ((localObject != null) && (((String)localObject).length() > 0))
      {
        this.mDetailAddrTxt.setText(this.loc);
        refreshStreetViewIcon();
        return;
      }
      asyncGetLocationName(localGeoPoint, this.mDetailAddrTxt, false);
    }
  }
  
  public Dialog newCustomDialog(int paramInt1, int paramInt2, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return CustomDialogFactory.a(this, getResources().getString(paramInt1), getResources().getString(paramInt2), paramOnDismissListener);
  }
  
  public Dialog newCustomProgressDialog(String paramString)
  {
    ReportDialog localReportDialog = new ReportDialog(this, 2131953338);
    localReportDialog.setContentView(2131624633);
    TextView localTextView = (TextView)localReportDialog.findViewById(2131431876);
    if (localTextView != null) {
      localTextView.setText(paramString);
    }
    return localReportDialog;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    super.setResult(-1, new Intent());
    try
    {
      backCall();
      super.onBackPressed();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      label21:
      break label21;
    }
    super.finish();
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
    this.processer = new SkinnableActivityProcesser(this, this);
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      getWindow().addFlags(67108864);
      if (this.mActNeedImmersive) {
        try
        {
          int i = getResources().getColor(2131168092);
          if (this.mSystemBarComp == null)
          {
            this.mSystemBarComp = new SystemBarCompact(this, true, i);
            if (ThemeUtil.isDefaultOrDIYTheme(false)) {
              this.mSystemBarComp.setStatusDrawable(getResources().getDrawable(2130847834));
            } else {
              this.mSystemBarComp.setStatusDrawable(null);
            }
          }
        }
        catch (IllegalStateException paramBundle)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" getResources() has IllegalStateException e = ");
            localStringBuilder.append(paramBundle);
            QLog.d("QQMapActivity", 2, localStringBuilder.toString());
          }
        }
      }
    }
    paramBundle = LayoutInflater.from(this).inflate(2131627992, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
      ImmersiveUtils.clearCoverForStatus(getWindow(), true);
    }
    super.setContentView(paramBundle);
    this.uin = super.getIntent().getStringExtra("uin");
    sendBroadcast(new Intent("com.tencent.mobileqq.addLbsObserver"));
    this.mRouteBar = super.findViewById(2131445185);
    this.mRouteBtn = ((Button)super.findViewById(2131445181));
    this.mAddrTxt = ((TextView)super.findViewById(2131427834));
    this.mDetailAddrTxt = ((TextView)super.findViewById(2131431772));
    this.mDistanceTxt = ((TextView)super.findViewById(2131431994));
    this.mTopLineLay = ((LinearLayout)findViewById(2131447734));
    initData();
    initTitleBar();
    initMap();
    if (this.startWithPos)
    {
      move2Location(this.latitude, this.longitude);
      getMyLocation(true);
    }
    else
    {
      getMyLocation(true);
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.onGetStreetViewUrl");
    paramBundle.addAction("com.tencent.mobileqq.onGetLbsShareSearch");
    paramBundle.addAction("com.tencent.mobileqq.onGetLbsShareShop");
    paramBundle.addAction("com.tencent.mobileqq.onGetShareShopDetail");
    registerReceiver(this.mBroadcastReceiver, paramBundle);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.intent.action.SCREEN_OFF");
    registerReceiver(this.mScreenReceiver, paramBundle);
    if (this.startWithPos) {
      sendBroadcast(new Intent("com.tencent.mobileqq.getStreetViewUrl").putExtra("latitude", this.latitude).putExtra("longitude", this.longitude));
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return null;
      }
      Dialog localDialog = newCustomDialog(2131889479, 2131889478, new QQMapActivity.10(this));
      localObject = localDialog.findViewById(2131431864);
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new QQMapActivity.11(this, localDialog));
      }
      View localView = localDialog.findViewById(2131431870);
      localObject = localDialog;
      if (localView != null)
      {
        localView.setOnClickListener(new QQMapActivity.12(this, localDialog));
        return localDialog;
      }
    }
    else
    {
      localObject = newCustomProgressDialog(getString(2131890040));
    }
    return localObject;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.processer;
    if (localObject != null) {
      ((SkinnableActivityProcesser)localObject).destory();
    }
    localObject = this.mapView;
    if (localObject != null) {
      ((QQMapView)localObject).a();
    }
    if (isNeedDestroyBoradcast())
    {
      sendBroadcast(new Intent("com.tencent.mobileqq.removeLbsObserver"));
      sendBroadcast(new Intent("com.tencent.mobileqq.unregisterReceiver"));
    }
    super.unregisterReceiver(this.mScreenReceiver);
    super.unregisterReceiver(this.mBroadcastReceiver);
  }
  
  void onFetchDataFailed()
  {
    this.fetchDataFailed = true;
    if (!isFinishing()) {
      super.showDialog(1);
    }
    if (!this.startWithPos)
    {
      TextView localTextView = (TextView)findViewById(2131436211);
      localTextView.setVisibility(0);
      localTextView.setText(2131887575);
    }
  }
  
  protected void onFetchDataSuceeded()
  {
    this.fetchDataFailed = false;
    if (!this.startWithPos)
    {
      TextView localTextView = (TextView)findViewById(2131436211);
      localTextView.setVisibility(0);
      localTextView.setText(localTextView.getTag().toString());
    }
  }
  
  protected void onGetLbsShareSearch(LBSShare.LocationResp paramLocationResp, Bundle paramBundle) {}
  
  protected void onGetLbsShareShop(LBSShare.NearByShopsResp paramNearByShopsResp, Bundle paramBundle) {}
  
  protected void onGetShareShopDetail(LBSShare.GetShopsByIdsResp paramGetShopsByIdsResp) {}
  
  public void onMapScrollEnd(GeoPoint paramGeoPoint)
  {
    if ((!this.startWithPos) && (!compare2LastPoint(paramGeoPoint)))
    {
      this.mLastPoint = paramGeoPoint;
      updateLocationAddress(paramGeoPoint);
    }
  }
  
  public void onMapScrollStart(GeoPoint paramGeoPoint) {}
  
  protected void onPause()
  {
    super.onPause();
    QQMapView localQQMapView = this.mapView;
    if (localQQMapView != null) {
      localQQMapView.onPause();
    }
  }
  
  public void onPostThemeChanged() {}
  
  public void onPreThemeChanged() {}
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (paramInt == 1)
    {
      if (paramArrayOfInt[0] == 0)
      {
        getMyLocation(this.mIsGetMyLocation);
        return;
      }
      DialogUtil.a(this, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    Object localObject = this.mapView;
    if (localObject != null) {
      ((QQMapView)localObject).onResume();
    }
    localObject = this.mSystemBarComp;
    if (localObject != null) {
      ((SystemBarCompact)localObject).init();
    }
    BaseActivity.mAppForground = GesturePWDUtils.getAppForground(this);
    if ((!BaseActivity.mAppForground) && (GesturePWDUtils.getGesturePWDState(this, this.uin) == 2) && (GesturePWDUtils.getGesturePWDMode(this, this.uin) == 21))
    {
      if (QLog.isColorLevel()) {
        QLog.d("qqbaseactivity", 2, "qqmapactivity.start lock. GesturePWDUnlockActivity");
      }
      super.startActivity(new Intent(this, GesturePWDUnlockActivity.class));
      this.hasLocked = true;
    }
    else
    {
      this.hasLocked = false;
    }
    if (!BaseActivity.mAppForground)
    {
      BaseActivity.mAppForground = true;
      GesturePWDUtils.setAppForground(this, BaseActivity.mAppForground);
    }
    this.hasStoped = false;
    if (!this.mIsGetMyLocation) {
      getMyLocation(false);
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    QQMapView localQQMapView = this.mapView;
    if (localQQMapView != null) {
      localQQMapView.onStart();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    QQMapView localQQMapView = this.mapView;
    if (localQQMapView != null) {
      localQQMapView.onStop();
    }
    this.hasStoped = true;
    BaseActivity.mAppForground = GesturePWDUtils.getAppForground(this);
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).removeListener(this.mLocationListener);
    if (!BaseActivity.mAppForground) {
      GesturePWDUtils.setAppForground(this, BaseActivity.mAppForground);
    }
  }
  
  protected void onTroopActivityCallback() {}
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    sendBroadcast(new Intent("com.tencent.mobileqq.showNotification"));
  }
  
  void playPinAnimation()
  {
    if (this.pinView.getVisibility() == 0) {
      this.pinView.startAnimation(this.pinAnim);
    }
  }
  
  protected void refresh()
  {
    getMyLocation(true);
  }
  
  protected void refreshStreetViewIcon()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("refreshStreetViewIcon: hideStreet=");
      ((StringBuilder)localObject).append(this.hideJiejingIcon);
      ((StringBuilder)localObject).append(", url=");
      ((StringBuilder)localObject).append(this.mStreetViewUrl);
      QLog.d("Q.qqmap", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mStreetViewUrl;
    if ((localObject != null) && (((String)localObject).length() != 0))
    {
      localObject = this.jiejingIcon;
      if ((localObject != null) && (!this.hideJiejingIcon))
      {
        ((View)localObject).setVisibility(0);
        this.jiejingIcon.setOnClickListener(new QQMapActivity.2(this));
      }
    }
    else
    {
      localObject = this.jiejingIcon;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
  }
  
  protected void sendSuccessCall() {}
  
  protected void setAccSoft()
  {
    Object localObject = (ViewGroup)findViewById(2131444897);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = findViewById(2131447463);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
    localObject = (TextView)findViewById(2131436180);
    if (localObject != null) {
      IphoneTitleBarActivity.setLayerType((View)localObject);
    }
  }
  
  protected void showInvalidNetworkAlert()
  {
    DialogUtil.a(this, 230).setTitle(getString(2131892106)).setMessage(2131889169).setPositiveButton(getString(2131887629), new QQMapActivity.8(this)).show();
  }
  
  protected void updateLocationAddress(GeoPoint paramGeoPoint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity
 * JD-Core Version:    0.7.0.1
 */