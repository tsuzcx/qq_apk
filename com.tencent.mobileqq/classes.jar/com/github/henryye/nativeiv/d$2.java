package com.github.henryye.nativeiv;

import java.util.concurrent.ThreadFactory;

class d$2
  implements ThreadFactory
{
  d$2(d paramd) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "native_image_decode_local");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.d.2
 * JD-Core Version:    0.7.0.1
 */