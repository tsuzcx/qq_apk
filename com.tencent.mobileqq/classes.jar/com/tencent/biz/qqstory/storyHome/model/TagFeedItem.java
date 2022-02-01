package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.SerializationPB.TagFeed;
import com.tencent.biz.qqstory.base.SerializationPB.VideoListFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class TagFeedItem
  extends VideoListFeedItem<TagHomeFeed, TagUserItem>
{
  public String blurb;
  public String content;
  public TagUserItem mOwner = new TagUserItem();
  public long recommendId;
  public String recommendTitle = "";
  public String schema;
  public TagItem tagItem;
  public int videoCount;
  
  protected int assignType()
  {
    return 6;
  }
  
  public void copy(Object paramObject)
  {
    super.copy(paramObject);
    paramObject = (TagFeedItem)paramObject;
    this.tagItem = paramObject.tagItem;
    this.videoCount = paramObject.videoCount;
    this.schema = paramObject.schema;
    this.content = paramObject.content;
    this.blurb = paramObject.blurb;
    this.recommendId = paramObject.recommendId;
    this.recommendTitle = paramObject.recommendTitle;
    this.mOwner = paramObject.mOwner;
  }
  
  public void covertFrom(String paramString, qqstory_struct.TagFeed paramTagFeed)
  {
    this.feedId = paramString;
    this.date = String.valueOf(paramTagFeed.date.get());
    super.setDate(this.date);
    this.mVideoSeq = paramTagFeed.seq.get();
    int i = paramTagFeed.is_end.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.mIsVideoEnd = bool;
    this.mVideoNextCookie = paramTagFeed.next_cookie.get().toStringUtf8();
    this.tagItem = new TagItem((qqstory_struct.TagItem)paramTagFeed.tag_item.get());
    this.videoCount = paramTagFeed.video_total.get();
    this.schema = paramTagFeed.schema.get().toStringUtf8();
    this.content = paramTagFeed.content.get().toStringUtf8();
    this.blurb = paramTagFeed.blur.get().toStringUtf8();
    this.recommendId = paramTagFeed.recommend_id.get();
    this.recommendTitle = paramTagFeed.title_wording.get().toStringUtf8();
    this.mOwner = new TagUserItem();
    this.mOwner.convertFrom((qqstory_struct.TagItem)paramTagFeed.tag_item.get());
    this.ownerId = this.mOwner.getUnionId();
  }
  
  public byte[] covertToByte()
  {
    SerializationPB.TagFeed localTagFeed = new SerializationPB.TagFeed();
    localTagFeed.video_list_feed.set(super.writeVideoListFeedLocalPB());
    localTagFeed.video_count.set(this.videoCount);
    localTagFeed.tag_id.set(this.tagItem.a.a);
    localTagFeed.tag_type.set(this.tagItem.a.d);
    localTagFeed.tag_name.set(this.tagItem.a.b);
    localTagFeed.tag_desc.set(this.tagItem.a.c);
    localTagFeed.join_count.set(this.tagItem.b);
    localTagFeed.wording.set(this.tagItem.c);
    localTagFeed.schema.set(this.schema);
    localTagFeed.content.set(this.content);
    localTagFeed.blur.set(this.blurb);
    localTagFeed.recommend_id.set(this.recommendId);
    if (!TextUtils.isEmpty(this.recommendTitle)) {
      localTagFeed.title_wording.set(ByteStringMicro.copyFromUtf8(this.recommendTitle));
    }
    return localTagFeed.toByteArray();
  }
  
  @NonNull
  public TagHomeFeed generateHomeFeed()
  {
    return new TagHomeFeed(this);
  }
  
  public int getCommentLikeType()
  {
    return 0;
  }
  
  @NonNull
  public TagUserItem getOwner()
  {
    if (this.mOwner == null) {
      this.mOwner = new TagUserItem();
    }
    return this.mOwner;
  }
  
  public boolean isMyFeedItem()
  {
    return false;
  }
  
  public void readFromLocalByte(byte[] paramArrayOfByte)
  {
    SerializationPB.TagFeed localTagFeed = new SerializationPB.TagFeed();
    localTagFeed.mergeFrom(paramArrayOfByte);
    super.readVideoListFeedLocalPB(localTagFeed.video_list_feed);
    this.videoCount = localTagFeed.video_count.get();
    long l = localTagFeed.tag_id.get();
    int i = localTagFeed.tag_type.get();
    paramArrayOfByte = localTagFeed.tag_name.get();
    String str1 = localTagFeed.tag_desc.get();
    int j = localTagFeed.join_count.get();
    String str2 = localTagFeed.wording.get();
    this.tagItem = new TagItem(new TagItem.TagInfoBase(l, paramArrayOfByte, str1, i), j, str2);
    this.schema = localTagFeed.schema.get();
    this.content = localTagFeed.content.get();
    this.blurb = localTagFeed.blur.get();
    this.recommendId = localTagFeed.recommend_id.get();
    this.recommendTitle = localTagFeed.title_wording.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.TagFeedItem
 * JD-Core Version:    0.7.0.1
 */