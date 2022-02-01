package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.qw.ez;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/WxaLaunchErrorAction$Companion;", "", "()V", "createErrorAction", "Lcom/tencent/luggage/launch/WxaLaunchErrorAction;", "pb", "Lcom/tencent/mm/protocal/protobuf/LaunchAction;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class m$a
{
  @Nullable
  public final m a(@Nullable ez paramez)
  {
    m localm = null;
    if (paramez != null)
    {
      int i = paramez.a;
      if (i != 2)
      {
        if (i != 3) {
          return null;
        }
        return (m)new n(paramez.d, paramez.e);
      }
      localm = (m)new o(paramez.b);
    }
    return localm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.m.a
 * JD-Core Version:    0.7.0.1
 */