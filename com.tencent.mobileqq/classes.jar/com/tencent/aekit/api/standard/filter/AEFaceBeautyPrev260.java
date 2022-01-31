package com.tencent.aekit.api.standard.filter;

import android.graphics.PointF;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.filter.BeautyFaceList_260;
import com.tencent.ttpic.openapi.filter.FaceFeatureParam;
import com.tencent.ttpic.util.AlgoUtils;
import java.util.ArrayList;
import java.util.List;

public class AEFaceBeautyPrev260
  extends AEChainI
{
  private boolean isApplied = false;
  private boolean isVeryLowDevice = false;
  private List<List<PointF>> mAllFacePoints = null;
  private BeautyFaceList_260 mBeautyFaceList = null;
  private double mFaceScale = 1.0D;
  private List<FaceStatus> mFaceStatusList = null;
  private List<Float[]> mPointsVis = null;
  private int mVideoHeight = 1280;
  private int mVideoWidth = 720;
  
  public void apply()
  {
    if (!this.isApplied)
    {
      this.mBeautyFaceList = new BeautyFaceList_260();
      this.mBeautyFaceList.initial();
      this.isApplied = true;
    }
  }
  
  public void clear()
  {
    if (this.mBeautyFaceList != null)
    {
      this.mBeautyFaceList.clear();
      this.mBeautyFaceList = null;
    }
    this.isApplied = false;
  }
  
  public void forceAvgEyeBag()
  {
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.forceAvgEyeBag();
    }
  }
  
  public boolean isValid()
  {
    return this.isApplied;
  }
  
  public Frame render(Frame paramFrame)
  {
    Object localObject = paramFrame;
    if (this.mBeautyFaceList != null)
    {
      localObject = paramFrame;
      if (this.isApplied == true)
      {
        ArrayList localArrayList1 = new ArrayList();
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList3 = new ArrayList();
        int i = 0;
        while (i < this.mAllFacePoints.size())
        {
          localObject = (List)this.mAllFacePoints.get(i);
          FaceStatus localFaceStatus = (FaceStatus)this.mFaceStatusList.get(i);
          Float[] arrayOfFloat = (Float[])this.mPointsVis.get(i);
          if (AlgoUtils.isFacePointsValid((List)localObject))
          {
            localArrayList1.add(localObject);
            localArrayList2.add(localFaceStatus);
            localArrayList3.add(arrayOfFloat);
          }
          i += 1;
        }
        localObject = paramFrame;
        if (!localArrayList1.isEmpty())
        {
          new ArrayList();
          localObject = this.mBeautyFaceList.render(paramFrame, localArrayList1, localArrayList3, localArrayList2, this.isVeryLowDevice);
        }
      }
    }
    return localObject;
  }
  
  public void resetEyeBagColors()
  {
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.resetEyeBagColors();
    }
  }
  
  public void resetFaceFeatureAlpha()
  {
    if (this.mBeautyFaceList != null)
    {
      this.mBeautyFaceList.setFaceFeatureNormalAlpha(0.0F);
      this.mBeautyFaceList.setFaceFeatureMultiplyAlpha(0.0F);
      this.mBeautyFaceList.setFaceFeatureSoftlightAlpha(0.0F);
    }
  }
  
  public void setFaceBeautyLevel(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    switch (AEFaceBeautyPrev260.1.$SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[paramTYPE.ordinal()])
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                } while (this.mBeautyFaceList == null);
                this.mBeautyFaceList.setEyeLightenAlpha(paramInt / 100.0F);
                return;
              } while (this.mBeautyFaceList == null);
              this.mBeautyFaceList.setToothWhitenAlpha(paramInt / 80.0F);
              return;
            } while (this.mBeautyFaceList == null);
            this.mBeautyFaceList.setRemovePounchAlpha(paramInt / 100.0F);
            return;
          } while (this.mBeautyFaceList == null);
          this.mBeautyFaceList.setRemoveWrinklesAlpha(paramInt / 100.0F);
          return;
        } while (this.mBeautyFaceList == null);
        this.mBeautyFaceList.setRemoveWrinklesAlpha2(paramInt / 100.0F);
        return;
      } while (this.mBeautyFaceList == null);
      this.mBeautyFaceList.setSkinColorAlpha((paramInt - 50) / 50.0F);
      return;
    } while (this.mBeautyFaceList == null);
    this.mBeautyFaceList.setContrastLevel(paramInt);
  }
  
  public void setFaceFeatureParam(FaceFeatureParam paramFaceFeatureParam)
  {
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setFaceFeatureParam(paramFaceFeatureParam);
    }
  }
  
  public void setFaceStatus(PTFaceAttr paramPTFaceAttr, double paramDouble, float paramFloat)
  {
    if (paramPTFaceAttr != null)
    {
      this.mAllFacePoints = paramPTFaceAttr.getAllFacePoints();
      this.mFaceStatusList = paramPTFaceAttr.getFaceStatusList();
      this.mPointsVis = paramPTFaceAttr.getPointsVis();
      this.mFaceScale = paramDouble;
    }
  }
  
  public void setLipsLut(String paramString)
  {
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setLipsLut(paramString);
    }
  }
  
  public void setLipsLutAlpha(int paramInt)
  {
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setLipsLutAlpha(paramInt);
    }
  }
  
  public void setNormalAlphaFactor(float paramFloat)
  {
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setNormalAlphaFactor(paramFloat);
    }
  }
  
  public void setRenderMode(int paramInt)
  {
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.setRenderMode(paramInt);
    }
  }
  
  public void setVeryLowDevice(boolean paramBoolean)
  {
    this.isVeryLowDevice = paramBoolean;
  }
  
  public void setVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mVideoWidth = paramInt1;
    this.mVideoHeight = paramInt2;
    this.mFaceScale = paramDouble;
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.updateVideoSize(this.mVideoWidth, this.mVideoHeight, this.mFaceScale);
    }
  }
  
  public void updateFilterBlendImage(String paramString, int paramInt)
  {
    if (this.mBeautyFaceList != null) {
      this.mBeautyFaceList.updateFilterBlendImage(paramString, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFaceBeautyPrev260
 * JD-Core Version:    0.7.0.1
 */