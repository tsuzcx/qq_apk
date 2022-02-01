package com.tencent.biz.pubaccount.readinjoy.view;

import android.net.Uri;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.ScreenshotContentObserver.Listener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

final class ReadInJoyScreenShotReporter$1
  implements ScreenshotContentObserver.Listener
{
  public void a(Uri paramUri, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder().append("onDetectScreenshot() path=").append(paramString).append(", channelID=");
      if (ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.a()) != null) {
        break label139;
      }
      paramUri = "null";
      paramString = paramString.append(paramUri).append(", channelType=");
      if (ReadInJoyScreenShotReporter.b(ReadInJoyScreenShotReporter.a()) != null) {
        break label149;
      }
    }
    label139:
    label149:
    for (paramUri = "null";; paramUri = ReadInJoyScreenShotReporter.b(ReadInJoyScreenShotReporter.a()))
    {
      QLog.d("ReadInJoyScreenShotReporter", 2, paramUri);
      if (ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.a()) != null) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, "", "0X8008100", "0X8008100", 0, 0, String.valueOf(System.currentTimeMillis() / 1000L), String.valueOf(ReadInJoyScreenShotReporter.b(ReadInJoyScreenShotReporter.a())), String.valueOf(ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.a())), null, false);
      }
      return;
      paramUri = ReadInJoyScreenShotReporter.a(ReadInJoyScreenShotReporter.a());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyScreenShotReporter.1
 * JD-Core Version:    0.7.0.1
 */