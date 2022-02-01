package com.tencent.luggage.ui;

import android.os.Bundle;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class WmpfPresentationActivityHelper$IPCOperatePresentationStack$a
  implements Runnable
{
  WmpfPresentationActivityHelper$IPCOperatePresentationStack$a(Bundle paramBundle) {}
  
  public final void run()
  {
    Object localObject1 = this.a.getParcelable("token");
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    WmpfPresentationActivityHelper.b localb = (WmpfPresentationActivityHelper.b)localObject1;
    Object localObject3 = this.a.getString("command", "");
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[%s] -> [%s] [%s] invoke: ");
    ((StringBuilder)localObject1).append((String)localObject3);
    o.d("WMPF.WmpfPresentationActivityHelper", ((StringBuilder)localObject1).toString(), new Object[] { localb.b(), r.c(), localb.c() });
    if (localObject3 == null) {
      return;
    }
    int i = ((String)localObject3).hashCode();
    Object localObject2 = null;
    localObject1 = null;
    switch (i)
    {
    default: 
    case 2008396909: 
      if (((String)localObject3).equals("onBackground"))
      {
        localObject2 = WmpfPresentationActivityHelper.a(WmpfPresentationActivityHelper.a).values();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "activityPresentationMap.values");
        localObject3 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = ((Iterator)localObject3).next();
          if (((WmpfPresentationActivityHelper.c)localObject2).hashCode() == localb.a()) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            localObject1 = localObject2;
          }
        }
        localObject1 = (WmpfPresentationActivityHelper.c)localObject1;
        if (localObject1 != null)
        {
          ((WmpfPresentationActivityHelper.c)localObject1).b();
          return;
        }
      }
      break;
    case 1671672458: 
      if (((String)localObject3).equals("dismiss"))
      {
        WmpfPresentationActivityHelper.d(WmpfPresentationActivityHelper.a, localb);
        return;
      }
      break;
    case 1320532813: 
      if (((String)localObject3).equals("registerToMainProc"))
      {
        WmpfPresentationActivityHelper.a(WmpfPresentationActivityHelper.a, localb);
        return;
      }
      break;
    case 1030080642: 
      if (((String)localObject3).equals("onForeground"))
      {
        localObject1 = WmpfPresentationActivityHelper.a(WmpfPresentationActivityHelper.a).values();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "activityPresentationMap.values");
        localObject3 = ((Iterable)localObject1).iterator();
        localObject1 = localObject2;
        while (((Iterator)localObject3).hasNext())
        {
          localObject2 = ((Iterator)localObject3).next();
          if (((WmpfPresentationActivityHelper.c)localObject2).hashCode() == localb.a()) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            localObject1 = localObject2;
          }
        }
        localObject1 = (WmpfPresentationActivityHelper.c)localObject1;
        if (localObject1 != null)
        {
          ((WmpfPresentationActivityHelper.c)localObject1).a();
          return;
        }
      }
      break;
    case 3529469: 
      if (((String)localObject3).equals("show"))
      {
        WmpfPresentationActivityHelper.c(WmpfPresentationActivityHelper.a, localb);
        return;
      }
      break;
    case -1964853850: 
      if (((String)localObject3).equals("unregisterToMainProc")) {
        WmpfPresentationActivityHelper.b(WmpfPresentationActivityHelper.a, localb);
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WmpfPresentationActivityHelper.IPCOperatePresentationStack.a
 * JD-Core Version:    0.7.0.1
 */