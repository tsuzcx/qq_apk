package com.tencent.luggage.wxa.on;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.j;
import com.tencent.luggage.wxa.qw.as;
import java.util.LinkedList;
import java.util.Locale;

public final class b
  implements Parcelable, j
{
  public static final Parcelable.Creator<b> CREATOR = new b.1();
  final byte[] a;
  final byte[] b;
  final byte[] c;
  
  private b(Parcel paramParcel)
  {
    this.a = paramParcel.createByteArray();
    this.b = paramParcel.createByteArray();
    this.c = paramParcel.createByteArray();
  }
  
  public b(@NonNull as paramas)
  {
    this.a = paramas.a.c();
    this.b = ((com.tencent.luggage.wxa.qu.b)paramas.b.get(0)).c();
    this.c = ((com.tencent.luggage.wxa.qu.b)paramas.b.get(1)).c();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NonNull
  public String toString()
  {
    return String.format(Locale.US, "PermissionBundle[%d][%d][%d]", new Object[] { Integer.valueOf(this.a.length), Integer.valueOf(this.b.length), Integer.valueOf(this.c.length) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.a);
    paramParcel.writeByteArray(this.b);
    paramParcel.writeByteArray(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.on.b
 * JD-Core Version:    0.7.0.1
 */