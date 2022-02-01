package com.tencent.device.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtX5WebView;
import com.tencent.smtt.sdk.WebView;
import cooperation.plugin.PluginBaseActivity;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.BaseActivity;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public class LightAppUtil
{
  public static volatile ConcurrentHashMap<Integer, LightAppSettingInfo> a = new ConcurrentHashMap();
  public static ArrayList<LightAppSettingInfo> b = new ArrayList();
  protected static long o = 0L;
  protected ArrayList<Integer> c;
  public Activity d;
  protected LightAppUtil.GetLightAppSettingListener e;
  protected QQProgressDialog f = null;
  protected AppRuntime g;
  protected boolean h;
  protected boolean i = false;
  protected boolean j = false;
  protected String k;
  protected DeviceInfo l;
  protected Bundle m;
  protected boolean n = false;
  private BusinessObserver p = new LightAppUtil.1(this);
  
  public LightAppUtil()
  {
    this.g = BaseApplicationImpl.getApplication().getRuntime();
    this.j = false;
  }
  
  public LightAppUtil(Activity paramActivity)
  {
    this.d = paramActivity;
    paramActivity = this.d;
    if ((paramActivity instanceof AppActivity))
    {
      this.g = ((AppActivity)paramActivity).getAppRuntime();
      this.j = true;
      return;
    }
    if ((paramActivity instanceof BaseActivity))
    {
      this.g = ((BaseActivity)paramActivity).getAppRuntime();
      this.j = false;
    }
  }
  
  public LightAppUtil(Activity paramActivity, LightAppUtil.GetLightAppSettingListener paramGetLightAppSettingListener)
  {
    this.d = paramActivity;
    this.e = paramGetLightAppSettingListener;
    paramActivity = this.d;
    if ((paramActivity instanceof AppActivity))
    {
      this.g = ((AppActivity)paramActivity).getAppRuntime();
      this.j = true;
      return;
    }
    if ((paramActivity instanceof BaseActivity))
    {
      this.g = ((BaseActivity)paramActivity).getAppRuntime();
      this.j = false;
    }
  }
  
  public static String a(Resources paramResources, LightAppSettingInfo paramLightAppSettingInfo, String paramString)
  {
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (!paramString.equals("null")) {}
    }
    else
    {
      str = paramResources.getString(2131888502);
    }
    if ((!TextUtils.isEmpty(paramLightAppSettingInfo.g)) && (!TextUtils.isEmpty(paramLightAppSettingInfo.f)) && (AppUtil.a(paramLightAppSettingInfo.g))) {
      return paramResources.getString(2131888504, new Object[] { str });
    }
    return paramResources.getString(2131888503, new Object[] { str });
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (AppUtil.a(paramString1)))
    {
      AppUtil.c(paramActivity, paramString1);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("autoDownload", false);
    localBundle.putString("packageName", paramString1);
    localBundle.putString("appId", paramString2);
    AppClient.b(paramActivity, localBundle);
  }
  
  private void a(Intent paramIntent, LightAppSettingInfo paramLightAppSettingInfo)
  {
    if (paramLightAppSettingInfo.h == 2) {
      paramLightAppSettingInfo = "https://qzs.qq.com/open/mobile/iot_public_device_2/html/ipCamera.html";
    } else if (paramLightAppSettingInfo.h == 17) {
      paramLightAppSettingInfo = "https://qzs.qq.com/open/mobile/iot_public_device_2/html/print.html";
    } else {
      paramLightAppSettingInfo = null;
    }
    paramIntent.putExtra("url", paramLightAppSettingInfo);
  }
  
  public static void a(ArrayList<LightAppSettingInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      LightAppSettingInfo localLightAppSettingInfo = (LightAppSettingInfo)paramArrayList.next();
      if (!a.containsKey(Integer.valueOf(localLightAppSettingInfo.c)))
      {
        a.put(Integer.valueOf(localLightAppSettingInfo.c), localLightAppSettingInfo);
        b.add(localLightAppSettingInfo);
      }
    }
  }
  
  public static void d()
  {
    a.clear();
    b.clear();
  }
  
  private void e()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.k);
    Object localObject = new StringBuilder();
    if (this.c != null)
    {
      int i1 = 0;
      while (i1 < this.c.size())
      {
        ((StringBuilder)localObject).append(this.c.get(i1));
        if (i1 != this.c.size() - 1) {
          ((StringBuilder)localObject).append(",");
        }
        i1 += 1;
      }
    }
    localBundle.putString("pids", ((StringBuilder)localObject).toString());
    if (this.n)
    {
      localObject = this.l;
      if (localObject != null) {
        localBundle.putLong("din", ((DeviceInfo)localObject).din);
      }
    }
    if (this.n) {
      localObject = "get_public_lightapp_info";
    } else {
      localObject = "get_lightapp_info";
    }
    SmartDeviceUtil.a((String)localObject, localBundle, this.g, this.p);
  }
  
  public LightAppSettingInfo a(DeviceInfo paramDeviceInfo)
  {
    LightAppSettingInfo localLightAppSettingInfo2 = (LightAppSettingInfo)a.get(Integer.valueOf(paramDeviceInfo.productId));
    LightAppSettingInfo localLightAppSettingInfo1 = localLightAppSettingInfo2;
    if (localLightAppSettingInfo2 == null)
    {
      localLightAppSettingInfo1 = localLightAppSettingInfo2;
      if (!this.j)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        localLightAppSettingInfo1 = localLightAppSettingInfo2;
        if ((localAppRuntime instanceof QQAppInterface))
        {
          a(((SmartDeviceProxyMgr)((QQAppInterface)localAppRuntime).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).d());
          localLightAppSettingInfo1 = (LightAppSettingInfo)a.get(Integer.valueOf(paramDeviceInfo.productId));
        }
      }
    }
    return localLightAppSettingInfo1;
  }
  
  public HashMap<Integer, String> a(JSONArray paramJSONArray)
  {
    HashMap localHashMap = new HashMap();
    if (paramJSONArray != null) {}
    try
    {
      if (paramJSONArray.length() > 0)
      {
        int i1 = 0;
        while (i1 < paramJSONArray.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i1);
          if (localJSONObject != null) {
            localHashMap.put(Integer.valueOf(localJSONObject.getInt("property_id")), localJSONObject.getString("property_val"));
          }
          i1 += 1;
        }
      }
      return localHashMap;
    }
    catch (Exception paramJSONArray) {}
    return localHashMap;
  }
  
  public void a(DeviceInfo paramDeviceInfo, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramDeviceInfo == null)
    {
      paramDeviceInfo = this.e;
      if (paramDeviceInfo != null) {
        paramDeviceInfo.a(false);
      }
      return;
    }
    boolean bool;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("showProgress", true);
    } else {
      bool = true;
    }
    this.i = true;
    this.n = paramBoolean;
    Object localObject3 = a(paramDeviceInfo);
    if (localObject3 != null)
    {
      if ((((LightAppSettingInfo)localObject3).n != 3) && (((LightAppSettingInfo)localObject3).n != 7) && (((LightAppSettingInfo)localObject3).n != 5) && (((LightAppSettingInfo)localObject3).n != 4) && (((LightAppSettingInfo)localObject3).n != 1) && (((LightAppSettingInfo)localObject3).n != 8) && (((LightAppSettingInfo)localObject3).n != 9))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("bindType=");
          ((StringBuilder)localObject1).append(((LightAppSettingInfo)localObject3).n);
          QLog.e("LightAppUtil", 2, ((StringBuilder)localObject1).toString());
        }
        ToastUtil.a().a(2131888505);
      }
      else
      {
        if (((LightAppSettingInfo)localObject3).a == 0)
        {
          int i1 = ((LightAppSettingInfo)localObject3).h;
          if (i1 != 2) {
            if (i1 != 14) {
              if (i1 != 16) {
                if ((i1 != 17) && (TextUtils.isEmpty(((LightAppSettingInfo)localObject3).i)) && (TextUtils.isEmpty(((LightAppSettingInfo)localObject3).j))) {
                  break label368;
                }
              }
            }
          }
        }
        do
        {
          do
          {
            localObject1 = "com.tencent.device.lightapp.LightAppActivity";
            break;
            localObject1 = "com.tencent.device.av.VisualDoorBellActivity";
            break;
            localObject1 = "com.tencent.device.qqwifi.WiFiStorageActivity";
            break;
            if ((((LightAppSettingInfo)localObject3).e != null) && (((LightAppSettingInfo)localObject3).e.contains(Integer.valueOf(200031))))
            {
              localObject1 = "com.tencent.device.superav.ui.SuperVideoActivity";
              break;
            }
          } while ((this.n) && (a()));
          localObject1 = "com.tencent.device.av.VideoActivity";
          break;
          if (((LightAppSettingInfo)localObject3).a != 1) {
            break label751;
          }
        } while ((!TextUtils.isEmpty(((LightAppSettingInfo)localObject3).i)) || (!TextUtils.isEmpty(((LightAppSettingInfo)localObject3).j)));
      }
      label368:
      Object localObject1 = null;
      Object localObject2;
      if (localObject1 == null)
      {
        paramDeviceInfo = new Intent();
        paramDeviceInfo.setClassName("com.tencent.mobileqq", "com.tencent.biz.pubaccount.api.PublicAccountBrowser");
        paramDeviceInfo.putExtra("url", "https://qzs.qq.com/open/mobile/qq_download/index.html");
        paramDeviceInfo.putExtra("isPublicDevice", paramBoolean);
        SmartDeviceReport.a(null, "Net_LiteApp_Setting", 0, 1, ((LightAppSettingInfo)localObject3).c);
      }
      else
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("device_info", paramDeviceInfo);
        localBundle.putParcelable("lightapp_setting", (Parcelable)localObject3);
        if (paramBundle != null) {
          localBundle.putBundle("extras", paramBundle);
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("uin", String.valueOf(paramDeviceInfo.din));
        if (!TextUtils.isEmpty(paramDeviceInfo.displayName)) {
          ((Intent)localObject2).putExtra("uinname", paramDeviceInfo.displayName);
        } else {
          ((Intent)localObject2).putExtra("uinname", SmartDeviceUtil.a(paramDeviceInfo));
        }
        ((Intent)localObject2).putExtra("account", paramDeviceInfo.serialNum);
        ((Intent)localObject2).putExtra("pid", paramDeviceInfo.productId);
        ((Intent)localObject2).putExtra("device_info", paramDeviceInfo);
        ((Intent)localObject2).putExtra("isPublicDevice", paramBoolean);
        if (this.n) {
          a((Intent)localObject2, (LightAppSettingInfo)localObject3);
        }
        if ((paramBundle != null) && (paramBundle.getBoolean("isFromBindSucc", false))) {
          ((Intent)localObject2).putExtra("bindSuccTime", System.currentTimeMillis());
        }
        ((Intent)localObject2).putExtras(localBundle);
        paramDeviceInfo = (DeviceInfo)localObject2;
      }
      if (localObject1 == null)
      {
        this.d.startActivity(paramDeviceInfo);
      }
      else
      {
        paramBundle = this.d;
        if ((paramBundle instanceof PluginBaseActivity))
        {
          paramDeviceInfo.setClassName(paramBundle, (String)localObject1);
          this.d.startActivity(paramDeviceInfo);
        }
        else
        {
          if ((paramBundle instanceof ChatActivity)) {
            paramDeviceInfo.putExtra("bFromChatActivity", true);
          }
          paramBundle = SmartDevicePluginLoader.a();
          localObject2 = this.d;
          localObject3 = this.g;
          paramBundle.a((Activity)localObject2, (AppRuntime)localObject3, ((AppRuntime)localObject3).getAccount(), paramDeviceInfo, (String)localObject1, -1, null, SmartDevicePluginProxyActivity.class);
        }
      }
      paramDeviceInfo = this.e;
      if (paramDeviceInfo != null)
      {
        paramDeviceInfo.a(true);
        return;
        label751:
        ToastUtil.a().a(2131888509);
        paramDeviceInfo = this.e;
        if (paramDeviceInfo != null) {
          paramDeviceInfo.a(false);
        }
      }
    }
    else
    {
      if (this.l == null)
      {
        if (!NetworkUtil.isNetworkAvailable(this.d))
        {
          ToastUtil.a().a(2131888508);
          paramDeviceInfo = this.e;
          if (paramDeviceInfo != null) {
            paramDeviceInfo.a(false);
          }
          return;
        }
        this.l = paramDeviceInfo;
        this.m = paramBundle;
        paramBundle = new ArrayList();
        paramBundle.add(Integer.valueOf(paramDeviceInfo.productId));
        a(paramBundle, bool);
        return;
      }
      ToastUtil.a().a(2131888507);
      if ((this.f != null) && (!this.d.isFinishing())) {
        this.f.dismiss();
      }
      paramDeviceInfo = this.e;
      if (paramDeviceInfo != null) {
        paramDeviceInfo.a(false);
      }
    }
  }
  
  public void a(ArrayList<Integer> paramArrayList, boolean paramBoolean)
  {
    this.c = paramArrayList;
    this.h = paramBoolean;
    c();
  }
  
  public boolean a()
  {
    Activity localActivity = this.d;
    boolean bool = false;
    if (localActivity == null) {
      return false;
    }
    Object localObject = localActivity;
    if ((localActivity instanceof PluginBaseActivity)) {
      localObject = ((PluginBaseActivity)localActivity).getOutActivity();
    }
    if (localObject == null) {
      return false;
    }
    localObject = new DtX5WebView((Context)localObject);
    if (Build.VERSION.SDK_INT >= 11)
    {
      ((WebView)localObject).removeJavascriptInterface("searchBoxJavaBridge_");
      ((WebView)localObject).removeJavascriptInterface("accessibility");
      ((WebView)localObject).removeJavascriptInterface("accessibilityTraversal");
    }
    if (((WebView)localObject).getX5WebViewExtension() != null) {
      bool = true;
    }
    ((WebView)localObject).destroy();
    return bool;
  }
  
  public void b()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = ((SmartDeviceProxyMgr)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).e();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        ArrayList localArrayList = new ArrayList();
        if (SystemClock.elapsedRealtime() - o > 15000L)
        {
          o = SystemClock.elapsedRealtime();
          int i2 = localObject1.length;
          int i1 = 0;
          while (i1 < i2)
          {
            Object localObject2 = localObject1[i1];
            if (!a.containsKey(Integer.valueOf(localObject2.productId))) {
              localArrayList.add(Integer.valueOf(localObject2.productId));
            }
            i1 += 1;
          }
          if (localArrayList.size() > 0) {
            a(localArrayList, false);
          }
        }
      }
    }
  }
  
  protected void c()
  {
    if (this.h)
    {
      localObject = this.d;
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        localObject = this.d;
        this.f = new QQProgressDialog((Context)localObject, ((Activity)localObject).getResources().getDimensionPixelSize(2131299920));
        this.f.c(2131888506);
        this.f.show();
      }
      else
      {
        this.h = false;
      }
    }
    Object localObject = this.g;
    if (localObject == null)
    {
      LogUtility.d("LightAppUtil", "app == null when dologin");
      localObject = this.e;
      if (localObject != null) {
        ((LightAppUtil.GetLightAppSettingListener)localObject).a(false);
      }
      return;
    }
    this.k = ((AppRuntime)localObject).getAccount();
    if (TextUtils.isEmpty(this.k)) {
      ToastUtil.a().a(2131892334);
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.utils.LightAppUtil
 * JD-Core Version:    0.7.0.1
 */