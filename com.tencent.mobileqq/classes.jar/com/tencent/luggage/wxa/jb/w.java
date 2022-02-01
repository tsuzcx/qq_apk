package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jc.u;
import org.json.JSONArray;
import org.json.JSONException;

public class w
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, String paramString)
  {
    paramd = paramd.h();
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1728361789: 
      if (paramString.equals("difference")) {
        i = 19;
      }
      break;
    case 1686617550: 
      if (paramString.equals("exclusion")) {
        i = 20;
      }
      break;
    case 1242982905: 
      if (paramString.equals("color-burn")) {
        i = 16;
      }
      break;
    case 1159099187: 
      if (paramString.equals("destination-over")) {
        i = 4;
      }
      break;
    case 1158680499: 
      if (paramString.equals("destination-atop")) {
        i = 7;
      }
      break;
    case 912936772: 
      if (paramString.equals("destination-in")) {
        i = 5;
      }
      break;
    case 653829668: 
      if (paramString.equals("multiply")) {
        i = 11;
      }
      break;
    case 170546243: 
      if (paramString.equals("lighter")) {
        i = 8;
      }
      break;
    case 170546239: 
      if (paramString.equals("lighten")) {
        i = 14;
      }
      break;
    case 94842723: 
      if (paramString.equals("color")) {
        i = 23;
      }
      break;
    case 3059573: 
      if (paramString.equals("copy")) {
        i = 9;
      }
      break;
    case 118875: 
      if (paramString.equals("xor")) {
        i = 10;
      }
      break;
    case 103672: 
      if (paramString.equals("hue")) {
        i = 21;
      }
      break;
    case -120580883: 
      if (paramString.equals("color-dodge")) {
        i = 15;
      }
      break;
    case -130953402: 
      if (paramString.equals("source-over")) {
        i = 0;
      }
      break;
    case -131372090: 
      if (paramString.equals("source-atop")) {
        i = 3;
      }
      break;
    case -230491182: 
      if (paramString.equals("saturation")) {
        i = 22;
      }
      break;
    case -1091287984: 
      if (paramString.equals("overlay")) {
        i = 12;
      }
      break;
    case -1112602980: 
      if (paramString.equals("source-out")) {
        i = 2;
      }
      break;
    case -1247677005: 
      if (paramString.equals("soft-light")) {
        i = 18;
      }
      break;
    case -1338968417: 
      if (paramString.equals("darken")) {
        i = 13;
      }
      break;
    case -1427739212: 
      if (paramString.equals("hard-light")) {
        i = 17;
      }
      break;
    case -1698458601: 
      if (paramString.equals("source-in")) {
        i = 1;
      }
      break;
    case -1763725041: 
      if (paramString.equals("destination-out")) {
        i = 6;
      }
      break;
    case -2120744511: 
      if (paramString.equals("luminosity")) {
        i = 24;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return true;
    case 14: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
      return true;
    case 13: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
      return true;
    case 12: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.OVERLAY));
      return true;
    case 11: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
      return true;
    case 10: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
      return true;
    case 9: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
      return true;
    case 8: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
      return true;
    case 7: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
      return true;
    case 6: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
      return true;
    case 5: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      return true;
    case 4: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
      return true;
    case 3: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
      return true;
    case 2: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
      return true;
    case 1: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      return true;
    case 0: 
      paramd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
    }
    return true;
  }
  
  public String a()
  {
    return "setGlobalCompositeOperation";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramCanvas = (u)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramCanvas == null) {
      return false;
    }
    return a(paramd, paramCanvas.b);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 1) {
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getString(0);
      return a(paramd, paramCanvas);
    }
    catch (JSONException paramd) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.w
 * JD-Core Version:    0.7.0.1
 */