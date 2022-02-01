package com.tencent.luggage.wxa.be;

import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.kp.h;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class a$3
  implements d.c
{
  a$3(a parama) {}
  
  public void a()
  {
    o.c("MicroMsg.AppBrandCameraView", "InitErrorCallback");
    Object localObject = new HashMap();
    ((Map)localObject).put("cameraId", Integer.valueOf(a.f(this.a)));
    localObject = new JSONObject((Map)localObject).toString();
    new h().b(a.g(this.a)).b((String)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.a.3
 * JD-Core Version:    0.7.0.1
 */