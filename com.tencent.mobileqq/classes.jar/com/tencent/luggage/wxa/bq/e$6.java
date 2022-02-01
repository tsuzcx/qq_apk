package com.tencent.luggage.wxa.bq;

import com.tencent.luggage.game.widget.input.WAGamePanelInputEditText;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.pp.x.e;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;

class e$6
  implements x.e
{
  e$6(e parame, WAGamePanelInputEditText paramWAGamePanelInputEditText, h paramh, com.tencent.luggage.game.widget.input.a parama, float paramFloat, int paramInt) {}
  
  public void a(int paramInt)
  {
    if (2 == paramInt)
    {
      e.c(this.f).a(this.a.getEditableText().toString(), this.b);
      return;
    }
    paramInt = this.c.getHeight();
    o.d("MicroMsg.WAGameJsApiShowKeyboard", "onVisibilityChanged inputPanelHeight(%d),density(%f).", new Object[] { Integer.valueOf(paramInt), Float.valueOf(this.d) });
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("height", Float.valueOf(paramInt / this.d));
    this.b.a(this.e, this.f.a("ok", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bq.e.6
 * JD-Core Version:    0.7.0.1
 */