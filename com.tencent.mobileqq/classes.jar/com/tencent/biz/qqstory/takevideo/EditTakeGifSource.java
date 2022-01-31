package com.tencent.biz.qqstory.takevideo;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import oih;

public class EditTakeGifSource
  extends EditLocalGifSource
{
  public static final Parcelable.Creator CREATOR = new oih();
  
  public EditTakeGifSource(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public EditTakeGifSource(String paramString, ArrayList paramArrayList, LocalMediaInfo paramLocalMediaInfo)
  {
    super(paramString, paramArrayList, paramLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditTakeGifSource
 * JD-Core Version:    0.7.0.1
 */