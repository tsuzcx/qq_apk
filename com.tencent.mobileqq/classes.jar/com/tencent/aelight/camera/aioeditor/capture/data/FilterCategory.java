package com.tencent.aelight.camera.aioeditor.capture.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
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
  public List<QIMFilterCategoryItem> c;
  public boolean d;
  public boolean e;
  public int f;
  public int g;
  
  public FilterCategory(int paramInt1, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    this.f = 0;
    this.g = 0;
    this.a = paramInt1;
    this.b = paramString;
    this.c = new ArrayList();
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramInt2;
    this.g = paramInt3;
  }
  
  protected FilterCategory(Parcel paramParcel)
  {
    boolean bool = false;
    this.f = 0;
    this.g = 0;
    this.a = paramParcel.readInt();
    this.b = paramParcel.readString();
    this.c = paramParcel.createTypedArrayList(QIMFilterCategoryItem.CREATOR);
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.d = bool;
  }
  
  public FilterCategory(JSONObject paramJSONObject, QIMRedDotConfig paramQIMRedDotConfig)
  {
    this.f = 0;
    this.g = 0;
    this.b = paramJSONObject.optString("name");
    this.a = paramJSONObject.optInt("categoryId");
    this.e = "1".equals(paramJSONObject.optString("random_position", "0"));
    this.f = paramJSONObject.optInt("hide_mask", 0);
    this.g = paramJSONObject.optInt("source_type", 0);
    int i;
    boolean bool;
    Object localObject2;
    Object localObject1;
    if (paramQIMRedDotConfig != null)
    {
      i = paramJSONObject.optInt("redDotVersion");
      bool = paramJSONObject.optBoolean("needRedDot");
      localObject2 = (QIMRedDotConfig.CategoryRedConfig)paramQIMRedDotConfig.categories.get(Integer.valueOf(this.a));
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((QIMRedDotConfig.CategoryRedConfig)localObject2).version != i)
        {
          ((QIMRedDotConfig.CategoryRedConfig)localObject2).version = i;
          ((QIMRedDotConfig.CategoryRedConfig)localObject2).showRedDot = bool;
          ((QIMRedDotConfig.CategoryRedConfig)localObject2).hasShow = false;
          ((QIMRedDotConfig.CategoryRedConfig)localObject2).firstShowTime = 0L;
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = new QIMRedDotConfig.CategoryRedConfig();
        ((QIMRedDotConfig.CategoryRedConfig)localObject1).categoryId = this.a;
        ((QIMRedDotConfig.CategoryRedConfig)localObject1).version = i;
        ((QIMRedDotConfig.CategoryRedConfig)localObject1).showRedDot = bool;
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
      bool = false;
      while (i < k)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
        QIMFilterCategoryItem localQIMFilterCategoryItem = new QIMFilterCategoryItem();
        localQIMFilterCategoryItem.d = localJSONObject.optString("iconUrl");
        localQIMFilterCategoryItem.b = localJSONObject.optString("name");
        localQIMFilterCategoryItem.i = localJSONObject.optString("camera");
        localQIMFilterCategoryItem.a = localJSONObject.optString("id");
        localQIMFilterCategoryItem.h = localJSONObject.optString("type_combo");
        localQIMFilterCategoryItem.e = this.a;
        localQIMFilterCategoryItem.f = this.b;
        localQIMFilterCategoryItem.g = this.g;
        localQIMFilterCategoryItem.q = localJSONObject.optString("jump_app");
        JSONArray localJSONArray = localJSONObject.optJSONArray("filters");
        if (localJSONArray != null)
        {
          int m = localJSONArray.length();
          int j = 0;
          while (j < m)
          {
            Object localObject3 = localJSONArray.getJSONObject(j);
            String str = ((JSONObject)localObject3).optString("name");
            if (!TextUtils.isEmpty(str))
            {
              localQIMFilterCategoryItem.j.add(str);
            }
            else
            {
              localObject3 = ((JSONObject)localObject3).optString("name_android");
              if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                localQIMFilterCategoryItem.j.add(localObject3);
              }
            }
            j += 1;
          }
        }
        localQIMFilterCategoryItem.k = localJSONObject.optJSONArray("pasters");
        localQIMFilterCategoryItem.l = localJSONObject.optJSONArray("musics");
        localQIMFilterCategoryItem.m = localJSONObject.optJSONArray("ufaces");
        localQIMFilterCategoryItem.n = localJSONObject.optJSONArray("texts");
        localQIMFilterCategoryItem.r = localJSONObject.optString("desc", "");
        if (((localQIMFilterCategoryItem.k != null) && (localQIMFilterCategoryItem.k.length() != 0)) || ((localQIMFilterCategoryItem.l != null) && (localQIMFilterCategoryItem.l.length() != 0)) || ((localQIMFilterCategoryItem.m != null) && (localQIMFilterCategoryItem.m.length() != 0)))
        {
          localQIMFilterCategoryItem.p = true;
          bool = true;
        }
        else
        {
          localQIMFilterCategoryItem.p = false;
        }
        ((List)localObject2).add(localQIMFilterCategoryItem);
        i += 1;
      }
      this.c = ((List)localObject2);
      if ((paramQIMRedDotConfig != null) && (localObject1 != null)) {
        paramQIMRedDotConfig.categories.put(Integer.valueOf(((QIMRedDotConfig.CategoryRedConfig)localObject1).categoryId), localObject1);
      }
      this.d = bool;
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
    paramParcel.writeByte((byte)this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.FilterCategory
 * JD-Core Version:    0.7.0.1
 */