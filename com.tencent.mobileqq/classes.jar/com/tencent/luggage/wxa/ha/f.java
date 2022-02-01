package com.tencent.luggage.wxa.ha;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.luggage.wxa.rb.a;
import com.tencent.luggage.wxa.rb.a.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class f
  extends a
{
  public static final String[] a = new String[0];
  private static final int n = "appId".hashCode();
  private static final int o = "moduleName".hashCode();
  private static final int p = "type".hashCode();
  private static final int q = "version".hashCode();
  private static final int r = "downloadURL".hashCode();
  private static final int s = "localPath".hashCode();
  private static final int t = "rowid".hashCode();
  public String b;
  public String c;
  public int d;
  public int e;
  public String f;
  public String g;
  private boolean h = true;
  private boolean i = true;
  private boolean j = true;
  private boolean k = true;
  private boolean l = true;
  private boolean m = true;
  
  public static a.a a(Class<?> paramClass)
  {
    paramClass = new a.a();
    paramClass.a = new Field[6];
    paramClass.c = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.c[0] = "appId";
    paramClass.d.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    paramClass.c[1] = "moduleName";
    paramClass.d.put("moduleName", "TEXT");
    localStringBuilder.append(" moduleName TEXT");
    localStringBuilder.append(", ");
    paramClass.c[2] = "type";
    paramClass.d.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    paramClass.c[3] = "version";
    paramClass.d.put("version", "INTEGER");
    localStringBuilder.append(" version INTEGER");
    localStringBuilder.append(", ");
    paramClass.c[4] = "downloadURL";
    paramClass.d.put("downloadURL", "TEXT");
    localStringBuilder.append(" downloadURL TEXT");
    localStringBuilder.append(", ");
    paramClass.c[5] = "localPath";
    paramClass.d.put("localPath", "TEXT");
    localStringBuilder.append(" localPath TEXT");
    paramClass.c[6] = "rowid";
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
      if (n == i3) {
        this.b = paramCursor.getString(i1);
      } else if (o == i3) {
        this.c = paramCursor.getString(i1);
      } else if (p == i3) {
        this.d = paramCursor.getInt(i1);
      } else if (q == i3) {
        this.e = paramCursor.getInt(i1);
      } else if (r == i3) {
        this.f = paramCursor.getString(i1);
      } else if (s == i3) {
        this.g = paramCursor.getString(i1);
      } else if (t == i3) {
        this.x = paramCursor.getLong(i1);
      }
      i1 += 1;
    }
  }
  
  public ContentValues b()
  {
    c();
    ContentValues localContentValues = new ContentValues();
    if (this.h) {
      localContentValues.put("appId", this.b);
    }
    if (this.i) {
      localContentValues.put("moduleName", this.c);
    }
    if (this.j) {
      localContentValues.put("type", Integer.valueOf(this.d));
    }
    if (this.k) {
      localContentValues.put("version", Integer.valueOf(this.e));
    }
    if (this.l) {
      localContentValues.put("downloadURL", this.f);
    }
    if (this.m) {
      localContentValues.put("localPath", this.g);
    }
    if (this.x > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.x));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ha.f
 * JD-Core Version:    0.7.0.1
 */