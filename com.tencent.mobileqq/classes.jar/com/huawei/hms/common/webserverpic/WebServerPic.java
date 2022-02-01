package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

public class WebServerPic
{
  public static final Parcelable.Creator<WebServerPic> CREATOR = new a();
  private final Uri a;
  private final int b;
  private final int c;
  
  public WebServerPic(Uri paramUri)
  {
    this(paramUri, 0, 0);
  }
  
  public WebServerPic(Uri paramUri, int paramInt1, int paramInt2)
  {
    this.a = paramUri;
    this.b = paramInt1;
    this.c = paramInt2;
    if (paramUri == null) {
      throw new IllegalArgumentException("url is not able to be null");
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("width and height should be positive or 0");
    }
  }
  
  public final int getHeight()
  {
    return this.c;
  }
  
  public final Uri getUrl()
  {
    return this.a;
  }
  
  public final int getWidth()
  {
    return this.b;
  }
  
  public final String toString()
  {
    return String.format(Locale.ENGLISH, "Image %dx%d %s", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.c), this.a.toString() });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Preconditions.checkNotNull(paramParcel);
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeParcelable(paramParcel, 1, getUrl(), paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 2, getWidth());
    SafeParcelWriter.writeInt(paramParcel, 3, getHeight());
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.webserverpic.WebServerPic
 * JD-Core Version:    0.7.0.1
 */