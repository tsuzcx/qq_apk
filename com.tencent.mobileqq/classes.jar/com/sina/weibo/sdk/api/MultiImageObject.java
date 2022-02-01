package com.sina.weibo.sdk.api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class MultiImageObject
  extends MediaObject
{
  public static final Parcelable.Creator<MultiImageObject> CREATOR = new MultiImageObject.1();
  private static final long serialVersionUID = 4858450022450986236L;
  public ArrayList<Uri> imageList;
  
  public MultiImageObject() {}
  
  protected MultiImageObject(Parcel paramParcel)
  {
    super(paramParcel);
    this.imageList = paramParcel.createTypedArrayList(Uri.CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ArrayList<Uri> getImageList()
  {
    return this.imageList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.imageList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.api.MultiImageObject
 * JD-Core Version:    0.7.0.1
 */