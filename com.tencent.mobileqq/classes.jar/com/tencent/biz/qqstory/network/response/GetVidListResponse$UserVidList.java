package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserVidList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetVidListResponse$UserVidList
{
  public String a;
  public List<String> b = new ArrayList();
  
  public GetVidListResponse$UserVidList(GetVidListResponse paramGetVidListResponse, qqstory_struct.UserVidList paramUserVidList)
  {
    this.a = paramUserVidList.union_id.get().toStringUtf8();
    paramGetVidListResponse = paramUserVidList.vid_list.get();
    if (paramGetVidListResponse != null)
    {
      paramGetVidListResponse = paramGetVidListResponse.iterator();
      while (paramGetVidListResponse.hasNext())
      {
        paramUserVidList = (ByteStringMicro)paramGetVidListResponse.next();
        this.b.add(paramUserVidList.toStringUtf8());
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserVidList{, uin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", vidList=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetVidListResponse.UserVidList
 * JD-Core Version:    0.7.0.1
 */