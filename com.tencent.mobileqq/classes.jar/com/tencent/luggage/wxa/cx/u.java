package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.ef.h;
import com.tencent.luggage.wxa.qw.bd;
import com.tencent.luggage.wxa.qw.dq;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/WxaRuntimeHostAttr;", "", "()V", "DUMMY", "Lcom/tencent/mm/protocal/protobuf/DynamicAttrInfo;", "getDUMMY", "()Lcom/tencent/mm/protocal/protobuf/DynamicAttrInfo;", "<set-?>", "DynamicAttrInfo", "getDynamicAttrInfo", "setDynamicAttrInfo", "(Lcom/tencent/mm/protocal/protobuf/DynamicAttrInfo;)V", "DynamicAttrInfo$delegate", "Lcom/tencent/luggage/sdk/wxa_ktx/WxaMmkvProperty;", "Lcom/tencent/mm/protocal/protobuf/GlobalAttrInfo;", "GlobalAttrInfo", "getGlobalAttrInfo", "()Lcom/tencent/mm/protocal/protobuf/GlobalAttrInfo;", "setGlobalAttrInfo", "(Lcom/tencent/mm/protocal/protobuf/GlobalAttrInfo;)V", "GlobalAttrInfo$delegate", "KEY", "", "TAG", "refreshWxaRuntimeHostAttr", "", "appId", "hostAppId", "CloseButtonActionTypeEnumDef", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class u
{
  public static final u b = new u();
  @NotNull
  private static final bd c;
  @NotNull
  private static final h d = new h(new bd(), null, 2, null);
  @NotNull
  private static final h e = new h(new dq(), null, 2, null);
  
  static
  {
    bd localbd = new bd();
    localbd.a = 0;
    c = localbd;
  }
  
  @NotNull
  public final bd a()
  {
    return c;
  }
  
  public final void a(@NotNull bd parambd)
  {
    Intrinsics.checkParameterIsNotNull(parambd, "<set-?>");
    d.a(this, a[0], parambd);
  }
  
  public final void a(@NotNull dq paramdq)
  {
    Intrinsics.checkParameterIsNotNull(paramdq, "<set-?>");
    e.a(this, a[1], paramdq);
  }
  
  public final void a(@Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString2, "hostAppId");
    f.a.c((Runnable)new u.a(paramString1, paramString2));
  }
  
  @NotNull
  public final bd b()
  {
    return (bd)d.a(this, a[0]);
  }
  
  @NotNull
  public final dq c()
  {
    return (dq)e.a(this, a[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.u
 * JD-Core Version:    0.7.0.1
 */