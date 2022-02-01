package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FragmentState$1
  implements Parcelable.Creator<FragmentState>
{
  public FragmentState createFromParcel(Parcel paramParcel)
  {
    return new FragmentState(paramParcel);
  }
  
  public FragmentState[] newArray(int paramInt)
  {
    return new FragmentState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentState.1
 * JD-Core Version:    0.7.0.1
 */