import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.mobileqq.minicode.recog.MiniCodeDetector;
import com.tencent.mobileqq.minicode.recog.RecogCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class apnd
  implements RecogCallback
{
  apnd(apnc paramapnc, ArrayList paramArrayList, long paramLong, Object paramObject, MiniCodeDetector paramMiniCodeDetector, boolean[] paramArrayOfBoolean, Bitmap paramBitmap) {}
  
  public void onDetectReady(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMinicodeRecogMiniCodeDetector != null) && (apnc.a(this.jdField_a_of_type_Apnc) != null)) {
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
  
  public void onDetectResult(List<apmz> arg1, long paramLong)
  {
    int i = 0;
    if (i < ???.size())
    {
      apmz localapmz = (apmz)???.get(i);
      if ((localapmz == null) || (localapmz.a.isEmpty())) {}
      for (;;)
      {
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilArrayList.add(localapmz);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("detectSync onDetectResult=%s", new Object[] { this.jdField_a_of_type_JavaUtilArrayList }));
    }
    if (paramLong == this.jdField_a_of_type_Long) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notifyAll();
        return;
      }
    }
  }
  
  public void onSaveImg(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apnd
 * JD-Core Version:    0.7.0.1
 */