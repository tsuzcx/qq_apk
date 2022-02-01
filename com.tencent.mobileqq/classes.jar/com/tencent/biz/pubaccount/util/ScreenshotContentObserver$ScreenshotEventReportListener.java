package com.tencent.biz.pubaccount.util;

import android.net.Uri;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class ScreenshotContentObserver$ScreenshotEventReportListener
  implements ScreenshotContentObserver.Listener
{
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    paramUri = BaseActivity.sTopActivity;
    if (paramUri != null) {}
    for (paramUri = paramUri.getClass().getSimpleName();; paramUri = "unkonw")
    {
      ReportController.b(null, "dc01160", "Pb_account_lifeservice", "", "0X8009815", "0X8009815", 0, 0, "", "", paramUri, NetworkUtils.c(BaseApplicationImpl.getContext()));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ScreenshotContentObserver.ScreenshotEventReportListener
 * JD-Core Version:    0.7.0.1
 */