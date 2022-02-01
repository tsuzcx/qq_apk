package com.tencent.biz.qqstory.msgTabNode.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class MsgTabNodeVidListPullSegment$1
  implements CmdTaskManger.CommandCallback<MsgTabNodeVidListRequest, MsgTabNodeVidListRequest.MsgTabNodeVidListResponse>
{
  MsgTabNodeVidListPullSegment$1(MsgTabNodeVidListPullSegment paramMsgTabNodeVidListPullSegment, MsgTabNodeInfo paramMsgTabNodeInfo) {}
  
  public void a(@NonNull MsgTabNodeVidListRequest paramMsgTabNodeVidListRequest, @Nullable MsgTabNodeVidListRequest.MsgTabNodeVidListResponse paramMsgTabNodeVidListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramMsgTabNodeVidListResponse != null) && (!paramErrorMessage.isFail()))
    {
      if (paramMsgTabNodeVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.video_list.size() == 0)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_Int != 5)
        {
          paramMsgTabNodeVidListRequest = new StringBuilder();
          paramMsgTabNodeVidListRequest.append("pull failed, ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, info=");
          paramMsgTabNodeVidListRequest.append(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo);
          paramMsgTabNodeVidListRequest.append(", err=ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, ");
          paramMsgTabNodeVidListRequest.append(paramErrorMessage.getErrorMessage());
          SLog.e("Q.qqstory.msgTab.jobPullVidList", paramMsgTabNodeVidListRequest.toString());
          MsgTabNodeVidListPullSegment.b(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeVidListPullSegment, new ErrorMessage(103, paramErrorMessage.getErrorMessage()));
          return;
        }
        MsgTabNodeVidListPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeVidListPullSegment, MsgTabNodeVidListPullSegment.a(paramMsgTabNodeVidListResponse.jdField_a_of_type_JavaUtilList));
        return;
      }
      if (QLog.isColorLevel())
      {
        paramMsgTabNodeVidListRequest = new StringBuilder();
        paramMsgTabNodeVidListRequest.append("pull succeed, info=");
        paramMsgTabNodeVidListRequest.append(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo);
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, paramMsgTabNodeVidListRequest.toString());
      }
      MsgTabStoryManager.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo, paramMsgTabNodeVidListResponse.jdField_a_of_type_ArrayOfByte);
      paramMsgTabNodeVidListRequest = MsgTabNodeVidListPullSegment.a(paramMsgTabNodeVidListResponse.jdField_a_of_type_JavaUtilList);
      int i = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_Int;
      MsgTabNodeVidListPullSegment.b(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeVidListPullSegment, paramMsgTabNodeVidListRequest);
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_Int == 12)
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeVidListPullSegment.a != null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeVidListPullSegment.a.c = paramMsgTabNodeVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
          paramMsgTabNodeVidListRequest = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeVidListPullSegment.a;
          boolean bool;
          if (paramMsgTabNodeVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.is_end.get() > 0) {
            bool = true;
          } else {
            bool = false;
          }
          paramMsgTabNodeVidListRequest.a = bool;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.i = paramMsgTabNodeVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList.cookie.get();
      }
      if (QLog.isColorLevel()) {
        SLog.a("Q.qqstory.msgTab.jobPullVidList", "MsgTabNodeVidListPullSegment::runSegment() use net resp %s, %s", this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString, paramMsgTabNodeVidListResponse.jdField_a_of_type_ComTencentBizQqstoryNetworkPbQqstory_service$RspMsgTabNodeVideoList);
      }
      return;
    }
    paramMsgTabNodeVidListRequest = new StringBuilder();
    paramMsgTabNodeVidListRequest.append("pull failed, err=");
    paramMsgTabNodeVidListRequest.append(paramErrorMessage.getErrorMessage());
    paramMsgTabNodeVidListRequest.append(" node:");
    paramMsgTabNodeVidListRequest.append(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo);
    SLog.e("Q.qqstory.msgTab.jobPullVidList", paramMsgTabNodeVidListRequest.toString());
    MsgTabNodeVidListPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeVidListPullSegment, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListPullSegment.1
 * JD-Core Version:    0.7.0.1
 */