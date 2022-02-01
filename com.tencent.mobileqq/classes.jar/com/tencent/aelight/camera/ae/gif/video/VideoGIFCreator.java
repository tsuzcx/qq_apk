package com.tencent.aelight.camera.ae.gif.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aelight.camera.ae.gif.preview.VideoFilterProcess;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.video.GifEncoder;

public class VideoGIFCreator
{
  private static String a = "GIFCreator";
  private Handler b;
  private VideoDecoder c;
  private BaseFilter d = new SurfaceTextureFilter();
  private BaseFilter e = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private BaseFilter f = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private VideoFilterProcess g = new VideoFilterProcess();
  private Frame h = new Frame();
  private int i = 0;
  private int j = 380;
  private int k = 380;
  private SurfaceTexture l = null;
  private GifEncoder m = new GifEncoder();
  private VideoGIFCreator.Callback n;
  private VideoGIFCreator.TextConfig o;
  
  public VideoGIFCreator(String paramString)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("input video = ");
    localStringBuilder.append(paramString);
    QLog.d((String)localObject, 4, localStringBuilder.toString());
    localObject = new HandlerThread("GIFCreatorHT");
    ((HandlerThread)localObject).start();
    this.b = new Handler(((HandlerThread)localObject).getLooper());
    this.b.post(new VideoGIFCreator.1(this, paramString));
  }
  
  public void a()
  {
    this.b.post(new VideoGIFCreator.4(this));
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.b.post(new VideoGIFCreator.2(this, paramBitmap, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  public void a(VideoGIFCreator.Callback paramCallback)
  {
    this.n = paramCallback;
    QLog.d(a, 4, "start create gif");
    this.b.post(new VideoGIFCreator.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator
 * JD-Core Version:    0.7.0.1
 */