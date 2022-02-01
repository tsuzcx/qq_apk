package com.tencent.luggage.wxa.su;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class h
{
  private static Map<String, g> a = new HashMap();
  
  public static g a(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      return (g)a.get(paramString);
    }
    return null;
  }
  
  private static h.a a(File paramFile)
  {
    if (paramFile == null)
    {
      Log.e("XWalkPluginMgr", "getPluginInfoFromDir dirFile is null");
      return null;
    }
    if ((paramFile.exists()) && (paramFile.isDirectory()))
    {
      Object localObject = paramFile.getName();
      int i = ((String)localObject).lastIndexOf('_');
      if ((i >= 0) && (i < ((String)localObject).length() - 1))
      {
        paramFile = ((String)localObject).substring(0, i);
        localObject = ((String)localObject).substring(i + 1);
        try
        {
          paramFile = new h.a(paramFile, Integer.parseInt((String)localObject));
          return paramFile;
        }
        catch (Exception paramFile)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getPluginInfoFromDir error: ");
          ((StringBuilder)localObject).append(paramFile.getMessage());
          Log.e("XWalkPluginMgr", ((StringBuilder)localObject).toString());
          return null;
        }
      }
      Log.e("XWalkPluginMgr", "getPluginInfoFromDir can not find _");
      return null;
    }
    Log.e("XWalkPluginMgr", "getPluginInfoFromDir dirFile is invalid");
    return null;
  }
  
  public static boolean a()
  {
    if (a.size() == 0)
    {
      Log.i("XWalkPluginMgr", "initPlugins");
      Object localObject = new c();
      a.put(((c)localObject).a(), localObject);
      localObject = new e();
      a.put(((e)localObject).a(), localObject);
      localObject = new f();
      a.put(((f)localObject).a(), localObject);
      localObject = new n();
      a.put(((n)localObject).a(), localObject);
      localObject = new b();
      a.put(((b)localObject).a(), localObject);
      localObject = new d();
      a.put(((m)localObject).a(), localObject);
    }
    return true;
  }
  
  public static List<g> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Map.Entry)localIterator.next()).getValue());
    }
    return localArrayList;
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      g localg = (g)((Map.Entry)localIterator.next()).getValue();
      if (localg != null)
      {
        localStringBuilder.append(localg.a());
        localStringBuilder.append(" = ");
        localStringBuilder.append(localg.e());
        localStringBuilder.append(", ");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void d()
  {
    if (a.size() == 0)
    {
      Log.e("XWalkPluginMgr", "checkFiles error, sPluginMap size is 0");
      return;
    }
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((g)((Map.Entry)localIterator.next()).getValue()).d();
    }
  }
  
  public static void e()
  {
    if (a.size() == 0)
    {
      Log.e("XWalkPluginMgr", "clearOldVersions error, sPluginMap size is 0");
      return;
    }
    Object localObject1 = XWalkEnvironment.getPluginBaseDir();
    if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
    {
      localObject1 = new File((String)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int m = localObject1.length;
        int i = 0;
        while (i < m)
        {
          File localFile = localObject1[i];
          if (localFile != null)
          {
            Object localObject2 = a(localFile);
            if (localObject2 == null)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("clearOldVersions can not get plugin info, delete ");
              ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
              Log.e("XWalkPluginMgr", ((StringBuilder)localObject2).toString());
              com.tencent.xweb.util.c.b(localFile.getAbsolutePath());
            }
            else
            {
              g localg = (g)a.get(h.a.a((h.a)localObject2));
              if (localg == null)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("clearOldVersions invalid plugin info, delete ");
                ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
                Log.e("XWalkPluginMgr", ((StringBuilder)localObject2).toString());
                com.tencent.xweb.util.c.b(localFile.getAbsolutePath());
              }
              else
              {
                int k = localg.e();
                int j = k;
                if (k < 0) {
                  j = localg.a(true);
                }
                if (j < 0)
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("clearOldVersions can not get availableVersion, skip ");
                  ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
                  Log.e("XWalkPluginMgr", ((StringBuilder)localObject2).toString());
                }
                else if (h.a.b((h.a)localObject2) < j)
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("clearOldVersions is old version, delete ");
                  ((StringBuilder)localObject2).append(localFile.getAbsolutePath());
                  Log.i("XWalkPluginMgr", ((StringBuilder)localObject2).toString());
                  com.tencent.xweb.util.c.b(localFile.getAbsolutePath());
                }
              }
            }
          }
          i += 1;
        }
        return;
      }
      Log.i("XWalkPluginMgr", "clearOldVersions, dir is empty, return");
      return;
    }
    Log.e("XWalkPluginMgr", "clearOldVersions clear other, pluginBaseDir is null, return");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.h
 * JD-Core Version:    0.7.0.1
 */