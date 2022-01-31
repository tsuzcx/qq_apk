package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

public class StaggeredGridLayoutManager$SavedState
  implements Parcelable
{
  public static final Parcelable.Creator<SavedState> CREATOR = new StaggeredGridLayoutManager.SavedState.1();
  boolean mAnchorLayoutFromEnd;
  int mAnchorPosition;
  List<StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem> mFullSpanItems;
  boolean mLastLayoutRTL;
  boolean mReverseLayout;
  int[] mSpanLookup;
  int mSpanLookupSize;
  int[] mSpanOffsets;
  int mSpanOffsetsSize;
  int mVisibleAnchorPosition;
  
  public StaggeredGridLayoutManager$SavedState() {}
  
  StaggeredGridLayoutManager$SavedState(Parcel paramParcel)
  {
    this.mAnchorPosition = paramParcel.readInt();
    this.mVisibleAnchorPosition = paramParcel.readInt();
    this.mSpanOffsetsSize = paramParcel.readInt();
    if (this.mSpanOffsetsSize > 0)
    {
      this.mSpanOffsets = new int[this.mSpanOffsetsSize];
      paramParcel.readIntArray(this.mSpanOffsets);
    }
    this.mSpanLookupSize = paramParcel.readInt();
    if (this.mSpanLookupSize > 0)
    {
      this.mSpanLookup = new int[this.mSpanLookupSize];
      paramParcel.readIntArray(this.mSpanLookup);
    }
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      this.mReverseLayout = bool1;
      if (paramParcel.readInt() != 1) {
        break label152;
      }
      bool1 = true;
      label113:
      this.mAnchorLayoutFromEnd = bool1;
      if (paramParcel.readInt() != 1) {
        break label157;
      }
    }
    label152:
    label157:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.mLastLayoutRTL = bool1;
      this.mFullSpanItems = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label113;
    }
  }
  
  public StaggeredGridLayoutManager$SavedState(SavedState paramSavedState)
  {
    this.mSpanOffsetsSize = paramSavedState.mSpanOffsetsSize;
    this.mAnchorPosition = paramSavedState.mAnchorPosition;
    this.mVisibleAnchorPosition = paramSavedState.mVisibleAnchorPosition;
    this.mSpanOffsets = paramSavedState.mSpanOffsets;
    this.mSpanLookupSize = paramSavedState.mSpanLookupSize;
    this.mSpanLookup = paramSavedState.mSpanLookup;
    this.mReverseLayout = paramSavedState.mReverseLayout;
    this.mAnchorLayoutFromEnd = paramSavedState.mAnchorLayoutFromEnd;
    this.mLastLayoutRTL = paramSavedState.mLastLayoutRTL;
    this.mFullSpanItems = paramSavedState.mFullSpanItems;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  void invalidateAnchorPositionInfo()
  {
    this.mSpanOffsets = null;
    this.mSpanOffsetsSize = 0;
    this.mAnchorPosition = -1;
    this.mVisibleAnchorPosition = -1;
  }
  
  void invalidateSpanInfo()
  {
    this.mSpanOffsets = null;
    this.mSpanOffsetsSize = 0;
    this.mSpanLookupSize = 0;
    this.mSpanLookup = null;
    this.mFullSpanItems = null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeInt(this.mAnchorPosition);
    paramParcel.writeInt(this.mVisibleAnchorPosition);
    paramParcel.writeInt(this.mSpanOffsetsSize);
    if (this.mSpanOffsetsSize > 0) {
      paramParcel.writeIntArray(this.mSpanOffsets);
    }
    paramParcel.writeInt(this.mSpanLookupSize);
    if (this.mSpanLookupSize > 0) {
      paramParcel.writeIntArray(this.mSpanLookup);
    }
    if (this.mReverseLayout)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.mAnchorLayoutFromEnd) {
        break label120;
      }
      paramInt = 1;
      label87:
      paramParcel.writeInt(paramInt);
      if (!this.mLastLayoutRTL) {
        break label125;
      }
    }
    label120:
    label125:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeList(this.mFullSpanItems);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label87;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */