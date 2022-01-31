package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.view.animation.AnimatorProxy;

public final class ViewHelper
{
  public static float getAlpha(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getAlpha();
    }
    return ViewHelper.Honeycomb.getAlpha(paramView);
  }
  
  public static float getPivotX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getPivotX();
    }
    return ViewHelper.Honeycomb.getPivotX(paramView);
  }
  
  public static float getPivotY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getPivotY();
    }
    return ViewHelper.Honeycomb.getPivotY(paramView);
  }
  
  public static float getRotation(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getRotation();
    }
    return ViewHelper.Honeycomb.getRotation(paramView);
  }
  
  public static float getRotationX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getRotationX();
    }
    return ViewHelper.Honeycomb.getRotationX(paramView);
  }
  
  public static float getRotationY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getRotationY();
    }
    return ViewHelper.Honeycomb.getRotationY(paramView);
  }
  
  public static float getScaleX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getScaleX();
    }
    return ViewHelper.Honeycomb.getScaleX(paramView);
  }
  
  public static float getScaleY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getScaleY();
    }
    return ViewHelper.Honeycomb.getScaleY(paramView);
  }
  
  public static float getScrollX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getScrollX();
    }
    return ViewHelper.Honeycomb.getScrollX(paramView);
  }
  
  public static float getScrollY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getScrollY();
    }
    return ViewHelper.Honeycomb.getScrollY(paramView);
  }
  
  public static float getTranslationX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getTranslationX();
    }
    return ViewHelper.Honeycomb.getTranslationX(paramView);
  }
  
  public static float getTranslationY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getTranslationY();
    }
    return ViewHelper.Honeycomb.getTranslationY(paramView);
  }
  
  public static float getX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getX();
    }
    return ViewHelper.Honeycomb.getX(paramView);
  }
  
  public static float getY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getY();
    }
    return ViewHelper.Honeycomb.getY(paramView);
  }
  
  public static void setAlpha(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setAlpha(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setAlpha(paramView, paramFloat);
  }
  
  public static void setPivotX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setPivotX(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setPivotX(paramView, paramFloat);
  }
  
  public static void setPivotY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setPivotY(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setPivotY(paramView, paramFloat);
  }
  
  public static void setRotation(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setRotation(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setRotation(paramView, paramFloat);
  }
  
  public static void setRotationX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setRotationX(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setRotationX(paramView, paramFloat);
  }
  
  public static void setRotationY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setRotationY(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setRotationY(paramView, paramFloat);
  }
  
  public static void setScaleX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setScaleX(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setScaleX(paramView, paramFloat);
  }
  
  public static void setScaleY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setScaleY(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setScaleY(paramView, paramFloat);
  }
  
  public static void setScrollX(View paramView, int paramInt)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setScrollX(paramInt);
      return;
    }
    ViewHelper.Honeycomb.setScrollX(paramView, paramInt);
  }
  
  public static void setScrollY(View paramView, int paramInt)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setScrollY(paramInt);
      return;
    }
    ViewHelper.Honeycomb.setScrollY(paramView, paramInt);
  }
  
  public static void setTranslationX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setTranslationX(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setTranslationX(paramView, paramFloat);
  }
  
  public static void setTranslationY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setTranslationY(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setTranslationY(paramView, paramFloat);
  }
  
  public static void setX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setX(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setX(paramView, paramFloat);
  }
  
  public static void setY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setY(paramFloat);
      return;
    }
    ViewHelper.Honeycomb.setY(paramView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.nineoldandroids.view.ViewHelper
 * JD-Core Version:    0.7.0.1
 */