package com.tencent.aelight.camera.ae.play;

import android.graphics.Bitmap;

public class FaceChangeUtils$ChangeFaceResult
{
  public static final int ERROR_FACE_POINTS_EMPTY = -4;
  public static final int ERROR_FAILED_PARSE_MATERIAL = -2;
  public static final int ERROR_NO_FACE_DETECTED = -3;
  public static final int ERROR_NULL_PARAMETERS = -1;
  public static final int ERROR_OK = 0;
  public final Bitmap data;
  public final int errCode;
  public final Throwable exception;
  public final boolean isSuccess;
  public final String msg;
  
  private FaceChangeUtils$ChangeFaceResult(boolean paramBoolean, int paramInt, String paramString, Throwable paramThrowable, Bitmap paramBitmap)
  {
    this.isSuccess = paramBoolean;
    this.errCode = paramInt;
    this.msg = paramString;
    this.exception = paramThrowable;
    this.data = paramBitmap;
  }
  
  private static ChangeFaceResult fail(int paramInt, String paramString)
  {
    return new ChangeFaceResult(false, paramInt, paramString, null, null);
  }
  
  private static ChangeFaceResult fail(int paramInt, String paramString, Throwable paramThrowable)
  {
    return new ChangeFaceResult(false, paramInt, paramString, paramThrowable, null);
  }
  
  private static ChangeFaceResult success(Bitmap paramBitmap)
  {
    return new ChangeFaceResult(true, 0, null, null, paramBitmap);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChangeFaceResult{isSuccess=");
    localStringBuilder.append(this.isSuccess);
    localStringBuilder.append(", errCode=");
    localStringBuilder.append(this.errCode);
    localStringBuilder.append(", msg='");
    localStringBuilder.append(this.msg);
    localStringBuilder.append('\'');
    localStringBuilder.append(", exception=");
    localStringBuilder.append(this.exception);
    localStringBuilder.append(", data=");
    localStringBuilder.append(this.data);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.FaceChangeUtils.ChangeFaceResult
 * JD-Core Version:    0.7.0.1
 */