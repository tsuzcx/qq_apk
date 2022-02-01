package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo$LipStickType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "MATTE", "SATIN", "MOIST", "HIGH_LIGHT", "PEARL", "METALLIC_LIGHT", "NEON_LIGHT", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public enum i$b
{
  public static final i.b.a h = new i.b.a(null);
  private final int j;
  
  static
  {
    b localb1 = new b("MATTE", 0, 0);
    a = localb1;
    b localb2 = new b("SATIN", 1, 1);
    b = localb2;
    b localb3 = new b("MOIST", 2, 2);
    c = localb3;
    b localb4 = new b("HIGH_LIGHT", 3, 3);
    d = localb4;
    b localb5 = new b("PEARL", 4, 4);
    e = localb5;
    b localb6 = new b("METALLIC_LIGHT", 5, 5);
    f = localb6;
    b localb7 = new b("NEON_LIGHT", 6, 6);
    g = localb7;
    i = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7 };
  }
  
  private i$b(int paramInt)
  {
    this.j = paramInt;
  }
  
  @JvmStatic
  @Nullable
  public static final b a(int paramInt)
  {
    return h.a(paramInt);
  }
  
  public final int a()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i.b
 * JD-Core Version:    0.7.0.1
 */