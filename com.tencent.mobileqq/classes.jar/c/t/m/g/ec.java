package c.t.m.g;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONObject;

public final class ec
{
  public static int a = 0;
  private final ee b;
  private final ea c;
  private final eb d;
  
  public ec(ee paramee, ea paramea, eb parameb)
  {
    this.b = paramee;
    this.c = paramea;
    this.d = parameb;
  }
  
  private String a(int paramInt1, int paramInt2, String paramString, da paramda, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramda == null) {
      return null;
    }
    label641:
    for (;;)
    {
      try
      {
        String str1;
        String str2;
        String str3;
        db localdb;
        if (this.c == null)
        {
          bool = true;
          str1 = f.a.a(this.b);
          str2 = f.a.a(this.c, bool);
          str3 = f.a.a(this.d);
          localdb = paramda.i();
          if (localdb == null) {
            return null;
          }
        }
        else
        {
          if (a == this.c.e) {
            break label641;
          }
          bool = true;
          a = this.c.e;
          continue;
        }
        Object localObject = new HashMap();
        ((HashMap)localObject).put("imei", localdb.a());
        ((HashMap)localObject).put("imsi", localdb.b());
        ((HashMap)localObject).put("phonenum", f.a.c(localdb.e));
        ((HashMap)localObject).put("qq", f.a.c(localdb.g));
        ((HashMap)localObject).put("mac", localdb.c().toLowerCase(Locale.ENGLISH));
        localdb.a.c();
        String str4 = new JSONObject((Map)localObject).toString();
        String str6 = localdb.f();
        eq.a();
        int k = eq.a(paramda.a);
        String str5 = es.c(paramda);
        localObject = localdb.j;
        paramda = (da)localObject;
        if (localObject != null) {
          paramda = ((String)localObject).replace("\"", "");
        }
        localObject = paramda;
        if (paramda != null) {
          localObject = paramda.replace("|", "");
        }
        paramda = (String)localObject + "_" + localdb.i;
        int j = 203;
        int i = j;
        if (paramBoolean2)
        {
          localObject = localdb.a();
          i = j;
          if (localObject != null) {
            i = Math.abs(((String)localObject).hashCode()) % 1000 + 1001;
          }
        }
        localObject = "{\"version\":\"" + localdb.d() + "\",\"address\":" + paramInt1;
        paramda = (String)localObject + ",\"source\":" + i + ",\"access_token\":\"" + str6 + "\",\"app_name\":\"" + paramString + "\",\"app_label\":\"" + paramda + "\",\"bearing\":1";
        paramString = paramda;
        if (paramInt2 >= 0) {
          paramString = paramda + ",\"control\":" + paramInt2;
        }
        if ((paramBoolean1) && (!paramBoolean2))
        {
          paramString = paramString + ",\"detectgps\":1";
          paramString = paramString + ",\"pstat\":" + k;
          paramString = paramString + ",\"wlan\":" + str5;
          return paramString + ",\"attribute\":" + str4 + ",\"location\":" + str3 + ",\"cells\":" + str2 + ",\"wifis\":" + str1 + "}";
        }
        paramString = paramString + ",\"detectgps\":0";
        continue;
        boolean bool = false;
      }
      catch (Exception paramString)
      {
        return null;
      }
    }
  }
  
  private boolean b()
  {
    return this.c != null;
  }
  
  private boolean c()
  {
    return this.b != null;
  }
  
  public final int a(ec paramec)
  {
    if (paramec == null) {}
    do
    {
      return 0;
      if ((paramec.c()) && (c()) && (this.b.a(paramec.b))) {
        return 2;
      }
    } while ((paramec.c()) || (c()) || (!paramec.b()) || (!b()) || (!this.c.b().equalsIgnoreCase(paramec.c.b())));
    return 1;
  }
  
  @Nullable
  public final eb a()
  {
    return this.d;
  }
  
  public final String a(int paramInt, String paramString, da paramda, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2) {
      return a(paramInt, 1, paramString, paramda, paramBoolean1, paramBoolean3);
    }
    return a(paramInt, 0, paramString, paramda, paramBoolean1, paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ec
 * JD-Core Version:    0.7.0.1
 */