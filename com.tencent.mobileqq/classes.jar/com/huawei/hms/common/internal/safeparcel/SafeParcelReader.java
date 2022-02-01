package com.huawei.hms.common.internal.safeparcel;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader
{
  private static final int BIT16_MARK = 65535;
  private static final int FIELD_ID_CHECKER = 20293;
  private static final int MAX_ARRAY_LENGTH = 1024;
  private static final int NEGATIVE_MARK = -65536;
  private static final int OFFSET16 = 16;
  
  public static BigDecimal createBigDecimal(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    byte[] arrayOfByte = paramParcel.createByteArray();
    int j = paramParcel.readInt();
    paramParcel.setDataPosition(paramInt + i);
    return new BigDecimal(new BigInteger(arrayOfByte), j);
  }
  
  public static BigDecimal[] createBigDecimalArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    paramInt = 0;
    if (i == 0) {
      return new BigDecimal[0];
    }
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[k];
    while (paramInt < k)
    {
      arrayOfBigDecimal[paramInt] = new BigDecimal(new BigInteger(paramParcel.createByteArray()), paramParcel.readInt());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfBigDecimal;
  }
  
  public static BigInteger createBigInteger(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    return new BigInteger(arrayOfByte);
  }
  
  public static BigInteger[] createBigIntegerArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    paramInt = 0;
    if (i == 0) {
      return new BigInteger[0];
    }
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    BigInteger[] arrayOfBigInteger = new BigInteger[k];
    while (paramInt < k)
    {
      arrayOfBigInteger[paramInt] = new BigInteger(paramParcel.createByteArray());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfBigInteger;
  }
  
  public static boolean[] createBooleanArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new boolean[0];
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    boolean[] arrayOfBoolean = paramParcel.createBooleanArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfBoolean;
  }
  
  public static ArrayList<Boolean> createBooleanList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    paramInt = 0;
    while (paramInt < k)
    {
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localArrayList.add(Boolean.valueOf(bool));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static Bundle createBundle(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    Bundle localBundle = paramParcel.readBundle();
    paramParcel.setDataPosition(paramInt + i);
    return localBundle;
  }
  
  public static byte[] createByteArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new byte[0];
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfByte;
  }
  
  public static byte[][] createByteArrayArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    byte[][] arrayOfByte = new byte[k][];
    paramInt = 0;
    while (paramInt < k)
    {
      arrayOfByte[paramInt] = paramParcel.createByteArray();
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfByte;
  }
  
  public static SparseArray<byte[]> createByteArraySparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    SparseArray localSparseArray = new SparseArray(k);
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), paramParcel.createByteArray());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static char[] createCharArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new char[0];
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    char[] arrayOfChar = paramParcel.createCharArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfChar;
  }
  
  public static double[] createDoubleArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new double[0];
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    double[] arrayOfDouble = paramParcel.createDoubleArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfDouble;
  }
  
  public static ArrayList<Double> createDoubleList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    paramInt = 0;
    while (paramInt < k)
    {
      localArrayList.add(Double.valueOf(paramParcel.readDouble()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static SparseArray<Double> createDoubleSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), Double.valueOf(paramParcel.readDouble()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static float[] createFloatArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new float[0];
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    float[] arrayOfFloat = paramParcel.createFloatArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfFloat;
  }
  
  public static ArrayList<Float> createFloatList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    paramInt = 0;
    while (paramInt < k)
    {
      localArrayList.add(Float.valueOf(paramParcel.readFloat()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static SparseArray<Float> createFloatSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), Float.valueOf(paramParcel.readFloat()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static IBinder[] createIBinderArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new IBinder[0];
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    IBinder[] arrayOfIBinder = paramParcel.createBinderArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfIBinder;
  }
  
  public static ArrayList<IBinder> createIBinderList(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    ArrayList localArrayList = paramParcel.createBinderArrayList();
    paramParcel.setDataPosition(paramInt + i);
    return localArrayList;
  }
  
  public static SparseArray<IBinder> createIBinderSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    SparseArray localSparseArray = new SparseArray(k);
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), paramParcel.readStrongBinder());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static int[] createIntArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new int[0];
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    int[] arrayOfInt = paramParcel.createIntArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfInt;
  }
  
  public static ArrayList<Integer> createIntegerList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    paramInt = 0;
    while (paramInt < k)
    {
      localArrayList.add(Integer.valueOf(paramParcel.readInt()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static long[] createLongArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new long[0];
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    long[] arrayOfLong = paramParcel.createLongArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfLong;
  }
  
  public static ArrayList<Long> createLongList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    ArrayList localArrayList = new ArrayList();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    paramInt = 0;
    while (paramInt < k)
    {
      localArrayList.add(Long.valueOf(paramParcel.readLong()));
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static Parcel createParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    Parcel localParcel = Parcel.obtain();
    localParcel.appendFrom(paramParcel, i, paramInt);
    paramParcel.setDataPosition(paramInt + i);
    return localParcel;
  }
  
  public static Parcel[] createParcelArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    paramInt = 0;
    if (i == 0) {
      return new Parcel[0];
    }
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    Parcel[] arrayOfParcel = new Parcel[k];
    while (paramInt < k)
    {
      int m = paramParcel.readInt();
      if (m == 0)
      {
        arrayOfParcel[paramInt] = null;
      }
      else
      {
        int n = paramParcel.dataPosition();
        ensureDataPositionValid(paramParcel, m, n);
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, n, m);
        arrayOfParcel[paramInt] = localParcel;
        paramParcel.setDataPosition(m + n);
      }
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return arrayOfParcel;
  }
  
  public static ArrayList<Parcel> createParcelList(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    ArrayList localArrayList = new ArrayList();
    paramInt = 0;
    while (paramInt < k)
    {
      int m = paramParcel.readInt();
      if (m == 0)
      {
        localArrayList.add(null);
      }
      else
      {
        int n = paramParcel.dataPosition();
        ensureDataPositionValid(paramParcel, m, n);
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, n, m);
        localArrayList.add(localParcel);
        paramParcel.setDataPosition(m + n);
      }
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localArrayList;
  }
  
  public static SparseArray<Parcel> createParcelSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    SparseArray localSparseArray = new SparseArray();
    paramInt = 0;
    while (paramInt < k)
    {
      int m = paramParcel.readInt();
      int n = paramParcel.readInt();
      if (n == 0)
      {
        localSparseArray.append(m, null);
      }
      else
      {
        int i1 = paramParcel.dataPosition();
        ensureDataPositionValid(paramParcel, n, i1);
        Parcel localParcel = Parcel.obtain();
        localParcel.appendFrom(paramParcel, i1, n);
        localSparseArray.append(m, localParcel);
        paramParcel.setDataPosition(i1 + n);
      }
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static <P extends Parcelable> P createParcelable(Parcel paramParcel, int paramInt, Parcelable.Creator<P> paramCreator)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    paramCreator = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(paramInt + i);
    return paramCreator;
  }
  
  public static SparseBooleanArray createSparseBooleanArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    SparseBooleanArray localSparseBooleanArray = paramParcel.readSparseBooleanArray();
    paramParcel.setDataPosition(paramInt + i);
    return localSparseBooleanArray;
  }
  
  public static SparseIntArray createSparseIntArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseIntArray.append(paramParcel.readInt(), paramParcel.readInt());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseIntArray;
  }
  
  public static SparseLongArray createSparseLongArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    SparseLongArray localSparseLongArray = null;
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    if (Build.VERSION.SDK_INT >= 18) {
      localSparseLongArray = new SparseLongArray();
    }
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    paramInt = 0;
    while (paramInt < k)
    {
      if (Build.VERSION.SDK_INT >= 18) {
        localSparseLongArray.append(paramParcel.readInt(), paramParcel.readLong());
      }
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseLongArray;
  }
  
  public static String createString(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    String str = paramParcel.readString();
    paramParcel.setDataPosition(paramInt + i);
    return str;
  }
  
  public static String[] createStringArray(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return new String[0];
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    String[] arrayOfString = paramParcel.createStringArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfString;
  }
  
  public static ArrayList<String> createStringList(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    ArrayList localArrayList = paramParcel.createStringArrayList();
    paramParcel.setDataPosition(paramInt + i);
    return localArrayList;
  }
  
  public static SparseArray<String> createStringSparseArray(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    SparseArray localSparseArray = new SparseArray();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    paramInt = 0;
    while (paramInt < k)
    {
      localSparseArray.append(paramParcel.readInt(), paramParcel.readString());
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  public static <C> C[] createTypedArray(Parcel paramParcel, int paramInt, Parcelable.Creator<C> paramCreator)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return paramCreator.newArray(0);
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    paramCreator = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(paramInt + i);
    return paramCreator;
  }
  
  public static <C> ArrayList<C> createTypedList(Parcel paramParcel, int paramInt, Parcelable.Creator<C> paramCreator)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    paramCreator = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(paramInt + i);
    return paramCreator;
  }
  
  public static <C> SparseArray<C> createTypedSparseArray(Parcel paramParcel, int paramInt, Parcelable.Creator<C> paramCreator)
  {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    SparseArray localSparseArray = new SparseArray();
    paramInt = 0;
    while (paramInt < k)
    {
      int m = paramParcel.readInt();
      Object localObject;
      if (paramParcel.readInt() != 0) {
        localObject = paramCreator.createFromParcel(paramParcel);
      } else {
        localObject = null;
      }
      localSparseArray.append(m, localObject);
      paramInt += 1;
    }
    paramParcel.setDataPosition(j + i);
    return localSparseArray;
  }
  
  private static void ensureArrayLengthValid(Parcel paramParcel, int paramInt)
  {
    if (paramInt <= 1024) {
      return;
    }
    throw new SafeParcelReader.ParseException("arraySize cannot be beyond 65535", paramParcel);
  }
  
  public static void ensureAtEnd(Parcel paramParcel, int paramInt)
  {
    if (paramParcel.dataPosition() == paramInt) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Overread allowed size end=");
    localStringBuilder.append(paramInt);
    throw new SafeParcelReader.ParseException(localStringBuilder.toString(), paramParcel);
  }
  
  private static void ensureDataPositionValid(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (!isOutOfIntBoundary(paramInt1, paramInt2))) {
      return;
    }
    throw new SafeParcelReader.ParseException("dataPosition cannot be beyond integer scope", paramParcel);
  }
  
  public static int getFieldId(int paramInt)
  {
    return paramInt & 0xFFFF;
  }
  
  private static boolean isOutOfIntBoundary(int paramInt1, int paramInt2)
  {
    long l = paramInt1 + paramInt2;
    return (l > 2147483647L) || (l < -2147483648L);
  }
  
  public static boolean readBoolean(Parcel paramParcel, int paramInt)
  {
    sizeChecker(paramParcel, paramInt, 4);
    return paramParcel.readInt() != 0;
  }
  
  public static Boolean readBooleanObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    boolean bool = false;
    if (i == 0) {
      return Boolean.valueOf(false);
    }
    sizeChecker(paramParcel, paramInt, i, 4);
    if (paramParcel.readInt() != 0) {
      bool = true;
    }
    return Boolean.valueOf(bool);
  }
  
  public static byte readByte(Parcel paramParcel, int paramInt)
  {
    sizeChecker(paramParcel, paramInt, 4);
    return (byte)paramParcel.readInt();
  }
  
  public static char readChar(Parcel paramParcel, int paramInt)
  {
    sizeChecker(paramParcel, paramInt, 4);
    return (char)paramParcel.readInt();
  }
  
  public static double readDouble(Parcel paramParcel, int paramInt)
  {
    sizeChecker(paramParcel, paramInt, 8);
    return paramParcel.readDouble();
  }
  
  public static Double readDoubleObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    sizeChecker(paramParcel, paramInt, i, 8);
    return Double.valueOf(paramParcel.readDouble());
  }
  
  public static float readFloat(Parcel paramParcel, int paramInt)
  {
    sizeChecker(paramParcel, paramInt, 4);
    return paramParcel.readFloat();
  }
  
  public static Float readFloatObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    sizeChecker(paramParcel, paramInt, i, 4);
    return Float.valueOf(paramParcel.readFloat());
  }
  
  public static int readHeader(Parcel paramParcel)
  {
    return paramParcel.readInt();
  }
  
  public static IBinder readIBinder(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0) {
      return null;
    }
    ensureDataPositionValid(paramParcel, paramInt, i);
    IBinder localIBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(paramInt + i);
    return localIBinder;
  }
  
  public static int readInt(Parcel paramParcel, int paramInt)
  {
    sizeChecker(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }
  
  public static Integer readIntegerObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    sizeChecker(paramParcel, paramInt, i, 4);
    return Integer.valueOf(paramParcel.readInt());
  }
  
  public static void readList(Parcel paramParcel, int paramInt, List paramList, ClassLoader paramClassLoader)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt != 0)
    {
      ensureDataPositionValid(paramParcel, paramInt, i);
      paramParcel.readList(paramList, paramClassLoader);
      paramParcel.setDataPosition(paramInt + i);
    }
  }
  
  public static long readLong(Parcel paramParcel, int paramInt)
  {
    sizeChecker(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }
  
  public static Long readLongObject(Parcel paramParcel, int paramInt)
  {
    int i = readSize(paramParcel, paramInt);
    if (i == 0) {
      return null;
    }
    sizeChecker(paramParcel, paramInt, i, 8);
    return Long.valueOf(paramParcel.readLong());
  }
  
  public static short readShort(Parcel paramParcel, int paramInt)
  {
    sizeChecker(paramParcel, paramInt, 4);
    return (short)paramParcel.readInt();
  }
  
  public static int readSize(Parcel paramParcel, int paramInt)
  {
    if ((paramInt & 0xFFFF0000) != -65536) {
      return paramInt >> 16 & 0xFFFF;
    }
    return paramParcel.readInt();
  }
  
  private static void sizeChecker(Parcel paramParcel, int paramInt1, int paramInt2)
  {
    paramInt1 = readSize(paramParcel, paramInt1);
    if (paramInt1 == paramInt2) {
      return;
    }
    String str = Integer.toHexString(paramInt1);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 46);
    localStringBuilder.append("Expected size ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" got ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" (0x");
    localStringBuilder.append(str);
    localStringBuilder.append(")");
    throw new SafeParcelReader.ParseException(localStringBuilder.toString(), paramParcel);
  }
  
  private static void sizeChecker(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == paramInt3) {
      return;
    }
    String str = Integer.toHexString(paramInt2);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 46);
    localStringBuilder.append("Expected size ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" got ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" (0x");
    localStringBuilder.append(str);
    localStringBuilder.append(")");
    throw new SafeParcelReader.ParseException(localStringBuilder.toString(), paramParcel);
  }
  
  public static void skipUnknownField(Parcel paramParcel, int paramInt)
  {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    ensureDataPositionValid(paramParcel, paramInt, i);
    paramParcel.setDataPosition(paramInt + i);
  }
  
  public static int validateObjectHeader(Parcel paramParcel)
  {
    int j = readHeader(paramParcel);
    int k = readSize(paramParcel, j);
    int i = paramParcel.dataPosition();
    if (getFieldId(j) != 20293)
    {
      localObject = "Expected object header. Got 0x";
      String str = Integer.toHexString(j);
      if (str.length() != 0) {
        localObject = "Expected object header. Got 0x".concat(str);
      }
      throw new SafeParcelReader.ParseException((String)localObject, paramParcel);
    }
    j = k + i;
    if ((j >= i) && (j <= paramParcel.dataSize())) {
      return j;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invalid start=");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(" end=");
    ((StringBuilder)localObject).append(j);
    throw new SafeParcelReader.ParseException(((StringBuilder)localObject).toString(), paramParcel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.safeparcel.SafeParcelReader
 * JD-Core Version:    0.7.0.1
 */