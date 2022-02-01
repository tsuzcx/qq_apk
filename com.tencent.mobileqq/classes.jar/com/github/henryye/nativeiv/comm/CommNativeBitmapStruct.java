package com.github.henryye.nativeiv.comm;

import androidx.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;

@Keep
class CommNativeBitmapStruct
  extends NativeBitmapStruct
{
  @Keep
  private int nConfig = -1;
  @Keep
  private boolean premultiplyAlpha;
  
  public CommNativeBitmapStruct convertToCommonStruct()
  {
    this.glType = a.a(this.nConfig);
    this.glFormat = a.b(this.nConfig);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.CommNativeBitmapStruct
 * JD-Core Version:    0.7.0.1
 */