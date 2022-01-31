package com.qq.jce.wup;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OldUniAttribute
{
  protected HashMap<String, HashMap<String, byte[]>> _data = new HashMap();
  JceInputStream _is = new JceInputStream();
  protected HashMap<String, Object> cachedClassName = new HashMap();
  private HashMap<String, Object> cachedData = new HashMap();
  protected String encodeName = "GBK";
  
  private void checkObjectType(ArrayList<String> paramArrayList, Object paramObject)
  {
    if (paramObject.getClass().isArray())
    {
      if (!paramObject.getClass().getComponentType().toString().equals("byte")) {
        throw new IllegalArgumentException("only byte[] is supported");
      }
      if (Array.getLength(paramObject) > 0)
      {
        paramArrayList.add("java.util.List");
        checkObjectType(paramArrayList, Array.get(paramObject, 0));
        return;
      }
      paramArrayList.add("Array");
      paramArrayList.add("?");
      return;
    }
    if ((paramObject instanceof Array)) {
      throw new IllegalArgumentException("can not support Array, please use List");
    }
    if ((paramObject instanceof List))
    {
      paramArrayList.add("java.util.List");
      paramObject = (List)paramObject;
      if (paramObject.size() > 0)
      {
        checkObjectType(paramArrayList, paramObject.get(0));
        return;
      }
      paramArrayList.add("?");
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramArrayList.add("java.util.Map");
      Object localObject = (Map)paramObject;
      if (((Map)localObject).size() > 0)
      {
        paramObject = ((Map)localObject).keySet().iterator().next();
        localObject = ((Map)localObject).get(paramObject);
        paramArrayList.add(paramObject.getClass().getName());
        checkObjectType(paramArrayList, localObject);
        return;
      }
      paramArrayList.add("?");
      paramArrayList.add("?");
      return;
    }
    paramArrayList.add(paramObject.getClass().getName());
  }
  
  private Object getCacheProxy(String paramString)
  {
    if (this.cachedClassName.containsKey(paramString)) {
      return this.cachedClassName.get(paramString);
    }
    Object localObject = BasicClassTypeUtil.createClassByUni(paramString);
    this.cachedClassName.put(paramString, localObject);
    return localObject;
  }
  
  private void saveDataCache(String paramString, Object paramObject)
  {
    this.cachedData.put(paramString, paramObject);
  }
  
  public void clearCacheData()
  {
    this.cachedData.clear();
  }
  
  public boolean containsKey(String paramString)
  {
    return this._data.containsKey(paramString);
  }
  
  public void decode(byte[] paramArrayOfByte)
  {
    this._is.wrap(paramArrayOfByte);
    this._is.setServerEncoding(this.encodeName);
    paramArrayOfByte = new HashMap(1);
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("", new byte[0]);
    paramArrayOfByte.put("", localHashMap);
    this._data = this._is.readMap(paramArrayOfByte, 0, false);
  }
  
  public byte[] encode()
  {
    JceOutputStream localJceOutputStream = new JceOutputStream(0);
    localJceOutputStream.setServerEncoding(this.encodeName);
    localJceOutputStream.write(this._data, 0);
    return JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
  }
  
  public <T> T get(String paramString)
  {
    Object localObject2 = null;
    if (!this._data.containsKey(paramString)) {
      return null;
    }
    if (this.cachedData.containsKey(paramString)) {
      return this.cachedData.get(paramString);
    }
    Object localObject1 = ((HashMap)this._data.get(paramString)).entrySet().iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = (String)((Map.Entry)localObject1).getKey();
    }
    for (localObject1 = (byte[])((Map.Entry)localObject1).getValue();; localObject1 = new byte[0]) {
      try
      {
        localObject2 = getCacheProxy((String)localObject2);
        this._is.wrap((byte[])localObject1);
        this._is.setServerEncoding(this.encodeName);
        localObject1 = this._is.read(localObject2, 0, true);
        saveDataCache(paramString, localObject1);
        return localObject1;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        throw new ObjectCreateException(paramString);
      }
    }
  }
  
  public <T> T get(String paramString, Object paramObject)
  {
    if (!this._data.containsKey(paramString)) {
      return paramObject;
    }
    if (this.cachedData.containsKey(paramString)) {
      return this.cachedData.get(paramString);
    }
    Object localObject1 = ((HashMap)this._data.get(paramString)).entrySet().iterator();
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = (String)((Map.Entry)localObject1).getKey();
      localObject1 = (byte[])((Map.Entry)localObject1).getValue();
    }
    for (;;)
    {
      try
      {
        localObject2 = getCacheProxy((String)localObject2);
        this._is.wrap((byte[])localObject1);
        this._is.setServerEncoding(this.encodeName);
        localObject1 = this._is.read(localObject2, 0, true);
        saveDataCache(paramString, localObject1);
        return localObject1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        saveDataCache(paramString, paramObject);
        return paramObject;
      }
      byte[] arrayOfByte = new byte[0];
      localObject2 = "";
    }
  }
  
  public String getEncodeName()
  {
    return this.encodeName;
  }
  
  public <T> T getJceStruct(String paramString)
  {
    if (!this._data.containsKey(paramString)) {
      return null;
    }
    if (this.cachedData.containsKey(paramString)) {
      return this.cachedData.get(paramString);
    }
    Object localObject1 = ((HashMap)this._data.get(paramString)).entrySet().iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localObject1 = (String)((Map.Entry)localObject2).getKey();
    }
    for (Object localObject2 = (byte[])((Map.Entry)localObject2).getValue();; localObject2 = new byte[0])
    {
      try
      {
        localObject1 = getCacheProxy((String)localObject1);
        this._is.wrap((byte[])localObject2);
        this._is.setServerEncoding(this.encodeName);
        localObject1 = this._is.directRead((JceStruct)localObject1, 0, true);
        saveDataCache(paramString, localObject1);
        return localObject1;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        throw new ObjectCreateException(paramString);
      }
      localObject1 = null;
    }
  }
  
  public Set<String> getKeySet()
  {
    return Collections.unmodifiableSet(this._data.keySet());
  }
  
  public boolean isEmpty()
  {
    return this._data.isEmpty();
  }
  
  public <T> void put(String paramString, T paramT)
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
    Object localObject = new JceOutputStream();
    ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
    ((JceOutputStream)localObject).write(paramT, 0);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    HashMap localHashMap = new HashMap(1);
    ArrayList localArrayList = new ArrayList(1);
    checkObjectType(localArrayList, paramT);
    localHashMap.put(BasicClassTypeUtil.transTypeList(localArrayList), localObject);
    this.cachedData.remove(paramString);
    this._data.put(paramString, localHashMap);
  }
  
  public <T> T remove(String paramString)
  {
    if (!this._data.containsKey(paramString)) {
      return null;
    }
    paramString = ((HashMap)this._data.remove(paramString)).entrySet().iterator();
    Object localObject;
    if (paramString.hasNext())
    {
      paramString = (Map.Entry)paramString.next();
      localObject = (String)paramString.getKey();
      paramString = (byte[])paramString.getValue();
    }
    for (;;)
    {
      try
      {
        localObject = BasicClassTypeUtil.createClassByUni((String)localObject);
        this._is.wrap(paramString);
        this._is.setServerEncoding(this.encodeName);
        paramString = this._is.read(localObject, 0, true);
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        throw new ObjectCreateException(paramString);
      }
      paramString = new byte[0];
      localObject = "";
    }
  }
  
  public void setEncodeName(String paramString)
  {
    this.encodeName = paramString;
  }
  
  public int size()
  {
    return this._data.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.jce.wup.OldUniAttribute
 * JD-Core Version:    0.7.0.1
 */