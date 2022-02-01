package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBannerVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoTarget;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetDiscoverBannerVideoResponse
  extends BaseResponse
{
  public List<String> a = new ArrayList();
  public List<String> b = new ArrayList();
  public boolean e;
  public String f;
  public int g;
  
  public GetDiscoverBannerVideoResponse(qqstory_service.RspBannerVideoList paramRspBannerVideoList)
  {
    super(paramRspBannerVideoList.result);
    if ((paramRspBannerVideoList.video_list.has()) && (!paramRspBannerVideoList.video_list.isEmpty()))
    {
      Iterator localIterator = paramRspBannerVideoList.video_list.get().iterator();
      while (localIterator.hasNext())
      {
        qqstory_struct.VideoTarget localVideoTarget = (qqstory_struct.VideoTarget)localIterator.next();
        this.a.add(localVideoTarget.vid.get().toStringUtf8());
        this.b.add(localVideoTarget.feed_id.get().toStringUtf8());
      }
    }
    if (paramRspBannerVideoList.is_end.has())
    {
      int i = paramRspBannerVideoList.is_end.get();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.e = bool;
    }
    if (paramRspBannerVideoList.next_cookie.has()) {
      this.f = paramRspBannerVideoList.next_cookie.get().toStringUtf8();
    }
    if (paramRspBannerVideoList.total_count.has()) {
      this.g = paramRspBannerVideoList.total_count.get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetDiscoverBannerVideoResponse
 * JD-Core Version:    0.7.0.1
 */