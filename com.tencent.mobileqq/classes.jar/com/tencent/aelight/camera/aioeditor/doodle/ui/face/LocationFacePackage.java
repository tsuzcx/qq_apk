package com.tencent.aelight.camera.aioeditor.doodle.ui.face;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.utils.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public class LocationFacePackage
  extends FacePackage
{
  public List<LocationFacePackage.Item> a;
  public boolean b;
  public String f;
  
  public LocationFacePackage(@NonNull String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static List<LocationFacePackage.Item> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONArray.length())
    {
      localArrayList.add(new LocationFacePackage.Item(paramJSONArray.getJSONObject(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public LocationFacePackage.Item a(String paramString)
  {
    if (!StringUtil.a(paramString))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          LocationFacePackage.Item localItem = (LocationFacePackage.Item)((Iterator)localObject).next();
          if (paramString.equals(localItem.f)) {
            return localItem;
          }
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    return "LocationFacePackage";
  }
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((LocationFacePackage.Item)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getThumbUri with illegal index : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", the item size is : ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public int b()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return ((LocationFacePackage.Item)this.jdField_a_of_type_JavaUtilList.get(paramInt)).b;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCategory with illegal index : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", the item size is : ");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList.size());
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("LocationFacePackage{");
    localStringBuffer.append("id='");
    localStringBuffer.append(this.jdField_a_of_type_JavaLangString);
    localStringBuffer.append('\'');
    localStringBuffer.append("logoUrl='");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append("logoDrawable='");
    localStringBuffer.append(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    localStringBuffer.append('\'');
    localStringBuffer.append("items=");
    localStringBuffer.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuffer.append(", isLocating=");
    localStringBuffer.append(this.b);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage
 * JD-Core Version:    0.7.0.1
 */