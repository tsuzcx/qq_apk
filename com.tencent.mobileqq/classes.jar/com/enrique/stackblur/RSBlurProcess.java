package com.enrique.stackblur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Allocation.MipmapControl;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;

class RSBlurProcess
  implements BlurProcess
{
  private final RenderScript _rs;
  private final Context context;
  private final int mBlurResId;
  
  public RSBlurProcess(Context paramContext, int paramInt)
  {
    this.context = paramContext.getApplicationContext();
    this.mBlurResId = paramInt;
    this._rs = RenderScript.create(this.context);
  }
  
  public Bitmap blur(Bitmap paramBitmap, float paramFloat)
  {
    int j = 0;
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    ScriptC_blur localScriptC_blur = new ScriptC_blur(this._rs, this.context.getResources(), this.mBlurResId);
    Allocation localAllocation1 = Allocation.createFromBitmap(this._rs, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
    localScriptC_blur.set_gIn(localAllocation1);
    localScriptC_blur.set_width(k);
    localScriptC_blur.set_height(m);
    localScriptC_blur.set_radius((int)paramFloat);
    int[] arrayOfInt = new int[m];
    int i = 0;
    while (i < m)
    {
      arrayOfInt[i] = i;
      i += 1;
    }
    Allocation localAllocation2 = Allocation.createSized(this._rs, Element.U32(this._rs), m, 1);
    localAllocation2.copyFrom(arrayOfInt);
    arrayOfInt = new int[k];
    i = j;
    while (i < k)
    {
      arrayOfInt[i] = i;
      i += 1;
    }
    Allocation localAllocation3 = Allocation.createSized(this._rs, Element.U32(this._rs), k, 1);
    localAllocation3.copyFrom(arrayOfInt);
    localScriptC_blur.forEach_blur_h(localAllocation2);
    localScriptC_blur.forEach_blur_v(localAllocation3);
    localAllocation1.copyTo(paramBitmap);
    return paramBitmap;
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.enrique.stackblur.RSBlurProcess
 * JD-Core Version:    0.7.0.1
 */