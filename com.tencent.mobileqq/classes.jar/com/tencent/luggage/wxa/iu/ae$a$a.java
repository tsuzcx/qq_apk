package com.tencent.luggage.wxa.iu;

import android.os.Parcelable;
import com.tencent.luggage.wxa.hj.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ae$a$a
  implements Runnable
{
  ae$a$a(String paramString, int paramInt) {}
  
  public final void run()
  {
    try
    {
      h.a(r.i(), (Parcelable)new u(this.a, this.b), ae.a.a.1.a.getClass());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PreRenderedRuntimeStore.remove appId:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", ipc notify get exception ");
      localStringBuilder.append(localException);
      o.b("Luggage.WxaPreRenderColdStartService", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.ae.a.a
 * JD-Core Version:    0.7.0.1
 */