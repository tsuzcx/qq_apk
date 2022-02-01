package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.database.OfficialRecommendEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.BigVColleciton;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class RecommendBigVItem
  extends BaseUIItem
{
  public int mColor;
  public String mCover;
  public String mDesc;
  public int mFans;
  public int mId;
  public String mLogo;
  public QQUserUIItem mUser;
  
  public RecommendBigVItem(OfficialRecommendEntry paramOfficialRecommendEntry)
  {
    if (paramOfficialRecommendEntry == null) {
      return;
    }
    this.mId = paramOfficialRecommendEntry.bigvId;
    this.mUser = new QQUserUIItem(paramOfficialRecommendEntry);
    this.mLogo = paramOfficialRecommendEntry.bigvLog;
    this.mColor = paramOfficialRecommendEntry.bigvColor;
    this.mDesc = paramOfficialRecommendEntry.bigvDesc;
    this.mCover = paramOfficialRecommendEntry.bigvCover;
    this.mFans = paramOfficialRecommendEntry.bigvFans;
  }
  
  public RecommendBigVItem(qqstory_struct.BigVColleciton paramBigVColleciton)
  {
    this.mId = paramBigVColleciton.id.get();
    QQUserUIItem localQQUserUIItem = new QQUserUIItem();
    localQQUserUIItem.convertFrom(paramBigVColleciton.user);
    this.mUser = ((UserManager)SuperManager.a(2)).a(localQQUserUIItem);
    this.mCover = paramBigVColleciton.cover.get().toStringUtf8();
    this.mLogo = paramBigVColleciton.logo.get().toStringUtf8();
    this.mColor = paramBigVColleciton.color.get();
    this.mDesc = paramBigVColleciton.desc.get().toStringUtf8();
    this.mFans = paramBigVColleciton.fans.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.RecommendBigVItem
 * JD-Core Version:    0.7.0.1
 */