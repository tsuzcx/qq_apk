package com.tencent.mobileqq.apollo.api.sdk.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.res.IApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloSoLoaderImpl;
import com.tencent.mobileqq.apollo.api.sdk.ICmShowSDKPlatform;
import com.tencent.mobileqq.apollo.api.sdk.onChangeApolloStatusListener;
import com.tencent.mobileqq.apollo.api.sdk.onCmShowDataInitListener;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.process.CmGameClientQIPCModule;
import com.tencent.mobileqq.apollo.view.opengl.GLTextureView;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/sdk/impl/CmShowSDKPlatformImpl;", "Lcom/tencent/mobileqq/apollo/api/sdk/ICmShowSDKPlatform;", "()V", "sSdkInit", "", "changeApolloStatus", "", "mode", "", "changeApolloStatusListener", "Lcom/tencent/mobileqq/apollo/api/sdk/onChangeApolloStatusListener;", "initCmShowData", "selfUin", "", "friendUin", "onCmShowDataInitListener", "Lcom/tencent/mobileqq/apollo/api/sdk/onCmShowDataInitListener;", "traceFeatureId", "initSdk", "cmSoLoadCompleteCallback", "Lcom/tencent/mobileqq/apollo/api/res/IApolloSoLoader$OnCmSoLoadCompleteCallback;", "isSdkInit", "context", "Landroid/content/Context;", "openCmShowStore", "url", "preLoadRes", "uins", "Ljava/util/ArrayList;", "actionIds", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CmShowSDKPlatformImpl
  implements ICmShowSDKPlatform
{
  public static final CmShowSDKPlatformImpl.Companion Companion = new CmShowSDKPlatformImpl.Companion(null);
  @NotNull
  public static final String TAG = "CmShowSDKPlatform";
  private boolean sSdkInit;
  
  public void changeApolloStatus(int paramInt, @Nullable onChangeApolloStatusListener paramonChangeApolloStatusListener)
  {
    QLog.d("CmShowSDKPlatform", 1, new Object[] { "changeApolloStatus mode:", Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putInt("mode", paramInt);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_change_mode", localBundle, (EIPCResultCallback)new CmShowSDKPlatformImpl.changeApolloStatus.1(paramonChangeApolloStatusListener));
  }
  
  public void initCmShowData(@Nullable String paramString1, @Nullable String paramString2, @Nullable onCmShowDataInitListener paramonCmShowDataInitListener, int paramInt)
  {
    if (paramonCmShowDataInitListener == null)
    {
      QLog.e("CmShowSDKPlatform", 1, "initSdk cmSoLoadCompleteCallback == null");
      return;
    }
    CmGameClientQIPCModule.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("selfUin", paramString1);
    localBundle.putString("friendUin", paramString2);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_init_cmshow_data", localBundle, (EIPCResultCallback)new CmShowSDKPlatformImpl.initCmShowData.1(this, paramString1, paramString2, paramonCmShowDataInitListener));
  }
  
  public void initSdk(@Nullable IApolloSoLoader.OnCmSoLoadCompleteCallback paramOnCmSoLoadCompleteCallback, int paramInt)
  {
    if (paramOnCmSoLoadCompleteCallback == null)
    {
      QLog.e("CmShowSDKPlatform", 1, "initSdk cmSoLoadCompleteCallback == null");
      return;
    }
    GLTextureView.checkGLVersion((Context)BaseApplicationImpl.getContext());
    CmGameClientQIPCModule.a();
    Bundle localBundle = new Bundle();
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_get_base_data", localBundle, (EIPCResultCallback)new CmShowSDKPlatformImpl.initSdk.1(this, paramOnCmSoLoadCompleteCallback));
  }
  
  public boolean isSdkInit(@NotNull Context paramContext)
  {
    boolean bool3 = false;
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    for (;;)
    {
      try
      {
        Object localObject = QRoute.api(IApolloUtil.class);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(IApolloUtil::class.java)");
        localObject = ((IApolloUtil)localObject).getAppInterface();
        if (localObject == null) {
          continue;
        }
        localObject = (IApolloManagerService)((AppRuntime)localObject).getRuntimeService(IApolloManagerService.class, "all");
        if (localObject == null) {
          continue;
        }
        bool1 = ((IApolloManagerService)localObject).isHardwareSupport(paramContext);
      }
      catch (Throwable paramContext)
      {
        boolean bool2;
        boolean bool1 = false;
        continue;
      }
      bool2 = bool3;
      if (bool1)
      {
        bool2 = bool3;
        if (ApolloSoLoaderImpl.isLibReady())
        {
          bool2 = bool3;
          if (this.sSdkInit) {
            bool2 = true;
          }
        }
      }
      return bool2;
      bool1 = false;
    }
  }
  
  public void openCmShowStore(@Nullable String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_open_store", localBundle, (EIPCResultCallback)CmShowSDKPlatformImpl.openCmShowStore.1.a);
  }
  
  public void preLoadRes(@Nullable ArrayList<String> paramArrayList, @Nullable int[] paramArrayOfInt)
  {
    QLog.d("CmShowSDKPlatform", 1, new Object[] { "preLoadRes uins:", paramArrayList });
    Bundle localBundle = new Bundle();
    localBundle.putIntArray("actionIds", paramArrayOfInt);
    localBundle.putStringArrayList("uins", paramArrayList);
    QIPCClientHelper.getInstance().callServer("cm_game_module", "action_render_view_preload_res", localBundle, (EIPCResultCallback)CmShowSDKPlatformImpl.preLoadRes.1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.sdk.impl.CmShowSDKPlatformImpl
 * JD-Core Version:    0.7.0.1
 */