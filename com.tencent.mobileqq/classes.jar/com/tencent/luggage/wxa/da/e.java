package com.tencent.luggage.wxa.da;

import android.app.Activity;
import com.tencent.luggage.wxa.ea.b;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/task/WxaMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/launch/task/WxaStartParams;", "uiClass", "Ljava/lang/Class;", "Landroid/app/Activity;", "pluginUIClass", "(Ljava/lang/Class;Ljava/lang/Class;)V", "getPluginUIClass", "()Ljava/lang/Class;", "getUiClass", "killAllRuntime", "", "type", "Lcom/tencent/luggage/sdk/processes/KillType;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class e
  extends b<h>
{
  @NotNull
  private final Class<? extends Activity> b;
  @NotNull
  private final Class<? extends Activity> c;
  
  public e(@NotNull Class<? extends Activity> paramClass1, @NotNull Class<? extends Activity> paramClass2)
  {
    this.b = paramClass1;
    this.c = paramClass2;
  }
  
  @NotNull
  public Class<? extends Activity> a()
  {
    return this.b;
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.ea.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "type");
    Iterator localIterator = ((Iterable)f()).iterator();
    while (localIterator.hasNext()) {
      b.a(this, (com.tencent.luggage.wxa.eb.a)new d((String)localIterator.next(), parama.name()), null, 2, null);
    }
  }
  
  @NotNull
  public Class<? extends Activity> b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.da.e
 * JD-Core Version:    0.7.0.1
 */