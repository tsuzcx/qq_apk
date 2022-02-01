package com.tencent.luggage.wxa.nt;

import com.tencent.luggage.wxa.qz.o;

final class b$1
  extends b
{
  public d a(String paramString)
  {
    o.d("MicroMsg.Record.AudioEncodeFactory", "createEncodeByType:%s", new Object[] { paramString });
    if (!com.tencent.luggage.wxa.ns.a.a(paramString)) {
      return null;
    }
    if ("aac".equalsIgnoreCase(paramString)) {
      return new a();
    }
    if ("mp3".equalsIgnoreCase(paramString)) {
      return new e();
    }
    if ("wav".equalsIgnoreCase(paramString)) {
      return new g();
    }
    if ("pcm".equalsIgnoreCase(paramString)) {
      return new f();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nt.b.1
 * JD-Core Version:    0.7.0.1
 */