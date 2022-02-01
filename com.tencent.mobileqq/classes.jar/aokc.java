import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.mobileqq.minicode.recog.MiniCodeDetector;
import com.tencent.mobileqq.minicode.recog.RecogCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class aokc
  implements RecogCallback
{
  aokc(aokb paramaokb, Rect paramRect, long paramLong, Object paramObject, MiniCodeDetector paramMiniCodeDetector, boolean[] paramArrayOfBoolean, Bitmap paramBitmap) {}
  
  public void onDetectReady(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector != null) && (aokb.a(this.jdField_a_of_type_Aokb) != null)) {
      this.jdField_a_of_type_ArrayOfBoolean[0] = this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector.detect(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Long);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniCodeController", 2, "detectSync onDetectReady exec=" + this.jdField_a_of_type_ArrayOfBoolean[0]);
      }
      if (this.jdField_a_of_type_ArrayOfBoolean[0] == 0) {}
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
        this.jdField_a_of_type_ArrayOfBoolean[0] = false;
      }
    }
  }
  
  public void onDetectResult(List<aojx> arg1, long paramLong)
  {
    int i = 0;
    label55:
    boolean bool;
    label68:
    int j;
    int k;
    int m;
    if (i < ???.size())
    {
      if (((aojx)???.get(i)).jdField_a_of_type_Int != 2) {
        break label217;
      }
      ??? = (aojx)???.get(i);
      this.jdField_a_of_type_AndroidGraphicsRect.set(???.jdField_a_of_type_AndroidGraphicsRect);
      if (QLog.isColorLevel())
      {
        if (??? == null) {
          break label226;
        }
        bool = true;
        i = this.jdField_a_of_type_AndroidGraphicsRect.left;
        j = this.jdField_a_of_type_AndroidGraphicsRect.top;
        k = this.jdField_a_of_type_AndroidGraphicsRect.width();
        m = this.jdField_a_of_type_AndroidGraphicsRect.height();
        if (??? == null) {
          break label232;
        }
      }
    }
    label217:
    label226:
    label232:
    for (float f = ???.jdField_a_of_type_Float;; f = 0.0F)
    {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("detectSync onDetectResult=%b [left,top,w,h,score]=[%d, %d, %d, %d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(f) }));
      if (paramLong == this.jdField_a_of_type_Long)
      {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          this.jdField_a_of_type_JavaLangObject.notifyAll();
          return;
        }
        ??? = null;
        break label55;
      }
      return;
      i += 1;
      break;
      bool = false;
      break label68;
    }
  }
  
  public void onSaveImg(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aokc
 * JD-Core Version:    0.7.0.1
 */