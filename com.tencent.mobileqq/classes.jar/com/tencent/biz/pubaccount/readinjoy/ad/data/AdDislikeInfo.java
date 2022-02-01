package com.tencent.biz.pubaccount.readinjoy.ad.data;

import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.NegFeedback;
import tencent.im.oidb.cmd0x885.oidb_0x885.NegFeedback;

public class AdDislikeInfo
  extends DislikeInfo
{
  public int a;
  public int b;
  
  public AdDislikeInfo(articlesummary.NegFeedback paramNegFeedback)
  {
    this.c = 7;
    this.jdField_a_of_type_Long = paramNegFeedback.uint64_type_id.get();
    this.jdField_a_of_type_Int = paramNegFeedback.uint32_id.get();
    this.jdField_b_of_type_Int = paramNegFeedback.uint32_f_id.get();
    this.jdField_a_of_type_JavaLangString = paramNegFeedback.bytes_type_desc.get().toStringUtf8();
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public AdDislikeInfo(oidb_0x885.NegFeedback paramNegFeedback)
  {
    this.c = 7;
    this.jdField_a_of_type_Long = paramNegFeedback.uint64_type_id.get();
    this.jdField_a_of_type_Int = paramNegFeedback.uint32_id.get();
    this.jdField_b_of_type_Int = paramNegFeedback.uint32_f_id.get();
    this.jdField_a_of_type_JavaLangString = paramNegFeedback.bytes_type_desc.get().toStringUtf8();
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public String toString()
  {
    return "AdDislikeInfo{id=" + this.jdField_a_of_type_Int + ", f_id=" + this.jdField_b_of_type_Int + ", tagID=" + this.jdField_a_of_type_Long + ", describe='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.data.AdDislikeInfo
 * JD-Core Version:    0.7.0.1
 */