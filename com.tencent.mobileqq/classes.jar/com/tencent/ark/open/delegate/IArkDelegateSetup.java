package com.tencent.ark.open.delegate;

import java.util.ArrayList;

public abstract class IArkDelegateSetup
{
  public ArrayList<String> onGetPredownloadApp()
  {
    return null;
  }
  
  public void reportEvent(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString4, String paramString5) {}
  
  public void setupArkEnvironment(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.delegate.IArkDelegateSetup
 * JD-Core Version:    0.7.0.1
 */