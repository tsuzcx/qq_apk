package com.tencent.luggage.wxa.rb;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class d<T extends a>
  extends e
{
  private final b a;
  public int b = 1;
  private final a.a c;
  private final String d;
  
  public d(b paramb, a.a parama, String paramString, String[] paramArrayOfString)
  {
    this.a = paramb;
    this.c = parama;
    parama = this.c;
    if (af.c(parama.b)) {
      paramb = "rowid";
    } else {
      paramb = this.c.b;
    }
    parama.b = paramb;
    this.d = paramString;
    a(paramArrayOfString);
  }
  
  public static String a(a.a parama, String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder2.append(paramString);
    localStringBuilder2.append(" ( ");
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(parama.e);
    localStringBuilder1.append(");");
    return localStringBuilder1.toString();
  }
  
  private static StringBuilder a(ContentValues paramContentValues, String... paramVarArgs)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(str);
      localStringBuilder2.append(" = ? AND ");
      localStringBuilder1.append(localStringBuilder2.toString());
      if (paramContentValues.get(str) == null) {
        return null;
      }
      i += 1;
    }
    localStringBuilder1.append(" 1=1");
    return localStringBuilder1;
  }
  
  public static List<String> a(a.a parama, String paramString, b paramb)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramb != null) && (paramString != null))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("PRAGMA table_info( ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" )");
      localObject1 = paramb.b(((StringBuilder)localObject1).toString(), new String[0], 2);
      if (localObject1 == null) {
        return localArrayList;
      }
      paramb = new HashMap();
      int i = ((Cursor)localObject1).getColumnIndex("name");
      int j = ((Cursor)localObject1).getColumnIndex("type");
      while (((Cursor)localObject1).moveToNext()) {
        paramb.put(((Cursor)localObject1).getString(i), ((Cursor)localObject1).getString(j));
      }
      ((Cursor)localObject1).close();
      parama = parama.d.entrySet().iterator();
      while (parama.hasNext())
      {
        Object localObject2 = (Map.Entry)parama.next();
        localObject1 = (String)((Map.Entry)localObject2).getValue();
        localObject2 = (String)((Map.Entry)localObject2).getKey();
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          Object localObject3 = (String)paramb.get(localObject2);
          if (localObject3 == null)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("ALTER TABLE ");
            ((StringBuilder)localObject3).append(paramString);
            ((StringBuilder)localObject3).append(" ADD COLUMN ");
            ((StringBuilder)localObject3).append((String)localObject2);
            ((StringBuilder)localObject3).append(" ");
            ((StringBuilder)localObject3).append((String)localObject1);
            ((StringBuilder)localObject3).append(";");
            localArrayList.add(((StringBuilder)localObject3).toString());
            paramb.remove(localObject2);
          }
          else if (!((String)localObject1).toLowerCase().startsWith(((String)localObject3).toLowerCase()))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("conflicting alter table on column: ");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(", ");
            localStringBuilder.append((String)localObject3);
            localStringBuilder.append("<o-n>");
            localStringBuilder.append((String)localObject1);
            o.b("MicroMsg.SDK.MAutoStorage", localStringBuilder.toString());
            paramb.remove(localObject2);
          }
        }
      }
      return localArrayList;
    }
    boolean bool;
    if (paramb == null) {
      bool = true;
    } else {
      bool = false;
    }
    o.b("MicroMsg.SDK.MAutoStorage", "dk getUpdateSQLs db==null :%b  table:%s", new Object[] { Boolean.valueOf(bool), paramString });
    return localArrayList;
  }
  
  private void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(":");
    localStringBuilder.append(paramString);
    o.e("MicroMsg.SDK.MAutoStorage", localStringBuilder.toString());
  }
  
  private void a(String[] paramArrayOfString)
  {
    List localList = a(this.c, b(), this.a);
    int j = 0;
    int i = 0;
    while (i < localList.size())
    {
      if (!this.a.a(this.d, (String)localList.get(i))) {
        o.d("MicroMsg.SDK.MAutoStorage", "updateColumnSQLs table failed %s, sql %s", new Object[] { this.d, localList.get(i) });
      }
      i += 1;
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      i = j;
      while (i < paramArrayOfString.length)
      {
        this.a.a(this.d, paramArrayOfString[i]);
        i += 1;
      }
    }
  }
  
  private boolean a(ContentValues paramContentValues)
  {
    Object localObject = this.a;
    String str = b();
    String[] arrayOfString = this.c.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.b);
    localStringBuilder.append(" = ?");
    localObject = ((b)localObject).b(str, arrayOfString, localStringBuilder.toString(), new String[] { af.b(paramContentValues.getAsString(this.c.b)) }, null, null, null);
    boolean bool = a.a(paramContentValues, (Cursor)localObject);
    ((Cursor)localObject).close();
    return bool;
  }
  
  private static String[] a(String[] paramArrayOfString, ContentValues paramContentValues)
  {
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    while (i < arrayOfString.length)
    {
      arrayOfString[i] = af.b(paramContentValues.getAsString(paramArrayOfString[i]));
      i += 1;
    }
    return arrayOfString;
  }
  
  private void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(":");
    localStringBuilder.append(paramString);
    o.b("MicroMsg.SDK.MAutoStorage", localStringBuilder.toString());
  }
  
  public boolean a(T paramT)
  {
    return a(paramT, true);
  }
  
  public boolean a(T paramT, boolean paramBoolean)
  {
    ContentValues localContentValues = paramT.b();
    if ((localContentValues != null) && (localContentValues.size() > 0))
    {
      paramT.x = this.a.a(b(), this.c.b, localContentValues);
      if (paramT.x <= 0L)
      {
        b("insert failed");
        return false;
      }
      localContentValues.put("rowid", Long.valueOf(paramT.x));
      if (paramBoolean) {
        c(localContentValues.getAsString(this.c.b));
      }
      return true;
    }
    b("insert failed, value.size <= 0");
    return false;
  }
  
  public boolean a(T paramT, boolean paramBoolean, String... paramVarArgs)
  {
    paramT = paramT.b();
    boolean bool = false;
    if ((paramT != null) && (paramT.size() > 0))
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localObject = a(paramT, paramVarArgs);
        if (localObject == null)
        {
          b("update failed, check keys failed");
          return false;
        }
        if (this.a.a(b(), paramT, ((StringBuilder)localObject).toString(), a(paramVarArgs, paramT)) > 0)
        {
          if (paramBoolean) {
            c(paramT.getAsString(this.c.b));
          }
          return true;
        }
        b("update failed");
        return false;
      }
      a("update with primary key");
      if (a(paramT))
      {
        a("no need replace , fields no change");
        return true;
      }
      paramVarArgs = this.a;
      Object localObject = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c.b);
      localStringBuilder.append(" = ?");
      if (paramVarArgs.a((String)localObject, paramT, localStringBuilder.toString(), new String[] { af.b(paramT.getAsString(this.c.b)) }) > 0) {
        bool = true;
      }
      if ((bool) && (paramBoolean)) {
        f();
      }
      return bool;
    }
    b("update failed, value.size <= 0");
    return false;
  }
  
  public boolean a(T paramT, String... paramVarArgs)
  {
    ContentValues localContentValues = paramT.b();
    if ((localContentValues != null) && (localContentValues.size() > 0))
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localObject = a(localContentValues, paramVarArgs);
        if (localObject == null)
        {
          b("get failed, check keys failed");
          return false;
        }
        paramVarArgs = this.a.b(b(), this.c.c, ((StringBuilder)localObject).toString(), a(paramVarArgs, localContentValues), null, null, null, 2);
        if (paramVarArgs.moveToFirst())
        {
          paramT.a(paramVarArgs);
          paramVarArgs.close();
          return true;
        }
        paramVarArgs.close();
        a("get failed, not found");
        return false;
      }
      a("get with primary key");
      paramVarArgs = this.a;
      Object localObject = b();
      String[] arrayOfString = this.c.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c.b);
      localStringBuilder.append(" = ?");
      paramVarArgs = paramVarArgs.b((String)localObject, arrayOfString, localStringBuilder.toString(), new String[] { af.b(localContentValues.getAsString(this.c.b)) }, null, null, null, 2);
      if (paramVarArgs.moveToFirst())
      {
        paramT.a(paramVarArgs);
        paramVarArgs.close();
        return true;
      }
      paramVarArgs.close();
      return false;
    }
    b("get failed, value.size <= 0");
    return false;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public boolean b(T paramT)
  {
    return b(paramT, true);
  }
  
  public boolean b(T paramT, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean b(T paramT, boolean paramBoolean, String... paramVarArgs)
  {
    paramT = paramT.b();
    boolean bool = false;
    if ((paramT != null) && (paramT.size() > 0))
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        localObject = a(paramT, paramVarArgs);
        if (localObject == null)
        {
          b("delete failed, check keys failed");
          return false;
        }
        if ((this.a.a(b(), ((StringBuilder)localObject).toString(), a(paramVarArgs, paramT)) > 0) && (paramBoolean))
        {
          c(this.c.b);
          return true;
        }
        b("delete failed");
        return false;
      }
      a("delete with primary key");
      paramVarArgs = this.a;
      Object localObject = b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c.b);
      localStringBuilder.append(" = ?");
      if (paramVarArgs.a((String)localObject, localStringBuilder.toString(), new String[] { af.b(paramT.getAsString(this.c.b)) }) > 0) {
        bool = true;
      }
      if ((bool) && (paramBoolean)) {
        f();
      }
      return bool;
    }
    b("delete failed, value.size <= 0");
    return false;
  }
  
  public boolean b(T paramT, String... paramVarArgs)
  {
    return b(paramT, true, paramVarArgs);
  }
  
  public boolean c(T paramT, String... paramVarArgs)
  {
    return a(paramT, true, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rb.d
 * JD-Core Version:    0.7.0.1
 */