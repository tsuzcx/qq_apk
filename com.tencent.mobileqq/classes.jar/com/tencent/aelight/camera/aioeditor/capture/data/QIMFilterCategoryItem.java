package com.tencent.aelight.camera.aioeditor.capture.data;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class QIMFilterCategoryItem
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<QIMFilterCategoryItem> CREATOR = new QIMFilterCategoryItem.1();
  public String a;
  public String b;
  public String c = "";
  public String d;
  public int e;
  public String f;
  public int g;
  public String h;
  public String i;
  public ArrayList<String> j;
  public JSONArray k;
  public JSONArray l;
  public JSONArray m;
  public JSONArray n;
  public int o;
  public boolean p;
  public String q;
  public String r;
  
  public QIMFilterCategoryItem()
  {
    this.g = 0;
    this.i = null;
    this.j = new ArrayList();
    this.o = 0;
    this.r = "";
  }
  
  protected QIMFilterCategoryItem(Parcel paramParcel)
  {
    boolean bool = false;
    this.g = 0;
    this.i = null;
    this.j = new ArrayList();
    this.o = 0;
    this.r = "";
    this.a = paramParcel.readString();
    this.b = paramParcel.readString();
    this.i = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readString();
    this.j = paramParcel.createStringArrayList();
    paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.p = bool;
    this.q = paramParcel.readString();
    this.r = paramParcel.readString();
  }
  
  public static boolean a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.j.iterator();
    while (paramQIMFilterCategoryItem.hasNext())
    {
      Object localObject = (String)paramQIMFilterCategoryItem.next();
      localObject = VideoFilterTools.a().a((String)localObject);
      if ((localObject != null) && (((FilterDesc)localObject).id == 9)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean b(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (Build.VERSION.SDK_INT == 18)
    {
      paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.j.iterator();
      while (paramQIMFilterCategoryItem.hasNext())
      {
        Object localObject = (String)paramQIMFilterCategoryItem.next();
        localObject = VideoFilterTools.a().a((String)localObject);
        if ((localObject != null) && (((FilterDesc)localObject).id == 1011)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public QIMFilterCategoryItem a()
  {
    try
    {
      QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)super.clone();
      return localQIMFilterCategoryItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public boolean b()
  {
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      String[] arrayOfString = CaptureConst.a;
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (arrayOfString[i1].equals(str)) {
          return false;
        }
        i1 += 1;
      }
    }
    return true;
  }
  
  public boolean c()
  {
    ArrayList localArrayList = this.j;
    return (localArrayList != null) && (localArrayList.contains("EMPTY"));
  }
  
  public boolean d()
  {
    ArrayList localArrayList = this.j;
    return (localArrayList != null) && ((localArrayList.contains("EMPTY")) || (this.j.contains("EMPTY2")));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    ArrayList localArrayList = this.j;
    return (localArrayList != null) && (localArrayList.contains("AIFilter"));
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null) {
      return false;
    }
    if (paramObject.hashCode() == hashCode()) {
      bool = true;
    }
    return bool;
  }
  
  public boolean f()
  {
    boolean bool1 = this.p;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    ArrayList localArrayList = this.j;
    bool1 = bool2;
    if (localArrayList != null)
    {
      bool1 = bool2;
      if (localArrayList.size() == 1)
      {
        bool1 = bool2;
        if (QQAVImageFilterConstants.getFilterType(VideoFilterTools.a().a((String)this.j.get(0)).id) == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean g()
  {
    return ("2".equals(this.h)) || ("3".equals(this.h));
  }
  
  public JSONObject h()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", this.a);
      localJSONObject.put("name", this.b);
      localJSONObject.put("camera", this.i);
      localJSONObject.put("iconUrl", this.d);
      localJSONObject.put("categoryId", this.e);
      localJSONObject.put("categoryName", this.f);
      if ((this.j != null) && (!this.j.isEmpty()))
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.j.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put((String)localIterator.next());
        }
        localJSONObject.put("filterIds", localJSONArray);
      }
      localJSONObject.put("isCombo", this.p);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      label154:
      break label154;
    }
    return null;
  }
  
  public int hashCode()
  {
    return this.a.intern().hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilterCategoryItem{id='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isCombo=");
    localStringBuilder.append(this.p);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.i);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeStringList(this.j);
    paramParcel.writeInt(0);
    paramParcel.writeByte((byte)this.p);
    paramParcel.writeString(this.q);
    paramParcel.writeString(this.r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem
 * JD-Core Version:    0.7.0.1
 */