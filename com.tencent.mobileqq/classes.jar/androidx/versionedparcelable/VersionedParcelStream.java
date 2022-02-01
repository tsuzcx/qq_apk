package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
class VersionedParcelStream
  extends VersionedParcel
{
  private static final int TYPE_BOOLEAN = 5;
  private static final int TYPE_BOOLEAN_ARRAY = 6;
  private static final int TYPE_DOUBLE = 7;
  private static final int TYPE_DOUBLE_ARRAY = 8;
  private static final int TYPE_FLOAT = 13;
  private static final int TYPE_FLOAT_ARRAY = 14;
  private static final int TYPE_INT = 9;
  private static final int TYPE_INT_ARRAY = 10;
  private static final int TYPE_LONG = 11;
  private static final int TYPE_LONG_ARRAY = 12;
  private static final int TYPE_NULL = 0;
  private static final int TYPE_STRING = 3;
  private static final int TYPE_STRING_ARRAY = 4;
  private static final int TYPE_SUB_BUNDLE = 1;
  private static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
  private static final Charset UTF_16 = Charset.forName("UTF-16");
  int mCount = 0;
  private DataInputStream mCurrentInput;
  private DataOutputStream mCurrentOutput;
  private VersionedParcelStream.FieldBuffer mFieldBuffer;
  private int mFieldId = -1;
  int mFieldSize = -1;
  private boolean mIgnoreParcelables;
  private final DataInputStream mMasterInput;
  private final DataOutputStream mMasterOutput;
  
  public VersionedParcelStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    this(paramInputStream, paramOutputStream, new ArrayMap(), new ArrayMap(), new ArrayMap());
  }
  
  private VersionedParcelStream(InputStream paramInputStream, OutputStream paramOutputStream, ArrayMap<String, Method> paramArrayMap1, ArrayMap<String, Method> paramArrayMap2, ArrayMap<String, Class> paramArrayMap)
  {
    super(paramArrayMap1, paramArrayMap2, paramArrayMap);
    if (paramInputStream != null) {}
    for (paramInputStream = new DataInputStream(new VersionedParcelStream.1(this, paramInputStream));; paramInputStream = null)
    {
      this.mMasterInput = paramInputStream;
      paramInputStream = localObject;
      if (paramOutputStream != null) {
        paramInputStream = new DataOutputStream(paramOutputStream);
      }
      this.mMasterOutput = paramInputStream;
      this.mCurrentInput = this.mMasterInput;
      this.mCurrentOutput = this.mMasterOutput;
      return;
    }
  }
  
  private void readObject(int paramInt, String paramString, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      throw new RuntimeException("Unknown type " + paramInt);
    case 0: 
      paramBundle.putParcelable(paramString, null);
      return;
    case 1: 
      paramBundle.putBundle(paramString, readBundle());
      return;
    case 2: 
      paramBundle.putBundle(paramString, readBundle());
      return;
    case 3: 
      paramBundle.putString(paramString, readString());
      return;
    case 4: 
      paramBundle.putStringArray(paramString, (String[])readArray(new String[0]));
      return;
    case 5: 
      paramBundle.putBoolean(paramString, readBoolean());
      return;
    case 6: 
      paramBundle.putBooleanArray(paramString, readBooleanArray());
      return;
    case 7: 
      paramBundle.putDouble(paramString, readDouble());
      return;
    case 8: 
      paramBundle.putDoubleArray(paramString, readDoubleArray());
      return;
    case 9: 
      paramBundle.putInt(paramString, readInt());
      return;
    case 10: 
      paramBundle.putIntArray(paramString, readIntArray());
      return;
    case 11: 
      paramBundle.putLong(paramString, readLong());
      return;
    case 12: 
      paramBundle.putLongArray(paramString, readLongArray());
      return;
    case 13: 
      paramBundle.putFloat(paramString, readFloat());
      return;
    }
    paramBundle.putFloatArray(paramString, readFloatArray());
  }
  
  private void writeObject(Object paramObject)
  {
    if (paramObject == null)
    {
      writeInt(0);
      return;
    }
    if ((paramObject instanceof Bundle))
    {
      writeInt(1);
      writeBundle((Bundle)paramObject);
      return;
    }
    if ((paramObject instanceof String))
    {
      writeInt(3);
      writeString((String)paramObject);
      return;
    }
    if ((paramObject instanceof String[]))
    {
      writeInt(4);
      writeArray((String[])paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      writeInt(5);
      writeBoolean(((Boolean)paramObject).booleanValue());
      return;
    }
    if ((paramObject instanceof boolean[]))
    {
      writeInt(6);
      writeBooleanArray((boolean[])paramObject);
      return;
    }
    if ((paramObject instanceof Double))
    {
      writeInt(7);
      writeDouble(((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof double[]))
    {
      writeInt(8);
      writeDoubleArray((double[])paramObject);
      return;
    }
    if ((paramObject instanceof Integer))
    {
      writeInt(9);
      writeInt(((Integer)paramObject).intValue());
      return;
    }
    if ((paramObject instanceof int[]))
    {
      writeInt(10);
      writeIntArray((int[])paramObject);
      return;
    }
    if ((paramObject instanceof Long))
    {
      writeInt(11);
      writeLong(((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof long[]))
    {
      writeInt(12);
      writeLongArray((long[])paramObject);
      return;
    }
    if ((paramObject instanceof Float))
    {
      writeInt(13);
      writeFloat(((Float)paramObject).floatValue());
      return;
    }
    if ((paramObject instanceof float[]))
    {
      writeInt(14);
      writeFloatArray((float[])paramObject);
      return;
    }
    throw new IllegalArgumentException("Unsupported type " + paramObject.getClass());
  }
  
  public void closeField()
  {
    if (this.mFieldBuffer != null) {}
    try
    {
      if (this.mFieldBuffer.mOutput.size() != 0) {
        this.mFieldBuffer.flushField();
      }
      this.mFieldBuffer = null;
      return;
    }
    catch (IOException localIOException)
    {
      throw new VersionedParcel.ParcelException(localIOException);
    }
  }
  
  protected VersionedParcel createSubParcel()
  {
    return new VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
  }
  
  public boolean isStream()
  {
    return true;
  }
  
  public boolean readBoolean()
  {
    try
    {
      boolean bool = this.mCurrentInput.readBoolean();
      return bool;
    }
    catch (IOException localIOException)
    {
      throw new VersionedParcel.ParcelException(localIOException);
    }
  }
  
  public Bundle readBundle()
  {
    int j = readInt();
    Object localObject;
    if (j < 0)
    {
      localObject = null;
      return localObject;
    }
    Bundle localBundle = new Bundle();
    int i = 0;
    for (;;)
    {
      localObject = localBundle;
      if (i >= j) {
        break;
      }
      localObject = readString();
      readObject(readInt(), (String)localObject, localBundle);
      i += 1;
    }
  }
  
  public byte[] readByteArray()
  {
    try
    {
      int i = this.mCurrentInput.readInt();
      if (i > 0)
      {
        byte[] arrayOfByte = new byte[i];
        this.mCurrentInput.readFully(arrayOfByte);
        return arrayOfByte;
      }
      return null;
    }
    catch (IOException localIOException)
    {
      throw new VersionedParcel.ParcelException(localIOException);
    }
  }
  
  protected CharSequence readCharSequence()
  {
    return null;
  }
  
  public double readDouble()
  {
    try
    {
      double d = this.mCurrentInput.readDouble();
      return d;
    }
    catch (IOException localIOException)
    {
      throw new VersionedParcel.ParcelException(localIOException);
    }
  }
  
  public boolean readField(int paramInt)
  {
    try
    {
      for (;;)
      {
        if (this.mFieldId == paramInt) {
          return true;
        }
        if (String.valueOf(this.mFieldId).compareTo(String.valueOf(paramInt)) > 0) {
          break;
        }
        if (this.mCount < this.mFieldSize) {
          this.mMasterInput.skip(this.mFieldSize - this.mCount);
        }
        this.mFieldSize = -1;
        int k = this.mMasterInput.readInt();
        this.mCount = 0;
        int j = k & 0xFFFF;
        int i = j;
        if (j == 65535) {
          i = this.mMasterInput.readInt();
        }
        this.mFieldId = (k >> 16 & 0xFFFF);
        this.mFieldSize = i;
      }
      return false;
    }
    catch (IOException localIOException) {}
  }
  
  public float readFloat()
  {
    try
    {
      float f = this.mCurrentInput.readFloat();
      return f;
    }
    catch (IOException localIOException)
    {
      throw new VersionedParcel.ParcelException(localIOException);
    }
  }
  
  public int readInt()
  {
    try
    {
      int i = this.mCurrentInput.readInt();
      return i;
    }
    catch (IOException localIOException)
    {
      throw new VersionedParcel.ParcelException(localIOException);
    }
  }
  
  public long readLong()
  {
    try
    {
      long l = this.mCurrentInput.readLong();
      return l;
    }
    catch (IOException localIOException)
    {
      throw new VersionedParcel.ParcelException(localIOException);
    }
  }
  
  public <T extends Parcelable> T readParcelable()
  {
    return null;
  }
  
  public String readString()
  {
    try
    {
      int i = this.mCurrentInput.readInt();
      if (i > 0)
      {
        Object localObject = new byte[i];
        this.mCurrentInput.readFully((byte[])localObject);
        localObject = new String((byte[])localObject, UTF_16);
        return localObject;
      }
      return null;
    }
    catch (IOException localIOException)
    {
      throw new VersionedParcel.ParcelException(localIOException);
    }
  }
  
  public IBinder readStrongBinder()
  {
    return null;
  }
  
  public void setOutputField(int paramInt)
  {
    closeField();
    this.mFieldBuffer = new VersionedParcelStream.FieldBuffer(paramInt, this.mMasterOutput);
    this.mCurrentOutput = this.mFieldBuffer.mDataStream;
  }
  
  public void setSerializationFlags(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      throw new RuntimeException("Serialization of this object is not allowed");
    }
    this.mIgnoreParcelables = paramBoolean2;
  }
  
  public void writeBoolean(boolean paramBoolean)
  {
    try
    {
      this.mCurrentOutput.writeBoolean(paramBoolean);
      return;
    }
    catch (IOException localIOException)
    {
      throw new VersionedParcel.ParcelException(localIOException);
    }
  }
  
  public void writeBundle(Bundle paramBundle)
  {
    if (paramBundle != null) {
      try
      {
        Object localObject = paramBundle.keySet();
        this.mCurrentOutput.writeInt(((Set)localObject).size());
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          writeString(str);
          writeObject(paramBundle.get(str));
          continue;
          this.mCurrentOutput.writeInt(-1);
        }
      }
      catch (IOException paramBundle)
      {
        throw new VersionedParcel.ParcelException(paramBundle);
      }
    }
  }
  
  public void writeByteArray(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      this.mCurrentOutput.writeInt(paramArrayOfByte.length);
      this.mCurrentOutput.write(paramArrayOfByte);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new VersionedParcel.ParcelException(paramArrayOfByte);
    }
    this.mCurrentOutput.writeInt(-1);
  }
  
  public void writeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      this.mCurrentOutput.writeInt(paramInt2);
      this.mCurrentOutput.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      throw new VersionedParcel.ParcelException(paramArrayOfByte);
    }
    this.mCurrentOutput.writeInt(-1);
  }
  
  protected void writeCharSequence(CharSequence paramCharSequence)
  {
    if (!this.mIgnoreParcelables) {
      throw new RuntimeException("CharSequence cannot be written to an OutputStream");
    }
  }
  
  public void writeDouble(double paramDouble)
  {
    try
    {
      this.mCurrentOutput.writeDouble(paramDouble);
      return;
    }
    catch (IOException localIOException)
    {
      throw new VersionedParcel.ParcelException(localIOException);
    }
  }
  
  public void writeFloat(float paramFloat)
  {
    try
    {
      this.mCurrentOutput.writeFloat(paramFloat);
      return;
    }
    catch (IOException localIOException)
    {
      throw new VersionedParcel.ParcelException(localIOException);
    }
  }
  
  public void writeInt(int paramInt)
  {
    try
    {
      this.mCurrentOutput.writeInt(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      throw new VersionedParcel.ParcelException(localIOException);
    }
  }
  
  public void writeLong(long paramLong)
  {
    try
    {
      this.mCurrentOutput.writeLong(paramLong);
      return;
    }
    catch (IOException localIOException)
    {
      throw new VersionedParcel.ParcelException(localIOException);
    }
  }
  
  public void writeParcelable(Parcelable paramParcelable)
  {
    if (!this.mIgnoreParcelables) {
      throw new RuntimeException("Parcelables cannot be written to an OutputStream");
    }
  }
  
  public void writeString(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = paramString.getBytes(UTF_16);
      this.mCurrentOutput.writeInt(paramString.length);
      this.mCurrentOutput.write(paramString);
      return;
    }
    catch (IOException paramString)
    {
      throw new VersionedParcel.ParcelException(paramString);
    }
    this.mCurrentOutput.writeInt(-1);
  }
  
  public void writeStrongBinder(IBinder paramIBinder)
  {
    if (!this.mIgnoreParcelables) {
      throw new RuntimeException("Binders cannot be written to an OutputStream");
    }
  }
  
  public void writeStrongInterface(IInterface paramIInterface)
  {
    if (!this.mIgnoreParcelables) {
      throw new RuntimeException("Binders cannot be written to an OutputStream");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.versionedparcelable.VersionedParcelStream
 * JD-Core Version:    0.7.0.1
 */