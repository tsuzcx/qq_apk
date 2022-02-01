package com.tencent.mobileqq.apollo.meme;

import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/IGetGifFrameCallback;", "", "onComplete", "", "success", "", "path", "", "action", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IGetGifFrameCallback
{
  public abstract void a(boolean paramBoolean, @Nullable String paramString, @NotNull MemeAction paramMemeAction);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.IGetGifFrameCallback
 * JD-Core Version:    0.7.0.1
 */