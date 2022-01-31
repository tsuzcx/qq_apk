package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;

class ViewCompat$HCViewCompatImpl
  extends ViewCompat.GBViewCompatImpl
{
  public int combineMeasuredStates(int paramInt1, int paramInt2)
  {
    return ViewCompatHC.combineMeasuredStates(paramInt1, paramInt2);
  }
  
  public float getAlpha(View paramView)
  {
    return ViewCompatHC.getAlpha(paramView);
  }
  
  long getFrameTime()
  {
    return ViewCompatHC.getFrameTime();
  }
  
  public int getLayerType(View paramView)
  {
    return ViewCompatHC.getLayerType(paramView);
  }
  
  public int getMeasuredHeightAndState(View paramView)
  {
    return ViewCompatHC.getMeasuredHeightAndState(paramView);
  }
  
  public int getMeasuredState(View paramView)
  {
    return ViewCompatHC.getMeasuredState(paramView);
  }
  
  public int getMeasuredWidthAndState(View paramView)
  {
    return ViewCompatHC.getMeasuredWidthAndState(paramView);
  }
  
  public float getPivotX(View paramView)
  {
    return ViewCompatHC.getPivotX(paramView);
  }
  
  public float getPivotY(View paramView)
  {
    return ViewCompatHC.getPivotY(paramView);
  }
  
  public float getRotation(View paramView)
  {
    return ViewCompatHC.getRotation(paramView);
  }
  
  public float getRotationX(View paramView)
  {
    return ViewCompatHC.getRotationX(paramView);
  }
  
  public float getRotationY(View paramView)
  {
    return ViewCompatHC.getRotationY(paramView);
  }
  
  public float getScaleX(View paramView)
  {
    return ViewCompatHC.getScaleX(paramView);
  }
  
  public float getScaleY(View paramView)
  {
    return ViewCompatHC.getScaleY(paramView);
  }
  
  public float getTranslationX(View paramView)
  {
    return ViewCompatHC.getTranslationX(paramView);
  }
  
  public float getTranslationY(View paramView)
  {
    return ViewCompatHC.getTranslationY(paramView);
  }
  
  public float getX(View paramView)
  {
    return ViewCompatHC.getX(paramView);
  }
  
  public float getY(View paramView)
  {
    return ViewCompatHC.getY(paramView);
  }
  
  public void jumpDrawablesToCurrentState(View paramView)
  {
    ViewCompatHC.jumpDrawablesToCurrentState(paramView);
  }
  
  public void offsetLeftAndRight(View paramView, int paramInt)
  {
    ViewCompatHC.offsetLeftAndRight(paramView, paramInt);
  }
  
  public void offsetTopAndBottom(View paramView, int paramInt)
  {
    ViewCompatHC.offsetTopAndBottom(paramView, paramInt);
  }
  
  public int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return ViewCompatHC.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }
  
  public void setActivated(View paramView, boolean paramBoolean)
  {
    ViewCompatHC.setActivated(paramView, paramBoolean);
  }
  
  public void setAlpha(View paramView, float paramFloat)
  {
    ViewCompatHC.setAlpha(paramView, paramFloat);
  }
  
  public void setLayerPaint(View paramView, Paint paramPaint)
  {
    setLayerType(paramView, getLayerType(paramView), paramPaint);
    paramView.invalidate();
  }
  
  public void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    ViewCompatHC.setLayerType(paramView, paramInt, paramPaint);
  }
  
  public void setPivotX(View paramView, float paramFloat)
  {
    ViewCompatHC.setPivotX(paramView, paramFloat);
  }
  
  public void setPivotY(View paramView, float paramFloat)
  {
    ViewCompatHC.setPivotY(paramView, paramFloat);
  }
  
  public void setRotation(View paramView, float paramFloat)
  {
    ViewCompatHC.setRotation(paramView, paramFloat);
  }
  
  public void setRotationX(View paramView, float paramFloat)
  {
    ViewCompatHC.setRotationX(paramView, paramFloat);
  }
  
  public void setRotationY(View paramView, float paramFloat)
  {
    ViewCompatHC.setRotationY(paramView, paramFloat);
  }
  
  public void setSaveFromParentEnabled(View paramView, boolean paramBoolean)
  {
    ViewCompatHC.setSaveFromParentEnabled(paramView, paramBoolean);
  }
  
  public void setScaleX(View paramView, float paramFloat)
  {
    ViewCompatHC.setScaleX(paramView, paramFloat);
  }
  
  public void setScaleY(View paramView, float paramFloat)
  {
    ViewCompatHC.setScaleY(paramView, paramFloat);
  }
  
  public void setTranslationX(View paramView, float paramFloat)
  {
    ViewCompatHC.setTranslationX(paramView, paramFloat);
  }
  
  public void setTranslationY(View paramView, float paramFloat)
  {
    ViewCompatHC.setTranslationY(paramView, paramFloat);
  }
  
  public void setX(View paramView, float paramFloat)
  {
    ViewCompatHC.setX(paramView, paramFloat);
  }
  
  public void setY(View paramView, float paramFloat)
  {
    ViewCompatHC.setY(paramView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.HCViewCompatImpl
 * JD-Core Version:    0.7.0.1
 */