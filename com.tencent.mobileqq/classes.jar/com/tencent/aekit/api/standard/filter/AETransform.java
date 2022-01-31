package com.tencent.aekit.api.standard.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.BeautyParam;
import com.tencent.ttpic.openapi.filter.BeautyParam.MeshType;
import com.tencent.ttpic.openapi.filter.BeautyTransformList;
import com.tencent.ttpic.openapi.filter.RemodelFilter;
import com.tencent.ttpic.openapi.util.BeautyRealUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class AETransform
  extends AEChainI
{
  private boolean isApplied;
  private final HashSet<BeautyRealConfig.TYPE> jsonType = new HashSet(Arrays.asList(new BeautyRealConfig.TYPE[] { BeautyRealConfig.TYPE.BASIC3, BeautyRealConfig.TYPE.BASIC4, BeautyRealConfig.TYPE.FACE_SHORTEN, BeautyRealConfig.TYPE.NOSE }));
  private List<List<PointF>> mAllFacePoints = null;
  private BeautyParam mBeautyParam = new BeautyParam(BeautyParam.MeshType.PITU, true);
  private BeautyTransformList mBeautyTransformList = new BeautyTransformList();
  private double mFaceScale = 1.0D;
  private List<float[]> mFacesAngles = null;
  private float mPhoneRotate = 0.0F;
  private RemodelFilter mRemodelFilter = new RemodelFilter();
  private int mVideoHeight = 1280;
  private int mVideoWidth = 720;
  private final HashSet<BeautyRealConfig.TYPE> remodelType = new HashSet(Arrays.asList(new BeautyRealConfig.TYPE[] { BeautyRealConfig.TYPE.FOREHEAD, BeautyRealConfig.TYPE.EYE, BeautyRealConfig.TYPE.EYE_DISTANCE, BeautyRealConfig.TYPE.EYE_ANGLE, BeautyRealConfig.TYPE.MOUTH_SHAPE, BeautyRealConfig.TYPE.CHIN, BeautyRealConfig.TYPE.FACE_THIN, BeautyRealConfig.TYPE.FACE_V, BeautyRealConfig.TYPE.NOSE_WING, BeautyRealConfig.TYPE.NOSE_POSITION, BeautyRealConfig.TYPE.LIPS_THICKNESS, BeautyRealConfig.TYPE.LIPS_WIDTH }));
  
  public void apply()
  {
    if (!this.isApplied)
    {
      this.mBeautyTransformList.initial();
      this.mRemodelFilter.init();
      this.isApplied = true;
    }
  }
  
  public void clear()
  {
    if (this.mBeautyTransformList != null)
    {
      this.mBeautyTransformList.clear();
      this.mBeautyTransformList = null;
    }
    if (this.mRemodelFilter != null)
    {
      this.mRemodelFilter.clear();
      this.mRemodelFilter = null;
    }
  }
  
  public boolean isValid()
  {
    return this.isApplied;
  }
  
  public Frame render(Frame paramFrame)
  {
    Object localObject;
    if ((this.mBeautyTransformList != null) && (this.isApplied == true))
    {
      localObject = new ArrayList();
      paramFrame = this.mBeautyTransformList.process(paramFrame, this.mAllFacePoints, (List)localObject, this.mFaceScale, this.mFacesAngles, this.mPhoneRotate, true);
    }
    for (;;)
    {
      localObject = paramFrame;
      if (this.mRemodelFilter != null)
      {
        localObject = paramFrame;
        if (this.isApplied == true)
        {
          localObject = new ArrayList();
          localObject = this.mRemodelFilter.process(paramFrame, this.mAllFacePoints, (List)localObject, this.mFacesAngles, this.mFaceScale, true);
        }
      }
      return localObject;
    }
  }
  
  public void setFaceStatus(List<List<PointF>> paramList, List<float[]> paramList1, double paramDouble, float paramFloat)
  {
    this.mAllFacePoints = paramList;
    this.mFacesAngles = paramList1;
    this.mFaceScale = paramDouble;
    this.mPhoneRotate = paramFloat;
  }
  
  public void setFaceTransformLevel(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    if (this.jsonType.contains(paramTYPE)) {
      if ((this.mBeautyParam != null) && (this.mBeautyTransformList != null)) {
        this.mBeautyTransformList.setBeautyParam(paramTYPE.value, BeautyRealUtil.getDistortParam(this.mBeautyParam.getDistortList(paramTYPE), paramInt, paramTYPE.value));
      }
    }
    while (!this.remodelType.contains(paramTYPE)) {
      return;
    }
    this.mRemodelFilter.setParam(paramTYPE, paramInt);
  }
  
  public void setGenderCoefficient(int paramInt1, int paramInt2)
  {
    if (this.mBeautyTransformList != null)
    {
      this.mBeautyTransformList.updateMalePercent(paramInt1 / 100.0F);
      this.mBeautyTransformList.updateFemalePercent(paramInt2 / 100.0F);
    }
    if (this.mRemodelFilter != null)
    {
      this.mRemodelFilter.setMalePercent(paramInt1 / 100.0F);
      this.mRemodelFilter.setFemalePercent(paramInt2 / 100.0F);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.mBeautyTransformList != null) {
      this.mBeautyTransformList.setRenderMode(paramInt);
    }
    if (this.mRemodelFilter != null) {
      this.mRemodelFilter.setRenderMode(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AETransform
 * JD-Core Version:    0.7.0.1
 */