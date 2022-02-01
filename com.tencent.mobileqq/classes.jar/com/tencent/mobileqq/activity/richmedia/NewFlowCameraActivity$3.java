package com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class NewFlowCameraActivity$3
  implements TroopMemberApiClient.Callback
{
  NewFlowCameraActivity$3(NewFlowCameraActivity paramNewFlowCameraActivity, String paramString1, String paramString2) {}
  
  public void callback(Bundle paramBundle)
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getIntent();
    if ((paramBundle != null) && (paramBundle.getBoolean("isSuccess")) && (paramBundle.getInt("head_id") >= 0) && (!TextUtils.isEmpty(paramBundle.getString("video_id"))))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a();
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("video_path", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("photo_path", this.b);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.a();
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity, 1, HardCodeUtil.a(2131707473), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.3
 * JD-Core Version:    0.7.0.1
 */