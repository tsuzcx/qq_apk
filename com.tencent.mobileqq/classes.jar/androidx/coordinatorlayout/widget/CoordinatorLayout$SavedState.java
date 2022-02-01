package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import androidx.customview.view.AbsSavedState;

public class CoordinatorLayout$SavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new CoordinatorLayout.SavedState.1();
  SparseArray<Parcelable> behaviorStates;
  
  public CoordinatorLayout$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    int j = paramParcel.readInt();
    int[] arrayOfInt = new int[j];
    paramParcel.readIntArray(arrayOfInt);
    paramParcel = paramParcel.readParcelableArray(paramClassLoader);
    this.behaviorStates = new SparseArray(j);
    int i = 0;
    while (i < j)
    {
      this.behaviorStates.append(arrayOfInt[i], paramParcel[i]);
      i += 1;
    }
  }
  
  public CoordinatorLayout$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    Object localObject = this.behaviorStates;
    int j = 0;
    int i;
    if (localObject != null) {
      i = ((SparseArray)localObject).size();
    } else {
      i = 0;
    }
    paramParcel.writeInt(i);
    localObject = new int[i];
    Parcelable[] arrayOfParcelable = new Parcelable[i];
    while (j < i)
    {
      localObject[j] = this.behaviorStates.keyAt(j);
      arrayOfParcelable[j] = ((Parcelable)this.behaviorStates.valueAt(j));
      j += 1;
    }
    paramParcel.writeIntArray((int[])localObject);
    paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.coordinatorlayout.widget.CoordinatorLayout.SavedState
 * JD-Core Version:    0.7.0.1
 */