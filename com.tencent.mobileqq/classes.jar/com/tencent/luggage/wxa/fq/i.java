package com.tencent.luggage.wxa.fq;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"makeBundle", "Landroid/os/Bundle;", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "luggage-standalone-open-runtime-sdk_release"}, k=2, mv={1, 1, 16})
public final class i
{
  private static final Bundle b(@NotNull BaseResp paramBaseResp)
  {
    Bundle localBundle = new Bundle();
    paramBaseResp.toBundle(localBundle);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.i
 * JD-Core Version:    0.7.0.1
 */