package com.bumptech.glide.load.engine;

import android.os.Process;

class ActiveResources$2
  implements Runnable
{
  ActiveResources$2(ActiveResources paramActiveResources) {}
  
  public void run()
  {
    Process.setThreadPriority(10);
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.ActiveResources.2
 * JD-Core Version:    0.7.0.1
 */