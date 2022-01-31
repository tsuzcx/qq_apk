import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class bjff
  implements URLDrawable.URLDrawableListener
{
  bjff(String paramString1, String paramString2, bkgj parambkgj, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper, bjcu parambjcu, int paramInt3) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    bjfe.a.remove(this.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "applyNormalPaster onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "urlDrawableListener onLoadSuccessed");
    }
    bjfe.a(paramURLDrawable, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bkgj, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper, this.jdField_a_of_type_Bjcu, this.jdField_c_of_type_Int);
    bjfe.a.remove(this.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjff
 * JD-Core Version:    0.7.0.1
 */