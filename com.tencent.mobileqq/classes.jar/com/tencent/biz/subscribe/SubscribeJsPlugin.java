package com.tencent.biz.subscribe;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.biz.subscribe.utils.SubscribeFollowUserUtil;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.armap.FaceObserver;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SubscribeJsPlugin
  extends WebViewPlugin
  implements FaceObserver
{
  private INonMainProcAvatarLoader a;
  private TroopMemberApiClient b;
  
  private void a(String paramString)
  {
    paramString = new SubscribeJsPlugin.SafeJsonObject(this, paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("code", paramString.optString("code"));
    localBundle.putString("location", paramString.optString("location"));
    if (this.b == null)
    {
      this.b = TroopMemberApiClient.a();
      this.b.e();
    }
    this.b.d(localBundle);
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    ThreadManager.post(new SubscribeJsPlugin.3(this, paramBitmap, paramString), 8, null, false);
  }
  
  private void a(String paramString, String[] paramArrayOfString)
  {
    if ("opendetail".equals(paramString))
    {
      if (!a(paramArrayOfString)) {
        return;
      }
      paramString = new SubscribeJsPlugin.SafeJsonObject(this, paramArrayOfString[0]);
      QLog.d(this.mTAG, 2, paramString.toString());
      if ((this.mRuntime != null) && ((this.mRuntime.f() instanceof SubscribeHybirdFragment)))
      {
        ((SubscribeHybirdFragment)this.mRuntime.f()).a(SubscribeLaucher.a(paramString.getString("feedid"), paramString.getString("uin"), paramString.getInt("type"), paramString.getInt("width"), paramString.getInt("height"), Long.valueOf(paramString.getString("createtime")).longValue()));
        return;
      }
      if ((this.mRuntime != null) && (this.mRuntime.d() != null)) {
        SubscribeLaucher.a(null, SubscribeLaucher.a(paramString.getString("feedid"), paramString.getString("uin"), paramString.getInt("type"), paramString.getInt("width"), paramString.getInt("height"), Long.valueOf(paramString.getString("createtime")).longValue()));
      }
    }
    else if ("sharepersonalpage".equals(paramString))
    {
      if (!a(paramArrayOfString)) {
        return;
      }
      paramString = new SubscribeJsPlugin.SafeJsonObject(this, paramArrayOfString[0]);
      if ((this.mRuntime != null) && ((this.mRuntime.f() instanceof SubscribeHybirdFragment)))
      {
        QLog.d(this.mTAG, 2, paramString.toString());
        ((SubscribeHybirdFragment)this.mRuntime.f()).a(paramString.getString("uin"), paramString.getString("nickname"), paramString.getString("icon"), paramString.getString("desc"), paramString.getString("usertype"));
      }
    }
    else if ("reloadmainpage".equals(paramString))
    {
      if ((this.mRuntime != null) && ((this.mRuntime.f() instanceof SubscribeHybirdFragment))) {
        ((SubscribeHybirdFragment)this.mRuntime.f()).a();
      }
    }
    else if ("openpublishpage".equals(paramString))
    {
      if (!a(paramArrayOfString)) {
        return;
      }
      if ((this.mRuntime != null) && (this.mRuntime.f() != null))
      {
        paramString = new SubscribeJsPlugin.SafeJsonObject(this, paramArrayOfString[0]).optString("puin");
        new Intent().putExtra("postUin", paramString);
        QZoneHelper.forwardToQQPublicAccountPublishPage(this.mRuntime.f().getHostActivity(), null, 0);
      }
    }
    else
    {
      if ("attachGoods".equals(paramString))
      {
        if (!a(paramArrayOfString)) {
          return;
        }
        b(paramArrayOfString[0]);
        return;
      }
      if ("cancelfollow".equals(paramString))
      {
        if (!a(paramArrayOfString)) {
          return;
        }
        c(paramArrayOfString[0]);
        return;
      }
      if ("getavatar".equals(paramString))
      {
        if (!a(paramArrayOfString)) {
          return;
        }
        d(paramArrayOfString[0]);
        return;
      }
      if ("refreshreturnpage".equals(paramString))
      {
        if ((this.mRuntime != null) && ((this.mRuntime.f() instanceof SubscribeHybirdFragment))) {
          ((SubscribeHybirdFragment)this.mRuntime.f()).b();
        }
      }
      else
      {
        if ("getlbslocation".equals(paramString))
        {
          if (!a(paramArrayOfString)) {
            return;
          }
          a(paramArrayOfString[0]);
          return;
        }
        if ("openhomepage".equals(paramString))
        {
          if (!a(paramArrayOfString)) {
            return;
          }
          SubscribeLaucher.a(null, new SubscribeJsPlugin.SafeJsonObject(this, paramArrayOfString[0]).optString("uid"));
        }
      }
    }
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length >= 1)) {
      return true;
    }
    QLog.e(this.mTAG, 2, "args is null");
    return false;
  }
  
  private void b(String paramString)
  {
    paramString = new SubscribeJsPlugin.SafeJsonObject(this, paramString).getJSONArray("goods");
    if (paramString != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        if (localJSONObject != null) {
          localArrayList.add(new CommodityBean(localJSONObject));
        }
        i += 1;
      }
      if ((this.mRuntime != null) && ((this.mRuntime.f() instanceof SubscribeHybirdFragment))) {
        ((SubscribeHybirdFragment)this.mRuntime.f()).a(localArrayList);
      }
    }
  }
  
  private void c(String paramString)
  {
    if ((this.mRuntime != null) && (this.mRuntime.f() != null))
    {
      if (this.mRuntime.f().getHostActivity() == null) {
        return;
      }
      Object localObject = new SubscribeJsPlugin.SafeJsonObject(this, paramString);
      paramString = ((SubscribeJsPlugin.SafeJsonObject)localObject).optString("uin");
      String str = ((SubscribeJsPlugin.SafeJsonObject)localObject).optString("nick");
      localObject = ((SubscribeJsPlugin.SafeJsonObject)localObject).optString("callback");
      SubscribeFollowUserUtil.a(this.mRuntime.f().getHostActivity(), paramString, str, new SubscribeJsPlugin.1(this, (String)localObject, str));
    }
  }
  
  private void d(String paramString)
  {
    if ((this.mRuntime != null) && (this.mRuntime.f() != null))
    {
      if (this.mRuntime.f().getHostActivity() == null) {
        return;
      }
      Object localObject = new SubscribeJsPlugin.SafeJsonObject(this, paramString);
      paramString = ((SubscribeJsPlugin.SafeJsonObject)localObject).optJSONArray("accountList");
      int i;
      if ("1".equals(((SubscribeJsPlugin.SafeJsonObject)localObject).getString("avatarType"))) {
        i = 4;
      } else {
        i = 1;
      }
      localObject = this.a;
      if (localObject == null)
      {
        this.a = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.mRuntime.d(), i);
        this.a.a();
        this.a.a(this);
      }
      else
      {
        ((INonMainProcAvatarLoader)localObject).a(i);
      }
      ThreadManagerV2.excute(new SubscribeJsPlugin.2(this, paramString), 16, null, false);
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    a(paramString1, paramBitmap);
    if (QLog.isColorLevel())
    {
      String str = this.mTAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetAvatar onFaceUpdate uin: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" -- ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" head:");
      localStringBuilder.append(paramBitmap);
      QLog.i(str, 4, localStringBuilder.toString());
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("qsubscribe".equals(paramString2))
    {
      paramJsBridgeListener = this.mTAG;
      paramString2 = new StringBuilder();
      paramString2.append("handleJsRequest:");
      paramString2.append(paramString1);
      QLog.i(paramJsBridgeListener, 2, paramString2.toString());
      try
      {
        a(paramString3, paramVarArgs);
      }
      catch (JSONException paramJsBridgeListener)
      {
        QLog.d(this.mTAG, 2, paramJsBridgeListener, new Object[0]);
      }
      return true;
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.b;
    if (localObject != null)
    {
      ((TroopMemberApiClient)localObject).f();
      this.b = null;
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((INonMainProcAvatarLoader)localObject).c();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeJsPlugin
 * JD-Core Version:    0.7.0.1
 */