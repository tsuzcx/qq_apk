package com.tencent.aekit.api.standard.filter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.RemodelFilter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class AERemodel
  extends AEChainI
{
  private boolean inited;
  private PTFaceAttr mFaceAttr;
  private RemodelFilter mRemodelFilter = new RemodelFilter();
  private final HashSet<BeautyRealConfig.TYPE> remodelType = new HashSet(Arrays.asList(new BeautyRealConfig.TYPE[] { BeautyRealConfig.TYPE.FOREHEAD, BeautyRealConfig.TYPE.EYE, BeautyRealConfig.TYPE.EYE_DISTANCE, BeautyRealConfig.TYPE.EYE_ANGLE, BeautyRealConfig.TYPE.MOUTH_SHAPE, BeautyRealConfig.TYPE.CHIN, BeautyRealConfig.TYPE.FACE_THIN, BeautyRealConfig.TYPE.FACE_V, BeautyRealConfig.TYPE.NOSE_WING, BeautyRealConfig.TYPE.NOSE_POSITION, BeautyRealConfig.TYPE.LIPS_THICKNESS, BeautyRealConfig.TYPE.LIPS_WIDTH, BeautyRealConfig.TYPE.NOSE, BeautyRealConfig.TYPE.CHEEKBONE_THIN }));
  
  public void apply()
  {
    if (!this.inited)
    {
      this.mRemodelFilter.init();
      this.inited = true;
    }
  }
  
  public void clear()
  {
    this.mRemodelFilter.clear();
  }
  
  public boolean isValid()
  {
    return this.inited;
  }
  
  public Frame render(Frame paramFrame)
  {
    if ((this.mFaceAttr == null) || (this.mFaceAttr.getFaceCount() <= 0)) {
      return paramFrame;
    }
    List localList1 = this.mFaceAttr.getAllFacePoints();
    List localList2 = this.mFaceAttr.getFaceStatusList();
    List localList3 = this.mFaceAttr.getAllFaceAngles();
    double d = this.mFaceAttr.getFaceDetectScale();
    return this.mRemodelFilter.process(paramFrame, localList1, localList2, localList3, d, true);
  }
  
  public void setFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.mFaceAttr = paramPTFaceAttr;
  }
  
  public void setGenderCoefficient(int paramInt1, int paramInt2)
  {
    if (this.mRemodelFilter != null)
    {
      this.mRemodelFilter.setMalePercent(paramInt1 / 100.0F);
      this.mRemodelFilter.setFemalePercent(paramInt2 / 100.0F);
    }
  }
  
  public void setRemodelLevel(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    if (this.remodelType.contains(paramTYPE)) {
      this.mRemodelFilter.setParam(paramTYPE, paramInt);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    this.mRemodelFilter.setRenderMode(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AERemodel
 * JD-Core Version:    0.7.0.1
 */