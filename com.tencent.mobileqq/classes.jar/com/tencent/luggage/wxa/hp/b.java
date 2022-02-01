package com.tencent.luggage.wxa.hp;

import android.os.Parcel;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.hj.p;

public class b
  implements a
{
  public Object a(Parcel paramParcel)
  {
    Object localObject = paramParcel.readString();
    paramParcel = paramParcel.readBundle();
    localObject = (com.tencent.luggage.wxa.hn.a)p.b((String)localObject, com.tencent.luggage.wxa.hn.a.class);
    if (localObject != null)
    {
      ((com.tencent.luggage.wxa.hn.a)localObject).a(paramParcel);
      return localObject;
    }
    return null;
  }
  
  public void a(@NonNull Object paramObject, Parcel paramParcel)
  {
    paramObject = (com.tencent.luggage.wxa.hn.a)paramObject;
    paramParcel.writeString(paramObject.getClass().getName());
    paramParcel.writeBundle(paramObject.a());
  }
  
  public boolean a(Object paramObject)
  {
    return paramObject instanceof com.tencent.luggage.wxa.hn.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hp.b
 * JD-Core Version:    0.7.0.1
 */