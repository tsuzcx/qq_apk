package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.cmsshow.api.CmShowAssetsData;
import com.tencent.aelight.camera.cmsshow.api.IAECMSShow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.CmShowLauncher;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.ipc.business.ICMResManager;
import com.tencent.mobileqq.apollo.ipc.business.ICm3DMakeup;
import com.tencent.mobileqq.apollo.utils.CmShowCECapabilitiesChecker;
import com.tencent.mobileqq.apollo.utils.RequestRoute;
import com.tencent.mobileqq.apollo.web.CmshowWebReqParam;
import com.tencent.mobileqq.apollo.web.IApolloJsCallBack;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class Makeup3DJsModule
  extends BaseJsModule
{
  private String b;
  private String c;
  
  public Makeup3DJsModule(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    super(paramVasWebviewJsPlugin);
  }
  
  private void a(String paramString)
  {
    if (CmShowWnsUtils.i())
    {
      a(paramString, "CrossEngine blacklist device");
      QLog.e("[cmshow]Makeup3DJsModule", 1, "CrossEngine blacklist device");
      return;
    }
    if (CmShowCECapabilitiesChecker.b())
    {
      b(paramString);
      return;
    }
    a(paramString, "not support CrossEngine");
    QLog.e("[cmshow]Makeup3DJsModule", 1, "not support CrossEngine");
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[notifyChange3DAvatarComponentResult] success :");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" message:");
    localStringBuilder.append(paramString);
    QLog.e("[cmshow]Makeup3DJsModule", 1, localStringBuilder.toString());
    if (TextUtils.isEmpty(this.b)) {
      return;
    }
    if (paramBoolean) {
      b(this.b);
    } else {
      a(this.b, paramString);
    }
    this.b = "";
  }
  
  private IApolloJsCallBack g()
  {
    WebViewFragment localWebViewFragment = b();
    if ((localWebViewFragment instanceof IApolloJsCallBack)) {
      return (IApolloJsCallBack)localWebViewFragment;
    }
    return null;
  }
  
  @RequestRoute(a="change3DAvatarComponent")
  private void handleCmShowChange3DAvatarComponent(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    QLog.d("[cmshow]Makeup3DJsModule", 1, "[handleCmShowChange3DAvatarComponent]");
    Object localObject = paramCmshowWebReqParam.a;
    String str1 = paramCmshowWebReqParam.b;
    Activity localActivity = paramCmshowWebReqParam.c;
    b(paramCmshowWebReqParam.d, paramCmshowWebReqParam.b);
    try
    {
      int i = ((JSONObject)localObject).optInt("type");
      localObject = ((JSONObject)localObject).optJSONObject("dressIds");
      if (localObject == null)
      {
        QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowChange3DAvatarComponent] get dressIds error");
        a(str1, "invalid params: dressId is null!");
        a(false, "invalid params: dressId is null!");
        return;
      }
      paramCmshowWebReqParam = new HashMap();
      Iterator localIterator = ((JSONObject)localObject).keys();
      if (localIterator == null)
      {
        QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowChange3DAvatarComponent] get dressIds keys error");
        a(str1, "invalid params: dressId is null!");
        a(false, "invalid params: dressId is null!");
        return;
      }
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        paramCmshowWebReqParam.put(Integer.valueOf(((JSONObject)localObject).optInt(str2)), str2);
      }
      if (paramCmshowWebReqParam.size() == 0)
      {
        QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowChange3DAvatarComponent] invalid params: dressId is null!");
        a(str1, "invalid params: dressId is null!");
        a(false, "invalid params: dressId is null!");
        return;
      }
      localObject = new ArrayList(paramCmshowWebReqParam.keySet());
      long l = System.currentTimeMillis();
      ((ICMResManager)ApolloIPCModule.a(ICMResManager.class)).a((ArrayList)localObject, 1, new Makeup3DJsModule.2(this, l, (ArrayList)localObject, str1, localActivity, i, paramCmshowWebReqParam));
      return;
    }
    catch (Throwable paramCmshowWebReqParam)
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowChange3DAvatarComponent] error! ", paramCmshowWebReqParam);
      a(str1, paramCmshowWebReqParam.getMessage());
      a(false, paramCmshowWebReqParam.getMessage());
    }
  }
  
  @RequestRoute(a="get3DFace")
  private void handleCmShowGet3DFace(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    QLog.d("[cmshow]Makeup3DJsModule", 1, "[handleCmShowGet3DFace]");
    Object localObject = paramCmshowWebReqParam.a;
    String str1 = paramCmshowWebReqParam.b;
    b(paramCmshowWebReqParam.d, paramCmshowWebReqParam.b);
    paramCmshowWebReqParam = g();
    if (paramCmshowWebReqParam == null)
    {
      a(str1, "No attached UI callback to handle this method!");
      return;
    }
    paramCmshowWebReqParam = paramCmshowWebReqParam.c();
    if (paramCmshowWebReqParam != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!TextUtils.isEmpty(paramCmshowWebReqParam.c))
        {
          paramCmshowWebReqParam = new JSONObject(paramCmshowWebReqParam.c);
          JSONObject localJSONObject1 = new JSONObject();
          localObject = ((JSONObject)localObject).optJSONArray("keys");
          if (localObject != null)
          {
            i = 0;
            int j = ((JSONArray)localObject).length();
            if (i < j)
            {
              String str2 = ((JSONArray)localObject).optString(i);
              if (TextUtils.isEmpty(str2)) {
                break label199;
              }
              JSONObject localJSONObject2 = paramCmshowWebReqParam.optJSONObject(str2);
              if (localJSONObject2 == null) {
                break label199;
              }
              localJSONObject1.put(str2, localJSONObject2);
              break label199;
            }
          }
          a(str1, localJSONObject1);
        }
        else
        {
          a(str1, "face data is empty!");
          QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowGet3DFace] face data is empty! ");
          return;
        }
      }
      catch (Exception paramCmshowWebReqParam)
      {
        a(str1, paramCmshowWebReqParam.getMessage());
        return;
      }
      label199:
      i += 1;
    }
  }
  
  @RequestRoute(a="get3DFaceFull")
  private void handleCmShowGet3DFaceFull(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    QLog.d("[cmshow]Makeup3DJsModule", 1, "[handleCmShowGet3DFaceFull]");
    String str = paramCmshowWebReqParam.b;
    b(paramCmshowWebReqParam.d, paramCmshowWebReqParam.b);
    paramCmshowWebReqParam = g();
    if (paramCmshowWebReqParam == null)
    {
      a(str, "No attached UI callback to handle this method!");
      return;
    }
    paramCmshowWebReqParam = paramCmshowWebReqParam.c();
    if (paramCmshowWebReqParam != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramCmshowWebReqParam.c))
      {
        a(str, new JSONObject(paramCmshowWebReqParam.c));
        return;
      }
      a(str, "face data is empty!");
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowGet3DFaceFull] face data is empty! ");
      return;
    }
    catch (Exception paramCmshowWebReqParam)
    {
      a(str, paramCmshowWebReqParam.getMessage());
    }
  }
  
  @RequestRoute(a="getAll3DAvatarComponent")
  private void handleCmShowGetAll3DAvatarComponent(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    QLog.d("[cmshow]Makeup3DJsModule", 1, "[handleCmShowGetAll3DAvatarComponent]");
    Object localObject1 = paramCmshowWebReqParam.a;
    localObject1 = paramCmshowWebReqParam.b;
    b(paramCmshowWebReqParam.d, paramCmshowWebReqParam.b);
    try
    {
      paramCmshowWebReqParam = g();
      if (paramCmshowWebReqParam == null)
      {
        a((String)localObject1, "No attached UI callback to handle this method!");
        return;
      }
      Object localObject2 = paramCmshowWebReqParam.c();
      if ((localObject2 != null) && (((CmShowAssetsData)localObject2).b == null))
      {
        paramCmshowWebReqParam = new JSONArray();
        localObject2 = ((CmShowAssetsData)localObject2).b.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          paramCmshowWebReqParam.put(Integer.parseInt(str.substring(str.lastIndexOf(File.separator))));
        }
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("dressIds", paramCmshowWebReqParam);
        a((String)localObject1, (JSONObject)localObject2);
        return;
      }
      a((String)localObject1, "dress map is empty");
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowGetAll3DAvatarComponent] dress map is empty");
      return;
    }
    catch (Throwable paramCmshowWebReqParam)
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowGetAll3DAvatarComponent] error! ", paramCmshowWebReqParam);
      a((String)localObject1, paramCmshowWebReqParam.getMessage());
    }
  }
  
  @RequestRoute(a="init3DAvatar")
  private void handleCmShowInit3DAvatar(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject1 = paramCmshowWebReqParam.a;
    String str1 = paramCmshowWebReqParam.b;
    b(paramCmshowWebReqParam.d, paramCmshowWebReqParam.b);
    QLog.d("[cmshow]Makeup3DJsModule", 1, "[handleCmShowInit3DAvatar]");
    try
    {
      paramCmshowWebReqParam = ((JSONObject)localObject1).optString("faceDataUrl");
      Object localObject2 = ((JSONObject)localObject1).optJSONObject("dressIds");
      if ((localObject2 != null) && (!TextUtils.isEmpty(paramCmshowWebReqParam)))
      {
        localObject1 = new HashMap();
        Iterator localIterator = ((JSONObject)localObject2).keys();
        if (localIterator == null)
        {
          QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowInit3DAvatar] dressIds keys is null!");
          a(str1, "invalid params!");
          return;
        }
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          ((Map)localObject1).put(Integer.valueOf(((JSONObject)localObject2).optInt(str2)), str2);
        }
        if (((Map)localObject1).size() == 0)
        {
          QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowInit3DAvatar] invalid params!");
          a(str1, "invalid params!");
          return;
        }
        localObject2 = new ArrayList(((Map)localObject1).keySet());
        ((ICMResManager)ApolloIPCModule.a(ICMResManager.class)).a((ArrayList)localObject2, 1, new Makeup3DJsModule.1(this, (Map)localObject1, paramCmshowWebReqParam, str1));
        return;
      }
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowInit3DAvatar] invalid params!");
      a(str1, "invalid params!");
      return;
    }
    catch (Throwable paramCmshowWebReqParam)
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowInit3DAvatar] error! ", paramCmshowWebReqParam);
      a(str1, paramCmshowWebReqParam.getMessage());
    }
  }
  
  @RequestRoute(a="load3DFaceDress")
  private void handleCmShowLoad3DFaceDress(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    QLog.d("[cmshow]Makeup3DJsModule", 1, "[handleCmShowLoad3DFaceDress]");
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    String str = paramCmshowWebReqParam.b;
    b(paramCmshowWebReqParam.d, paramCmshowWebReqParam.b);
    int i = localJSONObject.optInt("dressId");
    if (i <= 0)
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleCmShowLoad3DFaceDress] invalid params: dressId is null!");
      a(str, "invalid params: dressId is null!");
      return;
    }
    paramCmshowWebReqParam = new ArrayList(1);
    paramCmshowWebReqParam.add(Integer.valueOf(i));
    ((ICMResManager)ApolloIPCModule.a(ICMResManager.class)).a(paramCmshowWebReqParam, 1, new Makeup3DJsModule.3(this, str, i));
  }
  
  @RequestRoute(a="set3DFace")
  private void handleCmShowSet3DFace(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    QLog.d("[cmshow]Makeup3DJsModule", 1, "[handleCmShowSet3DFace]");
    String str = paramCmshowWebReqParam.b;
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    b(paramCmshowWebReqParam.d, paramCmshowWebReqParam.b);
    paramCmshowWebReqParam = g();
    if (paramCmshowWebReqParam == null)
    {
      a(str, "No attached UI callback to handle this method!");
      return;
    }
    CmShowAssetsData localCmShowAssetsData = new CmShowAssetsData();
    localCmShowAssetsData.c = localJSONObject.toString();
    paramCmshowWebReqParam.a(localCmShowAssetsData, 1);
    b(str);
  }
  
  @RequestRoute(a="set3DFaceFull")
  private void handleCmShowSet3DFaceFull(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    QLog.d("[cmshow]Makeup3DJsModule", 1, "[handleCmShowSet3DFaceFull]");
    String str = paramCmshowWebReqParam.b;
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    b(paramCmshowWebReqParam.d, paramCmshowWebReqParam.b);
    paramCmshowWebReqParam = g();
    if (paramCmshowWebReqParam == null)
    {
      a(str, "No attached UI callback to handle this method!");
      return;
    }
    CmShowAssetsData localCmShowAssetsData = new CmShowAssetsData();
    localCmShowAssetsData.c = localJSONObject.toString();
    paramCmshowWebReqParam.a(localCmShowAssetsData, 0);
    b(str);
  }
  
  @RequestRoute(a="set3DModeType")
  private void handleCmShowSet3DModeType(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    QLog.d("[cmshow]Makeup3DJsModule", 1, "[handleCmShowSet3DModeType]");
    String str = paramCmshowWebReqParam.b;
    Object localObject = paramCmshowWebReqParam.a;
    b(paramCmshowWebReqParam.d, paramCmshowWebReqParam.b);
    paramCmshowWebReqParam = g();
    if (paramCmshowWebReqParam != null)
    {
      localObject = ((JSONObject)localObject).optString("modeType");
      if ("face".equals(localObject))
      {
        paramCmshowWebReqParam.a(1);
        b(str);
        return;
      }
      if ("decorate".equals(localObject))
      {
        paramCmshowWebReqParam.a(0);
        b(str);
        return;
      }
      a(str, "invalid params!");
      return;
    }
    a(str, "No attached UI callback to handle this method!");
  }
  
  @RequestRoute(a="is3DDressLoaded")
  private void handleIs3DDressLoaded(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    paramCmshowWebReqParam = paramCmshowWebReqParam.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleIs3DDressLoaded] callbackId :");
    localStringBuilder.append(paramCmshowWebReqParam);
    QLog.e("[cmshow]Makeup3DJsModule", 1, localStringBuilder.toString());
    this.b = paramCmshowWebReqParam;
  }
  
  @RequestRoute(a="open3DDressUpPage")
  private void handleOpen3DDressUpPage(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    String str = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.a;
    if (paramCmshowWebReqParam != null) {
      paramCmshowWebReqParam = paramCmshowWebReqParam.optString("url");
    } else {
      paramCmshowWebReqParam = null;
    }
    CmShowLauncher.a(BaseApplicationImpl.getContext(), paramCmshowWebReqParam, null);
  }
  
  @RequestRoute(a="open3DFaceRecognition")
  private void handleOpenCmShowFaceCamera(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    QLog.d("[cmshow]Makeup3DJsModule", 1, "[handleOpenCmShowFaceCamera]");
    String str = paramCmshowWebReqParam.b;
    Activity localActivity = paramCmshowWebReqParam.c;
    b(paramCmshowWebReqParam.d, paramCmshowWebReqParam.b);
    this.c = str;
    CmShowLauncher.a(localActivity);
  }
  
  @RequestRoute(a="save3DFace")
  private void handleSave3DFaceData(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    QLog.d("[cmshow]Makeup3DJsModule", 1, "[handleSave3DFaceData]");
    String str = paramCmshowWebReqParam.b;
    Object localObject = paramCmshowWebReqParam.a;
    b(paramCmshowWebReqParam.d, paramCmshowWebReqParam.b);
    paramCmshowWebReqParam = new Bundle();
    paramCmshowWebReqParam.clear();
    localObject = ((JSONObject)localObject).optString("data");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, "[handleSave3DFaceData] get face data fail! ");
      a(str, "face data is empty!");
      return;
    }
    paramCmshowWebReqParam.putString("apollo_face3DData", (String)localObject);
    ((ICm3DMakeup)ApolloIPCModule.a(ICm3DMakeup.class)).a((String)localObject, new Makeup3DJsModule.4(this, str));
  }
  
  @RequestRoute(a="supportAEKit")
  private void handleSupportAekit(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    String str = paramCmshowWebReqParam.b;
    b(paramCmshowWebReqParam.d, paramCmshowWebReqParam.b);
    if (CMShowPlatform.a.b(Scene.MAKE_UP_3D))
    {
      a(str);
      return;
    }
    if (CmShowWnsUtils.h())
    {
      a(str, "AEKit blacklist device");
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]Makeup3DJsModule", 1, "AEKit blacklist device");
      }
    }
    else
    {
      if (((IAECMSShow)QRoute.api(IAECMSShow.class)).isCMShowSupported())
      {
        b(str);
        return;
      }
      a(str, "not supportAEKit");
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]Makeup3DJsModule", 1, "not supportAEKit");
      }
    }
  }
  
  public void a(int paramInt, @NonNull String paramString1, @NonNull String paramString2)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("result", paramInt);
      localJSONObject1.put("msg", "");
      if (paramInt == 0)
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("dressMap", new JSONObject(paramString1));
        localJSONObject2.put("face", paramString2);
        a(this.c, localJSONObject2);
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("callbackId->");
          paramString1.append(this.c);
          paramString1.append(" callbackOk");
          paramString1.append(localJSONObject1.toString());
          QLog.d("[cmshow]Makeup3DJsModule", 2, paramString1.toString());
          return;
        }
      }
    }
    catch (Exception paramString1)
    {
      QLog.e("[cmshow]Makeup3DJsModule", 1, paramString1.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup3DJsModule
 * JD-Core Version:    0.7.0.1
 */