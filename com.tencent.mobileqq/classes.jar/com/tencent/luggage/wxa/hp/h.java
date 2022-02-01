package com.tencent.luggage.wxa.hp;

import android.os.Parcel;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.hj.p;

public class h
  implements a
{
  public Object a(Parcel paramParcel)
  {
    g localg = (g)p.b(paramParcel.readString(), g.class);
    if (localg != null)
    {
      localg.b(paramParcel);
      return localg;
    }
    return null;
  }
  
  public void a(@NonNull Object paramObject, Parcel paramParcel)
  {
    paramObject = (g)paramObject;
    paramParcel.writeString(paramObject.getClass().getName());
    paramObject.a(paramParcel);
  }
  
  public boolean a(Object paramObject)
  {
    return paramObject instanceof g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hp.h
 * JD-Core Version:    0.7.0.1
 */