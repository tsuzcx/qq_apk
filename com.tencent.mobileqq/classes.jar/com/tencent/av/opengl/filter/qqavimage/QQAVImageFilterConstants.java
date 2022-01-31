package com.tencent.av.opengl.filter.qqavimage;

public class QQAVImageFilterConstants
{
  public static int a(int paramInt)
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
    return 0;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1013) || (paramInt == 1014);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants
 * JD-Core Version:    0.7.0.1
 */