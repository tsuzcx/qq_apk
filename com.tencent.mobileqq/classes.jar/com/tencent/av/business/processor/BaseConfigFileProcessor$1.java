package com.tencent.av.business.processor;

import com.tencent.mobileqq.utils.FileUtils;

class BaseConfigFileProcessor$1
  implements Runnable
{
  BaseConfigFileProcessor$1(BaseConfigFileProcessor paramBaseConfigFileProcessor, String paramString) {}
  
  public void run()
  {
    synchronized (BaseConfigFileProcessor.a(this.this$0))
    {
      FileUtils.writeFile(this.this$0.a(), this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.processor.BaseConfigFileProcessor.1
 * JD-Core Version:    0.7.0.1
 */