package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.module.Monitor;

class a$4
  implements Runnable
{
  a$4(a parama) {}
  
  public void run()
  {
    if (this.a.mInit)
    {
      Monitor.a(2, String.format("VideoEncoder[%d]: Stop, streamType:%d", new Object[] { Integer.valueOf(this.a.hashCode()), Integer.valueOf(this.a.mStreamType) }), "streamType: 2-big, 3-small, 7-sub", 0);
      a.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.a.4
 * JD-Core Version:    0.7.0.1
 */