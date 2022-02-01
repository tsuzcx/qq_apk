package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.LibraryLoadListener;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import java.io.File;
import java.util.HashMap;

public class HippyLibraryImpl
  implements IHippyLibrary
{
  public void downloadWhenSoInfoUpdated()
  {
    HippyQQLibraryManager.getInstance().downloadWhenSoInfoUpdated();
  }
  
  public long getCoreJsFileLength(String paramString)
  {
    paramString = HippyQQLibraryManager.getInstance().getCoreJsFilePath(paramString);
    if (paramString != null)
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        return paramString.length();
      }
    }
    return -1L;
  }
  
  public String getCoreJsFilePath(String paramString)
  {
    return HippyQQLibraryManager.getInstance().getCoreJsFilePath(paramString);
  }
  
  public int getHippyLibrayId()
  {
    return HippyQQLibraryManager.getInstance().getHippyLibrayId();
  }
  
  public HashMap<String, String> getLibraryVersions()
  {
    return HippyQQLibraryManager.getInstance().getLibraryVersions();
  }
  
  public boolean isLibraryLoaded()
  {
    return HippyQQLibraryManager.getInstance().isLibraryLoaded();
  }
  
  public boolean isLibrayExists()
  {
    return HippyQQLibraryManager.getInstance().isLibrayExists();
  }
  
  public void loadLibraryIfNeed(LibraryLoadListener paramLibraryLoadListener)
  {
    HippyQQLibraryManager.getInstance().loadLibraryIfNeed(paramLibraryLoadListener);
  }
  
  public void preDownload()
  {
    HippyQQLibraryManager.getInstance().downloadSo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.HippyLibraryImpl
 * JD-Core Version:    0.7.0.1
 */