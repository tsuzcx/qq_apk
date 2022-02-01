package com.tencent.biz.qqstory.network.request;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqReportEvil;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspReportEvil;
import com.tencent.biz.qqstory.network.response.ReportEvilResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class ReportEvilRequest
  extends NetworkRequest<ReportEvilResponse>
{
  public static final String e = StoryApi.a("StorySvc.video_report_evil");
  public String f;
  public String g;
  public long h;
  public final int i;
  
  public ReportEvilResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspReportEvil localRspReportEvil = new qqstory_service.RspReportEvil();
    try
    {
      localRspReportEvil.mergeFrom(paramArrayOfByte);
      return new ReportEvilResponse(localRspReportEvil);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public String a()
  {
    return e;
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqReportEvil localReqReportEvil = new qqstory_service.ReqReportEvil();
    if (!TextUtils.isEmpty(this.f)) {
      localReqReportEvil.vid.set(ByteStringMicro.copyFromUtf8(this.f));
    }
    if (this.h != 0L) {
      localReqReportEvil.tuin.set(this.h);
    }
    if (!TextUtils.isEmpty(this.g)) {
      localReqReportEvil.union_id.set(ByteStringMicro.copyFromUtf8(this.g));
    }
    localReqReportEvil.type.set(this.i);
    return localReqReportEvil.toByteArray();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReportEvilRequest{impeachType=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.ReportEvilRequest
 * JD-Core Version:    0.7.0.1
 */