package com.tencent.beacon.core.network.volley;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Cache$Entry
{
  public List<Header> allResponseHeaders;
  public byte[] data;
  public String etag;
  public long lastModified;
  public Map<String, String> responseHeaders = Collections.emptyMap();
  public long serverDate;
  public long softTtl;
  public long ttl;
  
  public boolean isExpired()
  {
    return this.ttl < System.currentTimeMillis();
  }
  
  public boolean refreshNeeded()
  {
    return this.softTtl < System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.Cache.Entry
 * JD-Core Version:    0.7.0.1
 */