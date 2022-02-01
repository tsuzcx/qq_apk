package com.tencent.mobileqq.apollo.meme;

import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class IMemePlayerListener$DefaultImpls
{
  public static void a(IMemePlayerListener paramIMemePlayerListener, @NotNull MemeAction paramMemeAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramMemeAction, "action");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.IMemePlayerListener.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */