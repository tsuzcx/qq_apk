package com.tencent.avgame.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.HashMap;

final class MapParcelable$1
  implements Parcelable.Creator<MapParcelable>
{
  public MapParcelable a(Parcel paramParcel)
  {
    MapParcelable localMapParcelable = new MapParcelable();
    localMapParcelable.a = paramParcel.readHashMap(HashMap.class.getClassLoader());
    return localMapParcelable;
  }
  
  public MapParcelable[] a(int paramInt)
  {
    return new MapParcelable[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ipc.MapParcelable.1
 * JD-Core Version:    0.7.0.1
 */