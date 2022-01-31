package com.microrapid.lensFlare;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.Float1sParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.filter.QImage;
import com.tencent.util.LogUtil;
import com.tencent.view.FilterDefault;

public class LensFlareHandle
{
  public static final int OPT_CROSS_CPU = 2;
  public static final int OPT_CROSS_GPU = 0;
  private boolean available = false;
  private boolean hasInit = false;
  private final long nativeObj = nativeLensFlare();
  private int optCrossMode = 2;
  private int opttype = 0;
  private float strength = 0.5F;
  
  private QImage CreateLensImgNoLightSource(QImage paramQImage)
  {
    Object localObject = new float[2];
    paramQImage = nativePreProcessLensImgNoLightSource(this.nativeObj, paramQImage, (float[])localObject);
    lensFilterProcess(paramQImage, localObject[0], localObject[1]);
    localObject = nativePostProcessForBg(this.nativeObj, paramQImage);
    paramQImage.Dispose();
    return localObject;
  }
  
  private QImage CreateLensImgWithLightSource(QImage paramQImage)
  {
    float[] arrayOfFloat = new float[2];
    paramQImage = nativePreProcessLensImgWithLightSource(this.nativeObj, paramQImage, arrayOfFloat);
    lensFilterProcess(paramQImage, arrayOfFloat[0], arrayOfFloat[1]);
    nativeBlurImage(this.nativeObj, paramQImage);
    return paramQImage;
  }
  
  private void checkavailable()
  {
    if (!this.available) {
      throw new RuntimeException("use bad addr");
    }
  }
  
  static float clamp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  private void initLightSource(QImage paramQImage)
  {
    nativeInitLightSource(this.nativeObj, paramQImage);
  }
  
  private void lensFilterProcess(QImage paramQImage, float paramFloat1, float paramFloat2)
  {
    float f = clamp(this.strength * 0.8F, 0.1F, 1.0F);
    BaseFilter localBaseFilter = new BaseFilter(GLSLRender.VERTEXT_LENSFLARE_SHADER, GLSLRender.FILTER_FACE_LENSFLARE_SHADER);
    localBaseFilter.addParam(new Param.IntParam("uSamples", 32));
    localBaseFilter.addParam(new Param.FloatParam("uDispersal", 0.3F));
    localBaseFilter.addParam(new Param.FloatParam("uHaloWidth", f));
    localBaseFilter.addParam(new Param.FloatParam("uDistortion", 2.0F));
    localBaseFilter.addParam(new Param.FloatParam("px", paramFloat1));
    localBaseFilter.addParam(new Param.FloatParam("py", paramFloat2));
    localBaseFilter.ApplyGLSLFilter(false, paramQImage.getWidth(), paramQImage.getHeight());
    Frame localFrame = new Frame();
    localBaseFilter.RendProcessImage(paramQImage, localFrame);
    localBaseFilter.ClearGLSL();
    localFrame.clear();
  }
  
  private void logDebug(String paramString)
  {
    LogUtil.i("test", paramString);
  }
  
  private native int nativeAttachLightSourceCrossGPUOne(long paramLong, QImage paramQImage, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3, float[] paramArrayOfFloat4, float[] paramArrayOfFloat5, float[] paramArrayOfFloat6, float[] paramArrayOfFloat7, float[] paramArrayOfFloat8, float[] paramArrayOfFloat9, float[] paramArrayOfFloat10, float[] paramArrayOfFloat11);
  
  private native void nativeBlurImage(long paramLong, QImage paramQImage);
  
  private native void nativeDispose(long paramLong);
  
  private native QImage nativeGetPatternImage(long paramLong);
  
  private native void nativeGrayProcess(Bitmap paramBitmap);
  
  private native void nativeInitLightSource(long paramLong, QImage paramQImage);
  
  private native boolean nativeIsLightSourceExisted(long paramLong, QImage paramQImage);
  
  private native long nativeLensFlare();
  
  private native void nativeLightSourceCrossImgSingle(long paramLong, QImage paramQImage);
  
  private native boolean nativeLightSourceCrossImgTotalCPU(long paramLong, QImage paramQImage);
  
  private native QImage nativePostProcessForBg(long paramLong, QImage paramQImage);
  
  private native QImage nativePreProcessLensImgNoLightSource(long paramLong, QImage paramQImage, float[] paramArrayOfFloat);
  
  private native QImage nativePreProcessLensImgWithLightSource(long paramLong, QImage paramQImage, float[] paramArrayOfFloat);
  
