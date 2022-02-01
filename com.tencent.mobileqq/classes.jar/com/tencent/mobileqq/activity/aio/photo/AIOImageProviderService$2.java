package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.DownAdapter;

class AIOImageProviderService$2
  extends UiCallBack.DownAdapter
{
  AIOImageProviderService$2(AIOImageProviderService paramAIOImageProviderService, long paramLong1, int paramInt1, int paramInt2, long paramLong2, String paramString) {}
  
  public void a(int paramInt, PicResult paramPicResult)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
    long l;
    int i;
    StringBuilder localStringBuilder;
    if (localObject != null) {
      if (paramPicResult.jdField_a_of_type_Int == 0)
      {
        ((IAIOImageProviderCallBack)localObject).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1, this.jdField_a_of_type_JavaLangString, paramPicResult.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
      }
      else
      {
        l = this.jdField_a_of_type_Long;
        paramInt = this.jdField_a_of_type_Int;
        i = this.jdField_b_of_type_Int;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("step:");
        localStringBuilder.append(paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(", desc:");
        localStringBuilder.append(paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
        ((IAIOImageProviderCallBack)localObject).a(l, paramInt, i, 2, localStringBuilder.toString(), paramPicResult.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "I:E");
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener;
    if (localObject != null)
    {
      if (paramPicResult.jdField_a_of_type_Int == 0)
      {
        ((AIOImageProviderService.AIOImageProviderListener)localObject).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 1, this.jdField_a_of_type_JavaLangString, paramPicResult.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_JavaLangString);
        return;
      }
      l = this.jdField_a_of_type_Long;
      paramInt = this.jdField_a_of_type_Int;
      i = this.jdField_b_of_type_Int;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("step:");
      localStringBuilder.append(paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", desc:");
      localStringBuilder.append(paramPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.b);
      ((AIOImageProviderService.AIOImageProviderListener)localObject).a(l, paramInt, i, 2, localStringBuilder.toString(), paramPicResult.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, "I:E");
    }
  }
  
  public void a_(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
    if (localObject != null) {
      ((IAIOImageProviderCallBack)localObject).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long, paramBoolean);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener;
    if (localObject != null) {
      ((AIOImageProviderService.AIOImageProviderListener)localObject).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt, this.jdField_b_of_type_Long, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.2
 * JD-Core Version:    0.7.0.1
 */