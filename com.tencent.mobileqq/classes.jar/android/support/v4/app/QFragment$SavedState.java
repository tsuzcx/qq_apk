package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QFragment$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new QFragment.SavedState.1();
  final Bundle mState;
  
  QFragment$SavedState(Bundle paramBundle)
  {
    this.mState = paramBundle;
  }
  
  QFragment$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    this.mState = paramParcel.readBundle();
    if ((paramClassLoader != null) && (this.mState != null)) {
      this.mState.setClassLoader(paramClassLoader);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.mState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     android.support.v4.app.QFragment.SavedState
 * JD-Core Version:    0.7.0.1
 */