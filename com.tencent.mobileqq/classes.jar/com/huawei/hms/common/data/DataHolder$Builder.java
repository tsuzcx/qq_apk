package com.huawei.hms.common.data;

import android.content.ContentValues;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class DataHolder$Builder
{
  private String[] a;
  private final ArrayList<HashMap<String, Object>> b;
  private final String c;
  private final HashMap<Object, Integer> d;
  
  private DataHolder$Builder(String[] paramArrayOfString, String paramString)
  {
    Preconditions.checkNotNull(paramArrayOfString, "builderColumnsP cannot be null");
    this.a = paramArrayOfString;
    this.b = new ArrayList();
    this.c = paramString;
    this.d = new HashMap();
  }
  
  DataHolder$Builder(String[] paramArrayOfString, String paramString, a parama)
  {
    this(paramArrayOfString, null);
  }
  
  public DataHolder build(int paramInt)
  {
    return new DataHolder(this, paramInt, null, null);
  }
  
  public DataHolder build(int paramInt, Bundle paramBundle)
  {
    return new DataHolder(this, paramInt, paramBundle, -1, null);
  }
  
  public Builder setDataForContentValuesHashMap(HashMap<String, Object> paramHashMap)
  {
    int j = 0;
    Preconditions.checkNotNull(paramHashMap, "contentValuesHashMap cannot be null");
    Object localObject;
    if (this.c != null)
    {
      localObject = paramHashMap.get(this.c);
      if (localObject != null)
      {
        Integer localInteger = (Integer)this.d.get(localObject);
        if (localInteger != null) {
          j = localInteger.intValue();
        }
      }
    }
    for (int i = 1; i != 0; i = 0)
    {
      this.b.remove(j);
      this.b.add(j, paramHashMap);
      return this;
      this.d.put(localObject, Integer.valueOf(this.b.size()));
    }
    this.b.add(paramHashMap);
    return this;
  }
  
  public Builder withRow(ContentValues paramContentValues)
  {
    Preconditions.checkNotNull(paramContentValues, "contentValues cannot be null");
    HashMap localHashMap = new HashMap(paramContentValues.size());
    paramContentValues = paramContentValues.valueSet().iterator();
    while (paramContentValues.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramContentValues.next();
      localHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    return setDataForContentValuesHashMap(localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.data.DataHolder.Builder
 * JD-Core Version:    0.7.0.1
 */