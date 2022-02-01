package com.enrique.stackblur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Allocation.MipmapControl;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;

class SdkRSBlurProcess
  implements BlurProcess
{
  private final RenderScript _rs;
  private final Context context;
  
  public SdkRSBlurProcess(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
    this._rs = RenderScript.create(this.context);
  }
  
  public Bitmap blur(Bitmap paramBitmap, float paramFloat)
  {
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Allocation localAllocation = Allocation.createFromBitmap(this._rs, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
    Object localObject = this._rs;
    localObject = ScriptIntrinsicBlur.create((RenderScript)localObject, Element.U8_4((RenderScript)localObject));
    ((ScriptIntrinsicBlur)localObject).setInput(localAllocation);
    ((ScriptIntrinsicBlur)localObject).setRadius(paramFloat);
    localAllocation = Allocation.createTyped(this._rs, localAllocation.getType());
    ((ScriptIntrinsicBlur)localObject).forEach(localAllocation);
    localAllocation.copyTo(paramBitmap);
    return paramBitmap;
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.enrique.stackblur.SdkRSBlurProcess
 * JD-Core Version:    0.7.0.1
 */