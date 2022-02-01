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
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("clear: deleteResult = ");
      localStringBuilder1.append(bool);
      Log.i("AladdinConfig", localStringBuilder1.toString());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("clear: ");
      localStringBuilder2.append(localException.getMessage());
      Log.e("AladdinConfig", localStringBuilder2.toString());
      if (Log.isDebugVersion())
      {
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("clear: ");
        localStringBuilder2.append(localException);
        Log.e("AladdinConfig", localStringBuilder2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.AladdinConfig.2
 * JD-Core Version:    0.7.0.1
 */