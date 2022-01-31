package com.tencent.aladdin.config;

import com.tencent.aladdin.config.utils.Log;
import java.io.File;

class AladdinConfig$2
  implements Runnable
{
  AladdinConfig$2(AladdinConfig paramAladdinConfig) {}
  
  public void run()
  {
    try
    {
      boolean bool = AladdinConfig.access$000(this.this$0).delete();
      Log.i("AladdinConfig", "clear: deleteResult = " + bool);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        Log.e("AladdinConfig", "clear: " + localException.getMessage());
      } while (!Log.isDebugVersion());
      Log.e("AladdinConfig", "clear: " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.aladdin.config.AladdinConfig.2
 * JD-Core Version:    0.7.0.1
 */