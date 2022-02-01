package com.tencent.biz.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.Builder;
import com.tencent.util.pm.PackageUtil;
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

public class QQMapRoutingHelper
  implements ActionSheet.OnButtonClickListener
{
  protected int a;
  protected Context a;
  protected Handler a;
  protected QQMapRoutingHelper.RouteListener a;
  protected GeoPoint a;
  protected ActionSheet a;
  protected String a;
  protected HashMap<String, Integer> a;
  protected HashSet<String> a;
  protected LinkedHashMap<String, String> a;
  protected int[] a;
  protected GeoPoint b;
  protected String b;
  
  public QQMapRoutingHelper(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ArrayOfInt = new int[6];
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("com.tencent.map", HardCodeUtil.a(2131710400));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("com.google.android.apps.maps", "Google地图");
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("com.autonavi.minimap", HardCodeUtil.a(2131710398));
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put("com.baidu.BaiduMap", HardCodeUtil.a(2131710399));
    this.jdField_a_of_type_JavaUtilHashMap.put("com.tencent.map", Integer.valueOf(2));
    this.jdField_a_of_type_JavaUtilHashMap.put("com.google.android.apps.maps", Integer.valueOf(5));
    this.jdField_a_of_type_JavaUtilHashMap.put("com.autonavi.minimap", Integer.valueOf(4));
    this.jdField_a_of_type_JavaUtilHashMap.put("com.baidu.BaiduMap", Integer.valueOf(3));
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble2 = paramDouble2 * 3.141592653589793D / 180.0D;
    paramDouble4 = paramDouble4 * 3.141592653589793D / 180.0D;
    paramDouble3 = (paramDouble1 - paramDouble3) * 3.141592653589793D / 180.0D;
    paramDouble1 = Math.sin((paramDouble2 - paramDouble4) / 2.0D);
    paramDouble3 = Math.sin(paramDouble3 / 2.0D);
    return 12756274.0D * Math.asin(Math.sqrt(paramDouble1 * paramDouble1 + Math.cos(paramDouble2) * Math.cos(paramDouble4) * paramDouble3 * paramDouble3));
  }
  
  public static String a(double paramDouble)
  {
    if (paramDouble < 1000.0D) {
      return String.format(HardCodeUtil.a(2131710406), new Object[] { Double.valueOf(paramDouble) });
    }
    return String.format(HardCodeUtil.a(2131710405), new Object[] { Double.valueOf(paramDouble / 1000.0D) });
  }
  
  protected static List<LatLng> a(List<Float> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 2))
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      localArrayList.add(new LatLng(((Float)paramList.get(0)).floatValue(), ((Float)paramList.get(1)).floatValue()));
      int i = 2;
      while (i < paramList.size())
      {
        int k = i / 2 - 1;
        float f3 = (float)((LatLng)localArrayList.get(k)).getLatitude();
        float f4 = Float.valueOf(((Float)paramList.get(i)).floatValue()).floatValue() / 1000000.0F;
        float f1 = (float)((LatLng)localArrayList.get(k)).getLongitude();
        float f2 = Float.valueOf(((Float)paramList.get(i + 1)).floatValue()).floatValue() / 1000000.0F;
        double d = f3 + f4;
        Double.isNaN(d);
        d = Math.round(d * 1000000.0D);
        Double.isNaN(d);
        f3 = (float)(d / 1000000.0D);
        d = f1 + f2;
        Double.isNaN(d);
        d = Math.round(d * 1000000.0D);
        Double.isNaN(d);
        f1 = (float)(d / 1000000.0D);
        localArrayList.add(new LatLng(f3, f1));
        i += 2;
      }
      paramList = new ArrayList();
      i = j;
      while (i < localArrayList.size())
      {
        if (paramList.size() >= 1)
        {
          if (!((LatLng)paramList.get(paramList.size() - 1)).equals(localArrayList.get(i))) {
            paramList.add(localArrayList.get(i));
          }
        }
        else {
          paramList.add(localArrayList.get(i));
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseRoutes: rawPoints=");
        localStringBuilder.append(localArrayList.size());
        localStringBuilder.append(", resultPoints=");
        localStringBuilder.append(paramList.size());
        QLog.d("Q.qqmap", 2, localStringBuilder.toString());
      }
      return paramList;
    }
    return null;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("opName=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",extra1=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",extra2=");
      localStringBuilder.append(paramString3);
      QLog.d("Q.qqmap.report", 2, localStringBuilder.toString());
    }
  }
  
  public static void a(List<LatLng> paramList, MapView paramMapView, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() < 2) {
        return;
      }
      LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localBuilder.include((LatLng)paramList.next());
      }
      paramMapView.getMap().moveCamera(CameraUpdateFactory.newLatLngBounds(localBuilder.build(), paramInt));
    }
  }
  
  public static double[] a(double paramDouble1, double paramDouble2)
  {
    double d = Math.sqrt(paramDouble2 * paramDouble2 + paramDouble1 * paramDouble1) + Math.sin(paramDouble1 * 3.141592653589793D) * 2.E-005D;
    paramDouble2 = Math.atan2(paramDouble1, paramDouble2) + Math.cos(paramDouble2 * 3.141592653589793D) * 3.E-006D;
    paramDouble1 = Math.cos(paramDouble2) * d + 0.0065D;
    paramDouble2 = d * Math.sin(paramDouble2) + 0.006D;
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("bd_lat:");
    localStringBuilder.append(paramDouble2);
    localPrintStream.println(localStringBuilder.toString());
    localPrintStream = System.out;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("bd_lon:");
    localStringBuilder.append(paramDouble1);
    localPrintStream.println(localStringBuilder.toString());
    return new double[] { paramDouble2, paramDouble1 };
  }
  
  public static void b(String paramString1, String paramString2)
  {
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "rec_locate", paramString1, 0, 0, paramString2, "", "", "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("opName=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",extra1=");
      localStringBuilder.append(paramString2);
      QLog.d("Q.qqmap.report", 2, localStringBuilder.toString());
    }
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    paramInt = this.jdField_a_of_type_ArrayOfInt[paramInt];
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt == 5)
              {
                d();
                a("googlemap_open");
                b("click_navig", "6");
              }
            }
            else
            {
              e();
              a("gaodemap_open");
              b("click_navig", "3");
            }
          }
          else
          {
            f();
            a("baidumap_open");
            b("click_navig", "4");
          }
        }
        else {
          c();
        }
      }
      else
      {
        b();
        a("didi_click");
      }
    }
    else
    {
      paramView = this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper$RouteListener;
      if (paramView != null) {
        if (!paramView.a())
        {
          a(this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint, this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint);
          a("show_route");
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper$RouteListener.g();
          a("hide_route");
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
  
  protected void a()
  {
    long l = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    Object localObject = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (PackageUtil.a(this.jdField_a_of_type_AndroidContentContext, str)) {
        this.jdField_a_of_type_JavaUtilHashSet.add(str);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkInstalledMapApp: time=");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.d("Q.qqmap", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(QQMapRoutingHelper.RouteListener paramRouteListener)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper$RouteListener = paramRouteListener;
  }
  
  public void a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      paramGeoPoint1 = this.jdField_a_of_type_AndroidContentContext.getResources();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, paramGeoPoint1.getString(2131694424), 1).b(paramGeoPoint1.getDimensionPixelSize(2131299168));
      return;
    }
    Bundle localBundle1 = new Bundle();
    Bundle localBundle2 = new Bundle();
    String str;
    if (this.jdField_a_of_type_Int == 1)
    {
      localBundle1.putString("get_mp", "0");
      localBundle1.putString("get_speed", "0");
      localBundle2.putInt("mode", 0);
      str = "https://apis.map.qq.com/ws/direction/v1/driving/";
    }
    else
    {
      localBundle2.putInt("routeMode", 1);
      str = "https://apis.map.qq.com/ws/direction/v1/walking/";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    double d = paramGeoPoint1.getLatitudeE6();
    Double.isNaN(d);
    localStringBuilder.append(d / 1000000.0D);
    localStringBuilder.append(",");
    d = paramGeoPoint1.getLongitudeE6();
    Double.isNaN(d);
    localStringBuilder.append(d / 1000000.0D);
    localBundle1.putString("from", localStringBuilder.toString());
    paramGeoPoint1 = new StringBuilder();
    d = paramGeoPoint2.getLatitudeE6();
    Double.isNaN(d);
    paramGeoPoint1.append(d / 1000000.0D);
    paramGeoPoint1.append(",");
    d = paramGeoPoint2.getLongitudeE6();
    Double.isNaN(d);
    paramGeoPoint1.append(d / 1000000.0D);
    localBundle1.putString("to", paramGeoPoint1.toString());
    localBundle1.putString("output", "json");
    localBundle1.putString("callback", "cb");
    localBundle1.putString("key", "UZVBZ-TYEKV-N6OPT-UFMDO-VYNG7-3MB7J");
    if (QLog.isColorLevel())
    {
      paramGeoPoint1 = new StringBuilder();
      paramGeoPoint1.append("getRoute:");
      paramGeoPoint1.append(str);
      QLog.d("Q.qqmap", 2, paramGeoPoint1.toString());
    }
    paramGeoPoint1 = new HashMap();
    paramGeoPoint1.put("BUNDLE", localBundle1);
    paramGeoPoint1.put("CONTEXT", BaseApplication.getContext());
    new HttpWebCgiAsyncTask(str, "GET", new QQMapRoutingHelper.1(this), 1000, localBundle2, true).execute(new HashMap[] { paramGeoPoint1 });
  }
  
  public void a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2, String paramString1, String paramString2)
  {
    if ((paramGeoPoint1 != null) && (paramGeoPoint2 != null))
    {
      this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint = paramGeoPoint1;
      this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint = paramGeoPoint2;
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_b_of_type_JavaLangString = paramString2;
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131710401);
      }
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131710397);
      }
      double d1 = paramGeoPoint1.getLongitudeE6();
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      double d2 = paramGeoPoint1.getLatitudeE6();
      Double.isNaN(d2);
      d2 /= 1000000.0D;
      double d3 = paramGeoPoint2.getLongitudeE6();
      Double.isNaN(d3);
      d3 /= 1000000.0D;
      double d4 = paramGeoPoint2.getLatitudeE6();
      Double.isNaN(d4);
      d1 = a(d1, d2, d3, d4 / 1000000.0D);
      if (d1 > 1000.0D) {
        this.jdField_a_of_type_Int = 1;
      } else {
        this.jdField_a_of_type_Int = 0;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showActionSheet: self=");
        localStringBuilder.append(paramGeoPoint1.toString());
        localStringBuilder.append(",to=");
        localStringBuilder.append(paramGeoPoint2.toString());
        localStringBuilder.append(",selfPoi=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(",toPoi=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(",distance=");
        localStringBuilder.append(d1);
        QLog.d("Q.qqmap", 2, localStringBuilder.toString());
      }
      a();
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.create(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(this);
      paramGeoPoint1 = this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper$RouteListener;
      if ((paramGeoPoint1 != null) && (!paramGeoPoint1.a())) {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131710404));
      } else {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131710396));
      }
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(HardCodeUtil.a(2131710402));
      this.jdField_a_of_type_ArrayOfInt[1] = 1;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton((CharSequence)this.jdField_a_of_type_JavaUtilLinkedHashMap.get("com.tencent.map"));
      paramGeoPoint1 = this.jdField_a_of_type_ArrayOfInt;
      int i = 3;
      paramGeoPoint1[2] = 2;
      paramGeoPoint1 = this.jdField_a_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      while (paramGeoPoint1.hasNext())
      {
        paramString1 = (Map.Entry)paramGeoPoint1.next();
        paramGeoPoint2 = (String)paramString1.getKey();
        paramString1 = (String)paramString1.getValue();
        if ((!paramGeoPoint2.equals("com.tencent.map")) && (this.jdField_a_of_type_JavaUtilHashSet.contains(paramGeoPoint2)))
        {
          this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(paramString1);
          this.jdField_a_of_type_ArrayOfInt[i] = ((Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramGeoPoint2)).intValue();
          i += 1;
        }
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 0, HardCodeUtil.a(2131710403), 1).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
  }
  
  protected void a(JSONObject paramJSONObject, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseRoutes: mode=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      if (paramJSONObject != null) {
        localObject1 = paramJSONObject.toString();
      } else {
        localObject1 = "";
      }
      localStringBuilder.append((String)localObject1);
      QLog.d("Q.qqmap", 2, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = null;
    Object localObject2 = null;
    int k = 0;
    int m = 0;
    int n = 0;
    int j = 0;
    Object localObject1 = localStringBuilder;
    int i = n;
    if (paramJSONObject != null)
    {
      localObject1 = localStringBuilder;
      i = n;
      try
      {
        if (paramJSONObject.getInt("status") != 0) {
          break label352;
        }
        paramJSONObject = paramJSONObject.getJSONObject("result").getJSONArray("routes");
        localObject1 = localStringBuilder;
        i = n;
        if (paramJSONObject.length() <= 0) {
          break label352;
        }
        localObject1 = paramJSONObject.getJSONObject(0);
        i = ((JSONObject)localObject1).getInt("distance");
        try
        {
          ((JSONObject)localObject1).getInt("duration");
          if (paramInt == 0)
          {
            paramJSONObject = ((JSONObject)localObject1).getJSONArray("polyline");
            localObject1 = new ArrayList();
            paramInt = j;
            while (paramInt < paramJSONObject.length())
            {
              ((List)localObject1).add(Float.valueOf((float)paramJSONObject.getDouble(paramInt)));
              paramInt += 1;
            }
            paramJSONObject = a((List)localObject1);
          }
          else
          {
            paramJSONObject = localObject2;
            if (paramInt == 1)
            {
              paramJSONObject = ((JSONObject)localObject1).getJSONArray("polyline");
              localObject1 = new ArrayList();
              paramInt = k;
              while (paramInt < paramJSONObject.length())
              {
                ((List)localObject1).add(Float.valueOf((float)paramJSONObject.getDouble(paramInt)));
                paramInt += 1;
              }
              paramJSONObject = a((List)localObject1);
            }
          }
          localObject1 = paramJSONObject;
        }
        catch (Exception paramJSONObject)
        {
          paramInt = i;
        }
        localObject1 = localStringBuilder;
      }
      catch (Exception paramJSONObject)
      {
        paramInt = m;
      }
      i = paramInt;
      if (QLog.isColorLevel())
      {
        QLog.w("Q.qqmap", 2, "parseRoutes:", paramJSONObject);
        i = paramInt;
        localObject1 = localStringBuilder;
      }
    }
    label352:
    paramJSONObject = this.jdField_a_of_type_ComTencentBizWidgetsQQMapRoutingHelper$RouteListener;
    if (paramJSONObject != null) {
      paramJSONObject.a((List)localObject1, i);
    }
  }
  
  protected void b()
  {
    Object localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    double d1 = this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6();
    Double.isNaN(d1);
    d1 /= 1000000.0D;
    double d2 = this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6();
    Double.isNaN(d2);
    d2 /= 1000000.0D;
    double d3 = this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6();
    Double.isNaN(d3);
    d3 /= 1000000.0D;
    double d4 = this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6();
    Double.isNaN(d4);
    String str = String.format("https://common.diditaxi.com.cn/general/webEntry?channel=72778&source=mqq&tolat=%f&tolng=%f&fromlat=%f&fromlng=%f&maptype=soso&_wv=1039", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4 / 1000000.0D) });
    ((Intent)localObject).putExtra("url", str);
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openDiDi:");
      ((StringBuilder)localObject).append(str);
      QLog.d("Q.qqmap", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_JavaUtilHashSet.contains("com.tencent.map"))
    {
      if (this.jdField_a_of_type_Int == 0) {
        localObject1 = "walk";
      } else {
        localObject1 = "drive";
      }
      Object localObject2 = this.jdField_a_of_type_JavaLangString;
      double d1 = this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6();
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      double d2 = this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6();
      Double.isNaN(d2);
      d2 /= 1000000.0D;
      Object localObject3 = this.jdField_b_of_type_JavaLangString;
      double d3 = this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6();
      Double.isNaN(d3);
      d3 /= 1000000.0D;
      double d4 = this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6();
      Double.isNaN(d4);
      localObject1 = String.format("qqmap://map/routeplan?type=%s&from=%s&fromcoord=%f,%f&to=%s&tocoord=%f,%f&policy=1&referer=qq", new Object[] { localObject1, localObject2, Double.valueOf(d1), Double.valueOf(d2), localObject3, Double.valueOf(d3), Double.valueOf(d4 / 1000000.0D) });
      try
      {
        localObject2 = Intent.parseUri((String)localObject1, 0);
        ((Intent)localObject2).addCategory("android.intent.category.BROWSABLE");
        ((Intent)localObject2).setComponent(null);
        if (Build.VERSION.SDK_INT >= 15) {
          ((Intent)localObject2).setSelector(null);
        }
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("openQQMapForRoute:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("Q.qqmap", 2, ((StringBuilder)localObject2).toString());
        }
        a("tencentmap_click", "open");
        b("click_navig", "1");
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("openQQMapForRoute:");
          ((StringBuilder)localObject3).append((String)localObject1);
          QLog.w("Q.qqmap", 2, ((StringBuilder)localObject3).toString(), localException);
        }
      }
    }
    Object localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", "https://3gimg.qq.com/map_site_cms/download/index.html?appid=mobilemap&logid=map_app&ch=appdownload");
    this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "openQQMapForRoute, download=https://3gimg.qq.com/map_site_cms/download/index.html?appid=mobilemap&logid=map_app&ch=appdownload");
    }
    a("tencentmap_click", "dl");
    b("click_navig", "2");
  }
  
  protected void d()
  {
    int i = this.jdField_a_of_type_Int;
    Object localObject1 = "http://maps.google.com/maps?f=d&source=s_d&saddr=%f,%f&daddr=%f,%f&hl=zh";
    if (i == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("http://maps.google.com/maps?f=d&source=s_d&saddr=%f,%f&daddr=%f,%f&hl=zh");
      ((StringBuilder)localObject1).append("&dirflg=w");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    double d1 = this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6();
    Double.isNaN(d1);
    d1 /= 1000000.0D;
    double d2 = this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6();
    Double.isNaN(d2);
    d2 /= 1000000.0D;
    double d3 = this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6();
    Double.isNaN(d3);
    d3 /= 1000000.0D;
    double d4 = this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6();
    Double.isNaN(d4);
    localObject1 = String.format((String)localObject1, new Object[] { Double.valueOf(d1), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4 / 1000000.0D) });
    try
    {
      Object localObject2 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject1));
      ((Intent)localObject2).addFlags(0);
      ((Intent)localObject2).setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("openGoogleMapForRoute:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("Q.qqmap", 2, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("openGoogleMapForRoute:");
        localStringBuilder.append((String)localObject1);
        QLog.w("Q.qqmap", 2, localStringBuilder.toString(), localException);
      }
    }
  }
  
  protected void e()
  {
    int i;
    if (this.jdField_a_of_type_Int == 0) {
      i = 4;
    } else {
      i = 2;
    }
    double d1 = this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6();
    Double.isNaN(d1);
    d1 /= 1000000.0D;
    double d2 = this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6();
    Double.isNaN(d2);
    d2 /= 1000000.0D;
    String str = this.jdField_a_of_type_JavaLangString;
    double d3 = this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6();
    Double.isNaN(d3);
    d3 /= 1000000.0D;
    double d4 = this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6();
    Double.isNaN(d4);
    str = String.format("androidamap://route?sourceApplication=qq&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&m=0&t=%d", new Object[] { Double.valueOf(d1), Double.valueOf(d2), str, Double.valueOf(d3), Double.valueOf(d4 / 1000000.0D), this.jdField_b_of_type_JavaLangString, Integer.valueOf(i) });
    try
    {
      Object localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).setData(Uri.parse(str));
      ((Intent)localObject).setPackage("com.autonavi.minimap");
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("openGaodeMapForRoute:");
        ((StringBuilder)localObject).append(str);
        QLog.d("Q.qqmap", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("openGaodeMapForRoute:");
        localStringBuilder.append(str);
        QLog.w("Q.qqmap", 2, localStringBuilder.toString(), localException);
      }
    }
  }
  
  protected void f()
  {
    String str;
    if (this.jdField_a_of_type_Int == 0) {
      str = "walking";
    } else {
      str = "driving";
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    try
    {
      int i = this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6();
      double d1 = i;
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      localObject1 = localObject2;
      i = this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6();
      double d2 = i;
      Double.isNaN(d2);
      d2 /= 1000000.0D;
      localObject1 = localObject2;
      double[] arrayOfDouble1 = a(d1, d2);
      localObject1 = localObject2;
      i = this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6();
      d1 = i;
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      localObject1 = localObject2;
      i = this.jdField_b_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6();
      d2 = i;
      Double.isNaN(d2);
      d2 /= 1000000.0D;
      localObject1 = localObject2;
      double[] arrayOfDouble2 = a(d1, d2);
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
        localObject2 = new StringBuilder();
        localObject1 = str;
        ((StringBuilder)localObject2).append("openBaiduMapForRoute:");
        localObject1 = str;
        ((StringBuilder)localObject2).append(str);
        localObject1 = str;
        QLog.d("Q.qqmap", 2, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("openBaiduMapForRoute:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.w("Q.qqmap", 2, ((StringBuilder)localObject2).toString(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.QQMapRoutingHelper
 * JD-Core Version:    0.7.0.1
 */