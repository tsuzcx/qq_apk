package com.tencent.luggage.wxa.hp;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class f$c
  implements Parcelable
{
  public static final Parcelable.Creator<c> CREATOR = new f.c.1();
  String a;
  Object b;
  
  private f$c() {}
  
  public f$c(String paramString, Object paramObject)
  {
    this.a = paramString;
    this.b = paramObject;
  }
  
  Object a()
  {
    return this.b;
  }
  
  void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    if (paramParcel.readInt() == 1) {
      this.b = c.a(paramParcel.readString(), paramParcel);
    }
  }
  
  String b()
  {
    return this.a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = c.a(localObject);
      if (localObject != null)
      {
        paramParcel.writeInt(1);
        paramParcel.writeString(localObject.getClass().getName());
        ((a)localObject).a(this.b, paramParcel);
        return;
      }
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hp.f.c
 * JD-Core Version:    0.7.0.1
 */