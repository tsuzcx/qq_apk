package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetUserGuide;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class GetUserGuideInfoStep$Response
  extends BaseResponse
{
  public String a;
  public String b;
  public int e;
  public String f;
  public String g;
  
  public GetUserGuideInfoStep$Response(qqstory_service.RspGetUserGuide paramRspGetUserGuide)
  {
    boolean bool = paramRspGetUserGuide.pic_url.has();
    Object localObject2 = null;
    if (bool) {
      localObject1 = paramRspGetUserGuide.pic_url.get().toStringUtf8();
    } else {
      localObject1 = null;
    }
    this.a = ((String)localObject1);
    if (paramRspGetUserGuide.word.has()) {
      localObject1 = paramRspGetUserGuide.word.get().toStringUtf8();
    } else {
      localObject1 = null;
    }
    this.b = ((String)localObject1);
    this.e = paramRspGetUserGuide.seqno.get();
    if (paramRspGetUserGuide.confirm_word.has()) {
      localObject1 = paramRspGetUserGuide.confirm_word.get().toStringUtf8();
    } else {
      localObject1 = null;
    }
    this.f = ((String)localObject1);
    Object localObject1 = localObject2;
    if (paramRspGetUserGuide.cancel_word.has()) {
      localObject1 = paramRspGetUserGuide.cancel_word.get().toStringUtf8();
    }
    this.g = ((String)localObject1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Response{imageUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", word='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", seqno=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", confirmBtnTxt='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cancelBtnTxt='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep.Response
 * JD-Core Version:    0.7.0.1
 */