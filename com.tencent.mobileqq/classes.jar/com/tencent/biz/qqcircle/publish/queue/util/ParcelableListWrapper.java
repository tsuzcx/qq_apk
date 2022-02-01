package com.tencent.biz.qqcircle.publish.queue.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class ParcelableListWrapper
  implements Parcelable
{
  public static final Parcelable.Creator<ParcelableListWrapper> CREATOR = new ParcelableListWrapper.1();
  private static ParcelableListWrapper[] b = new ParcelableListWrapper[5];
  private ArrayList a;
  
  ParcelableListWrapper(ArrayList<? extends SmartParcelable> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public static ArrayList<? extends SmartParcelable> a(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    int i = paramParcel.readInt();
    if (i < 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(i);
    a(paramParcel, localArrayList, i, paramClassLoader);
    return localArrayList;
  }
  
  public static void a(Parcel paramParcel, List<? extends SmartParcelable> paramList)
  {
    if (paramList == null)
    {
      paramParcel.writeInt(-1);
      return;
    }
    int j = paramList.size();
    int i = 0;
    paramParcel.writeInt(j);
    while (i < j)
    {
      ParcelableWrapper localParcelableWrapper = ParcelableWrapper.a((SmartParcelable)paramList.get(i));
      paramParcel.writeValue(localParcelableWrapper);
      ParcelableWrapper.a(localParcelableWrapper);
      i += 1;
    }
  }
  
  private static void a(Parcel paramParcel, List paramList, int paramInt, ClassLoader paramClassLoader)
  {
    while (paramInt > 0)
    {
      paramList.add(((ParcelableWrapper)paramParcel.readValue(paramClassLoader)).a());
      paramInt -= 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a(paramParcel, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.queue.util.ParcelableListWrapper
 * JD-Core Version:    0.7.0.1
 */