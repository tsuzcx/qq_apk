import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;

class bazh
  extends ajvz
{
  bazh(bazg parambazg) {}
  
  public void a(boolean paramBoolean, FaceInfo paramFaceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onUpdateStrangerHead.faceInfo=" + paramFaceInfo + ", isSuccess=" + paramBoolean);
    }
    if ((this.a.b) || (this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo == null) || (paramFaceInfo == null)) {}
    while ((paramFaceInfo.b != this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.b) || (!this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo.a.equals(paramFaceInfo.a))) {
      return;
    }
    if ((this.a.jdField_a_of_type_Ajvz != null) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.a.jdField_a_of_type_Ajvz);
    }
    if (paramBoolean)
    {
      paramFaceInfo = this.a.b();
      if (paramFaceInfo != null)
      {
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, paramFaceInfo);
        return;
      }
      this.a.a();
      return;
    }
    this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bazh
 * JD-Core Version:    0.7.0.1
 */