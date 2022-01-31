import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.GifAntishakeModule;
import cooperation.qzone.vision.PhotoUtil;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class anap
  implements Runnable
{
  public anap(GifAntishakeModule paramGifAntishakeModule, ArrayList paramArrayList, int paramInt, CountDownLatch paramCountDownLatch, Bitmap paramBitmap, boolean[] paramArrayOfBoolean) {}
  
  public void run()
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    if (localBitmap == null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
      return;
    }
    if (this.jdField_a_of_type_Int != 0)
    {
      float f = PhotoUtil.getImageSimilarity(this.jdField_a_of_type_AndroidGraphicsBitmap, localBitmap);
      if (QLog.isColorLevel()) {
        QLog.d("QzoneVision", 2, "第一帧与第" + (this.jdField_a_of_type_Int + 1) + "帧的相似度为" + f);
      }
      if ((localBitmap.getWidth() == this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth()) && (localBitmap.getHeight() == this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight()) && (f > GifAntishakeModule.a(this.jdField_a_of_type_CooperationQzoneUtilGifAntishakeModule))) {
        this.jdField_a_of_type_ArrayOfBoolean[this.jdField_a_of_type_Int] = true;
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anap
 * JD-Core Version:    0.7.0.1
 */