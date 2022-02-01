package com.tencent.luggage.wxa.jc;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ja.d;
import java.util.Objects;

public class o
  extends a
{
  public static final Parcelable.Creator<o> CREATOR = new o.1();
  public j b;
  
  public o() {}
  
  public o(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    this.b = ((j)paramParcel.readParcelable(o.class.getClassLoader()));
  }
  
  public boolean a(d paramd, Canvas paramCanvas)
  {
    j localj = this.b;
    if (localj == null) {
      return false;
    }
    return localj.a(paramd, paramCanvas);
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
    if (!(paramObject instanceof o)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (o)paramObject;
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
 * Qualified Name:     com.tencent.luggage.wxa.jc.o
 * JD-Core Version:    0.7.0.1
 */