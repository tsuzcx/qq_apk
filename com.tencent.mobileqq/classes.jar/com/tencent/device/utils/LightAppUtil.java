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
  protected static long a;
  public static ArrayList<LightAppSettingInfo> a;
  public static volatile ConcurrentHashMap<Integer, LightAppSettingInfo> a;
  public Activity a;
  protected Bundle a;
  protected DeviceInfo a;
  protected LightAppUtil.GetLightAppSettingListener a;
  protected QQProgressDialog a;
  protected String a;
  protected AppRuntime a;
  private BusinessObserver a;
  protected boolean a;
  protected ArrayList<Integer> b;
  protected boolean b;
  protected boolean c = false;
  protected boolean d = false;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_Long = 0L;
  }
  
  public LightAppUtil()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new LightAppUtil.1(this);
    this.jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    this.c = false;
  }
  
  public LightAppUtil(Activity paramActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new LightAppUtil.1(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    paramActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((paramActivity instanceof AppActivity))
    {
      this.jdField_a_of_type_MqqAppAppRuntime = ((AppActivity)paramActivity).getAppRuntime();
      this.c = true;
      return;
    }
    if ((paramActivity instanceof BaseActivity))
    {
      this.jdField_a_of_type_MqqAppAppRuntime = ((BaseActivity)paramActivity).getAppRuntime();
      this.c = false;
    }
  }
  
  public LightAppUtil(Activity paramActivity, LightAppUtil.GetLightAppSettingListener paramGetLightAppSettingListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_MqqObserverBusinessObserver = new LightAppUtil.1(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener = paramGetLightAppSettingListener;
    paramActivity = this.jdField_a_of_type_AndroidAppActivity;
    if ((paramActivity instanceof AppActivity))
    {
      this.jdField_a_of_type_MqqAppAppRuntime = ((AppActivity)paramActivity).getAppRuntime();
      this.c = true;
      return;
    }
    if ((paramActivity instanceof BaseActivity))
    {
      this.jdField_a_of_type_MqqAppAppRuntime = ((BaseActivity)paramActivity).getAppRuntime();
      this.c = false;
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
      str = paramResources.getString(2131691540);
    }
    if ((!TextUtils.isEmpty(paramLightAppSettingInfo.b)) && (!TextUtils.isEmpty(paramLightAppSettingInfo.jdField_a_of_type_JavaLangString)) && (AppUtil.a(paramLightAppSettingInfo.b))) {
      return paramResources.getString(2131691542, new Object[] { str });
    }
    return paramResources.getString(2131691541, new Object[] { str });
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (AppUtil.a(paramString1)))
    {
      AppUtil.a(paramActivity, paramString1);
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
    if (paramLightAppSettingInfo.jdField_d_of_type_Int == 2) {
      paramLightAppSettingInfo = "https://qzs.qq.com/open/mobile/iot_public_device_2/html/ipCamera.html";
    } else if (paramLightAppSettingInfo.jdField_d_of_type_Int == 17) {
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
      if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localLightAppSettingInfo.jdField_c_of_type_Int)))
      {
        jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localLightAppSettingInfo.jdField_c_of_type_Int), localLightAppSettingInfo);
        jdField_a_of_type_JavaUtilArrayList.add(localLightAppSettingInfo);
      }
    }
  }
  
  public static void c()
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  private void d()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", this.jdField_a_of_type_JavaLangString);
    Object localObject = new StringBuilder();
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaUtilArrayList.get(i));
        if (i != this.jdField_b_of_type_JavaUtilArrayList.size() - 1) {
          ((StringBuilder)localObject).append(",");
        }
        i += 1;
      }
    }
    localBundle.putString("pids", ((StringBuilder)localObject).toString());
    if (this.d)
    {
      localObject = this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo;
      if (localObject != null) {
        localBundle.putLong("din", ((DeviceInfo)localObject).din);
      }
    }
    if (this.d) {
      localObject = "get_public_lightapp_info";
    } else {
      localObject = "get_lightapp_info";
    }
    SmartDeviceUtil.a((String)localObject, localBundle, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqObserverBusinessObserver);
  }
  
  public LightAppSettingInfo a(DeviceInfo paramDeviceInfo)
  {
    LightAppSettingInfo localLightAppSettingInfo2 = (LightAppSettingInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramDeviceInfo.productId));
    LightAppSettingInfo localLightAppSettingInfo1 = localLightAppSettingInfo2;
    if (localLightAppSettingInfo2 == null)
    {
      localLightAppSettingInfo1 = localLightAppSettingInfo2;
      if (!this.c)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        localLightAppSettingInfo1 = localLightAppSettingInfo2;
        if ((localAppRuntime instanceof QQAppInterface))
        {
          a(((SmartDeviceProxyMgr)((QQAppInterface)localAppRuntime).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a());
          localLightAppSettingInfo1 = (LightAppSettingInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramDeviceInfo.productId));
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
        int i = 0;
        while (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
          if (localJSONObject != null) {
            localHashMap.put(Integer.valueOf(localJSONObject.getInt("property_id")), localJSONObject.getString("property_val"));
          }
          i += 1;
        }
      }
      return localHashMap;
    }
    catch (Exception paramJSONArray) {}
    return localHashMap;
  }
  
  public void a()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = ((SmartDeviceProxyMgr)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        ArrayList localArrayList = new ArrayList();
        if (SystemClock.elapsedRealtime() - jdField_a_of_type_Long > 15000L)
        {
          jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            if (!jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localObject2.productId))) {
              localArrayList.add(Integer.valueOf(localObject2.productId));
            }
            i += 1;
          }
          if (localArrayList.size() > 0) {
            a(localArrayList, false);
          }
        }
      }
    }
  }
  
  public void a(DeviceInfo paramDeviceInfo, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramDeviceInfo == null)
    {
      paramDeviceInfo = this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener;
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
    this.jdField_b_of_type_Boolean = true;
    this.d = paramBoolean;
    Object localObject3 = a(paramDeviceInfo);
    if (localObject3 != null)
    {
      if ((((LightAppSettingInfo)localObject3).e != 3) && (((LightAppSettingInfo)localObject3).e != 7) && (((LightAppSettingInfo)localObject3).e != 5) && (((LightAppSettingInfo)localObject3).e != 4) && (((LightAppSettingInfo)localObject3).e != 1) && (((LightAppSettingInfo)localObject3).e != 8) && (((LightAppSettingInfo)localObject3).e != 9))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("bindType=");
          ((StringBuilder)localObject1).append(((LightAppSettingInfo)localObject3).e);
          QLog.e("LightAppUtil", 2, ((StringBuilder)localObject1).toString());
        }
        ToastUtil.a().a(2131691543);
      }
      else
      {
        if (((LightAppSettingInfo)localObject3).jdField_a_of_type_Int == 0)
        {
          int i = ((LightAppSettingInfo)localObject3).jdField_d_of_type_Int;
          if (i != 2) {
            if (i != 14) {
              if (i != 16) {
                if ((i != 17) && (TextUtils.isEmpty(((LightAppSettingInfo)localObject3).jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(((LightAppSettingInfo)localObject3).jdField_d_of_type_JavaLangString))) {
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
            if ((((LightAppSettingInfo)localObject3).jdField_a_of_type_JavaUtilArrayList != null) && (((LightAppSettingInfo)localObject3).jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(200031))))
            {
              localObject1 = "com.tencent.device.superav.ui.SuperVideoActivity";
              break;
            }
          } while ((this.d) && (a()));
          localObject1 = "com.tencent.device.av.VideoActivity";
          break;
          if (((LightAppSettingInfo)localObject3).jdField_a_of_type_Int != 1) {
            break label751;
          }
        } while ((!TextUtils.isEmpty(((LightAppSettingInfo)localObject3).jdField_c_of_type_JavaLangString)) || (!TextUtils.isEmpty(((LightAppSettingInfo)localObject3).jdField_d_of_type_JavaLangString)));
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
        SmartDeviceReport.a(null, "Net_LiteApp_Setting", 0, 1, ((LightAppSettingInfo)localObject3).jdField_c_of_type_Int);
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
        if (this.d) {
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
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDeviceInfo);
      }
      else
      {
        paramBundle = this.jdField_a_of_type_AndroidAppActivity;
        if ((paramBundle instanceof PluginBaseActivity))
        {
          paramDeviceInfo.setClassName(paramBundle, (String)localObject1);
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDeviceInfo);
        }
        else
        {
          if ((paramBundle instanceof ChatActivity)) {
            paramDeviceInfo.putExtra("bFromChatActivity", true);
          }
          paramBundle = SmartDevicePluginLoader.a();
          localObject2 = this.jdField_a_of_type_AndroidAppActivity;
          localObject3 = this.jdField_a_of_type_MqqAppAppRuntime;
          paramBundle.a((Activity)localObject2, (AppRuntime)localObject3, ((AppRuntime)localObject3).getAccount(), paramDeviceInfo, (String)localObject1, -1, null, SmartDevicePluginProxyActivity.class);
        }
      }
      paramDeviceInfo = this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener;
      if (paramDeviceInfo != null)
      {
        paramDeviceInfo.a(true);
        return;
        label751:
        ToastUtil.a().a(2131691547);
        paramDeviceInfo = this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener;
        if (paramDeviceInfo != null) {
          paramDeviceInfo.a(false);
        }
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null)
      {
        if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
        {
          ToastUtil.a().a(2131691546);
          paramDeviceInfo = this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener;
          if (paramDeviceInfo != null) {
            paramDeviceInfo.a(false);
          }
          return;
        }
        this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo = paramDeviceInfo;
        this.jdField_a_of_type_AndroidOsBundle = paramBundle;
        paramBundle = new ArrayList();
        paramBundle.add(Integer.valueOf(paramDeviceInfo.productId));
        a(paramBundle, bool);
        return;
      }
      ToastUtil.a().a(2131691545);
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      paramDeviceInfo = this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener;
      if (paramDeviceInfo != null) {
        paramDeviceInfo.a(false);
      }
    }
  }
  
  public void a(ArrayList<Integer> paramArrayList, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    b();
  }
  
  public boolean a()
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
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
  
  protected void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      if ((localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        localObject = this.jdField_a_of_type_AndroidAppActivity;
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog((Context)localObject, ((Activity)localObject).getResources().getDimensionPixelSize(2131299168));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131691544);
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      }
      else
      {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localObject == null)
    {
      LogUtility.d("LightAppUtil", "app == null when dologin");
      localObject = this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener;
      if (localObject != null) {
        ((LightAppUtil.GetLightAppSettingListener)localObject).a(false);
      }
      return;
    }
    this.jdField_a_of_type_JavaLangString = ((AppRuntime)localObject).getAccount();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      ToastUtil.a().a(2131694648);
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.utils.LightAppUtil
 * JD-Core Version:    0.7.0.1
 */