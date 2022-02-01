package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.shortvideo.UiCallBack.DownAdapter;

class AIOImageProviderService$3
  extends UiCallBack.DownAdapter
{
  AIOImageProviderService$3(AIOImageProviderService paramAIOImageProviderService, long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a;
    if (localIAIOImageProviderCallBack != null) {
      localIAIOImageProviderCallBack.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramInt, 0L, true);
    }
  }
  
  public void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    IAIOImageProviderCallBack localIAIOImageProviderCallBack = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a;
    if (paramShortVideoResult.jdField_a_of_type_Int == 0)
    {
      paramShortVideoResult = (DownCallBack.DownResult)paramShortVideoResult.jdField_a_of_type_JavaLangObject;
      if (localIAIOImageProviderCallBack != null) {
        localIAIOImageProviderCallBack.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, 1, paramShortVideoResult.b, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, paramShortVideoResult.b);
      return;
    }
    if (localIAIOImageProviderCallBack != null)
    {
      long l = this.jdField_a_of_type_Long;
      paramInt = this.jdField_a_of_type_Int;
      int i = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("step:");
      localStringBuilder.append(paramShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.a);
      localStringBuilder.append(", desc:");
      localStringBuilder.append(paramShortVideoResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
      localIAIOImageProviderCallBack.a(l, paramInt, i, 2, localStringBuilder.toString(), false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.b, "I:E");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.3
 * JD-Core Version:    0.7.0.1
 */