package com.tencent.component.network.downloader;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class DownloadResult$1
  implements Parcelable.Creator<DownloadResult>
{
  public DownloadResult createFromParcel(Parcel paramParcel)
  {
    return new DownloadResult(paramParcel);
  }
  
  public DownloadResult[] newArray(int paramInt)
  {
    return new DownloadResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.DownloadResult.1
 * JD-Core Version:    0.7.0.1
 */