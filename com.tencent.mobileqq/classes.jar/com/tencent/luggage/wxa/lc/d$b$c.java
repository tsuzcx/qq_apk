package com.tencent.luggage.wxa.lc;

import com.tencent.luggage.wxa.ih.b;
import com.tencent.mm.msgsubscription.ui.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.l;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/JsApiRequestSubscribeMessage$SubscribeMsgTask$createGetSubscribeMsgListListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUserActionCompleted", "username", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "showDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class d$b$c
  implements b.c
{
  public void a(int paramInt1, int paramInt2, @NotNull String paramString, @Nullable com.tencent.luggage.wxa.ih.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    this.a.a(paramInt1, paramInt2, paramString, paramc);
  }
  
  public void a(@NotNull i parami)
  {
    Intrinsics.checkParameterIsNotNull(parami, "dialog");
    Object localObject = d.b.a(this.a);
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.wxa.du.c)localObject).y();
      if ((localObject != null) && (((com.tencent.luggage.wxa.oq.c)localObject).f() == true))
      {
        if (!(parami instanceof a)) {
          localObject = null;
        } else {
          localObject = parami;
        }
        localObject = (a)localObject;
        if (localObject != null) {
          ((a)localObject).c(1);
        }
      }
    }
    localObject = d.b.a(this.a);
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.wxa.du.c)localObject).i();
      if (localObject != null)
      {
        localObject = ((com.tencent.luggage.wxa.ed.d)localObject).ap();
        if (localObject != null) {
          ((l)localObject).a(parami);
        }
      }
    }
  }
  
  public void a(@NotNull String paramString, @NotNull List<com.tencent.luggage.wxa.ih.d> paramList, @Nullable b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "username");
    Intrinsics.checkParameterIsNotNull(paramList, "items");
    paramString = this.a.i();
    if (paramString != null) {
      paramString.a(CollectionsKt.toMutableList((Collection)paramList));
    }
    paramList = this.a.i();
    if (paramList != null)
    {
      paramString = this.a.h();
      if (paramString != null) {
        paramString = paramString.g();
      } else {
        paramString = null;
      }
      paramList.a(paramString);
    }
    paramString = this.a.i();
    if (paramString != null) {
      paramString.a(paramb);
    }
    d.b.a(this.a, 1);
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.d.b.c
 * JD-Core Version:    0.7.0.1
 */