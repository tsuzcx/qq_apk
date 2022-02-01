package com.tencent.luggage.wxa.lk;

import android.content.Intent;
import android.nfc.Tag;
import com.tencent.luggage.wxa.qz.o;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "intent", "Landroid/content/Intent;", "invoke"}, k=3, mv={1, 1, 16})
final class c$c
  extends Lambda
  implements Function1<Intent, Boolean>
{
  c$c(c paramc)
  {
    super(1);
  }
  
  public final boolean a(@NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onNewIntent, intent: ");
    ((StringBuilder)localObject).append(paramIntent);
    o.d("MicroMsg.AppBrand.NFCReadWriteManager", ((StringBuilder)localObject).toString());
    localObject = paramIntent.getAction();
    if (localObject != null)
    {
      int i = ((String)localObject).hashCode();
      if (i != -1634370981 ? (i == -1468892125) && (((String)localObject).equals("android.nfc.action.TAG_DISCOVERED")) : ((String)localObject).equals("android.nfc.action.TECH_DISCOVERED"))
      {
        o.e("MicroMsg.AppBrand.NFCReadWriteManager", "onNewIntent, tech/tag discovered");
        c.h(this.a).clear();
        c.a(this.a, (Tag)paramIntent.getParcelableExtra("android.nfc.extra.TAG"));
        this.a.a(paramIntent);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c.c
 * JD-Core Version:    0.7.0.1
 */