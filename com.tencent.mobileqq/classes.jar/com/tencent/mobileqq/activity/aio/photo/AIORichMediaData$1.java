package com.tencent.mobileqq.activity.aio.photo;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AIORichMediaData$1
  implements Parcelable.Creator<AIORichMediaData>
{
  public AIORichMediaData a(Parcel paramParcel)
  {
    Object localObject = paramParcel.readString();
    try
    {
      localObject = AIORichMediaData.a((String)localObject);
      ((AIORichMediaData)localObject).a(paramParcel);
      return localObject;
    }
    catch (ClassNotFoundException paramParcel)
    {
      throw new RuntimeException(paramParcel);
    }
  }
  
  public AIORichMediaData[] a(int paramInt)
  {
    return new AIORichMediaData[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIORichMediaData.1
 * JD-Core Version:    0.7.0.1
 */