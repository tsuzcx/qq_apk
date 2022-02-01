package com.tencent.luggage.wxa.mu;

import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.iu.c.d;
import com.tencent.luggage.wxa.qz.o;

class a$1
  extends c.c
{
  a$1(a parama) {}
  
  public void a()
  {
    super.a();
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onCreate");
    a.a(this.a, false);
  }
  
  public void a(c.d paramd)
  {
    super.a(paramd);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPause, type: ");
    localStringBuilder.append(paramd);
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", localStringBuilder.toString());
    this.a.a(paramd);
  }
  
  public void b()
  {
    super.b();
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onResume");
    a.a(this.a);
  }
  
  public void c()
  {
    super.c();
    o.d("MicroMsg.AppBrand.AppBrandRuntimeAudioOfVideoBackgroundPlayManager", "onDestroy");
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mu.a.1
 * JD-Core Version:    0.7.0.1
 */