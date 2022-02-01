package com.tencent.luggage.wxa.dg;

import com.tencent.ilinkservice.aq;
import com.tencent.ilinkservice.at;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/device/BaseActivateDevice;", "Lcom/tencent/luggage/login/device/IActivateDevice;", "()V", "tdiSessionCallbackDispatcher", "Lcom/tencent/ilinkservice/TdiSessionCallback;", "getTdiSessionCallbackDispatcher", "()Lcom/tencent/ilinkservice/TdiSessionCallback;", "tdiSessionCallbacks", "", "Lcom/tencent/luggage/login/device/IActivateDevice$TdiSessionCallbackWrapper;", "kotlin.jvm.PlatformType", "", "addTdiSessionCallback", "", "callback", "removeTdiSessionCallback", "", "Companion", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public abstract class a
  implements b
{
  @Deprecated
  public static final a.a a = new a.a(null);
  private final Set<b.b> c = Collections.newSetFromMap((Map)new ConcurrentHashMap());
  @NotNull
  private final at d = (at)new a.b(this);
  
  @NotNull
  protected final at a()
  {
    return this.d;
  }
  
  public final boolean a(@Nullable b.b paramb)
  {
    if (paramb != null) {
      this.c.add(paramb);
    }
    paramb = f();
    if (paramb != null)
    {
      paramb.a(this.d);
      return true;
    }
    return false;
  }
  
  public final void b(@Nullable b.b paramb)
  {
    if (paramb != null) {
      this.c.remove(paramb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dg.a
 * JD-Core Version:    0.7.0.1
 */