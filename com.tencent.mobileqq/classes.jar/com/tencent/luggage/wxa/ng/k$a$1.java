package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.qz.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"sort", "", "invoke"}, k=3, mv={1, 1, 16})
final class k$a$1
  extends Lambda
  implements Function0<Unit>
{
  k$a$1(k.a parama, List paramList, String paramString)
  {
    super(0);
  }
  
  public final void a()
  {
    Object localObject = (Iterable)this.b;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      localCollection.add(Long.valueOf(this.a.b.getLong(str, 0L)));
    }
    CollectionsKt.sorted((Iterable)localCollection);
    this.a.b.f((String)this.b.get(0));
    this.b.set(0, this.c);
    this.a.b.putLong(this.c, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.k.a.1
 * JD-Core Version:    0.7.0.1
 */