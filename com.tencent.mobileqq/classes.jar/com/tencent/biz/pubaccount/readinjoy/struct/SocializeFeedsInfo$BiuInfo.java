package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.BiuMultiLevel;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.BiuOneLevelItem;

public class SocializeFeedsInfo$BiuInfo
  implements Cloneable
{
  public Long a;
  public List a;
  public Long b;
  
  public SocializeFeedsInfo$BiuInfo(SocializeFeedsInfo paramSocializeFeedsInfo)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public BiuInfo a()
  {
    try
    {
      BiuInfo localBiuInfo = (BiuInfo)super.clone();
      try
      {
        localBiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localIterator.next();
          localBiuInfo.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo.a());
        }
        return localBiuInfo;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
      return null;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1) {}
  }
  
  public oidb_cmd0x68b.BiuMultiLevel a()
  {
    oidb_cmd0x68b.BiuMultiLevel localBiuMultiLevel = new oidb_cmd0x68b.BiuMultiLevel();
    if (this.jdField_a_of_type_JavaLangLong != null) {
      localBiuMultiLevel.uint64_origin_feeds_id.set(this.jdField_a_of_type_JavaLangLong.longValue());
    }
    if (this.jdField_b_of_type_JavaLangLong != null) {
      localBiuMultiLevel.uint64_origin_feeds_type.set(this.jdField_b_of_type_JavaLangLong.longValue());
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localIterator.next();
        oidb_cmd0x68b.BiuOneLevelItem localBiuOneLevelItem = new oidb_cmd0x68b.BiuOneLevelItem();
        localBiuOneLevelItem.uint32_biu_time.set(localBiuCommentInfo.jdField_a_of_type_Int);
        localBiuOneLevelItem.uint64_uin.set(localBiuCommentInfo.jdField_a_of_type_JavaLangLong.longValue());
        if (localBiuCommentInfo.jdField_b_of_type_JavaLangLong != null) {
          localBiuOneLevelItem.uint64_feeds_id.set(localBiuCommentInfo.jdField_b_of_type_JavaLangLong.longValue());
        }
        if (!TextUtils.isEmpty(localBiuCommentInfo.jdField_b_of_type_JavaLangString)) {
          localBiuOneLevelItem.bytes_biu_comments.set(ByteStringMicro.copyFromUtf8(localBiuCommentInfo.jdField_b_of_type_JavaLangString));
        }
        localBiuOneLevelItem.feeds_type.set(localBiuCommentInfo.jdField_b_of_type_Int);
        localBiuOneLevelItem.op_type.set(localBiuCommentInfo.c);
        localArrayList.add(localBiuOneLevelItem);
      }
      localBiuMultiLevel.rpt_biu_mutli_level.set(localArrayList);
    }
    return localBiuMultiLevel;
  }
  
  public String toString()
  {
    return "BiuInfo{oriFeedId=" + this.jdField_a_of_type_JavaLangLong + "BiuCommentList=" + this.jdField_a_of_type_JavaUtilList + "oriFeedType" + this.jdField_b_of_type_JavaLangLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo
 * JD-Core Version:    0.7.0.1
 */