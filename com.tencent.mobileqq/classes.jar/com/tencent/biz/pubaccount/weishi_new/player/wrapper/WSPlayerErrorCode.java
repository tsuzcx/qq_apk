package com.tencent.biz.pubaccount.weishi_new.player.wrapper;

import com.tencent.mobileqq.app.HardCodeUtil;

public class WSPlayerErrorCode
{
  private static String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4000)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131715987));
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    if (paramInt2 == 1300080)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131715918));
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131715944));
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 3) {
      return b(paramInt1, paramInt2);
    }
    return a(paramInt1, paramInt2);
  }
  
  private static String b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 123)
    {
      if (paramInt2 == 103)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131715987));
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("-");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(")");
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131715974));
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    if (paramInt1 == 122)
    {
      if (paramInt2 == 204)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131715951));
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("-");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(")");
        return localStringBuilder.toString();
      }
      if (paramInt2 == 202)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131715891));
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("-");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(")");
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131715989));
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    if (paramInt1 == 101)
    {
      if (paramInt2 == 80)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131715918));
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("-");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(")");
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131715920));
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131715944));
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.WSPlayerErrorCode
 * JD-Core Version:    0.7.0.1
 */