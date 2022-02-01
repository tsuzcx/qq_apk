package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.SerializationPB.BannerFeed;
import com.tencent.biz.qqstory.base.SerializationPB.CommentLikeFeed;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.BannerFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.BannerShareInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class BannerFeedItem
  extends CommentLikeFeedItem<BannerHomeFeed, QQUserUIItem>
{
  public String blurb;
  public String content;
  public int coverHeight = -1;
  public String coverUrl;
  public int coverWidth = -1;
  private QQUserUIItem mOwner = new QQUserUIItem();
  public long recommendId = -1L;
  public String recommendTitle = "";
  public String schema;
  public BannerFeedItem.ShareInfo shareInfo = new BannerFeedItem.ShareInfo();
  
  protected int assignType()
  {
    return 5;
  }
  
  public void copy(Object paramObject)
  {
    super.copy(paramObject);
    paramObject = (BannerFeedItem)paramObject;
    String str = paramObject.content;
    if (str != null) {
      this.content = str;
    }
    str = paramObject.coverUrl;
    if (str != null) {
      this.coverUrl = str;
    }
    str = paramObject.schema;
    if (str != null) {
      this.schema = str;
    }
    str = paramObject.blurb;
    if (str != null) {
      this.blurb = str;
    }
    int i = paramObject.coverHeight;
    if (i != -1) {
      this.coverHeight = i;
    }
    i = paramObject.coverWidth;
    if (i != -1) {
      this.coverWidth = i;
    }
    long l = paramObject.recommendId;
    if (l != -1L) {
      this.recommendId = l;
    }
    if (!TextUtils.isEmpty(paramObject.recommendTitle)) {
      this.recommendTitle = paramObject.recommendTitle;
    }
    this.mOwner.copy(paramObject.mOwner);
    this.shareInfo.a(paramObject.shareInfo);
  }
  
  public void covertFrom(String paramString, qqstory_struct.BannerFeed paramBannerFeed)
  {
    this.feedId = paramString;
    paramString = new QQUserUIItem();
    paramString.convertFrom((qqstory_struct.UserInfo)paramBannerFeed.user.get());
    this.mOwner = ((UserManager)SuperManager.a(2)).a(paramString);
    AssertUtils.checkNotNull(this.mOwner);
    this.ownerId = this.mOwner.getUnionId();
    this.date = String.valueOf(paramBannerFeed.date.get());
    super.setDate(this.date);
    this.blurb = paramBannerFeed.blurb.get().toStringUtf8();
    this.schema = paramBannerFeed.schema.get().toStringUtf8();
    this.content = paramBannerFeed.content.get().toStringUtf8();
    this.coverUrl = paramBannerFeed.cover_url.get().toStringUtf8();
    this.recommendTitle = paramBannerFeed.title_wording.get().toStringUtf8();
    this.coverWidth = paramBannerFeed.width.get();
    this.coverHeight = paramBannerFeed.height.get();
    this.recommendId = paramBannerFeed.recommend_id.get();
    this.shareInfo.a();
    this.shareInfo.a = paramBannerFeed.share_info.title.get().toStringUtf8();
    this.shareInfo.c = paramBannerFeed.share_info.icon.get().toStringUtf8();
    this.shareInfo.b = paramBannerFeed.share_info.content.get().toStringUtf8();
    this.shareInfo.d = paramBannerFeed.share_info.jump_url.get().toStringUtf8();
  }
  
  public byte[] covertToByte()
  {
    SerializationPB.BannerFeed localBannerFeed = new SerializationPB.BannerFeed();
    localBannerFeed.commet_like_feed.set(super.writeCommentLikeFeedlocalPB());
    PBStringField localPBStringField = localBannerFeed.share_info_title;
    boolean bool = TextUtils.isEmpty(this.shareInfo.a);
    String str2 = "";
    String str1;
    if (bool) {
      str1 = "";
    } else {
      str1 = this.shareInfo.a;
    }
    localPBStringField.set(str1);
    localPBStringField = localBannerFeed.share_info_icon;
    if (TextUtils.isEmpty(this.shareInfo.c)) {
      str1 = "";
    } else {
      str1 = this.shareInfo.c;
    }
    localPBStringField.set(str1);
    localPBStringField = localBannerFeed.share_info_content;
    if (TextUtils.isEmpty(this.shareInfo.b)) {
      str1 = "";
    } else {
      str1 = this.shareInfo.b;
    }
    localPBStringField.set(str1);
    localPBStringField = localBannerFeed.share_info_jump_url;
    if (TextUtils.isEmpty(this.shareInfo.d)) {
      str1 = "";
    } else {
      str1 = this.shareInfo.d;
    }
    localPBStringField.set(str1);
    localPBStringField = localBannerFeed.blurb;
    if (TextUtils.isEmpty(this.blurb)) {
      str1 = "";
    } else {
      str1 = this.blurb;
    }
    localPBStringField.set(str1);
    localPBStringField = localBannerFeed.schema;
    if (TextUtils.isEmpty(this.schema)) {
      str1 = "";
    } else {
      str1 = this.schema;
    }
    localPBStringField.set(str1);
    localPBStringField = localBannerFeed.content;
    if (TextUtils.isEmpty(this.content)) {
      str1 = "";
    } else {
      str1 = this.content;
    }
    localPBStringField.set(str1);
    localPBStringField = localBannerFeed.cover_url;
    if (TextUtils.isEmpty(this.coverUrl)) {
      str1 = str2;
    } else {
      str1 = this.coverUrl;
    }
    localPBStringField.set(str1);
    localBannerFeed.height.set(this.coverHeight);
    localBannerFeed.width.set(this.coverWidth);
    localBannerFeed.recommend_id.set(this.recommendId);
    if (!TextUtils.isEmpty(this.recommendTitle)) {
      localBannerFeed.title_wording.set(ByteStringMicro.copyFromUtf8(this.recommendTitle));
    }
    return localBannerFeed.toByteArray();
  }
  
  @NonNull
  public BannerHomeFeed generateHomeFeed()
  {
    return new BannerHomeFeed(this);
  }
  
  public int getCommentLikeType()
  {
    return 0;
  }
  
  @NonNull
  public QQUserUIItem getOwner()
  {
    if (this.mOwner == null) {
      this.mOwner = new QQUserUIItem();
    }
    return this.mOwner;
  }
  
  protected void onCovertFromEntry()
  {
    super.onCovertFromEntry();
    this.mOwner = ((UserManager)SuperManager.a(2)).a(this.ownerId);
  }
  
  public void readFromLocalByte(byte[] paramArrayOfByte)
  {
    SerializationPB.BannerFeed localBannerFeed = new SerializationPB.BannerFeed();
    localBannerFeed.mergeFrom(paramArrayOfByte);
    super.readCommentLikeFeedLocalPB(localBannerFeed.commet_like_feed);
    this.shareInfo.a = localBannerFeed.share_info_title.get();
    this.shareInfo.c = localBannerFeed.share_info_icon.get();
    this.shareInfo.b = localBannerFeed.share_info_content.get();
    this.shareInfo.d = localBannerFeed.share_info_jump_url.get();
    this.blurb = localBannerFeed.blurb.get();
    this.schema = localBannerFeed.schema.get();
    this.content = localBannerFeed.content.get();
    this.coverWidth = localBannerFeed.width.get();
    this.coverHeight = localBannerFeed.height.get();
    this.coverUrl = localBannerFeed.cover_url.get();
    this.recommendId = localBannerFeed.recommend_id.get();
    this.recommendTitle = localBannerFeed.title_wording.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.BannerFeedItem
 * JD-Core Version:    0.7.0.1
 */