package com.tencent.biz.qqcircle.requests;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.TaskCenterReader.TaskListReq;
import qqcircle.TaskCenterReader.TaskListRsp;

public class QCircleGetTaskCenterListRequest
  extends QCircleBaseRequest
{
  TaskCenterReader.TaskListReq mRequest = new TaskCenterReader.TaskListReq();
  
  public QCircleGetTaskCenterListRequest(String paramString)
  {
    this.mRequest.userId.set(paramString);
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    TaskCenterReader.TaskListRsp localTaskListRsp = new TaskCenterReader.TaskListRsp();
    localTaskListRsp.mergeFrom(paramArrayOfByte);
    return localTaskListRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circletaskcenter.TaskCenterReader.GetTaskList";
  }
  
  public byte[] getRequestByteData()
  {
    return this.mRequest.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleGetTaskCenterListRequest
 * JD-Core Version:    0.7.0.1
 */