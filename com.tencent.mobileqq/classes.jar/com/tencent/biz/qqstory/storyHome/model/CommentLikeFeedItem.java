package com.tencent.biz.qqstory.storyHome.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.SerializationPB.CommentLikeFeed;
import com.tencent.biz.qqstory.model.item.FeedFeatureItem;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public abstract class CommentLikeFeedItem<T extends StoryHomeFeed, E extends IFeedOwner>
  extends FeedItem<T, E>
{
  public static final int COMMENT_LIKE_TYPE_FANS = 1;
  public static final int COMMENT_LIKE_TYPE_FRIEND = 0;
  public int mCommentCount = -1;
  public int mCommentIsEnd = -1;
  public String mCommentLastCookie = "";
  public int mDenyComment = -1;
  public int mFanCommentCount = -1;
  public int mFanLikeCount = -1;
  public int mFriendCommentCount = -1;
  public int mFriendLikeCount = -1;
  public int mHadLike = -1;
  public int mLikeCount = -1;
  public long mViewTotalTime = -1L;
  
  public static int getCommentLikeType(QQUserUIItem paramQQUserUIItem)
  {
    if (paramQQUserUIItem == null) {
      return 1;
    }
    boolean bool1 = paramQQUserUIItem.isVipButNoFriend();
    boolean bool2 = paramQQUserUIItem.isSubscribeButNoFriend();
    if (paramQQUserUIItem.isMe()) {
      return 0;
    }
    if (!bool1)
    {
      if (bool2) {
        return 1;
      }
      return 0;
    }
    return 1;
  }
  
  public void convertFromFeedFeature(FeedFeatureItem paramFeedFeatureItem)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void copy(Object paramObject)
  {
    super.copy(paramObject);
    paramObject = (CommentLikeFeedItem)paramObject;
    int i = paramObject.mCommentCount;
    if (i != -1) {
      this.mCommentCount = i;
    }
    i = paramObject.mFriendCommentCount;
    if (i != -1) {
      this.mFriendCommentCount = i;
    }
    i = paramObject.mFanCommentCount;
    if (i != -1) {
      this.mFanCommentCount = i;
    }
    i = paramObject.mCommentIsEnd;
    if (i != -1) {
      this.mCommentIsEnd = i;
    }
    i = paramObject.mDenyComment;
    if (i != -1) {
      this.mDenyComment = i;
    }
    i = paramObject.mLikeCount;
    if (i != -1) {
      this.mLikeCount = i;
    }
    i = paramObject.mFriendLikeCount;
    if (i != -1) {
      this.mFriendLikeCount = i;
    }
    i = paramObject.mFanLikeCount;
    if (i != -1) {
      this.mFanLikeCount = i;
    }
    i = paramObject.mHadLike;
    if (i != -1) {
      this.mHadLike = i;
    }
    long l = paramObject.mViewTotalTime;
    if (l != -1L) {
      this.mViewTotalTime = l;
    }
  }
  
  public abstract int getCommentLikeType();
  
  public boolean isFakeFeedItem()
  {
    return false;
  }
  
  protected void readCommentLikeFeedLocalPB(SerializationPB.CommentLikeFeed paramCommentLikeFeed)
  {
    this.mCommentCount = paramCommentLikeFeed.comment_count.get();
    this.mFriendCommentCount = paramCommentLikeFeed.freind_commnet_count.get();
    this.mFanCommentCount = paramCommentLikeFeed.fan_comment_count.get();
    this.mCommentIsEnd = paramCommentLikeFeed.comment_is_end.get();
    this.mDenyComment = paramCommentLikeFeed.deny_comment.get();
    this.mCommentLastCookie = paramCommentLikeFeed.comment_last_cookie.get();
    this.mLikeCount = paramCommentLikeFeed.like_count.get();
    this.mFriendLikeCount = paramCommentLikeFeed.friend_like_count.get();
    this.mFanLikeCount = paramCommentLikeFeed.fan_like_count.get();
    this.mHadLike = paramCommentLikeFeed.had_like.get();
    this.mViewTotalTime = paramCommentLikeFeed.view_total_time.get();
  }
  
  public void reset()
  {
    this.mLikeCount = 0;
    this.mHadLike = 0;
    this.mLikeCount = 0;
    this.mCommentCount = -1;
    this.mCommentIsEnd = 0;
    this.mCommentLastCookie = "";
    this.mLikeCount = -1;
    this.mHadLike = -1;
    this.mViewTotalTime = -1L;
    this.mLikeCount = 0;
  }
  
  protected SerializationPB.CommentLikeFeed writeCommentLikeFeedlocalPB()
  {
    SerializationPB.CommentLikeFeed localCommentLikeFeed = new SerializationPB.CommentLikeFeed();
    localCommentLikeFeed.comment_count.set(this.mCommentCount);
    localCommentLikeFeed.freind_commnet_count.set(this.mFriendCommentCount);
    localCommentLikeFeed.fan_comment_count.set(this.mFanCommentCount);
    localCommentLikeFeed.comment_is_end.set(this.mCommentIsEnd);
    localCommentLikeFeed.deny_comment.set(this.mDenyComment);
    PBStringField localPBStringField = localCommentLikeFeed.comment_last_cookie;
    String str;
    if (TextUtils.isEmpty(this.mCommentLastCookie)) {
      str = "";
    } else {
      str = this.mCommentLastCookie;
    }
    localPBStringField.set(str);
    localCommentLikeFeed.like_count.set(this.mLikeCount);
    localCommentLikeFeed.friend_like_count.set(this.mFriendLikeCount);
    localCommentLikeFeed.fan_like_count.set(this.mFanLikeCount);
    localCommentLikeFeed.had_like.set(this.mHadLike);
    localCommentLikeFeed.view_total_time.set(this.mViewTotalTime);
    return localCommentLikeFeed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem
 * JD-Core Version:    0.7.0.1
 */