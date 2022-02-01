package com.tencent.biz.qcircleshadow.lib;

import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;

public class QCircleHostZipHelper
{
  public static Animatable createZipAnimationDrawable(String paramString, int paramInt, Drawable.Callback paramCallback)
  {
    Drawable localDrawable = ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(localDrawable, paramString, paramInt);
    localDrawable.setCallback(paramCallback);
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setScale(localDrawable, ViewUtils.getScreenWidth() / 720.0F);
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(localDrawable);
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(localDrawable, true);
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(localDrawable, true);
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).start(localDrawable);
    return (Animatable)localDrawable;
  }
  
  public static void draw(Animatable paramAnimatable, Canvas paramCanvas)
  {
    if ((paramAnimatable != null) && (((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).isZipAnimationDrawable(paramAnimatable))) {
      ((Drawable)paramAnimatable).draw(paramCanvas);
    }
  }
  
  public static void release(Animatable paramAnimatable)
  {
    if ((paramAnimatable != null) && (((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).isZipAnimationDrawable(paramAnimatable))) {
      ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).release(paramAnimatable);
    }
  }
  
  public static void setBounds(Animatable paramAnimatable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramAnimatable != null) && (((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).isZipAnimationDrawable(paramAnimatable))) {
      ((Drawable)paramAnimatable).setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostZipHelper
 * JD-Core Version:    0.7.0.1
 */