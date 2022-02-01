package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGroupDateVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupNodeInfo;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetShareGroupDateListResponse
  extends BaseResponse
{
  public boolean a;
  public String b;
  public long e;
  public ArrayList<VideoCollectionItem> f = new ArrayList();
  
  public GetShareGroupDateListResponse(String paramString, qqstory_service.RspGroupDateVideoList paramRspGroupDateVideoList)
  {
    super(paramRspGroupDateVideoList.result);
    int i = paramRspGroupDateVideoList.is_end.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.a = bool;
    this.b = paramRspGroupDateVideoList.next_cookie.get().toStringUtf8();
    this.e = paramRspGroupDateVideoList.seqno.get();
    paramRspGroupDateVideoList = paramRspGroupDateVideoList.group_node_info.get().iterator();
    while (paramRspGroupDateVideoList.hasNext())
    {
      qqstory_struct.GroupNodeInfo localGroupNodeInfo = (qqstory_struct.GroupNodeInfo)paramRspGroupDateVideoList.next();
      VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
      localVideoCollectionItem.convertFrom("Q.qqstory.shareGroup:GetDateCollectionListResponse", paramString, localGroupNodeInfo);
      this.f.add(localVideoCollectionItem);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetShareGroupDateListResponse{errorCode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isEnd=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", nextCookie='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", seq=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mCollectionItemList=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetShareGroupDateListResponse
 * JD-Core Version:    0.7.0.1
 */