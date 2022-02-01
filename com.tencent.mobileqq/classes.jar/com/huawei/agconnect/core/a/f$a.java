package com.huawei.agconnect.core.a;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map.Entry;

class f$a
  implements Serializable, Comparator<Map.Entry<String, Integer>>
{
  public int a(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2)
  {
    return ((Integer)paramEntry1.getValue()).intValue() - ((Integer)paramEntry2.getValue()).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.core.a.f.a
 * JD-Core Version:    0.7.0.1
 */