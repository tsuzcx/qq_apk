package com.tencent.mobileqq.app.face;

import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class NearByFaceDrawable$1
  extends FaceObserver
{
  NearByFaceDrawable$1(NearByFaceDrawable paramNearByFaceDrawable) {}
  
  public void a(boolean paramBoolean, FaceInfo paramFaceInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onUpdateStrangerHead.faceInfo=" + paramFaceInfo + ", isSuccess=" + paramBoolean);
    }
    if ((this.a.mCancelled) || (this.a.mFaceInfo == null) || (paramFaceInfo == null)) {}
    while ((paramFaceInfo.b != this.a.mFaceInfo.b) || (!this.a.mFaceInfo.a.equals(paramFaceInfo.a))) {
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver != null) && (this.a.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
      this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.NearByFaceDrawable.1
 * JD-Core Version:    0.7.0.1
 */