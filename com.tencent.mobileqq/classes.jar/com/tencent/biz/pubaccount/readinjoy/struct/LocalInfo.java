package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import tencent.im.oidb.articlesummary.articlesummary.LocalInfo;

public class LocalInfo
{
  public String a = null;
  public String b = null;
  public String c = null;
  public String d = null;
  public String e = null;
  public String f = null;
  public String g = null;
  public String h = null;
  
  public LocalInfo() {}
  
  public LocalInfo(articlesummary.LocalInfo paramLocalInfo)
  {
    if (paramLocalInfo == null) {
      return;
    }
    this.a = paramLocalInfo.bytes_store_url.get().toStringUtf8();
    this.b = paramLocalInfo.bytes_store_url.get().toStringUtf8();
    this.c = paramLocalInfo.bytes_store_address.get().toStringUtf8();
    this.d = paramLocalInfo.bytes_store_longitude.get().toStringUtf8();
    this.e = paramLocalInfo.bytes_store_latitude.get().toStringUtf8();
    this.f = paramLocalInfo.bytes_distance_description.get().toStringUtf8();
    this.g = paramLocalInfo.bytes_corporate_image_name.get().toStringUtf8();
    this.h = paramLocalInfo.bytes_distance_limit.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.LocalInfo
 * JD-Core Version:    0.7.0.1
 */