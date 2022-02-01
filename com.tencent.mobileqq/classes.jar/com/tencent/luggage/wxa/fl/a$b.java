package com.tencent.luggage.wxa.fl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/test_kit/DebuggerBroadcastAction$Registry;", "", "()V", "KEY_CONTENT", "", "TAG", "receivers", "Ljava/util/HashSet;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/test_kit/DebuggerBroadcastAction;", "Lkotlin/collections/HashSet;", "addActionReceiver", "", "action", "getAllActionReceivers", "", "removeActionReceiver", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$b
{
  private static final HashSet<a> b = new HashSet();
  
  @NotNull
  public final List<a> a()
  {
    synchronized (b)
    {
      List localList = (List)new LinkedList((Collection)b);
      return localList;
    }
  }
  
  public final void a(@NotNull a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "action");
    synchronized (b)
    {
      b.add(parama);
      if (b.size() == 1)
      {
        o.d("Luggage.DebuggerBroadcastAction.Registry", "register receiver action[%s]", new Object[] { "com.tencent.wmpf.dev.testkit.DebuggerBroadcastReceiver.ACTION" });
        parama = r.a();
        BroadcastReceiver localBroadcastReceiver = (BroadcastReceiver)a.a.a.a();
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.wmpf.dev.testkit.DebuggerBroadcastReceiver.ACTION");
        parama.registerReceiver(localBroadcastReceiver, localIntentFilter);
      }
      parama = Unit.INSTANCE;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fl.a.b
 * JD-Core Version:    0.7.0.1
 */