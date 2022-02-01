package com.tencent.luggage.wxa.fp;

import com.tencent.luggage.wxa.dc.a;
import com.tencent.luggage.wxa.qw.av;
import com.tencent.luggage.wxa.qw.aw;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.ro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/storage/collection/WxaCollectionStorage$Companion$CGICheckUserStarRecord;", "Lcom/tencent/luggage/login/Cgi;", "Lcom/tencent/mm/protocal/protobuf/CheckUserStarRecordRequest;", "Lcom/tencent/mm/protocal/protobuf/CheckUserStarRecordResponse;", "()V", "URL", "", "getURL", "()Ljava/lang/String;", "request", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "appId", "versionType", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class i$a$a
  extends a<av, aw>
{
  @NotNull
  public final d<aw> a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    av localav = new av();
    localav.a = paramString;
    localav.b = paramInt;
    return a("", (gt)localav, aw.class);
  }
  
  @NotNull
  public String a()
  {
    return "/cgi-bin/mmbiz-bin/wxabusiness/checkuserstarrecord";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fp.i.a.a
 * JD-Core Version:    0.7.0.1
 */