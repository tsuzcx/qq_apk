package com.tencent.biz.qqstory.network.request;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_group.GroupVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqAddGroupVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspAddGroupVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.VideoObject;
import com.tencent.biz.qqstory.network.response.AddGroupVideoResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class AddGroupVideoRequest
  extends NetworkRequest<AddGroupVideoResponse>
{
  private final HashMap<String, List<String>> e = new HashMap();
  private final List<Long> f;
  private final List<Integer> g;
  private final int h;
  
  public AddGroupVideoRequest(String paramString, List<String> paramList, List<Long> paramList1, List<Integer> paramList2, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.e.put(paramString, Collections.unmodifiableList(paramList));
        this.f = paramList1;
        this.g = paramList2;
        this.h = paramInt;
        return;
      }
      throw new IllegalArgumentException("vidList is empty");
    }
    throw new IllegalArgumentException("union_id should not be empty");
  }
  
  public String a()
  {
    return StoryApi.a("StoryGroupSvc.add_video");
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_group.RspAddGroupVideo localRspAddGroupVideo = new qqstory_group.RspAddGroupVideo();
    try
    {
      localRspAddGroupVideo.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("AddGroupVideoRequest", "decodeResponse", paramArrayOfByte);
    }
    return new AddGroupVideoResponse(localRspAddGroupVideo);
  }
  
  protected byte[] c()
  {
    qqstory_group.ReqAddGroupVideo localReqAddGroupVideo = new qqstory_group.ReqAddGroupVideo();
    Iterator localIterator = this.e.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      qqstory_group.GroupVideo localGroupVideo = new qqstory_group.GroupVideo();
      localGroupVideo.source.set(this.h);
      localGroupVideo.union_id.set(ByteStringMicro.copyFromUtf8((String)((Map.Entry)localObject).getKey()));
      int i = 0;
      localObject = ((List)((Map.Entry)localObject).getValue()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        qqstory_group.VideoObject localVideoObject = new qqstory_group.VideoObject();
        localVideoObject.vid.set(ByteStringMicro.copyFromUtf8(str));
        localVideoObject.ts.set(((Long)this.f.get(i)).longValue() / 1000L);
        localVideoObject.time_zone.set(((Integer)this.g.get(i)).intValue());
        localGroupVideo.video_obj_list.add(localVideoObject);
        i += 1;
      }
      localReqAddGroupVideo.group_video_list.add(localGroupVideo);
    }
    return localReqAddGroupVideo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.AddGroupVideoRequest
 * JD-Core Version:    0.7.0.1
 */