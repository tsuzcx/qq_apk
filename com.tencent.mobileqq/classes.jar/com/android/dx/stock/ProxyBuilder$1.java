package com.android.dx.stock;

import java.lang.reflect.Method;
import java.util.Comparator;

class ProxyBuilder$1
  implements Comparator<Method>
{
  ProxyBuilder$1(ProxyBuilder paramProxyBuilder) {}
  
  public int compare(Method paramMethod1, Method paramMethod2)
  {
    return paramMethod1.toString().compareTo(paramMethod2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.stock.ProxyBuilder.1
 * JD-Core Version:    0.7.0.1
 */