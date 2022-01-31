import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.IFaceSelectedListener;
import dov.com.qq.im.capture.paster.CaptureComboNormalPaster;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.model.SelectedItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.NormalFacePackage;
import java.util.HashMap;

public final class amwo
  implements URLDrawable.URLDrawableListener
{
  public amwo(String paramString1, int paramInt1, float paramFloat1, String paramString2, NormalFacePackage paramNormalFacePackage, int paramInt2, IFaceSelectedListener paramIFaceSelectedListener, float paramFloat2, int paramInt3, float paramFloat3, SegmentKeeper paramSegmentKeeper) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    CaptureComboNormalPaster.a.remove(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "applyNormalPaster onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    CaptureComboNormalPaster.a.remove(this.jdField_a_of_type_JavaLangString);
    int i = paramURLDrawable.getIntrinsicWidth();
    paramURLDrawable.setBounds(0, 0, i, paramURLDrawable.getIntrinsicHeight());
    float f = this.jdField_a_of_type_Int * this.jdField_a_of_type_Float / i;
    if (QLog.isColorLevel()) {
      QLog.d("QComboNPaster", 2, "applyNormalPaster onLoadSuccessed w=" + i + " scale=" + f + " name=" + this.jdField_b_of_type_JavaLangString);
    }
    paramURLDrawable = new SelectedItem(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiFaceNormalFacePackage.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramURLDrawable, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_DovComQqImCaptureDataIFaceSelectedListener.a(paramURLDrawable, this.jdField_a_of_type_Int * this.jdField_b_of_type_Float, this.jdField_c_of_type_Int * this.jdField_c_of_type_Float, f, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amwo
 * JD-Core Version:    0.7.0.1
 */