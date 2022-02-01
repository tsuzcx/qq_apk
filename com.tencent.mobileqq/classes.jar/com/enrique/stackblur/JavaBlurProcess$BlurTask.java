package com.enrique.stackblur;

import java.util.concurrent.Callable;

class JavaBlurProcess$BlurTask
  implements Callable<Void>
{
  private final int _coreIndex;
  private final int _h;
  private final int _radius;
  private final int _round;
  private final int[] _src;
  private final int _totalCores;
  private final int _w;
  
  public JavaBlurProcess$BlurTask(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this._src = paramArrayOfInt;
    this._w = paramInt1;
    this._h = paramInt2;
    this._radius = paramInt3;
    this._totalCores = paramInt4;
    this._coreIndex = paramInt5;
    this._round = paramInt6;
  }
  
  public Void call()
  {
    JavaBlurProcess.access$000(this._src, this._w, this._h, this._radius, this._totalCores, this._coreIndex, this._round);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.enrique.stackblur.JavaBlurProcess.BlurTask
 * JD-Core Version:    0.7.0.1
 */