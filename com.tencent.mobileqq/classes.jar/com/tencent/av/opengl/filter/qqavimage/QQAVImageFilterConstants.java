package com.tencent.av.opengl.filter.qqavimage;

public class QQAVImageFilterConstants
{
  public static int getFilterType(int paramInt)
  {
    if (paramInt == 9) {
      return 1;
    }
    if ((paramInt == 1006) || (paramInt == 1016) || (paramInt == 1007) || (paramInt == 1008) || (paramInt == 1009) || (paramInt == 1010) || (paramInt == 1011) || (paramInt == 1012) || (paramInt == 1013) || (paramInt == 1014) || (paramInt == 1015)) {
      return 2;
    }
    if (paramInt == 10) {
      return 3;
    }
    if ((paramInt == 1017) || (paramInt == 1018)) {
      return 4;
    }
    if (paramInt == 12) {
      return 5;
    }
    return 0;
  }
  
  public static boolean isMusicSpecialFilter(int paramInt)
  {
    return (paramInt == 1013) || (paramInt == 1014) || (paramInt == 1017);
  }
  
  public static boolean isNormalFilterSpecialCases(int paramInt, String paramString)
  {
    return (getFilterType(paramInt) == 0) && (paramString.equals("MANHUA"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants
 * JD-Core Version:    0.7.0.1
 */