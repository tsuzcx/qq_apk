package com.tencent.biz.qqstory.widget.circularreveal;

import android.animation.Animator;
import android.view.View;
import oqg;
import oqi;

public final class ViewAnimationCompatUtils
{
  public static Animator a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    return a(paramView, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6, 2);
  }
  
  public static Animator a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt)
  {
    oqg localoqg = oqg.a(paramView, paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    if (paramInt != paramView.getLayerType()) {
      localoqg.addListener(new oqi(paramView, paramInt));
    }
    return localoqg;
  }
  
  public static Animator a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    return a(paramView, paramInt1, paramInt2, paramFloat1, paramFloat2, 2);
  }
  
  public static Animator a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    oqg localoqg = oqg.a(paramView, paramInt1, paramInt2, paramFloat1, paramFloat2);
    if (paramInt3 != paramView.getLayerType()) {
      localoqg.addListener(new oqi(paramView, paramInt3));
    }
    return localoqg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.circularreveal.ViewAnimationCompatUtils
 * JD-Core Version:    0.7.0.1
 */