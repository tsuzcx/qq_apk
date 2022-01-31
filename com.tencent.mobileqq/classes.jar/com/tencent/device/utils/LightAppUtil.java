package com.tencent.device.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.AppUtil;
import com.tencent.qphone.base.util.QLog;
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
import qms;

public class LightAppUtil
{
  protected static long a;
  public static ArrayList a;
  public static volatile ConcurrentHashMap a;
  public Activity a;
  public Bundle a;
  public DeviceInfo a;
  public LightAppUtil.GetLightAppSettingListener a;
  public QQProgressDialog a;
  protected String a;
  public AppRuntime a;
  private BusinessObserver a;
  protected boolean a;
  protected ArrayList b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public LightAppUtil()
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver = new qms(this);
    this.jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    this.c = false;
  }
  
  public LightAppUtil(Activity paramActivity)
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver = new qms(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))
    {
      this.jdField_a_of_type_MqqAppAppRuntime = ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
      this.c = true;
    }
    while (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
    this.c = false;
  }
  
  public LightAppUtil(Activity paramActivity, LightAppUtil.GetLightAppSettingListener paramGetLightAppSettingListener)
  {
    this.jdField_a_of_type_MqqObserverBusinessObserver = new qms(this);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener = paramGetLightAppSettingListener;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof AppActivity))
    {
      this.jdField_a_of_type_MqqAppAppRuntime = ((AppActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
      this.c = true;
    }
    while (!(this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity)) {
      return;
    }
    this.jdField_a_of_type_MqqAppAppRuntime = ((BaseActivity)this.jdField_a_of_type_AndroidAppActivity).getAppRuntime();
    this.c = false;
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
      str = paramResources.getString(2131427736);
    }
    if ((!TextUtils.isEmpty(paramLightAppSettingInfo.b)) && (!TextUtils.isEmpty(paramLightAppSettingInfo.jdField_a_of_type_JavaLangString)) && (AppUtil.a(paramLightAppSettingInfo.b))) {
      return paramResources.getString(2131427735, new Object[] { str });
    }
    return paramResources.getString(2131427734, new Object[] { str });
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
    String str = null;
    if (paramLightAppSettingInfo.jdField_d_of_type_Int == 2) {
      str = "http://qzs.qq.com/open/mobile/iot_public_device_2/html/ipCamera.html";
    }
    for (;;)
    {
      paramIntent.putExtra("url", str);
      return;
      if (paramLightAppSettingInfo.jdField_d_of_type_Int == 17) {
        str = "http://qzs.qq.com/open/mobile/iot_public_device_2/html/print.html";
      }
    }
  }
  
  public static void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
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
    if ((this.d) && (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo != null)) {
      localBundle.putLong("din", this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.din);
    }
    if (this.d) {}
    for (localObject = "get_public_lightapp_info";; localObject = "get_lightapp_info")
    {
      SmartDeviceUtil.a((String)localObject, localBundle, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqObserverBusinessObserver);
      return;
    }
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
          a(((SmartDeviceProxyMgr)((QQAppInterface)localAppRuntime).a(51)).a());
          localLightAppSettingInfo1 = (LightAppSettingInfo)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramDeviceInfo.productId));
        }
      }
    }
    return localLightAppSettingInfo1;
  }
  
  public HashMap a(JSONArray paramJSONArray)
  {
    localHashMap = new HashMap();
    if (paramJSONArray != null) {
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
    }
  }
  
  public void a()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = ((SmartDeviceProxyMgr)((QQAppInterface)localObject1).a(51)).a();
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
      if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
        this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
      }
      return;
    }
    if (paramBundle != null) {}
    for (boolean bool = paramBundle.getBoolean("showProgress", true);; bool = true)
    {
      this.jdField_b_of_type_Boolean = true;
      this.d = paramBoolean;
      LightAppSettingInfo localLightAppSettingInfo = a(paramDeviceInfo);
      String str;
      if (localLightAppSettingInfo != null) {
        if ((localLightAppSettingInfo.e != 3) && (localLightAppSettingInfo.e != 7) && (localLightAppSettingInfo.e != 5) && (localLightAppSettingInfo.e != 4) && (localLightAppSettingInfo.e != 1) && (localLightAppSettingInfo.e != 8) && (localLightAppSettingInfo.e != 9))
        {
          if (QLog.isColorLevel()) {
            QLog.e("LightAppUtil", 2, "bindType=" + localLightAppSettingInfo.e);
          }
          ToastUtil.a().a(2131427733);
          str = null;
        }
      }
      for (;;)
      {
        if ((str == null) && (0 == 0))
        {
          paramDeviceInfo = new Intent();
          paramDeviceInfo.setClassName("com.tencent.mobileqq", "com.tencent.biz.pubaccount.PublicAccountBrowser");
          paramDeviceInfo.putExtra("url", "http://qzs.qq.com/open/mobile/qq_download/index.html");
          paramDeviceInfo.putExtra("isPublicDevice", paramBoolean);
          SmartDeviceReport.a(null, "Net_LiteApp_Setting", 0, 1, localLightAppSettingInfo.jdField_c_of_type_Int);
          if (str != null) {
            break label713;
          }
          this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDeviceInfo);
          label247:
          if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
            break label794;
          }
          this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(true);
          return;
          if (localLightAppSettingInfo.jdField_a_of_type_Int == 0) {
            switch (localLightAppSettingInfo.jdField_d_of_type_Int)
            {
            default: 
              if ((TextUtils.isEmpty(localLightAppSettingInfo.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(localLightAppSettingInfo.jdField_d_of_type_JavaLangString))) {
                break label935;
              }
              str = "com.tencent.device.lightapp.LightAppActivity";
              break;
            case 2: 
              if ((localLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList != null) && (localLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList.contains(Integer.valueOf(200031))))
              {
                str = "com.tencent.device.superav.ui.SuperVideoActivity";
                continue;
              }
              if ((this.d) && (a()))
              {
                str = "com.tencent.device.lightapp.LightAppActivity";
                continue;
              }
              str = "com.tencent.device.av.VideoActivity";
              break;
            case 14: 
              str = "com.tencent.device.qqwifi.WiFiStorageActivity";
              break;
            case 16: 
              str = "com.tencent.device.av.VisualDoorBellActivity";
              break;
            case 17: 
              str = "com.tencent.device.lightapp.LightAppActivity";
              break;
            }
          }
          if (localLightAppSettingInfo.jdField_a_of_type_Int == 1)
          {
            if ((TextUtils.isEmpty(localLightAppSettingInfo.jdField_c_of_type_JavaLangString)) && (TextUtils.isEmpty(localLightAppSettingInfo.jdField_d_of_type_JavaLangString))) {
              break label935;
            }
            str = "com.tencent.device.lightapp.LightAppActivity";
            continue;
          }
          ToastUtil.a().a(2131427732);
          if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
          return;
        }
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("device_info", paramDeviceInfo);
        localBundle.putParcelable("lightapp_setting", localLightAppSettingInfo);
        if (paramBundle != null) {
          localBundle.putBundle("extras", paramBundle);
        }
        if (0 == 0) {}
        for (Intent localIntent = new Intent();; localIntent = null)
        {
          localIntent.putExtra("uin", String.valueOf(paramDeviceInfo.din));
          if (!TextUtils.isEmpty(paramDeviceInfo.displayName)) {
            localIntent.putExtra("uinname", paramDeviceInfo.displayName);
          }
          for (;;)
          {
            localIntent.putExtra("account", paramDeviceInfo.serialNum);
            localIntent.putExtra("pid", paramDeviceInfo.productId);
            localIntent.putExtra("device_info", paramDeviceInfo);
            localIntent.putExtra("isPublicDevice", paramBoolean);
            if (this.d) {
              a(localIntent, localLightAppSettingInfo);
            }
            if ((paramBundle != null) && (paramBundle.getBoolean("isFromBindSucc", false))) {
              localIntent.putExtra("bindSuccTime", System.currentTimeMillis());
            }
            localIntent.putExtras(localBundle);
            paramDeviceInfo = localIntent;
            break;
            localIntent.putExtra("uinname", SmartDeviceUtil.a(paramDeviceInfo));
          }
          label713:
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
          {
            paramDeviceInfo.setClassName(this.jdField_a_of_type_AndroidAppActivity, str);
            this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDeviceInfo);
            break label247;
          }
          if ((this.jdField_a_of_type_AndroidAppActivity instanceof ChatActivity)) {
            paramDeviceInfo.putExtra("bFromChatActivity", true);
          }
          SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), paramDeviceInfo, str, -1, null, SmartDevicePluginProxyActivity.class);
          break label247;
          label794:
          break;
          if (this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null)
          {
            if (!NetworkUtil.g(this.jdField_a_of_type_AndroidAppActivity))
            {
              ToastUtil.a().a(2131427731);
              if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
                break;
              }
              this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
              return;
            }
            this.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo = paramDeviceInfo;
            this.jdField_a_of_type_AndroidOsBundle = paramBundle;
            paramBundle = new ArrayList();
            paramBundle.add(Integer.valueOf(paramDeviceInfo.productId));
            a(paramBundle, bool);
            return;
          }
          ToastUtil.a().a(2131427730);
          if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          }
          if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
          return;
        }
        label935:
        str = null;
      }
    }
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    b();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return false;
    }
    Object localObject;
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
    {
      localObject = ((PluginBaseActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity();
      label30:
      if (localObject == null) {
        break label97;
      }
      localObject = new WebView((Context)localObject);
      if (Build.VERSION.SDK_INT >= 11)
      {
        ((WebView)localObject).removeJavascriptInterface("searchBoxJavaBridge_");
        ((WebView)localObject).removeJavascriptInterface("accessibility");
        ((WebView)localObject).removeJavascriptInterface("accessibilityTraversal");
      }
      if ((localObject == null) || (((WebView)localObject).getX5WebViewExtension() == null)) {
        break label99;
      }
    }
    label97:
    label99:
    for (boolean bool = true;; bool = false)
    {
      ((WebView)localObject).destroy();
      return bool;
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      break label30;
      break;
    }
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_AndroidAppActivity == null) || (this.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
        break label103;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131558448));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131427729);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
    while (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      LogUtility.d("LightAppUtil", "app == null when dologin");
      if (this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener != null) {
        this.jdField_a_of_type_ComTencentDeviceUtilsLightAppUtil$GetLightAppSettingListener.a(false);
      }
      return;
      label103:
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      ToastUtil.a().a(2131435631);
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.utils.LightAppUtil
 * JD-Core Version:    0.7.0.1
 */