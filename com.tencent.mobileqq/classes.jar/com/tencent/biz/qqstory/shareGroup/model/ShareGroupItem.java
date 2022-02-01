package com.tencent.biz.qqstory.shareGroup.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.database.ShareGroupEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.model.item.IFeedOwner;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupBasicInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupExtInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.List;

public class ShareGroupItem
  extends BaseUIItem
  implements Copyable, IFeedOwner
{
  public static final int OWNER_TYPE_CREATOR = 1;
  public static final int OWNER_TYPE_PARTICIPATOR = 2;
  public static final int OWNER_TYPE_RECOMMEND = 3;
  public static final int TYPE_SHARE_GROUP = 2;
  public static final int TYPE_USER_GROUP = 1;
  public int allowStrangerVisitAndPost = -1;
  public String backgroundUrl = null;
  public int followCount = -1;
  public long groupUin = -1L;
  public List<String> headerUnionIdList = new ArrayList(0);
  public int isDisband = -1;
  public int isSubscribed = -1;
  public int memberCount = -1;
  public String name = HardCodeUtil.a(2131713793);
  public int ownerType = 1;
  public String ownerUnionId = null;
  public String shareGroupId;
  public int type = 2;
  public int videoCount = -1;
  
  public ShareGroupItem() {}
  
  public ShareGroupItem(ShareGroupEntry paramShareGroupEntry)
  {
    this.id = paramShareGroupEntry.getId();
    this.shareGroupId = paramShareGroupEntry.shareGroupId;
    this.name = paramShareGroupEntry.name;
    this.allowStrangerVisitAndPost = paramShareGroupEntry.allowStrangerVisitAndPost;
    this.memberCount = paramShareGroupEntry.memberCount;
    this.followCount = paramShareGroupEntry.followCount;
    this.videoCount = paramShareGroupEntry.videoCount;
    this.ownerType = paramShareGroupEntry.ownerType;
    this.headerUnionIdList = paramShareGroupEntry.getHeaderUnionIdListBytes();
    this.isSubscribed = paramShareGroupEntry.isSubscribed;
    this.isDisband = paramShareGroupEntry.isDisband;
    this.ownerUnionId = paramShareGroupEntry.ownerUnionId;
    this.type = paramShareGroupEntry.type;
    this.groupUin = paramShareGroupEntry.groupUin;
    this.backgroundUrl = paramShareGroupEntry.backgroundUrl;
    assertItem();
  }
  
  public void assertItem()
  {
    AssertUtils.checkNotEmpty(this.shareGroupId);
    if (this.type == 2) {
      SLog.d("Q.qqstory.shareGroup", "share group Item owner union id is null %s", new Object[] { this });
    }
  }
  
  public void convertFrom(qqstory_struct.ShareGroupBasicInfo paramShareGroupBasicInfo)
  {
    this.shareGroupId = paramShareGroupBasicInfo.shared_group_id.get();
    this.name = paramShareGroupBasicInfo.name.get();
    this.allowStrangerVisitAndPost = paramShareGroupBasicInfo.allow_stranger_visit_and_post.get();
    if (paramShareGroupBasicInfo.type.has()) {
      this.type = paramShareGroupBasicInfo.type.get();
    }
    if (paramShareGroupBasicInfo.owner.has()) {
      this.ownerUnionId = paramShareGroupBasicInfo.owner.get();
    }
    if (paramShareGroupBasicInfo.header_unionid_list.has()) {
      this.headerUnionIdList = paramShareGroupBasicInfo.header_unionid_list.get();
    }
    if (paramShareGroupBasicInfo.background_url.has()) {
      this.backgroundUrl = paramShareGroupBasicInfo.background_url.get();
    }
    if (paramShareGroupBasicInfo.group_code.has()) {
      this.groupUin = paramShareGroupBasicInfo.group_code.get();
    }
    if (paramShareGroupBasicInfo.has_disband.has()) {
      this.isDisband = paramShareGroupBasicInfo.has_disband.get();
    }
    assertItem();
  }
  
  public void convertFrom(qqstory_struct.ShareGroupInfo paramShareGroupInfo)
  {
    convertFrom(paramShareGroupInfo.basic_info);
    if (paramShareGroupInfo.ext_info.has())
    {
      qqstory_struct.ShareGroupExtInfo localShareGroupExtInfo = (qqstory_struct.ShareGroupExtInfo)paramShareGroupInfo.ext_info.get();
      if (localShareGroupExtInfo.total_members.has()) {
        this.memberCount = localShareGroupExtInfo.total_members.get();
      }
      if (localShareGroupExtInfo.total_videos.has()) {
        this.videoCount = localShareGroupExtInfo.total_videos.get();
      }
      if (localShareGroupExtInfo.has_join.has()) {
        this.isSubscribed = localShareGroupExtInfo.has_join.get();
      } else {
        this.isSubscribed = 0;
      }
    }
    if (paramShareGroupInfo.ext_info.owner_type.has()) {
      this.ownerType = paramShareGroupInfo.ext_info.owner_type.get();
    }
  }
  
  public ShareGroupEntry convertTo()
  {
    ShareGroupEntry localShareGroupEntry = new ShareGroupEntry();
    localShareGroupEntry.shareGroupId = this.shareGroupId;
    localShareGroupEntry.name = this.name;
    localShareGroupEntry.allowStrangerVisitAndPost = this.allowStrangerVisitAndPost;
    localShareGroupEntry.memberCount = this.memberCount;
    localShareGroupEntry.followCount = this.followCount;
    localShareGroupEntry.videoCount = this.videoCount;
    localShareGroupEntry.ownerType = this.ownerType;
    localShareGroupEntry.setHeaderUnionIdListBytes(this.headerUnionIdList);
    localShareGroupEntry.isSubscribed = this.isSubscribed;
    localShareGroupEntry.isDisband = this.isDisband;
    localShareGroupEntry.ownerUnionId = this.ownerUnionId;
    localShareGroupEntry.type = this.type;
    localShareGroupEntry.groupUin = this.groupUin;
    localShareGroupEntry.backgroundUrl = this.backgroundUrl;
    return localShareGroupEntry;
  }
  
  public void copy(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    paramObject = (ShareGroupItem)paramObject;
    this.shareGroupId = paramObject.shareGroupId;
    this.name = paramObject.name;
    this.type = paramObject.type;
    long l = paramObject.groupUin;
    if (l != -1L) {
      this.groupUin = l;
    }
    int i = paramObject.allowStrangerVisitAndPost;
    if (i != -1) {
      this.allowStrangerVisitAndPost = i;
    }
    i = paramObject.memberCount;
    if (i != -1) {
      this.memberCount = i;
    }
    i = paramObject.followCount;
    if (i != -1) {
      this.followCount = i;
    }
    i = paramObject.videoCount;
    if (i != -1) {
      this.videoCount = i;
    }
    i = paramObject.ownerType;
    if (i != -1) {
      this.ownerType = i;
    }
    Object localObject = paramObject.headerUnionIdList;
    if (localObject != null) {
      this.headerUnionIdList = ((List)localObject);
    }
    localObject = paramObject.ownerUnionId;
    if (localObject != null) {
      this.ownerUnionId = ((String)localObject);
    }
    i = paramObject.isSubscribed;
    if (i != -1) {
      this.isSubscribed = i;
    }
    i = paramObject.isDisband;
    if (i != -1) {
      this.isDisband = i;
    }
    paramObject = paramObject.backgroundUrl;
    if (paramObject != null) {
      this.backgroundUrl = paramObject;
    }
    assertItem();
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int getRelationType()
  {
    int i = this.type;
    if (i == 1) {
      return 2;
    }
    if (i == 2) {}
    return 1;
  }
  
  public int getReportGroupProp()
  {
    int j = this.type;
    int i = 1;
    if (j == 1) {
      return 3;
    }
    if (isPublic()) {
      i = 2;
    }
    return i;
  }
  
  public String getReportUserType()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getReportUserTypeInt());
    localStringBuilder.append("");
    return localStringBuilder.toString();
  }
  
  public int getReportUserTypeInt()
  {
    if (isOwner()) {
      return 1;
    }
    if (isSubscribe()) {
      return 2;
    }
    return 3;
  }
  
  public String getUnionId()
  {
    return this.shareGroupId;
  }
  
  public boolean isFriend()
  {
    return false;
  }
  
  public boolean isInvalid()
  {
    int i = this.type;
    boolean bool = false;
    if (i == 1) {
      return false;
    }
    if ((this.isDisband == 1) || (this.videoCount == 0) || (this.memberCount == 0)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isMe()
  {
    return false;
  }
  
  public boolean isOwner()
  {
    return QQStoryContext.a().a(this.ownerUnionId);
  }
  
  public boolean isPublic()
  {
    return this.allowStrangerVisitAndPost == 1;
  }
  
  public boolean isSubscribe()
  {
    return this.isSubscribed == 1;
  }
  
  public boolean isSubscribeButNoFriend()
  {
    return false;
  }
  
  public boolean isVip()
  {
    return false;
  }
  
  public boolean isVipButNoFriend()
  {
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShareGroupItem{shareGroupId='");
    localStringBuilder.append(this.shareGroupId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", allowStrangerVisitAndPost=");
    localStringBuilder.append(this.allowStrangerVisitAndPost);
    localStringBuilder.append(", memberCount=");
    localStringBuilder.append(this.memberCount);
    localStringBuilder.append(", followCount=");
    localStringBuilder.append(this.followCount);
    localStringBuilder.append(", videoCount=");
    localStringBuilder.append(this.videoCount);
    localStringBuilder.append(", ownerType=");
    localStringBuilder.append(this.ownerType);
    localStringBuilder.append(", headerUnionIdList=");
    localStringBuilder.append(this.headerUnionIdList);
    localStringBuilder.append(", isSubscribed=");
    localStringBuilder.append(this.isSubscribed);
    localStringBuilder.append(", isDisband=");
    localStringBuilder.append(this.isDisband);
    localStringBuilder.append(", ownerUnionId='");
    localStringBuilder.append(this.ownerUnionId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", backgroundUrl='");
    localStringBuilder.append(this.backgroundUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", groupUin=");
    localStringBuilder.append(this.groupUin);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem
 * JD-Core Version:    0.7.0.1
 */