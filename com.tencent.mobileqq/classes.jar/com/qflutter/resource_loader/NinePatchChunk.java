package com.qflutter.resource_loader;

import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class NinePatchChunk
{
  public static final int NO_COLOR = 1;
  public static final int TRANSPARENT_COLOR = 0;
  public int[] mColor;
  public int[] mDivX;
  public int[] mDivY;
  public Rect mPaddings = new Rect();
  
  private static boolean checkDivCount(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  public static NinePatchChunk deserialize(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.nativeOrder());
    if (paramArrayOfByte.get() == 0) {}
    NinePatchChunk localNinePatchChunk;
    do
    {
      return null;
      localNinePatchChunk = new NinePatchChunk();
      localNinePatchChunk.mDivX = new int[paramArrayOfByte.get()];
      localNinePatchChunk.mDivY = new int[paramArrayOfByte.get()];
      localNinePatchChunk.mColor = new int[paramArrayOfByte.get()];
    } while ((!checkDivCount(localNinePatchChunk.mDivX.length)) || (!checkDivCount(localNinePatchChunk.mDivY.length)));
    paramArrayOfByte.getInt();
    paramArrayOfByte.getInt();
    localNinePatchChunk.mPaddings.left = paramArrayOfByte.getInt();
    localNinePatchChunk.mPaddings.right = paramArrayOfByte.getInt();
    localNinePatchChunk.mPaddings.top = paramArrayOfByte.getInt();
    localNinePatchChunk.mPaddings.bottom = paramArrayOfByte.getInt();
    paramArrayOfByte.getInt();
    readIntArray(localNinePatchChunk.mDivX, paramArrayOfByte);
    readIntArray(localNinePatchChunk.mDivY, paramArrayOfByte);
    readIntArray(localNinePatchChunk.mColor, paramArrayOfByte);
    return localNinePatchChunk;
  }
  
  private static void readIntArray(int[] paramArrayOfInt, ByteBuffer paramByteBuffer)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramArrayOfInt[i] = paramByteBuffer.getInt();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.qflutter.resource_loader.NinePatchChunk
 * JD-Core Version:    0.7.0.1
 */