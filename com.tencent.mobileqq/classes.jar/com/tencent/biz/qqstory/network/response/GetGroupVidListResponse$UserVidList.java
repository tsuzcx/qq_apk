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
  public List<String> a;
  
  public GetGroupVidListResponse$UserVidList(GetGroupVidListResponse paramGetGroupVidListResponse, qqstory_struct.UserVidList paramUserVidList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramUserVidList.union_id.get().toStringUtf8();
    paramGetGroupVidListResponse = paramUserVidList.vid_list.get();
    if (paramGetGroupVidListResponse != null)
    {
      paramGetGroupVidListResponse = paramGetGroupVidListResponse.iterator();
      while (paramGetGroupVidListResponse.hasNext())
      {
        paramUserVidList = (ByteStringMicro)paramGetGroupVidListResponse.next();
        this.jdField_a_of_type_JavaUtilList.add(paramUserVidList.toStringUtf8());
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UserVidList{, uin=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", vidList=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetGroupVidListResponse.UserVidList
 * JD-Core Version:    0.7.0.1
 */