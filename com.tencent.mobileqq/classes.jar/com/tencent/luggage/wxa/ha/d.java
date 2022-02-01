package com.tencent.luggage.wxa.ha;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.luggage.wxa.rb.a;
import com.tencent.luggage.wxa.rb.a.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class d
  extends a
{
  public static final String[] a = new String[0];
  private static final int h = "appId".hashCode();
  private static final int i = "versionType".hashCode();
  private static final int j = "extJson".hashCode();
  private static final int k = "rowid".hashCode();
  public String b;
  public int c;
  public String d;
  private boolean e = true;
  private boolean f = true;
  private boolean g = true;
  
  public static a.a a(Class<?> paramClass)
  {
    paramClass = new a.a();
    paramClass.a = new Field[3];
    paramClass.c = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.c[0] = "appId";
    paramClass.d.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    paramClass.c[1] = "versionType";
    paramClass.d.put("versionType", "INTEGER");
    localStringBuilder.append(" versionType INTEGER");
    localStringBuilder.append(", ");
    paramClass.c[2] = "extJson";
    paramClass.d.put("extJson", "TEXT");
    localStringBuilder.append(" extJson TEXT");
    paramClass.c[3] = "rowid";
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
    int m = 0;
    int n = arrayOfString.length;
    while (m < n)
    {
      int i1 = arrayOfString[m].hashCode();
      if (h == i1) {
        this.b = paramCursor.getString(m);
      } else if (i == i1) {
        this.c = paramCursor.getInt(m);
      } else if (j == i1) {
        this.d = paramCursor.getString(m);
      } else if (k == i1) {
        this.x = paramCursor.getLong(m);
      }
      m += 1;
    }
  }
  
  public ContentValues b()
  {
    c();
    ContentValues localContentValues = new ContentValues();
    if (this.e) {
      localContentValues.put("appId", this.b);
    }
    if (this.f) {
      localContentValues.put("versionType", Integer.valueOf(this.c));
    }
    if (this.g) {
      localContentValues.put("extJson", this.d);
    }
    if (this.x > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.x));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ha.d
 * JD-Core Version:    0.7.0.1
 */