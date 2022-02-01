package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspShareVideoCollectionList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupFeed;
import com.tencent.biz.qqstory.storyHome.memory.model.ShareGroupCollectionItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetShareGroupListResponse
  extends BaseResponse
{
  public ArrayList<ShareGroupCollectionItem> a = new ArrayList();
  public int b;
  public String e;
  public boolean f;
  public long g;
  
  public GetShareGroupListResponse(String paramString, qqstory_service.RspShareVideoCollectionList paramRspShareVideoCollectionList)
  {
    super(paramRspShareVideoCollectionList.result);
    this.b = paramRspShareVideoCollectionList.total_share_group_count.get();
    this.e = paramRspShareVideoCollectionList.next_cookie.get().toStringUtf8();
    this.g = paramRspShareVideoCollectionList.seqno.get();
    int i = paramRspShareVideoCollectionList.is_end.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.f = bool;
    paramRspShareVideoCollectionList = paramRspShareVideoCollectionList.collection_list.get().iterator();
    while (paramRspShareVideoCollectionList.hasNext())
    {
      qqstory_struct.ShareGroupFeed localShareGroupFeed = (qqstory_struct.ShareGroupFeed)paramRspShareVideoCollectionList.next();
      ShareGroupCollectionItem localShareGroupCollectionItem = new ShareGroupCollectionItem();
      localShareGroupCollectionItem.convertFrom(paramString, localShareGroupFeed);
      this.a.add(localShareGroupCollectionItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetShareGroupListResponse
 * JD-Core Version:    0.7.0.1
 */