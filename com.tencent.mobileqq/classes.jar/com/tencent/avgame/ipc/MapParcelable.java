package com.tencent.avgame.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.HashMap;

public class MapParcelable
  implements Parcelable
{
  public static final Parcelable.Creator<MapParcelable> CREATOR = new MapParcelable.1();
  public HashMap<String, String> a = new HashMap();
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeMap(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ipc.MapParcelable
 * JD-Core Version:    0.7.0.1
 */