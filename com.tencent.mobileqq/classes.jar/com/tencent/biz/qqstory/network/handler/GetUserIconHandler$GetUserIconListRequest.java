package com.tencent.biz.qqstory.network.handler;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.lego.LegoRequestBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqIconPostfix;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspIconPostfix;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;

public class GetUserIconHandler$GetUserIconListRequest
  extends LegoRequestBase
{
  private ArrayList<String> a;
  
  public GetUserIconHandler$GetUserIconListRequest(ArrayList<String> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public LegoResponseBase a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_service.RspIconPostfix();
    try
    {
      ((qqstory_service.RspIconPostfix)localObject).mergeFrom(paramArrayOfByte);
      return new GetUserIconHandler.GetUserIconListResponse((qqstory_service.RspIconPostfix)localObject);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("GetUserIconHandler", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public String a()
  {
    return StoryApi.a("StorySvc.batch_get_user_icon_info");
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqIconPostfix localReqIconPostfix = new qqstory_service.ReqIconPostfix();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!TextUtils.isEmpty(str)) {
        localReqIconPostfix.union_id_list.add(ByteStringMicro.copyFromUtf8(str));
      }
    }
    return localReqIconPostfix.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserIconHandler.GetUserIconListRequest
 * JD-Core Version:    0.7.0.1
 */