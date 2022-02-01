package c.t.m.sapp.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class l
{
  public static void a(Context paramContext)
  {
    try
    {
      paramContext = new File(paramContext.getFilesDir(), q.c);
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      if ((paramContext.canRead()) && (paramContext.canWrite()) && (paramContext.canExecute()))
      {
        paramContext = e.b();
        paramContext.a("DMK", "ods:ok");
        return;
      }
      boolean bool1 = paramContext.setReadable(true);
      boolean bool2 = paramContext.setWritable(true);
      boolean bool3 = paramContext.setExecutable(true);
      e locale = e.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ods:");
      localStringBuilder.append(bool2);
      localStringBuilder.append("_");
      localStringBuilder.append(bool1);
      localStringBuilder.append("_");
      localStringBuilder.append(bool3);
      locale.a("DMK", localStringBuilder.toString());
      paramContext = paramContext.listFiles();
      if ((paramContext != null) && (paramContext.length > 0))
      {
        int i = 0;
        while (i < paramContext.length)
        {
          locale = paramContext[i];
          if ((locale.canRead()) && (locale.canWrite()) && (locale.canExecute()))
          {
            locale = e.b();
            locale.a("DMK", "ofs:ok");
          }
          else
          {
            bool1 = locale.setWritable(true);
            bool2 = locale.setReadable(true);
            bool3 = locale.setExecutable(true);
            locale = e.b();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("ofs:");
            localStringBuilder.append(bool1);
            localStringBuilder.append("_");
            localStringBuilder.append(bool2);
            localStringBuilder.append("_");
            localStringBuilder.append(bool3);
            locale.a("DMK", localStringBuilder.toString());
          }
          i += 1;
        }
      }
      return;
    }
    catch (Throwable paramContext)
    {
      locale = e.b();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("exp:");
      localStringBuilder.append(paramContext.toString());
      locale.a("DMK", localStringBuilder.toString());
    }
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        int i = ((ActivityManager.RunningAppProcessInfo)paramContext.next()).pid;
        if (i == paramInt) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      label47:
      break label47;
    }
    return false;
  }
  
  public static boolean a(List<a> paramList1, List<a> paramList2)
  {
    paramList1 = paramList1.iterator();
    boolean bool = true;
    while (paramList1.hasNext())
    {
      a locala1 = (a)paramList1.next();
      if (!locala1.c.contains(".dex"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(locala1.c);
        ((StringBuilder)localObject).append(".dex");
        locala1.c = ((StringBuilder)localObject).toString();
      }
      Object localObject = paramList2.iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala2 = (a)((Iterator)localObject).next();
        if (!locala2.c.contains(".dex"))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(locala2.c);
          localStringBuilder.append(".dex");
          locala2.c = localStringBuilder.toString();
        }
        if ((locala1.c.equals(locala2.c)) && (locala1.d == locala2.d) && (locala1.e.equals(locala2.e)))
        {
          i = 1;
          break label213;
        }
      }
      int i = 0;
      label213:
      if (i == 0) {
        bool = false;
      }
    }
    return bool;
  }
  
  public static int b(Context paramContext)
  {
    List localList = q.e(q.a(paramContext, "__SP_Tencent_Loc_COMP_INFO__sapp_", ""));
    int i = e(paramContext);
    if (i <= 3) {
      q.b(paramContext, "__pro_dex_load_info___sapp", "default");
    }
    if ((localList != null) && (!localList.equals("")))
    {
      paramContext = q.a(paramContext, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
      if ((paramContext != null) && (!paramContext.equals("")))
      {
        if (a(localList, q.e(paramContext)))
        {
          if (i <= 3) {
            return 2;
          }
          return 3;
        }
        if (i <= 3) {
          return 6;
        }
        return 5;
      }
      return 1;
    }
    return 0;
  }
  
  public static boolean c(Context paramContext)
  {
    if (!q.a(paramContext, "__SP_UPDATE_TencentLoc_COMP_SDK_VER__sapp_", "").equals(h.a)) {
      return false;
    }
    Object localObject1 = q.a(paramContext, "__SP_UPDATE_TencentLoc_COMP_INFO__sapp_", "");
    if ((localObject1 != null) && (!((String)localObject1).equals("")))
    {
      localObject1 = q.e((String)localObject1);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        Object localObject2 = q.a(paramContext, "__bad_dex_info___sapp", "preference_default_sapp");
        Object localObject3 = q.e((String)localObject2);
        if ((!((String)localObject2).equals("preference_default_sapp")) && (!((List)localObject3).isEmpty()) && (a((List)localObject1, (List)localObject3))) {
          return false;
        }
        Object localObject4 = new byte[2048];
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramContext.getFilesDir().getAbsolutePath());
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append(q.b);
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramContext.getFilesDir().getAbsolutePath());
        ((StringBuilder)localObject3).append(File.separator);
        ((StringBuilder)localObject3).append("TencentLocation_sapp/UpCp");
        Object localObject5 = ((StringBuilder)localObject3).toString();
        localObject3 = new ArrayList();
        Object localObject6 = ((List)localObject1).iterator();
        int i = 1;
        while (((Iterator)localObject6).hasNext())
        {
          Object localObject7 = (a)((Iterator)localObject6).next();
          Object localObject8 = new StringBuilder();
          ((StringBuilder)localObject8).append((String)localObject5);
          ((StringBuilder)localObject8).append(File.separator);
          ((StringBuilder)localObject8).append(((a)localObject7).c);
          localObject8 = ((StringBuilder)localObject8).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("tmp_backup__sapp");
          localStringBuilder.append(((a)localObject7).c);
          if (!q.b(paramContext, (String)localObject8, (String)localObject2, localStringBuilder.toString(), ((a)localObject7).d, (byte[])localObject4))
          {
            localObject8 = new StringBuilder();
            ((StringBuilder)localObject8).append((String)localObject2);
            ((StringBuilder)localObject8).append(File.separator);
            ((StringBuilder)localObject8).append("tmp_backup__sapp");
            ((StringBuilder)localObject8).append(((a)localObject7).c);
            localObject7 = new File(((StringBuilder)localObject8).toString());
            if ((((File)localObject7).exists()) && (((File)localObject7).isFile())) {
              ((File)localObject7).delete();
            }
            i = 0;
          }
          else
          {
            ((List)localObject3).add(localObject7);
          }
        }
        if (i == 0)
        {
          paramContext = ((List)localObject3).iterator();
          while (paramContext.hasNext())
          {
            localObject1 = (a)paramContext.next();
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append((String)localObject2);
            ((StringBuilder)localObject4).append(File.separator);
            ((StringBuilder)localObject4).append("tmp_backup__sapp");
            ((StringBuilder)localObject4).append(((a)localObject1).c);
            localObject1 = new File(((StringBuilder)localObject4).toString());
            if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
              ((File)localObject1).delete();
            }
          }
          ((List)localObject3).clear();
          return false;
        }
        if (((List)localObject1).size() == ((List)localObject3).size())
        {
          localObject1 = ((List)localObject3).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (a)((Iterator)localObject1).next();
            localObject5 = new File((String)localObject2, ((a)localObject4).c);
            if ((((File)localObject5).exists()) && (((File)localObject5).isFile())) {
              ((File)localObject5).delete();
            }
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("tmp_backup__sapp");
            ((StringBuilder)localObject6).append(((a)localObject4).c);
            new File((String)localObject2, ((StringBuilder)localObject6).toString()).renameTo((File)localObject5);
          }
          localObject1 = q.a((List)localObject3);
          q.b(paramContext, "__SP_Tencent_Loc_COMP_INFO__sapp_", (String)localObject1);
          e.a(paramContext).a("DBC", (String)localObject1);
          return true;
        }
        return false;
      }
      return false;
    }
    return false;
  }
  
  public static boolean d(Context paramContext)
  {
    String str = q.d(paramContext);
    if (!q.a(str)) {
      j.a("clear private dir failed");
    }
    Object localObject2 = new StringBuilder();
    Object localObject1 = "TencentLocationComp_sapp";
    ((StringBuilder)localObject2).append("TencentLocationComp_sapp");
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("comp_list");
    localObject2 = q.b(paramContext, ((StringBuilder)localObject2).toString());
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("base comp info:");
    ((StringBuilder)localObject3).append((String)localObject2);
    j.a(((StringBuilder)localObject3).toString());
    localObject2 = q.e((String)localObject2);
    Object localObject4 = new byte[2048];
    localObject3 = new ArrayList();
    Object localObject5 = ((List)localObject2).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      a locala = (a)((Iterator)localObject5).next();
      Object localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append((String)localObject1);
      ((StringBuilder)localObject6).append(File.separator);
      ((StringBuilder)localObject6).append(locala.c);
      localObject6 = ((StringBuilder)localObject6).toString();
      Object localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append(locala.c);
      ((StringBuilder)localObject7).append(".dex");
      locala.c = ((StringBuilder)localObject7).toString();
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append("tmp_asset__sapp");
      ((StringBuilder)localObject7).append(locala.c);
      localObject7 = ((StringBuilder)localObject7).toString();
      if (!q.a(paramContext, (String)localObject6, str, (String)localObject7, locala.d, (byte[])localObject4))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append((String)localObject7);
        localObject1 = new File(((StringBuilder)localObject1).toString());
        if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
          ((File)localObject1).delete();
        }
        i = 0;
        break label374;
      }
      ((ArrayList)localObject3).add(locala);
    }
    int i = 1;
    label374:
    if (i == 0)
    {
      paramContext = ((ArrayList)localObject3).iterator();
      while (paramContext.hasNext())
      {
        localObject1 = (a)paramContext.next();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(File.separator);
        ((StringBuilder)localObject2).append("tmp_asset__sapp");
        ((StringBuilder)localObject2).append(((a)localObject1).c);
        localObject1 = new File(((StringBuilder)localObject2).toString());
        if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
          ((File)localObject1).delete();
        }
      }
      return false;
    }
    if (((ArrayList)localObject3).size() == ((List)localObject2).size())
    {
      localObject1 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (a)((Iterator)localObject1).next();
        localObject4 = new File(str, ((a)localObject3).c);
        if ((((File)localObject4).exists()) && (((File)localObject4).isFile())) {
          ((File)localObject4).delete();
        }
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("tmp_asset__sapp");
        ((StringBuilder)localObject5).append(((a)localObject3).c);
        new File(str, ((StringBuilder)localObject5).toString()).renameTo((File)localObject4);
      }
      q.b(paramContext, "__SP_Tencent_Loc_COMP_INFO__sapp_", q.a((List)localObject2));
      return true;
    }
    return false;
  }
  
  public static int e(Context paramContext)
  {
    Object localObject = q.a(paramContext, "__pro_dex_load_info___sapp", "default");
    boolean bool = ((String)localObject).equals("default");
    int j = 1;
    if (bool) {
      return 1;
    }
    try
    {
      localObject = ((String)localObject).split("#");
      int i = j;
      if (localObject != null)
      {
        i = j;
        if (localObject.length > 0)
        {
          j = 0;
          int k;
          for (i = 1; j < localObject.length; i = k)
          {
            String[] arrayOfString = localObject[j];
            arrayOfString = arrayOfString.split("&");
            k = i;
            if (arrayOfString != null)
            {
              k = i;
              if (arrayOfString.length == 2)
              {
                String str = arrayOfString[1];
                bool = a(paramContext, Integer.parseInt(arrayOfString[0]));
                k = i;
                if (bool) {
                  k = 0;
                }
              }
            }
            j += 1;
          }
        }
      }
      if (i != 0) {
        return 3;
      }
    }
    catch (Exception paramContext)
    {
      label139:
      break label139;
    }
    return 4;
  }
  
  public static void f(Context paramContext)
  {
    String str = q.e(paramContext);
    if (str == null) {
      return;
    }
    int n = q.g();
    Object localObject1 = q.a(paramContext, "__pro_dex_load_info___sapp", "default");
    if (((String)localObject1).equals("default"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(n);
      ((StringBuilder)localObject1).append("&");
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("#");
      q.b(paramContext, "__pro_dex_load_info___sapp", ((StringBuilder)localObject1).toString());
      return;
    }
    try
    {
      Object localObject2 = ((String)localObject1).split("#");
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int m = 0;
        int j = 0;
        int k;
        Object localObject3;
        for (int i = 0; j < localObject2.length; i = k)
        {
          localObject1 = localObject2[j].split("&");
          k = i;
          if (localObject1 != null)
          {
            k = i;
            if (localObject1.length == 2)
            {
              localObject3 = localObject1[1];
              Integer.parseInt(localObject1[0]);
              k = i;
              if (str.equals(localObject3))
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(n);
                ((StringBuilder)localObject1).append("&");
                ((StringBuilder)localObject1).append(str);
                localObject2[j] = ((StringBuilder)localObject1).toString();
                k = 1;
              }
            }
          }
          j += 1;
        }
        localObject1 = "";
        j = m;
        while (j < localObject2.length)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(localObject2[j]);
          ((StringBuilder)localObject3).append("#");
          localObject1 = ((StringBuilder)localObject3).toString();
          j += 1;
        }
        localObject2 = localObject1;
        if (i == 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(n);
          ((StringBuilder)localObject2).append("&");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("#");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
        q.b(paramContext, "__pro_dex_load_info___sapp", (String)localObject2);
      }
      return;
    }
    catch (Exception paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.l
 * JD-Core Version:    0.7.0.1
 */