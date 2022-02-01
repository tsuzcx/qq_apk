package com.tencent.luggage.wxa.ha;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.luggage.wxa.rb.a;
import com.tencent.luggage.wxa.rb.a.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class g
  extends a
{
  private static final int S = "usernameHash".hashCode();
  private static final int T = "username".hashCode();
  private static final int U = "appId".hashCode();
  private static final int V = "nickname".hashCode();
  private static final int W = "shortNickname".hashCode();
  private static final int X = "brandIconURL".hashCode();
  private static final int Y = "roundedSquareIconURL".hashCode();
  private static final int Z = "bigHeadURL".hashCode();
  public static final String[] a = { "CREATE INDEX IF NOT EXISTS WxaAttributesTableAppIdIndex ON WxaAttributesTable(appId)" };
  private static final int aa = "smallHeadURL".hashCode();
  private static final int ab = "signature".hashCode();
  private static final int ac = "appOpt".hashCode();
  private static final int ad = "registerSource".hashCode();
  private static final int ae = "appInfo".hashCode();
  private static final int af = "versionInfo".hashCode();
  private static final int ag = "passThroughInfo".hashCode();
  private static final int ah = "bindWxaInfo".hashCode();
  private static final int ai = "dynamicInfo".hashCode();
  private static final int aj = "reserved".hashCode();
  private static final int ak = "syncTimeSecond".hashCode();
  private static final int al = "syncVersion".hashCode();
  private static final int am = "bizMenu".hashCode();
  private static final int an = "rowid".hashCode();
  private boolean A = true;
  private boolean B = true;
  private boolean C = true;
  private boolean D = true;
  private boolean E = true;
  private boolean F = true;
  private boolean G = true;
  private boolean H = true;
  private boolean I = true;
  private boolean J = true;
  private boolean K = true;
  private boolean L = true;
  private boolean M = true;
  private boolean N = true;
  private boolean O = true;
  private boolean P = true;
  private boolean Q = true;
  private boolean R = true;
  public int b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public int l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public long t;
  public String u;
  public String v;
  private boolean w = true;
  private boolean y = true;
  private boolean z = true;
  
  public static a.a a(Class<?> paramClass)
  {
    paramClass = new a.a();
    paramClass.a = new Field[21];
    paramClass.c = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.c[0] = "usernameHash";
    paramClass.d.put("usernameHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    paramClass.b = "usernameHash";
    paramClass.c[1] = "username";
    paramClass.d.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    paramClass.c[2] = "appId";
    paramClass.d.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    paramClass.c[3] = "nickname";
    paramClass.d.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    paramClass.c[4] = "shortNickname";
    paramClass.d.put("shortNickname", "TEXT");
    localStringBuilder.append(" shortNickname TEXT");
    localStringBuilder.append(", ");
    paramClass.c[5] = "brandIconURL";
    paramClass.d.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    paramClass.c[6] = "roundedSquareIconURL";
    paramClass.d.put("roundedSquareIconURL", "TEXT");
    localStringBuilder.append(" roundedSquareIconURL TEXT");
    localStringBuilder.append(", ");
    paramClass.c[7] = "bigHeadURL";
    paramClass.d.put("bigHeadURL", "TEXT");
    localStringBuilder.append(" bigHeadURL TEXT");
    localStringBuilder.append(", ");
    paramClass.c[8] = "smallHeadURL";
    paramClass.d.put("smallHeadURL", "TEXT");
    localStringBuilder.append(" smallHeadURL TEXT");
    localStringBuilder.append(", ");
    paramClass.c[9] = "signature";
    paramClass.d.put("signature", "TEXT");
    localStringBuilder.append(" signature TEXT");
    localStringBuilder.append(", ");
    paramClass.c[10] = "appOpt";
    paramClass.d.put("appOpt", "INTEGER default '0' ");
    localStringBuilder.append(" appOpt INTEGER default '0' ");
    localStringBuilder.append(", ");
    paramClass.c[11] = "registerSource";
    paramClass.d.put("registerSource", "TEXT");
    localStringBuilder.append(" registerSource TEXT");
    localStringBuilder.append(", ");
    paramClass.c[12] = "appInfo";
    paramClass.d.put("appInfo", "TEXT");
    localStringBuilder.append(" appInfo TEXT");
    localStringBuilder.append(", ");
    paramClass.c[13] = "versionInfo";
    paramClass.d.put("versionInfo", "TEXT");
    localStringBuilder.append(" versionInfo TEXT");
    localStringBuilder.append(", ");
    paramClass.c[14] = "passThroughInfo";
    paramClass.d.put("passThroughInfo", "TEXT");
    localStringBuilder.append(" passThroughInfo TEXT");
    localStringBuilder.append(", ");
    paramClass.c[15] = "bindWxaInfo";
    paramClass.d.put("bindWxaInfo", "TEXT");
    localStringBuilder.append(" bindWxaInfo TEXT");
    localStringBuilder.append(", ");
    paramClass.c[16] = "dynamicInfo";
    paramClass.d.put("dynamicInfo", "TEXT");
    localStringBuilder.append(" dynamicInfo TEXT");
    localStringBuilder.append(", ");
    paramClass.c[17] = "reserved";
    paramClass.d.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    paramClass.c[18] = "syncTimeSecond";
    paramClass.d.put("syncTimeSecond", "LONG default '0' ");
    localStringBuilder.append(" syncTimeSecond LONG default '0' ");
    localStringBuilder.append(", ");
    paramClass.c[19] = "syncVersion";
    paramClass.d.put("syncVersion", "TEXT");
    localStringBuilder.append(" syncVersion TEXT");
    localStringBuilder.append(", ");
    paramClass.c[20] = "bizMenu";
    paramClass.d.put("bizMenu", "TEXT");
    localStringBuilder.append(" bizMenu TEXT");
    paramClass.c[21] = "rowid";
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
      if (S == i3)
      {
        this.b = paramCursor.getInt(i1);
        this.w = true;
      }
      else if (T == i3)
      {
        this.c = paramCursor.getString(i1);
      }
      else if (U == i3)
      {
        this.d = paramCursor.getString(i1);
      }
      else if (V == i3)
      {
        this.e = paramCursor.getString(i1);
      }
      else if (W == i3)
      {
        this.f = paramCursor.getString(i1);
      }
      else if (X == i3)
      {
        this.g = paramCursor.getString(i1);
      }
      else if (Y == i3)
      {
        this.h = paramCursor.getString(i1);
      }
      else if (Z == i3)
      {
        this.i = paramCursor.getString(i1);
      }
      else if (aa == i3)
      {
        this.j = paramCursor.getString(i1);
      }
      else if (ab == i3)
      {
        this.k = paramCursor.getString(i1);
      }
      else if (ac == i3)
      {
        this.l = paramCursor.getInt(i1);
      }
      else if (ad == i3)
      {
        this.m = paramCursor.getString(i1);
      }
      else if (ae == i3)
      {
        this.n = paramCursor.getString(i1);
      }
      else if (af == i3)
      {
        this.o = paramCursor.getString(i1);
      }
      else if (ag == i3)
      {
        this.p = paramCursor.getString(i1);
      }
      else if (ah == i3)
      {
        this.q = paramCursor.getString(i1);
      }
      else if (ai == i3)
      {
        this.r = paramCursor.getString(i1);
      }
      else if (aj == i3)
      {
        this.s = paramCursor.getString(i1);
      }
      else if (ak == i3)
      {
        this.t = paramCursor.getLong(i1);
      }
      else if (al == i3)
      {
        this.u = paramCursor.getString(i1);
      }
      else if (am == i3)
      {
        this.v = paramCursor.getString(i1);
      }
      else if (an == i3)
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
    if (this.w) {
      localContentValues.put("usernameHash", Integer.valueOf(this.b));
    }
    if (this.y) {
      localContentValues.put("username", this.c);
    }
    if (this.z) {
      localContentValues.put("appId", this.d);
    }
    if (this.A) {
      localContentValues.put("nickname", this.e);
    }
    if (this.B) {
      localContentValues.put("shortNickname", this.f);
    }
    if (this.C) {
      localContentValues.put("brandIconURL", this.g);
    }
    if (this.D) {
      localContentValues.put("roundedSquareIconURL", this.h);
    }
    if (this.E) {
      localContentValues.put("bigHeadURL", this.i);
    }
    if (this.F) {
      localContentValues.put("smallHeadURL", this.j);
    }
    if (this.G) {
      localContentValues.put("signature", this.k);
    }
    if (this.H) {
      localContentValues.put("appOpt", Integer.valueOf(this.l));
    }
    if (this.I) {
      localContentValues.put("registerSource", this.m);
    }
    if (this.J) {
      localContentValues.put("appInfo", this.n);
    }
    if (this.K) {
      localContentValues.put("versionInfo", this.o);
    }
    if (this.L) {
      localContentValues.put("passThroughInfo", this.p);
    }
    if (this.M) {
      localContentValues.put("bindWxaInfo", this.q);
    }
    if (this.N) {
      localContentValues.put("dynamicInfo", this.r);
    }
    if (this.O) {
      localContentValues.put("reserved", this.s);
    }
    if (this.P) {
      localContentValues.put("syncTimeSecond", Long.valueOf(this.t));
    }
    if (this.Q) {
      localContentValues.put("syncVersion", this.u);
    }
    if (this.R) {
      localContentValues.put("bizMenu", this.v);
    }
    if (this.x > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.x));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ha.g
 * JD-Core Version:    0.7.0.1
 */