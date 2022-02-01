package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint({"BanParcelableUsage"})
public class Fragment$SavedState
  implements Parcelable
{
  @NonNull
  public static final Parcelable.Creator<SavedState> CREATOR = new Fragment.SavedState.1();
  final Bundle mState;
  
  Fragment$SavedState(Bundle paramBundle)
  {
    this.mState = paramBundle;
  }
  
  Fragment$SavedState(@NonNull Parcel paramParcel, @Nullable ClassLoader paramClassLoader)
  {
    this.mState = paramParcel.readBundle();
    if (paramClassLoader != null)
    {
      paramParcel = this.mState;
      if (paramParcel != null) {
        paramParcel.setClassLoader(paramClassLoader);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    paramParcel.writeBundle(this.mState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.Fragment.SavedState
 * JD-Core Version:    0.7.0.1
 */