package com.tencent.luggage.wxa.jc;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ja.d;
import java.util.Objects;

public class ab
  extends a
{
  public static final Parcelable.Creator<ab> CREATOR = new ab.1();
  public k b;
  
  public ab() {}
  
  public ab(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.b = ((k)paramParcel.readParcelable(ab.class.getClassLoader()));
  }
  
  public boolean a(d paramd, Canvas paramCanvas)
  {
    k localk = this.b;
    if (localk == null) {
      return false;
    }
    return localk.a(paramd, paramCanvas);
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
    if (!(paramObject instanceof ab)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (ab)paramObject;
    return Objects.equals(this.b, paramObject.b);
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), this.b });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.b, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jc.ab
 * JD-Core Version:    0.7.0.1
 */