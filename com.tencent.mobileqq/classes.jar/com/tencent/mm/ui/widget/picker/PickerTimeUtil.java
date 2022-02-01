package com.tencent.mm.ui.widget.picker;

public final class PickerTimeUtil
{
  private static int a(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString, 10);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public static boolean checkHourIntValid(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 23);
  }
  
  public static boolean checkMinuteIntValid(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 59);
  }
  
  public static int[] parseHHMM(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return null;
      }
      paramString = paramString.split(":");
      localObject1 = localObject2;
      if (paramString != null)
      {
        if (paramString.length != 2) {
          return null;
        }
        int i = a(paramString[0], -1);
        int j = a(paramString[1], -1);
        localObject1 = localObject2;
        if (checkHourIntValid(i))
        {
          if (!checkMinuteIntValid(j)) {
            return null;
          }
          localObject1 = new int[2];
          localObject1[0] = i;
          localObject1[1] = j;
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.picker.PickerTimeUtil
 * JD-Core Version:    0.7.0.1
 */