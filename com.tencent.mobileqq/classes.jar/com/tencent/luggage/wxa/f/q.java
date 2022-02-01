package com.tencent.luggage.wxa.f;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;

public class q
  implements Parcelable, Comparable<q>
{
  public static final Parcelable.Creator<q> CREATOR = new q.1();
  private final int a;
  private final int b;
  
  public q(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int a(@NonNull q paramq)
  {
    return this.a * this.b - paramq.a * paramq.b;
  }
  
  public int b()
  {
    return this.b;
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
    if ((paramObject instanceof q))
    {
      paramObject = (q)paramObject;
      bool1 = bool2;
      if (this.a == paramObject.a)
      {
        bool1 = bool2;
        if (this.b == paramObject.b) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    int i = this.b;
    int j = this.a;
    return i ^ (j >>> 16 | j << 16);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("x");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.q
 * JD-Core Version:    0.7.0.1
 */