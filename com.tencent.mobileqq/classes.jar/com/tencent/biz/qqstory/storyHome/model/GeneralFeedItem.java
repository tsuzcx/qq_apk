package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.SerializationPB.VideoListFeed;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GeneralFeed;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GeneralFeedItem
  extends VideoListFeedItem
{
  public QQUserUIItem mUserUIItem = new QQUserUIItem();
  
  public static GeneralFeedItem createFakeFeedItem(String paramString)
  {
    GeneralFeedItem localGeneralFeedItem = new GeneralFeedItem();
    localGeneralFeedItem.feedId = makeFakeFeedId(QQStoryContext.a().b(), paramString);
    localGeneralFeedItem.setDate(paramString);
    localGeneralFeedItem.mUserUIItem = ((UserManager)SuperManager.a(2)).a();
    if (localGeneralFeedItem.mUserUIItem == null)
    {
      localGeneralFeedItem.mUserUIItem = new QQUserUIItem();
      localGeneralFeedItem.mUserUIItem.uid = QQStoryContext.a().b();
      localGeneralFeedItem.mUserUIItem.qq = PlayModeUtils.a().getCurrentAccountUin();
      localGeneralFeedItem.mUserUIItem.nickName = PlayModeUtils.a().getCurrentNickname();
      localGeneralFeedItem.mUserUIItem.headUrl = "";
      SLog.e("VideoListFeedItem", "create fake feed item while QQUserUIItem is null! use fake QQUserUIItem to instead.", new Object[] { localGeneralFeedItem.mUserUIItem.toString() });
    }
    localGeneralFeedItem.ownerId = localGeneralFeedItem.mUserUIItem.getUnionId();
    localGeneralFeedItem.mViewTotalTime = 0L;
    localGeneralFeedItem.mHadLike = 0;
    localGeneralFeedItem.mDenyComment = 0;
    localGeneralFeedItem.mCommentCount = 0;
    localGeneralFeedItem.mFriendCommentCount = 0;
    localGeneralFeedItem.mFanCommentCount = 0;
    localGeneralFeedItem.mLikeCount = 0;
    localGeneralFeedItem.mFriendLikeCount = 0;
    localGeneralFeedItem.mFanLikeCount = 0;
    localGeneralFeedItem.mIsVideoEnd = true;
    return localGeneralFeedItem;
  }
  
  protected int assignType()
  {
    return 1;
  }
  
  public void copy(Object paramObject)
  {
    super.copy(paramObject);
    paramObject = (GeneralFeedItem)paramObject;
    if (paramObject.mUserUIItem != null)
    {
      this.mUserUIItem = paramObject.mUserUIItem;
      AssertUtils.a(this.mUserUIItem);
    }
  }
  
  public boolean covertFrom(String paramString, qqstory_struct.GeneralFeed paramGeneralFeed)
  {
    boolean bool2 = false;
    this.feedId = paramString;
    super.setDate(String.valueOf(paramGeneralFeed.date.get()));
    this.mVideoSeq = paramGeneralFeed.seq.get();
    if (paramGeneralFeed.is_end.get() == 1)
    {
      bool1 = true;
      this.mIsVideoEnd = bool1;
      if (paramGeneralFeed.share_to_discover.get() != 1) {
        break label214;
      }
      bool1 = true;
      label64:
      this.mIsContribute = bool1;
      this.mVideoNextCookie = paramGeneralFeed.next_cookie.get().toStringUtf8();
      this.mVideoPullType = paramGeneralFeed.pull_type.get();
      if (paramGeneralFeed.hasVideoTag.get() != 1) {
        break label219;
      }
    }
    label214:
    label219:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.mHasTag = bool1;
      bool1 = bool2;
      if (paramGeneralFeed.has_public_video.get() == 1) {
        bool1 = true;
      }
      this.mHasPublicVideo = bool1;
      paramString = new QQUserUIItem();
      paramString.convertFrom(paramGeneralFeed.user);
      this.mUserUIItem = ((UserManager)SuperManager.a(2)).a(paramString);
      AssertUtils.a(this.mUserUIItem);
      this.ownerId = this.mUserUIItem.getUnionId();
      if (paramGeneralFeed.qim_sync_wording.has()) {
        this.mQimSyncWording = paramGeneralFeed.qim_sync_wording.get().toStringUtf8();
      }
      return true;
      bool1 = false;
      break;
      bool1 = false;
      break label64;
    }
  }
  
  public byte[] covertToByte()
  {
    return super.writeVideoListFeedLocalPB().toByteArray();
  }
  
  @NonNull
  public GeneralHomeFeed generateHomeFeed()
  {
    return new GeneralHomeFeed(this);
  }
  
  public int getCommentLikeType()
  {
    if (this.mUserUIItem == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return 1;
      bool1 = this.mUserUIItem.isVipButNoFriend();
      bool2 = this.mUserUIItem.isSubscribeButNoFriend();
      if (this.mUserUIItem.isMe()) {
        return 0;
      }
    } while ((bool1) || (bool2));
    return 0;
  }
  
  @NonNull
  public QQUserUIItem getOwner()
  {
    if (this.mUserUIItem == null) {
      this.mUserUIItem = new QQUserUIItem();
    }
    return this.mUserUIItem;
  }
  
  public boolean isMyFeedItem()
  {
    if (this.mUserUIItem == null) {
      return false;
    }
    return QQStoryContext.a().a(this.mUserUIItem.getUnionId());
  }
  
  protected void onCovertFromEntry()
  {
    super.onCovertFromEntry();
    this.mUserUIItem = ((UserManager)SuperManager.a(2)).b(this.ownerId);
    if (this.mUserUIItem == null)
    {
      this.mUserUIItem = new QQUserUIItem();
      this.mUserUIItem.uid = QQStoryContext.a().b();
      this.mUserUIItem.qq = PlayModeUtils.a().getCurrentAccountUin();
      this.mUserUIItem.nickName = PlayModeUtils.a().getCurrentNickname();
      this.mUserUIItem.headUrl = "";
      SLog.e("VideoListFeedItem", "create fake feed item while QQUserUIItem is null! use fake QQUserUIItem to instead.", new Object[] { this.mUserUIItem.toString() });
    }
  }
  
  public void readFromLocalByte(byte[] paramArrayOfByte)
  {
    SerializationPB.VideoListFeed localVideoListFeed = new SerializationPB.VideoListFeed();
    localVideoListFeed.mergeFrom(paramArrayOfByte);
    super.readVideoListFeedLocalPB(localVideoListFeed);
  }
  
  public String toString()
  {
    return "GeneralFeedItem{}" + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem
 * JD-Core Version:    0.7.0.1
 */