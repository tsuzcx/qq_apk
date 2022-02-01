package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.item.RecommendItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetOfficialRecommends;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.RecommendItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetOfficialRecommendStoryListResponse
  extends BaseResponse
{
  public String a;
  public ArrayList<RecommendItem> a;
  public boolean a;
  public int b;
  
  public GetOfficialRecommendStoryListResponse(qqstory_service.RspGetOfficialRecommends paramRspGetOfficialRecommends)
  {
    this(paramRspGetOfficialRecommends, false);
  }
  
  public GetOfficialRecommendStoryListResponse(qqstory_service.RspGetOfficialRecommends paramRspGetOfficialRecommends, boolean paramBoolean)
  {
    super(paramRspGetOfficialRecommends.result);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int i = paramRspGetOfficialRecommends.is_end.get();
    paramBoolean = true;
    if (i != 1) {
      paramBoolean = false;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.b = paramRspGetOfficialRecommends.recom_count.get();
    this.jdField_a_of_type_JavaLangString = paramRspGetOfficialRecommends.next_cookie.get().toStringUtf8();
    paramRspGetOfficialRecommends = paramRspGetOfficialRecommends.recom_item_list.get().iterator();
    while (paramRspGetOfficialRecommends.hasNext())
    {
      qqstory_struct.RecommendItem localRecommendItem = (qqstory_struct.RecommendItem)paramRspGetOfficialRecommends.next();
      this.jdField_a_of_type_JavaUtilArrayList.add(new RecommendItem(localRecommendItem));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetOfficialRecommendStoryListResponse
 * JD-Core Version:    0.7.0.1
 */