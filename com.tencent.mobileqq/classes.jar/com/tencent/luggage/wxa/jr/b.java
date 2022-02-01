package com.tencent.luggage.wxa.jr;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class b
{
  protected Map<String, String> a = new HashMap();
  
  public String a(String paramString)
  {
    return (String)this.a.get(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.put(paramString1, paramString2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append(localEntry.getKey());
      localStringBuilder.append(":");
      localStringBuilder.append(localEntry.getValue());
      localStringBuilder.append("\n");
    }
    if (localStringBuilder.length() > 1) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jr.b
 * JD-Core Version:    0.7.0.1
 */