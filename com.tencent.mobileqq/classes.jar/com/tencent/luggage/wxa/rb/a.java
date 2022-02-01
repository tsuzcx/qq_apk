package com.tencent.luggage.wxa.rb;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.luggage.wxa.qz.o;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public abstract class a
{
  public long x = -1L;
  
  public static boolean a(ContentValues paramContentValues, Cursor paramCursor)
  {
    if (paramContentValues == null) {
      return paramCursor == null;
    }
    if (paramCursor != null)
    {
      if (paramCursor.getCount() != 1) {
        return false;
      }
      paramCursor.moveToFirst();
      int k = paramCursor.getColumnCount();
      int j = paramContentValues.size();
      int i = j;
      if (paramContentValues.containsKey("rowid")) {
        i = j - 1;
      }
      j = k;
      if (paramCursor.getColumnIndex("rowid") != -1) {
        j = k - 1;
      }
      if (i != j) {
        return false;
      }
      try
      {
        Iterator localIterator = paramContentValues.valueSet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)((Map.Entry)localIterator.next()).getKey();
          if (!str.equals("rowid"))
          {
            i = paramCursor.getColumnIndex(str);
            if (i == -1) {
              return false;
            }
            if ((paramContentValues.get(str) instanceof byte[]))
            {
              if (!a((byte[])paramContentValues.get(str), paramCursor.getBlob(i))) {
                return false;
              }
            }
            else
            {
              if ((paramCursor.getString(i) == null) && (paramContentValues.get(str) != null)) {
                return false;
              }
              if (paramContentValues.get(str) == null) {
                return false;
              }
              boolean bool = paramContentValues.get(str).toString().equals(paramCursor.getString(i));
              if (!bool) {
                return false;
              }
            }
          }
        }
        return true;
      }
      catch (Exception paramContentValues)
      {
        o.a("MicroMsg.SDK.IAutoDBItem", paramContentValues, "", new Object[0]);
      }
    }
    return false;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) && (paramArrayOfByte2 == null)) {
      return true;
    }
    if ((paramArrayOfByte1 == null) && (paramArrayOfByte2 != null)) {
      return false;
    }
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 == null)) {
      return false;
    }
    if (paramArrayOfByte1.length != paramArrayOfByte2.length) {
      return false;
    }
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  protected abstract a.a a();
  
  public abstract void a(Cursor paramCursor);
  
  public abstract ContentValues b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rb.a
 * JD-Core Version:    0.7.0.1
 */