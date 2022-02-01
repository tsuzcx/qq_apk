package com.tencent.mobileqq.activity.aio.voicetextpanel.model;

import java.util.concurrent.atomic.AtomicInteger;

public class VoiceTextSttState
{
  AtomicInteger a = new AtomicInteger(0);
  
  public void a(int paramInt)
  {
    this.a.set(paramInt);
  }
  
  public boolean a()
  {
    return this.a.get() == 1;
  }
  
  public boolean b()
  {
    return this.a.get() == 2;
  }
  
  public boolean c()
  {
    return this.a.get() == 4;
  }
  
  public boolean d()
  {
    return this.a.get() > 4;
  }
  
  public boolean e()
  {
    return this.a.get() > 1;
  }
  
  public boolean f()
  {
    return this.a.get() == 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextSttState
 * JD-Core Version:    0.7.0.1
 */