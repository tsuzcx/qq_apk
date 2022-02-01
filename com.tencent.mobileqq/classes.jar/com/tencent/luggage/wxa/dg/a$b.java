package com.tencent.luggage.wxa.dg;

import com.tencent.ilink.tdi.b.a;
import com.tencent.ilink.tdi.b.d;
import com.tencent.ilink.tdi.b.g;
import com.tencent.ilink.tdi.b.j;
import com.tencent.ilink.tdi.b.l;
import com.tencent.ilink.tdi.b.n;
import com.tencent.ilink.tdi.b.p;
import com.tencent.ilink.tdi.b.r;
import com.tencent.ilink.tdi.b.v;
import com.tencent.ilinkservice.ag.c;
import com.tencent.ilinkservice.at;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/device/BaseActivateDevice$tdiSessionCallbackDispatcher$1", "Lcom/tencent/ilinkservice/TdiSessionCallback;", "onAppSessionTimeout", "", "onCancelOAuthComplete", "p0", "", "p1", "onCheckLoginQrCodeComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiCheckLoginQrCodeResponse;", "onFaceExtVerifyComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiFaceExtVerifyResponse;", "onFaceRecognizeComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiFaceRecognizeResponse;", "onFaceRecognizeConfigComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiFaceRecognizeConfigResponse;", "onGetAppPushTokenComplete", "p2", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppPushToken;", "onGetLoginQrCodeComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiGetLoginQrCodeResponse;", "onGetOAuthCodeComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiGetOAuthCodeResponse;", "onLoginComplete", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiLoginResponse;", "onLogoutComplete", "errCode", "onReceiveAppMessage", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppMessage;", "onReceiveAppResponse", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppResponse;", "onReceiveMultiProcessCloneTicket", "", "onRequestUploadLogfiles", "Lcom/tencent/ilinkservice/IlinkServiceProto$IlinkPullLogCmd;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class a$b
  implements at
{
  public void a()
  {
    a.b();
    o.d("Luggage.BaseActivateDevice", "onAppSessionTimeout");
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a();
    }
  }
  
  public void a(int paramInt)
  {
    a.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLogoutComplete errCode:");
    ((StringBuilder)localObject).append(paramInt);
    o.d("Luggage.BaseActivateDevice", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(paramInt);
    }
    this.a.g();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable com.tencent.ilink.tdi.b.b paramb)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(paramInt1, paramInt2, paramb);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable b.d paramd)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(paramInt1, paramInt2, paramd);
    }
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable b.r paramr)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(paramInt1, paramInt2, paramr);
    }
  }
  
  public void a(int paramInt, @Nullable b.g paramg)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(paramInt, paramg);
    }
  }
  
  public void a(int paramInt, @Nullable b.j paramj)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(paramInt, paramj);
    }
  }
  
  public void a(int paramInt, @Nullable b.l paraml)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(paramInt, paraml);
    }
  }
  
  public void a(int paramInt, @Nullable b.n paramn)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(paramInt, paramn);
    }
  }
  
  public void a(int paramInt, @Nullable b.p paramp)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(paramInt, paramp);
    }
  }
  
  public void a(int paramInt, @Nullable b.v paramv)
  {
    a.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onLogicComplete errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", ");
    o.d("Luggage.BaseActivateDevice", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(paramInt, paramv);
    }
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(paramInt, paramString);
    }
  }
  
  public void a(@Nullable b.a parama)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(parama);
    }
  }
  
  public void a(@Nullable ag.c paramc)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)a.a(this.a));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b.b)((Iterator)localObject).next()).a(paramc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dg.a.b
 * JD-Core Version:    0.7.0.1
 */