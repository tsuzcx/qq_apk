package com.tencent.aekit.api.standard.filter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.facedetect.FaceStatus;
import com.tencent.ttpic.facedetect.GenderType;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.filter.FaceLineFilter;
import java.util.List;

public class AEFaceLine
  extends AEChainI
{
  private static final String TAG = "FaceLineFilter";
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private Frame mDebugFrame = new Frame();
  private PTFaceAttr mFaceAttr;
  private FaceLineFilter mFaceLineFilter;
  private int previewHeight;
  private int previewWidth;
  
  public void apply()
  {
    if (this.mIsApplied) {
      return;
    }
    this.mFaceLineFilter = new FaceLineFilter();
    this.mFaceLineFilter.ApplyGLSLFilter();
    this.mIsApplied = true;
  }
  
  public void clear()
  {
    if (this.mFaceLineFilter != null) {
      this.mFaceLineFilter.clearGLSLSelf();
    }
    this.mIsApplied = false;
  }
  
  public Frame render(Frame paramFrame)
  {
    paramFrame.bindFrame(-1, paramFrame.width, paramFrame.height, 0.0D);
    int i = 0;
    if (i < 5)
    {
      if (this.mFaceAttr.getAllFacePoints().size() > i)
      {
        this.mFaceLineFilter.updatePoints(this.mFaceAttr.getAllFacePoints(), i);
        if ((this.mFaceAttr.getFaceStatusList().size() <= i) || (this.mFaceAttr.getFaceStatusList().get(i) == null) || (((FaceStatus)this.mFaceAttr.getFaceStatusList().get(i)).gender != GenderType.FEMALE.value)) {
          break label146;
        }
        this.mFaceLineFilter.updateBlurAlpha(1.0F);
      }
      for (;;)
      {
        this.mFaceLineFilter.render(paramFrame.getTextureId(), this.previewWidth, this.previewHeight);
        i += 1;
        break;
        label146:
        if ((this.mFaceAttr.getFaceStatusList().size() > i) && (this.mFaceAttr.getFaceStatusList().get(i) != null) && (((FaceStatus)this.mFaceAttr.getFaceStatusList().get(i)).gender == GenderType.MALE.value)) {
          this.mFaceLineFilter.updateBlurAlpha(0.5F);
        } else {
          this.mFaceLineFilter.updateBlurAlpha(0.0F);
        }
      }
    }
    return paramFrame;
  }
  
  public void setmFaceAttr(PTFaceAttr paramPTFaceAttr)
  {
    this.mFaceAttr = paramPTFaceAttr;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.mFaceLineFilter.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.previewWidth = paramInt1;
    this.previewHeight = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.filter.AEFaceLine
 * JD-Core Version:    0.7.0.1
 */