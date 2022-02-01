package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.database.VideoUrlEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetShareVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoFullInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoUrl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetShareVideoListResponse
  extends BaseResponse
{
  public String a;
  public String b;
  public boolean e;
  public List<StoryVideoItem> f = new ArrayList();
  public List<List<VideoUrlEntry>> g = new ArrayList();
  
  public GetShareVideoListResponse(String paramString, qqstory_service.RspGetShareVideoList paramRspGetShareVideoList)
  {
    super(paramRspGetShareVideoList.result);
    this.a = paramString;
    int i = paramRspGetShareVideoList.is_end.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.e = bool;
    this.b = paramRspGetShareVideoList.next_cookie.get().toStringUtf8();
    paramString = paramRspGetShareVideoList.full_video_info_list.get().iterator();
    while (paramString.hasNext())
    {
      Object localObject1 = (qqstory_struct.StoryVideoFullInfo)paramString.next();
      paramRspGetShareVideoList = new StoryVideoItem();
      paramRspGetShareVideoList.convertFrom((qqstory_struct.StoryVideoFullInfo)localObject1);
      this.f.add(paramRspGetShareVideoList);
      Object localObject2 = ((qqstory_struct.StoryVideoFullInfo)localObject1).compressed_video.get();
      if (localObject2 != null)
      {
        localObject1 = new ArrayList(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          qqstory_struct.VideoUrl localVideoUrl = (qqstory_struct.VideoUrl)((Iterator)localObject2).next();
          VideoUrlEntry localVideoUrlEntry = new VideoUrlEntry();
          localVideoUrlEntry.vid = paramRspGetShareVideoList.mVid;
          localVideoUrlEntry.videoUrlLevel = localVideoUrl.video_level.get();
          localVideoUrlEntry.videoUrl = localVideoUrl.video_url.get();
          ((List)localObject1).add(localVideoUrlEntry);
        }
        this.g.add(localObject1);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetShareVideoListResponse{unionId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("isEnd=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", nextCookie='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoItems=");
    localStringBuilder.append(StoryVideoItem.dump(this.f));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetShareVideoListResponse
 * JD-Core Version:    0.7.0.1
 */