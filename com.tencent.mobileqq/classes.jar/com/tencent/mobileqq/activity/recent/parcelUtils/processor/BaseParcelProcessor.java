package com.tencent.mobileqq.activity.recent.parcelUtils.processor;

import android.os.Parcel;
import java.lang.reflect.Field;
import java.util.ArrayList;

public abstract class BaseParcelProcessor
{
  public abstract void a(Object paramObject, Parcel paramParcel, ArrayList<Field> paramArrayList);
  
  abstract void a(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel);
  
  public boolean a(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel)
  {
    a(paramObject, paramArrayList, paramParcel);
    if (b(paramObject, paramArrayList, paramParcel)) {
      b(paramObject, paramArrayList, paramParcel);
    }
    return false;
  }
  
  abstract void b(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel);
  
  abstract boolean b(Object paramObject, ArrayList<Field> paramArrayList, Parcel paramParcel);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.parcelUtils.processor.BaseParcelProcessor
 * JD-Core Version:    0.7.0.1
 */