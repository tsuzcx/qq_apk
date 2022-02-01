package com.tencent.luggage.opensdk.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.ra.a;
import com.tencent.luggage.wxa.ra.b;
import com.tencent.luggage.wxa.ra.c;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine;", "Lcom/tencent/mm/sdk/statemachine/StateMachine;", "(Lcom/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget;)V", "_stateConnectError", "com/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine$_stateConnectError$1", "Lcom/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine$_stateConnectError$1;", "_stateExpired", "com/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine$_stateExpired$1", "Lcom/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine$_stateExpired$1;", "_stateLoaded", "com/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine$_stateLoaded$1", "Lcom/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine$_stateLoaded$1;", "_stateLoading", "com/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine$_stateLoading$1", "Lcom/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine$_stateLoading$1;", "_stateScanned", "com/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine$_stateScanned$1", "Lcom/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine$_stateScanned$1;", "unhandledMessage", "", "msg", "Landroid/os/Message;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class QRCodeTransferQRDisplayWidget$a
  extends c
{
  private final QRCodeTransferQRDisplayWidget.a.d b = new QRCodeTransferQRDisplayWidget.a.d(this);
  private final QRCodeTransferQRDisplayWidget.a.c c = new QRCodeTransferQRDisplayWidget.a.c(this);
  private final QRCodeTransferQRDisplayWidget.a.e d = new QRCodeTransferQRDisplayWidget.a.e(this);
  private final QRCodeTransferQRDisplayWidget.a.b e = new QRCodeTransferQRDisplayWidget.a.b(this);
  private final QRCodeTransferQRDisplayWidget.a.a f = new QRCodeTransferQRDisplayWidget.a.a(this);
  
  public QRCodeTransferQRDisplayWidget$a()
  {
    super("Luggage.WXA.Standalone.QRCodeTransferQRDisplayWidget", Looper.getMainLooper());
    a((b)this.b);
    a((b)this.c);
    a((b)this.d);
    a((b)this.e);
    a((b)this.f);
    b((b)this.b);
    c();
  }
  
  protected void a(@Nullable Message paramMessage)
  {
    super.a(paramMessage);
    if (paramMessage != null)
    {
      int i = paramMessage.what;
      QRCodeTransferQRDisplayWidget.d();
      if (i == 10000) {
        a((a)this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.ui.QRCodeTransferQRDisplayWidget.a
 * JD-Core Version:    0.7.0.1
 */