package com.tencent.mobileqq.apollo.statistics.product;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder;", "", "()V", "<set-?>", "", "duration", "getDuration", "()Ljava/lang/String;", "", "entry", "getEntry", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "ex1", "getEx1", "ex2", "getEx2", "ex3", "getEx3", "ex4", "getEx4", "ex5", "getEx5", "exMore", "getExMore", "fromEntrance", "getFromEntrance", "guest", "getGuest", "", "intimateRelationTimestamp", "getIntimateRelationTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "intimateType", "getIntimateType", "keyText", "getKeyText", "mode", "getMode", "ownerStatus", "getOwnerStatus", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getParams", "()Ljava/util/HashMap;", "setParams", "(Ljava/util/HashMap;)V", "peerStatus", "getPeerStatus", "peerUin", "getPeerUin", "personNum", "getPersonNum", "qqUin", "getQqUin", "timestamp", "getTimestamp", "type", "getType", "vip", "getVip", "build", "setDuration", "setEntry", "setExtend1", "ex", "setExtend2", "setExtend3", "setExtend4", "setExtend5", "setExtendMore", "setFromEntrance", "from", "setGuest", "setIntimateRelationTimestamp", "(Ljava/lang/Long;)Lcom/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder;", "setIntimateType", "(Ljava/lang/Integer;)Lcom/tencent/mobileqq/apollo/statistics/product/DtReportParamsBuilder;", "setKeyText", "setMode", "setOwnerStatus", "setPeerStatus", "setPeerUin", "setPersonNum", "setQQUin", "setTimestamp", "setType", "setVip", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public final class DtReportParamsBuilder
{
  @Nullable
  private Integer a;
  @Nullable
  private Integer b;
  @Nullable
  private Integer c;
  @Nullable
  private Integer d;
  @Nullable
  private Integer e;
  @Nullable
  private String f;
  @Nullable
  private Integer g;
  @Nullable
  private Integer h;
  @Nullable
  private String i;
  @Nullable
  private String j;
  @Nullable
  private String k;
  @Nullable
  private String l;
  @Nullable
  private String m;
  @Nullable
  private String n;
  @Nullable
  private String o;
  @Nullable
  private String p;
  @Nullable
  private String q;
  @Nullable
  private String r;
  @Nullable
  private Integer s;
  @Nullable
  private Long t;
  @Nullable
  private String u;
  @Nullable
  private Integer v;
  @NotNull
  private HashMap<String, String> w = new HashMap();
  
  @NotNull
  public final DtReportParamsBuilder a(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.a = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder a(@Nullable Integer paramInteger)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.h = paramInteger;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder a(@Nullable Long paramLong)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.t = paramLong;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "keyText");
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.f = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final HashMap<String, String> a()
  {
    Object localObject = this.a;
    if (localObject != null) {
      this.w.put("mode", String.valueOf(localObject));
    }
    localObject = this.b;
    if (localObject != null) {
      this.w.put("entry", String.valueOf(localObject));
    }
    localObject = this.c;
    if (localObject != null) {
      this.w.put("type", String.valueOf(localObject));
    }
    localObject = this.d;
    if (localObject != null) {
      this.w.put("guest", String.valueOf(localObject));
    }
    localObject = this.e;
    if (localObject != null) {
      this.w.put("personNum", String.valueOf(localObject));
    }
    localObject = this.f;
    if (localObject != null) {
      this.w.put("keyText", String.valueOf(localObject));
    }
    localObject = this.g;
    if (localObject != null) {
      this.w.put("ownerStatus", String.valueOf(localObject));
    }
    localObject = this.h;
    if (localObject != null) {
      this.w.put("peerStatus", String.valueOf(localObject));
    }
    localObject = this.i;
    if (localObject != null) {
      this.w.put("qqUin", String.valueOf(localObject));
    }
    localObject = this.j;
    if (localObject != null) {
      this.w.put("peerUin", String.valueOf(localObject));
    }
    localObject = this.k;
    if (localObject != null) {
      this.w.put("timestamp", String.valueOf(localObject));
    }
    localObject = this.l;
    if (localObject != null) {
      this.w.put("duration", String.valueOf(localObject));
    }
    localObject = this.m;
    if (localObject != null) {
      this.w.put("ex1", String.valueOf(localObject));
    }
    localObject = this.n;
    if (localObject != null) {
      this.w.put("ex2", String.valueOf(localObject));
    }
    localObject = this.o;
    if (localObject != null) {
      this.w.put("ex3", String.valueOf(localObject));
    }
    localObject = this.p;
    if (localObject != null) {
      this.w.put("ex4", String.valueOf(localObject));
    }
    localObject = this.q;
    if (localObject != null) {
      this.w.put("ex5", String.valueOf(localObject));
    }
    localObject = this.r;
    if (localObject != null) {
      this.w.put("from_entrance", String.valueOf(localObject));
    }
    localObject = this.s;
    if (localObject != null) {
      this.w.put("intimateRelation", String.valueOf(localObject));
    }
    localObject = this.t;
    if (localObject != null) {
      this.w.put("intimateRelationTimeStamp", String.valueOf(localObject));
    }
    localObject = this.u;
    if (localObject != null) {
      this.w.put("exMore", String.valueOf(localObject));
    }
    localObject = this.v;
    if (localObject != null) {
      this.w.put("vip", String.valueOf(localObject));
    }
    return this.w;
  }
  
  @NotNull
  public final DtReportParamsBuilder b(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.b = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder b(@Nullable Integer paramInteger)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.s = paramInteger;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder b(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.i = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder c(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.c = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder c(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.j = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder d(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.d = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder d(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.k = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder e(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.e = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder e(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.l = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder f(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.g = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder f(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.m = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder g(int paramInt)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.v = Integer.valueOf(paramInt);
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder g(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.n = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder h(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.o = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder i(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.p = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder j(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.q = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder k(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.r = paramString;
    return localDtReportParamsBuilder;
  }
  
  @NotNull
  public final DtReportParamsBuilder l(@Nullable String paramString)
  {
    DtReportParamsBuilder localDtReportParamsBuilder = (DtReportParamsBuilder)this;
    localDtReportParamsBuilder.u = paramString;
    return localDtReportParamsBuilder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder
 * JD-Core Version:    0.7.0.1
 */