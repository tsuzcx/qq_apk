package androidx.core.os;

import android.os.Parcelable.Creator;

@Deprecated
public final class ParcelableCompat
{
  @Deprecated
  public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> paramParcelableCompatCreatorCallbacks)
  {
    return new ParcelableCompat.ParcelableCompatCreatorHoneycombMR2(paramParcelableCompatCreatorCallbacks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.os.ParcelableCompat
 * JD-Core Version:    0.7.0.1
 */