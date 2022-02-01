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
    if ((paramStoryShareTranslateTokenResponse != null) && (paramStoryShareTranslateTokenResponse.jdField_a_of_type_Int == 0))
    {
      if (((Boolean)((StoryConfigManager)SuperManager.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {
        paramStoryShareTranslateTokenRequest = StoryShareEncryptHelper.a(this.jdField_a_of_type_ArrayOfJavaLangString[1], this.jdField_a_of_type_Boolean);
      } else {
        paramStoryShareTranslateTokenRequest = this.jdField_a_of_type_ArrayOfJavaLangString[1];
      }
      paramErrorMessage = new StringBuilder();
      paramErrorMessage.append(this.jdField_a_of_type_ArrayOfJavaLangString[0]);
      paramErrorMessage.append("?token=");
      paramErrorMessage.append(paramStoryShareTranslateTokenResponse.jdField_a_of_type_JavaLangString);
      paramErrorMessage.append("&");
      paramErrorMessage.append(paramStoryShareTranslateTokenRequest);
      paramStoryShareTranslateTokenRequest = paramErrorMessage.toString();
      if (QLog.isColorLevel())
      {
        paramErrorMessage = new StringBuilder();
        paramErrorMessage.append("encrypt done url:");
        paramErrorMessage.append(paramStoryShareTranslateTokenRequest);
        QLog.d("Q.qqstory.share.trans.helper", 2, paramErrorMessage.toString());
      }
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareUtilStoryShareEncryptHelper$EncryptCallback.a(paramStoryShareTranslateTokenResponse, paramStoryShareTranslateTokenRequest, this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share.trans.helper", 2, "encrypt failed");
    }
    paramStoryShareTranslateTokenRequest = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((paramStoryShareTranslateTokenRequest != null) && (paramStoryShareTranslateTokenRequest.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131714356), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.1
 * JD-Core Version:    0.7.0.1
 */