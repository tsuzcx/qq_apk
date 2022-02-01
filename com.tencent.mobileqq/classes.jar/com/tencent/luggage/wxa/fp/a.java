package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qw.id;
import com.tencent.luggage.wxa.qw.ie;
import com.tencent.luggage.wxa.qw.iu;
import com.tencent.luggage.wxa.qw.iv;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.d.a;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.luggage.wxa.ro.h;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/storage/collection/CgiModCollection;", "Lcom/tencent/luggage/login/Cgi;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordRequest;", "Lcom/tencent/mm/protocal/protobuf/UpdateWxaStarRecordResponse;", "()V", "TAG", "", "URL", "getURL", "()Ljava/lang/String;", "add", "Lcom/tencent/mm/protocal/protobuf/StarWxaSortOperation;", "self", "Lcom/tencent/mm/protocal/protobuf/StarWxaInfo;", "prev", "next", "delete", "move", "op", "", "runOperation", "", "runPipeline", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "appId", "request", "clazz", "Ljava/lang/Class;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  extends com.tencent.luggage.wxa.dc.a<iu, iv>
{
  public static final a a = new a();
  
  private final ie a(int paramInt, id paramid1, id paramid2, id paramid3)
  {
    ie localie = new ie();
    localie.a = paramid1;
    localie.e = paramInt;
    localie.b = paramid2;
    localie.c = paramid3;
    return localie;
  }
  
  @JvmStatic
  @NotNull
  public static final ie a(@NotNull id paramid)
  {
    Intrinsics.checkParameterIsNotNull(paramid, "self");
    return a(a, 2, paramid, null, null, 12, null);
  }
  
  @JvmStatic
  @JvmOverloads
  @NotNull
  public static final ie a(@NotNull id paramid1, @Nullable id paramid2, @Nullable id paramid3)
  {
    Intrinsics.checkParameterIsNotNull(paramid1, "self");
    return a.a(1, paramid1, paramid2, paramid3);
  }
  
  @NotNull
  public d<iv> a(@Nullable String paramString, @NotNull iu paramiu, @NotNull Class<iv> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramiu, "request");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    if (!i.a.g())
    {
      paramString = h.a((d.a)a.c.a);
      Intrinsics.checkExpressionValueIsNotNull(paramString, "QuickAccess.pipeline(Pip…solve null\n            })");
      return paramString;
    }
    return super.a(paramString, (gt)paramiu, paramClass);
  }
  
  @NotNull
  public String a()
  {
    return "/cgi-bin/mmbiz-bin/wxaapp/updatestarrecord";
  }
  
  public final void a(@NotNull ie paramie)
  {
    Intrinsics.checkParameterIsNotNull(paramie, "op");
    iu localiu = new iu();
    localiu.b.add(paramie);
    localiu.a = 4;
    a(null, localiu, iv.class).a((e.c)new a.a(paramie)).a((e.a)new a.b(paramie));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.a
 * JD-Core Version:    0.7.0.1
 */