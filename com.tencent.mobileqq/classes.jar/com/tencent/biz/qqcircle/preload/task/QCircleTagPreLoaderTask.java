package com.tencent.biz.qqcircle.preload.task;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StTagInfo;

public class QCircleTagPreLoaderTask
  extends BasePreLoadTask
{
  private QCircleInitBean a;
  private boolean b;
  
  public QCircleTagPreLoaderTask(QCircleInitBean paramQCircleInitBean, boolean paramBoolean)
  {
    this.a = paramQCircleInitBean;
    this.b = paramBoolean;
  }
  
  public void onRemove() {}
  
  public void startLoadData(OnPreLoadListener paramOnPreLoadListener)
  {
    Object localObject = this.a;
    if ((localObject != null) && (((QCircleInitBean)localObject).getTagInfo() != null) && ((!TextUtils.isEmpty(this.a.getTagInfo().tagId.get())) || (!TextUtils.isEmpty(this.a.getTagInfo().tagName.get()))))
    {
      localObject = new QCircleGetFeedListRequest(this.a.getTagInfo().tagId.get(), this.a.getTagInfo().tagName.get(), this.b, null, null);
      paramOnPreLoadListener = new QCircleTagPreLoaderTask.1(this, paramOnPreLoadListener);
      if (this.b) {
        ((QCircleGetFeedListRequest)localObject).setEnableCache(false);
      } else {
        ((QCircleGetFeedListRequest)localObject).setEnableCache(true);
      }
      VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, paramOnPreLoadListener);
      paramOnPreLoadListener = new StringBuilder();
      paramOnPreLoadListener.append("QCircleTagPreLoaderTask->sendQCircleRequest: CmdName:");
      paramOnPreLoadListener.append(((QCircleGetFeedListRequest)localObject).getCmdName());
      paramOnPreLoadListener.append("| TraceId:");
      paramOnPreLoadListener.append(((QCircleGetFeedListRequest)localObject).getTraceId());
      paramOnPreLoadListener.append(" | SeqId:");
      paramOnPreLoadListener.append(((QCircleGetFeedListRequest)localObject).getCurrentSeq());
      QLog.d("QCircleTagPreLoaderTask", 1, paramOnPreLoadListener.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.preload.task.QCircleTagPreLoaderTask
 * JD-Core Version:    0.7.0.1
 */