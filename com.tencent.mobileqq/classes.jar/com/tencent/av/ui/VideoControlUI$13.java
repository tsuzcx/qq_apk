package com.tencent.av.ui;

import android.view.View;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class VideoControlUI$13
  implements QQPermissionCallback
{
  VideoControlUI$13(VideoControlUI paramVideoControlUI, String paramString, long paramLong, View paramView) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    String str = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Camera, deny, i[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mRequestPermissionIng[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.p);
    localStringBuilder.append("], permissions[");
    localStringBuilder.append(AudioHelper.a(paramArrayOfString));
    localStringBuilder.append("], grantResults[");
    localStringBuilder.append(AudioHelper.a(paramArrayOfInt));
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    paramArrayOfString = this.jdField_a_of_type_ComTencentAvUiVideoControlUI;
    paramArrayOfString.p = false;
    paramArrayOfString.e(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    String str = this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Camera, grant, i[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mRequestPermissionIng[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.p);
    localStringBuilder.append("], permissions[");
    localStringBuilder.append(AudioHelper.a(paramArrayOfString));
    localStringBuilder.append("], grantResults[");
    localStringBuilder.append(AudioHelper.a(paramArrayOfInt));
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.p = false;
    if ("android.permission.CAMERA".equals(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    if ("android.permission.RECORD_AUDIO".equals(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g(this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.13
 * JD-Core Version:    0.7.0.1
 */