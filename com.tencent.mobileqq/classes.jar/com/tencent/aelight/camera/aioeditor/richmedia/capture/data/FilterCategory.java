package com.tencent.aelight.camera.aioeditor.richmedia.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.aelight.camera.struct.editor.FilterCategoryItem;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class FilterCategory
  implements Parcelable
{
  public static final Parcelable.Creator<FilterCategory> CREATOR = new FilterCategory.1();
  public int a;
  public String b;
  public List<FilterCategoryItem> c;
  
  protected FilterCategory(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.createTypedArrayList(FilterCategoryItem.CREATOR);
  }
  
  public FilterCategory(JSONObject paramJSONObject, CaptureRedDotConfig paramCaptureRedDotConfig)
  {
    this.b = paramJSONObject.optString("name");
    this.a = paramJSONObject.optInt("categoryId");
    int i;
    Object localObject2;
    Object localObject1;
    if (paramCaptureRedDotConfig != null)
    {
      i = paramJSONObject.optInt("redDotVersion");
      boolean bool = paramJSONObject.optBoolean("needRedDot");
      localObject2 = (CaptureRedDotConfig.CategoryRedConfig)paramCaptureRedDotConfig.categories.get(Integer.valueOf(this.a));
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((CaptureRedDotConfig.CategoryRedConfig)localObject2).version != i)
        {
          ((CaptureRedDotConfig.CategoryRedConfig)localObject2).version = i;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject2).showRedDot = bool;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject2).hasShow = false;
          ((CaptureRedDotConfig.CategoryRedConfig)localObject2).firstShowTime = 0L;
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = new CaptureRedDotConfig.CategoryRedConfig();
        ((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId = this.a;
        ((CaptureRedDotConfig.CategoryRedConfig)localObject1).version = i;
        ((CaptureRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
      }
    }
    else
    {
      localObject1 = null;
    }
    if (paramJSONObject.has("content"))
    {
      paramJSONObject = paramJSONObject.getJSONArray("content");
      localObject2 = new ArrayList();
      int k = paramJSONObject.length();
      i = 0;
      while (i < k)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        FilterCategoryItem localFilterCategoryItem = new FilterCategoryItem();
        localFilterCategoryItem.d = localJSONObject.optString("iconUrl");
        localFilterCategoryItem.b = localJSONObject.optString("name");
        localFilterCategoryItem.a = localJSONObject.optString("id");
        localFilterCategoryItem.f = this.a;
        localFilterCategoryItem.g = localJSONObject.optString("englishName");
        localFilterCategoryItem.h = localJSONObject.optString("usedPeople");
        localFilterCategoryItem.i = localJSONObject.optBoolean("advertisement");
        Object localObject4;
        if (localFilterCategoryItem.i)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("item.advertisement is true name is:");
          ((StringBuilder)localObject4).append(localFilterCategoryItem.b);
          QLog.d("FilterCategory", 2, ((StringBuilder)localObject4).toString());
          try
          {
            localFilterCategoryItem.n = localJSONObject.optString("badgeurl");
            localFilterCategoryItem.k = localJSONObject.optString("openurl");
            localFilterCategoryItem.j = localJSONObject.optString("androidopenurlheader");
            localFilterCategoryItem.l = localJSONObject.optString("storeurl");
            localFilterCategoryItem.m = localJSONObject.optBoolean("popup");
            localFilterCategoryItem.q = localJSONObject.optString("popupbtn");
            localFilterCategoryItem.p = localJSONObject.optString("popupcontent");
            localFilterCategoryItem.s = localJSONObject.optString("popupbtn2");
            localFilterCategoryItem.r = localJSONObject.optString("popupcontent2");
            localFilterCategoryItem.o = localJSONObject.optString("popupimgurl");
            localFilterCategoryItem.t = localJSONObject.optString("buttonbgcolor");
          }
          catch (Exception localException)
          {
            QLog.e("FilterCategory", 2, "item.advertisement is true has Exception", localException);
          }
        }
        else
        {
          Object localObject3 = localException.optJSONArray("filters");
          if (localObject3 != null)
          {
            int m = ((JSONArray)localObject3).length();
            int j = 0;
            while (j < m)
            {
              localObject4 = ((JSONArray)localObject3).getJSONObject(j).optString("name");
              if (!TextUtils.isEmpty((CharSequence)localObject4)) {
                localFilterCategoryItem.v.add(localObject4);
              }
              j += 1;
            }
          }
          localObject3 = localFilterCategoryItem.c();
          if ((localObject3 != null) && (((FilterDesc)localObject3).type == 1) && (!QmcfManager.getInstance().hasQmcfEntrance(1))) {
            break label599;
          }
        }
        ((List)localObject2).add(localFilterCategoryItem);
        label599:
        i += 1;
      }
      this.c = ((List)localObject2);
      if ((paramCaptureRedDotConfig != null) && (localObject1 != null)) {
        paramCaptureRedDotConfig.categories.put(Integer.valueOf(((CaptureRedDotConfig.CategoryRedConfig)localObject1).categoryId), localObject1);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeTypedList(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.capture.data.FilterCategory
 * JD-Core Version:    0.7.0.1
 */