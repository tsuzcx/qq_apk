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
    int i = this.mCurrentField;
    if (i >= 0)
    {
      i = this.mPositionLookup.get(i);
      int j = this.mParcel.dataPosition();
      this.mParcel.setDataPosition(i);
      this.mParcel.writeInt(j - i);
      this.mParcel.setDataPosition(j);
    }
  }
  
  protected VersionedParcel createSubParcel()
  {
    Parcel localParcel = this.mParcel;
    int k = localParcel.dataPosition();
    int j = this.mNextRead;
    int i = j;
    if (j == this.mOffset) {
      i = this.mEnd;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mPrefix);
    localStringBuilder.append("  ");
    return new VersionedParcelParcel(localParcel, k, i, localStringBuilder.toString(), this.mReadCache, this.mWriteCache, this.mParcelizerCache);
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
    while (this.mNextRead < this.mEnd)
    {
      int i = this.mFieldId;
      if (i == paramInt) {
        return true;
      }
      if (String.valueOf(i).compareTo(String.valueOf(paramInt)) > 0) {
        return false;
      }
      this.mParcel.setDataPosition(this.mNextRead);
      i = this.mParcel.readInt();
      this.mFieldId = this.mParcel.readInt();
      this.mNextRead += i;
    }
    return this.mFieldId == paramInt;
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.versionedparcelable.VersionedParcelParcel
 * JD-Core Version:    0.7.0.1
 */