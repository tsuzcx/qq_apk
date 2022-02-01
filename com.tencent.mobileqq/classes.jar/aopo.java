import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

class aopo
  extends aopi
{
  aopo(aopn paramaopn) {}
  
  public void a(boolean paramBoolean, FaceInfo paramFaceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onUpdateStrangerHead.faceInfo=" + paramFaceInfo + ", isSuccess=" + paramBoolean);
    }
    if ((this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo == null) || (paramFaceInfo == null)) {}
    while ((paramFaceInfo.b != this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.b) || (!this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo.a.equals(paramFaceInfo.a))) {
      return;
    }
    if ((this.a.jdField_a_of_type_Aopi != null) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.a.jdField_a_of_type_Aopi);
    }
    if (paramBoolean)
    {
      paramFaceInfo = this.a.a();
      if (paramFaceInfo != null)
      {
        this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo, paramFaceInfo);
        return;
      }
      this.a.a();
      return;
    }
    this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceInfo, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aopo
 * JD-Core Version:    0.7.0.1
 */