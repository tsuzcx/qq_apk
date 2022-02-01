package com.tencent.android.gldrawable.api.impl;

import android.content.Context;
import android.widget.Toast;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class LoaderUtilsImpl$showTestToast$1
  implements Runnable
{
  LoaderUtilsImpl$showTestToast$1(Context paramContext, String paramString) {}
  
  public final void run()
  {
    Toast.makeText(this.$context, (CharSequence)this.$toast, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.impl.LoaderUtilsImpl.showTestToast.1
 * JD-Core Version:    0.7.0.1
 */