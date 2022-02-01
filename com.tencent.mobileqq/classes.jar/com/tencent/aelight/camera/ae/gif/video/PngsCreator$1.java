package com.tencent.aelight.camera.ae.gif.video;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.view.Surface;
import com.tencent.aelight.camera.ae.gif.filter.GifFilterProcess;
import com.tencent.filter.BaseFilter;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglCore;

class PngsCreator$1
  implements Runnable
{
  PngsCreator$1(PngsCreator paramPngsCreator, String paramString) {}
  
  public void run()
  {
    Object localObject = new EglCore(null, 1);
    ((EglCore)localObject).b(((EglCore)localObject).a(320, 320));
    localObject = new int[1];
    GLES20.glGenTextures(localObject.length, (int[])localObject, 0);
    PngsCreator.a(this.this$0, localObject[0]);
    GLES20.glBindTexture(36197, PngsCreator.a(this.this$0));
    GLES20.glTexParameterf(36197, 10240, 9729.0F);
    GLES20.glTexParameterf(36197, 10241, 9729.0F);
    GLES20.glTexParameterf(36197, 10242, 33071.0F);
    GLES20.glTexParameterf(36197, 10243, 33071.0F);
    PngsCreator.b(this.this$0).apply();
    PngsCreator.c(this.this$0).a(320, 320);
    PngsCreator.c(this.this$0).a();
    localObject = this.this$0;
    PngsCreator.a((PngsCreator)localObject, new SurfaceTexture(PngsCreator.a((PngsCreator)localObject)));
    PngsCreator.d(this.this$0).setOnFrameAvailableListener(new PngsCreator.DecodeFrameListener(this.this$0));
    PngsCreator.a(this.this$0, new RepeatVideoDecoder());
    PngsCreator.e(this.this$0).a(this.a, new Surface(PngsCreator.d(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.video.PngsCreator.1
 * JD-Core Version:    0.7.0.1
 */