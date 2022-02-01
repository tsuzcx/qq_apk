package com.tencent.luggage.wxa.ac;

import com.tencent.luggage.wxa.h.k;
import java.util.Collections;
import java.util.List;

public final class a
  extends c
{
  public final List<a.a> a;
  public final List<a.a> b;
  public final List<a.a> c;
  public final k d;
  public final List<k> e;
  
  public a(String paramString, List<String> paramList, List<a.a> paramList1, List<a.a> paramList2, List<a.a> paramList3, k paramk, List<k> paramList4)
  {
    super(paramString, paramList);
    this.a = Collections.unmodifiableList(paramList1);
    this.b = Collections.unmodifiableList(paramList2);
    this.c = Collections.unmodifiableList(paramList3);
    this.d = paramk;
    if (paramList4 != null) {
      paramString = Collections.unmodifiableList(paramList4);
    } else {
      paramString = null;
    }
    this.e = paramString;
  }
  
  public static a a(String paramString)
  {
    paramString = Collections.singletonList(a.a.a(paramString));
    List localList = Collections.emptyList();
    return new a(null, Collections.emptyList(), paramString, localList, localList, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ac.a
 * JD-Core Version:    0.7.0.1
 */