package com.huawei.hms.common.data;

import android.content.ContentValues;
import java.util.HashMap;

final class DataHolderBuilderCreator
  extends DataHolder.Builder
{
  DataHolderBuilderCreator(String[] paramArrayOfString, String paramString)
  {
    super(paramArrayOfString, null, null);
  }
  
  public final DataHolder.Builder setDataForContentValuesHashMap(HashMap<String, Object> paramHashMap)
  {
    throw new UnsupportedOperationException("DataHolderBuilderCreator unsupported setDataForContentValuesHashMap");
  }
  
  public final DataHolder.Builder withRow(ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("DataHolderBuilderCreator unsupported withRow");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.data.DataHolderBuilderCreator
 * JD-Core Version:    0.7.0.1
 */