package com.tencent.luggage.wxa.oh;

import com.tencent.luggage.wxa.on.c.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;

class b$1
  implements c.c
{
  b$1(b paramb) {}
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    o.d("MicroMsg.ProxyOnPermissionUpdateListener", "onUpdate");
    paramArrayOfByte3 = new HashMap();
    paramArrayOfByte3.put("fg", paramArrayOfByte1);
    paramArrayOfByte3.put("bg", paramArrayOfByte2);
    this.a.a(paramArrayOfByte3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oh.b.1
 * JD-Core Version:    0.7.0.1
 */