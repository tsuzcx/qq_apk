package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.database.OfficialRecommendEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ClickUrlInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class RecommendLinkItem
  extends BaseUIItem
{
  public int mColor;
  public String mCover;
  public String mDesc;
  public int mId;
  public String mLogo;
  public String mUrl;
  
  public RecommendLinkItem(OfficialRecommendEntry paramOfficialRecommendEntry)
  {
    if (paramOfficialRecommendEntry == null) {
      return;
    }
    this.mId = paramOfficialRecommendEntry.linkId;
    this.mUrl = paramOfficialRecommendEntry.linkUrl;
    this.mCover = paramOfficialRecommendEntry.linkCover;
    this.mLogo = paramOfficialRecommendEntry.linkLogo;
    this.mColor = paramOfficialRecommendEntry.linkColor;
    this.mDesc = paramOfficialRecommendEntry.linkDesc;
  }
  
  public RecommendLinkItem(qqstory_struct.ClickUrlInfo paramClickUrlInfo)
  {
    this.mId = paramClickUrlInfo.id.get();
    this.mUrl = paramClickUrlInfo.url.get().toStringUtf8();
    this.mCover = paramClickUrlInfo.cover.get().toStringUtf8();
    this.mLogo = paramClickUrlInfo.logo.get().toStringUtf8();
    this.mColor = paramClickUrlInfo.color.get();
    this.mDesc = paramClickUrlInfo.desc.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.RecommendLinkItem
 * JD-Core Version:    0.7.0.1
 */