package com.tencent.luggage.wxa.hp;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class d
  implements a
{
  public Object a(Parcel paramParcel)
  {
    return paramParcel.readParcelable(getClass().getClassLoader());
  }
  
  public void a(@NonNull Object paramObject, Parcel paramParcel)
  {
    paramParcel.writeParcelable((Parcelable)paramObject, 0);
  }
  
  public boolean a(Object paramObject)
  {
    return paramObject instanceof Parcelable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hp.d
 * JD-Core Version:    0.7.0.1
 */