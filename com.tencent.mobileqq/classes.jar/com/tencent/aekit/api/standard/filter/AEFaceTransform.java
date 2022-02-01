package com.tencent.aekit.api.standard.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.PTHairAttr;
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

public class AEFaceTransform
  extends AEChainI
{
  private AIAttr aiAttr;
  private BaseFilter copyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private PTFaceAttr faceAttr;
  private VideoFilterBase fillFilter = new VideoFilterBase(BaseFilter.getFragmentShader(0));
  private final HashSet<BeautyRealConfig.TYPE> jsonType = new HashSet(Arrays.asList(new BeautyRealConfig.TYPE[] { BeautyRealConfig.TYPE.BASIC4, BeautyRealConfig.TYPE.BASIC3, BeautyRealConfig.TYPE.FACE_SHORTEN, BeautyRealConfig.TYPE.NOSE }));
  private List<List<PointF>> mAllFacePoints = null;
  private BeautyParam mBeautyParam = new BeautyParam(BeautyParam.MeshType.PITU, true);
  private BeautyTransformList mBeautyTransformList = new BeautyTransformList();
  private double mFaceScale = 1.0D;
  private List<float[]> mFacesAngles = null;
  private PTHairAttr mHairAttr;
  private Frame mHairMaskFrame = new Frame();
  private boolean mIsAgeDetectOn = false;
  private float mPhoneRotate = 0.0F;
  private RemodelFilter mRemodelFilter = new RemodelFilter();
  List<FaceStatus> mStatusList = new ArrayList();
  private int[] mTextureTmp;
  private boolean pointUpdate = false;
  private final HashSet<BeautyRealConfig.TYPE> remodelType = new HashSet(Arrays.asList(new BeautyRealConfig.TYPE[] { BeautyRealConfig.TYPE.FOREHEAD, BeautyRealConfig.TYPE.EYE, BeautyRealConfig.TYPE.EYE_DISTANCE, BeautyRealConfig.TYPE.EYE_ANGLE, BeautyRealConfig.TYPE.MOUTH_SHAPE, BeautyRealConfig.TYPE.CHIN, BeautyRealConfig.TYPE.FACE_THIN, BeautyRealConfig.TYPE.FACE_V, BeautyRealConfig.TYPE.NOSE_WING, BeautyRealConfig.TYPE.NOSE_POSITION, BeautyRealConfig.TYPE.LIPS_THICKNESS, BeautyRealConfig.TYPE.LIPS_WIDTH, BeautyRealConfig.TYPE.CHEEKBONE_THIN }));
  private int transBasic3;
  private int transBasic4;
  private int transCheekboneThin;
  private int transChin;
  private int transEye;
  private int transEyeAngle;
  private int transEyeDistance;
  private int transFaceShorten;
  private int transFaceThin;
  private int transFaceV;
  private int transForehead;
  private int transLipsThickness;
  private int transLipsWidth;
  private int transMouthShape;
  private int transNose;
  private int transNosePosition;
  private int transNoseWing;
  
  public void apply()
  {
    if (!this.mIsApplied)
    {
      this.mBeautyTransformList.initial();
      this.fillFilter.ApplyGLSLFilter();
      this.mRemodelFilter.init();
      this.copyFilter.apply();
      this.mIsApplied = true;
    }
  }
  
  public void clear()
  {
    if (this.mBeautyTransformList != null) {
      this.mBeautyTransformList.clear();
    }
    if (this.mRemodelFilter != null) {
      this.mRemodelFilter.clear();
    }
    if (this.fillFilter != null) {
      this.fillFilter.clearGLSLSelf();
    }
    if (this.copyFilter != null) {
      this.copyFilter.clearGLSLSelf();
    }
    if (this.mTextureTmp != null)
    {
      GLES20.glDeleteTextures(this.mTextureTmp.length, this.mTextureTmp, 0);
      this.mTextureTmp = null;
    }
    this.mHairMaskFrame.clear();
    this.mIsApplied = false;
  }
  
  public void closeAIBeautyConfig()
  {
    this.mRemodelFilter.closeAIBeautyConfig();
  }
  
  public boolean isValid()
  {
    return this.mIsApplied;
  }
  
  public String printParamInfo()
  {
    return "AEFaceTransform {transForehead=" + this.transForehead + ", transEye=" + this.transEye + ", transEyeDistance=" + this.transEyeDistance + ", transEyeAngle=" + this.transEyeAngle + ", transMouthShape=" + this.transMouthShape + ", transChin=" + this.transChin + ", transFaceThin=" + this.transFaceThin + ", transFaceV=" + this.transFaceV + ", transNoseWing=" + this.transNoseWing + ", transNosePosition=" + this.transNosePosition + ", transLipsThickness=" + this.transLipsThickness + ", transLipsWidth=" + this.transLipsWidth + ", transNose=" + this.transNose + ", transCheekboneThin=" + this.transCheekboneThin + ", transFaceShorten=" + this.transFaceShorten + ", transBasic4=" + this.transBasic4 + ", transBasic3=" + this.transBasic3 + '}';
  }
  
  public Frame render(Frame paramFrame)
  {
    if ((this.mBeautyTransformList != null) && (this.mIsApplied)) {
      paramFrame = this.mBeautyTransformList.process(paramFrame, this.mAllFacePoints, this.mStatusList, this.mFaceScale, this.mFacesAngles, this.mPhoneRotate, this.mIsAgeDetectOn);
    }
    for (;;)
    {
      if ((this.mRemodelFilter != null) && (this.mIsApplied)) {
        paramFrame = this.mRemodelFilter.process(paramFrame, this.mAllFacePoints, this.mStatusList, this.mFacesAngles, this.mFaceScale, this.mIsAgeDetectOn);
      }
      for (;;)
      {
        if (this.aiAttr != null) {
          this.mHairAttr = ((PTHairAttr)this.aiAttr.getRealtimeData(AEDetectorType.HAIR_SEGMENT.value));
        }
        if ((this.mAllFacePoints != null) && (this.mAllFacePoints.size() > 0) && (this.mHairAttr != null) && (this.mHairAttr.isReady()) && (paramFrame != null) && (paramFrame.width > 0))
        {
          if (this.mTextureTmp == null)
          {
            this.mTextureTmp = new int[1];
            GLES20.glGenTextures(this.mTextureTmp.length, this.mTextureTmp, 0);
          }
          Bitmap localBitmap = this.mHairAttr.getMaskBitmap();
          if ((BitmapUtils.isLegal(localBitmap)) && (localBitmap.getWidth() > 0))
          {
            GlUtil.loadTexture(this.mTextureTmp[0], localBitmap);
            this.mHairMaskFrame = this.copyFilter.RenderProcess(this.mTextureTmp[0], localBitmap.getWidth(), localBitmap.getHeight(), paramFrame.width, paramFrame.height);
            if ((this.mBeautyTransformList != null) && (this.mIsApplied)) {
              this.mHairMaskFrame = this.mBeautyTransformList.process(this.mHairMaskFrame, this.mAllFacePoints, this.mStatusList, this.mFaceScale, this.mFacesAngles, this.mPhoneRotate, this.mIsAgeDetectOn);
            }
            if ((this.mRemodelFilter != null) && (this.mIsApplied)) {
              this.mHairMaskFrame = this.mRemodelFilter.process(this.mHairMaskFrame, this.mAllFacePoints, this.mStatusList, this.mFacesAngles, this.mFaceScale, this.mIsAgeDetectOn);
            }
            this.mHairAttr.setMaskFrame(this.mHairMaskFrame);
          }
        }
        if ((this.mBeautyTransformList != null) && (this.pointUpdate)) {
          this.mBeautyTransformList.updateFaceFeature(this.mAllFacePoints);
        }
        return paramFrame;
      }
    }
  }
  
  public void setAIBeautyValid(boolean paramBoolean)
  {
    this.mRemodelFilter.setAIBeautyValid(paramBoolean);
  }
  
  public void setAgeDetectOn(boolean paramBoolean)
  {
    this.mIsAgeDetectOn = paramBoolean;
  }
  
  public void setAiAttr(AIAttr paramAIAttr)
  {
    this.aiAttr = paramAIAttr;
  }
  
  public void setFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.faceAttr = paramPTFaceAttr;
    this.mRemodelFilter.updatePreview(paramPTFaceAttr);
    this.mBeautyTransformList.updatePreview(paramPTFaceAttr);
  }
  
  public void setFaceStatus(List<List<PointF>> paramList, List<float[]> paramList1, List<FaceStatus> paramList2, double paramDouble, float paramFloat)
  {
    this.mStatusList = paramList2;
    this.mAllFacePoints = paramList;
    this.mFacesAngles = paramList1;
    this.mFaceScale = paramDouble;
    this.mPhoneRotate = paramFloat;
  }
  
  public void setFaceTransformLevel(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    if (this.jsonType.contains(paramTYPE)) {
      if ((this.mBeautyParam != null) && (this.mBeautyTransformList != null)) {
        switch (AEFaceTransform.1.$SwitchMap$com$tencent$ttpic$openapi$config$BeautyRealConfig$TYPE[paramTYPE.ordinal()])
        {
        default: 
          this.mBeautyTransformList.setBeautyParam(paramTYPE.value, BeautyRealUtil.getDistortParam(this.mBeautyParam.getDistortList(paramTYPE), paramInt, paramTYPE.value));
        }
      }
    }
    while (!this.remodelType.contains(paramTYPE)) {
      for (;;)
      {
        return;
        this.transForehead = paramInt;
        continue;
        this.transEye = paramInt;
        continue;
        this.transEyeDistance = paramInt;
        continue;
        this.transEyeAngle = paramInt;
        continue;
        this.transMouthShape = paramInt;
        continue;
        this.transChin = paramInt;
        continue;
        this.transFaceThin = paramInt;
        continue;
        this.transFaceV = paramInt;
        continue;
        this.transNoseWing = paramInt;
        continue;
        this.transNosePosition = paramInt;
        continue;
        this.transLipsThickness = paramInt;
        continue;
        this.transLipsWidth = paramInt;
        continue;
        this.transCheekboneThin = paramInt;
        continue;
        this.transBasic4 = paramInt;
        continue;
        this.transNose = paramInt;
        this.transFaceShorten = paramInt;
        this.transBasic3 = paramInt;
        if (this.mBeautyTransformList != null) {
          this.mBeautyTransformList.setBeautyParamValue(paramTYPE.value, paramInt);
        }
      }
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
  
  public void setNeedReCaculateFace(boolean paramBoolean)
  {
    this.mRemodelFilter.setNeedReCaculateFace(paramBoolean);
    this.mBeautyTransformList.setNeedReCaculateFace(paramBoolean);
  }
  
  public void setPointUpdate(boolean paramBoolean)
  {
    this.pointUpdate = paramBoolean;
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
  
  public void updateAgeSexBeautyConfig(AIBeautyParamsJsonBean paramAIBeautyParamsJsonBean)
  {
    this.mRemodelFilter.updateAgeSexBeautyConfig(paramAIBeautyParamsJsonBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFaceTransform
 * JD-Core Version:    0.7.0.1
 */