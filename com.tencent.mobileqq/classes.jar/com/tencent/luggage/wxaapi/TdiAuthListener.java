package com.tencent.luggage.wxaapi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface TdiAuthListener
{
  public abstract void onAuthFinish(@NotNull TdiAuthErrCode paramTdiAuthErrCode, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxaapi.TdiAuthListener
 * JD-Core Version:    0.7.0.1
 */