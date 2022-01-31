package com.tencent.component.app.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

final class ParcelableWrapper$1
  implements Parcelable.Creator<ParcelableWrapper>
{
  public ParcelableWrapper createFromParcel(Parcel paramParcel)
  {
    ParcelableWrapper localParcelableWrapper = new ParcelableWrapper(null);
    Object localObject1 = paramParcel.readString();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return localParcelableWrapper;
    }
    Object localObject3 = ParcelableWrapper.access$400((String)localObject1, null);
    Object localObject2 = ParcelableWrapper.ParcableInfo.access$100((ParcelableWrapper.ParcableInfo)localObject3);
    localObject1 = ParcelableWrapper.ParcableInfo.access$200((ParcelableWrapper.ParcableInfo)localObject3);
    localObject3 = ParcelableWrapper.ParcableInfo.access$000((ParcelableWrapper.ParcableInfo)localObject3);
    int i;
    Field localField;
    try
    {
      localObject3 = (SmartParcelable)((Class)localObject3).newInstance();
      ParcelableWrapper.access$502(localParcelableWrapper, (SmartParcelable)localObject3);
      localObject2 = ((List)localObject2).iterator();
      i = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localField = (Field)((Iterator)localObject2).next();
        switch (((Integer)((List)localObject1).get(i)).intValue())
        {
        case 5: 
          localField.set(localObject3, paramParcel.readString());
        }
      }
    }
    catch (Exception paramParcel)
    {
      QZLog.e("ParcelableWrapper", "ParcelableWrapper.createFromParcel:", paramParcel);
    }
    return localParcelableWrapper;
    localField.set(localObject3, ParcelableWrapper.access$500((ParcelableWrapper)paramParcel.readParcelable(ParcelableWrapper.access$600())));
    break label445;
    localField.setInt(localObject3, paramParcel.readInt());
    break label445;
    localField.set(localObject3, paramParcel.readParcelable(ParcelableWrapper.access$600()));
    break label445;
    if (paramParcel.readByte() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localField.setBoolean(localObject3, bool);
      break label445;
      localField.setLong(localObject3, paramParcel.readLong());
      break label445;
      localField.setDouble(localObject3, paramParcel.readDouble());
      break label445;
      localField.setFloat(localObject3, paramParcel.readFloat());
      break label445;
      localField.setByte(localObject3, paramParcel.readByte());
      break label445;
      localField.set(localObject3, ParcelableWrapper.readArrayList(paramParcel, ParcelableWrapper.access$600()));
      break label445;
      localField.set(localObject3, ParcelableWrapper.readHashMap(paramParcel, ParcelableWrapper.access$600()));
      break label445;
      localField.set(localObject3, paramParcel.readSerializable());
      break label445;
      localField.set(localObject3, paramParcel.createStringArray());
      break label445;
      localField.set(localObject3, paramParcel.createByteArray());
      break label445;
      localField.set(localObject3, paramParcel.readValue(ParcelableWrapper.access$600()));
      label445:
      i += 1;
      break;
    }
  }
  
  public ParcelableWrapper[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.app.common.ParcelableWrapper.1
 * JD-Core Version:    0.7.0.1
 */