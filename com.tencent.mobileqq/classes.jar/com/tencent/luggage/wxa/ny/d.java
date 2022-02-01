package com.tencent.luggage.wxa.ny;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.a;

public final class d
  implements DialogInterface
{
  @Nullable
  private Function<Context, i.a> a;
  private v b;
  private i.a c;
  private DialogInterface.OnCancelListener d;
  private boolean e = false;
  private boolean f = false;
  
  public d a(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.d = paramOnCancelListener;
    paramOnCancelListener = this.c;
    if (paramOnCancelListener != null) {
      paramOnCancelListener.setOnCancelListener(this.d);
    }
    return this;
  }
  
  public void a(@Nullable Function<Context, i.a> paramFunction)
  {
    this.a = paramFunction;
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.iu.d paramd)
  {
    if (!t.a())
    {
      t.a(new d.1(this, paramd));
      return;
    }
    this.b = new v(Looper.getMainLooper(), new d.2(this, paramd), false);
    this.b.a(500L);
  }
  
  public void cancel()
  {
    this.e = true;
    Object localObject = this.c;
    if (localObject != null)
    {
      ((i.a)localObject).cancel();
      return;
    }
    localObject = this.d;
    if (localObject != null) {
      ((DialogInterface.OnCancelListener)localObject).onCancel(this);
    }
  }
  
  public void dismiss()
  {
    this.f = true;
    i.a locala = this.c;
    if (locala != null) {
      locala.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ny.d
 * JD-Core Version:    0.7.0.1
 */