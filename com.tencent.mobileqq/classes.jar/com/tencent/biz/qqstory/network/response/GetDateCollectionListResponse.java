package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDateVideoCollectionList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.DateVideoCollection;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetDateCollectionListResponse
  extends BaseResponse
{
  public boolean a;
  public String b;
  public long e;
  public ArrayList<VideoCollectionItem> f = new ArrayList();
  public int g;
  public int h = -1;
  
  public GetDateCollectionListResponse(String paramString, qqstory_service.RspDateVideoCollectionList paramRspDateVideoCollectionList)
  {
    super(paramRspDateVideoCollectionList.result);
    int i = paramRspDateVideoCollectionList.is_end.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.a = bool;
    this.b = paramRspDateVideoCollectionList.next_cookie.get().toStringUtf8();
    this.g = paramRspDateVideoCollectionList.total_video_count.get();
    this.e = paramRspDateVideoCollectionList.seqno.get();
    this.h = paramRspDateVideoCollectionList.is_friend.get();
    paramRspDateVideoCollectionList = paramRspDateVideoCollectionList.collection_list.get().iterator();
    while (paramRspDateVideoCollectionList.hasNext())
    {
      qqstory_struct.DateVideoCollection localDateVideoCollection = (qqstory_struct.DateVideoCollection)paramRspDateVideoCollectionList.next();
      VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
      localVideoCollectionItem.convertFrom("Q.qqstory.memories:GetDateCollectionListResponse", paramString, localDateVideoCollection);
      this.f.add(localVideoCollectionItem);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetDateCollectionListResponse{isEnd=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", nextCookie='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", seq=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mTotalVideoCount=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mIsFriend=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetDateCollectionListResponse
 * JD-Core Version:    0.7.0.1
 */