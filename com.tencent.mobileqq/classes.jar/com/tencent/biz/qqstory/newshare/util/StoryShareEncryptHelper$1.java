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
    if ((paramStoryShareTranslateTokenResponse != null) && (paramStoryShareTranslateTokenResponse.c == 0))
    {
      if (((Boolean)((StoryConfigManager)SuperManager.a(10)).c("key_share_encrypt_flag", Boolean.valueOf(false))).booleanValue()) {
        paramStoryShareTranslateTokenRequest = StoryShareEncryptHelper.a(this.c[1], this.d);
      } else {
        paramStoryShareTranslateTokenRequest = this.c[1];
      }
      paramErrorMessage = new StringBuilder();
      paramErrorMessage.append(this.c[0]);
      paramErrorMessage.append("?token=");
      paramErrorMessage.append(paramStoryShareTranslateTokenResponse.a);
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
      this.e.a(paramStoryShareTranslateTokenResponse, paramStoryShareTranslateTokenRequest, this.b);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share.trans.helper", 2, "encrypt failed");
    }
    paramStoryShareTranslateTokenRequest = this.b;
    if ((paramStoryShareTranslateTokenRequest != null) && (paramStoryShareTranslateTokenRequest.isShowing())) {
      this.b.dismiss();
    }
    QQToast.makeText(BaseApplication.getContext(), 1, HardCodeUtil.a(2131911870), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.1
 * JD-Core Version:    0.7.0.1
 */