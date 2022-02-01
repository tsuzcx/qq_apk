package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class a
  implements Parcelable.Creator<WebServerPic>
{
  public WebServerPic a(Parcel paramParcel)
  {
    return new WebServerPic((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()), paramParcel.readInt(), paramParcel.readInt());
  }
  
  public WebServerPic[] a(int paramInt)
  {
    return new WebServerPic[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.common.webserverpic.a
 * JD-Core Version:    0.7.0.1
 */