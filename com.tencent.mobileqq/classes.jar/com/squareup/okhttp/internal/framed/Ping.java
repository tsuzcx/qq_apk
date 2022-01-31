package com.squareup.okhttp.internal.framed;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class Ping
{
  private final CountDownLatch latch = new CountDownLatch(1);
  private long received = -1L;
  private long sent = -1L;
  
  void cancel()
  {
    if ((this.received != -1L) || (this.sent == -1L)) {
      throw new IllegalStateException();
    }
    this.received = (this.sent - 1L);
    this.latch.countDown();
  }
  
  void receive()
  {
    if ((this.received != -1L) || (this.sent == -1L)) {
      throw new IllegalStateException();
    }
    this.received = System.nanoTime();
    this.latch.countDown();
  }
  
  public long roundTripTime()
  {
    this.latch.await();
    return this.received - this.sent;
  }
  
  public long roundTripTime(long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.latch.await(paramLong, paramTimeUnit)) {
      return this.received - this.sent;
    }
    return -2L;
  }
  
  void send()
  {
    if (this.sent != -1L) {
      throw new IllegalStateException();
    }
    this.sent = System.nanoTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.internal.framed.Ping
 * JD-Core Version:    0.7.0.1
 */