package com.tencent.luggage.wxa.ha;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.luggage.wxa.rb.a;
import com.tencent.luggage.wxa.rb.a.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class h
  extends a
{
  private static final int c = "userName".hashCode();
  public static final String[] d = new String[0];
  private static final int g = "versionType".hashCode();
  private static final int h = "rowid".hashCode();
  private boolean a = true;
  private boolean b = true;
  public String e;
  public int f;
  
  public static a.a a(Class<?> paramClass)
  {
    paramClass = new a.a();
    paramClass.a = new Field[2];
    paramClass.c = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.c[0] = "userName";
    paramClass.d.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    paramClass.c[1] = "versionType";
    paramClass.d.put("versionType", "INTEGER");
    localStringBuilder.append(" versionType INTEGER");
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
      if (c == k) {
        this.e = paramCursor.getString(i);
      } else if (g == k) {
        this.f = paramCursor.getInt(i);
      } else if (h == k) {
        this.x = paramCursor.getLong(i);
      }
      i += 1;
    }
  }
  
  public ContentValues b()
  {
    c();
    ContentValues localContentValues = new ContentValues();
    if (this.a) {
      localContentValues.put("userName", this.e);
    }
    if (this.b) {
      localContentValues.put("versionType", Integer.valueOf(this.f));
    }
    if (this.x > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.x));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ha.h
 * JD-Core Version:    0.7.0.1
 */