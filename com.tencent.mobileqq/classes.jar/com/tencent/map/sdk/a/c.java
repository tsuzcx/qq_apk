package com.tencent.map.sdk.a;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class c
{
  protected HashMap<String, HashMap<String, byte[]>> a = new HashMap();
  protected HashMap<String, Object> b = new HashMap();
  protected String c = "GBK";
  k d = new k();
  private HashMap<String, Object> e = new HashMap();
  
  private void a(ArrayList<String> paramArrayList, Object paramObject)
  {
    for (;;)
    {
      if (paramObject.getClass().isArray())
      {
        if (!paramObject.getClass().getComponentType().toString().equals("byte")) {
          throw new IllegalArgumentException("only byte[] is supported");
        }
        if (Array.getLength(paramObject) > 0)
        {
          paramArrayList.add("java.util.List");
          paramObject = Array.get(paramObject, 0);
        }
        else
        {
          paramArrayList.add("Array");
          paramArrayList.add("?");
        }
      }
      else
      {
        if ((paramObject instanceof Array)) {
          throw new IllegalArgumentException("can not support Array, please use List");
        }
        if ((paramObject instanceof List))
        {
          paramArrayList.add("java.util.List");
          paramObject = (List)paramObject;
          if (paramObject.size() > 0) {
            paramObject = paramObject.get(0);
          } else {
            paramArrayList.add("?");
          }
        }
        else
        {
          if (!(paramObject instanceof Map)) {
            break label221;
          }
          paramArrayList.add("java.util.Map");
          Object localObject = (Map)paramObject;
          if (((Map)localObject).size() <= 0) {
            break;
          }
          localObject = ((Map)localObject).get(((Map)localObject).keySet().iterator().next());
          paramArrayList.add(a(paramObject));
          paramObject = localObject;
        }
      }
    }
    paramArrayList.add("?");
    paramArrayList.add("?");
    return;
    label221:
    paramArrayList.add(a(paramObject));
  }
  
  public <T> T a(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    String str1 = null;
    if (!this.a.containsKey(paramString)) {
      return null;
    }
    if (this.e.containsKey(paramString)) {
      return this.e.get(paramString);
    }
    Object localObject2 = (HashMap)this.a.get(paramString);
    Object localObject1 = new byte[0];
    localObject2 = ((HashMap)localObject2).entrySet().iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      str1 = (String)((Map.Entry)localObject1).getKey();
      localObject1 = (byte[])((Map.Entry)localObject1).getValue();
    }
    for (;;)
    {
      try
      {
        String str2 = m.a(str1);
        localObject2 = str1;
        if (str2 != null)
        {
          localObject2 = str1;
          if (!"".equals(str2)) {
            localObject2 = str2;
          }
        }
        if (this.b.containsKey(localObject2))
        {
          paramClassLoader = this.b.get(localObject2);
          this.d.a((byte[])localObject1);
          this.d.a(this.c);
          paramClassLoader = this.d.a(paramClassLoader, 0, true);
          this.e.put(paramString, paramClassLoader);
          return paramClassLoader;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        throw new b(paramString);
      }
      paramClassLoader = a.a((String)localObject2, paramBoolean, paramClassLoader);
      this.b.put(localObject2, paramClassLoader);
    }
  }
  
  public <T> String a(T paramT)
  {
    String str1 = "";
    if ((paramT instanceof n)) {
      str1 = ((n)paramT).className();
    }
    String str2 = str1;
    if ("".equals(str1)) {
      str2 = paramT.getClass().getName();
    }
    return str2;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public <T> void a(String paramString, T paramT)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("put key can not is null");
    }
    if (paramT == null) {
      throw new IllegalArgumentException("put value can not is null");
    }
    if ((paramT instanceof Set)) {
      throw new IllegalArgumentException("can not support Set");
    }
    Object localObject = new l();
    ((l)localObject).a(this.c);
    ((l)localObject).a(paramT, 0);
    localObject = o.a(((l)localObject).a);
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    a(localArrayList, paramT);
    localHashMap.put(a.a(localArrayList), localObject);
    this.e.remove(paramString);
    this.a.put(paramString, localHashMap);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.d.a(paramArrayOfByte);
    this.d.a(this.c);
    paramArrayOfByte = new HashMap(1);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("", new byte[0]);
    paramArrayOfByte.put("", localHashMap);
    this.a = this.d.a(paramArrayOfByte, 0, false);
  }
  
  public byte[] a()
  {
    l locall = new l(0);
    locall.a(this.c);
    locall.a(this.a, 0);
    return o.a(locall.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.c
 * JD-Core Version:    0.7.0.1
 */