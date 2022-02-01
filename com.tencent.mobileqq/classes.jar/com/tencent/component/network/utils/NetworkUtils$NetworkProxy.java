package com.tencent.component.network.utils;

import android.text.TextUtils;

public class NetworkUtils$NetworkProxy
  implements Cloneable
{
  public final String host;
  public final int port;
  
  NetworkUtils$NetworkProxy(String paramString, int paramInt)
  {
    this.host = paramString;
    this.port = paramInt;
  }
  
  final NetworkProxy copy()
  {
    try
    {
      NetworkProxy localNetworkProxy = (NetworkProxy)clone();
      return localNetworkProxy;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof NetworkProxy)))
    {
      paramObject = (NetworkProxy)paramObject;
      if ((TextUtils.equals(this.host, paramObject.host)) && (this.port == paramObject.port)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.host);
    localStringBuilder.append(":");
    localStringBuilder.append(this.port);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.NetworkUtils.NetworkProxy
 * JD-Core Version:    0.7.0.1
 */