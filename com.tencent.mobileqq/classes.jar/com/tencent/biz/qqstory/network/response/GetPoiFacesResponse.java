package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.item.POIPosterItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPOIPosters;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.POIPosterData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;

public class GetPoiFacesResponse
  extends BaseResponse
{
  public final ArrayList a = new ArrayList();
  
  public GetPoiFacesResponse(qqstory_service.RspGetPOIPosters paramRspGetPOIPosters)
  {
    a(paramRspGetPOIPosters);
  }
  
  private void a(qqstory_service.RspGetPOIPosters paramRspGetPOIPosters)
  {
    int i = 0;
    while (i < paramRspGetPOIPosters.poi_posters.size())
    {
      Object localObject = (qqstory_struct.POIPosterData)paramRspGetPOIPosters.poi_posters.get(i);
      localObject = new POIPosterItem(((qqstory_struct.POIPosterData)localObject).poster_name.get().toStringUtf8(), ((qqstory_struct.POIPosterData)localObject).name.get().toStringUtf8(), ((qqstory_struct.POIPosterData)localObject).thumb_url.get().toStringUtf8(), ((qqstory_struct.POIPosterData)localObject).poster_url.get().toStringUtf8(), ((qqstory_struct.POIPosterData)localObject).poster_json_layout_desc.get().toStringUtf8());
      this.a.add(localObject);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetPoiFacesResponse
 * JD-Core Version:    0.7.0.1
 */