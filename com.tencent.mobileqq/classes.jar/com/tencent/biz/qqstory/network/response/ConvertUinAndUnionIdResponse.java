package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspConvertUinAndUnionId;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvertUinAndUnionIdResponse
  extends BaseResponse
{
  public List<QQUserUIItem> a = new ArrayList();
  
  public ConvertUinAndUnionIdResponse(qqstory_service.RspConvertUinAndUnionId paramRspConvertUinAndUnionId)
  {
    super(paramRspConvertUinAndUnionId.result);
    paramRspConvertUinAndUnionId = paramRspConvertUinAndUnionId.user_list.get();
    if (paramRspConvertUinAndUnionId != null)
    {
      paramRspConvertUinAndUnionId = paramRspConvertUinAndUnionId.iterator();
      while (paramRspConvertUinAndUnionId.hasNext())
      {
        qqstory_struct.UserInfo localUserInfo = (qqstory_struct.UserInfo)paramRspConvertUinAndUnionId.next();
        QQUserUIItem localQQUserUIItem = new QQUserUIItem();
        localQQUserUIItem.convertFrom(localUserInfo);
        this.a.add(localQQUserUIItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.ConvertUinAndUnionIdResponse
 * JD-Core Version:    0.7.0.1
 */