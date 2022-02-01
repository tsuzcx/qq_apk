package com.tencent.luggage.wxa.f;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;

public class a
  implements Parcelable, Comparable<a>
{
  public static final Parcelable.Creator<a> CREATOR = new a.1();
  private static final SparseArrayCompat<SparseArrayCompat<a>> a = new SparseArrayCompat(16);
  private final int b;
  private final int c;
  
  private a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public static a a(int paramInt1, int paramInt2)
  {
    int i = b(paramInt1, paramInt2);
    paramInt1 /= i;
    paramInt2 /= i;
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)a.get(paramInt1);
    if (localSparseArrayCompat == null)
    {
      localObject1 = new a(paramInt1, paramInt2);
      localObject2 = new SparseArrayCompat();
      ((SparseArrayCompat)localObject2).put(paramInt2, localObject1);
      a.put(paramInt1, localObject2);
      return localObject1;
    }
    Object localObject2 = (a)localSparseArrayCompat.get(paramInt2);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new a(paramInt1, paramInt2);
      localSparseArrayCompat.put(paramInt2, localObject1);
    }
    return localObject1;
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    int i;
    for (;;)
    {
      i = paramInt1;
      paramInt1 = paramInt2;
      if (paramInt1 == 0) {
        break;
      }
      paramInt2 = i % paramInt1;
    }
    return i;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(@NonNull a parama)
  {
    if (equals(parama)) {
      return 0;
    }
    if (c() - parama.c() > 0.0F) {
      return 1;
    }
    return -1;
  }
  
  public boolean a(q paramq)
  {
    int j = b(paramq.a(), paramq.b());
    int i = paramq.a() / j;
    j = paramq.b() / j;
    return (this.b == i) && (this.c == j);
  }
  
  public int b()
  {
    return this.c;
  }
  
  public float c()
  {
    return this.b / this.c;
  }
  
  public a d()
  {
    return a(this.c, this.b);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    boolean bool1 = bool2;
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      bool1 = bool2;
      if (this.b == paramObject.b)
      {
        bool1 = bool2;
        if (this.c == paramObject.c) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    int i = this.c;
    int j = this.b;
    return i ^ (j >>> 16 | j << 16);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(":");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.a
 * JD-Core Version:    0.7.0.1
 */