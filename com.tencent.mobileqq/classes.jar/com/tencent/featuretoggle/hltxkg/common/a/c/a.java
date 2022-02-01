package com.tencent.featuretoggle.hltxkg.common.a.c;

import java.util.Iterator;
import java.util.List;

public final class a
{
  private static String a(List<com.tencent.featuretoggle.hltxkg.common.a.a> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localStringBuilder.append(((com.tencent.featuretoggle.hltxkg.common.a.a)paramList.next()).d());
        localStringBuilder.append(",");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("[appid:");
    localStringBuilder.append(0);
    localStringBuilder.append(",ckip:");
    localStringBuilder.append(null);
    localStringBuilder.append(",rule:");
    localStringBuilder.append(null);
    localStringBuilder.append(",iplist:");
    localStringBuilder.append(a(null));
    localStringBuilder.append(",httpPorts:");
    localStringBuilder.append(null);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.c.a
 * JD-Core Version:    0.7.0.1
 */