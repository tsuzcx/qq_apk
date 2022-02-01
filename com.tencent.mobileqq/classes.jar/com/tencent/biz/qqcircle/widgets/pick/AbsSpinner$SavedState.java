package com.tencent.biz.qqcircle.widgets.pick;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class AbsSpinner$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new AbsSpinner.SavedState.1();
  long a;
  int b;
  
  private AbsSpinner$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readLong();
    this.b = paramParcel.readInt();
  }
  
  AbsSpinner$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AbsSpinner.SavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" selectedId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" position=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeLong(this.a);
    paramParcel.writeInt(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pick.AbsSpinner.SavedState
 * JD-Core Version:    0.7.0.1
 */