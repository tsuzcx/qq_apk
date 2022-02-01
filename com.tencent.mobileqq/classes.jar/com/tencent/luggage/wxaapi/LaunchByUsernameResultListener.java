package com.tencent.luggage.wxaapi;

import org.jetbrains.annotations.Nullable;

public abstract interface LaunchByUsernameResultListener
{
  public abstract void onLaunchResult(@Nullable String paramString, int paramInt, long paramLong, LaunchWxaAppResult paramLaunchWxaAppResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxaapi.LaunchByUsernameResultListener
 * JD-Core Version:    0.7.0.1
 */