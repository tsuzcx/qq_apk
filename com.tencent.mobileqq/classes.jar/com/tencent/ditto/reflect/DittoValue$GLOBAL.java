package com.tencent.ditto.reflect;

import com.tencent.ditto.shell.DittoUIEngine;

public class DittoValue$GLOBAL
{
  private static final GLOBAL sInstance = new GLOBAL();
  public static final int screenWidth = (int)DittoUIEngine.getScreenWidth();
  
  public static GLOBAL getInstance()
  {
    if (DittoUIEngine.getOuterGlobalData() != null) {
      return DittoUIEngine.getOuterGlobalData();
    }
    return sInstance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ditto.reflect.DittoValue.GLOBAL
 * JD-Core Version:    0.7.0.1
 */