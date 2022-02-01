package com.tencent.av.ui;

import android.view.View;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class VideoControlUI$13
  implements QQPermissionCallback
{
  VideoControlUI$13(VideoControlUI paramVideoControlUI, String paramString, long paramLong, View paramView) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d, 1, "onClick_Camera, deny, i[" + paramInt + "], mRequestPermissionIng[" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.p + "], permissions[" + AudioHelper.a(paramArrayOfString) + "], grantResults[" + AudioHelper.a(paramArrayOfInt) + "]");
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.p = false;
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d, 1, "onClick_Camera, grant, i[" + paramInt + "], mRequestPermissionIng[" + this.jdField_a_of_type_ComTencentAvUiVideoControlUI.p + "], permissions[" + AudioHelper.a(paramArrayOfString) + "], grantResults[" + AudioHelper.a(paramArrayOfInt) + "]");
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.p = false;
    if ("android.permission.CAMERA".equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentAvUiVideoControlUI.e(this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidViewView);
    }
    do
    {
      return;
      if ("android.permission.RECORD_AUDIO".equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentAvUiVideoControlUI.d(this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidViewView);
        return;
      }
    } while (!"android.permission.WRITE_EXTERNAL_STORAGE".equals(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentAvUiVideoControlUI.g(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.13
 * JD-Core Version:    0.7.0.1
 */