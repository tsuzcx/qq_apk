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
  public int b;
  public String c;
  public String d;
  public String e;
  
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
    this.c = ((String)localObject1);
    this.b = paramRspGetUserGuide.seqno.get();
    if (paramRspGetUserGuide.confirm_word.has()) {
      localObject1 = paramRspGetUserGuide.confirm_word.get().toStringUtf8();
    } else {
      localObject1 = null;
    }
    this.d = ((String)localObject1);
    Object localObject1 = localObject2;
    if (paramRspGetUserGuide.cancel_word.has()) {
      localObject1 = paramRspGetUserGuide.cancel_word.get().toStringUtf8();
    }
    this.e = ((String)localObject1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Response{imageUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", word='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", seqno=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", confirmBtnTxt='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cancelBtnTxt='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetUserGuideInfoStep.Response
 * JD-Core Version:    0.7.0.1
 */