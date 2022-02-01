package com.tencent.luggage.wxa.ih;

import com.tencent.mm.msgsubscription.ui.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "IS_ALWAYS_NO", "", "getIS_ALWAYS_NO", "()I", "IS_ALWAYS_YES", "getIS_ALWAYS_YES", "OP_TYPE_CANCEL", "getOP_TYPE_CANCEL", "OP_TYPE_CONFIRM", "getOP_TYPE_CONFIRM", "OP_TYPE_NONE", "getOP_TYPE_NONE", "OP_TYPE_REJECT", "getOP_TYPE_REJECT", "build", "event", "itemsShowOnDialog", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "isAlwaysCbCheck", "", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$a
{
  public final int a()
  {
    return b.d();
  }
  
  @NotNull
  public final b a(int paramInt, @NotNull List<a.b> paramList, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "itemsShowOnDialog");
    b localb = new b();
    int i;
    if (paramBoolean) {
      i = ((a)this).d();
    } else {
      i = ((a)this).e();
    }
    localb.b(i);
    if (paramInt == 1) {
      paramInt = ((a)this).a();
    } else if (paramInt == 3) {
      paramInt = ((a)this).c();
    } else {
      paramInt = ((a)this).b();
    }
    localb.a(paramInt);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a.b localb1 = (a.b)paramList.next();
      ArrayList localArrayList = localb.c();
      b.c localc = new b.c();
      localc.a(localb1.d());
      if (localb1.a()) {
        paramInt = b.c.a.a();
      } else {
        paramInt = b.c.a.b();
      }
      localc.a(paramInt);
      localArrayList.add(localc);
    }
    return localb;
  }
  
  public final int b()
  {
    return b.e();
  }
  
  public final int c()
  {
    return b.f();
  }
  
  public final int d()
  {
    return b.g();
  }
  
  public final int e()
  {
    return b.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ih.b.a
 * JD-Core Version:    0.7.0.1
 */