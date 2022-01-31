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
    return Honeycomb.getAlpha(paramView);
  }
  
  public static float getPivotX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getPivotX();
    }
    return Honeycomb.getPivotX(paramView);
  }
  
  public static float getPivotY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getPivotY();
    }
    return Honeycomb.getPivotY(paramView);
  }
  
  public static float getRotation(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getRotation();
    }
    return Honeycomb.getRotation(paramView);
  }
  
  public static float getRotationX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getRotationX();
    }
    return Honeycomb.getRotationX(paramView);
  }
  
  public static float getRotationY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getRotationY();
    }
    return Honeycomb.getRotationY(paramView);
  }
  
  public static float getScaleX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getScaleX();
    }
    return Honeycomb.getScaleX(paramView);
  }
  
  public static float getScaleY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getScaleY();
    }
    return Honeycomb.getScaleY(paramView);
  }
  
  public static float getScrollX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getScrollX();
    }
    return Honeycomb.getScrollX(paramView);
  }
  
  public static float getScrollY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getScrollY();
    }
    return Honeycomb.getScrollY(paramView);
  }
  
  public static float getTranslationX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getTranslationX();
    }
    return Honeycomb.getTranslationX(paramView);
  }
  
  public static float getTranslationY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getTranslationY();
    }
    return Honeycomb.getTranslationY(paramView);
  }
  
  public static float getX(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getX();
    }
    return Honeycomb.getX(paramView);
  }
  
  public static float getY(View paramView)
  {
    if (AnimatorProxy.NEEDS_PROXY) {
      return AnimatorProxy.wrap(paramView).getY();
    }
    return Honeycomb.getY(paramView);
  }
  
  public static void setAlpha(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setAlpha(paramFloat);
      return;
    }
    Honeycomb.setAlpha(paramView, paramFloat);
  }
  
  public static void setPivotX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setPivotX(paramFloat);
      return;
    }
    Honeycomb.setPivotX(paramView, paramFloat);
  }
  
  public static void setPivotY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setPivotY(paramFloat);
      return;
    }
    Honeycomb.setPivotY(paramView, paramFloat);
  }
  
  public static void setRotation(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setRotation(paramFloat);
      return;
    }
    Honeycomb.setRotation(paramView, paramFloat);
  }
  
  public static void setRotationX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setRotationX(paramFloat);
      return;
    }
    Honeycomb.setRotationX(paramView, paramFloat);
  }
  
  public static void setRotationY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setRotationY(paramFloat);
      return;
    }
    Honeycomb.setRotationY(paramView, paramFloat);
  }
  
  public static void setScaleX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setScaleX(paramFloat);
      return;
    }
    Honeycomb.setScaleX(paramView, paramFloat);
  }
  
  public static void setScaleY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setScaleY(paramFloat);
      return;
    }
    Honeycomb.setScaleY(paramView, paramFloat);
  }
  
  public static void setScrollX(View paramView, int paramInt)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setScrollX(paramInt);
      return;
    }
    Honeycomb.setScrollX(paramView, paramInt);
  }
  
  public static void setScrollY(View paramView, int paramInt)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setScrollY(paramInt);
      return;
    }
    Honeycomb.setScrollY(paramView, paramInt);
  }
  
  public static void setTranslationX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setTranslationX(paramFloat);
      return;
    }
    Honeycomb.setTranslationX(paramView, paramFloat);
  }
  
  public static void setTranslationY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setTranslationY(paramFloat);
      return;
    }
    Honeycomb.setTranslationY(paramView, paramFloat);
  }
  
  public static void setX(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setX(paramFloat);
      return;
    }
    Honeycomb.setX(paramView, paramFloat);
  }
  
  public static void setY(View paramView, float paramFloat)
  {
    if (AnimatorProxy.NEEDS_PROXY)
    {
      AnimatorProxy.wrap(paramView).setY(paramFloat);
      return;
    }
    Honeycomb.setY(paramView, paramFloat);
  }
  
  private static final class Honeycomb
  {
    static float getAlpha(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getAlpha();
    }
    
    static float getPivotX(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getPivotX();
    }
    
    static float getPivotY(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getPivotY();
    }
    
    static float getRotation(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getRotation();
    }
    
    static float getRotationX(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getRotationX();
    }
    
    static float getRotationY(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getRotationY();
    }
    
    static float getScaleX(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getScaleX();
    }
    
    static float getScaleY(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getScaleY();
    }
    
    static float getScrollX(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getScrollX();
    }
    
    static float getScrollY(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getScrollY();
    }
    
    static float getTranslationX(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getTranslationX();
    }
    
    static float getTranslationY(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getTranslationY();
    }
    
    static float getX(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getX();
    }
    
    static float getY(View paramView)
    {
      return AnimatorProxy.wrap(paramView).getY();
    }
    
    static void setAlpha(View paramView, float paramFloat)
    {
      AnimatorProxy.wrap(paramView).setAlpha(paramFloat);
    }
    
    static void setPivotX(View paramView, float paramFloat)
    {
      AnimatorProxy.wrap(paramView).setPivotX(paramFloat);
    }
    
    static void setPivotY(View paramView, float paramFloat)
    {
      AnimatorProxy.wrap(paramView).setPivotY(paramFloat);
    }
    
    static void setRotation(View paramView, float paramFloat)
    {
      AnimatorProxy.wrap(paramView).setRotation(paramFloat);
    }
    
    static void setRotationX(View paramView, float paramFloat)
    {
      AnimatorProxy.wrap(paramView).setRotationX(paramFloat);
    }
    
    static void setRotationY(View paramView, float paramFloat)
    {
      AnimatorProxy.wrap(paramView).setRotationY(paramFloat);
    }
    
    static void setScaleX(View paramView, float paramFloat)
    {
      AnimatorProxy.wrap(paramView).setScaleX(paramFloat);
    }
    
    static void setScaleY(View paramView, float paramFloat)
    {
      AnimatorProxy.wrap(paramView).setScaleY(paramFloat);
    }
    
    static void setScrollX(View paramView, int paramInt)
    {
      AnimatorProxy.wrap(paramView).setScrollX(paramInt);
    }
    
    static void setScrollY(View paramView, int paramInt)
    {
      AnimatorProxy.wrap(paramView).setScrollY(paramInt);
    }
    
    static void setTranslationX(View paramView, float paramFloat)
    {
      AnimatorProxy.wrap(paramView).setTranslationX(paramFloat);
    }
    
    static void setTranslationY(View paramView, float paramFloat)
    {
      AnimatorProxy.wrap(paramView).setTranslationY(paramFloat);
    }
    
    static void setX(View paramView, float paramFloat)
    {
      AnimatorProxy.wrap(paramView).setX(paramFloat);
    }
    
    static void setY(View paramView, float paramFloat)
    {
      AnimatorProxy.wrap(paramView).setY(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.nineoldandroids.view.ViewHelper
 * JD-Core Version:    0.7.0.1
 */