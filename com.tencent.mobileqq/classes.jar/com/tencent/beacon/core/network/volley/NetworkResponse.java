package com.tencent.beacon.core.network.volley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class NetworkResponse
{
  public final List<Header> allHeaders;
  public final byte[] data;
  public final Map<String, String> headers;
  public final long networkTimeMs;
  public final boolean notModified;
  public final int statusCode;
  
  private NetworkResponse(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, List<Header> paramList, boolean paramBoolean, long paramLong)
  {
    this.statusCode = paramInt;
    this.data = paramArrayOfByte;
    this.headers = paramMap;
    if (paramList == null) {}
    for (this.allHeaders = null;; this.allHeaders = Collections.unmodifiableList(paramList))
    {
      this.notModified = paramBoolean;
      this.networkTimeMs = paramLong;
      return;
    }
  }
  
  @Deprecated
  public NetworkResponse(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean)
  {
    this(paramInt, paramArrayOfByte, paramMap, paramBoolean, 0L);
  }
  
  @Deprecated
  public NetworkResponse(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    this(paramInt, paramArrayOfByte, paramMap, toAllHeaderList(paramMap), paramBoolean, paramLong);
  }
  
  public NetworkResponse(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean, long paramLong, List<Header> paramList)
  {
    this(paramInt, paramArrayOfByte, toHeaderMap(paramList), paramList, paramBoolean, paramLong);
  }
  
  public NetworkResponse(byte[] paramArrayOfByte)
  {
    this(200, paramArrayOfByte, false, 0L, Collections.emptyList());
  }
  
  @Deprecated
  public NetworkResponse(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this(200, paramArrayOfByte, paramMap, false, 0L);
  }
  
  private static List<Header> toAllHeaderList(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return null;
    }
    if (paramMap.isEmpty()) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList(paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localArrayList.add(new Header((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return localArrayList;
  }
  
  private static Map<String, String> toHeaderMap(List<Header> paramList)
  {
    if (paramList == null) {
      return null;
    }
    if (paramList.isEmpty()) {
      return Collections.emptyMap();
    }
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Header localHeader = (Header)paramList.next();
      localTreeMap.put(localHeader.getName(), localHeader.getValue());
    }
    return localTreeMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.NetworkResponse
 * JD-Core Version:    0.7.0.1
 */