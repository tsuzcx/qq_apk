package com.tencent.luggage.wxa.f;

import java.util.concurrent.atomic.AtomicBoolean;

class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public void run()
  {
    if (b.a(this.a).get())
    {
      f.b("MicroMsg.Camera1", "takePicture, cancel focus => takePictureInternal");
      b.a(this.a).set(false);
      this.a.q();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.b.3
 * JD-Core Version:    0.7.0.1
 */