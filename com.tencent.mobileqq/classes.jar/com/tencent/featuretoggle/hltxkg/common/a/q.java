package com.tencent.featuretoggle.hltxkg.common.a;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class q
{
  public static boolean a(String paramString, boolean paramBoolean, Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      paramString = paramMap.keySet().iterator();
      while (paramString.hasNext()) {
        paramString.next();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.q
 * JD-Core Version:    0.7.0.1
 */