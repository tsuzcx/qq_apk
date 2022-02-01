package com.tencent.mobileqq.apollo.player;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/CMSPlayer$Companion;", "", "()V", "BRICK_ENGINE_FRAME_MINIMUM", "", "TAG", "", "adapterToBrickFrameInterval", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMSPlayer$Companion
{
  private final float a(float paramFloat)
  {
    float f = paramFloat / 1000.0F;
    paramFloat = f;
    if (f < 0.03333334F) {
      paramFloat = 0.03333334F;
    }
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSPlayer.Companion
 * JD-Core Version:    0.7.0.1
 */