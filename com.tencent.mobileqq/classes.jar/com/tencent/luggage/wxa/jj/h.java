package com.tencent.luggage.wxa.jj;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.CallSuper;
import org.joor.Reflect;
import org.json.JSONObject;

public class h
  implements Parcelable
{
  public static final Parcelable.Creator<h> CREATOR = new h.1();
  public String D;
  public String E;
  public String F;
  public int G;
  public String H;
  public String I;
  public int J;
  public String K;
  
  public h() {}
  
  protected h(Parcel paramParcel)
  {
    this.D = paramParcel.readString();
    this.E = paramParcel.readString();
    this.F = paramParcel.readString();
    this.G = paramParcel.readInt();
    this.I = paramParcel.readString();
    this.H = paramParcel.readString();
    this.J = paramParcel.readInt();
    this.K = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public JSONObject l()
  {
    return null;
  }
  
  public h n()
  {
    Parcel localParcel = p();
    h localh = (h)Reflect.on(getClass()).create(new Object[] { localParcel }).get();
    localParcel.recycle();
    return localh;
  }
  
  public Parcel p()
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    return localParcel;
  }
  
  @CallSuper
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.D);
    paramParcel.writeString(this.E);
    paramParcel.writeString(this.F);
    paramParcel.writeInt(this.G);
    paramParcel.writeString(this.I);
    paramParcel.writeString(this.H);
    paramParcel.writeInt(this.J);
    paramParcel.writeString(this.K);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.h
 * JD-Core Version:    0.7.0.1
 */