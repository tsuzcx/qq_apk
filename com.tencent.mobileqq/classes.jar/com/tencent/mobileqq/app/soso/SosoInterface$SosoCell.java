package com.tencent.mobileqq.app.soso;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class SosoInterface$SosoCell
  implements Parcelable, Comparable<SosoCell>
{
  public static final Parcelable.Creator<SosoCell> CREATOR = new SosoInterface.SosoCell.1();
  public int mCellId;
  public boolean mIsMainCell;
  public int mLac;
  public int mMcc;
  public int mMnc;
  public int mRss;
  
  public SosoInterface$SosoCell(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    this.mMcc = paramInt1;
    this.mMnc = paramInt2;
    this.mLac = paramInt3;
    this.mCellId = paramInt4;
    this.mRss = paramInt5;
    this.mIsMainCell = paramBoolean;
  }
  
  protected SosoInterface$SosoCell(Parcel paramParcel)
  {
    this.mMcc = paramParcel.readInt();
    this.mMnc = paramParcel.readInt();
    this.mLac = paramParcel.readInt();
    this.mCellId = paramParcel.readInt();
    this.mRss = paramParcel.readInt();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.mIsMainCell = bool;
      return;
    }
  }
  
  public int compareTo(SosoCell paramSosoCell)
  {
    return this.mCellId - paramSosoCell.mCellId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.mMcc);
    paramParcel.writeInt(this.mMnc);
    paramParcel.writeInt(this.mLac);
    paramParcel.writeInt(this.mCellId);
    paramParcel.writeInt(this.mRss);
    if (this.mIsMainCell) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.SosoCell
 * JD-Core Version:    0.7.0.1
 */