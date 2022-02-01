package com.tencent.avgame.gameroom.video;

import android.view.View;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class AVGameControlUI$1
  implements QQPermissionCallback
{
  AVGameControlUI$1(AVGameControlUI paramAVGameControlUI, String paramString, long paramLong, int paramInt, View paramView) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    String str = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Camera, deny, i[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mRequestPermissionIng[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.jdField_a_of_type_Boolean);
    localStringBuilder.append("], permissions[");
    localStringBuilder.append(QQAudioHelper.a(paramArrayOfString));
    localStringBuilder.append("], grantResults[");
    localStringBuilder.append(QQAudioHelper.a(paramArrayOfInt));
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    paramArrayOfString = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
    paramArrayOfString.jdField_a_of_type_Boolean = false;
    paramArrayOfString.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    String str = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Camera, grant, i[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mRequestPermissionIng[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.jdField_a_of_type_Boolean);
    localStringBuilder.append("], permissions[");
    localStringBuilder.append(QQAudioHelper.a(paramArrayOfString));
    localStringBuilder.append("], grantResults[");
    localStringBuilder.append(QQAudioHelper.a(paramArrayOfInt));
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.jdField_a_of_type_Boolean = false;
    if ("android.permission.CAMERA".equals(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidViewView);
      return;
    }
    if ("android.permission.RECORD_AUDIO".equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidViewView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUI.1
 * JD-Core Version:    0.7.0.1
 */