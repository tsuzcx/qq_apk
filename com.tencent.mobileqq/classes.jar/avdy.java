import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import mqq.app.QQPermissionCallback;

class avdy
  implements QQPermissionCallback
{
  avdy(avdx paramavdx, FaceDetectForThirdPartyManager.AppConf paramAppConf) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_Avdx.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment.b();
    bhlq.a(DeleteFaceFragment.a(this.jdField_a_of_type_Avdx.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment), paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DeleteFaceFragment.a(this.jdField_a_of_type_Avdx.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment, this.jdField_a_of_type_Avdx.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Avdx.b, this.jdField_a_of_type_ComTencentMobileqqJspFaceDetectForThirdPartyManager$AppConf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdy
 * JD-Core Version:    0.7.0.1
 */