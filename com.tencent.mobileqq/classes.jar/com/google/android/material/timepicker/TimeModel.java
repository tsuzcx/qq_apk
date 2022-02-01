package com.google.android.material.timepicker;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.IntRange;
import java.util.Arrays;

class TimeModel
  implements Parcelable
{
  public static final Parcelable.Creator<TimeModel> CREATOR = new TimeModel.1();
  final int a;
  int b;
  int c;
  int d;
  int e;
  private final MaxInputValidator f;
  private final MaxInputValidator g;
  
  public TimeModel()
  {
    this(0);
  }
  
  public TimeModel(int paramInt)
  {
    this(0, 0, 10, paramInt);
  }
  
  public TimeModel(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.a = paramInt4;
    this.e = d(paramInt1);
    this.f = new MaxInputValidator(59);
    if (paramInt4 == 1) {
      paramInt1 = 24;
    } else {
      paramInt1 = 12;
    }
    this.g = new MaxInputValidator(paramInt1);
  }
  
  protected TimeModel(Parcel paramParcel)
  {
    this(paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt());
  }
  
  public static String a(Resources paramResources, CharSequence paramCharSequence)
  {
    return a(paramResources, paramCharSequence, "%02d");
  }
  
  public static String a(Resources paramResources, CharSequence paramCharSequence, String paramString)
  {
    return String.format(paramResources.getConfiguration().locale, paramString, new Object[] { Integer.valueOf(Integer.parseInt(String.valueOf(paramCharSequence))) });
  }
  
  private static int d(int paramInt)
  {
    if (paramInt >= 12) {
      return 1;
    }
    return 0;
  }
  
  public int a()
  {
    if (this.a == 1) {
      return this.b % 24;
    }
    int j = this.b;
    if (j % 12 == 0) {
      return 12;
    }
    int i = j;
    if (this.e == 1) {
      i = j - 12;
    }
    return i;
  }
  
  public void a(int paramInt)
  {
    if (this.a == 1)
    {
      this.b = paramInt;
      return;
    }
    int i = 12;
    if (this.e != 1) {
      i = 0;
    }
    this.b = (paramInt % 12 + i);
  }
  
  public MaxInputValidator b()
  {
    return this.f;
  }
  
  public void b(@IntRange(from=0L, to=60L) int paramInt)
  {
    this.c = (paramInt % 60);
  }
  
  public MaxInputValidator c()
  {
    return this.g;
  }
  
  public void c(int paramInt)
  {
    if (paramInt != this.e)
    {
      this.e = paramInt;
      int i = this.b;
      if ((i < 12) && (paramInt == 1))
      {
        this.b = (i + 12);
        return;
      }
      i = this.b;
      if ((i >= 12) && (paramInt == 0)) {
        this.b = (i - 12);
      }
    }
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
    if (!(paramObject instanceof TimeModel)) {
      return false;
    }
    paramObject = (TimeModel)paramObject;
    return (this.b == paramObject.b) && (this.c == paramObject.c) && (this.a == paramObject.a) && (this.d == paramObject.d);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.timepicker.TimeModel
 * JD-Core Version:    0.7.0.1
 */