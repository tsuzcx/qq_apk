package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.qphone.base.util.QLog;

class SdkDynamicAvatarSettingHelper$2$1
  extends ProtoUtils.TroopProtocolObserver
{
  SdkDynamicAvatarSettingHelper$2$1(SdkDynamicAvatarSettingHelper.2 param2, long paramLong) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SdkDynamicAvatarSettingHelper", 2, new Object[] { "checkOpenidDiff, onResult, errorCode=", Integer.valueOf(paramInt) });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSdkDynamicAvatarSettingHelper$2.a.isFinishing()) || (System.currentTimeMillis() - this.jdField_a_of_type_Long > 5000L)) {}
    while (paramInt != 16) {
      return;
    }
    SdkDynamicAvatarSettingHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoSdkDynamicAvatarSettingHelper$2.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.SdkDynamicAvatarSettingHelper.2.1
 * JD-Core Version:    0.7.0.1
 */