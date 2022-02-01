package com.tencent.mobileqq.activity.recent.parcelUtils.processor;

import android.os.Parcel;
import java.lang.reflect.Field;
import java.util.ArrayList;

public abstract class BaseParcelProcessor
{
  public abstract void a(Object paramObject, Parcel paramParcel, ArrayList<Field> paramArrayList);
  
  public boolean a(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel)
  {
    b(paramObject, paramArrayList, paramParcel);
    if (c(paramObject, paramArrayList, paramParcel)) {
      d(paramObject, paramArrayList, paramParcel);
    }
    return false;
  }
  
  abstract void b(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel);
  
  abstract boolean c(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel);
  
  abstract void d(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.parcelUtils.processor.BaseParcelProcessor
 * JD-Core Version:    0.7.0.1
 */