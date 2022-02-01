package com.tencent.biz.richframework.download;

import android.content.SharedPreferences;

public abstract class RFWDownloadStrategy
{
  public abstract String getBusinessKey();
  
  public abstract String getDownloadRootPath();
  
  public abstract SharedPreferences getSP();
  
  public abstract boolean supportBreakPointDownload();
  
  public abstract boolean supportUnZipFile();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloadStrategy
 * JD-Core Version:    0.7.0.1
 */