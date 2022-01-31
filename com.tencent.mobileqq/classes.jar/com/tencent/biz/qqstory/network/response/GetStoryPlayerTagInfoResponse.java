package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryPlayerTagInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBaseVidList;
import com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest.TagInfoBaseVidList;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetStoryPlayerTagInfoResponse
  extends BaseResponse
{
  public final List a = new ArrayList();
  
  public GetStoryPlayerTagInfoResponse(qqstory_service.RspStoryPlayerTagInfo paramRspStoryPlayerTagInfo)
  {
    super(paramRspStoryPlayerTagInfo.result);
    paramRspStoryPlayerTagInfo = paramRspStoryPlayerTagInfo.tag_info.get().iterator();
    while (paramRspStoryPlayerTagInfo.hasNext())
    {
      Object localObject = (qqstory_struct.TagInfoBaseVidList)paramRspStoryPlayerTagInfo.next();
      String str = ((qqstory_struct.TagInfoBaseVidList)localObject).vid.get().toStringUtf8();
      localObject = (qqstory_struct.TagInfoBase)((qqstory_struct.TagInfoBaseVidList)localObject).tag_info.get();
      this.a.add(new GetStoryPlayerTagInfoRequest.TagInfoBaseVidList(str, new TagItem.TagInfoBase((qqstory_struct.TagInfoBase)localObject)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetStoryPlayerTagInfoResponse
 * JD-Core Version:    0.7.0.1
 */