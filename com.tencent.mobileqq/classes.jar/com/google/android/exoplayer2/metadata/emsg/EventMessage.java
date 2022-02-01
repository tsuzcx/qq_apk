package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class EventMessage
  implements Metadata.Entry
{
  public static final Parcelable.Creator<EventMessage> CREATOR = new EventMessage.1();
  public final long durationMs;
  private int hashCode;
  public final long id;
  public final byte[] messageData;
  public final long presentationTimeUs;
  public final String schemeIdUri;
  public final String value;
  
  EventMessage(Parcel paramParcel)
  {
    this.schemeIdUri = paramParcel.readString();
    this.value = paramParcel.readString();
    this.presentationTimeUs = paramParcel.readLong();
    this.durationMs = paramParcel.readLong();
    this.id = paramParcel.readLong();
    this.messageData = paramParcel.createByteArray();
  }
  
  public EventMessage(String paramString1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte, long paramLong3)
  {
    this.schemeIdUri = paramString1;
    this.value = paramString2;
    this.durationMs = paramLong1;
    this.id = paramLong2;
    this.messageData = paramArrayOfByte;
    this.presentationTimeUs = paramLong3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (EventMessage)paramObject;
      return (this.presentationTimeUs == paramObject.presentationTimeUs) && (this.durationMs == paramObject.durationMs) && (this.id == paramObject.id) && (Util.areEqual(this.schemeIdUri, paramObject.schemeIdUri)) && (Util.areEqual(this.value, paramObject.value)) && (Arrays.equals(this.messageData, paramObject.messageData));
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0)
    {
      String str = this.schemeIdUri;
      int j = 0;
      int i;
      if (str != null) {
        i = str.hashCode();
      } else {
        i = 0;
      }
      str = this.value;
      if (str != null) {
        j = str.hashCode();
      }
      long l = this.presentationTimeUs;
      int k = (int)(l ^ l >>> 32);
      l = this.durationMs;
      int m = (int)(l ^ l >>> 32);
      l = this.id;
      this.hashCode = ((((((527 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + (int)(l ^ l >>> 32)) * 31 + Arrays.hashCode(this.messageData));
    }
    return this.hashCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.schemeIdUri);
    paramParcel.writeString(this.value);
    paramParcel.writeLong(this.presentationTimeUs);
    paramParcel.writeLong(this.durationMs);
    paramParcel.writeLong(this.id);
    paramParcel.writeByteArray(this.messageData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.emsg.EventMessage
 * JD-Core Version:    0.7.0.1
 */