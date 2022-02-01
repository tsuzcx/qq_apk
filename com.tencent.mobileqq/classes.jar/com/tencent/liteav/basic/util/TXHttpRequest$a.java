package com.tencent.liteav.basic.util;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.util.Map;

class TXHttpRequest$a
  extends AsyncTask<byte[], Void, TXHttpRequest.b>
{
  private WeakReference<TXHttpRequest> a;
  private Handler b = null;
  private Map<String, String> c;
  
  public TXHttpRequest$a(TXHttpRequest paramTXHttpRequest, Map<String, String> paramMap)
  {
    this.c = paramMap;
    this.a = new WeakReference(paramTXHttpRequest);
    paramTXHttpRequest = Looper.myLooper();
    if (paramTXHttpRequest != null)
    {
      this.b = new Handler(paramTXHttpRequest);
      return;
    }
    this.b = null;
  }
  
  protected TXHttpRequest.b a(byte[]... paramVarArgs)
  {
    TXHttpRequest.b localb = new TXHttpRequest.b();
    try
    {
      if (new String(paramVarArgs[0]).startsWith("https")) {
        localb.c = TXHttpRequest.getHttpsPostRsp(this.c, new String(paramVarArgs[0]), paramVarArgs[1]);
      } else {
        localb.c = TXHttpRequest.getHttpPostRsp(this.c, new String(paramVarArgs[0]), paramVarArgs[1]);
      }
      localb.a = 0;
    }
    catch (Exception paramVarArgs)
    {
      localb.b = paramVarArgs.toString();
      localb.a = 1;
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("TXPostRequest->result: ");
    paramVarArgs.append(localb.a);
    paramVarArgs.append("|");
    paramVarArgs.append(localb.b);
    TXCLog.i("TXHttpRequest", paramVarArgs.toString());
    return localb;
  }
  
  protected void a(TXHttpRequest.b paramb)
  {
    super.onPostExecute(paramb);
    TXHttpRequest localTXHttpRequest = (TXHttpRequest)this.a.get();
    if ((localTXHttpRequest != null) && (TXHttpRequest.access$000(localTXHttpRequest) != 0L))
    {
      Object localObject = this.b;
      if (localObject != null)
      {
        ((Handler)localObject).post(new TXHttpRequest.a.1(this, paramb, localTXHttpRequest));
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TXPostRequest->recvMsg: ");
      ((StringBuilder)localObject).append(paramb.a);
      ((StringBuilder)localObject).append("|");
      ((StringBuilder)localObject).append(paramb.b);
      TXCLog.i("TXHttpRequest", ((StringBuilder)localObject).toString());
      TXHttpRequest.access$100(localTXHttpRequest, TXHttpRequest.access$000(localTXHttpRequest), paramb.a, paramb.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXHttpRequest.a
 * JD-Core Version:    0.7.0.1
 */