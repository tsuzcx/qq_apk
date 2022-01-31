package com.tencent.aekit.api.standard.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.filter.BeautyBodyFilter;
import java.util.List;

public class AEBodyBeauty
  extends AEChainI
{
  public static final int BODY_BEAUTY_LONG_LEG = 1;
  public static final int BODY_BEAUTY_SLIM_WAIST = 2;
  public static final int BODY_BEAUTY_THIN_BODY = 3;
  public static final int BODY_BEAUTY_THIN_SHOULDER = 4;
  private static final String TAG = AEBodyBeauty.class.getSimpleName();
  private boolean longLetEnabled = false;
  private BeautyBodyFilter mBeautyBodyFilter = new BeautyBodyFilter();
  private boolean slimWaistEnabled = false;
  private boolean thinBodyEnabled = false;
  private boolean thinShoulderEnabled = false;
  
  public void apply()
  {
    this.mBeautyBodyFilter.ApplyGLSLFilter();
  }
  
  public void clear()
  {
    this.mBeautyBodyFilter.clearGLSLSelf();
  }
  
  public boolean isEnabled()
  {
    return (this.longLetEnabled) || (this.slimWaistEnabled) || (this.thinBodyEnabled) || (this.thinShoulderEnabled);
  }
  
  public boolean isValid()
  {
    return this.mBeautyBodyFilter.isValid();
  }
  
  public Frame render(Frame paramFrame)
  {
    if (!isEnabled()) {
      return paramFrame;
    }
    return this.mBeautyBodyFilter.render(paramFrame);
  }
  
  public void setBodyBeautyStrength(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    int i;
    if (paramInt2 < 0) {
      i = 0;
    }
    float f;
    for (;;)
    {
      f = i / 100.0F;
      switch (paramInt1)
      {
      default: 
        return;
        i = paramInt2;
        if (paramInt2 > 100) {
          i = 100;
        }
        break;
      }
    }
    if (f != 0.0F) {}
    for (;;)
    {
      this.longLetEnabled = bool1;
      this.mBeautyBodyFilter.setStrength("LONG_LEG", f);
      return;
      bool1 = false;
    }
    if (f != 0.0F) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.slimWaistEnabled = bool1;
      this.mBeautyBodyFilter.setStrength("SLIM_WAIST", f);
      return;
    }
    if (f != 0.0F) {}
    for (bool1 = bool3;; bool1 = false)
    {
      this.thinBodyEnabled = bool1;
      this.mBeautyBodyFilter.setStrength("THIN_BODY", f);
      return;
    }
    if (f != 0.0F) {}
    for (bool1 = bool4;; bool1 = false)
    {
      this.thinShoulderEnabled = bool1;
      this.mBeautyBodyFilter.setStrength("THIN_SHOULDER", f);
      return;
    }
  }
  
  public void setBodyPoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    this.mBeautyBodyFilter.beautyBody(paramList, paramInt1, paramInt2);
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mBeautyBodyFilter.setRenderMode(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEBodyBeauty
 * JD-Core Version:    0.7.0.1
 */