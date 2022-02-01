package com.tencent.biz.qqstory.newshare.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.UIThreadCallback;
import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest;
import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class StoryShareEncryptHelper$2$1
  extends CmdTaskManger.UIThreadCallback<StoryShareTranslateTokenRequest, StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse>
{
  StoryShareEncryptHelper$2$1(StoryShareEncryptHelper.2 param2, long paramLong, QQProgressDialog paramQQProgressDialog) {}
  
  public void a(@NonNull StoryShareTranslateTokenRequest paramStoryShareTranslateTokenRequest, @Nullable StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse paramStoryShareTranslateTokenResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (QLog.isColorLevel())
    {
      paramStoryShareTranslateTokenRequest = new StringBuilder();
      paramStoryShareTranslateTokenRequest.append("decrypt done costTime = ");
      paramStoryShareTranslateTokenRequest.append(System.currentTimeMillis() - this.b);
      paramStoryShareTranslateTokenRequest.append(", resp:");
      paramStoryShareTranslateTokenRequest.append(paramStoryShareTranslateTokenResponse);
      QLog.d("Q.qqstory.share.trans.helper", 2, paramStoryShareTranslateTokenRequest.toString());
    }
    StoryReportor.a("StoryShareEncryptHelper", "decrypt", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.b) });
    this.d.d.a(paramStoryShareTranslateTokenResponse, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.2.1
 * JD-Core Version:    0.7.0.1
 */