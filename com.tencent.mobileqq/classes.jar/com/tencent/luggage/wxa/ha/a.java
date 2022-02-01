package com.tencent.luggage.wxa.ha;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.luggage.wxa.rb.a.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class a
  extends com.tencent.luggage.wxa.rb.a
{
  public static final String[] a = new String[0];
  private static final int f = "key".hashCode();
  private static final int g = "value".hashCode();
  private static final int h = "rowid".hashCode();
  public String b;
  public String c;
  private boolean d = true;
  private boolean e = true;
  
  public static a.a a(Class<?> paramClass)
  {
    paramClass = new a.a();
    paramClass.a = new Field[2];
    paramClass.c = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.c[0] = "key";
    paramClass.d.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    paramClass.b = "key";
    paramClass.c[1] = "value";
    paramClass.d.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    paramClass.c[2] = "rowid";
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
    int i = 0;
    int j = arrayOfString.length;
    while (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (f == k)
      {
        this.b = paramCursor.getString(i);
        this.d = true;
      }
      else if (g == k)
      {
        this.c = paramCursor.getString(i);
      }
      else if (h == k)
      {
        this.x = paramCursor.getLong(i);
      }
      i += 1;
    }
  }
  
  public ContentValues b()
  {
    c();
    ContentValues localContentValues = new ContentValues();
    if (this.d) {
      localContentValues.put("key", this.b);
    }
    if (this.e) {
      localContentValues.put("value", this.c);
    }
    if (this.x > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.x));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ha.a
 * JD-Core Version:    0.7.0.1
 */