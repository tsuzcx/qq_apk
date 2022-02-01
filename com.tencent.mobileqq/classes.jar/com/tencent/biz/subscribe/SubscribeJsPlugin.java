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
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  private INonMainProcAvatarLoader jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
  
  private void a(String paramString)
  {
    paramString = new SubscribeJsPlugin.SafeJsonObject(this, paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("code", paramString.optString("code"));
    localBundle.putString("location", paramString.optString("location"));
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.d(localBundle);
  }
  
  private void a(String paramString, Bitmap paramBitmap)
  {
    ThreadManager.post(new SubscribeJsPlugin.3(this, paramBitmap, paramString), 8, null, false);
  }
  
  private void a(String paramString, String[] paramArrayOfString)
  {
    if ("opendetail".equals(paramString)) {
      if (a(paramArrayOfString)) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          paramString = new SubscribeJsPlugin.SafeJsonObject(this, paramArrayOfString[0]);
                          QLog.d(this.TAG, 2, paramString.toString());
                          if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof SubscribeHybirdFragment)))
                          {
                            ((SubscribeHybirdFragment)this.mRuntime.a()).a(SubscribeLaucher.a(paramString.getString("feedid"), paramString.getString("uin"), paramString.getInt("type"), paramString.getInt("width"), paramString.getInt("height"), Long.valueOf(paramString.getString("createtime")).longValue()));
                            return;
                          }
                        } while ((this.mRuntime == null) || (this.mRuntime.a() == null));
                        SubscribeLaucher.a(null, SubscribeLaucher.a(paramString.getString("feedid"), paramString.getString("uin"), paramString.getInt("type"), paramString.getInt("width"), paramString.getInt("height"), Long.valueOf(paramString.getString("createtime")).longValue()));
                        return;
                        if (!"sharepersonalpage".equals(paramString)) {
                          break;
                        }
                      } while (!a(paramArrayOfString));
                      paramString = new SubscribeJsPlugin.SafeJsonObject(this, paramArrayOfString[0]);
                    } while ((this.mRuntime == null) || (!(this.mRuntime.a() instanceof SubscribeHybirdFragment)));
                    QLog.d(this.TAG, 2, paramString.toString());
                    ((SubscribeHybirdFragment)this.mRuntime.a()).a(paramString.getString("uin"), paramString.getString("nickname"), paramString.getString("icon"), paramString.getString("desc"), paramString.getString("usertype"));
                    return;
                    if (!"reloadmainpage".equals(paramString)) {
                      break;
                    }
                  } while ((this.mRuntime == null) || (!(this.mRuntime.a() instanceof SubscribeHybirdFragment)));
                  ((SubscribeHybirdFragment)this.mRuntime.a()).a();
                  return;
                  if (!"openpublishpage".equals(paramString)) {
                    break;
                  }
                } while ((!a(paramArrayOfString)) || (this.mRuntime == null) || (this.mRuntime.a() == null));
                paramString = new SubscribeJsPlugin.SafeJsonObject(this, paramArrayOfString[0]).optString("puin");
                new Intent().putExtra("postUin", paramString);
                QZoneHelper.forwardToQQPublicAccountPublishPage(this.mRuntime.a().getHostActivity(), null, 0);
                return;
                if (!"attachGoods".equals(paramString)) {
                  break;
                }
              } while (!a(paramArrayOfString));
              b(paramArrayOfString[0]);
              return;
              if (!"cancelfollow".equals(paramString)) {
                break;
              }
            } while (!a(paramArrayOfString));
            c(paramArrayOfString[0]);
            return;
            if (!"getavatar".equals(paramString)) {
              break;
            }
          } while (!a(paramArrayOfString));
          d(paramArrayOfString[0]);
          return;
          if (!"refreshreturnpage".equals(paramString)) {
            break;
          }
        } while ((this.mRuntime == null) || (!(this.mRuntime.a() instanceof SubscribeHybirdFragment)));
        ((SubscribeHybirdFragment)this.mRuntime.a()).b();
        return;
        if (!"getlbslocation".equals(paramString)) {
          break;
        }
      } while (!a(paramArrayOfString));
      a(paramArrayOfString[0]);
      return;
    } while ((!"openhomepage".equals(paramString)) || (!a(paramArrayOfString)));
    SubscribeLaucher.a(null, new SubscribeJsPlugin.SafeJsonObject(this, paramArrayOfString[0]).optString("uid"));
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1))
    {
      QLog.e(this.TAG, 2, "args is null");
      bool = false;
    }
    return bool;
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
      if ((this.mRuntime != null) && ((this.mRuntime.a() instanceof SubscribeHybirdFragment))) {
        ((SubscribeHybirdFragment)this.mRuntime.a()).a(localArrayList);
      }
    }
  }
  
  private void c(String paramString)
  {
    if ((this.mRuntime == null) || (this.mRuntime.a() == null) || (this.mRuntime.a().getHostActivity() == null)) {
      return;
    }
    Object localObject = new SubscribeJsPlugin.SafeJsonObject(this, paramString);
    paramString = ((SubscribeJsPlugin.SafeJsonObject)localObject).optString("uin");
    String str = ((SubscribeJsPlugin.SafeJsonObject)localObject).optString("nick");
    localObject = ((SubscribeJsPlugin.SafeJsonObject)localObject).optString("callback");
    SubscribeFollowUserUtil.a(this.mRuntime.a().getHostActivity(), paramString, str, new SubscribeJsPlugin.1(this, (String)localObject, str));
  }
  
  private void d(String paramString)
  {
    if ((this.mRuntime == null) || (this.mRuntime.a() == null) || (this.mRuntime.a().getHostActivity() == null)) {
      return;
    }
    paramString = new SubscribeJsPlugin.SafeJsonObject(this, paramString);
    JSONArray localJSONArray = paramString.optJSONArray("accountList");
    int i;
    if ("1".equals(paramString.getString("avatarType")))
    {
      i = 4;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader != null) {
        break label143;
      }
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.mRuntime.a(), i);
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a();
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(this);
    }
    for (;;)
    {
      ThreadManagerV2.excute(new SubscribeJsPlugin.2(this, localJSONArray), 16, null, false);
      return;
      i = 1;
      break;
      label143:
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(i);
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    a(paramString1, paramBitmap);
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 4, "handleGetAvatar onFaceUpdate uin: " + paramString1 + " -- " + paramString2 + " head:" + paramBitmap);
    }
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("qsubscribe".equals(paramString2))
    {
      QLog.i(this.TAG, 2, "handleJsRequest:" + paramString1);
      try
      {
        a(paramString3, paramVarArgs);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        for (;;)
        {
          QLog.d(this.TAG, 2, paramJsBridgeListener, new Object[0]);
        }
      }
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.b();
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeJsPlugin
 * JD-Core Version:    0.7.0.1
 */