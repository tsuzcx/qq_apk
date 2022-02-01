package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCollectionViewCount;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.DateVideoCollection;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UpdateCollectionViewCountResponse
  extends BaseResponse
{
  public List<VideoCollectionItem> a = new ArrayList();
  
  public UpdateCollectionViewCountResponse(String paramString, qqstory_service.RspCollectionViewCount paramRspCollectionViewCount)
  {
    super(paramRspCollectionViewCount.result);
    paramRspCollectionViewCount = paramRspCollectionViewCount.collection_list.get();
    if (paramRspCollectionViewCount != null)
    {
      paramRspCollectionViewCount = paramRspCollectionViewCount.iterator();
      while (paramRspCollectionViewCount.hasNext())
      {
        qqstory_struct.DateVideoCollection localDateVideoCollection = (qqstory_struct.DateVideoCollection)paramRspCollectionViewCount.next();
        VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
        localVideoCollectionItem.convertFrom("Q.qqstory.net:UpdateCollectionViewCountResponse", paramString, localDateVideoCollection);
        this.a.add(localVideoCollectionItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.UpdateCollectionViewCountResponse
 * JD-Core Version:    0.7.0.1
 */