package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType$Companion;", "", "()V", "from", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "typeInt", "", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class i$b$a
{
  @JvmStatic
  @Nullable
  public final i.b a(int paramInt)
  {
    i.b[] arrayOfb = i.b.values();
    int k = arrayOfb.length;
    int i = 0;
    while (i < k)
    {
      i.b localb = arrayOfb[i];
      int j;
      if (paramInt == localb.a()) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i.b.a
 * JD-Core Version:    0.7.0.1
 */