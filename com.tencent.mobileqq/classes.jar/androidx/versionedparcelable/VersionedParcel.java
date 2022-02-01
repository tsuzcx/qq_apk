package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class VersionedParcel
{
  private static final int EX_BAD_PARCELABLE = -2;
  private static final int EX_ILLEGAL_ARGUMENT = -3;
  private static final int EX_ILLEGAL_STATE = -5;
  private static final int EX_NETWORK_MAIN_THREAD = -6;
  private static final int EX_NULL_POINTER = -4;
  private static final int EX_PARCELABLE = -9;
  private static final int EX_SECURITY = -1;
  private static final int EX_UNSUPPORTED_OPERATION = -7;
  private static final String TAG = "VersionedParcel";
  private static final int TYPE_BINDER = 5;
  private static final int TYPE_FLOAT = 8;
  private static final int TYPE_INTEGER = 7;
  private static final int TYPE_PARCELABLE = 2;
  private static final int TYPE_SERIALIZABLE = 3;
  private static final int TYPE_STRING = 4;
  private static final int TYPE_VERSIONED_PARCELABLE = 1;
  protected final ArrayMap<String, Class> mParcelizerCache;
  protected final ArrayMap<String, Method> mReadCache;
  protected final ArrayMap<String, Method> mWriteCache;
  
  public VersionedParcel(ArrayMap<String, Method> paramArrayMap1, ArrayMap<String, Method> paramArrayMap2, ArrayMap<String, Class> paramArrayMap)
  {
    this.mReadCache = paramArrayMap1;
    this.mWriteCache = paramArrayMap2;
    this.mParcelizerCache = paramArrayMap;
  }
  
  private Exception createException(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case -8: 
    default: 
      return new RuntimeException("Unknown exception code: " + paramInt + " msg " + paramString);
    case -9: 
      return (Exception)readParcelable();
    case -1: 
      return new SecurityException(paramString);
    case -2: 
      return new BadParcelableException(paramString);
    case -3: 
      return new IllegalArgumentException(paramString);
    case -4: 
      return new NullPointerException(paramString);
    case -5: 
      return new IllegalStateException(paramString);
    case -6: 
      return new NetworkOnMainThreadException();
    }
    return new UnsupportedOperationException(paramString);
  }
  
  private Class findParcelClass(Class<? extends VersionedParcelable> paramClass)
  {
    Class localClass2 = (Class)this.mParcelizerCache.get(paramClass.getName());
    Class localClass1 = localClass2;
    if (localClass2 == null)
    {
      localClass1 = Class.forName(String.format("%s.%sParcelizer", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() }), false, paramClass.getClassLoader());
      this.mParcelizerCache.put(paramClass.getName(), localClass1);
    }
    return localClass1;
  }
  
  private Method getReadMethod(String paramString)
  {
    Method localMethod2 = (Method)this.mReadCache.get(paramString);
    Method localMethod1 = localMethod2;
    if (localMethod2 == null)
    {
      System.currentTimeMillis();
      localMethod1 = Class.forName(paramString, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", new Class[] { VersionedParcel.class });
      this.mReadCache.put(paramString, localMethod1);
    }
    return localMethod1;
  }
  
  @NonNull
  protected static Throwable getRootCause(@NonNull Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    return paramThrowable;
  }
  
  private <T> int getType(T paramT)
  {
    if ((paramT instanceof String)) {
      return 4;
    }
    if ((paramT instanceof Parcelable)) {
      return 2;
    }
    if ((paramT instanceof VersionedParcelable)) {
      return 1;
    }
    if ((paramT instanceof Serializable)) {
      return 3;
    }
    if ((paramT instanceof IBinder)) {
      return 5;
    }
    if ((paramT instanceof Integer)) {
      return 7;
    }
    if ((paramT instanceof Float)) {
      return 8;
    }
    throw new IllegalArgumentException(paramT.getClass().getName() + " cannot be VersionedParcelled");
  }
  
  private Method getWriteMethod(Class paramClass)
  {
    Method localMethod = (Method)this.mWriteCache.get(paramClass.getName());
    Object localObject = localMethod;
    if (localMethod == null)
    {
      localObject = findParcelClass(paramClass);
      System.currentTimeMillis();
      localObject = ((Class)localObject).getDeclaredMethod("write", new Class[] { paramClass, VersionedParcel.class });
      this.mWriteCache.put(paramClass.getName(), localObject);
    }
    return localObject;
  }
  
  private <T, S extends Collection<T>> S readCollection(S paramS)
  {
    int i = readInt();
    S ?;
    if (i < 0) {
      ? = null;
    }
    do
    {
      return ?;
      ? = paramS;
    } while (i == 0);
    int i1 = readInt();
    if (i < 0) {
      return null;
    }
    int j = i;
    int k = i;
    int m = i;
    int n = i;
    switch (i1)
    {
    default: 
      return paramS;
    case 1: 
      for (;;)
      {
        ? = paramS;
        if (j <= 0) {
          break;
        }
        paramS.add(readVersionedParcelable());
        j -= 1;
      }
    case 4: 
      for (;;)
      {
        ? = paramS;
        if (k <= 0) {
          break;
        }
        paramS.add(readString());
        k -= 1;
      }
    case 2: 
      for (;;)
      {
        ? = paramS;
        if (m <= 0) {
          break;
        }
        paramS.add(readParcelable());
        m -= 1;
      }
    case 3: 
      for (;;)
      {
        ? = paramS;
        if (n <= 0) {
          break;
        }
        paramS.add(readSerializable());
        n -= 1;
      }
    }
    for (;;)
    {
      ? = paramS;
      if (i <= 0) {
        break;
      }
      paramS.add(readStrongBinder());
      i -= 1;
    }
  }
  
  private Exception readException(int paramInt, String paramString)
  {
    return createException(paramInt, paramString);
  }
  
  private int readExceptionCode()
  {
    return readInt();
  }
  
  private <T> void writeCollection(Collection<T> paramCollection)
  {
    if (paramCollection == null) {
      writeInt(-1);
    }
    for (;;)
    {
      return;
      int i = paramCollection.size();
      writeInt(i);
      if (i > 0)
      {
        i = getType(paramCollection.iterator().next());
        writeInt(i);
        switch (i)
        {
        case 6: 
        default: 
          return;
        case 1: 
          paramCollection = paramCollection.iterator();
          while (paramCollection.hasNext()) {
            writeVersionedParcelable((VersionedParcelable)paramCollection.next());
          }
        case 4: 
          paramCollection = paramCollection.iterator();
          while (paramCollection.hasNext()) {
            writeString((String)paramCollection.next());
          }
        case 2: 
          paramCollection = paramCollection.iterator();
          while (paramCollection.hasNext()) {
            writeParcelable((Parcelable)paramCollection.next());
          }
        case 3: 
          paramCollection = paramCollection.iterator();
          while (paramCollection.hasNext()) {
            writeSerializable((Serializable)paramCollection.next());
          }
        case 5: 
          paramCollection = paramCollection.iterator();
          while (paramCollection.hasNext()) {
            writeStrongBinder((IBinder)paramCollection.next());
          }
        case 7: 
          paramCollection = paramCollection.iterator();
          while (paramCollection.hasNext()) {
            writeInt(((Integer)paramCollection.next()).intValue());
          }
        }
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
          writeFloat(((Float)paramCollection.next()).floatValue());
        }
      }
    }
  }
  
  private <T> void writeCollection(Collection<T> paramCollection, int paramInt)
  {
    setOutputField(paramInt);
    writeCollection(paramCollection);
  }
  
  private void writeSerializable(Serializable paramSerializable)
  {
    if (paramSerializable == null)
    {
      writeString(null);
      return;
    }
    String str = paramSerializable.getClass().getName();
    writeString(str);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramSerializable);
      localObjectOutputStream.close();
      writeByteArray(localByteArrayOutputStream.toByteArray());
      return;
    }
    catch (IOException paramSerializable)
    {
      throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + str + ")", paramSerializable);
    }
  }
  
  private void writeVersionedParcelableCreator(VersionedParcelable paramVersionedParcelable)
  {
    try
    {
      Class localClass = findParcelClass(paramVersionedParcelable.getClass());
      writeString(localClass.getName());
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException(paramVersionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", localClassNotFoundException);
    }
  }
  
  protected abstract void closeField();
  
  protected abstract VersionedParcel createSubParcel();
  
  public boolean isStream()
  {
    return false;
  }
  
  protected <T> T[] readArray(T[] paramArrayOfT)
  {
    int i = readInt();
    if (i < 0) {}
    ArrayList localArrayList;
    int i1;
    do
    {
      return null;
      localArrayList = new ArrayList(i);
      if (i == 0) {
        break;
      }
      i1 = readInt();
    } while (i < 0);
    int j = i;
    int k = i;
    int m = i;
    int n = i;
    switch (i1)
    {
    default: 
      return localArrayList.toArray(paramArrayOfT);
    case 4: 
      while (j > 0)
      {
        localArrayList.add(readString());
        j -= 1;
      }
    case 2: 
      while (k > 0)
      {
        localArrayList.add(readParcelable());
        k -= 1;
      }
    case 1: 
      while (m > 0)
      {
        localArrayList.add(readVersionedParcelable());
        m -= 1;
      }
    case 3: 
      while (n > 0)
      {
        localArrayList.add(readSerializable());
        n -= 1;
      }
    }
    while (i > 0)
    {
      localArrayList.add(readStrongBinder());
      i -= 1;
    }
  }
  
  public <T> T[] readArray(T[] paramArrayOfT, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramArrayOfT;
    }
    return readArray(paramArrayOfT);
  }
  
  protected abstract boolean readBoolean();
  
  public boolean readBoolean(boolean paramBoolean, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramBoolean;
    }
    return readBoolean();
  }
  
  protected boolean[] readBooleanArray()
  {
    int j = readInt();
    if (j < 0) {
      return null;
    }
    boolean[] arrayOfBoolean = new boolean[j];
    int i = 0;
    if (i < j)
    {
      if (readInt() != 0) {}
      for (int k = 1;; k = 0)
      {
        arrayOfBoolean[i] = k;
        i += 1;
        break;
      }
    }
    return arrayOfBoolean;
  }
  
  public boolean[] readBooleanArray(boolean[] paramArrayOfBoolean, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramArrayOfBoolean;
    }
    return readBooleanArray();
  }
  
  protected abstract Bundle readBundle();
  
  public Bundle readBundle(Bundle paramBundle, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramBundle;
    }
    return readBundle();
  }
  
  public byte readByte(byte paramByte, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramByte;
    }
    return (byte)(readInt() & 0xFF);
  }
  
  protected abstract byte[] readByteArray();
  
  public byte[] readByteArray(byte[] paramArrayOfByte, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramArrayOfByte;
    }
    return readByteArray();
  }
  
  public char[] readCharArray(char[] paramArrayOfChar, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramArrayOfChar;
    }
    int i = readInt();
    if (i < 0) {
      return null;
    }
    char[] arrayOfChar = new char[i];
    paramInt = 0;
    for (;;)
    {
      paramArrayOfChar = arrayOfChar;
      if (paramInt >= i) {
        break;
      }
      arrayOfChar[paramInt] = ((char)readInt());
      paramInt += 1;
    }
  }
  
  protected abstract CharSequence readCharSequence();
  
  public CharSequence readCharSequence(CharSequence paramCharSequence, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramCharSequence;
    }
    return readCharSequence();
  }
  
  protected abstract double readDouble();
  
  public double readDouble(double paramDouble, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramDouble;
    }
    return readDouble();
  }
  
  protected double[] readDoubleArray()
  {
    int j = readInt();
    Object localObject;
    if (j < 0)
    {
      localObject = null;
      return localObject;
    }
    double[] arrayOfDouble = new double[j];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfDouble;
      if (i >= j) {
        break;
      }
      arrayOfDouble[i] = readDouble();
      i += 1;
    }
  }
  
  public double[] readDoubleArray(double[] paramArrayOfDouble, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramArrayOfDouble;
    }
    return readDoubleArray();
  }
  
  public Exception readException(Exception paramException, int paramInt)
  {
    if (!readField(paramInt)) {}
    do
    {
      return paramException;
      paramInt = readExceptionCode();
    } while (paramInt == 0);
    return readException(paramInt, readString());
  }
  
  protected abstract boolean readField(int paramInt);
  
  protected abstract float readFloat();
  
  public float readFloat(float paramFloat, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramFloat;
    }
    return readFloat();
  }
  
  protected float[] readFloatArray()
  {
    int j = readInt();
    Object localObject;
    if (j < 0)
    {
      localObject = null;
      return localObject;
    }
    float[] arrayOfFloat = new float[j];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfFloat;
      if (i >= j) {
        break;
      }
      arrayOfFloat[i] = readFloat();
      i += 1;
    }
  }
  
  public float[] readFloatArray(float[] paramArrayOfFloat, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramArrayOfFloat;
    }
    return readFloatArray();
  }
  
  protected <T extends VersionedParcelable> T readFromParcel(String paramString, VersionedParcel paramVersionedParcel)
  {
    try
    {
      paramString = (VersionedParcelable)getReadMethod(paramString).invoke(null, new Object[] { paramVersionedParcel });
      return paramString;
    }
    catch (IllegalAccessException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", paramString);
    }
    catch (InvocationTargetException paramString)
    {
      if ((paramString.getCause() instanceof RuntimeException)) {
        throw ((RuntimeException)paramString.getCause());
      }
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", paramString);
    }
    catch (NoSuchMethodException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", paramString);
    }
    catch (ClassNotFoundException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", paramString);
    }
  }
  
  protected abstract int readInt();
  
  public int readInt(int paramInt1, int paramInt2)
  {
    if (!readField(paramInt2)) {
      return paramInt1;
    }
    return readInt();
  }
  
  protected int[] readIntArray()
  {
    int j = readInt();
    Object localObject;
    if (j < 0)
    {
      localObject = null;
      return localObject;
    }
    int[] arrayOfInt = new int[j];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfInt;
      if (i >= j) {
        break;
      }
      arrayOfInt[i] = readInt();
      i += 1;
    }
  }
  
  public int[] readIntArray(int[] paramArrayOfInt, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramArrayOfInt;
    }
    return readIntArray();
  }
  
  public <T> List<T> readList(List<T> paramList, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramList;
    }
    return (List)readCollection(new ArrayList());
  }
  
  protected abstract long readLong();
  
  public long readLong(long paramLong, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramLong;
    }
    return readLong();
  }
  
  protected long[] readLongArray()
  {
    int j = readInt();
    Object localObject;
    if (j < 0)
    {
      localObject = null;
      return localObject;
    }
    long[] arrayOfLong = new long[j];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfLong;
      if (i >= j) {
        break;
      }
      arrayOfLong[i] = readLong();
      i += 1;
    }
  }
  
  public long[] readLongArray(long[] paramArrayOfLong, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramArrayOfLong;
    }
    return readLongArray();
  }
  
  public <K, V> Map<K, V> readMap(Map<K, V> paramMap, int paramInt)
  {
    if (!readField(paramInt)) {}
    int i;
    ArrayMap localArrayMap;
    do
    {
      return paramMap;
      i = readInt();
      if (i < 0) {
        return null;
      }
      localArrayMap = new ArrayMap();
      paramMap = localArrayMap;
    } while (i == 0);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    readCollection(localArrayList1);
    readCollection(localArrayList2);
    paramInt = 0;
    for (;;)
    {
      paramMap = localArrayMap;
      if (paramInt >= i) {
        break;
      }
      localArrayMap.put(localArrayList1.get(paramInt), localArrayList2.get(paramInt));
      paramInt += 1;
    }
  }
  
  protected abstract <T extends Parcelable> T readParcelable();
  
  public <T extends Parcelable> T readParcelable(T paramT, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramT;
    }
    return readParcelable();
  }
  
  protected Serializable readSerializable()
  {
    String str = readString();
    if (str == null) {
      return null;
    }
    Object localObject = new ByteArrayInputStream(readByteArray());
    try
    {
      localObject = (Serializable)new VersionedParcel.1(this, (InputStream)localObject).readObject();
      return localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + str + ")", localIOException);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + str + ")", localClassNotFoundException);
    }
  }
  
  public <T> Set<T> readSet(Set<T> paramSet, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramSet;
    }
    return (Set)readCollection(new ArraySet());
  }
  
  @RequiresApi(api=21)
  public Size readSize(Size paramSize, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramSize;
    }
    if (readBoolean()) {
      return new Size(readInt(), readInt());
    }
    return null;
  }
  
  @RequiresApi(api=21)
  public SizeF readSizeF(SizeF paramSizeF, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramSizeF;
    }
    if (readBoolean()) {
      return new SizeF(readFloat(), readFloat());
    }
    return null;
  }
  
  public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramSparseBooleanArray;
    }
    int i = readInt();
    if (i < 0) {
      return null;
    }
    SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray(i);
    paramInt = 0;
    for (;;)
    {
      paramSparseBooleanArray = localSparseBooleanArray;
      if (paramInt >= i) {
        break;
      }
      localSparseBooleanArray.put(readInt(), readBoolean());
      paramInt += 1;
    }
  }
  
  protected abstract String readString();
  
  public String readString(String paramString, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramString;
    }
    return readString();
  }
  
  protected abstract IBinder readStrongBinder();
  
  public IBinder readStrongBinder(IBinder paramIBinder, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramIBinder;
    }
    return readStrongBinder();
  }
  
  protected <T extends VersionedParcelable> T readVersionedParcelable()
  {
    String str = readString();
    if (str == null) {
      return null;
    }
    return readFromParcel(str, createSubParcel());
  }
  
  public <T extends VersionedParcelable> T readVersionedParcelable(T paramT, int paramInt)
  {
    if (!readField(paramInt)) {
      return paramT;
    }
    return readVersionedParcelable();
  }
  
  protected abstract void setOutputField(int paramInt);
  
  public void setSerializationFlags(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected <T> void writeArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT == null) {
      writeInt(-1);
    }
    int j;
    do
    {
      return;
      j = paramArrayOfT.length;
      writeInt(j);
    } while (j <= 0);
    int i = getType(paramArrayOfT[0]);
    writeInt(i);
    switch (i)
    {
    default: 
      return;
    case 1: 
      i = 0;
      while (i < j)
      {
        writeVersionedParcelable((VersionedParcelable)paramArrayOfT[i]);
        i += 1;
      }
    }
    while (i < j)
    {
      writeString((String)paramArrayOfT[i]);
      i += 1;
      continue;
      while (i < j)
      {
        writeParcelable((Parcelable)paramArrayOfT[i]);
        i += 1;
        continue;
        while (i < j)
        {
          writeSerializable((Serializable)paramArrayOfT[i]);
          i += 1;
          continue;
          while (i < j)
          {
            writeStrongBinder((IBinder)paramArrayOfT[i]);
            i += 1;
            continue;
            i = 0;
          }
          i = 0;
        }
        i = 0;
      }
      i = 0;
    }
  }
  
  public <T> void writeArray(T[] paramArrayOfT, int paramInt)
  {
    setOutputField(paramInt);
    writeArray(paramArrayOfT);
  }
  
  protected abstract void writeBoolean(boolean paramBoolean);
  
  public void writeBoolean(boolean paramBoolean, int paramInt)
  {
    setOutputField(paramInt);
    writeBoolean(paramBoolean);
  }
  
  protected void writeBooleanArray(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean != null)
    {
      int k = paramArrayOfBoolean.length;
      writeInt(k);
      int i = 0;
      if (i < k)
      {
        if (paramArrayOfBoolean[i] != 0) {}
        for (int j = 1;; j = 0)
        {
          writeInt(j);
          i += 1;
          break;
        }
      }
    }
    else
    {
      writeInt(-1);
    }
  }
  
  public void writeBooleanArray(boolean[] paramArrayOfBoolean, int paramInt)
  {
    setOutputField(paramInt);
    writeBooleanArray(paramArrayOfBoolean);
  }
  
  protected abstract void writeBundle(Bundle paramBundle);
  
  public void writeBundle(Bundle paramBundle, int paramInt)
  {
    setOutputField(paramInt);
    writeBundle(paramBundle);
  }
  
  public void writeByte(byte paramByte, int paramInt)
  {
    setOutputField(paramInt);
    writeInt(paramByte);
  }
  
  protected abstract void writeByteArray(byte[] paramArrayOfByte);
  
  public void writeByteArray(byte[] paramArrayOfByte, int paramInt)
  {
    setOutputField(paramInt);
    writeByteArray(paramArrayOfByte);
  }
  
  protected abstract void writeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public void writeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    setOutputField(paramInt3);
    writeByteArray(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void writeCharArray(char[] paramArrayOfChar, int paramInt)
  {
    setOutputField(paramInt);
    if (paramArrayOfChar != null)
    {
      int i = paramArrayOfChar.length;
      writeInt(i);
      paramInt = 0;
      while (paramInt < i)
      {
        writeInt(paramArrayOfChar[paramInt]);
        paramInt += 1;
      }
    }
    writeInt(-1);
  }
  
  protected abstract void writeCharSequence(CharSequence paramCharSequence);
  
  public void writeCharSequence(CharSequence paramCharSequence, int paramInt)
  {
    setOutputField(paramInt);
    writeCharSequence(paramCharSequence);
  }
  
  protected abstract void writeDouble(double paramDouble);
  
  public void writeDouble(double paramDouble, int paramInt)
  {
    setOutputField(paramInt);
    writeDouble(paramDouble);
  }
  
  protected void writeDoubleArray(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble != null)
    {
      int j = paramArrayOfDouble.length;
      writeInt(j);
      int i = 0;
      while (i < j)
      {
        writeDouble(paramArrayOfDouble[i]);
        i += 1;
      }
    }
    writeInt(-1);
  }
  
  public void writeDoubleArray(double[] paramArrayOfDouble, int paramInt)
  {
    setOutputField(paramInt);
    writeDoubleArray(paramArrayOfDouble);
  }
  
  public void writeException(Exception paramException, int paramInt)
  {
    setOutputField(paramInt);
    if (paramException == null)
    {
      writeNoException();
      return;
    }
    paramInt = 0;
    if (((paramException instanceof Parcelable)) && (paramException.getClass().getClassLoader() == Parcelable.class.getClassLoader())) {
      paramInt = -9;
    }
    for (;;)
    {
      writeInt(paramInt);
      if (paramInt != 0) {
        break label161;
      }
      if (!(paramException instanceof RuntimeException)) {
        break;
      }
      throw ((RuntimeException)paramException);
      if ((paramException instanceof SecurityException)) {
        paramInt = -1;
      } else if ((paramException instanceof BadParcelableException)) {
        paramInt = -2;
      } else if ((paramException instanceof IllegalArgumentException)) {
        paramInt = -3;
      } else if ((paramException instanceof NullPointerException)) {
        paramInt = -4;
      } else if ((paramException instanceof IllegalStateException)) {
        paramInt = -5;
      } else if ((paramException instanceof NetworkOnMainThreadException)) {
        paramInt = -6;
      } else if ((paramException instanceof UnsupportedOperationException)) {
        paramInt = -7;
      }
    }
    throw new RuntimeException(paramException);
    label161:
    writeString(paramException.getMessage());
    switch (paramInt)
    {
    default: 
      return;
    }
    writeParcelable((Parcelable)paramException);
  }
  
  protected abstract void writeFloat(float paramFloat);
  
  public void writeFloat(float paramFloat, int paramInt)
  {
    setOutputField(paramInt);
    writeFloat(paramFloat);
  }
  
  protected void writeFloatArray(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null)
    {
      int j = paramArrayOfFloat.length;
      writeInt(j);
      int i = 0;
      while (i < j)
      {
        writeFloat(paramArrayOfFloat[i]);
        i += 1;
      }
    }
    writeInt(-1);
  }
  
  public void writeFloatArray(float[] paramArrayOfFloat, int paramInt)
  {
    setOutputField(paramInt);
    writeFloatArray(paramArrayOfFloat);
  }
  
  protected abstract void writeInt(int paramInt);
  
  public void writeInt(int paramInt1, int paramInt2)
  {
    setOutputField(paramInt2);
    writeInt(paramInt1);
  }
  
  protected void writeIntArray(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      int j = paramArrayOfInt.length;
      writeInt(j);
      int i = 0;
      while (i < j)
      {
        writeInt(paramArrayOfInt[i]);
        i += 1;
      }
    }
    writeInt(-1);
  }
  
  public void writeIntArray(int[] paramArrayOfInt, int paramInt)
  {
    setOutputField(paramInt);
    writeIntArray(paramArrayOfInt);
  }
  
  public <T> void writeList(List<T> paramList, int paramInt)
  {
    writeCollection(paramList, paramInt);
  }
  
  protected abstract void writeLong(long paramLong);
  
  public void writeLong(long paramLong, int paramInt)
  {
    setOutputField(paramInt);
    writeLong(paramLong);
  }
  
  protected void writeLongArray(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong != null)
    {
      int j = paramArrayOfLong.length;
      writeInt(j);
      int i = 0;
      while (i < j)
      {
        writeLong(paramArrayOfLong[i]);
        i += 1;
      }
    }
    writeInt(-1);
  }
  
  public void writeLongArray(long[] paramArrayOfLong, int paramInt)
  {
    setOutputField(paramInt);
    writeLongArray(paramArrayOfLong);
  }
  
  public <K, V> void writeMap(Map<K, V> paramMap, int paramInt)
  {
    setOutputField(paramInt);
    if (paramMap == null) {
      writeInt(-1);
    }
    do
    {
      return;
      paramInt = paramMap.size();
      writeInt(paramInt);
    } while (paramInt == 0);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList1.add(localEntry.getKey());
      localArrayList2.add(localEntry.getValue());
    }
    writeCollection(localArrayList1);
    writeCollection(localArrayList2);
  }
  
  protected void writeNoException()
  {
    writeInt(0);
  }
  
  protected abstract void writeParcelable(Parcelable paramParcelable);
  
  public void writeParcelable(Parcelable paramParcelable, int paramInt)
  {
    setOutputField(paramInt);
    writeParcelable(paramParcelable);
  }
  
  public void writeSerializable(Serializable paramSerializable, int paramInt)
  {
    setOutputField(paramInt);
    writeSerializable(paramSerializable);
  }
  
  public <T> void writeSet(Set<T> paramSet, int paramInt)
  {
    writeCollection(paramSet, paramInt);
  }
  
  @RequiresApi(api=21)
  public void writeSize(Size paramSize, int paramInt)
  {
    setOutputField(paramInt);
    if (paramSize != null) {}
    for (boolean bool = true;; bool = false)
    {
      writeBoolean(bool);
      if (paramSize != null)
      {
        writeInt(paramSize.getWidth());
        writeInt(paramSize.getHeight());
      }
      return;
    }
  }
  
  @RequiresApi(api=21)
  public void writeSizeF(SizeF paramSizeF, int paramInt)
  {
    setOutputField(paramInt);
    if (paramSizeF != null) {}
    for (boolean bool = true;; bool = false)
    {
      writeBoolean(bool);
      if (paramSizeF != null)
      {
        writeFloat(paramSizeF.getWidth());
        writeFloat(paramSizeF.getHeight());
      }
      return;
    }
  }
  
  public void writeSparseBooleanArray(SparseBooleanArray paramSparseBooleanArray, int paramInt)
  {
    setOutputField(paramInt);
    if (paramSparseBooleanArray == null) {
      writeInt(-1);
    }
    for (;;)
    {
      return;
      int i = paramSparseBooleanArray.size();
      writeInt(i);
      paramInt = 0;
      while (paramInt < i)
      {
        writeInt(paramSparseBooleanArray.keyAt(paramInt));
        writeBoolean(paramSparseBooleanArray.valueAt(paramInt));
        paramInt += 1;
      }
    }
  }
  
  protected abstract void writeString(String paramString);
  
  public void writeString(String paramString, int paramInt)
  {
    setOutputField(paramInt);
    writeString(paramString);
  }
  
  protected abstract void writeStrongBinder(IBinder paramIBinder);
  
  public void writeStrongBinder(IBinder paramIBinder, int paramInt)
  {
    setOutputField(paramInt);
    writeStrongBinder(paramIBinder);
  }
  
  protected abstract void writeStrongInterface(IInterface paramIInterface);
  
  public void writeStrongInterface(IInterface paramIInterface, int paramInt)
  {
    setOutputField(paramInt);
    writeStrongInterface(paramIInterface);
  }
  
  protected <T extends VersionedParcelable> void writeToParcel(T paramT, VersionedParcel paramVersionedParcel)
  {
    try
    {
      getWriteMethod(paramT.getClass()).invoke(null, new Object[] { paramT, paramVersionedParcel });
      return;
    }
    catch (IllegalAccessException paramT)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", paramT);
    }
    catch (InvocationTargetException paramT)
    {
      if ((paramT.getCause() instanceof RuntimeException)) {
        throw ((RuntimeException)paramT.getCause());
      }
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", paramT);
    }
    catch (NoSuchMethodException paramT)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", paramT);
    }
    catch (ClassNotFoundException paramT)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", paramT);
    }
  }
  
  protected void writeVersionedParcelable(VersionedParcelable paramVersionedParcelable)
  {
    if (paramVersionedParcelable == null)
    {
      writeString(null);
      return;
    }
    writeVersionedParcelableCreator(paramVersionedParcelable);
    VersionedParcel localVersionedParcel = createSubParcel();
    writeToParcel(paramVersionedParcelable, localVersionedParcel);
    localVersionedParcel.closeField();
  }
  
  public void writeVersionedParcelable(VersionedParcelable paramVersionedParcelable, int paramInt)
  {
    setOutputField(paramInt);
    writeVersionedParcelable(paramVersionedParcelable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.versionedparcelable.VersionedParcel
 * JD-Core Version:    0.7.0.1
 */