package com.tencent.luggage.opensdk.ui;

import android.graphics.Bitmap;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.luggage.wxa.ra.a;
import com.tencent.luggage.wxa.ra.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine$_stateLoaded$1", "Lcom/tencent/mm/sdk/statemachine/State;", "enter", "", "exit", "processMessage", "", "msg", "Landroid/os/Message;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class QRCodeTransferQRDisplayWidget$a$c
  extends b
{
  public void a()
  {
    super.a();
    Object localObject2 = QRCodeTransferQRDisplayWidget.a.d(this.a).obj;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof Bitmap)) {
      localObject1 = null;
    }
    localObject1 = (Bitmap)localObject1;
    if (localObject1 != null)
    {
      localObject2 = QRCodeTransferQRDisplayWidget.a(this.a.a);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "mQRImage");
      ((ImageView)localObject2).setVisibility(0);
      QRCodeTransferQRDisplayWidget.a(this.a.a).setImageBitmap((Bitmap)localObject1);
      return;
    }
    localObject1 = (Unit)((Function0)new QRCodeTransferQRDisplayWidget.a.c.a(this)).invoke();
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
    if (i != 2)
    {
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
    }
    else
    {
      paramMessage = this.a;
      QRCodeTransferQRDisplayWidget.a.a(paramMessage, (a)QRCodeTransferQRDisplayWidget.a.e(paramMessage));
    }
    return true;
  }
  
  public void b()
  {
    super.b();
    QRCodeTransferQRDisplayWidget.a(this.a.a).setImageBitmap(null);
    ImageView localImageView = QRCodeTransferQRDisplayWidget.a(this.a.a);
    Intrinsics.checkExpressionValueIsNotNull(localImageView, "mQRImage");
    localImageView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.ui.QRCodeTransferQRDisplayWidget.a.c
 * JD-Core Version:    0.7.0.1
 */