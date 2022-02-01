package com.tencent.biz.qcircleshadow.lib.listener;

import biyn;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import java.lang.ref.WeakReference;

public class QCircleWXShareListenerProxy
  implements biyn
{
  private WeakReference<QCircleWXShareListener> mWRFListener;
  
  public QCircleWXShareListenerProxy(QCircleWXShareListener paramQCircleWXShareListener)
  {
    this.mWRFListener = new WeakReference(paramQCircleWXShareListener);
  }
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    QCircleWXShareListener localQCircleWXShareListener = (QCircleWXShareListener)this.mWRFListener.get();
    if (localQCircleWXShareListener != null) {
      localQCircleWXShareListener.onWXShareResp(paramBaseResp.errCode, paramBaseResp.errStr, paramBaseResp.transaction);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.listener.QCircleWXShareListenerProxy
 * JD-Core Version:    0.7.0.1
 */