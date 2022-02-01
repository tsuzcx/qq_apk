package com.tencent.mobileqq.ark.core;

import com.tencent.ark.open.delegate.IArkDelegateSetup;
import java.util.ArrayList;

final class ArkMultiProc$2
  implements IArkDelegateSetup
{
  public ArrayList<String> getPredownloadApp()
  {
    return null;
  }
  
  public void setupArkEnvironment(boolean paramBoolean)
  {
    ArkEnvironment.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkMultiProc.2
 * JD-Core Version:    0.7.0.1
 */