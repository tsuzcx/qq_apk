package com.tencent.mm.plugin.appbrand.appstorage;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rb.a;
import com.tencent.luggage.wxa.rb.a.a;
import com.tencent.luggage.wxa.rb.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public class c
  extends d<b>
  implements m
{
  public static final String[] a = { d.a(b.f, "AppBrandKVData"), "DROP TABLE IF EXISTS AppBrandStorageKVData;" };
  private com.tencent.luggage.wxa.rb.b c;
  private Function1<String, String> d = new c.2(this);
  private Function2<String, String, Unit> e = new c.3(this);
  
  public c(com.tencent.luggage.wxa.rb.b paramb)
  {
    super(paramb, b.f, "AppBrandKVData", null);
    this.c = paramb;
  }
  
  private void a()
  {
    Object localObject = b.f;
    com.tencent.luggage.wxa.rb.b localb = this.c;
    String str1 = b();
    localObject = a((a.a)localObject, b(), localb).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str2 = (String)((Iterator)localObject).next();
      if (!localb.a(str1, str2)) {
        o.b("AppBrandKVStorage", "updateColumnSQLs table failed %s, sql %s", new Object[] { str1, str2 });
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2)
  {
    b localb = new b();
    localb.b = c(paramInt1, paramString, "@@@TOTAL@DATA@SIZE@@@");
    paramString = new StringBuilder();
    paramString.append(paramInt2);
    paramString.append("");
    localb.c = paramString.toString();
    super.b(localb);
  }
  
  private void a(@NonNull String paramString, int paramInt)
  {
    r.a(paramString, paramInt, this.d, this.e);
  }
  
  private int b(int paramInt1, String paramString, int paramInt2)
  {
    paramInt2 = Math.max(0, c(paramInt1, paramString) + paramInt2);
    a(paramInt1, paramString, paramInt2);
    return paramInt2;
  }
  
  private void b(String paramString, int paramInt)
  {
    r.b(paramString, paramInt, this.d, this.e);
  }
  
  private int c(int paramInt, String paramString)
  {
    b localb = new b();
    localb.b = c(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@");
    paramInt = 0;
    if (super.a(localb, new String[0])) {
      paramInt = af.a(localb.c, 0);
    }
    return paramInt;
  }
  
  private String c(int paramInt, String paramString1, String paramString2)
  {
    return r.a(paramInt, paramString1, paramString2);
  }
  
  private boolean c(int paramInt1, String paramString, int paramInt2)
  {
    return c(paramInt1, paramString) + paramInt2 >= d(paramInt1, paramString);
  }
  
  private int d(int paramInt, String paramString)
  {
    return r.a(paramInt, paramString);
  }
  
  private void d(String paramString)
  {
    b localb = new b();
    localb.b = paramString;
    super.b(localb, new String[0]);
  }
  
  private int e(String paramString)
  {
    Object localObject = null;
    try
    {
      Cursor localCursor = this.c.b("AppBrandKVData", new String[] { "size" }, "key = ?", new String[] { paramString }, null, null, null, 2);
      localObject = localCursor;
      if (localCursor.moveToFirst())
      {
        localObject = localCursor;
        int i = localCursor.getInt(0);
        localObject = localCursor;
        localCursor.close();
        return i;
      }
      localObject = localCursor;
      localCursor.close();
      return 0;
    }
    catch (SQLiteException localSQLiteException)
    {
      if (af.b(localSQLiteException.getMessage()).contains("no such table"))
      {
        o.b("AppBrandKVStorage", "getDataSize recordKey[%s], get exception[%s] try create table", new Object[] { paramString, localSQLiteException });
        if ((localObject != null) && (!localObject.isClosed())) {
          localObject.close();
        }
        return 0;
      }
      throw localSQLiteException;
    }
  }
  
  public m.a a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((!af.c(paramString1)) && (!af.c(paramString2)))
    {
      String str = r.a(paramInt, paramString1, paramString2, "__");
      int j = e(str);
      int i = r.a(paramString2, paramString3);
      j = i - j;
      if (c(paramInt, paramString1, j)) {
        return m.a.e;
      }
      b localb = new b();
      localb.b = str;
      localb.c = paramString3;
      localb.d = paramString4;
      localb.e = i;
      paramString4 = new c.1(this, localb, paramString1, paramInt, j);
      try
      {
        paramString3 = (m.a)paramString4.invoke();
        return paramString3;
      }
      catch (SQLiteException paramString3)
      {
        if (af.b(paramString3.getMessage()).contains("no such table"))
        {
          o.b("AppBrandKVStorage", "set storageId[%d] appId[%s] key[%s], get exception[%s] try create table", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3 });
          try
          {
            a();
            paramString4 = (m.a)paramString4.invoke();
            return paramString4;
          }
          catch (SQLiteException paramString4)
          {
            paramString1 = String.format(Locale.ENGLISH, "set storageId[%d] appId[%s] key[%s], get exception[%s] after retry", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2, paramString3 });
            o.b("AppBrandKVStorage", paramString1);
            throw new SQLiteException(paramString1, paramString4);
          }
        }
        throw paramString3;
      }
    }
    return m.a.c;
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("__");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("__");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("__");
      localObject = ((StringBuilder)localObject).toString();
    }
    b(paramString, paramInt);
    com.tencent.luggage.wxa.rb.b localb = this.c;
    String str = String.format("%s like ? escape ? OR %s=?", new Object[] { "key", "key" });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((String)localObject).replace("_", "\\_"));
    localStringBuilder.append("%");
    localb.a("AppBrandKVData", str, new String[] { localStringBuilder.toString(), "\\", c(paramInt, paramString, "@@@TOTAL@DATA@SIZE@@@") });
  }
  
  @NonNull
  public int[] a(@NonNull String paramString)
  {
    return r.a(paramString, this.d, this.e);
  }
  
  public Object[] a(int paramInt, String paramString1, String paramString2)
  {
    if ((!af.c(paramString1)) && (!af.c(paramString2)))
    {
      Object localObject = new b();
      ((b)localObject).b = r.a(paramInt, paramString1, paramString2, "__");
      try
      {
        if (super.a((a)localObject, new String[0])) {
          return new Object[] { m.a.a, ((b)localObject).c, ((b)localObject).d };
        }
        localObject = r.a;
        return localObject;
      }
      catch (SQLiteException localSQLiteException)
      {
        if (af.b(localSQLiteException.getMessage()).contains("no such table"))
        {
          o.b("AppBrandKVStorage", "get storageId[%d] appId[%s] key[%s], no such table, return RET_GET_NO_SUCH_KEY", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
          return r.a;
        }
        if (localSQLiteException.getClass().getName().endsWith("CursorWindowAllocationException")) {
          return new Object[] { m.a.f };
        }
        throw localSQLiteException;
      }
    }
    return new Object[] { m.a.c };
  }
  
  public int b(@NonNull String paramString)
  {
    int[] arrayOfInt = a(paramString);
    int k = arrayOfInt.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += c(arrayOfInt[i], paramString);
      i += 1;
    }
    return j;
  }
  
  public m.a b(int paramInt, String paramString1, String paramString2)
  {
    if ((!af.c(paramString1)) && (!af.c(paramString2)))
    {
      paramString2 = r.a(paramInt, paramString1, paramString2, "__");
      int i = b(paramInt, paramString1, -e(paramString2));
      d(paramString2);
      if (i <= 0) {
        b(paramString1, paramInt);
      }
      return m.a.a;
    }
    return m.a.c;
  }
  
  public Object[] b(int paramInt, String paramString)
  {
    Object localObject1;
    if (paramInt == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("__");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("__");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("__");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = this.c;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(((String)localObject1).replace("_", "\\_"));
    ((StringBuilder)localObject3).append("%");
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject2 = ((com.tencent.luggage.wxa.rb.b)localObject2).b("AppBrandKVData", new String[] { "key" }, "key like ? escape ?", new String[] { localObject3, "\\" }, null, null, null, 2);
    localObject3 = new ArrayList();
    while (((Cursor)localObject2).moveToNext()) {
      ((ArrayList)localObject3).add(((Cursor)localObject2).getString(0).replace((CharSequence)localObject1, ""));
    }
    ((Cursor)localObject2).close();
    return new Object[] { localObject3, Integer.valueOf(c(paramInt, paramString)), Integer.valueOf(d(paramInt, paramString)) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.c
 * JD-Core Version:    0.7.0.1
 */