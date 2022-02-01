package com.tencent.ark.open.delegate;

import java.io.File;
import java.util.HashMap;

public abstract class IArkDelegateNet
{
  public void download(String paramString, boolean paramBoolean1, boolean paramBoolean2, HashMap<String, String> paramHashMap, File paramFile, IArkDelegateNetCallback paramIArkDelegateNetCallback) {}
  
  public int getNetworkType()
  {
    return 0;
  }
  
  public boolean isNetworkAvailable()
  {
    return true;
  }
  
  public void sendAppMsg(String paramString1, String paramString2, int paramInt1, int paramInt2, IArkDelegateNetCallback paramIArkDelegateNetCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.delegate.IArkDelegateNet
 * JD-Core Version:    0.7.0.1
 */