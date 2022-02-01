package com.android.dx.dex.file;

import com.android.dex.DexIndexOverflowException;
import com.android.dx.command.dexer.Main;
import com.android.dx.rop.cst.CstType;
import java.util.Collection;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MemberIdsSection
  extends UniformItemSection
{
  public MemberIdsSection(String paramString, DexFile paramDexFile)
  {
    super(paramString, paramDexFile, 4);
  }
  
  private String getTooManyMembersMessage()
  {
    Object localObject4 = new TreeMap();
    Iterator localIterator = items().iterator();
    Object localObject1;
    while (localIterator.hasNext())
    {
      String str2 = ((MemberIdItem)localIterator.next()).getDefiningClass().getPackageName();
      localObject3 = (AtomicInteger)((Map)localObject4).get(str2);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = new AtomicInteger();
        ((Map)localObject4).put(str2, localObject1);
      }
      ((AtomicInteger)localObject1).incrementAndGet();
    }
    Object localObject3 = new Formatter();
    for (;;)
    {
      try
      {
        if ((this instanceof MethodIdsSection))
        {
          localObject1 = "method";
          ((Formatter)localObject3).format("Too many %s references: %d; max is %d.%n" + Main.getTooManyIdsErrorMessage() + "%nReferences by package:", new Object[] { localObject1, Integer.valueOf(items().size()), Integer.valueOf(65536) });
          localObject1 = ((Map)localObject4).entrySet().iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject4 = (Map.Entry)((Iterator)localObject1).next();
          ((Formatter)localObject3).format("%n%6d %s", new Object[] { Integer.valueOf(((AtomicInteger)((Map.Entry)localObject4).getValue()).get()), ((Map.Entry)localObject4).getKey() });
          continue;
        }
        str1 = "field";
      }
      finally
      {
        ((Formatter)localObject3).close();
      }
    }
    String str1 = ((Formatter)localObject3).toString();
    ((Formatter)localObject3).close();
    return str1;
  }
  
  protected void orderItems()
  {
    if (items().size() > 65536) {
      throw new DexIndexOverflowException(getTooManyMembersMessage());
    }
    Iterator localIterator = items().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ((MemberIdItem)localIterator.next()).setIndex(i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.MemberIdsSection
 * JD-Core Version:    0.7.0.1
 */