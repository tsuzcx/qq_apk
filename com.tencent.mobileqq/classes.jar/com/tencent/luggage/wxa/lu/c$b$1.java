package com.tencent.luggage.wxa.lu;

import android.hardware.SensorManager;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pd.h.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;

class c$b$1
  implements h.a
{
  c$b$1(c.b paramb, c paramc) {}
  
  public boolean a(Object... paramVarArgs)
  {
    o.f("MicroMsg.JsApiEnableCompass", "onAction.");
    paramVarArgs = new float[3];
    Object localObject = new float[9];
    SensorManager.getRotationMatrix((float[])localObject, null, c.b.a(this.b), c.b.b(this.b));
    SensorManager.getOrientation((float[])localObject, paramVarArgs);
    localObject = new HashMap();
    float f2 = (float)Math.toDegrees(paramVarArgs[0]);
    float f1 = f2;
    if (f2 < 0.0F) {
      f1 = f2 + 360.0F;
    }
    ((Map)localObject).put("direction", Float.valueOf(f1));
    if (c.b.c(this.b).equalsIgnoreCase("unknow"))
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append(c.b.c(this.b));
      paramVarArgs.append("{value:");
      paramVarArgs.append(c.b.d(this.b));
      paramVarArgs.append("}");
      ((Map)localObject).put("accuracy", paramVarArgs.toString());
    }
    else
    {
      ((Map)localObject).put("accuracy", c.b.c(this.b));
    }
    this.b.d.b((Map)localObject);
    return i.a().a(this.b.d, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.c.b.1
 * JD-Core Version:    0.7.0.1
 */