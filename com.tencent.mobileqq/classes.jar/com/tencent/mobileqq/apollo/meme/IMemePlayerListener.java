package com.tencent.mobileqq.apollo.meme;

import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/meme/IMemePlayerListener;", "", "onRecordDone", "", "action", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "success", "", "recordKey", "", "recordPath", "onRecordFrame", "index", "", "pixels", "", "width", "height", "frameTime", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface IMemePlayerListener
{
  public abstract void a(@NotNull MemeAction paramMemeAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(@NotNull MemeAction paramMemeAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.IMemePlayerListener
 * JD-Core Version:    0.7.0.1
 */