package com.tencent.luggage.wxa.k;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.b;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class a
  implements Parcelable, Comparator<a.a>
{
  public static final Parcelable.Creator<a> CREATOR = new a.1();
  public final int a;
  private final a.a[] b;
  private int c;
  
  a(Parcel paramParcel)
  {
    this.b = ((a.a[])paramParcel.createTypedArray(a.a.CREATOR));
    this.a = this.b.length;
  }
  
  public a(List<a.a> paramList)
  {
    this(false, (a.a[])paramList.toArray(new a.a[paramList.size()]));
  }
  
  private a(boolean paramBoolean, a.a... paramVarArgs)
  {
    a.a[] arrayOfa = paramVarArgs;
    if (paramBoolean) {
      arrayOfa = (a.a[])paramVarArgs.clone();
    }
    Arrays.sort(arrayOfa, this);
    int i = 1;
    while (i < arrayOfa.length) {
      if (!a.a.a(arrayOfa[(i - 1)]).equals(a.a.a(arrayOfa[i])))
      {
        i += 1;
      }
      else
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("Duplicate data for uuid: ");
        paramVarArgs.append(a.a.a(arrayOfa[i]));
        throw new IllegalArgumentException(paramVarArgs.toString());
      }
    }
    this.b = arrayOfa;
    this.a = arrayOfa.length;
  }
  
  public a(a.a... paramVarArgs)
  {
    this(true, paramVarArgs);
  }
  
  public int a(a.a parama1, a.a parama2)
  {
    if (b.b.equals(a.a.a(parama1)))
    {
      if (b.b.equals(a.a.a(parama2))) {
        return 0;
      }
      return 1;
    }
    return a.a.a(parama1).compareTo(a.a.a(parama2));
  }
  
  public a.a a(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public a a(@Nullable String paramString)
  {
    a.a[] arrayOfa = this.b;
    int k = arrayOfa.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      if (!x.a(arrayOfa[i].a, paramString))
      {
        i = 1;
        break label49;
      }
      i += 1;
    }
    i = 0;
    label49:
    if (i != 0)
    {
      arrayOfa = new a.a[this.b.length];
      i = j;
      while (i < arrayOfa.length)
      {
        arrayOfa[i] = this.b[i].a(paramString);
        i += 1;
      }
      return new a(arrayOfa);
    }
    return this;
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
    if ((paramObject != null) && (getClass() == paramObject.getClass())) {
      return Arrays.equals(this.b, ((a)paramObject).b);
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.c == 0) {
      this.c = Arrays.hashCode(this.b);
    }
    return this.c;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.k.a
 * JD-Core Version:    0.7.0.1
 */