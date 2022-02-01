package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetLabelList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetLabelListResponse
  extends BaseResponse
{
  public List<String> a = new ArrayList();
  public boolean b;
  public String e;
  
  public GetLabelListResponse(qqstory_service.RspGetLabelList paramRspGetLabelList)
  {
    super(paramRspGetLabelList.result);
    this.e = paramRspGetLabelList.next_cookie.get().toStringUtf8();
    int i = paramRspGetLabelList.is_end.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.b = bool;
    paramRspGetLabelList = paramRspGetLabelList.label_list.get();
    if (paramRspGetLabelList != null)
    {
      paramRspGetLabelList = paramRspGetLabelList.iterator();
      while (paramRspGetLabelList.hasNext())
      {
        ByteStringMicro localByteStringMicro = (ByteStringMicro)paramRspGetLabelList.next();
        this.a.add(localByteStringMicro.toStringUtf8());
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetLabelListResponse{isEnd=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", labelList=");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append(", nextCookie='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetLabelListResponse
 * JD-Core Version:    0.7.0.1
 */