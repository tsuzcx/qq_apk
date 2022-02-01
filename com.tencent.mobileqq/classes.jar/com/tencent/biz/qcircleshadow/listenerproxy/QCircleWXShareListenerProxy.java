package com.tencent.biz.qcircleshadow.listenerproxy;

import com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListener;
import com.tencent.mobileqq.wxapi.data.WXShareRsp;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;
import java.lang.ref.WeakReference;

public class QCircleWXShareListenerProxy
  implements IWXShareHelperListener
{
  private WeakReference<QCircleWXShareListener> a;
  
  public QCircleWXShareListenerProxy(QCircleWXShareListener paramQCircleWXShareListener)
  {
    this.a = new WeakReference(paramQCircleWXShareListener);
  }
  
  public void onWXShareResp(WXShareRsp paramWXShareRsp)
  {
    QCircleWXShareListener localQCircleWXShareListener = (QCircleWXShareListener)this.a.get();
    if (localQCircleWXShareListener != null) {
      localQCircleWXShareListener.onWXShareResp(paramWXShareRsp.errCode, paramWXShareRsp.errStr, paramWXShareRsp.transaction);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.listenerproxy.QCircleWXShareListenerProxy
 * JD-Core Version:    0.7.0.1
 */