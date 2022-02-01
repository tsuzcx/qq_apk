package com.tencent.luggage.wxa.ha;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.luggage.wxa.rb.a;
import com.tencent.luggage.wxa.rb.a.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class b
  extends a
{
  public static final String[] a = new String[0];
  private static final int j = "key".hashCode();
  private static final int k = "data".hashCode();
  private static final int l = "dataType".hashCode();
  private static final int m = "size".hashCode();
  private static final int n = "rowid".hashCode();
  public String b;
  public String c;
  public String d;
  public int e;
  private boolean f = true;
  private boolean g = true;
  private boolean h = true;
  private boolean i = true;
  
  public static a.a a(Class<?> paramClass)
  {
    paramClass = new a.a();
    paramClass.a = new Field[4];
    paramClass.c = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.c[0] = "key";
    paramClass.d.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    paramClass.b = "key";
    paramClass.c[1] = "data";
    paramClass.d.put("data", "TEXT");
    localStringBuilder.append(" data TEXT");
    localStringBuilder.append(", ");
    paramClass.c[2] = "dataType";
    paramClass.d.put("dataType", "TEXT");
    localStringBuilder.append(" dataType TEXT");
    localStringBuilder.append(", ");
    paramClass.c[3] = "size";
    paramClass.d.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    paramClass.c[4] = "rowid";
    paramClass.e = localStringBuilder.toString();
    return paramClass;
  }
  
  private final void c() {}
  
  public void a(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i1 = 0;
    int i2 = arrayOfString.length;
    while (i1 < i2)
    {
      int i3 = arrayOfString[i1].hashCode();
      if (j == i3)
      {
        this.b = paramCursor.getString(i1);
        this.f = true;
      }
      else if (k == i3)
      {
        this.c = paramCursor.getString(i1);
      }
      else if (l == i3)
      {
        this.d = paramCursor.getString(i1);
      }
      else if (m == i3)
      {
        this.e = paramCursor.getInt(i1);
      }
      else if (n == i3)
      {
        this.x = paramCursor.getLong(i1);
      }
      i1 += 1;
    }
  }
  
  public ContentValues b()
  {
    c();
    ContentValues localContentValues = new ContentValues();
    if (this.f) {
      localContentValues.put("key", this.b);
    }
    if (this.g) {
      localContentValues.put("data", this.c);
    }
    if (this.h) {
      localContentValues.put("dataType", this.d);
    }
    if (this.i) {
      localContentValues.put("size", Integer.valueOf(this.e));
    }
    if (this.x > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.x));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ha.b
 * JD-Core Version:    0.7.0.1
 */