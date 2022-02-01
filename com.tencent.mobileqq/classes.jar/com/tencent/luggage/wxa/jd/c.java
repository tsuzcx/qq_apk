package com.tencent.luggage.wxa.jd;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class c
  extends com.tencent.luggage.wxa.jc.a
{
  public static final Parcelable.Creator<c> CREATOR = new c.1();
  public List<a> b = new ArrayList();
  
  public c() {}
  
  public c(Parcel paramParcel)
  {
    this(paramParcel, null);
  }
  
  public c(Parcel paramParcel, Object paramObject)
  {
    super(paramParcel, paramObject);
    this.b = paramParcel.readArrayList(c.class.getClassLoader());
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!super.equals(paramObject)) {
      return false;
    }
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      return this.b.equals(paramObject.b);
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeList(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jd.c
 * JD-Core Version:    0.7.0.1
 */