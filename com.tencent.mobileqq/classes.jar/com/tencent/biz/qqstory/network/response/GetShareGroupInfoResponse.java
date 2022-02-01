package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetShareGroupInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupInfo;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetShareGroupInfoResponse
  extends BaseResponse
{
  public List<ShareGroupItem> a = new ArrayList();
  
  public GetShareGroupInfoResponse(qqstory_service.RspGetShareGroupInfo paramRspGetShareGroupInfo)
  {
    super(paramRspGetShareGroupInfo.result);
    if (paramRspGetShareGroupInfo.share_group_info_list.has())
    {
      paramRspGetShareGroupInfo = paramRspGetShareGroupInfo.share_group_info_list.get().iterator();
      while (paramRspGetShareGroupInfo.hasNext())
      {
        qqstory_struct.ShareGroupInfo localShareGroupInfo = (qqstory_struct.ShareGroupInfo)paramRspGetShareGroupInfo.next();
        ShareGroupItem localShareGroupItem = new ShareGroupItem();
        localShareGroupItem.convertFrom(localShareGroupInfo);
        this.a.add(localShareGroupItem);
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetShareGroupInfoResponse{errorCode=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", groupItems=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetShareGroupInfoResponse
 * JD-Core Version:    0.7.0.1
 */