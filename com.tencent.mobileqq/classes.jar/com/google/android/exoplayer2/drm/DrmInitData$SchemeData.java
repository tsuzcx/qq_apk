package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.UUID;

public final class DrmInitData$SchemeData
  implements Parcelable
{
  public static final Parcelable.Creator<SchemeData> CREATOR = new DrmInitData.SchemeData.1();
  public final byte[] data;
  private int hashCode;
  public final String mimeType;
  public final boolean requiresSecureDecryption;
  private final UUID uuid;
  
  DrmInitData$SchemeData(Parcel paramParcel)
  {
    this.uuid = new UUID(paramParcel.readLong(), paramParcel.readLong());
    this.mimeType = paramParcel.readString();
    this.data = paramParcel.createByteArray();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.requiresSecureDecryption = bool;
      return;
    }
  }
  
  public DrmInitData$SchemeData(UUID paramUUID, String paramString, byte[] paramArrayOfByte)
  {
    this(paramUUID, paramString, paramArrayOfByte, false);
  }
  
  public DrmInitData$SchemeData(UUID paramUUID, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    this.uuid = ((UUID)Assertions.checkNotNull(paramUUID));
    this.mimeType = ((String)Assertions.checkNotNull(paramString));
    this.data = paramArrayOfByte;
    this.requiresSecureDecryption = paramBoolean;
  }
  
  public boolean canReplace(SchemeData paramSchemeData)
  {
    return (hasData()) && (!paramSchemeData.hasData()) && (matches(paramSchemeData.uuid));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof SchemeData)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (SchemeData)paramObject;
      if ((!this.mimeType.equals(paramObject.mimeType)) || (!Util.areEqual(this.uuid, paramObject.uuid))) {
        break;
      }
      bool1 = bool2;
    } while (Arrays.equals(this.data, paramObject.data));
    return false;
  }
  
  public boolean hasData()
  {
    return this.data != null;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0) {
      this.hashCode = ((this.uuid.hashCode() * 31 + this.mimeType.hashCode()) * 31 + Arrays.hashCode(this.data));
    }
    return this.hashCode;
  }
  
  public boolean matches(UUID paramUUID)
  {
    return (C.UUID_NIL.equals(this.uuid)) || (paramUUID.equals(this.uuid));
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.uuid.getMostSignificantBits());
    paramParcel.writeLong(this.uuid.getLeastSignificantBits());
    paramParcel.writeString(this.mimeType);
    paramParcel.writeByteArray(this.data);
    if (this.requiresSecureDecryption) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DrmInitData.SchemeData
 * JD-Core Version:    0.7.0.1
 */