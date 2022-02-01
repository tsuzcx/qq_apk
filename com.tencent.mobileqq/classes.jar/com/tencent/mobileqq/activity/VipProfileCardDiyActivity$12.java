package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.profile.upload.task.VipBaseUpsImageUploadTask;
import com.tencent.upload.uinterface.data.UpsImageUploadResult;

class VipProfileCardDiyActivity$12
  extends VipBaseUpsImageUploadTask
{
  VipProfileCardDiyActivity$12(VipProfileCardDiyActivity paramVipProfileCardDiyActivity, long paramLong, String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, boolean paramBoolean)
  {
    super(paramLong, paramString1, paramArrayOfByte, paramString2);
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1001)
    {
      if (paramInt != 1002) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.k();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.k();
    if (a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVipProfileCardDiyActivity.a(this.jdField_a_of_type_JavaLangString, (UpsImageUploadResult)a(), this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.12
 * JD-Core Version:    0.7.0.1
 */