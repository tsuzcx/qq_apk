package com.tencent.luggage.opensdk;

import android.app.Dialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class h$a
  implements Runnable
{
  h$a(h paramh) {}
  
  public final void run()
  {
    if (!h.a(this.a))
    {
      h localh = this.a;
      Dialog localDialog = (Dialog)h.b(localh).invoke();
      localDialog.show();
      h.a(localh, localDialog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.h.a
 * JD-Core Version:    0.7.0.1
 */