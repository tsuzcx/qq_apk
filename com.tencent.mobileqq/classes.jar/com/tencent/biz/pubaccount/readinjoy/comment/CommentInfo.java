package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class CommentInfo
  extends CommentInfoConstants
  implements Serializable
{
  private String TAG = "CommentInfo";
  public boolean anonymous;
  public transient ArticleInfo articleInfo;
  public String authorAvater = "";
  public String authorComment = "";
  public long authorCreateTime;
  public String authorHomepage = "";
  public String authorNickName = "";
  public String authorUin = "";
  public int author_selection;
  public boolean commentByMyself;
  public String commentContent = "";
  public int commentCount;
  public String commentId = "";
  public long commentTime;
  public int commentType;
  public transient JSONArray gift_list;
  public boolean hasNextPage = true;
  public boolean hasTarget;
  public int level;
  public int likeCount;
  public boolean liked;
  public List mCommentItemLists = new ArrayList();
  public int nowPageNum = 1;
  public int page;
  public int rank = -1;
  public String retMsg = "";
  public String sub_comments = "";
  public int sub_comments_total;
  public String toNickName = "";
  public String toUin = "";
  public String uuid = "";
  
  public void toLogString(String paramString)
  {
    String str;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str = this.TAG;
      localStringBuilder = new StringBuilder().append(paramString).append("CommentInfo  info: article id=");
      if (this.articleInfo == null) {
        break label264;
      }
    }
    label264:
    for (paramString = Long.valueOf(this.articleInfo.mArticleID);; paramString = "null")
    {
      QLog.d(str, 2, paramString + " uuid=" + this.uuid + " commentid=" + this.commentId + " commentcontent=" + this.commentContent + " commentTime=" + this.commentTime + " retMsg=" + this.retMsg + " likecount=" + this.likeCount + " liked=" + this.liked + " anonymous=" + this.anonymous + " level=" + this.level + " commentByMyself" + this.commentByMyself + " authorhome=" + this.authorHomepage + " authoruin" + this.authorUin + " authornickname" + this.authorNickName + " authorAvater=" + this.authorAvater + " author_select=" + this.author_selection + "  hastarget=" + this.hasTarget + "  toNick`name" + this.toNickName);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo
 * JD-Core Version:    0.7.0.1
 */