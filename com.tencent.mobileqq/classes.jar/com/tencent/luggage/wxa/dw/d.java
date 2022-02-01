package com.tencent.luggage.wxa.dw;

import android.os.Parcel;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;

public enum d
{
  private d() {}
  
  public static d a(@NonNull Parcel paramParcel)
  {
    int j = paramParcel.readInt();
    paramParcel = values();
    int k = paramParcel.length;
    int i = 0;
    while (i < k)
    {
      d locald = paramParcel[i];
      if (j == locald.ordinal()) {
        return locald;
      }
      i += 1;
    }
    o.b("Luggage.WxaColdStartMode", "readFromParcel get unrecognized ordinal %d", new Object[] { Integer.valueOf(j) });
    return a;
  }
  
  public static void a(d paramd, @NonNull Parcel paramParcel)
  {
    paramParcel.writeInt(paramd.ordinal());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dw.d
 * JD-Core Version:    0.7.0.1
 */