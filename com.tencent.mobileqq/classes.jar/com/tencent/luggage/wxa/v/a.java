package com.tencent.luggage.wxa.v;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

public final class a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new a.1();
  private final a.a[] a;
  
  a(Parcel paramParcel)
  {
    this.a = new a.a[paramParcel.readInt()];
    int i = 0;
    for (;;)
    {
      a.a[] arrayOfa = this.a;
      if (i >= arrayOfa.length) {
        break;
      }
      arrayOfa[i] = ((a.a)paramParcel.readParcelable(a.a.class.getClassLoader()));
      i += 1;
    }
  }
  
  public a(List<? extends a.a> paramList)
  {
    if (paramList != null)
    {
      this.a = new a.a[paramList.size()];
      paramList.toArray(this.a);
      return;
    }
    this.a = new a.a[0];
  }
  
  public a(a.a... paramVarArgs)
  {
    a.a[] arrayOfa = paramVarArgs;
    if (paramVarArgs == null) {
      arrayOfa = new a.a[0];
    }
    this.a = arrayOfa;
  }
  
  public int a()
  {
    return this.a.length;
  }
  
  public a.a a(int paramInt)
  {
    return this.a[paramInt];
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (a)paramObject;
      return Arrays.equals(this.a, paramObject.a);
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.a);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a.length);
    a.a[] arrayOfa = this.a;
    int i = arrayOfa.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramParcel.writeParcelable(arrayOfa[paramInt], 0);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.v.a
 * JD-Core Version:    0.7.0.1
 */