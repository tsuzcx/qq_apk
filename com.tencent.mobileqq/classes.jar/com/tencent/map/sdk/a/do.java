package com.tencent.map.sdk.a;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class do
{
  public ej a = ej.a;
  public ec b = ec.a;
  public dm c = dl.a;
  public final Map<Type, dp<?>> d = new HashMap();
  public final List<ef> e = new ArrayList();
  public final List<ef> f = new ArrayList();
  public boolean g;
  public String h;
  public int i = 2;
  public int j = 2;
  public boolean k;
  public boolean l;
  public boolean m = true;
  public boolean n;
  public boolean o;
  
  public final do a(Type paramType, Object paramObject)
  {
    eg.a(true);
    if ((paramObject instanceof dp)) {
      this.d.put(paramType, (dp)paramObject);
    }
    fd localfd = fd.a(paramType);
    List localList = this.e;
    if (localfd.b == localfd.a) {}
    for (boolean bool = true;; bool = false)
    {
      localList.add(new ed.a(paramObject, localfd, bool, (byte)0));
      if ((paramObject instanceof ee)) {
        this.e.add(fc.a(fd.a(paramType), (ee)paramObject));
      }
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.do
 * JD-Core Version:    0.7.0.1
 */