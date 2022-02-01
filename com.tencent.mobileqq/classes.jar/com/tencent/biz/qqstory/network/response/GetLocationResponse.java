package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;

public class GetLocationResponse
  extends BaseResponse
{
  public final String a;
  public final String b;
  public final String e;
  public final String f;
  public final String g;
  
  public GetLocationResponse(qqstory_service.RspGetLocation paramRspGetLocation)
  {
    this.a = paramRspGetLocation.country.get().toStringUtf8();
    this.b = paramRspGetLocation.province.get().toStringUtf8();
    this.e = paramRspGetLocation.city.get().toStringUtf8();
    this.f = paramRspGetLocation.district.get().toStringUtf8();
    this.g = paramRspGetLocation.street.get().toStringUtf8();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetLocationResponse{mCountry='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mProvince='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCity='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mDistrict='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mStreet='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetLocationResponse
 * JD-Core Version:    0.7.0.1
 */