package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.annotation.API;

@API
public class TargetDownloadInfo
{
  @API
  public final String hash;
  @API
  public final long size;
  @API
  public final String url;
  
  public TargetDownloadInfo(String paramString1, String paramString2, long paramLong)
  {
    this.url = paramString1;
    this.hash = paramString2;
    this.size = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.TargetDownloadInfo
 * JD-Core Version:    0.7.0.1
 */