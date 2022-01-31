package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspCardList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.CardInfo;
import com.tencent.biz.qqstory.storyHome.discover.model.CardItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetDiscoverCardInfoResponse
  extends BaseResponse
{
  public String a;
  public ArrayList a;
  public boolean a;
  
  public GetDiscoverCardInfoResponse(qqstory_service.RspCardList paramRspCardList)
  {
    super(paramRspCardList.result);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramRspCardList.next_cookie.get().toStringUtf8();
    if (paramRspCardList.is_end.get() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      paramRspCardList = paramRspCardList.card_info_list.get().iterator();
      while (paramRspCardList.hasNext())
      {
        CardItem localCardItem = new CardItem((qqstory_struct.CardInfo)paramRspCardList.next());
        this.jdField_a_of_type_JavaUtilArrayList.add(localCardItem);
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetDiscoverCardInfoResponse
 * JD-Core Version:    0.7.0.1
 */