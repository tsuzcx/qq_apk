package com.tencent.biz.qqstory.network.request;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqEditShareGroup;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspEditShareGroup;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupBasicInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupExtInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupInfo;
import com.tencent.biz.qqstory.network.response.EditShareGroupResponse;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.Iterator;
import java.util.List;

public class EditShareGroupRequest
  extends NetworkRequest<EditShareGroupResponse>
{
  protected static final String a;
  public ShareGroupItem a;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.edit_share_group");
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspEditShareGroup localRspEditShareGroup = new qqstory_service.RspEditShareGroup();
    try
    {
      localRspEditShareGroup.mergeFrom(paramArrayOfByte);
      return new EditShareGroupResponse(localRspEditShareGroup);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("Q.qqstory.shareGroup:edit_share_group", a(), paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqEditShareGroup localReqEditShareGroup = new qqstory_service.ReqEditShareGroup();
    qqstory_struct.ShareGroupInfo localShareGroupInfo = new qqstory_struct.ShareGroupInfo();
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem != null)
    {
      Object localObject = new qqstory_struct.ShareGroupBasicInfo();
      ((qqstory_struct.ShareGroupBasicInfo)localObject).shared_group_id.set(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.shareGroupId);
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.allowStrangerVisitAndPost != -1) {
        ((qqstory_struct.ShareGroupBasicInfo)localObject).allow_stranger_visit_and_post.set(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.allowStrangerVisitAndPost);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.name)) {
        ((qqstory_struct.ShareGroupBasicInfo)localObject).name.set(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.name);
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.ownerUnionId)) {
        ((qqstory_struct.ShareGroupBasicInfo)localObject).owner.set(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.ownerUnionId);
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.headerUnionIdList != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.headerUnionIdList.isEmpty()))
      {
        Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.headerUnionIdList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!TextUtils.isEmpty(str)) {
            ((qqstory_struct.ShareGroupBasicInfo)localObject).header_unionid_list.add(str);
          }
        }
      }
      localShareGroupInfo.basic_info.set((MessageMicro)localObject);
      localObject = new qqstory_struct.ShareGroupExtInfo();
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isSubscribed != -1) {
        ((qqstory_struct.ShareGroupExtInfo)localObject).has_join.set(this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.isSubscribed);
      }
      localShareGroupInfo.ext_info.set((MessageMicro)localObject);
    }
    localReqEditShareGroup.share_group_info.set(localShareGroupInfo);
    return localReqEditShareGroup.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.EditShareGroupRequest
 * JD-Core Version:    0.7.0.1
 */