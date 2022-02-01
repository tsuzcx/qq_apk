package c.t.m.sapp.c;

import android.content.Context;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h
{
  public static String a = "6.7.6";
  public static h b;
  public Context c;
  public List<a> d = new ArrayList();
  
  public h(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static h a(Context paramContext)
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new h(paramContext);
        }
      }
      finally {}
    }
    return b;
  }
  
  public List<a> a(String paramString)
  {
    paramString = q.e(q.a(this.c, paramString, ""));
    if (paramString.size() == 0) {
      e.a(this.c).a("DLC", "localComp parse error");
    }
    return paramString;
  }
  
  public boolean a()
  {
    c();
    Object localObject1 = a;
    String str = q.a(this.c, "__Tencent_Cover_SDK_Version__sapp_", "");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("cv:");
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append((String)localObject1);
    j.a(((StringBuilder)localObject2).toString());
    localObject2 = e.a(this.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_");
    localStringBuilder.append((String)localObject1);
    ((e)localObject2).a("DCV", localStringBuilder.toString());
    if (!((String)localObject1).equals(str))
    {
      System.currentTimeMillis();
      if (!l.d(this.c))
      {
        j.a("copy to private dir failed");
        return false;
      }
      q.b(this.c, "__Tencent_Cover_SDK_Version__sapp_", (String)localObject1);
      q.b(this.c, "__pro_dex_load_info___sapp", "default");
      q.b(this.c, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.c.getFilesDir().getAbsolutePath());
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("TencentLocation_sapp/UpCp");
      q.a(((StringBuilder)localObject1).toString());
      return true;
    }
    return false;
  }
  
  public boolean a(boolean paramBoolean, List<a> paramList, String paramString)
  {
    paramString = new File(this.c.getFilesDir(), paramString);
    paramString = q.a(this.c, paramString);
    if ((paramString != null) && (paramString.size() != 0) && (paramList.size() != 0))
    {
      Object localObject1 = q.a(this.c, "__bad_dex_info___sapp", "preference_default_sapp");
      Object localObject2 = q.e((String)localObject1);
      if ((!((String)localObject1).equals("preference_default_sapp")) && (!((List)localObject2).isEmpty()) && (l.a(paramList, (List)localObject2))) {
        return false;
      }
      paramList = paramList.iterator();
      paramBoolean = true;
      while (paramList.hasNext())
      {
        localObject1 = (a)paramList.next();
        localObject2 = paramString.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String[] arrayOfString = ((String)((Iterator)localObject2).next()).split(",");
          if ((arrayOfString.length == 3) && (((a)localObject1).c.equals(arrayOfString[0])) && (String.valueOf(((a)localObject1).d).equals(arrayOfString[1])) && (((a)localObject1).e.equals(arrayOfString[2])))
          {
            i = 1;
            break label232;
          }
        }
        int i = 0;
        label232:
        if (i == 0) {
          paramBoolean = false;
        }
      }
      return paramBoolean;
    }
    j.a("private dir files is empty");
    e.a(this.c).a("DLC", "localComp file error");
    return false;
  }
  
  public DexClassLoader b()
  {
    a();
    if (l.b(this.c) == 6) {
      l.c(this.c);
    }
    if (!a(true, a("__SP_Tencent_Loc_COMP_INFO__sapp_"), q.b)) {
      d();
    }
    List localList = a("__SP_Tencent_Loc_COMP_INFO__sapp_");
    return b.a(this.c).a(localList, q.b);
  }
  
  public final void c()
  {
    File localFile = new File(this.c.getFilesDir(), q.b);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    localFile = new File(this.c.getFilesDir(), q.c);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    l.a(this.c);
  }
  
  public void d()
  {
    e.a(this.c).a("DCR", "goback");
    if (!l.d(this.c)) {
      e.a(this.c).a("DCR", "copy from asset failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.h
 * JD-Core Version:    0.7.0.1
 */