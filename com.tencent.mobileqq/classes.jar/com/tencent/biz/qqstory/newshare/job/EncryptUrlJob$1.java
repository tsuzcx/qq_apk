package com.tencent.biz.qqstory.newshare.job;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest;
import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse;
import com.tencent.biz.qqstory.newshare.util.ShareUtils;
import com.tencent.qphone.base.util.QLog;

class EncryptUrlJob$1
  extends CmdTaskManger.UIThreadCallback<StoryShareTranslateTokenRequest, StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse>
{
  EncryptUrlJob$1(EncryptUrlJob paramEncryptUrlJob, String[] paramArrayOfString) {}
  
  public void a(@NonNull StoryShareTranslateTokenRequest paramStoryShareTranslateTokenRequest, @Nullable StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse paramStoryShareTranslateTokenResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramStoryShareTranslateTokenResponse != null) && (paramStoryShareTranslateTokenResponse.jdField_a_of_type_Int == 0))
    {
      if (((Boolean)((StoryConfigManager)SuperManager.a(10)).b("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {
        paramStoryShareTranslateTokenRequest = ShareUtils.a(this.jdField_a_of_type_ArrayOfJavaLangString[1], EncryptUrlJob.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobEncryptUrlJob));
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
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt done url:", paramStoryShareTranslateTokenRequest });
      }
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobEncryptUrlJob.a("EncryptUrlJob_coverUrl", paramStoryShareTranslateTokenResponse.c);
      this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobEncryptUrlJob.a("EncryptUrlJob_encryptedUrl", paramStoryShareTranslateTokenRequest);
      EncryptUrlJob.b(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobEncryptUrlJob, true);
      return;
    }
    int i;
    if (paramStoryShareTranslateTokenResponse != null) {
      i = paramStoryShareTranslateTokenResponse.jdField_a_of_type_Int;
    } else {
      i = -1;
    }
    if (QLog.isColorLevel())
    {
      paramStoryShareTranslateTokenRequest = new StringBuilder();
      paramStoryShareTranslateTokenRequest.append("encrypt failed, error code = ");
      paramStoryShareTranslateTokenRequest.append(i);
      QLog.e("EncryptUrlJob", 2, paramStoryShareTranslateTokenRequest.toString());
    }
    EncryptUrlJob.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobEncryptUrlJob, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.EncryptUrlJob.1
 * JD-Core Version:    0.7.0.1
 */