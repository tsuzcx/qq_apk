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
  public List<LocationFacePackage.Item> k = new ArrayList();
  public boolean l;
  public String m;
  
  public LocationFacePackage(@NonNull String paramString)
  {
    super(paramString);
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
  
  public String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.k.size())) {
      return ((LocationFacePackage.Item)this.k.get(paramInt)).a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getThumbUri with illegal index : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", the item size is : ");
    localStringBuilder.append(this.k.size());
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public LocationFacePackage.Item b(String paramString)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      Object localObject = this.k;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          LocationFacePackage.Item localItem = (LocationFacePackage.Item)((Iterator)localObject).next();
          if (paramString.equals(localItem.h)) {
            return localItem;
          }
        }
      }
    }
    return null;
  }
  
  public String b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.k.size())) {
      return ((LocationFacePackage.Item)this.k.get(paramInt)).b;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCategory with illegal index : ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", the item size is : ");
    localStringBuilder.append(this.k.size());
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public String c()
  {
    return "LocationFacePackage";
  }
  
  public int d()
  {
    List localList = this.k;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("LocationFacePackage{");
    localStringBuffer.append("id='");
    localStringBuffer.append(this.a);
    localStringBuffer.append('\'');
    localStringBuffer.append("logoUrl='");
    localStringBuffer.append(this.c);
    localStringBuffer.append('\'');
    localStringBuffer.append("logoDrawable='");
    localStringBuffer.append(this.e);
    localStringBuffer.append('\'');
    localStringBuffer.append("items=");
    localStringBuffer.append(this.k);
    localStringBuffer.append(", isLocating=");
    localStringBuffer.append(this.l);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage
 * JD-Core Version:    0.7.0.1
 */