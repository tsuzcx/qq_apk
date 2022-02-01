package com.huawei.hms.common.webserverpic;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class WebServerPicCreator
  implements Parcelable.Creator<WebServerPic>
{
  public WebServerPic createFromParcel(Parcel paramParcel)
  {
    return new WebServerPic((Uri)paramParcel.readParcelable(Uri.class.getClassLoader()), paramParcel.readInt(), paramParcel.readInt());
  }
  
  public WebServerPic[] newArray(int paramInt)
  {
    return new WebServerPic[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.webserverpic.WebServerPicCreator
 * JD-Core Version:    0.7.0.1
 */