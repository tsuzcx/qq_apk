package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryPlayerTagInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.CompInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBaseVidList;
import com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest.TagInfoBaseVidList;
import com.tencent.biz.qqstory.takevideo.tag.CompInfoBase;
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
  public final List<GetStoryPlayerTagInfoRequest.TagInfoBaseVidList> a = new ArrayList();
  
  public GetStoryPlayerTagInfoResponse(qqstory_service.RspStoryPlayerTagInfo paramRspStoryPlayerTagInfo)
  {
    super(paramRspStoryPlayerTagInfo.result);
    Iterator localIterator = paramRspStoryPlayerTagInfo.tag_info.get().iterator();
    while (localIterator.hasNext())
    {
      qqstory_struct.TagInfoBaseVidList localTagInfoBaseVidList = (qqstory_struct.TagInfoBaseVidList)localIterator.next();
      String str2 = localTagInfoBaseVidList.vid.get().toStringUtf8();
      qqstory_struct.TagInfoBase localTagInfoBase = (qqstory_struct.TagInfoBase)localTagInfoBaseVidList.tag_info.get();
      boolean bool = localTagInfoBaseVidList.comp_info.has();
      String str1 = null;
      if (bool) {
        paramRspStoryPlayerTagInfo = new CompInfoBase((qqstory_struct.CompInfoBase)localTagInfoBaseVidList.comp_info.get());
      } else {
        paramRspStoryPlayerTagInfo = null;
      }
      if (localTagInfoBaseVidList.extern_config_json.has()) {
        str1 = localTagInfoBaseVidList.extern_config_json.get().toStringUtf8();
      }
      this.a.add(new GetStoryPlayerTagInfoRequest.TagInfoBaseVidList(str2, new TagItem.TagInfoBase(localTagInfoBase), paramRspStoryPlayerTagInfo, str1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetStoryPlayerTagInfoResponse
 * JD-Core Version:    0.7.0.1
 */