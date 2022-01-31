package com.tencent.dlsdk.yybutil.apkchannel.v2;

import java.util.Objects;

public class b<F, S>
{
  public final F a;
  public final S b;
  
  public b(F paramF, S paramS)
  {
    this.a = paramF;
    this.b = paramS;
  }
  
  public static <A, B> b<A, B> a(A paramA, B paramB)
  {
    return new b(paramA, paramB);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof b)) {}
    do
    {
      return false;
      paramObject = (b)paramObject;
    } while ((!Objects.equals(paramObject.a, this.a)) || (!Objects.equals(paramObject.b, this.b)));
    return true;
  }
  
  public int hashCode()
  {
    int j = 0;
    int i;
    if (this.a == null)
    {
      i = 0;
      if (this.b != null) {
        break label33;
      }
    }
    for (;;)
    {
      return i ^ j;
      i = this.a.hashCode();
      break;
      label33:
      j = this.b.hashCode();
    }
  }
  
  public String toString()
  {
    return "Pair{" + String.valueOf(this.a) + " " + String.valueOf(this.b) + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.v2.b
 * JD-Core Version:    0.7.0.1
 */