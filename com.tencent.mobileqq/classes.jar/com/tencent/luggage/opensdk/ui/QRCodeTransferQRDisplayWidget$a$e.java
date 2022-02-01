package com.tencent.luggage.opensdk.ui;

import android.graphics.Color;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.wxa.ra.a;
import com.tencent.luggage.wxa.ra.b;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine$_stateScanned$1", "Lcom/tencent/mm/sdk/statemachine/State;", "enter", "", "processMessage", "", "msg", "Landroid/os/Message;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class QRCodeTransferQRDisplayWidget$a$e
  extends b
{
  public void a()
  {
    super.a();
    QRCodeTransferQRDisplayWidget.a(this.a.a, 2131442832);
    QRCodeTransferQRDisplayWidget.b(this.a.a).setImageResource(2130841147);
    QRCodeTransferQRDisplayWidget.c(this.a.a).setText(2131914180);
    QRCodeTransferQRDisplayWidget.c(this.a.a).setTextColor(Color.parseColor("#1AAD19"));
  }
  
  public boolean a(@Nullable Message paramMessage)
  {
    int i;
    if (paramMessage != null)
    {
      i = paramMessage.what;
    }
    else
    {
      QRCodeTransferQRDisplayWidget.d();
      i = 0;
    }
    if (i != 3)
    {
      if (i != 4) {
        return false;
      }
      paramMessage = this.a;
      QRCodeTransferQRDisplayWidget.a.a(paramMessage, (a)QRCodeTransferQRDisplayWidget.a.c(paramMessage));
    }
    else
    {
      paramMessage = this.a;
      QRCodeTransferQRDisplayWidget.a.a(paramMessage, (a)QRCodeTransferQRDisplayWidget.a.b(paramMessage));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.ui.QRCodeTransferQRDisplayWidget.a.e
 * JD-Core Version:    0.7.0.1
 */