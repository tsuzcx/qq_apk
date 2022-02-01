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
  public int a;
  public String a;
  public ArrayList<String> a;
  public JSONArray a;
  public boolean a;
  public int b;
  public String b;
  public JSONArray b;
  public int c;
  public String c;
  public JSONArray c;
  public String d;
  public JSONArray d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public QIMFilterCategoryItem()
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 0;
    this.g = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
    this.i = "";
  }
  
  protected QIMFilterCategoryItem(Parcel paramParcel)
  {
    this.jdField_c_of_type_JavaLangString = "";
    boolean bool = false;
    this.jdField_b_of_type_Int = 0;
    this.g = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
    this.i = "";
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.g = paramParcel.readString();
    this.d = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.jdField_a_of_type_JavaUtilArrayList = paramParcel.createStringArrayList();
    paramParcel.readInt();
    if (paramParcel.readByte() != 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.h = paramParcel.readString();
    this.i = paramParcel.readString();
  }
  
  public static boolean a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
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
      paramQIMFilterCategoryItem = paramQIMFilterCategoryItem.jdField_a_of_type_JavaUtilArrayList.iterator();
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
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("name", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("camera", this.g);
      localJSONObject.put("iconUrl", this.d);
      localJSONObject.put("categoryId", this.jdField_a_of_type_Int);
      localJSONObject.put("categoryName", this.e);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        JSONArray localJSONArray = new JSONArray();
        Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          localJSONArray.put((String)localIterator.next());
        }
        localJSONObject.put("filterIds", localJSONArray);
      }
      localJSONObject.put("isCombo", this.jdField_a_of_type_Boolean);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      label154:
      break label154;
    }
    return null;
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      String[] arrayOfString = CaptureConst.a;
      int k = arrayOfString.length;
      int j = 0;
      while (j < k)
      {
        if (arrayOfString[j].equals(str)) {
          return false;
        }
        j += 1;
      }
    }
    return true;
  }
  
  public boolean b()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    return (localArrayList != null) && (localArrayList.contains("EMPTY"));
  }
  
  public boolean c()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    return (localArrayList != null) && ((localArrayList.contains("EMPTY")) || (this.jdField_a_of_type_JavaUtilArrayList.contains("EMPTY2")));
  }
  
  public boolean d()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    return (localArrayList != null) && (localArrayList.contains("AIFilter"));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    boolean bool1 = this.jdField_a_of_type_Boolean;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    bool1 = bool2;
    if (localArrayList != null)
    {
      bool1 = bool2;
      if (localArrayList.size() == 1)
      {
        bool1 = bool2;
        if (QQAVImageFilterConstants.getFilterType(VideoFilterTools.a().a((String)this.jdField_a_of_type_JavaUtilArrayList.get(0)).id) == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
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
    return ("2".equals(this.f)) || ("3".equals(this.f));
  }
  
  public int hashCode()
  {
    return this.jdField_a_of_type_JavaLangString.intern().hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FilterCategoryItem{id='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isCombo=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.e);
    paramParcel.writeStringList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeInt(0);
    paramParcel.writeByte((byte)this.jdField_a_of_type_Boolean);
    paramParcel.writeString(this.h);
    paramParcel.writeString(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem
 * JD-Core Version:    0.7.0.1
 */