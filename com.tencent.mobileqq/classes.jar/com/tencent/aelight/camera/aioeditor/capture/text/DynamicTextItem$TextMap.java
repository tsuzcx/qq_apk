package com.tencent.aelight.camera.aioeditor.capture.text;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DynamicTextItem$TextMap
  implements Parcelable
{
  public static final Parcelable.Creator<TextMap> CREATOR = new DynamicTextItem.TextMap.1();
  private Map<Integer, String> a = new HashMap();
  
  public DynamicTextItem$TextMap() {}
  
  protected DynamicTextItem$TextMap(Parcel paramParcel)
  {
    this();
    int j = paramParcel.readInt();
    int i = 0;
    while (i < j)
    {
      this.a.put(Integer.valueOf(paramParcel.readInt()), paramParcel.readString());
      i += 1;
    }
  }
  
  public DynamicTextItem$TextMap(@NonNull List<String> paramList)
  {
    this();
    if (paramList != null)
    {
      int i = 0;
      while (i < paramList.size())
      {
        this.a.put(Integer.valueOf(i), paramList.get(i));
        i += 1;
      }
    }
  }
  
  public int a()
  {
    Iterator localIterator = this.a.entrySet().iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((Integer)localEntry.getKey()).intValue() > i) {
        i = ((Integer)localEntry.getKey()).intValue();
      }
    }
    return i + 1;
  }
  
  @NonNull
  public String a(int paramInt)
  {
    int i = a();
    if (i == 0) {
      return "";
    }
    if ((paramInt >= 0) && (paramInt < i))
    {
      String str = (String)this.a.get(Integer.valueOf(paramInt));
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      return localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("location ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" is out of bounds, TextMap size is ");
    ((StringBuilder)localObject).append(i);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  @NonNull
  public List<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    int j = a();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.a.get(Integer.valueOf(i)));
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(int paramInt, @NonNull String paramString)
  {
    if (paramInt != -1) {
      this.a.put(Integer.valueOf(paramInt), paramString);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() >= paramInt1) && (((Integer)localEntry.getKey()).intValue() < paramInt2) && (!TextUtils.isEmpty((CharSequence)localEntry.getValue()))) {
        return false;
      }
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (TextMap)paramObject;
      if (this.a.equals(paramObject.a)) {
        return true;
      }
      int j = this.a.size();
      if (j != paramObject.a.size()) {
        return false;
      }
      int i = 0;
      while (i < j)
      {
        if (!a(i).equals(paramObject.a(i))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    int j = a();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((String)this.a.get(Integer.valueOf(i)));
      localStringBuilder.append("#");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a.size());
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramParcel.writeInt(((Integer)localEntry.getKey()).intValue());
      paramParcel.writeString((String)localEntry.getValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.TextMap
 * JD-Core Version:    0.7.0.1
 */