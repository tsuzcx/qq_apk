package com.tencent.biz.qqstory.msgTabNode.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;
import nem;

public class MsgTabNodeVidListPullSegment
  extends JobSegment
{
  private boolean a;
  
  public MsgTabNodeVidListPullSegment(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  protected void a(JobContext paramJobContext, MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if ((paramMsgTabNodeInfo == null) || (TextUtils.isEmpty(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString)))
    {
      notifyError(new ErrorMessage(100, "nodeInfo not valid"));
      return;
    }
    if (paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "skip, nodeInfo has no video, info=" + paramMsgTabNodeInfo);
      }
      notifyResult(new MsgTabNodeVidListRequest.MsgTabNodeVidListResponse(paramMsgTabNodeInfo, new qqstory_service.RspMsgTabNodeVideoList(), null));
      return;
    }
    paramJobContext = MsgTabStoryManager.a(paramMsgTabNodeInfo);
    if (paramJobContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "get succeed from db, info=" + paramMsgTabNodeInfo);
      }
      notifyResult(MsgTabNodeVidListRequest.a(paramMsgTabNodeInfo, paramJobContext));
      return;
    }
    if (this.a)
    {
      notifyResult(null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "db not found, start to pull, info=" + paramMsgTabNodeInfo);
    }
    paramJobContext = new MsgTabNodeVidListRequest(paramMsgTabNodeInfo);
    CmdTaskManger.a().a(paramJobContext, new nem(this, paramMsgTabNodeInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListPullSegment
 * JD-Core Version:    0.7.0.1
 */