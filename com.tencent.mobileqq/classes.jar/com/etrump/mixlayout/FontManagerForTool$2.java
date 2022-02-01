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
    int i = paramEIPCResult.data.getInt("font_type");
    boolean bool = false;
    if (i != 1)
    {
      if (i == 4) {
        bool = FontManagerForTool.b(this.a, false);
      }
    }
    else {
      bool = FontManagerForTool.a(this.a, false);
    }
    if (bool)
    {
      FontManagerForTool.b(this.a);
      this.a.notifyObservers(Integer.valueOf(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.FontManagerForTool.2
 * JD-Core Version:    0.7.0.1
 */