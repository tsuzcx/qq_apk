package com.tencent.luggage.wxa.jc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.Objects;

public class w
  extends a
{
  public static final Parcelable.Creator<w> CREATOR = new w.1();
  public float[] b = null;
  public float c = 1.4E-45F;
  
  public w() {}
  
  public w(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public void a(Parcel paramParcel)
  {
    super.a(paramParcel);
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.b = new float[i];
      paramParcel.readFloatArray(this.b);
    }
    this.c = paramParcel.readFloat();
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
    if (!(paramObject instanceof w)) {
      return false;
    }
    if (!super.equals(paramObject)) {
      return false;
    }
    paramObject = (w)paramObject;
    return (Float.compare(paramObject.c, this.c) == 0) && (Arrays.equals(this.b, paramObject.b));
  }
  
  public int hashCode()
  {
    return Objects.hash(new Object[] { Integer.valueOf(super.hashCode()), Float.valueOf(this.c) }) * 31 + Arrays.hashCode(this.b);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    float[] arrayOfFloat = this.b;
    if (arrayOfFloat != null)
    {
      paramParcel.writeInt(arrayOfFloat.length);
      paramParcel.writeFloatArray(this.b);
    }
    paramParcel.writeFloat(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jc.w
 * JD-Core Version:    0.7.0.1
 */