package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.store.ApolloStoreViewController;
import com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam;
import com.tencent.mobileqq.apollo.store.IApolloActivityJsCallBack;
import com.tencent.mobileqq.apollo.utils.RequestRoute;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.web.CmshowWebReqParam;
import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.CmStoreUserInfo;
import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.engine.resource.ApolloResManagerFacade;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResDownloader;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class Avatar2DJsModule
  extends BaseJsModule
  implements OnApolloViewListener
{
  private static final int b = (int)((float)(DeviceInfoUtil.F() >> 1) / DeviceInfoUtil.A());
  private static final int c;
  private String d;
  private Vector<String> e = new Vector();
  @NonNull
  private IApolloResManager f = ApolloResManagerFacade.a.a(Scene.WEB_STORE_OR_GAME);
  private Avatar2DJsModule.OnCheckApolloResListener g = new Avatar2DJsModule.6(this);
  private Avatar2DJsModule.OnCheckApolloResListener h = new Avatar2DJsModule.7(this);
  private Avatar2DJsModule.OnCheckApolloResListener i = new Avatar2DJsModule.8(this);
  
  static
  {
    double d1 = DeviceInfoUtil.G();
    Double.isNaN(d1);
    double d2 = DeviceInfoUtil.A();
    Double.isNaN(d2);
    c = (int)(d1 * 0.4D / d2);
  }
  
  public Avatar2DJsModule(VasWebviewJsPlugin paramVasWebviewJsPlugin)
  {
    super(paramVasWebviewJsPlugin);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, ArrayList<ApolloWebAvatarParam> paramArrayList, String paramString3, Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Avatar2DJsModule", 2, new Object[] { "IPC_APOLLO_CHECK_AVATAR_RES, ret=", Integer.valueOf(paramInt1), ", msg=", paramString1, ", from=", Integer.valueOf(paramInt2) });
    }
    if (paramInt1 != 0)
    {
      if (paramInt2 != 2) {
        QQToast.makeText(paramActivity, HardCodeUtil.a(2131898662), 1).show();
      }
      a(paramString2, HardCodeUtil.a(2131898672));
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("下载素材角色装扮素材失败->mRoleId");
        paramString1.append(d().mRoleId);
        paramString1.append(" mDressIds->");
        paramString1.append(d().mDressIds);
        QLog.d("Avatar2DJsModule", 2, paramString1.toString());
      }
      return;
    }
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      ThreadManager.getUIHandlerV2().post(new Avatar2DJsModule.5(this, paramString3, paramString2, paramInt2, paramArrayList, paramActivity));
      return;
    }
    a(paramString2, HardCodeUtil.a(2131898674));
  }
  
  private void a(int paramInt, String paramString, ArrayList<ApolloWebAvatarParam> paramArrayList, Activity paramActivity)
  {
    AppRuntime localAppRuntime;
    if ((paramActivity instanceof QBaseActivity)) {
      localAppRuntime = ((QBaseActivity)paramActivity).getAppRuntime();
    } else {
      localAppRuntime = null;
    }
    if (localAppRuntime == null)
    {
      a(paramString, "获取AppInterface失败");
      return;
    }
    if (paramInt == 1)
    {
      a(paramString, paramArrayList, paramActivity, localAppRuntime, this.g);
      return;
    }
    if (paramInt == 0)
    {
      a(paramString, paramArrayList, paramActivity, localAppRuntime, this.h);
      return;
    }
    if (paramInt == 2) {
      a(paramString, paramArrayList, paramActivity, localAppRuntime, this.i);
    }
  }
  
  private void a(String paramString, ArrayList<ApolloWebAvatarParam> paramArrayList, Activity paramActivity, AppRuntime paramAppRuntime, Avatar2DJsModule.OnCheckApolloResListener paramOnCheckApolloResListener)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      ApolloWebAvatarParam localApolloWebAvatarParam = (ApolloWebAvatarParam)localIterator.next();
      if (localApolloWebAvatarParam.isResExist) {
        paramOnCheckApolloResListener.a(paramString, paramActivity, localApolloWebAvatarParam, paramArrayList);
      } else {
        this.f.a().a(paramAppRuntime, localApolloWebAvatarParam.uin, new Avatar2DJsModule.9(this, paramString, localApolloWebAvatarParam, paramOnCheckApolloResListener, paramArrayList), localApolloWebAvatarParam.roleId, localApolloWebAvatarParam.dressIds, -1, -1, false);
      }
    }
  }
  
  @RequestRoute(a="addAvatar")
  private void handleJsApiAddAvatar(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject2 = paramCmshowWebReqParam.a;
    String str = paramCmshowWebReqParam.b;
    Activity localActivity = paramCmshowWebReqParam.c;
    boolean bool1 = QLog.isColorLevel();
    Object localObject1 = "Avatar2DJsModule";
    if (bool1) {
      QLog.d("Avatar2DJsModule", 2, "addAvatar");
    }
    boolean bool3 = localActivity instanceof IApolloActivityJsCallBack;
    if (!bool3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Avatar2DJsModule", 2, "addAvatar, not IApolloActivityJsCallBack, check getApolloStoreViewController()");
      }
      if ((c() == null) && ((a().a().getParent() instanceof RelativeLayout)))
      {
        a(new ApolloStoreViewController((RelativeLayout)a().a().getParent(), null));
        c().a(this);
      }
      if (c() == null)
      {
        QLog.e("Avatar2DJsModule", 1, "addAvatar, getApolloStoreViewController() null");
        a(str, "ApolloViewController is null");
        return;
      }
    }
    paramCmshowWebReqParam = ((JSONObject)localObject2).getJSONArray("apolloList");
    if ((paramCmshowWebReqParam != null) && (paramCmshowWebReqParam.length() != 0))
    {
      localObject2 = new ArrayList(paramCmshowWebReqParam.length());
      int n = paramCmshowWebReqParam.length();
      int k = 0;
      int j = 0;
      while (k < n)
      {
        Object localObject3 = paramCmshowWebReqParam.getJSONObject(k);
        ApolloWebAvatarParam localApolloWebAvatarParam = new ApolloWebAvatarParam();
        localApolloWebAvatarParam.isMain = false;
        localApolloWebAvatarParam.apolloId = ((JSONObject)localObject3).optString("apolloId");
        localApolloWebAvatarParam.x = ((JSONObject)localObject3).optInt("x", b);
        localApolloWebAvatarParam.y = ((JSONObject)localObject3).optInt("y", c);
        localApolloWebAvatarParam.nickName = ((JSONObject)localObject3).optString("nickName");
        localApolloWebAvatarParam.uin = ((JSONObject)localObject3).optString("uin");
        if ((!TextUtils.isEmpty(localApolloWebAvatarParam.apolloId)) && (!TextUtils.isEmpty(localApolloWebAvatarParam.uin)))
        {
          localApolloWebAvatarParam.rate = ((float)((JSONObject)localObject3).optDouble("rate", 0.0D));
          localApolloWebAvatarParam.roleId = ((JSONObject)localObject3).optInt("roleId");
          localObject3 = ((JSONObject)localObject3).optJSONArray("dressIds");
          if (localApolloWebAvatarParam.roleId > 0) {
            bool1 = this.f.b(localApolloWebAvatarParam.roleId);
          } else {
            bool1 = false;
          }
          if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
          {
            int i1 = ((JSONArray)localObject3).length();
            localApolloWebAvatarParam.dressIds = new int[i1];
            int m = 0;
            while (m < i1)
            {
              int i2 = ((JSONArray)localObject3).getInt(m);
              localApolloWebAvatarParam.dressIds[m] = i2;
              boolean bool2 = bool1;
              if (localApolloWebAvatarParam.roleId > 0)
              {
                bool2 = bool1;
                if (bool1) {
                  bool2 = this.f.a(i2);
                }
              }
              m += 1;
              bool1 = bool2;
            }
          }
          localApolloWebAvatarParam.isResExist = bool1;
          if (!bool1) {
            j = 1;
          }
          ((ArrayList)localObject2).add(localApolloWebAvatarParam);
          if (!this.e.contains(localApolloWebAvatarParam.apolloId)) {
            this.e.add(localApolloWebAvatarParam.apolloId);
          }
          k += 1;
        }
        else
        {
          QLog.e((String)localObject1, 1, "addAvatar, apolloId or uin is null");
          k = 1;
          break label569;
        }
      }
      k = 0;
      label569:
      if (k != 0)
      {
        QLog.e((String)localObject1, 1, "addAvatar, param invalid");
        a(str, HardCodeUtil.a(2131898685));
        return;
      }
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d((String)localObject1, 2, "addAvatar, should request resource");
        }
        ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a((Serializable)localObject2, new Avatar2DJsModule.4(this, str, localActivity));
        return;
      }
      if (bool3)
      {
        paramCmshowWebReqParam = ((IApolloActivityJsCallBack)localActivity).a((ArrayList)localObject2);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("&&");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(paramCmshowWebReqParam);
        ((StringBuilder)localObject1).append(");");
        super.d(((StringBuilder)localObject1).toString());
        return;
      }
      if (c() != null)
      {
        paramCmshowWebReqParam = c().a((ArrayList)localObject2);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("&&");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append("(");
        ((StringBuilder)localObject1).append(paramCmshowWebReqParam);
        ((StringBuilder)localObject1).append(");");
        super.d(((StringBuilder)localObject1).toString());
        return;
      }
      QLog.e((String)localObject1, 1, "addAvatar, controller null");
      a(str, HardCodeUtil.a(2131898697));
      return;
    }
    QLog.e("Avatar2DJsModule", 1, "addAvatar, param list null");
    a(str, HardCodeUtil.a(2131898705));
  }
  
  @RequestRoute(a="destroyAvatar")
  private void handleJsApiDestroyAvatar(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    Object localObject = paramCmshowWebReqParam.a;
    String str1 = paramCmshowWebReqParam.b;
    paramCmshowWebReqParam = paramCmshowWebReqParam.c;
    localObject = ((JSONObject)localObject).optJSONArray("apolloList");
    if ((localObject != null) && (((JSONArray)localObject).length() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int j = 0;
      int k = ((JSONArray)localObject).length();
      while (j < k)
      {
        String str2 = ((JSONArray)localObject).getString(j);
        localArrayList.add(str2);
        this.e.remove(str2);
        j += 1;
      }
      if ((paramCmshowWebReqParam instanceof IApolloActivityJsCallBack))
      {
        ((IApolloActivityJsCallBack)paramCmshowWebReqParam).b(localArrayList);
        b(str1);
        return;
      }
      if (c() != null)
      {
        c().b(localArrayList);
        b(str1);
        return;
      }
      QLog.e("Avatar2DJsModule", 1, "destroyAvatar, controller null");
      a(str1, HardCodeUtil.a(2131898689));
      return;
    }
    a(str1, HardCodeUtil.a(2131898694));
  }
  
  @RequestRoute(a="initApolloView")
  private boolean handleJsApiInitApolloView(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    String str = paramCmshowWebReqParam.b;
    Activity localActivity = paramCmshowWebReqParam.c;
    Object localObject1 = paramCmshowWebReqParam.e;
    if (!ApolloEngine.isEngineReady())
    {
      a(str, "engine is not ready");
      return true;
    }
    Object localObject2 = c();
    paramCmshowWebReqParam = null;
    if ((localObject2 == null) && ((a().a().getParent() instanceof RelativeLayout)))
    {
      a(new ApolloStoreViewController((RelativeLayout)a().a().getParent(), null));
      c().a(this);
    }
    if (c() == null)
    {
      a(str, "ApolloViewController is null");
      return true;
    }
    int j = localJSONObject.optInt("disableTouch", 0);
    int k = localJSONObject.optInt("scrollByWebView", 0);
    if ((a().a() instanceof TouchWebView))
    {
      localObject2 = (TouchWebView)a().a();
      if (k > 0) {
        paramCmshowWebReqParam = c();
      }
      ((TouchWebView)localObject2).setOnScrollChangedListener(paramCmshowWebReqParam);
    }
    paramCmshowWebReqParam = c();
    boolean bool1;
    if (j > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramCmshowWebReqParam.b(bool1);
    localObject2 = new ApolloWebAvatarParam();
    ((ApolloWebAvatarParam)localObject2).isMain = true;
    ((ApolloWebAvatarParam)localObject2).apolloId = localJSONObject.optString("apolloId", "me");
    ((ApolloWebAvatarParam)localObject2).x = localJSONObject.optInt("x", b);
    ((ApolloWebAvatarParam)localObject2).y = localJSONObject.optInt("y", c);
    ((ApolloWebAvatarParam)localObject2).uin = localJSONObject.optString("uin");
    if (TextUtils.isEmpty(((ApolloWebAvatarParam)localObject2).uin)) {
      ((ApolloWebAvatarParam)localObject2).uin = a().b().getCurrentAccountUin();
    }
    ((ApolloWebAvatarParam)localObject2).nickName = localJSONObject.optString("nickName");
    ((ApolloWebAvatarParam)localObject2).type = 0;
    ((ApolloWebAvatarParam)localObject2).tab = "mall";
    ((ApolloWebAvatarParam)localObject2).rate = ((float)localJSONObject.optDouble("rate", 0.0D));
    ((ApolloWebAvatarParam)localObject2).roleId = localJSONObject.optInt("roleId");
    paramCmshowWebReqParam = localJSONObject.optJSONArray("tapRect");
    if ((paramCmshowWebReqParam != null) && (paramCmshowWebReqParam.length() >= 4))
    {
      ((ApolloWebAvatarParam)localObject2).tapRectX = paramCmshowWebReqParam.getInt(0);
      ((ApolloWebAvatarParam)localObject2).tapRectY = paramCmshowWebReqParam.getInt(1);
      ((ApolloWebAvatarParam)localObject2).tapRectWidth = paramCmshowWebReqParam.getInt(2);
      ((ApolloWebAvatarParam)localObject2).tapRectHeight = paramCmshowWebReqParam.getInt(3);
    }
    paramCmshowWebReqParam = localJSONObject.optJSONArray("dressIds");
    if (((ApolloWebAvatarParam)localObject2).roleId > 0) {
      bool1 = this.f.b(((ApolloWebAvatarParam)localObject2).roleId);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (paramCmshowWebReqParam != null)
    {
      bool2 = bool1;
      if (paramCmshowWebReqParam.length() > 0)
      {
        k = paramCmshowWebReqParam.length();
        ((ApolloWebAvatarParam)localObject2).dressIds = new int[k];
        j = 0;
        while (j < k)
        {
          int m = paramCmshowWebReqParam.getInt(j);
          ((ApolloWebAvatarParam)localObject2).dressIds[j] = m;
          bool2 = bool1;
          if (((ApolloWebAvatarParam)localObject2).roleId > 0)
          {
            bool2 = bool1;
            if (bool1) {
              bool2 = this.f.a(m);
            }
          }
          j += 1;
          bool1 = bool2;
        }
        bool2 = bool1;
      }
    }
    ((ApolloWebAvatarParam)localObject2).isResExist = bool2;
    this.e.clear();
    this.e.add(((ApolloWebAvatarParam)localObject2).apolloId);
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Avatar2DJsModule", 2, "initApolloView, should request resource");
      }
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject2);
      paramCmshowWebReqParam = localJSONObject.optString("reqUrl");
      if (TextUtils.isEmpty(paramCmshowWebReqParam)) {
        paramCmshowWebReqParam = (CmshowWebReqParam)localObject1;
      }
      ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(localArrayList, new Avatar2DJsModule.1(this, str, paramCmshowWebReqParam, localActivity));
      c().a(true, ((ApolloWebAvatarParam)localObject2).x, ((ApolloWebAvatarParam)localObject2).y);
      return false;
    }
    paramCmshowWebReqParam = c().a(1, true, (ApolloWebAvatarParam)localObject2);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append("&&");
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append("(");
    ((StringBuilder)localObject1).append(paramCmshowWebReqParam);
    ((StringBuilder)localObject1).append(");");
    super.d(((StringBuilder)localObject1).toString());
    return false;
  }
  
  @RequestRoute(a="initAvatar")
  private void handleJsApiInitAvatar(@NonNull CmshowWebReqParam paramCmshowWebReqParam)
  {
    JSONObject localJSONObject = paramCmshowWebReqParam.a;
    String str = paramCmshowWebReqParam.b;
    Activity localActivity = paramCmshowWebReqParam.c;
    Object localObject1 = paramCmshowWebReqParam.e;
    if (QLog.isColorLevel()) {
      QLog.d("Avatar2DJsModule", 2, "initAvatar");
    }
    if (!IApolloActivityJsCallBack.class.isInstance(localActivity))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Avatar2DJsModule", 2, "initAvatar, not ApolloStoreActivity");
      }
      if ((localActivity instanceof QBaseActivity))
      {
        paramCmshowWebReqParam = (AppInterface)((QBaseActivity)localActivity).getAppRuntime();
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(localActivity, null, "share", a().a().getUrl(), paramCmshowWebReqParam);
      }
      ThreadManager.getSubThreadHandler().postDelayed(new Avatar2DJsModule.2(this, localActivity), 2000L);
    }
    ApolloWebAvatarParam localApolloWebAvatarParam = new ApolloWebAvatarParam();
    localApolloWebAvatarParam.isMain = true;
    localApolloWebAvatarParam.apolloId = localJSONObject.optString("apolloId", "me");
    localApolloWebAvatarParam.type = localJSONObject.optInt("type");
    localApolloWebAvatarParam.x = localJSONObject.optInt("x", b);
    localApolloWebAvatarParam.y = localJSONObject.optInt("y", c);
    localApolloWebAvatarParam.tab = localJSONObject.optString("tab");
    localApolloWebAvatarParam.rate = ((float)localJSONObject.optDouble("rate", 0.0D));
    localApolloWebAvatarParam.uin = localJSONObject.optString("uin");
    localApolloWebAvatarParam.nickName = localJSONObject.optString("nickName");
    localApolloWebAvatarParam.greeting = localJSONObject.optString("greeting");
    Object localObject3 = a().b().getCurrentAccountUin();
    if (TextUtils.isEmpty(localApolloWebAvatarParam.uin)) {
      localApolloWebAvatarParam.uin = ((String)localObject3);
    }
    this.d = localApolloWebAvatarParam.uin;
    localApolloWebAvatarParam.roleId = localJSONObject.optInt("roleId");
    paramCmshowWebReqParam = localJSONObject.optJSONArray("tapRect");
    if ((paramCmshowWebReqParam != null) && (paramCmshowWebReqParam.length() >= 4))
    {
      localApolloWebAvatarParam.tapRectX = paramCmshowWebReqParam.getInt(0);
      localApolloWebAvatarParam.tapRectY = paramCmshowWebReqParam.getInt(1);
      localApolloWebAvatarParam.tapRectWidth = paramCmshowWebReqParam.getInt(2);
      localApolloWebAvatarParam.tapRectHeight = paramCmshowWebReqParam.getInt(3);
    }
    boolean bool1;
    if (localApolloWebAvatarParam.roleId > 0) {
      bool1 = this.f.b(localApolloWebAvatarParam.roleId);
    } else {
      bool1 = false;
    }
    paramCmshowWebReqParam = localJSONObject.optJSONArray("dressIds");
    long l = localJSONObject.optLong("avatarTs");
    Object localObject2;
    int j;
    boolean bool2;
    if ((paramCmshowWebReqParam != null) && (paramCmshowWebReqParam.length() > 0))
    {
      int k = paramCmshowWebReqParam.length();
      localObject2 = new int[k];
      j = 0;
      while (j < k)
      {
        localObject2[j] = paramCmshowWebReqParam.getInt(j);
        bool2 = bool1;
        if (localApolloWebAvatarParam.roleId > 0)
        {
          bool2 = bool1;
          if (bool1) {
            bool2 = this.f.a(localObject2[j]);
          }
        }
        j += 1;
        bool1 = bool2;
      }
      localApolloWebAvatarParam.dressIds = ((int[])localObject2);
      paramCmshowWebReqParam = (CmshowWebReqParam)localObject2;
      bool2 = bool1;
      if (this.d.equals(localObject3))
      {
        d().mRoleId = localApolloWebAvatarParam.roleId;
        d().mDressIds = ((int[])localObject2);
        paramCmshowWebReqParam = (CmshowWebReqParam)localObject2;
        bool2 = bool1;
      }
    }
    else
    {
      paramCmshowWebReqParam = null;
      bool2 = bool1;
    }
    if (!bool2) {
      j = 1;
    } else {
      j = 0;
    }
    this.e.clear();
    this.e.add(localApolloWebAvatarParam.apolloId);
    if ((localActivity instanceof IApolloActivityJsCallBack))
    {
      localObject3 = (IApolloActivityJsCallBack)localActivity;
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Avatar2DJsModule", 2, "initAvatar, should request resource");
        }
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(localApolloWebAvatarParam);
        localObject2 = localJSONObject.optString("reqUrl");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = localObject2;
        }
        ((IApolloActivityJsCallBack)localObject3).a(true, localApolloWebAvatarParam.x, localApolloWebAvatarParam.y);
        ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(localArrayList, new Avatar2DJsModule.3(this, str, (String)localObject1, localActivity));
      }
      else
      {
        localObject1 = ((IApolloActivityJsCallBack)localObject3).a(d().mApolloStatus, localApolloWebAvatarParam);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("&&");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(");");
        super.d(((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      QLog.e("Avatar2DJsModule", 1, "initAvatar, not apollo store activity");
      a(str, HardCodeUtil.a(2131898682));
    }
    if (j == 0) {
      ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(localJSONObject.optString("uin"), l, paramCmshowWebReqParam);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d("Avatar2DJsModule", 2, "Avatar view is Ready.");
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("Avatar2DJsModule", 2, new Object[] { "[onNotifyStatusChanged] status=", Integer.valueOf(paramInt), ", apolloId=", paramString });
    if (TextUtils.isEmpty(paramString))
    {
      super.d("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar();");
      return;
    }
    super.d(String.format("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar('%s');", new Object[] { paramString }));
  }
  
  public void a(String paramString)
  {
    QLog.d("Avatar2DJsModule", 2, new Object[] { "onNotifyLongTouch:", paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Avatar2DJsModule
 * JD-Core Version:    0.7.0.1
 */