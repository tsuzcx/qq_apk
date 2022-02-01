package com.tencent.intervideo.nowproxy.common.log;

import com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl;

public class XLog
{
  public static final int D = 1;
  public static final int E = 4;
  public static final int I = 2;
  public static final int V = 0;
  public static final int W = 3;
  public static final int WTF = 5;
  
  public static final int d(String paramString1, String paramString2)
  {
    SdkBaseAbilityImpl.getsInstance().printLog(0, paramString1, paramString2);
    return 0;
  }
  
  public static final int e(String paramString1, String paramString2)
  {
    SdkBaseAbilityImpl.getsInstance().printLog(4, paramString1, paramString2);
    return 0;
  }
  
  public static final int i(String paramString1, String paramString2)
  {
    SdkBaseAbilityImpl.getsInstance().printLog(2, paramString1, paramString2);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.log.XLog
 * JD-Core Version:    0.7.0.1
 */