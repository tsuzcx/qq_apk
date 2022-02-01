package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.utils.api.ICMShowWnsHelper;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/utils/api/impl/CMShowWnsHelperImpl;", "Lcom/tencent/mobileqq/apollo/utils/api/ICMShowWnsHelper;", "()V", "enableCmshowAvatar", "", "getCmshowAvatar3DSwitch", "getCmshowAvatarTitle", "", "getCmshowMemeCacheKey", "", "isCmShowMemeEnabledForIceBreak", "isCmShowMemeTabInFaceEnabled", "runOnCrossEngineForMemePlayer", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMShowWnsHelperImpl
  implements ICMShowWnsHelper
{
  public boolean enableCmshowAvatar()
  {
    return CmShowWnsUtils.y();
  }
  
  public boolean getCmshowAvatar3DSwitch()
  {
    return CmShowWnsUtils.Q();
  }
  
  @NotNull
  public String getCmshowAvatarTitle()
  {
    String str = CmShowWnsUtils.S();
    Intrinsics.checkExpressionValueIsNotNull(str, "CmShowWnsUtils.getCmshowAvatarTitle()");
    return str;
  }
  
  public int getCmshowMemeCacheKey()
  {
    return CmShowWnsUtils.E();
  }
  
  public boolean isCmShowMemeEnabledForIceBreak()
  {
    return CmShowWnsUtils.H();
  }
  
  public boolean isCmShowMemeTabInFaceEnabled()
  {
    return CmShowWnsUtils.f();
  }
  
  public boolean runOnCrossEngineForMemePlayer()
  {
    return CMShowPlatform.a.b(Scene.MEME_PLAYER);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.CMShowWnsHelperImpl
 * JD-Core Version:    0.7.0.1
 */