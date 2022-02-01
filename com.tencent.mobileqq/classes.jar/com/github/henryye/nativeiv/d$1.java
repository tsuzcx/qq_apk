package com.github.henryye.nativeiv;

import java.util.concurrent.ThreadFactory;

class d$1
  implements ThreadFactory
{
  d$1(d paramd) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "native_image_decode_net");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.d.1
 * JD-Core Version:    0.7.0.1
 */