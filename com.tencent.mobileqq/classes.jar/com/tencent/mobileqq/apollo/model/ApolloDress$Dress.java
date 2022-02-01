package com.tencent.mobileqq.apollo.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class ApolloDress$Dress
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<Dress> CREATOR = new ApolloDress.Dress.1();
  public ArrayList<String> attachPart;
  public int feeType;
  public int id;
  public int tag;
  public long ts;
  
  public ApolloDress$Dress() {}
  
  protected ApolloDress$Dress(Parcel paramParcel)
  {
    this.id = paramParcel.readInt();
    this.ts = paramParcel.readLong();
    this.feeType = paramParcel.readInt();
    this.tag = paramParcel.readInt();
    if (this.attachPart == null) {
      this.attachPart = new ArrayList();
    }
    paramParcel.readList(this.attachPart, String.class.getClassLoader());
  }
  
  protected Object clone()
  {
    Object localObject;
    try
    {
      Dress localDress = (Dress)super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
      localObject = null;
    }
    ArrayList localArrayList = this.attachPart;
    if (localArrayList != null) {
      localObject.attachPart = ((ArrayList)localArrayList.clone());
    }
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.id);
    paramParcel.writeLong(this.ts);
    paramParcel.writeInt(this.feeType);
    paramParcel.writeInt(this.tag);
    paramParcel.writeList(this.attachPart);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloDress.Dress
 * JD-Core Version:    0.7.0.1
 */