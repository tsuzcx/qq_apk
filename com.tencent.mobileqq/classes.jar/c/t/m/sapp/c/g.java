package c.t.m.sapp.c;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
{
  public static void a(Context paramContext)
  {
    b(paramContext);
    Object localObject1 = c(paramContext);
    Object localObject5 = q.e(q.a(paramContext, "__SP_Tencent_Loc_COMP_INFO__sapp_", ""));
    Object localObject2;
    int i;
    Object localObject3;
    Object localObject4;
    Object localObject6;
    if ((localObject1 != null) && (((List)localObject1).size() != 0) && (((List)localObject5).size() != 0))
    {
      localObject2 = ((List)localObject5).iterator();
      i = 1;
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (a)((Iterator)localObject2).next();
        localObject4 = ((List)localObject1).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject6 = ((String)((Iterator)localObject4).next()).split(",");
          if ((localObject6.length == 3) && (((a)localObject3).c.equals(localObject6[0])) && (String.valueOf(((a)localObject3).d).equals(localObject6[1])) && (((a)localObject3).e.equals(localObject6[2])))
          {
            j = 1;
            break label180;
          }
        }
        j = 0;
        label180:
        if (j == 0) {
          i = 0;
        }
      }
    }
    int j = 0;
    if (j != 0)
    {
      localObject1 = new byte[2048];
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramContext.getFilesDir().getAbsolutePath());
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(q.b);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramContext.getFilesDir().getAbsolutePath());
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("TencentLocation_sapp/lastComp");
      localObject4 = ((StringBuilder)localObject3).toString();
      localObject6 = new ArrayList();
      Iterator localIterator = ((List)localObject5).iterator();
      i = 0;
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        localObject3 = new File((String)localObject4, locala.c);
        if (((File)localObject3).exists())
        {
          localObject3 = q.a((File)localObject3);
          if (locala.e.equals(localObject3)) {}
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(File.separator);
          ((StringBuilder)localObject3).append(locala.c);
          String str1 = ((StringBuilder)localObject3).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("tmp__sapp");
          ((StringBuilder)localObject3).append(locala.c);
          String str2 = ((StringBuilder)localObject3).toString();
          j = locala.d;
          localObject3 = localObject1;
          if (!q.b(paramContext, str1, (String)localObject4, str2, j, (byte[])localObject3)) {
            break label501;
          }
          ((List)localObject6).add(locala);
        }
        continue;
        label501:
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject4);
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append("tmp__sapp");
        ((StringBuilder)localObject1).append(locala.c);
        localObject1 = new File(((StringBuilder)localObject1).toString());
        if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
          ((File)localObject1).delete();
        }
        localObject1 = localObject3;
        i = 1;
      }
      if (i != 0)
      {
        paramContext = ((List)localObject6).iterator();
        while (paramContext.hasNext())
        {
          localObject1 = (a)paramContext.next();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject4);
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append("tmp__sapp");
          ((StringBuilder)localObject2).append(((a)localObject1).c);
          localObject1 = new File(((StringBuilder)localObject2).toString());
          if ((((File)localObject1).exists()) && (((File)localObject1).isFile())) {
            ((File)localObject1).delete();
          }
        }
      }
      if (((List)localObject5).size() == ((List)localObject6).size())
      {
        localObject1 = ((List)localObject6).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          localObject3 = new File((String)localObject4, ((a)localObject2).c);
          if ((((File)localObject3).exists()) && (((File)localObject3).isFile())) {
            ((File)localObject3).delete();
          }
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("tmp__sapp");
          ((StringBuilder)localObject5).append(((a)localObject2).c);
          new File((String)localObject4, ((StringBuilder)localObject5).toString()).renameTo((File)localObject3);
        }
        q.b(paramContext, "__SP_LAST_TencentLoc_COMP_INFO__sapp_", q.a((List)localObject6));
        q.b(paramContext, "__SP_LAST_TencentLoc_COMP_SDK_VER__sapp_", h.a);
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), "TencentLocation_sapp/lastComp");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
  }
  
  public static List<String> c(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), q.b);
    if ((paramContext.exists()) && (paramContext.isDirectory()))
    {
      File[] arrayOfFile = paramContext.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        ArrayList localArrayList = new ArrayList();
        int j = arrayOfFile.length;
        int i = 0;
        for (;;)
        {
          paramContext = localArrayList;
          if (i >= j) {
            break;
          }
          paramContext = arrayOfFile[i];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramContext.getName());
          localStringBuilder.append(",");
          localStringBuilder.append(paramContext.length());
          localStringBuilder.append(",");
          localStringBuilder.append(q.a(paramContext));
          localArrayList.add(localStringBuilder.toString());
          i += 1;
        }
      }
    }
    paramContext = null;
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.g
 * JD-Core Version:    0.7.0.1
 */