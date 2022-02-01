package com.tencent.mobileqq.apollo.player.manager;

import android.util.Pair;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.cmshow.engine.render.IRecordFrameListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayer$CMSActionContext$1", "Lcom/tencent/mobileqq/cmshow/engine/render/IRecordFrameListener;", "getViewSize", "Landroid/util/Pair;", "", "kotlin.jvm.PlatformType", "onRecordFrameEnd", "", "actionComplete", "onRecordFrameStart", "frameTime", "", "onRecordSingleFrame", "pixels", "", "width", "height", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayer$CMSActionContext$1
  implements IRecordFrameListener
{
  @NotNull
  public Pair<Integer, Integer> a()
  {
    return new Pair(Integer.valueOf(this.a.a()), Integer.valueOf(this.a.b()));
  }
  
  public boolean a(float paramFloat)
  {
    return this.a.a().a(paramFloat);
  }
  
  public boolean a(boolean paramBoolean)
  {
    return this.a.a().a(paramBoolean);
  }
  
  public boolean a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    return this.a.a().a(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSActionContext.1
 * JD-Core Version:    0.7.0.1
 */