package com.tencent.luggage.wxa.iu;

import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import java.nio.ByteBuffer;

class j$1
  extends x
{
  j$1(j paramj) {}
  
  public int a()
  {
    if (j.a(this.a) != null) {
      return j.a(this.a).r();
    }
    return 0;
  }
  
  public ByteBuffer a(int paramInt)
  {
    if (j.a(this.a) != null) {
      return j.a(this.a).a(paramInt, false);
    }
    return null;
  }
  
  public void a(int paramInt, String paramString)
  {
    j.b(this.a).getJsRuntime().evaluateJavascript(String.format("typeof WeixinWorker.workerMsgHandler !== 'undefined' && WeixinWorker.workerMsgHandler(%d, %s);", new Object[] { Integer.valueOf(paramInt), paramString }), null);
  }
  
  public void a(int paramInt, ByteBuffer paramByteBuffer)
  {
    if (j.a(this.a) != null) {
      j.a(this.a).a(paramInt, paramByteBuffer);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (j.a(this.a) != null) {
      j.a(this.a).a(paramLong1, paramLong2);
    }
  }
  
  public boolean b()
  {
    if (j.a(this.a) != null) {
      return j.a(this.a).p();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.j.1
 * JD-Core Version:    0.7.0.1
 */