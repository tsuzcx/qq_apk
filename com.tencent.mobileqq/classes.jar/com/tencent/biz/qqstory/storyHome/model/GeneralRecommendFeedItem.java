package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.SerializationPB.GeneralRecommendFeed;
import com.tencent.biz.qqstory.base.SerializationPB.VideoListFeed;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GeneralFeed;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class GeneralRecommendFeedItem
  extends VideoListFeedItem<GeneralRecommendHomeFeed, QQUserUIItem>
{
  public String blurb;
  public QQUserUIItem mUserUIItem = new QQUserUIItem();
  public long recommendId = -1L;
  public String recommendTitle = "";
  public String wsSchemaForMain = "default";
  public String wsSchemaForMemories = "default";
  
  protected int assignType()
  {
    return 3;
  }
  
  public void copy(Object paramObject)
  {
    super.copy(paramObject);
    paramObject = (GeneralRecommendFeedItem)paramObject;
    Object localObject = paramObject.mUserUIItem;
    if (localObject != null)
    {
      this.mUserUIItem = ((QQUserUIItem)localObject);
      AssertUtils.checkNotNull(this.mUserUIItem);
    }
    localObject = paramObject.blurb;
    if (localObject != null) {
      this.blurb = ((String)localObject);
    }
    long l = paramObject.recommendId;
    if (l != -1L) {
      this.recommendId = l;
    }
    if (!TextUtils.isEmpty(paramObject.recommendTitle)) {
      this.recommendTitle = paramObject.recommendTitle;
    }
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
    if (paramGeneralFeed.ws_schemas.size() == 2)
    {
      this.wsSchemaForMain = ((ByteStringMicro)paramGeneralFeed.ws_schemas.get(0)).toStringUtf8();
      this.wsSchemaForMemories = ((ByteStringMicro)paramGeneralFeed.ws_schemas.get(1)).toStringUtf8();
    }
    paramString = new QQUserUIItem();
    paramString.convertFrom(paramGeneralFeed.user);
    this.mUserUIItem = ((UserManager)SuperManager.a(2)).a(paramString);
    AssertUtils.checkNotNull(this.mUserUIItem);
    this.ownerId = this.mUserUIItem.getUnionId();
    return true;
  }
  
  public byte[] covertToByte()
  {
    SerializationPB.GeneralRecommendFeed localGeneralRecommendFeed = new SerializationPB.GeneralRecommendFeed();
    SerializationPB.VideoListFeed localVideoListFeed = super.writeVideoListFeedLocalPB();
    localGeneralRecommendFeed.video_list_feed.set(localVideoListFeed);
    PBStringField localPBStringField = localGeneralRecommendFeed.blurb;
    String str;
    if (TextUtils.isEmpty(this.blurb)) {
      str = "";
    } else {
      str = this.blurb;
    }
    localPBStringField.set(str);
    localGeneralRecommendFeed.recommend_id.set(this.recommendId);
    if (!TextUtils.isEmpty(this.recommendTitle)) {
      localGeneralRecommendFeed.title_wording.set(ByteStringMicro.copyFromUtf8(this.recommendTitle));
    }
    if (!TextUtils.isEmpty(this.wsSchemaForMain)) {
      localVideoListFeed.ws_schema_main.set(ByteStringMicro.copyFromUtf8(this.wsSchemaForMain));
    }
    if (!TextUtils.isEmpty(this.wsSchemaForMemories)) {
      localVideoListFeed.ws_schema_memories.set(ByteStringMicro.copyFromUtf8(this.wsSchemaForMemories));
    }
    return localGeneralRecommendFeed.toByteArray();
  }
  
  @NonNull
  public GeneralRecommendHomeFeed generateHomeFeed()
  {
    return new GeneralRecommendHomeFeed(this);
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
    this.mUserUIItem = ((UserManager)SuperManager.a(2)).a(this.ownerId);
  }
  
  public void readFromLocalByte(byte[] paramArrayOfByte)
  {
    SerializationPB.GeneralRecommendFeed localGeneralRecommendFeed = new SerializationPB.GeneralRecommendFeed();
    localGeneralRecommendFeed.mergeFrom(paramArrayOfByte);
    readVideoListFeedLocalPB(localGeneralRecommendFeed.video_list_feed);
    this.blurb = localGeneralRecommendFeed.blurb.get();
    this.recommendId = localGeneralRecommendFeed.recommend_id.get();
    this.recommendTitle = localGeneralRecommendFeed.title_wording.get().toStringUtf8();
    if (localGeneralRecommendFeed.video_list_feed.ws_schema_main.has()) {
      this.wsSchemaForMain = localGeneralRecommendFeed.video_list_feed.ws_schema_main.get().toStringUtf8();
    }
    if (localGeneralRecommendFeed.video_list_feed.ws_schema_memories.has()) {
      this.wsSchemaForMemories = localGeneralRecommendFeed.video_list_feed.ws_schema_memories.get().toStringUtf8();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GeneralRecommendFeedItem{blurb='");
    localStringBuilder.append(this.blurb);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.GeneralRecommendFeedItem
 * JD-Core Version:    0.7.0.1
 */