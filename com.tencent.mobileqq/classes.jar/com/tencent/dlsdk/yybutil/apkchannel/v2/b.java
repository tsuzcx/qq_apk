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
    if (!(paramObject instanceof b)) {
      return false;
    }
    paramObject = (b)paramObject;
    return (Objects.equals(paramObject.a, this.a)) && (Objects.equals(paramObject.b, this.b));
  }
  
  public int hashCode()
  {
    Object localObject = this.a;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    localObject = this.b;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i ^ j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Pair{");
    localStringBuilder.append(String.valueOf(this.a));
    localStringBuilder.append(" ");
    localStringBuilder.append(String.valueOf(this.b));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.v2.b
 * JD-Core Version:    0.7.0.1
 */