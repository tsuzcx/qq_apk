package com.tencent.mobileqq.apollo.player;

import com.tencent.mobileqq.apollo.player.action.CMSAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/player/IGetGifFrameCallback;", "", "onComplete", "", "success", "", "path", "", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IGetGifFrameCallback
{
  public abstract void a(boolean paramBoolean, @Nullable String paramString, @NotNull CMSAction paramCMSAction);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.IGetGifFrameCallback
 * JD-Core Version:    0.7.0.1
 */