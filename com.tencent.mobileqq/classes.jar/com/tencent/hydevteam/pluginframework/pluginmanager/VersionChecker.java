package com.tencent.hydevteam.pluginframework.pluginmanager;

import com.tencent.hydevteam.common.annotation.API;

@API
public abstract interface VersionChecker
{
  @API
  public static final String SOURCE_BACKUP_LATEST = "SOURCE_BACKUP_LATEST";
  @API
  public static final String SOURCE_BACKUP_STABLE = "SOURCE_BACKUP_STABLE";
  @API
  public static final String SOURCE_CGI = "SOURCE_CGI";
  
  @API
  public abstract TargetDownloadInfo check(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws VersionCheckException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.VersionChecker
 * JD-Core Version:    0.7.0.1
 */