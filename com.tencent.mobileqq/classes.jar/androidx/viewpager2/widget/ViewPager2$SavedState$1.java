package androidx.viewpager2.widget;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class ViewPager2$SavedState$1
  implements Parcelable.ClassLoaderCreator<ViewPager2.SavedState>
{
  public ViewPager2.SavedState createFromParcel(Parcel paramParcel)
  {
    return createFromParcel(paramParcel, null);
  }
  
  public ViewPager2.SavedState createFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return new ViewPager2.SavedState(paramParcel, paramClassLoader);
    }
    return new ViewPager2.SavedState(paramParcel);
  }
  
  public ViewPager2.SavedState[] newArray(int paramInt)
  {
    return new ViewPager2.SavedState[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2.SavedState.1
 * JD-Core Version:    0.7.0.1
 */