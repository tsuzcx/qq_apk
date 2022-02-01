package com.tencent.biz.qrcode.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class ScannerParams$1
  implements Parcelable.Creator<ScannerParams>
{
  public ScannerParams a(Parcel paramParcel)
  {
    return new ScannerParams(paramParcel);
  }
  
  public ScannerParams[] a(int paramInt)
  {
    return new ScannerParams[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.ipc.ScannerParams.1
 * JD-Core Version:    0.7.0.1
 */