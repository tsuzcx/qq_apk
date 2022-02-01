package com.tencent.biz.pubaccount.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ReadInJoyShareHelper$ReadInJoyDefaultSheetItemSuppiler
  implements ReadInJoyShareHelper.SheetItemSupplier
{
  protected Map<Integer, Integer> a = new HashMap();
  protected Map<Integer, Integer> b = new HashMap();
  
  public ReadInJoyShareHelper$ReadInJoyDefaultSheetItemSuppiler()
  {
    a();
  }
  
  protected Integer a(int paramInt)
  {
    return (Integer)this.a.get(Integer.valueOf(paramInt));
  }
  
  protected void a()
  {
    this.a.put(Integer.valueOf(34), Integer.valueOf(1));
    this.a.put(Integer.valueOf(2), Integer.valueOf(2));
    this.a.put(Integer.valueOf(3), Integer.valueOf(3));
    this.a.put(Integer.valueOf(9), Integer.valueOf(4));
    this.a.put(Integer.valueOf(10), Integer.valueOf(5));
    this.a.put(Integer.valueOf(12), Integer.valueOf(6));
    this.a.put(Integer.valueOf(5), Integer.valueOf(7));
    this.a.put(Integer.valueOf(4), Integer.valueOf(8));
    this.a.put(Integer.valueOf(21), Integer.valueOf(9));
    this.a.put(Integer.valueOf(7), Integer.valueOf(10));
    this.a.put(Integer.valueOf(6), Integer.valueOf(12));
    this.a.put(Integer.valueOf(129), Integer.valueOf(39));
    this.a.put(Integer.valueOf(26), Integer.valueOf(13));
    this.a.put(Integer.valueOf(1), Integer.valueOf(14));
    this.a.put(Integer.valueOf(11), Integer.valueOf(20));
    this.a.put(Integer.valueOf(44), Integer.valueOf(15));
    this.a.put(Integer.valueOf(43), Integer.valueOf(11));
    this.a.put(Integer.valueOf(38), Integer.valueOf(19));
    this.a.put(Integer.valueOf(35), Integer.valueOf(17));
    this.a.put(Integer.valueOf(37), Integer.valueOf(16));
    this.a.put(Integer.valueOf(31), Integer.valueOf(21));
    this.a.put(Integer.valueOf(40), Integer.valueOf(25));
    this.a.put(Integer.valueOf(68), Integer.valueOf(28));
    this.a.put(Integer.valueOf(129), Integer.valueOf(39));
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.b.put(localEntry.getValue(), localEntry.getKey());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInJoyShareHelper.ReadInJoyDefaultSheetItemSuppiler
 * JD-Core Version:    0.7.0.1
 */