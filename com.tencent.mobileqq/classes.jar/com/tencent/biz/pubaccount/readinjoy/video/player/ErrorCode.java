package com.tencent.biz.pubaccount.readinjoy.video.player;

import com.tencent.mobileqq.app.HardCodeUtil;

public class ErrorCode
{
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    if (paramInt2 == 1300080)
    {
      paramInt3 = 1;
      if (paramInt1 == 202)
      {
        i = j;
        if (paramInt2 == 108) {}
      }
      else
      {
        if (paramInt2 != 1300062) {
          break label87;
        }
      }
    }
    label87:
    for (int i = j;; i = 0)
    {
      if (i == 0) {
        break label92;
      }
      return HardCodeUtil.a(2131718441) + " (" + paramInt1 + "-" + paramInt2 + ")";
      paramInt3 = 0;
      break;
    }
    label92:
    if (paramInt1 == 4000) {
      return HardCodeUtil.a(2131716064) + paramInt1 + "-" + paramInt2 + ")";
    }
    if (paramInt3 != 0) {
      return HardCodeUtil.a(2131715995) + paramInt1 + "-" + paramInt2 + ")";
    }
    return HardCodeUtil.a(2131716021) + paramInt1 + "-" + paramInt2 + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ErrorCode
 * JD-Core Version:    0.7.0.1
 */