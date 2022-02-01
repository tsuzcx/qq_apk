package com.dataline.util.file;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class DLFileInfo$1
  implements Parcelable.Creator<DLFileInfo>
{
  public DLFileInfo a(Parcel paramParcel)
  {
    return new DLFileInfo(paramParcel, null);
  }
  
  public DLFileInfo[] a(int paramInt)
  {
    return new DLFileInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.util.file.DLFileInfo.1
 * JD-Core Version:    0.7.0.1
 */