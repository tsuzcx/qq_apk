import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class aqei
  implements INetEngine.INetEngineListener
{
  aqei(aqeh paramaqeh) {}
  
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
        synchronized (aqeh.a(this.a))
        {
          if (aqeh.a(this.a).isEmpty()) {
            break;
          }
          Iterator localIterator = aqeh.a(this.a).iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject3 = (WeakReference)localIterator.next();
          if ((localObject3 == null) || (((WeakReference)localObject3).get() == null)) {
            continue;
          }
          localObject3 = (aqej)((WeakReference)localObject3).get();
          if (i == 0)
          {
            bool = true;
            ((aqej)localObject3).a((String)localObject1, bool, false);
          }
        }
        bool = false;
      }
      aqeh.a(this.a).remove(localObject2);
    } while ((!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) || (NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())));
    aqeh.a(this.a);
  }
  
  public void onUpdateProgeress(NetReq arg1, long paramLong1, long paramLong2)
  {
    if ((!aqeh.a(this.a).isEmpty()) && ((??? instanceof HttpNetReq))) {
      if (paramLong2 <= 0L) {
        break label148;
      }
    }
    label148:
    for (int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);; i = 0)
    {
      String str = ((HttpNetReq)???).mReqUrl;
      synchronized (aqeh.a(this.a))
      {
        if (!aqeh.a(this.a).isEmpty())
        {
          Iterator localIterator = aqeh.a(this.a).iterator();
          while (localIterator.hasNext())
          {
            WeakReference localWeakReference = (WeakReference)localIterator.next();
            if ((localWeakReference != null) && (localWeakReference.get() != null)) {
              ((aqej)localWeakReference.get()).a(str, i);
            }
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqei
 * JD-Core Version:    0.7.0.1
 */