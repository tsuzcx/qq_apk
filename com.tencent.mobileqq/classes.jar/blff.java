import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.common.GifUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.view.RendererUtils;
import dov.com.qq.im.ae.gif.video.VideoGIFCreator.1;
import dov.com.qq.im.video.GifEncoder;
import java.io.File;

public class blff
  implements SurfaceTexture.OnFrameAvailableListener
{
  public blff(VideoGIFCreator.1 param1, String paramString) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    QLog.d(blfe.a(), 4, "gif creator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).RenderProcess(blfe.c(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0), 960, 480, -1, 0.0D, blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0));
    blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a(true);
    paramSurfaceTexture = blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a(blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0), 480, 480);
    if (blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0) != null)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      float f1 = blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).jdField_a_of_type_Float * 2.0F - 1.0F;
      float f2 = blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).b * 2.0F - 1.0F;
      float f3 = blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).c * 2.0F + f1;
      float f4 = blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).d * 2.0F + f2;
      blfe.b(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).setPositions(new float[] { f1, f2, f1, f4, f3, f4, f3, f2 });
      blfe.b(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).RenderProcess(blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).jdField_a_of_type_Int, paramSurfaceTexture.width, paramSurfaceTexture.height, -1, 0.0D, paramSurfaceTexture);
      GLES20.glDisable(3042);
    }
    paramSurfaceTexture = blfe.c(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).RenderProcess(paramSurfaceTexture.getTextureId(), blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0), blfe.b(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0));
    Bitmap localBitmap = RendererUtils.saveTexture(paramSurfaceTexture);
    paramSurfaceTexture.unlock();
    blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a(localBitmap, 55);
    localBitmap.recycle();
    QLog.d(blfe.a(), 4, "gif creator decodeToSurface()");
    if (!blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a())
    {
      QLog.d(blfe.a(), 4, "gifEncoder.close() start");
      blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a();
      QLog.d(blfe.a(), 4, "gifEncoder.close() end");
      QLog.d(blfe.a(), 4, "gif encode complete");
      paramSurfaceTexture = bkpd.b + File.separator + System.currentTimeMillis() + "_compressed.gif";
      arso.c(paramSurfaceTexture);
      QLog.d(blfe.a(), 4, "gif compress start");
      int i = GifUtil.compressGif(this.jdField_a_of_type_JavaLangString, paramSurfaceTexture, 30);
      QLog.d(blfe.a(), 4, "gif compress end, ret = " + i);
      arso.c(this.jdField_a_of_type_JavaLangString);
      if (i <= 0) {
        break label563;
      }
      blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a(paramSurfaceTexture);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0.a();
      return;
      label563:
      blfe.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blff
 * JD-Core Version:    0.7.0.1
 */