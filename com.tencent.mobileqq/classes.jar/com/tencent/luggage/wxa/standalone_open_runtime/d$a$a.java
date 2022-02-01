package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.page.o;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxa/standalone_open_runtime/WxaPageContainer$Companion$createForApp$1", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageContainer;", "onCreatePageView", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "container", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainer;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class d$a$a
  extends d
{
  d$a$a(LinkedList paramLinkedList, Context paramContext1, com.tencent.luggage.wxa.ed.d paramd1, Context paramContext2, com.tencent.luggage.wxa.ed.d paramd2)
  {
    super(paramContext2, paramd2);
  }
  
  @NotNull
  public e b(@NotNull o paramo)
  {
    Intrinsics.checkParameterIsNotNull(paramo, "container");
    paramo = (e)this.a.pollFirst();
    if (paramo != null) {
      return paramo;
    }
    return e.c.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.d.a.a
 * JD-Core Version:    0.7.0.1
 */