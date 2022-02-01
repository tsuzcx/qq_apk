package com.tencent.luggage.wxa.dw;

import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class c<R extends Parcelable>
  implements Parcelable
{
  public static final Parcelable.Creator<c> CREATOR = new c.3();
  private final b<R> a;
  private final ResultReceiver b;
  
  private c(Parcel paramParcel)
  {
    this.b = ((ResultReceiver)ResultReceiver.CREATOR.createFromParcel(paramParcel));
    this.a = new c.2(this);
  }
  
  private c(@NonNull b<R> paramb)
  {
    this.a = paramb;
    this.b = new c.1(this, new Handler(Looper.getMainLooper()), paramb);
  }
  
  public static <R extends Parcelable> b<R> a(@NonNull Parcel paramParcel)
  {
    paramParcel = (c)paramParcel.readParcelable(c.class.getClassLoader());
    if (paramParcel != null) {
      return paramParcel.a;
    }
    return null;
  }
  
  public static <R extends Parcelable> void a(@Nullable b<R> paramb, @NonNull Parcel paramParcel)
  {
    if (paramb == null)
    {
      paramParcel.writeString(null);
      return;
    }
    paramParcel.writeParcelable(new c(paramb), 0);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    this.b.writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dw.c
 * JD-Core Version:    0.7.0.1
 */