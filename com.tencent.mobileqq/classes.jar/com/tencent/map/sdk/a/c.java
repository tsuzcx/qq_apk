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
        if (paramObject.getClass().getComponentType().toString().equals("byte"))
        {
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
        else {
          throw new IllegalArgumentException("only byte[] is supported");
        }
      }
      else
      {
        if ((paramObject instanceof Array)) {
          break label222;
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
            break label211;
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
    label211:
    paramArrayList.add(a(paramObject));
    return;
    label222:
    paramArrayList = new IllegalArgumentException("can not support Array, please use List");
    for (;;)
    {
      throw paramArrayList;
    }
  }
  
  public <T> T a(String paramString, boolean paramBoolean, ClassLoader paramClassLoader)
  {
    boolean bool = this.a.containsKey(paramString);
    Object localObject1 = null;
    if (!bool) {
      return null;
    }
    if (this.e.containsKey(paramString)) {
      return this.e.get(paramString);
    }
    Object localObject3 = (HashMap)this.a.get(paramString);
    Object localObject2 = new byte[0];
    localObject3 = ((HashMap)localObject3).entrySet().iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject3).next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (byte[])((Map.Entry)localObject2).getValue();
    }
    for (;;)
    {
      try
      {
        localObject3 = m.a((String)localObject1);
        if ((localObject3 != null) && (!"".equals(localObject3)))
        {
          localObject1 = localObject3;
          if (this.b.containsKey(localObject1))
          {
            paramClassLoader = this.b.get(localObject1);
          }
          else
          {
            paramClassLoader = a.a((String)localObject1, paramBoolean, paramClassLoader);
            this.b.put(localObject1, paramClassLoader);
          }
          this.d.a((byte[])localObject2);
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
    }
  }
  
  public <T> String a(T paramT)
  {
    String str1;
    if ((paramT instanceof n)) {
      str1 = ((n)paramT).className();
    } else {
      str1 = "";
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
    if (paramString != null)
    {
      if (paramT != null)
      {
        if (!(paramT instanceof Set))
        {
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
          return;
        }
        throw new IllegalArgumentException("can not support Set");
      }
      throw new IllegalArgumentException("put value can not is null");
    }
    throw new IllegalArgumentException("put key can not is null");
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