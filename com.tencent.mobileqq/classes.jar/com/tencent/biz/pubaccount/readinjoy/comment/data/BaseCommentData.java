package com.tencent.biz.pubaccount.readinjoy.comment.data;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;
import orr;
import pdn;
import pdo;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ActivityLevel;

public abstract class BaseCommentData
  implements Serializable
{
  public static final int MAIN_COMMENT = 1;
  public static final int SUB_COMMENT = 2;
  public static final String TAG = "BaseCommentData";
  public pdn accountLevelInfo;
  public long activityCfgID;
  public String activityJumpUrl;
  public oidb_cmd0xc46.ActivityLevel activityLevel;
  public String activityPicUrl;
  public AdvertisementInfo advertisementInfo;
  public int anonymous;
  public String authorComment;
  public int authorSelection;
  public String avatar;
  public String avatarPendantUrl;
  public int awesome;
  public String commentContent;
  public String commentId;
  public List<BaseCommentData.CommentLinkData> commentLinkDataList;
  public long commentTime;
  public int contentSrc;
  public int createSrc;
  public int disLike;
  public String flowGuidePtsData;
  public String homepage;
  public int isActivity;
  public boolean isAd;
  public boolean isAnchor;
  public int isApproved;
  public boolean isAuthorLike;
  public int isAuthorReply;
  public boolean isAuthorSticky;
  public boolean isBanner;
  public boolean isDelete;
  public boolean isFollowing;
  public int isStar;
  public String ksHomePage;
  public int level;
  public int like;
  public int likeCnt;
  public int maxLine = 9;
  public orr medalInfo;
  public List<pdo> mediaDataList;
  public int myself;
  public String nickName;
  public String passthrough;
  public int rank;
  public String rowKey;
  public int secondMaxLine = 6;
  public String styleData;
  public String uin;
  public String userTitle;
  
  public int getCommentLevel()
  {
    if ((this instanceof CommentData)) {
      return 1;
    }
    if ((this instanceof SubCommentData)) {
      return 2;
    }
    return 0;
  }
  
  public int getCommentMediaType()
  {
    if ((this.mediaDataList != null) && (this.mediaDataList.size() > 0))
    {
      pdo localpdo = (pdo)this.mediaDataList.get(0);
      if (localpdo != null) {
        return localpdo.e;
      }
    }
    return 0;
  }
  
  public boolean hasLinkData()
  {
    return (this.commentLinkDataList != null) && (this.commentLinkDataList.size() > 0);
  }
  
  public boolean isActivity()
  {
    return this.isActivity == 1;
  }
  
  public boolean isAnonymous()
  {
    return this.anonymous == 1;
  }
  
  public boolean isApproved()
  {
    return this.isApproved == 1;
  }
  
  public boolean isAuthorReply()
  {
    return this.isAuthorReply == 1;
  }
  
  public boolean isAuthorSelection()
  {
    return this.authorSelection == 1;
  }
  
  public boolean isAwesome()
  {
    return this.awesome == 1;
  }
  
  public boolean isBanner()
  {
    return this.isBanner;
  }
  
  public boolean isDisliked()
  {
    return this.disLike == 1;
  }
  
  public boolean isDynamicComment()
  {
    return (!TextUtils.isEmpty(this.styleData)) && (this.styleData.contains("style_ID"));
  }
  
  public boolean isFamilyTopEntry()
  {
    if ((!TextUtils.isEmpty(this.styleData)) && (this.styleData.contains("ReadInJoy_comment_family_top_cell"))) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("BaseCommentData", 2, "isFamilyTopEntry " + bool);
      return bool;
    }
  }
  
  public boolean isFolderCard()
  {
    if ((!TextUtils.isEmpty(this.styleData)) && (this.styleData.contains("ReadInJoy_comment_bottom_fold_cell"))) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("BaseCommentData", 2, "isFolderCard " + bool);
      return bool;
    }
  }
  
  public boolean isLiked()
  {
    return this.like == 1;
  }
  
  public boolean isMyself()
  {
    return this.myself == 1;
  }
  
  public boolean isRank()
  {
    return this.rank != 0;
  }
  
  public boolean isStar()
  {
    return this.isStar == 1;
  }
  
  public String toString()
  {
    return "BaseCommentData{level=" + this.level + ", commentId='" + this.commentId + '\'' + ", commentContent='" + this.commentContent + '\'' + ", commentTime=" + this.commentTime + ", uin='" + this.uin + '\'' + ", nickName='" + this.nickName + '\'' + ", avatar='" + this.avatar + '\'' + ", homepage='" + this.homepage + '\'' + ", myself=" + this.myself + ", like=" + this.like + ", disLike=" + this.disLike + ", likeCnt=" + this.likeCnt + ", anonymous=" + this.anonymous + ", authorSelection=" + this.authorSelection + ", authorComment='" + this.authorComment + '\'' + ", rank=" + this.rank + ", awesome=" + this.awesome + ", rowKey='" + this.rowKey + '\'' + ", contentSrc=" + this.contentSrc + ", passthrough='" + this.passthrough + '\'' + ", isAnchor=" + this.isAnchor + ", isDelete=" + this.isDelete + ", maxLine=" + this.maxLine + ", secondMaxLine=" + this.secondMaxLine + ", isStar=" + this.isStar + ", isApproved=" + this.isApproved + ", flowGuidePtsData='" + this.flowGuidePtsData + '\'' + ", createSrc=" + this.createSrc + ", isActivity=" + this.isActivity + ", activityPicUrl='" + this.activityPicUrl + '\'' + ", activityJumpUrl='" + this.activityJumpUrl + '\'' + ", activityCfgID=" + this.activityCfgID + ", isBanner=" + this.isBanner + ", medalInfo=" + this.medalInfo + ", mediaDataList=" + this.mediaDataList + ", isAuthorReply=" + this.isAuthorReply + ", userTitle='" + this.userTitle + '\'' + ", isAuthorLike=" + this.isAuthorLike + ", isFollowing=" + this.isFollowing + ", isAuthorSticky=" + this.isAuthorSticky + ", avatarPendantUrl='" + this.avatarPendantUrl + '\'' + ", ksHomePage='" + this.ksHomePage + '\'' + ", styleData='" + this.styleData + '\'' + ", accountLevelInfo=" + this.accountLevelInfo + ", isAd=" + this.isAd + ", advertisementInfo=" + this.advertisementInfo + ", commentLinkDataList=" + this.commentLinkDataList + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData
 * JD-Core Version:    0.7.0.1
 */