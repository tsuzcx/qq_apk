package com.tencent.aelight.camera.ae.camera.autotest;

import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.util.HashMap;

public class AEFilterManagerParamsListener
  implements AutoImageTestManager.IParamsListener
{
  private AEFilterManager a;
  private HashMap<String, VideoMaterial> b;
  
  public AEFilterManagerParamsListener(AEFilterManager paramAEFilterManager)
  {
    this.a = paramAEFilterManager;
  }
  
  public VideoMaterial a(String paramString)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    if (this.b.containsKey(paramString)) {
      return (VideoMaterial)this.b.get(paramString);
    }
    ThreadManager.excute(new AEFilterManagerParamsListener.1(this, paramString), 64, null, true);
    return null;
  }
  
  public void a(BeautyRealConfig.TYPE paramTYPE, int paramInt)
  {
    this.a.setBeautyOrTransformLevel(paramTYPE, paramInt);
  }
  
  public void a(VideoMaterial paramVideoMaterial, int paramInt)
  {
    this.a.updateMaterialGL(paramVideoMaterial);
    this.a.updateFenGeAlpha(paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.a.updateLutGL(paramString);
    this.a.updateLutAlpha(paramInt);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      return;
    }
    this.a.openAndUpdateBasicLips(paramString, paramInt1, paramInt2);
    this.a.openBeautyEnable(true);
  }
  
  public void b(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.a.openFaceThinEnable(paramString);
  }
  
  public void b(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    this.a.openAndUpdateBasicMultiply(paramString, paramInt);
    this.a.openBeautyEnable(true);
  }
  
  public void c(String paramString, int paramInt)
  {
    if (paramString == null) {
      return;
    }
    this.a.openAndUpdateBasicSoftLight(paramString, paramInt);
    this.a.openBeautyEnable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.autotest.AEFilterManagerParamsListener
 * JD-Core Version:    0.7.0.1
 */