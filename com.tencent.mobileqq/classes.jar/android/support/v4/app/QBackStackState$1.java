package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class QBackStackState$1
  implements Parcelable.Creator<QBackStackState>
{
  public QBackStackState createFromParcel(Parcel paramParcel)
  {
    return new QBackStackState(paramParcel);
  }
  
  public QBackStackState[] newArray(int paramInt)
  {
    return new QBackStackState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.app.QBackStackState.1
 * JD-Core Version:    0.7.0.1
 */