package com.tencent.biz.pubaccount.readinjoy.comment;

import amtj;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import bblk;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import oql;
import oqm;
import oqn;
import org.json.JSONArray;

public class CommentInfo
  extends oqn
  implements Serializable
{
  public static final int HOT_AREA = 1;
  public static final int NEW_AREA = 2;
  public boolean anonymous;
  public int area;
  public transient ArticleInfo articleInfo;
  public String authorAvatar = "";
  public String authorComment = "";
  public long authorCreateTime;
  public String authorHomepage = "";
  public String authorNickName = "";
  public transient SpannableStringBuilder authorRealCommentSpanSb;
  public int authorSelection;
  public String authorUin = "";
  public int awesome;
  public boolean commentByMyself;
  public String commentContent = "";
  public int commentCount;
  public String commentId = "";
  public long commentTime;
  public int commentType;
  public transient QQText decodedCommentContent;
  public int disLikeCount;
  public boolean disLiked;
  public transient JSONArray giftList;
  public boolean hasNextPage = true;
  public boolean hasTarget;
  public int level;
  public int likeCount;
  public boolean liked;
  public List<CommentInfo> mCommentItemLists = new ArrayList();
  public int nowPageNum = 1;
  public int page;
  public int rank = -1;
  public String retMsg = "";
  public transient List<SpannableStringBuilder> secondLevelCommentSpanSbList;
  public String subComments = "";
  public int subCommentsTotal;
  public String toNickName = "";
  public String toUin = "";
  public String uuid = "";
  
  public void createDecodedCommentContent()
  {
    if ((TextUtils.isEmpty(this.commentContent)) && (this.giftList == null)) {
      this.commentContent = amtj.a(2131701331);
    }
    this.decodedCommentContent = new QQText(bblk.b(this.commentContent), 7, 16);
  }
  
  public void createProcessedAuthorComment()
  {
    if (!TextUtils.isEmpty(this.authorComment))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append("作者回复：");
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FF8444")), 0, localSpannableStringBuilder.length(), 33);
      localSpannableStringBuilder.append(new QQText(bblk.b(this.authorComment), 7, 16));
      this.authorRealCommentSpanSb = localSpannableStringBuilder;
    }
  }
  
  public void createProcessedCommentItemList(BaseActivity paramBaseActivity)
  {
    if ((this.mCommentItemLists == null) || (this.mCommentItemLists.size() == 0)) {
      return;
    }
    label38:
    int i;
    label50:
    CommentInfo localCommentInfo;
    if (this.secondLevelCommentSpanSbList == null)
    {
      this.secondLevelCommentSpanSbList = new ArrayList();
      int j = this.mCommentItemLists.size();
      i = 0;
      if ((i < j) && (i < 2))
      {
        localCommentInfo = (CommentInfo)this.mCommentItemLists.get(i);
        if (localCommentInfo != null) {
          break label99;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break label50;
      break;
      this.secondLevelCommentSpanSbList.clear();
      break label38;
      label99:
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (!TextUtils.isEmpty(localCommentInfo.authorNickName))
      {
        localSpannableStringBuilder.append(localCommentInfo.authorNickName);
        localSpannableStringBuilder.setSpan(new oql(this, localCommentInfo, paramBaseActivity), 0, localSpannableStringBuilder.length(), 33);
      }
      if ((localCommentInfo.hasTarget) && (!TextUtils.isEmpty(localCommentInfo.toNickName)))
      {
        localSpannableStringBuilder.append(" 回复 ");
        int k = localSpannableStringBuilder.length();
        localSpannableStringBuilder.append(localCommentInfo.toNickName);
        localSpannableStringBuilder.setSpan(new oqm(this, localCommentInfo, paramBaseActivity), k, localSpannableStringBuilder.length(), 33);
      }
      localSpannableStringBuilder.append("：");
      if (!TextUtils.isEmpty(localCommentInfo.commentContent)) {
        localSpannableStringBuilder.append(new QQText(bblk.b(localCommentInfo.commentContent), 7, 16));
      }
      this.secondLevelCommentSpanSbList.add(localSpannableStringBuilder);
    }
  }
  
  public void toLogString(String paramString)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append(paramString).append("CommentInfo  info: article id=");
      if (this.articleInfo == null) {
        break label270;
      }
    }
    label270:
    for (paramString = Long.valueOf(this.articleInfo.mArticleID);; paramString = "null")
    {
      QLog.d("CommentInfo", 2, paramString + " uuid=" + this.uuid + " commentid=" + this.commentId + " commentcontent=" + this.commentContent + " commentTime=" + this.commentTime + " retMsg=" + this.retMsg + " likecount=" + this.likeCount + " liked=" + this.liked + " anonymous=" + this.anonymous + " level=" + this.level + " commentByMyself" + this.commentByMyself + " authorhome=" + this.authorHomepage + " authoruin" + this.authorUin + " authornickname" + this.authorNickName + " authorAvater=" + this.authorAvatar + " author_select=" + this.authorSelection + "  hastarget=" + this.hasTarget + "  toNick`name" + this.toNickName);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.CommentInfo
 * JD-Core Version:    0.7.0.1
 */