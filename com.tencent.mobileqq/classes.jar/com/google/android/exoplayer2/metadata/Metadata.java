package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;
import java.util.List;

public final class Metadata
  implements Parcelable
{
  public static final Parcelable.Creator<Metadata> CREATOR = new Metadata.1();
  private final Metadata.Entry[] entries;
  
  Metadata(Parcel paramParcel)
  {
    this.entries = new Metadata.Entry[paramParcel.readInt()];
    int i = 0;
    while (i < this.entries.length)
    {
      this.entries[i] = ((Metadata.Entry)paramParcel.readParcelable(Metadata.Entry.class.getClassLoader()));
      i += 1;
    }
  }
  
  public Metadata(List<? extends Metadata.Entry> paramList)
  {
    if (paramList != null)
    {
      this.entries = new Metadata.Entry[paramList.size()];
      paramList.toArray(this.entries);
      return;
    }
    this.entries = new Metadata.Entry[0];
  }
  
  public Metadata(Metadata.Entry... paramVarArgs)
  {
    Metadata.Entry[] arrayOfEntry = paramVarArgs;
    if (paramVarArgs == null) {
      arrayOfEntry = new Metadata.Entry[0];
    }
    this.entries = arrayOfEntry;
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
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (Metadata)paramObject;
    return Arrays.equals(this.entries, paramObject.entries);
  }
  
  public Metadata.Entry get(int paramInt)
  {
    return this.entries[paramInt];
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.entries);
  }
  
  public int length()
  {
    return this.entries.length;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.entries.length);
    Metadata.Entry[] arrayOfEntry = this.entries;
    int i = arrayOfEntry.length;
    paramInt = 0;
    while (paramInt < i)
    {
      paramParcel.writeParcelable(arrayOfEntry[paramInt], 0);
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.metadata.Metadata
 * JD-Core Version:    0.7.0.1
 */