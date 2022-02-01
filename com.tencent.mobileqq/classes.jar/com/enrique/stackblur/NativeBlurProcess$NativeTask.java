package com.enrique.stackblur;

import android.graphics.Bitmap;
import java.util.concurrent.Callable;

class NativeBlurProcess$NativeTask
  implements Callable<Void>
{
  private final Bitmap _bitmapOut;
  private final int _coreIndex;
  private final int _radius;
  private final int _round;
  private final int _totalCores;
  
  public NativeBlurProcess$NativeTask(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this._bitmapOut = paramBitmap;
    this._radius = paramInt1;
    this._totalCores = paramInt2;
    this._coreIndex = paramInt3;
    this._round = paramInt4;
  }
  
  public Void call()
  {
    NativeBlurProcess.access$000(this._bitmapOut, this._radius, this._totalCores, this._coreIndex, this._round);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.enrique.stackblur.NativeBlurProcess.NativeTask
 * JD-Core Version:    0.7.0.1
 */