package com.tencent.aekit.api.standard.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.ttpic.filter.BeautyBodyFilter;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.util.youtu.bodydetector.BodyDetectResult;
import java.util.ArrayList;
import java.util.List;

public class AEBodyBeauty
  extends AEChainI
{
  public static final int BODY_BEAUTY_LONG_LEG = 1;
  public static final int BODY_BEAUTY_SLIM_WAIST = 2;
  public static final int BODY_BEAUTY_THIN_BODY = 3;
  public static final int BODY_BEAUTY_THIN_SHOULDER = 4;
  private static final String TAG = AEBodyBeauty.class.getSimpleName();
  private List<PointF> bodyPoints = null;
  private boolean longLegEnabled = false;
  private float longLegLevel = 0.0F;
  private BeautyBodyFilter mBeautyBodyFilter = new BeautyBodyFilter();
  private boolean slimWaistEnabled = false;
  private float slimWaistLevel = 0.0F;
  private boolean thinBodyEnabled = false;
  private float thinBodyLevel = 0.0F;
  private boolean thinShoulderEnabled = false;
  private float thinShoulderLevel = 0.0F;
  
  public void apply()
  {
    if (!this.mIsApplied) {
      this.mBeautyBodyFilter.ApplyGLSLFilter();
    }
  }
  
  public void clear()
  {
    this.mBeautyBodyFilter.clearGLSLSelf();
    this.mIsApplied = false;
    this.longLegEnabled = false;
    this.slimWaistEnabled = false;
    this.thinBodyEnabled = false;
    this.thinShoulderEnabled = false;
    this.longLegLevel = 0.0F;
    this.slimWaistLevel = 0.0F;
    this.thinBodyLevel = 0.0F;
    this.thinShoulderLevel = 0.0F;
  }
  
  public boolean isEnabled()
  {
    return (this.bodyPoints != null) && ((this.longLegEnabled) || (this.slimWaistEnabled) || (this.thinBodyEnabled) || (this.thinShoulderEnabled));
  }
  
  public boolean isValid()
  {
    return this.mBeautyBodyFilter.isValid();
  }
  
  public String printParamInfo()
  {
    return "AEBodyBeauty {TAG =AEBodyBeauty , longLegLevel='" + this.longLegLevel + ", slimWaistLevel=" + this.slimWaistLevel + ", thinBodyLevel=" + this.thinBodyLevel + ", thinShoulderLevel=" + this.thinShoulderLevel + '}';
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
      this.longLegEnabled = bool1;
      this.longLegLevel = f;
      this.mBeautyBodyFilter.setStrength("LONG_LEG", f);
      return;
      bool1 = false;
    }
    if (f != 0.0F) {}
    for (bool1 = bool2;; bool1 = false)
    {
      this.slimWaistEnabled = bool1;
      this.slimWaistLevel = f;
      this.mBeautyBodyFilter.setStrength("SLIM_WAIST", f);
      return;
    }
    if (f != 0.0F) {}
    for (bool1 = bool3;; bool1 = false)
    {
      this.thinBodyEnabled = bool1;
      this.thinBodyLevel = f;
      this.mBeautyBodyFilter.setStrength("THIN_BODY", f);
      return;
    }
    if (f != 0.0F) {}
    for (bool1 = bool4;; bool1 = false)
    {
      this.thinShoulderEnabled = bool1;
      this.thinShoulderLevel = f;
      this.mBeautyBodyFilter.setStrength("THIN_SHOULDER", f);
      return;
    }
  }
  
  public void setBodyBeautyStrength(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    int i;
    if (paramInt < 0) {
      i = 0;
    }
    float f;
    for (;;)
    {
      f = i / 100.0F;
      switch (AEBodyBeauty.1.$SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[paramTYPE.ordinal()])
      {
      default: 
        return;
        i = paramInt;
        if (paramInt > 100) {
          i = 100;
        }
        break;
      }
    }
    bool1 = bool2;
    if (f != 0.0F) {
      bool1 = true;
    }
    this.longLegEnabled = bool1;
    this.longLegLevel = f;
    this.mBeautyBodyFilter.setStrength("LONG_LEG", f);
    return;
    if (f != 0.0F) {}
    for (;;)
    {
      this.slimWaistEnabled = bool1;
      this.slimWaistLevel = f;
      this.mBeautyBodyFilter.setStrength("SLIM_WAIST", f);
      return;
      bool1 = false;
    }
    if (f != 0.0F) {}
    for (bool1 = bool3;; bool1 = false)
    {
      this.thinBodyEnabled = bool1;
      this.thinBodyLevel = f;
      this.mBeautyBodyFilter.setStrength("THIN_BODY", f);
      return;
    }
    if (f != 0.0F) {}
    for (bool1 = bool4;; bool1 = false)
    {
      this.thinShoulderEnabled = bool1;
      this.thinShoulderLevel = f;
      this.mBeautyBodyFilter.setStrength("THIN_SHOULDER", f);
      return;
    }
  }
  
  public void setBodyPoints(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    this.bodyPoints = paramList;
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.mBeautyBodyFilter.beautyBody(paramList, paramInt1, paramInt2);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mBeautyBodyFilter.setRenderMode(paramInt);
  }
  
  public void updateAIAttr(AIAttr paramAIAttr)
  {
    if (paramAIAttr != null)
    {
      List localList = (List)paramAIAttr.getAvailableData(AEDetectorType.BODY.value);
      if ((localList != null) && (localList.size() > 0))
      {
        ArrayList localArrayList = new ArrayList();
        localList = ((BodyDetectResult)localList.get(0)).bodyPoints;
        int i = 0;
        while (i < localList.size())
        {
          localArrayList.add(new PointF());
          ((PointF)localArrayList.get(i)).x = ((PointF)localList.get(i)).x;
          ((PointF)localArrayList.get(i)).y = ((PointF)localList.get(i)).y;
          i += 1;
        }
        setBodyPoints(localArrayList, paramAIAttr.getTexWidth(), paramAIAttr.getTexHeight());
      }
    }
    else
    {
      return;
    }
    setBodyPoints(null, paramAIAttr.getTexWidth(), paramAIAttr.getTexHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEBodyBeauty
 * JD-Core Version:    0.7.0.1
 */