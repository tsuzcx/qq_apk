package com.tencent.aelight.camera.struct.camera;

import android.graphics.Bitmap;
import java.io.Serializable;

public class AEPhotoCaptureResult
  implements Serializable
{
  public static final int TYPE_CAPTURE_FRAME = 0;
  public static final int TYPE_TAKE_PICTURE = 1;
  public Bitmap bitmap;
  public int errorCode;
  public String filePath;
  public int orientation;
  public int type;
  
  public AEPhotoCaptureResult(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap, int paramInt3)
  {
    this.type = paramInt1;
    this.errorCode = paramInt2;
    this.filePath = paramString;
    this.bitmap = paramBitmap;
    this.orientation = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult
 * JD-Core Version:    0.7.0.1
 */