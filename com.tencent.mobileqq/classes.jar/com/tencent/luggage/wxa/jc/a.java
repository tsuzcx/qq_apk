package com.tencent.luggage.wxa.jc;

import android.graphics.Canvas;
import android.os.Parcel;
import com.tencent.luggage.wxa.ja.d;

public abstract class a
  implements c
{
  public String a;
  
  public a() {}
  
  @Deprecated
  public a(Parcel paramParcel)
  {
    a(paramParcel);
  }
  
  public a(Parcel paramParcel, Object paramObject)
  {
    this.a = paramParcel.readString();
  }
  
  @Deprecated
  public void a(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }
  
  public boolean a(d paramd, Canvas paramCanvas)
  {
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof a))
    {
      Object localObject = (a)paramObject;
      paramObject = this.a;
      localObject = ((a)localObject).a;
      if (paramObject == localObject) {
        return true;
      }
      if ((paramObject != null) && (paramObject.equals(localObject))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return String.format("method %s", new Object[] { this.a });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jc.a
 * JD-Core Version:    0.7.0.1
 */