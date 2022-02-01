package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

public class ExtendableSavedState
  extends AbsSavedState
{
  public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new ExtendableSavedState.1();
  @NonNull
  public final SimpleArrayMap<String, Bundle> a;
  
  private ExtendableSavedState(@NonNull Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel, paramClassLoader);
    int j = paramParcel.readInt();
    paramClassLoader = new String[j];
    paramParcel.readStringArray(paramClassLoader);
    Bundle[] arrayOfBundle = new Bundle[j];
    paramParcel.readTypedArray(arrayOfBundle, Bundle.CREATOR);
    this.a = new SimpleArrayMap(j);
    int i = 0;
    while (i < j)
    {
      this.a.put(paramClassLoader[i], arrayOfBundle[i]);
      i += 1;
    }
  }
  
  public ExtendableSavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
    this.a = new SimpleArrayMap();
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtendableSavedState{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" states=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    int i = this.a.size();
    paramParcel.writeInt(i);
    String[] arrayOfString = new String[i];
    Bundle[] arrayOfBundle = new Bundle[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfString[paramInt] = ((String)this.a.keyAt(paramInt));
      arrayOfBundle[paramInt] = ((Bundle)this.a.valueAt(paramInt));
      paramInt += 1;
    }
    paramParcel.writeStringArray(arrayOfString);
    paramParcel.writeTypedArray(arrayOfBundle, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.stateful.ExtendableSavedState
 * JD-Core Version:    0.7.0.1
 */