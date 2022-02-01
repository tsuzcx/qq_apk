package com.tencent.mobileqq.apollo.data;

import amrh;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class ApolloDress$Dress
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<Dress> CREATOR = new amrh();
  public int a;
  public long a;
  public ArrayList<String> a;
  public int b;
  public int c;
  
  public ApolloDress$Dress() {}
  
  public ApolloDress$Dress(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramParcel.readList(this.jdField_a_of_type_JavaUtilArrayList, String.class.getClassLoader());
  }
  
  protected Object clone()
  {
    Object localObject = null;
    try
    {
      Dress localDress = (Dress)super.clone();
      localObject = localDress;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      localObject.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)this.jdField_a_of_type_JavaUtilArrayList.clone());
    }
    return localObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.data.ApolloDress.Dress
 * JD-Core Version:    0.7.0.1
 */