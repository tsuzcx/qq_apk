package com.tencent.biz.qqcircle.adapter;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import qqcircle.TaskCenterReader.TaskListRsp;

class QCircleTaskCenterAdapter$2
  implements VSDispatchObserver.onVSRspCallBack<TaskCenterReader.TaskListRsp>
{
  QCircleTaskCenterAdapter$2(QCircleTaskCenterAdapter paramQCircleTaskCenterAdapter) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, TaskCenterReader.TaskListRsp paramTaskListRsp)
  {
    if (paramTaskListRsp != null)
    {
      this.a.setDatas((ArrayList)paramTaskListRsp.taskRecords.get());
      if ((this.a.a != null) && (QCircleTaskCenterAdapter.c(this.a) != null))
      {
        this.a.a.removeAllViews();
        paramBaseRequest = String.valueOf(paramTaskListRsp.myFuel.get()).toCharArray();
        int j = paramBaseRequest.length;
        int i = 0;
        while (i < j)
        {
          char c = paramBaseRequest[i];
          paramString = new ImageView(QCircleTaskCenterAdapter.d(this.a));
          paramString.setImageResource(QCircleTaskCenterAdapter.e(this.a)[java.lang.Character.getNumericValue(c)]);
          this.a.a.addView(paramString);
          i += 1;
        }
      }
      QCircleTaskCenterAdapter.a(this.a, paramTaskListRsp.taskEntranceUrl.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleTaskCenterAdapter.2
 * JD-Core Version:    0.7.0.1
 */