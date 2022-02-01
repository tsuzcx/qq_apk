package com.tencent.biz.qqcircle.bizparts.danmaku;

import com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QCircleDanmakuSmartView$DoLikeRequestCallback
  implements VSDispatchObserver.onVSRspCallBack
{
  private WeakReference<QCircleDanmakuSmartView> a;
  private WeakReference<AbsDanmaku> b;
  private QCircleDanmakuSmartView.LikeRequestParam c = null;
  
  public QCircleDanmakuSmartView$DoLikeRequestCallback(QCircleDanmakuSmartView paramQCircleDanmakuSmartView, AbsDanmaku paramAbsDanmaku, QCircleDanmakuSmartView.LikeRequestParam paramLikeRequestParam)
  {
    this.a = new WeakReference(paramQCircleDanmakuSmartView);
    this.b = new WeakReference(paramAbsDanmaku);
    this.c = paramLikeRequestParam;
  }
  
  public void onReceive(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, Object paramObject)
  {
    paramObject = this.a;
    Object localObject = null;
    if (paramObject == null) {
      paramObject = null;
    } else {
      paramObject = (QCircleDanmakuSmartView)paramObject.get();
    }
    if (paramObject == null)
    {
      QLog.d("Refactor-QCircleDanmakuSmartView", 2, new Object[] { "onReceive container == null, trace id:", paramBaseRequest.getTraceId() });
      return;
    }
    QLog.d("Refactor-QCircleDanmakuSmartView", 2, new Object[] { "onReceive trace id:", paramBaseRequest.getTraceId(), " | retCode: ", Long.valueOf(paramLong), " | errMsg: ", paramString });
    if ((paramBoolean) && (paramLong == 0L))
    {
      paramString = this.b;
      paramBaseRequest = localObject;
      if (paramString != null)
      {
        paramBaseRequest = localObject;
        if (paramString.get() != null) {
          paramBaseRequest = (AbsDanmaku)this.b.get();
        }
      }
      QCircleDanmakuSmartView.a(paramObject, paramBaseRequest, this.c);
      return;
    }
    QCircleToastUtil.a(paramLong, paramString, 0);
    QLog.d("Refactor-QCircleDanmakuSmartView", 4, "zan failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.QCircleDanmakuSmartView.DoLikeRequestCallback
 * JD-Core Version:    0.7.0.1
 */