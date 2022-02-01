package com.tencent.luggage.wxa.fq;

import com.tencent.ilinkservice.w;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxaapi/internal/XLogUploadLogic$mIlinkDeviceCallback$2$1", "Lcom/tencent/ilinkservice/IlinkDeviceCallback;", "onFinishGetStrategy", "", "onLoginComplete", "p0", "", "p1", "p2", "", "p3", "", "onNetStatusChanged", "onReceiveMessage", "p4", "onSendMsgResult", "onUploadLogComplete", "errorCode", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class t$b$1
  implements w
{
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(int paramInt1, int paramInt2, @Nullable byte[] paramArrayOfByte, @Nullable String paramString) {}
  
  public void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4, int paramInt) {}
  
  public void b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUploadLogComplete, code: ");
    ((StringBuilder)localObject).append(paramInt);
    o.d("XLogUploadLogic", ((StringBuilder)localObject).toString());
    localObject = t.a.c();
    if (localObject != null) {
      localObject = (Unit)((Function1)localObject).invoke(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.t.b.1
 * JD-Core Version:    0.7.0.1
 */