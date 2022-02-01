package com.tencent.luggage.wxa.ha;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.luggage.wxa.qw.fb;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rb.a;
import com.tencent.luggage.wxa.rb.a.a;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class e
  extends a
{
  public static final String[] a = new String[0];
  private static final int f = "appId".hashCode();
  private static final int g = "launchPB".hashCode();
  private static final int h = "rowid".hashCode();
  public String b;
  public fb c;
  private boolean d = true;
  private boolean e = true;
  
  public static a.a a(Class<?> paramClass)
  {
    paramClass = new a.a();
    paramClass.a = new Field[2];
    paramClass.c = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.c[0] = "appId";
    paramClass.d.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    paramClass.c[1] = "launchPB";
    paramClass.d.put("launchPB", "BLOB");
    localStringBuilder.append(" launchPB BLOB");
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
      if (f == k) {
        this.b = paramCursor.getString(i);
      } else if (g == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            break label140;
          }
          this.c = ((fb)new fb().a(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          o.b("MicroMsg.SDK.BaseLaunchWxaAppPBTable", localIOException.getMessage());
        }
      } else if (h == k) {
        this.x = paramCursor.getLong(i);
      }
      label140:
      i += 1;
    }
  }
  
  public ContentValues b()
  {
    c();
    ContentValues localContentValues = new ContentValues();
    if (this.d) {
      localContentValues.put("appId", this.b);
    }
    if (this.e)
    {
      fb localfb = this.c;
      if (localfb != null) {
        try
        {
          localContentValues.put("launchPB", localfb.b());
        }
        catch (IOException localIOException)
        {
          o.b("MicroMsg.SDK.BaseLaunchWxaAppPBTable", localIOException.getMessage());
        }
      }
    }
    if (this.x > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.x));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ha.e
 * JD-Core Version:    0.7.0.1
 */