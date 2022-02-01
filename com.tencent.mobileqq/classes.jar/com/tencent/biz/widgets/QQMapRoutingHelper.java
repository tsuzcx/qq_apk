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
  protected ActionSheet a = null;
  protected HashSet<String> b = new HashSet();
  protected LinkedHashMap<String, String> c = new LinkedHashMap();
  protected HashMap<String, Integer> d = new HashMap();
  protected int[] e = new int[6];
  protected String f;
  protected String g;
  protected GeoPoint h;
  protected GeoPoint i;
  protected Context j;
  protected Handler k;
  protected int l = 0;
  protected QQMapRoutingHelper.RouteListener m;
  
  public QQMapRoutingHelper(Context paramContext)
  {
    this.j = paramContext;
    this.c.put("com.tencent.map", HardCodeUtil.a(2131908091));
    this.c.put("com.google.android.apps.maps", "Google地图");
    this.c.put("com.autonavi.minimap", HardCodeUtil.a(2131908089));
    this.c.put("com.baidu.BaiduMap", HardCodeUtil.a(2131908090));
    this.d.put("com.tencent.map", Integer.valueOf(2));
    this.d.put("com.google.android.apps.maps", Integer.valueOf(5));
    this.d.put("com.autonavi.minimap", Integer.valueOf(4));
    this.d.put("com.baidu.BaiduMap", Integer.valueOf(3));
    this.k = new Handler(Looper.getMainLooper());
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
      return String.format(HardCodeUtil.a(2131908097), new Object[] { Double.valueOf(paramDouble) });
    }
    return String.format(HardCodeUtil.a(2131908096), new Object[] { Double.valueOf(paramDouble / 1000.0D) });
  }
  
  protected static List<LatLng> a(List<Float> paramList)
  {
    if ((paramList != null) && (paramList.size() >= 2))
    {
      ArrayList localArrayList = new ArrayList();
      int i1 = 0;
      localArrayList.add(new LatLng(((Float)paramList.get(0)).floatValue(), ((Float)paramList.get(1)).floatValue()));
      int n = 2;
      while (n < paramList.size())
      {
        int i2 = n / 2 - 1;
        float f3 = (float)((LatLng)localArrayList.get(i2)).getLatitude();
        float f4 = Float.valueOf(((Float)paramList.get(n)).floatValue()).floatValue() / 1000000.0F;
        float f1 = (float)((LatLng)localArrayList.get(i2)).getLongitude();
        float f2 = Float.valueOf(((Float)paramList.get(n + 1)).floatValue()).floatValue() / 1000000.0F;
        double d1 = f3 + f4;
        Double.isNaN(d1);
        d1 = Math.round(d1 * 1000000.0D);
        Double.isNaN(d1);
        f3 = (float)(d1 / 1000000.0D);
        d1 = f1 + f2;
        Double.isNaN(d1);
        d1 = Math.round(d1 * 1000000.0D);
        Double.isNaN(d1);
        f1 = (float)(d1 / 1000000.0D);
        localArrayList.add(new LatLng(f3, f1));
        n += 2;
      }
      paramList = new ArrayList();
      n = i1;
      while (n < localArrayList.size())
      {
        if (paramList.size() >= 1)
        {
          if (!((LatLng)paramList.get(paramList.size() - 1)).equals(localArrayList.get(n))) {
            paramList.add(localArrayList.get(n));
          }
        }
        else {
          paramList.add(localArrayList.get(n));
        }
        n += 1;
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
    double d1 = Math.sqrt(paramDouble2 * paramDouble2 + paramDouble1 * paramDouble1) + Math.sin(paramDouble1 * 3.141592653589793D) * 2.E-005D;
    paramDouble2 = Math.atan2(paramDouble1, paramDouble2) + Math.cos(paramDouble2 * 3.141592653589793D) * 3.E-006D;
    paramDouble1 = Math.cos(paramDouble2) * d1 + 0.0065D;
    paramDouble2 = d1 * Math.sin(paramDouble2) + 0.006D;
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
  
  protected void a()
  {
    long l1 = System.currentTimeMillis();
    this.b.clear();
    Object localObject = this.c.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (PackageUtil.d(this.j, str)) {
        this.b.add(str);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkInstalledMapApp: time=");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l1);
      QLog.d("Q.qqmap", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(QQMapRoutingHelper.RouteListener paramRouteListener)
  {
    this.m = paramRouteListener;
  }
  
  public void a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    if (!NetworkUtil.isNetworkAvailable(this.j))
    {
      paramGeoPoint1 = this.j.getResources();
      QQToast.makeText(this.j.getApplicationContext(), 1, paramGeoPoint1.getString(2131892104), 1).show(paramGeoPoint1.getDimensionPixelSize(2131299920));
      return;
    }
    Bundle localBundle1 = new Bundle();
    Bundle localBundle2 = new Bundle();
    String str;
    if (this.l == 1)
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
    double d1 = paramGeoPoint1.getLatitudeE6();
    Double.isNaN(d1);
    localStringBuilder.append(d1 / 1000000.0D);
    localStringBuilder.append(",");
    d1 = paramGeoPoint1.getLongitudeE6();
    Double.isNaN(d1);
    localStringBuilder.append(d1 / 1000000.0D);
    localBundle1.putString("from", localStringBuilder.toString());
    paramGeoPoint1 = new StringBuilder();
    d1 = paramGeoPoint2.getLatitudeE6();
    Double.isNaN(d1);
    paramGeoPoint1.append(d1 / 1000000.0D);
    paramGeoPoint1.append(",");
    d1 = paramGeoPoint2.getLongitudeE6();
    Double.isNaN(d1);
    paramGeoPoint1.append(d1 / 1000000.0D);
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
      this.h = paramGeoPoint1;
      this.i = paramGeoPoint2;
      this.f = paramString1;
      this.g = paramString2;
      if (TextUtils.isEmpty(this.f)) {
        this.f = HardCodeUtil.a(2131908092);
      }
      if (TextUtils.isEmpty(this.g)) {
        this.g = HardCodeUtil.a(2131908088);
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
        this.l = 1;
      } else {
        this.l = 0;
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
      this.a = ActionSheet.create(this.j);
      this.a.setOnButtonClickListener(this);
      paramGeoPoint1 = this.m;
      if ((paramGeoPoint1 != null) && (!paramGeoPoint1.i())) {
        this.a.addButton(HardCodeUtil.a(2131908095));
      } else {
        this.a.addButton(HardCodeUtil.a(2131908087));
      }
      this.e[0] = 0;
      this.a.addButton(HardCodeUtil.a(2131908093));
      this.e[1] = 1;
      this.a.addButton((CharSequence)this.c.get("com.tencent.map"));
      paramGeoPoint1 = this.e;
      int n = 3;
      paramGeoPoint1[2] = 2;
      paramGeoPoint1 = this.c.entrySet().iterator();
      while (paramGeoPoint1.hasNext())
      {
        paramString1 = (Map.Entry)paramGeoPoint1.next();
        paramGeoPoint2 = (String)paramString1.getKey();
        paramString1 = (String)paramString1.getValue();
        if ((!paramGeoPoint2.equals("com.tencent.map")) && (this.b.contains(paramGeoPoint2)))
        {
          this.a.addButton(paramString1);
          this.e[n] = ((Integer)this.d.get(paramGeoPoint2)).intValue();
          n += 1;
        }
      }
      this.a.addCancelButton(2131887648);
      this.a.show();
      return;
    }
    QQToast.makeText(this.j.getApplicationContext(), 0, HardCodeUtil.a(2131908094), 1).show(this.j.getResources().getDimensionPixelSize(2131299920));
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
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i1 = 0;
    Object localObject1 = localStringBuilder;
    int n = i4;
    if (paramJSONObject != null)
    {
      localObject1 = localStringBuilder;
      n = i4;
      try
      {
        if (paramJSONObject.getInt("status") != 0) {
          break label352;
        }
        paramJSONObject = paramJSONObject.getJSONObject("result").getJSONArray("routes");
        localObject1 = localStringBuilder;
        n = i4;
        if (paramJSONObject.length() <= 0) {
          break label352;
        }
        localObject1 = paramJSONObject.getJSONObject(0);
        n = ((JSONObject)localObject1).getInt("distance");
        try
        {
          ((JSONObject)localObject1).getInt("duration");
          if (paramInt == 0)
          {
            paramJSONObject = ((JSONObject)localObject1).getJSONArray("polyline");
            localObject1 = new ArrayList();
            paramInt = i1;
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
              paramInt = i2;
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
          paramInt = n;
        }
        localObject1 = localStringBuilder;
      }
      catch (Exception paramJSONObject)
      {
        paramInt = i3;
      }
      n = paramInt;
      if (QLog.isColorLevel())
      {
        QLog.w("Q.qqmap", 2, "parseRoutes:", paramJSONObject);
        n = paramInt;
        localObject1 = localStringBuilder;
      }
    }
    label352:
    paramJSONObject = this.m;
    if (paramJSONObject != null) {
      paramJSONObject.a((List)localObject1, n);
    }
  }
  
  protected void b()
  {
    Object localObject = new Intent(this.j, QQBrowserActivity.class);
    double d1 = this.i.getLatitudeE6();
    Double.isNaN(d1);
    d1 /= 1000000.0D;
    double d2 = this.i.getLongitudeE6();
    Double.isNaN(d2);
    d2 /= 1000000.0D;
    double d3 = this.h.getLatitudeE6();
    Double.isNaN(d3);
    d3 /= 1000000.0D;
    double d4 = this.h.getLongitudeE6();
    Double.isNaN(d4);
    String str = String.format("https://common.diditaxi.com.cn/general/webEntry?channel=72778&source=mqq&tolat=%f&tolng=%f&fromlat=%f&fromlng=%f&maptype=soso&_wv=1039", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4 / 1000000.0D) });
    ((Intent)localObject).putExtra("url", str);
    this.j.startActivity((Intent)localObject);
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
    if (this.b.contains("com.tencent.map"))
    {
      if (this.l == 0) {
        localObject1 = "walk";
      } else {
        localObject1 = "drive";
      }
      Object localObject2 = this.f;
      double d1 = this.h.getLatitudeE6();
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      double d2 = this.h.getLongitudeE6();
      Double.isNaN(d2);
      d2 /= 1000000.0D;
      Object localObject3 = this.g;
      double d3 = this.i.getLatitudeE6();
      Double.isNaN(d3);
      d3 /= 1000000.0D;
      double d4 = this.i.getLongitudeE6();
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
        this.j.startActivity((Intent)localObject2);
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
    Object localObject1 = new Intent(this.j, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", "https://3gimg.qq.com/map_site_cms/download/index.html?appid=mobilemap&logid=map_app&ch=appdownload");
    this.j.startActivity((Intent)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "openQQMapForRoute, download=https://3gimg.qq.com/map_site_cms/download/index.html?appid=mobilemap&logid=map_app&ch=appdownload");
    }
    a("tencentmap_click", "dl");
    b("click_navig", "2");
  }
  
  protected void d()
  {
    int n = this.l;
    Object localObject1 = "http://maps.google.com/maps?f=d&source=s_d&saddr=%f,%f&daddr=%f,%f&hl=zh";
    if (n == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("http://maps.google.com/maps?f=d&source=s_d&saddr=%f,%f&daddr=%f,%f&hl=zh");
      ((StringBuilder)localObject1).append("&dirflg=w");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    double d1 = this.h.getLatitudeE6();
    Double.isNaN(d1);
    d1 /= 1000000.0D;
    double d2 = this.h.getLongitudeE6();
    Double.isNaN(d2);
    d2 /= 1000000.0D;
    double d3 = this.i.getLatitudeE6();
    Double.isNaN(d3);
    d3 /= 1000000.0D;
    double d4 = this.i.getLongitudeE6();
    Double.isNaN(d4);
    localObject1 = String.format((String)localObject1, new Object[] { Double.valueOf(d1), Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4 / 1000000.0D) });
    try
    {
      Object localObject2 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject1));
      ((Intent)localObject2).addFlags(0);
      ((Intent)localObject2).setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      this.j.startActivity((Intent)localObject2);
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
    int n;
    if (this.l == 0) {
      n = 4;
    } else {
      n = 2;
    }
    double d1 = this.h.getLatitudeE6();
    Double.isNaN(d1);
    d1 /= 1000000.0D;
    double d2 = this.h.getLongitudeE6();
    Double.isNaN(d2);
    d2 /= 1000000.0D;
    String str = this.f;
    double d3 = this.i.getLatitudeE6();
    Double.isNaN(d3);
    d3 /= 1000000.0D;
    double d4 = this.i.getLongitudeE6();
    Double.isNaN(d4);
    str = String.format("androidamap://route?sourceApplication=qq&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&m=0&t=%d", new Object[] { Double.valueOf(d1), Double.valueOf(d2), str, Double.valueOf(d3), Double.valueOf(d4 / 1000000.0D), this.g, Integer.valueOf(n) });
    try
    {
      Object localObject = new Intent("android.intent.action.VIEW");
      ((Intent)localObject).setData(Uri.parse(str));
      ((Intent)localObject).setPackage("com.autonavi.minimap");
      this.j.startActivity((Intent)localObject);
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
    if (this.l == 0) {
      str = "walking";
    } else {
      str = "driving";
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    try
    {
      int n = this.h.getLatitudeE6();
      double d1 = n;
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      localObject1 = localObject2;
      n = this.h.getLongitudeE6();
      double d2 = n;
      Double.isNaN(d2);
      d2 /= 1000000.0D;
      localObject1 = localObject2;
      double[] arrayOfDouble1 = a(d1, d2);
      localObject1 = localObject2;
      n = this.i.getLatitudeE6();
      d1 = n;
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      localObject1 = localObject2;
      n = this.i.getLongitudeE6();
      d2 = n;
      Double.isNaN(d2);
      d2 /= 1000000.0D;
      localObject1 = localObject2;
      double[] arrayOfDouble2 = a(d1, d2);
      localObject1 = localObject2;
      str = String.format("intent://map/direction?origin=latlng:%f,%f|name:%s&destination=latlng:%f,%f|name:%s&mode=%s&src=src=thirdapp.navi.yourCompanyName.yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end", new Object[] { Double.valueOf(arrayOfDouble1[0]), Double.valueOf(arrayOfDouble1[1]), this.f, Double.valueOf(arrayOfDouble2[0]), Double.valueOf(arrayOfDouble2[1]), this.g, str });
      localObject1 = str;
      localObject2 = Intent.getIntent(str);
      localObject1 = str;
      this.j.startActivity((Intent)localObject2);
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
  
  public void onClick(View paramView, int paramInt)
  {
    paramInt = this.e[paramInt];
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
      paramView = this.m;
      if (paramView != null) {
        if (!paramView.i())
        {
          a(this.h, this.i);
          a("show_route");
        }
        else
        {
          this.m.h();
          a("hide_route");
        }
      }
    }
    if (this.a.isShowing()) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.widgets.QQMapRoutingHelper
 * JD-Core Version:    0.7.0.1
 */