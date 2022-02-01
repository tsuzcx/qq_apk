package com.tencent.luggage.wxaapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PreloadWxaProcessEnvResult$1
  implements Parcelable.Creator<PreloadWxaProcessEnvResult>
{
  public PreloadWxaProcessEnvResult createFromParcel(Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    paramParcel = PreloadWxaProcessEnvResult.values();
    int k = paramParcel.length;
    int i = 0;
    while (i < k)
    {
      PreloadWxaProcessEnvResult localPreloadWxaProcessEnvResult = paramParcel[i];
      if (localPreloadWxaProcessEnvResult.ordinal() == j) {
        return localPreloadWxaProcessEnvResult;
      }
      i += 1;
    }
    return PreloadWxaProcessEnvResult.Preload_Fail;
  }
  
  public PreloadWxaProcessEnvResult[] newArray(int paramInt)
  {
    return new PreloadWxaProcessEnvResult[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxaapi.PreloadWxaProcessEnvResult.1
 * JD-Core Version:    0.7.0.1
 */