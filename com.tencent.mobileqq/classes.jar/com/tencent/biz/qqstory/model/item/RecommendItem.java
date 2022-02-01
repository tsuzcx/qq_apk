package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.database.OfficialRecommendEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.RecommendItem;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

public class RecommendItem
  extends BaseUIItem
{
  public static final String TAG = "RecommendItem";
  public static final int TYPE_BIG_V = 1;
  public static final int TYPE_HOT_TOPIC = 4;
  public static final int TYPE_LINK = 3;
  public int mID;
  public boolean mIsMarkRead = false;
  public BaseUIItem mItem;
  public int mPlayerRecord = 0;
  public int mType;
  
  public RecommendItem(OfficialRecommendEntry paramOfficialRecommendEntry)
  {
    this.mType = paramOfficialRecommendEntry.type;
    this.mID = paramOfficialRecommendEntry.itemId;
    this.mIsMarkRead = paramOfficialRecommendEntry.isMarkRead;
    int i = this.mType;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (QLog.isColorLevel())
          {
            paramOfficialRecommendEntry = new StringBuilder();
            paramOfficialRecommendEntry.append("cannot found type :");
            paramOfficialRecommendEntry.append(this.mType);
            QLog.e("RecommendItem", 2, paramOfficialRecommendEntry.toString());
          }
        }
        else {
          this.mItem = new HotTopicItem(paramOfficialRecommendEntry);
        }
      }
      else {
        this.mItem = new RecommendLinkItem(paramOfficialRecommendEntry);
      }
    }
    else {
      this.mItem = new RecommendBigVItem(paramOfficialRecommendEntry);
    }
  }
  
  public RecommendItem(qqstory_struct.RecommendItem paramRecommendItem)
  {
    this.mType = paramRecommendItem.type.get();
    this.mID = paramRecommendItem.item_id.get();
    int i = this.mType;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (QLog.isColorLevel())
          {
            paramRecommendItem = new StringBuilder();
            paramRecommendItem.append("cannot found type :");
            paramRecommendItem.append(this.mType);
            QLog.e("RecommendItem", 2, paramRecommendItem.toString());
          }
        }
        else {
          this.mItem = new HotTopicItem(paramRecommendItem.topic_info);
        }
      }
      else {
        this.mItem = new RecommendLinkItem(paramRecommendItem.url_info);
      }
    }
    else {
      this.mItem = new RecommendBigVItem(paramRecommendItem.bigv_info);
    }
  }
  
  public OfficialRecommendEntry cover2StoryEntry()
  {
    OfficialRecommendEntry localOfficialRecommendEntry = new OfficialRecommendEntry();
    int i = this.mType;
    localOfficialRecommendEntry.type = i;
    localOfficialRecommendEntry.itemId = this.mID;
    localOfficialRecommendEntry.isMarkRead = this.mIsMarkRead;
    Object localObject;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("cannot found type :");
            ((StringBuilder)localObject).append(this.mType);
            QLog.e("RecommendItem", 2, ((StringBuilder)localObject).toString());
            return localOfficialRecommendEntry;
          }
        }
        else
        {
          localObject = (HotTopicItem)this.mItem;
          localOfficialRecommendEntry.topicId = ((HotTopicItem)localObject).topicId;
          localOfficialRecommendEntry.topicName = ((HotTopicItem)localObject).topicName;
          localOfficialRecommendEntry.topicCover = ((HotTopicItem)localObject).topicCover;
          localOfficialRecommendEntry.topicLogo = ((HotTopicItem)localObject).topicLogo;
          localOfficialRecommendEntry.topicColor = ((HotTopicItem)localObject).topicColor;
          localOfficialRecommendEntry.topicDesc = ((HotTopicItem)localObject).topicDesc;
          localOfficialRecommendEntry.topicCanJoin = ((HotTopicItem)localObject).topicCanJoin;
          return localOfficialRecommendEntry;
        }
      }
      else
      {
        localObject = (RecommendLinkItem)this.mItem;
        localOfficialRecommendEntry.linkId = ((RecommendLinkItem)localObject).mId;
        localOfficialRecommendEntry.linkUrl = ((RecommendLinkItem)localObject).mUrl;
        localOfficialRecommendEntry.linkCover = ((RecommendLinkItem)localObject).mCover;
        localOfficialRecommendEntry.linkColor = ((RecommendLinkItem)localObject).mColor;
        localOfficialRecommendEntry.linkDesc = ((RecommendLinkItem)localObject).mDesc;
        return localOfficialRecommendEntry;
      }
    }
    else
    {
      localObject = (RecommendBigVItem)this.mItem;
      localOfficialRecommendEntry.bigvId = ((RecommendBigVItem)localObject).mId;
      localOfficialRecommendEntry.bigvCover = ((RecommendBigVItem)localObject).mCover;
      localOfficialRecommendEntry.bigvLog = ((RecommendBigVItem)localObject).mLogo;
      localOfficialRecommendEntry.bigvColor = ((RecommendBigVItem)localObject).mColor;
      localOfficialRecommendEntry.bigvDesc = ((RecommendBigVItem)localObject).mDesc;
      localOfficialRecommendEntry.bigvFans = ((RecommendBigVItem)localObject).mFans;
      localOfficialRecommendEntry.bigvUserUnionId = ((RecommendBigVItem)localObject).mUser.uid;
      localOfficialRecommendEntry.bigvUserNickName = ((RecommendBigVItem)localObject).mUser.nickName;
      localOfficialRecommendEntry.bigvUserHeadUrl = ((RecommendBigVItem)localObject).mUser.headUrl;
      localOfficialRecommendEntry.bigvUserRemark = ((RecommendBigVItem)localObject).mUser.remark;
      localOfficialRecommendEntry.bigvUserIsVip = ((RecommendBigVItem)localObject).mUser.isVip;
      localOfficialRecommendEntry.bigvUserSymbolUrl = ((RecommendBigVItem)localObject).mUser.symbolUrl;
    }
    return localOfficialRecommendEntry;
  }
  
  public String toString()
  {
    int i = this.mType;
    Object localObject;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          localObject = "";
        }
        else
        {
          localObject = (HotTopicItem)this.mItem;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(", topicId: ");
          localStringBuilder.append(((HotTopicItem)localObject).topicId);
          localStringBuilder.append(", topicName: ");
          localStringBuilder.append(((HotTopicItem)localObject).topicName);
          localStringBuilder.append(", cover: ");
          localStringBuilder.append(((HotTopicItem)localObject).topicCover);
          localObject = localStringBuilder.toString();
        }
      }
      else
      {
        localObject = (RecommendLinkItem)this.mItem;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(", linkDesc");
        localStringBuilder.append(((RecommendLinkItem)localObject).mDesc);
        localStringBuilder.append(", linkUrl:");
        localStringBuilder.append(((RecommendLinkItem)localObject).mUrl);
        localStringBuilder.append(", cover: ");
        localStringBuilder.append(((RecommendLinkItem)localObject).mCover);
        localObject = localStringBuilder.toString();
      }
    }
    else
    {
      localObject = (RecommendBigVItem)this.mItem;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(", bigVID: ");
      localStringBuilder.append(((RecommendBigVItem)localObject).mId);
      localStringBuilder.append(",bigVName: ");
      localStringBuilder.append(((RecommendBigVItem)localObject).mUser.nickName);
      localStringBuilder.append(", uid: ");
      localStringBuilder.append(((RecommendBigVItem)localObject).mUser.uid);
      localStringBuilder.append(", cover: ");
      localStringBuilder.append(((RecommendBigVItem)localObject).mCover);
      localObject = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecommendItem { mIsMarkRead:");
    localStringBuilder.append(this.mIsMarkRead);
    localStringBuilder.append(", mPlayerRecord:");
    localStringBuilder.append(this.mPlayerRecord);
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.RecommendItem
 * JD-Core Version:    0.7.0.1
 */