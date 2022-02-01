package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource.Factory;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

@TargetApi(18)
public final class HttpMediaDrmCallback
  implements MediaDrmCallback
{
  private final HttpDataSource.Factory dataSourceFactory;
  private final String defaultLicenseUrl;
  private final boolean forceDefaultLicenseUrl;
  private final Map<String, String> keyRequestProperties;
  
  public HttpMediaDrmCallback(String paramString, HttpDataSource.Factory paramFactory)
  {
    this(paramString, false, paramFactory);
  }
  
  public HttpMediaDrmCallback(String paramString, boolean paramBoolean, HttpDataSource.Factory paramFactory)
  {
    this.dataSourceFactory = paramFactory;
    this.defaultLicenseUrl = paramString;
    this.forceDefaultLicenseUrl = paramBoolean;
    this.keyRequestProperties = new HashMap();
  }
  
  private static byte[] executePost(HttpDataSource.Factory paramFactory, String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    paramFactory = paramFactory.createDataSource();
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        paramFactory.setRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
    paramFactory = new DataSourceInputStream(paramFactory, new DataSpec(Uri.parse(paramString), paramArrayOfByte, 0L, 0L, -1L, null, 1));
    try
    {
      paramString = Util.toByteArray(paramFactory);
      Util.closeQuietly(paramFactory);
      return paramString;
    }
    finally
    {
      Util.closeQuietly(paramFactory);
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void clearAllKeyRequestProperties()
  {
    synchronized (this.keyRequestProperties)
    {
      this.keyRequestProperties.clear();
      return;
    }
  }
  
  public void clearKeyRequestProperty(String paramString)
  {
    Assertions.checkNotNull(paramString);
    synchronized (this.keyRequestProperties)
    {
      this.keyRequestProperties.remove(paramString);
      return;
    }
  }
  
  public byte[] executeKeyRequest(UUID arg1, ExoMediaDrm.KeyRequest paramKeyRequest)
  {
    String str1 = paramKeyRequest.getDefaultUrl();
    String str2;
    if (!this.forceDefaultLicenseUrl)
    {
      str2 = str1;
      if (!TextUtils.isEmpty(str1)) {}
    }
    else
    {
      str2 = this.defaultLicenseUrl;
    }
    HashMap localHashMap = new HashMap();
    if (C.PLAYREADY_UUID.equals(???)) {
      str1 = "text/xml";
    } else if (C.CLEARKEY_UUID.equals(???)) {
      str1 = "application/json";
    } else {
      str1 = "application/octet-stream";
    }
    localHashMap.put("Content-Type", str1);
    if (C.PLAYREADY_UUID.equals(???)) {
      localHashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
    }
    synchronized (this.keyRequestProperties)
    {
      localHashMap.putAll(this.keyRequestProperties);
      return executePost(this.dataSourceFactory, str2, paramKeyRequest.getData(), localHashMap);
    }
  }
  
  public byte[] executeProvisionRequest(UUID paramUUID, ExoMediaDrm.ProvisionRequest paramProvisionRequest)
  {
    paramUUID = new StringBuilder();
    paramUUID.append(paramProvisionRequest.getDefaultUrl());
    paramUUID.append("&signedRequest=");
    paramUUID.append(new String(paramProvisionRequest.getData()));
    paramUUID = paramUUID.toString();
    return executePost(this.dataSourceFactory, paramUUID, new byte[0], null);
  }
  
  public void setKeyRequestProperty(String paramString1, String paramString2)
  {
    Assertions.checkNotNull(paramString1);
    Assertions.checkNotNull(paramString2);
    synchronized (this.keyRequestProperties)
    {
      this.keyRequestProperties.put(paramString1, paramString2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.HttpMediaDrmCallback
 * JD-Core Version:    0.7.0.1
 */