package com.etrump.mixlayout;

import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class FontManagerForTool$2
  implements EIPCResultCallback
{
  FontManagerForTool$2(FontManagerForTool paramFontManagerForTool) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (paramEIPCResult.data.getInt("font_type"))
    {
    default: 
      bool1 = bool2;
    }
    for (;;)
    {
      if (bool1)
      {
        FontManagerForTool.b(this.a);
        this.a.notifyObservers(Integer.valueOf(1));
      }
      return;
      bool1 = FontManagerForTool.a(this.a, false);
      continue;
      bool1 = FontManagerForTool.b(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.FontManagerForTool.2
 * JD-Core Version:    0.7.0.1
 */