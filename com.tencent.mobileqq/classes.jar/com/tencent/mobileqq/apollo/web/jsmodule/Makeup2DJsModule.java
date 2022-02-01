package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.store.ApolloStoreViewController;
import com.tencent.mobileqq.apollo.store.ApolloStoreViewController.PlayActionData;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import com.tencent.mobileqq.apollo.utils.RequestRoute;
import com.tencent.mobileqq.apollo.web.CmshowWebReqParam;
import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.CmStoreUserInfo;
import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.facedetect.GenderType;
import org.json.JSONArray;
import org.json.JSONObject;

public class Makeup2DJsModule
  extends BaseJsModule
{
  private boolean b = false;
  @NonNull
  private IApolloResManager c = ApolloResManagerFacade.a.a(Scene.WEB_STORE_OR_GAME);
  
  public Makeup2DJsModule(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    super(paramVasWebviewJsPlugin);
  }
  
  private void a(String paramString, int paramInt, ApolloJsPluginImpl.CmStoreUserInfo paramCmStoreUserInfo)
  {
    if (paramCmStoreUserInfo == null) {
      return;
    }
    this.b = true;
    a(paramCmStoreUserInfo);
    if (d().mRoleId <= 0) {
      d().mRoleId = b(d().mUserGender);
    }
    if (3 == paramInt) {}
    try
    {
      if ((d().mDressIds != null) && (d().mDressIds.length > 0))
      {
        localObject = new JSONObject();
        paramCmStoreUserInfo = new JSONArray();
        int[] arrayOfInt = d().mDressIds;
        int i = arrayOfInt.length;
        paramInt = 0;
        while (paramInt < i)
        {
          paramCmStoreUserInfo.put(Integer.valueOf(arrayOfInt[paramInt]));
          paramInt += 1;
        }
        ((JSONObject)localObject).put("dressIds", paramCmStoreUserInfo);
        a(paramString, (JSONObject)localObject);
        if (!QLog.isColorLevel()) {
          break label377;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("dressIds.array->");
        ((StringBuilder)localObject).append(paramCmStoreUserInfo);
        QLog.d("Makeup2DJsModule", 2, ((StringBuilder)localObject).toString());
        return;
      }
      a(paramString, HardCodeUtil.a(2131898700));
      if (!QLog.isColorLevel()) {
        break label377;
      }
      QLog.d("Makeup2DJsModule", 2, "dressIds.array->默认角色或获取本人信息失败");
      return;
    }
    catch (Exception paramCmStoreUserInfo)
    {
      Object localObject;
      break label302;
    }
    if (2 == paramInt)
    {
      if (d().mRoleId <= 0)
      {
        a(paramString, HardCodeUtil.a(2131898679));
        return;
      }
      paramCmStoreUserInfo = new JSONObject();
      paramCmStoreUserInfo.put("roleId", d().mRoleId);
      a(paramString, paramCmStoreUserInfo);
      return;
    }
    if (4 == paramInt)
    {
      paramCmStoreUserInfo = new JSONObject();
      paramCmStoreUserInfo.put("status", d().mApolloStatus);
      a(paramString, paramCmStoreUserInfo);
      return;
      label302:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleApolloGetApolloData error：");
      ((StringBuilder)localObject).append(paramCmStoreUserInfo.getMessage());
      QLog.e("Makeup2DJsModule", 1, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("获取数据失败");
      ((StringBuilder)localObject).append(paramCmStoreUserInfo.getMessage());
      a(paramString, ((StringBuilder)localObject).toString());
    }
    label377:
  }
  
  private boolean a(Context paramContext)
  {
    if (!SdCardUtil.hasStorageCard())
    {
      QQToast.makeText(paramContext, HardCodeUtil.a(2131898676), 0).show();
      return false;
    }
    return true;
  }
  
  private int b(int paramInt)
  {
    if ((paramInt != GenderType.FEMALE.value) && (paramInt != GenderType.DEFAULT.value)) {
      return GenderType.MALE.value;
    }
    return GenderType.FEMALE.value;
  }
  
  @RequestRoute(a="changeRole")
  private void changeRole(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    String str = paramCmshowWebReqParam.b;
    if (!a(paramCmshowWebReqParam.c))
    {
      a(str, "sdcard未装");
      return;
    }
    int j = localJSONObject.getInt("roleId");
    if (j > 0) {
      d().mRoleId = j;
    }
    paramCmshowWebReqParam = localJSONObject.optJSONArray("dressIds");
    if ((j > 0) && (paramCmshowWebReqParam != null) && (paramCmshowWebReqParam.length() > 0))
    {
      int k = paramCmshowWebReqParam.length();
      d().mDressIds = new int[k];
      int i = 0;
      while (i < k)
      {
        d().mDressIds[i] = paramCmshowWebReqParam.getInt(i);
        i += 1;
      }
      paramCmshowWebReqParam = localJSONObject.optString("userData");
      localJSONObject = new JSONObject(paramCmshowWebReqParam);
      d().mRoleGender = localJSONObject.optInt("sex");
      d().mRoleId = j;
      ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(j, d().mDressIds, 0, paramCmshowWebReqParam, new Makeup2DJsModule.1(this, str));
      return;
    }
    a(str, HardCodeUtil.a(2131898678));
  }
  
  @RequestRoute(a="addCustomAction")
  private void handleJsApiAddCustomAction(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    paramCmshowWebReqParam = paramCmshowWebReqParam.b;
    int i = localJSONObject.optInt("actionId");
    int j = localJSONObject.optInt("textType");
    String str = localJSONObject.optString("actionText");
    int k = localJSONObject.optInt("audioId");
    int m = localJSONObject.optInt("playOriginalAudio");
    float f = localJSONObject.optInt("audioStartTime");
    ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(i, str, j, k, m, f, new Makeup2DJsModule.8(this, paramCmshowWebReqParam));
    if (QLog.isColorLevel()) {
      QLog.d("Makeup2DJsModule", 2, "apolloJsPlugin call addCustomAction");
    }
  }
  
  @RequestRoute(a="delLocalFavAction")
  private void handleJsApiDelLocalFavAction(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    paramCmshowWebReqParam = paramCmshowWebReqParam.b;
    if (QLog.isColorLevel()) {
      QLog.d("Makeup2DJsModule", 2, "apolloJsPlugin call delLocalFavList");
    }
    ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(localJSONObject.optJSONArray("favActionDel"), new Makeup2DJsModule.9(this, paramCmshowWebReqParam));
  }
  
  @RequestRoute(a="getLocalFavAction")
  private void handleJsApiGetLocalFavAction(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    paramCmshowWebReqParam = paramCmshowWebReqParam.b;
    ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(new Makeup2DJsModule.7(this, paramCmshowWebReqParam));
  }
  
  @RequestRoute(a="getLocalInfo")
  private void handleJsApiGetLocalInfo(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject1 = paramCmshowWebReqParam.b;
    if (!this.b)
    {
      ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(new Makeup2DJsModule.5(this, (String)localObject1));
      return;
    }
    if ((d().mDressIds != null) && (d().mDressIds.length > 0))
    {
      JSONObject localJSONObject = new JSONObject();
      int i = 0;
      localJSONObject.put("result", 0);
      localJSONObject.put("msg", "");
      Object localObject2 = new JSONObject();
      paramCmshowWebReqParam = new JSONArray();
      int[] arrayOfInt = d().mDressIds;
      int j = arrayOfInt.length;
      while (i < j)
      {
        paramCmshowWebReqParam.put(Integer.valueOf(arrayOfInt[i]));
        i += 1;
      }
      ((JSONObject)localObject2).put("dressIds", paramCmshowWebReqParam);
      localJSONObject.put("data", localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("&&");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(localJSONObject.toString());
      ((StringBuilder)localObject2).append(");");
      super.d(((StringBuilder)localObject2).toString());
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("array->");
        ((StringBuilder)localObject1).append(paramCmshowWebReqParam);
        QLog.d("Makeup2DJsModule", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    a((String)localObject1, HardCodeUtil.a(2131898675));
    if (QLog.isColorLevel()) {
      QLog.d("Makeup2DJsModule", 2, "dressIds.array->默认角色或获取本人信息失败");
    }
  }
  
  @RequestRoute(a="getRoleId")
  private void handleJsApiGetRoleID(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject = paramCmshowWebReqParam.a;
    localObject = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    if (!this.b)
    {
      ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(new Makeup2DJsModule.6(this, (String)localObject));
      return;
    }
    paramCmshowWebReqParam = new JSONObject();
    int j = d().mRoleId;
    int i = j;
    if (j <= 0) {
      i = b(d().mUserGender);
    }
    paramCmshowWebReqParam.put("roleId", i);
    a((String)localObject, paramCmshowWebReqParam);
  }
  
  @RequestRoute(a="getSwitch")
  private void handleJsApiGetSwitch(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject1 = paramCmshowWebReqParam.a;
    localObject1 = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    if (!this.b)
    {
      ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(new Makeup2DJsModule.4(this, (String)localObject1));
      return;
    }
    paramCmshowWebReqParam = new JSONObject();
    paramCmshowWebReqParam.put("result", 0);
    paramCmshowWebReqParam.put("msg", "");
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("status", d().mApolloStatus);
    paramCmshowWebReqParam.put("data", localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("&&");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("(");
    ((StringBuilder)localObject2).append(paramCmshowWebReqParam.toString());
    ((StringBuilder)localObject2).append(");");
    super.d(((StringBuilder)localObject2).toString());
  }
  
  @RequestRoute(a="getUserInfo")
  private void handleJsApiGetUserInfo(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @RequestRoute(a="preview")
  private void handleJsApiPreview(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject = paramCmshowWebReqParam.a;
    String str = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    if (!a(paramCmshowWebReqParam))
    {
      a(str, "sdcard未装");
      return;
    }
    if (!(paramCmshowWebReqParam instanceof IApolloActivityJsCallBack))
    {
      a(str, HardCodeUtil.a(2131898690));
      return;
    }
    localObject = ((JSONObject)localObject).optJSONArray("dressIds");
    if ((localObject != null) && (((JSONArray)localObject).length() != 0))
    {
      int k = ((JSONArray)localObject).length();
      int[] arrayOfInt = new int[k];
      int j = 0;
      int i = 0;
      while (i < k)
      {
        arrayOfInt[i] = ((JSONArray)localObject).getInt(i);
        i += 1;
      }
      k = arrayOfInt.length;
      i = 0;
      while (i < k)
      {
        int m = arrayOfInt[i];
        if (!this.c.a(m))
        {
          i = j;
          break label166;
        }
        i += 1;
      }
      i = 1;
      label166:
      if (i != 0)
      {
        paramCmshowWebReqParam = ((IApolloActivityJsCallBack)paramCmshowWebReqParam).a(arrayOfInt);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("&&");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("(");
        ((StringBuilder)localObject).append(paramCmshowWebReqParam);
        ((StringBuilder)localObject).append(");");
        super.d(((StringBuilder)localObject).toString());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("callbackId->");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(" callbackOk");
          ((StringBuilder)localObject).append(paramCmshowWebReqParam);
          QLog.e("Makeup2DJsModule", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(arrayOfInt, new Makeup2DJsModule.3(this, paramCmshowWebReqParam, str));
      return;
    }
    a(str, "dressIds为空");
  }
  
  @RequestRoute(a="previewOnFrame")
  private void handleJsApiPreviewOnFrame(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject = paramCmshowWebReqParam.a;
    String str1 = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    if (!a(paramCmshowWebReqParam))
    {
      a(str1, "sdcard未装");
      return;
    }
    int i = ((JSONObject)localObject).optInt("actionId");
    int j = ((JSONObject)localObject).optInt("type");
    int k = ((JSONObject)localObject).optInt("isSpecial");
    String str2 = ((JSONObject)localObject).optString("title");
    String str3 = ((JSONObject)localObject).optString("subTitle");
    localObject = ((JSONObject)localObject).optString("apolloId", "me");
    ApolloStoreViewController.PlayActionData localPlayActionData = new ApolloStoreViewController.PlayActionData();
    localPlayActionData.activeId = i;
    localPlayActionData.actionType = j;
    localPlayActionData.floatPreview = k;
    localPlayActionData.title = str2;
    localPlayActionData.subTitle = str3;
    j = d().mRoleGender;
    i = 2;
    if (j == 2) {
      i = 1;
    }
    localPlayActionData.partnerRoleId = i;
    localPlayActionData.apolloId = ((String)localObject);
    ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(localPlayActionData, new Makeup2DJsModule.2(this, str1, paramCmshowWebReqParam));
  }
  
  @RequestRoute(a="refreshAction")
  private void handleJsApiRefreshAction(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a();
    if (QLog.isColorLevel()) {
      QLog.d("Makeup2DJsModule", 2, "apolloJsPlugin call refreshAction");
    }
  }
  
  @RequestRoute(a="removeBubble")
  private void handleJsApiRemoveBubble(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    long l = paramCmshowWebReqParam.a.optLong("bubbleId");
    ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(l);
  }
  
  @RequestRoute(a="sendActionToFrd")
  private void handleJsApiSendActionToFrd(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject = paramCmshowWebReqParam.a;
    int i = ((JSONObject)localObject).optInt("actionId", -1);
    int j = ((JSONObject)localObject).optInt("pkgId", -1);
    paramCmshowWebReqParam = ((JSONObject)localObject).optString("uin", "");
    int k = ((JSONObject)localObject).optInt("uinType", 0);
    if (QLog.isColorLevel()) {
      QLog.d("Makeup2DJsModule", 2, new Object[] { "apolloJsPlugin call sendActionToFrd, pkgId=", Integer.valueOf(j), ", actionId=", Integer.valueOf(i), ", uin=", paramCmshowWebReqParam });
    }
    localObject = new Bundle();
    ((Bundle)localObject).putInt("forward_type", 26);
    ((Bundle)localObject).putInt("apollo_actionid_key", i);
    ((Bundle)localObject).putInt("apollo_pkgid_key", j);
    if (!TextUtils.isEmpty(paramCmshowWebReqParam))
    {
      Intent localIntent = new Intent();
      String str = SplashActivity.class.getName();
      localIntent.setClassName(BaseApplicationImpl.getContext(), str);
      localIntent = AIOUtils.a(localIntent, new int[] { 1 });
      localIntent.putExtra("uin", paramCmshowWebReqParam);
      localIntent.putExtra("uintype", k);
      localIntent.putExtra("entrance", 0);
      localIntent.putExtra("apollo_forward_key", true);
      localIntent.putExtras((Bundle)localObject);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      return;
    }
    paramCmshowWebReqParam = new Intent(a().d().getApplicationContext(), ForwardRecentActivity.class);
    paramCmshowWebReqParam.addFlags(268435456);
    paramCmshowWebReqParam.addFlags(67108864);
    paramCmshowWebReqParam.putExtras((Bundle)localObject);
    a().d().startActivity(paramCmshowWebReqParam);
  }
  
  @RequestRoute(a="setApolloViewVisibility")
  private void handleJsApiSetApolloViewVisibility(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    String str = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    int i = localJSONObject.optInt("visibility", 0);
    if ((paramCmshowWebReqParam instanceof IApolloActivityJsCallBack))
    {
      ((IApolloActivityJsCallBack)paramCmshowWebReqParam).d(i);
      b(str);
      return;
    }
    if (c() == null)
    {
      a(str, "ApolloViewController is null");
      return;
    }
    c().b(i);
    b(str);
  }
  
  @RequestRoute(a="setup")
  private void handleJsApiSetup(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    String str = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    JSONArray localJSONArray = localJSONObject.optJSONArray("dressIds");
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      int j = localJSONArray.length();
      d().mDressIds = new int[j];
      int i = 0;
      while (i < j)
      {
        d().mDressIds[i] = localJSONArray.getInt(i);
        i += 1;
      }
    }
    if ((paramCmshowWebReqParam instanceof IApolloActivityJsCallBack))
    {
      d().mApolloStatus = 1;
      ((IApolloActivityJsCallBack)paramCmshowWebReqParam).a(d().mRoleId, d().mDressIds);
      b(str);
      paramCmshowWebReqParam = localJSONObject.optString("userData");
      ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(paramCmshowWebReqParam);
      return;
    }
    a(str, HardCodeUtil.a(2131898671));
  }
  
  @RequestRoute(a="previewAction")
  private void previewAction(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    handleJsApiPreviewOnFrame(paramCmshowWebReqParam);
  }
  
  @RequestRoute(a="sayHi")
  private void sayHi(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    String str = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    StringBuilder localStringBuilder;
    if ((paramCmshowWebReqParam instanceof IApolloActivityJsCallBack))
    {
      paramCmshowWebReqParam = ((IApolloActivityJsCallBack)paramCmshowWebReqParam).b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("&&");
      localStringBuilder.append(str);
      localStringBuilder.append("(");
      localStringBuilder.append(paramCmshowWebReqParam);
      localStringBuilder.append(");");
      super.d(localStringBuilder.toString());
      return;
    }
    if (c() != null)
    {
      paramCmshowWebReqParam = c().d();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("&&");
      localStringBuilder.append(str);
      localStringBuilder.append("(");
      localStringBuilder.append(paramCmshowWebReqParam);
      localStringBuilder.append(");");
      super.d(localStringBuilder.toString());
      return;
    }
    a(str, "ApolloViewController not inited or not ApolloStoreActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup2DJsModule
 * JD-Core Version:    0.7.0.1
 */