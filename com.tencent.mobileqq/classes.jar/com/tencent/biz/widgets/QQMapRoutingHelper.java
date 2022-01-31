package com.tencent.biz.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import pca;

public class QQMapRoutingHelper
  implements ActionSheet.OnButtonClickListener
{
  protected int a;
  protected Context a;
  public Handler a;
  protected QQMapRoutingHelper.RouteListener a;
  protected GeoPoint a;
  protected ActionSheet a;
  protected String a;
  protected HashMap a;
  protected HashSet a;
  protected LinkedHashMap a;
  protected int[] a;
  protected GeoPoint b;
  protected String b;
  
  public QQMapRoutingHelper(Context paramContext)
  {
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[6];
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("com.tencent.map", "腾讯地图");
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("com.google.android.apps.maps", "Google地图");
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("com.autonavi.minimap", "高德地图");
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("com.baidu.BaiduMap", "百度地图");
    this.jdField_a_of_type_JavaUtilHashMap.put("com.tencent.map", Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilHashMap.put("com.google.android.apps.maps", Integer.valueOf(5));
    this.jdField_a_of_type_JavaUtilHashMap.put("com.autonavi.minimap", Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilHashMap.put("com.baidu.BaiduMap", Integer.valueOf(3));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble2 = 3.141592653589793D * paramDouble2 / 180.0D;
    paramDouble4 = 3.141592653589793D * paramDouble4 / 180.0D;
    paramDouble3 = (paramDouble1 - paramDouble3) * 3.141592653589793D / 180.0D;
    paramDouble1 = Math.sin((paramDouble2 - paramDouble4) / 2.0D);
    paramDouble3 = Math.sin(paramDouble3 / 2.0D);
    return 6378137.0D * 2.0D * Math.asin(Math.sqrt(Math.cos(paramDouble2) * Math.cos(paramDouble4) * paramDouble3 * paramDouble3 + paramDouble1 * paramDouble1));
  }
  
  public static String a(double paramDouble)
  {
    if (paramDouble < 1000.0D) {
      return String.format("距离我%.1f米", new Object[] { Double.valueOf(paramDouble) });
    }
    return String.format("距离我%.1f公里", new Object[] { Double.valueOf(paramDouble / 1000.0D) });
  }
  
  protected static List a(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 2)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new LatLng(((Float)paramList.get(0)).floatValue(), ((Float)paramList.get(1)).floatValue()));
    int i = 2;
    while (i < paramList.size())
    {
      float f3 = (float)((LatLng)localArrayList.get(i / 2 - 1)).getLatitude();
      float f4 = Float.valueOf(((Float)paramList.get(i)).floatValue()).floatValue() / 1000000.0F;
      float f1 = (float)((LatLng)localArrayList.get(i / 2 - 1)).getLongitude();
      float f2 = Float.valueOf(((Float)paramList.get(i + 1)).floatValue()).floatValue() / 1000000.0F;
      f3 = (float)(Math.round((f3 + f4) * 1000000.0D) / 1000000.0D);
      f1 = (float)(Math.round((f2 + f1) * 1000000.0D) / 1000000.0D);
      localArrayList.add(new LatLng(f3, f1));
      i += 2;
    }
    paramList = new ArrayList();
    i = 0;
    if (i < localArrayList.size())
    {
      if (paramList.size() >= 1) {
        if (!((LatLng)paramList.get(paramList.size() - 1)).equals(localArrayList.get(i))) {
          paramList.add(localArrayList.get(i));
        }
      }
      for (;;)
      {
        i += 1;
        break;
        paramList.add(localArrayList.get(i));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "parseRoutes: rawPoints=" + localArrayList.size() + ", resultPoints=" + paramList.size());
    }
    return paramList;
  }
  
  public static void a(String paramString)
  {
    a(paramString, "");
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "");
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "rec_locate_android", paramString1, 0, 0, paramString2, paramString3, "", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap.report", 2, "opName=" + paramString1 + ",extra1=" + paramString2 + ",extra2=" + paramString3);
    }
  }
  
  public static void a(List paramList, MapView paramMapView, int paramInt)
  {
    if ((paramList == null) || (paramList.size() < 2)) {
      return;
    }
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localBuilder.include((LatLng)paramList.next());
    }
    paramMapView.getMap().moveCamera(CameraUpdateFactory.newLatLngBounds(localBuilder.build(), paramInt));
  }
  
  public static double[] a(double paramDouble1, double paramDouble2)
  {
    double d = Math.sqrt(paramDouble2 * paramDouble2 + paramDouble1 * paramDouble1) + 2.E-005D * Math.sin(paramDouble1 * 3.141592653589793D);
    paramDouble1 = Math.atan2(paramDouble1, paramDouble2);
    paramDouble2 = Math.cos(3.141592653589793D * paramDouble2) * 3.E-006D + paramDouble1;
    paramDouble1 = Math.cos(paramDouble2) * d + 0.0065D;
    paramDouble2 = Math.sin(paramDouble2) * d + 0.006D;
    System.out.println("bd_lat:" + paramDouble2);
    System.out.println("bd_lon:" + paramDouble1);
    return new double[] { paramDouble2, paramDouble1 };
  }
  
  public static void b(String paramString1, String paramString2)
  {
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", paramString1, 0, 0, paramString2, "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap.report", 2, "opName=" + paramString1 + ",extra1=" + paramString2);
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (this.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      }
      return;
      if (this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper$RouteListener != null) {
        if (!this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper$RouteListener.b())
        {
          a(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint, this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint);
          a("show_route");
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper$RouteListener.l();
          a("hide_route");
          continue;
          b();
          a("didi_click");
          continue;
          c();
          continue;
          f();
          a("baidumap_open");
          b("click_navig", "4");
          continue;
          e();
          a("gaodemap_open");
          b("click_navig", "3");
          continue;
          d();
          a("googlemap_open");
          b("click_navig", "6");
        }
      }
    }
  }
  
  protected void a()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    List localList = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getInstalledPackages(0);
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        String str = ((PackageInfo)localList.get(i)).packageName;
        if (this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(str)) {
          this.jdField_a_of_type_JavaUtilHashSet.add(str);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "checkInstalledMapApp: time=" + (System.currentTimeMillis() - l));
    }
  }
  
  public void a(QQMapRoutingHelper.RouteListener paramRouteListener)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper$RouteListener = paramRouteListener;
  }
  
  public void a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      paramGeoPoint1 = this.jdField_a_of_type_AndroidContentContext.getResources();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, paramGeoPoint1.getString(2131434794), 1).b(paramGeoPoint1.getDimensionPixelSize(2131558448));
      return;
    }
    Bundle localBundle1 = new Bundle();
    Bundle localBundle2 = new Bundle();
    String str;
    if (this.jdField_a_of_type_Int == 1)
    {
      str = "https://apis.map.qq.com/ws/direction/v1/driving/";
      localBundle1.putString("get_mp", "0");
      localBundle1.putString("get_speed", "0");
      localBundle2.putInt("mode", 0);
    }
    for (;;)
    {
      localBundle1.putString("from", paramGeoPoint1.getLatitudeE6() / 1000000.0D + "," + paramGeoPoint1.getLongitudeE6() / 1000000.0D);
      localBundle1.putString("to", paramGeoPoint2.getLatitudeE6() / 1000000.0D + "," + paramGeoPoint2.getLongitudeE6() / 1000000.0D);
      localBundle1.putString("output", "json");
      localBundle1.putString("callback", "cb");
      localBundle1.putString("key", "UZVBZ-TYEKV-N6OPT-UFMDO-VYNG7-3MB7J");
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqmap", 2, "getRoute:" + str);
      }
      paramGeoPoint1 = new HashMap();
      paramGeoPoint1.put("BUNDLE", localBundle1);
      paramGeoPoint1.put("CONTEXT", BaseApplication.getContext());
      new HttpWebCgiAsyncTask(str, "GET", new pca(this), 1000, localBundle2, true).execute(new HashMap[] { paramGeoPoint1 });
      return;
      str = "https://apis.map.qq.com/ws/direction/v1/walking/";
      localBundle2.putInt("routeMode", 1);
    }
  }
  
  public void a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, String paramString1, String paramString2)
  {
    if ((paramGeoPoint1 == null) || (paramGeoPoint2 == null))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 0, "获取当前位置失败", 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      return;
    }
    this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint = paramGeoPoint1;
    this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint = paramGeoPoint2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "自己位置";
    }
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = "目标位置";
    }
    double d = a(paramGeoPoint1.getLongitudeE6() / 1000000.0D, paramGeoPoint1.getLatitudeE6() / 1000000.0D, paramGeoPoint2.getLongitudeE6() / 1000000.0D, paramGeoPoint2.getLatitudeE6() / 1000000.0D);
    if (d > 1000.0D)
    {
      this.jdField_a_of_type_Int = 1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqmap", 2, "showActionSheet: self=" + paramGeoPoint1.toString() + ",to=" + paramGeoPoint2.toString() + ",selfPoi=" + paramString1 + ",toPoi=" + paramString2 + ",distance=" + d);
      }
      a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.a(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.a(this);
      if ((this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper$RouteListener == null) || (this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper$RouteListener.b())) {
        break label454;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c("显示路线");
      label283:
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c("滴滴打车");
      this.jdField_a_of_type_ArrayOfInt[1] = 1;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c((CharSequence)this.jdField_a_of_type_JavaUtilLinkedHashMap.get("com.tencent.map"));
      this.jdField_a_of_type_ArrayOfInt[2] = 2;
      paramGeoPoint1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      int i = 3;
      label349:
      if (!paramGeoPoint1.hasNext()) {
        break label467;
      }
      paramString1 = (Map.Entry)paramGeoPoint1.next();
      paramGeoPoint2 = (String)paramString1.getKey();
      paramString1 = (String)paramString1.getValue();
      if ((paramGeoPoint2.equals("com.tencent.map")) || (!this.jdField_a_of_type_JavaUtilHashSet.contains(paramGeoPoint2))) {
        break label485;
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(paramString1);
      this.jdField_a_of_type_ArrayOfInt[i] = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramGeoPoint2)).intValue();
      i += 1;
    }
    label454:
    label467:
    label485:
    for (;;)
    {
      break label349;
      this.jdField_a_of_type_Int = 0;
      break;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c("隐藏路线");
      break label283;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.c(2131432998);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
  }
  
  public void a(JSONObject paramJSONObject, int paramInt)
  {
    int k = 0;
    int j = 0;
    StringBuilder localStringBuilder;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("parseRoutes: mode=").append(paramInt).append(", ");
      if (paramJSONObject != null)
      {
        localObject = paramJSONObject.toString();
        QLog.d("Q.qqmap", 2, (String)localObject);
      }
    }
    else
    {
      localStringBuilder = null;
      if (paramJSONObject == null) {
        break label334;
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          if (paramJSONObject.getInt("status") != 0) {
            continue;
          }
          paramJSONObject = paramJSONObject.getJSONObject("result").getJSONArray("routes");
          if (paramJSONObject.length() <= 0) {
            continue;
          }
          paramJSONObject = paramJSONObject.getJSONObject(0);
          i = paramJSONObject.getInt("distance");
        }
        catch (Exception localException1)
        {
          int i = 0;
          paramInt = i;
          paramJSONObject = localStringBuilder;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.w("Q.qqmap", 2, "parseRoutes:", localException1);
          paramInt = i;
          paramJSONObject = localStringBuilder;
          continue;
          paramInt = 0;
          paramJSONObject = null;
          continue;
        }
        try
        {
          paramJSONObject.getInt("duration");
          if (paramInt != 0) {
            continue;
          }
          paramJSONObject = paramJSONObject.getJSONArray("polyline");
          localObject = new ArrayList();
          paramInt = j;
          if (paramInt < paramJSONObject.length())
          {
            ((List)localObject).add(Float.valueOf((float)paramJSONObject.getDouble(paramInt)));
            paramInt += 1;
            continue;
            localObject = "";
            break;
          }
          paramJSONObject = a((List)localObject);
          paramInt = i;
        }
        catch (Exception localException2)
        {
          continue;
          paramJSONObject = null;
          paramInt = i;
        }
      }
      if (this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper$RouteListener != null) {
        this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper$RouteListener.a(paramJSONObject, paramInt);
      }
      return;
      if (paramInt == 1)
      {
        paramJSONObject = paramJSONObject.getJSONArray("polyline");
        localObject = new ArrayList();
        paramInt = k;
        if (paramInt < paramJSONObject.length())
        {
          ((List)localObject).add(Float.valueOf((float)paramJSONObject.getDouble(paramInt)));
          paramInt += 1;
        }
        else
        {
          paramJSONObject = a((List)localObject);
          paramInt = i;
        }
      }
      else
      {
        label334:
        paramInt = 0;
        paramJSONObject = localStringBuilder;
      }
    }
  }
  
  protected void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    String str = String.format("https://common.diditaxi.com.cn/general/webEntry?channel=72778&source=mqq&tolat=%f&tolng=%f&fromlat=%f&fromlng=%f&maptype=soso&_wv=1039", new Object[] { Double.valueOf(this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6() / 1000000.0D), Double.valueOf(this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6() / 1000000.0D), Double.valueOf(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6() / 1000000.0D), Double.valueOf(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6() / 1000000.0D) });
    localIntent.putExtra("url", str);
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "openDiDi:" + str);
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.contains("com.tencent.map"))
    {
      localObject = "drive";
      if (this.jdField_a_of_type_Int == 0) {
        localObject = "walk";
      }
      localObject = String.format("qqmap://map/routeplan?type=%s&from=%s&fromcoord=%f,%f&to=%s&tocoord=%f,%f&policy=1&referer=qq", new Object[] { localObject, this.jdField_a_of_type_JavaLangString, Double.valueOf(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6() / 1000000.0D), Double.valueOf(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6() / 1000000.0D), this.jdField_b_of_type_JavaLangString, Double.valueOf(this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6() / 1000000.0D), Double.valueOf(this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6() / 1000000.0D) });
      try
      {
        Intent localIntent = Intent.parseUri((String)localObject, 0);
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqmap", 2, "openQQMapForRoute:" + (String)localObject);
        }
        a("tencentmap_click", "open");
        b("click_navig", "1");
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqmap", 2, "openQQMapForRoute:" + (String)localObject, localException);
        }
      }
    }
    Object localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", "https://3gimg.qq.com/map_site_cms/download/index.html?appid=mobilemap&logid=map_app&ch=appdownload");
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "openQQMapForRoute, download=https://3gimg.qq.com/map_site_cms/download/index.html?appid=mobilemap&logid=map_app&ch=appdownload");
    }
    a("tencentmap_click", "dl");
    b("click_navig", "2");
  }
  
  protected void d()
  {
    String str = "http://maps.google.com/maps?f=d&source=s_d&saddr=%f,%f&daddr=%f,%f&hl=zh";
    if (this.jdField_a_of_type_Int == 0) {
      str = "http://maps.google.com/maps?f=d&source=s_d&saddr=%f,%f&daddr=%f,%f&hl=zh" + "&dirflg=w";
    }
    str = String.format(str, new Object[] { Double.valueOf(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6() / 1000000.0D), Double.valueOf(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6() / 1000000.0D), Double.valueOf(this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6() / 1000000.0D), Double.valueOf(this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6() / 1000000.0D) });
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(str));
      localIntent.addFlags(0);
      localIntent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqmap", 2, "openGoogleMapForRoute:" + str);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqmap", 2, "openGoogleMapForRoute:" + str, localException);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_Int == 0) {}
    for (int i = 4;; i = 2)
    {
      String str = String.format("androidamap://route?sourceApplication=qq&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&m=0&t=%d", new Object[] { Double.valueOf(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6() / 1000000.0D), Double.valueOf(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6() / 1000000.0D), this.jdField_a_of_type_JavaLangString, Double.valueOf(this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6() / 1000000.0D), Double.valueOf(this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6() / 1000000.0D), this.jdField_b_of_type_JavaLangString, Integer.valueOf(i) });
      try
      {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(str));
        localIntent.setPackage("com.autonavi.minimap");
        this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqmap", 2, "openGaodeMapForRoute:" + str);
        }
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w("Q.qqmap", 2, "openGaodeMapForRoute:" + str, localException);
        return;
      }
    }
  }
  
  protected void f()
  {
    String str = "driving";
    if (this.jdField_a_of_type_Int == 0) {
      str = "walking";
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    try
    {
      double[] arrayOfDouble1 = a(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6() / 1000000.0D, this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6() / 1000000.0D);
      localObject1 = localObject2;
      double[] arrayOfDouble2 = a(this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint.getLatitudeE6() / 1000000.0D, this.jdField_b_of_type_ComTencentMapsdkRasterModelGeoPoint.getLongitudeE6() / 1000000.0D);
      localObject1 = localObject2;
      str = String.format("intent://map/direction?origin=latlng:%f,%f|name:%s&destination=latlng:%f,%f|name:%s&mode=%s&src=src=thirdapp.navi.yourCompanyName.yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end", new Object[] { Double.valueOf(arrayOfDouble1[0]), Double.valueOf(arrayOfDouble1[1]), this.jdField_a_of_type_JavaLangString, Double.valueOf(arrayOfDouble2[0]), Double.valueOf(arrayOfDouble2[1]), this.jdField_b_of_type_JavaLangString, str });
      localObject1 = str;
      localObject2 = Intent.getIntent(str);
      localObject1 = str;
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      localObject1 = str;
      if (QLog.isColorLevel())
      {
        localObject1 = str;
        QLog.d("Q.qqmap", 2, "openBaiduMapForRoute:" + str);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqmap", 2, "openBaiduMapForRoute:" + (String)localObject1, localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.widgets.QQMapRoutingHelper
 * JD-Core Version:    0.7.0.1
 */