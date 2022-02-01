package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeedTagInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBaseList;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetFeedTagInfoListRequest$GetFeedTagInfoListResponse
  extends BaseResponse
{
  public List<GetFeedTagInfoListRequest.FeedTagInfoList> a = new ArrayList();
  
  public GetFeedTagInfoListRequest$GetFeedTagInfoListResponse(qqstory_service.RspStoryFeedTagInfo paramRspStoryFeedTagInfo)
  {
    paramRspStoryFeedTagInfo = paramRspStoryFeedTagInfo.tag_info.get();
    if (paramRspStoryFeedTagInfo != null)
    {
      paramRspStoryFeedTagInfo = paramRspStoryFeedTagInfo.iterator();
      while (paramRspStoryFeedTagInfo.hasNext())
      {
        Object localObject = (qqstory_struct.TagInfoBaseList)paramRspStoryFeedTagInfo.next();
        GetFeedTagInfoListRequest.FeedTagInfoList localFeedTagInfoList = new GetFeedTagInfoListRequest.FeedTagInfoList();
        localFeedTagInfoList.a = ((qqstory_struct.TagInfoBaseList)localObject).feed_id.get().toStringUtf8();
        localObject = ((qqstory_struct.TagInfoBaseList)localObject).tag_info_list.get();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            TagItem.TagInfoBase localTagInfoBase = new TagItem.TagInfoBase((qqstory_struct.TagInfoBase)((Iterator)localObject).next());
            localFeedTagInfoList.b.add(localTagInfoBase);
          }
        }
        this.a.add(localFeedTagInfoList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetFeedTagInfoListRequest.GetFeedTagInfoListResponse
 * JD-Core Version:    0.7.0.1
 */