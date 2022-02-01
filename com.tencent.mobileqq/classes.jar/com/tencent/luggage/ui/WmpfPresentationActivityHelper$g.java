package com.tencent.luggage.ui;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.wxa.hj.h;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class WmpfPresentationActivityHelper$g
  extends Lambda
  implements Function0<Unit>
{
  WmpfPresentationActivityHelper$g(Bundle paramBundle)
  {
    super(0);
  }
  
  public final void a()
  {
    h.a(r.i(), (Parcelable)this.a, WmpfPresentationActivityHelper.IPCOperatePresentationStack.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WmpfPresentationActivityHelper.g
 * JD-Core Version:    0.7.0.1
 */