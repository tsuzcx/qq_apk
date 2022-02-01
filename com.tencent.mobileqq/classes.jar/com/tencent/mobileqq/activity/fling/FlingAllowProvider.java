package com.tencent.mobileqq.activity.fling;

import java.util.ArrayList;
import java.util.List;

public class FlingAllowProvider
{
  private static List<String> sWhiteList = new ArrayList();
  
  public static boolean contain(String paramString)
  {
    return sWhiteList.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingAllowProvider
 * JD-Core Version:    0.7.0.1
 */