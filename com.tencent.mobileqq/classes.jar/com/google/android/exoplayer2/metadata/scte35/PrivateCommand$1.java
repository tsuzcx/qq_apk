package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PrivateCommand$1
  implements Parcelable.Creator<PrivateCommand>
{
  public PrivateCommand createFromParcel(Parcel paramParcel)
  {
    return new PrivateCommand(paramParcel, null);
  }
  
  public PrivateCommand[] newArray(int paramInt)
  {
    return new PrivateCommand[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.scte35.PrivateCommand.1
 * JD-Core Version:    0.7.0.1
 */