  private native void nativeQImageCopy(QImage paramQImage1, QImage paramQImage2);
  
  private native void nativeRefineLabelmapEx(long paramLong);
  
  private native void nativeUpdateCrossNumStrength(long paramLong, float paramFloat);
  
  private native void nativeUpdateCrossSizeStrength(long paramLong, float paramFloat);
  
  private native void nativeUpdateOpType(long paramLong, int paramInt);
  
  private native void nativeUpdatePatternImage(long paramLong, QImage paramQImage);
  
  private native void nativeUpdateStrength(long paramLong, float paramFloat);
  
  private void processCrosssImage(QImage paramQImage)
  {
    if (!this.hasInit)
    {
      initLightSource(paramQImage);
      nativeRefineLabelmapEx(this.nativeObj);
      this.hasInit = true;
    }
    if (this.optCrossMode == 2)
    {
      nativeLightSourceCrossImgTotalCPU(this.nativeObj, paramQImage);
      return;
    }
    Object localObject1 = new float[55];
    float[] arrayOfFloat1 = new float[55];
    float[] arrayOfFloat2 = new float[55];
    float[] arrayOfFloat3 = new float[55];
    float[] arrayOfFloat4 = new float[55];
    float[] arrayOfFloat5 = new float[55];
    float[] arrayOfFloat6 = new float[55];
    float[] arrayOfFloat7 = new float[55];
    float[] arrayOfFloat8 = new float[55];
    float[] arrayOfFloat9 = new float[55];
    float[] arrayOfFloat10 = new float[55];
    nativeAttachLightSourceCrossGPUOne(this.nativeObj, paramQImage, (float[])localObject1, arrayOfFloat1, arrayOfFloat2, arrayOfFloat3, arrayOfFloat4, arrayOfFloat5, arrayOfFloat6, arrayOfFloat7, arrayOfFloat8, arrayOfFloat9, arrayOfFloat10);
    Object localObject2 = nativeGetPatternImage(this.nativeObj);
    Bitmap localBitmap = Bitmap.createBitmap(((QImage)localObject2).getWidth(), ((QImage)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
    ((QImage)localObject2).ToBitmap(localBitmap);
    nativeGrayProcess(localBitmap);
    localObject2 = new BaseFilter(GLSLRender.FILTER_FACE_ATTACHCROSS_EX_SHADER);
    ((BaseFilter)localObject2).addParam(new Param.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, true));
    ((BaseFilter)localObject2).addParam(new Param.Float1sParam("rlist", (float[])localObject1));
    ((BaseFilter)localObject2).addParam(new Param.Float1sParam("glist", arrayOfFloat1));
    ((BaseFilter)localObject2).addParam(new Param.Float1sParam("blist", arrayOfFloat2));
    ((BaseFilter)localObject2).addParam(new Param.Float1sParam("offsetx_txlist", arrayOfFloat3));
    ((BaseFilter)localObject2).addParam(new Param.Float1sParam("offsety_tylist", arrayOfFloat4));
    ((BaseFilter)localObject2).addParam(new Param.Float1sParam("offsetx_rw_txlist", arrayOfFloat5));
    ((BaseFilter)localObject2).addParam(new Param.Float1sParam("offsety_rh_tylist", arrayOfFloat6));
    ((BaseFilter)localObject2).addParam(new Param.Float1sParam("alphaxlist", arrayOfFloat7));
    ((BaseFilter)localObject2).addParam(new Param.Float1sParam("alphaylist", arrayOfFloat8));
    ((BaseFilter)localObject2).addParam(new Param.Float1sParam("betaxlist", arrayOfFloat9));
    ((BaseFilter)localObject2).addParam(new Param.Float1sParam("betaylist", arrayOfFloat10));
    ((BaseFilter)localObject2).ApplyGLSLFilter(false, paramQImage.getWidth(), paramQImage.getHeight());
    logDebug("processCrosssImage ApplyGLSLFilter ");
    localObject1 = new Frame();
    ((BaseFilter)localObject2).RendProcessImage(paramQImage, (Frame)localObject1);
    ((BaseFilter)localObject2).ClearGLSL();
    ((Frame)localObject1).clear();
  }
  
  private void processLensImage(QImage paramQImage)
  {
    if (!this.hasInit)
    {
      initLightSource(paramQImage);
      this.hasInit = true;
    }
    if (nativeIsLightSourceExisted(this.nativeObj, paramQImage))
    {
      logDebug("processLensImage 1");
      Object localObject3 = CreateLensImgWithLightSource(paramQImage);
      localObject2 = paramQImage.CreateImageFromQImage();
      nativeLightSourceCrossImgSingle(this.nativeObj, (QImage)localObject2);
      localObject1 = Bitmap.createBitmap(((QImage)localObject3).getWidth(), ((QImage)localObject3).getHeight(), Bitmap.Config.ARGB_8888);
      ((QImage)localObject3).ToBitmap((Bitmap)localObject1);
      ((QImage)localObject3).Dispose();
      localObject3 = Bitmap.createBitmap(((QImage)localObject2).getWidth(), ((QImage)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
      ((QImage)localObject2).ToBitmap((Bitmap)localObject3);
      ((QImage)localObject2).Dispose();
      localObject2 = new BaseFilter(GLSLRender.VERTEXT_LENSFLARE_SHADER, GLSLRender.FILTER_FACE_ALPHABLEND_SHADER);
      ((BaseFilter)localObject2).addParam(new Param.TextureBitmapParam("inputImageTexture2", (Bitmap)localObject1, 33986, true));
      ((BaseFilter)localObject2).addParam(new Param.TextureBitmapParam("inputImageTexture3", (Bitmap)localObject3, 33987, true));
      ((BaseFilter)localObject2).ApplyGLSLFilter(false, paramQImage.getWidth(), paramQImage.getHeight());
      localObject1 = new Frame();
      ((BaseFilter)localObject2).RendProcessImage(paramQImage, (Frame)localObject1);
      ((BaseFilter)localObject2).ClearGLSL();
      ((Frame)localObject1).clear();
      return;
    }
    logDebug("processLensImage 2");
    Object localObject2 = CreateLensImgNoLightSource(paramQImage);
    Object localObject1 = Bitmap.createBitmap(((QImage)localObject2).getWidth(), ((QImage)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
    ((QImage)localObject2).ToBitmap((Bitmap)localObject1);
    ((QImage)localObject2).Dispose();
    localObject2 = new BaseFilter(GLSLRender.VERTEXT_LENSFLARE_SHADER, GLSLRender.FILTER_FACE_ALPHABLENDCROSS_SHADER);
    ((BaseFilter)localObject2).addParam(new Param.TextureBitmapParam("inputImageTexture2", (Bitmap)localObject1, 33986, true));
    ((BaseFilter)localObject2).ApplyGLSLFilter(false, paramQImage.getWidth(), paramQImage.getHeight());
    localObject1 = new Frame();
    ((BaseFilter)localObject2).RendProcessImage(paramQImage, (Frame)localObject1);
    ((BaseFilter)localObject2).ClearGLSL();
    ((Frame)localObject1).clear();
  }
  
  public void dispose()
  {
    if (this.available)
    {
      nativeDispose(this.nativeObj);
      this.hasInit = false;
      this.available = false;
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    dispose();
    super.finalize();
  }
  
  public boolean isRunnable()
  {
    checkavailable();
    return nativeGetPatternImage(this.nativeObj) != null;
  }
  
  public void processImage(QImage paramQImage)
  {
    checkavailable();
    if (nativeGetPatternImage(this.nativeObj) == null) {
      return;
    }
    if (this.opttype == 0)
    {
      processLensImage(paramQImage);
      return;
    }
    processCrosssImage(paramQImage);
  }
  
  public void setCrossMode(int paramInt)
  {
    this.optCrossMode = paramInt;
  }
  
  public void updateCrossNumStrength(float paramFloat)
  {
    checkavailable();
    nativeUpdateCrossNumStrength(this.nativeObj, paramFloat);
  }
  
  public void updateCrossSizeStrength(float paramFloat)
  {
    checkavailable();
    nativeUpdateCrossSizeStrength(this.nativeObj, paramFloat);
  }
  
  public void updateOpType(int paramInt)
  {
    this.opttype = paramInt;
    checkavailable();
    nativeUpdateOpType(this.nativeObj, paramInt);
  }
  
  public void updatePatternImage(String paramString)
  {
    checkavailable();
    paramString = FilterDefault.decodeBitmap(paramString);
    if (paramString != null)
    {
      QImage localQImage = QImage.BindBitmap(paramString);
      nativeUpdatePatternImage(this.nativeObj, localQImage);
      localQImage.UnBindBitmap(paramString);
      paramString.recycle();
    }
  }
  
  public void updateStrength(float paramFloat)
  {
    this.strength = paramFloat;
    checkavailable();
    nativeUpdateStrength(this.nativeObj, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.microrapid.lensFlare.LensFlareHandle
 * JD-Core Version:    0.7.0.1
 */