package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.SerializationPB.VideoListFeed;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GeneralFeed;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tcz;
import tdl;
import tsr;
import uwf;
import ved;
import vxp;

public class GeneralFeedItem
  extends VideoListFeedItem<uwf, QQUserUIItem>
{
  public QQUserUIItem mUserUIItem = new QQUserUIItem();
  public String wsSchemaForMain = "default";
  public String wsSchemaForMemories = "default";
  
  public static GeneralFeedItem createFakeFeedItem(String paramString)
  {
    GeneralFeedItem localGeneralFeedItem = new GeneralFeedItem();
    localGeneralFeedItem.feedId = makeFakeFeedId(QQStoryContext.a().b(), paramString);
    localGeneralFeedItem.setDate(paramString);
    localGeneralFeedItem.mUserUIItem = ((tdl)tcz.a(2)).a();
    if (localGeneralFeedItem.mUserUIItem == null)
    {
      localGeneralFeedItem.mUserUIItem = new QQUserUIItem();
      localGeneralFeedItem.mUserUIItem.uid = QQStoryContext.a().b();
      localGeneralFeedItem.mUserUIItem.qq = tsr.a().getCurrentAccountUin();
      localGeneralFeedItem.mUserUIItem.nickName = tsr.a().getCurrentNickname();
      localGeneralFeedItem.mUserUIItem.headUrl = "";
      ved.e("VideoListFeedItem", "create fake feed item while QQUserUIItem is null! use fake QQUserUIItem to instead.", new Object[] { localGeneralFeedItem.mUserUIItem.toString() });
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
      vxp.a(this.mUserUIItem);
    }
    this.wsSchemaForMain = paramObject.wsSchemaForMain;
    this.wsSchemaForMemories = paramObject.wsSchemaForMemories;
  }
  
  public boolean covertFrom(String paramString, qqstory_struct.GeneralFeed paramGeneralFeed)
  {
    this.feedId = paramString;
    super.setDate(String.valueOf(paramGeneralFeed.date.get()));
    this.mVideoSeq = paramGeneralFeed.seq.get();
    if (paramGeneralFeed.is_end.get() == 1)
    {
      bool = true;
      this.mIsVideoEnd = bool;
      if (paramGeneralFeed.share_to_discover.get() != 1) {
        break label255;
      }
      bool = true;
      label61:
      this.mIsContribute = bool;
      this.mVideoNextCookie = paramGeneralFeed.next_cookie.get().toStringUtf8();
      this.mVideoPullType = paramGeneralFeed.pull_type.get();
      if (paramGeneralFeed.hasVideoTag.get() != 1) {
        break label260;
      }
      bool = true;
      label104:
      this.mHasTag = bool;
      if (paramGeneralFeed.has_public_video.get() != 1) {
        break label265;
      }
    }
    label260:
    label265:
    for (boolean bool = true;; bool = false)
    {
      this.mHasPublicVideo = bool;
      paramString = new QQUserUIItem();
      paramString.convertFrom(paramGeneralFeed.user);
      this.mUserUIItem = ((tdl)tcz.a(2)).a(paramString);
      vxp.a(this.mUserUIItem);
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
      bool = false;
      break;
      label255:
      bool = false;
      break label61;
      bool = false;
      break label104;
    }
  }
  
  public byte[] covertToByte()
  {
    SerializationPB.VideoListFeed localVideoListFeed = super.writeVideoListFeedLocalPB();
    localVideoListFeed.ws_schema_main.set(ByteStringMicro.copyFromUtf8(this.wsSchemaForMain));
    localVideoListFeed.ws_schema_memories.set(ByteStringMicro.copyFromUtf8(this.wsSchemaForMemories));
    return localVideoListFeed.toByteArray();
  }
  
  @NonNull
  public uwf generateHomeFeed()
  {
    return new uwf(this);
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
    return QQStoryContext.a().a(this.mUserUIItem.getUnionId());
  }
  
  protected void onCovertFromEntry()
  {
    super.onCovertFromEntry();
    this.mUserUIItem = ((tdl)tcz.a(2)).b(this.ownerId);
    if (this.mUserUIItem == null)
    {
      this.mUserUIItem = new QQUserUIItem();
      this.mUserUIItem.uid = QQStoryContext.a().b();
      this.mUserUIItem.qq = tsr.a().getCurrentAccountUin();
      this.mUserUIItem.nickName = tsr.a().getCurrentNickname();
      this.mUserUIItem.headUrl = "";
      ved.e("VideoListFeedItem", "create fake feed item while QQUserUIItem is null! use fake QQUserUIItem to instead.", new Object[] { this.mUserUIItem.toString() });
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
    return "GeneralFeedItem{}" + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem
 * JD-Core Version:    0.7.0.1
 */