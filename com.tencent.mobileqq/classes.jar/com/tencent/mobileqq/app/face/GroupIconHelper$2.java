package com.tencent.mobileqq.app.face;

import java.util.Comparator;

final class GroupIconHelper$2
  implements Comparator<String>
{
  public int a(String paramString1, String paramString2)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (l1 == l2) {
        return 0;
      }
      if (l1 > l2) {
        return 2;
      }
      return -1;
    }
    catch (Exception paramString1) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.2
 * JD-Core Version:    0.7.0.1
 */