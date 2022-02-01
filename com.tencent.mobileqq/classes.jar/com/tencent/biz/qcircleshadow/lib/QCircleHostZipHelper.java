package com.tencent.biz.qcircleshadow.lib;

import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;

public class QCircleHostZipHelper
{
  public static Animatable createZipAnimationDrawable(String paramString, int paramInt, Drawable.Callback paramCallback)
  {
    return QCircleServiceImpl.getQZoneService().createZipAnimationDrawable(paramString, paramInt, paramCallback);
  }
  
  public static void draw(Animatable paramAnimatable, Canvas paramCanvas)
  {
    QCircleServiceImpl.getQZoneService().draw(paramAnimatable, paramCanvas);
  }
  
  public static void release(Animatable paramAnimatable)
  {
    QCircleServiceImpl.getQZoneService().release(paramAnimatable);
  }
  
  public static void setBounds(Animatable paramAnimatable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QCircleServiceImpl.getQZoneService().setBounds(paramAnimatable, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostZipHelper
 * JD-Core Version:    0.7.0.1
 */