package com.tencent.mm.ui.widget.snackbar;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Snack$1
  implements Parcelable.Creator<Snack>
{
  public Snack createFromParcel(Parcel paramParcel)
  {
    return new Snack(paramParcel);
  }
  
  public Snack[] newArray(int paramInt)
  {
    return new Snack[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.Snack.1
 * JD-Core Version:    0.7.0.1
 */