package com.tencent.hippy.qq.api.impl;

import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.LibraryLoadListener;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import java.util.HashMap;

public class HippyLibraryImpl
  implements IHippyLibrary
{
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
    HippyQQLibraryManager.getInstance().preDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.api.impl.HippyLibraryImpl
 * JD-Core Version:    0.7.0.1
 */