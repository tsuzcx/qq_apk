package com.tencent.luggage.wxa.jj;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qw.ai;
import com.tencent.luggage.wxa.qw.lu;
import com.tencent.luggage.wxa.qw.lv;
import com.tencent.luggage.wxa.qw.lx;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rb.c;
import com.tencent.luggage.wxa.rb.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class r
  extends d<s>
{
  private final com.tencent.luggage.wxa.rb.b a;
  
  public r(com.tencent.luggage.wxa.rb.b paramb, String paramString, String[] paramArrayOfString)
  {
    super(paramb, s.w, paramString, paramArrayOfString);
    this.a = paramb;
  }
  
  private boolean a(String paramString, com.tencent.luggage.wxa.qu.b paramb, List<lu> paramList, boolean paramBoolean)
  {
    if (af.a(paramList)) {
      return false;
    }
    s locals = new s();
    locals.c = paramString;
    boolean bool2 = a(locals, new String[] { "username" });
    paramString = paramList.iterator();
    boolean bool1 = false;
    while (paramString.hasNext())
    {
      paramList = (lu)paramString.next();
      if (paramList != null) {
        bool1 |= a(locals, paramList);
      }
    }
    locals.t = af.a();
    if (paramb == null) {
      paramString = new byte[0];
    } else {
      paramString = paramb.c();
    }
    locals.u = af.b(paramString);
    if (bool1)
    {
      if ((bool2 ^ true))
      {
        a(locals, paramBoolean);
        return bool1;
      }
      a(locals, paramBoolean, new String[] { "username" });
      return bool1;
    }
    a(locals, false, new String[] { "username" });
    return bool1;
  }
  
  private static boolean a(String paramString1, String paramString2)
  {
    return af.b(paramString1).equals(af.b(paramString2));
  }
  
  int a(long paramLong)
  {
    com.tencent.luggage.wxa.rb.b localb = this.a;
    if ((localb instanceof c)) {
      return ((c)localb).b(paramLong);
    }
    return -1;
  }
  
  long a()
  {
    com.tencent.luggage.wxa.rb.b localb = this.a;
    if ((localb instanceof c)) {
      return ((c)localb).a(Thread.currentThread().getId());
    }
    return -1L;
  }
  
  @Nullable
  public s a(String paramString, String... paramVarArgs)
  {
    boolean bool = af.c(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    if (!paramString.endsWith("@app")) {
      return null;
    }
    Object localObject2 = this.a;
    String str = b();
    if (af.a(paramVarArgs)) {
      paramVarArgs = null;
    }
    localObject2 = ((com.tencent.luggage.wxa.rb.b)localObject2).b(str, paramVarArgs, String.format(Locale.US, "%s=?", new Object[] { "usernameHash" }), new String[] { String.valueOf(paramString.hashCode()) }, null, null, null, 2);
    if (localObject2 == null) {
      return null;
    }
    paramVarArgs = localObject1;
    if (((Cursor)localObject2).moveToFirst())
    {
      paramVarArgs = new s();
      paramVarArgs.a((Cursor)localObject2);
      paramVarArgs.c = paramString;
    }
    ((Cursor)localObject2).close();
    return paramVarArgs;
  }
  
  public String a(String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    paramString = b(paramString, new String[] { "username" });
    if (paramString == null) {
      return null;
    }
    return paramString.c;
  }
  
  protected boolean a(@NonNull s params, @NonNull lu paramlu)
  {
    if (("NickName".equals(paramlu.a)) && (!a(paramlu.b, params.e)))
    {
      params.e = af.b(paramlu.b);
      return true;
    }
    if (("BrandIconURL".equals(paramlu.a)) && (!a(paramlu.b, params.g)))
    {
      params.g = paramlu.b;
      return true;
    }
    if (("BigHeadImgUrl".equals(paramlu.a)) && (!a(paramlu.b, params.i)))
    {
      params.i = paramlu.b;
      return true;
    }
    if (("SmallHeadImgUrl".equals(paramlu.a)) && (!a(paramlu.b, params.j)))
    {
      params.j = paramlu.b;
      return true;
    }
    if (("Signature".equals(paramlu.a)) && (!a(paramlu.b, params.k)))
    {
      params.k = paramlu.b;
      return true;
    }
    if ("WxAppOpt".equals(paramlu.a))
    {
      int i = af.a(paramlu.b, 0);
      if (i != params.l)
      {
        params.l = i;
        return true;
      }
    }
    if (("RegisterSource".equals(paramlu.a)) && (!a(paramlu.b, params.m)))
    {
      params.m = paramlu.b;
      return true;
    }
    if (("WxaAppInfo".equals(paramlu.a)) && (!a(paramlu.b, params.n))) {
      params.n = paramlu.b;
    }
    try
    {
      paramlu = new JSONObject(paramlu.b);
      params.d = paramlu.getString("Appid");
      params.h = paramlu.getString("RoundedSquareIconUrl");
      params.f = paramlu.optString("ShortNickName");
      return true;
    }
    catch (Exception params) {}
    if (("WxaAppVersionInfo".equalsIgnoreCase(paramlu.a)) && (!a(paramlu.b, params.o)))
    {
      params.o = paramlu.b;
      return true;
    }
    if (("BindWxaInfo".equals(paramlu.a)) && (!a(paramlu.b, params.q)))
    {
      params.q = paramlu.b;
      return true;
    }
    if (("WxaAppDynamic".equals(paramlu.a)) && (!a(paramlu.b, params.r)))
    {
      params.r = paramlu.b;
      return true;
    }
    if (("MMBizMenu".equals(paramlu.a)) && (!a(paramlu.b, params.v)))
    {
      params.v = paramlu.b;
      return true;
    }
    if (("PassThroughInfo".equals(paramlu.a)) && (!a(paramlu.a, params.p)))
    {
      params.p = paramlu.b;
      return true;
    }
    return false;
    return true;
  }
  
  public final boolean a(s params, boolean paramBoolean)
  {
    params.b = params.c.hashCode();
    boolean bool = false;
    super.a(params, false);
    if (a(params.c, new String[] { "appId" }) != null) {
      bool = true;
    }
    if ((bool) && (paramBoolean) && (!TextUtils.isEmpty(params.c))) {
      a("single", 2, params.c);
    }
    return bool;
  }
  
  public final boolean a(s params, boolean paramBoolean, String... paramVarArgs)
  {
    if (!af.a(paramVarArgs))
    {
      int i = 0;
      while (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("username"))
        {
          paramVarArgs[i] = "usernameHash";
          params.b = params.c.hashCode();
          break;
        }
        i += 1;
      }
    }
    boolean bool = super.a(params, false, paramVarArgs);
    if ((bool) && (paramBoolean) && (!TextUtils.isEmpty(params.c))) {
      a("single", 3, params.c);
    }
    return bool;
  }
  
  public boolean a(s params, String... paramVarArgs)
  {
    if (!af.a(paramVarArgs))
    {
      int i = 0;
      while (i < paramVarArgs.length)
      {
        if (paramVarArgs[i].equals("username"))
        {
          paramVarArgs[i] = "usernameHash";
          params.b = params.c.hashCode();
          break;
        }
        i += 1;
      }
    }
    return super.a(params, paramVarArgs);
  }
  
  public boolean a(ai paramai)
  {
    return a(paramai, null);
  }
  
  public boolean a(@NonNull ai paramai, @Nullable List<String> paramList)
  {
    long l = a();
    LinkedList localLinkedList = new LinkedList();
    paramai = paramai.a.iterator();
    boolean bool1 = false;
    while (paramai.hasNext())
    {
      lx locallx = (lx)paramai.next();
      o.d("MicroMsg.WxaAttrStorage", "batchSyncInGroup flushAttrs(%s)", new Object[] { locallx.a });
      boolean bool2 = bool1 | a(locallx.a, locallx.b, locallx.c, false);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(locallx.a))
        {
          localLinkedList.add(locallx.a);
          bool1 = bool2;
        }
      }
    }
    a(l);
    if (localLinkedList.size() > 0)
    {
      if (paramList != null) {
        paramList.addAll(localLinkedList);
      }
      a("batch", 3, localLinkedList);
    }
    return bool1;
  }
  
  public boolean a(String paramString, com.tencent.luggage.wxa.qu.b paramb, List<lu> paramList)
  {
    return a(paramString, paramb, paramList, true);
  }
  
  public boolean a(String paramString, lv paramlv)
  {
    if (TextUtils.isEmpty(paramString))
    {
      o.b("MicroMsg.WxaAttrStorage", "updateAttrsByUsernameWithProto username EMPTY");
      return false;
    }
    return a(paramString, paramlv.a, paramlv.b);
  }
  
  public s b(String paramString, String... paramVarArgs)
  {
    boolean bool = af.c(paramString);
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    Object localObject2 = this.a;
    String str = b();
    if (af.a(paramVarArgs)) {
      paramVarArgs = null;
    }
    localObject2 = ((com.tencent.luggage.wxa.rb.b)localObject2).b(str, paramVarArgs, String.format(Locale.US, "%s=?", new Object[] { "appId" }), new String[] { paramString }, null, null, null, 2);
    if (localObject2 == null)
    {
      o.b("MicroMsg.WxaAttrStorage", "queryWithAppId(%s) null==cursor", new Object[] { paramString });
      return null;
    }
    if (((Cursor)localObject2).moveToFirst())
    {
      paramVarArgs = new s();
      paramVarArgs.a((Cursor)localObject2);
      paramVarArgs.d = paramString;
      paramString = paramVarArgs;
    }
    else
    {
      o.b("MicroMsg.WxaAttrStorage", "queryWithAppId(%s) !cursor.moveToFirst()", new Object[] { paramString });
      paramString = localObject1;
    }
    ((Cursor)localObject2).close();
    return paramString;
  }
  
  public boolean b(s params, boolean paramBoolean, String... paramVarArgs)
  {
    if (!af.c(params.c)) {
      params.b = params.c.hashCode();
    }
    boolean bool = super.b(params, false, paramVarArgs);
    if ((bool) && (paramBoolean) && (!TextUtils.isEmpty(params.c))) {
      a("single", 5, params.c);
    }
    return bool;
  }
  
  public boolean b(String paramString, lv paramlv)
  {
    String str = a(paramString);
    Object localObject2 = str;
    if (TextUtils.isEmpty(str))
    {
      localObject2 = paramlv.b.iterator();
      do
      {
        localObject1 = str;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (lu)((Iterator)localObject2).next();
      } while (!"UserName".equalsIgnoreCase(((lu)localObject1).a));
      Object localObject1 = ((lu)localObject1).b;
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        o.b("MicroMsg.WxaAttrStorage", "updateAttrsWithProto appId=%s, username EMPTY", new Object[] { paramString });
        return false;
      }
    }
    return a((String)localObject2, paramlv.a, paramlv.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.r
 * JD-Core Version:    0.7.0.1
 */