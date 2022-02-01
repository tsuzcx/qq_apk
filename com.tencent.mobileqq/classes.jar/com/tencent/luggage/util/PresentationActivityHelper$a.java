package com.tencent.luggage.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.wxa.hj.e;
import com.tencent.luggage.wxa.hp.f;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.t;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.Reflect;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/util/PresentationActivityHelper$Companion;", "", "()V", "TAG", "", "setResult", "", "resultCode", "", "source", "Landroid/content/Intent;", "data", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class PresentationActivityHelper$a
{
  @JvmStatic
  public final void a(int paramInt, @NotNull Intent paramIntent1, @Nullable Intent paramIntent2)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent1, "source");
    if (!t.a())
    {
      t.a((Runnable)new PresentationActivityHelper.a.a(paramInt, paramIntent1, paramIntent2));
      return;
    }
    Object localObject1 = paramIntent1.getStringExtra("Luggage.LuggageActivityHelperproc_name");
    if (!af.c((String)localObject1))
    {
      int i = paramIntent1.getIntExtra("Luggage.LuggageActivityHelperinstance_id", 0);
      int j = paramIntent1.getIntExtra("Luggage.LuggageActivityHelperreq_code", 0);
      Object localObject2 = r.c();
      if (Intrinsics.areEqual(localObject2, localObject1))
      {
        localObject2 = LuggageActivityHelper.sHelpers.keySet().iterator();
        localObject1 = (Activity)null;
        do
        {
          paramIntent1 = (Intent)localObject1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramIntent1 = ((LuggageActivityHelper.ActivityHelperKey)((Iterator)localObject2).next()).getActivity();
        } while (paramIntent1.hashCode() != i);
        if (paramIntent1 != null)
        {
          Reflect.on(paramIntent1).call("onActivityResult", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), paramIntent2 });
          paramIntent1 = (LuggageActivityHelper)LuggageActivityHelper.sHelpers.get(LuggageActivityHelper.genActivityHelperKey(PresentationActivityHelper.class, paramIntent1));
          if (paramIntent1 != null) {
            paramIntent1.onActivityResult(j, paramInt, paramIntent2);
          }
        }
      }
      else
      {
        o.d("WMPF.WMPFActivityHelper", "setResult: [%s] -> [%s]", new Object[] { localObject2, localObject1 });
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("resultCode", paramInt);
        ((Bundle)localObject2).putParcelable("from", (Parcelable)paramIntent1);
        ((Bundle)localObject2).putParcelable("data", (Parcelable)paramIntent2);
        f.a((String)localObject1, localObject2, PresentationActivityHelper.b.class, (e)PresentationActivityHelper.a.b.a);
      }
      return;
    }
    paramIntent1 = (Throwable)new NullPointerException("proc name is null");
    for (;;)
    {
      throw paramIntent1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.PresentationActivityHelper.a
 * JD-Core Version:    0.7.0.1
 */