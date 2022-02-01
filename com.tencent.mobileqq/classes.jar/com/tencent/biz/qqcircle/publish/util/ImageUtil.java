package com.tencent.biz.qqcircle.publish.util;

import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import java.util.ArrayList;

public class ImageUtil
{
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    int i = JpegExifReader.readOrientation(paramString);
    if (i != 3)
    {
      if (i != 6)
      {
        if (i != 8) {
          return 0;
        }
        return 270;
      }
      return 90;
    }
    return 180;
  }
  
  public static int a(ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayList.size())
    {
      localStringBuilder.append((String)paramArrayList.get(i));
      i += 1;
    }
    return localStringBuilder.toString().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.util.ImageUtil
 * JD-Core Version:    0.7.0.1
 */