import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.fragment.DeleteFaceFragment;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class avdx
  implements avwz
{
  public avdx(DeleteFaceFragment paramDeleteFaceFragment, String paramString1, String paramString2) {}
  
  public void a(int paramInt, String paramString)
  {
    if (DeleteFaceFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment))
    {
      QLog.e("DeleteFaceFragment", 1, "getConfFailed, activity is null");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment.b();
    QLog.e("DeleteFaceFragment", 1, new Object[] { "sendGetTmpKeyRequest error, ", paramString });
    QQToast.a(DeleteFaceFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment), paramString, 0).a();
  }
  
  public void a(FaceDetectForThirdPartyManager.AppConf paramAppConf)
  {
    if (DeleteFaceFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment))
    {
      QLog.e("DeleteFaceFragment", 1, "getConfSuccess, activity is null");
      return;
    }
    int i;
    if (Build.VERSION.SDK_INT >= 23) {
      if (DeleteFaceFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment).checkSelfPermission("android.permission.CAMERA") == 0) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        DeleteFaceFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment).requestPermissions(new avdy(this, paramAppConf), 1, new String[] { "android.permission.CAMERA" });
        return;
        i = 0;
      }
      else
      {
        DeleteFaceFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentDeleteFaceFragment, this.jdField_a_of_type_JavaLangString, this.b, paramAppConf);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdx
 * JD-Core Version:    0.7.0.1
 */