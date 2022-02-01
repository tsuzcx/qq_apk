package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.articlesummary.feeds_info.VisibleShowInfo;

public class SocializeFeedsInfo$PrivacyShowInfo
  implements Cloneable
{
  public int a;
  public long a;
  public long b = 0L;
  
  public SocializeFeedsInfo$PrivacyShowInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  private static PrivacyShowInfo b(feeds_info.VisibleShowInfo paramVisibleShowInfo)
  {
    long l2 = 0L;
    PrivacyShowInfo localPrivacyShowInfo = new PrivacyShowInfo();
    long l1;
    if (paramVisibleShowInfo.uint64_feed_id.has())
    {
      l1 = paramVisibleShowInfo.uint64_feed_id.get();
      localPrivacyShowInfo.b = l1;
      if (!paramVisibleShowInfo.uint32_visible_type.has()) {
        break label150;
      }
    }
    label150:
    for (int i = paramVisibleShowInfo.uint32_visible_type.get();; i = 0)
    {
      localPrivacyShowInfo.jdField_a_of_type_Int = i;
      l1 = l2;
      if (paramVisibleShowInfo.uint64_who.has()) {
        l1 = paramVisibleShowInfo.uint64_who.get();
      }
      localPrivacyShowInfo.jdField_a_of_type_Long = l1;
      QLog.d("SocializeFeedsInfo", 1, "feeds privacy | feedsid  " + localPrivacyShowInfo.b + " | privacyType " + localPrivacyShowInfo.jdField_a_of_type_Int + " | privacySetUin " + localPrivacyShowInfo.jdField_a_of_type_Long);
      return localPrivacyShowInfo;
      l1 = 0L;
      break;
    }
  }
  
  public PrivacyShowInfo a()
  {
    try
    {
      PrivacyShowInfo localPrivacyShowInfo = (PrivacyShowInfo)super.clone();
      return localPrivacyShowInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PrivacyShowInfo
 * JD-Core Version:    0.7.0.1
 */