package com.tencent.luggage.wxa.dw;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.o;

final class c$a
  implements Parcelable
{
  public static final Parcelable.Creator<a> CREATOR = new c.a.1();
  private Parcelable a;
  
  c$a(Parcel paramParcel)
  {
    String str = paramParcel.readString();
    if (TextUtils.isEmpty(str))
    {
      this.a = null;
      return;
    }
    try
    {
      this.a = paramParcel.readParcelable(Class.forName(str).getClassLoader());
      return;
    }
    catch (ClassNotFoundException paramParcel)
    {
      label38:
      break label38;
    }
    o.b("Luggage.WxaSDK.OnWXAppResultXPCWrapper", "ClassNotFoundException with %s", new Object[] { str });
  }
  
  c$a(Parcelable paramParcelable)
  {
    this.a = paramParcelable;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Parcelable localParcelable = this.a;
    if (localParcelable == null)
    {
      paramParcel.writeString(null);
      return;
    }
    paramParcel.writeString(localParcelable.getClass().getName());
    paramParcel.writeParcelable(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dw.c.a
 * JD-Core Version:    0.7.0.1
 */