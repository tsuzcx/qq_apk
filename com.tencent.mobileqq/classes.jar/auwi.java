import com.tencent.mobileqq.profile.VipProfileCardPreviewActivity.4;
import com.tencent.qphone.base.util.QLog;

public class auwi
  extends bbwt
{
  public auwi(VipProfileCardPreviewActivity.4 param4) {}
  
  public void onDone(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style end download, url : %s, resultCode : %d ", new Object[] { parambbwu.jdField_a_of_type_JavaLangString, Integer.valueOf(parambbwu.jdField_a_of_type_Int) }));
    }
  }
  
  public void onProgress(bbwu parambbwu)
  {
    int i = (int)parambbwu.jdField_a_of_type_Float;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style progress, url : %s, progress : %d", new Object[] { parambbwu.jdField_a_of_type_JavaLangString, Integer.valueOf(i) }));
    }
  }
  
  public boolean onStart(bbwu parambbwu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.VipProfileCardPreviewActivity", 2, String.format("Resource style start download, url : %s, position : %s ", new Object[] { parambbwu.jdField_a_of_type_JavaLangString, Integer.valueOf(this.a.jdField_a_of_type_Int) }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwi
 * JD-Core Version:    0.7.0.1
 */