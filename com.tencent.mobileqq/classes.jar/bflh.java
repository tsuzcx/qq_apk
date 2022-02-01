import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.troopreward.OrientationAdapterImageView;
import com.tencent.qphone.base.util.QLog;

public class bflh
  extends Handler
{
  public bflh(OrientationAdapterImageView paramOrientationAdapterImageView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.a.invalidate();
    }
    if (QLog.isColorLevel()) {
      QLog.d("OrientationAdapterImageView", 2, "handleMessage:" + this.a.jdField_a_of_type_Int + "," + this.a.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflh
 * JD-Core Version:    0.7.0.1
 */