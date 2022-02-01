package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.RestrictTo;

@SuppressLint({"BanParcelableUsage"})
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class LinearLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new LinearLayoutManager.SavedState.1();
  boolean mAnchorLayoutFromEnd;
  int mAnchorOffset;
  int mAnchorPosition;
  
  public LinearLayoutManager$SavedState() {}
  
  LinearLayoutManager$SavedState(Parcel paramParcel)
  {
    this.mAnchorPosition = paramParcel.readInt();
    this.mAnchorOffset = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.mAnchorLayoutFromEnd = bool;
      return;
      bool = false;
    }
  }
  
  public LinearLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.mAnchorPosition = paramSavedState.mAnchorPosition;
    this.mAnchorOffset = paramSavedState.mAnchorOffset;
    this.mAnchorLayoutFromEnd = paramSavedState.mAnchorLayoutFromEnd;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  boolean hasValidAnchor()
  {
    return this.mAnchorPosition >= 0;
  }
  
  void invalidateAnchor()
  {
    this.mAnchorPosition = -1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mAnchorPosition);
    paramParcel.writeInt(this.mAnchorOffset);
    if (this.mAnchorLayoutFromEnd) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.LinearLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */