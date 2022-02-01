package com.tencent.component.animation.rebound;

import android.os.Build.VERSION;

abstract class AndroidSpringLooperFactory
{
  public static SpringLooper createSpringLooper()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.create();
    }
    return AndroidSpringLooperFactory.LegacyAndroidSpringLooper.create();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.animation.rebound.AndroidSpringLooperFactory
 * JD-Core Version:    0.7.0.1
 */