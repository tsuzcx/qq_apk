package com.tencent.luggage.wxa.pq;

import android.widget.EditText;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pp.ac;
import com.tencent.luggage.wxa.pw.a.a;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;

public final class d
{
  public static <Input extends EditText,  extends ac> void a(@NonNull u paramu, @NonNull Input paramInput, @NonNull a.a parama)
  {
    ac localac = (ac)paramInput;
    if (!localac.d()) {
      return;
    }
    paramu = new WeakReference(paramu);
    paramu = new d.1(new WeakReference(paramInput), paramu);
    paramInput = localac.getAutoFillController();
    paramInput.a(parama.d);
    paramInput.a(paramu);
    if ("screen".equalsIgnoreCase(parama.c)) {
      paramu = g.a;
    } else {
      paramu = g.b;
    }
    paramInput.a(paramu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.d
 * JD-Core Version:    0.7.0.1
 */