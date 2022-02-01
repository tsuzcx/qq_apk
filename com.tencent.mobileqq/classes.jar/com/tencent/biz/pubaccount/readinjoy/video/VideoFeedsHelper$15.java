package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.qphone.base.util.QLog;

final class VideoFeedsHelper$15
  implements UserOperationModule.Ox978RespCallBack
{
  VideoFeedsHelper$15(String paramString, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsHelper", 2, "followPubAccount() onFollowPublicAccount uin=" + this.jdField_a_of_type_JavaLangString + ", isSuccess=" + paramBoolean + ", isUGC=" + this.jdField_a_of_type_Boolean + ", data=" + paramInt);
    }
    VideoFeedsHelper.a(paramBoolean, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.15
 * JD-Core Version:    0.7.0.1
 */