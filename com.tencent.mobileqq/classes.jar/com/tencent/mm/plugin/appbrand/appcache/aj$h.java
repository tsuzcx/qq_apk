package com.tencent.mm.plugin.appbrand.appcache;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "", "invoke"}, k=3, mv={1, 1, 16})
final class aj$h
  extends Lambda
  implements Function0<LinkedList<String>>
{
  aj$h(aj paramaj)
  {
    super(0);
  }
  
  @NotNull
  public final LinkedList<String> a()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = ((Map)aj.c(this.a)).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (((h.a)localEntry.getValue()).i != null) {
        localLinkedList.add(str);
      }
    }
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aj.h
 * JD-Core Version:    0.7.0.1
 */