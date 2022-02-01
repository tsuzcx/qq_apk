package com.tencent.luggage.wxa.ii;

import com.tencent.luggage.wxa.ih.b;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.luggage.wxa.qw.ik;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$Builder$Companion;", "", "()V", "buildGetAllSubscribeStatusReq", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "username", "", "callback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "buildGetSubscribeStatusByUrlReq", "subscribeUrl", "buildGetSubscribeStatusReq", "templateIds", "", "buildGetSubscribeUIStatusReq", "buildSubscribeReq", "templates", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "isOpened", "", "buildSubscribeReqForDialogRequest", "byteArray", "", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "innerBuildSubscribeRequest", "action", "", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class a$a$a
{
  private final a a(String paramString, boolean paramBoolean, a.c paramc, List<d> paramList, int paramInt, byte[] paramArrayOfByte, b paramb)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public final a a(@NotNull String paramString, @NotNull List<String> paramList, @Nullable a.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "username");
    Intrinsics.checkParameterIsNotNull(paramList, "templateIds");
    paramString = new a(paramString, 2);
    a.a(paramString, paramc);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramc = (String)paramList.next();
      List localList = a.a(paramString);
      ik localik = new ik();
      localik.a = paramc;
      localList.add(localik);
    }
    return paramString;
  }
  
  @NotNull
  public final a a(@NotNull String paramString, @NotNull List<d> paramList, @Nullable a.c paramc, boolean paramBoolean, @NotNull byte[] paramArrayOfByte, @Nullable b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "username");
    Intrinsics.checkParameterIsNotNull(paramList, "templates");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "byteArray");
    return ((a)this).a(paramString, paramBoolean, paramc, paramList, 6, paramArrayOfByte, paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ii.a.a.a
 * JD-Core Version:    0.7.0.1
 */