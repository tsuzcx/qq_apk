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
    int i = this.mSpanOffsetsSize;
    if (i > 0)
    {
      this.mSpanOffsets = new int[i];
      paramParcel.readIntArray(this.mSpanOffsets);
    }
    this.mSpanLookupSize = paramParcel.readInt();
    i = this.mSpanLookupSize;
    if (i > 0)
    {
      this.mSpanLookup = new int[i];
      paramParcel.readIntArray(this.mSpanLookup);
    }
    i = paramParcel.readInt();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mReverseLayout = bool1;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mAnchorLayoutFromEnd = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    }
    this.mLastLayoutRTL = bool1;
    this.mFullSpanItems = paramParcel.readArrayList(StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.class.getClassLoader());
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.SavedState
 * JD-Core Version:    0.7.0.1
 */