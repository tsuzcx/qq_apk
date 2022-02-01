package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class SendInfo$1
  implements Parcelable.Creator<SendInfo>
{
  public SendInfo a(Parcel paramParcel)
  {
    return new SendInfo(paramParcel, null);
  }
  
  public SendInfo[] a(int paramInt)
  {
    return new SendInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.util.file.SendInfo.1
 * JD-Core Version:    0.7.0.1
 */