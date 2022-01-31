import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.4;
import com.tencent.qphone.base.util.QLog;

public class atyh
  extends batl
{
  public atyh(VipProfileCardPreviewActivity.4 param4) {}
  
  public void onDone(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style end download, url : %s, resultCode : %d ", new Object[] { parambatm.jdField_a_of_type_JavaLangString, Integer.valueOf(parambatm.jdField_a_of_type_Int) }));
    }
  }
  
  public void onProgress(batm parambatm)
  {
    int i = (int)parambatm.jdField_a_of_type_Float;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style progress, url : %s, progress : %d", new Object[] { parambatm.jdField_a_of_type_JavaLangString, Integer.valueOf(i) }));
    }
  }
  
  public boolean onStart(batm parambatm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style start download, url : %s, position : %s ", new Object[] { parambatm.jdField_a_of_type_JavaLangString, Integer.valueOf(this.a.jdField_a_of_type_Int) }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyh
 * JD-Core Version:    0.7.0.1
 */