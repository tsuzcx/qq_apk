package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import java.io.InputStream;
import java.util.Locale;

public final class c
  extends a
{
  public static final Parcelable.Creator<c> CREATOR = new c.1();
  public static final c a = new c();
  private final af b = new af();
  
  public c()
  {
    af localaf = this.b;
    localaf.d = true;
    localaf.b = 0;
    localaf.pkgVersion = u.a;
    this.b.md5 = "";
  }
  
  private c(Parcel paramParcel)
  {
    this();
  }
  
  public InputStream c(String paramString)
  {
    return u.a(paramString);
  }
  
  public void close() {}
  
  public void d() {}
  
  public int describeContents()
  {
    return 0;
  }
  
  @NonNull
  public af e()
  {
    return this.b;
  }
  
  public String toString()
  {
    return String.format(Locale.ENGLISH, "AssetReader[%d][%s]", new Object[] { Integer.valueOf(c()), a() });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.c
 * JD-Core Version:    0.7.0.1
 */