package com.tencent.biz.webviewplugin;

import abfe;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public final class NewerGuidePlugin$RecommendedListResp
  implements Parcelable
{
  public static final Parcelable.Creator<RecommendedListResp> CREATOR = new abfe();
  public int a;
  public long a;
  public List<NewerGuidePlugin.PhoneInfo> a;
  public int b;
  
  public NewerGuidePlugin$RecommendedListResp()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public NewerGuidePlugin$RecommendedListResp(Parcel paramParcel)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaUtilList = paramParcel.createTypedArrayList(NewerGuidePlugin.PhoneInfo.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeInt(this.b);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeTypedList(this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin.RecommendedListResp
 * JD-Core Version:    0.7.0.1
 */