package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.ipc.business.ICmShowAvatar;
import com.tencent.mobileqq.apollo.web.CmshowWebReqParam;
import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.AvatarInfo;
import com.tencent.mobileqq.emosm.web.RequestRoute;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PendantAvatarJsModule
  extends BaseJsModule
{
  private int a;
  public Map<String, ApolloJsPluginImpl.AvatarInfo> a;
  
  public PendantAvatarJsModule(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    super(paramVasWebviewJsPlugin);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Int = ((int)CmShowWnsUtils.a());
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    ((ICmShowAvatar)ApolloIPCModule.a(ICmShowAvatar.class)).a(a().a().getCurrentUin(), paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, new PendantAvatarJsModule.2(this, paramInt3, paramInt4));
  }
  
  private void a(JSONObject paramJSONObject)
  {
    if ((a() != null) && (a().a() != null))
    {
      CustomWebView localCustomWebView = a().a();
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("callbackAvatarImage ");
        localStringBuilder.append(paramJSONObject.toString());
        QLog.d("[cmshow]AvatarJsModule", 2, localStringBuilder.toString());
      }
      if (localCustomWebView != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:mqq.dispatchEvent(\"onLoadAvatarImageEvent\",");
        localStringBuilder.append(paramJSONObject.toString());
        localStringBuilder.append(")");
        localCustomWebView.callJs(localStringBuilder.toString());
      }
    }
  }
  
  private void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = new Intent("ACTION_NEWER_GUIDE_CMSHOW_AVATAR_RESULT");
    ((Intent)localObject1).putExtra("path", paramString);
    Object localObject2 = a();
    if (localObject2 != null)
    {
      localObject2 = ((WebViewPlugin.PluginRuntime)localObject2).a();
      if (localObject2 != null)
      {
        ((Activity)localObject2).sendBroadcast((Intent)localObject1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("broadcastToSetAvatar ");
        ((StringBuilder)localObject1).append(paramString);
        QLog.i("[cmshow]AvatarJsModule", 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  @RequestRoute(a="getAvatarImages")
  private void handleGetAvatarImages(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject1 = paramCmshowWebReqParam.jdField_a_of_type_OrgJsonJSONObject;
    paramCmshowWebReqParam = paramCmshowWebReqParam.jdField_a_of_type_JavaLangString;
    if (localJSONObject1 == null)
    {
      QLog.e("[cmshow]AvatarJsModule", 1, "handleGetAvatarImages with json null");
      return;
    }
    for (;;)
    {
      try
      {
        JSONArray localJSONArray = localJSONObject1.getJSONArray("actions");
        int i = 0;
        if (i < localJSONArray.length())
        {
          JSONObject localJSONObject2 = (JSONObject)localJSONArray.get(i);
          int k = localJSONObject2.getInt("actionId");
          String str = localJSONObject2.getString("actionType");
          if (!TextUtils.isEmpty(str))
          {
            j = Integer.parseInt(str);
            a(k, j, localJSONObject2.getInt("isDynamic"), localJSONObject2.getInt("type"), this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
            i += 1;
          }
        }
        else
        {
          a(paramCmshowWebReqParam, 0, "get avatar list succeed");
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]AvatarJsModule", 1, new Object[] { "handleGetAvatarImages exception", localJSONObject1.toString(), localException });
        a(paramCmshowWebReqParam, "params parse error");
        return;
      }
      int j = 0;
    }
  }
  
  @RequestRoute(a="setSpriteAvatar")
  private void handleSetAvatar(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject = paramCmshowWebReqParam.jdField_a_of_type_OrgJsonJSONObject;
    paramCmshowWebReqParam = paramCmshowWebReqParam.jdField_a_of_type_JavaLangString;
    if (localJSONObject == null)
    {
      QLog.e("[cmshow]AvatarJsModule", 1, "handleSetSpriteAvatar with json null");
      a(paramCmshowWebReqParam, "params parse error");
      return;
    }
    for (;;)
    {
      try
      {
        int j = localJSONObject.getInt("actionId");
        int k = localJSONObject.getInt("isDynamic");
        localJSONObject.getInt("type");
        String str = localJSONObject.getString("actionType");
        if (!TextUtils.isEmpty(str))
        {
          i = Integer.parseInt(str);
          ((ICmShowAvatar)ApolloIPCModule.a(ICmShowAvatar.class)).a(a().a().getCurrentUin(), j, i, k, new PendantAvatarJsModule.1(this, paramCmshowWebReqParam));
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("[cmshow]AvatarJsModule", 1, new Object[] { "handleSetSpriteAvatar exception", localJSONObject.toString(), localJSONException });
        a(paramCmshowWebReqParam, "params parse error");
        return;
      }
      int i = 0;
    }
  }
  
  public void a(@NonNull String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("actionId", paramInt1);
      localJSONObject.put("isDynamic", paramInt2);
      localJSONObject.put("type", paramInt3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://cmshow.qq.com/qq_cms_avatar/");
      localStringBuilder.append(paramString);
      localJSONObject.put("img", localStringBuilder.toString());
      a(localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("[cmshow]AvatarJsModule", 1, new Object[] { "callbackRecordAction exception ", Integer.valueOf(paramInt1), paramString });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.PendantAvatarJsModule
 * JD-Core Version:    0.7.0.1
 */