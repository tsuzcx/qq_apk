package com.tencent.aelight.camera.aioeditor.takevideo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AEColorBarManage
{
  public static List<Integer> a = new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(-14079703), Integer.valueOf(-1), Integer.valueOf(-1027508), Integer.valueOf(-1131223), Integer.valueOf(-6038445), Integer.valueOf(-12147713), Integer.valueOf(-7768577), Integer.valueOf(-496479) }));
  
  public static int a(boolean paramBoolean)
  {
    List localList;
    int i;
    if (paramBoolean)
    {
      localList = a;
      i = 2;
    }
    else
    {
      localList = a;
      i = 1;
    }
    return ((Integer)localList.get(i)).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.AEColorBarManage
 * JD-Core Version:    0.7.0.1
 */