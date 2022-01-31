package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqConvertUinAndUnionId;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspConvertUinAndUnionId;
import com.tencent.biz.qqstory.network.response.ConvertUinAndUnionIdResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvertUinAndUnionIdRequest
  extends NetworkRequest
{
  public String a;
  public List a;
  public boolean a;
  public int c;
  
  public ConvertUinAndUnionIdRequest()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public ConvertUinAndUnionIdResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspConvertUinAndUnionId localRspConvertUinAndUnionId = new qqstory_service.RspConvertUinAndUnionId();
    try
    {
      localRspConvertUinAndUnionId.mergeFrom(paramArrayOfByte);
      return new ConvertUinAndUnionIdResponse(localRspConvertUinAndUnionId);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.d("Q.qqstory.user:ConvertUinAndUnionIdRequest", "" + paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return StoryApi.a("StorySvc.convert_uid_and_union_id");
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqConvertUinAndUnionId localReqConvertUinAndUnionId = new qqstory_service.ReqConvertUinAndUnionId();
    localReqConvertUinAndUnionId.convert_from.set(this.c);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      QQUserUIItem.UserID localUserID = (QQUserUIItem.UserID)localIterator.next();
      localReqConvertUinAndUnionId.user_id_list.add(localUserID.a());
    }
    return localReqConvertUinAndUnionId.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.ConvertUinAndUnionIdRequest
 * JD-Core Version:    0.7.0.1
 */