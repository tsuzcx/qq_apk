package com.tencent.ilivesdk.avpreloadservice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type.Builder;

public class NV12ToBitmap
{
  public static Bitmap a(Context paramContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      RenderScript localRenderScript = RenderScript.create(paramContext);
      ScriptIntrinsicYuvToRGB localScriptIntrinsicYuvToRGB = ScriptIntrinsicYuvToRGB.create(localRenderScript, Element.U8_4(localRenderScript));
      Allocation localAllocation1 = Allocation.createTyped(localRenderScript, new Type.Builder(localRenderScript, Element.U8(localRenderScript)).setX(paramInt1 * paramInt2 * 3 / 2).create(), 1);
      Allocation localAllocation2 = Allocation.createTyped(localRenderScript, new Type.Builder(localRenderScript, Element.RGBA_8888(localRenderScript)).setX(paramInt1).setY(paramInt2).create(), 1);
      localAllocation1.copyFrom(paramArrayOfByte);
      localScriptIntrinsicYuvToRGB.setInput(localAllocation1);
      localScriptIntrinsicYuvToRGB.forEach(localAllocation2);
      paramContext = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      paramArrayOfByte.printStackTrace();
    }
    catch (Exception paramArrayOfByte)
    {
      try
      {
        localAllocation2.copyTo(paramContext);
        localAllocation1.destroy();
        localAllocation2.destroy();
        localScriptIntrinsicYuvToRGB.destroy();
        localRenderScript.destroy();
        return paramContext;
      }
      catch (Exception paramArrayOfByte)
      {
        break label146;
      }
      paramArrayOfByte = paramArrayOfByte;
      paramContext = null;
    }
    label146:
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.NV12ToBitmap
 * JD-Core Version:    0.7.0.1
 */