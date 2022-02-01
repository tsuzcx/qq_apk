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
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GeneralFeedItem
  extends VideoListFeedItem<GeneralHomeFeed, QQUserUIItem>
{
  public QQUserUIItem mUserUIItem = new QQUserUIItem();
  public String wsSchemaForMain = "default";
  public String wsSchemaForMemories = "default";
  
  public static GeneralFeedItem createFakeFeedItem(String paramString)
  {
    GeneralFeedItem localGeneralFeedItem = new GeneralFeedItem();
    localGeneralFeedItem.feedId = makeFakeFeedId(QQStoryContext.a().i(), paramString);
    localGeneralFeedItem.setDate(paramString);
    localGeneralFeedItem.mUserUIItem = ((UserManager)SuperManager.a(2)).c();
    if (localGeneralFeedItem.mUserUIItem == null)
    {
      localGeneralFeedItem.mUserUIItem = new QQUserUIItem();
      localGeneralFeedItem.mUserUIItem.uid = QQStoryContext.a().i();
      localGeneralFeedItem.mUserUIItem.qq = PlayModeUtils.b().getCurrentAccountUin();
      localGeneralFeedItem.mUserUIItem.nickName = PlayModeUtils.b().getCurrentNickname();
      paramString = localGeneralFeedItem.mUserUIItem;
      paramString.headUrl = "";
      SLog.e("VideoListFeedItem", "create fake feed item while QQUserUIItem is null! use fake QQUserUIItem to instead.", new Object[] { paramString.toString() });
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
    QQUserUIItem localQQUserUIItem = paramObject.mUserUIItem;
    if (localQQUserUIItem != null)
    {
      this.mUserUIItem = localQQUserUIItem;
      AssertUtils.checkNotNull(this.mUserUIItem);
    }
    this.wsSchemaForMain = paramObject.wsSchemaForMain;
    this.wsSchemaForMemories = paramObject.wsSchemaForMemories;
  }
  
  public boolean covertFrom(String paramString, qqstory_struct.GeneralFeed paramGeneralFeed)
  {
    this.feedId = paramString;
    super.setDate(String.valueOf(paramGeneralFeed.date.get()));
    this.mVideoSeq = paramGeneralFeed.seq.get();
    boolean bool;
    if (paramGeneralFeed.is_end.get() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.mIsVideoEnd = bool;
    if (paramGeneralFeed.share_to_discover.get() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.mIsContribute = bool;
    this.mVideoNextCookie = paramGeneralFeed.next_cookie.get().toStringUtf8();
    this.mVideoPullType = paramGeneralFeed.pull_type.get();
    if (paramGeneralFeed.hasVideoTag.get() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.mHasTag = bool;
    if (paramGeneralFeed.has_public_video.get() == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.mHasPublicVideo = bool;
    paramString = new QQUserUIItem();
    paramString.convertFrom(paramGeneralFeed.user);
    this.mUserUIItem = ((UserManager)SuperManager.a(2)).a(paramString);
    AssertUtils.checkNotNull(this.mUserUIItem);
    this.ownerId = this.mUserUIItem.getUnionId();
    if (paramGeneralFeed.qim_sync_wording.has()) {
      this.mQimSyncWording = paramGeneralFeed.qim_sync_wording.get().toStringUtf8();
    }
    if (paramGeneralFeed.ws_schemas.size() == 2)
    {
      this.wsSchemaForMain = ((ByteStringMicro)paramGeneralFeed.ws_schemas.get(0)).toStringUtf8();
      this.wsSchemaForMemories = ((ByteStringMicro)paramGeneralFeed.ws_schemas.get(1)).toStringUtf8();
    }
    return true;
  }
  
  public byte[] covertToByte()
  {
    SerializationPB.VideoListFeed localVideoListFeed = super.writeVideoListFeedLocalPB();
    localVideoListFeed.ws_schema_main.set(ByteStringMicro.copyFromUtf8(this.wsSchemaForMain));
    localVideoListFeed.ws_schema_memories.set(ByteStringMicro.copyFromUtf8(this.wsSchemaForMemories));
    return localVideoListFeed.toByteArray();
  }
  
  @NonNull
  public GeneralHomeFeed generateHomeFeed()
  {
    return new GeneralHomeFeed(this);
  }
  
  public int getCommentLikeType()
  {
    return CommentLikeFeedItem.getCommentLikeType(this.mUserUIItem);
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
    return QQStoryContext.a().b(this.mUserUIItem.getUnionId());
  }
  
  protected void onCovertFromEntry()
  {
    super.onCovertFromEntry();
    this.mUserUIItem = ((UserManager)SuperManager.a(2)).b(this.ownerId);
    if (this.mUserUIItem == null)
    {
      this.mUserUIItem = new QQUserUIItem();
      this.mUserUIItem.uid = QQStoryContext.a().i();
      this.mUserUIItem.qq = PlayModeUtils.b().getCurrentAccountUin();
      this.mUserUIItem.nickName = PlayModeUtils.b().getCurrentNickname();
      QQUserUIItem localQQUserUIItem = this.mUserUIItem;
      localQQUserUIItem.headUrl = "";
      SLog.e("VideoListFeedItem", "create fake feed item while QQUserUIItem is null! use fake QQUserUIItem to instead.", new Object[] { localQQUserUIItem.toString() });
    }
  }
  
  public void readFromLocalByte(byte[] paramArrayOfByte)
  {
    SerializationPB.VideoListFeed localVideoListFeed = new SerializationPB.VideoListFeed();
    localVideoListFeed.mergeFrom(paramArrayOfByte);
    this.wsSchemaForMain = localVideoListFeed.ws_schema_main.get().toStringUtf8();
    this.wsSchemaForMemories = localVideoListFeed.ws_schema_memories.get().toStringUtf8();
    super.readVideoListFeedLocalPB(localVideoListFeed);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GeneralFeedItem{}");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem
 * JD-Core Version:    0.7.0.1
 */