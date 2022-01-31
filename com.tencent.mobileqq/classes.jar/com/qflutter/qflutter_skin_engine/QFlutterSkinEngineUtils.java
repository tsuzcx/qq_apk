package com.qflutter.qflutter_skin_engine;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;

public class QFlutterSkinEngineUtils
{
  public static final String TAG = "QFlutterSkinEngineUtils";
  
  public static Bitmap getBitmapFromNinePatchDrawable(NinePatchDrawable paramNinePatchDrawable)
  {
    return null;
  }
  
  public static NinePatchInfo getNinePatchInfoFromChunk(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (NinePatch.isNinePatchChunk(paramArrayOfByte)))
    {
      paramArrayOfByte = NinePatchChunk.deserialize(paramArrayOfByte);
      if ((paramArrayOfByte.mDivX.length >= 2) && (paramArrayOfByte.mDivY.length >= 2))
      {
        NinePatchInfo localNinePatchInfo = new NinePatchInfo();
        localNinePatchInfo.centerSlice = new Rect(paramArrayOfByte.mDivX[0], paramArrayOfByte.mDivY[0], paramArrayOfByte.mDivX[1], paramArrayOfByte.mDivY[1]);
        if ((paramArrayOfByte.mDivX.length >= 2) || (paramArrayOfByte.mDivY.length >= 2))
        {
          localNinePatchInfo.mDivX = paramArrayOfByte.mDivX;
          localNinePatchInfo.mDivY = paramArrayOfByte.mDivY;
        }
        return localNinePatchInfo;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qflutter.qflutter_skin_engine.QFlutterSkinEngineUtils
 * JD-Core Version:    0.7.0.1
 */