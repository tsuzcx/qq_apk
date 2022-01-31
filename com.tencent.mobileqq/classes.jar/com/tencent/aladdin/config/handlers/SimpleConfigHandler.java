package com.tencent.aladdin.config.handlers;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.utils.Log;

public class SimpleConfigHandler
  implements AladdinConfigHandler
{
  private static final String TAG = "SimpleConfigHandler";
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    Log.d("SimpleConfigHandler", "onReceiveConfig: id=" + paramInt1 + ", version=" + paramInt2);
    if (Log.isDebugVersion()) {
      Log.d("SimpleConfigHandler", "onReceiveConfig: content=" + paramString);
    }
    return Aladdin.getConfig(paramInt1).update(paramString);
  }
  
  public void onWipeConfig(int paramInt)
  {
    Log.d("SimpleConfigHandler", "onWipeConfig: id=" + paramInt);
    Aladdin.getConfig(paramInt).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aladdin.config.handlers.SimpleConfigHandler
 * JD-Core Version:    0.7.0.1
 */