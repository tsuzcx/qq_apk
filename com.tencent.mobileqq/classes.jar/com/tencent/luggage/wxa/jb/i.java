package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jc.h;
import com.tencent.luggage.wxa.jf.a;
import com.tencent.luggage.wxa.jf.a.a;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;

public class i
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Paint.FontMetrics localFontMetrics = paramd.e().getFontMetrics();
    if (paramd.e().b() == a.a.b) {}
    for (float f = Math.abs(localFontMetrics.ascent);; f = Math.abs((-localFontMetrics.ascent + localFontMetrics.descent) / 2.0F - localFontMetrics.descent))
    {
      f = paramFloat2 + f;
      break label113;
      if (paramd.e().b() != a.a.d) {
        break;
      }
    }
    f = paramFloat2;
    if (paramd.e().b() == a.a.c) {
      f = paramFloat2 - Math.abs(localFontMetrics.descent);
    }
    label113:
    paramd = paramd.e();
    paramFloat2 = paramd.measureText(paramString);
    if ((paramFloat3 > 0.0F) && (paramFloat3 < paramFloat2))
    {
      paramCanvas.save();
      paramFloat2 = paramFloat3 / paramFloat2;
      paramCanvas.translate(paramFloat1, f);
      paramCanvas.scale(paramFloat2, 1.0F);
      paramCanvas.drawText(paramString, 0.0F, 0.0F, paramd);
      paramCanvas.restore();
    }
    else
    {
      paramCanvas.drawText(paramString, paramFloat1, f, paramd);
    }
    return true;
  }
  
  public String a()
  {
    return "strokeText";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramc = (h)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramc == null) {
      return false;
    }
    return a(paramd, paramCanvas, paramc.b, paramc.c, paramc.d, paramc.e);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 3) {
      return false;
    }
    return a(paramd, paramCanvas, paramJSONArray.optString(0), g.d(paramJSONArray, 1), g.d(paramJSONArray, 2), g.d(paramJSONArray, 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.i
 * JD-Core Version:    0.7.0.1
 */