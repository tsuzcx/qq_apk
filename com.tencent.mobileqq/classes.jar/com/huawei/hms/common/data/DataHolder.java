package com.huawei.hms.common.data;

import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DataHolder
  extends AbstractSafeParcelable
  implements Closeable
{
  public static final Parcelable.Creator<DataHolder> CREATOR = new DataHolderCreator();
  private static final String TAG = "DataHolder";
  public static final String TYPE_BOOLEAN = "type_boolean";
  public static final String TYPE_BYTE_ARRAY = "type_byte_array";
  public static final String TYPE_DOUBLE = "type_double";
  public static final String TYPE_FLOAT = "type_float";
  public static final String TYPE_INT = "type_int";
  public static final String TYPE_LONG = "type_long";
  public static final String TYPE_STRING = "type_string";
  private static final DataHolder.Builder builder = new a(new String[0], null);
  private String[] columns;
  private Bundle columnsBundle;
  private CursorWindow[] cursorWindows;
  private int dataCount;
  private boolean isInstance;
  private boolean mClosed;
  private Bundle metadata;
  private int[] perCursorCounts;
  private int statusCode;
  private int version;
  
  DataHolder(int paramInt1, String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt2, Bundle paramBundle)
  {
    this.mClosed = false;
    this.isInstance = true;
    this.version = paramInt1;
    this.columns = paramArrayOfString;
    this.cursorWindows = paramArrayOfCursorWindow;
    this.statusCode = paramInt2;
    this.metadata = paramBundle;
    collectColumsAndCount();
  }
  
  public DataHolder(Cursor paramCursor, int paramInt, Bundle paramBundle)
  {
    this(new com.huawei.hms.common.a.a(paramCursor), paramInt, paramBundle);
  }
  
  private DataHolder(com.huawei.hms.common.a.a parama, int paramInt, Bundle paramBundle)
  {
    this(parama.getColumnNames(), getCursorWindows(parama), paramInt, paramBundle);
  }
  
  private DataHolder(DataHolder.Builder paramBuilder, int paramInt, Bundle paramBundle)
  {
    this(DataHolder.Builder.a(paramBuilder), getCursorWindows(paramBuilder, -1), paramInt, null);
  }
  
  private DataHolder(DataHolder.Builder paramBuilder, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this(DataHolder.Builder.a(paramBuilder), getCursorWindows(paramBuilder, -1), paramInt1, paramBundle);
  }
  
  public DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle)
  {
    Preconditions.checkNotNull(paramArrayOfString, "columnsP cannot be null");
    Preconditions.checkNotNull(paramArrayOfString, "cursorWindowP cannot be null");
    this.mClosed = false;
    this.isInstance = true;
    this.version = 1;
    this.columns = paramArrayOfString;
    this.cursorWindows = paramArrayOfCursorWindow;
    this.statusCode = paramInt;
    this.metadata = paramBundle;
    collectColumsAndCount();
  }
  
  public static DataHolder.Builder builder(String[] paramArrayOfString)
  {
    return new DataHolder.Builder(paramArrayOfString, null, null);
  }
  
  private void checkAvailable(String paramString, int paramInt)
  {
    String str = "";
    if ((this.columnsBundle == null) || (!this.columnsBundle.containsKey(paramString))) {
      paramString = "cannot find column: " + paramString;
    }
    for (;;)
    {
      Preconditions.checkArgument(paramString.isEmpty(), paramString);
      return;
      if (isClosed())
      {
        paramString = "buffer has been closed";
      }
      else if (paramInt >= 0)
      {
        paramString = str;
        if (paramInt < this.dataCount) {}
      }
      else
      {
        paramString = "row is out of index:" + paramInt;
      }
    }
  }
  
  public static DataHolder empty(int paramInt)
  {
    return new DataHolder(builder, paramInt, null);
  }
  
  private static CursorWindow[] getCursorWindows(com.huawei.hms.common.a.a parama)
  {
    int j = 0;
    Object localObject1 = new ArrayList();
    try
    {
      int k = parama.getCount();
      CursorWindow localCursorWindow = parama.getWindow();
      int i = j;
      if (localCursorWindow != null)
      {
        i = j;
        if (localCursorWindow.getStartPosition() == 0)
        {
          localCursorWindow.acquireReference();
          parama.a(null);
          ((ArrayList)localObject1).add(localCursorWindow);
          i = localCursorWindow.getNumRows();
        }
      }
      ((ArrayList)localObject1).addAll(iterCursorWrapper(parama, i, k));
      localObject1 = (CursorWindow[])((ArrayList)localObject1).toArray(new CursorWindow[((ArrayList)localObject1).size()]);
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      HMSLog.e("DataHolder", "fail to getCursorWindows: " + localThrowable.getMessage());
      return new CursorWindow[0];
    }
    finally
    {
      parama.close();
    }
  }
  
  private static CursorWindow[] getCursorWindows(DataHolder.Builder paramBuilder, int paramInt)
  {
    if (DataHolder.Builder.a(paramBuilder).length == 0) {
      return new CursorWindow[0];
    }
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < DataHolder.Builder.b(paramBuilder).size()) {}
    }
    else
    {
      i = DataHolder.Builder.b(paramBuilder).size();
    }
    paramBuilder = iterCursorWindow(paramBuilder, i, DataHolder.Builder.b(paramBuilder).subList(0, i));
    return (CursorWindow[])paramBuilder.toArray(new CursorWindow[paramBuilder.size()]);
  }
  
  private static ArrayList<CursorWindow> iterCursorWindow(DataHolder.Builder paramBuilder, int paramInt, List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    CursorWindow localCursorWindow = new CursorWindow(null);
    localCursorWindow.setNumColumns(DataHolder.Builder.a(paramBuilder).length);
    localArrayList.add(localCursorWindow);
    int i = 0;
    if (i < paramInt) {}
    label290:
    label293:
    for (;;)
    {
      try
      {
        if (localCursorWindow.allocRow()) {
          break label293;
        }
        HMSLog.d("DataHolder", "Failed to allocate a row");
        localCursorWindow = new CursorWindow(null);
        localCursorWindow.setStartPosition(i);
        localCursorWindow.setNumColumns(DataHolder.Builder.a(paramBuilder).length);
        if (!localCursorWindow.allocRow())
        {
          HMSLog.e("DataHolder", "Failed to retry to allocate a row");
          return localArrayList;
        }
        localArrayList.add(localCursorWindow);
        HashMap localHashMap = (HashMap)paramList.get(i);
        boolean bool = true;
        int j = 0;
        if (j >= DataHolder.Builder.a(paramBuilder).length) {
          break label290;
        }
        bool = putValue(localCursorWindow, localHashMap.get(DataHolder.Builder.a(paramBuilder)[j]), i, j);
        if (!bool)
        {
          if (!bool)
          {
            HMSLog.d("DataHolder", "fail to put data for row " + i);
            localCursorWindow.freeLastRow();
            paramList = new CursorWindow(null);
            paramList.setStartPosition(i);
            paramList.setNumColumns(DataHolder.Builder.a(paramBuilder).length);
            localArrayList.add(paramList);
            return localArrayList;
          }
        }
        else
        {
          j += 1;
          continue;
        }
        i += 1;
      }
      catch (RuntimeException paramBuilder)
      {
        paramList = localArrayList.iterator();
        if (paramList.hasNext())
        {
          ((CursorWindow)paramList.next()).close();
          continue;
        }
        throw paramBuilder;
      }
      break;
    }
  }
  
  private static ArrayList<CursorWindow> iterCursorWrapper(com.huawei.hms.common.a.a parama, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      CursorWindow localCursorWindow;
      if ((paramInt1 < paramInt2) && (parama.moveToPosition(paramInt1)))
      {
        localCursorWindow = parama.getWindow();
        if (localCursorWindow != null) {
          break label61;
        }
        localCursorWindow = new CursorWindow(null);
        localCursorWindow.setStartPosition(paramInt1);
        parama.fillWindow(paramInt1, localCursorWindow);
      }
      while (localCursorWindow.getNumRows() == 0)
      {
        return localArrayList;
        label61:
        localCursorWindow.acquireReference();
        parama.a(null);
      }
      localArrayList.add(localCursorWindow);
      paramInt1 = localCursorWindow.getNumRows() + localCursorWindow.getStartPosition();
    }
  }
  
  private static boolean putValue(CursorWindow paramCursorWindow, Object paramObject, int paramInt1, int paramInt2)
  {
    if (paramObject == null) {
      return paramCursorWindow.putNull(paramInt1, paramInt2);
    }
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue()) {}
      for (long l = 1L;; l = 0L) {
        return paramCursorWindow.putLong(l, paramInt1, paramInt2);
      }
    }
    if ((paramObject instanceof Integer)) {
      return paramCursorWindow.putLong(((Integer)paramObject).intValue(), paramInt1, paramInt2);
    }
    if ((paramObject instanceof Long)) {
      return paramCursorWindow.putLong(((Long)paramObject).longValue(), paramInt1, paramInt2);
    }
    if ((paramObject instanceof Float)) {
      return paramCursorWindow.putDouble(((Float)paramObject).floatValue(), paramInt1, paramInt2);
    }
    if ((paramObject instanceof Double)) {
      return paramCursorWindow.putDouble(((Double)paramObject).doubleValue(), paramInt1, paramInt2);
    }
    if ((paramObject instanceof String)) {
      return paramCursorWindow.putString((String)paramObject, paramInt1, paramInt2);
    }
    if ((paramObject instanceof byte[])) {
      return paramCursorWindow.putBlob((byte[])paramObject, paramInt1, paramInt2);
    }
    throw new IllegalArgumentException("unsupported type for column: " + paramObject);
  }
  
  public final void close()
  {
    try
    {
      if (!this.mClosed)
      {
        CursorWindow[] arrayOfCursorWindow = this.cursorWindows;
        int j = arrayOfCursorWindow.length;
        int i = 0;
        while (i < j)
        {
          arrayOfCursorWindow[i].close();
          i += 1;
        }
        this.mClosed = true;
      }
      return;
    }
    finally {}
  }
  
  public final void collectColumsAndCount()
  {
    int j = 0;
    this.columnsBundle = new Bundle();
    int i = 0;
    while (i < this.columns.length)
    {
      this.columnsBundle.putInt(this.columns[i], i);
      i += 1;
    }
    this.perCursorCounts = new int[this.cursorWindows.length];
    int k = 0;
    i = j;
    j = k;
    while (i < this.cursorWindows.length)
    {
      this.perCursorCounts[i] = j;
      j = this.cursorWindows[i].getStartPosition() + this.cursorWindows[i].getNumRows();
      i += 1;
    }
    this.dataCount = j;
  }
  
  public final void copyToBuffer(String paramString, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer)
  {
    checkAvailable(paramString, paramInt1);
    this.cursorWindows[paramInt2].copyStringToBuffer(paramInt1, this.columnsBundle.getInt(paramString), paramCharArrayBuffer);
  }
  
  protected final void finalize()
  {
    if ((this.isInstance) && (this.cursorWindows.length > 0) && (!isClosed())) {
      close();
    }
    super.finalize();
  }
  
  public final int getCount()
  {
    return this.dataCount;
  }
  
  public final Bundle getMetadata()
  {
    return this.metadata;
  }
  
  public final int getStatusCode()
  {
    return this.statusCode;
  }
  
  public final Object getValue(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    boolean bool = true;
    int i = -1;
    switch (paramString2.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return null;
        if (paramString2.equals("type_int"))
        {
          i = 0;
          continue;
          if (paramString2.equals("type_long"))
          {
            i = 1;
            continue;
            if (paramString2.equals("type_string"))
            {
              i = 2;
              continue;
              if (paramString2.equals("type_boolean"))
              {
                i = 3;
                continue;
                if (paramString2.equals("type_float"))
                {
                  i = 4;
                  continue;
                  if (paramString2.equals("type_double"))
                  {
                    i = 5;
                    continue;
                    if (paramString2.equals("type_byte_array")) {
                      i = 6;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    checkAvailable(paramString1, paramInt1);
    return Integer.valueOf(this.cursorWindows[paramInt2].getInt(paramInt1, this.columnsBundle.getInt(paramString1)));
    checkAvailable(paramString1, paramInt1);
    return Long.valueOf(this.cursorWindows[paramInt2].getLong(paramInt1, this.columnsBundle.getInt(paramString1)));
    checkAvailable(paramString1, paramInt1);
    return this.cursorWindows[paramInt2].getString(paramInt1, this.columnsBundle.getInt(paramString1));
    checkAvailable(paramString1, paramInt1);
    if (this.cursorWindows[paramInt2].getLong(paramInt1, this.columnsBundle.getInt(paramString1)) == 1L) {}
    for (;;)
    {
      return Boolean.valueOf(bool);
      bool = false;
    }
    checkAvailable(paramString1, paramInt1);
    return Float.valueOf(this.cursorWindows[paramInt2].getFloat(paramInt1, this.columnsBundle.getInt(paramString1)));
    checkAvailable(paramString1, paramInt1);
    return Double.valueOf(this.cursorWindows[paramInt2].getDouble(paramInt1, this.columnsBundle.getInt(paramString1)));
    checkAvailable(paramString1, paramInt1);
    return this.cursorWindows[paramInt2].getBlob(paramInt1, this.columnsBundle.getInt(paramString1));
  }
  
  public final int getWindowIndex(int paramInt)
  {
    int j = 0;
    boolean bool;
    if ((paramInt >= 0) || (paramInt < this.dataCount))
    {
      bool = true;
      Preconditions.checkArgument(bool, "rowIndex is out of index:" + paramInt);
    }
    for (;;)
    {
      int i = j;
      if (j < this.perCursorCounts.length)
      {
        if (paramInt < this.perCursorCounts[j]) {
          i = j - 1;
        }
      }
      else
      {
        paramInt = i;
        if (i == this.perCursorCounts.length) {
          paramInt = i - 1;
        }
        return paramInt;
        bool = false;
        break;
      }
      j += 1;
    }
  }
  
  public final boolean hasColumn(String paramString)
  {
    return this.columnsBundle.containsKey(paramString);
  }
  
  public final boolean hasNull(String paramString, int paramInt1, int paramInt2)
  {
    checkAvailable(paramString, paramInt1);
    return this.cursorWindows[paramInt2].getType(paramInt1, this.columnsBundle.getInt(paramString)) == 0;
  }
  
  public final boolean isClosed()
  {
    try
    {
      boolean bool = this.mClosed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringArray(paramParcel, 1, this.columns, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, this.cursorWindows, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getStatusCode());
    SafeParcelWriter.writeBundle(paramParcel, 4, getMetadata(), false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.version);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    if ((paramInt & 0x1) != 0) {
      close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.data.DataHolder
 * JD-Core Version:    0.7.0.1
 */