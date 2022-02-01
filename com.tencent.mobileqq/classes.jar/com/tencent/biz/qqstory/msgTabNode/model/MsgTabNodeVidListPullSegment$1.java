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
      if (paramMsgTabNodeVidListResponse.e.video_list.size() == 0)
      {
        if (this.a.b != 5)
        {
          paramMsgTabNodeVidListRequest = new StringBuilder();
          paramMsgTabNodeVidListRequest.append("pull failed, ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, info=");
          paramMsgTabNodeVidListRequest.append(this.a);
          paramMsgTabNodeVidListRequest.append(", err=ERROR_NODE_VIDEOINFO_VIDLIST_IS_NULL, ");
          paramMsgTabNodeVidListRequest.append(paramErrorMessage.getErrorMessage());
          SLog.e("Q.qqstory.msgTab.jobPullVidList", paramMsgTabNodeVidListRequest.toString());
          MsgTabNodeVidListPullSegment.b(this.b, new ErrorMessage(103, paramErrorMessage.getErrorMessage()));
          return;
        }
        MsgTabNodeVidListPullSegment.a(this.b, MsgTabNodeVidListPullSegment.a(paramMsgTabNodeVidListResponse.f));
        return;
      }
      if (QLog.isColorLevel())
      {
        paramMsgTabNodeVidListRequest = new StringBuilder();
        paramMsgTabNodeVidListRequest.append("pull succeed, info=");
        paramMsgTabNodeVidListRequest.append(this.a);
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, paramMsgTabNodeVidListRequest.toString());
      }
      MsgTabStoryManager.a(this.a, paramMsgTabNodeVidListResponse.b);
      paramMsgTabNodeVidListRequest = MsgTabNodeVidListPullSegment.a(paramMsgTabNodeVidListResponse.f);
      int i = this.a.b;
      MsgTabNodeVidListPullSegment.b(this.b, paramMsgTabNodeVidListRequest);
      if (this.a.b == 12)
      {
        if (this.b.c != null)
        {
          this.b.c.d = paramMsgTabNodeVidListResponse.e.cookie.get();
          paramMsgTabNodeVidListRequest = this.b.c;
          boolean bool;
          if (paramMsgTabNodeVidListResponse.e.is_end.get() > 0) {
            bool = true;
          } else {
            bool = false;
          }
          paramMsgTabNodeVidListRequest.g = bool;
        }
        this.a.x = paramMsgTabNodeVidListResponse.e.cookie.get();
      }
      if (QLog.isColorLevel()) {
        SLog.a("Q.qqstory.msgTab.jobPullVidList", "MsgTabNodeVidListPullSegment::runSegment() use net resp %s, %s", this.a.d, paramMsgTabNodeVidListResponse.e);
      }
      return;
    }
    paramMsgTabNodeVidListRequest = new StringBuilder();
    paramMsgTabNodeVidListRequest.append("pull failed, err=");
    paramMsgTabNodeVidListRequest.append(paramErrorMessage.getErrorMessage());
    paramMsgTabNodeVidListRequest.append(" node:");
    paramMsgTabNodeVidListRequest.append(this.a);
    SLog.e("Q.qqstory.msgTab.jobPullVidList", paramMsgTabNodeVidListRequest.toString());
    MsgTabNodeVidListPullSegment.a(this.b, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListPullSegment.1
 * JD-Core Version:    0.7.0.1
 */