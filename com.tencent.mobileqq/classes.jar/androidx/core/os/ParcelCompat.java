package androidx.core.os;

import android.os.Parcel;
import androidx.annotation.NonNull;

public final class ParcelCompat
{
  public static boolean readBoolean(@NonNull Parcel paramParcel)
  {
    return paramParcel.readInt() != 0;
  }
  
  public static void writeBoolean(@NonNull Parcel paramParcel, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.os.ParcelCompat
 * JD-Core Version:    0.7.0.1
 */