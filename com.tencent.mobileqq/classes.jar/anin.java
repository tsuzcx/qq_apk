import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.GifAntishakeModule;
import cooperation.qzone.vision.PhotoUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class anin
  implements Runnable
{
  public anin(GifAntishakeModule paramGifAntishakeModule, int paramInt1, int paramInt2, int paramInt3, ArrayList paramArrayList, Bitmap paramBitmap, int paramInt4, int paramInt5, String[] paramArrayOfString, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "frame: " + this.jdField_a_of_type_Int + ", startAntishake at " + System.currentTimeMillis());
      }
      Bitmap localBitmap1 = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.RGB_565);
      Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
      PhotoUtil.getAntiShakeBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localBitmap2, localBitmap1);
      localBitmap2 = Bitmap.createBitmap(localBitmap1, this.d, this.e, localBitmap1.getWidth() - this.d * 2, localBitmap1.getHeight() - this.e * 2);
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "frame: " + this.jdField_a_of_type_Int + ", endAntishake and startSave at " + System.currentTimeMillis());
      }
      String str = PhotoUtils.a(GifAntishakeModule.a(this.jdField_a_of_type_CooperationQzoneUtilGifAntishakeModule), ".IMG" + this.jdField_a_of_type_Int, ".jpg");
      ImageUtil.a(localBitmap2, new File(str));
      if (!localBitmap1.isRecycled()) {
        localBitmap1.recycle();
      }
      if (!localBitmap2.isRecycled()) {
        localBitmap2.recycle();
      }
      this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int] = str;
      GifAntishakeModule.b();
      GifAntishakeModule.a(this.jdField_a_of_type_CooperationQzoneUtilGifAntishakeModule, GifAntishakeModule.c());
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "frame: " + this.jdField_a_of_type_Int + ", endSave at " + System.currentTimeMillis());
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anin
 * JD-Core Version:    0.7.0.1
 */