package com.tencent.mobileqq.activity.aio.avatardoubletap;

import android.text.TextUtils;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;

public class PaiYiPaiMsgUtil
{
  public static boolean a(Object paramObject)
  {
    if (!(paramObject instanceof MessageForUniteGrayTip)) {
      return false;
    }
    paramObject = (MessageForUniteGrayTip)paramObject;
    if (!TextUtils.equals(paramObject.getExtInfoFromExtStr("uint64_busi_type"), "12")) {
      return false;
    }
    return TextUtils.equals(paramObject.getExtInfoFromExtStr("uint64_busi_id"), "1061");
  }
  
  public static boolean b(Object paramObject)
  {
    if (!a(paramObject)) {
      return false;
    }
    return TextUtils.equals(((MessageForUniteGrayTip)paramObject).getExtInfoFromExtStr("pai_yi_pai_trigger_from_local"), "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiMsgUtil
 * JD-Core Version:    0.7.0.1
 */