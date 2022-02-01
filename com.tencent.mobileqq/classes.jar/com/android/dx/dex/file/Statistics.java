package com.android.dx.dex.file;

import com.android.dx.util.AnnotatedOutput;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public final class Statistics
{
  private final HashMap<String, Statistics.Data> dataMap = new HashMap(50);
  
  public void add(Item paramItem)
  {
    String str = paramItem.typeName();
    Statistics.Data localData = (Statistics.Data)this.dataMap.get(str);
    if (localData == null)
    {
      this.dataMap.put(str, new Statistics.Data(paramItem, str));
      return;
    }
    localData.add(paramItem);
  }
  
  public void addAll(Section paramSection)
  {
    paramSection = paramSection.items().iterator();
    while (paramSection.hasNext()) {
      add((Item)paramSection.next());
    }
  }
  
  public String toHuman()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Statistics:\n");
    Object localObject = new TreeMap();
    Iterator localIterator = this.dataMap.values().iterator();
    while (localIterator.hasNext())
    {
      Statistics.Data localData = (Statistics.Data)localIterator.next();
      ((TreeMap)localObject).put(Statistics.Data.access$000(localData), localData);
    }
    localObject = ((TreeMap)localObject).values().iterator();
    while (((Iterator)localObject).hasNext()) {
      localStringBuilder.append(((Statistics.Data)((Iterator)localObject).next()).toHuman());
    }
    return localStringBuilder.toString();
  }
  
  public final void writeAnnotation(AnnotatedOutput paramAnnotatedOutput)
  {
    if (this.dataMap.size() == 0) {}
    for (;;)
    {
      return;
      paramAnnotatedOutput.annotate(0, "\nstatistics:\n");
      Object localObject = new TreeMap();
      Iterator localIterator = this.dataMap.values().iterator();
      while (localIterator.hasNext())
      {
        Statistics.Data localData = (Statistics.Data)localIterator.next();
        ((TreeMap)localObject).put(Statistics.Data.access$000(localData), localData);
      }
      localObject = ((TreeMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Statistics.Data)((Iterator)localObject).next()).writeAnnotation(paramAnnotatedOutput);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.dex.file.Statistics
 * JD-Core Version:    0.7.0.1
 */