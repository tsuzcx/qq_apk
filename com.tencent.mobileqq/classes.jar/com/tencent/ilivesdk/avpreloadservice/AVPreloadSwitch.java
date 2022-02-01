package com.tencent.ilivesdk.avpreloadservice;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceAdapter;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface.AVPreloadScenes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AVPreloadSwitch
  implements ThreadCenter.HandlerKeyable
{
  private static final List<AVPreloadSwitch.SwitchConfig> b = new ArrayList();
  private AppGeneralInfoService jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService;
  private HttpInterface jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface;
  private LogInterface jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface;
  private AVPreloadSwitch.AVPreloadSwitchListener jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadSwitch$AVPreloadSwitchListener;
  private AVPreloadServiceAdapter jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceAdapter;
  private String jdField_a_of_type_JavaLangString = "";
  private List<AVPreloadSwitch.SwitchConfig> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  static
  {
    AVPreloadSwitch.SwitchConfig localSwitchConfig = new AVPreloadSwitch.SwitchConfig();
    localSwitchConfig.jdField_a_of_type_JavaLangString = "switch_room";
    localSwitchConfig.jdField_a_of_type_Boolean = true;
    localSwitchConfig.jdField_b_of_type_Boolean = true;
    localSwitchConfig.jdField_c_of_type_Boolean = true;
    localSwitchConfig.d = false;
    localSwitchConfig.jdField_a_of_type_Int = 3;
    localSwitchConfig.jdField_b_of_type_Int = 2;
    localSwitchConfig.jdField_c_of_type_Int = 5;
    b.add(localSwitchConfig);
    localSwitchConfig = new AVPreloadSwitch.SwitchConfig();
    localSwitchConfig.jdField_a_of_type_JavaLangString = "clicked_enter_room";
    localSwitchConfig.jdField_a_of_type_Boolean = true;
    localSwitchConfig.jdField_b_of_type_Boolean = false;
    localSwitchConfig.jdField_c_of_type_Boolean = true;
    localSwitchConfig.d = false;
    localSwitchConfig.jdField_a_of_type_Int = 3;
    localSwitchConfig.jdField_b_of_type_Int = 2;
    localSwitchConfig.jdField_c_of_type_Int = 5;
    b.add(localSwitchConfig);
  }
  
  private AVPreloadSwitch.SwitchConfig a(JSONObject paramJSONObject)
  {
    AVPreloadSwitch.SwitchConfig localSwitchConfig = new AVPreloadSwitch.SwitchConfig();
    localSwitchConfig.jdField_a_of_type_JavaLangString = paramJSONObject.optString("scene");
    int i = paramJSONObject.optInt("preload_enable");
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localSwitchConfig.jdField_a_of_type_Boolean = bool1;
    if (paramJSONObject.optInt("mobile_enable") == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localSwitchConfig.jdField_b_of_type_Boolean = bool1;
    if (paramJSONObject.optInt("screen_shot_enable") == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localSwitchConfig.jdField_c_of_type_Boolean = bool1;
    if (paramJSONObject.optInt("frame_seek_enable") == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localSwitchConfig.d = bool1;
    localSwitchConfig.jdField_a_of_type_Int = paramJSONObject.optInt("max_cache_size");
    localSwitchConfig.jdField_b_of_type_Int = paramJSONObject.optInt("max_download_count");
    localSwitchConfig.jdField_c_of_type_Int = paramJSONObject.optInt("max_refresh_count");
    localSwitchConfig.jdField_b_of_type_JavaLangString = paramJSONObject.optString("frame_seek_domain");
    boolean bool1 = bool2;
    if (paramJSONObject.optInt("dispatch_enable") == 1) {
      bool1 = true;
    }
    localSwitchConfig.e = bool1;
    localSwitchConfig.jdField_c_of_type_JavaLangString = paramJSONObject.optString("dispatch_domain");
    return localSwitchConfig;
  }
  
  private String a(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes)
  {
    int i = AVPreloadSwitch.3.a[paramAVPreloadScenes.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return "unknown";
      }
      return "clicked_enter_room";
    }
    return "switch_room";
  }
  
  private void a(AVPreloadSwitch.OnCgiResponse paramOnCgiResponse)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("client_type", this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService.getClientType());
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("preload_switch_android");
      localJSONObject1.put("config_key", localJSONArray);
      localJSONObject1.put("flag", 0);
      localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("client_identified_name", "version_code");
      localJSONObject2.put("client_identified_value", String.valueOf(this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService.getVersionCode()));
      localJSONArray.put(localJSONObject2);
      localJSONObject2 = new JSONObject();
      String[] arrayOfString = this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService.getVersionName().split("\\.");
      Object localObject = new StringBuffer();
      try
      {
        ((StringBuffer)localObject).append(arrayOfString[0]);
        int i = arrayOfString[1].length();
        StringBuilder localStringBuilder;
        if (i == 1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("0");
          localStringBuilder.append(arrayOfString[1]);
          ((StringBuffer)localObject).append(localStringBuilder.toString());
        }
        else
        {
          ((StringBuffer)localObject).append(arrayOfString[1]);
        }
        if (arrayOfString[2].length() == 1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("0");
          localStringBuilder.append(arrayOfString[2]);
          ((StringBuffer)localObject).append(localStringBuilder.toString());
        }
        else
        {
          ((StringBuffer)localObject).append(arrayOfString[2]);
        }
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.printException(localException);
      }
      localObject = ((StringBuffer)localObject).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localJSONObject2.put("client_identified_name", "build_version");
        localJSONObject2.put("client_identified_value", localObject);
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("client_identified_name", "guid");
      localJSONObject2.put("client_identified_value", this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService.getGuid());
      localJSONArray.put(localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("client_identified_name", "os_level");
      localJSONObject2.put("client_identified_value", String.valueOf(Build.VERSION.SDK_INT));
      localJSONArray.put(localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("client_identified_name", "model");
      localJSONObject2.put("client_identified_value", String.valueOf(Build.MODEL));
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("client_infos", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.printException(localJSONException);
    }
    String str;
    if (this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService.isSvrTestEnv()) {
      str = "https://test.ilive.qq.com/cgi-bin/general/platform_config/pull_config";
    } else {
      str = "https://ilive.qq.com/cgi-bin/general/platform_config/pull_config";
    }
    ThreadCenter.postLogicTask(new AVPreloadSwitch.2(this, str, localJSONObject1, paramOnCgiResponse), "fetch_preload_switch");
  }
  
  private boolean a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      int i = 0;
      try
      {
        while (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null) {
            this.jdField_a_of_type_JavaUtilList.add(a(localJSONObject));
          }
          i += 1;
        }
        return true;
      }
      catch (Exception paramJSONArray)
      {
        this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.printException(paramJSONArray);
        return false;
      }
    }
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface.e("AVPreloadSwitch", "switchConfig is empty return", new Object[0]);
    return false;
  }
  
  public AVPreloadSwitch.SwitchConfig a(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      AVPreloadSwitch.SwitchConfig localSwitchConfig = (AVPreloadSwitch.SwitchConfig)localIterator.next();
      if ((localSwitchConfig != null) && (a(paramAVPreloadScenes).equalsIgnoreCase(localSwitchConfig.jdField_a_of_type_JavaLangString))) {
        return localSwitchConfig;
      }
    }
    return b(paramAVPreloadScenes);
  }
  
  public List<AVPreloadSwitch.SwitchConfig> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    a(new AVPreloadSwitch.1(this));
  }
  
  public void a(AVPreloadSwitch.AVPreloadSwitchListener paramAVPreloadSwitchListener)
  {
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadserviceAVPreloadSwitch$AVPreloadSwitchListener = paramAVPreloadSwitchListener;
  }
  
  public void a(AVPreloadServiceAdapter paramAVPreloadServiceAdapter)
  {
    if (paramAVPreloadServiceAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentIlivesdkAvpreloadservice_interfaceAVPreloadServiceAdapter = paramAVPreloadServiceAdapter;
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiHttpHttpInterface = paramAVPreloadServiceAdapter.a();
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService = paramAVPreloadServiceAdapter.a();
    this.jdField_a_of_type_ComTencentFalcoBaseLibapiLogLogInterface = paramAVPreloadServiceAdapter.a();
  }
  
  public boolean a(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes)
  {
    paramAVPreloadScenes = a(paramAVPreloadScenes);
    if (paramAVPreloadScenes == null) {
      return false;
    }
    if (!paramAVPreloadScenes.jdField_a_of_type_Boolean) {
      return false;
    }
    if (paramAVPreloadScenes.jdField_b_of_type_Boolean) {
      return true;
    }
    return NetworkUtil.isWiFi(this.jdField_a_of_type_ComTencentFalcoBaseLibapiGeneralinfoAppGeneralInfoService.getApplication());
  }
  
  public AVPreloadSwitch.SwitchConfig b(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes)
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      AVPreloadSwitch.SwitchConfig localSwitchConfig = (AVPreloadSwitch.SwitchConfig)localIterator.next();
      if ((localSwitchConfig != null) && (a(paramAVPreloadScenes).equalsIgnoreCase(localSwitchConfig.jdField_a_of_type_JavaLangString))) {
        return localSwitchConfig;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadSwitch
 * JD-Core Version:    0.7.0.1
 */