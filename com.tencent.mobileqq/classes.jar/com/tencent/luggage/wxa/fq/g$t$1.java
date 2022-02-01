package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxaapi.UploadLogResultCode;
import com.tencent.luggage.wxaapi.UploadLogResultListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class g$t$1
  implements Runnable
{
  g$t$1(g.t paramt, int paramInt) {}
  
  public final void run()
  {
    UploadLogResultListener localUploadLogResultListener = this.a.a;
    if (localUploadLogResultListener != null)
    {
      int i = this.b;
      UploadLogResultCode localUploadLogResultCode;
      if (i == t.a.a()) {
        localUploadLogResultCode = UploadLogResultCode.OK;
      } else if (i == t.a.b()) {
        localUploadLogResultCode = UploadLogResultCode.FailNetworkType;
      } else {
        localUploadLogResultCode = UploadLogResultCode.Fail;
      }
      localUploadLogResultListener.onResult(localUploadLogResultCode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.t.1
 * JD-Core Version:    0.7.0.1
 */