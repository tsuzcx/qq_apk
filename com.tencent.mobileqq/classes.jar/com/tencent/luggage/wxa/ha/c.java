package com.tencent.luggage.wxa.ha;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.luggage.wxa.rb.a;
import com.tencent.luggage.wxa.rb.a.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class c
  extends a
{
  private static final int A = "pkgPath".hashCode();
  private static final int B = "createTime".hashCode();
  private static final int C = "debugType".hashCode();
  private static final int D = "downloadURL".hashCode();
  private static final int E = "startTime".hashCode();
  private static final int F = "endTime".hashCode();
  private static final int G = "rowid".hashCode();
  public static final String[] a = { "CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)" };
  private static final int v = "appId".hashCode();
  private static final int w = "version".hashCode();
  private static final int y = "versionMd5".hashCode();
  private static final int z = "NewMd5".hashCode();
  public String b;
  public int c;
  public String d;
  public String e;
  public String f;
  public long g;
  public int h;
  public String i;
  public long j;
  public long k;
  private boolean l = true;
  private boolean m = true;
  private boolean n = true;
  private boolean o = true;
  private boolean p = true;
  private boolean q = true;
  private boolean r = true;
  private boolean s = true;
  private boolean t = true;
  private boolean u = true;
  
  public static a.a a(Class<?> paramClass)
  {
    paramClass = new a.a();
    paramClass.a = new Field[10];
    paramClass.c = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.c[0] = "appId";
    paramClass.d.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    paramClass.c[1] = "version";
    paramClass.d.put("version", "INTEGER");
    localStringBuilder.append(" version INTEGER");
    localStringBuilder.append(", ");
    paramClass.c[2] = "versionMd5";
    paramClass.d.put("versionMd5", "TEXT");
    localStringBuilder.append(" versionMd5 TEXT");
    localStringBuilder.append(", ");
    paramClass.c[3] = "NewMd5";
    paramClass.d.put("NewMd5", "TEXT");
    localStringBuilder.append(" NewMd5 TEXT");
    localStringBuilder.append(", ");
    paramClass.c[4] = "pkgPath";
    paramClass.d.put("pkgPath", "TEXT");
    localStringBuilder.append(" pkgPath TEXT");
    localStringBuilder.append(", ");
    paramClass.c[5] = "createTime";
    paramClass.d.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    paramClass.c[6] = "debugType";
    paramClass.d.put("debugType", "INTEGER default '0' ");
    localStringBuilder.append(" debugType INTEGER default '0' ");
    localStringBuilder.append(", ");
    paramClass.c[7] = "downloadURL";
    paramClass.d.put("downloadURL", "TEXT");
    localStringBuilder.append(" downloadURL TEXT");
    localStringBuilder.append(", ");
    paramClass.c[8] = "startTime";
    paramClass.d.put("startTime", "LONG");
    localStringBuilder.append(" startTime LONG");
    localStringBuilder.append(", ");
    paramClass.c[9] = "endTime";
    paramClass.d.put("endTime", "LONG");
    localStringBuilder.append(" endTime LONG");
    paramClass.c[10] = "rowid";
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
      if (v == i3) {
        this.b = paramCursor.getString(i1);
      } else if (w == i3) {
        this.c = paramCursor.getInt(i1);
      } else if (y == i3) {
        this.d = paramCursor.getString(i1);
      } else if (z == i3) {
        this.e = paramCursor.getString(i1);
      } else if (A == i3) {
        this.f = paramCursor.getString(i1);
      } else if (B == i3) {
        this.g = paramCursor.getLong(i1);
      } else if (C == i3) {
        this.h = paramCursor.getInt(i1);
      } else if (D == i3) {
        this.i = paramCursor.getString(i1);
      } else if (E == i3) {
        this.j = paramCursor.getLong(i1);
      } else if (F == i3) {
        this.k = paramCursor.getLong(i1);
      } else if (G == i3) {
        this.x = paramCursor.getLong(i1);
      }
      i1 += 1;
    }
  }
  
  public ContentValues b()
  {
    c();
    ContentValues localContentValues = new ContentValues();
    if (this.l) {
      localContentValues.put("appId", this.b);
    }
    if (this.m) {
      localContentValues.put("version", Integer.valueOf(this.c));
    }
    if (this.n) {
      localContentValues.put("versionMd5", this.d);
    }
    if (this.o) {
      localContentValues.put("NewMd5", this.e);
    }
    if (this.p) {
      localContentValues.put("pkgPath", this.f);
    }
    if (this.q) {
      localContentValues.put("createTime", Long.valueOf(this.g));
    }
    if (this.r) {
      localContentValues.put("debugType", Integer.valueOf(this.h));
    }
    if (this.s) {
      localContentValues.put("downloadURL", this.i);
    }
    if (this.t) {
      localContentValues.put("startTime", Long.valueOf(this.j));
    }
    if (this.u) {
      localContentValues.put("endTime", Long.valueOf(this.k));
    }
    if (this.x > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.x));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ha.c
 * JD-Core Version:    0.7.0.1
 */