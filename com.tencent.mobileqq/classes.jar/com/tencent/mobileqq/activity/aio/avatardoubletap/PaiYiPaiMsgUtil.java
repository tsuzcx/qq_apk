package com.tencent.mobileqq.activity.aio.avatardoubletap;

import android.text.TextUtils;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

public class PaiYiPaiMsgUtil
{
  public static boolean a(Object paramObject)
  {
    if (!(paramObject instanceof MessageForUniteGrayTip)) {}
    do
    {
      return false;
      paramObject = (MessageForUniteGrayTip)paramObject;
    } while (!TextUtils.equals(paramObject.getExtInfoFromExtStr("uint64_busi_type"), "12"));
    return TextUtils.equals(paramObject.getExtInfoFromExtStr("uint64_busi_id"), "1061");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiMsgUtil
 * JD-Core Version:    0.7.0.1
 */