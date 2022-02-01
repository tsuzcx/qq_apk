package com.tencent.luggage.wxaapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface WxaApi
{
  public abstract void addWxaAppCloseEventListener(WxaAppCloseEventListener paramWxaAppCloseEventListener);
  
  public abstract void checkAuthState(TdiAuthCheckStateListener paramTdiAuthCheckStateListener);
  
  public abstract boolean checkIfWechatSupportWxaApi();
  
  public abstract void clearAuth();
  
  public abstract void closeWxaApp(@NotNull String paramString, boolean paramBoolean);
  
  public abstract DebugApi getDebugApi();
  
  public abstract String getSDKVersion();
  
  public abstract int getSDKVersionInt();
  
  public abstract String getTdiUserId();
  
  public abstract boolean handleIntent(Context paramContext, Intent paramIntent);
  
  public abstract InitDynamicPkgResult initDynamicPkg(String paramString);
  
  public abstract boolean isDynamicPkgLoaded();
  
  public abstract long launchByQRRawData(@Nullable Context paramContext, @NonNull String paramString, @Nullable Map<String, Object> paramMap, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener);
  
  public abstract long launchByQRScanCode(@Nullable Context paramContext, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener);
  
  public abstract long launchByQRScanCode(@Nullable Context paramContext, @Nullable Map<String, Object> paramMap, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener);
  
  public abstract long launchByUsername(@Nullable Context paramContext, @NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable LaunchByUsernameResultListener paramLaunchByUsernameResultListener);
  
  public abstract long launchByUsername(@Nullable Context paramContext, @NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable Map<String, Object> paramMap, @Nullable LaunchByUsernameResultListener paramLaunchByUsernameResultListener);
  
  public abstract long launchWxaApp(@Nullable Context paramContext, @NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener);
  
  public abstract long launchWxaApp(@Nullable Context paramContext, @NotNull String paramString1, int paramInt, @Nullable String paramString2, @Nullable Map<String, Object> paramMap, @Nullable LaunchWxaAppResultListener paramLaunchWxaAppResultListener);
  
  public abstract void launchWxaByShortLink(@NotNull Activity paramActivity, @NotNull String paramString, boolean paramBoolean, @Nullable LaunchWxaAppWithShortLinkResultListener paramLaunchWxaAppWithShortLinkResultListener);
  
  public abstract void launchWxaByShortLink(@NotNull Activity paramActivity, @NotNull String paramString, boolean paramBoolean, @Nullable Map<String, Object> paramMap, LaunchWxaAppWithShortLinkResultListener paramLaunchWxaAppWithShortLinkResultListener);
  
  public abstract void preloadWxaProcessEnv(int paramInt, @Nullable PreloadWxaProcessEnvResultListener paramPreloadWxaProcessEnvResultListener);
  
  public abstract void removeWxaAppCloseEventListener(WxaAppCloseEventListener paramWxaAppCloseEventListener);
  
  public abstract void requestUploadLogFiles(int paramInt1, int paramInt2, @Nullable UploadLogResultListener paramUploadLogResultListener);
  
  public abstract void sendAuth(TdiAuthListener paramTdiAuthListener);
  
  public abstract void sendCombineAuth(SendAuth.Req paramReq, IWXAPIEventHandler paramIWXAPIEventHandler, TdiAuthListener paramTdiAuthListener);
  
  public abstract void setWxaProcessMaxCount(int paramInt);
  
  public abstract void updateTuringOAID(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxaapi.WxaApi
 * JD-Core Version:    0.7.0.1
 */