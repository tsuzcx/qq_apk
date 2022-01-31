package com.tencent.biz.pubaccount;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.NegFeedback;

public class VideoAdInfo$NegFeedback
{
  public long a;
  public String a;
  
  public VideoAdInfo$NegFeedback(VideoAdInfo paramVideoAdInfo, oidb_0x6cf.NegFeedback paramNegFeedback)
  {
    this.jdField_a_of_type_Long = paramNegFeedback.uint64_type_id.get();
    this.jdField_a_of_type_JavaLangString = paramNegFeedback.bytes_type_desc.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback
 * JD-Core Version:    0.7.0.1
 */