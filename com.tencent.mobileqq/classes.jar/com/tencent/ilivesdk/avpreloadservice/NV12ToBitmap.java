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
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    Object localObject2 = localObject4;
    try
    {
      RenderScript localRenderScript = RenderScript.create(paramContext);
      localObject1 = localObject3;
      localObject2 = localObject4;
      ScriptIntrinsicYuvToRGB localScriptIntrinsicYuvToRGB = ScriptIntrinsicYuvToRGB.create(localRenderScript, Element.U8_4(localRenderScript));
      localObject1 = localObject3;
      localObject2 = localObject4;
      Allocation localAllocation1 = Allocation.createTyped(localRenderScript, new Type.Builder(localRenderScript, Element.U8(localRenderScript)).setX(paramInt1 * paramInt2 * 3 / 2).create(), 1);
      localObject1 = localObject3;
      localObject2 = localObject4;
      Allocation localAllocation2 = Allocation.createTyped(localRenderScript, new Type.Builder(localRenderScript, Element.RGBA_8888(localRenderScript)).setX(paramInt1).setY(paramInt2).create(), 1);
      localObject1 = localObject3;
      localObject2 = localObject4;
      localAllocation1.copyFrom(paramArrayOfByte);
      localObject1 = localObject3;
      localObject2 = localObject4;
      localScriptIntrinsicYuvToRGB.setInput(localAllocation1);
      localObject1 = localObject3;
      localObject2 = localObject4;
      localScriptIntrinsicYuvToRGB.forEach(localAllocation2);
      localObject1 = localObject3;
      localObject2 = localObject4;
      paramContext = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_4444);
      localObject1 = paramContext;
      localObject2 = paramContext;
      localAllocation2.copyTo(paramContext);
      localObject1 = paramContext;
      localObject2 = paramContext;
      localAllocation1.destroy();
      localObject1 = paramContext;
      localObject2 = paramContext;
      localAllocation2.destroy();
      localObject1 = paramContext;
      localObject2 = paramContext;
      localScriptIntrinsicYuvToRGB.destroy();
      localObject1 = paramContext;
      localObject2 = paramContext;
      localRenderScript.destroy();
      return paramContext;
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
      return localObject1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.NV12ToBitmap
 * JD-Core Version:    0.7.0.1
 */