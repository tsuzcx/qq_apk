package com.qq.android.dexposed.utility;

import android.util.Log;

public class NeverCalled
{
  private void fake(int paramInt)
  {
    Log.i(getClass().getSimpleName(), paramInt + "Do not inline me!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.utility.NeverCalled
 * JD-Core Version:    0.7.0.1
 */