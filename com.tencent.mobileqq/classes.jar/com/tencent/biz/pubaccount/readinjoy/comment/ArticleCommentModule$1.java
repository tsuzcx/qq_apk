package com.tencent.biz.pubaccount.readinjoy.comment;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;

final class ArticleCommentModule$1
  implements ReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ArticleCommentModule$1(CommentInfo paramCommentInfo) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(this.a.authorUin)) || (paramReadInJoyUserInfo == null)) {
      return;
    }
    this.a.authorNickName = paramReadInJoyUserInfo.nick;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.1
 * JD-Core Version:    0.7.0.1
 */