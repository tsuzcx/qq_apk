package com.tencent.biz.qqstory.takevideo;

import com.tencent.biz.qqstory.model.lbs.LbsManager.OnLocationListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

class EditVideoPoi$3$1
  extends LbsManager.OnLocationListener
{
  EditVideoPoi$3$1(EditVideoPoi.3 param3, String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    super.onLocationFinish(paramInt, paramSosoLbsInfo);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.a = paramSosoLbsInfo.mLocation.mLat02;
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.b = paramSosoLbsInfo.mLocation.mLon02;
      SLog.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() latitude=" + this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.a + " longitude=" + this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.b);
      if (this.a.jdField_a_of_type_Boolean) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.g();
      }
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.a = 0.0D;
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.b = 0.0D;
    SLog.b("Q.qqstory.publish.edit.EditVideoPoi", "onLocationUpdate() error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPoi.3.1
 * JD-Core Version:    0.7.0.1
 */