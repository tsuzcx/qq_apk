package com.tencent.hippy.qq.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;

@QAPI(process={"all"})
public abstract interface IHippyLibrary
  extends QRouteApi
{
  public abstract void downloadWhenSoInfoUpdated();
  
  public abstract long getCoreJsFileLength(String paramString);
  
  public abstract String getCoreJsFilePath(String paramString);
  
  public abstract int getHippyLibrayId();
  
  public abstract HashMap<String, String> getLibraryVersions();
  
  public abstract boolean isLibraryLoaded();
  
  public abstract boolean isLibrayExists();
  
  public abstract void loadLibraryIfNeed(LibraryLoadListener paramLibraryLoadListener);
  
  public abstract void preDownload();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.IHippyLibrary
 * JD-Core Version:    0.7.0.1
 */