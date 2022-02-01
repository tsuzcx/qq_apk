package com.tencent.biz.qqstory.model.filter;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetFilterList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FilterListPack;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class VideoFilterManager$GetFilterListResponse
  extends BaseResponse
{
  public final boolean a;
  @NonNull
  public final List<FilterItem> b;
  @NonNull
  public final String e;
  public final int f;
  
  public VideoFilterManager$GetFilterListResponse(byte[] paramArrayOfByte)
  {
    Object localObject1 = new qqstory_service.RspGetFilterList();
    try
    {
      ((qqstory_service.RspGetFilterList)localObject1).mergeFrom(paramArrayOfByte);
      this.c = ((qqstory_service.RspGetFilterList)localObject1).result.error_code.get();
      this.d = ((qqstory_service.RspGetFilterList)localObject1).result.error_desc.get().toStringUtf8();
      boolean bool;
      if (((qqstory_service.RspGetFilterList)localObject1).is_end.get() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.a = bool;
      this.e = ((qqstory_service.RspGetFilterList)localObject1).next_cookie.get().toStringUtf8();
      this.f = ((qqstory_service.RspGetFilterList)localObject1).frequency.get();
      paramArrayOfByte = new ArrayList();
      localObject1 = ((qqstory_service.RspGetFilterList)localObject1).filter_list.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (qqstory_struct.FilterListPack)((Iterator)localObject1).next();
        FilterItem.Builder localBuilder = new FilterItem.Builder();
        localBuilder.a = ((qqstory_struct.FilterListPack)localObject2).filter_id.get();
        localBuilder.b = ((qqstory_struct.FilterListPack)localObject2).filter_name.get().toStringUtf8();
        localBuilder.c = ((qqstory_struct.FilterListPack)localObject2).filter_type.get();
        localBuilder.d = ((qqstory_struct.FilterListPack)localObject2).filter_config_file.get().toStringUtf8();
        localBuilder.e = ((qqstory_struct.FilterListPack)localObject2).filter_config_md5.get().toStringUtf8();
        try
        {
          localObject2 = localBuilder.a();
          paramArrayOfByte.add(localObject2);
          SLog.d("VideoFilterManager", "GET Filter : id=%d, name=%s, type=%d, url=%s, md5=%s", new Object[] { Long.valueOf(((FilterItem)localObject2).filterId), ((FilterItem)localObject2).filterName, Integer.valueOf(((FilterItem)localObject2).filterType), ((FilterItem)localObject2).filterConfigUrl, ((FilterItem)localObject2).filterConfigMd5 });
        }
        catch (FilterItem.FilterItemIllegalException localFilterItemIllegalException)
        {
          SLog.c("VideoFilterManager", "GET Filter error : ", localFilterItemIllegalException);
        }
      }
      this.b = Collections.unmodifiableList(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("GetEmojiPackInfoListRequest error : ");
      ((StringBuilder)localObject1).append(paramArrayOfByte);
      SLog.e("VideoFilterManager", ((StringBuilder)localObject1).toString());
      this.c = -1;
      this.d = HardCodeUtil.a(2131913464);
      this.a = false;
      this.b = Collections.EMPTY_LIST;
      this.e = "";
      this.f = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.VideoFilterManager.GetFilterListResponse
 * JD-Core Version:    0.7.0.1
 */