package com.tencent.aelight.camera.aeeditor.util;

import android.graphics.Color;
import com.microrapid.opencv.ImageMainColorData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class AEExtractColorUtil
{
  public static int a(ImageMainColorData paramImageMainColorData)
  {
    return Color.argb(255, (int)paramImageMainColorData.r, (int)paramImageMainColorData.g, (int)paramImageMainColorData.b);
  }
  
  public static List<String> a(List<ImageMainColorData> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      int j;
      do
      {
        String str;
        do
        {
          if (!paramList.hasNext()) {
            break;
          }
          str = String.format("#%06X", new Object[] { Integer.valueOf(a((ImageMainColorData)paramList.next()) & 0xFFFFFF) });
        } while (localArrayList.contains(str));
        localArrayList.add(str);
        j = i + 1;
        i = j;
      } while (j < paramInt);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.util.AEExtractColorUtil
 * JD-Core Version:    0.7.0.1
 */