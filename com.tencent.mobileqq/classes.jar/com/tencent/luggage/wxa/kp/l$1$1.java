package com.tencent.luggage.wxa.kp;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;

class l$1$1
  implements c
{
  l$1$1(l.1 param1) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.a.b.a(this.a.c, this.a.d.b("ok"));
      return;
    }
    com.tencent.luggage.wxa.jx.c localc = this.a.b;
    paramInt = this.a.c;
    l locall = this.a.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail:");
    localStringBuilder.append(paramString);
    localc.a(paramInt, locall.b(localStringBuilder.toString()));
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      paramString2 = new HashMap();
      paramString2.put("tempImagePath", paramString1);
      paramString2.put("width", Integer.valueOf(paramInt2));
      paramString2.put("height", Integer.valueOf(paramInt3));
      this.a.b.a(this.a.c, this.a.d.a("ok", paramString2));
      return;
    }
    paramString1 = this.a.b;
    paramInt1 = this.a.c;
    l locall = this.a.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail:");
    localStringBuilder.append(paramString2);
    paramString1.a(paramInt1, locall.b(localStringBuilder.toString()));
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, long paramLong, int paramInt3, int paramInt4)
  {
    o.e("MicroMsg.JsApiOperateCamera", "onStopRecord ret %d, thumbPath %s,tempVideoPath %s,duration %d,size %d,width %d,height %d", new Object[] { Integer.valueOf(paramInt1), paramString2, paramString3, Integer.valueOf(paramInt2), Long.valueOf(paramLong), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (paramInt1 == 0)
    {
      paramString1 = new HashMap();
      paramString1.put("tempThumbPath", paramString2);
      paramString1.put("tempVideoPath", paramString3);
      paramString1.put("duration", Integer.valueOf(paramInt2));
      paramString1.put("size", Long.valueOf(paramLong));
      paramString1.put("height", Integer.valueOf(paramInt4));
      paramString1.put("width", Integer.valueOf(paramInt3));
      this.a.b.a(this.a.c, this.a.d.a("ok", paramString1));
      return;
    }
    paramString2 = this.a.b;
    paramInt1 = this.a.c;
    paramString3 = this.a.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fail:");
    localStringBuilder.append(paramString1);
    paramString2.a(paramInt1, paramString3.b(localStringBuilder.toString()));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!af.c(paramString))
    {
      com.tencent.luggage.wxa.jx.c localc = this.a.b;
      paramInt1 = this.a.c;
      l locall = this.a.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail:");
      localStringBuilder.append(paramString);
      localc.a(paramInt1, locall.b(localStringBuilder.toString()));
      return;
    }
    o.e("MicroMsg.JsApiOperateCamera", "onListenFrameChange bufferId:%d width:%d height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    paramString = new HashMap();
    paramString.put("bufferId", Integer.valueOf(paramInt1));
    paramString.put("width", Integer.valueOf(paramInt2));
    paramString.put("height", Integer.valueOf(paramInt3));
    this.a.b.a(this.a.c, this.a.d.a("ok", paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kp.l.1.1
 * JD-Core Version:    0.7.0.1
 */