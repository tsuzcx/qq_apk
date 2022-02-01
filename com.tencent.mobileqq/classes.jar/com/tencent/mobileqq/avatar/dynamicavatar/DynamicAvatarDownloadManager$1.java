package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class DynamicAvatarDownloadManager$1
  implements INetEngineListener
{
  DynamicAvatarDownloadManager$1(DynamicAvatarDownloadManager paramDynamicAvatarDownloadManager) {}
  
  public void onResp(NetResp arg1)
  {
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onResp reqUrl: resp is null: ");
      if (??? == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)localObject1).toString());
    }
    if (??? == null) {
      return;
    }
    Object localObject1 = ((HttpNetReq)???.mReq).mReqUrl;
    int i = ???.mResult;
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onResp reqUrl: ");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(" mResult: ");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(",httpCode:");
      ((StringBuilder)localObject3).append(???.mHttpCode);
      ((StringBuilder)localObject3).append(",errDesc:");
      ((StringBuilder)localObject3).append(???.mErrDesc);
      QLog.i("Q.dynamicAvatar", 2, ((StringBuilder)localObject3).toString());
    }
    label324:
    synchronized (DynamicAvatarDownloadManager.a(this.a))
    {
      if (!DynamicAvatarDownloadManager.a(this.a).isEmpty())
      {
        localObject3 = DynamicAvatarDownloadManager.a(this.a).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (WeakReference)((Iterator)localObject3).next();
          if ((localObject4 != null) && (((WeakReference)localObject4).get() != null))
          {
            localObject4 = (DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback)((WeakReference)localObject4).get();
            if (i != 0) {
              break label324;
            }
            bool = true;
            ((DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback)localObject4).a((String)localObject1, bool, false);
          }
        }
      }
      DynamicAvatarDownloadManager.b(this.a).remove(localObject1);
      if ((NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) && (!NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext()))) {
        DynamicAvatarDownloadManager.c(this.a);
      }
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    if ((!DynamicAvatarDownloadManager.a(this.a).isEmpty()) && ((??? instanceof HttpNetReq)))
    {
      int i = 0;
      if (paramLong2 > 0L) {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
      String str = ((HttpNetReq)???).mReqUrl;
      synchronized (DynamicAvatarDownloadManager.a(this.a))
      {
        if (!DynamicAvatarDownloadManager.a(this.a).isEmpty())
        {
          Iterator localIterator = DynamicAvatarDownloadManager.a(this.a).iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback)localWeakReference.get()).a(str, i);
            }
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */