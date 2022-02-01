import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.location.ui.MapUtils.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import mqq.app.MobileQQ;

public class awao
{
  private static Boolean a;
  
  private static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  private static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    paramDouble2 = a(paramDouble2);
    paramDouble4 = a(paramDouble4);
    double d = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    return Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d)) * 2.0D * 6378137.0D;
  }
  
  public static double a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return a(paramLatLng1.latitude, paramLatLng1.longitude, paramLatLng2.latitude, paramLatLng2.longitude);
  }
  
  public static int a(Context paramContext)
  {
    int j = 0;
    if (Build.VERSION.SDK_INT >= 19) {}
    for (;;)
    {
      try
      {
        i = Settings.Secure.getInt(paramContext.getContentResolver(), "location_mode");
        if (QLog.isColorLevel()) {
          QLog.d("MapUtils", 2, "getLocationMode: invoked. locationMode: " + i);
        }
        return i;
      }
      catch (Settings.SettingNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        i = j;
        continue;
      }
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "location_providers_allowed");
      int i = j;
      if (!TextUtils.isEmpty(paramContext)) {
        if ((paramContext.contains("gps")) && (paramContext.contains("network")))
        {
          i = 3;
        }
        else if (paramContext.contains("gps"))
        {
          i = 1;
        }
        else
        {
          i = j;
          if (paramContext.contains("network")) {
            i = 2;
          }
        }
      }
    }
  }
  
  private static Object a(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      paramString = paramObject.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramObject = paramString.get(paramObject);
      return paramObject;
    }
    catch (NoSuchFieldException paramObject)
    {
      paramObject.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  static String a(double paramDouble)
  {
    if (paramDouble < 60.0D)
    {
      if (Math.round(paramDouble) <= 0L) {}
      for (i = 1;; i = (int)Math.round(paramDouble)) {
        return i + "分钟";
      }
    }
    if (paramDouble < 1440.0D)
    {
      i = (int)(paramDouble / 60.0D);
      j = (int)Math.round(paramDouble - i * 60);
      return i + "小时" + j + "分钟";
    }
    int i = (int)(paramDouble / 1440.0D);
    int j = (int)(paramDouble / 60.0D - i * 24);
    int k = (int)Math.round(paramDouble - j * 60 - i * 24 * 60);
    return i + "天" + j + "小时" + k + "分钟";
  }
  
  public static void a()
  {
    a = null;
  }
  
  static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    if (a())
    {
      String str = String.format("qqmap://map/routeplan?type=%s&from=%s&fromcoord=%f,%f&to=%s&tocoord=%f,%f&policy=1&referer=qq", new Object[] { paramString1, paramString2, Double.valueOf(paramLatLng1.latitude), Double.valueOf(paramLatLng1.longitude), paramString3, Double.valueOf(paramLatLng2.latitude), Double.valueOf(paramLatLng2.longitude) });
      try
      {
        Intent localIntent = Intent.parseUri(str, 0);
        localIntent.addCategory("android.intent.category.BROWSABLE");
        localIntent.setComponent(null);
        localIntent.setSelector(null);
        localIntent.putExtra("big_brother_source_key", "biz_src_location_share");
        paramActivity.startActivity(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqmap", 2, "launchQQMap: " + str);
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqmap", 2, "launchQQMap: " + str, localException);
        }
        bcst.b(null, "CliOper", "", "", "0X800A972", "0X800A972", 1, 0, "0", "0", "0", "");
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = String.format("qqmap://map/routeplan?type=%s&from=%s&fromcoord=%f,%f&to=%s&tocoord=%f,%f&referer=qq", new Object[] { paramString1, paramString2, Double.valueOf(paramLatLng1.latitude), Double.valueOf(paramLatLng1.longitude), paramString3, Double.valueOf(paramLatLng2.latitude), Double.valueOf(paramLatLng2.longitude) });
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqmap", 2, "launchQQMap, mapparam = " + paramString1);
        }
        paramString1 = URLEncoder.encode(paramString1, "UTF-8");
        paramString1 = "https://mapdownload.map.qq.com/outindex?key=qq&referer=qq2&channel=10041881%2C10041882&intention=" + paramString1;
        paramString2 = new Intent(paramActivity, QQBrowserActivity.class);
        paramString2.putExtra("big_brother_source_key", "biz_src_location_share");
        paramString2.putExtra("url", paramString1);
        paramActivity.startActivity(paramString2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qqmap", 2, "launchQQMap, download = " + paramString1);
        return;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = new Intent(paramActivity, QQBrowserActivity.class);
        paramString1.putExtra("big_brother_source_key", "biz_src_location_share");
        paramString1.putExtra("url", "https://mapdownload.map.qq.com/outindex?key=qq&referer=qq2&channel=10041881%2C10041882");
        paramActivity.startActivity(paramString1);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.qqmap", 2, "launchQQMap, download = https://mapdownload.map.qq.com/outindex?key=qq&referer=qq2&channel=10041881%2C10041882");
      return;
      bcst.b(null, "CliOper", "", "", "0X800A972", "0X800A972", 2, 0, "0", "0", "0", "");
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    if (AppSetting.c) {
      paramView.setContentDescription(paramString);
    }
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  public static void a(TencentMap paramTencentMap)
  {
    if (paramTencentMap != null) {
      a(a(a(a(a(paramTencentMap, "m"), "a"), "b"), "b"), "b", null);
    }
  }
  
  public static void a(TencentMap paramTencentMap, int paramInt)
  {
    if (paramTencentMap != null)
    {
      paramTencentMap = a(a(a(a(paramTencentMap.getUiSettings(), "a"), "a"), "d"), "W");
      if ((paramTencentMap instanceof ViewGroup)) {
        ((ViewGroup)paramTencentMap).setVisibility(paramInt);
      }
    }
  }
  
  public static void a(Marker paramMarker)
  {
    if (paramMarker != null)
    {
      String str1 = paramMarker.getTitle();
      String str2 = paramMarker.getSnippet();
      if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2))) {
        paramMarker.showInfoWindow();
      }
    }
    else
    {
      return;
    }
    paramMarker.hideInfoWindow();
  }
  
  private static void a(Object paramObject1, String paramString, Object paramObject2)
  {
    if (paramObject1 == null) {
      return;
    }
    try
    {
      paramString = paramObject1.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString.set(paramObject1, paramObject2);
      return;
    }
    catch (NoSuchFieldException paramObject1)
    {
      paramObject1.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramTextView.getWidth() == 0)
    {
      paramTextView.post(new MapUtils.1(paramString1, paramString2, paramTextView));
      return;
    }
    String str = paramString1 + paramString2;
    float f2 = paramTextView.getWidth();
    float f1 = paramTextView.getPaint().measureText(paramString1);
    float f3 = paramTextView.getPaint().measureText(paramString2);
    if (f1 + f3 <= f2)
    {
      paramTextView.setText(str);
      return;
    }
    float f4 = paramTextView.getPaint().measureText("...");
    while ((f1 + f4 + f3 > f2) && (paramString1.length() > 0))
    {
      paramString1 = paramString1.substring(0, paramString1.length() - 1);
      f1 = paramTextView.getPaint().measureText(paramString1);
    }
    paramTextView.setText(paramString1 + "..." + paramString2);
  }
  
  public static boolean a()
  {
    if (a == null) {
      a = Boolean.valueOf(bkgu.a(MobileQQ.sMobileQQ, "com.tencent.map"));
    }
    return a.booleanValue();
  }
  
  public static boolean a(Context paramContext, TencentMap paramTencentMap, LatLng paramLatLng)
  {
    boolean bool1 = false;
    int i = paramContext.getResources().getDisplayMetrics().heightPixels;
    paramContext = new Rect(0, 0, paramContext.getResources().getDisplayMetrics().widthPixels, i);
    paramTencentMap = paramTencentMap.getProjection();
    if (paramTencentMap == null) {}
    boolean bool2;
    do
    {
      return bool1;
      paramTencentMap = paramTencentMap.toScreenLocation(paramLatLng);
      bool2 = paramContext.contains(paramTencentMap.x, paramTencentMap.y);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("MapUtils", 2, "[map][init]isLocationInScreen: invoked. location: " + paramLatLng + " screen: " + paramTencentMap + " inScreen: " + bool2);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awao
 * JD-Core Version:    0.7.0.1
 */