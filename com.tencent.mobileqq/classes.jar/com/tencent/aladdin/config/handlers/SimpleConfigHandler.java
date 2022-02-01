package com.tencent.aladdin.config.handlers;

import android.support.annotation.CallSuper;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.utils.Log;

public class SimpleConfigHandler
  implements AladdinConfigHandler
{
  private static final String TAG = "SimpleConfigHandler";
  
  @CallSuper
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveConfig: id=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", version=");
    localStringBuilder.append(paramInt2);
    Log.d("SimpleConfigHandler", localStringBuilder.toString());
    if (Log.isDebugVersion())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveConfig: content=");
      localStringBuilder.append(paramString);
      Log.d("SimpleConfigHandler", localStringBuilder.toString());
    }
    return Aladdin.getConfig(paramInt1).update(paramString);
  }
  
  @CallSuper
  public void onWipeConfig(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onWipeConfig: id=");
    localStringBuilder.append(paramInt);
    Log.d("SimpleConfigHandler", localStringBuilder.toString());
    Aladdin.getConfig(paramInt).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.handlers.SimpleConfigHandler
 * JD-Core Version:    0.7.0.1
 */