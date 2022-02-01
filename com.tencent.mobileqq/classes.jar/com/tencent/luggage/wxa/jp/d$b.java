package com.tencent.luggage.wxa.jp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

class d$b
  implements Runnable
{
  d$b(d paramd) {}
  
  public void run()
  {
    ScheduledExecutorService localScheduledExecutorService = Executors.newScheduledThreadPool(4);
    while (d.a(this.a)) {
      try
      {
        Socket localSocket = d.b(this.a).accept();
        localScheduledExecutorService.submit(new d.a(this.a, localSocket));
      }
      catch (IOException localIOException)
      {
        label48:
        break label48;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.d.b
 * JD-Core Version:    0.7.0.1
 */