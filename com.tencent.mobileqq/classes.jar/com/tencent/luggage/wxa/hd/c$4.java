package com.tencent.luggage.wxa.hd;

import android.os.SystemClock;
import java.nio.charset.Charset;
import java.util.UUID;

final class c$4
  extends c.b
{
  c$4(c.a parama)
  {
    super(parama);
  }
  
  String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c.c());
    localStringBuilder.append('#');
    localStringBuilder.append(c.b());
    localStringBuilder.append('#');
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append('#');
    localStringBuilder.append(SystemClock.elapsedRealtimeNanos());
    return UUID.nameUUIDFromBytes(localStringBuilder.toString().getBytes(Charset.forName("UTF-8"))).toString();
  }
  
  void b() {}
  
  void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.4
 * JD-Core Version:    0.7.0.1
 */