package com.tencent.mobileqq.apollo.view.hippy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IPatchBundleDataHandler;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.fragment.HippyProgressBarWrapper;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/view/hippy/CMBattleGameFragment;", "Lcom/tencent/hippy/qq/fragment/BaseHippyFragment;", "Landroid/os/Handler$Callback;", "()V", "hippyCallback", "Lcom/tencent/mobileqq/apollo/view/hippy/ICmHippyCallback;", "getHippyCallback", "()Lcom/tencent/mobileqq/apollo/view/hippy/ICmHippyCallback;", "setHippyCallback", "(Lcom/tencent/mobileqq/apollo/view/hippy/ICmHippyCallback;)V", "mHippyContainer", "Landroid/view/ViewGroup;", "mProgressBarWrapper", "Lcom/tencent/hippy/qq/fragment/HippyProgressBarWrapper;", "mTimeoutHandler", "Landroid/os/Handler;", "doBussinessInitData", "Lorg/json/JSONObject;", "jsInitData", "handleMessage", "", "msg", "Landroid/os/Message;", "initProgressBar", "", "rootView", "isNightTheme", "notifyHippyThemeChange", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onLoadHippyError", "statusCode", "", "", "onLoadHippySuccess", "onPanelIconClickBeforeCreate", "onPostThemeChanged", "reportTimeOut", "setData", "jsonData", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMBattleGameFragment
  extends BaseHippyFragment
  implements Handler.Callback
{
  public static final CMBattleGameFragment.Companion a = new CMBattleGameFragment.Companion(null);
  private ViewGroup b;
  private final HippyProgressBarWrapper c = new HippyProgressBarWrapper();
  private final Handler d = new Handler(Looper.getMainLooper(), (Handler.Callback)this);
  @Nullable
  private ICmHippyCallback e;
  
  @JvmStatic
  @Nullable
  public static final OpenHippyInfo a(@NotNull QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    return a.a(paramQQAppInterface, paramInt1, paramInt2);
  }
  
  private final void a(ViewGroup paramViewGroup)
  {
    HippyQQPreloadEngine localHippyQQPreloadEngine = this.mHippyQQEngine;
    if ((localHippyQQPreloadEngine != null) && (!localHippyQQPreloadEngine.isPredraw())) {
      this.d.sendEmptyMessageDelayed(256, 5000L);
    }
    localHippyQQPreloadEngine = this.mHippyQQEngine;
    if ((localHippyQQPreloadEngine != null) && (!localHippyQQPreloadEngine.isNeedShowLoading())) {
      return;
    }
    this.c.initProgressBar(paramViewGroup);
    this.c.startProgressBar();
  }
  
  @JvmStatic
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    a.a(paramQQAppInterface, paramInt);
  }
  
  private final void a(boolean paramBoolean)
  {
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushBoolean("isNightMode", paramBoolean);
    sendHippyNativeEvent("themeChange", localHippyMap);
  }
  
  private final void b()
  {
    if (this.mHippyQQEngine == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    Object localObject2 = (Map)localHashMap;
    boolean bool = false;
    ((Map)localObject2).put("ret", Integer.valueOf(0));
    Object localObject1 = getLastStepName();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "lastStepName");
    ((Map)localObject2).put("errMsg", localObject1);
    localObject1 = this.mHippyQQEngine;
    if (localObject1 != null) {
      bool = ((HippyQQPreloadEngine)localObject1).isPreloaded();
    }
    ((Map)localObject2).put("isPreload", Boolean.valueOf(bool));
    localObject1 = getParameters().getString("from");
    if (localObject1 == null) {
      localObject1 = "";
    }
    ((Map)localObject2).put("from", localObject1);
    localObject1 = HippyReporter.getInstance();
    localObject2 = this.mHippyQQEngine;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "mHippyQQEngine");
    localObject2 = ((HippyQQPreloadEngine)localObject2).getModuleName();
    HippyQQPreloadEngine localHippyQQPreloadEngine = this.mHippyQQEngine;
    Intrinsics.checkExpressionValueIsNotNull(localHippyQQPreloadEngine, "mHippyQQEngine");
    ((HippyReporter)localObject1).reportHippyLoadResult(6, (String)localObject2, localHippyQQPreloadEngine.getModuleVersion(), localHashMap, generateStepCosts());
  }
  
  private final boolean c()
  {
    return ThemeUtil.isNowThemeIsNight(null, false, null);
  }
  
  public final void a()
  {
    a(c());
  }
  
  public final void a(@Nullable ICmHippyCallback paramICmHippyCallback)
  {
    this.e = paramICmHippyCallback;
  }
  
  @NotNull
  protected JSONObject doBussinessInitData(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "jsInitData");
    for (;;)
    {
      try
      {
        ((IPatchBundleDataHandler)QRoute.api(IPatchBundleDataHandler.class)).checkWrapSSOData(paramJSONObject, getModuleName());
        localObject3 = getParameters().getSerializable("js_param_map");
        Object localObject1 = localObject3;
        if (!(localObject3 instanceof SerializableMap)) {
          localObject1 = null;
        }
        localObject1 = (SerializableMap)localObject1;
        localObject3 = (IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class);
        if (localObject1 != null)
        {
          localObject1 = ((SerializableMap)localObject1).getMap();
          localObject1 = ((IHippyAccessHelper)localObject3).wrapHashMap(paramJSONObject, (HashMap)localObject1);
          localObject3 = MobileQQ.sMobileQQ.waitAppRuntime(null);
          Object localObject4 = getArguments();
          int i = -1;
          if (localObject4 != null) {
            i = ((Bundle)localObject4).getInt("sceneId", -1);
          }
          localObject4 = getArguments();
          int j = 0;
          if (localObject4 != null) {
            j = ((Bundle)localObject4).getInt("cmBattleGameStyle", 0);
          }
          boolean bool = localObject3 instanceof QQAppInterface;
          if (bool)
          {
            localObject4 = a;
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "jsonObject");
            ((CMBattleGameFragment.Companion)localObject4).a((JSONObject)localObject1, (QQAppInterface)localObject3, i, j);
          }
          else
          {
            QLog.e("CMBattleGameFragment", 1, "appInterface error!");
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("doBussinessInitData jsonObject=");
            ((StringBuilder)localObject3).append(localObject1);
            QLog.d("CMBattleGameFragment", 2, ((StringBuilder)localObject3).toString());
          }
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "jsonObject");
          return localObject1;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("doBussinessInitData:");
        ((StringBuilder)localObject3).append(localThrowable);
        QLog.e("CMBattleGameFragment", 1, ((StringBuilder)localObject3).toString());
        return paramJSONObject;
      }
      Object localObject2 = null;
    }
  }
  
  public boolean handleMessage(@Nullable Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.what == 256))
    {
      paramMessage = this.e;
      if (paramMessage != null) {
        paramMessage.f();
      }
      if (this.mHippyQQEngine != null) {
        b();
      }
      return true;
    }
    return false;
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131624168, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(2131435055);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "rootView.findViewById(R.id.hippy_container)");
    this.b = ((ViewGroup)paramViewGroup);
    paramViewGroup = this.b;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mHippyContainer");
    }
    loadHippy(paramViewGroup);
    if (paramLayoutInflater != null)
    {
      a((ViewGroup)paramLayoutInflater);
      return paramLayoutInflater;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("CMBattleGameFragment", 2, "onDestroy");
    }
  }
  
  public void onDestroyView()
  {
    this.d.removeMessages(256);
    super.onDestroyView();
  }
  
  protected void onLoadHippyError(int paramInt, @Nullable String paramString)
  {
    super.onLoadHippyError(paramInt, paramString);
    this.d.removeMessages(256);
    this.c.hideProgressBar();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadHippyError code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" msg=");
    localStringBuilder.append(paramString);
    QLog.e("CMBattleGameFragment", 1, localStringBuilder.toString());
    paramString = this.e;
    if (paramString != null) {
      paramString.g();
    }
  }
  
  protected void onLoadHippySuccess()
  {
    super.onLoadHippySuccess();
    this.d.removeMessages(256);
    this.c.hideProgressBar();
    a(c());
    ICmHippyCallback localICmHippyCallback = this.e;
    if (localICmHippyCallback != null) {
      localICmHippyCallback.e();
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    a(c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.hippy.CMBattleGameFragment
 * JD-Core Version:    0.7.0.1
 */