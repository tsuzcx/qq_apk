package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import androidx.annotation.NonNull;

class FragmentTabHost$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new FragmentTabHost.SavedState.1();
  String curTab;
  
  FragmentTabHost$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.curTab = paramParcel.readString();
  }
  
  FragmentTabHost$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FragmentTabHost.SavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" curTab=");
    localStringBuilder.append(this.curTab);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.curTab);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentTabHost.SavedState
 * JD-Core Version:    0.7.0.1
 */