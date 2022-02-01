package com.huawei.hms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;

public class DataBufferRef
{
  protected final DataHolder mDataHolder;
  protected int mDataRow;
  private int windowIndex;
  
  public DataBufferRef(DataHolder paramDataHolder, int paramInt)
  {
    Preconditions.checkNotNull(paramDataHolder, "dataHolder cannot be null");
    this.mDataHolder = paramDataHolder;
    getWindowIndex(paramInt);
  }
  
  protected void copyToBuffer(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.mDataHolder.copyToBuffer(paramString, this.mDataRow, this.windowIndex, paramCharArrayBuffer);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof DataBufferRef;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (DataBufferRef)paramObject;
      bool1 = bool2;
      if (paramObject.mDataRow == this.mDataRow)
      {
        bool1 = bool2;
        if (paramObject.windowIndex == this.windowIndex)
        {
          bool1 = bool2;
          if (paramObject.mDataHolder == this.mDataHolder) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean getBoolean(String paramString)
  {
    paramString = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_boolean");
    if (paramString != null) {
      return ((Boolean)paramString).booleanValue();
    }
    return false;
  }
  
  protected byte[] getByteArray(String paramString)
  {
    paramString = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_byte_array");
    if (paramString != null) {
      return (byte[])paramString;
    }
    return null;
  }
  
  protected int getDataRow()
  {
    return this.mDataRow;
  }
  
  protected double getDouble(String paramString)
  {
    paramString = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_double");
    if (paramString != null) {
      return ((Double)paramString).doubleValue();
    }
    return -1.0D;
  }
  
  protected float getFloat(String paramString)
  {
    paramString = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_float");
    if (paramString != null) {
      return ((Float)paramString).floatValue();
    }
    return -1.0F;
  }
  
  protected int getInteger(String paramString)
  {
    paramString = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_int");
    if (paramString != null) {
      return ((Integer)paramString).intValue();
    }
    return -1;
  }
  
  protected long getLong(String paramString)
  {
    paramString = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_long");
    if (paramString != null) {
      return ((Long)paramString).longValue();
    }
    return -1L;
  }
  
  protected String getString(String paramString)
  {
    paramString = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_string");
    if (paramString != null) {
      return (String)paramString;
    }
    return "";
  }
  
  protected final void getWindowIndex(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.mDataHolder.getCount())) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "rowNum is out of index");
    this.mDataRow = paramInt;
    this.windowIndex = this.mDataHolder.getWindowIndex(this.mDataRow);
  }
  
  public boolean hasColumn(String paramString)
  {
    return this.mDataHolder.hasColumn(paramString);
  }
  
  protected boolean hasNull(String paramString)
  {
    return this.mDataHolder.hasNull(paramString, this.mDataRow, this.windowIndex);
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.mDataRow), Integer.valueOf(this.windowIndex), this.mDataHolder });
  }
  
  public boolean isDataValid()
  {
    return this.mDataHolder.isClosed() ^ true;
  }
  
  protected Uri parseUri(String paramString)
  {
    paramString = (String)this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_string");
    if (paramString == null) {
      return null;
    }
    return Uri.parse(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.data.DataBufferRef
 * JD-Core Version:    0.7.0.1
 */