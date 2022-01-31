package com.tencent.biz.pubaccount.readinjoy.capture;

import android.annotation.TargetApi;
import android.content.Context;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import lhx;

@TargetApi(18)
public class ReadInJoyCameraCaptureHelper
{
  public static void a(TextView paramTextView, long paramLong)
  {
    if (paramLong >= 2147483647L) {}
    while (paramTextView == null) {
      return;
    }
    paramTextView.post(new lhx(paramTextView, String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 1000L / 60L), Long.valueOf(paramLong / 1000L % 60L) })));
  }
  
  private static boolean a(AppInterface paramAppInterface)
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(paramAppInterface);
    } while (ShortVideoUtils.a());
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    boolean bool = PtvFilterSoLoad.a(paramQQAppInterface, BaseApplicationImpl.getContext());
    return (a(paramQQAppInterface)) && ((bool) || (PtvFilterSoLoad.a(paramContext) == 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureHelper
 * JD-Core Version:    0.7.0.1
 */