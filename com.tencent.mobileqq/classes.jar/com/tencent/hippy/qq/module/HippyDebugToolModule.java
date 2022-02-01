package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.hippy.qq.utils.HippyDebugUtil;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@HippyNativeModule(name="DebugTool")
public class HippyDebugToolModule
  extends HippyNativeModuleBase
{
  static final String CLASSNAME = "DebugTool";
  
  public HippyDebugToolModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="deleteModule")
  public void deleteModule(String paramString, Promise paramPromise)
  {
    try
    {
      paramString = new JSONObject(paramString);
      paramPromise.resolve(Boolean.valueOf(HippyDebugUtil.deleteModule(paramString.optString("moduleName"), Integer.parseInt(paramString.optString("version")))));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramPromise.reject("error");
    }
  }
  
  @HippyMethod(name="enableDebugModule")
  public void enableDebugModule(String paramString, Promise paramPromise)
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          bool = true;
          HippyDebugUtil.enableDebug(bool);
          HippyDebugUtil.enableDebugModule(paramString);
          paramPromise.resolve("success");
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramPromise.reject("error");
        return;
      }
      boolean bool = false;
    }
  }
  
  @HippyMethod(name="enableDebugPort")
  public void enableDebugPort(String paramString, Promise paramPromise)
  {
    try
    {
      HippyDebugUtil.enableDebugPort(paramString);
      paramPromise.resolve("success");
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramPromise.reject("error");
    }
  }
  
  @HippyMethod(name="getDebugModule")
  public void getDebugModule(Promise paramPromise)
  {
    try
    {
      String str1 = HippyDebugUtil.getHippyBundleName();
      String str2 = HippyDebugUtil.getHippyServerHost();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("module", str1);
      localJSONObject.put("server", str2);
      paramPromise.resolve(localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramPromise.reject("error");
    }
  }
  
  @HippyMethod(name="getLibraryVersions")
  public void getLibraryVersions(Promise paramPromise)
  {
    try
    {
      Object localObject = HippyDebugUtil.getLibraryVersions();
      HippyMap localHippyMap = new HippyMap();
      localObject = ((HashMap)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localHippyMap.pushString((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      paramPromise.resolve(localHippyMap);
      return;
    }
    catch (Exception localException)
    {
      label77:
      break label77;
    }
    paramPromise.reject("error");
  }
  
  @HippyMethod(name="getModuleInfo")
  public void getModuleInfo(String paramString, Promise paramPromise)
  {
    try
    {
      paramPromise.resolve(HippyDebugUtil.getModuleInfo(paramString).toString());
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      paramPromise.reject("error");
    }
  }
  
  @HippyMethod(name="getModules")
  public void getModules(Promise paramPromise)
  {
    try
    {
      paramPromise.resolve(HippyDebugUtil.getHippyModules().toString());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      paramPromise.reject("error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.HippyDebugToolModule
 * JD-Core Version:    0.7.0.1
 */