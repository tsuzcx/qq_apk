package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
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
    this.d = 7;
    this.e = paramNegFeedback.uint64_type_id.get();
    this.a = paramNegFeedback.uint32_id.get();
    this.b = paramNegFeedback.uint32_f_id.get();
    this.c = paramNegFeedback.bytes_type_desc.get().toStringUtf8();
    this.f = "";
  }
  
  public AdDislikeInfo(oidb_0x885.NegFeedback paramNegFeedback)
  {
    this.d = 7;
    this.e = paramNegFeedback.uint64_type_id.get();
    this.a = paramNegFeedback.uint32_id.get();
    this.b = paramNegFeedback.uint32_f_id.get();
    this.c = paramNegFeedback.bytes_type_desc.get().toStringUtf8();
    this.f = "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AdDislikeInfo{id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", f_id=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", tagID=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", describe='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdDislikeInfo
 * JD-Core Version:    0.7.0.1
 */