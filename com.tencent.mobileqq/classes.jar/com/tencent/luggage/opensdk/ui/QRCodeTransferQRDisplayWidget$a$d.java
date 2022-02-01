package com.tencent.luggage.opensdk.ui;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.widget.ProgressBar;
import com.tencent.luggage.wxa.ra.a;
import com.tencent.luggage.wxa.ra.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/opensdk/ui/QRCodeTransferQRDisplayWidget$DisplayStateMachine$_stateLoading$1", "Lcom/tencent/mm/sdk/statemachine/State;", "mIndicator", "Landroid/widget/ProgressBar;", "getMIndicator", "()Landroid/widget/ProgressBar;", "mIndicator$delegate", "Lkotlin/Lazy;", "enter", "", "exit", "processMessage", "", "msg", "Landroid/os/Message;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class QRCodeTransferQRDisplayWidget$a$d
  extends b
{
  private final Lazy b = LazyKt.lazy((Function0)new QRCodeTransferQRDisplayWidget.a.d.a(this));
  
  private final ProgressBar d()
  {
    return (ProgressBar)this.b.getValue();
  }
  
  public void a()
  {
    super.a();
    QRCodeTransferQRDisplayWidget.a(this.a.a, 2131442833);
    d().setVisibility(0);
    Drawable localDrawable = d().getProgressDrawable();
    Object localObject = localDrawable;
    if (!(localDrawable instanceof Animatable)) {
      localObject = null;
    }
    localObject = (Animatable)localObject;
    if (localObject != null) {
      ((Animatable)localObject).start();
    }
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
    if (i != 1)
    {
      if (i != 10000)
      {
        if (i != 3)
        {
          if (i != 4) {
            return false;
          }
          paramMessage = this.a;
          QRCodeTransferQRDisplayWidget.a.a(paramMessage, (a)QRCodeTransferQRDisplayWidget.a.c(paramMessage));
          return true;
        }
        paramMessage = this.a;
        QRCodeTransferQRDisplayWidget.a.a(paramMessage, (a)QRCodeTransferQRDisplayWidget.a.b(paramMessage));
        return true;
      }
    }
    else
    {
      paramMessage = this.a;
      QRCodeTransferQRDisplayWidget.a.a(paramMessage, (a)QRCodeTransferQRDisplayWidget.a.a(paramMessage));
    }
    return true;
  }
  
  public void b()
  {
    super.b();
    d().setVisibility(8);
    Drawable localDrawable = d().getProgressDrawable();
    Object localObject = localDrawable;
    if (!(localDrawable instanceof Animatable)) {
      localObject = null;
    }
    localObject = (Animatable)localObject;
    if (localObject != null) {
      ((Animatable)localObject).stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.ui.QRCodeTransferQRDisplayWidget.a.d
 * JD-Core Version:    0.7.0.1
 */