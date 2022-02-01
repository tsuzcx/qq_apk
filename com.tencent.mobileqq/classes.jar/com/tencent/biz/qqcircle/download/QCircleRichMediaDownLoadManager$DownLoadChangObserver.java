package com.tencent.biz.qqcircle.download;

import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.NetworkChangedObserver;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostHttpUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import java.lang.ref.WeakReference;

public class QCircleRichMediaDownLoadManager$DownLoadChangObserver
  implements HostStaticInvokeHelper.NetworkChangedObserver
{
  private WeakReference<QCircleRichMediaDownLoadManager.DownLoadParams> a;
  private WeakReference<HttpNetReq> b;
  
  public QCircleRichMediaDownLoadManager$DownLoadChangObserver(QCircleRichMediaDownLoadManager.DownLoadParams paramDownLoadParams, HttpNetReq paramHttpNetReq)
  {
    this.a = new WeakReference(paramDownLoadParams);
    this.b = new WeakReference(paramHttpNetReq);
  }
  
  public void onNetworkChanged()
  {
    if (!HostNetworkUtils.isNetworkAvailable())
    {
      Object localObject = this.a;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        localObject = (QCircleRichMediaDownLoadManager.DownLoadParams)this.a.get();
        if ((localObject != null) && (QCircleRichMediaDownLoadManager.DownLoadParams.a((QCircleRichMediaDownLoadManager.DownLoadParams)localObject) != null))
        {
          QCircleRichMediaDownLoadManager.DownLoadParams.a((QCircleRichMediaDownLoadManager.DownLoadParams)localObject).a(false);
          HostFileUtils.delete(((QCircleRichMediaDownLoadManager.DownLoadParams)localObject).c(), true);
        }
      }
      localObject = this.b;
      if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
        HostHttpUtils.cancel((NetReq)this.b.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.DownLoadChangObserver
 * JD-Core Version:    0.7.0.1
 */