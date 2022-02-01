package com.tencent.map.sdk.a;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  private static ClassLoader a;
  private static boolean b = true;
  
  public static Object a(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    Object localObject1 = new ArrayList();
    int i = paramString.indexOf("<");
    int m = 0;
    int j;
    while (m < i)
    {
      a((ArrayList)localObject1, paramString.substring(m, i));
      int n = i + 1;
      i = paramString.indexOf("<", n);
      int k = paramString.indexOf(",", n);
      j = i;
      if (i == -1) {
        j = k;
      }
      m = n;
      i = j;
      if (k != -1)
      {
        m = n;
        i = j;
        if (k < j)
        {
          i = k;
          m = n;
        }
      }
    }
    a((ArrayList)localObject1, paramString.substring(m, paramString.length()));
    Iterator localIterator = ((ArrayList)localObject1).iterator();
    localObject1 = null;
    paramString = null;
    String str1 = null;
    for (;;)
    {
      label140:
      if (!localIterator.hasNext()) {
        break label382;
      }
      Object localObject2 = b((String)localIterator.next(), paramBoolean, paramClassLoader);
      if ((localObject2 instanceof String))
      {
        String str2 = (String)localObject2;
        if ("Array".equals(str2))
        {
          localObject1 = localObject2;
          if (paramString != null) {
            continue;
          }
          localObject1 = Array.newInstance(Byte.class, 0);
          continue;
        }
        localObject1 = localObject2;
        if ("?".equals(str2)) {
          continue;
        }
        if (paramString == null) {}
      }
      else
      {
        do
        {
          str1 = paramString;
          break label372;
          boolean bool = localObject2 instanceof List;
          j = 1;
          if (bool)
          {
            if ((paramString != null) && ((paramString instanceof Byte)))
            {
              localObject1 = Array.newInstance(Byte.class, 1);
              Array.set(localObject1, 0, paramString);
              break label140;
            }
            if (paramString != null) {
              ((List)localObject2).add(paramString);
            }
            paramString = null;
            localObject1 = localObject2;
            break label140;
          }
          if ((localObject2 instanceof Map))
          {
            if (paramString != null) {
              i = 1;
            } else {
              i = 0;
            }
            if (str1 == null) {
              j = 0;
            }
            if ((i & j) != 0) {
              ((Map)localObject2).put(paramString, str1);
            }
            localObject1 = localObject2;
            break;
          }
        } while (paramString != null);
      }
      label372:
      paramString = localObject2;
      localObject1 = localObject2;
    }
    label382:
    return localObject1;
  }
  
  public static String a(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j;
    Object localObject;
    for (;;)
    {
      j = paramArrayList.size();
      localObject = "map";
      if (i >= j) {
        break;
      }
      String str = (String)paramArrayList.get(i);
      if ((!str.equals("java.lang.Integer")) && (!str.equals("int")))
      {
        if ((!str.equals("java.lang.Boolean")) && (!str.equals("boolean")))
        {
          if ((!str.equals("java.lang.Byte")) && (!str.equals("byte")))
          {
            if ((!str.equals("java.lang.Double")) && (!str.equals("double")))
            {
              if ((!str.equals("java.lang.Float")) && (!str.equals("float")))
              {
                if ((!str.equals("java.lang.Long")) && (!str.equals("long")))
                {
                  if ((!str.equals("java.lang.Short")) && (!str.equals("short")))
                  {
                    if (!str.equals("java.lang.Character"))
                    {
                      if (str.equals("java.lang.String")) {
                        localObject = "string";
                      } else if (str.equals("java.util.List")) {
                        localObject = "list";
                      } else if (!str.equals("java.util.Map")) {
                        localObject = str;
                      }
                    }
                    else {
                      throw new IllegalArgumentException("can not support java.lang.Character");
                    }
                  }
                  else {
                    localObject = "short";
                  }
                }
                else {
                  localObject = "int64";
                }
              }
              else {
                localObject = "float";
              }
            }
            else {
              localObject = "double";
            }
          }
          else {
            localObject = "char";
          }
        }
        else {
          localObject = "bool";
        }
      }
      else {
        localObject = "int32";
      }
      paramArrayList.set(i, localObject);
      i += 1;
    }
    Collections.reverse(paramArrayList);
    i = 0;
    while (i < paramArrayList.size())
    {
      localObject = (String)paramArrayList.get(i);
      if (((String)localObject).equals("list"))
      {
        j = i - 1;
        localObject = new StringBuilder("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      else if (((String)localObject).equals("map"))
      {
        j = i - 1;
        localObject = new StringBuilder("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        ((StringBuilder)localObject).append(",");
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      else if (((String)localObject).equals("Array"))
      {
        j = i - 1;
        localObject = new StringBuilder("<");
        ((StringBuilder)localObject).append((String)paramArrayList.get(j));
        paramArrayList.set(j, ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append((String)paramArrayList.get(0));
        ((StringBuilder)localObject).append(">");
        paramArrayList.set(0, ((StringBuilder)localObject).toString());
      }
      i += 1;
    }
    Collections.reverse(paramArrayList);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localStringBuffer.append((String)paramArrayList.next());
    }
    return localStringBuffer.toString();
  }
  
  private static void a(ArrayList<String> paramArrayList, String paramString)
  {
    int i = paramString.length();
    int j;
    do
    {
      j = i;
      if (paramString.charAt(i - 1) != '>') {
        break;
      }
      j = i - 1;
      i = j;
    } while (j != 0);
    String str = paramString.substring(0, j);
    if (str.equals("int32"))
    {
      paramString = "java.lang.Integer";
    }
    else if (str.equals("bool"))
    {
      paramString = "java.lang.Boolean";
    }
    else if (str.equals("char"))
    {
      paramString = "java.lang.Byte";
    }
    else if (str.equals("double"))
    {
      paramString = "java.lang.Double";
    }
    else if (str.equals("float"))
    {
      paramString = "java.lang.Float";
    }
    else if (str.equals("int64"))
    {
      paramString = "java.lang.Long";
    }
    else if (str.equals("short"))
    {
      paramString = "java.lang.Short";
    }
    else if (str.equals("string"))
    {
      paramString = "java.lang.String";
    }
    else if (str.equals("list"))
    {
      paramString = "java.util.List";
    }
    else
    {
      paramString = str;
      if (str.equals("map")) {
        paramString = "java.util.Map";
      }
    }
    paramArrayList.add(0, paramString);
  }
  
  private static Object b(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    if (paramString.equals("java.lang.Integer")) {
      return Integer.valueOf(0);
    }
    if (paramString.equals("java.lang.Boolean")) {
      return Boolean.FALSE;
    }
    if (paramString.equals("java.lang.Byte")) {
      return Byte.valueOf((byte)0);
    }
    if (paramString.equals("java.lang.Double")) {
      return Double.valueOf(0.0D);
    }
    if (paramString.equals("java.lang.Float")) {
      return Float.valueOf(0.0F);
    }
    if (paramString.equals("java.lang.Long")) {
      return Long.valueOf(0L);
    }
    if (paramString.equals("java.lang.Short")) {
      return Short.valueOf((short)0);
    }
    if (!paramString.equals("java.lang.Character"))
    {
      if (paramString.equals("java.lang.String")) {
        return "";
      }
      if (paramString.equals("java.util.List")) {
        return new ArrayList();
      }
      if (paramString.equals("java.util.Map")) {
        return new HashMap();
      }
      if (paramString.equals("Array")) {
        return "Array";
      }
      if (paramString.equals("?")) {
        return paramString;
      }
      if (paramClassLoader != null) {}
      try
      {
        paramString = Class.forName(paramString, paramBoolean, paramClassLoader);
        break label214;
        if (a != null) {
          paramString = Class.forName(paramString, b, a);
        } else {
          paramString = Class.forName(paramString);
        }
        label214:
        paramString = paramString.getConstructor(new Class[0]).newInstance(new Object[0]);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        throw new b(paramString);
      }
    }
    throw new IllegalArgumentException("can not support java.lang.Character");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */