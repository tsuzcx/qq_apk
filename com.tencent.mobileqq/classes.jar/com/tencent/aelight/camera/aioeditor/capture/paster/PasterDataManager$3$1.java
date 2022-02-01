package com.tencent.aelight.camera.aioeditor.capture.paster;

import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

class PasterDataManager$3$1
  extends LbsManager.OnLocationListener
{
  PasterDataManager$3$1(PasterDataManager.3 param3, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLocationUpdate() latitude=");
      localStringBuilder.append(paramSosoLbsInfo.mLocation.mLat02);
      localStringBuilder.append(" longitude=");
      localStringBuilder.append(paramSosoLbsInfo.mLocation.mLon02);
      SLog.b("PasterDataManager", localStringBuilder.toString());
      PasterDataManager.a(this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterPasterDataManager, true);
      PasterDataManager.a(this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterPasterDataManager, this.a.jdField_a_of_type_Boolean);
      this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterPasterDataManager.a(null);
      return;
    }
    SLog.b("PasterDataManager", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager.3.1
 * JD-Core Version:    0.7.0.1
 */