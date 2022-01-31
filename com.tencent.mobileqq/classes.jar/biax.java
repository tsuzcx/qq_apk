import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import android.os.Environment;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.common.GifUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.view.RendererUtils;
import dov.com.qq.im.video.GifEncoder;
import dov.com.qq.im.video.VideoGIFCreator.1;
import java.io.File;

public class biax
  implements SurfaceTexture.OnFrameAvailableListener
{
  public biax(VideoGIFCreator.1 param1, String paramString) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    QLog.d(biaw.a(), 4, "gif creator onFrameAvailable()");
    paramSurfaceTexture.updateTexImage();
    biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).RenderProcess(biaw.c(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0), 960, 480, -1, 0.0D, biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0));
    biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).a(true);
    paramSurfaceTexture = biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).a(biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0), 480, 480);
    if (biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0) != null)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(770, 771);
      float f1 = biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).jdField_a_of_type_Float * 2.0F - 1.0F;
      float f2 = biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).b * 2.0F - 1.0F;
      float f3 = biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).c * 2.0F + f1;
      float f4 = biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).d * 2.0F + f2;
      biaw.b(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).setPositions(new float[] { f1, f2, f1, f4, f3, f4, f3, f2 });
      biaw.b(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).RenderProcess(biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).jdField_a_of_type_Int, paramSurfaceTexture.width, paramSurfaceTexture.height, -1, 0.0D, paramSurfaceTexture);
      GLES20.glDisable(3042);
    }
    paramSurfaceTexture = biaw.c(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).RenderProcess(paramSurfaceTexture.getTextureId(), biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0), biaw.b(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0));
    Bitmap localBitmap = RendererUtils.saveTexture(paramSurfaceTexture);
    paramSurfaceTexture.unlock();
    biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).a(localBitmap, 55);
    localBitmap.recycle();
    QLog.d(biaw.a(), 4, "gif creator decodeToSurface()");
    if (!biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).a())
    {
      QLog.d(biaw.a(), 4, "gifEncoder.close() start");
      biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).a();
      QLog.d(biaw.a(), 4, "gifEncoder.close() end");
      QLog.d(biaw.a(), 4, "gif encode complete");
      paramSurfaceTexture = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.tencent.mobileqq/qq/video/Source/" + System.currentTimeMillis() + "_compressed.gif";
      apdh.c(paramSurfaceTexture);
      QLog.d(biaw.a(), 4, "gif compress start");
      int i = GifUtil.compressGif(this.jdField_a_of_type_JavaLangString, paramSurfaceTexture, 30);
      QLog.d(biaw.a(), 4, "gif compress end, ret = " + i);
      apdh.c(this.jdField_a_of_type_JavaLangString);
      if (i <= 0) {
        break label565;
      }
      biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).a(paramSurfaceTexture);
    }
    for (;;)
    {
      this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0.a();
      return;
      label565:
      biaw.a(this.jdField_a_of_type_DovComQqImVideoVideoGIFCreator$1.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biax
 * JD-Core Version:    0.7.0.1
 */