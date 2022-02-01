package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class QFragmentManagerState
  implements Parcelable
{
  public static final Parcelable.Creator<QFragmentManagerState> CREATOR = new QFragmentManagerState.1();
  QFragmentState[] mActive;
  int[] mAdded;
  QBackStackState[] mBackStack;
  
  public QFragmentManagerState() {}
  
  public QFragmentManagerState(Parcel paramParcel)
  {
    this.mActive = ((QFragmentState[])paramParcel.createTypedArray(QFragmentState.CREATOR));
    this.mAdded = paramParcel.createIntArray();
    try
    {
      this.mBackStack = ((QBackStackState[])paramParcel.createTypedArray(QBackStackState.CREATOR));
      return;
    }
    catch (OutOfMemoryError paramParcel)
    {
      this.mBackStack = null;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeTypedArray(this.mActive, paramInt);
    paramParcel.writeIntArray(this.mAdded);
    paramParcel.writeTypedArray(this.mBackStack, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.app.QFragmentManagerState
 * JD-Core Version:    0.7.0.1
 */