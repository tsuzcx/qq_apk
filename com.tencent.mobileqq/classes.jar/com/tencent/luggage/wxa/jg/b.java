package com.tencent.luggage.wxa.jg;

import android.graphics.Path;
import android.graphics.RectF;
import com.tencent.luggage.wxa.jd.d;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;

public class b
  implements a
{
  private boolean a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, boolean paramBoolean)
  {
    float f1 = paramFloat1 - paramFloat3;
    float f2 = paramFloat2 - paramFloat3;
    float f3 = paramFloat1 + paramFloat3;
    float f4 = paramFloat2 + paramFloat3;
    float f5 = (float)Math.toDegrees(paramFloat4);
    paramFloat1 = (float)Math.toDegrees(paramFloat5);
    double d = paramFloat3;
    Double.isNaN(d);
    paramFloat5 = (float)(360.0D / (d * 6.283185307179586D));
    if (paramBoolean)
    {
      if (f5 - paramFloat1 >= 360.0F)
      {
        paramFloat1 = -360.0F;
        break label237;
      }
      paramFloat2 = f5 % 360.0F;
      paramFloat3 = paramFloat1 % 360.0F;
      paramFloat1 = paramFloat2;
      if (paramFloat2 < 0.0F) {
        paramFloat1 = paramFloat2 + 360.0F;
      }
      paramFloat2 = paramFloat3;
      if (paramFloat3 < 0.0F) {
        paramFloat2 = paramFloat3 + 360.0F;
      }
      paramFloat3 = paramFloat2;
      paramFloat4 = paramFloat1;
      if (paramFloat2 >= paramFloat1)
      {
        paramFloat1 = paramFloat2 - paramFloat1 - 360.0F;
        break label237;
      }
    }
    else
    {
      if (paramFloat1 - f5 >= 360.0F)
      {
        paramFloat1 = 360.0F;
        break label237;
      }
      paramFloat3 = f5 % 360.0F;
      paramFloat2 = paramFloat1 % 360.0F;
      paramFloat1 = paramFloat3;
      if (paramFloat3 < 0.0F) {
        paramFloat1 = paramFloat3 + 360.0F;
      }
      paramFloat3 = paramFloat2;
      if (paramFloat2 < 0.0F) {
        paramFloat3 = paramFloat2 + 360.0F;
      }
      if (paramFloat3 >= paramFloat1)
      {
        paramFloat4 = paramFloat1;
      }
      else
      {
        paramFloat3 += 360.0F;
        paramFloat4 = paramFloat1;
      }
    }
    paramFloat1 = paramFloat3 - paramFloat4;
    label237:
    paramFloat2 = paramFloat1 % 360.0F;
    if ((paramFloat2 <= paramFloat5) && (paramFloat2 >= -paramFloat5))
    {
      paramPath.arcTo(new RectF(f1, f2, f3, f4), f5, paramFloat1, false);
      paramPath.addArc(new RectF(f1, f2, f3, f4), f5, paramFloat1);
    }
    else
    {
      paramPath.arcTo(new RectF(f1, f2, f3, f4), f5, paramFloat1, false);
    }
    return true;
  }
  
  public String a()
  {
    return "arc";
  }
  
  public boolean a(Path paramPath, com.tencent.luggage.wxa.jd.a parama)
  {
    if ((parama != null) && ((parama instanceof d)))
    {
      parama = (d)parama;
      return a(paramPath, parama.b, parama.c, parama.d, parama.e, parama.f, parama.g);
    }
    return false;
  }
  
  public boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 5) {
      return false;
    }
    return a(paramPath, g.d(paramJSONArray, 0), g.d(paramJSONArray, 1), g.d(paramJSONArray, 2), (float)paramJSONArray.optDouble(3), (float)paramJSONArray.optDouble(4), paramJSONArray.optBoolean(5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jg.b
 * JD-Core Version:    0.7.0.1
 */