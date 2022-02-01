package com.tencent.luggage.wxa.ng;

import androidx.collection.ArraySet;
import com.tencent.luggage.wxa.jo.b;
import com.tencent.luggage.wxa.jo.c;
import com.tencent.luggage.wxa.qz.w;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class k$a
  implements Runnable
{
  k$a(c paramc, w paramw, int paramInt) {}
  
  public final void run()
  {
    Object localObject1 = this.b;
    String str = null;
    localObject1 = ((w)localObject1).getStringSet("VideoCastDeviceManager.saveDevice", null);
    if (localObject1 != null) {
      localObject1 = CollectionsKt.toMutableList((Collection)localObject1);
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.a.a();
    if (localObject2 != null) {
      localObject2 = ((b)localObject2).j;
    } else {
      localObject2 = null;
    }
    if (localObject1 != null)
    {
      if (((List)localObject1).contains(localObject2))
      {
        this.b.putLong((String)localObject2, System.currentTimeMillis());
        return;
      }
      if (((List)localObject1).size() >= this.c) {
        new k.a.1(this, (List)localObject1, (String)localObject2).a();
      }
      b localb = this.a.a();
      if (localb != null) {
        str = localb.j;
      }
      ((List)localObject1).add(str);
      this.b.putStringSet("VideoCastDeviceManager.saveDevice", CollectionsKt.toSet((Iterable)localObject1));
      this.b.putLong((String)localObject2, System.currentTimeMillis());
      return;
    }
    localObject1 = new ArraySet();
    ((ArraySet)localObject1).add(localObject2);
    this.b.putStringSet("VideoCastDeviceManager.saveDevice", (Set)localObject1);
    this.b.putLong((String)localObject2, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.k.a
 * JD-Core Version:    0.7.0.1
 */