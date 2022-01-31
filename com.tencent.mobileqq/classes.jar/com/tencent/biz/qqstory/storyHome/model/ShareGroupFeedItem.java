package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.SerializationPB.ShareGroupFeed;
import com.tencent.biz.qqstory.base.SerializationPB.VideoListFeed;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Iterator;
import java.util.List;
import uwa;
import wfw;
import wqm;
import xqq;

public class ShareGroupFeedItem
  extends VideoListFeedItem<wqm, ShareGroupItem>
{
  public String des = "";
  private ShareGroupItem mOwner = new ShareGroupItem();
  public int todayJoinMemberCount = -1;
  public int videoCount;
  
  private String a(qqstory_struct.ShareGroupFeed paramShareGroupFeed)
  {
    if ((!paramShareGroupFeed.today_new_member.has()) || (paramShareGroupFeed.today_new_member.get() == null)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    this.todayJoinMemberCount = paramShareGroupFeed.today_new_member.get().size();
    paramShareGroupFeed = paramShareGroupFeed.today_new_member.get().iterator();
    while (paramShareGroupFeed.hasNext())
    {
      qqstory_struct.UserInfo localUserInfo = (qqstory_struct.UserInfo)paramShareGroupFeed.next();
      QQUserUIItem localQQUserUIItem = new QQUserUIItem();
      localQQUserUIItem.convertFrom(localUserInfo);
      localStringBuilder.append(localQQUserUIItem.getName());
      localStringBuilder.append("、");
    }
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  public static ShareGroupFeedItem createFakeFeedItem(String paramString1, String paramString2)
  {
    ShareGroupFeedItem localShareGroupFeedItem = new ShareGroupFeedItem();
    localShareGroupFeedItem.feedId = makeFakeFeedId(paramString1, paramString2);
    localShareGroupFeedItem.setDate(paramString2);
    localShareGroupFeedItem.mOwner = ((wfw)uwa.a(7)).b(paramString1);
    localShareGroupFeedItem.ownerId = paramString1;
    localShareGroupFeedItem.mViewTotalTime = 0L;
    localShareGroupFeedItem.mHadLike = 0;
    localShareGroupFeedItem.mDenyComment = 0;
    localShareGroupFeedItem.mCommentCount = 0;
    localShareGroupFeedItem.mFriendCommentCount = 0;
    localShareGroupFeedItem.mFanCommentCount = 0;
    localShareGroupFeedItem.mLikeCount = 0;
    localShareGroupFeedItem.mFriendLikeCount = 0;
    localShareGroupFeedItem.mFanLikeCount = 0;
    localShareGroupFeedItem.mIsVideoEnd = true;
    return localShareGroupFeedItem;
  }
  
  protected int assignType()
  {
    return 2;
  }
  
  public void copy(Object paramObject)
  {
    super.copy(paramObject);
    paramObject = (ShareGroupFeedItem)paramObject;
    xqq.a(this.mOwner);
    this.mOwner.copy(paramObject.mOwner);
    if (paramObject.des != null) {
      this.des = paramObject.des;
    }
    if (paramObject.videoCount != -1) {
      this.videoCount = paramObject.videoCount;
    }
    if (paramObject.todayJoinMemberCount != -1) {
      this.todayJoinMemberCount = paramObject.todayJoinMemberCount;
    }
  }
  
  public boolean covertFrom(String paramString, qqstory_struct.StoryFeed paramStoryFeed)
  {
    this.feedId = paramString;
    paramString = (qqstory_struct.ShareGroupFeed)paramStoryFeed.share_group_feed.get();
    setDate(String.valueOf(paramString.date.get()));
    this.mVideoSeq = paramString.seq.get();
    if (paramString.is_end.get() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsVideoEnd = bool;
      this.mVideoNextCookie = paramString.next_cookie.get().toStringUtf8();
      this.mVideoPullType = paramString.pull_type.get();
      this.videoCount = paramString.video_total.get();
      this.des = a(paramString);
      this.mOwner = new ShareGroupItem();
      this.mOwner.convertFrom(paramString.info);
      this.ownerId = this.mOwner.shareGroupId;
      this.mOwner = ((wfw)uwa.a(7)).a(this.mOwner);
      return true;
    }
  }
  
  public byte[] covertToByte()
  {
    SerializationPB.ShareGroupFeed localShareGroupFeed = new SerializationPB.ShareGroupFeed();
    localShareGroupFeed.video_list_feed.set(super.writeVideoListFeedLocalPB());
    localShareGroupFeed.video_count.set(this.videoCount);
    PBStringField localPBStringField = localShareGroupFeed.des;
    if (TextUtils.isEmpty(this.des)) {}
    for (String str = "";; str = this.des)
    {
      localPBStringField.set(str);
      localShareGroupFeed.today_join_member_count.set(this.todayJoinMemberCount);
      xqq.a(this.des);
      return localShareGroupFeed.toByteArray();
    }
  }
  
  @NonNull
  public wqm generateHomeFeed()
  {
    return new wqm(this);
  }
  
  public int getCommentLikeType()
  {
    return 0;
  }
  
  @NonNull
  public ShareGroupItem getOwner()
  {
    if (this.mOwner == null) {
      this.mOwner = new ShareGroupItem();
    }
    return this.mOwner;
  }
  
  public boolean isMyFeedItem()
  {
    return false;
  }
  
  protected void onCovertFromEntry()
  {
    super.onCovertFromEntry();
    xqq.a(this.ownerId);
    if (!TextUtils.isEmpty(this.ownerId)) {
      this.mOwner = ((wfw)uwa.a(7)).b(this.ownerId);
    }
  }
  
  public void readFromLocalByte(byte[] paramArrayOfByte)
  {
    SerializationPB.ShareGroupFeed localShareGroupFeed = new SerializationPB.ShareGroupFeed();
    localShareGroupFeed.mergeFrom(paramArrayOfByte);
    super.readVideoListFeedLocalPB(localShareGroupFeed.video_list_feed);
    this.videoCount = localShareGroupFeed.video_count.get();
    this.des = localShareGroupFeed.des.get();
    this.todayJoinMemberCount = localShareGroupFeed.today_join_member_count.get();
  }
  
  public void reset()
  {
    super.reset();
    this.des = "";
    this.videoCount = 0;
  }
  
  public String toString()
  {
    return "ShareGroupFeedItem{mOwner=" + this.mOwner + ", des='" + this.des + '\'' + ", videoCount=" + this.videoCount + '}' + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem
 * JD-Core Version:    0.7.0.1
 */