package com.qq.android.dexposed.utility;

import android.util.Log;

public class NeverCalled
{
  private void fake(int paramInt)
  {
    String str = getClass().getSimpleName();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramInt));
    localStringBuilder.append("Do not inline me!!");
    Log.i(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.utility.NeverCalled
 * JD-Core Version:    0.7.0.1
 */