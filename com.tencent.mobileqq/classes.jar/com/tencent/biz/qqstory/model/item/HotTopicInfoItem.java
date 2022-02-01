package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetHotTopicInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem.ActivityCardInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class HotTopicInfoItem
  extends BaseUIItem
{
  public final String mBackgroundUrl;
  public final String mCoverUrl;
  public final boolean mIsValid;
  public final int mJoinCount;
  public final String mJoinDesc;
  public final String mLabel;
  public final int mMaskColor;
  public final String mSubjectName;
  public final long mTopicId;
  
  public HotTopicInfoItem(long paramLong, qqstory_service.RspGetHotTopicInfo paramRspGetHotTopicInfo)
  {
    this.mTopicId = paramLong;
    if (paramRspGetHotTopicInfo.result.error_code.get() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsValid = bool;
      this.mBackgroundUrl = paramRspGetHotTopicInfo.pic_url.get().toStringUtf8();
      this.mSubjectName = paramRspGetHotTopicInfo.subject.get().toStringUtf8();
      this.mJoinCount = paramRspGetHotTopicInfo.join_count.get();
      this.mJoinDesc = paramRspGetHotTopicInfo.guide_word.get().toStringUtf8();
      this.mMaskColor = paramRspGetHotTopicInfo.bkg_color.get();
      this.mLabel = paramRspGetHotTopicInfo.topic_label.get().toStringUtf8();
      this.mCoverUrl = paramRspGetHotTopicInfo.cover_url.get().toStringUtf8();
      return;
    }
  }
  
  public HotTopicInfoItem(CardItem.ActivityCardInfo paramActivityCardInfo)
  {
    this.mTopicId = paramActivityCardInfo.a();
    this.mJoinCount = paramActivityCardInfo.a();
    this.mCoverUrl = paramActivityCardInfo.b();
    this.mSubjectName = paramActivityCardInfo.a();
    this.mJoinDesc = "";
    this.mMaskColor = -1;
    this.mLabel = paramActivityCardInfo.c();
    this.mBackgroundUrl = "";
    this.mIsValid = true;
  }
  
  public String toString()
  {
    return "HotTopicInfoItem{mIsValid=" + this.mIsValid + ", mJoinCount=" + this.mJoinCount + ", mBackgroundUrl='" + this.mBackgroundUrl + '\'' + ", mSubjectName='" + this.mSubjectName + '\'' + ", mJoinDesc='" + this.mJoinDesc + '\'' + ", mMaskColor=" + this.mMaskColor + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.HotTopicInfoItem
 * JD-Core Version:    0.7.0.1
 */