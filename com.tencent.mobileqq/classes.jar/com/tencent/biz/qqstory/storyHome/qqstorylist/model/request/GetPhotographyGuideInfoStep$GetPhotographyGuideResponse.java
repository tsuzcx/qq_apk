package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPhotographyGuide;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetPhotographyGuideInfoStep$GetPhotographyGuideResponse
  extends BaseResponse
{
  public List<String> a = new ArrayList();
  public int b;
  
  public GetPhotographyGuideInfoStep$GetPhotographyGuideResponse(qqstory_service.RspGetPhotographyGuide paramRspGetPhotographyGuide)
  {
    super(paramRspGetPhotographyGuide.result);
    Object localObject = paramRspGetPhotographyGuide.word.get();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ByteStringMicro localByteStringMicro = (ByteStringMicro)((Iterator)localObject).next();
        this.a.add(localByteStringMicro.toStringUtf8());
      }
    }
    this.b = paramRspGetPhotographyGuide.seqno.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetPhotographyGuideResponse{, wordList=");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append(", seqno=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.GetPhotographyGuideInfoStep.GetPhotographyGuideResponse
 * JD-Core Version:    0.7.0.1
 */