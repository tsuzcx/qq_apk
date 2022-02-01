package com.qflutter.resource_loader;

import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;

public class Utils
{
  public static final String TAG = "Utils";
  
  public static Bitmap getBitmapFromNinePatchDrawable(NinePatchDrawable paramNinePatchDrawable)
  {
    return null;
  }
  
  public static NinePatchInfo getNinePatchInfoFromChunk(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (NinePatch.isNinePatchChunk(paramArrayOfByte)))
    {
      NinePatchChunk localNinePatchChunk = NinePatchChunk.deserialize(paramArrayOfByte);
      if ((localNinePatchChunk != null) && (localNinePatchChunk.mDivX.length >= 2) && (localNinePatchChunk.mDivY.length >= 2))
      {
        NinePatchInfo localNinePatchInfo = new NinePatchInfo();
        localNinePatchInfo.centerSlice = new Rect(localNinePatchChunk.mDivX[0], localNinePatchChunk.mDivY[0], localNinePatchChunk.mDivX[1], localNinePatchChunk.mDivY[1]);
        if (localNinePatchChunk.mDivX.length < 2)
        {
          paramArrayOfByte = localNinePatchInfo;
          if (localNinePatchChunk.mDivY.length < 2) {
            return paramArrayOfByte;
          }
        }
        localNinePatchInfo.mDivX = localNinePatchChunk.mDivX;
        localNinePatchInfo.mDivY = localNinePatchChunk.mDivY;
        return localNinePatchInfo;
      }
    }
    paramArrayOfByte = null;
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.resource_loader.Utils
 * JD-Core Version:    0.7.0.1
 */