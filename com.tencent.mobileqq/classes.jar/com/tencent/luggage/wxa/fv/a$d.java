package com.tencent.luggage.wxa.fv;

import com.tencent.ilinkservice.w;
import com.tencent.luggage.wxa.dg.b.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/tdi/DemoILinkActivateDevice$loginIlink$5$1", "Lcom/tencent/ilinkservice/IlinkDeviceCallback;", "onFinishGetStrategy", "", "onLoginComplete", "errCode", "", "detailRet", "profile", "", "token", "", "onNetStatusChanged", "code", "onReceiveMessage", "fromIlinkId", "fromNickname", "fromHeadImageUrl", "content", "mediatype", "onSendMsgResult", "error", "taskid", "onUploadLogComplete", "p0", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$d
  implements w
{
  a$d(long paramLong, b.a parama, d paramd) {}
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, @Nullable byte[] paramArrayOfByte, @Nullable String arg4)
  {
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("loginIlink() device onLoginComplete(");
    paramArrayOfByte.append(paramInt1);
    paramArrayOfByte.append(", ");
    paramArrayOfByte.append(paramInt2);
    paramArrayOfByte.append("), cost:");
    paramArrayOfByte.append(af.b() - this.a);
    paramArrayOfByte.append("ms");
    o.d("DemoILinkActivateDevice", paramArrayOfByte.toString());
    paramArrayOfByte = this.b;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.a(this.c.a(), this.c.b(), this.c.c(), this.c.b(), this.c.d(), "");
    }
    paramArrayOfByte = new ConcurrentLinkedQueue();
    synchronized (a.c)
    {
      a.a(a.c, 2);
      paramArrayOfByte.addAll((Collection)a.a(a.c));
      while (!paramArrayOfByte.isEmpty())
      {
        ??? = (b.a)paramArrayOfByte.poll();
        if (??? != null) {
          ???.a(this.c.a(), this.c.b(), this.c.c(), this.c.b(), this.c.d(), "");
        }
      }
      return;
    }
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, int paramInt) {}
  
  public void b(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fv.a.d
 * JD-Core Version:    0.7.0.1
 */