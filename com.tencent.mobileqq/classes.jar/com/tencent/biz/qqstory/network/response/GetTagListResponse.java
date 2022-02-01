package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetTagList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagItem;
import com.tencent.biz.qqstory.takevideo.tag.TagItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetTagListResponse
  extends BaseResponse
{
  public final List<TagItem> a = new ArrayList();
  public final int b;
  public final String e;
  
  public GetTagListResponse(qqstory_service.RspGetTagList paramRspGetTagList)
  {
    Object localObject = paramRspGetTagList.tag_list.get();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        qqstory_struct.TagItem localTagItem = (qqstory_struct.TagItem)((Iterator)localObject).next();
        this.a.add(new TagItem(localTagItem));
      }
    }
    this.b = paramRspGetTagList.is_end.get();
    this.e = paramRspGetTagList.next_cookie.get();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetTagListResponse{mTagItems=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mIsEnd=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mNextCookie='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetTagListResponse
 * JD-Core Version:    0.7.0.1
 */