package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import qqcircle.TaskCenterReader.TaskListRsp;
import qqcircle.TaskCenterReader.TaskRecord;

class QCircleRecommendImageView$7
  implements VSDispatchObserver.onVSRspCallBack<TaskCenterReader.TaskListRsp>
{
  QCircleRecommendImageView$7(QCircleRecommendImageView paramQCircleRecommendImageView) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, TaskCenterReader.TaskListRsp paramTaskListRsp)
  {
    if (paramTaskListRsp != null)
    {
      paramBaseRequest = ((ArrayList)paramTaskListRsp.taskRecords.get()).iterator();
      for (;;)
      {
        paramBoolean = paramBaseRequest.hasNext();
        int i = 0;
        if (!paramBoolean) {
          break;
        }
        paramString = (TaskCenterReader.TaskRecord)paramBaseRequest.next();
        if (paramString.taskType.get() == 5)
        {
          int j = paramString.haveDone.get();
          int k = paramString.maxCnt.get();
          paramString = new StringBuilder();
          paramString.append("getShareInfo: haveDone ");
          paramString.append(j);
          paramString.append(" maxCnt ");
          paramString.append(k);
          QLog.i("QCircleRecommend_", 1, paramString.toString());
          if (j >= k) {
            i = 1;
          }
          QCirclePluginGlobalInfo.b(i);
        }
      }
      QCircleRecommendImageView.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.7
 * JD-Core Version:    0.7.0.1
 */