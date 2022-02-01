package com.tencent.luggage.wxa.il;

import com.tencent.luggage.wxa.im.b;
import java.util.List;

public class a<T>
  implements b
{
  private List<T> a;
  
  public a(List<T> paramList)
  {
    this.a = paramList;
  }
  
  public int a()
  {
    return this.a.size();
  }
  
  public Object a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return this.a.get(paramInt);
    }
    return "";
  }
  
  public String b(int paramInt)
  {
    Object localObject2 = a(paramInt);
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = "";
    }
    else
    {
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = localObject2.toString();
      }
    }
    return (String)localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.il.a
 * JD-Core Version:    0.7.0.1
 */