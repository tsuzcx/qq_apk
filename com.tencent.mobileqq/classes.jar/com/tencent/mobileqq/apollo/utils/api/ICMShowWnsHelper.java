package com.tencent.mobileqq.apollo.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/api/ICMShowWnsHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "enableCmshowAvatar", "", "getCmshowAvatar3DSwitch", "getCmshowAvatarTitle", "", "getCmshowMemeCacheKey", "", "isCmShowMemeTabInFaceEnabled", "runOnCrossEngineForMemePlayer", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface ICMShowWnsHelper
  extends QRouteApi
{
  public abstract boolean enableCmshowAvatar();
  
  public abstract boolean getCmshowAvatar3DSwitch();
  
  @NotNull
  public abstract String getCmshowAvatarTitle();
  
  public abstract int getCmshowMemeCacheKey();
  
  public abstract boolean isCmShowMemeTabInFaceEnabled();
  
  public abstract boolean runOnCrossEngineForMemePlayer();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.ICMShowWnsHelper
 * JD-Core Version:    0.7.0.1
 */