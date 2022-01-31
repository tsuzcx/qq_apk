package com.tencent.mobileqq.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import ztb;

public class RoamInfoListWrapper
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new ztb();
  public ArrayList a;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.RoamInfoListWrapper
 * JD-Core Version:    0.7.0.1
 */