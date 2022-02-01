package com.tencent.biz.qqstory.network.request;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetBatchUserVidList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetBatchUserVidList;
import com.tencent.biz.qqstory.network.response.GetVidListResponse;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetVidListRequest
  extends NetworkRequest
{
  public static final String e = StoryApi.a("StorySvc.get_vid_list_no_expired");
  public List<String> f = new ArrayList();
  public int g;
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspGetBatchUserVidList localRspGetBatchUserVidList = new qqstory_service.RspGetBatchUserVidList();
    try
    {
      localRspGetBatchUserVidList.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return new GetVidListResponse(localRspGetBatchUserVidList);
  }
  
  protected byte[] c()
  {
    qqstory_service.ReqGetBatchUserVidList localReqGetBatchUserVidList = new qqstory_service.ReqGetBatchUserVidList();
    localReqGetBatchUserVidList.pull_type.set(this.g);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (TextUtils.isEmpty(a(str))) {
        AssertUtils.fail("why uid is null ??", new Object[0]);
      } else {
        localArrayList.add(ByteStringMicro.copyFromUtf8(a(str)));
      }
    }
    localReqGetBatchUserVidList.union_id_list.addAll(localArrayList);
    return localReqGetBatchUserVidList.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetVidListRequest
 * JD-Core Version:    0.7.0.1
 */