package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.structs.c;

class b$7
  implements Runnable
{
  b$7(b paramb, c paramc) {}
  
  public void run()
  {
    if (b.d(this.b) != null) {
      b.d(this.b).setThreadPriority(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.b.7
 * JD-Core Version:    0.7.0.1
 */