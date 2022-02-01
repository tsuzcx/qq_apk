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
    if ((paramStoryShareTranslateTokenResponse != null) && (paramStoryShareTranslateTokenResponse.c == 0))
    {
      if (((Boolean)((StoryConfigManager)SuperManager.a(10)).c("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {
        paramStoryShareTranslateTokenRequest = ShareUtils.a(this.b[1], EncryptUrlJob.a(this.c));
      } else {
        paramStoryShareTranslateTokenRequest = this.b[1];
      }
      paramErrorMessage = new StringBuilder();
      paramErrorMessage.append(this.b[0]);
      paramErrorMessage.append("?token=");
      paramErrorMessage.append(paramStoryShareTranslateTokenResponse.a);
      paramErrorMessage.append("&");
      paramErrorMessage.append(paramStoryShareTranslateTokenRequest);
      paramStoryShareTranslateTokenRequest = paramErrorMessage.toString();
      if (QLog.isColorLevel()) {
        QLog.d("EncryptUrlJob", 2, new Object[] { "encrypt done url:", paramStoryShareTranslateTokenRequest });
      }
      this.c.a("EncryptUrlJob_coverUrl", paramStoryShareTranslateTokenResponse.b);
      this.c.a("EncryptUrlJob_encryptedUrl", paramStoryShareTranslateTokenRequest);
      EncryptUrlJob.b(this.c, true);
      return;
    }
    int i;
    if (paramStoryShareTranslateTokenResponse != null) {
      i = paramStoryShareTranslateTokenResponse.c;
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
    EncryptUrlJob.a(this.c, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.EncryptUrlJob.1
 * JD-Core Version:    0.7.0.1
 */