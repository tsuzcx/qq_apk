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
  public boolean mIsMarkRead;
  public BaseUIItem mItem;
  public int mPlayerRecord;
  public int mType;
  
  public RecommendItem(OfficialRecommendEntry paramOfficialRecommendEntry)
  {
    this.mType = paramOfficialRecommendEntry.type;
    this.mID = paramOfficialRecommendEntry.itemId;
    this.mIsMarkRead = paramOfficialRecommendEntry.isMarkRead;
    switch (this.mType)
    {
    case 2: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("RecommendItem", 2, "cannot found type :" + this.mType);
      }
      return;
    case 4: 
      this.mItem = new HotTopicItem(paramOfficialRecommendEntry);
      return;
    case 1: 
      this.mItem = new RecommendBigVItem(paramOfficialRecommendEntry);
      return;
    }
    this.mItem = new RecommendLinkItem(paramOfficialRecommendEntry);
  }
  
  public RecommendItem(qqstory_struct.RecommendItem paramRecommendItem)
  {
    this.mType = paramRecommendItem.type.get();
    this.mID = paramRecommendItem.item_id.get();
    switch (this.mType)
    {
    case 2: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("RecommendItem", 2, "cannot found type :" + this.mType);
      }
      return;
    case 4: 
      this.mItem = new HotTopicItem(paramRecommendItem.topic_info);
      return;
    case 1: 
      this.mItem = new RecommendBigVItem(paramRecommendItem.bigv_info);
      return;
    }
    this.mItem = new RecommendLinkItem(paramRecommendItem.url_info);
  }
  
  public OfficialRecommendEntry cover2StoryEntry()
  {
    OfficialRecommendEntry localOfficialRecommendEntry = new OfficialRecommendEntry();
    localOfficialRecommendEntry.type = this.mType;
    localOfficialRecommendEntry.itemId = this.mID;
    localOfficialRecommendEntry.isMarkRead = this.mIsMarkRead;
    switch (this.mType)
    {
    case 2: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("RecommendItem", 2, "cannot found type :" + this.mType);
      }
      return localOfficialRecommendEntry;
    case 4: 
      localObject = (HotTopicItem)this.mItem;
      localOfficialRecommendEntry.topicId = ((HotTopicItem)localObject).topicId;
      localOfficialRecommendEntry.topicName = ((HotTopicItem)localObject).topicName;
      localOfficialRecommendEntry.topicCover = ((HotTopicItem)localObject).topicCover;
      localOfficialRecommendEntry.topicLogo = ((HotTopicItem)localObject).topicLogo;
      localOfficialRecommendEntry.topicColor = ((HotTopicItem)localObject).topicColor;
      localOfficialRecommendEntry.topicDesc = ((HotTopicItem)localObject).topicDesc;
      localOfficialRecommendEntry.topicCanJoin = ((HotTopicItem)localObject).topicCanJoin;
      return localOfficialRecommendEntry;
    case 1: 
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
      return localOfficialRecommendEntry;
    }
    Object localObject = (RecommendLinkItem)this.mItem;
    localOfficialRecommendEntry.linkId = ((RecommendLinkItem)localObject).mId;
    localOfficialRecommendEntry.linkUrl = ((RecommendLinkItem)localObject).mUrl;
    localOfficialRecommendEntry.linkCover = ((RecommendLinkItem)localObject).mCover;
    localOfficialRecommendEntry.linkColor = ((RecommendLinkItem)localObject).mColor;
    localOfficialRecommendEntry.linkDesc = ((RecommendLinkItem)localObject).mDesc;
    return localOfficialRecommendEntry;
  }
  
  public String toString()
  {
    String str = "";
    Object localObject = str;
    switch (this.mType)
    {
    default: 
      localObject = str;
    }
    for (;;)
    {
      return "RecommendItem { mIsMarkRead:" + this.mIsMarkRead + ", mPlayerRecord:" + this.mPlayerRecord + (String)localObject + "}";
      localObject = (HotTopicItem)this.mItem;
      localObject = ", topicId: " + ((HotTopicItem)localObject).topicId + ", topicName: " + ((HotTopicItem)localObject).topicName + ", cover: " + ((HotTopicItem)localObject).topicCover;
      continue;
      localObject = (RecommendBigVItem)this.mItem;
      localObject = ", bigVID: " + ((RecommendBigVItem)localObject).mId + ",bigVName: " + ((RecommendBigVItem)localObject).mUser.nickName + ", uid: " + ((RecommendBigVItem)localObject).mUser.uid + ", cover: " + ((RecommendBigVItem)localObject).mCover;
      continue;
      localObject = (RecommendLinkItem)this.mItem;
      localObject = ", linkDesc" + ((RecommendLinkItem)localObject).mDesc + ", linkUrl:" + ((RecommendLinkItem)localObject).mUrl + ", cover: " + ((RecommendLinkItem)localObject).mCover;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.RecommendItem
 * JD-Core Version:    0.7.0.1
 */