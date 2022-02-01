package com.tencent.gamecenter.wadl.config;

import java.util.Iterator;
import java.util.List;

public class WadlConfigUtils
{
  public static int a()
  {
    FloatingPermissionConfBean localFloatingPermissionConfBean = FloatingPermissionConfProcessor.a();
    if (localFloatingPermissionConfBean != null) {
      return localFloatingPermissionConfBean.a;
    }
    return -1;
  }
  
  public static boolean a(String paramString)
  {
    Object localObject = FloatingPermissionConfProcessor.a();
    if (localObject == null) {
      return false;
    }
    localObject = ((FloatingPermissionConfBean)localObject).c;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((String)((Iterator)localObject).next()).equals(paramString)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean b()
  {
    FloatingPermissionConfBean localFloatingPermissionConfBean = FloatingPermissionConfProcessor.a();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localFloatingPermissionConfBean != null)
    {
      bool1 = bool2;
      if (localFloatingPermissionConfBean.b == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.config.WadlConfigUtils
 * JD-Core Version:    0.7.0.1
 */