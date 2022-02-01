package com.tencent.gdtad.api.interstitial;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.GdtAdParams;
import com.tencent.gdtad.log.GdtLog;
import org.json.JSONObject;

public class GdtInterstitialParams
  extends GdtAdParams
  implements Parcelable
{
  public static final Parcelable.Creator<GdtInterstitialParams> CREATOR = new GdtInterstitialParams.1();
  public JSONObject c;
  public GdtHandler.Options d;
  public int e = -2147483648;
  public boolean f;
  int g;
  int h;
  
  public GdtInterstitialParams()
  {
    this.f = false;
    this.g = -2147483648;
    this.h = -2147483648;
  }
  
  protected GdtInterstitialParams(Parcel paramParcel)
  {
    boolean bool = false;
    this.f = false;
    this.g = -2147483648;
    this.h = -2147483648;
    if (paramParcel == null)
    {
      GdtLog.d("GdtInterstitialParams", "GdtInterstitialParams(Parcel in) error");
      return;
    }
    String str = paramParcel.readString();
    if (!TextUtils.isEmpty(str)) {
      try
      {
        this.c = new JSONObject(str);
      }
      catch (Throwable localThrowable)
      {
        AdLog.e("GdtInterstitialParams", "GdtInterstitialParams(Parcel in)", localThrowable);
      }
    }
    this.d = ((GdtHandler.Options)paramParcel.readParcelable(GdtHandler.Options.class.getClassLoader()));
    this.e = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.f = bool;
  }
  
  public boolean a()
  {
    return (this.d != null) && (this.e != -2147483648);
  }
  
  boolean b()
  {
    return (a()) && (this.d.a());
  }
  
  String c()
  {
    if ((!a()) || (this.d.a == null) || (!this.d.a.isValid())) {
      return null;
    }
    return this.d.a.getTraceId();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (paramParcel == null)
    {
      GdtLog.d("GdtInterstitialParams", "writeToParcel error");
      return;
    }
    String str;
    if ((this.c != null) && (!JSONObject.NULL.equals(this.c))) {
      str = this.c.toString();
    } else {
      str = null;
    }
    paramParcel.writeString(str);
    paramParcel.writeParcelable(this.d, paramInt);
    paramParcel.writeInt(this.e);
    paramParcel.writeByte((byte)this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialParams
 * JD-Core Version:    0.7.0.1
 */