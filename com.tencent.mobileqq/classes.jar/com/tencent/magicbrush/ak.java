package com.tencent.magicbrush;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/V8RawPointer;", "", "isolatePtr", "", "contextPtr", "uvLoopPtr", "(JJJ)V", "getContextPtr", "()J", "getIsolatePtr", "getUvLoopPtr", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class ak
{
  private final long a;
  private final long b;
  private final long c;
  
  public ak(long paramLong1, long paramLong2, long paramLong3)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public final long c()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof ak))
      {
        paramObject = (ak)paramObject;
        int i;
        if (this.a == paramObject.a) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if (this.b == paramObject.b) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            if (this.c == paramObject.c) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0) {
              return true;
            }
          }
        }
      }
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    long l = this.a;
    int i = (int)(l ^ l >>> 32);
    l = this.b;
    int j = (int)(l ^ l >>> 32);
    l = this.c;
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("V8RawPointer(isolatePtr=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", contextPtr=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", uvLoopPtr=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ak
 * JD-Core Version:    0.7.0.1
 */