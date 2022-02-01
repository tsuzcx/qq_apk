package com.tencent.luggage.wxa.ii;

import com.tencent.luggage.wxa.ih.b;
import com.tencent.luggage.wxa.ih.c;
import com.tencent.luggage.wxa.ih.c.a;
import com.tencent.luggage.wxa.ik.a.a;
import com.tencent.luggage.wxa.qw.ik;
import com.tencent.luggage.wxa.qw.im;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "username", "", "actionType", "", "isOpened", "", "(Ljava/lang/String;IZ)V", "(Ljava/lang/String;I)V", "getActionType", "()I", "byteArray", "", "getByteArray", "()[B", "setByteArray", "([B)V", "itemList", "", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgItem;", "mSubscribeEndCallback", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "subscribeUrl", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUsername", "()Ljava/lang/String;", "doScene", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getCallback", "getReq", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgReq;", "getResp", "Lcom/tencent/mm/protocal/protobuf/SubscribeMsgResp;", "getType", "onSceneEnd", "", "errType", "errCode", "errMsg", "scene", "setCallback", "callback", "Builder", "Companion", "IOnNetSceneSubscribeEndCallback", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  extends com.tencent.luggage.wxa.ik.a
  implements com.tencent.luggage.wxa.ik.a.b
{
  public static final a.b a = new a.b(null);
  private final List<ik> b;
  private com.tencent.luggage.wxa.ik.a.c c;
  private a.c d;
  private boolean e;
  private String f;
  private b g;
  @NotNull
  private byte[] h;
  @NotNull
  private final String i;
  private final int j;
  
  public a(@NotNull String paramString, int paramInt)
  {
    this.i = paramString;
    this.j = paramInt;
    this.b = ((List)new ArrayList());
    this.f = "";
    this.h = new byte[0];
  }
  
  public a(@NotNull String paramString, int paramInt, boolean paramBoolean)
  {
    this(paramString, paramInt);
    this.e = paramBoolean;
  }
  
  public int a()
  {
    return 2920;
  }
  
  public final int a(@NotNull a.a parama)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(int paramInt1, int paramInt2, @Nullable String paramString, @Nullable com.tencent.luggage.wxa.ik.a parama)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      parama = this.c;
      if (parama == null) {
        Intrinsics.throwNpe();
      }
      parama = parama.b();
      if (parama != null)
      {
        parama = (im)parama;
        a.c localc = this.d;
        if (localc != null)
        {
          if (paramString == null) {
            paramString = "";
          }
          localc.a(paramInt1, paramInt2, paramString, c.a.a(parama));
        }
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.SubscribeMsgResp");
    }
    parama = this.d;
    if (parama != null)
    {
      if (paramString == null) {
        paramString = "";
      }
      parama.a(paramInt1, paramInt2, paramString, null);
    }
  }
  
  public final void a(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "<set-?>");
    this.h = paramArrayOfByte;
  }
  
  @NotNull
  public final String b()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ii.a
 * JD-Core Version:    0.7.0.1
 */