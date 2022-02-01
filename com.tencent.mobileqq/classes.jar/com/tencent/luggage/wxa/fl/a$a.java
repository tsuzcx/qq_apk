package com.tencent.luggage.wxa.fl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/test_kit/DebuggerBroadcastAction$DebuggerBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$a
  extends BroadcastReceiver
{
  public static final a.a.a a = new a.a.a(null);
  @NotNull
  private static final a b = new a();
  
  public void onReceive(@Nullable Context paramContext, @Nullable Intent paramIntent)
  {
    if (paramIntent != null) {
      paramContext = paramIntent.getAction();
    } else {
      paramContext = null;
    }
    if (Intrinsics.areEqual("com.tencent.wmpf.dev.testkit.DebuggerBroadcastReceiver.ACTION", paramContext))
    {
      paramContext = paramIntent.getStringExtra("kAction");
      Object localObject1 = paramIntent.getStringExtra("kContent");
      Object localObject2 = (CharSequence)localObject1;
      int i;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        return;
      }
      localObject1 = Base64.decode((String)localObject1, 0);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "Base64.decode(rawXml, Base64.DEFAULT)");
      localObject1 = new String((byte[])localObject1, Charsets.UTF_8);
      Object localObject3 = (Iterable)a.b.a();
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = ((Iterator)localObject3).next();
        if (Intrinsics.areEqual(((a)localObject4).a(), paramContext)) {
          ((Collection)localObject2).add(localObject4);
        }
      }
      paramContext = ((Iterable)localObject2).iterator();
      while (paramContext.hasNext()) {
        ((a)paramContext.next()).a(paramIntent, (String)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fl.a.a
 * JD-Core Version:    0.7.0.1
 */