package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;

class AEVideoStoryDashboardPart$MessageRenderUtil
{
  static CharSequence a(@NonNull AEDashboardUtil.BinaryInfo paramBinaryInfo)
  {
    if (paramBinaryInfo.a) {
      return paramBinaryInfo.toString();
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    paramBinaryInfo = paramBinaryInfo.toString();
    SpannableString localSpannableString = new SpannableString(paramBinaryInfo);
    localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, paramBinaryInfo.length(), 17);
    localSpannableStringBuilder.append(localSpannableString);
    return localSpannableStringBuilder;
  }
  
  static CharSequence a(@NonNull AEDashboardUtil.NetInfo paramNetInfo)
  {
    if ("failed".equals(paramNetInfo.c))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      paramNetInfo = paramNetInfo.toString();
      SpannableString localSpannableString = new SpannableString(paramNetInfo);
      localSpannableString.setSpan(new ForegroundColorSpan(-65536), 0, paramNetInfo.length(), 17);
      localSpannableStringBuilder.append(localSpannableString);
      return localSpannableStringBuilder;
    }
    return paramNetInfo.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.MessageRenderUtil
 * JD-Core Version:    0.7.0.1
 */