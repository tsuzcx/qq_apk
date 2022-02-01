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
  private String[] builderColumns;
  private final ArrayList<HashMap<String, Object>> dataCollectionList;
  private final String type;
  private final HashMap<Object, Integer> typeAndDataCollectionCountMapping;
  
  private DataHolder$Builder(String[] paramArrayOfString, String paramString)
  {
    Preconditions.checkNotNull(paramArrayOfString, "builderColumnsP cannot be null");
    this.builderColumns = paramArrayOfString;
    this.dataCollectionList = new ArrayList();
    this.type = paramString;
    this.typeAndDataCollectionCountMapping = new HashMap();
  }
  
  DataHolder$Builder(String[] paramArrayOfString, String paramString, DataHolderBuilderCreator paramDataHolderBuilderCreator)
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
    Preconditions.checkNotNull(paramHashMap, "contentValuesHashMap cannot be null");
    Object localObject = this.type;
    int j = 0;
    if (localObject != null)
    {
      localObject = paramHashMap.get(localObject);
      if (localObject != null)
      {
        Integer localInteger = (Integer)this.typeAndDataCollectionCountMapping.get(localObject);
        if (localInteger != null)
        {
          j = localInteger.intValue();
          i = 1;
          break label85;
        }
        this.typeAndDataCollectionCountMapping.put(localObject, Integer.valueOf(this.dataCollectionList.size()));
      }
    }
    int i = 0;
    label85:
    if (i != 0)
    {
      this.dataCollectionList.remove(j);
      this.dataCollectionList.add(j, paramHashMap);
      return this;
    }
    this.dataCollectionList.add(paramHashMap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.data.DataHolder.Builder
 * JD-Core Version:    0.7.0.1
 */