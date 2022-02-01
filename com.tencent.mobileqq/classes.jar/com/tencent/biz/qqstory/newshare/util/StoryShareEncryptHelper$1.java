package com.tencent.biz.qqstory.newshare.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest;
import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

final class StoryShareEncryptHelper$1
  extends CmdTaskManger.UIThreadCallback<StoryShareTranslateTokenRequest, StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse>
{
  public void a(@NonNull StoryShareTranslateTokenRequest paramStoryShareTranslateTokenRequest, @Nullable StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse paramStoryShareTranslateTokenResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramStoryShareTranslateTokenResponse == null) || (paramStoryShareTranslateTokenResponse.jdField_a_of_type_Int != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share.trans.helper", 2, "encrypt failed");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131714435), 0).a();
      return;
    }
    if (((Boolean)((StoryConfigManager)SuperManager.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {}
    for (paramStoryShareTranslateTokenRequest = StoryShareEncryptHelper.a(this.jdField_a_of_type_ArrayOfJavaLangString[1], this.jdField_a_of_type_Boolean);; paramStoryShareTranslateTokenRequest = this.jdField_a_of_type_ArrayOfJavaLangString[1])
    {
      paramStoryShareTranslateTokenRequest = this.jdField_a_of_type_ArrayOfJavaLangString[0] + "?token=" + paramStoryShareTranslateTokenResponse.jdField_a_of_type_JavaLangString + "&" + paramStoryShareTranslateTokenRequest;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share.trans.helper", 2, "encrypt done url:" + paramStoryShareTranslateTokenRequest);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareUtilStoryShareEncryptHelper$EncryptCallback.a(paramStoryShareTranslateTokenResponse, paramStoryShareTranslateTokenRequest, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.1
 * JD-Core Version:    0.7.0.1
 */