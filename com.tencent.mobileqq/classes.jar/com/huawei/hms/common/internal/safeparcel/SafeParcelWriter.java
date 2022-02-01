package com.huawei.hms.common.internal.safeparcel;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter
{
  private static int a(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(0xFFFF0000 | paramInt);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  private static void a(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 65535)
    {
      paramParcel.writeInt(0xFFFF0000 | paramInt1);
      paramParcel.writeInt(paramInt2);
      return;
    }
    paramParcel.writeInt(paramInt2 << 16 | paramInt1);
  }
  
  private static <P extends Parcelable> void a(Parcel paramParcel, P paramP, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramP.writeToParcel(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(paramInt - j);
    paramParcel.setDataPosition(paramInt);
  }
  
  private static void b(Parcel paramParcel, int paramInt)
  {
    int i = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i - paramInt);
    paramParcel.setDataPosition(i);
  }
  
  public static int beginObjectHeader(Parcel paramParcel)
  {
    return a(paramParcel, 20293);
  }
  
  public static void finishObjectHeader(Parcel paramParcel, int paramInt)
  {
    b(paramParcel, paramInt);
  }
  
  public static void writeBigDecimal(Parcel paramParcel, int paramInt, BigDecimal paramBigDecimal, boolean paramBoolean)
  {
    if (paramBigDecimal != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeByteArray(paramBigDecimal.unscaledValue().toByteArray());
      paramParcel.writeInt(paramBigDecimal.scale());
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeBigDecimalArray(Parcel paramParcel, int paramInt, BigDecimal[] paramArrayOfBigDecimal, boolean paramBoolean)
  {
    int i = 0;
    if (paramArrayOfBigDecimal != null)
    {
      j = a(paramParcel, paramInt);
      k = paramArrayOfBigDecimal.length;
      paramParcel.writeInt(k);
      paramInt = i;
      while (paramInt < k)
      {
        paramParcel.writeByteArray(paramArrayOfBigDecimal[paramInt].unscaledValue().toByteArray());
        paramParcel.writeInt(paramArrayOfBigDecimal[paramInt].scale());
        paramInt += 1;
      }
      b(paramParcel, j);
    }
    while (!paramBoolean)
    {
      int j;
      int k;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeBigInteger(Parcel paramParcel, int paramInt, BigInteger paramBigInteger, boolean paramBoolean)
  {
    if (paramBigInteger != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeByteArray(paramBigInteger.toByteArray());
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeBigIntegerArray(Parcel paramParcel, int paramInt, BigInteger[] paramArrayOfBigInteger, boolean paramBoolean)
  {
    int i = 0;
    if (paramArrayOfBigInteger != null)
    {
      j = a(paramParcel, paramInt);
      k = paramArrayOfBigInteger.length;
      paramParcel.writeInt(k);
      paramInt = i;
      while (paramInt < k)
      {
        paramParcel.writeByteArray(paramArrayOfBigInteger[paramInt].toByteArray());
        paramInt += 1;
      }
      b(paramParcel, j);
    }
    while (!paramBoolean)
    {
      int j;
      int k;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeBoolean(Parcel paramParcel, int paramInt, boolean paramBoolean)
  {
    a(paramParcel, paramInt, 4);
    if (paramBoolean)
    {
      paramParcel.writeInt(1);
      return;
    }
    paramParcel.writeInt(0);
  }
  
  public static void writeBooleanArray(Parcel paramParcel, int paramInt, boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    if (paramArrayOfBoolean != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeBooleanArray(paramArrayOfBoolean);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeBooleanList(Parcel paramParcel, int paramInt, List<Boolean> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      j = a(paramParcel, paramInt);
      k = paramList.size();
      paramParcel.writeInt(k);
      paramInt = 0;
      if (paramInt < k)
      {
        if (((Boolean)paramList.get(paramInt)).booleanValue()) {}
        for (i = 1;; i = 0)
        {
          paramParcel.writeInt(i);
          paramInt += 1;
          break;
        }
      }
      b(paramParcel, j);
    }
    while (!paramBoolean)
    {
      int j;
      int k;
      int i;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeBooleanObject(Parcel paramParcel, int paramInt, Boolean paramBoolean, boolean paramBoolean1)
  {
    int i = 0;
    if (paramBoolean != null)
    {
      a(paramParcel, paramInt, 4);
      paramInt = i;
      if (paramBoolean.booleanValue()) {
        paramInt = 1;
      }
      paramParcel.writeInt(paramInt);
    }
    while (!paramBoolean1) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeBundle(Parcel paramParcel, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramBundle != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeBundle(paramBundle);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeByte(Parcel paramParcel, int paramInt, byte paramByte)
  {
    a(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramByte);
  }
  
  public static void writeByteArray(Parcel paramParcel, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeByteArray(paramArrayOfByte);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeByteArrayArray(Parcel paramParcel, int paramInt, byte[][] paramArrayOfByte, boolean paramBoolean)
  {
    int i = 0;
    if (paramArrayOfByte != null)
    {
      j = a(paramParcel, paramInt);
      k = paramArrayOfByte.length;
      paramParcel.writeInt(k);
      paramInt = i;
      while (paramInt < k)
      {
        paramParcel.writeByteArray(paramArrayOfByte[paramInt]);
        paramInt += 1;
      }
      b(paramParcel, j);
    }
    while (!paramBoolean)
    {
      int j;
      int k;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeByteArraySparseArray(Parcel paramParcel, int paramInt, SparseArray<byte[]> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray != null)
    {
      i = a(paramParcel, paramInt);
      j = paramSparseArray.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        paramParcel.writeByteArray((byte[])paramSparseArray.valueAt(paramInt));
        paramInt += 1;
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeChar(Parcel paramParcel, int paramInt, char paramChar)
  {
    a(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramChar);
  }
  
  public static void writeCharArray(Parcel paramParcel, int paramInt, char[] paramArrayOfChar, boolean paramBoolean)
  {
    if (paramArrayOfChar != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeCharArray(paramArrayOfChar);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeDouble(Parcel paramParcel, int paramInt, double paramDouble)
  {
    a(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble);
  }
  
  public static void writeDoubleArray(Parcel paramParcel, int paramInt, double[] paramArrayOfDouble, boolean paramBoolean)
  {
    if (paramArrayOfDouble != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeDoubleArray(paramArrayOfDouble);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeDoubleList(Parcel paramParcel, int paramInt, List<Double> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      i = a(paramParcel, paramInt);
      j = paramList.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        paramParcel.writeDouble(((Double)paramList.get(paramInt)).doubleValue());
        paramInt += 1;
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeDoubleObject(Parcel paramParcel, int paramInt, Double paramDouble, boolean paramBoolean)
  {
    if (paramDouble != null)
    {
      a(paramParcel, paramInt, 8);
      paramParcel.writeDouble(paramDouble.doubleValue());
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeDoubleSparseArray(Parcel paramParcel, int paramInt, SparseArray<Double> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray != null)
    {
      i = a(paramParcel, paramInt);
      j = paramSparseArray.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        paramParcel.writeDouble(((Double)paramSparseArray.valueAt(paramInt)).doubleValue());
        paramInt += 1;
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeFloat(Parcel paramParcel, int paramInt, float paramFloat)
  {
    a(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat);
  }
  
  public static void writeFloatArray(Parcel paramParcel, int paramInt, float[] paramArrayOfFloat, boolean paramBoolean)
  {
    if (paramArrayOfFloat != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeFloatArray(paramArrayOfFloat);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeFloatList(Parcel paramParcel, int paramInt, List<Float> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      i = a(paramParcel, paramInt);
      j = paramList.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        paramParcel.writeFloat(((Float)paramList.get(paramInt)).floatValue());
        paramInt += 1;
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeFloatObject(Parcel paramParcel, int paramInt, Float paramFloat, boolean paramBoolean)
  {
    if (paramFloat != null)
    {
      a(paramParcel, paramInt, 4);
      paramParcel.writeFloat(paramFloat.floatValue());
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeFloatSparseArray(Parcel paramParcel, int paramInt, SparseArray<Float> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray != null)
    {
      i = a(paramParcel, paramInt);
      j = paramSparseArray.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        paramParcel.writeFloat(((Float)paramSparseArray.valueAt(paramInt)).floatValue());
        paramInt += 1;
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeIBinder(Parcel paramParcel, int paramInt, IBinder paramIBinder, boolean paramBoolean)
  {
    if (paramIBinder != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeStrongBinder(paramIBinder);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeIBinderArray(Parcel paramParcel, int paramInt, IBinder[] paramArrayOfIBinder, boolean paramBoolean)
  {
    if (paramArrayOfIBinder != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeBinderArray(paramArrayOfIBinder);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeIBinderList(Parcel paramParcel, int paramInt, List<IBinder> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeBinderList(paramList);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeIBinderSparseArray(Parcel paramParcel, int paramInt, SparseArray<IBinder> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray != null)
    {
      i = a(paramParcel, paramInt);
      j = paramSparseArray.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        paramParcel.writeStrongBinder((IBinder)paramSparseArray.valueAt(paramInt));
        paramInt += 1;
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeInt(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    a(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  public static void writeIntArray(Parcel paramParcel, int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    if (paramArrayOfInt != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeIntArray(paramArrayOfInt);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeIntegerList(Parcel paramParcel, int paramInt, List<Integer> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      i = a(paramParcel, paramInt);
      j = paramList.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        paramParcel.writeInt(((Integer)paramList.get(paramInt)).intValue());
        paramInt += 1;
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeIntegerObject(Parcel paramParcel, int paramInt, Integer paramInteger, boolean paramBoolean)
  {
    if (paramInteger != null)
    {
      a(paramParcel, paramInt, 4);
      paramParcel.writeInt(paramInteger.intValue());
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeList(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeList(paramList);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeLong(Parcel paramParcel, int paramInt, long paramLong)
  {
    a(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void writeLongArray(Parcel paramParcel, int paramInt, long[] paramArrayOfLong, boolean paramBoolean)
  {
    if (paramArrayOfLong != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeLongArray(paramArrayOfLong);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeLongList(Parcel paramParcel, int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      i = a(paramParcel, paramInt);
      j = paramList.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        paramParcel.writeLong(((Long)paramList.get(paramInt)).longValue());
        paramInt += 1;
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeLongObject(Parcel paramParcel, int paramInt, Long paramLong, boolean paramBoolean)
  {
    if (paramLong != null)
    {
      a(paramParcel, paramInt, 8);
      paramParcel.writeLong(paramLong.longValue());
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeParcel(Parcel paramParcel1, int paramInt, Parcel paramParcel2, boolean paramBoolean)
  {
    if (paramParcel2 != null)
    {
      paramInt = a(paramParcel1, paramInt);
      paramParcel1.appendFrom(paramParcel2, 0, paramParcel2.dataSize());
      b(paramParcel1, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel1, paramInt, 0);
  }
  
  public static void writeParcelArray(Parcel paramParcel, int paramInt, Parcel[] paramArrayOfParcel, boolean paramBoolean)
  {
    if (paramArrayOfParcel != null)
    {
      i = a(paramParcel, paramInt);
      j = paramArrayOfParcel.length;
      paramParcel.writeInt(j);
      paramInt = 0;
      if (paramInt < j)
      {
        if (paramArrayOfParcel[paramInt] == null) {
          paramParcel.writeInt(0);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          paramParcel.writeInt(paramArrayOfParcel[paramInt].dataSize());
          paramParcel.appendFrom(paramArrayOfParcel[paramInt], 0, paramArrayOfParcel[paramInt].dataSize());
        }
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeParcelList(Parcel paramParcel, int paramInt, List<Parcel> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      i = a(paramParcel, paramInt);
      j = paramList.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      if (paramInt < j)
      {
        localParcel = (Parcel)paramList.get(paramInt);
        if (localParcel == null) {
          paramParcel.writeInt(0);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          paramParcel.writeInt(localParcel.dataSize());
          paramParcel.appendFrom(localParcel, 0, localParcel.dataSize());
        }
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      Parcel localParcel;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeParcelSparseArray(Parcel paramParcel, int paramInt, SparseArray<Parcel> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray != null)
    {
      i = a(paramParcel, paramInt);
      j = paramSparseArray.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      if (paramInt < j)
      {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        localParcel = (Parcel)paramSparseArray.valueAt(paramInt);
        if (localParcel == null) {
          paramParcel.writeInt(0);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          paramParcel.writeInt(localParcel.dataSize());
          paramParcel.appendFrom(localParcel, 0, localParcel.dataSize());
        }
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      Parcel localParcel;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeParcelable(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean)
  {
    if (paramParcelable != null)
    {
      paramInt1 = a(paramParcel, paramInt1);
      paramParcelable.writeToParcel(paramParcel, paramInt2);
      b(paramParcel, paramInt1);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt1, 0);
  }
  
  public static void writeShort(Parcel paramParcel, int paramInt, short paramShort)
  {
    a(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramShort);
  }
  
  public static void writeSparseBooleanArray(Parcel paramParcel, int paramInt, SparseBooleanArray paramSparseBooleanArray, boolean paramBoolean)
  {
    if (paramSparseBooleanArray != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeSparseBooleanArray(paramSparseBooleanArray);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeSparseIntArray(Parcel paramParcel, int paramInt, SparseIntArray paramSparseIntArray, boolean paramBoolean)
  {
    int i = 0;
    if (paramSparseIntArray != null)
    {
      j = a(paramParcel, paramInt);
      k = paramSparseIntArray.size();
      paramParcel.writeInt(k);
      paramInt = i;
      while (paramInt < k)
      {
        paramParcel.writeInt(paramSparseIntArray.keyAt(paramInt));
        paramParcel.writeInt(paramSparseIntArray.valueAt(paramInt));
        paramInt += 1;
      }
      b(paramParcel, j);
    }
    while (!paramBoolean)
    {
      int j;
      int k;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeSparseLongArray(Parcel paramParcel, int paramInt, SparseLongArray paramSparseLongArray, boolean paramBoolean)
  {
    int i = 0;
    int j;
    if (paramSparseLongArray != null)
    {
      j = a(paramParcel, paramInt);
      if (Build.VERSION.SDK_INT < 18) {
        break label101;
      }
    }
    label101:
    for (paramInt = paramSparseLongArray.size();; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      while (i < paramInt)
      {
        if (Build.VERSION.SDK_INT >= 18) {
          paramParcel.writeInt(paramSparseLongArray.keyAt(i));
        }
        if (Build.VERSION.SDK_INT >= 18) {
          paramParcel.writeLong(paramSparseLongArray.valueAt(i));
        }
        i += 1;
      }
      b(paramParcel, j);
      do
      {
        return;
      } while (!paramBoolean);
      a(paramParcel, paramInt, 0);
      return;
    }
  }
  
  public static void writeString(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramString != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeString(paramString);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeStringArray(Parcel paramParcel, int paramInt, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeStringArray(paramArrayOfString);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeStringList(Parcel paramParcel, int paramInt, List<String> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      paramInt = a(paramParcel, paramInt);
      paramParcel.writeStringList(paramList);
      b(paramParcel, paramInt);
    }
    while (!paramBoolean) {
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static void writeStringSparseArray(Parcel paramParcel, int paramInt, SparseArray<String> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray != null)
    {
      i = a(paramParcel, paramInt);
      j = paramSparseArray.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      while (paramInt < j)
      {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        paramParcel.writeString((String)paramSparseArray.valueAt(paramInt));
        paramInt += 1;
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static <P extends Parcelable> void writeTypedArray(Parcel paramParcel, int paramInt1, P[] paramArrayOfP, int paramInt2, boolean paramBoolean)
  {
    if (paramArrayOfP != null)
    {
      i = a(paramParcel, paramInt1);
      paramParcel.writeInt(i);
      j = paramArrayOfP.length;
      paramInt1 = 0;
      if (paramInt1 < j)
      {
        if (paramArrayOfP[paramInt1] != null) {
          a(paramParcel, paramArrayOfP[paramInt1], paramInt2);
        }
        for (;;)
        {
          paramInt1 += 1;
          break;
          paramParcel.writeInt(0);
        }
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      return;
    }
    a(paramParcel, paramInt1, 0);
  }
  
  public static <T extends Parcelable> void writeTypedList(Parcel paramParcel, int paramInt, List<T> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      i = a(paramParcel, paramInt);
      j = paramList.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      if (paramInt < j)
      {
        localParcelable = (Parcelable)paramList.get(paramInt);
        if (localParcelable != null) {
          a(paramParcel, localParcelable, 0);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          paramParcel.writeInt(0);
        }
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      Parcelable localParcelable;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
  
  public static <T extends Parcelable> void writeTypedSparseArray(Parcel paramParcel, int paramInt, SparseArray<T> paramSparseArray, boolean paramBoolean)
  {
    if (paramSparseArray != null)
    {
      i = a(paramParcel, paramInt);
      j = paramSparseArray.size();
      paramParcel.writeInt(j);
      paramInt = 0;
      if (paramInt < j)
      {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        localParcelable = (Parcelable)paramSparseArray.valueAt(paramInt);
        if (localParcelable != null) {
          a(paramParcel, localParcelable, 0);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          paramParcel.writeInt(0);
        }
      }
      b(paramParcel, i);
    }
    while (!paramBoolean)
    {
      int i;
      int j;
      Parcelable localParcelable;
      return;
    }
    a(paramParcel, paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.common.internal.safeparcel.SafeParcelWriter
 * JD-Core Version:    0.7.0.1
 */