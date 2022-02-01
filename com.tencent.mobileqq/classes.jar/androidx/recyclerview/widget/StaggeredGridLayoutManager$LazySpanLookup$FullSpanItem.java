package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

@SuppressLint({"BanParcelableUsage"})
class StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem
  implements Parcelable
{
  public static final Parcelable.Creator<FullSpanItem> CREATOR = new StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1();
  int mGapDir;
  int[] mGapPerSpan;
  boolean mHasUnwantedGapAfter;
  int mPosition;
  
  StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem() {}
  
  StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem(Parcel paramParcel)
  {
    this.mPosition = paramParcel.readInt();
    this.mGapDir = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.mHasUnwantedGapAfter = bool;
      int i = paramParcel.readInt();
      if (i > 0)
      {
        this.mGapPerSpan = new int[i];
        paramParcel.readIntArray(this.mGapPerSpan);
      }
      return;
      bool = false;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getGapForSpan(int paramInt)
  {
    if (this.mGapPerSpan == null) {
      return 0;
    }
    return this.mGapPerSpan[paramInt];
  }
  
  public String toString()
  {
    return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mPosition);
    paramParcel.writeInt(this.mGapDir);
    if (this.mHasUnwantedGapAfter) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      if ((this.mGapPerSpan == null) || (this.mGapPerSpan.length <= 0)) {
        break;
      }
      paramParcel.writeInt(this.mGapPerSpan.length);
      paramParcel.writeIntArray(this.mGapPerSpan);
      return;
    }
    paramParcel.writeInt(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem
 * JD-Core Version:    0.7.0.1
 */