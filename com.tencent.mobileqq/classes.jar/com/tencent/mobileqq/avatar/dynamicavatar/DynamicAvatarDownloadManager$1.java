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
    Object localObject1;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("onResp reqUrl: resp is null: ");
      if (??? == null)
      {
        bool = true;
        QLog.i("Q.dynamicAvatar", 2, bool);
      }
    }
    else
    {
      if (??? != null) {
        break label51;
      }
    }
    label51:
    do
    {
      return;
      bool = false;
      break;
      localObject1 = ((HttpNetReq)???.mReq).mReqUrl;
      int i = ???.mResult;
      if (QLog.isColorLevel()) {
        QLog.i("Q.dynamicAvatar", 2, "onResp reqUrl: " + (String)localObject1 + " mResult: " + i + ",httpCode:" + ???.mHttpCode + ",errDesc:" + ???.mErrDesc);
      }
      for (;;)
      {
        synchronized (DynamicAvatarDownloadManager.a(this.a))
        {
          if (DynamicAvatarDownloadManager.a(this.a).isEmpty()) {
            break;
          }
          Iterator localIterator = DynamicAvatarDownloadManager.a(this.a).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject3 = (WeakReference)localIterator.next();
          if ((localObject3 == null) || (((WeakReference)localObject3).get() == null)) {
            continue;
          }
          localObject3 = (DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback)((WeakReference)localObject3).get();
          if (i == 0)
          {
            bool = true;
            ((DynamicAvatarDownloadManager.IDynamicAvatarDownloadCallback)localObject3).a((String)localObject1, bool, false);
          }
        }
        bool = false;
      }
      DynamicAvatarDownloadManager.a(this.a).remove(localObject2);
    } while ((!NetworkUtil.g(BaseApplicationImpl.getContext())) || (NetworkUtil.h(BaseApplicationImpl.getContext())));
    DynamicAvatarDownloadManager.a(this.a);
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    if ((!DynamicAvatarDownloadManager.a(this.a).isEmpty()) && ((??? instanceof HttpNetReq))) {
      if (paramLong2 <= 0L) {
        break label148;
      }
    }
    label148:
    for (int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);; i = 0)
    {
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
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */