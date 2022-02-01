package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;

public class FontManager
{
  private static Boolean a;
  private static Boolean b;
  private static Boolean c;
  
  public static boolean a()
  {
    return QCircleConfigHelper.a("QzCustomFont", "TrueTypeViewCache", Integer.valueOf(1)).intValue() != 0;
  }
  
  public static boolean a(int paramInt)
  {
    int i = QCircleConfigHelper.a("QzCustomFont", "DiyFontShow", Integer.valueOf(0)).intValue();
    if (paramInt != 1) {
      if (paramInt != 2) {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return true;
          }
          if ((i & 0x8) == 0) {
            return true;
          }
        }
      }
    }
    while ((i & 0x1) != 0)
    {
      do
      {
        do
        {
          return false;
        } while ((i & 0x4) != 0);
        return true;
      } while ((i & 0x2) != 0);
      return true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.FontManager
 * JD-Core Version:    0.7.0.1
 */