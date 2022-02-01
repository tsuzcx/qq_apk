package com.tencent.luggage.wxa.ej;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.qw.il;
import com.tencent.luggage.wxa.qw.im;
import com.tencent.luggage.wxa.ro.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/storage/WxaSubscribeMsgSettingDataHelper;", "", "()V", "ACTION_GET_ALL_SUBSCRIBE_STATUS", "", "ACTION_SUBSCRIBE", "TAG", "", "getSubscribeMsgInfoByNetScene", "", "userName", "appId", "receiver", "Lkotlin/Function1;", "Lcom/tencent/luggage/setting/entity/SubscribeMsgSettingData;", "syncSetting2Server", "data", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull com.tencent.luggage.wxa.eh.c paramc, @NotNull Function1<? super com.tencent.luggage.wxa.ih.c, Unit> paramFunction1)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull Function1<? super com.tencent.luggage.wxa.eh.c, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "userName");
    Intrinsics.checkParameterIsNotNull(paramString2, "appId");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "receiver");
    il localil = new il();
    localil.a = paramString1;
    localil.b = 3;
    ((com.tencent.luggage.wxa.ob.b)e.a(com.tencent.luggage.wxa.ob.b.class)).b("/cgi-bin/mmbiz-bin/bizattr/subscribemsg", paramString2, (com.tencent.luggage.wxa.qu.a)localil, im.class).a((com.tencent.luggage.wxa.rl.b)a.a.a).a((com.tencent.luggage.wxa.rl.b)new a.b(paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ej.a
 * JD-Core Version:    0.7.0.1
 */