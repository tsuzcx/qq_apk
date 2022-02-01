package c.t.m.sapp.c;

import android.annotation.TargetApi;
import android.content.Context;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  public static b a;
  public Context b;
  public List<a> c = null;
  public String d = "";
  
  public b(Context paramContext)
  {
    this.b = paramContext;
    this.c = new ArrayList();
  }
  
  public static b a(Context paramContext)
  {
    if (a == null) {
      a = new b(paramContext);
    }
    return a;
  }
  
  @TargetApi(3)
  public final DexClassLoader a()
  {
    try
    {
      l.a(this.b);
      localObject1 = this.c;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        q.d = q.a(this.c);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.b.getFilesDir().getAbsolutePath());
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(this.d);
        Object localObject3 = ((StringBuilder)localObject1).toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.b.getFilesDir().getAbsolutePath());
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append(q.c);
        localObject5 = ((StringBuilder)localObject1).toString();
        localStringBuilder1 = new StringBuilder();
        localObject1 = this.c.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (a)((Iterator)localObject1).next();
          if (localObject4 != null)
          {
            localStringBuilder1.append((String)localObject3);
            localStringBuilder1.append(File.separator);
            localStringBuilder1.append(((a)localObject4).c);
            localStringBuilder1.append(File.pathSeparator);
          }
        }
        try
        {
          System.currentTimeMillis();
          localObject4 = new DexClassLoader(localStringBuilder1.toString(), (String)localObject5, null, getClass().getClassLoader());
          localObject1 = "";
          try
          {
            localObject6 = new File((String)localObject3);
            localObject3 = localObject1;
            if (((File)localObject6).exists())
            {
              localObject3 = localObject1;
              if (((File)localObject6).isDirectory())
              {
                localObject6 = ((File)localObject6).listFiles();
                localObject3 = localObject1;
                if (localObject6 != null)
                {
                  localObject3 = localObject1;
                  if (localObject6.length > 0)
                  {
                    int j = localObject6.length;
                    int i = 0;
                    for (;;)
                    {
                      localObject3 = localObject1;
                      if (i >= j) {
                        break;
                      }
                      localObject3 = localObject6[i];
                      StringBuilder localStringBuilder2 = new StringBuilder();
                      localStringBuilder2.append(((File)localObject3).getName());
                      localStringBuilder2.append(",");
                      localStringBuilder2.append(((File)localObject3).length());
                      localStringBuilder2.append(",");
                      localStringBuilder2.append(q.a((File)localObject3));
                      localObject3 = localStringBuilder2.toString();
                      localStringBuilder2 = new StringBuilder();
                      localStringBuilder2.append((String)localObject1);
                      localStringBuilder2.append((String)localObject3);
                      localStringBuilder2.append(";");
                      localObject1 = localStringBuilder2.toString();
                      i += 1;
                    }
                  }
                }
              }
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("before load ,private dir files:");
            ((StringBuilder)localObject1).append((String)localObject3);
            j.a(((StringBuilder)localObject1).toString());
            localObject1 = e.a(this.b);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("suc:");
            ((StringBuilder)localObject3).append(q.d);
            ((e)localObject1).a("CPL", ((StringBuilder)localObject3).toString());
            return localObject4;
          }
          catch (Exception localException1)
          {
            localObject1 = localObject4;
          }
          j.a("try once", localException2);
        }
        catch (Exception localException2)
        {
          localObject1 = null;
        }
        localObject4 = e.a(this.b);
        Object localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("fail:");
        ((StringBuilder)localObject6).append(q.d);
        ((StringBuilder)localObject6).append(",exc:");
        ((StringBuilder)localObject6).append(localException2.toString());
        ((e)localObject4).a("CPL", ((StringBuilder)localObject6).toString());
        l.a(this.b);
      }
    }
    finally
    {
      Object localObject1;
      Object localObject5;
      StringBuilder localStringBuilder1;
      Object localObject4;
      for (;;)
      {
        label682:
        label685:
        throw localObject2;
      }
    }
    try
    {
      System.currentTimeMillis();
      localObject4 = new DexClassLoader(localStringBuilder1.toString(), (String)localObject5, null, getClass().getClassLoader());
    }
    catch (Throwable localThrowable2)
    {
      break label685;
    }
    try
    {
      localObject1 = e.a(this.b);
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("suc:c");
      ((StringBuilder)localObject5).append(q.d);
      ((e)localObject1).a("CPL", ((StringBuilder)localObject5).toString());
      return localObject4;
    }
    catch (Throwable localThrowable1)
    {
      break label682;
    }
    localObject1 = localObject4;
    j.a("try once failed", localException2);
    return localObject1;
    return null;
  }
  
  public DexClassLoader a(List<a> paramList, String paramString)
  {
    this.c = paramList;
    this.d = paramString;
    int i = 0;
    paramList = null;
    for (;;)
    {
      int j = i + 1;
      paramString = paramList;
      if (i < 3) {
        try
        {
          paramString = a();
          paramList = paramString;
          locale = e.b();
          paramList = paramString;
          localStringBuilder = new StringBuilder();
          paramList = paramString;
          localStringBuilder.append("lcn:");
          paramList = paramString;
          localStringBuilder.append(j);
          paramList = paramString;
          locale.a("CPL", localStringBuilder.toString());
          if (paramString != null)
          {
            paramList = paramString;
            l.f(this.b);
            return paramString;
          }
          i = j;
          paramList = paramString;
        }
        catch (Throwable paramString)
        {
          e locale = e.b();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("fail:");
          localStringBuilder.append(paramString.toString());
          locale.a("CPL", localStringBuilder.toString());
          paramString = paramList;
        }
      }
    }
    l.f(this.b);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.b
 * JD-Core Version:    0.7.0.1
 */