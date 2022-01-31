package com.tencent.feedback.eup;

import android.content.Context;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements Runnable
{
  private String a;
  private List<File> b;
  
  public a(Context paramContext, String paramString, List<File> paramList)
  {
    this.a = paramString;
    this.b = paramList;
  }
  
  public final void run()
  {
    x.c("rqdp{ run libs file record task }", new Object[0]);
    Object localObject3 = new ArrayList();
    if ((this.b != null) && (this.b.size() > 0)) {
      ((List)localObject3).addAll(this.b);
    }
    Object localObject1 = new File(this.a);
    int j;
    int i;
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles(new a.1(this));
      if (localObject1 != null)
      {
        j = localObject1.length;
        i = 0;
        while (i < j)
        {
          localObject2 = localObject1[i];
          if (!((List)localObject3).contains(localObject2)) {
            ((List)localObject3).add(localObject2);
          }
          i += 1;
        }
      }
    }
    Object localObject2 = p.a().a(1003, null, true);
    localObject1 = new ArrayList();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      if (((String)localEntry.getKey()).startsWith("sosha1_")) {
        try
        {
          ((List)localObject1).add(z.a((byte[])localEntry.getValue(), PlugInBean.CREATOR));
        }
        catch (Throwable localThrowable2)
        {
          localThrowable2.printStackTrace();
        }
      }
    }
    localObject2 = new HashMap();
    Object localObject4 = ((List)localObject1).iterator();
    Object localObject6;
    while (((Iterator)localObject4).hasNext())
    {
      PlugInBean localPlugInBean = (PlugInBean)((Iterator)localObject4).next();
      try
      {
        localObject6 = localPlugInBean.a.split("#")[0];
        ((Map)localObject2).put(localObject6, new PlugInBean((String)localObject6, localPlugInBean.b, localPlugInBean.c));
      }
      catch (Throwable localThrowable3)
      {
        localThrowable3.printStackTrace();
      }
    }
    if (((Map)localObject2).size() > 0) {
      com.tencent.bugly.crashreport.common.info.a.b().a((Map)localObject2);
    }
    localObject2 = new ArrayList();
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (File)((Iterator)localObject3).next();
      Object localObject5 = ((List)localObject1).iterator();
      i = 0;
      long l1;
      long l2;
      for (;;)
      {
        for (;;)
        {
          j = i;
          if (((Iterator)localObject5).hasNext()) {
            j = i;
          }
          try
          {
            localObject6 = (PlugInBean)((Iterator)localObject5).next();
            j = i;
            String[] arrayOfString = ((PlugInBean)localObject6).a.split("#", 3);
            String str = arrayOfString[0];
            j = i;
            l1 = Long.parseLong(arrayOfString[1]);
            j = i;
            l2 = Long.parseLong(arrayOfString[2]);
            j = i;
            if (((File)localObject4).getAbsolutePath().equals(str))
            {
              j = i;
              if (((File)localObject4).lastModified() == Long.valueOf(l2).longValue())
              {
                j = i;
                if (((File)localObject4).length() == Long.valueOf(l1).longValue())
                {
                  j = i;
                  if (((PlugInBean)localObject6).c != null)
                  {
                    j = i;
                    ((Iterator)localObject5).remove();
                    j = i;
                    ((List)localObject2).add(localObject6);
                    j = 1;
                    i = 1;
                    x.c("rqdp{  BufFB existed n:}%s ,ar:%s, md:%s", new Object[] { ((PlugInBean)localObject6).a, ((PlugInBean)localObject6).b, ((PlugInBean)localObject6).c });
                    j = i;
                    if (j != 0) {
                      break;
                    }
                    l1 = System.currentTimeMillis();
                    localObject5 = z.a((File)localObject4, "SHA-1");
                    l2 = System.currentTimeMillis();
                    if (localObject5 == null) {
                      break label779;
                    }
                    localObject6 = ((File)localObject4).getAbsolutePath();
                    l1 = ((File)localObject4).length();
                    l2 = ((File)localObject4).lastModified();
                    localObject4 = new PlugInBean((String)localObject6 + "#" + l1 + "#" + l2, com.tencent.bugly.crashreport.common.info.a.b().q(), (String)localObject5);
                    x.c("rqdp{  BufFB new }plugid:%s , plugtype:%s , plugsha1:%s", new Object[] { ((PlugInBean)localObject4).a, ((PlugInBean)localObject4).b, ((PlugInBean)localObject4).c });
                    ((List)localObject2).add(localObject4);
                  }
                }
              }
            }
          }
          catch (Throwable localThrowable4)
          {
            if (!x.a(localThrowable4)) {
              localThrowable4.printStackTrace();
            }
            i = j;
          }
        }
      }
      label779:
      x.c("rqdp{  Error BufFB md fail! pth:}%s , rqdp{  cs:}%d", new Object[] { ((File)localObject4).getAbsolutePath(), Long.valueOf(l2 - l1) });
    }
    p.a().a(1003, null, null, true);
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (PlugInBean)((Iterator)localObject1).next();
      p.a().a(1003, "sosha1_" + ((PlugInBean)localObject3).c, z.a((Parcelable)localObject3), null, true);
    }
    localObject1 = new HashMap();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (PlugInBean)((Iterator)localObject2).next();
      try
      {
        localObject4 = localObject3.a.split("#")[0];
        ((Map)localObject1).put(localObject4, new PlugInBean((String)localObject4, ((PlugInBean)localObject3).b, ((PlugInBean)localObject3).c));
      }
      catch (Throwable localThrowable1)
      {
        localThrowable1.printStackTrace();
      }
    }
    com.tencent.bugly.crashreport.common.info.a.b().a((Map)localObject1);
    x.c("rqdp{ libs file record task finished }", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.feedback.eup.a
 * JD-Core Version:    0.7.0.1
 */