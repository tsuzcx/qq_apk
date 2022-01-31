import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.4;
import com.tencent.qphone.base.util.QLog;

public class awnu
  extends bdvu
{
  public awnu(VipProfileCardPreviewActivity.4 param4) {}
  
  public void onDone(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style end download, url : %s, resultCode : %d ", new Object[] { parambdvv.jdField_a_of_type_JavaLangString, Integer.valueOf(parambdvv.jdField_a_of_type_Int) }));
    }
  }
  
  public void onProgress(bdvv parambdvv)
  {
    int i = (int)parambdvv.jdField_a_of_type_Float;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style progress, url : %s, progress : %d", new Object[] { parambdvv.jdField_a_of_type_JavaLangString, Integer.valueOf(i) }));
    }
  }
  
  public boolean onStart(bdvv parambdvv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style start download, url : %s, position : %s ", new Object[] { parambdvv.jdField_a_of_type_JavaLangString, Integer.valueOf(this.a.jdField_a_of_type_Int) }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awnu
 * JD-Core Version:    0.7.0.1
 */