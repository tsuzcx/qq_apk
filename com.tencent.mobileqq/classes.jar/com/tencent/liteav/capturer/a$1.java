package com.tencent.liteav.capturer;

import android.hardware.Camera.Size;
import java.util.Comparator;

final class a$1
  implements Comparator<Camera.Size>
{
  public int a(Camera.Size paramSize1, Camera.Size paramSize2)
  {
    return paramSize2.width * paramSize2.height - paramSize1.width * paramSize1.height;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.capturer.a.1
 * JD-Core Version:    0.7.0.1
 */