package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_group.GroupFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspPublishVideo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PublishStoryVideoRespond
  extends BaseResponse
{
  public long a;
  public String b = "";
  public String e;
  public String f;
  public long g;
  public String h;
  public List<AddGroupVideoResponse.AddGroupFeed> i;
  
  public PublishStoryVideoRespond(qqstory_service.RspPublishVideo paramRspPublishVideo)
  {
    super(paramRspPublishVideo.result);
    this.a = paramRspPublishVideo.create_time.get();
    this.b = paramRspPublishVideo.feed_id.get().toStringUtf8();
    this.e = String.valueOf(paramRspPublishVideo.date.get());
    this.g = paramRspPublishVideo.video_index.get();
    if (paramRspPublishVideo.story_id.has()) {
      this.f = paramRspPublishVideo.story_id.get().toStringUtf8();
    }
    if (paramRspPublishVideo.vid.has()) {
      this.h = paramRspPublishVideo.vid.get().toStringUtf8();
    }
    this.i = new ArrayList();
    paramRspPublishVideo = paramRspPublishVideo.group_feed_list.get().iterator();
    while (paramRspPublishVideo.hasNext())
    {
      qqstory_group.GroupFeed localGroupFeed = (qqstory_group.GroupFeed)paramRspPublishVideo.next();
      this.i.add(new AddGroupVideoResponse.AddGroupFeed(localGroupFeed));
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PublishStoryVideoRespond{createTime=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", date='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", storyId='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoIndex=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", vid=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", addShareGroupFeeds=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.PublishStoryVideoRespond
 * JD-Core Version:    0.7.0.1
 */