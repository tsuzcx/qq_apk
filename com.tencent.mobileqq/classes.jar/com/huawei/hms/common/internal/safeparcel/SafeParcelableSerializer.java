package com.huawei.hms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SafeParcelableSerializer
{
  public static <S extends SafeParcelable> S deserializeFromBytes(byte[] paramArrayOfByte, Parcelable.Creator<S> paramCreator)
  {
    Preconditions.checkNotNull(paramCreator);
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = (SafeParcelable)paramCreator.createFromParcel(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public static <S extends SafeParcelable> S deserializeFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator<S> paramCreator)
  {
    paramIntent = paramIntent.getByteArrayExtra(paramString);
    if (paramIntent == null) {
      return null;
    }
    return deserializeFromBytes(paramIntent, paramCreator);
  }
  
  public static <S extends SafeParcelable> S deserializeFromString(String paramString, Parcelable.Creator<S> paramCreator)
  {
    return deserializeFromBytes(Base64Utils.decodeUrlSafe(paramString), paramCreator);
  }
  
  public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromBundle(Bundle paramBundle, String paramString, Parcelable.Creator<S> paramCreator)
  {
    if (paramBundle == null) {
      return null;
    }
    paramString = (ArrayList)paramBundle.getSerializable(paramString);
    if (paramString == null) {
      return null;
    }
    paramBundle = new ArrayList(paramString.size());
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      paramBundle.add(deserializeFromBytes((byte[])paramString.next(), paramCreator));
    }
    return paramBundle;
  }
  
  public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator<S> paramCreator)
  {
    paramString = (ArrayList)paramIntent.getSerializableExtra(paramString);
    if (paramString == null) {
      return null;
    }
    paramIntent = new ArrayList(paramString.size());
    paramString = paramString.iterator();
    while (paramString.hasNext()) {
      paramIntent.add(deserializeFromBytes((byte[])paramString.next(), paramCreator));
    }
    return paramIntent;
  }
  
  public static <S extends SafeParcelable> void serializeIterableToBundle(Iterable<S> paramIterable, Bundle paramBundle, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(serializeToBytes((SafeParcelable)paramIterable.next()));
    }
    paramBundle.putSerializable(paramString, localArrayList);
  }
  
  public static <S extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<S> paramIterable, Intent paramIntent, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add(serializeToBytes((SafeParcelable)paramIterable.next()));
    }
    paramIntent.putExtra(paramString, localArrayList);
  }
  
  public static <S extends SafeParcelable> byte[] serializeToBytes(S paramS)
  {
    Parcel localParcel = Parcel.obtain();
    paramS.writeToParcel(localParcel, 0);
    paramS = localParcel.marshall();
    localParcel.recycle();
    return paramS;
  }
  
  public static <S extends SafeParcelable> void serializeToIntentExtra(S paramS, Intent paramIntent, String paramString)
  {
    paramIntent.putExtra(paramString, serializeToBytes(paramS));
  }
  
  public static <S extends SafeParcelable> String serializeToString(S paramS)
  {
    return Base64Utils.encodeUrlSafe(serializeToBytes(paramS));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.safeparcel.SafeParcelableSerializer
 * JD-Core Version:    0.7.0.1
 */