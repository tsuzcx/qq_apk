package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class b
  implements Parcelable
{
  public static final Parcelable.Creator<b> CREATOR = new b.a();
  public String a;
  public Bundle b = null;
  private int c = 1;
  private Bundle d = null;
  
  public b() {}
  
  private b(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public b(String paramString, int paramInt)
  {
    this.a = paramString;
    this.c = paramInt;
  }
  
  private static ClassLoader a(Class paramClass)
  {
    return paramClass.getClassLoader();
  }
  
  private void a(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.a = paramParcel.readString();
    this.b = paramParcel.readBundle(a(Bundle.class));
    this.d = paramParcel.readBundle(a(Bundle.class));
  }
  
  public Bundle a()
  {
    return this.d;
  }
  
  public b a(Bundle paramBundle)
  {
    this.d = paramBundle;
    return this;
  }
  
  public int b()
  {
    if (this.d == null) {
      return 0;
    }
    return 1;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.a);
    paramParcel.writeBundle(this.b);
    paramParcel.writeBundle(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.core.aidl.b
 * JD-Core Version:    0.7.0.1
 */