package com.tencent.mobileqq.apollo.api;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.apollo.api.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.api.render.IRenderRunner;
import com.tencent.mobileqq.apollo.game.rankList.CmGameUserInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Service(needUin=false, process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/IApolloCmdChannel;", "Lmqq/app/api/IRuntimeService;", "addCmdHandler", "", "requestHandler", "Lcom/tencent/mobileqq/apollo/api/channel/IRequestHandler;", "addRenderRunner", "renderRunner", "Lcom/tencent/mobileqq/apollo/api/render/IRenderRunner;", "callbackDirect", "jsRuntime", "", "lState", "", "errCode", "", "cmd", "", "respData", "callbackEngine", "callbackEngineWrapper", "callbackFromRequest", "callbackGetHead", "data", "Landroid/graphics/Bitmap;", "openId", "type", "jsContext", "callbackGetNick", "nick", "checkSetNative", "destroyMusic", "getOpenApiHead", "dir", "openid", "getOpenApiNick", "handleWebEvent", "gameId", "makesureHasInitObj", "nativeOpenApiGetHeadCallBack", "dirctor", "code", "w", "h", "head", "", "nativeOpenApiGetNickCallBack", "playMusicInner", "hash", "audioAddr", "removeCmdHandler", "removeRenderRunner", "requestData", "jsState", "reqData", "async", "isCallFromJsRuntime", "setActivityContext", "activity", "Landroid/app/Activity;", "updateUserInfo", "info", "Lcom/tencent/mobileqq/apollo/game/rankList/CmGameUserInfo;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloCmdChannel
  extends IRuntimeService
{
  public abstract void addCmdHandler(@NotNull IRequestHandler paramIRequestHandler);
  
  public abstract void addRenderRunner(@NotNull IRenderRunner paramIRenderRunner);
  
  public abstract void callbackDirect(boolean paramBoolean, long paramLong, int paramInt, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void callbackEngine(long paramLong, int paramInt, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void callbackEngineWrapper(boolean paramBoolean, long paramLong, int paramInt, @Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void callbackFromRequest(long paramLong, int paramInt, @NotNull String paramString1, @NotNull String paramString2);
  
  public abstract void callbackGetHead(@NotNull Bitmap paramBitmap, @NotNull String paramString, int paramInt, long paramLong);
  
  public abstract void callbackGetNick(@NotNull String paramString1, @NotNull String paramString2, int paramInt, long paramLong);
  
  public abstract void checkSetNative();
  
  public abstract void destroyMusic();
  
  public abstract void getOpenApiHead(long paramLong, @Nullable String paramString);
  
  public abstract void getOpenApiNick(long paramLong, @Nullable String paramString);
  
  public abstract void handleWebEvent(@NotNull String paramString, int paramInt);
  
  public abstract void makesureHasInitObj();
  
  public abstract void nativeOpenApiGetHeadCallBack(long paramLong, @Nullable String paramString, int paramInt1, int paramInt2, int paramInt3, @Nullable byte[] paramArrayOfByte);
  
  public abstract void nativeOpenApiGetNickCallBack(long paramLong, @Nullable String paramString1, int paramInt, @Nullable String paramString2);
  
  public abstract void playMusicInner(@Nullable IRenderRunner paramIRenderRunner, int paramInt, long paramLong);
  
  public abstract void removeCmdHandler(@NotNull IRequestHandler paramIRequestHandler);
  
  public abstract void removeRenderRunner(@NotNull IRenderRunner paramIRenderRunner);
  
  @NotNull
  public abstract String requestData(long paramLong, @NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setActivityContext(@NotNull Activity paramActivity);
  
  public abstract void updateUserInfo(@Nullable CmGameUserInfo paramCmGameUserInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.IApolloCmdChannel
 * JD-Core Version:    0.7.0.1
 */