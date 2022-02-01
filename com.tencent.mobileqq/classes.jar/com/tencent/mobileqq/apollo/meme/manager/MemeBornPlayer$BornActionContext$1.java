package com.tencent.mobileqq.apollo.meme.manager;

import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController;
import com.tencent.mobileqq.cmshow.engine.render.IRecordFrameListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/meme/manager/MemeBornPlayer$BornActionContext$1", "Lcom/tencent/mobileqq/cmshow/engine/render/IRecordFrameListener;", "getAction", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "onRecordFrameEnd", "", "actionComplete", "onRecordFrameStart", "frameTime", "", "onRecordSingleFrame", "pixels", "", "width", "", "height", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class MemeBornPlayer$BornActionContext$1
  implements IRecordFrameListener
{
  @NotNull
  public MemeAction a()
  {
    return this.a.k();
  }
  
  public boolean a(float paramFloat)
  {
    return this.a.g().a(paramFloat);
  }
  
  public boolean a(boolean paramBoolean)
  {
    return this.a.g().a(paramBoolean);
  }
  
  public boolean a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    return this.a.g().a(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayer.BornActionContext.1
 * JD-Core Version:    0.7.0.1
 */