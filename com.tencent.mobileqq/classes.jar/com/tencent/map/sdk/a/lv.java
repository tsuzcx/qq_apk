package com.tencent.map.sdk.a;

import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public final class lv
{
  public lg a;
  public pf b;
  public HashMap<Integer, mn> c;
  public HashMap<Integer, mn> d;
  public CopyOnWriteArrayList<Integer> e = new CopyOnWriteArrayList();
  public SparseBooleanArray f = new SparseBooleanArray();
  public ArrayList<Integer> g = new ArrayList();
  
  lv(lg paramlg, pf parampf)
  {
    this.a = paramlg;
    this.b = parampf;
    this.c = new HashMap();
    this.d = new HashMap();
  }
  
  public final void a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.c.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = ((Map.Entry)localObject3).getKey();
      localObject3 = (mn)((Map.Entry)localObject3).getValue();
      if (!this.d.containsKey(localObject2))
      {
        localArrayList.add(Integer.valueOf(((Integer)localObject2).intValue()));
        oi.b(((mn)localObject3).b);
      }
    }
    int j = localArrayList.size();
    if (j > 0)
    {
      localObject1 = new int[j];
      int i = 0;
      while (i < j)
      {
        localObject1[i] = ((Integer)localArrayList.get(i)).intValue();
        i += 1;
      }
      this.b.a((int[])localObject1, j);
    }
    this.c.clear();
    this.c.putAll(this.d);
    this.d.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.lv
 * JD-Core Version:    0.7.0.1
 */