package androidx.viewpager2.adapter;

import android.os.Parcelable;
import androidx.annotation.NonNull;

public abstract interface StatefulAdapter
{
  public abstract void restoreState(@NonNull Parcelable paramParcelable);
  
  @NonNull
  public abstract Parcelable saveState();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.adapter.StatefulAdapter
 * JD-Core Version:    0.7.0.1
 */