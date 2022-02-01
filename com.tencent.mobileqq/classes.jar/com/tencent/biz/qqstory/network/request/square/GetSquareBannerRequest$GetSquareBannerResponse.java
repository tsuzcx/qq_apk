package com.tencent.biz.qqstory.network.request.square;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetSquareBannerItemList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.SquareBannerItem;
import com.tencent.biz.qqstory.storyHome.square.model.SquareBannerItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetSquareBannerRequest$GetSquareBannerResponse
  extends BaseResponse
{
  public List<SquareBannerItem> a = new ArrayList();
  
  public GetSquareBannerRequest$GetSquareBannerResponse(qqstory_service.RspGetSquareBannerItemList paramRspGetSquareBannerItemList)
  {
    super(paramRspGetSquareBannerItemList.result);
    paramRspGetSquareBannerItemList = paramRspGetSquareBannerItemList.item_list.get().iterator();
    while (paramRspGetSquareBannerItemList.hasNext())
    {
      SquareBannerItem localSquareBannerItem = new SquareBannerItem((qqstory_struct.SquareBannerItem)paramRspGetSquareBannerItemList.next());
      this.a.add(localSquareBannerItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.square.GetSquareBannerRequest.GetSquareBannerResponse
 * JD-Core Version:    0.7.0.1
 */