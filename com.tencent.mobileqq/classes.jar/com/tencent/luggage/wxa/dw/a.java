package com.tencent.luggage.wxa.dw;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;

public class a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new a.2();
  private final ResultReceiver a;
  
  private a(Parcel paramParcel)
  {
    this.a = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    this.a.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dw.a
 * JD-Core Version:    0.7.0.1
 */