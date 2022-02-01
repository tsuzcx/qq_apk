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
  @NonNull
  public final String a;
  @NonNull
  public final List<FilterItem> a;
  public final boolean a;
  public final int b;
  
  public VideoFilterManager$GetFilterListResponse(byte[] paramArrayOfByte)
  {
    Object localObject1 = new qqstory_service.RspGetFilterList();
    for (;;)
    {
      try
      {
        ((qqstory_service.RspGetFilterList)localObject1).mergeFrom(paramArrayOfByte);
        this.jdField_a_of_type_Int = ((qqstory_service.RspGetFilterList)localObject1).result.error_code.get();
        this.jdField_b_of_type_JavaLangString = ((qqstory_service.RspGetFilterList)localObject1).result.error_desc.get().toStringUtf8();
        if (((qqstory_service.RspGetFilterList)localObject1).is_end.get() != 0)
        {
          this.jdField_a_of_type_Boolean = bool;
          this.jdField_a_of_type_JavaLangString = ((qqstory_service.RspGetFilterList)localObject1).next_cookie.get().toStringUtf8();
          this.jdField_b_of_type_Int = ((qqstory_service.RspGetFilterList)localObject1).frequency.get();
          paramArrayOfByte = new ArrayList();
          localObject1 = ((qqstory_service.RspGetFilterList)localObject1).filter_list.get().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          Object localObject2 = (qqstory_struct.FilterListPack)((Iterator)localObject1).next();
          FilterItem.Builder localBuilder = new FilterItem.Builder();
          localBuilder.jdField_a_of_type_Long = ((qqstory_struct.FilterListPack)localObject2).filter_id.get();
          localBuilder.jdField_a_of_type_JavaLangString = ((qqstory_struct.FilterListPack)localObject2).filter_name.get().toStringUtf8();
          localBuilder.jdField_a_of_type_Int = ((qqstory_struct.FilterListPack)localObject2).filter_type.get();
          localBuilder.jdField_b_of_type_JavaLangString = ((qqstory_struct.FilterListPack)localObject2).filter_config_file.get().toStringUtf8();
          localBuilder.c = ((qqstory_struct.FilterListPack)localObject2).filter_config_md5.get().toStringUtf8();
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
          continue;
        }
        bool = false;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        SLog.e("VideoFilterManager", "GetEmojiPackInfoListRequest error : " + paramArrayOfByte);
        this.jdField_a_of_type_Int = -1;
        this.jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131716090);
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilList = Collections.EMPTY_LIST;
        this.jdField_a_of_type_JavaLangString = "";
        this.jdField_b_of_type_Int = 0;
        return;
      }
    }
    this.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.filter.VideoFilterManager.GetFilterListResponse
 * JD-Core Version:    0.7.0.1
 */