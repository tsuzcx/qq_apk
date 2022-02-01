package com.tencent.luggage.scanner.qbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qbar.QBar.QBarResult;

public class d
  extends QBar.QBarResult
  implements Parcelable
{
  public static final Parcelable.Creator<d> CREATOR = new d.1();
  public int a = 0;
  public c b;
  
  public d(int paramInt1, String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, int paramInt2)
  {
    this.typeID = paramInt1;
    this.typeName = paramString1;
    this.data = paramString2;
    this.rawData = paramArrayOfByte;
    this.charset = paramString3;
    this.priorityLevel = paramInt2;
  }
  
  public d(Parcel paramParcel)
  {
    this.typeID = paramParcel.readInt();
    this.typeName = paramParcel.readString();
    this.data = paramParcel.readString();
    paramParcel.readByteArray(this.rawData);
    this.charset = paramParcel.readString();
    this.a = paramParcel.readInt();
    this.b = ((c)paramParcel.readParcelable(c.class.getClassLoader()));
    this.priorityLevel = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.typeID);
    paramParcel.writeString(this.typeName);
    paramParcel.writeString(this.data);
    paramParcel.writeByteArray(this.rawData);
    paramParcel.writeString(this.charset);
    paramParcel.writeInt(this.a);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeInt(this.priorityLevel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.qbar.d
 * JD-Core Version:    0.7.0.1
 */