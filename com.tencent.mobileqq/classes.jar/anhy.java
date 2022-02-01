import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;

class anhy
  extends anhs
{
  anhy(anhx paramanhx) {}
  
  public void a(boolean paramBoolean, FaceInfo paramFaceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onUpdateStrangerHead.faceInfo=" + paramFaceInfo + ", isSuccess=" + paramBoolean);
    }
    if ((this.a.mCancelled) || (this.a.mFaceInfo == null) || (paramFaceInfo == null)) {}
    while ((paramFaceInfo.b != this.a.mFaceInfo.b) || (!this.a.mFaceInfo.a.equals(paramFaceInfo.a))) {
      return;
    }
    if ((this.a.jdField_a_of_type_Anhs != null) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.removeObserver(this.a.jdField_a_of_type_Anhs);
    }
    if (paramBoolean)
    {
      paramFaceInfo = this.a.getBitmapFromCache();
      if (paramFaceInfo != null)
      {
        this.a.onDecodeTaskCompleted(this.a.mFaceInfo, paramFaceInfo);
        return;
      }
      this.a.requestDecode();
      return;
    }
    this.a.onDecodeTaskCompleted(this.a.mFaceInfo, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhy
 * JD-Core Version:    0.7.0.1
 */