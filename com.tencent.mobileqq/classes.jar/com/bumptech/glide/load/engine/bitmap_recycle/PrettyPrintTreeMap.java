package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class PrettyPrintTreeMap<K, V>
  extends TreeMap<K, V>
{
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("( ");
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append('{');
      localStringBuilder.append(localEntry.getKey());
      localStringBuilder.append(':');
      localStringBuilder.append(localEntry.getValue());
      localStringBuilder.append("}, ");
    }
    if (!isEmpty()) {
      localStringBuilder.replace(localStringBuilder.length() - 2, localStringBuilder.length(), "");
    }
    localStringBuilder.append(" )");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.bitmap_recycle.PrettyPrintTreeMap
 * JD-Core Version:    0.7.0.1
 */