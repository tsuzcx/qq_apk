package com.tencent.luggage.wxa.hp;

import android.os.Parcel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class c
{
  private static List<a> a = new LinkedList();
  private static Map<String, a> b = new HashMap();
  
  public static a a(Object paramObject)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.a(paramObject)) {
        return locala;
      }
    }
    return null;
  }
  
  public static a a(String paramString)
  {
    return (a)b.get(paramString);
  }
  
  public static Object a(String paramString, Parcel paramParcel)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.a(paramParcel);
    }
    return null;
  }
  
  public static void a(a parama)
  {
    if (parama != null)
    {
      if (a.contains(parama)) {
        return;
      }
      b.put(parama.getClass().getName(), parama);
      a.add(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hp.c
 * JD-Core Version:    0.7.0.1
 */