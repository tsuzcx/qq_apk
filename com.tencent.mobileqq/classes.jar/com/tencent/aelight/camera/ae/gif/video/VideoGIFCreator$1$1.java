package com.tencent.aelight.camera.ae.gif.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aelight.camera.ae.AEPath.GIF.FILES;
import com.tencent.aelight.camera.ae.gif.preview.VideoFilterProcess;
import com.tencent.common.GifUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.FrameUtil;
import com.tencent.view.RendererUtils;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;

class VideoGIFCreator$1$1
  implements SurfaceTexture.OnFrameAvailableListener
{
  VideoGIFCreator$1$1(VideoGIFCreator.1 param1, String paramString) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    QLog.d(VideoGIFCreator.b(), 4, "gif creator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    VideoGIFCreator.e(this.b.this$0).RenderProcess(VideoGIFCreator.d(this.b.this$0), 960, 480, -1, 0.0D, VideoGIFCreator.i(this.b.this$0));
    VideoGIFCreator.h(this.b.this$0).a(true);
    paramSurfaceTexture = VideoGIFCreator.h(this.b.this$0).a(VideoGIFCreator.i(this.b.this$0), 480, 480);
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(1, 771);
    if (VideoGIFCreator.j(this.b.this$0) != null)
    {
      float f1 = VideoGIFCreator.j(this.b.this$0).b * 2.0F - 1.0F;
      float f2 = VideoGIFCreator.j(this.b.this$0).c * 2.0F - 1.0F;
      float f3 = VideoGIFCreator.j(this.b.this$0).d * 2.0F + f1;
      float f4 = VideoGIFCreator.j(this.b.this$0).e * 2.0F + f2;
      VideoGIFCreator.f(this.b.this$0).setPositions(new float[] { f1, f2, f1, f4, f3, f4, f3, f2 });
      VideoGIFCreator.f(this.b.this$0).RenderProcess(VideoGIFCreator.j(this.b.this$0).a, paramSurfaceTexture.width, paramSurfaceTexture.height, -1, 0.0D, paramSurfaceTexture);
    }
    Object localObject1 = FrameBufferCache.getInstance().get(VideoGIFCreator.a(this.b.this$0), VideoGIFCreator.b(this.b.this$0));
    FrameUtil.clearFrame((Frame)localObject1, 0.0F, 0.0F, 0.0F, 0.0F, ((Frame)localObject1).width, ((Frame)localObject1).height);
    VideoGIFCreator.g(this.b.this$0).RenderProcess(paramSurfaceTexture.getTextureId(), VideoGIFCreator.a(this.b.this$0), VideoGIFCreator.b(this.b.this$0), -1, 0.0D, (Frame)localObject1);
    Object localObject2 = RendererUtils.saveTexture((Frame)localObject1);
    paramSurfaceTexture.unlock();
    ((Frame)localObject1).unlock();
    GLES20.glDisable(3042);
    VideoGIFCreator.c(this.b.this$0).a((Bitmap)localObject2, 55);
    ((Bitmap)localObject2).recycle();
    QLog.d(VideoGIFCreator.b(), 4, "gif creator decodeToSurface()");
    if (!VideoGIFCreator.k(this.b.this$0).a())
    {
      QLog.d(VideoGIFCreator.b(), 4, "gifEncoder.close() start");
      VideoGIFCreator.c(this.b.this$0).a();
      QLog.d(VideoGIFCreator.b(), 4, "gifEncoder.close() end");
      QLog.d(VideoGIFCreator.b(), 4, "gif encode complete");
      paramSurfaceTexture = new StringBuilder();
      paramSurfaceTexture.append(AEPath.GIF.FILES.b);
      paramSurfaceTexture.append(File.separator);
      paramSurfaceTexture.append(System.currentTimeMillis());
      paramSurfaceTexture.append("_compressed.gif");
      paramSurfaceTexture = paramSurfaceTexture.toString();
      FileUtil.e(paramSurfaceTexture);
      QLog.d(VideoGIFCreator.b(), 4, "gif compress start");
      int i = GifUtil.compressGif(this.a, paramSurfaceTexture, 30);
      localObject1 = VideoGIFCreator.b();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("gif compress end, ret = ");
      ((StringBuilder)localObject2).append(i);
      QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
      FileUtil.e(this.a);
      if (i > 0) {
        VideoGIFCreator.l(this.b.this$0).a(paramSurfaceTexture);
      } else {
        VideoGIFCreator.l(this.b.this$0).a();
      }
      this.b.this$0.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.VideoGIFCreator.1.1
 * JD-Core Version:    0.7.0.1
 */