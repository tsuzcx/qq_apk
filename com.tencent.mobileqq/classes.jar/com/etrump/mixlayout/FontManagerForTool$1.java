package com.etrump.mixlayout;

import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class FontManagerForTool$1
  implements EIPCResultCallback
{
  FontManagerForTool$1(FontManagerForTool paramFontManagerForTool) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      FontManagerForTool.a(this.a);
      this.a.notifyObservers(Integer.valueOf(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.FontManagerForTool.1
 * JD-Core Version:    0.7.0.1
 */