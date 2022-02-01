package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class AbsSavedState
  implements Parcelable
{
  public static final Parcelable.Creator<AbsSavedState> CREATOR = new AbsSavedState.2();
  public static final AbsSavedState EMPTY_STATE = new AbsSavedState.1();
  private final Parcelable mSuperState;
  
  private AbsSavedState()
  {
    this.mSuperState = null;
  }
  
  protected AbsSavedState(@NonNull Parcel paramParcel)
  {
    this(paramParcel, null);
  }
  
  protected AbsSavedState(@NonNull Parcel paramParcel, @Nullable ClassLoader paramClassLoader)
  {
    paramParcel = paramParcel.readParcelable(paramClassLoader);
    if (paramParcel == null) {
      paramParcel = EMPTY_STATE;
    }
    this.mSuperState = paramParcel;
  }
  
  protected AbsSavedState(@NonNull Parcelable paramParcelable)
  {
    if (paramParcelable != null)
    {
      if (paramParcelable == EMPTY_STATE) {
        paramParcelable = null;
      }
      this.mSuperState = paramParcelable;
      return;
    }
    throw new IllegalArgumentException("superState must not be null");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Nullable
  public final Parcelable getSuperState()
  {
    return this.mSuperState;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.mSuperState, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.customview.view.AbsSavedState
 * JD-Core Version:    0.7.0.1
 */