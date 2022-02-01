package com.tencent.mobileqq.app.parser;

import com.tencent.biz.qqstory.network.request.StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper;
import com.tencent.biz.qqstory.newshare.util.StoryShareEncryptHelper.DecryptCallback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

class QQstoryAction$1
  implements StoryShareEncryptHelper.DecryptCallback
{
  QQstoryAction$1(QQstoryAction paramQQstoryAction) {}
  
  public void a(StoryShareTranslateTokenRequest.StoryShareTranslateTokenResponse paramStoryShareTranslateTokenResponse, QQProgressDialog paramQQProgressDialog)
  {
    if ((paramQQProgressDialog != null) && (paramQQProgressDialog.isShowing())) {
      paramQQProgressDialog.dismiss();
    }
    StoryShareEncryptHelper.a(this.a.f);
    if ((paramStoryShareTranslateTokenResponse != null) && (paramStoryShareTranslateTokenResponse.c == 0))
    {
      StoryShareEncryptHelper.a(paramStoryShareTranslateTokenResponse.a, this.a.f);
      QQstoryAction.a(this.a);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))
    {
      QQToast.makeText(BaseApplicationImpl.getApplication(), 1, 2131892105, 1).show();
      return;
    }
    paramStoryShareTranslateTokenResponse = this.a;
    paramStoryShareTranslateTokenResponse.e = "open";
    QQstoryAction.a(paramStoryShareTranslateTokenResponse);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQstoryAction.1
 * JD-Core Version:    0.7.0.1
 */