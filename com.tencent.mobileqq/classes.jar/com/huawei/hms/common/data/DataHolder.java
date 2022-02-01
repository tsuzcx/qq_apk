package com.huawei.hms.common.data;

import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.sqlite.HMSCursorWrapper;
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
  private static final DataHolder.Builder builder = new DataHolderBuilderCreator(new String[0], null);
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
    this(new HMSCursorWrapper(paramCursor), paramInt, paramBundle);
  }
  
  private DataHolder(DataHolder.Builder paramBuilder, int paramInt, Bundle paramBundle)
  {
    this(DataHolder.Builder.access$200(paramBuilder), getCursorWindows(paramBuilder, -1), paramInt, null);
  }
  
  private DataHolder(DataHolder.Builder paramBuilder, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    this(DataHolder.Builder.access$200(paramBuilder), getCursorWindows(paramBuilder, -1), paramInt1, paramBundle);
  }
  
  private DataHolder(HMSCursorWrapper paramHMSCursorWrapper, int paramInt, Bundle paramBundle)
  {
    this(paramHMSCursorWrapper.getColumnNames(), getCursorWindows(paramHMSCursorWrapper), paramInt, paramBundle);
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
    Object localObject = this.columnsBundle;
    if ((localObject != null) && (((Bundle)localObject).containsKey(paramString)))
    {
      if (isClosed())
      {
        paramString = "buffer has been closed";
      }
      else if ((paramInt >= 0) && (paramInt < this.dataCount))
      {
        paramString = "";
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("row is out of index:");
        paramString.append(paramInt);
        paramString = paramString.toString();
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cannot find column: ");
      ((StringBuilder)localObject).append(paramString);
      paramString = ((StringBuilder)localObject).toString();
    }
    Preconditions.checkArgument(paramString.isEmpty(), paramString);
  }
  
  public static DataHolder empty(int paramInt)
  {
    return new DataHolder(builder, paramInt, null);
  }
  
  private static CursorWindow[] getCursorWindows(DataHolder.Builder paramBuilder, int paramInt)
  {
    if (DataHolder.Builder.access$200(paramBuilder).length == 0) {
      return new CursorWindow[0];
    }
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < DataHolder.Builder.access$300(paramBuilder).size()) {}
    }
    else
    {
      i = DataHolder.Builder.access$300(paramBuilder).size();
    }
    paramBuilder = iterCursorWindow(paramBuilder, i, DataHolder.Builder.access$300(paramBuilder).subList(0, i));
    return (CursorWindow[])paramBuilder.toArray(new CursorWindow[paramBuilder.size()]);
  }
  
  private static CursorWindow[] getCursorWindows(HMSCursorWrapper paramHMSCursorWrapper)
  {
    Object localObject1 = new ArrayList();
    try
    {
      j = paramHMSCursorWrapper.getCount();
      localObject4 = paramHMSCursorWrapper.getWindow();
      if ((localObject4 == null) || (((CursorWindow)localObject4).getStartPosition() != 0)) {
        break label144;
      }
      ((CursorWindow)localObject4).acquireReference();
      paramHMSCursorWrapper.setWindow(null);
      ((ArrayList)localObject1).add(localObject4);
      i = ((CursorWindow)localObject4).getNumRows();
    }
    finally
    {
      for (;;)
      {
        try
        {
          int j;
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("fail to getCursorWindows: ");
          ((StringBuilder)localObject4).append(localObject2.getMessage());
          HMSLog.e("DataHolder", ((StringBuilder)localObject4).toString());
          return new CursorWindow[0];
        }
        finally
        {
          paramHMSCursorWrapper.close();
        }
        int i = 0;
      }
    }
    ((ArrayList)localObject1).addAll(iterCursorWrapper(paramHMSCursorWrapper, i, j));
    localObject1 = (CursorWindow[])((ArrayList)localObject1).toArray(new CursorWindow[((ArrayList)localObject1).size()]);
    paramHMSCursorWrapper.close();
    return localObject1;
  }
  
  private static ArrayList<CursorWindow> iterCursorWindow(DataHolder.Builder paramBuilder, int paramInt, List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    CursorWindow localCursorWindow = new CursorWindow(null);
    localCursorWindow.setNumColumns(DataHolder.Builder.access$200(paramBuilder).length);
    localArrayList.add(localCursorWindow);
    int i = 0;
    if (i < paramInt) {}
    for (;;)
    {
      int j;
      try
      {
        boolean bool = localCursorWindow.allocRow();
        if (!bool)
        {
          HMSLog.d("DataHolder", "Failed to allocate a row");
          localCursorWindow = new CursorWindow(null);
          localCursorWindow.setStartPosition(i);
          localCursorWindow.setNumColumns(DataHolder.Builder.access$200(paramBuilder).length);
          if (!localCursorWindow.allocRow())
          {
            HMSLog.e("DataHolder", "Failed to retry to allocate a row");
            return localArrayList;
          }
          localArrayList.add(localCursorWindow);
        }
        HashMap localHashMap = (HashMap)paramList.get(i);
        j = 0;
        bool = true;
        if (j < DataHolder.Builder.access$200(paramBuilder).length)
        {
          bool = putValue(localCursorWindow, localHashMap.get(DataHolder.Builder.access$200(paramBuilder)[j]), i, j);
          if (bool) {
            break label297;
          }
        }
        if (!bool)
        {
          paramList = new StringBuilder();
          paramList.append("fail to put data for row ");
          paramList.append(i);
          HMSLog.d("DataHolder", paramList.toString());
          localCursorWindow.freeLastRow();
          paramList = new CursorWindow(null);
          paramList.setStartPosition(i);
          paramList.setNumColumns(DataHolder.Builder.access$200(paramBuilder).length);
          localArrayList.add(paramList);
          return localArrayList;
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
      return localArrayList;
      label297:
      j += 1;
    }
  }
  
  private static ArrayList<CursorWindow> iterCursorWrapper(HMSCursorWrapper paramHMSCursorWrapper, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    while ((paramInt1 < paramInt2) && (paramHMSCursorWrapper.moveToPosition(paramInt1)))
    {
      CursorWindow localCursorWindow = paramHMSCursorWrapper.getWindow();
      if (localCursorWindow == null)
      {
        localCursorWindow = new CursorWindow(null);
        localCursorWindow.setStartPosition(paramInt1);
        paramHMSCursorWrapper.fillWindow(paramInt1, localCursorWindow);
      }
      else
      {
        localCursorWindow.acquireReference();
        paramHMSCursorWrapper.setWindow(null);
      }
      if (localCursorWindow.getNumRows() == 0) {
        return localArrayList;
      }
      localArrayList.add(localCursorWindow);
      paramInt1 = localCursorWindow.getNumRows() + localCursorWindow.getStartPosition();
    }
    return localArrayList;
  }
  
  private static boolean putValue(CursorWindow paramCursorWindow, Object paramObject, int paramInt1, int paramInt2)
  {
    if (paramObject == null) {
      return paramCursorWindow.putNull(paramInt1, paramInt2);
    }
    if ((paramObject instanceof Boolean))
    {
      long l;
      if (((Boolean)paramObject).booleanValue()) {
        l = 1L;
      } else {
        l = 0L;
      }
      return paramCursorWindow.putLong(l, paramInt1, paramInt2);
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
    paramCursorWindow = new StringBuilder();
    paramCursorWindow.append("unsupported type for column: ");
    paramCursorWindow.append(paramObject);
    throw new IllegalArgumentException(paramCursorWindow.toString());
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
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final void collectColumsAndCount()
  {
    this.columnsBundle = new Bundle();
    int k = 0;
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = this.columns;
      if (i >= localObject.length) {
        break;
      }
      this.columnsBundle.putInt(localObject[i], i);
      i += 1;
    }
    this.perCursorCounts = new int[this.cursorWindows.length];
    int j = 0;
    i = k;
    for (;;)
    {
      localObject = this.cursorWindows;
      if (i >= localObject.length) {
        break;
      }
      this.perCursorCounts[i] = j;
      j = localObject[i].getStartPosition() + this.cursorWindows[i].getNumRows();
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
    int i = paramString2.hashCode();
    boolean bool = true;
    switch (i)
    {
    default: 
      break;
    case 1300508295: 
      if (paramString2.equals("type_byte_array")) {
        i = 6;
      }
      break;
    case 878975158: 
      if (paramString2.equals("type_string")) {
        i = 2;
      }
      break;
    case 519136353: 
      if (paramString2.equals("type_long")) {
        i = 1;
      }
      break;
    case 445002870: 
      if (paramString2.equals("type_double")) {
        i = 5;
      }
      break;
    case -675993238: 
      if (paramString2.equals("type_int")) {
        i = 0;
      }
      break;
    case -870070237: 
      if (paramString2.equals("type_boolean")) {
        i = 3;
      }
      break;
    case -1092271849: 
      if (paramString2.equals("type_float")) {
        i = 4;
      }
      break;
    }
    i = -1;
    switch (i)
    {
    default: 
      return null;
    case 6: 
      checkAvailable(paramString1, paramInt1);
      return this.cursorWindows[paramInt2].getBlob(paramInt1, this.columnsBundle.getInt(paramString1));
    case 5: 
      checkAvailable(paramString1, paramInt1);
      return Double.valueOf(this.cursorWindows[paramInt2].getDouble(paramInt1, this.columnsBundle.getInt(paramString1)));
    case 4: 
      checkAvailable(paramString1, paramInt1);
      return Float.valueOf(this.cursorWindows[paramInt2].getFloat(paramInt1, this.columnsBundle.getInt(paramString1)));
    case 3: 
      checkAvailable(paramString1, paramInt1);
      if (this.cursorWindows[paramInt2].getLong(paramInt1, this.columnsBundle.getInt(paramString1)) != 1L) {
        bool = false;
      }
      return Boolean.valueOf(bool);
    case 2: 
      checkAvailable(paramString1, paramInt1);
      return this.cursorWindows[paramInt2].getString(paramInt1, this.columnsBundle.getInt(paramString1));
    case 1: 
      checkAvailable(paramString1, paramInt1);
      return Long.valueOf(this.cursorWindows[paramInt2].getLong(paramInt1, this.columnsBundle.getInt(paramString1)));
    }
    checkAvailable(paramString1, paramInt1);
    return Integer.valueOf(this.cursorWindows[paramInt2].getInt(paramInt1, this.columnsBundle.getInt(paramString1)));
  }
  
  public final int getWindowIndex(int paramInt)
  {
    int j = 0;
    boolean bool;
    if ((paramInt < 0) && (paramInt >= this.dataCount)) {
      bool = false;
    } else {
      bool = true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("rowIndex is out of index:");
    ((StringBuilder)localObject).append(paramInt);
    Preconditions.checkArgument(bool, ((StringBuilder)localObject).toString());
    int i;
    for (;;)
    {
      localObject = this.perCursorCounts;
      i = j;
      if (j >= localObject.length) {
        break;
      }
      if (paramInt < localObject[j])
      {
        i = j - 1;
        break;
      }
      j += 1;
    }
    paramInt = i;
    if (i == this.perCursorCounts.length) {
      paramInt = i - 1;
    }
    return paramInt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.data.DataHolder
 * JD-Core Version:    0.7.0.1
 */