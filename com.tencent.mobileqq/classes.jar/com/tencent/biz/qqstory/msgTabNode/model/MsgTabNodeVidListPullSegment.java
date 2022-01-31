package com.tencent.biz.qqstory.msgTabNode.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeVidListRequest.MsgTabNodeVidListResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.PBUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;
import nij;

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
    paramJobContext = null;
    if ((paramMsgTabNodeInfo == null) || (TextUtils.isEmpty(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString)))
    {
      notifyError(new ErrorMessage(100, "nodeInfo not valid"));
      return;
    }
    if (paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size() == 0)
    {
      QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, new Object[] { "skip, nodeInfo has no video, info=%s", paramMsgTabNodeInfo });
      notifyResult(new MsgTabNodeVidListRequest.MsgTabNodeVidListResponse(paramMsgTabNodeInfo, new qqstory_service.RspMsgTabNodeVideoList(), null));
      return;
    }
    Object localObject = MsgTabStoryManager.a(paramMsgTabNodeInfo);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobPullVidList", 2, "get succeed from db, info=" + paramMsgTabNodeInfo);
      }
      localObject = MsgTabNodeVidListRequest.a(paramMsgTabNodeInfo, (byte[])localObject);
      notifyResult(localObject);
      if (localObject != null) {
        paramJobContext = ((MsgTabNodeVidListRequest.MsgTabNodeVidListResponse)localObject).a;
      }
      SLog.a("Q.qqstory.msgTab.jobPullVidList.VASH", "MsgTabNodeVidListPullSegment::runSegment() use local %s, %s", paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString, PBUtils.a(paramJobContext));
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
    SLog.a("Q.qqstory.msgTab.jobPullVidList", "sendRequest %s: nodeInfo: %s", paramJobContext.a(), String.valueOf(paramMsgTabNodeInfo));
    CmdTaskManger.a().a(paramJobContext, new nij(this, paramMsgTabNodeInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListPullSegment
 * JD-Core Version:    0.7.0.1
 */