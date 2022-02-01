package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserVidList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetGroupVidListResponse$UserVidList
{
  public String a;
  public List<String> b = new ArrayList();
  
  public GetGroupVidListResponse$UserVidList(GetGroupVidListResponse paramGetGroupVidListResponse, qqstory_struct.UserVidList paramUserVidList)
  {
    this.a = paramUserVidList.union_id.get().toStringUtf8();
    paramGetGroupVidListResponse = paramUserVidList.vid_list.get();
    if (paramGetGroupVidListResponse != null)
    {
      paramGetGroupVidListResponse = paramGetGroupVidListResponse.iterator();
      while (paramGetGroupVidListResponse.hasNext())
      {
        paramUserVidList = (ByteStringMicro)paramGetGroupVidListResponse.next();
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
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetGroupVidListResponse.UserVidList
 * JD-Core Version:    0.7.0.1
 */