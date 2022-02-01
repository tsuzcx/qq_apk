package com.tencent.biz.pubaccount.readinjoy.comment;

import bgku;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import owk;

public class ArticleCommentModule
  extends CommentInfo
{
  public boolean canComment;
  public int facecount;
  private List<CommentInfo> mCommentItemLists = new ArrayList();
  
  public ArticleCommentModule(ArticleInfo paramArticleInfo, int paramInt, String paramString1, String paramString2)
  {
    this.articleInfo = paramArticleInfo;
    this.commentId = paramString1;
    this.commentType = paramInt;
    this.uuid = paramString2;
  }
  
  public static CommentInfo buildFeedsOutsideComment(ArticleInfo paramArticleInfo, String paramString)
  {
    localObject = "";
    try
    {
      str = new JSONObject(paramString).getString("comment");
    }
    catch (JSONException paramString)
    {
      label59:
      break label59;
    }
    try
    {
      paramString = new String(bgku.decode(str, 0));
      localObject = paramString;
      QLog.d("ArticleCommentModule", 2, "buildFeedsOutsideComment commentVal " + paramString);
      localObject = paramString;
    }
    catch (JSONException paramString)
    {
      localObject = str;
      break label59;
    }
    paramString = new CommentInfo();
    paramString.articleInfo = paramArticleInfo;
    paramString.commentTime = (System.currentTimeMillis() / 1000L);
    paramString.liked = false;
    paramString.disLiked = false;
    paramString.commentContent = ((String)localObject);
    paramString.commentByMyself = true;
    paramString.rank = 1;
    paramArticleInfo = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramArticleInfo instanceof QQAppInterface))
    {
      paramString.authorUin = ((QQAppInterface)paramArticleInfo).getCurrentAccountUin();
      paramString.commentByMyself = true;
    }
    paramArticleInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramString.authorUin), new owk(paramString));
    if (paramArticleInfo != null) {}
    for (paramArticleInfo = paramArticleInfo.nick;; paramArticleInfo = ReadInJoyUserInfoModule.a())
    {
      paramString.authorNickName = paramArticleInfo;
      return paramString;
    }
  }
  
  public List<CommentInfo> getCommentList()
  {
    return this.mCommentItemLists;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule
 * JD-Core Version:    0.7.0.1
 */