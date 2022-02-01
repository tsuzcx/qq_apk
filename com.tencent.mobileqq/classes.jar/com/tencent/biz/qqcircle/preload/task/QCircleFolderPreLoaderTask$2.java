package com.tencent.biz.qqcircle.preload.task;

import com.tencent.biz.qqcircle.manager.QCircleFuelAnimationManager;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import qqcircle.TaskCenterReader.TaskListRsp;

class QCircleFolderPreLoaderTask$2
  implements VSDispatchObserver.onVSRspCallBack<TaskCenterReader.TaskListRsp>
{
  QCircleFolderPreLoaderTask$2(QCircleFolderPreLoaderTask paramQCircleFolderPreLoaderTask) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, TaskCenterReader.TaskListRsp paramTaskListRsp)
  {
    if (paramTaskListRsp != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QCircleFolderPreLoaderTask->onReceive: dispatch Success:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" |CmdName:");
      localStringBuilder.append(paramBaseRequest.getCmdName());
      localStringBuilder.append(" | TraceId:");
      localStringBuilder.append(paramBaseRequest.getTraceId());
      localStringBuilder.append(" | SeqId:");
      localStringBuilder.append(paramBaseRequest.getCurrentSeq());
      localStringBuilder.append(" | retCode:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" | retMessage:");
      localStringBuilder.append(paramString);
      QLog.d("QCircleFolderPreLoaderTask", 1, localStringBuilder.toString());
      QCircleFuelAnimationManager.a().a((ArrayList)paramTaskListRsp.taskRecords.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.preload.task.QCircleFolderPreLoaderTask.2
 * JD-Core Version:    0.7.0.1
 */