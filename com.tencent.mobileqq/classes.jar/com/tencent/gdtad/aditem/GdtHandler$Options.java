package com.tencent.gdtad.aditem;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONObject;

public class GdtHandler$Options
  implements Parcelable
{
  public static final Parcelable.Creator<Options> CREATOR = new GdtHandler.Options.1();
  public GdtAd a;
  public boolean b;
  public int c;
  public int d;
  public boolean e;
  public boolean f;
  public boolean g;
  public String h;
  public boolean i;
  public Rect j;
  public long k;
  public boolean l;
  public boolean m;
  public String n;
  public JSONObject o;
  public Bundle p;
  private boolean q;
  
  public GdtHandler$Options()
  {
    this.b = true;
    this.c = -2147483648;
    this.d = -2147483648;
    this.e = false;
    this.f = false;
    this.g = false;
    this.i = false;
    this.j = null;
    this.q = false;
    this.k = 0L;
    this.l = false;
    this.m = false;
    this.n = null;
    this.o = null;
  }
  
  protected GdtHandler$Options(Parcel paramParcel)
  {
    boolean bool2 = true;
    this.b = true;
    this.c = -2147483648;
    this.d = -2147483648;
    this.e = false;
    this.f = false;
    this.g = false;
    this.i = false;
    this.j = null;
    this.q = false;
    this.k = 0L;
    this.l = false;
    this.m = false;
    this.n = null;
    this.o = null;
    if (paramParcel == null)
    {
      GdtLog.d("GdtHandler", "Options(Parcel in) error");
      return;
    }
    this.a = ((GdtAd)paramParcel.readParcelable(GdtAd.class.getClassLoader()));
    boolean bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.e = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.f = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.g = bool1;
    this.h = paramParcel.readString();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.i = bool1;
    this.j = ((Rect)paramParcel.readParcelable(Rect.class.getClassLoader()));
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.q = bool1;
    this.k = paramParcel.readLong();
    if (paramParcel.readByte() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.l = bool1;
    if (paramParcel.readByte() != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.m = bool1;
    this.n = paramParcel.readString();
    this.p = paramParcel.readBundle();
    try
    {
      this.o = new JSONObject(paramParcel.readString());
      return;
    }
    catch (Throwable paramParcel)
    {
      GdtLog.d("GdtHandler", "Options(Parcel in)", paramParcel);
    }
  }
  
  public boolean a()
  {
    GdtAd localGdtAd = this.a;
    return (localGdtAd != null) && (localGdtAd.isValid()) && (!TextUtils.isEmpty(this.a.getTraceId())) && (!TextUtils.isEmpty(this.a.getUrlForImpression())) && (!TextUtils.isEmpty(this.a.getUrlForClick())) && (!TextUtils.isEmpty(this.a.getUrlForEffect())) && (!TextUtils.isEmpty(this.a.getUrlForAction())) && (!TextUtils.isEmpty(this.a.getUrlForLandingPage()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null)
    {
      GdtLog.d("GdtHandler", "writeToParcel error");
      return;
    }
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeByte((byte)this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeByte((byte)this.e);
    paramParcel.writeByte((byte)this.f);
    paramParcel.writeByte((byte)this.g);
    paramParcel.writeString(this.h);
    paramParcel.writeByte((byte)this.i);
    paramParcel.writeParcelable(this.j, paramInt);
    paramParcel.writeByte((byte)this.q);
    paramParcel.writeLong(this.k);
    paramParcel.writeByte((byte)this.l);
    paramParcel.writeByte((byte)this.m);
    paramParcel.writeString(this.n);
    paramParcel.writeBundle(this.p);
    String str;
    if ((this.o != null) && (!JSONObject.NULL.equals(this.o))) {
      str = this.o.toString();
    } else {
      str = null;
    }
    paramParcel.writeString(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler.Options
 * JD-Core Version:    0.7.0.1
 */