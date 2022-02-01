package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
class VersionedParcelParcel
  extends VersionedParcel
{
  private static final boolean DEBUG = false;
  private static final String TAG = "VersionedParcelParcel";
  private int mCurrentField = -1;
  private final int mEnd;
  private int mFieldId = -1;
  private int mNextRead = 0;
  private final int mOffset;
  private final Parcel mParcel;
  private final SparseIntArray mPositionLookup = new SparseIntArray();
  private final String mPrefix;
  
  VersionedParcelParcel(Parcel paramParcel)
  {
    this(paramParcel, paramParcel.dataPosition(), paramParcel.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
  }
  
  private VersionedParcelParcel(Parcel paramParcel, int paramInt1, int paramInt2, String paramString, ArrayMap<String, Method> paramArrayMap1, ArrayMap<String, Method> paramArrayMap2, ArrayMap<String, Class> paramArrayMap)
  {
    super(paramArrayMap1, paramArrayMap2, paramArrayMap);
    this.mParcel = paramParcel;
    this.mOffset = paramInt1;
    this.mEnd = paramInt2;
    this.mNextRead = this.mOffset;
    this.mPrefix = paramString;
  }
  
  public void closeField()
  {
    if (this.mCurrentField >= 0)
    {
      int i = this.mPositionLookup.get(this.mCurrentField);
      int j = this.mParcel.dataPosition();
      this.mParcel.setDataPosition(i);
      this.mParcel.writeInt(j - i);
      this.mParcel.setDataPosition(j);
    }
  }
  
  protected VersionedParcel createSubParcel()
  {
    Parcel localParcel = this.mParcel;
    int j = this.mParcel.dataPosition();
    if (this.mNextRead == this.mOffset) {}
    for (int i = this.mEnd;; i = this.mNextRead) {
      return new VersionedParcelParcel(localParcel, j, i, this.mPrefix + "  ", this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }
  }
  
  public boolean readBoolean()
  {
    return this.mParcel.readInt() != 0;
  }
  
  public Bundle readBundle()
  {
    return this.mParcel.readBundle(getClass().getClassLoader());
  }
  
  public byte[] readByteArray()
  {
    int i = this.mParcel.readInt();
    if (i < 0) {
      return null;
    }
    byte[] arrayOfByte = new byte[i];
    this.mParcel.readByteArray(arrayOfByte);
    return arrayOfByte;
  }
  
  protected CharSequence readCharSequence()
  {
    return (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.mParcel);
  }
  
  public double readDouble()
  {
    return this.mParcel.readDouble();
  }
  
  public boolean readField(int paramInt)
  {
    if (this.mNextRead < this.mEnd) {
      if (this.mFieldId != paramInt) {}
    }
    while (this.mFieldId == paramInt)
    {
      return true;
      if (String.valueOf(this.mFieldId).compareTo(String.valueOf(paramInt)) > 0) {
        return false;
      }
      this.mParcel.setDataPosition(this.mNextRead);
      int i = this.mParcel.readInt();
      this.mFieldId = this.mParcel.readInt();
      this.mNextRead = (i + this.mNextRead);
      break;
    }
    return false;
  }
  
  public float readFloat()
  {
    return this.mParcel.readFloat();
  }
  
  public int readInt()
  {
    return this.mParcel.readInt();
  }
  
  public long readLong()
  {
    return this.mParcel.readLong();
  }
  
  public <T extends Parcelable> T readParcelable()
  {
    return this.mParcel.readParcelable(getClass().getClassLoader());
  }
  
  public String readString()
  {
    return this.mParcel.readString();
  }
  
  public IBinder readStrongBinder()
  {
    return this.mParcel.readStrongBinder();
  }
  
  public void setOutputField(int paramInt)
  {
    closeField();
    this.mCurrentField = paramInt;
    this.mPositionLookup.put(paramInt, this.mParcel.dataPosition());
    writeInt(0);
    writeInt(paramInt);
  }
  
  public void writeBoolean(boolean paramBoolean)
  {
    Parcel localParcel = this.mParcel;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localParcel.writeInt(i);
      return;
    }
  }
  
  public void writeBundle(Bundle paramBundle)
  {
    this.mParcel.writeBundle(paramBundle);
  }
  
  public void writeByteArray(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      this.mParcel.writeInt(paramArrayOfByte.length);
      this.mParcel.writeByteArray(paramArrayOfByte);
      return;
    }
    this.mParcel.writeInt(-1);
  }
  
  public void writeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      this.mParcel.writeInt(paramArrayOfByte.length);
      this.mParcel.writeByteArray(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    this.mParcel.writeInt(-1);
  }
  
  protected void writeCharSequence(CharSequence paramCharSequence)
  {
    TextUtils.writeToParcel(paramCharSequence, this.mParcel, 0);
  }
  
  public void writeDouble(double paramDouble)
  {
    this.mParcel.writeDouble(paramDouble);
  }
  
  public void writeFloat(float paramFloat)
  {
    this.mParcel.writeFloat(paramFloat);
  }
  
  public void writeInt(int paramInt)
  {
    this.mParcel.writeInt(paramInt);
  }
  
  public void writeLong(long paramLong)
  {
    this.mParcel.writeLong(paramLong);
  }
  
  public void writeParcelable(Parcelable paramParcelable)
  {
    this.mParcel.writeParcelable(paramParcelable, 0);
  }
  
  public void writeString(String paramString)
  {
    this.mParcel.writeString(paramString);
  }
  
  public void writeStrongBinder(IBinder paramIBinder)
  {
    this.mParcel.writeStrongBinder(paramIBinder);
  }
  
  public void writeStrongInterface(IInterface paramIInterface)
  {
    this.mParcel.writeStrongInterface(paramIInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.versionedparcelable.VersionedParcelParcel
 * JD-Core Version:    0.7.0.1
 */