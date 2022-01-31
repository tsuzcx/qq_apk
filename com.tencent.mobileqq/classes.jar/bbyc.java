import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

public class bbyc
  implements DownloadParams.DecodeHandler
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean;
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      paramDownloadParams = null;
    }
    Bitmap localBitmap;
    Path localPath;
    Canvas localCanvas;
    do
    {
      return paramDownloadParams;
      paramBitmap.setDensity((int)bbll.c());
      localBitmap = bbbb.a(paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Int * 2);
      localPath = new Path();
      localCanvas = new Canvas(localBitmap);
      localCanvas.save();
      localPath.moveTo(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      localPath.lineTo(localBitmap.getWidth() - this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      localPath.lineTo(localBitmap.getWidth() - this.jdField_a_of_type_Int, localBitmap.getHeight() - this.jdField_a_of_type_Int);
      localPath.lineTo(this.jdField_a_of_type_Int, localBitmap.getHeight() - this.jdField_a_of_type_Int);
      localPath.close();
      localPath.setFillType(Path.FillType.EVEN_ODD);
      localCanvas.clipPath(localPath);
      localCanvas.drawBitmap(paramBitmap, new Rect(0, (paramBitmap.getHeight() - paramBitmap.getWidth()) / 2, paramBitmap.getWidth(), (paramBitmap.getWidth() + paramBitmap.getHeight()) / 2), new Rect(0, 0, localBitmap.getWidth(), localBitmap.getHeight()), this.jdField_a_of_type_AndroidGraphicsPaint);
      localCanvas.restore();
      paramDownloadParams = localBitmap;
    } while (this.jdField_a_of_type_Boolean);
    localCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbyc
 * JD-Core Version:    0.7.0.1
 */