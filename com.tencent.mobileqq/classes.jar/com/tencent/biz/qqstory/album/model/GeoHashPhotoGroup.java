package com.tencent.biz.qqstory.album.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.album.tools.GeoHashUtils.Gps;
import com.tencent.biz.qqstory.model.item.AddressItem;
import java.util.List;

public class GeoHashPhotoGroup
{
  public GeoHashUtils.Gps a;
  public AddressItem a;
  public String a;
  public List<StoryAlbum.PicInfo> a;
  
  public GeoHashPhotoGroup(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof GeoHashPhotoGroup)) {
      return TextUtils.equals(this.jdField_a_of_type_JavaLangString, ((GeoHashPhotoGroup)paramObject).jdField_a_of_type_JavaLangString);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("GeoHashPhotoGroup=[");
    localStringBuilder.append("geohashString:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("picList size:");
    List localList = this.jdField_a_of_type_JavaUtilList;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.model.GeoHashPhotoGroup
 * JD-Core Version:    0.7.0.1
 */