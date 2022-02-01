package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.tencent.luggage.wxa.jc.ae;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;
import org.json.JSONException;

public class ai
  implements d
{
  private boolean a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.setValues(new float[] { paramFloat1, paramFloat3, paramFloat5, paramFloat2, paramFloat4, paramFloat6, 0.0F, 0.0F, 1.0F });
    paramCanvas.setMatrix(localMatrix);
    return true;
  }
  
  public String a()
  {
    return "setTransform";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramd = (ae)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramd == null) {
      return false;
    }
    return a(paramCanvas, paramd.b, paramd.c, paramd.d, paramd.e, paramd.f, paramd.g);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 6) {
      return false;
    }
    try
    {
      boolean bool = a(paramCanvas, (float)paramJSONArray.getDouble(0), (float)paramJSONArray.getDouble(1), (float)paramJSONArray.getDouble(2), (float)paramJSONArray.getDouble(3), g.c(paramJSONArray, 4), g.c(paramJSONArray, 5));
      return bool;
    }
    catch (JSONException paramd) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.ai
 * JD-Core Version:    0.7.0.1
 */