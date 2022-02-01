package com.tencent.hippy.qq.tuwen.util;

import androidx.annotation.NonNull;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;

public class TKDTuWenCommentUtil
{
  private static final String TAG = "TKDTuWenCommentUtil";
  private static Boolean useHippy;
  
  public static boolean isAllZero(@NonNull double... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (paramVarArgs[i] != 0.0D) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isCommentSwitchOn()
  {
    if (useHippy == null) {
      if (Aladdin.getConfig(412).getIntegerFromString("tuwen_comment_hippy_switch", 0) != 1) {
        break label75;
      }
    }
    label75:
    for (boolean bool = true;; bool = false)
    {
      useHippy = Boolean.valueOf(bool);
      QLog.d("TKDTuWenCommentUtil", 1, "useHippy=" + useHippy);
      if ((useHippy == null) || (!useHippy.booleanValue())) {
        break;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.util.TKDTuWenCommentUtil
 * JD-Core Version:    0.7.0.1
 */