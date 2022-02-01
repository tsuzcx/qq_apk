package com.tencent.luggage.ui;

import com.tencent.luggage.wxa.gz.e;
import com.tencent.luggage.wxa.gz.e.a;
import com.tencent.luggage.wxa.qy.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/ui/WxaMusicActivity$musicPlayerListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/MusicPlayerEvent;", "callback", "", "event", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaMusicActivity$f
  extends c<e>
{
  public boolean a(@NotNull e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "event");
    int i = parame.a.a;
    if ((i != 0) && (i != 1))
    {
      if ((i != 2) && (i != 3))
      {
        if ((i != 4) && (i != 7))
        {
          if (i == 8) {
            WxaMusicActivity.b(this.a).c();
          }
        }
        else
        {
          WxaMusicActivity.a(this.a);
          WxaMusicActivity.b(this.a).e();
        }
      }
      else
      {
        WxaMusicActivity.a(this.a);
        WxaMusicActivity.b(this.a).f();
      }
    }
    else
    {
      WxaMusicActivity.a(this.a);
      WxaMusicActivity.b(this.a).g();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaMusicActivity.f
 * JD-Core Version:    0.7.0.1
 */