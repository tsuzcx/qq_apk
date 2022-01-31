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

public class biwe
  implements SurfaceTexture.OnFrameAvailableListener
{
  public biwe(VideoGIFCreator.1 param1, String paramString) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    QLog.d(biwd.a(), 4, "gif creator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).RenderProcess(biwd.c(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0), 960, 480, -1, 0.0D, biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0));
    biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a(true);
    paramSurfaceTexture = biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a(biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0), 480, 480);
    if (biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0) != null)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      float f1 = biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).jdField_a_of_type_Float * 2.0F - 1.0F;
      float f2 = biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).b * 2.0F - 1.0F;
      float f3 = biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).c * 2.0F + f1;
      float f4 = biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).d * 2.0F + f2;
      biwd.b(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).setPositions(new float[] { f1, f2, f1, f4, f3, f4, f3, f2 });
      biwd.b(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).RenderProcess(biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).jdField_a_of_type_Int, paramSurfaceTexture.width, paramSurfaceTexture.height, -1, 0.0D, paramSurfaceTexture);
      GLES20.glDisable(3042);
    }
    paramSurfaceTexture = biwd.c(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).RenderProcess(paramSurfaceTexture.getTextureId(), biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0), biwd.b(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0));
    Bitmap localBitmap = RendererUtils.saveTexture(paramSurfaceTexture);
    paramSurfaceTexture.unlock();
    biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a(localBitmap, 55);
    localBitmap.recycle();
    QLog.d(biwd.a(), 4, "gif creator decodeToSurface()");
    if (!biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a())
    {
      QLog.d(biwd.a(), 4, "gifEncoder.close() start");
      biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a();
      QLog.d(biwd.a(), 4, "gifEncoder.close() end");
      QLog.d(biwd.a(), 4, "gif encode complete");
      paramSurfaceTexture = biiy.b + File.separator + System.currentTimeMillis() + "_compressed.gif";
      apvd.c(paramSurfaceTexture);
      QLog.d(biwd.a(), 4, "gif compress start");
      int i = GifUtil.compressGif(this.jdField_a_of_type_JavaLangString, paramSurfaceTexture, 30);
      QLog.d(biwd.a(), 4, "gif compress end, ret = " + i);
      apvd.c(this.jdField_a_of_type_JavaLangString);
      if (i <= 0) {
        break label563;
      }
      biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a(paramSurfaceTexture);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0.a();
      return;
      label563:
      biwd.a(this.jdField_a_of_type_DovComQqImAeGifVideoVideoGIFCreator$1.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwe
 * JD-Core Version:    0.7.0.1
 */