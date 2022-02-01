package com.tencent.biz.pubaccount.weishi_new.player.wrapper;

import com.tencent.mobileqq.app.HardCodeUtil;

public class WSPlayerErrorCode
{
  private static String a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 4000) {
      return HardCodeUtil.a(2131716064) + paramInt1 + "-" + paramInt2 + ")";
    }
    if (paramInt2 == 1300080) {
      return HardCodeUtil.a(2131715995) + paramInt1 + "-" + paramInt2 + ")";
    }
    return HardCodeUtil.a(2131716021) + paramInt1 + "-" + paramInt2 + ")";
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
      if (paramInt2 == 103) {
        return HardCodeUtil.a(2131716064) + paramInt1 + "-" + paramInt2 + ")";
      }
      return HardCodeUtil.a(2131716051) + paramInt1 + "-" + paramInt2 + ")";
    }
    if (paramInt1 == 122)
    {
      if (paramInt2 == 204) {
        return HardCodeUtil.a(2131716028) + paramInt1 + "-" + paramInt2 + ")";
      }
      if (paramInt2 == 202) {
        return HardCodeUtil.a(2131715968) + paramInt1 + "-" + paramInt2 + ")";
      }
      return HardCodeUtil.a(2131716066) + paramInt1 + "-" + paramInt2 + ")";
    }
    if (paramInt1 == 101)
    {
      if (paramInt2 == 80) {
        return HardCodeUtil.a(2131715995) + paramInt1 + "-" + paramInt2 + ")";
      }
      return HardCodeUtil.a(2131715997) + paramInt1 + "-" + paramInt2 + ")";
    }
    return HardCodeUtil.a(2131716021) + paramInt1 + "-" + paramInt2 + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.wrapper.WSPlayerErrorCode
 * JD-Core Version:    0.7.0.1
 */