package com.tencent.aelight.camera.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.AEPath.GIF.CACHE;
import com.tencent.aelight.camera.ae.gif.filter.GifFilterProcess;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.PTFaceAttr;
import java.io.File;
import java.util.List;

public class PngsCreator
{
  private static String a = "PngsCreator";
  private Handler b;
  private RepeatVideoDecoder c;
  private BaseFilter d = new SurfaceTextureFilter();
  private GifFilterProcess e = new GifFilterProcess();
  private Frame f = new Frame();
  private int g = 0;
  private SurfaceTexture h = null;
  private PngsCreator.Callback i;
  private int j = 0;
  private String k;
  private List<PTFaceAttr> l;
  private long m = 0L;
  
  public PngsCreator(String paramString, List<PTFaceAttr> paramList)
  {
    this.l = paramList;
    paramList = new HandlerThread("PngCreatorHT");
    paramList.start();
    this.b = new Handler(paramList.getLooper());
    this.b.post(new PngsCreator.1(this, paramString));
  }
  
  public void a()
  {
    this.j = 0;
    this.b.post(new PngsCreator.5(this));
  }
  
  public void a(PngsCreator.Callback paramCallback)
  {
    this.m = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AEPath.GIF.CACHE.b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(System.currentTimeMillis());
    this.k = localStringBuilder.toString();
    try
    {
      new File(this.k).mkdirs();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    QLog.d(a, 4, new Object[] { "pngDir = ", this.k });
    this.i = paramCallback;
    this.b.post(new PngsCreator.2(this));
  }
  
  public void a(String paramString)
  {
    this.b.post(new PngsCreator.3(this, paramString));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.b.post(new PngsCreator.4(this, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramString4, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.PngsCreator
 * JD-Core Version:    0.7.0.1
 */